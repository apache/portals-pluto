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

import javax.servlet.ServletContext;


/**
 * <div class="changed_added_3_0">
 * Class representing the execution context for an asynchronous operation that was
 * initiated on a ResourceRequest.
 * <p>
 * Portlet asynchronous support is modeled after servlet asynchronous support, and in 
 * general, the portlet async methods behave in the same manner as their 
 * <code>AsyncContext</code> analog. 
 * <p>
 * A PortletAsyncContext is created and initialized by a call to
 * ResourceRequest#startAsync() or ResourceRequest#startAsync(ServletRequest,
 * ServletResponse). Repeated invocations of these methods will return the same
 * AsyncContext instance, reinitialized as appropriate.
 * <p>
 * In the event that an asynchronous operation has timed out, the container must
 * invoke, at their onTimeout method, all PortletAsyncListener instances registered
 * with the ResourceRequest on which the asynchronous operation was initiated.
 * If none of the listeners called complete() or any of the dispatch() methods,
 * complete the request on behalf of the application. * 
 * </div>
 * 
 * @see     javax.servlet.AsyncContext
 * @since   3.0
 */
public interface PortletAsyncContext {

   /**
    * <div class="changed_added_3_0">
    * Registers the given <code>PortletAsyncListener</code> with the most recent 
    * asynchronous cycle that was started by a call to one of the 
    * <code>ResourceRequest.startAsync()</code> methods.
    * <p>
    * The given <code>PortletAsyncListener</code> will receive an 
    * <code>PortletAsyncEvent</code> when the
    * asynchronous cycle completes successfully, times out, results in an error, or a
    * new asynchronous cycle is being initiated via one of the
    * <code>ResourceRequest.startAsync()</code> methods.
    * <p>
    * <code>PortletAsyncListener</code> instances will be notified in the order in 
    * which they were added. 
    * <p>
    * If <code>ResourceRequest.startAsync(ResourceRequest, ResourceResponse)</code> or
    * <code>ResourceRequest.startAsync()</code> is called, the exact same request and response
    * objects are available from the <code>PortletAsyncEvent</code> when the 
    * <code>PortletAsyncListener</code> is notified.
    * </div>
    * 
    * @since   3.0
    * 
    * @param listener   the listener to be added
    * @throws IllegalStateException
    * if this method is called after the container-initiated dispatch, during which
    * one of the <code>ServletRequest.startAsync()</code> methods was called, has
    * returned to the container
    * 
    */
   public void addListener(PortletAsyncListener listener) throws IllegalStateException;

   /**
    * <div class="changed_added_3_0">
    * Registers the given <code>PortletAsyncListener</code> with the most recent 
    * asynchronous cycle that was started by a call to one of the 
    * <code>ResourceRequest.startAsync()</code> methods.
    * <p>
    * The given <code>PortletAsyncListener</code> will receive an 
    * <code>PortletAsyncEvent</code> when the
    * asynchronous cycle completes successfully, times out, results in an error, or a
    * new asynchronous cycle is being initiated via one of the
    * <code>ResourceRequest.startAsync()</code> methods.
    * <p>
    * <code>PortletAsyncListener</code> instances will be notified in the order in 
    * which they were added. 
    * <p>
    * The given <code>ResourceRequest</code> and <code>ResourceResponse</code> objects will be made
    * available to the given <code>PortletAsyncListener</code> via the 
    * <code>getSuppliedRequest</code> and
    * <code>getSuppliedResponse</code> methods, respectively, of the 
    * <code>PortletAsyncEvent</code> delivered to
    * it. These objects should not be read from or written to, respectively, at the
    * time the <code>PortletAsyncEvent</code> is delivered, because additional wrapping 
    * may have
    * occurred since the given <code>PortletAsyncListener</code> was registered, but may 
    * be used in
    * order to release any resources associated with them.
    * </div>
    * 
    * @since   3.0
    * 
    * @param listener   the listener to be added
    * @param request    the request object to be included in the <code>PortletAsyncEvent</code>
    * @param response   the response object to be included in the <code>PortletAsyncEvent</code>
    * @throws IllegalStateException
    * if this method is called after the container-initiated dispatch, during which
    * one of the <code>ServletRequest.startAsync()</code> methods was called, has
    * returned to the container
    * 
    */
   public void addListener(PortletAsyncListener listener, ResourceRequest request, ResourceResponse response) throws IllegalStateException;

   /**
    * <div class="changed_added_3_0">
    * </div>
    * 
    * @since   3.0
    * 
    * @throws IllegalStateException
    * if this method is called before an asynchronous processing cycle was started, 
    * after it has already been completed, or after a call to 
    * one of the <code>ServletRequest.dispatch()</code> methods
    * 
    */
   public void complete() throws IllegalStateException;

   /**
    * <div class="changed_added_3_0">
    * Instantiates the given AsyncListener class.
    * <p>
    * The returned AsyncListener instance may be further customized before it is
    * registered with this AsyncContext via a call to one of the addListener methods.
    * <p>
    * The given AsyncListener class must define a zero argument constructor, which is
    * used to instantiate it.
    * <p>
    * This method supports resource injection if the given class represents a Managed
    * Bean. See the Java EE platform and JSR 299 specifications for additional details
    * about Managed Beans and resource injection.
    * </div>
    * 
    * @since   3.0
    * 
    * @param cls     the class to be instantiated
    * @return        the instantiated class
    * @throws PortletException if the given class cannot be instantiated
    */
   public <T extends PortletAsyncListener> T createListener(Class<T> cls) throws PortletException;

