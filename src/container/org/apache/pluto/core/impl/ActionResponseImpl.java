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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.apache.pluto.core.InternalActionResponse;
import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.services.information.DynamicInformationProvider;
import org.apache.pluto.services.information.InformationProviderAccess;
import org.apache.pluto.services.information.ResourceURLProvider;

public class ActionResponseImpl extends PortletResponseImpl
implements ActionResponse, InternalActionResponse {

    /**
     * Is it still allowed to invoke the method sendRedirect() ?
     */
    boolean redirectAllowed = true;

    private boolean redirected;
    private String redirectLocation;

    private Map renderParameters = new HashMap();
    private WindowState windowState = null;
    private PortletMode portletMode = null;

    private DynamicInformationProvider provider;


    public ActionResponseImpl(PortletWindow portletWindow,
                              javax.servlet.http.HttpServletRequest servletRequest,
                              javax.servlet.http.HttpServletResponse servletResponse)
    {
        super(portletWindow, servletRequest, servletResponse);

        provider = InformationProviderAccess.getDynamicProvider(getHttpServletRequest());

    }

    // javax.portlet.ActionResponse ---------------------------------------------------------------
    public void setWindowState (WindowState windowState) throws WindowStateException
    {
        if (redirected) {
            throw new IllegalStateException("it is not allowed to invoke setWindowState after sendRedirect has been called");
        }

        if (provider.isWindowStateAllowed(windowState)) {
            this.windowState = windowState;
        } else {
            throw new WindowStateException("Can't set this WindowState",windowState);
        }
        redirectAllowed = false;
    }
    
    public void setPortletMode (PortletMode portletMode) throws PortletModeException
    {
        if (redirected) {
            throw new IllegalStateException("it is not allowed to invoke setPortletMode after sendRedirect has been called");
        }

        // check if portal supports portlet mode
        boolean supported = provider.isPortletModeAllowed(portletMode);

        // check if portlet supports portlet mode as well
        supported &= PortletModeHelper.isPortletModeAllowedByPortlet(getInternalPortletWindow(), this.getHttpServletRequest().getContentType(), portletMode);

        // if porlet mode is allowed
        if (supported) {
            this.portletMode = portletMode;
        } else
            throw new PortletModeException("Can't set this PortletMode",portletMode);

        redirectAllowed = false;
    }

    public void sendRedirect(String location) throws java.io.IOException
    {
        if (redirectAllowed) {
            if (location != null) {
                javax.servlet.http.HttpServletResponse redirectResponse = _getHttpServletResponse();
                while (redirectResponse instanceof javax.servlet.http.HttpServletResponseWrapper) {
                    redirectResponse = (javax.servlet.http.HttpServletResponse)
                                       ((javax.servlet.http.HttpServletResponseWrapper)redirectResponse).getResponse();
                }
                ResourceURLProvider provider = InformationProviderAccess.getDynamicProvider(getHttpServletRequest()).getResourceURLProvider(getInternalPortletWindow());
                if (location.indexOf("://") != -1) {
                    provider.setAbsoluteURL(location);
                } else {
                    provider.setFullPath(location);
                }
                location = redirectResponse.encodeRedirectURL(provider.toString());
                //redirectResponse.sendRedirect(location);
                redirectLocation = location;
                redirected = true;
            }
        } else
            throw new java.lang.IllegalStateException("Can't invoke sendRedirect() after certain methods have been called");

    }
    
    public void setRenderParameters(Map parameters)
    {
        if (redirected) {
            throw new IllegalStateException("Can't invoke setRenderParameters() after sendRedirect() has been called");
        }
        if (parameters == null) {
            throw new IllegalArgumentException("Render parameters must not be null.");
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

        renderParameters.putAll(parameters);

        redirectAllowed = false;
    }
    
    public void setRenderParameter(String key, String value)
    {
        if (redirected) {
            throw new IllegalStateException("Can't invoke setRenderParameter() after sendRedirect() has been called");
        }

        if ((key == null) || (value == null)) {
            throw new IllegalArgumentException("Render parameter key or value must not be null.");
        }

        renderParameters.put(key, new String[] {value});

        redirectAllowed = false;
    }
    
    public void setRenderParameter(String key, String[] values)
    {
        if (redirected) {
            throw new IllegalStateException("Can't invoke setRenderParameter() after sendRedirect() has been called");
        }

        if (key == null || values == null || values.length == 0) {
            throw new IllegalArgumentException("Render parameter key or value must not be null or values be an empty array.");
        }

        renderParameters.put(key, values);

        redirectAllowed = false;
    }
    // --------------------------------------------------------------------------------------------
    
    // org.apache.pluto.core.InternalActionResponse implementation --------------------------------
    public Map getRenderParameters()
    {
        return renderParameters;
    }

    public PortletMode getChangedPortletMode()
    {
        return this.portletMode;
    }

    public WindowState getChangedWindowState()
    {
        return this.windowState;
    }

    public String getRedirectLocation() {
        return redirectLocation;
    }
    // --------------------------------------------------------------------------------------------
}
