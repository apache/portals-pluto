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
/* 

 */

package org.apache.pluto.core.impl;

import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.Constants;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.core.InternalPortletWindow;

/**
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates. To enable and disable the creation of type
 * comments go to Window>Preferences>Java>Code Generation.
 */
public class ActionRequestImpl
    extends PortletRequestImpl implements ActionRequest {
    /**
     * Holds the portlet preferences
     */
    private PortletPreferences portletPreferences;

    public ActionRequestImpl(PortletContainer container,
                             InternalPortletWindow internalPortletWindow,
                             HttpServletRequest servletRequest) {
        super(container, internalPortletWindow, servletRequest);
    }

    // javax.portlet.ActionRequest implementation -------------------------------------------------
    /* (non-Javadoc)
     * @see org.apache.pluto.core.InternalActionResponse#getPortletInputStream()
     */
    public InputStream getPortletInputStream() throws java.io.IOException {
        javax.servlet.http.HttpServletRequest servletRequest = (javax.servlet.http.HttpServletRequest) super.getRequest();

        if (servletRequest.getMethod().equals("POST")) {
            String contentType = servletRequest.getContentType();
            if (contentType == null ||
                contentType.equals("application/x-www-form-urlencoded")) {
                throw new java.lang.IllegalStateException(
                    "User request HTTP POST data is of type application/x-www-form-urlencoded. This data has been already processed by the portal/portlet-container and is available as request parameters.");
            }
        }
        return servletRequest.getInputStream();
    }

    // --------------------------------------------------------------------------------------------
    // PortletRequestImpl implementation ----------------------------------------------------------
    public PortletPreferences getPreferences() {
        if (this.portletPreferences == null) {
            portletPreferences = new PortletPreferencesImpl(getContainer(),
                                                            getWindow(), this,
                                                            Constants.METHOD_ACTION);
        }
        return this.portletPreferences;
    }
    // --------------------------------------------------------------------------------------------
}
