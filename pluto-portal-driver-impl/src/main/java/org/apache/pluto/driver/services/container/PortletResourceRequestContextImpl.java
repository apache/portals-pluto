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

import javax.portlet.ResourceParameters;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletResourceRequestContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.impl.ResourceParametersImpl;

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
}
