/*
 * Copyright 2004 The Apache Software Foundation.
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

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.servlet.ServletContext;

import org.apache.pluto.PortletContainerException;
import org.apache.pluto.util.StringManager;
import org.apache.pluto.binding.PortletAppDD;
import org.apache.pluto.binding.XMLBindingFactory;
import org.apache.pluto.core.impl.PortletContextImpl;

/**
 * Manager used to cache the portlet configurations which have
 * been previously parsed.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 20, 2004
 */
public class PortletContextManager {

    /** Portlet deployment descriptor location. */
    private static final String PORTLET_XML = "/WEB-INF/portlet.xml";

    /** Exception Messages. */
    private static final StringManager EXCEPTIONS =
        StringManager.getManager(
            PortletContextManager.class.getPackage().getName()
        );

    /** Singleton instance. */
    private static PortletContextManager manager;

    /**
     * Singleton accessor method.
     * @return the PortletContextManager implementation.
     */
    public static PortletContextManager getManager() {
        if (manager == null) {
            manager = new PortletContextManager();
        }
        return manager;
    }

    /** The PortletContext cache. */
    private Map contexts;

    /** Singleton Constructor. */
    private PortletContextManager() {
        contexts = new java.util.HashMap();
    }

    /**
     * Retrieve the PortletContext associated with the given ServletContext.
     * If one does not exist, it is created.
     *
     * @param context the servlet context
     * @return the portlet context existing within the ServletContext.
     * @throws PortletContainerException
     */
    public InternalPortletContext getContext(ServletContext context)
        throws PortletContainerException {
        if (!contexts.containsKey(context)) {
            PortletAppDD def = createDefinition(context);
            PortletContext pc = new PortletContextImpl(context, def);
            contexts.put(context, pc);
        }
        return (InternalPortletContext) contexts.get(context);
    }

    /**
     * Create the portlet.xml deployment descriptor representation.
     *
     * @param ctx
     * @return
     * @throws PortletContainerException
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

