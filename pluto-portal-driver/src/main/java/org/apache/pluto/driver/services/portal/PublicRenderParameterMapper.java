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


package org.apache.pluto.driver.services.portal;

import static java.util.logging.Level.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;

import org.apache.pluto.driver.url.PortalURLPublicParameter;
import org.apache.pluto.container.driver.PortletRegistryService;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;

/**
 * Provides public render parameter mappings for a given page.
 * 
 * @author msnicklous
 * @since  16/01/2015
 */
public class PublicRenderParameterMapper {
   private final Logger LOGGER = LoggerFactory.getLogger(PublicRenderParameterMapper.class);
   
   // Maps the portlet window ID to a set of public render parameters
   private final Map<String, Set<PortalURLPublicParameter>> wid2PRP = 
                        new HashMap<String, Set<PortalURLPublicParameter>>();
   
   // Maps the PRP QName to a set of public render parameters
   private final Map<QName, Set<PortalURLPublicParameter>> qn2PRP = 
                        new HashMap<QName, Set<PortalURLPublicParameter>>();
   
   public PublicRenderParameterMapper(PageConfig paco, PortletRegistryService pore) {
      
      Collection<String> pids = paco.getPortletIds();
      LOGGER.debug("Setting up the PRP mapper. There are " + pids.size() + " portlets to process.");

      StringBuilder dbgstr = new StringBuilder(1024);
      boolean isDebug = LOGGER.isDebugEnabled();
      for (String pid : pids) {
         if (isDebug) {
            dbgstr.append("\n  Processing portlet id = " + pid);
         }
         
         PortletWindowConfig pwc = null;
         PortletApplicationDefinition pad = null;
         PortletDefinition pd = null;
         
         pwc = PortletWindowConfig.fromId(pid);
         String cxtpa = pwc.getContextPath();
         String portletName = pwc.getPortletName();
         
         try {
            pad = pore.getPortletApplication(cxtpa);
            pd = pore.getPortlet(cxtpa, portletName);

            if (isDebug) {
               dbgstr.append("\n    For context: " + cxtpa + ", App name is " 
                     + pad.getName() + ", portlet name is " + pd.getPortletName());
            }
            
         } catch (Exception e) {
            if (pad == null) {
               LOGGER.error("Could not get portlet app for: " + cxtpa);
            } else {
               LOGGER.error("Could not get portlet definition for: " + portletName);
            }
         }
      }
      if (isDebug) {
         LOGGER.debug(dbgstr.toString());
      }
   }

}
