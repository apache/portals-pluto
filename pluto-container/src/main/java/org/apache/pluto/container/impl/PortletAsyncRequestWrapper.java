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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.portlet.ResourceRequest;
import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.container.NamespaceMapper;
import org.apache.pluto.container.PortletAsyncManager;
import org.apache.pluto.container.PortletResourceRequestContext;
import org.apache.pluto.container.PortletWindowID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Scott Nicklous
 *
 */
public class PortletAsyncRequestWrapper extends HttpServletPortletRequestWrapper {
   
   /** Logger. */
   private static final Logger LOG = LoggerFactory.getLogger(PortletAsyncRequestWrapper.class);
   @SuppressWarnings("unused")
   private static final boolean isDebug = LOG.isDebugEnabled();
   private static final boolean isTrace = LOG.isTraceEnabled();
   
   
   @SuppressWarnings("unused")
   private final ResourceRequest preq;
   private final PortletResourceRequestContext reqctx;
   private final NamespaceMapper mapper;
   private final PortletWindowID winId;

   public PortletAsyncRequestWrapper(HttpServletRequest hreq, ResourceRequest preq, PortletResourceRequestContext reqctx) {
      super(hreq, reqctx.getSession(), preq);
      this.preq = preq;
      this.reqctx = reqctx;
      this.mapper = reqctx.getContainer().getContainerServices().getNamespaceMapper();
      this.winId = reqctx.getPortletWindow().getId();
   }
   
   
   
   @Override
   public Object getAttribute(String name) {
      boolean encoded = true;
      Object val = getRequest().getAttribute(mapper.encode(winId, name));
      if (val == null) {
         val = getRequest().getAttribute(name);
         encoded = false;
      }
      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Getting: ");
         txt.append(name).append(", value: ").append((val == null) ? "null" : val.toString());
         txt.append(", encoded: ").append(encoded);
         LOG.debug(txt.toString());
      }
      return val;
   }
   
   @Override
   public Enumeration<String> getAttributeNames() {
      Enumeration<String> enames = getRequest().getAttributeNames();
      ArrayList<String> snames = new ArrayList<String>();
      for (String name : Collections.list(enames)) {
         String dn = mapper.decode(winId, name);
         if (dn != null) {
            snames.add(dn);
         } else {
            snames.add(name);
         }
      }
      return Collections.enumeration(snames);
   }
   
   @Override
   public void setAttribute(String name, Object o) {
      PortletAsyncManager actx = reqctx.getPortletAsyncContext();
      if (actx != null && actx.isComplete()) {
         return;
      }
      boolean encoded = false;
      Object val = getRequest().getAttribute(mapper.encode(winId, name));
      if (val != null) {
         getRequest().setAttribute(mapper.encode(winId, name), o);
         encoded = true;
      } else {
         getRequest().setAttribute(name, o);
      }

      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Setting: ");
         txt.append(name).append(", value: ").append((o == null) ? "null" : o.toString());
         txt.append(", encoded: ").append(encoded);
         LOG.debug(txt.toString());
      }
   }
   
   @Override
   public void removeAttribute(String name) {
      PortletAsyncManager actx = reqctx.getPortletAsyncContext();
      if (actx != null && actx.isComplete()) {
         return;
      }
      boolean encoded = false;
      Object val = getRequest().getAttribute(mapper.encode(winId, name));
      if (val != null) {
         getRequest().removeAttribute(mapper.encode(winId, name));
         encoded = true;
      } else {
         getRequest().removeAttribute(name);
      }

      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Removing: ");
         txt.append(name);
         txt.append(", encoded: ").append(encoded);
         LOG.debug(txt.toString());
      }
   }
   
   @Override
   public String getServletPath() {
      String path = ((HttpServletRequest)getRequest()).getServletPath();
      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Servlet path: ");
         txt.append(path);
         LOG.debug(txt.toString());
      }
      return path;
   }
   
   @Override
   public String getPathInfo() {
      String info = ((HttpServletRequest)getRequest()).getPathInfo();
      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Path info: ");
         txt.append(info);
         LOG.debug(txt.toString());
      }
      return info;
   }
   
   @Override
   public AsyncContext startAsync() throws IllegalStateException {
      return reqctx.startAsync();
   }

   @Override
   public AsyncContext startAsync(ServletRequest request, ServletResponse response) throws IllegalStateException {
      return reqctx.startAsync(request, response);
   }

   @Override
   public boolean isAsyncStarted() {
      return reqctx.isAsyncStarted();
   }

   @Override
   public boolean isAsyncSupported() {
      return reqctx.isAsyncSupported();
   }
   
   @Override
   public AsyncContext getAsyncContext() {
      return reqctx.getAsyncContext();
   }


}
