/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
/* 

 */

package org.apache.pluto.core.impl;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletSecurityException;
import javax.portlet.PortletURL;
import javax.portlet.PortalContext;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.apache.pluto.Constants;
import org.apache.pluto.factory.PortletObjectAccess;
import org.apache.pluto.services.information.InformationProviderAccess;
import org.apache.pluto.services.information.PortletURLProvider;
import org.apache.pluto.om.portlet.ContentType;
import org.apache.pluto.om.portlet.ContentTypeSet;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.window.PortletWindow;

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
        // This implementation does assume not having a supporting security environment installed! 
        if (secure == true) {
            throw new PortletSecurityException(
                "The current implementation does assume not having a supporting security environment installed!"
            );
        }

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
