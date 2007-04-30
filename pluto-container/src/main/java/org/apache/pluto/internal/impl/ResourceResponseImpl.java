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
package org.apache.pluto.internal.impl;

import java.io.IOException;
import java.io.OutputStream;

import javax.portlet.CacheControl;
import javax.portlet.PortalContext;
import javax.portlet.ResourceResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.internal.InternalResourceResponse;
import org.apache.pluto.spi.PortalCallbackService;

public class ResourceResponseImpl extends StateAwareResponseImpl
implements ResourceResponse, InternalResourceResponse {

	/**
     * Is it still allowed to invoke the method sendRedirect() ?
     */
	

    private PortalCallbackService callback;
    private PortalContext context;


    public ResourceResponseImpl(PortletContainer container,
                              InternalPortletWindow internalPortletWindow,
                              HttpServletRequest servletRequest,
                              HttpServletResponse servletResponse) {
        super(container, internalPortletWindow, servletRequest,
              servletResponse);
        context = container.getRequiredContainerServices().getPortalContext();
        callback = container.getRequiredContainerServices().getPortalCallbackService();
    }


	public CacheControl getCacheControl() {
		// TODO Auto-generated method stub
//		return null;
		throw new UnsupportedOperationException("This method needs to be implemented");
	}


	public String getContentType() {
		// TODO Auto-generated method stub
//		return null;
		throw new UnsupportedOperationException("This method needs to be implemented");
	}


	public OutputStream getPortletOutputStream() throws IOException {
		// TODO Auto-generated method stub
//		return null;
		throw new UnsupportedOperationException("This method needs to be implemented");
	}


	public void setTitle(String arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented");		
	}


	public void addProperty(Cookie cookie) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}
	
}
