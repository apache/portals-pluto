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

package org.apache.portals.samples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.portlet.annotations.Namespace;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;
import javax.portlet.annotations.URLFactory;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Resource portlet for viewing path information.
 */
public class AsyncHackPortlet {
   private static final Logger LOGGER = Logger.getLogger(AsyncHackPortlet.class.getName());

   public static final String RESPARAM_DISPLAY = "display";

   // Injecting the namespace & URLFactory
   @Inject
   @Namespace
   private String             pid;
   @Inject
   private URLFactory         uf;

   @RenderMethod(portletNames = { "AsyncHackPortlet" }, ordinal = 100)
   public String getImageInclude() {
      LOGGER.fine("Rendering async hack portlet");

      StringBuilder txt = new StringBuilder(128);
      txt.append("<h3>Async Hack Portlet</h3>");

      ResourceURL resurl = uf.createResourceURL();

      txt.append("<div class='infobox' id='").append(pid).append("-putResourceHere'></div>\n");
      txt.append("<script>\n");
      txt.append("(function () {\n");
      txt.append("   var xhr = new XMLHttpRequest();\n");
      txt.append("   xhr.onreadystatechange=function() {\n");
      txt.append("      if (xhr.readyState==4 && xhr.status==200) {\n");
      txt.append("         document.getElementById('").append(pid)
            .append("-putResourceHere').innerHTML=xhr.responseText;\n");
      txt.append("      }\n");
      txt.append("   };\n");
      txt.append("   xhr.open(\"GET\",\"").append(resurl.toString()).append("\",true);\n");
      txt.append("   xhr.send();\n");
      txt.append("})();\n");
      txt.append("</script>\n");

      return txt.toString();
   }

   /**
    * This resource method generates some output directly, then includes output from a JSP as specified in the
    * annotation.
    * 
    * @return The string for inclusion in the output.
    * @throws IOException
    * @throws PortletException 
    */
   @ServeResourceMethod(portletNames = { "AsyncHackPortlet" }, asyncSupported = true)
   public void getPathInfo(ResourceRequest req, ResourceResponse resp) throws IOException, PortletException {
      LOGGER.fine("Doing async hack resource request");

      @SuppressWarnings("unchecked")
      ArrayList<String> pathInfo = (ArrayList<String>) req.getAttribute("pathInfo");
      if (pathInfo == null) {
         pathInfo = new ArrayList<String>();
      }

      HttpServletRequest hreq = (HttpServletRequest) req.getAttribute("javax.portlet.debug.ServletRequest");
      HttpServletResponse hresp = (HttpServletResponse) req.getAttribute("javax.portlet.debug.ServletResponse");
      PathDisplay pd;
      if (hreq != null) {
         pd = new PathDisplay(hreq, "Resource Method (Servlet)");
         hreq.setAttribute("pathInfo", pathInfo);
      } else {
         pd = new PathDisplay(req, "Resource Method (Resource)");
         req.setAttribute("pathInfo", pathInfo);
      }
      pathInfo.add(pd.toMarkup());

      PrintWriter writer = resp.getWriter();
      writer.append("<h5>Async Hack Resource Request</h5>");
      
      StringBuilder txt = new StringBuilder(128);
      txt.append("Trying to start async. Servlet context: ").append(hreq.getServletContext().getContextPath());

      String jsp = "/WEB-INF/jsp/pathinfo.jsp";
//      String jsp = "/ais";
//      RequestDispatcher rd = null;
//      rd = hreq.getRequestDispatcher(jsp);
//      txt.append("Request dispatcher: ").append(rd);
      LOGGER.fine(txt.toString());
      txt.setLength(0);
      
      if (hreq != null && hresp != null) {
         try {
            
            AsyncContext context = hreq.startAsync(hreq, hresp);
            context.setTimeout(1000);
            
            txt.append("Async context: ").append((context == null) ? "null." : "not null.");
            txt.append(" Now dispatching ... ");

//            context.dispatch(hreq.getServletContext(), jsp);
            context.dispatch(jsp);
            
            txt.append(" done. ");
         } catch (Exception e) {
            txt.append(" ... didn't work. Exception: ").append(e.toString());
         }
         
         LOGGER.fine(txt.toString());
         txt.setLength(0);
      }

   }

}
