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

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletContext;


/**
 * Portlet Application Deployment Descriptor Service which
 * retrieves reads the descriptor from the ServletContext.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version $Id:$
 * @since Mar 5, 2005
 */
public class ContextPortletAppDescriptorServiceImpl extends AbstractPortletAppDescriptorService {
    
    public static final String PORTLET_XML_URI =  "/WEB-INF/portlet.xml";

    private ServletContext ctx;

    public ContextPortletAppDescriptorServiceImpl(ServletContext ctx) {
        super(ctx.getServletContextName());
        this.ctx = ctx;
    }

    protected InputStream getInputStream()
    throws IOException {
        return ctx.getResourceAsStream(PORTLET_XML_URI);
    }

    protected OutputStream getOutputStream()
    throws IOException {
        URL url = ctx.getResource(PORTLET_XML_URI);
        return url.openConnection().getOutputStream();
    }
}

