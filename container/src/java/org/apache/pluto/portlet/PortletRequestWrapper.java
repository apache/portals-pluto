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

package org.apache.pluto.portlet;

import java.util.Enumeration;

import javax.portlet.*;

public class PortletRequestWrapper extends javax.servlet.http.HttpServletRequestWrapper 
implements PortletRequest 
{

    /**
    * Creates a ServletRequest adaptor wrapping the given request object.
    * @throws java.lang.IllegalArgumentException if the request is null.
    */
    public PortletRequestWrapper(PortletRequest portletRequest)
    {
        super((javax.servlet.http.HttpServletRequest)portletRequest);

        if (portletRequest == null) 
        {
            throw new IllegalArgumentException("Request cannot be null");
        }
    }

    // javax.portlet.PortletRequest implementation -------------------------------------------------
    public boolean isWindowStateAllowed(WindowState state)
    {
        return this.getPortletRequest().isWindowStateAllowed(state);
    }
    
    public boolean isPortletModeAllowed(PortletMode mode)
    {
        return this.getPortletRequest().isPortletModeAllowed(mode);
    }

    public PortletMode getPortletMode()
    {
        return this.getPortletRequest().getPortletMode();
    }

    public WindowState getWindowState()
    {
        return this.getPortletRequest().getWindowState();
    }
    
    public PortletPreferences getPreferences()
    {
        return this.getPortletRequest().getPreferences();
    }
    
    public PortletSession getPortletSession()
    {
        return this.getPortletRequest().getPortletSession();
    }

    public PortletSession getPortletSession(boolean create)
    {
        return this.getPortletRequest().getPortletSession(create);
    }

    public String getProperty(String name)
    {
        return this.getPortletRequest().getProperty(name);      
    }

    public Enumeration getProperties(String name)
    {
        return this.getPortletRequest().getProperties(name);
    }

    public Enumeration getPropertyNames()
    {
        return this.getPortletRequest().getPropertyNames();
    }

    public PortalContext getPortalContext()
    {
        return this.getPortletRequest().getPortalContext();
    }

    public java.lang.String getAuthType()
    {
        return this.getPortletRequest().getAuthType();
    }

    public String getContextPath()
    {
        return this.getPortletRequest().getContextPath();
    }

    public java.lang.String getRemoteUser()
    {
        return this.getPortletRequest().getRemoteUser();
    }

    public java.security.Principal getUserPrincipal()
    {
        return this.getPortletRequest().getUserPrincipal();
    }

    public boolean isUserInRole(java.lang.String role)
    {
        return this.getPortletRequest().isUserInRole(role);
    }

    public Object getAttribute(String name)
    {
        return this.getPortletRequest().getAttribute(name);
    }

    public java.util.Enumeration getAttributeNames()
    {
        return this.getPortletRequest().getAttributeNames();
    }

    public String getParameter(String name)
    {
        return this.getPortletRequest().getParameter(name);
    }
    
    public java.util.Enumeration getParameterNames()
    {
        return this.getPortletRequest().getParameterNames();
    }
    
    public String[] getParameterValues(String name)
    {
        return this.getPortletRequest().getParameterValues(name);
    }

    public java.util.Map getParameterMap()
    {
        return this.getPortletRequest().getParameterMap();
    }

    public boolean isSecure()
    {
        return this.getPortletRequest().isSecure();
    }

    public void setAttribute(String name, Object o)
    {
        this.getPortletRequest().setAttribute(name,o);
    }
   
    public void removeAttribute(String name)
    {
        this.getPortletRequest().removeAttribute(name);
    }
    
    public String getRequestedSessionId()
    {
        return this.getPortletRequest().getRequestedSessionId();
    }

    public boolean isRequestedSessionIdValid()
    {
        return this.getPortletRequest().isRequestedSessionIdValid();
    }
    
    public String getResponseContentType()
    {
        return this.getPortletRequest().getResponseContentType();
    }
    
    public java.util.Enumeration getResponseContentTypes()
    {
        return this.getPortletRequest().getResponseContentTypes();
    }
    
    public java.util.Locale getLocale()
    {
        return this.getPortletRequest().getLocale();
    }
    
    public java.util.Enumeration getLocales()
    {
        return this.getPortletRequest().getLocales();
    }

    public String getScheme()
    {
        return this.getPortletRequest().getScheme();
    }
    
    public String getServerName()
    {
        return this.getPortletRequest().getServerName();
    }
    
    public int getServerPort()
    {
        return this.getPortletRequest().getServerPort();
    }

    // --------------------------------------------------------------------------------------------
    
    // additional methods -------------------------------------------------------------------------
    /**
    * Return the wrapped ServletRequest object.
    */
    public PortletRequest getPortletRequest()
    {
        return (PortletRequest) super.getRequest();
    }
    
    /**
    * Sets the request being wrapped. 
    * @throws java.lang.IllegalArgumentException if the request is null.
    */
    public void setRequest(PortletRequest request)
    {
        if (request == null) 
        {
            throw new IllegalArgumentException("Request cannot be null");
        }    
        setRequest((javax.servlet.http.HttpServletRequest)request);
    }
    // --------------------------------------------------------------------------------------------
}

