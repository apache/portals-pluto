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

import java.util.Enumeration;
import java.util.Map;

import javax.portlet.CacheControl;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletResourceRequestContext;
import org.apache.pluto.container.PortletResourceResponseContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceRequestImpl extends ClientDataRequestImpl implements ResourceRequest
{

   /** Internal logger. */
   private static final Logger LOG = LoggerFactory.getLogger(ResourceRequestImpl.class);

    private CacheControl cacheControl;
    
    public ResourceRequestImpl(PortletResourceRequestContext requestContext, PortletResourceResponseContext responseContext)
    {
        super(requestContext, responseContext, PortletRequest.RESOURCE_PHASE);
        this.cacheControl = responseContext.getCacheControl();
    }
    
    @Override
    protected PortletResourceRequestContext getRequestContext() {
       return (PortletResourceRequestContext) requestContext;
    }
    
    protected PortletResourceResponseContext getResponseContext() {
       return (PortletResourceResponseContext) responseContext;
    }
    
    @Override
    public String getProperty(String name)
    {
        String result = getMimeRequestProperty(name, cacheControl);
        return result != null ? result : super.getProperty(name);
    }

    public String getCacheability()
    {
        return getRequestContext().getCacheability();
    }

    public String getETag()
    {
        return cacheControl.getETag();
    }

    public Map<String, String[]> getPrivateRenderParameterMap()
    {
        return cloneParameterMap(getRequestContext().getPrivateRenderParameterMap());
    }

    public String getResourceID()
	{
		return getRequestContext().getResourceID();
	}

    public String getResponseContentType()
    {
        return getServletRequest().getHeader("accept");
    }

    public Enumeration<String> getResponseContentTypes()
    {
        return getServletRequest().getHeaders("accept");
    }
   
   // Debug code - intercept getParameter call & dump all parameters to trace
   @Override
   public String getParameter(String name) {
      String val = super.getParameter(name);
      if (LOG.isTraceEnabled()) {
         Map<String, String[]> pmap = super.getParameterMap();
         StringBuffer txt = new StringBuffer(1024);
         txt.append("Resource Request parameter map dump:");
         for (String n : pmap.keySet()) {
            txt.append("\nName: " + n + ", Values: ");
            String[] vals = pmap.get(n);
            String sep = "";
            for (String v : vals) {
               txt.append(sep + v);
               sep = ", ";
            }
         }
         LOG.debug(txt.toString());
      }
      return val;
   }

   public ResourceParameters getResourceParameters() {
      return getRequestContext().getResourceParameters();
   }

   @Override
   public AsyncContext startAsync() throws IllegalStateException {
      ResourceResponse resp = getRequestContext().getResponse();
      return startAsync(this, resp);
   }

   @Override
   public AsyncContext startAsync(ResourceRequest request, ResourceResponse response) throws IllegalStateException {
      
      HttpServletRequest hreq = getRequestContext().getServletRequest();
      HttpServletResponse hresp = getRequestContext().getServletResponse();
      ServletContext ctx = getRequestContext().getServletContext();
      HttpSession sess = getSession();
      PortletConfig cfg =getRequestContext().getPortletConfig(); 
      
      HttpServletRequest wreq = new HttpServletPortletRequestWrapper(hreq, ctx, sess, request, false, false);
      HttpServletResponse wresp = new HttpServletPortletResponseWrapper(hresp, request, response, false);
   
      request.setAttribute(PortletInvokerService.PORTLET_CONFIG, cfg);
      request.setAttribute(PortletInvokerService.PORTLET_REQUEST, request);
      request.setAttribute(PortletInvokerService.PORTLET_RESPONSE, response);
      
      AsyncContext actx = hreq.startAsync(wreq, wresp);

      return actx;
   }

   @Override
   public boolean isAsyncStarted() {
      return getRequestContext().getServletRequest().isAsyncStarted();
   }

   @Override
   public boolean isAsyncSupported() {
      return getRequestContext().getServletRequest().isAsyncSupported();
   }

   @Override
   public AsyncContext getAsyncContext() {
      return getRequestContext().getServletRequest().getAsyncContext();
   }

   @Override
   public DispatcherType getDispatcherType() {
      return getRequestContext().getServletRequest().getDispatcherType();
   }

   // For use within the wrapper. 
   // PLT.10.4.3. Proxied session is created and passed if 
   // javax.portlet.servletDefaultSessionScope == PORTLET_SCOPE
   private HttpSession getSession() {
      HttpSession sess = null;

      PortletConfig portletConfig = getRequestContext().getPortletConfig();
      Map<String, String[]> containerRuntimeOptions = portletConfig.getContainerRuntimeOptions();
      String[] values = containerRuntimeOptions.get("javax.portlet.servletDefaultSessionScope");

      if ((values != null) && (values.length > 0) && "PORTLET_SCOPE".equals(values[0])) {
         String portletWindowId = getRequestContext().getPortletWindow().getId().getStringId();
         sess = ServletPortletSessionProxy.createProxy(getRequestContext().getServletRequest(), portletWindowId);
      }

      return sess;
   }
}
