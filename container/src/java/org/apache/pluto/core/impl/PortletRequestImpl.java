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

import java.io.BufferedReader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.portlet.PortalContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.WindowState;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.pluto.core.InternalPortletRequest;
import org.apache.pluto.factory.PortletObjectAccess;
import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.services.information.DynamicInformationProvider;
import org.apache.pluto.services.information.InformationProviderAccess;
import org.apache.pluto.services.property.PropertyManager;
import org.apache.pluto.util.Enumerator;
import org.apache.pluto.util.NamespaceMapperAccess;

public abstract class PortletRequestImpl extends javax.servlet.http.HttpServletRequestWrapper
implements PortletRequest, InternalPortletRequest
{

    private PortletWindow portletWindow;

    /**
     * Holds the portlet session
     */
    private PortletSession portletSession;

    private DynamicInformationProvider provider;

    /**
     * true if the HTTP-Body has been accessed
     */
    private boolean bodyAccessed;

    /**
     * true if we are in an include call
     */
    private boolean included;

    public PortletRequestImpl(PortletWindow portletWindow,
                              javax.servlet.http.HttpServletRequest servletRequest)
    {
        super(servletRequest);
        this.portletWindow = portletWindow;

        provider = InformationProviderAccess.getDynamicProvider(_getHttpServletRequest());
    }

    // javax.portlet.PortletRequest implementation ------------------------------------------------
    public boolean isWindowStateAllowed(WindowState state)
    {
        return provider.isWindowStateAllowed(state);
    }

    public boolean isPortletModeAllowed(PortletMode portletMode)
    {
        // check if portal supports portlet mode
        boolean supported = provider.isPortletModeAllowed(portletMode);

        // check if portlet supports portlet mode as well
        if (supported)
        {
            supported = PortletModeHelper.isPortletModeAllowedByPortlet(portletWindow, portletMode);
        }

        return supported;
    }
    
    public PortletMode getPortletMode()
    {
        return provider.getPortletMode(portletWindow);
    }
    
    public WindowState getWindowState()
    {
        return provider.getWindowState(portletWindow);
    }

    // needs to be implemented in each subclass
    public abstract PortletPreferences getPreferences();
    
    public PortletSession getPortletSession()
    {
        return getPortletSession(true);
    }
    
    public PortletSession getPortletSession(boolean create)
    {
        // check if the session was invalidated
        javax.servlet.http.HttpSession httpSession = this._getHttpServletRequest().getSession(false);

        if ((portletSession != null) && (httpSession == null))
        {
        	portletSession = null;
        }
        else if (httpSession != null)
        {
        	create = true;
        }

        if (create && portletSession == null)
        {
        	httpSession = this._getHttpServletRequest().getSession(create);
        	if (httpSession != null)
        	{
        		portletSession = PortletObjectAccess.getPortletSession(portletWindow, httpSession);
        	}
        }

        return portletSession;
    }
    
    public String getProperty(String name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Attribute name == null");
        }

        // get properties from request header
        String prop = this._getHttpServletRequest().getHeader(name);
        if (prop == null)
        {
            // get properties from PropertyManager
            Map map = PropertyManager.getRequestProperties(portletWindow, this._getHttpServletRequest());
            if (map != null)
            {
                String[] properties = (String[]) map.get(name);
                if ((properties != null) && (properties.length > 0))
                {
                    prop = properties[0];
                }
            }
        }

        return prop;
    }

    public Enumeration getProperties(String name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Property name == null");
        }

        Set v = new HashSet();

        // get properties from request header
        Enumeration props = this._getHttpServletRequest().getHeaders(name);
        if (props != null)
        {
            while (props.hasMoreElements())
            {
                v.add(props.nextElement());
            }
        }

        // get properties from PropertyManager
        Map map = PropertyManager.getRequestProperties(portletWindow, this._getHttpServletRequest());
        if (map != null)
        {
            String[] properties = (String[]) map.get(name);

            if (properties != null)
            {
                // add properties to vector
                for (int i=0;i<properties.length;i++)
                {
                    v.add(properties[i]);
                }
            }
        }

        return new Enumerator(v.iterator());
    }
        
    public Enumeration getPropertyNames()
    {
        Set v = new HashSet();           

        // get properties from PropertyManager
        Map map = PropertyManager.getRequestProperties(portletWindow, this._getHttpServletRequest());
        if (map != null)
        {
            Iterator propsIter = map.keySet().iterator();

            while (propsIter.hasNext())
            {
                v.add(propsIter.next());
            }
        }

        // get properties from request header
        Enumeration props =  this._getHttpServletRequest().getHeaderNames();
        if (props != null)
        {
            while (props.hasMoreElements())
            {
                v.add(props.nextElement());
            }
        }

        return new Enumerator(v.iterator());
    }

    public PortalContext getPortalContext()
    {
        return PortletObjectAccess.getPortalContext();
    }

    public String getAuthType()
    {
        return this._getHttpServletRequest().getAuthType();
    }

    public String getContextPath()
    {
        return portletWindow.getPortletEntity().getPortletDefinition().getPortletApplicationDefinition().getWebApplicationDefinition().getContextRoot();

        // we cannot use that because of a bug in tomcat
        // return this._getHttpServletRequest().getContextPath();
    }

    public String getRemoteUser()
    {
        return this._getHttpServletRequest().getRemoteUser();
    }

    public java.security.Principal getUserPrincipal()
    {
        return this._getHttpServletRequest().getUserPrincipal();
    }

    public boolean isUserInRole(String role)
    {
        return this._getHttpServletRequest().isUserInRole(role);
    }

    public Object getAttribute(String name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Attribute name == null");
        }

        Object attribute = this._getHttpServletRequest().getAttribute(
                                                                     NamespaceMapperAccess.getNamespaceMapper().encode(portletWindow.getId(),name)
                                                                     );

        if (attribute==null)
        {
            // TBD, not sure, if this should be done for all attributes or only javax.servlet.
            attribute = this._getHttpServletRequest().getAttribute(name);
        }
        return attribute;
    }

    public Enumeration getAttributeNames()
    {
        Enumeration attributes = this._getHttpServletRequest().getAttributeNames();

        Vector portletAttributes = new Vector();

        while (attributes.hasMoreElements())
        {
            String attribute = (String)attributes.nextElement();

            String portletAttribute = NamespaceMapperAccess.getNamespaceMapper().decode(portletWindow.getId(),attribute);

            if (portletAttribute!=null)
            { // it is in the portlet's namespace
                portletAttributes.add(portletAttribute);
            }
        }

        return portletAttributes.elements();
    }

    public String getParameter(String name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Parameter name == null");
        }

        bodyAccessed = true;

        Map parameters = this._getHttpServletRequest().getParameterMap();
        String[] values = (String[])parameters.get(name);
        if (values != null)
        {
            return values[0];
        }
        return null;
    }

    public java.util.Enumeration getParameterNames()
    {
        bodyAccessed = true;

        Map parameters = this._getHttpServletRequest().getParameterMap();
        return Collections.enumeration(parameters.keySet());
    }

    public String[] getParameterValues(String name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Parameter name == null");
        }

        bodyAccessed = true;

        Map parameters = this._getHttpServletRequest().getParameterMap();
        return(String[])parameters.get(name);
    }

    public Map getParameterMap()
    {
        bodyAccessed = true;

        return Collections.unmodifiableMap(this._getHttpServletRequest().getParameterMap());
    }

    public boolean isSecure()
    {
        return this._getHttpServletRequest().isSecure();
    }

    public void setAttribute(String name, Object o)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Attribute name == null");
        }

        if ( o == null)
        {
            this.removeAttribute(name);
        }
        else if (isNameReserved(name))
        {
            // Reserved names go directly in the underlying request
            _getHttpServletRequest().setAttribute(name, o);
        }
        else
        {
            this._getHttpServletRequest().setAttribute(NamespaceMapperAccess.getNamespaceMapper().encode(portletWindow.getId(),name), o);
        }
    }

    public void removeAttribute(String name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Attribute name == null");
        }
        if (isNameReserved(name))
        {
            // Reserved names go directly in the underlying request
            _getHttpServletRequest().removeAttribute(name);
        }
        else
        {

            this._getHttpServletRequest().
              removeAttribute(NamespaceMapperAccess.getNamespaceMapper().encode(portletWindow.getId(), name));
        }                                                  
    }

    public String getRequestedSessionId()
    {
        return this._getHttpServletRequest().getRequestedSessionId();
    }

    public boolean isRequestedSessionIdValid()
    {
        return this._getHttpServletRequest().isRequestedSessionIdValid();
    }

    public String getResponseContentType()
    {
        // get the default response content type from the container
        String responseContentType = provider.getResponseContentType();

        return responseContentType;
    }
    
    public Enumeration getResponseContentTypes()
    {
        // get the default response content types from the container
        Iterator responseContentTypes = provider.getResponseContentTypes();

        return new Enumerator(responseContentTypes);
    }
    
    public java.util.Locale getLocale()
    {
        return this._getHttpServletRequest().getLocale();
    }
    
    public Enumeration getLocales()
    {
        return this._getHttpServletRequest().getLocales();
    }

    public String getScheme()
    {
        return this._getHttpServletRequest().getScheme();
    }

    public String getServerName()
    {
        return this._getHttpServletRequest().getServerName();
    }

    public int getServerPort()
    {
        return this._getHttpServletRequest().getServerPort();
    }
    // --------------------------------------------------------------------------------------------

    // org.apache.pluto.core.InternalPortletRequest implementation --------------------------------
    public void lateInit(javax.servlet.http.HttpServletRequest webModuleServletRequest)
    {
        this.setRequest(webModuleServletRequest);
    }

    public PortletWindow getInternalPortletWindow()
    {
        return portletWindow;
    }

    public void setIncluded(boolean included)
    {
        this.included = included;
    }

    public boolean isIncluded()
    {
        return included;
    }
    // --------------------------------------------------------------------------------------------

    // internal methods ---------------------------------------------------------------------------
    private javax.servlet.http.HttpServletRequest _getHttpServletRequest()
    {
        return(javax.servlet.http.HttpServletRequest)super.getRequest();
    }

    /**
     * Is this attribute name a reserved name (by the J2EE spec)?. 
     * Reserved names begin with "java." or "javax.". 
     */
    private boolean isNameReserved(String name)
    {
        return name.startsWith("java.") || name.startsWith("javax.");
    }
    // --------------------------------------------------------------------------------------------

    // additional methods
    // javax.servlet.http.HttpServletRequestWrapper
    public java.lang.String getCharacterEncoding()
    {
        return this._getHttpServletRequest().getCharacterEncoding();
    }

    public java.lang.String getContentType()
    {
        if (included)
        {
            return null;
        }
        else
        {
            return this._getHttpServletRequest().getContentType();
        }
    }

    public int getContentLength()
    {
        if (included)
        {
            return 0;
        }
        else
        {
            return _getHttpServletRequest().getContentLength();
        }
    }
    
    public BufferedReader getReader() throws java.io.UnsupportedEncodingException,java.io.IOException
    {
        if (included)
        {
            return null;
        }
        else
        {
            // the super class will ensure that a IllegalStateException is thrown if getInputStream() was called earlier
            BufferedReader reader = _getHttpServletRequest().getReader();

            bodyAccessed = true;

            return reader;
        }
    }

    public Cookie[] getCookies()
    {
        //must be based on the PortletRequest property [!]
        return this._getHttpServletRequest().getCookies();
    }

    public long getDateHeader(String name)
    {
        //must be based on the PortletRequest property [!]
        return this._getHttpServletRequest().getDateHeader(name);
    }

    public String getHeader(String name)
    {
        //must be based on the PortletRequest property [!]
        return this._getHttpServletRequest().getHeader(name);
    }

    public Enumeration getHeaders(String name)
    {
        //must be based on the PortletRequest property [!]
        return this._getHttpServletRequest().getHeaders(name);
    }

    public Enumeration getHeaderNames()
    {
        //must be based on the PortletRequest property [!]
        return this._getHttpServletRequest().getHeaderNames();
    }

    public int getIntHeader(String name)
    {
        //must be based on the PortletRequest property [!]
        return this._getHttpServletRequest().getIntHeader(name);

    }

    public String getPathInfo()
    {
        String attr = (String)super.getAttribute("javax.servlet.include.path_info");
        return(attr != null) ? attr
                             : super.getPathInfo(); 
    }

    public String getQueryString()
    {
        String attr = (String)super.getAttribute("javax.servlet.include.query_string");
        return(attr != null) ? attr
                             : super.getQueryString();
    }

    public String getPathTranslated()
    {
        return null;
    }

    public String getRequestURI()
    {
        String attr = (String)super.getAttribute("javax.servlet.include.request_uri");
        return(attr != null) ? attr
                             : super.getRequestURI();
    }

    public StringBuffer getRequestURL()
    {
        return null;
    }

    public String getServletPath()
    {
        String attr = (String)super.getAttribute("javax.servlet.include.servlet_path");
        return(attr != null) ? attr
                             : super.getServletPath();
    }

    public HttpSession getSession(boolean create)
    {
        return this._getHttpServletRequest().getSession(true);
    }

    public HttpSession getSession()
    {
        return this._getHttpServletRequest().getSession();
    }

    public String getMethod()
    {
        // TBD
        return this._getHttpServletRequest().getMethod();
    }

    public boolean isRequestedSessionIdFromURL()
    {
        // TBD
        return this._getHttpServletRequest().isRequestedSessionIdFromURL();
    }

    public boolean isRequestedSessionIdFromUrl()
    {
        return this._getHttpServletRequest().isRequestedSessionIdFromUrl();
    }

    public boolean isRequestedSessionIdFromCookie()
    {
        return this._getHttpServletRequest().isRequestedSessionIdFromCookie();
    }

    public String getProtocol()
    {
        return null;
    }

    public String getRemoteAddr()
    {
        return null;
    }

    public String getRemoteHost()
    {
        return null;
    }

    public String getRealPath(String path)
    {
        return null;
    }

    public void setCharacterEncoding(String env) throws java.io.UnsupportedEncodingException
    {
        if (bodyAccessed)
        {
            throw new IllegalStateException("This method must not be called after the HTTP-Body was accessed !");
        }

        this._getHttpServletRequest().setCharacterEncoding(env);
        return; 
    }

    public javax.servlet.ServletInputStream getInputStream() throws java.io.IOException
    {
        if (included)
        {
            return null;
        }
        else
        {
            // the super class will ensure that a IllegalStateException is thrown if getReader() was called earlier
            javax.servlet.ServletInputStream stream = _getHttpServletRequest().getInputStream();

            bodyAccessed = true;

            return stream;
        }
    }

    public javax.servlet.RequestDispatcher getRequestDispatcher(String path)
    {
        return this._getHttpServletRequest().getRequestDispatcher(path);
    }
}
