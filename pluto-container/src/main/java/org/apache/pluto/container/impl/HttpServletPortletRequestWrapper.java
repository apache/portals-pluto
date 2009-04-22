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
package org.apache.pluto.container.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.portlet.ClientDataRequest;
import javax.portlet.PortletRequest;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.RequestDispatcherPathInfo;
import org.apache.pluto.container.RequestDispatcherPathInfoProvider;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;

/**
 * @author <a href="mailto:ate@douma.nu">Ate Douma</a>
 * @version $Id$
 */
public class HttpServletPortletRequestWrapper extends HttpServletRequestWrapper
{
    private static final String INCLUDE_CONTEXT_PATH = "javax.servlet.include.context_path";
    private static final String INCLUDE_PATH_INFO = "javax.servlet.include.path_info";
    private static final String INCLUDE_QUERY_STRING = "javax.servlet.include.query_string";
    private static final String INCLUDE_REQUEST_URI = "javax.servlet.include.request_uri";
    private static final String INCLUDE_SERVLET_PATH = "javax.servlet.include.servlet_path";
    private static final String FORWARD_CONTEXT_PATH = "javax.servlet.forward.context_path";
    private static final String FORWARD_PATH_INFO = "javax.servlet.forward.path_info";
    private static final String FORWARD_QUERY_STRING = "javax.servlet.forward.query_string";
    private static final String FORWARD_REQUEST_URI = "javax.servlet.forward.request_uri";
    private static final String FORWARD_SERVLET_PATH = "javax.servlet.forward.servlet_path";
    
    private static final HashSet<String> pathInfoAttributes = 
        new HashSet<String>(Arrays.asList(new String[] { INCLUDE_CONTEXT_PATH,
                                                         INCLUDE_PATH_INFO,
                                                         INCLUDE_QUERY_STRING,
                                                         INCLUDE_REQUEST_URI,
                                                         INCLUDE_SERVLET_PATH,
                                                         FORWARD_CONTEXT_PATH,
                                                         FORWARD_PATH_INFO,
                                                         FORWARD_QUERY_STRING,
                                                         FORWARD_REQUEST_URI,
                                                         FORWARD_SERVLET_PATH }));
    
    /**
     * Cache for parsed dateHeader values.
     */
    protected static final HashMap<String,Long> dateHeaderParseCache = new HashMap<String,Long>();
    
