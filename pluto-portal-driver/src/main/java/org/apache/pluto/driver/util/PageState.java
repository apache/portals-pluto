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

package org.apache.pluto.driver.util;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletConfig;
import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.services.portal.PublicRenderParameterMapper;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortalURLParameter;
import org.apache.pluto.driver.url.PortalURLPublicParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;

/**
 * @author Scott Nicklous
 * @author Neil Griffin
 * 
 *         This is a utility class that collects all data needed by the portlet hub in one location. The data is
 *         formatted appropriately for transmission to the client.
 *
 */
public class PageState {
   private final Logger                     LOGGER  = LoggerFactory.getLogger(PageState.class);

   private CsrfToken                        csrfToken;
   private DriverConfiguration              drvrConfig;
   private PageConfig                       pageConfig;
   private PortalRequestContext             portalRC;
   private PortalURL                        portalUrl;
   private ServletContext                   servletContext;
   private Map<String, RenderData>          renderDataMap;

   /**
    * Constructor. Access the classes containing the necessary data.
    * 
    * @param request
    */
   public PageState(HttpServletRequest request) {
      portalRC = PortalRequestContext.getContext(request);
      portalUrl = portalRC.getRequestedPortalURL();
      drvrConfig = (DriverConfiguration) portalRC.getServletContext().getAttribute(AttributeKeys.DRIVER_CONFIG);
      servletContext = portalRC.getServletContext();
      pageConfig = portalUrl.getPageConfig(servletContext);
      csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
   }

   public PageState(HttpServletRequest request, Map<String, RenderData> renderDataMap) {
      this(request);
      this.renderDataMap = renderDataMap;
   }

   public String getCsrfParameterName() {
      if (csrfToken == null) {
         return "";
      }

      return csrfToken.getParameterName();
   }

   public String getCsrfParameterValue() {
      if (csrfToken == null) {
         return "";
      }

      return csrfToken.getToken();
   }

   /**
    * Returns the portal URL parameters that are set on the current URL.
    * 
    * @return
    */
   public Collection<PortalURLParameter> getParameters() {
      return portalUrl.getParameters();
   }

   /**
    * Returns the public render parameters set on the current URL.
    * 
    * @return
    */
   public Map<String, String[]> getPublicParameters() {
      Map<String, String[]> tmp = new HashMap<String, String[]>();
      PublicRenderParameterMapper prpMapper = portalUrl.getPublicRenderParameterMapper();
      if (prpMapper != null) {
         for (int ind : prpMapper.getActiveIndexes()) {
            String name = prpMapper.getPublicParameterGroup(ind).get(0).getName();
            String[] vals = prpMapper.getValues(ind);
            tmp.put(name, vals);
         }
      }
      return tmp;
   }

   /**
    * Returns a collection containing the portlet IDs for the portlets on the page.
    * 
    * @return
    */
   public Collection<String> getPortletIds() {
      return pageConfig.getPortletIds();
   }

   /**
    * Returns a Pluto namespace string for the input portlet ID.
    * 
    * @param portletId
    * @return namespace string for the portlet ID
    */
   public String getNameSpace(String portletId) {
      StringBuffer ns = new StringBuffer("Pluto_");
      for (int ii = 0; ii < portletId.length(); ii++) {
         if (Character.isJavaIdentifierPart(portletId.charAt(ii))) {
            ns.append(portletId.charAt(ii));
         } else {
            ns.append("_");
         }
      }
      ns.append("_");
      return ns.toString();
   }

   /**
    * Returns the public render parameter names for the portlet ID as a set.
    * 
    * @param portletId
    * @return Set of string public render parameter names
    */
   public Set<String> getPRPNames(String portletId) {
      Set<String> prpnames = new HashSet<String>();
      PortletConfig pc = null;

      try {
         pc = drvrConfig.getPortletConfig(portletId);
         Enumeration<String> prps = pc.getPublicRenderParameterNames();
         while (prps.hasMoreElements()) {
            String prp = prps.nextElement();
            prpnames.add(prp);
         }
      } catch (Exception e) {
      }
      return prpnames;
   }

