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
package org.apache.pluto.descriptors.services;

import java.io.IOException;

import org.apache.pluto.descriptors.servlet.WebAppDD;

/**
 * WebApplication configuration as contained
 * within the web.xml Deployment Descriptor.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version $Id$
 * @since Feb 28, 2005
 */
public interface WebAppDescriptorService {

    /**
     * Retrieve the name of the context path
     * within which WebApps retrieved from this
     * service reside.
     * @return
     */
    String getContextPath();

    /**
     * Retrieve the WebApp deployment descriptor
     * (web.xml).
     * @return Object representation of the descriptor.
     * @throws IOException if an IO error occurs.
     */ 
    WebAppDD read() throws IOException;

    /**
     * Write the WebApp deployment descriptor
     * (web.xml).
     * @param dd
     * @throws IOException if an IO error occurs.
     */
    void write(WebAppDD dd) throws IOException;
}
