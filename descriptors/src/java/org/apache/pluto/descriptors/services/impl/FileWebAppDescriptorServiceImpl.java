/*
 * Copyright 2005 The Apache Software Foundation
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
package org.apache.pluto.descriptors.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version $Id$
 * @since Mar 5, 2005
 */
public class FileWebAppDescriptorServiceImpl extends AbstractWebAppDescriptorService {

    private static final String WEB_XML_FILE = "WEB-INF/web.xml";

    private File file;

    public FileWebAppDescriptorServiceImpl(File file) {
        super(file.getName());
        this.file = new File(file, WEB_XML_FILE);
    }

    protected InputStream getInputStream() throws IOException {
        if(file.exists()) {
            return new FileInputStream(file);
        }
        return null;
    }

    protected OutputStream getOutputStream() throws IOException {
        if(file.exists()) {
            return new FileOutputStream(file);
        }
        return null;
    }
}

