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
package org.apache.pluto.driver.url.impl;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletMode;
import javax.portlet.ResourceURL;
import javax.portlet.WindowState;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.services.portal.PublicRenderParameterMapper;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortalURL.URLType;
import org.apache.pluto.driver.url.PortalURLParameter;
import org.apache.pluto.driver.url.PortalURLParser;
import org.apache.pluto.driver.url.PortalURLPublicParameter;

/**
 * @version 1.0
 * @since Sep 30, 2004
 */
public class PortalURLParserImpl implements PortalURLParser {

   /** Logger. */
   private static final Logger LOG = LoggerFactory.getLogger(PortalURLParserImpl.class);

   /** The singleton parser instance. */
   private static final PortalURLParser PARSER = new PortalURLParserImpl();


   // Constants used for Encoding/Decoding ------------------------------------

   private static final String PREFIX = "__";
   private static final String DELIM = "_";
   private static final String PORTLET_ID = "pd";
   private static final String RESOURCE_ID = "ri";
   private static final String CACHE_LEVEL = "cl";
   private static final String RENDER_PARAM = "rp";
   private static final String PUBLIC_RENDER_PARAM = "sp";
   private static final String WINDOW_STATE = "ws";
   private static final String PORTLET_MODE = "pm";
   
   // The delimiter & special chars for the value encoding are chosen
   // from the URL reserved delimiter characters that ARE ENCODED by the URLEncoder
   // so that they will not appear encoded parameter names or values.
   // See RFC 3986 & URLEncoder documentation.
   private static final String VALUE_DELIM = ":";
   private static final String VALUE_NULL = ",";

   private static final String ACTION = "ac";
   private static final String RESOURCE = "rs";
   private static final String AJAX_ACTION = "aa";       // new for portlet spec 3
   private static final String PARTIAL_ACTION = "pa";    // new for portlet spec 3
   private static final String RENDER = "re";            // new for portlet spec 3
   
   private static final String ACTION_PARAM = "av";      // new for portlet spec 3
   private static final String RESOURCE_PARAM = "rv";    // new for portlet spec 3


//    //This is a list of characters that need to be encoded  to be protected
//    //The ? is necessary to protect URI's with a query portion that is being passed as a parameter
//    private static final String[][] ENCODINGS = new String[][] {
//       new String[] { "_",  "0x1" },
//       new String[] { ".",  "0x2" },
//       new String[] { "/",  "0x3" },
//       new String[] { "\r", "0x4" },
//       new String[] { "\n", "0x5" },
//       new String[] { "<",  "0x6" },
//       new String[] { ">",  "0x7" },
//       new String[] { " ",  "0x8" },
//       new String[] { "#",  "0x9" },
//       new String[] { "?",  "0xa" },
//       new String[] { "\\", "0xb" },
//       new String[] { "%",  "0xc" },
//    };

   // Constructor -------------------------------------------------------------

   /**
    * Private constructor that prevents external instantiation.
    */
   private PortalURLParserImpl() {
      // Do nothing.
   }

   /**
    * Returns the singleton parser instance.
    * @return the singleton parser instance.
    */
   public static PortalURLParser getParser() {
      return PARSER;
   }


   // Public Methods ----------------------------------------------------------

