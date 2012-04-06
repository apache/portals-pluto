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
package org.apache.pluto.driver.container;

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

import org.apache.pluto.container.PortletAppDescriptorService;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.RequestDispatcherService;
import org.apache.pluto.container.driver.DriverPortletConfig;
import org.apache.pluto.container.driver.DriverPortletContext;
import org.apache.pluto.container.driver.PortalDriverServices;
import org.apache.pluto.container.driver.PortletContextService;
import org.apache.pluto.container.driver.PortletRegistryEvent;
import org.apache.pluto.container.driver.PortletRegistryListener;
import org.apache.pluto.container.driver.PortletRegistryService;
import org.apache.pluto.container.driver.PortletServletLifecycleCallback;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.util.ClasspathScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manager used to cache the portlet configurations which have
 * been previously parsed.
 *
 * @version 1.0
 * @since Sep 20, 2004
 */
public class PortletContextManager implements PortletRegistryService, PortletContextService {

	/**
     * Logger Instance
     */
    private static final Logger LOG = LoggerFactory.getLogger(PortletContextManager.class);

    /**
     * List of application id resolvers. *
     */
    private static final List<ApplicationIdResolver> APP_ID_RESOLVERS = new ArrayList<ApplicationIdResolver>();

    /**
     * The PortletContext cache map: key is servlet context, and value is the
     * associated portlet context.
     */
    private final Map<String,DriverPortletContextHolder> portletContexts = new HashMap<String,DriverPortletContextHolder>();


    // Private Member Variables ------------------------------------------------

    /**
     * The PortletContext cache map: key is servlet context, and value is the
     * associated portlet context.
     */
    private final Map<String,DriverPortletConfig> portletConfigs = new HashMap<String,DriverPortletConfig>();


    /**
     * The registered listeners that should be notified upon
     * registry events.
     */
    private final List<PortletRegistryListener> registryListeners = new ArrayList<PortletRegistryListener>();

    /**
     * The classloader for the portal, key is portletWindow and value is the classloader.
     */
    private final Map<String,ClassLoader> classLoaders = new HashMap<String,ClassLoader>();
    
    private final PortalDriverServices portalDriverServices;
    private final PortletDescriptorRegistry portletRegistry;

    // Constructor -------------------------------------------------------------

    public PortletContextManager(PortalDriverServices portalDriverServices, PortletAppDescriptorService portletAppDescriptorService) {
        this.portalDriverServices = portalDriverServices;
        portletRegistry = new PortletDescriptorRegistry(portletAppDescriptorService);
    }


    // Public Methods ----------------------------------------------------------
    
    private static final class DriverPortletContextHolder {
        private final DriverPortletContext portletAppContext;
        private int portletCount = 0;
        
        public DriverPortletContextHolder(DriverPortletContext portletAppContext) {
            this.portletAppContext = portletAppContext;
        }
    }

