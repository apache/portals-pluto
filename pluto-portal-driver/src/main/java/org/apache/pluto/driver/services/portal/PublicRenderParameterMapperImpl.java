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

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
   ArrayList<PortalURLPublicParameter> prpList = new ArrayList<PortalURLPublicParameter>();
   
   // Maps the PRP QName to a set of public render parameters
   private final Map<QName, List<PortalURLPublicParameter>> qn2PRP =
                     new HashMap<QName, List<PortalURLPublicParameter>>();
   private final ArrayList<QName> qnList = new ArrayList<QName>();
   
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
                     
                     // Add to set of all PRPs for page
                     prpList.add(pupp);

                     // Add PRP to the QName to PRP mapping
                     if (qn2PRP.containsKey(qn)) {
                        qn2PRP.get(qn).add(pupp);
                     } else {
                        List<PortalURLPublicParameter> s = new ArrayList<PortalURLPublicParameter>();
                        s.add(pupp);
                        qn2PRP.put(qn, s);
                        qnList.add(qn);
                     }
                     
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

   
   public List<PortalURLPublicParameter> getPublicParameterGroup(int index) {
      List<PortalURLPublicParameter> oprps = new ArrayList<PortalURLPublicParameter>();
      for (PortalURLPublicParameter prp : qn2PRP.get(qnList.get(index))) {
         PortalURLPublicParameter p = prp.clone();
         if (!prp.isRemoved()) {
            p.setValues(prp.getValues().clone());
            oprps.add(p);
         }
      }
      if (LOGGER.isDebugEnabled()) {
         LOGGER.debug("getPublicParameterSet - Returning " + oprps.size() + " public render parameters");
      }
      return oprps;
   }

   public int getNumberOfGroups() {
      return qnList.size();
   }

   public int getIndex(PortalURLPublicParameter prp) {
      return qnList.indexOf(prp.getQName());
   }

   public int getIndex(String windowId, String identifier) {
      PortalURLPublicParameter tmpPRP = new PortalURLPublicParameter(windowId, identifier, null);
      int ind = prpList.indexOf(tmpPRP);
      if (ind < 0) {
         LOGGER.warn("Public render parameter with window ID = " + windowId + ", ID = " + identifier + " could not be found.");
      } else {
         QName qn = prpList.get(ind).getQName();
         ind = qnList.indexOf(qn);
      }
      return ind;
   }

   public int getIndex(QName qname) {
      return qnList.indexOf(qname);
   }

   public void setValues(int index, String[] values) {
      List<PortalURLPublicParameter> oprps = qn2PRP.get(qnList.get(index));
      for (PortalURLPublicParameter prp : oprps) {
         prp.setValues(values.clone());
      }
   }

   public String[] getValues(int index) {
      List<PortalURLPublicParameter> oprps = qn2PRP.get(qnList.get(index));
      return oprps.get(0).getValues().clone();
   }

   public void setRemoved(int index, boolean removed) {
      List<PortalURLPublicParameter> oprps = qn2PRP.get(qnList.get(index));
      for (PortalURLPublicParameter prp : oprps) {
         prp.setRemoved(removed);
      }
   }

   public boolean getRemoved(int index) {
      List<PortalURLPublicParameter> oprps = qn2PRP.get(qnList.get(index));
      return oprps.get(0).isRemoved();
   }

   public List<Integer> getActiveIndexes() {
      ArrayList<Integer> inds = new ArrayList<Integer>();
      for (QName qn : qnList) {
         List<PortalURLPublicParameter> oprps = qn2PRP.get(qn);
         if (!oprps.get(0).isRemoved()) {
            inds.add(qnList.indexOf(qn));
         }
      }
      return inds; 
   }

}
