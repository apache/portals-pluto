/*
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.deploy.impl;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.Iterator;
import java.util.Enumeration;
import java.util.Map;

import org.w3c.dom.Document;

/**
 * Used to assemble a web application into a portlet application.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 15, 2004
 */
public class ArchivedFileAssembler extends AbstractAssembler {

    private JarFile war;
    private File destination;

    private Map entries  = new java.util.HashMap();

    public ArchivedFileAssembler(JarFile war, File destination) {
        this.war = war;
        this.destination = destination;
    }


    protected InputStream getWebResource(String name)
    throws IOException {
        JarEntry entry = war.getJarEntry(name);
        if(entry!=null) {
            return war.getInputStream(entry);
        }
        return null;
    }

    protected void setWebResource(String name, InputStream in)
    throws IOException {

    }

    protected void setWebResource(String name, Document doc)
    throws IOException {

    }


    protected void close() throws IOException  {
        File file = new File(destination+".tmp");
        FileOutputStream fout = new FileOutputStream(file);
        JarOutputStream out = new JarOutputStream(fout);

        Enumeration enumeration = war.entries();
        while(enumeration.hasMoreElements()) {
            JarEntry entry = (JarEntry)enumeration.nextElement();
            entry = new JarEntry(entry.getName());
            InputStream is = null;
            if(!entries.containsKey(entry.getName())) {
                is = war.getInputStream(entry);
                out.putNextEntry(new JarEntry(entry));
                save(is, out);
            }
        }

        Iterator it = entries.keySet().iterator();
        while(it.hasNext()) {
            String name = it.next().toString();
            InputStream in = (InputStream)entries.get(name);
            out.putNextEntry(new JarEntry(name));
            save(in, out);
        }
        out.flush();
        out.close();

        destination.delete();
        file.renameTo(destination);
        file.delete();
    }
}


