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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.portlet.PortalContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletSecurityException;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.apache.pluto.factory.PortletObjectAccess;
import org.apache.pluto.om.portlet.ContentType;
import org.apache.pluto.om.portlet.ContentTypeSet;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.services.information.InformationProviderAccess;
import org.apache.pluto.services.information.PortletURLProvider;

public class PortletURLImpl implements PortletURL {
    protected PortletMode mode = null;

    protected HashMap parameters = new HashMap();

    protected PortletWindow portletWindow;

    protected boolean secure;
    protected javax.servlet.http.HttpServletRequest servletRequest;
    protected javax.servlet.http.HttpServletResponse servletResponse;
    protected WindowState state;
    protected boolean isAction;

    public PortletURLImpl(PortletWindow portletWindow,
                          javax.servlet.http.HttpServletRequest servletRequest,
                          javax.servlet.http.HttpServletResponse servletResponse,
                          boolean isAction)
    {
        this.portletWindow = portletWindow;
        this.servletRequest = servletRequest;
        this.servletResponse = servletResponse;
        secure = servletRequest.isSecure();
        this.isAction = isAction;
    }

    // javax.portlet.PortletURL -------------------------------------------------------------------
    public void setWindowState(WindowState windowState) throws WindowStateException
    {
        PortalContext portalContext = PortletObjectAccess.getPortalContext();
        Enumeration supportedWindowStates = portalContext.getSupportedWindowStates();
        if (windowState != null) {
            while (supportedWindowStates.hasMoreElements()) {
                WindowState supportedWindowState = (WindowState)supportedWindowStates.nextElement();
                if (windowState.equals(supportedWindowState)) {
                    state = windowState;
                    return;             
                }
            }
        }
        throw new WindowStateException("unsupported Window State used: " + windowState,windowState);
    }

    public void setPortletMode (PortletMode portletMode) throws PortletModeException
    {
        if (isPortletModeSupported(portletMode,portletWindow)) {
            mode = portletMode;
            return;             
        }
        throw new PortletModeException("unsupported Portlet Mode used: " + portletMode,portletMode);
    }

    public void setParameter(String name, String value)
    {
        if (name == null || value == null) {
            throw new IllegalArgumentException("name and value must not be null");
        }

        parameters.put( name, value);
    }

    public void setParameter (String name, String[] values)
    {
        if (name == null || values == null || values.length == 0) {
            throw new IllegalArgumentException("name and values must not be null or values be an empty array");
        }

        parameters.put( name, values);
    }
    
    /* (non-Javadoc)
     * @see javax.portlet.PortletURL#setParameters(Map)
     */
    public void setParameters(Map parameters) {
        if (parameters == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        for (Iterator iter = parameters.entrySet().iterator(); iter.hasNext();) {
            Map.Entry entry = (Map.Entry)iter.next();
            if (!(entry.getKey() instanceof String)) {
                throw new IllegalArgumentException("Key must not be null and of type java.lang.String.");
            }
            if (!(entry.getValue() instanceof String[])) {
                throw new IllegalArgumentException("Value must not be null and of type java.lang.String[].");
            }
        }

        this.parameters = new HashMap(parameters);
    }

    public void setSecure (boolean secure) throws PortletSecurityException
    {
        this.secure = secure;
    }
    
    public String toString()
    {
        StringBuffer url = new StringBuffer(200);                                                                   

        PortletURLProvider urlProvider = InformationProviderAccess.getDynamicProvider(servletRequest).getPortletURLProvider(portletWindow);

        if (mode != null) {
            urlProvider.setPortletMode(mode);
        }
        if (state != null) {
            urlProvider.setWindowState(state);
        }
        if (isAction) {
            urlProvider.setAction();
        }
        if (secure) {
            urlProvider.setSecure();
        }
        urlProvider.clearParameters();
        urlProvider.setParameters(parameters);

        url.append(urlProvider.toString());

        return url.toString();
    }
    // --------------------------------------------------------------------------------------------

    // internal methods ---------------------------------------------------------------------------
    private boolean isPortletModeSupported(PortletMode requestedPortletMode,PortletWindow referencedPortletWindow) {
        PortletDefinition portletDefinition = referencedPortletWindow.getPortletEntity().getPortletDefinition();
        ContentTypeSet contentTypes = portletDefinition.getContentTypeSet();
        ContentType contentType = contentTypes.get("text/html");
        Iterator portletModes = contentType.getPortletModes();
        if (requestedPortletMode != null) {
            while (portletModes.hasNext()) {
                PortletMode supportedPortletMode = (PortletMode)portletModes.next();
                if (requestedPortletMode.equals(supportedPortletMode)) {
                    return true;
                }
            }
        }
        return false;
    }
    // --------------------------------------------------------------------------------------------

    // additional methods -------------------------------------------------------------------------
    public String getParameter(String name)
    {
        return(String)parameters.get(name);
    }

    public String[] getParameters(String name)
    {
        return(String[])parameters.get(name);
    }

    public PortletMode getPortletMode ()
    {
        return mode;
    }

    public WindowState getWindowState ()
    {
        return state;
    }
    // --------------------------------------------------------------------------------------------
}