   /**
    * Parse a servlet request to a portal URL.
    * @param request  the servlet request to parse.
    * @return the portal URL.
    */
   public PortalURL parse(HttpServletRequest request) {

      if (LOG.isDebugEnabled()) {
         LOG.debug("Parsing URL: " + request.getRequestURI());
      }

      String contextPath = request.getContextPath();
      String servletName = request.getServletPath();

      String urlBase = request.getScheme()+"://" + request.getServerName() + ":" + request.getServerPort();
      // Construct portal URL using info retrieved from servlet request.
      RelativePortalURLImpl portalURL =  new RelativePortalURLImpl(urlBase, contextPath, servletName, this, request);

      // Support added for filter.  Should we separate into a different impl?
      String pathInfo = request.getPathInfo();
      if (pathInfo == null) {
         if(servletName.contains(".jsp") && !servletName.endsWith(".jsp")) {
            int idx = servletName.indexOf(".jsp")+".jsp".length();
            pathInfo = servletName.substring(idx);
            servletName = servletName.substring(0, idx);
            portalURL = new RelativePortalURLImpl(urlBase, contextPath, servletName, this, request);
         } else {
            return portalURL;
         }
      }

      if (LOG.isDebugEnabled()) {
         LOG.debug("Parsing request pathInfo: " + pathInfo);
      }

      // Need to set the render path (= page) and PRP mapper before the rest of the URL is parsed
      StringBuilder renderPath = new StringBuilder();
      if (pathInfo.charAt(0) != '/') {
         renderPath.append('/');
      }

      int ind = pathInfo.indexOf("/" + PREFIX);
      if (ind < 0) {
         // there are no parameters to process
         renderPath.append(pathInfo);
         pathInfo = "";
      } else {
         // parameters, etc. remain to be processed
         renderPath.append(pathInfo.substring(0, ind));
         pathInfo = pathInfo.substring(ind);
      }

      portalURL.setRenderPath(renderPath.toString());
      if (LOG.isDebugEnabled()) {
         LOG.debug("Parse: renderPath: " + renderPath.toString() + ",  pathInfo: " + pathInfo);
      }

      // Set up public render parameter mapper & portlet ID list
      
      ServletContext sc = request.getServletContext();
      DriverConfiguration dc = (DriverConfiguration) sc.getAttribute(AttributeKeys.DRIVER_CONFIG);
      PublicRenderParameterMapper prpm = dc.getPublicRenderParameterService()
            .getPRPMapper(renderPath.toString());
      portalURL.setPublicRenderParameterMapper(prpm);
      Collection<String> pids = dc.getPageConfig(renderPath.toString()).getPortletIds();
      portalURL.setPortletIds(pids);

      // Extract the version info for the portlets on the page and store in URL
      
      StringBuilder vstr = new StringBuilder();
      if (LOG.isDebugEnabled()) {
         vstr.append("Portlet Versions: ");
      }
      for (String pid : pids) {
         String appName = PortletWindowConfig.fromId(pid).getContextPath();
         try {
            String pv = dc.getPortletRegistryService().getPortletApplication(appName).getVersion();
            portalURL.setVersion(pid, pv);
            if (LOG.isDebugEnabled()) {
               vstr.append(pid).append(" = ").append(pv).append(", ");
            }
         } catch (Exception e) {
            LOG.error("Portlet application definition could not be retrieved for " + appName);
         }
      }
      if (LOG.isDebugEnabled()) {
         LOG.debug(vstr.toString());
      }

      // Tokenize the rest and process the tokens
      ArrayList<String> portletIds = new ArrayList<String>();
      if (pathInfo.length() > 2) {
         String[] tokens = pathInfo.split("/" + PREFIX);
         for (String t : tokens) {

            // vals contains the component values of the token after the type
            String type, val;
            String[] vals;
            if (t.length() < 3) {
               // LOG.warn("Token >>" + t + "<< is too short!! ");
               continue;
            } else {
               type = t.substring(0, 2);
               val = t.substring(2);
               vals = val.split(DELIM);
//                for (int ii = 0; ii < vals.length; ii++) {
//                   vals[ii] = decodeCharacters(vals[ii]);
//                }
            }

            // If the first value is numeric, attempt to dereference the index to obtain the portlet ID.
            // The code assumes that the portlet ID table in the URL appears directly after the render path. 
            int index = -1;
            String pid = null;
            if ((vals[0].length() > 0) && vals[0].matches("\\d+")) {
               try {
                  index = Integer.parseInt(vals[0]);
                  if ((index >= 0) && (index < portletIds.size())) {
                     pid = portletIds.get(index);
                  }
               } catch (Exception e) {
                  LOG.error("error parsing URL pid reference token. Token: " + vals[0] + ", exception: " + e.toString());
               }
            }

            // Get the portlet IDs & reference numbers. The portlet IDs are URL encoded.
            if (type.equals(PORTLET_ID)) {
               portletIds.add(Integer.parseInt(vals[1]), urlDecode(vals[0]));
               continue;
            } 

            // Cacheability definition: portalURL.setCacheability().
            if (type.equals(CACHE_LEVEL)) {
               portalURL.setCacheability(urlDecode(vals[0]));
               continue;
            }

            // ResourceID definition: portalURL.setResourceID().
            if (type.equals(RESOURCE_ID)) {
               portalURL.setResourceID(urlDecode(vals[0]));
               continue;
            }

            // Resource window definition: portalURL.setResourceWindow().
            if (type.equals(RESOURCE)) {
               portalURL.setTargetWindow(pid);
               portalURL.setType(URLType.Resource);
               continue;
            }

            // Render window definition: portalURL.setResourceWindow().
            if (type.equals(RENDER)) {
               portalURL.setTargetWindow(pid);
               portalURL.setType(URLType.Render);
               continue;
            }

            // Action window definition: portalURL.setActionWindow().
            if (type.equals(ACTION)) {
               portalURL.setTargetWindow(pid);
               portalURL.setType(URLType.Action);
               continue;
            }

            // Ajax Action window definition: portalURL.setActionWindow().
            if (type.equals(AJAX_ACTION)) {
               portalURL.setTargetWindow(pid);
               portalURL.setType(URLType.AjaxAction);
               continue;
            }

            // Partial Action window definition: portalURL.setActionWindow().
            if (type.equals(PARTIAL_ACTION)) {
               portalURL.setTargetWindow(pid);
               portalURL.setType(URLType.PartialAction);
               continue;
            }

            // Window state definition: portalURL.setWindowState().
            if (type.equals(WINDOW_STATE)) {
               portalURL.setWindowState(pid, new WindowState(urlDecode(vals[1])));
               continue;
            }

            // Portlet mode definition: portalURL.setPortletMode().
            if (type.equals(PORTLET_MODE)) {
               portalURL.setPortletMode(pid, new PortletMode(urlDecode(vals[1])));
               continue;
            }

            // The remaining types deal with parameters, so extract the
            // parameter name and values.
            StringBuilder dbgstr = new StringBuilder();
            if (LOG.isDebugEnabled()) {
               dbgstr.append("Decoding parameter: window ID=").append(pid)
                     .append(", name/value=").append(vals[1]);
            }

            String values = vals[1];
            if (type.equals(PUBLIC_RENDER_PARAM)) {
               if (vals.length != 3) {
                  LOG.warn("Bad PRP Token: " + val);  
               } else {
                  values = vals[2];
               }
            }

            String[] pVals = values.split(VALUE_DELIM);
            String[] paramValues = new String[0];
            String paramName = "";
            if (pVals.length > 1) {
               for (int i = 0; i < pVals.length; i++){
                  if (pVals[i].equals(VALUE_NULL)) {
                     pVals[i] = null;
                  } else {
                     pVals[i] = urlDecode(pVals[i]);
                  }
               }
            }
            
            if (pVals.length <= 1 || pVals[0] == null) {
               LOG.warn("Bad parameter token: " + values);
            } else {
               paramName = pVals[0];
               paramValues = Arrays.copyOfRange(pVals, 1, pVals.length);
            }
            
            if (LOG.isDebugEnabled()) {
               dbgstr.append(", paramName=").append(paramName);
               dbgstr.append(", paramValues=").append(Arrays.toString(paramValues));
               LOG.debug(dbgstr.toString());
            }

            // Portal URL parameter: portalURL.addParameter().
            if(type.equals(RENDER_PARAM)) {
               portalURL.addParameter(new PortalURLParameter(pid, paramName, paramValues));
               continue;
            }

            // Portal URL parameter: portalURL.addParameter().
            if(type.equals(ACTION_PARAM)) {
               portalURL.addParameter(new PortalURLParameter(pid, paramName, paramValues, 
                     PortalURLParameter.PARAM_TYPE_ACTION));
               continue;
            }

            // Portal URL parameter: portalURL.addParameter().
            if(type.equals(RESOURCE_PARAM)) {
               portalURL.addParameter(new PortalURLParameter(pid, paramName, paramValues,
                     PortalURLParameter.PARAM_TYPE_RESOURCE));
               continue;
            }

            //set public parameter in portalURL
            if (type.equals(PUBLIC_RENDER_PARAM)){
               PublicRenderParameterMapper mapper = portalURL.getPublicRenderParameterMapper();
               int prpGroup = mapper.getIndex(pid, paramName);
               if (prpGroup >= 0) {
                  mapper.setValues(prpGroup, paramValues);
               } else {
                  StringBuilder sb = new StringBuilder("Could not find public render parameter group for portlet ID=");
                  sb.append(pid).append(", parameter name=").append(paramName);
                  LOG.warn(sb.toString());
               }
               continue;
            }
         }
      }

      // If we're dealing with a render request (with or without target portlet),
      // we can parse the servlet request parameters directly.
      if (portalURL.getType() == URLType.Render || portalURL.getType() == URLType.Portal) {
         portalURL.handleServletRequestParams();
      }
      
      if (LOG.isDebugEnabled()) {
         LOG.debug("Found " + portletIds.size() + " IDs: " + Arrays.toString(portletIds.toArray()));
      }

      // Return the portal URL.
      return portalURL;
   }


