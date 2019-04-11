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

package org.apache.portals.pluto.demo.v3annotated;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.portlet.MutableRenderParameters;
import javax.portlet.MutableResourceParameters;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;
import javax.portlet.MimeResponse;

/**
 * Resource portlet for viewing path information.
 */
@PortletConfiguration(portletName="PathInfoPortlet") // not necessary; test for title handling
public class PathInfoPortlet {

   public static final String RESPARAM_DISPLAY = "display";

   private static final String JSP = "/WEB-INF/jsp/pathinfo.jsp?mix1&qp1=qval1&mix2=qmix2";
   private static final String SERVLET = "/Named/Bob/Some/Path/Info?mix1&qp1=qval1&mix2=qmix2";
   private static final String NAME = "Bob";

   @Inject
   private PortletConfig      pcfg;
   @Inject
   private MimeResponse         mimeresp;
   
   @RenderMethod(portletNames = { "PathInfoPortlet" }, ordinal = 100)
   public void getImageInclude(RenderRequest req, RenderResponse resp) throws IOException, PortletException {

      String op = req.getRenderParameters().getValue("op");
      PrintWriter writer = resp.getWriter();
      
      if (op == null || !op.equals("fwd")) {

         resp.setContentType("text/html");

         writer.append("<h3>Path Info Portlet</h3>");
         writer.append("<div class='parmbox'>");

         PortletURL rurl = resp.createRenderURL();
         MutableRenderParameters rp = rurl.getRenderParameters().clone();
         rp.setValue("renp1", "renval1");
         rp.setValue("mix2", "renmix2");
         rp.setValue("mix1", "renmix1");
         rp.setValue("op", "inc");
         rurl.getRenderParameters().set(rp);
         RenderLink tl = new RenderLink("Resource include", rurl);
         writer.append(tl.toString());

         rurl = resp.createRenderURL();
         rp.setValue("op", "fwd");
         rurl.getRenderParameters().set(rp);
         tl = new RenderLink("Forward to Servlet from Render", rurl);
         writer.append(tl.toString());

         rurl = resp.createRenderURL();
         rp.setValue("op", "fwdjsp");
         rurl.getRenderParameters().set(rp);
         tl = new RenderLink("Forward to JSP from Render", rurl);
         writer.append(tl.toString());
         
         rurl = resp.createRenderURL();
         rp.setValue("op", "incjsp");
         rurl.getRenderParameters().set(rp);
         tl = new RenderLink("Include JSP from Render", rurl);
         writer.append(tl.toString());
         
         rurl = resp.createRenderURL();
         rp.setValue("op", "nested");
         rurl.getRenderParameters().set(rp);
         tl = new RenderLink("Nested Include Portlet -> Servlet -> JSP", rurl);
         writer.append(tl.toString());
         
         rurl = resp.createRenderURL();
         rp.setValue("op", "named");
         rurl.getRenderParameters().set(rp);
         tl = new RenderLink("Include Named Servlet", rurl);
         writer.append(tl.toString());
         writer.append("</div>");

      }
      
      if (op != null) {

         PortletURL cntlurl = resp.createRenderURL();
         MutableRenderParameters rp = cntlurl.getRenderParameters();
         rp.setValue("renp1", "renval1");
         rp.setValue("mix2", "renmix2");
         rp.setValue("mix1", "renmix1");
         rp.setValue("op", "inc");

         if (op.equals("fwd")) {
            RenderLink renlink = new RenderLink("back", cntlurl);
            req.setAttribute("renderLink", renlink);
            req.setAttribute("title", "Forwarded to Servlet by render method.");
            PortletRequestDispatcher rd = pcfg.getPortletContext().getRequestDispatcher(SERVLET);
            rd.forward(req, resp);
            return;
         } else if (op.equals("fwdjsp")) {
            RenderLink renlink = new RenderLink("back", cntlurl);
            req.setAttribute("renderLink", renlink);
            req.setAttribute("jsptitle", "Forwarded to JSP by render method.");
            PortletRequestDispatcher rd = pcfg.getPortletContext().getRequestDispatcher(JSP);
            rd.forward(req, resp);
            return;
         }

         writer.append("<div class='infobox'>");

         if (op.equals("nested")) {
            req.setAttribute("title", "Included nested in Portlet -> Servlet -> JSP.");
            PathDisplay pd = new PathDisplay(req, "Render Method (Before)");
            writer.write(pd.toMarkup());
            PortletRequestDispatcher rd = pcfg.getPortletContext().getRequestDispatcher(SERVLET);
            rd.include(req, resp);
            pd = new PathDisplay(req, "Render Method (After)");
            writer.write(pd.toMarkup());
         }  else if (op.equals("incjsp")) {
            req.setAttribute("jsptitle", "Included by render method.");
            PortletRequestDispatcher rd = pcfg.getPortletContext().getRequestDispatcher(JSP);
            rd.include(req, resp);
         } else if (op.equals("inc")) {

            ResourceURL resurl = mimeresp.createResourceURL();
            MutableResourceParameters resparms = resurl.getResourceParameters();
            resparms.setValue("resp1", "resval1");
            resparms.setValue("mix1", "resval2");

            String pid = resp.getNamespace();
            writer.append("<div id='").append(pid).append("-putResourceHere'></div>\n");
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

            resurl = mimeresp.createResourceURL();
            resurl.setResourceID("fwd");
            resurl.getResourceParameters().set(resparms);

            writer.append("<div id='").append(pid).append("-puReHe'></div>\n");
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
         } else if (op.equals("named")) {
            writer.write("Including named servlet:");
            req.setAttribute("title", "Included named Servlet.");
            PortletRequestDispatcher rd = req.getPortletContext().getNamedDispatcher(NAME);
            rd.include(req, resp);
         } else {
            writer.write("unknown operation: " + op);
         }
         writer.append("</div>");
      }

   }

   /**
    * This resource method generates some output directly, then includes output
    * from a JSP as specified in the annotation.
    * 
    * @return The string for inclusion in the output.
    * @throws IOException
    */
   @ServeResourceMethod(portletNames = { "PathInfoPortlet" }, include=JSP)
   public void getPathInfo(ResourceRequest req, ResourceResponse resp) throws IOException {

      @SuppressWarnings("unchecked")
      ArrayList<String> pathInfo = (ArrayList<String>) req.getAttribute("pathInfo");
      if (pathInfo == null) {
         pathInfo = new ArrayList<String>();
      }
      PathDisplay pd = new PathDisplay(req, "Resource Method (ResourceRequest)");
      pathInfo.add(pd.toMarkup());

      req.setAttribute("pathInfo", pathInfo);
      req.setAttribute("jsptitle", "Included by resource method.");

   }

   @ServeResourceMethod(portletNames = { "PathInfoPortlet" }, resourceID="fwd")
   public void getPathInfo2(ResourceRequest req, ResourceResponse resp) throws IOException, PortletException {

      req.setAttribute("jsptitle", "Forwarded by resource method.");
      PortletRequestDispatcher prd = req.getPortletContext().getRequestDispatcher(JSP);
      prd.forward(req, resp);

   }

}
