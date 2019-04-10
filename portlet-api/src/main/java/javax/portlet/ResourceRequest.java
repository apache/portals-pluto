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

/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

package javax.portlet;

import javax.servlet.DispatcherType;

/**
 * <span class="changed_modified_3_0">The</span>
 * <code>ResourceRequest</code> interface represents the request
 * send to the portlet for rendering resources.
 * 
 * It extends the ClientDataRequest interface and provides resource request
 * information to portlets.
 * <p>
 * The portlet container creates an <CODE>ResourceRequest</CODE> object and
 * passes it as argument to the portlet's <CODE>serveResource</CODE> method.
 * <p>
 * The <code>ResourceRequest</code> is provided with the current portlet mode, window state, 
 * and render parameters that the portlet can access via the 
 * <code>PortletResourceRequest</code> with <code>getPortletMode</code> and, 
 * <code>getWindowState</code>, or one of the <code>getParameter</code> methods.   
 * ResourceURLs cannot change the current portlet mode, window state or 
 * render parameters. Parameters set on a resource URL are not render parameters 
 * but parameters for serving this resource and will last only for only 
 * this the current serveResource request.<br>
 * If a parameter is set that has the same name as a render parameter that this 
 * resource URL contains, the render parameter must be the last entry in the 
 * parameter value array. 
 * 
 * @see ClientDataRequest
 * @see ResourceServingPortlet
 * @since 2.0
 */
public interface ResourceRequest extends ClientDataRequest {

   /**
    * This property is set by the container if the container
    * has a cached response for the given validation tag. The property can be
    * retrieved using the <code>getProperty</code> method. 
    * <P>
    * The value is <code>"portlet.ETag "</code>.
    */
   public static final String ETAG = "portlet.ETag";

   /**
    * Returns the validation tag if the portlet container
    * has a cached response for this validation tag, or
    * <code>null</code> if no cached response exists.
    * <p>
    * This call returns the same value as 
    * <code>ResourceRequest.getProperty(ResourceRequest.ETAG)</code>.
    * 
    * @return  the validation tag if the portlet container
    *          has a cached response for this validation tag, or
    *          <code>null</code> if no cached response exists.
    */
   public String getETag();

   /**
    * Returns the resource ID set on the ResourceURL or <code>null</code>
    * if no resource ID was set on the URL.
    * 
    * @return  the resource ID set on the ResourceURL,or <code>null</code>
    *          if no resource ID was set on the URL. 
    */
   public String getResourceID();

   /**
    * Returns a <code>Map</code> of the private render parameters of this request.
    * Private parameters are not shared with other portlets or components.  
    * The returned parameters are "x-www-form-urlencoded" decoded.
    * <p>
    * The parameters returned do not include the resource parameters that
    * the portlet may have set on the resource URL triggering this
    * <code>serveResource</code> call.
    * <p>
    * The values in the returned <code>Map</code> are from type
    * String array (<code>String[]</code>).
    * <p>
    * If no private parameters exist this method returns an empty <code>Map</code>.
    *
    * @return     an immutable <code>Map</code> containing private parameter names as 
    *             keys and private parameter values as map values, or an empty <code>Map</code>
    *             if no private parameters exist. The keys in the parameter
    *             map are of type String. The values in the parameter map are of type
    *             String array (<code>String[]</code>).
    *             
    * @deprecated As of version 3.0. Use {@link PortletRequest#getRenderParameters()} instead.
    */

   @Deprecated
   public java.util.Map<String, String[]> getPrivateRenderParameterMap();


   /**
    * <div class="changed_added_3_0">
    * Gets the resource parameters set for this request.
    * <p>
    * Resource parameters are additional portlet parameters added to the 
    * URL triggering the request that extend the state information provided by 
    * the render parameters.
    * <p>
    * {@link PortletParameters} provides a description of the parameter concept.
    * </div>
    * 
    * @return   an immutable <code>ResourceParameters</code> object representing
    *           the resource parameters
    * @since    3.0
    * @see      PortletParameters 
    * @see      MutableResourceParameters 
    * @see      ResourceURL 
    */

   public ResourceParameters getResourceParameters();


