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

import org.w3c.dom.Document;

import java.io.*;
import java.util.Iterator;
import java.util.Map;

/**
 * Used to assemble a web application into a portlet application.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 15, 2004
 */
public class ExplodedFileAssembler extends AbstractAssembler {


    private File source;
    private File destination;

    private Map documents = new java.util.HashMap();
    private Map streams = new java.util.HashMap();

    public ExplodedFileAssembler(File webapp) {
        this(webapp, webapp);
    }

    public ExplodedFileAssembler(File webapp, File destination) {
        this.source = webapp;
        this.destination = destination;
        destination.mkdirs();
    }


    protected InputStream getWebResource(String resource) throws IOException {
        File file = new File(source, resource);
        return new FileInputStream(file);
    }

    protected void setWebResource(String name, InputStream in)
        throws IOException {
        streams.put(name, in);
    }

    protected void setWebResource(String name, Document dom)
        throws IOException {
        documents.put(name, dom);
    }

    protected void close() throws IOException {
        if(!source.equals(destination)) {
            copyRecursive(source, destination);
        }

        Iterator it = documents.keySet().iterator();
        while(it.hasNext()) {
            String name = it.next().toString();
            Document doc = (Document)documents.get(name);
            File file = new File(destination, name);
            file.getParentFile().mkdirs();
            OutputStream out = new FileOutputStream(file);
            save(doc, out);
        }

        it = streams.keySet().iterator();
        while(it.hasNext()) {
            String name = it.next().toString();
            InputStream in = (InputStream) streams.get(name);
            File file = new File(destination, name);
            file.getParentFile().mkdirs();
            OutputStream out = new FileOutputStream(file);
            save(in, out);
        }
    }

    private void copyRecursive(File source, File dest) throws IOException {
        File[] files = source.listFiles();
        for(int i=0;i<files.length;i++) {
            File destFile = new File(dest, files[i].getName());
            if(files[i].isDirectory()) {
                copyRecursive(files[i], destFile);
            }
            else {
                FileInputStream in = new FileInputStream(files[i]);
                FileOutputStream out = new FileOutputStream(destFile);
                save(in, out);
            }
        }
    }
}