   /**
    * Returns the public render parameter names for the portlet ID as a delimited string that can be used in a JSON
    * array.
    * 
    * @param portletId
    * @return Delimited string of public render parameter names
    */
   public String getPRPNamesAsString(String portletId) {
      PortletConfig pc = null;
      StringBuffer prpstring = new StringBuffer();
      ;

      String sep = "";
      try {
         pc = drvrConfig.getPortletConfig(portletId);
         Enumeration<String> prps = pc.getPublicRenderParameterNames();
         while (prps.hasMoreElements()) {
            String prp = prps.nextElement();
            prpstring.append(sep + "\"" + prp + "\"");
            sep = ",";
         }
      } catch (Exception e) {
      }
      return prpstring.toString();
   }

   /**
    * Returns the supported portlet mode names for the portlet ID as a delimited string that can be used in a JSON
    * array.
    * 
    * @param portletId
    * @return Delimited string of portlet mode names
    */
   public String getPortletModesAsString(String portletId) {
      StringBuffer pmstring = new StringBuffer();
      try {
         Set<PortletMode> allowedPMs = drvrConfig.getSupportedPortletModes(portletId);
         String sep = "";
         for (PortletMode pm : allowedPMs) {
            pmstring.append(sep + "\"" + pm.toString() + "\"");
            sep = ",";
         }
      } catch (Exception e) {
      }
      return pmstring.toString();
   }

   /**
    * Returns the supported window state names for the portlet ID as a delimited string that can be used in a JSON
    * array.
    * 
    * @param portletId
    * @return Delimited string of window state names
    */
   public String getWindowStatesAsString(String portletId) {
      StringBuffer wsstring = new StringBuffer();
      try {
         Set<WindowState> allowedWSs = drvrConfig.getSupportedWindowStates(portletId, "text/html");
         String sep = "";
         for (WindowState ws : allowedWSs) {
            wsstring.append(sep + "\"" + ws.toString() + "\"");
            sep = ",";
         }
      } catch (Exception e) {
      }
      return wsstring.toString();
   }

   /**
    * Returns the current portlet mode for the portlet
    * 
    * @param portletId
    * @return
    */
   public String getPortletMode(String portletId) {
      return portalUrl.getPortletMode(portletId).toString();
   }

   /**
    * Returns the current window state for the portlet
    * 
    * @param portletId
    * @return
    */
   public String getWindowState(String portletId) {
      return portalUrl.getWindowState(portletId).toString();
   }

   /**
    * Returns a relative base base as needed by the portlet hub to generate URLs. Must be encoded by the caller.
    * 
    * @return
    */
   public String getUrlBase() {
      StringBuffer ub = new StringBuffer();
      ub.append(portalUrl.getServletPath().startsWith("/") ? "" : "/").append(portalUrl.getServletPath()).append(portalUrl.getRenderPath());
      return ub.toString();
   }