   /**
    * Returns the portal preferred content type for the response.
    * <p>
    * The returned content type should be based on the HTTP Accept header 
    * provided by the client.
    * 
    * @return preferred content type of the response
    */

   public String getResponseContentType();


   /**
    * Gets a list of content types which the portal accepts for the response.
    * This list is ordered with the most preferable types listed first.
    * <p>
    * The returned content types should be based on the HTTP Accept header 
    * provided by the client.
    *
    * @return ordered list of content types for the response
    */

   public java.util.Enumeration<String> getResponseContentTypes();

   /**
    * Returns the cache level of this resource request.
    * <p>
    * Possible return values are: 
    * <code>ResourceURL.FULL, ResourceURL.PORTLET</code> 
    * or <code>ResourceURL.PAGE</code>.
    * 
    * @return  the cache level of this resource request.
    */
   public String getCacheability();


   /**
    * <span class="changed_modified_3_0">Returns</span> 
    * the current portlet mode of the portlet.
    * <div class="changed_added_3_0">
    * <p>
    * If called during a request where the cache level is set to 
    * <code>ResourceURL.FULL</code>, the portlet mode will not
    * be available. 
    * </div>
    *
    * @return   the portlet mode.
    * <span class="changed_added_3_0">
    *           The portlet mode UNDEFINED will be returned if the cache level is
    *           set to <code>ResourceURL.FULL</code>.  
    * </span>
    * 
    * @since 3.0
    */

   public PortletMode getPortletMode();


   /**
    * <span class="changed_modified_3_0">Returns</span> 
    * the current window state of the portlet.
    * <div class="changed_added_3_0">
    * <p>
    * If called during a request where the cache level is set to 
    * <code>ResourceURL.FULL</code>, the window state will not
    * be available. 
    * </div>
    *
    * @return   the window state.
    * <span class="changed_added_3_0">
    *           The window state UNDEFINED will be returned if the cache level is
    *           set to <code>ResourceURL.FULL</code>.  
    * </span>
    * 
    * @since 3.0
    */

   public WindowState getWindowState();


   /**
    * <div class="changed_added_3_0">
    * Puts this request into asynchronous mode and initializes the <code>AsyncContext</code>
    * object.
    * <p>
    * Calling this method will cause committal of the associated response to be delayed until 
    * <code>AsyncContext#complete</code> is called on the returned <code>AsyncContext</code>,
    * or the asynchronous operation has timed out.
    * <p>
    * This method clears the list of <code>AsyncListener</code> instances (if any) that were
    * registered with the <code>AsyncContext</code> returned by the previous call to one of the
    * <code>startAsync</code> methods, after calling each <code>AsyncListener</code> at 
    * its <code>onStartAsync</code> method.
    * <p>
    * Subsequent invocations of this method, or its overloaded variant, will return
    * the same <code>AsyncContext</code> instance, reinitialized as appropriate.
    * <p> 
    * The <code>AsyncContext</code> object can be used as described by the servlet
    * specification. The <code>ServletRequest</code> and <code>ServletResponse</code> 
    * objects obtained from the <code>AsyncContext</code> will provide functionality 
    * appropriate for the portlet environment.
    * <p>
    * The original <code>ResourceRequest</code> and <code>ResourceResponse</code> objects
    * will be made available as request attributes on the code>ServletRequest</code> object 
    * obtained from the <code>AsyncContext</code> under the names 
    * <code>javax.portlet.request</code>
    * and <code>javax.portlet.response</code>, respectively.
    * The <code>PortletConfig</code> object will be made available on the 
    * <code>ServletRequest</code> under the name 
    * <code>javax.portlet.config</code>.
    * <p>
    * The <code>AsyncContext#dispatch()</code> method will cause the portlet resource
    * method to be invoked with the <code>ResourceRequest</code> and <code>ResourceResponse</code>
    * objects available as attributes on the <code>ServletRequest</code> object obtained from
    * the <code>AsyncContext</code>.
    * In this case, the <code>ResourceRequest#isAsyncStarted()</code> method will return 
    * <code>false</code> and the <code>ResourceRequest#getDispatcherType()</code> method
    * will return <code>DispatcherType#ASYNC</code>.
    * <p>
    * A portlet <code>ResourceFilter</code> that allocates resources and attaches them to the 
    * <code>ResourceRequest</code> or that wraps the <code>ResourceRequest</code> or
    * <code>ResourceResponse</code> should not release resources in the outbound direction
    * if asynchronous mode has been started.
    * A portlet <code>ResourceFilter</code> can use the values provided by the 
    * <code>ResourceRequest#isAsyncStarted()</code> and the
    * <code>ResourceRequest#getDispatcherType()</code> methods to determine when to
    * allocate and release resources.
    * </div>
    * 
    * @return  the (re)initialized AsyncContext
    * 
    * @throws  IllegalStateException 
    *          if this request is within the scope of a filter or servlet that does not 
    *          support asynchronous operations (that is, isAsyncSupported() returns 
    *          false), or if this method is called again without any asynchronous 
    *          dispatch (resulting from one of the PortletAsyncContext#dispatch methods), 
    *          is called outside the scope of any such dispatch, or is called again 
    *          within the scope of the same dispatch, or if the response has 
    *          already been closed
    * 
    * @since   3.0
    * @see     javax.servlet.ServletRequest#startAsync()
    * @see     javax.servlet.AsyncContext
    * @see     #isAsyncStarted() 
    * @see     #getDispatcherType()
    * @see     javax.portlet.filter.ResourceFilter
    */

