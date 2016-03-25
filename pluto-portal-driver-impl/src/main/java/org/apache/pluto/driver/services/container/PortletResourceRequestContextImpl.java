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
package org.apache.pluto.driver.services.container;

import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletResourceRequestContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.impl.HttpServletPortletRequestWrapper;
import org.apache.pluto.container.impl.HttpServletPortletResponseWrapper;
import org.apache.pluto.container.impl.PortletAsyncRequestWrapper;
import org.apache.pluto.container.impl.ResourceParametersImpl;
import org.apache.pluto.container.impl.ServletPortletSessionProxy;

/**
 * @version $Id$
 *
 */
public class PortletResourceRequestContextImpl extends PortletRequestContextImpl implements
                PortletResourceRequestContext
{
   private String pageState;
   private ResourceResponse response;
   
   
    public PortletResourceRequestContextImpl(PortletContainer container, HttpServletRequest containerRequest,
                                             HttpServletResponse containerResponse, PortletWindow window,
                                             String pageState)
    {
       // if pageState != null, we're dealing with a Partial Action request, so 
       // the servlet parameters are not to be used. Otherwise, resource params could be
       // passed as servlet parameters.
        super(container, containerRequest, containerResponse, window, (pageState==null));
        this.pageState = pageState;
    }

    @Override
    public String getCacheability()
    {
        return getPortalURL().getCacheability();
    }

    @Override
    public Map<String, String[]> getPrivateRenderParameterMap()
    {
        return paramFactory.getResourceRenderParameterMap(window.getId().getStringId());
    }

    @Override
    public String getResourceID()
    {
        return getPortalURL().getResourceID();
    }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.PortletResourceRequestContext#getPageState()
    */
    @Override
   public String getPageState() {
      return pageState;
   }

    @Override
   public ResourceParameters getResourceParameters() {
      return new ResourceParametersImpl(urlProvider, windowId);
   }

   /**
    * @return the response
    */
    @Override
   public ResourceResponse getResponse() {
      return response;
   }

   /**
    * @param response the response to set
    */
    @Override
   public void setResponse(ResourceResponse response) {
      this.response = response;
   }

    @Override
    public AsyncContext startAsync(ResourceRequest request) throws IllegalStateException {
       return startAsync(request, response);
    }

    @Override
    public AsyncContext startAsync(ResourceRequest request, ResourceResponse response) throws IllegalStateException {
       
       HttpServletRequest hreq = getServletRequest();
       HttpServletResponse hresp = getServletResponse();
       ServletContext ctx = getServletContext();
       HttpSession sess = getSession();
       PortletConfig cfg = getPortletConfig(); 

       // Set portlet-scoped attributes directly on resource request
       
       request.setAttribute(PortletInvokerService.PORTLET_CONFIG, cfg);
       request.setAttribute(PortletInvokerService.PORTLET_REQUEST, request);
       request.setAttribute(PortletInvokerService.PORTLET_RESPONSE, response);

       // Wrap http req & response. 
       
       HttpServletRequest wreq = new PortletAsyncRequestWrapper(hreq, ctx, sess, request);
       HttpServletResponse wresp = new HttpServletPortletResponseWrapper(hresp, request, response, false);

       // get the original container req & resp to pass to listener for resource releasing

       HttpServletRequest creq = getContainerRequest();     
       HttpServletResponse cresp = getContainerResponse();

       // Attach listener to release resources upon async complete.
       
       AsyncContext actx = hreq.startAsync(wreq, wresp);
       PortletAsyncListener pal = new PortletAsyncListener();
       actx.addListener(pal, creq, cresp);

       return actx;
    }

    @Override
    public boolean isAsyncStarted() {
       return getServletRequest().isAsyncStarted();
    }

    @Override
    public boolean isAsyncSupported() {
       return getServletRequest().isAsyncSupported();
    }

    @Override
    public AsyncContext getAsyncContext() {
       return getServletRequest().getAsyncContext();
    }

    @Override
    public DispatcherType getDispatcherType() {
       return getServletRequest().getDispatcherType();
    }

    // For use within the wrapper. 
    // PLT.10.4.3. Proxied session is created and passed if 
    // javax.portlet.servletDefaultSessionScope == PORTLET_SCOPE
    private HttpSession getSession() {
       HttpSession sess = null;

       PortletConfig portletConfig = getPortletConfig();
       Map<String, String[]> containerRuntimeOptions = portletConfig.getContainerRuntimeOptions();
       String[] values = containerRuntimeOptions.get("javax.portlet.servletDefaultSessionScope");

       if ((values != null) && (values.length > 0) && "PORTLET_SCOPE".equals(values[0])) {
          String portletWindowId = getPortletWindow().getId().getStringId();
          sess = ServletPortletSessionProxy.createProxy(getServletRequest(), portletWindowId);
       }

       return sess;
    }
}
