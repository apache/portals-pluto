/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.apache.pluto.testsuite.test.jsr286.filter;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.EventFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.RenderFilter;
import javax.portlet.filter.ResourceFilter;

public class WildcardMappedFilter extends BaseFilter  implements
    RenderFilter, ActionFilter, EventFilter, ResourceFilter {

    public static String ATTR_SET_IN_FILTER = 
                                        WildcardMappedFilter.class.getName();
    
    public static String ATTR_TO_BE_OVERWRITTEN = "OVERWRITE_ME";
    
    private void processRequest(PortletRequest request) {
        request.setAttribute(ATTR_SET_IN_FILTER, Boolean.TRUE);
        request.setAttribute(ATTR_TO_BE_OVERWRITTEN, ATTR_TO_BE_OVERWRITTEN);
    }
    
    public void doFilter(RenderRequest request, RenderResponse response,
            FilterChain filterChain) throws IOException, PortletException {
        processRequest(request);
        filterChain.doFilter(request, response);
    }

    public void doFilter(ActionRequest request, ActionResponse response,
            FilterChain filterChain) throws IOException, PortletException {
        processRequest(request);
        filterChain.doFilter(request, response);
    }

    public void doFilter(EventRequest request, EventResponse response, 
            FilterChain filterChain) throws IOException, PortletException {
        processRequest(request);
        filterChain.doFilter(request, response);
    }

    public void doFilter(ResourceRequest request, ResourceResponse response,
            FilterChain filterChain) throws IOException, PortletException {
        processRequest(request);
        filterChain.doFilter(request, response);        
    }

}