   /**
    * <div class="changed_added_3_0">
    * </div>
    * 
    * @since   3.0
    * 
    * @throws IllegalStateException 
    * if called before an asynchronous processing cycle has been started, 
    * if one of the dispatch methods has been called but the <code>startAsync<code/> method has not
    * been called during the resulting dispatch, or if <code>complete()<code/> was called
    */
   public void dispatch() throws IllegalStateException;

   /**
    * <div class="changed_added_3_0">
    * </div>
    * 
    * @since   3.0
    * 
    * @param path
    * @throws IllegalStateException
    * if called before an asynchronous processing cycle has been started, 
    * if one of the dispatch methods has been called but the <code>startAsync<code/> method has not
    * been called during the resulting dispatch, or if <code>complete()<code/> was called
    */
   public void dispatch(String path) throws IllegalStateException;

   /**
    * <div class="changed_added_3_0">
    * </div>
    * 
    * @since   3.0
    * 
    * @param context
    * @param path
    * @throws IllegalStateException
    * if called before an asynchronous processing cycle has been started, 
    * if one of the dispatch methods has been called but the <code>startAsync<code/> method has not
    * been called during the resulting dispatch, or if <code>complete()<code/> was called
    */
   public void dispatch(ServletContext context, String path) throws IllegalStateException;

   /**
    * <div class="changed_added_3_0">
    * Gets the request that was used to initialize this <code>PortletAsyncContext</code> by calling
    * <code>ResourceRequest.startAsync()</code> or <code>ResourceRequest.startAsync(ServletRequest, ServletResponse)</code>.
    * </div>
    * 
    * @since   3.0
    * 
    * @return
    * @throws IllegalStateException
    * if one of the dispatch methods has been called but the <code>startAsync<code/> method has not
    * been called during the resulting dispatch, or if <code>complete()<code/> was called
    */
   public ResourceRequest getRequest() throws IllegalStateException;

   /**
    * <div class="changed_added_3_0">
    * Gets the response that was used to initialize this <code>PortletAsyncContext</code> by calling
    * <code>ResourceRequest.startAsync()</code> or <code>ResourceRequest.startAsync(ServletRequest, ServletResponse)</code>.
    * </div>
    * 
    * @since   3.0
    * 
    * @return
    * @throws IllegalStateException
    * if one of the dispatch methods has been called but the <code>startAsync<code/> method has not
    * been called during the resulting dispatch, or if <code>complete()<code/> was called
    */
   public ResourceResponse getResponse() throws IllegalStateException;

   /**
    * <div class="changed_added_3_0">
    * Gets the timeout (in milliseconds) for this PortletAsyncContext.
    * <p>
    * This method returns the container's default timeout for asynchronous operations,
    * or the timeout value passed to the most recent invocation of 
    * <code>setTimeout(long)</code>.
    * <p>
    * A timeout value of zero or less indicates no timeout.
    * </div>
    * 
    * @since   3.0
    * 
    * @return     the timeout in milliseconds
    */
   public long getTimeout();

   /**
    * <div class="changed_added_3_0">
    * Checks if this <code>PortletAsyncContext</code> was initialized with the original or
    * application-wrapped request and response objects.
    * <p>
    * This information may be used by filters invoked in the outbound direction, after
    * a request was put into asynchronous mode, to determine whether any request
    * and/or response wrappers that they added during their inbound invocation need to
    * be preserved for the duration of the asynchronous operation, or may be released.
    * </div>
    * 
    * @since   3.0
    * 
    * @return
    * <code>true</code> if this <code>PortletAsyncContext</code> was initialized with the original 
    * request and response objects by calling <code>ResourceRequest.startAsync()</code>, 
    * or if it was initialized by calling 
    * <code>ResourceRequest.startAsync(ResourceRequest, ResourceResponse)</code>, and neither
    * the <code>ResourceRequest</code> nor <code>ResourceResponse</code> arguments carried any
    * application-provided wrappers; <code>false</code> otherwise

    */
   public boolean hasOriginalRequestAndResponse();

   /**
    * <div class="changed_added_3_0">
    * Sets the timeout (in milliseconds) for this <code>PortletAsyncContext</code>.
    * <p>
    * The timeout applies to this <code>PortletAsyncContext</code> once the 
    * container-initiated dispatch
    * during which one of the <code>ResourceRequest.startAsync()</code> methods was 
    * called has returned to the container.
    * <p>
    * The timeout will expire if neither the <code>complete()</code> method nor any of 
    * the dispatch
    * methods are called. A timeout value of zero or less indicates no timeout.
    * <p>
    * If <code>setTimeout(long)</code> is not called, then the container's default timeout, 
    * which is available via a call to <code>getTimeout()</code>, will apply.
    * <p>
    * The default value is 30000 ms.
    * </div>
    * 
    * @since   3.0
    * 
    * @param time    the timeout in milliseconds
    */
   public void setTimeout(long time);

   /**
    * <div class="changed_added_3_0">
    * </div>
    * 
    * @since   3.0
    * 
    * @param run
    * @throws IllegalStateException
    * if this method is called before an asynchronous processing cycle was started, 
    * after it has already been completed, or after a call to 
    * one of the <code>ServletRequest.dispatch()</code> methods
    * 
    **/
   public void start(Runnable run) throws IllegalStateException;

}
