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
 * Class representing the execution context for an asynchronous operation that was
 * initiated on a ResourceRequest.
 * <p>
 * Portlet asynchronous support is modeled after servlet asynchronous support, and in 
 * general, the portlet async methods behave in the same manner as their 
 * <code>AsyncContext</code> analog. 
 * <p>
 * A <code>PortletAsyncContext</code> is created and initialized by a call to
 * <code>ResourceRequest#startAsync()</code> or 
 * <code>ResourceRequest#startAsync(ServletRequest, ServletResponse)</code>. 
 * Repeated invocations of these methods will return the same
 * <code>PortletAsyncContext</code> instance, reinitialized as appropriate.
 * <p>
 * In the event that an asynchronous operation times out, the container will
 * invoke the onTimeout method of all <code>PortletAsyncListener</code> instances registered
 * with the <code>PortletAsyncContext</code> on which the asynchronous operation was initiated.
 * If none of the listeners call <code>complete()</code> or any of the 
 * <code>dispatch()</code> methods, the portlet container will
 * complete the request on behalf of the application and may respond with error information.
 * </div>
 * 
 * @see     javax.servlet.AsyncContext
 * @see     PortletAsyncListener
 * @see     PortletAsyncEvent
 * 
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
    * When one of the listener methods is invoked, the 
    * <code>PortletAsyncListener</code> <code>getSuppliedRequest()</code> and
    * <code>getSuppliedResponse()</code> methods of the 
    * <code>PortletAsyncEvent</code> object will return <code>null</code>.
    * </div>
    * 
    * @see PortletAsyncListener
    * @see PortletAsyncEvent
    * 
    * @param listener   the listener to be added
    * @throws IllegalStateException
    * if this method is called after the container-initiated dispatch, during which
    * one of the <code>ResourceRequest.startAsync()</code> methods was called, has
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
    * it. These objects should not be read from or written to at the
    * time the <code>PortletAsyncEvent</code> is delivered, because additional wrapping 
    * may have
    * occurred since the given <code>PortletAsyncListener</code> was registered. 
    * However, they may be used to release any resources associated with them.
    * </div>
    * 
    * @see PortletAsyncListener
    * @see PortletAsyncEvent
    * 
    * @param listener   the listener to be added
    * @param request    the request object to be included in the <code>PortletAsyncEvent</code>
    * @param response   the response object to be included in the <code>PortletAsyncEvent</code>
    * @throws IllegalStateException
    * if this method is called after the container-initiated dispatch, during which
    * one of the <code>ResourceRequest.startAsync()</code> methods was called, has
    * returned to the container
    * 
    */
   public void addListener(PortletAsyncListener listener, ResourceRequest request, ResourceResponse response) throws IllegalStateException;

   /**
    * <div class="changed_added_3_0">
    * Completes the <code>PortletAsynchronous</code> operation
    * and closes the response associated with this <code>PortletAsyncContext</code> object.
    * <p>
    * The <code>onComplete</code> method of any registered listeners that were registered 
    * with the <code>PortletAsyncContext</code> object for this asynchronous cycle 
    * will be invoked.
    * <p>
    * It is legal to call this method any time after a call to
    * <code>ResourceRequest#startAsync()</code> or 
    * <code>ResourceRequest#startAsync(ResourceRequest, ResourceResponse)</code>, 
    * and before a call to one of the dispatch methods of this
    * class. If this method is called before the container-initiated dispatch that
    * called <code>startAsync</code> has returned to the container, then the call will 
    * not take effect (and any invocations of 
    * <code>PortletAsyncListener#onComplete(PortletAsyncEvent)</code> will
    * be delayed) until after the container-initiated dispatch has returned to the
    * container.
    * </div>
    * 
    * @throws IllegalStateException
    * if this method is called before an asynchronous processing cycle was started, 
    * after it has already been completed, or after a call to 
    * one of the <code>dispatch()</code> methods
    * 
    */
   public void complete() throws IllegalStateException;

   /**
    * <div class="changed_added_3_0">
    * Instantiates the given <code>PortletAsyncListener</code> class.
    * <p>
    * The returned <code>PortletAsyncListener</code> instance may be further customized before it is
    * registered with this <code>PortletAsyncContext</code> via a call to one of the addListener methods.
    * <p>
    * The given <code>PortletAsyncListener</code> class must define a zero argument constructor, which is
    * used to instantiate it.
    * <p>
    * This method supports resource injection if contextual support is available, and if 
    * the given class represents a Managed
    * Bean. See the Java EE platform and JSR 299 specifications for additional details
    * about Managed Beans and resource injection.
    * </div>
    * 
    * @param cls     the class to be instantiated
    * @return        the instantiated class
    * @throws        PortletException if the given class cannot be instantiated
    */
   public <T extends PortletAsyncListener> T createPortletAsyncListener(Class<T> cls) throws PortletException;

   /**
    * <div class="changed_added_3_0">
    * Dispatches the request and response objects of this <code>PortletAsyncContext</code> to
    * the portlet container.
    * <p>
    * The portlet container will dispatch the the request and response to the
    * portlet resource method in which the first asynchronous processing cycle was
    * initiated.
    * <p>
    * This method returns immediately after passing the request and response
    * objects to a container managed thread which will perform the dispatch
    * operation. If this method is called before the container-initiated dispatch
    * that called startAsync has returned to the container, the dispatch operation
    * will be delayed until after the container-initiated dispatch has returned to
    * the container.
    * <p>
    * The dispatcher type of the request is set to <code>DispatcherType.ASYNC</code>. Unlike
    * forward dispatches, the response buffer and headers will not be reset, and
    * it is legal to dispatch even if the response has already been committed.
    * <p>
    * Control over the request and response is delegated to the dispatch target,
    * and the response will be closed when the dispatch target has completed
    * execution, unless <code>ResourceRequest#startAsync()</code> or
    * <code>ResourceRequest#startAsync(ResourceRequest, ResourceResponse)</code> are called.
    * <p>
    * Any errors or exceptions that may occur during the execution of this method
    * must be caught and handled by the container as follows:
    * <ul>
    * <li>
    * Invoke the <code>onError</code> method of all <code>PortletAsyncListener</code> 
    * instances registered with this <code>PortletAsyncContext</code> and
    * make the caught <code>Throwable</code> available via 
    * <code>PortletAsyncEvent#getThrowable</code>.
    * </li>
    * <li>
    * If none of the listeners called <code>complete()</code> or any of the <code>dispatch()</code>
    * methods, set the status code equal to
    * <code>HttpResourceResponse.SC_INTERNAL_SERVER_ERROR</code>, make the 
    * <code>Throwable</code> leading to the error available as the value of the
    * <code>RequestDispatcher.ERROR_EXCEPTION</code> request attribute, and perform 
    * an error dispatch to generate a platform-specific error message. 
    * </li>
    * <li>
    * Complete the asynchronous processing cycle by calling <code>complete()</code>.
    * </li>
    * </ul>
    * <p>
    * There can be at most one asynchronous dispatch operation per asynchronous
    * cycle, which is started by a call to one of the <code>ResourceRequest#startAsync</code>
    * methods. Any attempt to perform an additional asynchronous dispatch
    * operation within the same asynchronous cycle will result in an
    * <code>IllegalStateException</code>. When the container performs the dispatch operation,
    * <code>startAsync()</code> may be invoked on the dispatched request to initiate a new
    * asynchronous processing cycle, after which any of the dispatch methods or the
    * <code>complete()</code> method may be called.
    * </div>
    * 
    * @throws IllegalStateException 
    * if called before an asynchronous processing cycle has been started, 
    * if one of the dispatch methods has been called but the <code>startAsync</code> method has not
    * been called during the resulting dispatch, or if <code>complete()</code> was called
    */
   public void dispatch() throws IllegalStateException;

   /**
    * <div class="changed_added_3_0">
    * Dispatches the request and response objects of this <code>PortletAsyncContext</code> to
    * the given path within the <code>PortletContext</code>.
    * <p>
    * The path parameter is interpreted in the same way as in
    * <code>PortletContext#getRequestDispatcher(String)</code> scoped to
    * the current portlet context.
    * <p>
    * There can be at most one asynchronous dispatch operation per asynchronous
    * cycle, which is started by a call to one of the <code>ResourceRequest#startAsync</code>
    * methods. Any attempt to perform an additional asynchronous dispatch
    * operation within the same asynchronous cycle will result in an
    * <code>IllegalStateException</code>. When the container performs the dispatch operation,
    * <code>startAsync()</code> may be invoked on the dispatched request to initiate a new
    * asynchronous processing cycle, after which any of the dispatch methods or the
    * <code>complete()</code> method may be called.
    * <p>
    * See {@link #dispatch()} for additional details, including error handling.
    * </div>
    * 
    * @param path the path of the dispatch target, scoped to the PortletContext from which 
    * this PortletAsyncContext was initialized 
    * @throws IllegalStateException
    * if called before an asynchronous processing cycle has been started, 
    * if one of the dispatch methods has been called but the <code>startAsync</code> method has not
    * been called during the resulting dispatch, or if <code>complete()</code> was called
    */
   public void dispatch(String path) throws IllegalStateException;

   /**
    * <div class="changed_added_3_0">
    * Gets the request that was used to initialize this <code>PortletAsyncContext</code> by calling
    * <code>ResourceRequest.startAsync()</code> or <code>ResourceRequest.startAsync(ServletRequest, ServletResponse)</code>.
    * </div>
    * 
    * @return The resource request object
    * @throws IllegalStateException
    * if one of the dispatch methods has been called but the <code>startAsync</code> method has not
    * been called during the resulting dispatch, or if <code>complete()</code> was called
    */
   public ResourceRequest getResourceRequest() throws IllegalStateException;

   /**
    * <div class="changed_added_3_0">
    * Gets the response that was used to initialize this <code>PortletAsyncContext</code> by calling
    * <code>ResourceRequest.startAsync()</code> or <code>ResourceRequest.startAsync(ServletRequest, ServletResponse)</code>.
    * </div>
    * 
    * @return The resource response object
    * @throws IllegalStateException
    * if one of the dispatch methods has been called but the <code>startAsync</code> method has not
    * been called during the resulting dispatch, or if <code>complete()</code> was called
    */
   public ResourceResponse getResourceResponse() throws IllegalStateException;

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
    * @param time    the timeout in milliseconds
    */
   public void setTimeout(long time);

   /**
    * <div class="changed_added_3_0">
    * Causes the container to dispatch a thread, possibly from a managed thread pool,
    * to run the specified <code>Runnable</code>. The container may propagate appropriate
    * contextual information to the <code>Runnable</code>.
    * </div>
    * 
    * @param run     the asynchronous handler
    * @throws IllegalStateException
    * if this method is called before an asynchronous processing cycle was started, 
    * after it has already been completed, or after a call to 
    * one of the <code>dispatch()</code> methods
    * 
    **/
   public void start(Runnable run) throws IllegalStateException;

}
