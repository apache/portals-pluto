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
package org.apache.pluto.driver.deploy.impl;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.pluto.driver.deploy.PortalRegistrarService;
import org.apache.pluto.descriptors.services.PortletAppDescriptorService;

/**
 * Registrar service which adds the application context to the
 * registry file.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Mar 11, 2005
 */
public class ContextRegistryRegistrarService implements PortalRegistrarService {

    public static final String CONTEXT_FILE = "WEB-INF/data/portletcontexts.txt";

    private File webAppDir;

    public ContextRegistryRegistrarService(File webAppDir) {
        this.webAppDir = webAppDir;
    }

    public void register(PortletAppDescriptorService service)
        throws IOException {
        System.out.println("<VERBOSE> Registering Applicaiton Context");
        File file = new File(webAppDir, CONTEXT_FILE);
        RandomAccessFile ras = new RandomAccessFile(file, "rw");

        long length = ras.length();
        byte[] contentByte = new byte[(int) length];
        ras.read(contentByte);
        String contents = new String(contentByte);
        long pos = contents.lastIndexOf("/"+service.getContextPath());
        if(pos > -1) {
            System.out.println("<VERBOSE> Found previous context registration; Registration aborted.");
            ras.close();
            return;
        }
        ras.seek(length);
        ras.writeBytes("/"+service.getContextPath());
        ras.writeBytes("\n");
        ras.close();
    }
}

