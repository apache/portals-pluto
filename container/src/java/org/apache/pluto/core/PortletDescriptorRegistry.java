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

import java.util.Map;
import java.io.InputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.pluto.binding.PortletAppDD;
import org.apache.pluto.binding.XMLBindingFactory;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.util.StringManager;

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

    /** Singleton Instance */
    private static PortletDescriptorRegistry registry;

    /** Singleton Accessor. */
    public static PortletDescriptorRegistry getRegistry() {
        if(registry == null) {
            registry = new PortletDescriptorRegistry();
        }
        return registry;
    }

    /**
     * Cache of descriptors.  WeakHashMap is used so that
     * once the context is destroyed (kinda), the cache is eliminated.
     * Ideally we'd use a ServletContextListener, but at this
     * point I'm wondering if we really want to add another
     * config requirement in the servlet xml? Hmm. . .
     */
    private Map cache = new java.util.WeakHashMap();

    private PortletDescriptorRegistry() {

    }

    /**
     * Retrieve the Portlet Application Deployment Descriptor
     * for the given servlet context.  Create it if it does
     * not allready exist.
     *
     * @param context
     * @return
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
            app = XMLBindingFactory.createXMLBinding().getPortletAppDD(in);
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