   /**
    * Converts a portal URL to a URL string.
    * @param portalURL  the portal URL to convert.
    * @return a URL string representing the portal URL.
    */
   public String toString(RelativePortalURLImpl portalURL) {

      StringBuilder buffer = new StringBuilder();
      String targetWindow = portalURL.getTargetWindow();
      
      // Make sure the servlet parameters have been processed
      portalURL.handleServletRequestParams();

      // Append the server URI and the servlet path.
      buffer.append(portalURL.getServletPath().startsWith("/")?"":"/")
      .append(portalURL.getServletPath());

      // Start the pathInfo with the path to the render URL (page).
      if (portalURL.getRenderPath() != null) {
         buffer.append(portalURL.getRenderPath());
      }

      // Add the portletIds with references
      ArrayList<String> pids = new ArrayList<String>();
      for (String pid : portalURL.getPortletIds()) {
         pids.add(pid);
         buffer.append("/").append(PREFIX).append(PORTLET_ID);
         try {
            buffer.append(URLEncoder.encode(pid, "UTF-8"));
         } catch(Exception e) {
            LOG.warn("Could not encode pid=" + pid);
         }
         buffer.append(DELIM).append(String.valueOf(pids.indexOf(pid)));
      }

      //Append the resource window definition, if it exists.
      if (portalURL.getType() == URLType.Resource) {
         int index = pids.indexOf(targetWindow);
         if (index < 0) {
            LOG.warn("resource window not found in portlet ID list. PID = " + targetWindow);
         } else {
            buffer.append("/");
            buffer.append(PREFIX).append(RESOURCE).append(String.valueOf(index));
         }
      }

      //Append the render window definition, if it exists.
      if (portalURL.getType() == URLType.Render) {
         int index = pids.indexOf(targetWindow);
         if (index < 0) {
            LOG.warn("render window not found in portlet ID list. PID = " + targetWindow);
         } else {
            buffer.append("/");
            buffer.append(PREFIX).append(RENDER).append(String.valueOf(index));
         }
      }
      
      // Append the action window definition, if it exists.
      if (portalURL.getType() == URLType.Action) {
         int index = pids.indexOf(targetWindow);
         if (index < 0) {
            LOG.warn("Action window not found in portlet ID list. PID = " + targetWindow);
         } else {
            buffer.append("/");
            buffer.append(PREFIX).append(ACTION).append(String.valueOf(index));
         }
      }

      String reswin = null;
      if (portalURL.getType() == URLType.Resource) {
         if (portalURL.getCacheability() != null) {
            buffer.append("/");
            buffer.append(PREFIX).append(CACHE_LEVEL)
                  .append(urlEncode(portalURL.getCacheability()));
         }
         if (portalURL.getResourceID() != null) {
            buffer.append("/");
            buffer.append(PREFIX).append(RESOURCE_ID)
                  .append(urlEncode(portalURL.getResourceID()));
         }
         
         // if cacheability = FULL, we're done. For PORTLET, set
         // the resource window so that the only the state for the
         // target portlet is set.
         
         if (portalURL.getCacheability().equals(ResourceURL.FULL)) {
            return buffer.toString();
         } else if (portalURL.getCacheability().equals(ResourceURL.PORTLET)) {
            reswin = portalURL.getTargetWindow();
         }
      }

      // Append portlet mode definitions.
      for (String pid : portalURL.getPortletModes().keySet()) {
         
         // special handling for Cacheability = PORTLET
         if (reswin != null && !reswin.equals(pid)) {
            continue;
         }
         
         int index = pids.indexOf(pid);
         PortletMode pm = portalURL.getPortletMode(pid);
         if (index < 0) {
            LOG.warn("Window not found in portlet ID list. PID = " + pid + ", PM = " + pm.toString());
            LOG.warn("portlet IDs in map: " + Arrays.toString(pids.toArray()));
         } else {
            buffer.append("/").append(PREFIX).append(PORTLET_MODE)
            .append(String.valueOf(index)).append(DELIM).append(urlEncode(pm.toString()));
         }
      }

      // Append window state definitions.
      for (String pid : portalURL.getWindowStates().keySet()) {

         // special handling for Cacheability = PORTLET
         if (reswin != null && !reswin.equals(pid)) {
            continue;
         }
         
         int index = pids.indexOf(pid);
         WindowState ws = portalURL.getWindowState(pid);
         if (index < 0) {
            LOG.warn("Window not found in portlet ID list. PID = " + pid + ", WS = " + ws.toString());
         } else {
            buffer.append("/").append(PREFIX).append(WINDOW_STATE)
            .append(String.valueOf(index)).append(DELIM).append(urlEncode(ws.toString()));
         }
      }

      // Append action and render parameters.
      for (PortalURLParameter param : portalURL.getParameters()) {

         // special handling for Cacheability = PORTLET
         if (reswin != null && !reswin.equals(param.getWindowId())) {
            continue;
         }

         int index = pids.indexOf(param.getWindowId());
         if (index < 0) {
            LOG.warn("Window not found in portlet ID list. PID = " + param.getWindowId() + ", Param name = " + param.getName());
            continue;
         }

         // Encode render params as a part of the URL.
         if (param.getName() != null && param.getValues() != null
               && param.getValues().length > 0) {
            String valueString = encodeMultiValues(param.getValues());
            if (valueString.length() > 0) {
               String ptype = RENDER_PARAM;
               if (param.getType().equals(PortalURLParameter.PARAM_TYPE_ACTION)) {
                  ptype = ACTION_PARAM;
               } else if (param.getType().equals(PortalURLParameter.PARAM_TYPE_RESOURCE)) {
                  ptype = RESOURCE_PARAM;
               }
               buffer.append("/").append(PREFIX).append(ptype)
               .append(String.valueOf(index)).append(DELIM).append(urlEncode(param.getName()))
               .append(VALUE_DELIM).append(valueString);
            }
         }
      }

      // Add the public render parameters, retaining the grouping information and 
      // the parameter names for each portlet. 
      PublicRenderParameterMapper mapper = portalURL.getPublicRenderParameterMapper();
      List<Integer> activeIndexes = mapper.getActiveIndexes();

      // special handling for Cacheability = PORTLET
      if (reswin != null) {
         List<PortalURLPublicParameter> pups = mapper.getPRPsForWindow(reswin, true);
         activeIndexes = new ArrayList<Integer>();
         for (PortalURLPublicParameter pup : pups) {
            activeIndexes.add(mapper.getIndex(pup));
         }
      }
      
      for (int i : activeIndexes) {
         String[] values = mapper.getValues(i);
         String valstr = encodeMultiValues(values);
         
         // the values for the PRP group need only appear in the URL once
         List<PortalURLPublicParameter> prplist = mapper.getPublicParameterGroup(i);
         if (prplist.size() > 0) {
            PortalURLPublicParameter prp = prplist.get(0);
            int index = pids.indexOf(prp.getWindowId());
            if (index >= 0) {
               buffer.append("/").append(PREFIX).append(PUBLIC_RENDER_PARAM)
               .append(String.valueOf(index)).append(DELIM)
               .append(String.valueOf(i)).append(DELIM)
               .append(urlEncode(prp.getName())).append(VALUE_DELIM)
               .append(valstr);
            } else {
               LOG.warn("window ID not on page for public render parameter: " + prp.toString());
            }
         }

      }

      // Construct the string representing the portal URL.
      return buffer.toString();
   }