    /**
     * Retrieves the PortletContext associated with the given ServletContext.
     * If one does not exist, it is created.
     *
     * @param config the servlet config.
     * @return the InternalPortletContext associated with the ServletContext.
     * @throws PortletContainerException
     */
    public synchronized void register(String portletName, ServletConfig config, ClassLoader classLoader,
            PortletServletLifecycleCallback registrationCallback) throws PortletContainerException {
        
	    final ServletContext servletContext = config.getServletContext();
	    final String contextPath = getContextPath(servletContext);
	    
	    //Get or register the portlet application
	    DriverPortletContextHolder portletAppContextHolder = portletContexts.get(contextPath);
        if (portletAppContextHolder == null) {
            final PortletApplicationDefinition portletApp = portletRegistry.getPortletAppDD(servletContext, contextPath, contextPath);
            final RequestDispatcherService requestDispatcherService = this.portalDriverServices.getRequestDispatcherService();
            final DriverPortletContextImpl portletAppContext = new DriverPortletContextImpl(servletContext, portletApp, requestDispatcherService);
            
            //Verify the app loaded correctly
            final String appName = portletAppContext.getApplicationName();
            if (appName == null) {
                throw new PortletContainerException(
                        "Portlet application name was null when trying to register portlet '" + portletName
                                + "' from webapp " + contextPath);
            }
            
            portletAppContextHolder = new DriverPortletContextHolder(portletAppContext);

            portletContexts.put(contextPath, portletAppContextHolder);
            classLoaders.put(portletApp.getName(), classLoader);
            
            fireRegistered(portletAppContext);

            if (LOG.isInfoEnabled()) {
                LOG.info("Registered portlet application for context '" + contextPath + "'");
            }
        }
        
        
        //register the portlet
        final DriverPortletContext portletAppContext = portletAppContextHolder.portletAppContext;
        final PortletApplicationDefinition portletApp = portletAppContext.getPortletApplicationDefinition();
        
        if (LOG.isInfoEnabled()) {
            LOG.info("Portlet application for context '" + contextPath
                    + "' already registered, incrementing portlet count");
        }
        
        final PortletDefinition portlet = portletApp.getPortlet(portletName);

        final DriverPortletConfigImpl portletContext = new DriverPortletConfigImpl(portletAppContext, portlet);
        final String portletAppKey = portletAppContext.getApplicationName() + "/" + portlet.getPortletName();
        portletConfigs.put(portletAppKey, portletContext);

        //Notify the portlet it has been registered
        try {
            registrationCallback.registered(portalDriverServices, portletAppContext, portletContext);
            portletAppContextHolder.portletCount++;
        }
        catch (Throwable t) {
            //registration failed, cleanup
            portletConfigs.remove(portletAppKey);
            
            throw new PortletContainerException("Failed to register portlet " + portlet.getPortletName() + " from context " + portletAppContext.getApplicationName(), t);
        }

        //TODO fireRegistered(portletContext);

        if (LOG.isInfoEnabled()) {
            LOG.info("Registered portlet " + portlet.getPortletName() + " from context " + portletAppContext.getApplicationName() + " which now has " + portletAppContextHolder.portletCount + " registered portlets");
        }
    }


    public synchronized void unregister(DriverPortletContext portletAppContext, DriverPortletConfig portletContext, PortletServletLifecycleCallback lifecycleCallback) {
        lifecycleCallback.unregistered();
        
        final String portletAppKey = portletAppContext.getApplicationName() + "/" + portletContext.getPortletName();
        
        if (portletConfigs.remove(portletAppKey) != null) {
            //only bother with unregistration work if the was successfully registered in the first place
            
            //TODO fireRemoved(portletAppContext);
            
            final DriverPortletContextHolder driverPortletContextHolder = portletContexts.get(portletAppContext.getApplicationName());
            driverPortletContextHolder.portletCount--;
            
            //Last portlet unregistered, remove the app
            if (driverPortletContextHolder.portletCount == 0) {
                fireRemoved(portletAppContext);
            }
        }
    }

    /**
     * @see org.apache.pluto.container.driver.PortletRegistryService#getRegisteredPortletApplicationNames()
     */
    public Iterator<String> getRegisteredPortletApplicationNames() {
        return new HashSet<String>(portletContexts.keySet()).iterator();
    }

    /**
     * @see org.apache.pluto.container.driver.PortletContextService#getPortletContexts()
     */
    public synchronized Iterator<DriverPortletContext> getPortletContexts() {
        final List<DriverPortletContext> portletContextsList = new ArrayList<DriverPortletContext>(portletContexts.size());
        
        for (final DriverPortletContextHolder portletContextHolder : portletContexts.values()) {
            portletContextsList.add(portletContextHolder.portletAppContext);
        }
        
        return portletContextsList.iterator();
    }

    /**
     * @see org.apache.pluto.container.driver.PortletContextService#getPortletContext(java.lang.String)
     */
    public DriverPortletContext getPortletContext(String applicationName) {
        final DriverPortletContextHolder driverPortletContextHolder = portletContexts.get(applicationName);
        if (driverPortletContextHolder == null) {
            return null;
        }
        return driverPortletContextHolder.portletAppContext;
    }

    /**
     * @see org.apache.pluto.container.driver.PortletContextService#getPortletContext(org.apache.pluto.container.PortletWindow)
     */
    public DriverPortletContext getPortletContext(PortletWindow portletWindow) throws PortletContainerException {
        return getPortletContext(portletWindow.getPortletDefinition().getApplication().getName());
    }


