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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.inject.Inject;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.PortletLifecycleFilter;
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
@PortletLifecycleFilter(portletNames="AsyncPortlet")
public class AsyncFilter implements ResourceFilter {
   private static final Logger logger = LoggerFactory.getLogger(AsyncFilter.class);
   
   @Inject private PortletRequestRandomNumberBean reqnum;
   @Inject private AsyncDialogBean asyncDialogBean;

   @Override
   public void init(FilterConfig filterConfig) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void doFilter(ResourceRequest resourceRequest, ResourceResponse resourceResponse, FilterChain chain) throws IOException,
         PortletException {
      
      DispatcherType dispatcherType = resourceRequest.getDispatcherType();
      
      StringBuilder txt = new StringBuilder(128);
      txt.append("Entering request. DispatcherType: ").append(dispatcherType);
      txt.append(", request #: ").append(reqnum.getRandomNumber());
      logger.debug(txt.toString());
      
      if (asyncDialogBean.isShowFilter()) {
         txt.setLength(0);
         txt.append("<div class='msgbox'>");
         txt.append("Filter: Request number: ").append(reqnum.getRandomNumber());
         txt.append(", DispatcherType: ").append(resourceRequest.getDispatcherType());
         txt.append("</div>");
         resourceResponse.getWriter().write(txt.toString());
      }
      
      chain.doFilter(resourceRequest, resourceResponse);
      
      logger.debug("Exiting request. DispatcherType: " + resourceRequest.getDispatcherType());
      
   }

}
