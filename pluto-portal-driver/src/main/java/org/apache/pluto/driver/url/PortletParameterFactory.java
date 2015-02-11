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

package org.apache.pluto.driver.url;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.pluto.driver.services.portal.PublicRenderParameterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Scott Nicklous
 * 
 * This class bridges between the URL parameter representation and the parameter
 * representation presented through the portlet API. It also bridges between the 
 * JSR 286 and the JSR 362 parameter handling APIs. 
 *
 */
public class PortletParameterFactory {
   private static final Logger LOGGER = LoggerFactory.getLogger(PortletParameterFactory.class);
   private final static boolean isDebug = LOGGER.isDebugEnabled();
   
   PortalURL url;
   
   HashMap<String, ArrayList<PortalURLParameter>> wid2Render;
   HashMap<String, ArrayList<PortalURLParameter>> wid2Action;
   HashMap<String, ArrayList<PortalURLParameter>> wid2Resource;
   
   public PortletParameterFactory(PortalURL url) {
      this.url = url;
   }
   
   private void addParam(Map<String, ArrayList<PortalURLParameter>> map, PortalURLParameter parm) {
      String wid = parm.getWindowId();
      if (!map.keySet().contains(wid)) {
         map.put(wid, new ArrayList<PortalURLParameter>());
      }
      map.get(wid).add(parm);
   }
   
   /**
    * process the URL parameters. Do this as late as possible so that 
    * the servlet rquest parameters get handled properly.
    */
   private void processParams() {
      wid2Render = new HashMap<String, ArrayList<PortalURLParameter>>();
      wid2Action = new HashMap<String, ArrayList<PortalURLParameter>>();
      wid2Resource = new HashMap<String, ArrayList<PortalURLParameter>>();
      
      for (PortalURLParameter parm : url.getParameters()) {
         if (parm.getType().equals(PortalURLParameter.PARAM_TYPE_ACTION)) {
            addParam(wid2Action, parm);
         } else if (parm.getType().equals(PortalURLParameter.PARAM_TYPE_RESOURCE)) {
            addParam(wid2Resource, parm);
         } else {
            addParam(wid2Render, parm);
         }
      }

   }

   /**
    * This V2.0 method returns the private parameters for the given window ID.
    * In the case of a render URL, it returns only the private render parameters.
    * 
    * In the case of an action or resource URL, it returns the action or resource 
    * parameters combined with the render parameters, with the action or resource
    * parameters taking precedence.
    * 
    * Note that the  latter circumstance will only occur with V3.0 portlets.
    *  
    * @param windowId
    * @return
    */
   public Map<String, String[]> getPrivateParameterMap(String windowId) {
      HashMap<String, String[]> parameters = new HashMap<String, String[]>();
      processParams();

      // get the action or resource parameters
      
      if (wid2Action.containsKey(windowId)) {
         for (PortalURLParameter parm : wid2Action.get(windowId)) {
            parameters.put(parm.getName(), parm.getValues().clone());
         }
      } else if (wid2Resource.containsKey(windowId)) {
         for (PortalURLParameter parm : wid2Resource.get(windowId)) {
            parameters.put(parm.getName(), parm.getValues().clone());
         }
      }
      
      // Now merge in the render parameters
      
      if (wid2Render.containsKey(windowId)) {
         for (PortalURLParameter parm : wid2Render.get(windowId)) {
            if (parameters.containsKey(parm.getName())) {
               ArrayList<String> vals = 
                     new ArrayList<String>(Arrays.asList(parameters.get(parm.getName())));
               vals.addAll(Arrays.asList(parm.getValues()));
               parameters.put(parm.getName(), vals.toArray(new String[0]));
            } else {
               parameters.put(parm.getName(), parm.getValues().clone());
            }
         }
      }

      if (isDebug) {
         StringBuffer sb = new StringBuffer();
         sb.append("Dump private Parameter Map:");
         for (String k : parameters.keySet()) {
            sb.append("\nName: " + k + ", Values: ");
            String sep = "";
            for (String v : parameters.get(k)) {
               sb.append(sep + v);
               sep = ", ";
            }
         }
         LOGGER.debug(sb.toString());
      }
      return parameters;
   }
   
   /**
    * Returns the active (= have been set) public render parameters for the
    * given window ID.
    *  
    * @param windowId
    * @return
    */
   public Map<String, String[]> getPublicParameterMap(String windowId) {
      HashMap<String, String[]> parameters = new HashMap<String, String[]>();

      PublicRenderParameterMapper mapper = url.getPublicRenderParameterMapper();
      
      // get the active PRPs only
      
      List<PortalURLPublicParameter> prps = mapper.getPRPsForWindow(windowId, true);
      for (PortalURLPublicParameter prp : prps) {
         parameters.put(prp.getName(), prp.getValues().clone());
      }
      
      if (isDebug) {
         LOGGER.debug("getPublicParameterMap returning " + parameters.size() + " parameters.");
      }
      
      return parameters;
   }

   /**
    * This is a V2 method to get the private render parameter map during
    * a resource request.
    * 
    * @return
    */
   public Map<String, String[]> getResourceRenderParameterMap(String windowId) {
      HashMap<String, String[]> parameters = new HashMap<String, String[]>();

      processParams();
      
      if (wid2Render.containsKey(windowId)) {
         for (PortalURLParameter parm : wid2Render.get(windowId)) {
            parameters.put(parm.getName(), parm.getValues().clone());
         }
      }
      
      return parameters;
   }

}
