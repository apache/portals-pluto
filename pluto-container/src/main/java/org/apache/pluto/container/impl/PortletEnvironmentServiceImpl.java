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
package org.apache.pluto.container.impl;

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

import org.apache.pluto.container.PortletActionResponseContext;
import org.apache.pluto.container.PortletEnvironmentService;
import org.apache.pluto.container.PortletEventResponseContext;
import org.apache.pluto.container.PortletRenderResponseContext;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletResourceRequestContext;
import org.apache.pluto.container.PortletResourceResponseContext;
import org.apache.pluto.container.PortletWindow;

public class PortletEnvironmentServiceImpl implements PortletEnvironmentService
{
    public ActionRequest createActionRequest(PortletRequestContext requestContext, PortletActionResponseContext responseContext)
    {
        return new ActionRequestImpl(requestContext, responseContext);
    }

    public ActionResponse createActionResponse(PortletActionResponseContext responseContext)
    {
        return new ActionResponseImpl(responseContext);
    }

    public EventRequest createEventRequest(PortletRequestContext requestContext, PortletEventResponseContext responseContext, Event event)
    {
        return new EventRequestImpl(requestContext, responseContext, event);
    }

    public EventResponse createEventResponse(PortletEventResponseContext responseContext)
    {
        return new EventResponseImpl(responseContext);
    }

    public PortletSession createPortletSession(PortletContext portletContext, PortletWindow portletWindow,
                                               HttpSession session)
    {
        return new PortletSessionImpl(portletContext, portletWindow, session);
    }

    public RenderRequest createRenderRequest(PortletRequestContext requestContext, PortletRenderResponseContext responseContext)
    {
        return new RenderRequestImpl(requestContext, responseContext);
    }

    public RenderResponse createRenderResponse(PortletRenderResponseContext responseContext)
    {
        return new RenderResponseImpl(responseContext);
    }

    public ResourceRequest createResourceRequest(PortletResourceRequestContext requestContext, PortletResourceResponseContext responseContext)
    {
        return new ResourceRequestImpl(requestContext, responseContext);
    }

    public ResourceResponse createResourceResponse(PortletResourceResponseContext responseContext,
                                                   String requestCacheLevel)
    {
        return new ResourceResponseImpl(responseContext, requestCacheLevel);
    }
}