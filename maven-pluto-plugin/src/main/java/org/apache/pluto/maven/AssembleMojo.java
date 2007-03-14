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
package org.apache.pluto.maven;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.apache.pluto.util.assemble.Assembler;
import org.apache.pluto.util.assemble.AssemblerConfig;
import org.apache.pluto.util.assemble.AssemblerFactory;

/**
 * TODO: Document
 * TODO: Refactor this and the assembler to model deployer and allow no arg constructor
 *
 * @since Jul 30, 2005
 * @see org.apache.pluto.util.assemble.Assembler
 *
 * @goal assemble
 * @description prepares a web application as a portlet application
 * @phase process-resources
 */
public class AssembleMojo extends AbstractPortletMojo {

	// Private Member Variables ------------------------------------------------

    /**
     * The portlet application descriptor (<code>WEB-INF/portlet.xml</code>).
     * @parameter expression="${basedir}/src/main/webapp/WEB-INF/portlet.xml"
     * @required
     */
    private File portletXml;

    /**
     * The original webapp descriptor (<code>WEB-INF/web.xml</code>).
     * @parameter expression="${basedir}/src/main/webapp/WEB-INF/web.xml"
     * @required
     */
    private File webXml;

    /**
     * The file to which the updated webapp descriptor is written.
     * @parameter expression="${project.build.directory}/pluto-resources/web.xml"
     */
    private File webXmlDestination;

    /**
     * The name of the dispatch servlet class to use
     * @parameter
     */
    private String dispatchServletClass;
    
    /**
     * A list of war files to assemble.  Mutually exclusive with portletXml, webXml, 
     * and webXmlDestination parameters.
     * @parameter
     */
    private List warFiles;
    
    /**
     * Destination directory the assembled war files are written out to.
     * @parameter expression="${project.build.directory}/pluto-assembled-wars"
     */
    private File warFilesDestination;

    // AbstractPlutoMojo Impl --------------------------------------------------

    protected void doExecute() throws Exception {
        // Log parameter values.
    	Log log = getLog();
        if (log.isInfoEnabled()) {
            if (warFiles == null || warFiles.isEmpty()) {
                log.info("Reading web.xml from :" + webXml.getAbsolutePath());
                log.info("Reading portlet.xml from: " + portletXml.getAbsolutePath());
                log.info("Writing web.xml to: " + webXmlDestination.getAbsolutePath());
            } else {
                final String nl = System.getProperty("line.separator");
                StringBuffer buf = new StringBuffer("Attempting to assemble the following war files to destination directory " +
                        warFilesDestination.getAbsolutePath() + " : " + nl);
                for (Iterator i = warFiles.iterator(); i.hasNext();) {
                    File f = new File(i.next().toString());
                    buf.append("  " + f.getAbsolutePath());
                    if (i.hasNext()) {
                        buf.append(nl);
                    }
                }
                buf.append(nl);
                log.info(buf.toString());
            }              
        }
            
        // Assemble portlet app by updating web.xml.
        if (warFiles == null || warFiles.isEmpty()) {        
            AssemblerConfig config = createAssemblerConfig();
            Assembler assembler = AssemblerFactory.getFactory()
        		    .createAssembler(config);
            assembler.assemble(config);
        } else {
            for (Iterator i = warFiles.iterator(); i.hasNext();) {
                File warFile = new File(i.next().toString());
                if (log.isInfoEnabled()) {
                    log.info("Assembling war file " + warFile.getAbsolutePath() + " to directory " + warFilesDestination.getAbsolutePath());
                }                
                AssemblerConfig config = createWarFileAssemblerConfig(warFile, warFilesDestination);
                Assembler assembler = AssemblerFactory.getFactory()
                    .createAssembler(config);
                assembler.assemble(config);
            }
        }
    }

    protected void doValidate() throws MojoExecutionException {
        Log log = getLog();

        // If a list of war files are supplied:
        //   1) webXml, portletXml, and webXmlDestination parameters are ignored
        //   2) verify the files in the List exist.
        //   3) verify the destination is a directory, or create it if it doesn't exist.
        
        // A list of files was supplied so we ignore other parameters. 
        if (warFiles != null && !warFiles.isEmpty()) {
            if (webXml != null) {
                log.debug("warFiles parameter and webXml parameter are mutually exclusive.  Ignoring webXml parameter.");
            }
            if (portletXml != null) {
                log.debug("warFiles parameter and portletXml parameter are mutually exclusive.  Ignoring portletXml parameter.");
            }
            if (webXmlDestination != null) {
                log.debug("warFiles parameter and webXmlDestination parameter are mutually exclusive.  Ignoring webXmlDestination parameter.");
            }
            
            // verify each file can be found
            for (Iterator i = warFiles.iterator(); i.hasNext();) {
                File f = new File(i.next().toString());
                if (!f.exists()) {
                    log.warn("File " + f.getAbsolutePath() + " does not exist.");
                    i.remove();
                    continue;
                }
                if (!f.canRead()) {
                    log.warn("File " + f.getAbsolutePath() + " exists but cannot be read.");
                    i.remove();
                    continue;
                }
            }
            
            // check to see if the warFiles list is now empty
            if (warFiles.isEmpty()) {
                throw new MojoExecutionException("No war files could be installed due errors.");
            }
             
            // check to see if the dest dir exists or create it.
            if (!warFilesDestination.exists()) {
                if (log.isDebugEnabled()) {
                    log.debug("Creating destination directory for assembled war files: " + warFilesDestination.getAbsolutePath());
                }
                try {                    
                    if(!warFilesDestination.mkdirs()) {
                        throw new MojoExecutionException("Unable to create destination directory for assembled war files: " + 
                                warFilesDestination.getAbsolutePath());
                    }                        
                } catch (SecurityException e) {
                    throw new MojoExecutionException("Unable to create destination directory for assembled war files: " + e.getMessage(), e);
                }
            } else {
                if (!warFilesDestination.isDirectory()) {
                    throw new MojoExecutionException("Specified destination for assembled war files " +
                            warFilesDestination.getAbsolutePath() + " is not a directory!");
                }
                if (!warFilesDestination.canRead()||!warFilesDestination.canWrite()) {
                    throw new MojoExecutionException("Unable to read or write to destination directory for assembed war files.  " +
                            "Check permissions on the directory " + warFilesDestination.getAbsolutePath());
                }
            }
            
        // A list of war files was not provided, so use the other parameters instead.
            
        } else {            
            if (webXml == null || !webXml.exists()) {
                throw new MojoExecutionException("Web application descriptor must be a valid web.xml");
            }
            if (portletXml == null || !portletXml.exists()) {
                throw new MojoExecutionException("Portlet descriptor must be a valid portlet.xml");
            }
        }
    }

    // Private Methods ---------------------------------------------------------

    private AssemblerConfig createAssemblerConfig() {
        AssemblerConfig config = new AssemblerConfig();
        config.setPortletDescriptor(portletXml);
        config.setWebappDescriptor(webXml);
        config.setDestination(webXmlDestination);
        config.setDispatchServletClass(dispatchServletClass);
        return config;
    }
    
    private AssemblerConfig createWarFileAssemblerConfig(File warFile, File destinationDirectory) {
        AssemblerConfig config = new AssemblerConfig();
        config.setDispatchServletClass(dispatchServletClass);
        config.setWarSource(warFile);
        config.setDestination(destinationDirectory);
        return config;
    }

}
