/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.container;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpSession;


/**
 * Factory Service for creating Portlet request, responses and session.
 *
 * @since 1.1.0
 */
public interface PortletEnvironmentService
{    
    ActionRequest createActionRequest(PortletRequestContext requestContext, PortletActionResponseContext responseContext);
    ActionResponse createActionResponse(PortletActionResponseContext responseContext);

    EventRequest createEventRequest(PortletRequestContext requestContext, PortletEventResponseContext responseContext, Event event);
    EventResponse createEventResponse(PortletEventResponseContext responseContext);
    
    RenderRequest createRenderRequest(PortletRequestContext requestContext, PortletRenderResponseContext responseContext);
    RenderResponse createRenderResponse(PortletRenderResponseContext responseContext);
    
    ResourceRequest createResourceRequest(PortletResourceRequestContext requestContext, PortletResourceResponseContext responseContext);
    ResourceResponse createResourceResponse(PortletResourceResponseContext responseContext, String requestCacheLevel);

    PortletSession createPortletSession(PortletContext portletContext, PortletWindow portletWindow, HttpSession session);
}
