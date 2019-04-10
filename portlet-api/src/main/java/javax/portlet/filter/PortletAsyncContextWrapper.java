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


package javax.portlet.filter;

import javax.portlet.PortletAsyncContext;
import javax.portlet.PortletAsyncListener;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * <div class="changed_added_3_0">
 * The <code>PortletAsyncContextWrapper</code> provides a convenient 
 * implementation of the <code>PortletAsyncContext</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped object.
 * </div>
 *
 * @since 3.0
 */
public class PortletAsyncContextWrapper implements PortletAsyncContext {
   
   private PortletAsyncContext wrapped;
   
   public PortletAsyncContextWrapper(PortletAsyncContext wrapped) {
      if (wrapped == null) {
         throw new java.lang.IllegalArgumentException("Object to wrap is null");
      }
      this.wrapped = wrapped;
   }

   /**
    * @return the wrapped object
    */
   public PortletAsyncContext getWrapped() {
      return wrapped;
   }

   /**
    * @param wrapped the wrapped object to set. May not be null.
    */
   public void setWrapped(PortletAsyncContext wrapped) {
      if (wrapped == null) {
         throw new java.lang.IllegalArgumentException("Object to wrap is null");
      }
      this.wrapped = wrapped;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncContext#addListener(javax.portlet.PortletAsyncListener)
    */
   @Override
   public void addListener(PortletAsyncListener listener) throws IllegalStateException {
      wrapped.addListener(listener);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncContext#addListener(javax.portlet.PortletAsyncListener, javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
    */
   @Override
   public void addListener(PortletAsyncListener listener, ResourceRequest request, ResourceResponse response)
         throws IllegalStateException {
      wrapped.addListener(listener, request, response);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncContext#complete()
    */
   @Override
   public void complete() throws IllegalStateException {
      wrapped.complete();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncContext#createPortletAsyncListener(java.lang.Class)
    */
   @Override
   public <T extends PortletAsyncListener> T createPortletAsyncListener(Class<T> cls) throws PortletException {
      return wrapped.createPortletAsyncListener(cls);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncContext#dispatch()
    */
   @Override
   public void dispatch() throws IllegalStateException {
      wrapped.dispatch();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncContext#dispatch(java.lang.String)
    */
   @Override
   public void dispatch(String path) throws IllegalStateException {
      wrapped.dispatch(path);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncContext#getResourceRequest()
    */
   @Override
   public ResourceRequest getResourceRequest() throws IllegalStateException {
      return wrapped.getResourceRequest();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncContext#getResourceResponse()
    */
   @Override
   public ResourceResponse getResourceResponse() throws IllegalStateException {
      return wrapped.getResourceResponse();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncContext#getTimeout()
    */
   @Override
   public long getTimeout() {
      return wrapped.getTimeout();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncContext#hasOriginalRequestAndResponse()
    */
   @Override
   public boolean hasOriginalRequestAndResponse() {
      return wrapped.hasOriginalRequestAndResponse();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncContext#setTimeout(long)
    */
   @Override
   public void setTimeout(long time) {
      wrapped.setTimeout(time);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncContext#start(java.lang.Runnable)
    */
   @Override
   public void start(Runnable run) throws IllegalStateException {
      wrapped.start(run);
   }

}
