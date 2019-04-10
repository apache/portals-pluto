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


package org.apache.pluto.container.bean.processor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to display the portlet configuration along with any configuration
 * errors or warnings for this servlet context.
 * 
 * @author Scott Nicklous
 */
public class ConfigServlet extends HttpServlet {
   private static final long serialVersionUID = -3842324547802444406L;

   private StringBuilder errorString = new StringBuilder();
   public static final String ATTRIB_ERROR = "_Error";
   
   @Inject
   private AnnotatedConfigBean acb;

   /**
    * TODO: complete and make work.
    */
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String portletName = "Fred";
      
      ConfigSummary summary = acb.getSummary();
      AnnotatedMethodStore ams = acb.getMethodStore();
      PortletStateScopedConfig config = acb.getStateScopedConfig();
      
      // Make sure there are beans for this portlet name. If not, build an error
      // string for later viewing. The error string shows all deployment errors that were
      // logged along with all annotated portlet artifacts that were found.
      
      List<String> errors = summary.getErrorStrings(portletName);
      if (!ams.getPortletNames().contains(portletName) && errors.size() == 0) {

         errorString.append("<h3>Portlet Name: ").append(portletName).append("</h3>");
         errorString.append("<p>No portlet annotations could be found for this portlet.</p>");
         errorString.append("<h4>Deployment errors:</h4>");
         List<String> portletNames = summary.getPortletsWithErrors();
         portletNames.remove("*");
         for (String name: portletNames) {
            errorString.append("<p style='color: #00F; font: bold;'>Portlet: " + name + "</p>");
            List<String> errs = summary.getErrorStrings(name);
            for (String err : errs) {
               errorString.append("<div style='padding-left: 15px;'>");
               String[] lines = err.split("\\n");
               errorString.append(lines[0]);
               if (lines.length > 1) {
                  for (String line : Arrays.copyOfRange(lines, 1, lines.length)) {
                     errorString.append("<div style='padding-left: 15px;'>");
                     errorString.append(line);
                     errorString.append("</div>");
                  }
               }
               errorString.append("</div>");
            }
         }
         errorString.append("<h4>Available annotated portlet artifacts:</h4>");
//         formatToErrorString(ams.getConfigAsString().split("\n"));
         formatToErrorString(ams.getMethodsAsString().split("\n"));
         errorString.append("<h4>RenderStateScoped Bean Configuration:</h4>");
         formatToErrorString(config.getConfigAsString().split("\n"));
      } else {
         
         // If there are deployment errors for this portlet, display them rather 
         // than trying to dispatch to potentially erroneous bean methods.
         
         if (errors.size() > 0) {

            errorString.append("<h3>Portlet Name: ").append(portletName).append("</h3>");
            errorString.append("<p>There were deployment problems with this portlet.</p>");
            errorString.append("<h4>Deployment errors:</h4>");
            for (String err : errors) {
               errorString.append("<div style='padding-left: 15px;'>");
               String[] lines = err.split("\\n");
               errorString.append(lines[0]);
               if (lines.length > 1) {
                  for (String line : Arrays.copyOfRange(lines, 1, lines.length)) {
                     errorString.append("<div style='padding-left: 15px;'>");
                     errorString.append(line);
                     errorString.append("</div>");
                  }
               }
               errorString.append(err.replaceAll("\\n", "<br/>"));
               errorString.append("</div>");
            }
         }

      }

      resp.setContentType("text/html");
      PrintWriter writer = resp.getWriter();
      writer.write(errorString.toString());

   }

   
   /**
    * Formats an array of text lines to the error string. The first line is highlighted.
    * subsequent lines are indented once for each tab character at the beginning.
    *   
    * @param lines   The lines to format
    */
   private void formatToErrorString(String[] lines) {
      if (lines.length > 0) {
         errorString.append("<p style='color: #00F; font: bold;'>" + lines[0] + "</p>");
         for (String line : Arrays.copyOfRange(lines, 1, lines.length)) {
            Stack<String> closingTags = new Stack<String>();
            
            errorString.append("<div style='padding-left: 15px;'>");
            closingTags.push("</div>");

            while (line.length() > 0 && line.startsWith("\t")) {
               errorString.append("<div style='padding-left: 15px;'>");
               closingTags.push("</div>");
               line = line.substring(1);
            }
            
            errorString.append(line);
            
            while(!closingTags.empty()) {
               errorString.append(closingTags.pop());
            }
         }
      }
   }

}
