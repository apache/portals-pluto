/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.internal.InternalPortletConfig;
import org.apache.pluto.internal.InternalPortletContext;
import org.apache.pluto.internal.impl.Configuration;
import org.apache.pluto.internal.impl.PortletConfigImpl;
import org.apache.pluto.internal.impl.PortletContextImpl;
import org.apache.pluto.om.portlet.Portlet;
import org.apache.pluto.om.portlet.PortletApp;
import org.apache.pluto.spi.optional.PortletRegistryEvent;
import org.apache.pluto.spi.optional.PortletRegistryListener;
import org.apache.pluto.spi.optional.PortletRegistryService;
import org.apache.pluto.util.ClasspathScanner;

/**
 * Manager used to cache the portlet configurations which have
 * been previously parsed.
 *
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
    
    /**
     * The PortletContext cache map: key is servlet context, and value is the
     * associated portlet context.
     */
    private Map<String,InternalPortletContext> portletContexts = new HashMap<String,InternalPortletContext>();

    /**
     * List of application id resolvers. *
     */
    private static final List<ApplicationIdResolver> APP_ID_RESOLVERS = new ArrayList<ApplicationIdResolver>();


    // Private Member Variables ------------------------------------------------
    
    /**
     * The PortletContext cache map: key is servlet context, and value is the
     * associated portlet context.
     */
    private final Map<String,InternalPortletConfig> portletConfigs = new HashMap<String,InternalPortletConfig>();


    /**
     * The registered listeners that should be notified upon
     * registry events.
     */
    private final List<PortletRegistryListener> registryListeners = new ArrayList<PortletRegistryListener>();

    /**
     * The classloader for the portal, key is portletWindow and value is the classloader.
     */
    private final Map<String,ClassLoader> classLoaders = new HashMap<String,ClassLoader>();
    
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
     * @param config the servlet config.
     * @return the InternalPortletContext associated with the ServletContext.
     * @throws PortletContainerException
     */
	public String register(ServletConfig config) throws PortletContainerException {
	    ServletContext servletContext = config.getServletContext();
        String applicationId = getContextPath(servletContext);
        if (!portletContexts.containsKey(applicationId)) {

            PortletApp portletApp = PortletDescriptorRegistry.getRegistry().getPortletAppDD(servletContext);
            portletApp.setId(applicationId);
            portletApp.setName(applicationId.substring(1));

            InternalPortletContext portletContext = new PortletContextImpl(servletContext, portletApp);

            portletContexts.put(applicationId, portletContext);

            fireRegistered(portletContext);

            if (LOG.isInfoEnabled()) {
                LOG.info("Registered portlet application with application id '" + applicationId + "'");

                LOG.info("Registering "+portletApp.getPortlets().size()+" portlets for context "+portletContext.getApplicationId());

                classLoaders.put(portletApp.getId(), Thread.currentThread().getContextClassLoader());
                for (Portlet portlet: portletApp.getPortlets()) {
                    portletConfigs.put(
                        portletContext.getApplicationId() + "/" + portlet.getPortletName(),
                        new PortletConfigImpl(config, portletContext, portlet, portletApp)
                    );
                }
            }
        } else {
             if (LOG.isInfoEnabled()) {
                LOG.info("Portlet application with application id '" + applicationId + "' already registered.");
            }
        }
        return applicationId;
    }

    public void remove(InternalPortletContext context) {
        portletContexts.remove(context.getApplicationId());
        classLoaders.remove(context.getApplicationId());
        Iterator<String> configs = portletConfigs.keySet().iterator();
        while (configs.hasNext()) {
            String key = configs.next();
            if (key.startsWith(context.getApplicationId() + "/")) {
                configs.remove();
            }
        }
        fireRemoved(context);
    }

    public Iterator<String> getRegisteredPortletApplicationIds() {
        return new HashSet<String>(portletContexts.keySet()).iterator();
    }

    /**
     * Retrieve an iterator of all PortletContext instances
     * @return
     */
    public Iterator<InternalPortletContext> getPortletContexts() {
        return new HashSet<InternalPortletContext>(portletContexts.values()).iterator();
    }

    public InternalPortletContext getPortletContext(String applicationId) {
        return portletContexts.get(applicationId);
    }

    public InternalPortletConfig getPortletConfig(String applicationId, String portletName) throws PortletContainerException {
        InternalPortletConfig ipc = portletConfigs.get(applicationId + "/" + portletName);
        if (ipc != null) {
            return ipc;
        }
        String msg = "Unable to locate portlet config [applicationId="+applicationId+"]/["+portletName+"].";
        LOG.warn(msg);
        throw new PortletContainerException(msg);
    }

    public Portlet getPortlet(String applicationId, String portletName) throws PortletContainerException {
        InternalPortletConfig ipc = portletConfigs.get(applicationId + "/" + portletName);
        if (ipc != null) {
            return ipc.getPortletDefinition();
        }
        String msg = "Unable to retrieve portlet: '"+applicationId+"/"+portletName+"'";
        LOG.warn(msg);
        throw new PortletContainerException(msg);
    }

    public PortletApp getPortletApplication(String applicationId) throws PortletContainerException {
        InternalPortletContext ipc = portletContexts.get(applicationId);
        if (ipc != null) {
            return ipc.getPortletApplicationDefinition();
        }
        String msg = "Unable to retrieve portlet application: '"+applicationId+"'"; 
        LOG.warn(msg);
        throw new PortletContainerException(msg);
    }
    
    public ClassLoader getClassLoader(String applicationId){
    	return classLoaders.get(applicationId);
    }

    public void addPortletRegistryListener(PortletRegistryListener listener) {
        registryListeners.add(listener);
    }

    public void removePortletRegistryListener(PortletRegistryListener listener) {
        registryListeners.remove(listener);
    }

    private void fireRegistered(InternalPortletContext context) {
        PortletRegistryEvent event = new PortletRegistryEvent();
        event.setPortletApplication(context.getPortletApplicationDefinition());

        for (PortletRegistryListener l: registryListeners) {
            l.portletApplicationRegistered(event);
        }
        LOG.info("Portlet Context '" + context.getApplicationId() + "' registered.");
    }

    private void fireRemoved(InternalPortletContext context) {
        PortletRegistryEvent event = new PortletRegistryEvent();
        event.setPortletApplication(context.getPortletApplicationDefinition());

        for (PortletRegistryListener l: registryListeners) {
            l.portletApplicationRemoved(event);
        }

        LOG.info("Portlet Context '" + context.getApplicationId() + "' removed.");
    }

