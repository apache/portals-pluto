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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.PortletRequestFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.ResourceFilter;
import javax.servlet.DispatcherType;

/**
 * Filter for the async portlet. logs the dispatcher type and sometimes
 * generates output.
 * 
 * @author Scott Nicklous
 *
 */
@PortletRequestFilter(portletNames="AsyncPortlet")
public class AsyncPortletFilter implements ResourceFilter {
   private static final Logger LOGGER = Logger.getLogger(AsyncPortletFilter.class.getName());
   
   @Inject private PortletRequestRandomNumberBean reqnum;
   @Inject private AsyncDialogBean adb;

   @Override
   public void init(FilterConfig filterConfig) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void doFilter(ResourceRequest request, ResourceResponse response, FilterChain chain) throws IOException,
         PortletException {
      
      DispatcherType type = request.getDispatcherType();
      
      StringBuilder txt = new StringBuilder(128);
      txt.append("Entering request. Dispatcher type: ").append(type);
      txt.append(", request #: ").append(reqnum.getRandomNumber());
      LOGGER.fine(txt.toString());
      
      if (adb.isUseFilter()) {
         txt.setLength(0);
         txt.append("<div class='msgbox'>");
         txt.append("Filter: Request number: ").append(reqnum.getRandomNumber());
         txt.append(", dispatcher type: ").append(request.getDispatcherType());
         txt.append("</div>");
         response.getWriter().write(txt.toString());
      }
      
      chain.doFilter(request, response);
      
      LOGGER.fine("Exiting request. Dispatcher type: " + request.getDispatcherType());
      
   }

}
