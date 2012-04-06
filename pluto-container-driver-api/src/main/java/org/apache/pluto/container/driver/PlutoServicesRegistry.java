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
package org.apache.pluto.container.driver;

import java.util.Map;
import java.util.WeakHashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.pluto.container.PortletContainerException;

/**
 * Static registry used by the {@link PortletServlet} and {@link PortalDriverServices} implementations to
 * coordinate registration lifecycle
 * 
 * @author Eric Dalquist
 */
public final class PlutoServicesRegistry {
    //Using a weak map keyed on ServletConfig, this should result in the map not causing memory leaks as applications are redpeloyed
    private static final Map<ServletConfig, RegistrationData> REGISTERED_PORTLETS = new WeakHashMap<ServletConfig, RegistrationData>(); 
    private static volatile PortalDriverServices portalDriverServices;
    
    /**
     * Called by the portlet container when it initializes to register the {@link PortalDriverServices} implementation
     */
    public static void registerPortalDriverServices(PortalDriverServices portalDriverServices) {
        if (portalDriverServices == null) {
            throw new IllegalArgumentException("Cannot register a null PortalDriverServices");
        }
        
        synchronized (REGISTERED_PORTLETS) {
            if (PlutoServicesRegistry.portalDriverServices != null) {
                throw new IllegalStateException("Cannot register PortalDriverServices, there is already one registered\n" +
                		"existing: " + PlutoServicesRegistry.portalDriverServices + "\n" +
        				"     new: " + portalDriverServices);
            }
            
            PlutoServicesRegistry.portalDriverServices = portalDriverServices;
            
            //Just registered the driver services, notify it about all portlets that have already called register
            if (PlutoServicesRegistry.portalDriverServices != null) {
                final PortletContextService portletContextService = portalDriverServices.getPortletContextService();
                
                for (final Map.Entry<ServletConfig, RegistrationData> registeredPortletEntry : REGISTERED_PORTLETS.entrySet()) {
                    final ServletConfig config = registeredPortletEntry.getKey();
                    final RegistrationData registrationData = registeredPortletEntry.getValue();
                    registerPortlet(portletContextService, config, registrationData);
                }
            }
        }
    }
    
    /**
     * Called by the portlet container when it is destroyed to remove the {@link PortalDriverServices} registration
     */
    public static void unregisterPortalDriverServices(PortalDriverServices portalDriverServices) {
        if (portalDriverServices == null) {
            throw new IllegalArgumentException("Cannot unregister a null PortalDriverServices");
        }
        
        synchronized (REGISTERED_PORTLETS) {
            if (PlutoServicesRegistry.portalDriverServices != portalDriverServices) {
                throw new IllegalStateException("Cannot unregister PortalDriverServices, the provided service does not match the existing registered service\n" +
                        "existing: " + PlutoServicesRegistry.portalDriverServices + "\n" +
                        "provided: " + portalDriverServices);
            }
            
            //Just unregistered the driver services, notify each portlet by calling unregister
            for (final Map.Entry<ServletConfig, RegistrationData> registeredPortletEntry : REGISTERED_PORTLETS.entrySet()) {
                final RegistrationData registrationData = registeredPortletEntry.getValue();
                
                try {
                    registrationData.lifecycleCallback.unregistered();
                }
                catch (Throwable t) {
                    final ServletConfig config = registeredPortletEntry.getKey();
                    config.getServletContext().log("Failed to unregister portlet " + config.getInitParameter("portlet-name") + " in " + config.getServletContext().getServletContextName(), t);
                }
            }
            
            //Clear the services reference
            PlutoServicesRegistry.portalDriverServices = null;
        }
        
    }
    
    /**
     * Called by the {@link PortletServlet} when it initializes, notifies the portlet container that the portlet needs to be registered
     * 
     * @param config The {@link ServletConfig} for the {@link PortletServlet} that is being initialized
     * @param classLoader The portlet application's {@link ClassLoader}
     * @param lifecycleCallback The callback the portlet container should call when registering the portlet
     */
    public static void register(String portletName, ServletConfig config, ClassLoader classLoader, PortletServletLifecycleCallback lifecycleCallback) {
        synchronized (REGISTERED_PORTLETS) {
            final RegistrationData registrationData = new RegistrationData(portletName, classLoader, lifecycleCallback);
            REGISTERED_PORTLETS.put(config, registrationData);
            
            //Driver services exist, notify them of the registration
            if (portalDriverServices != null) {
                final PortletContextService portletContextService = portalDriverServices.getPortletContextService();
                registerPortlet(portletContextService, config, registrationData);
            }
        }
    }
    
    /**
     * Called by the {@link PortletServlet} when it is destroyed, notifies the portlet container that the portlet needs to be unregistered
     * 
     * @param config The {@link ServletConfig} for the {@link PortletServlet} that is being destroyed
     * @param classLoader The portlet application's {@link ClassLoader}
     * @param lifecycleCallback The callback the portlet container should call when unregistering the portlet
     */
    public static void unregister(ServletConfig config, DriverPortletContext portletAppContext, DriverPortletConfig portletContext, PortletServletLifecycleCallback lifecycleCallback) {
        synchronized (REGISTERED_PORTLETS) {
            REGISTERED_PORTLETS.remove(config);
            
            //Driver services exist, notify them of the de-registration
            if (portalDriverServices != null) {
                final PortletContextService portletContextService = portalDriverServices.getPortletContextService();
                portletContextService.unregister(portletAppContext, portletContext, lifecycleCallback);
            }
            else {
                //Run the unregistered callback immediately since there is no portal to notify
                lifecycleCallback.unregistered();
            }
        }
    }

    private static void registerPortlet(final PortletContextService portletContextService, final ServletConfig config,
            final RegistrationData registrationData) {

        try {
            portletContextService.register(registrationData.portletName, config, registrationData.classLoader, registrationData.lifecycleCallback);
        }
        catch (PortletContainerException e) {
            final ServletContext context = config.getServletContext();
            context.log(e.getMessage(), e);
        }
    }
    
    private static final class RegistrationData {
        private final String portletName;
        private final ClassLoader classLoader;
        private final PortletServletLifecycleCallback lifecycleCallback;

        public RegistrationData(String portletName, ClassLoader classLoader, PortletServletLifecycleCallback lifecycleCallback) {
            this.portletName = portletName;
            this.classLoader = classLoader;
            this.lifecycleCallback = lifecycleCallback;
        }
    }
}
