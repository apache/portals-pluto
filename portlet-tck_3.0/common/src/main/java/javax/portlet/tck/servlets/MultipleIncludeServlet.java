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

import static javax.portlet.tck.constants.Constants.MULTIPLE_INCLUDE_ATTR;
import static javax.portlet.tck.constants.Constants.MULTIPLE_INCLUDE_VAL;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet for JSR 362 request dispatcher testing.
 * 
 * This servlet is for inclusion before the main servlet that contains
 * the test cases. It sets a request attribute to mark that it was 
 * successfully included.
 * 
 * @author nick
 *
 */
public class MultipleIncludeServlet extends HttpServlet {

   private static final long serialVersionUID = -4104376549644600993L;
   private final Logger LOGGER = LoggerFactory.getLogger(MultipleIncludeServlet.class);

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
      LOGGER.trace("processTCKReq: servlet entry");

      String str = (String) request.getAttribute(MULTIPLE_INCLUDE_ATTR);
      int num = 1;
      if (str != null) {
         str = str.replaceFirst(".*=(\\d+).*", "$1");
         num = (str == null) ? 1 : Integer.parseInt(str);
      }
      str = MULTIPLE_INCLUDE_VAL + num;

      request.setAttribute(MULTIPLE_INCLUDE_ATTR, str);
      
   }
}
