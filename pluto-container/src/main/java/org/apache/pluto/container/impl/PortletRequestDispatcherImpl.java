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

import java.io.IOException;
import java.util.Map;

import javax.portlet.MimeResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletRequestContext;

/**
 * Implementation of the <code>PortletRequestDispatcher</code> interface.
 * The portlet request dispatcher is used to dispatch <b>PortletRequest</b> and
 * <b>PortletResponse</b> to a URI.
 * 
 */
public class PortletRequestDispatcherImpl implements PortletRequestDispatcher, RequestDispatcher
{	
    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PortletRequestDispatcherImpl.class);
    
    // Private Member Variables ------------------------------------------------
    
    /** The nested servlet request dispatcher instance. */
    private RequestDispatcher requestDispatcher;
    private boolean namedDispatch;
    
    
    // Constructors ------------------------------------------------------------
    
    /**
     * Creates an instance. This constructor should be called to construct a
     * portlet request dispatcher.
     * @param requestDispatcher  the servlet request dispatcher.
     * @param namedDispatch true if requestDispatcher is a named dispatcher 
     * @see javax.portlet.PortletContext#getNamedDispatcher(String)
     * @see javax.portlet.PortletContext#getRequestDispatcher(String)
     */
    public PortletRequestDispatcherImpl(RequestDispatcher requestDispatcher, boolean namedDispatch)
    {
        this.requestDispatcher = requestDispatcher;
        this.namedDispatch = namedDispatch;
    	
        if (LOG.isDebugEnabled())
        {
        	LOG.debug("Request dispatcher created.");
        }
    }
    
    private static HttpServletPortletRequestWrapper getWrappedRequest(ServletRequest request)
    {
        HttpServletPortletRequestWrapper req = null;
        
        do
        {
            if (request instanceof HttpServletPortletRequestWrapper)
            {
                req = (HttpServletPortletRequestWrapper)request;
            }
            else if (request instanceof HttpServletRequestWrapper)
            {
                request = ((HttpServletRequestWrapper)request).getRequest();
            }
            else
            {
                request = null;
            }                
        }
        while (request != null && req == null);
        return req;
    }

    private static HttpServletPortletResponseWrapper getWrappedResponse(ServletResponse response)
    {
        HttpServletPortletResponseWrapper res = null;
        
        do
        {
            if (response instanceof HttpServletPortletResponseWrapper)
            {
                res = (HttpServletPortletResponseWrapper)response;
            }
            else if (response instanceof HttpServletResponseWrapper)
            {
                response = ((HttpServletResponseWrapper)response).getResponse();
            }
            else
            {
                response = null;
            }                
        }
        while (response != null && res == null);
        return res;
    }
    
    private void doDispatch(PortletRequest request, PortletResponse response, boolean included) throws PortletException, IOException
    {
        boolean needsFlushAfterForward = false;
        if (!included)
        {
            String lifecyclePhase = (String)request.getAttribute(PortletRequest.LIFECYCLE_PHASE);
            if (PortletRequest.RENDER_PHASE.equals(lifecyclePhase) || PortletRequest.RESOURCE_PHASE.equals(lifecyclePhase))
            {
                needsFlushAfterForward = true;
                ((MimeResponse)response).resetBuffer();
            }
        }
        
        PortletRequestContext requestContext = (PortletRequestContext)request.getAttribute(PortletInvokerService.REQUEST_CONTEXT);
        HttpSession session = null;
        
        // PLT.10.4.3. Proxied session is created and passed if javax.portlet.servletDefaultSessionScope == PORTLET_SCOPE
        if (isPortletScopeSessionConfigured(requestContext))
        {
            String portletWindowId = requestContext.getPortletWindow().getId().getStringId();
            session = ServletPortletSessionProxy.createProxy(requestContext.getServletRequest(), portletWindowId);
        }
        
        HttpServletPortletRequestWrapper req = new HttpServletPortletRequestWrapper(requestContext.getServletRequest(), 
                                                                                    requestContext.getServletContext(),
                                                                                    session,
                                                                                    request,
                                                                                    included,
                                                                                    namedDispatch);
        HttpServletPortletResponseWrapper res = new HttpServletPortletResponseWrapper(requestContext.getServletResponse(),
                                                                                      request,
                                                                                      response,
                                                                                      included);
        try
        {
            request.setAttribute(PortletInvokerService.PORTLET_CONFIG, requestContext.getPortletConfig());
            request.setAttribute(PortletInvokerService.PORTLET_REQUEST, request);
            request.setAttribute(PortletInvokerService.PORTLET_RESPONSE, response);
            
            if (!included && req.isForwardingPossible())
            {
                requestDispatcher.forward(req, res);
            }
            else
            {
                // need to "fake" the forward using an include
                requestDispatcher.include(req, res);
            }
            if (needsFlushAfterForward)
            {
                ((MimeResponse)response).flushBuffer();
            }
        }
        catch (ServletException sex)
        {
            if (sex.getRootCause() != null)
            {
                throw new PortletException(sex.getRootCause());
            } 
            throw new PortletException(sex);
        }
        finally
        {
            request.removeAttribute(PortletInvokerService.PORTLET_CONFIG);
            request.removeAttribute(PortletInvokerService.PORTLET_REQUEST);
            request.removeAttribute(PortletInvokerService.PORTLET_RESPONSE);
        }
    }
    
    private boolean isPortletScopeSessionConfigured(PortletRequestContext requestContext)
    {
        boolean portletScopeSessionConfigured = false;
        
        PortletConfig portletConfig = requestContext.getPortletConfig();
        Map<String, String []> containerRuntimeOptions = portletConfig.getContainerRuntimeOptions();
        String [] values = containerRuntimeOptions.get("javax.portlet.servletDefaultSessionScope");
        
        if (values != null && values.length > 0)
        {
            portletScopeSessionConfigured = "PORTLET_SCOPE".equals(values[0]);
        }
        
        return portletScopeSessionConfigured;
    }

    // PortletRequestDispatcher Impl -------------------------------------------
   
    public void forward(PortletRequest request, PortletResponse response) throws PortletException, IOException
    {
        doDispatch(request, response, false);
    }
    
	public void include(PortletRequest request, PortletResponse response) throws PortletException, IOException
	{
	    doDispatch(request, response, true);
	}
	
	public void include(RenderRequest request, RenderResponse response) throws PortletException, IOException
	{
	    doDispatch(request, response, true);
    }
	
    // Nested RequestDispatcher Impl -------------------------------------------
	
    public void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
        HttpServletPortletRequestWrapper req = getWrappedRequest(request);
        HttpServletPortletResponseWrapper res = getWrappedResponse(response);
        res.resetBuffer();
        
        // cache the current dispatch state
        boolean forwarded = req.isForwarded();
        boolean namedDispatch = req.isNamedDispatch();
        Map<String,Object> pathAttributeValues = req.getPathAttributeValues();
        HttpServletPortletRequestWrapper.PathMethodValues pathMethodValues = req.getInitPathMethodValues();
        
        // (re)initialize the request wrapper to a nested forward
        req.setNestedForward();
        try
        {
            if (req.isForwardingPossible())
            {
                requestDispatcher.forward(request, response);
            }
            else
            {
                // need to "fake" the forward using an include
                requestDispatcher.include(request, response);
            }
        }
        finally
        {
            // restore the previously cached dispatch state
            req.restoreFromNestedForward(forwarded, namedDispatch, pathMethodValues, pathAttributeValues);
        }
    }

    public void include(ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
        // no need for special handling on a nested dispatcher include: just calling the wrapped servlet dispatcher
        requestDispatcher.include(request, response);
    }
}
