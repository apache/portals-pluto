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

package org.apache.pluto.driver.services.container;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.pluto.driver.services.portal.PublicRenderParameterMapper;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortalURLParameter;
import org.apache.pluto.driver.url.PortalURLPublicParameter;
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
   
   public PortletParameterFactory(PortalURL url) {
      this.url = url;
   }

   public Map<String, String[]> getPrivateParameterMap(String windowId) {
      HashMap<String, String[]> parameters = new HashMap<String, String[]>();
//       if (useRequestParameters) {
//          parameters.putAll(servletRequest.getParameterMap());
//       }
//       for (Map.Entry<String, String[]> entry : getPrivateRenderParameterMap()
//             .entrySet()) {
//          String[] values = parameters.get(entry.getKey());
//          if (values == null) {
//             parameters.put(entry.getKey(), entry.getValue());
//          } else {
//             String[] copy = new String[values.length + entry.getValue().length];
//             System.arraycopy(values, 0, copy, 0, values.length);
//             System.arraycopy(entry.getValue(), 0, copy, values.length,
//                   entry.getValue().length);
//             parameters.put(entry.getKey(), copy);
//          }
//       }
      for (PortalURLParameter parm : url.getParameters()) {
         if (windowId.equals(parm.getWindowId()) 
               && PortalURLParameter.PARAM_TYPE_RENDER.equals(parm.getType())) {
            String[] values = parameters.get(parm.getName());
            if (values == null) {
               parameters.put(parm.getName(), parm.getValues());
            } else {
               String[] copy = new String[values.length
                     + parm.getValues().length];
               System.arraycopy(values, 0, copy, 0, values.length);
               System.arraycopy(parm.getValues(), 0, copy, values.length,
                     parm.getValues().length);
               parameters.put(parm.getName(), copy);
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
   
   public Map<String, String[]> getPublicParameterMap(String windowId) {
      HashMap<String, String[]> parameters = new HashMap<String, String[]>();
      PublicRenderParameterMapper mapper = url.getPublicRenderParameterMapper();
      // get the active PRPs only
      List<PortalURLPublicParameter> prps = mapper.getPRPsForWindow(windowId, true);
      for (PortalURLPublicParameter prp : prps) {
         parameters.put(prp.getName(), prp.getValues().clone());
      }
      return parameters;
   }

}
