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

package javax.portlet.tck.util;

import java.util.HashMap;
import java.util.Map;
import javax.portlet.tck.beans.TestCaseDetails;

/**
 * Defines constants for the test case names and test case details 
 * for the JSR 362 TCK.
 * 
 * Note that the backing map is static and not threadsafe. Operations
 * that change the map such as put, remove, etc., should not be used
 * in portlets.
 * 
 * @author nick
 */
public class ModuleTestCaseDetails extends TestCaseDetails {

   public final static String V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_ISASYNCSUPPORTED = "V3ResourceAsyncTests_SPEC_21_NoAsync_isAsyncSupported";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_ISASYNCSTARTED = "V3ResourceAsyncTests_SPEC_21_NoAsync_isAsyncStarted";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_STARTASYNC1 = "V3ResourceAsyncTests_SPEC_21_NoAsync_startAsync1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_STARTASYNC2 = "V3ResourceAsyncTests_SPEC_21_NoAsync_startAsync2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_GETDISPATCHERTYPE = "V3ResourceAsyncTests_SPEC_21_NoAsync_getDispatcherType";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_GETPORTLETASYNCCONTEXT = "V3ResourceAsyncTests_SPEC_21_NoAsync_getPortletAsyncContext";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSUPPORTED = "V3ResourceAsyncTests_SPEC_21_Async_isAsyncSupported";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSTARTED1 = "V3ResourceAsyncTests_SPEC_21_Async_isAsyncStarted1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSTARTED2 = "V3ResourceAsyncTests_SPEC_21_Async_isAsyncStarted2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC1 = "V3ResourceAsyncTests_SPEC_21_Async_startAsync1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC2 = "V3ResourceAsyncTests_SPEC_21_Async_startAsync2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC3 = "V3ResourceAsyncTests_SPEC_21_Async_startAsync3";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC4 = "V3ResourceAsyncTests_SPEC_21_Async_startAsync4";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE1 = "V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE2 = "V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE3 = "V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType3";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE4 = "V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType4";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE5 = "V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType5";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT1 = "V3ResourceAsyncTests_SPEC_21_Async_getPortletAsyncContext1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT2 = "V3ResourceAsyncTests_SPEC_21_Async_getPortletAsyncContext2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE1 = "V3ResourceAsyncTests_SPEC_21_Async_complete1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE2 = "V3ResourceAsyncTests_SPEC_21_Async_complete2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE3 = "V3ResourceAsyncTests_SPEC_21_Async_complete3";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE4 = "V3ResourceAsyncTests_SPEC_21_Async_complete4";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE5 = "V3ResourceAsyncTests_SPEC_21_Async_complete5";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE6 = "V3ResourceAsyncTests_SPEC_21_Async_complete6";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_SETTIMEOUT = "V3ResourceAsyncTests_SPEC_21_Async_setTimeout";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTIMEOUT1 = "V3ResourceAsyncTests_SPEC_21_Async_getTimeout1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTIMEOUT2 = "V3ResourceAsyncTests_SPEC_21_Async_getTimeout2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE1 = "V3ResourceAsyncTests_SPEC_21_Async_hasOriginalRequestAndResponse1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE2 = "V3ResourceAsyncTests_SPEC_21_Async_hasOriginalRequestAndResponse2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE3 = "V3ResourceAsyncTests_SPEC_21_Async_hasOriginalRequestAndResponse3";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST1 = "V3ResourceAsyncTests_SPEC_21_Async_getResourceRequest1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST2 = "V3ResourceAsyncTests_SPEC_21_Async_getResourceRequest2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST3 = "V3ResourceAsyncTests_SPEC_21_Async_getResourceRequest3";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE1 = "V3ResourceAsyncTests_SPEC_21_Async_getResourceResponse1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE2 = "V3ResourceAsyncTests_SPEC_21_Async_getResourceResponse2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE3 = "V3ResourceAsyncTests_SPEC_21_Async_getResourceResponse3";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER1 = "V3ResourceAsyncTests_SPEC_21_Async_createPortletAsyncListener1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER2 = "V3ResourceAsyncTests_SPEC_21_Async_createPortletAsyncListener2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER3 = "V3ResourceAsyncTests_SPEC_21_Async_createPortletAsyncListener3";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER4 = "V3ResourceAsyncTests_SPEC_21_Async_createPortletAsyncListener4";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER1 = "V3ResourceAsyncTests_SPEC_21_Async_addListener1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER2 = "V3ResourceAsyncTests_SPEC_21_Async_addListener2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER3 = "V3ResourceAsyncTests_SPEC_21_Async_addListener3";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER4 = "V3ResourceAsyncTests_SPEC_21_Async_addListener4";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH1 = "V3ResourceAsyncTests_SPEC_21_Async_dispatch1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH2 = "V3ResourceAsyncTests_SPEC_21_Async_dispatch2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH3 = "V3ResourceAsyncTests_SPEC_21_Async_dispatch3";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH4 = "V3ResourceAsyncTests_SPEC_21_Async_dispatch4";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH5 = "V3ResourceAsyncTests_SPEC_21_Async_dispatch5";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH6 = "V3ResourceAsyncTests_SPEC_21_Async_dispatch6";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH7 = "V3ResourceAsyncTests_SPEC_21_Async_dispatch7";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH8 = "V3ResourceAsyncTests_SPEC_21_Async_dispatch8";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH9 = "V3ResourceAsyncTests_SPEC_21_Async_dispatch9";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCHA = "V3ResourceAsyncTests_SPEC_21_Async_dispatchA";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START1 = "V3ResourceAsyncTests_SPEC_21_Async_start1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START2 = "V3ResourceAsyncTests_SPEC_21_Async_start2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START3 = "V3ResourceAsyncTests_SPEC_21_Async_start3";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START4 = "V3ResourceAsyncTests_SPEC_21_Async_start4";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI1 = "V3ResourceAsyncTests_SPEC_21_Async_cdi1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI2 = "V3ResourceAsyncTests_SPEC_21_Async_cdi2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI3 = "V3ResourceAsyncTests_SPEC_21_Async_cdi3";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONTIMEOUT = "V3ResourceAsyncTests_SPEC_21_Async_onTimeout";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONERROR = "V3ResourceAsyncTests_SPEC_21_Async_onError";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONCOMPLETE = "V3ResourceAsyncTests_SPEC_21_Async_onComplete";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONSTARTASYNC = "V3ResourceAsyncTests_SPEC_21_Async_onStartAsync";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT = "V3ResourceAsyncTests_SPEC_21_Async_getPortletAsyncContext";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST1 = "V3ResourceAsyncTests_SPEC_21_Async_getSuppliedRequest1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST2 = "V3ResourceAsyncTests_SPEC_21_Async_getSuppliedRequest2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE1 = "V3ResourceAsyncTests_SPEC_21_Async_getSuppliedResponse1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE2 = "V3ResourceAsyncTests_SPEC_21_Async_getSuppliedResponse2";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE1 = "V3ResourceAsyncTests_SPEC_21_Async_getThrowable1";
   public final static String V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE2 = "V3ResourceAsyncTests_SPEC_21_Async_getThrowable2";

   
   private final static Map<String, String> tcd = new HashMap<String, String>();
   static {

      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_ISASYNCSUPPORTED, "The ResourceRequest object isAsyncSupported() method returns false if the portlet does not support async processing");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_ISASYNCSTARTED, "The ResourceRequest object isAsyncStarted() method returns false if the portlet does not support async processing");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_STARTASYNC1, "The ResourceRequest object startAsync() method throws an IllegalStateException if the portlet does not support async processing");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_STARTASYNC2, "The ResourceRequest object startAsync(ResourceRequest, ResourceResponse) method throws an IllegalStateException if the portlet does not support async processing");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_GETDISPATCHERTYPE, "The ResourceRequest object getDispatcherType() method returns the value DispatcherType.REQUEST within the resource method if the portlet does not support async processing");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_GETPORTLETASYNCCONTEXT, "The ResourceRequest object getPortletAsyncContext() method throws an IllegalStateException if the portlet does not support async processing");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSUPPORTED, "The ResourceRequest object isAsyncSupported() method returns true if the portlet supports async processing");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSTARTED1, "The ResourceRequest object isAsyncStarted() method returns false if asynchronous processing has not been started");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSTARTED2, "The ResourceRequest object isAsyncStarted() method returns true if asynchronous processing has been started");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC1, "The ResourceRequest object startAsync() method returns a PortletAsyncContext object");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC2, "The ResourceRequest object startAsync(ResourceRequest, ResourceResponse) method returns a PortletAsyncContext object");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC3, "The ResourceRequest object startAsync() method throws an IllegalStateException if asynchronous processing has already been started");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC4, "The ResourceRequest object startAsync(ResourceRequest, ResourceResponse) method throws an IllegalStateException if asynchronous processing has already been started");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE1, "The ResourceRequest object getDispatcherType() method returns the value DispatcherType.REQUEST within the resource method before the container dispatch cycle in which asynchronous processing is started returns");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE2, "The ResourceRequest object getDispatcherType() method returns the value DispatcherType.REQUEST within the resource filter before the container dispatch cycle in which asynchronous processing is started returns");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE3, "The ResourceRequest object getDispatcherType() method returns the value DispatcherType.ASYNC within the resource method when the PortletAsyncContext object dispatch() method is used to dispatch to the resource method ");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE4, "The ResourceRequest object getDispatcherType() method returns the value DispatcherType.ASYNC within the resource filter when the PortletAsyncContext object dispatch() method is used to dispatch to the resource method ");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE5, "The ResourceRequest object getDispatcherType() method returns the value DispatcherType.ASYNC within the dispatch target method when the PortletAsyncContext object dispatch(String) method is used to dispatch to the resource method ");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT1, "The ResourceRequest object getPortletAsyncContext() method throws an IllegalStateException if async processing has not been started");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT2, "The ResourceRequest object getPortletAsyncContext() method returns a PortletAsyncContext object if async processing has been started");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE1, "The PortletAsyncContext object complete() method completes asynchronous processing within the original resource request");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE2, "The PortletAsyncContext object complete() method completes asynchronous processing within an asynchronous thread");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE3, "The PortletAsyncContext object complete() method throws an IllegalStateException if called before asynchronous processing has started");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE4, "The PortletAsyncContext object complete() method throws an IllegalStateException if called after asynchronous processing has completed");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE5, "The PortletAsyncContext object complete() method throws an IllegalStateException if called after the PortletAsyncContext object dispatch() method has been called");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE6, "The PortletAsyncContext object complete() method throws an IllegalStateException if called after the PortletAsyncContext object dispatch(String) method has been called");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_SETTIMEOUT, "The PortletAsyncContext object setTimeout() method sets the asynchronous timeout value");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTIMEOUT1, "The PortletAsyncContext object getTimeout() method returns the default value of 30000 ms");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTIMEOUT2, "The PortletAsyncContext object getTimeout() method returns a previously set timeout value");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE1, "The PortletAsyncContext object hasOriginalRequestAndResponse() method returns true if asynchronous processing was started through the startPortletAsync() method");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE2, "The PortletAsyncContext object hasOriginalRequestAndResponse() method returns true if asynchronous processing was started through the startPortletAsync(ResourceRequest, ResourceResponse) method if the request and response objects were not wrapped");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE3, "The PortletAsyncContext object hasOriginalRequestAndResponse() method returns false if asynchronous processing was started through the startPortletAsync(ResourceRequest, ResourceResponse) method if the request and response objects were wrapped");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST1, "The PortletAsyncContext object getResourceRequest() method returns the original ResourceRequest object if asynchronous processing was started through the startPortletAsync() method");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST2, "The PortletAsyncContext object getResourceRequest() method returns the original ResourceRequest object if asynchronous processing was started through the startPortletAsync(ResourceRequest, ResourceResponse) method if the request and response objects were not wrapped");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST3, "The PortletAsyncContext object getResourceRequest() method returns the wrapped ResourceRequest object if asynchronous processing was started through the startPortletAsync(ResourceRequest, ResourceResponse) method if the request and response objects were wrapped");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE1, "The PortletAsyncContext object getResourceResponse() method returns the original ResourceResponse object if asynchronous processing was started through the startPortletAsync() method");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE2, "The PortletAsyncContext object getResourceResponse() method returns the original ResourceResponse object if asynchronous processing was started through the startPortletAsync(ResourceRequest, ResourceResponse) method if the request and response objects were not wrapped");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE3, "The PortletAsyncContext object getResourceResponse() method returns the wrapped  ResourceResponse object if asynchronous processing was started through the startPortletAsync(ResourceRequest, ResourceResponse) method if the request and response objects were wrapped");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER1, "The PortletAsyncContext object createPortletAsyncListener(Class) method returns an instance of the PortletAsyncListener class provided");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER2, "The PortletAsyncContext object createPortletAsyncListener(Class) method throws a PortletException if the class provided is not of type PortletAsyncListener");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER3, "The PortletAsyncContext object createPortletAsyncListener(Class) method throws a PortletException if the class provided cannot be instantiated");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER4, "The PortletAsyncContext object createPortletAsyncListener(Class) method throws a PortletException if the class provided does not have a zero argument constructor");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER1, "The PortletAsyncContext object addListener(PortletAsyncListener) method adds a portlet asynchronous listener");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER2, "The PortletAsyncContext object addListener(PortletAsyncListener) method throws an IllegalStateException if called after the container-initiated dispatch during which one of the startAsync() methods was called has returned to the container");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER3, "The PortletAsyncContext object addListener(PortletAsyncListener, ResourceRequest, ResourceResponse) method adds a portlet asynchronous listener");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER4, "The PortletAsyncContext object addListener(PortletAsyncListener, ResourceRequest, ResourceResponse) method throws an IllegalStateException if called after the container-initiated dispatch during which one of the startAsync() methods was called has returned to the container");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH1, "The PortletAsyncContext object dispatch() method dispatches to the resource method if called from within the original resource request");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH2, "The PortletAsyncContext object dispatch() method dispatches to the resource method if called from within an asynchronous thread");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH3, "The PortletAsyncContext object dispatch() method throws an IllegalStateException if called before a new asynchronous processing cycle has been started");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH4, "The PortletAsyncContext object dispatch() method throws an IllegalStateException if called after asynchronous processing has completed");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH5, "The PortletAsyncContext object dispatch() method throws an IllegalStateException if called after a dispatch method has been called within the same container dispatch cycle");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH6, "The PortletAsyncContext object dispatch(String) method dispatches to the given path if called from within the original resource request");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH7, "The PortletAsyncContext object dispatch(String) method dispatches to the given path if called from within an asynchronous thread");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH8, "The PortletAsyncContext object dispatch(String) method throws an IllegalStateException if called before a new asynchronous processing cycle has been started");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH9, "The PortletAsyncContext object dispatch(String) method throws an IllegalStateException if called after asynchronous processing has completed");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCHA, "The PortletAsyncContext object dispatch(String) method throws an IllegalStateException if called after a dispatch method has been called within the same container dispatch cycle");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START1, "The PortletAsyncContext object start(String) method causes an asynchronous thread to run");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START2, "The PortletAsyncContext object start(String) method throws an IllegalStateException if called before a new asynchronous processing cycle has been started");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START3, "The PortletAsyncContext object start(String) method throws an IllegalStateException if called after asynchronous processing has completed");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START4, "The PortletAsyncContext object start(String) method throws an IllegalStateException if called after a dispatch method has been called within the same container dispatch cycle");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI1, "When CDI is available and the asynchronous thread is started through the PortletAsyncContext object, the asynchronous thread runs in the same context as the original request");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI2, "When CDI is available and the asynchronous thread is started through the PortletAsyncContext object, the PortletAsyncListener runs in the same context as the original request");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI3, "When CDI is available and the asynchronous thread is started through the PortletAsyncContext object, the resource filter runs in the same context as the original request");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONTIMEOUT, "The PortletAsyncListener object onTimeout(PortletAsyncEvent) method is called when a timeout occurs ");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONERROR, "The PortletAsyncListener object onError(PortletAsyncEvent) method is called if an exception is thrown in an asynchronous thread started through the PortletAsyncContext object ");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONCOMPLETE, "The PortletAsyncListener object onComplete(PortletAsyncEvent) method is called when asynchronous processing completes ");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONSTARTASYNC, "The PortletAsyncListener object onStartAsync(PortletAsyncEvent) method is called when asynchronous processing is restarted ");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT, "The PortletAsyncEvent object getPortletAsyncContext() method returns the PortletAsyncContext object for the request");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST1, "The PortletAsyncEvent object getSuppliedRequest() method returns null if no resource request was supplied when the PortletAsyncListener was added ");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST2, "The PortletAsyncEvent object getSuppliedRequest() method returns the supplied request if a resource request was supplied when the PortletAsyncListener was added ");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE1, "The PortletAsyncEvent object getSuppliedResponse() method returns null if no resource response was supplied when the PortletAsyncListener was added ");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE2, "The PortletAsyncEvent object getSuppliedResponse() method returns the supplied response if a resource response was supplied when the PortletAsyncListener was added ");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE1, "The PortletAsyncEvent object getThrowable() method returns null within the PortletAsyncListener object onComplete(), onTimeout(), and onStartAsync() methods");
      tcd.put(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE2, "The PortletAsyncEvent object getThrowable() method returns the Throwable object associated with the error within the PortletAsyncListener object onError() method");

   }

   /**
    * Constructor.
    * 
    * Passes the static test case names - details map to the superclass
    * 
    * Note that the backing map is static and not threadsafe. Operations
    * that change the map such as put, remove, etc., should not be used
    * in portlets.
    */
   public ModuleTestCaseDetails() {
     super(tcd); 
   }

}
