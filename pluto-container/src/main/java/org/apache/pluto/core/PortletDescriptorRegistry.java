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
package org.apache.pluto.core;

import org.apache.pluto.PlutoConfigurationException;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.services.PortletAppDescriptorService;
import org.apache.pluto.util.StringManager;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Simple caching mechanism used to manage
 * portlet descriptors.  This mechanism takes
 * special considerations to make sure that the
 * cache is invalidated for any ServletContext that
 * is destroyed, thus allowing for a the context
 * to be redeployed.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Nov 3, 2004
 */
class PortletDescriptorRegistry {
    /** Portlet deployment descriptor location. */
    private static final String PORTLET_XML = "/WEB-INF/portlet.xml";

    /** Exception Messages. */
    private static final StringManager EXCEPTIONS =
        StringManager.getManager(
            PortletDescriptorRegistry.class.getPackage().getName()
        );

    private PortletAppDescriptorService portletDDService;

    public static PortletDescriptorRegistry instance;

    public static PortletDescriptorRegistry getRegistry() {
        if(instance == null) {
            instance = new PortletDescriptorRegistry();
        }
        return instance;
    }

    /**
     * We must modify the context class loader in order for
     * the Configuration utility to find the properties file.
     */
    private PortletDescriptorRegistry() {
        String className = Configuration.getPortletAppDescriptorServiceImpl();
        try {
            Class cl = Class.forName(className);
            Object instance = cl.newInstance();
            portletDDService = (PortletAppDescriptorService)instance;
        } catch (ClassNotFoundException e) {
            throw new PlutoConfigurationException("ClassLoader configuration error: Unable to load class "+className, e);
        } catch (InstantiationException e) {
            throw new PlutoConfigurationException("Configuration Error: Unable to instantiate class "+className, e);
        } catch (IllegalAccessException e) {
            throw new PlutoConfigurationException("Security Error: Unable to access class "+className, e);
        }
    }

    /**
     * Cache of descriptors.  WeakHashMap is used so that
     * once the context is destroyed (kinda), the cache is eliminated.
     * Ideally we'd use a ServletContextListener, but at this
     * point I'm wondering if we really want to add another
     * config requirement in the servlet xml? Hmm. . .
     */
    private Map cache = new java.util.WeakHashMap();

    /**
     * Retrieve the Portlet Application Deployment Descriptor
     * for the given servlet context.  Create it if it does
     * not allready exist.
     *
     * @param context
     * @return The portlet application deployment descriptor.
     * @throws PortletContainerException
     */
    public PortletAppDD getPortletAppDD(ServletContext context)
    throws PortletContainerException {
        PortletAppDD dd = (PortletAppDD)cache.get(context);
        if(dd == null) {
            dd = createDefinition(context);
            cache.put(context, dd);
        }
        return dd;
    }
    /**
     * Create the portlet.xml deployment descriptor representation.
     *
     * @param ctx the servlet context for which the DD is requested.
     * @return the Portlet Application Deployment Descriptor info.
     * @throws org.apache.pluto.PortletContainerException
     */
    private PortletAppDD createDefinition(ServletContext ctx)
    throws PortletContainerException {
        PortletAppDD app = null;
        try {
            InputStream in = ctx.getResourceAsStream(PORTLET_XML);
            app = this.portletDDService.read(in);
        } catch (IOException io) {
            throw new PortletContainerException(
                EXCEPTIONS.getString(
                    "error.context.descriptor.load",
                    new String[] {ctx.getServletContextName()}
                ),
                io);
        }
        return app;
    }
}

