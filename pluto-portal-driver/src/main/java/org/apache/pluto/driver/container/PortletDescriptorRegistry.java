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

import java.util.Map;
import java.util.WeakHashMap;

import javax.servlet.ServletContext;

import org.apache.pluto.container.PortletAppDescriptorService;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.util.StringManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple caching mechanism used to manage portlet descriptors. This mechanism
 * takes special considerations to make sure that the cache is invalidated for
 * any ServletContext that is destroyed, thus allowing for a the context to be
 * redeployed.
 * 
 * NOTE: This should only be used internally. Do not access it from embedding
 * portals, instead, utilize the PortletRegistryService.
 * 
 * @version 1.0
 * @since Nov 3, 2004
 */
public class PortletDescriptorRegistry {
   
   /** Logger. */
   private static final Logger LOG = LoggerFactory
         .getLogger(PortletDescriptorRegistry.class);
   private static final boolean isDebug = LOG.isDebugEnabled();

   /** Exception Messages. */
   private static final StringManager EXCEPTIONS  = StringManager.getManager(PortletDescriptorRegistry.class
                                                                                           .getPackage()
                                                                                           .getName());

   // Private Member Variables ------------------------------------------------

   /** The portlet application descriptor service. */
   @SuppressWarnings("unused")
   private final PortletAppDescriptorService                       portletDDService;

   /**
    * Cache of descriptors. WeakHashMap is used so that once the context is
    * destroyed (kinda), the cache is eliminated. Ideally we'd use a
    * ServletContextListener, but at this point I'm wondering if we really want
    * to add another config requirement in the servlet xml? Hmm. . .
    */
   private final Map<ServletContext, PortletApplicationDefinition> cache       = new WeakHashMap<ServletContext, PortletApplicationDefinition>();

   // Constructor -------------------------------------------------------------

   // someone didn't want this accessible externally.
   PortletDescriptorRegistry(PortletAppDescriptorService portletDDService) {
      this.portletDDService = portletDDService;
   }

   // Public Methods ----------------------------------------------------------

   /**
    * Retrieve the Portlet Application Deployment Descriptor for the given
    * servlet context. Create it if it does not allready exist.
    * 
    * @param servletContext
    *           the servlet context.
    * @return The portlet application deployment descriptor.
    * @throws PortletContainerException
    *            if the descriptor can not be found or parsed
    */
   public PortletApplicationDefinition getPortletAppDD(
         ServletContext servletContext, String name, String contextPath)
         throws PortletContainerException {
      PortletApplicationDefinition portletApp = cache.get(servletContext);
      if (portletApp == null) {
         portletApp = createDefinition(servletContext, name, contextPath);
         cache.put(servletContext, portletApp);
      }
      return portletApp;
   }

   // Private Methods ---------------------------------------------------------

   /**
    * Creates and retisters the portlet application configuration based on the
    * config data read by the PortletContainerInitializer.
    * 
    * @param servletContext
    *           the servlet context for which the DD is requested.
    * @return the Portlet Application Deployment Descriptor.
    * @throws PortletContainerException
    */
   private PortletApplicationDefinition createDefinition(
         ServletContext servletContext, String name, String contextPath)
         throws PortletContainerException {
      
      PortletApplicationDefinition portletApp = null;
      ConfigurationHolder holder = (ConfigurationHolder) servletContext
            .getAttribute(ConfigurationHolder.ATTRIB_NAME);
      
      if (holder != null) {
         
         if (isDebug) {
            LOG.debug("Registering config initializer. ctx path: " + contextPath);
         }
         
         portletApp = holder.getPad();
         portletApp.setContextPath(contextPath);
         portletApp.setName(name);
         
      } else {
            throw new PortletContainerException(EXCEPTIONS.getString(
                  "error.context.descriptor.load",
                  new String[] { servletContext.getServletContextName(), "No config data stored in context." }));
      }
      return portletApp;
   }

}
