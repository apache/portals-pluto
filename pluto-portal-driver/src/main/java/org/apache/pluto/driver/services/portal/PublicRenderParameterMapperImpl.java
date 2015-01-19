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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;

import org.apache.pluto.driver.url.PortalURLPublicParameter;
import org.apache.pluto.container.driver.PortletRegistryService;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.PublicRenderParameter;

/**
 * Provides public render parameter mappings for a given page.
 * This mapper maps public render parameters on the basis of Qnames. 
 * If two PRPs have the same QName, they are considered to refer to the same 
 * public render parameter. The mapping is limited to the current page.
 * 
 * @author msnicklous
 * @since  16/01/2015
 */
public class PublicRenderParameterMapperImpl implements PublicRenderParameterMapper {
   private final Logger LOGGER = LoggerFactory.getLogger(PublicRenderParameterMapperImpl.class);
   
   // Set of all public render parameters on the page
   Set<PortalURLPublicParameter> prps = new HashSet<PortalURLPublicParameter>();
   
   public PublicRenderParameterMapperImpl(PageConfig paco, PortletRegistryService pore) {
      
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
            
            Collection<String> prpIds = pd.getSupportedPublicRenderParameters();
            if (prpIds != null && prpIds.size() > 0) {
               Collection<? extends PublicRenderParameter> prpDefs = pad.getPublicRenderParameters();
               String namespace = pad.getDefaultNamespace();
               for (String prpId : prpIds) {
                  Iterator<? extends PublicRenderParameter> i = prpDefs.iterator();
                  QName qn = null;
                  while (qn == null && i.hasNext()) {
                     PublicRenderParameter prpDef = i.next();
                     if (prpDef.getIdentifier().equals(prpId)) {
                        qn = prpDef.getQName();
                        if (qn == null) {
                           // If qname is null, build a qnamme from the name & namespace fields
                           String name = prpDef.getName();
                           if (name == null) {
                              LOGGER.error("Problem with PRP definition: Both QName and Nqme are null.");
                           } else {
                              qn = new QName(namespace, name);
                           }
                        }
                     }
                  }
                  if (qn == null) {
                     LOGGER.error("Problem with PRP definition: Both QName could not be obtained.");
                  } else {
                     PortalURLPublicParameter pupp = new PortalURLPublicParameter(pid, prpId, qn);

                     prps.add(pupp);
                     
                     if (isDebug) {
                        dbgstr.append("\n      Added PRP for window = " + pid + " QName = " + qn.toString()
                              + ", ID = " + prpId);
                     }
                  }
               }
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

   /**
    * Returns set of related PRPs for the input PRP. The mapping is done on the basis of the QName. 
    * The value arrays of all PRPs in the returned set are set to the value array in the input PRP.
    */
   public Set<PortalURLPublicParameter> getMappedPublicParameters(PortalURLPublicParameter prp) {
      Set<PortalURLPublicParameter> oprps = new HashSet<PortalURLPublicParameter>();
      for (PortalURLPublicParameter ip : prps) {
         if (ip.getQName().equals(prp.getQName())) {
            PortalURLPublicParameter p = ip.clone();
            p.setValues(prp.getValues().clone());
            oprps.add(p);
         }
      }
      if (LOGGER.isDebugEnabled()) {
         LOGGER.debug("getMappedPublicParameters - Returning " + oprps.size() + " for window = " + prp.getWindowId() 
               + " QName = " + prp.getQName().toString() + ", ID = " + prp.getName());
      }
      return oprps;
   }

   /**
    * Returns the set of all PRPs with the same parameter names (IDs).
    * Scaffolding code to be thrown away when the URL gen code is complete.
    * 
    * @param id
    * @param vals
    * @return
    */
   public Set<PortalURLPublicParameter> getPRPsForId(String id, String[] vals) {
      Set<PortalURLPublicParameter> oprps = new HashSet<PortalURLPublicParameter>();
      for (PortalURLPublicParameter ip : prps) {
         if (ip.getName().equals(id)) {
            PortalURLPublicParameter p = ip.clone();
            p.setValues(vals.clone());
            oprps.add(p);
         }
      }
      if (LOGGER.isDebugEnabled()) {
         LOGGER.debug("getPRPsForId - Returning " + oprps.size() + " for ID = " + id);
      }
      return oprps;
   }

}
