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
package org.apache.pluto.descriptors.services.impl;

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * <B>TODO</B>: Document
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Mar 7, 2005
 */
public class StreamPortletAppDescriptorServiceImpl 
    extends AbstractPortletAppDescriptorService {

    private InputStream in;
    private OutputStream out;

    public StreamPortletAppDescriptorServiceImpl(String contextPath,
                                                 InputStream in,
                                                 OutputStream out) {
        super(contextPath);
        this.in = in;
        this.out = out;
    }

    protected InputStream getInputStream() throws IOException {
        return in;
    }

    protected OutputStream getOutputStream() throws IOException {
        return out;
    }
}

