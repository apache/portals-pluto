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
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.portlet.annotations.Namespace;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;
import javax.portlet.annotations.URLFactory;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Resource portlet for viewing path information.
 */
public class PathInfoPortlet {
   
   private class DispatchServlet extends HttpServlet {
      
   }

   public static final String RESPARAM_DISPLAY = "display";

   // Injecting the namespace & URLFactory
   @Inject
   @Namespace
   private String             pid;
   @Inject
   private URLFactory         uf;
   
   @RenderMethod(portletNames = { "PathInfoPortlet" }, ordinal = 100)
   public void getImageInclude(RenderRequest req, RenderResponse resp) throws IOException {

      resp.setContentType("text/html");
      PrintWriter writer = resp.getWriter();

      writer.append("<h3>Path Info Portlet</h3>");
      writer.append("<h5>Include:</h5>");

      ResourceURL resurl = uf.createResourceURL();

      writer.append("<div class='infobox' id='").append(pid).append("-putResourceHere'></div>\n");
      writer.append("<script>\n");
      writer.append("(function () {\n");
      writer.append("   var xhr = new XMLHttpRequest();\n");
      writer.append("   xhr.onreadystatechange=function() {\n");
      writer.append("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.append("         document.getElementById('").append(pid)
            .append("-putResourceHere').innerHTML=xhr.responseText;\n");
      writer.append("      }\n");
      writer.append("   };\n");
      writer.append("   xhr.open(\"GET\",\"").append(resurl.toString()).append("\",true);\n");
      writer.append("   xhr.send();\n");
      writer.append("})();\n");
      writer.append("</script>\n");

      writer.append("<h5>Forward:</h5>");

      resurl = uf.createResourceURL();
      resurl.setResourceID("fwd");

      writer.append("<div class='infobox' id='").append(pid).append("-puReHe'></div>\n");
      writer.append("<script>\n");
      writer.append("(function () {\n");
      writer.append("   var xhr = new XMLHttpRequest();\n");
      writer.append("   xhr.onreadystatechange=function() {\n");
      writer.append("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.append("         document.getElementById('").append(pid)
            .append("-puReHe').innerHTML=xhr.responseText;\n");
      writer.append("      }\n");
      writer.append("   };\n");
      writer.append("   xhr.open(\"GET\",\"").append(resurl.toString()).append("\",true);\n");
      writer.append("   xhr.send();\n");
      writer.append("})();\n");
      writer.append("</script>\n");
      
      // display info for named servlet
      
      PortletRequestDispatcher rd = req.getPortletContext().getNamedDispatcher("Bob");
      try {
         rd.include(req, resp);
      } catch (Exception e) {
         writer.append("<p>");
         writer.append("Exception getting named dispatcher: ").append(e.toString());
         writer.append("</p>");
      }

   }

   /**
    * This resource method generates some output directly, then includes output
    * from a JSP as specified in the annotation.
    * 
    * @return The string for inclusion in the output.
    * @throws IOException
    */
   @ServeResourceMethod(portletNames = { "PathInfoPortlet" }, include="/WEB-INF/jsp/pathinfo.jsp")
   public void getPathInfo(ResourceRequest req, ResourceResponse resp) throws IOException {

      @SuppressWarnings("unchecked")
      ArrayList<String> pathInfo = (ArrayList<String>) req.getAttribute("pathInfo");
      if (pathInfo == null) {
         pathInfo = new ArrayList<String>();
      }

      HttpServletRequest hreq = (HttpServletRequest) req.getAttribute("javax.portlet.debug.ServletRequest");
      PathDisplay pd;
      if (hreq != null) {
         pd = new PathDisplay(hreq, "Resource Method (Servlet)");
         pathInfo.add(pd.toMarkup());
      }
      pd = new PathDisplay(req, "Resource Method (ResourceRequest)");
      pathInfo.add(pd.toMarkup());

      req.setAttribute("pathInfo", pathInfo);

   }

   @ServeResourceMethod(portletNames = { "PathInfoPortlet" }, resourceID="fwd")
   public void getPathInfo2(ResourceRequest req, ResourceResponse resp) throws IOException, PortletException {

      PortletRequestDispatcher prd = req.getPortletContext().getRequestDispatcher("/WEB-INF/jsp/pathinfo.jsp");
      prd.forward(req, resp);

   }

}