    /**
     * @see org.apache.pluto.container.driver.PortletContextService#getPortletConfig(java.lang.String, java.lang.String)
     */
    public DriverPortletConfig getPortletConfig(String applicationName, String portletName) throws PortletContainerException {
        DriverPortletConfig ipc = portletConfigs.get(applicationName + "/" + portletName);
        if (ipc != null) {
            return ipc;
        }
        String msg = "Unable to locate portlet config [applicationName="+applicationName+"]/["+portletName+"].";
        LOG.warn(msg);
        throw new PortletContainerException(msg);
    }

    /**
     * @see org.apache.pluto.container.driver.PortletRegistryService#getPortlet(java.lang.String, java.lang.String)
     */
    public PortletDefinition getPortlet(String applicationName, String portletName) throws PortletContainerException {
        DriverPortletConfig ipc = portletConfigs.get(applicationName + "/" + portletName);
        if (ipc != null) {
            return ipc.getPortletDefinition();
        }
        String msg = "Unable to retrieve portlet: '"+applicationName+"/"+portletName+"'";
        LOG.warn(msg);
        throw new PortletContainerException(msg);
    }

    /**
     * @see org.apache.pluto.container.driver.PortletRegistryService#getPortletApplication(java.lang.String)
     */
    public PortletApplicationDefinition getPortletApplication(String applicationName) throws PortletContainerException {
        final DriverPortletContextHolder driverPortletContextHolder = portletContexts.get(applicationName);
        if (driverPortletContextHolder != null) {
            DriverPortletContext ipc = driverPortletContextHolder.portletAppContext;
            if (ipc != null) {
                return ipc.getPortletApplicationDefinition();
            }
        }
        String msg = "Unable to retrieve portlet application: '"+applicationName+"'";
        LOG.warn(msg);
        throw new PortletContainerException(msg);
    }

    /**
     * @see org.apache.pluto.container.driver.PortletContextService#getClassLoader(java.lang.String)
     */
    public ClassLoader getClassLoader(String applicationName){
    	return classLoaders.get(applicationName);
    }

    /**
     * @see org.apache.pluto.container.driver.PortletRegistryService#addPortletRegistryListener(org.apache.pluto.container.driver.PortletRegistryListener)
     */
    public void addPortletRegistryListener(PortletRegistryListener listener) {
        registryListeners.add(listener);
    }

    /**
     * @see org.apache.pluto.container.driver.PortletRegistryService#removePortletRegistryListener(org.apache.pluto.container.driver.PortletRegistryListener)
     */
    public void removePortletRegistryListener(PortletRegistryListener listener) {
        registryListeners.remove(listener);
    }

    private void fireRegistered(DriverPortletContext context) {
        //TODO differentiate between portlet app and portlet events
        PortletRegistryEvent event = new PortletRegistryEvent();
        event.setPortletApplication(context.getPortletApplicationDefinition());

        for (PortletRegistryListener l: registryListeners) {
            l.portletApplicationRegistered(event);
        }
        LOG.info("Portlet Context '" + context.getApplicationName() + "' registered.");
    }

    private void fireRemoved(DriverPortletContext context) {
        //TODO differentiate between portlet app and portlet events
        PortletRegistryEvent event = new PortletRegistryEvent();
        event.setPortletApplication(context.getPortletApplicationDefinition());

        for (PortletRegistryListener l: registryListeners) {
            l.portletApplicationRemoved(event);
        }

        LOG.info("Portlet Context '" + context.getApplicationName() + "' removed.");
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

        //Hack to deal with inconsistence in root context handling between
        //ServletContext.getContextPath and ServletContext.getContext
        if ("".equals(portletContextPath)) {
            portletContextPath = "/";
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
            contextPathGetter = ServletContext.class.getMethod("getContextPath", (Class[])null);
        }
        catch (NoSuchMethodException e) {
            LOG.warn("Servlet 2.4 or below detected.  Unable to find getContextPath on ServletContext.");
        }
    }

    protected static String getContextPath(ServletContext context) {
        String contextPath = null;
        if (contextPathGetter != null) {
            try {
                contextPath = (String) contextPathGetter.invoke(context, (Object[])null);
            } catch (Exception e) {
                LOG.warn("Unable to directly retrieve context path from ServletContext. Computing. . . ");
            }
        }

        if (contextPath == null) {
            contextPath = computeContextPath(context);
        }

        return contextPath;
    }


    @SuppressWarnings("unchecked")
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
