/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.util.assemble.war;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.pluto.util.UtilityException;
import org.apache.pluto.util.assemble.AssemblerConfig;
import org.apache.pluto.util.assemble.WebXmlRewritingAssembler;

/**
 *
 * @author Eric Dalquist <a href="mailto:edalquist@doit.wisc.edu">edalquist@doit.wisc.edu</a>
 * @version 1.0
 * @since Nov 8, 2004
 */
public class WarAssembler extends WebXmlRewritingAssembler {
    // Constructor -------------------------------------------------------------
    
    /**
     * Default no-arg constructor.
     */
    public WarAssembler() {
    	// Do nothing.
    }
    
    
    // Assembler Impl ----------------------------------------------------------
    
    public void assemble(AssemblerConfig config) throws UtilityException {
        try {
            final File sourceArchive = config.getWarSource();
            final File destinationFolder = config.getDestination();
            final File destinationArchive = new File(destinationFolder, sourceArchive.getName());
            
            //If the source and dest are the same a temp location is needed
            if (sourceArchive.equals(destinationArchive)) {
                final File tempArchive = File.createTempFile(sourceArchive.getName() + ".", ".tmp");
                this.assembleWar(sourceArchive, tempArchive, config.getDispatchServletClass());
                
                //Move the temp file to the destination location
                destinationArchive.delete();
                tempArchive.renameTo(destinationArchive);
            }
            else {
                this.assembleWar(sourceArchive, destinationArchive, config.getDispatchServletClass());
            }
            
        } catch (IOException ex) {
            throw new UtilityException(ex.getMessage(), ex, null);
        }
    }
    
    /**
     * Reads the source JAR copying entries to the dest JAR. The web.xml and portlet.xml are cached
     * and after the entire archive is copied (minus the web.xml) a re-written web.xml is generated
     * and written to the destination JAR.
     */
    protected void assembleWar(File source, File dest, String dispatchServletClass) throws IOException {
        final JarInputStream jarIn = new JarInputStream(new FileInputStream(source));
        
        try {
            //Create the output JAR stream, copying the Manifest
            final Manifest manifest = jarIn.getManifest();
            //TODO add pluto notes to the Manifest?
            FileUtils.forceMkdir(dest.getParentFile());
            final JarOutputStream jarOut = new JarOutputStream(new FileOutputStream(dest), manifest);

            try {
                //Need to buffer the web.xml and portlet.xml files for the rewritting
                JarEntry servletXmlEntry = null;
                byte[] servletXmlBuffer = null;
                byte[] portletXmlBuffer = null;
                
                //Read the source archive entry by entry
                JarEntry originalJarEntry;
                while ((originalJarEntry = jarIn.getNextJarEntry()) != null) {
                    final JarEntry newJarEntry = this.smartClone(originalJarEntry);
                    
                    //Capture the web.xml JarEntry and contents as a byte[], don't write it out now
                    if (SERVLET_XML.equals(newJarEntry.getName())) {
                        servletXmlEntry = newJarEntry;
                        servletXmlBuffer = IOUtils.toByteArray(jarIn);
                    }
                    //Capture the portlet.xml contents as a byte[]
                    else if (PORTLET_XML.equals(newJarEntry.getName())) {
                        portletXmlBuffer = IOUtils.toByteArray(jarIn);
                        jarOut.putNextEntry(newJarEntry);
                        IOUtils.write(portletXmlBuffer, jarOut);
                    }
                    //Copy all other entries directly to the output archive
                    else {
                        jarOut.putNextEntry(newJarEntry);
                        IOUtils.copy(jarIn, jarOut);
                    }
                }
                
                //Checks to make sure the web.xml and portlet.xml were found
                if (servletXmlBuffer == null) {
                    throw new FileNotFoundException("File '" + SERVLET_XML + "' could not be found in the archive '" + source + "'");
                }
                if (portletXmlBuffer == null) {
                    throw new FileNotFoundException("File '" + PORTLET_XML + "' could not be found in the archive '" + source + "'");
                }
                
                //Create streams of the byte[] data for the updater method
                final InputStream webXmlIn = new ByteArrayInputStream(servletXmlBuffer);
                final InputStream portletXmlIn = new ByteArrayInputStream(portletXmlBuffer);
                final ByteArrayOutputStream webXmlOut = new ByteArrayOutputStream(servletXmlBuffer.length);
                
                //Update the web.xml
                this.updateWebappDescriptor(webXmlIn, portletXmlIn, webXmlOut, dispatchServletClass);
                final byte[] webXmlBytes = webXmlOut.toByteArray();
                
                //If no compression is being used (STORED) we have to manually update the size and crc
                if (servletXmlEntry.getMethod() == ZipEntry.STORED) {
                    servletXmlEntry.setSize(webXmlBytes.length);
                    
                    final CRC32 webXmlCrc = new CRC32();
                    webXmlCrc.update(webXmlBytes);
                    servletXmlEntry.setCrc(webXmlCrc.getValue());
                }
                
                //write out the web.xml entry and contents
                jarOut.putNextEntry(servletXmlEntry);
                IOUtils.write(webXmlBytes, jarOut);
            }
            finally {
                jarOut.flush();
                jarOut.close();
            }
        }
        finally {
            jarIn.close();
        }
    }


    private JarEntry smartClone(JarEntry originalJarEntry) {
        final JarEntry newJarEntry = new JarEntry(originalJarEntry.getName());
        newJarEntry.setComment(originalJarEntry.getComment());
        newJarEntry.setExtra(originalJarEntry.getExtra());
        newJarEntry.setMethod(originalJarEntry.getMethod());
        newJarEntry.setTime(originalJarEntry.getTime());

        //Must set size and CRC for STORED entries
        if (newJarEntry.getMethod() == ZipEntry.STORED) {
            newJarEntry.setSize(originalJarEntry.getSize());
            newJarEntry.setCrc(originalJarEntry.getCrc());
        }
        
        return newJarEntry;
    }
}

