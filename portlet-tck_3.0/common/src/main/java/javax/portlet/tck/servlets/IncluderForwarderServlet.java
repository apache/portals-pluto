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

import static javax.portlet.tck.constants.Constants.ATTR_DISPATCH_ACTION;
import static javax.portlet.tck.constants.Constants.ATTR_DISPATCH_CONTEXT_PATH;
import static javax.portlet.tck.constants.Constants.ATTR_DISPATCH_PATH_INFO;
import static javax.portlet.tck.constants.Constants.ATTR_DISPATCH_QUERY_STRING;
import static javax.portlet.tck.constants.Constants.ATTR_DISPATCH_REQUEST_URI;
import static javax.portlet.tck.constants.Constants.ATTR_DISPATCH_SERVLET_PATH;
import static javax.portlet.tck.constants.Constants.ATTR_DISPATCH_TARGET;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
   private final Logger LOGGER = LoggerFactory.getLogger(IncluderForwarderServlet.class);

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

      String action = (String) request.getAttribute(ATTR_DISPATCH_ACTION);
      if (action == null || !action.matches("(include|forward)")) {
         String msg = "Bad action attribute. action = " + action;
         LOGGER.error(msg);
         throw new ServletException(msg);
      }

      String target = (String) request.getAttribute(ATTR_DISPATCH_TARGET);
      if (target == null) {
         String msg = "Bad target attribute. target = " + action;
         LOGGER.error(msg);
         throw new ServletException(msg);
      }
      
      // do logging if enabled
      ServletRequestUtils.logDebugInfo(request, this.getClass().getSimpleName());
      
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
         String msg = "Could not get request dispatcher.";
         LOGGER.error(msg);
         throw new ServletException(msg);
      }
      
      if (action.equals("include")) {
         rd.include(request, response);
      } else {
         rd.forward(request, response);
      }

   }
}
