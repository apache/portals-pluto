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
package org.apache.pluto.wrappers;

import java.util.Enumeration;
import java.util.Map;

import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.StateAwareResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.xml.namespace.QName;

public class ActionResponseWrapper extends PortletResponseWrapper
    implements ActionResponse {

    /**
     * Creates a ServletResponse adaptor wrapping the given response object.
     * @throws java.lang.IllegalArgumentException
     *          if the response is null.
     */
    public ActionResponseWrapper(ActionResponse actionResponse) {
        super(actionResponse);

        if (actionResponse == null) {
            throw new IllegalArgumentException("Response cannot be null");
        }
    }

    // javax.portlet.ActionResponse implementation ------------------------------------------------
    public void setWindowState(WindowState windowState)
        throws WindowStateException {
        this.getActionResponse().setWindowState(windowState);
    }

    public void setPortletMode(PortletMode portletMode)
        throws PortletModeException {
        this.getActionResponse().setPortletMode(portletMode);
    }

    public void sendRedirect(String location) throws java.io.IOException {
        this.getActionResponse().sendRedirect(location);
    }

    public void setRenderParameters(Map<String, String[]> parameters) {
        this.getActionResponse().setRenderParameters(parameters);
    }

    public void setRenderParameter(String key, String value) {
        this.getActionResponse().setRenderParameter(key, value);
    }

    public void setRenderParameter(String key, String[] values) {
        this.getActionResponse().setRenderParameter(key, values);
    }

    // --------------------------------------------------------------------------------------------

    // additional methods -------------------------------------------------------------------------
    /**
     * Return the wrapped ServletResponse object.
     */
    public ActionResponse getActionResponse() {
        return (ActionResponse) getPortletResponse();
    }

    public StateAwareResponse getStateAwareResponse(){
    	return (StateAwareResponse) getPortletResponse();
    }

	public void setEvent(QName qname, java.io.Serializable value) {
		this.getStateAwareResponse().setEvent(qname, value);
	}

	public void setEvents(Map<javax.xml.namespace.QName, java.io.Serializable> events) {
		// TODO look for setEvents in StateAwareResponse
//		this.getStateAwareResponse().setEvents(events);		
	}
    // --------------------------------------------------------------------------------------------

	public PortletMode getPortletMode() {
		return this.getStateAwareResponse().getPortletMode();
	}

	public Map getRenderParameterMap() {
		return this.getStateAwareResponse().getRenderParameterMap();
	}

	public WindowState getWindowState() {
		return this.getStateAwareResponse().getWindowState();
	}

	public void setNextPossiblePortletModes(Enumeration portletModes) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}

	public void setDefaultNamespacedEvents(Map<String, Object> events) {
		// TODO Auto-generated method stub
		
	}

	public void setEvent(String name, java.io.Serializable value) {
		// TODO Auto-generated method stub
		
	}
}

