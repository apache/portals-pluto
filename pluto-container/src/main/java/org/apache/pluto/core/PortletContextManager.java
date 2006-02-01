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

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.servlet.ServletContext;

import org.apache.pluto.PortletContainerException;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.core.impl.PortletContextImpl;

/**
 * Manager used to cache the portlet configurations which have
 * been previously parsed.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @version 1.0
 * @since Sep 20, 2004
 */
public class PortletContextManager {

    /** The singleton manager instance. */
    private static final PortletContextManager MANAGER = new PortletContextManager();

    // Private Member Variables ------------------------------------------------
    
    /**
     * The PortletContext cache map: key is servlet context, and value is the
     * associated portlet context.
     */
    private Map portletContexts = new HashMap();
    
    
    // Constructor -------------------------------------------------------------
    
    /**
     * Private constructor that prevents external instantiation.
     */
    private PortletContextManager() {
    	// Do nothing.
    }

    /**
     * Returns the singleton manager instance.
     * @return the singleton manager instance.
     */
    public static PortletContextManager getManager() {
        return MANAGER;
    }
    
    
    // Public Methods ----------------------------------------------------------

    /**
     * Retrieves the PortletContext associated with the given ServletContext.
     * If one does not exist, it is created.
     *
     * @param servletContext  the servlet context.
     * @return the InternalPortletContext associated with the ServletContext.
     * @throws PortletContainerException
     */
    public InternalPortletContext getPortletContext(ServletContext servletContext)
    throws PortletContainerException {
        if (!portletContexts.containsKey(servletContext)) {
            PortletAppDD portletAppDD = PortletDescriptorRegistry.getRegistry()
            		.getPortletAppDD(servletContext);
            PortletContext portletContext = new PortletContextImpl(
            		servletContext, portletAppDD);
            portletContexts.put(servletContext, portletContext);
        }
        return (InternalPortletContext) portletContexts.get(servletContext);
    }
}
