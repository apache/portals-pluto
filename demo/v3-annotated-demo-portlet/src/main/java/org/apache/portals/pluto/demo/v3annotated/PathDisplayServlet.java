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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Named servlet to display the path info when included through a named
 * dispatcher.
 * 
 * @author Scott Nicklous
 *
 */
@WebServlet(urlPatterns = "/Named/Bob/*", name = "Bob")
public class PathDisplayServlet extends HttpServlet {
   private static final long serialVersionUID = -7767947528599563527L;

   private static final String JSP = "/WEB-INF/jsp/pathinfo.jsp?mix1=svtqval1&svtqp3=svtqval3&mix2=svtqval2";

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String op = req.getParameter("op");
      PrintWriter writer = resp.getWriter();
      if (op != null) {
         if (op.equals("fwd")) {
            resp.setContentType("text/html");

            writer.write("<h3>Path Info Portlet</h3>");
            writer.write("<div class='infobox'>");

            RenderLink rl = (RenderLink) req.getAttribute("renderLink");
            if (rl != null) {
               rl.writeTo(writer);
            }
            
            PathDisplay pd = new PathDisplay(req, "Path Display Servlet");
            writer.write(pd.toMarkup());
            writer.write("</div>");

         } else if (op.equals("nested")) {
            
            PathDisplay pd = new PathDisplay(req, "PD Servlet (Before)");
            writer.write(pd.toMarkup());
            
            req.setAttribute("jsptitle", "Included by servlet.");
            RequestDispatcher rd = req.getRequestDispatcher(JSP);
            rd.include(req, resp);
            
            pd = new PathDisplay(req, "PD Servlet (After)");
            writer.write(pd.toMarkup());
         } else if (op.equals("named")) {
            PathDisplay pd = new PathDisplay(req, "Path Display Servlet");
            writer.write(pd.toMarkup());
         }
      } else {
         // assume the servlet is being included
         PathDisplay pd = new PathDisplay(req, "Path Display Servlet");
         writer.write(pd.toMarkup());
      }
   }
}