   public PortletAsyncContext startPortletAsync() throws IllegalStateException;


   /**
    * <div class="changed_added_3_0">
    * Puts this request into asynchronous mode and initializes the <code>AsyncContext</code>
    * object.
    * <p>
    * Calling this method will cause committal of the associated response to be delayed until 
    * <code>AsyncContext#complete</code> is called on the returned <code>AsyncContext</code>,
    * or the asynchronous operation has timed out.
    * <p>
    * This method clears the list of <code>AsyncListener</code> instances (if any) that were
    * registered with the <code>AsyncContext</code> returned by the previous call to one of the
    * <code>startAsync</code> methods, after calling each <code>AsyncListener</code> at 
    * its <code>onStartAsync</code> method.
    * <p> 
    * The <code>AsyncContext</code> object can be used as described by the servlet
    * specification. The <code>ServletRequest</code> and <code>ServletResponse</code> 
    * objects obtained from the <code>AsyncContext</code> will provide functionality 
    * appropriate for the portlet environment.
    * <p>
    * The <code>ResourceRequest</code> and <code>ResourceResponse</code> objects
    * passed as arguments to this method
    * will be made available as request attributes on the code>ServletRequest</code> object 
    * obtained from the <code>AsyncContext</code> under the names 
    * <code>javax.portlet.request</code>
    * and <code>javax.portlet.response</code>, respectively.
    * The <code>PortletConfig</code> object will be made available on the 
    * <code>ServletRequest</code> under the name 
    * <code>javax.portlet.config</code>.
    * <p>
    * Subsequent invocations of this method, or its zero-argument variant, will return
    * the same <code>AsyncContext</code> instance, reinitialized as appropriate.
    * If a call to this method is followed by a call to its zero-argument variant, 
    * the specified (and possibly wrapped) <code>ResourceRequest</code> and 
    * <code>ResourceResponse</code> objects will remain available  
    * as request attributes on the <code>ServletRequest</code> object 
    * obtained from the <code>AsyncContext</code>.
    * <p>
    * The <code>AsyncContext#dispatch()</code> method will cause the portlet resource
    * method to be invoked with the <code>ResourceRequest</code> and <code>ResourceResponse</code>
    * objects available as attributes on the <code>ServletRequest</code> object obtained from
    * the <code>AsyncContext</code>.
    * In this case, the <code>ResourceRequest#isAsyncStarted()</code> method will return 
    * <code>false</code> and the <code>ResourceRequest#getDispatcherType()</code> method
    * will return <code>DispatcherType#ASYNC</code>.
    * <p>
    * A portlet <code>ResourceFilter</code> that allocates resources and attaches them to the 
    * <code>ResourceRequest</code> or that wraps the <code>ResourceRequest</code> or
    * <code>ResourceResponse</code> should not release resources in the outbound direction
    * if asynchronous mode has been started.
    * A portlet <code>ResourceFilter</code> can use the values provided by the 
    * <code>ResourceRequest#isAsyncStarted()</code> and the
    * <code>ResourceRequest#getDispatcherType()</code> methods to determine when to
    * allocate and release resources.
    * </div>
    * 
    * @return  the (re)initialized AsyncContext 
    * 
    * @throws  IllegalStateException 
    *          if this request is within the scope of a filter or servlet that does not 
    *          support asynchronous operations (that is, isAsyncSupported() returns 
    *          false), or if this method is called again without any asynchronous 
    *          dispatch (resulting from one of the PortletAsyncContext#dispatch methods), 
    *          is called outside the scope of any such dispatch, or is called again 
    *          within the scope of the same dispatch, or if the response has 
    *          already been closed
    * 
    * @since   3.0
    * @see     javax.servlet.ServletRequest#startAsync()
    * @see     javax.servlet.AsyncContext 
    * @see     #isAsyncStarted() 
    * @see     #getDispatcherType()
    * @see     javax.portlet.filter.ResourceFilter
    */

