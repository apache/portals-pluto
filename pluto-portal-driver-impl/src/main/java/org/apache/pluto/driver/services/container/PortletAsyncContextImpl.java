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


package org.apache.pluto.driver.services.container;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncListener;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletAsyncContext;
import org.apache.pluto.container.PortletResourceRequestContext;

/**
 * Wrapper class for the AsyncContext obtained from the servlet container. Provides
 * a couple of work-arounds for Tomcat async bugs as well as portlet-specific listener
 * support.
 * 
 * @author Scott Nicklous
 *
 */
public class PortletAsyncContextImpl implements PortletAsyncContext {

   private AsyncContext actx;
   private final HttpServletRequest hreq;

   public PortletAsyncContextImpl(AsyncContext actx, HttpServletRequest hreq) {
      this.actx = actx;
      this.hreq = hreq;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.driver.services.container.PortletAsyncContext#requestComplete(org.apache.pluto.container.PortletResourceRequestContext)
    */
   @Override
   public void init(PortletResourceRequestContext prctx) {

      // get the original container req & resp to pass to listener for resource releasing

      HttpServletRequest creq = prctx.getContainerRequest();
      HttpServletResponse cresp = prctx.getContainerResponse();

      PortletAsyncListener pal = new PortletAsyncListener();
      actx.addListener(pal, creq, cresp);
   }
   
   /* (non-Javadoc)
    * @see org.apache.pluto.driver.services.container.PortletAsyncContext#setWrapped(javax.servlet.AsyncContext)
    */
   @Override
   public void setWrapped(AsyncContext actx) {
      this.actx = actx;
   }

   /* (non-Javadoc)
    * @see javax.servlet.AsyncContext#addListener(javax.servlet.AsyncListener)
    */
   @Override
   public void addListener(AsyncListener l) {
      actx.addListener(l);
   }

   /* (non-Javadoc)
    * @see javax.servlet.AsyncContext#addListener(javax.servlet.AsyncListener, javax.servlet.ServletRequest, javax.servlet.ServletResponse)
    */
   @Override
   public void addListener(AsyncListener l, ServletRequest req, ServletResponse resp) {
      actx.addListener(l, req, resp);
   }

   /* (non-Javadoc)
    * @see javax.servlet.AsyncContext#complete()
    */
   @Override
   public void complete() {
      actx.complete();
   }

   /* (non-Javadoc)
    * @see javax.servlet.AsyncContext#createListener(java.lang.Class)
    */
   @Override
   public <T extends AsyncListener> T createListener(Class<T> cls) throws ServletException {
      return actx.createListener(cls);
   }

   /* (non-Javadoc)
    * @see javax.servlet.AsyncContext#dispatch()
    */
   @Override
   public void dispatch() {
      // workaround for Tomcat bug 59213
      actx.dispatch(hreq.getServletContext(), hreq.getServletPath());
   }

   /* (non-Javadoc)
    * @see javax.servlet.AsyncContext#dispatch(java.lang.String)
    */
   @Override
   public void dispatch(String path) {
      // workaround for Tomcat bug 59213
      actx.dispatch(hreq.getServletContext(), path);
   }

   /* (non-Javadoc)
    * @see javax.servlet.AsyncContext#dispatch(javax.servlet.ServletContext, java.lang.String)
    */
   @Override
   public void dispatch(ServletContext sctx, String path) {
      actx.dispatch(sctx, path);
   }

   /* (non-Javadoc)
    * @see javax.servlet.AsyncContext#getRequest()
    */
   @Override
   public ServletRequest getRequest() {
      return actx.getRequest();
   }

   /* (non-Javadoc)
    * @see javax.servlet.AsyncContext#getResponse()
    */
   @Override
   public ServletResponse getResponse() {
      return actx.getResponse();
   }

   /* (non-Javadoc)
    * @see javax.servlet.AsyncContext#getTimeout()
    */
   @Override
   public long getTimeout() {
      return actx.getTimeout();
   }

   /* (non-Javadoc)
    * @see javax.servlet.AsyncContext#hasOriginalRequestAndResponse()
    */
   @Override
   public boolean hasOriginalRequestAndResponse() {
      return actx.hasOriginalRequestAndResponse();
   }

   /* (non-Javadoc)
    * @see javax.servlet.AsyncContext#setTimeout(long)
    */
   @Override
   public void setTimeout(long time) {
      actx.setTimeout(time);
   }

   /* (non-Javadoc)
    * @see javax.servlet.AsyncContext#start(java.lang.Runnable)
    */
   @Override
   public void start(Runnable run) {
      actx.start(run);
   }

}
