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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.services.Constants;
import org.apache.pluto.descriptors.services.PortletAppDescriptorService;
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
public abstract class AbstractPortletAppDescriptorService
    extends AbstractCastorDescriptorService
    implements PortletAppDescriptorService {

    public static final String PORTLET_XML_MAPPING =
        "castor-portlet-xml-mapping.xml";

    /**
     * Flag to determine if an empty deployment descriptor
     * should be created (in memory) if the actual descriptor
     * does not exist.
     */
    private boolean create;

    /**
     * Default Constructor.
     */
    protected AbstractPortletAppDescriptorService(String contextPath) {
        super(contextPath);
        this.create = true;
    }

    /**
     * Secondary Constructor.  Create an instance
     * and specify whether or not a default/empty instance
     * should be returned if no descriptor is available.
     * @param create
     */
    protected AbstractPortletAppDescriptorService(String contextPath, boolean create) {
        super(contextPath);
        this.create = create;
    }

    /**
     * Read the Web Application Deployment Descriptor.
     *
     * @return WebAppDD instance representing the descriptor.
     * @throws java.io.IOException
     */
    public PortletAppDD read() throws IOException {
        PortletAppDD portlet =
            (PortletAppDD) readInternal();
        if(portlet == null && create) {
            portlet = new PortletAppDD();
        }
        return portlet;
    }

    /**
     * Write the deployment descriptor.
     * @param portlet
     * @throws java.io.IOException
     */
    public void write(PortletAppDD portlet) throws IOException {
        writeInternal(portlet);
    }

    /**
     * Retrieve the Web Application Deployment
     * descriptor's public Id.
     * @return
     */
    protected String getPublicId() {
        return Constants.PORLTET_XML_PUBLIC_ID;
    }

    /**
     * Retrieve the Web Application Deployment
     * descriptor's DTD uri.
     * @return
     */
    protected String getDTDUri() {
        return Constants.PORTLET_XML_DTD;
    }

    /**
     * Read and Retrieve the Web Application's Castor Mapping
     * resource.
     *
     * @return
     * @throws java.io.IOException
     * @throws org.exolab.castor.mapping.MappingException
     */
    protected Mapping getCastorMapping()
    throws IOException, MappingException {
        URL url = PortletAppDD.class.getResource(PORTLET_XML_MAPPING);
        //dump(url);
        Mapping mapping = new Mapping();
        mapping.loadMapping(url);
        return mapping;
    }

    protected boolean getIgnoreExtraElements() {
        return true;
    }

    private void dump(URL url) {
        try {
        InputStream is = url.openStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String s;
            while( (s = in.readLine())!=null) {
                System.out.println(s);
            }
        }
        catch(IOException io) {
            io.printStackTrace();
        }
    }

}

