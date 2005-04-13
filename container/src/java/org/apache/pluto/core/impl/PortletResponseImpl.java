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

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.core.InternalPortletResponse;
import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.services.information.InformationProviderAccess;
import org.apache.pluto.services.information.ResourceURLProvider;
import org.apache.pluto.services.property.PropertyManager;
import org.apache.pluto.util.PrintWriterServletOutputStream;

public abstract class PortletResponseImpl extends javax.servlet.http.HttpServletResponseWrapper 
implements InternalPortletResponse, PortletResponse
{

    PortletWindow portletWindow;

    /**
     * this variable holds the servlet request of the target/portlet's
     * web module
     */
    private javax.servlet.http.HttpServletRequest webModuleServletRequest;

    private boolean usingWriter;
    private boolean usingStream;

    private ServletOutputStream wrappedWriter;
    private Map properties;

    /**
     * true if we are in an include call
     */
    private boolean included;

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

        Map props = getProperties();
        
        String[] oldValues = (String[]) props.get(key);
        String[] newValues = null;
        if (oldValues == null)
        {
            newValues = new String[]{value}; 
        }
        else
        {
            int len = oldValues.length;
            newValues = new String[len+1];
            System.arraycopy(oldValues, 0, newValues, 0, len);
            newValues[len] = value;
        }
        props.put(key, newValues);

        PropertyManager.setResponseProperties(portletWindow, this.getHttpServletRequest(), _getHttpServletResponse(), props);

    }
    
    public void setProperty(String key, String value) 
    {
        if (key == null)
        {
            throw new IllegalArgumentException("Property key == null");
        }

        Map props = getProperties();
        
        String[] newValues = new String[]{value}; 
        props.put(key, newValues);

        PropertyManager.setResponseProperties(portletWindow, this.getHttpServletRequest(), _getHttpServletResponse(), props);
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

    private Map getProperties() {
        if (properties == null)
            properties = new HashMap();
        return properties;
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

    /**
     * @deprecated use encodeRedirectURL instead
     */
    public String encodeRedirectUrl(String url)
    {
        return included ? null : this._getHttpServletResponse().encodeRedirectUrl(url);
    }

    public String encodeRedirectURL(String url)
    {
        return included ? null : this._getHttpServletResponse().encodeRedirectURL(url);
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

    /**
     * @deprecated As of version 2.1, due to ambiguous meaning 
     * of the message parameter. To set a status code use 
     * setStatus(int), to send an error with a description 
     * use sendError(int, String). Sets the status code and 
     * message for this response.
     */
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
            wrappedWriter = new PrintWriterServletOutputStream(
                _getHttpServletResponse().getWriter(),
                _getHttpServletResponse().getCharacterEncoding()
            );
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
    
    // internal
    
    HttpServletRequest getHttpDServletRequest()
    {
        return webModuleServletRequest;
    }

   public void setIncluded(boolean included)
   {
       this.included = included;
   }

   public boolean isIncluded()
   {
       return included;
   }
}
