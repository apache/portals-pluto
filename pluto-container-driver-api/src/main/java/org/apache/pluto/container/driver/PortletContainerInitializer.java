/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.pluto.container.driver;

import java.io.InputStream;
import java.util.Set;

import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.PortletConfigurations;
import javax.portlet.annotations.PortletRequestFilter;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;

import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.bean.processor.AnnotatedConfigBean;
import org.apache.pluto.container.bean.processor.PortletCDIExtension;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet container initializer that reads the configuration and adds the
 * portlet servlets for any portlets contained in the application.
 * 
 * @author Scott Nicklous
 * 
 */
@HandlesTypes({PortletApplication.class, PortletConfiguration.class,
               PortletRequestFilter.class, PortletConfigurations.class})
public class PortletContainerInitializer implements ServletContainerInitializer {

   private static final String WEB_XML     = "/WEB-INF/web.xml";
   private static final String PORTLET_XML = "/WEB-INF/portlet.xml";

   /** Logger. */
   private static final Logger LOG         = LoggerFactory
                                                 .getLogger(PortletContainerInitializer.class);
   private static boolean      isDebug     = LOG.isDebugEnabled();

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.ServletContainerInitializer#onStartup(java.util.Set,
    * javax.servlet.ServletContext)
    */
   @Override
   public void onStartup(Set<Class<?>> classes, ServletContext ctx)
         throws ServletException {

      try {

         // Get the bean configuration from the CDI extension

         AnnotatedConfigBean acb = PortletCDIExtension.getConfig();
         if (acb == null) {
            StringBuilder txt = new StringBuilder();
            txt.append("The managed bean configuration could not be obtained. \n\nMake sure Tomcat is configured correctly.");
            txt.append("\nVerify that the CDI implementation is available and configured to run before the Pluto portlet container initializer.");
            txt.append("\nVerify that the file 'weld-servlet-2.3.1.Final.jar' is in the ${catalina.base}/lib directory.");
            txt.append("\nVerify that the catalina.properties file contains a line similar to:.");
            txt.append("\n   common.loader=\"${catalina.home}/lib/weld-servlet-2.3.1.Final.jar\",\"${catalina.base}/lib\",\"${catalina.base}/lib/*.jar\",\"${catalina.home}/lib\",\"${catalina.home}/lib/*.jar\"");
            txt.append("\n");
            LOG.warn(txt.toString());
         }

         // Read the annotated configuration

         ConfigurationHolder holder = new ConfigurationHolder();

         if (classes != null) {
            holder.processConfigAnnotations(classes);
         }

         // set up for reading the XML files

         InputStream win = ctx.getResourceAsStream(WEB_XML);
         InputStream pin = ctx.getResourceAsStream(PORTLET_XML);

         if (isDebug) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("§§§ ServletContainerInitializer. ctx path: ").append(
                  ctx.getContextPath());
            txt.append(", servlet ctx name: ").append(ctx.getServletContextName());
            txt.append(", # portlet annotations: ").append(
                  (classes != null) ? classes.size() : "null");
            txt.append(", found web.xml: ").append(win != null);
            txt.append(", found portlet.xml: ").append(pin != null);
            LOG.debug(txt.toString());
         }

         // Now read the XML configuration and validate the resulting explicit config

         if (pin != null) {
            // parse the portlet deployment descriptor
            holder.processPortletDD(pin);
         }

         if (win != null) {
            // parse the web app deployment descriptor
            holder.processWebDD(win);
         }

         holder.validate();
         
         // If we were able to obtain a bean config, reconcile the bean config with the
         // explicitly declared portlet configuration.
         
         if (acb != null) {
            holder.reconcileBeanConfig(acb.getMethodStore());
         }
         
         // If portlets have been found in this servlet context, launch the portlet servlets

         if (holder.getPad().getPortlets().size() > 0) {

            ctx.setAttribute(ConfigurationHolder.ATTRIB_NAME, holder);

            // dynamically deploy the portlet servlets
            for (PortletDefinition pd : holder.getPad().getPortlets()) {
               String pn = pd.getPortletName();
               String mapping = PortletInvokerService.URIPREFIX + pn;
               String servletName = pn + "_PS3";

               if (isDebug) {
                  StringBuilder txt = new StringBuilder();
                  txt.append("Adding PortletServlet3. Portlet name: ");
                  txt.append(pn);
                  txt.append(", servlet name: ").append(servletName);
                  txt.append(", mapping: ").append(mapping);
                  LOG.debug(txt.toString());
               }

               ServletRegistration.Dynamic sr = ctx.addServlet(servletName, PortletServlet3.class);
               sr.addMapping(mapping);
               sr.setInitParameter(PortletServlet3.PORTLET_NAME, pn);
               sr.setLoadOnStartup(100);

            }

         } else {
            LOG.debug("No portlet definitions for context: " + ctx.getServletContextName());
         }

      } catch (Exception e) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Exception processing portlet application configuration");
         txt.append(", Servlet ctx name: ").append(
               ctx.getServletContextName());
         txt.append(", Exception: ").append(e.toString());
         LOG.info(txt.toString());
      }

   }

}
