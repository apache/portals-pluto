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

import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * utilities for tracing information about servlet requests.
 * 
 * @author Scott Nicklous
 * 
 */
public class ServletRequestUtils {
   private static final Logger LOGGER = LoggerFactory.getLogger(ServletRequestUtils.class.getName());

   public static void logDebugInfo(HttpServletRequest req, String title) {

      if (LOGGER.isTraceEnabled()) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Servlet request info: \nAttributes for ").append(title).append(":");
         
         Enumeration<String> names = req.getAttributeNames();
         for (String name : Collections.list(names)) {
            txt.append("\nName: ").append(name);
            txt.append(", value: ").append(req.getAttribute(name));
         }
         
         txt.append("\n\nPath info:");
         txt.append("\nRequestUri:").append(req.getRequestURI());
         txt.append("\nContextPath:").append(req.getContextPath());
         txt.append("\nServletPath:").append(req.getServletPath());
         txt.append("\nPathInfo:").append(req.getPathInfo());
         txt.append("\nQueryString:").append(req.getQueryString());

         LOGGER.trace(txt.toString());
      }
   }

}
