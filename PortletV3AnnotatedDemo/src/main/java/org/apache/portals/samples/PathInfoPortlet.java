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

import javax.inject.Inject;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.portlet.annotations.Namespace;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;
import javax.portlet.annotations.URLFactory;
import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Resource portlet for viewing path information.
 */
public class PathInfoPortlet {

   public static final String RESPARAM_DISPLAY = "display";

   // Injecting the namespace & URLFactory
   @Inject
   @Namespace
   private String             pid;
   @Inject
   private URLFactory         uf;

   @RenderMethod(portletNames = { "PathInfoPortlet" }, ordinal = 100)
   public String getImageInclude() {

      StringBuilder txt = new StringBuilder(128);
      txt.append("<h3>Path Info Portlet</h3>");

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
    * This resource method generates some output directly, then includes output
    * from a JSP as specified in the annotation.
    * 
    * @return The string for inclusion in the output.
    * @throws IOException
    */
   @ServeResourceMethod(portletNames = { "PathInfoPortlet" }, asyncSupported = true)
   public void getPathInfo(ResourceRequest req, ResourceResponse resp) throws IOException {

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
      } else {
         pd = new PathDisplay(req, "Resource Method (Resource)");
      }
      pathInfo.add(pd.toMarkup());

      req.setAttribute("pathInfo", pathInfo);

      PrintWriter writer = resp.getWriter();
      writer.append("<h5>Async Hack Resource Request</h5>");
      writer.append("<p>");
      writer.append("Trying to start async. Servlet context = ").append(hreq.getServletContext().getContextPath())
            .append(". ");
      resp.flushBuffer();

      RequestDispatcher rd = null;
      String jsp = "/WEB-INF/jsp/pathinfo.jsp";
      rd = hreq.getRequestDispatcher(jsp);
      if (hreq != null && hresp != null) {
         try {
            AsyncContext context = hreq.startAsync(hreq, hresp);
            context.setTimeout(3000);
            writer = context.getResponse().getWriter();
            writer.append("worked. Async context: ").append((context == null) ? "null." : "not null.");
            writer.append(" Now dispatching ... ");
            resp.flushBuffer();
            context.dispatch(jsp);
            writer.append(" done. ");
         } catch (Exception e) {
            writer.append(" ... didn't work. Exception: ").append(e.toString());
            resp.flushBuffer();
         }
      }

      writer.append("</p><hr>");
      resp.flushBuffer();
      try {
         writer.append("<p>Now doing request dispatcher include.</p>");
         rd.include(hreq, hresp);
      } catch (ServletException e) {
         writer.append("<p>Exception including jsp. ").append(e.toString());
         writer.append("</p>");
      }

   }

}
