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


package javax.portlet;


/**
 * <div class="changed_added_3_0">
 * Event that gets fired when the asynchronous operation initiated on a
 * <code>ResourceRequest</code> (via a call to <code>ResourceRequest#startAsync</code> or
 * <code>ResourceRequest#startAsync(ResourceRequest, ResouceResponse))</code> has completed, timed
 * out, or produced an error.
 * </div>
 * 
 * @see     PortletAsyncContext
 * @see     PortletAsyncEvent
 * @see     ResourceRequest
 * @since   3.0
 */
public class PortletAsyncEvent {

   PortletAsyncContext  context;
   ResourceRequest      request;
   ResourceResponse     response;
   Throwable            throwable;
   
   /**
    * <div class="changed_added_3_0">
    * Constructs a <code>PortletAsyncEvent</code> from the given 
    * <code>PortletAsyncContext</code>, <code>ResourceRequest</code>, <code>ResourceResponse</code>, 
    * and <code>Throwable</code>.
    * </div>
    * 
    * @param context
    * @param request
    * @param response
    * @param throwable
    */
   public PortletAsyncEvent(PortletAsyncContext context, ResourceRequest request, ResourceResponse response, Throwable throwable) {
      this.context = context;
      this.request = request;
      this.response = response;
      this.throwable = throwable;
   }

   /**
    * <div class="changed_added_3_0">
    * Constructs a <code>PortletAsyncEvent</code> from the given 
    * <code>PortletAsyncContext</code>, <code>ResourceRequest</code>, and <code>ResourceResponse</code>.
    * </div>
    * 
    * @param context
    * @param request
    * @param response
    */
   public PortletAsyncEvent(PortletAsyncContext context, ResourceRequest request, ResourceResponse response) {
      this.context = context;
      this.request = request;
      this.response = response;
      this.throwable = null;
   }

   /**
    * <div class="changed_added_3_0">
    * Constructs a <code>PortletAsyncEvent</code> from the given 
    * <code>PortletAsyncContext</code> and <code>Throwable</code>.
    * </div>
    * 
    * @param context
    * @param throwable
    */
   public PortletAsyncEvent(PortletAsyncContext context, Throwable throwable) {
      this.context = context;
      this.request = null;
      this.response = null;
      this.throwable = throwable;
   }

   /**
    * <div class="changed_added_3_0">
    * Constructs a <code>PortletAsyncEvent</code> from the given 
    * <code>PortletAsyncContext</code>.
    * </div>
    * 
    * @param context
    */
   public PortletAsyncEvent(PortletAsyncContext context) {
      this.context = context;
      this.request = null;
      this.response = null;
      this.throwable = null;
   }

   /**
    * <div class="changed_added_3_0">
    * Gets the portlet asynchronous context object associated with the event.
    * </div>
    * 
    * @return the portlet asynchronous context
    */
   public PortletAsyncContext getPortletAsyncContext() {
      return context;
   }

   /**
    * <div class="changed_added_3_0">
    * Gets the resource request associated with the listener when it was added through the 
    * <code>PortletAsyncContext#addListener(PortletAsyncListener, ResourceRequest, ResourceResponse)</code>
    * method. 
    * <p>
    * If the listener was added through the 
    * <code>PortletAsyncContext#addListener(PortletAsyncListener)</code> method,
    * the returned resource request will be <code>null</code>.
    * </div>
    * 
    * @return the resource request provided to the constructor, or <code>null</code>
    * if no resource request was provided.
    */
   public ResourceRequest getSuppliedRequest() {
      return request;
   }

   /**
    * <div class="changed_added_3_0">
    * Gets the resource response associated with the listener when it was added through the 
    * <code>PortletAsyncContext#addListener(PortletAsyncListener, ResourceRequest, ResourceResponse)</code>
    * method. 
    * <p>
    * If the listener was added through the 
    * <code>PortletAsyncContext#addListener(PortletAsyncListener)</code> method,
    * the returned resource response will be <code>null</code>.
    * </div>
    * 
    * @return the resource response provided to the constructor, or <code>null</code>
    * if no resource response was provided.
    */
   public ResourceResponse getSuppliedResponse() {
      return response;
   }

   /**
    * <div class="changed_added_3_0">
    * Gets the <code>Throwable</code> associated with the event.
    * </div>
    * 
    * @return The <code>Throwable</code> that was used to initialize the event, or <code>null</code>
    * if no <code>Throwable</code> was provided.
    */
   public Throwable getThrowable() {
      return throwable;
   }

}
