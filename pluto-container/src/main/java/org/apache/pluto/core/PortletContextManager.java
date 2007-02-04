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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.internal.InternalPortletContext;
import org.apache.pluto.internal.PortletDescriptorRegistry;
import org.apache.pluto.internal.Configuration;
import org.apache.pluto.internal.impl.PortletContextImpl;
import org.apache.pluto.spi.optional.PortletRegistryEvent;
import org.apache.pluto.spi.optional.PortletRegistryListener;
import org.apache.pluto.spi.optional.PortletRegistryService;

import javax.servlet.ServletContext;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
     * Log Instance
     */
    private static final Log LOG = LogFactory.getLog(PortletContextManager.class);

    /**
     * The singleton manager instance.
     */
    private static final PortletContextManager MANAGER = new PortletContextManager();

    // Private Member Variables ------------------------------------------------

    /**
     * The PortletContext cache map: key is servlet context, and value is the
     * associated portlet context.
     */
    private Map portletContexts = new HashMap();

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
        String applicationId = getContextPath(servletContext);
        if (!portletContexts.containsKey(servletContext)) {

            PortletAppDD portletAppDD = PortletDescriptorRegistry.getRegistry()
                .getPortletAppDD(servletContext);

            PortletContextImpl portletContext = new PortletContextImpl(
                applicationId,  servletContext, portletAppDD);

            if (portletContext.getApplicationId() == null) {
                throw new IllegalStateException("Unable to resolve unique identifier for portletContext.");
            }
            portletContexts.put(applicationId, portletContext);
            fireRegistered(portletContext);
        }
        return (InternalPortletContext)portletContexts.get(applicationId);
    }

    public void remove(InternalPortletContext context) {
        portletContexts.remove(context);
        fireRemoved(context);
    }

    public Iterator getRegisteredPortletApplicationIds() {
        return new HashSet(portletContexts.keySet()).iterator();

    }

    public Iterator getRegisteredPortletApplications() {
        return new HashSet(portletContexts.values()).iterator();
    }

    public PortletAppDD getPortletApplicationDescriptor(String name) throws PortletContainerException {
        InternalPortletContext ipc = (InternalPortletContext) portletContexts.get(name);
        if (ipc != null) {
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

        LOG.info("Portlet Context '" + context.getApplicationId() + "' registered.");
    }

    private void fireRemoved(InternalPortletContext context) {
        PortletRegistryEvent event = new PortletRegistryEvent();
        event.setApplicationId(context.getApplicationId());
        event.setPortletApplicationDescriptor(context.getPortletApplicationDefinition());

        Iterator i = registryListeners.iterator();
        while (i.hasNext()) {
            ((PortletRegistryListener) i.next()).portletApplicationRemoved(event);
        }

        LOG.info("Portlet Context '" + context.getApplicationId() + "' removed.");
    }


//
// Utility

    public static ServletContext getPortletContext(ServletContext portalContext, String portletContextPath) {
        if(Configuration.preventUnecessaryCrossContext()) {
            String portalPath = getContextPath(portalContext);
            if(portalPath.equals(portletContextPath)) {
                return portalContext;
            }
        }
        return portalContext.getContext(portletContextPath);
    }

    /**
     * Servlet 2.5 ServletContext.getContextPath() method.
     */
    private static Method contextPathGetter;

    static {
        try {
            contextPathGetter = ServletContext.class.getMethod("getContextPath", new Class[0]);
        }
        catch (NoSuchMethodException e) {
            LOG.warn("Servlet 2.4 or below detected.  Unable to find getContextPath on ServletContext.");
        }
    }

    protected static String getContextPath(ServletContext context) {
        String contextPath = null;
        if (contextPathGetter != null) {
            try {
                contextPath = (String) contextPathGetter.invoke(context, new Class[0]);
            } catch (Exception e) {
                LOG.warn("Unable to directly retrieve context path from ServletContext. Computing. . . ");
            }
        }

        if(contextPath == null) {
            contextPath = computeContextPath(context);
        }

        return contextPath;
    }

    private static final String WEB_XML = "/WEB-INF/web.xml";
    protected static String computeContextPath(ServletContext context) {
        try {
            URL webXmlUrl = context.getResource(WEB_XML);
            String path = webXmlUrl.toExternalForm();
            path = path.substring(0, path.indexOf(WEB_XML));
            path = path.substring(path.lastIndexOf("/"));

            int id = path.indexOf(".war");
            if(id > 0) {
                path = path.substring(0, id);
            }

            return path;
        } catch (MalformedURLException e) {
            LOG.warn("Erorr retrieving web.xml from ServletContext. Unable to derive contextPath.");
            return null;
        }
    }
}
