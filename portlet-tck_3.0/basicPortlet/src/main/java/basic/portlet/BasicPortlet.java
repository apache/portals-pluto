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

package basic.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletContext;

/**
 * A very simple portlet
 */
public class BasicPortlet extends GenericPortlet {

   // Set up logging
   private static final String LOG_CLASS = BasicPortlet.class.getName();
   private final Logger logger = Logger.getLogger(LOG_CLASS);

   protected void doView(RenderRequest request, RenderResponse response)
         throws PortletException, IOException {
      
      if (logger.isLoggable(Level.FINE)) {
         logger.logp(Level.FINE, this.getClass().getName(), "doView", "Entry");
      }
      
      response.setContentType("text/html");
      
      PrintWriter writer = response.getWriter();
      writer.write("<p>");
      writer.write(getInitParameter("greeting"));
      writer.write("</p>");
      writer.write("<p>PortletContext is ServletContext?: ");
      writer.write("" + (this.getPortletContext() instanceof ServletContext));
      writer.write("</p>");
      
      String title = "Hello from window: " + request.getWindowID();
      request.setAttribute("title", title);
      
      // dispatch to the viewer JSP
      PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(
            "/WEB-INF/jsp/view.jsp");
      rd.include(request, response);
      
      PortletSession ps = request.getPortletSession();
      
      writer.write("<h5>Here are our attributes:</h5>");
      StringBuilder txt = new StringBuilder(128);
      txt.append("Portlet scoped attribute: ").append(ps.getAttribute("portletScopedNumber")).append("<br>");
      txt.append("App scoped attribute: ")
         .append(ps.getAttribute("appScopedNumber", PortletSession.APPLICATION_SCOPE))
         .append("<br>");
      
      txt.append("<p>Auth type: ").append(request.getAuthType()).append("</p>");
      
      writer.write(txt.toString());
      
      
   }

   public void processAction(ActionRequest req, ActionResponse resp)
         throws PortletException, IOException {
      // the only action for this portlet is to trigger a reload of the
      // configuration file
      String actionName = req.getParameter("action");
      if ("setParms".equals(actionName)) {
         logger.logp(Level.INFO, this.getClass().getName(), "processAction",
               "Set some parameters.");
         resp.setRenderParameter("parm1", "value1");
         resp.setRenderParameter("parm2", new String[] {"valueX", "valueY"});
         resp.setRenderParameter("parm3", "value3");
         resp.setRenderParameter("namespace", resp.getNamespace());
         resp.setRenderParameter("windowID", req.getWindowID());
      }

      PortletSession ps = req.getPortletSession();

      if ("invalidateSession".equals(actionName)) {
         logger.logp(Level.INFO, this.getClass().getName(), "processAction",
               "Invalidate the session.");
         
         ps.invalidate();
      } else {

         if (ps.getAttribute("portletScopedNumber") == null) {
            int num = (int)(Math.random() * 1000);
            ps.setAttribute("portletScopedNumber", num);
         }

         if (ps.getAttribute("appScopedNumber", PortletSession.APPLICATION_SCOPE) == null) {
            int num = (int)(Math.random() * 1000);
            ps.setAttribute("appScopedNumber", num, PortletSession.APPLICATION_SCOPE);
         }
         
      }

   }

}
