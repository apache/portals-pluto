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
package org.apache.pluto.driver.deploy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.io.FileOutputStream;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;
import java.util.Enumeration;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Mar 6, 2005
 */
class PortletApplicationExploder {

    private File destination;

    private boolean validateJsp;

    /**
     *
     * @param destination
     */
    public PortletApplicationExploder(File destination) {
        this.destination = destination;
    }

    public PortletApplicationExploder(File destination, boolean validate) {
        this(destination);
        this.validateJsp = validate;
    }

    public void explode(File war) throws IOException {
        File destination = getDestinationDirectory(war.getName());
        destination.delete();
        destination.mkdirs();
        JarFile jarFile = new JarFile(war);

        Enumeration files = jarFile.entries();
        while (files.hasMoreElements()) {
            JarEntry entry = (JarEntry) files.nextElement();
            String fileName = entry.getName();
            InputStream is = jarFile.getInputStream(entry);
            if(validateJsp && !entry.isDirectory() && entry.getName().endsWith(".jsp")) {

                validateJsp(is);
            }

                File file = new File(destination, fileName);
                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    file.getParentFile().mkdirs();
                    byte[] buffer = new byte[1024];
                    int length = 0;
                    is = jarFile.getInputStream(entry);
                    FileOutputStream fos = new FileOutputStream(file);
                    while ((length = is.read(buffer)) >= 0) {
                        fos.write(buffer, 0, length);
                    }
                    fos.close();
            }
        }

    }

    private void validateJsp(InputStream is) throws IOException {
        Reader r = new BufferedReader(new InputStreamReader(is));
        StreamTokenizer st = new StreamTokenizer(r);
        st.quoteChar('\'');
        st.quoteChar('"');
        while(st.nextToken()!=StreamTokenizer.TT_EOF) {
            if(st.ttype=='\'' || st.ttype=='"'){
                String sval = st.sval;
                String sqc = Character.toString((char)st.ttype);
                if(sval.equals("/WEB-INF/tld/portlet.tld")){
                    System.out.println("Warning: " + sqc+st.sval+sqc + " has been found in file " + ". Use instead " +sqc+"http://java.sun.com/portlet"+sqc+" with your portlet taglib declaration!\n");
                    break;
                }
            }
        }
    }

    private File getDestinationDirectory(String warName) {
        int extLocation = warName.indexOf(".");
        warName = warName.substring(0, extLocation);
        return new File(destination, warName);
    }

}

