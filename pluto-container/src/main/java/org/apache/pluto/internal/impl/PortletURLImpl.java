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

import java.util.List;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletWindow;

/**
 * Refactoring where functionality was pushed into JSR-286 <code>BaseURL</code>.
 *
 * @since 2.0
 */
public class PortletURLImpl extends BaseURLImpl implements PortletURL {

    public PortletURLImpl(PortletContainer container,
                          PortletWindow portletWindow,
                          javax.servlet.http.HttpServletRequest servletRequest,
                          javax.servlet.http.HttpServletResponse servletResponse,
                          boolean isAction) {
    	super(container,portletWindow,servletRequest,
    			servletResponse,isAction,false);
    }

    // javax.portlet.PortletURL -------------------------------------------------------------------
    public void setWindowState(WindowState windowState)
        throws WindowStateException {
        if (windowState != null && isWindowStateAllowed(windowState)) {
            state = windowState;
            return;
        }

        throw new WindowStateException(
            "unsupported Window State used: " + windowState, windowState);
    }

    public void setPortletMode(PortletMode portletMode)
        throws PortletModeException {
        // Test and throw exception if not allowed.
        isPortletModeAllowed(portletMode);
        mode = portletMode;
    }
    
    public javax.portlet.PortletMode getPortletMode(){
    	return super.getPortletMode();
    }
    public javax.portlet.WindowState getWindowState(){
    	return super.getWindowState();
    }

	public void removePublicRenderParameter(String name) {
		List<String> publicRenderParameterNames = portletWindow.getPortletEntity().getPortletDefinition().getSupportedPublicRenderParameters();
	    
	    if (publicRenderParameterNames != null){
	    	if (publicRenderParameterNames.contains(name)){
	    		publicRenderParameters.put(name,new String[] {null});
		    }
	    	else{
	    		throw new IllegalArgumentException(
	            	"name and value must not be null");
	    	}
	    }
	}

}
