/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */


package org.apache.pluto.container.impl;

import java.util.Enumeration;

import javax.portlet.PortletRequest;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

/**
 * @author Scott Nicklous
 *
 */
public class PortletAsyncRequestWrapper extends HttpServletRequestWrapper {
   
   private final PortletRequest preq;

   public PortletAsyncRequestWrapper(HttpServletRequest hreq, PortletRequest preq) {
      super(hreq);
      this.preq = preq;
   }
   
   
   
   @Override
   public Object getAttribute(String name) {
      return preq.getAttribute(name);
   }
   
   @Override
   public Enumeration<String> getAttributeNames() {
      return preq.getAttributeNames();
   }
   
   @Override
   public void setAttribute(String name, Object o) {
      preq.setAttribute(name, o);
   }
   
   @Override
   public void removeAttribute(String name) {
      preq.removeAttribute(name);
   }
   
   
   
   
   
   
   
   
   
   // saved methods below.

//    /**
//     * Modifies the behavior of the underlying wrapper to allow access to the
//     * async methods.
//     * 
//     * @param request
//     * @param servletContext
//     * @param session
//     * @param portletRequest
//     */
//    public PortletAsyncRequestWrapper(HttpServletRequest request, ServletContext servletContext, HttpSession session,
//          PortletRequest portletRequest) {
//       super(request, servletContext, session, portletRequest, false, false);
//       
//    }
//    
// 
// 
//    @Override
//    public AsyncContext startAsync() throws IllegalStateException {
//       return getRequest().startAsync();
//    }
// 
//    @Override
//    public AsyncContext startAsync(ServletRequest request, ServletResponse response) throws IllegalStateException {
//       return getRequest().startAsync(request, response);
//    }
// 
//    @Override
//    public boolean isAsyncStarted() {
//       return getRequest().isAsyncStarted();
//    }
// 
//    @Override
//    public boolean isAsyncSupported() {
//       return getRequest().isAsyncSupported();
//    }
// 

}
