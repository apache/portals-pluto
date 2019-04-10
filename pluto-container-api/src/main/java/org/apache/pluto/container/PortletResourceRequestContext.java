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
package org.apache.pluto.container;

import java.util.Map;

import javax.enterprise.inject.spi.BeanManager;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @version $Id$
 *
 */
public interface PortletResourceRequestContext extends PortletRequestContext
{
    String getResourceID();
    String getCacheability();
    Map<String, String[]> getPrivateRenderParameterMap();
    
    /**
     * Returns the resource parameters for the request. V3 method.
     * @return
     */
    ResourceParameters getResourceParameters();
    
    /**
     * Returns the resource response needed for async support. V3 method.
     * @return
     */
    ResourceResponse getResponse();
    
    /**
     * Sets the resource response needed for async support. V3 method.
     * @return
     */
    void setResponse(ResourceResponse response);
    
    /**
     * For async support
     */
    
    AsyncContext startAsync(ResourceRequest request) throws IllegalStateException;
    AsyncContext startAsync(ResourceRequest request, ResourceResponse response, boolean origReqResp) throws IllegalStateException;
    boolean isAsyncStarted();
    boolean isAsyncSupported();
    AsyncContext getAsyncContext() throws IllegalStateException;
    DispatcherType getDispatcherType();
    HttpSession getSession();
    AsyncContext startAsync();
    AsyncContext startAsync(ServletRequest request, ServletResponse response);
    PortletAsyncManager getPortletAsyncContext();
    BeanManager getBeanManager();
    void setBeanManager(BeanManager beanmgr);
}
