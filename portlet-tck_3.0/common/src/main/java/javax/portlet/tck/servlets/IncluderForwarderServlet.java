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


package javax.portlet.tck.servlets;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.*;

/**
 * Servlet for JSR 362 request dispatcher testing.
 * 
 * This servlet forwards to or includes another servlet in order to allow multi-level
 * forward / include testing. Request attributes specify the action (forward or include)
 * to be carried out and the target of the action. 
 * 
 * @author nick
 *
 */
public class IncluderForwarderServlet extends HttpServlet {
   private static final long serialVersionUID = -4104376549644600993L;
   private static final String LOG_CLASS = 
         IncluderForwarderServlet.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
      processTCKReq(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
      processTCKReq(req, resp);
   }

   // The tck uses only get & post requests
   protected void processTCKReq(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      LOGGER.entering(LOG_CLASS, "servlet entry");

      String action = (String) request.getAttribute(ATTR_DISPATCH_ACTION);
      if (action == null || !action.matches("(include|forward)")) {
         String msg = LOG_CLASS + ": Bad action attribute. action = " + action;
         LOGGER.severe(msg);
         throw new ServletException(msg);
      }

      String target = (String) request.getAttribute(ATTR_DISPATCH_TARGET);
      if (target == null) {
         String msg = LOG_CLASS + ": Bad target attribute. target = " + action;
         LOGGER.severe(msg);
         throw new ServletException(msg);
      }
      
      String uri = request.getRequestURI();
      String cp = request.getContextPath();
      String sp = request.getServletPath();
      String pi = request.getPathInfo();
      String qs = request.getQueryString();
      
      request.setAttribute(ATTR_DISPATCH_REQUEST_URI, uri);
      request.setAttribute(ATTR_DISPATCH_CONTEXT_PATH, cp);
      request.setAttribute(ATTR_DISPATCH_SERVLET_PATH, sp);
      request.setAttribute(ATTR_DISPATCH_PATH_INFO, pi);
      request.setAttribute(ATTR_DISPATCH_QUERY_STRING, qs);
      
      RequestDispatcher rd = request.getRequestDispatcher(target);
      if (rd == null) {
         String msg = LOG_CLASS + ": Could not get request dispatcher.";
         LOGGER.severe(msg);
         throw new ServletException(msg);
      }
      
      if (action.equals("include")) {
         rd.include(request, response);
      } else {
         rd.forward(request, response);
      }

   }
}
