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

import java.io.IOException;
import java.net.URL;

import org.apache.pluto.descriptors.services.Constants;
import org.apache.pluto.descriptors.services.WebAppDescriptorService;
import org.apache.pluto.descriptors.servlet.WebAppDD;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;

/**
 * Abstract Implementation of the Web Application Deployment
 * Descriptor service.  Provides default implementation of
 * the service; requiring only that subclasses provide the
 * input streams to/from the actual descriptor.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version $Id$
 * @since Mar 5, 2005
 */
public abstract class AbstractWebAppDescriptorService
    extends AbstractCastorDescriptorService
    implements WebAppDescriptorService {

    public static final String WEB_XML_MAPPING = "castor-web-xml-mapping.xml";

    /**
     * Flag to determine if an empty deployment descriptor
     * should be created (in memory) if the actual descriptor
     * does not exist.
     */
    private boolean create;

    /**
     * Default Constructor.
     */
    protected AbstractWebAppDescriptorService(String contextPath) {
        super(contextPath);
        this.create = true;
    }

    /**
     * Secondary Constructor.  Create an instance
     * and specify whether or not a default/empty instance
     * should be returned if no descriptor is available.
     * @param create
     */
    protected AbstractWebAppDescriptorService(String contextPath, boolean create) {
        super(contextPath);
        this.create = create;
    }

    /**
     * Read the Web Application Deployment Descriptor.
     *
     * @return WebAppDD instance representing the descriptor.
     * @throws IOException
     */
    public WebAppDD read() throws IOException {
        WebAppDD webApp = (WebAppDD) readInternal();
        if(webApp == null && create) {
            webApp = new WebAppDD();
            webApp.setDisplayName("Portal Application");
            webApp.setDescription("Auto Generated Portal Application Wrapper");
        }
        return webApp;
    }

    /**
     * Write the deployment descriptor.
     * @param webApp
     * @throws IOException
     */
    public void write(WebAppDD webApp) throws IOException {
        writeInternal(webApp);
    }

    /**
     * Retrieve the Web Application Deployment
     * descriptor's public Id.
     * @return
     */
    protected String getPublicId() {
        return Constants.WEB_XML_PUBLIC_ID;
    }

    /**
     * Retrieve the Web Application Deployment
     * descriptor's DTD uri.
     * @return
     */
    protected String getDTDUri() {
        return Constants.WEB_XML_DTD;
    }

    /**
     * Read and Retrieve the Web Application's Castor Mapping
     * resource.
     *
     * @return
     * @throws IOException
     * @throws MappingException
     */
    protected Mapping getCastorMapping()
    throws IOException, MappingException {
        URL url = WebAppDD.class.getResource(WEB_XML_MAPPING);
        Mapping mapping = new Mapping();
        mapping.loadMapping(url);
        return mapping;
    }

}

