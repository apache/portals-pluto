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
import java.util.Set;

import javax.portlet.ActionResponse;
import javax.portlet.PortletModeException;
import javax.portlet.PortletURL;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.internal.InternalActionResponse;
import org.apache.pluto.spi.ResourceURLProvider;

public class ActionResponseImpl extends StateAwareResponseImpl
implements ActionResponse, InternalActionResponse {

	/** Logger. */
    private static final Log LOG = LogFactory.getLog(ActionResponseImpl.class);

    public ActionResponseImpl(PortletContainer container,
                              PortletWindow portletWindow,
                              HttpServletRequest servletRequest,
                              HttpServletResponse servletResponse) {
        super(container, portletWindow, servletRequest,
              servletResponse);
    }

	@Override
	public void sendRedirect(String location) throws IOException {
		if (super.isIncluded()){
			// no operation
		}
		super.sendRedirect(location);
	}

	public void sendRedirect(String location, String renderUrlParamName) throws IOException {
		
        if (location != null) {
            HttpServletResponse redirectResponse = getHttpServletResponse();
            while (redirectResponse instanceof HttpServletResponseWrapper) {
                redirectResponse = (HttpServletResponse)
                    ((HttpServletResponseWrapper)redirectResponse).getResponse();
            }

            ResourceURLProvider provider = super.callback.getResourceURLProvider(
                            getHttpServletRequest(),
                            getPortletWindow()
            );

            if (location.indexOf("://") != -1) {
                provider.setAbsoluteURL(location);
            } else {
                provider.setFullPath(location);
            }
            location =
            	redirectResponse.encodeRedirectURL(provider.toString());
            //add the currently windows state, portlet mode, render parameter and current public parameter
            String renderURL = getCurrentRenderURL();
            if (location.indexOf("?") != -1){
            	//add the URL to the other Parameters
            	location += "&" + renderUrlParamName + "=" +renderURL;
            }
            else{
            	//first Query Parameter
            	location += "?" + renderUrlParamName + "=" +renderURL;
            }
            
            redirectResponse.sendRedirect(location);
            super.redirected = true;
        }
	}
	private String getCurrentRenderURL(){
        PortletURL renderURL = createRenderURL();
		try {
			if (getPortletMode()!= null)
				renderURL.setPortletMode(getPortletMode());
			if (getWindowState() != null)
				renderURL.setWindowState(getWindowState());
			if (getRenderParameterMap()!= null)
				renderURL.setParameters(getRenderParameterMap());
			if (getPublicRenderParameter() != null){
				Set<String> keys = getPublicRenderParameter().keySet();
				if (keys != null){
					for (String string : keys) {
						renderURL.setParameter(string, getPublicRenderParameter().get(string));
					}
				}
			}
		} catch (PortletModeException e) {
            LOG.warn(e);
		} catch (WindowStateException e) {
            LOG.warn(e);
		}
		return renderURL.toString();
	}
}