    /**
     * The set of SimpleDateFormat formats to use in getDateHeader().
     *
     * Notice that because SimpleDateFormat is not thread-safe, we can't
     * declare formats[] as a static variable.
     */
    protected SimpleDateFormat dateHeaderFormats[] = 
    {
        new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US),
        new SimpleDateFormat("EEEEEE, dd-MMM-yy HH:mm:ss zzz", Locale.US),
        new SimpleDateFormat("EEE MMMM d HH:mm:ss yyyy", Locale.US)
    };
    
    private boolean included;
    private RequestDispatcherPathInfo methodPathInfo;
    private RequestDispatcherPathInfo includedPathInfo;
    private RequestDispatcherPathInfo forwardedPathInfo;

    private Map<String, String[]> parameterMap;
    private Map<String, String[]> origParameterMap;
    
    private ServletRequest currentRequest;
    
    private final ServletContext servletContext;
    private final PortletRequest portletRequest;
    private final ClientDataRequest clientDataRequest;
    private final String lifecyclePhase;
    private final boolean renderPhase;
    private HttpSession session;
    
    private boolean dispatching;
    
    @SuppressWarnings("unchecked")
    public HttpServletPortletRequestWrapper(HttpServletRequest request, ServletContext servletContext, HttpSession session, PortletRequest portletRequest, RequestDispatcherPathInfo pathInfo, boolean included)
    {
        super(request);
        origParameterMap = request.getParameterMap();
        this.servletContext = servletContext;
        this.session = session;
        this.portletRequest = portletRequest;
        lifecyclePhase = (String)portletRequest.getAttribute(PortletRequest.LIFECYCLE_PHASE);
        clientDataRequest = PortletRequest.ACTION_PHASE.equals(lifecyclePhase) || PortletRequest.RESOURCE_PHASE.equals(lifecyclePhase) ? (ClientDataRequest)portletRequest : null;
        renderPhase = PortletRequest.RENDER_PHASE.equals(lifecyclePhase);
        setNewPathInfo(pathInfo, pathInfo, included);
    }
    
    /**
     * Try to parse the given date as a HTTP date. Borrowed and adapted from
     * Tomcat FastHttpDateFormat
     */
    private long parseDateHeader(String value)
    {
        Long dateValue = null;
        try
        {
            dateValue = dateHeaderParseCache.get(value);
        }
        catch (Exception e)
        {
        }
        if (dateValue == null)
        {
            for (int i = 0; i < dateHeaderFormats.length; i++)
            {
                try
                {
                    Date date = dateHeaderFormats[i].parse(value);
                    dateValue = new Long(date.getTime());
                }
                catch (ParseException e)
                {
                }
            }
            if (dateValue != null)
            {
                synchronized (dateHeaderParseCache)
                {
                    if (dateHeaderParseCache.size() > 1000)
                    {
                        dateHeaderParseCache.clear();
                    }
                    dateHeaderParseCache.put(value, dateValue);
                }
            }
            else
            {
                throw new IllegalArgumentException(value);
            }
        }
        return dateValue.longValue();
    }
    
    public boolean isForwardingPossible()
    {
        return !renderPhase;
    }

    public boolean isIncluded()
    {
        return included;
    }
    
    public void setNewPathInfo(RequestDispatcherPathInfo methodPathInfo, RequestDispatcherPathInfo attributesPathInfo, boolean included)
    {
        this.methodPathInfo = methodPathInfo;
        if (included)
        {
            includedPathInfo = attributesPathInfo;
        }
        else
        {
            forwardedPathInfo = attributesPathInfo;
        }
        this.included = included;
    }
    
    public void restorePathInfo(RequestDispatcherPathInfo methodPathInfo, RequestDispatcherPathInfo includedPathInfo, RequestDispatcherPathInfo forwardedPathInfo, boolean included)
    {
        this.methodPathInfo = methodPathInfo;
        this.forwardedPathInfo = forwardedPathInfo;
        this.includedPathInfo = includedPathInfo;
        this.included = included;
    }
    
    public RequestDispatcherPathInfo getMethodPathInfo()
    {
        return methodPathInfo;
    }
    
    public RequestDispatcherPathInfo getIncludedPathInfo()
    {
        return includedPathInfo;
    }
    
    public RequestDispatcherPathInfo getForwardedPathInfo()
    {
        return forwardedPathInfo;
    }
    
    public void setDispatching(boolean dispatching)
    {
        this.dispatching = dispatching;
    }
    
    public boolean isDispatching()
    {
        return dispatching;
    }
    
    @Override
    public String getParameter(String name)
    {
        String[] values = this.getParameterMap().get(name);
        return values != null ? values[0] : null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, String[]> getParameterMap()
    {
        if (currentRequest == null || getRequest() != currentRequest)
        {
            currentRequest = getRequest();
            Map<String, String[]> currParameterMap = currentRequest.getParameterMap();
            Map<String, String[]> diffParameterMap = new HashMap<String, String[]>();
            
            for (Map.Entry<String,String[]> entry : currParameterMap.entrySet())
            {
                String[] values = entry.getValue();
                String[] original = origParameterMap.get(entry.getKey());
                String[] diff = null;
                if ( original == null )
                {
                    // a new parameter
                    diff = values.clone();
                }
                else if ( values.length > original.length )
                {
                    // we've got some additional query string parameter value(s)
                    diff = new String[values.length - original.length];
                    System.arraycopy(values,0,diff,0,values.length-original.length);
                }
                if ( diff != null )
                {
                    diffParameterMap.put(entry.getKey(), diff);
                }
            }
            if (!diffParameterMap.isEmpty())
            {
                currParameterMap.clear();
                currParameterMap.putAll(portletRequest.getParameterMap());
                for (Map.Entry<String, String[]> entry : diffParameterMap.entrySet())
                {
                    String[] diff = entry.getValue();
                    String[] curr = currParameterMap.get(entry.getKey());
                    if ( curr == null )
                    {
                        currParameterMap.put(entry.getKey(), diff.clone());
                    }
                    else
                    {
                        // we've got some additional query string parameter value(s)
                        String[] copy = new String[curr.length+diff.length];
                        System.arraycopy(diff,0,copy,0,diff.length);
                        System.arraycopy(curr,0,copy,diff.length,curr.length);
                        currParameterMap.put(entry.getKey(), copy);
                    }
                }
                parameterMap = Collections.unmodifiableMap(currParameterMap);
            }
        }
        if (parameterMap == null)
        {
            parameterMap = portletRequest.getParameterMap();
        }
        return parameterMap;
    }

    @Override
    public Enumeration<String> getParameterNames()
    {
        return Collections.enumeration(this.getParameterMap().keySet());
    }

    @Override
    public String[] getParameterValues(String name)
    {
        return this.getParameterMap().get(name);
    }

    @Override
    public String getAuthType()
    {
        return portletRequest.getAuthType();
    }

    @Override
    public Cookie[] getCookies()
    {
        return portletRequest.getCookies();
    }

    @Override
    public long getDateHeader(String name)
    {
        String value = portletRequest.getProperty(name);
        if (value == null)
        { 
            return (-1L);
        }
        // Attempt to convert the date header in a variety of formats
        return parseDateHeader(value);
    }

    @Override
    public String getHeader(String name)
    {
        return portletRequest.getProperty(name);
    }

    @Override
    public Enumeration<String> getHeaderNames()
    {
        return portletRequest.getPropertyNames();
    }

    @Override
    public Enumeration<String> getHeaders(String name)
    {
        return portletRequest.getProperties(name);
    }

    @Override
    public int getIntHeader(String name)
    {
        String property = portletRequest.getProperty(name);
        if (property == null)
        {
            return -1;
        }
        return Integer.parseInt(property);
    }

    @Override
    public String getMethod()
    {
        return renderPhase ? "GET" : super.getMethod();
    }
    
    @Override
    public String getContextPath()
    {
        return portletRequest.getContextPath();
    }

    @Override
    public String getPathInfo()
    {
        return methodPathInfo.getPathInfo();
    }

    @Override
    public String getPathTranslated()
    {
        return getPathInfo() != null ? servletContext.getRealPath(getPathInfo()) : null;
    }

    @Override
    public String getQueryString()
    {
        return methodPathInfo.getQueryString();
    }

    @Override
    public String getRemoteUser()
    {
        return portletRequest.getRemoteUser();
    }

    @Override
    public String getRequestedSessionId()
    {
        return portletRequest.getRequestedSessionId();
    }

    @Override
    public String getRequestURI()
    {
        return methodPathInfo.getRequestURI();
    }

    @Override
    public StringBuffer getRequestURL()
    {
        return null;
    }

    @Override
    public String getServletPath()
    {
        return methodPathInfo.getServletPath();
    }

    @Override
    public HttpSession getSession()
    {
        return session !=  null ? session : super.getSession();
    }

    @Override
    public HttpSession getSession(boolean create)
    {
        return session != null ? session : super.getSession(create);
    }

    @Override
    public Principal getUserPrincipal()
    {
        return portletRequest.getUserPrincipal();
    }

    @Override
    public boolean isRequestedSessionIdValid()
    {
        return portletRequest.isRequestedSessionIdValid();
    }

    @Override
    public boolean isUserInRole(String role)
    {
        return portletRequest.isUserInRole(role);
    }

    @Override
    public Object getAttribute(String name)
    {
        Object value = (dispatching ? getRequest().getAttribute(name) : null);
        
        if (value == null && pathInfoAttributes.contains(name))
        {
            if (includedPathInfo != null && !includedPathInfo.isNamedRequestDispatcher())
            {
                if (INCLUDE_CONTEXT_PATH.equals(name))
                {
                    return getContextPath();
                }
                else if (INCLUDE_PATH_INFO.equals(name))
                {
                    return includedPathInfo.getPathInfo();
                }
                else if (INCLUDE_QUERY_STRING.equals(name))
                {
                    return includedPathInfo.getQueryString();
                }
                else if (INCLUDE_REQUEST_URI.equals(name))
                {
                    return includedPathInfo.getRequestURI();
                }
                else if (INCLUDE_SERVLET_PATH.equals(name))
                {
                    return includedPathInfo.getServletPath();
                }
            }
            if (forwardedPathInfo != null && !forwardedPathInfo.isNamedRequestDispatcher())
            {
                if (FORWARD_CONTEXT_PATH.equals(name))
                {
                    return getContextPath();
                }
                else if (FORWARD_PATH_INFO.equals(name))
                {
                    return forwardedPathInfo.getPathInfo();
                }
                else if (FORWARD_QUERY_STRING.equals(name))
                {
                    return forwardedPathInfo.getQueryString();
                }
                else if (FORWARD_REQUEST_URI.equals(name))
                {
                    return forwardedPathInfo.getRequestURI();
                }
                else if (FORWARD_SERVLET_PATH.equals(name))
                {
                    return forwardedPathInfo.getServletPath();
                }                
            }
            return null;
        }
        
        /*
         * First try to access the attribute from the *parent* request.
         * Webcontainers typically "inject" a custom servletrequest in between the
         * dispatched request (this) and its original "parent", to ensure proper
         * management of requestdispatcher state.
         * Webcontainer specific attributes therefore *must* be accessed from the
         * *current* parent request to ensure proper behavior
         * Without doing this, for instance Tomcat fails to properly match
         * servlet filters properly, if at all...
         * This should not really interfere with normal PortletRequest attribute
         * management as the PortletRequestContext implementation is assumed to
         * encode newly set attributes anyway or store them otherwise, hence going
         * through the current parent request *first* should not yield those
         * attributes.
         */
        if (value == null && !dispatching)
        {
            value = getRequest().getAttribute(name);
        }
        return value != null ? value : portletRequest.getAttribute(name);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Enumeration<String> getAttributeNames()
    {
        HashSet<String> names = new HashSet<String>();
        Enumeration<String> e;
        for (e = getRequest().getAttributeNames(); e.hasMoreElements();  )
        {
            try
            {
                names.add(e.nextElement());
            }
            catch(NoSuchElementException nse)
            {
                // ignore potential concurrent changes when run in parallel mode
            }
        }
        for (e = portletRequest.getAttributeNames(); e.hasMoreElements();  )
        {
            try
            {
                names.add(e.nextElement());
            }
            catch(NoSuchElementException nse)
            {
                // ignore potential concurrent changes when run in parallel mode
            }
        }
        return Collections.enumeration(names);
    }

    @Override
    public String getCharacterEncoding()
    {
        return clientDataRequest != null ? clientDataRequest.getCharacterEncoding() : null;
    }

    @Override
    public int getContentLength()
    {
        return clientDataRequest != null ? clientDataRequest.getContentLength() : 0;
    }

    @Override
    public String getContentType()
    {
        return clientDataRequest != null ? clientDataRequest.getContentType() : null;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException
    {
        return clientDataRequest != null ? (ServletInputStream)clientDataRequest.getPortletInputStream() : null;
    }

    @Override
    public String getLocalAddr()
    {
        return null;
    }

    @Override
    public Locale getLocale()
    {
        return portletRequest.getLocale();
    }

    @Override
    public Enumeration<Locale> getLocales()
    {
        return portletRequest.getLocales();
    }

    @Override
    public String getLocalName()
    {
        return null;
    }

    @Override
    public int getLocalPort()
    {
        return 0;
    }

    @Override
    public String getProtocol()
    {
        return "HTTP/1.1";
    }

    @Override
    public BufferedReader getReader() throws IOException
    {
        return clientDataRequest != null ? clientDataRequest.getReader() : null;
    }

    @Override
    public String getRealPath(String path)
    {
        return null;
    }

    @Override
    public String getRemoteAddr()
    {
        return null;
    }

    @Override
    public String getRemoteHost()
    {
        return null;
    }

    @Override
    public int getRemotePort()
    {
        return 0;
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path)
    {
        if (path != null)
        {
            RequestDispatcher dispatcher = super.getRequestDispatcher(path);
            if (dispatcher != null)
            {
                if (!path.startsWith("/"))
                {
                    String servletPath = !included ? forwardedPathInfo.getServletPath() : getServletPath();
                    if (servletPath != null)
                    {                        
                        path = (servletPath.equals("/") ? "/" : servletPath) + path;
                    }
                    else
                    {
                        // Don't know what to do here: cannot determine needed servletPath prefix which should
                        // be present to build a correct RequestDispatcherPathInfo
                    }
                }
                PortletRequestContext requestContext = (PortletRequestContext)portletRequest.getAttribute(PortletInvokerService.REQUEST_CONTEXT);
                PortletApplicationDefinition app = requestContext.getPortletWindow().getPortletEntity().getPortletDefinition().getApplication();
                RequestDispatcherPathInfoProvider provider = RequestDispatcherPathInfoProviderImpl.getProvider(requestContext.getPortletConfig().getPortletContext(), app);
                return new PortletRequestDispatcherImpl(dispatcher, provider.getPathInfo(getContextPath(),path));
            }
        }
        return null;
    }

    @Override
    public String getScheme()
    {
        return portletRequest.getScheme();
    }

    @Override
    public String getServerName()
    {
        return portletRequest.getServerName();
    }

    @Override
    public int getServerPort()
    {
        return portletRequest.getServerPort();
    }

    @Override
    public boolean isSecure()
    {
        return portletRequest.isSecure();
    }

    @Override
    public void removeAttribute(String name)
    {
        portletRequest.removeAttribute(name);
    }

    @Override
    public void setAttribute(String name, Object o)
    {
        portletRequest.setAttribute(name, o);
    }

    @Override
    public void setCharacterEncoding(String enc) throws UnsupportedEncodingException
    {
        if (clientDataRequest != null)
        {
            clientDataRequest.setCharacterEncoding(enc);
        }
    }    
}
