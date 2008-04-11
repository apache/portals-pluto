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
import javax.portlet.PortletModeException;
import javax.portlet.RenderResponse;
import javax.portlet.StateAwareResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.internal.InternalRenderResponse;
import org.apache.pluto.spi.PortalCallbackService;
import org.apache.pluto.util.ArgumentUtility;
import org.apache.pluto.util.StringUtils;


/**
 * Implementation of the <code>javax.portlet.RenderResponse</code> interface.
 * 
 */
public class RenderResponseImpl extends MimeResponseImpl
implements RenderResponse, InternalRenderResponse {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(RenderResponseImpl.class);
	private String contenType;
    
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
		PortletMode tmpPortletMode = super.getInternalPortletWindow().getPortletMode();
		PortletMode portletMode = PortletMode.VIEW;
		boolean next = false;
		boolean first = true;
		for (PortletMode mode : portletModes) {
			if (first)
				portletMode = mode;
			if (next){
				portletMode = mode;
				next = false;
			}
			if (mode.equals(tmpPortletMode)){
				next = true;
			}
		}
		try {
			((StateAwareResponse)(super.getResponse())).setPortletMode(portletMode) ;
		} catch (PortletModeException e) {
            LOG.warn(e);
		}
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
	
	@Override
	public int getBufferSize() {
			return 0;
	}
	
	@Override
    public void setContentType(String contentType){
    	
    	if (super.isIncluded()){
    		//no operation
    	}
    	else{
    		ArgumentUtility.validateNotNull("contentType", contentType);
            String mimeType = StringUtils.getMimeTypeWithoutEncoding(contentType);
            if (!isValidContentType(mimeType)) {
                throw new IllegalArgumentException("Specified content type '"
                		+ mimeType + "' is not supported.");
            }
            getHttpServletResponse().setContentType(mimeType);
            this.contenType = contentType;
    	}
    }
	
	@Override
	public String getContentType() {
		return contenType;
    }
}