   // Private Encoding/Decoding Methods ---------------------------------------

//    private static void encode(StringBuilder url){
//       replaceChar(url,"|","%7C");
//       replaceChar(url,"\"","%22");
//    }
// 
//    private static void replaceChar(StringBuilder url, String character, String change){
//       boolean contains = url.toString().contains(character);
//       while (contains){
//          int index = url.indexOf(character);
//          url.deleteCharAt(index);
//          url.insert(index, change, 0, 3);
//          contains = url.toString().contains(character);
//       }
//    }
// 
//    private String encodeQueryParam(String param) {
//       try {
//          return URLEncoder.encode(param, "UTF-8");
//       }
//       catch (UnsupportedEncodingException e) {
//          // If this happens, we've got bigger problems.
//          throw new RuntimeException(e);
//       }
//    }

   /**
    * Wrapper for URLEncoder
    * @param str
    * @return
    */
   private String urlEncode(String str) {
      String out = str;
      if (str != null) {
         try {
            out = URLEncoder.encode(str, "UTF-8");
         } catch(Exception e) {
            LOG.warn("Error URL encoding string: " + str);
         }
      }
      return out;
   }

   /**
    * Wrapper for URLDecoder
    * @param str
    * @return
    */
   private String urlDecode(String str) {
      String out = str;
      if (str != null) {
         try {
            out = URLDecoder.decode(str, "UTF-8");
         } catch(Exception e) {
            LOG.warn("Error URL decoding string: " + str);
         }
      }
      return out;
   }

