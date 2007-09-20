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

import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletMode;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.internal.InternalRenderResponse;
import org.apache.pluto.spi.PortalCallbackService;

/**
 * Implementation of the <code>javax.portlet.RenderResponse</code> interface.
 * 
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class RenderResponseImpl extends MimeResponseImpl
implements RenderResponse, InternalRenderResponse {
    
    public RenderResponseImpl(PortletContainer container,
                              InternalPortletWindow internalPortletWindow,
                              HttpServletRequest servletRequest,
                              HttpServletResponse servletResponse) {
        super(container, internalPortletWindow, servletRequest, servletResponse);
    }
    

    public void setTitle(String title) {
        PortalCallbackService callback = getContainer()
        		.getRequiredContainerServices()
        		.getPortalCallbackService();
        callback.setTitle(this.getHttpServletRequest(),
                          getInternalPortletWindow(),
                          title);
    }

	public void setNextPossiblePortletModes(Collection<PortletMode> portletModes) {
		//TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
		
	}
	
	@Override
	public void setCharacterEncoding(String arg0) {
		if (super.isIncluded() || super.isForwarded()){
			//no operation
		}
		else
			super.setCharacterEncoding(arg0);
	}

	@Override
	public void setContentLength(int arg0) {
		if (super.isIncluded() || super.isForwarded()){
			//no operation
		}
		else
			super.setContentLength(arg0);
	}

	@Override
	public void setLocale(Locale arg0) {
		if (super.isIncluded() || super.isForwarded()){
			//no operation
		}
		else
			super.setLocale(arg0);
	}
	
}