   public PortletAsyncContext startPortletAsync(ResourceRequest request, ResourceResponse response) throws IllegalStateException;


   /**
    * <div class="changed_added_3_0">
    * Checks if this request has been put into asynchronous mode. 
    * <p>
    * A <code>ResourceRequest</code> is put into asynchronous mode by calling 
    * <code>startAsync()</code> or <code>startAsync(ResourceRequest,ResourceResponse)</code>
    * on it. 
    * <p>
    * This method returns <code>false</code> if this request was put into asynchronous mode, 
    * but has since been dispatched using one of the <code>AsyncContext#dispatch</code> 
    * methods or released from asynchronous mode via a call to <code>AsyncContext#complete</code>. 
    * </div>
    * 
    * @return   <code>true</code> if asynchronous mode has been started
    * @since    3.0
    * @see      #startPortletAsync()
    * @see      #startPortletAsync(ResourceRequest, ResourceResponse)
    */

   public boolean isAsyncStarted();
   

   /**
    * <div class="changed_added_3_0">
    * Checks if this request supports asynchronous operation. 
    * <p>
    * Asynchronous operation is disabled for this request if this request is within 
    * the scope of a filter or servlet that has not been annotated or flagged in 
    * the portlet configuration as being able to support asynchronous handling. 
    * </div>
    * 
    * @return   <code>true</code> if this request supports asynchronous operation
    * @since    3.0
    */

   public boolean isAsyncSupported();


   /**
    * <div class="changed_added_3_0">
    * Gets the <code>AsyncContext</code> that was created or reinitialized by the most 
    * recent invocation of <code>startAsync()</code> or 
    * <code>startAsync(ResourceRequest,ResourceResponse)</code> on this request. 
    * </div>
    * 
    * @return   the <code>AsyncContext</code> (re)initialized by the most recent <code>startAsync</code> method invocation 
    * 
    * @throws  IllegalStateException 
    *          if this request is within the scope of a filter or servlet that does not 
    *          support asynchronous operations (that is, isAsyncSupported() returns 
    *          false), or if asynchronous processing has not yet been started.
    *          
    * @since    3.0
    * @see      javax.servlet.ServletRequest#startAsync()
    * @see      javax.servlet.AsyncContext 
    */
   
   public PortletAsyncContext getPortletAsyncContext();


   /**
    * <div class="changed_added_3_0">
    * Gets the dispatcher type of this request. 
    * <p>
    * The initial dispatcher type of a request is defined as <code>DispatcherType.REQUEST</code>.
    * The dispatcher type of a request dispatched via a <code>RequestDispatcher</code>
    * is given as <code>DispatcherType.FORWARD</code> or <code>DispatcherType.INCLUDE</code>, 
    * while the dispatcher type of an asynchronous request dispatched via one of the
    * <code>AsyncContext#dispatch</code> methods is given as <code>DispatcherType.ASYNC</code>.
    * </div>
    * 
    * @return   the dispatcher type of this request
    * @since    3.0
    * @see      javax.servlet.DispatcherType
    */

   public DispatcherType getDispatcherType();

}
