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

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.PortletRequestFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.ResourceFilter;

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

   @Override
   public void init(FilterConfig filterConfig) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void doFilter(ResourceRequest request, ResourceResponse response, FilterChain chain) throws IOException,
         PortletException {
      
      LOGGER.fine("Entering request. Dispatcher type: " + request.getDispatcherType());
      
      chain.doFilter(request, response);
      
      LOGGER.fine("Exiting request. Dispatcher type: " + request.getDispatcherType());
      
   }

}
