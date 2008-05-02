/*
 * Copyright 2003,2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.pluto.internal.impl;

import java.io.IOException;

import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.internal.InternalEventResponse;

/**
 * Implementation of JSR-286 <code>EventResponse</code>.
 *
 * @since 2.0
 */

public class EventResponseImpl extends StateAwareResponseImpl
	implements EventResponse,InternalEventResponse {

    public EventResponseImpl(PortletContainer container,
                              PortletWindow portletWindow,
                              HttpServletRequest servletRequest,
                              HttpServletResponse servletResponse) {
        super(container, portletWindow, servletRequest,
              servletResponse);
    }

	public void setRenderParameters(EventRequest request) {
		super.setEventRequest(request);
	}

	@Override
	public void sendRedirect(String location) throws IOException {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		super.sendRedirect(location);
	}
}
