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

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletResponse;
import javax.servlet.ServletOutputStream;

import org.apache.pluto.core.InternalPortletResponse;
import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.services.information.InformationProviderAccess;
import org.apache.pluto.services.information.ResourceURLProvider;
import org.apache.pluto.services.property.PropertyManager;
import org.apache.pluto.util.PrintWriterServletOutputStream;

public abstract class PortletResponseImpl extends javax.servlet.http.HttpServletResponseWrapper 
implements InternalPortletResponse, PortletResponse
{

    private PortletWindow portletWindow;

    /**
     * this variable holds the servlet request of the target/portlet's
     * web module
     */
    private javax.servlet.http.HttpServletRequest webModuleServletRequest;

    private boolean usingWriter;
    private boolean usingStream;

    private ServletOutputStream wrappedWriter;

    public PortletResponseImpl(PortletWindow portletWindow,
                               javax.servlet.http.HttpServletRequest servletRequest,
                               javax.servlet.http.HttpServletResponse servletResponse)
    {
        super(servletResponse);

        this.webModuleServletRequest = servletRequest;
        this.portletWindow = portletWindow;
    }

    // javax.portlet.PortletResponse --------------------------------------------------------------
    public void addProperty(String key, String value) 
    {
        if (key == null)
        {
            throw new IllegalArgumentException("Property key == null");
        }

        // get properties from PropertyManager
        Map map = PropertyManager.getRequestProperties(portletWindow, this.getHttpServletRequest());
        if (map == null)
        {
            map = new HashMap();
        }

        String[] properties = (String[]) map.get(key);
        if (properties == null)
        {
            properties = new String[]{value};
        }
        else
        {
            properties[properties.length] = value;
        }

        map.put(key, properties);

        PropertyManager.setResponseProperties(portletWindow, this.getHttpServletRequest(), _getHttpServletResponse(), map);
    }
    
    public void setProperty(String key, String value) 
    {
        if (key == null)
        {
            throw new IllegalArgumentException("Property key == null");
        }

        // get properties from PropertyManager
        Map map = PropertyManager.getRequestProperties(portletWindow, this.getHttpServletRequest());
        if (map == null)
        {
            map = new HashMap();
        }

        String[] properties = new String[]{value};

        map.put(key, properties);

        PropertyManager.setResponseProperties(portletWindow, getHttpServletRequest(), _getHttpServletResponse(), map);
    }
    
    public String encodeURL(String path)
    {
        if (path.indexOf("://") == -1 && !path.startsWith("/"))
        {
            throw new IllegalArgumentException("only absolute URLs or full path URIs are allowed");
        }
        ResourceURLProvider provider = InformationProviderAccess.getDynamicProvider(getHttpServletRequest()).getResourceURLProvider(portletWindow);
        if (path.indexOf("://") != -1)
        {
            provider.setAbsoluteURL(path);
        }
        else
        {
            provider.setFullPath(path);
        }
        return this._getHttpServletResponse().encodeURL(provider.toString());
    }
    // --------------------------------------------------------------------------------------------

    // org.apache.pluto.core.InternalPortletResponse implementation -------------------------------
    public void lateInit(javax.servlet.http.HttpServletRequest webModuleServletRequest,
                         javax.servlet.http.HttpServletResponse webModuleServletResponse)
    {
        this.webModuleServletRequest = webModuleServletRequest;
        this.setResponse(webModuleServletResponse);
    }
    // --------------------------------------------------------------------------------------------

    // internal methods ---------------------------------------------------------------------------
    protected javax.servlet.http.HttpServletResponse _getHttpServletResponse()
    {
        return(javax.servlet.http.HttpServletResponse) super.getResponse();
    }

    protected javax.servlet.http.HttpServletRequest getHttpServletRequest()
    {
        return webModuleServletRequest;
    }
    // --------------------------------------------------------------------------------------------

    // additional methods -------------------------------------------------------------------------
    // servlet-only implementation 
    // (inherited from HttpServletResponseWrapper)
    public void addCookie(javax.servlet.http.Cookie cookie)
    {
        this._getHttpServletResponse().addCookie(cookie);
    }

    public boolean containsHeader(String name)
    {
        return this._getHttpServletResponse().containsHeader(name);
    }

    public String encodeRedirectUrl(String url)
    {
        return this._getHttpServletResponse().encodeRedirectUrl(url);
    }

    public String encodeRedirectURL(String url)
    {
        return this._getHttpServletResponse().encodeRedirectURL(url);
    }

    public void sendRedirect(String location) throws java.io.IOException
    {
        this._getHttpServletResponse().sendRedirect(location);
    }

    public void setDateHeader(String name, long date)
    {
        this._getHttpServletResponse().setDateHeader(name,date);
    }

    public void sendError(int sc, String msg) throws java.io.IOException
    {
        this._getHttpServletResponse().sendError(sc,msg);
    }

    public void sendError(int sc) throws java.io.IOException
    {
        this._getHttpServletResponse().sendError(sc);
    }

    public void addHeader(String name, String value)
    {
        this._getHttpServletResponse().addHeader(name,value);
    }

    public void setIntHeader(String name, int value)
    {
        this._getHttpServletResponse().setIntHeader(name,value);
    }

    public void addDateHeader(String name, long date)
    {
        this._getHttpServletResponse().addDateHeader(name,date);
    }

    public void setHeader(String name, String value)
    {
        this._getHttpServletResponse().setHeader(name,value);
    }

    public void setStatus(int sc)
    {
        this._getHttpServletResponse().setStatus(sc);
    }

    public void setStatus(int sc, String sm)
    {
        this._getHttpServletResponse().setStatus(sc,sm);
    }

    public void addIntHeader(String name, int value)
    {
        this._getHttpServletResponse().addIntHeader(name,value);
    }

    public void setContentLength(int len)
    {
        this._getHttpServletResponse().setContentLength(len);
    }

    public String encodeUrl(String url)
    {
        return this.encodeURL(url);
    }

    public void setLocale(java.util.Locale loc)
    {
        this._getHttpServletResponse().setLocale(loc);
    }

    public ServletOutputStream getOutputStream() throws IllegalStateException, IOException {
        if (usingWriter)
        {
            throw new IllegalStateException("getPortletOutputStream can't be used after getWriter was invoked");
        }

        if (wrappedWriter == null)
        {
            wrappedWriter = new PrintWriterServletOutputStream(_getHttpServletResponse().getWriter(),
                                                               _getHttpServletResponse().getCharacterEncoding());
        }

        usingStream = true;

        return wrappedWriter;
    }

    public PrintWriter getWriter() throws UnsupportedEncodingException, IllegalStateException, IOException {
        if (usingStream)
        {
            throw new IllegalStateException("getWriter can't be used after getOutputStream was invoked");
        }

        usingWriter = true;

        return _getHttpServletResponse().getWriter();
    }

    // other
    public PortletWindow getInternalPortletWindow()
    {
        return portletWindow;
    }
    // --------------------------------------------------------------------------------------------
}