   /**
    * Encode a string array containing multiple values into a single string.
    * This method is used to encode multiple render parameter values.
    * @param values  the string array to encode.
    * @return a single string containing all the values.
    */
   private String encodeMultiValues(String[] values) {
      StringBuilder buffer = new StringBuilder();
      for (int i = 0; i < values.length; i++) {
         if (values[i] == null) {
            buffer.append(VALUE_NULL);
         } else {
            buffer.append(urlEncode(values[i]));
         }
         if (i + 1 < values.length) {
            buffer.append(VALUE_DELIM);
         }
      }
      return buffer.toString();
   }

   /**
    * This parser is completely married to the URL impl anyway, so let it
    * blow up if someone tries to use a different URL impl.
    */
   public String toString(PortalURL portalURL) {
      return toString((RelativePortalURLImpl) portalURL);
   }

//    /**
//     * Encode special characters contained in the string value.
//     * @param string  the string value to encode.
//     * @return the encoded string.
//     */
//    private String encodeCharacters(String string) {
//       for (int i = 0; i < ENCODINGS.length; i++) {
//          string = string.replace(ENCODINGS[i][0], ENCODINGS[i][1]);
//       }
//       return string;
//    }
// 
//    /**
//     * Decode special characters contained in the string value.
//     * @param string  the string value to decode.
//     * @return the decoded string.
//     */
//    private String decodeCharacters(String string) {
//       for (int i = 0; i < ENCODINGS.length; i++) {
//          string = string.replace(ENCODINGS[i][1], ENCODINGS[i][0]);
//       }
//       return string;
//    }

}