//
// Utility

    /**
     * Retrieve the servlet context of the portlet web app.
     * @param portalContext The servlet context of the portal web app.
     * @param portletContextPath The context path of the portlet web app.
     * The given path must be begin with "/" (see {@link ServletContext#getContext(String)}).
     * @return The servlet context of the portlet web app.
     * @throws PortletContainerException if the servlet context cannot be
     * retrieved for the given context path
     */
    public static ServletContext getPortletContext(ServletContext portalContext,
        String portletContextPath) throws PortletContainerException {
        if (Configuration.preventUnecessaryCrossContext()) {
            String portalPath = getContextPath(portalContext);
            if (portalPath.equals(portletContextPath)) {
                return portalContext;
            }
        }
        ServletContext portletAppCtx = portalContext.getContext(portletContextPath);
        if (portletAppCtx == null) {
            final String msg = "Unable to obtain the servlet context for the " +
              "portlet app context path [" + portletContextPath + "]. Make " +
              "sure that the portlet app has been deployed and that cross " +
              "context support is enabled for the portal app.";
            throw new PortletContainerException(msg);
        }
        return portletAppCtx;
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

        if (contextPath == null) {
            contextPath = computeContextPath(context);
        }

        return contextPath;
    }


    protected static String computeContextPath(ServletContext context) {
        if (APP_ID_RESOLVERS.size() < 1) {
            List<Class> classes = null;
            try {
                classes = ClasspathScanner.findConfiguredImplementations(ApplicationIdResolver.class);
            } catch (IOException e) {
                throw new RuntimeException("Unable to find any ApplicationIdResolvers");
            }
            for (Class c : classes) {
                try {
                    APP_ID_RESOLVERS.add((ApplicationIdResolver)c.newInstance());
                } catch (Exception e) {
                    LOG.warn("Unable to instantiate ApplicationIdResolver for class " + c.getName());
                }
            }
            if (LOG.isInfoEnabled()) {
                LOG.info("Found " + APP_ID_RESOLVERS.size() + " application id resolvers.");
            }
        }

        String path = null;
        int authority = Integer.MAX_VALUE;

        for (ApplicationIdResolver resolver : APP_ID_RESOLVERS) {
            if (resolver.getAuthority() < authority || path == null) {
                authority = resolver.getAuthority();
                String temp = resolver.resolveApplicationId(context);
                if (temp != null) {
                    path = temp;
                }
            }
        }
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("Resolved application id '" + path + "' with authority " + authority);
        }
        return path;
    }

}