   /**
    * Returns the page state needed by the portlet hub as a JSON string suitable for transport to the client.
    * 
    * @return JSON string representing the current page state
    */
   public String toJSONString() {
      StringBuffer json = new StringBuffer(1024);
      json.append("{\"portlets\":{");

      Collection<PortalURLParameter> pups = getParameters();
      PublicRenderParameterMapper mapper = portalUrl.getPublicRenderParameterMapper();

      boolean sep = false;
      for (String pid : getPortletIds()) {
         if (sep) {
            json.append(",");
         }
         sep = true;
         json.append("\"" + getNameSpace(pid) + "\":{");
         json.append("\"state\":{");
         json.append("\"parameters\":{");

         // Add the portlet parameters
         String c1 = "\"";
         for (PortalURLParameter pup : pups) {
            if (pup.getWindowId().equals(pid)) {
               json.append(c1 + pup.getName() + "\":[");
               String c2 = "";
               for (String val : pup.getValues()) {
                  json.append(c2 + "\"" + val + "\"");
                  c2 = ",";
               }
               json.append("]");
               c1 = ",\"";
            }
         }

         // Add the public render parameter values for this portlet

         for (PortalURLPublicParameter prp : mapper.getPRPsForWindow(pid, true)) {
            json.append(c1 + prp.getName() + "\":[");
            String c2 = "";
            for (String val : prp.getValues()) {
               json.append(c2 + " \"" + val + "\"");
               c2 = ",";
            }
            json.append("]");
            c1 = ",\"";
         }

         json.append("}, ");
         json.append("\"portletMode\":\"" + getPortletMode(pid) + "\",");
         json.append("\"windowState\":\"" + getWindowState(pid) + "\"");
         json.append("},");
         json.append("\"pubParms\":{");

         String c2 = "";
         for (PortalURLPublicParameter prp : mapper.getPRPsForWindow(pid, false)) {
            int group = mapper.getIndex(prp);
            json.append(c2);
            json.append("\"");
            json.append(prp.getName());
            json.append("\":\"");
            json.append(String.valueOf(group));
            json.append("\"");
            c2 = ",";
         }
         json.append("},");

         json.append("\"allowedPM\":[" + getPortletModesAsString(pid) + "],");
         json.append("\"allowedWS\":[" + getWindowStatesAsString(pid) + "],");
         json.append("\"renderData\":{");

         RenderData renderData = null;
         if (renderDataMap != null) {
            renderData = renderDataMap.get(pid);
         }
         if (renderData == null) {
            json.append("\"content\":null,");
            json.append("\"mimeType\":\"text/plain\"");
         } else {
            json.append("\"content\":\"");
            String content = StringEscapeUtils.escapeJson(renderData.getContent());
            json.append(content);
            json.append("\",");
            json.append("\"mimeType\":\"");
            json.append(renderData.getContentType());
            json.append("\"");
         }
         json.append("},");
         json.append("\"urlpid\":\"" + pid + "\"");
         json.append("}");
      }

      json.append("},\"prpMap\":{");
      String sep1 = "";
      for (int ii = 0; ii < mapper.getNumberOfGroups(); ii++) {
         json.append(sep1).append("\"").append(String.valueOf(ii)).append("\":{");
         sep1 = ",";
         String sep2 = "";
         for (PortalURLPublicParameter prp : mapper.getPublicParameterGroup(ii)) {
            json.append(sep2).append("\"").append(getNameSpace(prp.getWindowId())).append("\":\"").append(prp.getName()).append("\"");
            sep2 = ",";
         }
         json.append("}");
      }
      json.append("}}");

      if (LOGGER.isDebugEnabled()) {
         LOGGER.debug("Resulting json string:\n   " + json);
      }

      return json.toString();
   }

   /**
    * This method returns the json string encoded in a manner compatible with
    * the decodeUriComponent JavaScript decode function on the client. Encoding is only
    * performed if json contains dangerous characters.
    * 
    * @return The encoded json string representing the page state.
    */
   public String toEncodedJSONString() {

      String json = toJSONString();
      String ejson = json;

//      boolean mustEscape = json.matches(".*[<>/].*");
      boolean mustEscape = json.indexOf('<') >= 0;
      if (mustEscape) {
         ejson = ejson.replace("<", "%3C");
//         ejson = ejson.replace(">", "%3E");
//         ejson = ejson.replace("/", "%2F");
      }

      if (LOGGER.isDebugEnabled()) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Must escape: ").append(mustEscape);
         txt.append(", original json contains escapes: ").append(json.matches(".*(%3C|%3E|%2F).*"));
         txt.append("\nPreprocessed json string:\n   " + json);
         txt.append("\nEncoded json string:\n   " + ejson);
         LOGGER.debug(txt.toString());
      }
      
      return ejson;
   }
}
