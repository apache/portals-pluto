/*
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
package org.apache.pluto.core;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.CacheControl;
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

import org.apache.pluto.PortletWindow;
import org.apache.pluto.internal.impl.ActionRequestImpl;
import org.apache.pluto.internal.impl.ActionResponseImpl;
import org.apache.pluto.internal.impl.EventRequestImpl;
import org.apache.pluto.internal.impl.EventResponseImpl;
import org.apache.pluto.internal.impl.PortletSessionImpl;
import org.apache.pluto.internal.impl.RenderRequestImpl;
import org.apache.pluto.internal.impl.RenderResponseImpl;
import org.apache.pluto.internal.impl.ResourceRequestImpl;
import org.apache.pluto.internal.impl.ResourceResponseImpl;
import org.apache.pluto.spi.optional.PortletActionResponseContext;
import org.apache.pluto.spi.optional.PortletEnvironmentService;
import org.apache.pluto.spi.optional.PortletEventResponseContext;
import org.apache.pluto.spi.optional.PortletRenderResponseContext;
import org.apache.pluto.spi.optional.PortletRequestContext;
import org.apache.pluto.spi.optional.PortletResourceRequestContext;
import org.apache.pluto.spi.optional.PortletResourceResponseContext;

public class DefaultPortletEnvironmentService implements PortletEnvironmentService
{
    public ActionRequest createActionRequest(PortletRequestContext requestContext)
    {
        return new ActionRequestImpl(requestContext);
    }

    public ActionResponse createActionResponse(PortletActionResponseContext responseContext)
    {
        return new ActionResponseImpl(responseContext);
    }

    public EventRequest createEventRequest(PortletRequestContext requestContext, Event event)
    {
        return new EventRequestImpl(requestContext, event);
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

    public RenderRequest createRenderRequest(PortletRequestContext requestContext, CacheControl cacheControl)
    {
        return new RenderRequestImpl(requestContext, cacheControl);
    }

    public RenderResponse createRenderResponse(PortletRenderResponseContext responseContext)
    {
        return new RenderResponseImpl(responseContext);
    }

    public ResourceRequest createResourceRequest(PortletResourceRequestContext requestContext, CacheControl cacheControl)
    {
        return new ResourceRequestImpl(requestContext, cacheControl);
    }

    public ResourceResponse createResourceResponse(PortletResourceResponseContext responseContext,
                                                   String requestCacheLevel)
    {
        return new ResourceResponseImpl(responseContext, requestCacheLevel);
    }
}