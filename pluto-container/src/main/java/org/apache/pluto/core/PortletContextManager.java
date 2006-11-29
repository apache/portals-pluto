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

import org.apache.pluto.PortletContainerException;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.internal.InternalPortletContext;
import org.apache.pluto.internal.PortletDescriptorRegistry;
import org.apache.pluto.internal.impl.PortletContextImpl;
import org.apache.pluto.spi.optional.PortletRegistryEvent;
import org.apache.pluto.spi.optional.PortletRegistryListener;
import org.apache.pluto.spi.optional.PortletRegistryService;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Manager used to cache the portlet configurations which have
 * been previously parsed.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @version 1.0
 * @since Sep 20, 2004
 */
public class PortletContextManager implements PortletRegistryService {

    /**
     * The singleton manager instance.
     */
    private static final PortletContextManager MANAGER = new PortletContextManager();

    // Private Member Variables ------------------------------------------------

    /**
     * The PortletContext cache map: key is servlet context, and value is the
     * associated portlet context.
     */
    private MultiKeyedMap portletContexts = new MultiKeyedMap();

    /**
     * The registered listeners that should be notified upon
     * registry events.
     */
    private List registryListeners = new ArrayList();

    // Constructor -------------------------------------------------------------

    /**
     * Private constructor that prevents external instantiation.
     */
    private PortletContextManager() {
        // Do nothing.
    }

    /**
     * Returns the singleton manager instance.
     *
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
     * @param servletContext the servlet context.
     * @return the InternalPortletContext associated with the ServletContext.
     * @throws PortletContainerException
     */
    public InternalPortletContext register(ServletContext servletContext)
        throws PortletContainerException {
        if (!portletContexts.containsKey(servletContext)) {
            PortletAppDD portletAppDD = PortletDescriptorRegistry.getRegistry()
                .getPortletAppDD(servletContext);
            PortletContextImpl portletContext = new PortletContextImpl(
                servletContext, portletAppDD);

            if (portletContext.getApplicationId() == null) {
                throw new IllegalStateException("Unable to resolve unique identifier for portletContext.");
            }
            portletContexts.put(servletContext, portletContext);
            fireRegistered(portletContext);
        }
        return (InternalPortletContext) portletContexts.get(servletContext);
    }

    public void remove(InternalPortletContext context) {
        portletContexts.remove(context);
        fireRemoved(context);
    }


    public Iterator getRegisteredPortletApplications() throws PortletContainerException {
        return portletContexts.keySet().iterator();
    }

    public PortletAppDD getPortletApplicationDescriptor(String name) throws PortletContainerException {
        InternalPortletContext ipc = (InternalPortletContext)portletContexts.get(name);
        if(ipc != null) {
            return ipc.getPortletApplicationDefinition();
        }
        return null;
    }

    public void addPortletRegistryListener(PortletRegistryListener listener) {
        registryListeners.add(listener);
    }

    public void removePortletRegistryListener(PortletRegistryListener listener) {
        registryListeners.remove(listener);
    }

    private void fireRegistered(InternalPortletContext context) {
        PortletRegistryEvent event = new PortletRegistryEvent();
        event.setApplicationId(context.getApplicationId());
        event.setPortletApplicationDescriptor(context.getPortletApplicationDefinition());

        Iterator i = registryListeners.iterator();
        while (i.hasNext()) {
            ((PortletRegistryListener) i.next()).portletApplicationRegistered(event);
        }
    }

    private void fireRemoved(InternalPortletContext context) {
        PortletRegistryEvent event = new PortletRegistryEvent();
        event.setApplicationId(context.getApplicationId());
        event.setPortletApplicationDescriptor(context.getPortletApplicationDefinition());

        Iterator i = registryListeners.iterator();
        while (i.hasNext()) {
            ((PortletRegistryListener) i.next()).portletApplicationRemoved(event);
        }
    }

    class MultiKeyedMap extends HashMap {

        public void put(PortletContextImpl context) {
            put(context.getApplicationId(),context);
            put(context.getServletContext(), context);

            String contextPath = context.getContextPath();

            if (contextPath != null) {
                put(contextPath, context);
            }
        }

        public PortletAppDD remove(PortletContextImpl context) {
            PortletAppDD dd = (PortletAppDD) remove(context.getApplicationId());
            remove(context.getContextPath());
            remove(context.getServletContext());
            return dd;
        }
    }
}
