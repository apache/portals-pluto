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

package javax.portlet.tck.portlets;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE6;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH6;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH7;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH8;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH9;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCHA;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTIMEOUT1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTIMEOUT2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSTARTED1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSTARTED2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSUPPORTED;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONCOMPLETE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONERROR;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONSTARTASYNC;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONTIMEOUT;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_SETTIMEOUT;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC4;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.inject.Inject;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletAsyncContext;
import javax.portlet.PortletAsyncListener;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.filter.ResourceRequestWrapper;
import javax.portlet.filter.ResourceResponseWrapper;
import javax.portlet.tck.beans.ResourceLink;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import javax.servlet.DispatcherType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "ResourceAsyncTests_SPEC_21_Async", asyncSupported = true)
public class ResourceAsyncTests_SPEC_21_Async implements Portlet, ResourceServingPortlet {
   private static final Logger LOGGER = LoggerFactory.getLogger(ResourceAsyncTests_SPEC_21_Async.class.getName());
   
   @Inject private AsyncBean           bean;
   @Inject private AsyncBeanRunner     beanRunner;
   @Inject private AsyncBeanListener   beanListener;

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_isAsyncSupported              */
      /* Details: "The ResourceRequest object isAsyncSupported() method returns     */
      /* true if the portlet supports async processing"                             */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSUPPORTED) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSUPPORTED, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_isAsyncStarted1               */
      /* Details: "The ResourceRequest object isAsyncStarted() method returns false */
      /* if asynchronous processing has not been started"                           */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSTARTED1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSTARTED1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_isAsyncStarted2               */
      /* Details: "The ResourceRequest object isAsyncStarted() method returns true  */
      /* if asynchronous processing has been started"                               */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSTARTED2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSTARTED2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_startAsync1                   */
      /* Details: "The ResourceRequest object startAsync() method returns a         */
      /* PortletAsyncContext object"                                                */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_startAsync2                   */
      /* Details: "The ResourceRequest object startAsync(ResourceRequest,           */
      /* ResourceResponse) method returns a PortletAsyncContext object"             */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_startAsync3                   */
      /* Details: "The ResourceRequest object startAsync() method throws an         */
      /* IllegalStateException if asynchronous processing has already been started" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC3) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC3, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_startAsync4                   */
      /* Details: "The ResourceRequest object startAsync(ResourceRequest,           */
      /* ResourceResponse) method throws an IllegalStateException if asynchronous   */
      /* processing has already been started"                                       */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC4) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC4, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType1            */
      /* Details: "The ResourceRequest object getDispatcherType() method returns    */
      /* the value DispatcherType.REQUEST within the resource method before the     */
      /* container dispatch cycle in which asynchronous processing is started       */
      /* returns"                                                                   */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType2            */
      /* Details: "The ResourceRequest object getDispatcherType() method returns    */
      /* the value DispatcherType.REQUEST within the resource filter before the     */
      /* container dispatch cycle in which asynchronous processing is started       */
      /* returns"                                                                   */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType3            */
      /* Details: "The ResourceRequest object getDispatcherType() method returns    */
      /* the value DispatcherType.ASYNC within the resource method when the         */
      /* PortletAsyncContext object dispatch() method is used to dispatch to the    */
      /* resource method "                                                          */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE3) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE3, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType4            */
      /* Details: "The ResourceRequest object getDispatcherType() method returns    */
      /* the value DispatcherType.ASYNC within the resource filter when the         */
      /* PortletAsyncContext object dispatch() method is used to dispatch to the    */
      /* resource method "                                                          */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE4) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE4, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType5            */
      /* Details: "The ResourceRequest object getDispatcherType() method returns    */
      /* the value DispatcherType.ASYNC within the dispatch target method when the  */
      /* PortletAsyncContext object dispatch(String) method is used to dispatch to  */
      /* the resource method "                                                      */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE5) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE5, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getPortletAsyncContext1       */
      /* Details: "The ResourceRequest object getPortletAsyncContext() method       */
      /* returns the value null if async processing has not been started"           */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getPortletAsyncContext2       */
      /* Details: "The ResourceRequest object getPortletAsyncContext() method       */
      /* returns a PortletAsyncContext object if async processing has been started" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete1                     */
      /* Details: "The PortletAsyncContext object complete() method completes       */
      /* asynchronous processing within the original resource request"              */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete2                     */
      /* Details: "The PortletAsyncContext object complete() method completes       */
      /* asynchronous processing within an asynchronous thread"                     */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete3                     */
      /* Details: "The PortletAsyncContext object complete() method throws an       */
      /* IllegalStateException if called before asynchronous processing has         */
      /* started"                                                                   */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE3) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE3, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete4                     */
      /* Details: "The PortletAsyncContext object complete() method throws an       */
      /* IllegalStateException if called after asynchronous processing has          */
      /* completed"                                                                 */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE4) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE4, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete5                     */
      /* Details: "The PortletAsyncContext object complete() method throws an       */
      /* IllegalStateException if called after the PortletAsyncContext object       */
      /* dispatch() method has been called"                                         */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE5) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE5, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete6                     */
      /* Details: "The PortletAsyncContext object complete() method throws an       */
      /* IllegalStateException if called after the PortletAsyncContext object       */
      /* dispatch(String) method has been called"                                   */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE6) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE6, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_setTimeout                    */
      /* Details: "The PortletAsyncContext object setTimeout() method sets the      */
      /* asynchronous timeout value"                                                */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_SETTIMEOUT) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_SETTIMEOUT, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getTimeout1                   */
      /* Details: "The PortletAsyncContext object getTimeout() method returns the   */
      /* default value of 30000 ms"                                                 */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTIMEOUT1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTIMEOUT1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getTimeout2                   */
      /* Details: "The PortletAsyncContext object getTimeout() method returns a     */
      /* previously set timeout value"                                              */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTIMEOUT2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTIMEOUT2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_hasOriginalRequestAndResponse1 */
      /* Details: "The PortletAsyncContext object hasOriginalRequestAndResponse()   */
      /* method returns true if asynchronous processing was started through the     */
      /* startPortletAsync() method"                                                */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_hasOriginalRequestAndResponse2 */
      /* Details: "The PortletAsyncContext object hasOriginalRequestAndResponse()   */
      /* method returns true if asynchronous processing was started through the     */
      /* startPortletAsync(ResourceRequest, ResourceResponse) method if the request */
      /* and response objects were not wrapped"                                     */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_hasOriginalRequestAndResponse3 */
      /* Details: "The PortletAsyncContext object hasOriginalRequestAndResponse()   */
      /* method returns false if asynchronous processing was started through the    */
      /* startPortletAsync(ResourceRequest, ResourceResponse) method if the request */
      /* and response objects were wrapped"                                         */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE3) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE3, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getResourceRequest1           */
      /* Details: "The PortletAsyncContext object getResourceRequest() method       */
      /* returns the original ResourceRequest object if asynchronous processing was */
      /* started through the startPortletAsync() method"                            */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getResourceRequest2           */
      /* Details: "The PortletAsyncContext object getResourceRequest() method       */
      /* returns the original ResourceRequest object if asynchronous processing was */
      /* started through the startPortletAsync(ResourceRequest, ResourceResponse)   */
      /* method if the request and response objects were not wrapped"               */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getResourceRequest3           */
      /* Details: "The PortletAsyncContext object getResourceRequest() method       */
      /* returns the wrapped ResourceRequest object if asynchronous processing was  */
      /* started through the startPortletAsync(ResourceRequest, ResourceResponse)   */
      /* method if the request and response objects were wrapped"                   */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST3) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST3, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getResourceResponse1          */
      /* Details: "The PortletAsyncContext object getResourceResponse() method      */
      /* returns the original ResourceResponse object if asynchronous processing    */
      /* was started through the startPortletAsync() method"                        */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getResourceResponse2          */
      /* Details: "The PortletAsyncContext object getResourceResponse() method      */
      /* returns the original ResourceResponse object if asynchronous processing    */
      /* was started through the startPortletAsync(ResourceRequest,                 */
      /* ResourceResponse) method if the request and response objects were not      */
      /* wrapped"                                                                   */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getResourceResponse3          */
      /* Details: "The PortletAsyncContext object getResourceResponse() method      */
      /* returns the wrapped ResourceResponse object if asynchronous processing was */
      /* started through the startPortletAsync(ResourceRequest, ResourceResponse)   */
      /* method if the request and response objects were wrapped"                   */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE3) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE3, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_createPortletAsyncListener1   */
      /* Details: "The PortletAsyncContext object createPortletAsyncListener(Class) */
      /* method returns an instance of the PortletAsyncListener class provided"     */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_createPortletAsyncListener2   */
      /* Details: "The PortletAsyncContext object createPortletAsyncListener(Class) */
      /* method throws a PortletException if the class provided is not of type      */
      /* PortletAsyncListener"                                                      */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_createPortletAsyncListener3   */
      /* Details: "The PortletAsyncContext object createPortletAsyncListener(Class) */
      /* method throws a PortletException if the class provided cannot be           */
      /* instantiated"                                                              */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER3) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER3, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_createPortletAsyncListener4   */
      /* Details: "The PortletAsyncContext object createPortletAsyncListener(Class) */
      /* method throws a PortletException if the class provided does not have a     */
      /* zero argument constructor"                                                 */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER4) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER4, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_addListener1                  */
      /* Details: "The PortletAsyncContext object addListener(PortletAsyncListener) */
      /* method adds a portlet asynchronous listener"                               */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_addListener2                  */
      /* Details: "The PortletAsyncContext object addListener(PortletAsyncListener) */
      /* method throws an IllegalStateException if called after the                 */
      /* container-initiated dispatch during which one of the startAsync() methods  */
      /* was called has returned to the container"                                  */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_addListener3                  */
      /* Details: "The PortletAsyncContext object addListener(PortletAsyncListener, */
      /* ResourceRequest, ResourceResponse) method adds a portlet asynchronous      */
      /* listener"                                                                  */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER3) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER3, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_addListener4                  */
      /* Details: "The PortletAsyncContext object addListener(PortletAsyncListener, */
      /* ResourceRequest, ResourceResponse) method throws an IllegalStateException  */
      /* if called after the container-initiated dispatch during which one of the   */
      /* startAsync() methods was called has returned to the container"             */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER4) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER4, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch1                     */
      /* Details: "The PortletAsyncContext object dispatch() method dispatches to   */
      /* the resource method if called from within the original resource request"   */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch2                     */
      /* Details: "The PortletAsyncContext object dispatch() method dispatches to   */
      /* the resource method if called from within an asynchronous thread"          */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch3                     */
      /* Details: "The PortletAsyncContext object dispatch() method throws an       */
      /* IllegalStateException if called before a new asynchronous processing cycle */
      /* has been started"                                                          */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH3) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH3, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch4                     */
      /* Details: "The PortletAsyncContext object dispatch() method throws an       */
      /* IllegalStateException if called after asynchronous processing has          */
      /* completed"                                                                 */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH4) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH4, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch5                     */
      /* Details: "The PortletAsyncContext object dispatch() method throws an       */
      /* IllegalStateException if called after a dispatch method has been called    */
      /* within the same container dispatch cycle"                                  */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH5) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH5, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch6                     */
      /* Details: "The PortletAsyncContext object dispatch(String) method           */
      /* dispatches to the given path if called from within the original resource   */
      /* request"                                                                   */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH6) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH6, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch7                     */
      /* Details: "The PortletAsyncContext object dispatch(String) method           */
      /* dispatches to the given path if called from within an asynchronous thread" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH7) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH7, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch8                     */
      /* Details: "The PortletAsyncContext object dispatch(String) method throws an */
      /* IllegalStateException if called before a new asynchronous processing cycle */
      /* has been started"                                                          */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH8) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH8, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch9                     */
      /* Details: "The PortletAsyncContext object dispatch(String) method throws an */
      /* IllegalStateException if called after asynchronous processing has          */
      /* completed"                                                                 */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH9) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH9, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatchA                     */
      /* Details: "The PortletAsyncContext object dispatch(String) method throws an */
      /* IllegalStateException if called after a dispatch method has been called    */
      /* within the same container dispatch cycle"                                  */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCHA) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCHA, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_start1                        */
      /* Details: "The PortletAsyncContext object start(Runnable) method causes an    */
      /* asynchronous thread to run"                                                */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_start2                        */
      /* Details: "The PortletAsyncContext object start(Runnable) method throws an    */
      /* IllegalStateException if called before a new asynchronous processing cycle */
      /* has been started"                                                          */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_start3                        */
      /* Details: "The PortletAsyncContext object start(Runnable) method throws an    */
      /* IllegalStateException if called after asynchronous processing has          */
      /* completed"                                                                 */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START3) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START3, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_start4                        */
      /* Details: "The PortletAsyncContext object start(Runnable) method throws an    */
      /* IllegalStateException if called after a dispatch method has been called    */
      /* within the same container dispatch cycle"                                  */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START4) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START4, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_cdi1                          */
      /* Details: "When CDI is available and the asynchronous thread is started     */
      /* through the PortletAsyncContext object, the asynchronous thread runs in    */
      /* the same context as the original request"                                  */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_cdi2                          */
      /* Details: "When CDI is available and the asynchronous thread is started     */
      /* through the PortletAsyncContext object, the PortletAsyncListener runs in   */
      /* the same context as the original request"                                  */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_cdi3                          */
      /* Details: "When CDI is available and the asynchronous thread is started     */
      /* through the PortletAsyncContext object, the resource filter runs in the    */
      /* same context as the original request"                                      */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI3) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI3, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_onTimeout                     */
      /* Details: "The PortletAsyncListener object onTimeout(PortletAsyncEvent)     */
      /* method is called when a timeout occurs "                                   */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONTIMEOUT) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONTIMEOUT, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_onError                       */
      /* Details: "The PortletAsyncListener object onError(PortletAsyncEvent)       */
      /* method is called if an exception is thrown in an asynchronous thread       */
      /* started through the PortletAsyncContext object "                           */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONERROR) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONERROR, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_onComplete                    */
      /* Details: "The PortletAsyncListener object onComplete(PortletAsyncEvent)    */
      /* method is called when asynchronous processing completes "                  */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONCOMPLETE) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONCOMPLETE, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_onStartAsync                  */
      /* Details: "The PortletAsyncListener object onStartAsync(PortletAsyncEvent)  */
      /* method is called when asynchronous processing is restarted "               */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONSTARTASYNC) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONSTARTASYNC, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getPortletAsyncContext        */
      /* Details: "The PortletAsyncEvent object getPortletAsyncContext() method     */
      /* returns the PortletAsyncContext object for the request"                    */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getSuppliedRequest1           */
      /* Details: "The PortletAsyncEvent object getSuppliedRequest() method returns */
      /* null if no resource request was supplied when the PortletAsyncListener was */
      /* added "                                                                    */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getSuppliedRequest2           */
      /* Details: "The PortletAsyncEvent object getSuppliedRequest() method returns */
      /* the supplied request if a resource request was supplied when the           */
      /* PortletAsyncListener was added "                                           */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getSuppliedResponse1          */
      /* Details: "The PortletAsyncEvent object getSuppliedResponse() method        */
      /* returns null if no resource response was supplied when the                 */
      /* PortletAsyncListener was added "                                           */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getSuppliedResponse2          */
      /* Details: "The PortletAsyncEvent object getSuppliedResponse() method        */
      /* returns the supplied response if a resource response was supplied when the */
      /* PortletAsyncListener was added "                                           */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getThrowable1                 */
      /* Details: "The PortletAsyncEvent object getThrowable() method returns null  */
      /* within the PortletAsyncListener object onComplete(), onTimeout(), and      */
      /* onStartAsync() methods"                                                    */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getThrowable2                 */
      /* Details: "The PortletAsyncEvent object getThrowable() method returns the   */
      /* Throwable object associated with the error within the PortletAsyncListener */
      /* object onError() method"                                                   */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

   }

   @SuppressWarnings("unused")
   @Override
   public void serveResource(ResourceRequest req, ResourceResponse resp) throws PortletException, IOException {

      resp.setContentType("text/html");
      resp.setCharacterEncoding("UTF-8");
      PrintWriter writer = resp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      String testcase = req.getResourceParameters().getValue("testcase");
      TestResult result = null;
      PortletAsyncContext pac = null;
      boolean doComplete = false;
      PortletSession session = req.getPortletSession();
      AsyncResults asyres = AsyncResults.getAsyncResults();
      
      try {
      
         if (testcase == null) {
            writer.write("Unknown test case: null");
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_isAsyncSupported              */
         /* Details: "The ResourceRequest object isAsyncSupported() method returns     */
         /* true if the portlet supports async processing"                             */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSUPPORTED)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSUPPORTED);
            if (req.isAsyncSupported() == true) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("isAsyncSupported returns false when async is supported.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_isAsyncStarted1               */
         /* Details: "The ResourceRequest object isAsyncStarted() method returns false */
         /* if asynchronous processing has not been started"                           */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSTARTED1)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSTARTED1);
            if (req.isAsyncStarted() == false) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("isAsyncStarted returns true when async has not been started.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_isAsyncStarted2               */
         /* Details: "The ResourceRequest object isAsyncStarted() method returns true  */
         /* if asynchronous processing has been started"                               */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSTARTED2)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ISASYNCSTARTED2);
            pac = req.startPortletAsync();
            doComplete = true;
            if (req.isAsyncStarted() == true) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("isAsyncStarted returns false after async has been started.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_startAsync1                   */
         /* Details: "The ResourceRequest object startAsync() method returns a         */
         /* PortletAsyncContext object"                                                */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC1)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC1);
            pac = req.startPortletAsync();
            doComplete = true;
            if (pac != null) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("startPortletAsync returned null.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_startAsync2                   */
         /* Details: "The ResourceRequest object startAsync(ResourceRequest,           */
         /* ResourceResponse) method returns a PortletAsyncContext object"             */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC2)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC2);
            ResourceRequestWrapper wreq = new ResourceRequestWrapper(req);
            ResourceResponseWrapper wresp = new ResourceResponseWrapper(resp);
            pac = req.startPortletAsync(wreq, wresp);
            doComplete = true;
            if (pac != null) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("startPortletAsync returned null.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_startAsync3                   */
         /* Details: "The ResourceRequest object startAsync() method throws an         */
         /* IllegalStateException if asynchronous processing has already been started" */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC3)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC3);
            try {
               pac = req.startPortletAsync();
               doComplete = true;
               PortletAsyncContext pac2 = req.startPortletAsync();
               result.appendTcDetail("startPortletAsync did not throw exception although async was already started.");
            } catch (IllegalStateException e) {
               result.setTcSuccess(true);
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_startAsync4                   */
         /* Details: "The ResourceRequest object startAsync(ResourceRequest,           */
         /* ResourceResponse) method throws an IllegalStateException if asynchronous   */
         /* processing has already been started"                                       */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC4)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_STARTASYNC4);
            try {
               ResourceRequestWrapper wreq = new ResourceRequestWrapper(req);
               ResourceResponseWrapper wresp = new ResourceResponseWrapper(resp);
               pac = req.startPortletAsync();
               doComplete = true;
               PortletAsyncContext pac2 = req.startPortletAsync(wreq, wresp);
               result.appendTcDetail("startPortletAsync did not throw exception although async was already started.");
            } catch (IllegalStateException e) {
               result.setTcSuccess(true);
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType1            */
         /* Details: "The ResourceRequest object getDispatcherType() method returns    */
         /* the value DispatcherType.REQUEST within the resource method before the     */
         /* container dispatch cycle in which asynchronous processing is started       */
         /* returns"                                                                   */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE1)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE1);
            DispatcherType dt = req.getDispatcherType();
            if (dt == DispatcherType.REQUEST) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Unexpected dispatcher type: " + dt.name());
            }

            // actual test done in filter
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE2)) {
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType3            */
         /* Details: "The ResourceRequest object getDispatcherType() method returns    */
         /* the value DispatcherType.ASYNC within the resource method when the         */
         /* PortletAsyncContext object dispatch() method is used to dispatch to the    */
         /* resource method "                                                          */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE3)) {
            boolean isDispatched = new Boolean((String) session.getAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE3));
            if (isDispatched) {
               // 2nd time thru
               session.removeAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE3);
               result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE3);
               DispatcherType dt = req.getDispatcherType();
               if (dt == DispatcherType.ASYNC) {
                  result.setTcSuccess(true);
               } else {
                  result.appendTcDetail("Unexpected dispatcher type: " + dt.name());
               }
            } else {
               // 1st time thru
               try {
                  pac = req.startPortletAsync();
                  pac.dispatch();
                  session.setAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE3, "true");
               } catch (Throwable t) {
                  result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE3);
                  result.appendTcDetail("Exception starting or dispatching async: " + t.getMessage());
               }
            }

            // actual test done in filter
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE4)) {
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType5            */
         /* Details: "The ResourceRequest object getDispatcherType() method returns    */
         /* the value DispatcherType.ASYNC within the dispatch target method when the  */
         /* PortletAsyncContext object dispatch(String) method is used to dispatch to  */
         /* the resource method "                                                      */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE5)) {
            try {
               pac = req.startPortletAsync();
               pac.dispatch("/dispatchTarget");
            } catch (Throwable t) {
               result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE5);
               result.appendTcDetail("Exception starting or dispatching async: " + t.getMessage());
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getPortletAsyncContext1       */
         /* Details: "The ResourceRequest object getPortletAsyncContext() method       */
         /* returns the value null if async processing has not been started"           */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT1)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT1);
            try {
               PortletAsyncContext ctx = req.getPortletAsyncContext();
               result.appendTcDetail("Method did not throw exception although async is not sstarted.");
            } catch (IllegalStateException e) {
               result.setTcSuccess(true);
            } catch (Throwable t) {
               result.appendTcDetail("Method threw unexpected exception type: " + t.getMessage());
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getPortletAsyncContext2       */
         /* Details: "The ResourceRequest object getPortletAsyncContext() method       */
         /* returns a PortletAsyncContext object if async processing has been started" */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT2)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT2);
            pac = req.startPortletAsync();
            doComplete = true;
            if (req.getPortletAsyncContext() != null) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("PortletAsyncContext was null although async was started.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete1                     */
         /* Details: "The PortletAsyncContext object complete() method completes       */
         /* asynchronous processing within the original resource request"              */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE1)) {
            // results are created in the listener
            result = asyres.getAndClearResult(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE1);
            if (result == null) {
               writer.write("repeat");     // signal the JS fetch code to repeat
               pac = req.startPortletAsync();
               AsyncListener listener = new AsyncListener();
               listener.setTestcase(testcase);
               pac.addListener(listener);
               pac.complete();
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete2                     */
         /* Details: "The PortletAsyncContext object complete() method completes       */
         /* asynchronous processing within an asynchronous thread"                     */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE2)) {
            // results are created in the listener
            result = asyres.getAndClearResult(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE2);
            if (result == null) {
               pac = req.startPortletAsync();
               AsyncListener listener = new AsyncListener();
               listener.setTestcase(testcase);
               pac.addListener(listener);
               AsyncRunner runner = new AsyncRunner();
               runner.init(pac, V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE2);
               pac.start(runner);
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete3                     */
         /* Details: "The PortletAsyncContext object complete() method throws an       */
         /* IllegalStateException if called before asynchronous processing has         */
         /* started"                                                                   */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE3)) {
            boolean isDispatched = new Boolean((String) session.getAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE3));
            if (isDispatched) {
               // 2nd time thru
               session.removeAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE3);
               result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE3);
               pac = req.getPortletAsyncContext();
               if (pac != null) {
                  try {
                     pac.complete();
                     result.appendTcDetail("No exception was thrown.");
                  } catch (IllegalStateException e) {
                     result.setTcSuccess(true);
                  }
               } else {
                  result.appendTcDetail("Couldn't retrieve PortletAsyncContext object");
               }
            } else {
               // 1st time thru
               try {
                  pac = req.startPortletAsync();
                  pac.dispatch();
                  session.setAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE3, "true");
               } catch (Throwable t) {
                  result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE3);
                  result.appendTcDetail("Exception starting or dispatching async: " + t.getMessage());
               }
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete4                     */
         /* Details: "The PortletAsyncContext object complete() method throws an       */
         /* IllegalStateException if called after asynchronous processing has          */
         /* completed"                                                                 */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE4)) {
            result = asyres.getAndClearResult(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE4);
            if (result == null) {
               writer.write("repeat");     // signal the JS fetch code to repeat
               result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE4);
               pac = req.startPortletAsync();
               pac.complete();
               try {
                  pac.complete();
                  result.appendTcDetail("complete() did not throw exception although the async context was already complete.");
               } catch (IllegalStateException e) {
                  result.setTcSuccess(true);
               } catch (Throwable t) {
                  result.appendTcDetail("complete() threw unexpected exception: " + t.getMessage());
               }
               asyres.setResult(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE4, result);
               result = null;
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete5                     */
         /* Details: "The PortletAsyncContext object complete() method throws an       */
         /* IllegalStateException if called after the PortletAsyncContext object       */
         /* dispatch() method has been called"                                         */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE5)) {
            result = (TestResult) session.getAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE5);
            if (result == null) {
               result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE5);
               pac = req.startPortletAsync();
               pac.dispatch();
               try {
                  pac.complete();
                  result.appendTcDetail("complete() did not throw exception after a dispatch was performed.");
               } catch (IllegalStateException e) {
                  result.setTcSuccess(true);
               } catch (Throwable t) {
                  result.appendTcDetail("complete() threw unexpected exception: " + t.getMessage());
               }
               session.setAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE5, result);
               result = null;
            } else {
               session.removeAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE5);
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete6                     */
         /* Details: "The PortletAsyncContext object complete() method throws an       */
         /* IllegalStateException if called after the PortletAsyncContext object       */
         /* dispatch(String) method has been called"                                   */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE6)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE6);
            pac = req.startPortletAsync();
            pac.dispatch("/dispatchTarget");
            try {
               pac.complete();
               result.appendTcDetail("complete() did not throw exception after a dispatch was performed.");
            } catch (IllegalStateException e) {
               result.setTcSuccess(true);
            } catch (Throwable t) {
               result.appendTcDetail("complete() threw unexpected exception: " + t.getMessage());
            }
            session.setAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE6, result, PortletSession.APPLICATION_SCOPE);
            result = null;
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_setTimeout                    */
         /* Details: "The PortletAsyncContext object setTimeout() method sets the      */
         /* asynchronous timeout value"                                                */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_SETTIMEOUT)) {
            // the results are written in the async listener
            pac = req.startPortletAsync();
            pac.setTimeout(100);
            AsyncListener listener = new AsyncListener();
            listener.setTestcase(testcase);
            pac.addListener(listener);
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getTimeout1                   */
         /* Details: "The PortletAsyncContext object getTimeout() method returns the   */
         /* default value of 30000 ms"                                                 */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTIMEOUT1)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTIMEOUT1);
            pac = req.startPortletAsync();
            doComplete = true;
            long to = pac.getTimeout();
            if (to == 30000) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Timeout value was not 30000 as expected, but: " + to);
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getTimeout2                   */
         /* Details: "The PortletAsyncContext object getTimeout() method returns a     */
         /* previously set timeout value"                                              */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTIMEOUT2)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTIMEOUT2);
            pac = req.startPortletAsync();
            doComplete = true;
            pac.setTimeout(1000);
            long to = pac.getTimeout();
            if (to == 1000) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Timeout value was not 1000 as expected, but: " + to);
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_hasOriginalRequestAndResponse1 */
         /* Details: "The PortletAsyncContext object hasOriginalRequestAndResponse()   */
         /* method returns true if asynchronous processing was started through the     */
         /* startPortletAsync() method"                                                */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE1)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE1);
            pac = req.startPortletAsync();
            doComplete = true;
            if (pac.hasOriginalRequestAndResponse() == true) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Method returned false when the ResourceRequest and ResourceResponse objects were not provided.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_hasOriginalRequestAndResponse2 */
         /* Details: "The PortletAsyncContext object hasOriginalRequestAndResponse()   */
         /* method returns true if asynchronous processing was started through the     */
         /* startPortletAsync(ResourceRequest, ResourceResponse) method if the request */
         /* and response objects were not wrapped"                                     */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE2)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE2);
            pac = req.startPortletAsync(req, resp);
            doComplete = true;
            if (pac.hasOriginalRequestAndResponse() == true) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Method returned false when the original ResourceRequest and ResourceResponse objects were provided.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_hasOriginalRequestAndResponse3 */
         /* Details: "The PortletAsyncContext object hasOriginalRequestAndResponse()   */
         /* method returns false if asynchronous processing was started through the    */
         /* startPortletAsync(ResourceRequest, ResourceResponse) method if the request */
         /* and response objects were wrapped"                                         */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE3)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_HASORIGINALREQUESTANDRESPONSE3);
            ResourceRequestWrapper wreq = new ResourceRequestWrapper(req);
            ResourceResponseWrapper wresp = new ResourceResponseWrapper(resp);
            pac = req.startPortletAsync(wreq, wresp);
            doComplete = true;
            if (pac.hasOriginalRequestAndResponse() == false) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Method returned true when wrapped ResourceRequest and ResourceResponse objects were provided.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getResourceRequest1           */
         /* Details: "The PortletAsyncContext object getResourceRequest() method       */
         /* returns the original ResourceRequest object if asynchronous processing was */
         /* started through the startPortletAsync() method"                            */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST1)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST1);
            pac = req.startPortletAsync();
            doComplete = true;
            if (pac.getResourceRequest() == req) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Method returned object different than the original when no ResourceRequest and ResourceResponse objects were provided.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getResourceRequest2           */
         /* Details: "The PortletAsyncContext object getResourceRequest() method       */
         /* returns the original ResourceRequest object if asynchronous processing was */
         /* started through the startPortletAsync(ResourceRequest, ResourceResponse)   */
         /* method if the request and response objects were not wrapped"               */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST2)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST2);
            pac = req.startPortletAsync(req, resp);
            doComplete = true;
            if (pac.getResourceRequest() == req) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Method returned object different than the original when the original ResourceRequest and ResourceResponse objects were provided.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getResourceRequest3           */
         /* Details: "The PortletAsyncContext object getResourceRequest() method       */
         /* returns the wrapped ResourceRequest object if asynchronous processing was  */
         /* started through the startPortletAsync(ResourceRequest, ResourceResponse)   */
         /* method if the request and response objects were wrapped"                   */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST3)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCEREQUEST3);
            ResourceRequestWrapper wreq = new ResourceRequestWrapper(req);
            ResourceResponseWrapper wresp = new ResourceResponseWrapper(resp);
            pac = req.startPortletAsync(wreq, wresp);
            doComplete = true;
            if (pac.getResourceRequest() == wreq) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Method returned object different than the wrapped object when wrapped ResourceRequest and ResourceResponse objects were provided.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getResourceResponse1          */
         /* Details: "The PortletAsyncContext object getResourceResponse() method      */
         /* returns the original ResourceResponse object if asynchronous processing    */
         /* was started through the startPortletAsync() method"                        */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE1)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE1);
            pac = req.startPortletAsync();
            doComplete = true;
            if (pac.getResourceResponse() == resp) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Method returned object different than the original when no ResourceRequest and ResourceResponse objects were provided.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getResourceResponse2          */
         /* Details: "The PortletAsyncContext object getResourceResponse() method      */
         /* returns the original ResourceResponse object if asynchronous processing    */
         /* was started through the startPortletAsync(ResourceRequest,                 */
         /* ResourceResponse) method if the request and response objects were not      */
         /* wrapped"                                                                   */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE2)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE2);
            pac = req.startPortletAsync(req, resp);
            doComplete = true;
            if (pac.getResourceResponse() == resp) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Method returned object different than the original when the original ResourceRequest and ResourceResponse objects were provided.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getResourceResponse3          */
         /* Details: "The PortletAsyncContext object getResourceResponse() method      */
         /* returns the wrapped ResourceResponse object if asynchronous processing was */
         /* started through the startPortletAsync(ResourceRequest, ResourceResponse)   */
         /* method if the request and response objects were wrapped"                   */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE3)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETRESOURCERESPONSE3);
            ResourceRequestWrapper wreq = new ResourceRequestWrapper(req);
            ResourceResponseWrapper wresp = new ResourceResponseWrapper(resp);
            pac = req.startPortletAsync(wreq, wresp);
            doComplete = true;
            if (pac.getResourceResponse() == wresp) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Method returned object different than the wrapped object when wrapped ResourceRequest and ResourceResponse objects were provided.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_createPortletAsyncListener1   */
         /* Details: "The PortletAsyncContext object createPortletAsyncListener(Class) */
         /* method returns an instance of the PortletAsyncListener class provided"     */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER1)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER1);
            pac = req.startPortletAsync();
            PortletAsyncListener pal = pac.createPortletAsyncListener(AsyncListener.class);
            doComplete = true;
            if (pal instanceof AsyncListener) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Returned object was not instance of AsyncListener. Class: " + pal.getClass().getCanonicalName());
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_createPortletAsyncListener2   */
         /* Details: "The PortletAsyncContext object createPortletAsyncListener(Class) */
         /* method throws a PortletException if the class provided is not of type      */
         /* PortletAsyncListener"                                                      */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER2)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER2);
            pac = req.startPortletAsync();
            doComplete = true;
            try {
               @SuppressWarnings("rawtypes")
               Class cls = StringBuilder.class;
               @SuppressWarnings("unchecked")
               PortletAsyncListener pal = pac.createPortletAsyncListener(cls);
               result.appendTcDetail("Method did not throw exception although bad class was provided.");
            } catch (PortletException e) {
               result.setTcSuccess(true);
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_createPortletAsyncListener3   */
         /* Details: "The PortletAsyncContext object createPortletAsyncListener(Class) */
         /* method throws a PortletException if the class provided cannot be           */
         /* instantiated"                                                              */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER3)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER3);
            pac = req.startPortletAsync();
            doComplete = true;
            try {
               PortletAsyncListener pal = pac.createPortletAsyncListener(BadAsyncListener.class);
               result.appendTcDetail("Method did not throw exception although bad class was provided.");
            } catch (PortletException e) {
               result.setTcSuccess(true);
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_createPortletAsyncListener4   */
         /* Details: "The PortletAsyncContext object createPortletAsyncListener(Class) */
         /* method throws a PortletException if the class provided does not have a     */
         /* zero argument constructor"                                                 */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER4)) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CREATEPORTLETASYNCLISTENER4);
            pac = req.startPortletAsync();
            doComplete = true;
            try {
               PortletAsyncListener pal = pac.createPortletAsyncListener(NoDefaultConstructorAsyncListener.class);
               result.appendTcDetail("Method did not throw exception although bad class was provided.");
            } catch (PortletException e) {
               result.setTcSuccess(true);
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_addListener1                  */
         /* Details: "The PortletAsyncContext object addListener(PortletAsyncListener) */
         /* method adds a portlet asynchronous listener"                               */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER1)) {
            result = asyres.getAndClearResult(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER1);
            if (result == null) {
               // the results are written in the async listener
               pac = req.startPortletAsync();
               AsyncListener listener = new AsyncListener();
               listener.setTestcase(testcase);
               pac.addListener(listener);
               writer.write("repeat");     // signal the JS fetch code to repeat
               pac.complete();
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_addListener2                  */
         /* Details: "The PortletAsyncContext object addListener(PortletAsyncListener) */
         /* method throws an IllegalStateException if called after the                 */
         /* container-initiated dispatch during which one of the startAsync() methods  */
         /* was called has returned to the container"                                  */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER2)) {
            boolean isDispatched = new Boolean((String) session.getAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER2));
            LOGGER.trace("isDispatched: {}", isDispatched);
            if (isDispatched) {
               // 2nd time thru
               session.removeAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER2);
               result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER2);
               pac = req.getPortletAsyncContext();
               if (pac != null) {
                  try {
                     AsyncListener listener = new AsyncListener();
                     listener.setTestcase(testcase);
                     pac.addListener(listener);
                     result.appendTcDetail("No exception was thrown.");
                  } catch (IllegalStateException e) {
                     result.setTcSuccess(true);
                  }
               } else {
                  result.appendTcDetail("Couldn't retrieve PortletAsyncContext object");
               }
            } else {
               // 1st time thru
               try {
                  pac = req.startPortletAsync();
                  pac.dispatch();
                  session.setAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER2, "true");
                  LOGGER.trace("dispatched to resource method.");
               } catch (Throwable t) {
                  result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER2);
                  result.appendTcDetail("Exception starting or dispatching async: " + t.getMessage());
               }
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_addListener3                  */
         /* Details: "The PortletAsyncContext object addListener(PortletAsyncListener, */
         /* ResourceRequest, ResourceResponse) method adds a portlet asynchronous      */
         /* listener"                                                                  */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER3)) {
            result = asyres.getAndClearResult(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER3);
            if (result == null) {
               // the results are written in the async listener
               pac = req.startPortletAsync();
               AsyncListener listener = new AsyncListener();
               listener.setTestcase(testcase);
               ResourceRequestWrapper wreq = new ResourceRequestWrapper(req);
               ResourceResponseWrapper wresp = new ResourceResponseWrapper(resp);
               pac.addListener(listener, wreq, wresp);
               writer.write("repeat");    // signal the JS fetch code to repeat
               pac.complete();
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_addListener4                  */
         /* Details: "The PortletAsyncContext object addListener(PortletAsyncListener, */
         /* ResourceRequest, ResourceResponse) method throws an IllegalStateException  */
         /* if called after the container-initiated dispatch during which one of the   */
         /* startAsync() methods was called has returned to the container"             */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER4)) {
            boolean isDispatched = new Boolean((String) session.getAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER4));
            if (isDispatched) {
               // 2nd time thru
               session.removeAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER4);
               result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER4);
               pac = req.getPortletAsyncContext();
               if (pac != null) {
                  try {
                     AsyncListener listener = new AsyncListener();
                     listener.setTestcase(testcase);
                     ResourceRequestWrapper wreq = new ResourceRequestWrapper(req);
                     ResourceResponseWrapper wresp = new ResourceResponseWrapper(resp);
                     pac.addListener(listener, wreq, wresp);
                     result.appendTcDetail("No exception was thrown.");
                  } catch (IllegalStateException e) {
                     result.setTcSuccess(true);
                  }
               } else {
                  result.appendTcDetail("Couldn't retrieve PortletAsyncContext object");
               }
            } else {
               // 1st time thru
               try {
                  pac = req.startPortletAsync();
                  pac.dispatch();
                  session.setAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER4, "true");
               } catch (Throwable t) {
                  result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER4);
                  result.appendTcDetail("Exception starting or dispatching async: " + t.getMessage());
               }
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch1                     */
         /* Details: "The PortletAsyncContext object dispatch() method dispatches to   */
         /* the resource method if called from within the original resource request"   */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH1)) {
            boolean isDispatched = new Boolean((String) session.getAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH1));
            if (isDispatched) {
               // 2nd time thru
               session.removeAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH1);
               result = tcd.getTestResultSucceeded(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH1);
            } else {
               // 1st time thru
               try {
                  pac = req.startPortletAsync();
                  pac.dispatch();
                  session.setAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH1, "true");
               } catch (Throwable t) {
                  result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH1);
                  result.appendTcDetail("Exception starting or dispatching async: " + t.getMessage());
               }
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch2                     */
         /* Details: "The PortletAsyncContext object dispatch() method dispatches to   */
         /* the resource method if called from within an asynchronous thread"          */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH2)) {
            boolean isDispatched = new Boolean((String) session.getAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH2));
            if (isDispatched) {
               // 2nd time thru
               session.removeAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH2);
               result = tcd.getTestResultSucceeded(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH2);
            } else {
               // 1st time thru
               try {
                  pac = req.startPortletAsync();
                  session.setAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH2, "true");
                  AsyncRunner runner = new AsyncRunner();
                  runner.init(pac, testcase);
                  pac.start(runner);
               } catch (Throwable t) {
                  result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH2);
                  result.appendTcDetail("Exception starting or dispatching async: " + t.getMessage());
               }
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch3                     */
         /* Details: "The PortletAsyncContext object dispatch() method throws an       */
         /* IllegalStateException if called before a new asynchronous processing cycle */
         /* has been started"                                                          */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH3)) {
            boolean isDispatched = new Boolean((String) session.getAttribute(testcase));
            if (isDispatched) {
               // 2nd time thru
               session.removeAttribute(testcase);
               result = tcd.getTestResultFailed(testcase);
               pac = req.getPortletAsyncContext();
               if (pac != null) {
                  try {
                     pac.dispatch();
                     result.appendTcDetail("No exception was thrown.");
                  } catch (IllegalStateException e) {
                     result.setTcSuccess(true);
                  }
               } else {
                  result.appendTcDetail("Couldn't retrieve PortletAsyncContext object");
               }
            } else {
               // 1st time thru
               try {
                  pac = req.startPortletAsync();
                  pac.dispatch();
                  session.setAttribute(testcase, "true");
               } catch (Throwable t) {
                  result = tcd.getTestResultFailed(testcase);
                  result.appendTcDetail("Exception starting or dispatching async: " + t.getMessage());
               }
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch4                     */
         /* Details: "The PortletAsyncContext object dispatch() method throws an       */
         /* IllegalStateException if called after asynchronous processing has          */
         /* completed"                                                                 */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH4)) {
            result = asyres.getAndClearResult(testcase);
            if (result == null) {
               writer.write("repeat");     // signal the JS fetch code to repeat
               result = tcd.getTestResultFailed(testcase);
               pac = req.startPortletAsync();
               pac.complete();
               try {
                  pac.dispatch();
                  result.appendTcDetail("dispatch() did not throw exception although the async context was already complete.");
               } catch (IllegalStateException e) {
                  result.setTcSuccess(true);
               } catch (Throwable t) {
                  result.appendTcDetail("complete() threw unexpected exception: " + t.getMessage());
               }
               asyres.setResult(testcase, result);
               result = null;
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch5                     */
         /* Details: "The PortletAsyncContext object dispatch() method throws an       */
         /* IllegalStateException if called after a dispatch method has been called    */
         /* within the same container dispatch cycle"                                  */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH5)) {
            result = asyres.getAndClearResult(testcase);
            if (result == null) {
               result = tcd.getTestResultFailed(testcase);
               pac = req.startPortletAsync();
               pac.dispatch();
               try {
                  pac.dispatch();
                  result.appendTcDetail("dispatch() did not throw exception although the async context was already complete.");
               } catch (IllegalStateException e) {
                  result.setTcSuccess(true);
               } catch (Throwable t) {
                  result.appendTcDetail("complete() threw unexpected exception: " + t.getMessage());
               }
               asyres.setResult(testcase, result);
               result = null;
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch6                     */
         /* Details: "The PortletAsyncContext object dispatch(String) method           */
         /* dispatches to the given path if called from within the original resource   */
         /* request"                                                                   */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH6)) {
            try {
               pac = req.startPortletAsync();
               pac.dispatch("/dispatchTarget");
            } catch (Throwable t) {
               result = tcd.getTestResultFailed(testcase);
               result.appendTcDetail("Exception starting or dispatching async: " + t.getMessage());
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch7                     */
         /* Details: "The PortletAsyncContext object dispatch(String) method           */
         /* dispatches to the given path if called from within an asynchronous thread" */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH7)) {
            try {
               pac = req.startPortletAsync();
               AsyncRunner runner = new AsyncRunner();
               runner.init(pac, testcase);
               pac.start(runner);
            } catch (Throwable t) {
               result = tcd.getTestResultFailed(testcase);
               result.appendTcDetail("Exception setting up test: " + t.getMessage());
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch8                     */
         /* Details: "The PortletAsyncContext object dispatch(String) method throws an */
         /* IllegalStateException if called before a new asynchronous processing cycle */
         /* has been started"                                                          */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH8)) {
            boolean isDispatched = new Boolean((String) session.getAttribute(testcase));
            if (isDispatched) {
               // 2nd time thru
               session.removeAttribute(testcase);
               result = tcd.getTestResultFailed(testcase);
               pac = req.getPortletAsyncContext();
               if (pac != null) {
                  try {
                     pac.dispatch("/dispatchTarget");
                     result.appendTcDetail("No exception was thrown.");
                  } catch (IllegalStateException e) {
                     result.setTcSuccess(true);
                  }
               } else {
                  result.appendTcDetail("Couldn't retrieve PortletAsyncContext object");
               }
            } else {
               // 1st time thru
               try {
                  pac = req.startPortletAsync();
                  pac.dispatch();
                  session.setAttribute(testcase, "true");
               } catch (Throwable t) {
                  result = tcd.getTestResultFailed(testcase);
                  result.appendTcDetail("Exception starting or dispatching async: " + t.getMessage());
               }
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch9                     */
         /* Details: "The PortletAsyncContext object dispatch(String) method throws an */
         /* IllegalStateException if called after asynchronous processing has          */
         /* completed"                                                                 */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH9)) {
            result = asyres.getAndClearResult(testcase);
            if (result == null) {
               writer.write("repeat");     // signal the JS fetch code to repeat
               result = tcd.getTestResultFailed(testcase);
               pac = req.startPortletAsync();
               pac.complete();
               try {
                  pac.dispatch("/dispatchTarget");
                  result.appendTcDetail("dispatch() did not throw exception although the async context was already complete.");
               } catch (IllegalStateException e) {
                  result.setTcSuccess(true);
               } catch (Throwable t) {
                  result.appendTcDetail("dispatch() threw unexpected exception: " + t.getMessage());
               }
               asyres.setResult(testcase, result);
               result = null;
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatchA                     */
         /* Details: "The PortletAsyncContext object dispatch(String) method throws an */
         /* IllegalStateException if called after a dispatch method has been called    */
         /* within the same container dispatch cycle"                                  */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCHA)) {
            result = asyres.getAndClearResult(testcase);
            if (result == null) {
               result = tcd.getTestResultFailed(testcase);
               pac = req.startPortletAsync();
               pac.dispatch();
               try {
                  pac.dispatch("/dispatchTarget");
                  result.appendTcDetail("dispatch() did not throw exception although the async context was already complete.");
               } catch (IllegalStateException e) {
                  result.setTcSuccess(true);
               } catch (Throwable t) {
                  result.appendTcDetail("dispatch() threw unexpected exception: " + t.getMessage());
               }
               asyres.setResult(testcase, result);
               result = null;
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_start1                        */
         /* Details: "The PortletAsyncContext object start(Runnable) method causes an    */
         /* asynchronous thread to run"                                                */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START1)) {
            try {
               pac = req.startPortletAsync();
               AsyncRunner runner = new AsyncRunner();
               runner.init(pac, testcase);
               pac.start(runner);
            } catch (Throwable t) {
               result = tcd.getTestResultFailed(testcase);
               result.appendTcDetail("Exception setting up test: " + t.getMessage());
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_start2                        */
         /* Details: "The PortletAsyncContext object start(Runnable) method throws an    */
         /* IllegalStateException if called before a new asynchronous processing cycle */
         /* has been started"                                                          */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START2)) {
            boolean isDispatched = new Boolean((String) session.getAttribute(testcase));
            if (isDispatched) {
               // 2nd time thru
               session.removeAttribute(testcase);
               result = tcd.getTestResultFailed(testcase);
               pac = req.getPortletAsyncContext();
               if (pac != null) {
                  try {
                     AsyncRunner runner = new AsyncRunner();
                     runner.init(pac, testcase);
                     pac.start(runner);
                     result.appendTcDetail("No exception was thrown.");
                  } catch (IllegalStateException e) {
                     result.setTcSuccess(true);
                  }
               } else {
                  result.appendTcDetail("Couldn't retrieve PortletAsyncContext object");
               }
            } else {
               // 1st time thru
               try {
                  pac = req.startPortletAsync();
                  pac.dispatch();
                  session.setAttribute(testcase, "true");
               } catch (Throwable t) {
                  result = tcd.getTestResultFailed(testcase);
                  result.appendTcDetail("Exception starting or dispatching async: " + t.getMessage());
               }
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_start3                        */
         /* Details: "The PortletAsyncContext object start(Runnable) method throws an    */
         /* IllegalStateException if called after asynchronous processing has          */
         /* completed"                                                                 */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START3)) {
            result = asyres.getAndClearResult(testcase);
            if (result == null) {
               writer.write("repeat");     // signal the JS fetch code to repeat
               result = tcd.getTestResultFailed(testcase);
               pac = req.startPortletAsync();
               pac.complete();
               try {
                  AsyncRunner runner = new AsyncRunner();
                  runner.init(pac, testcase);
                  pac.start(runner);
                  result.appendTcDetail("Method did not throw exception although the async context was already complete.");
               } catch (IllegalStateException e) {
                  result.setTcSuccess(true);
               } catch (Throwable t) {
                  result.appendTcDetail("Method threw unexpected exception: " + t.getMessage());
               }
               asyres.setResult(testcase, result);
               result = null;
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_start4                        */
         /* Details: "The PortletAsyncContext object start(Runnable) method throws an    */
         /* IllegalStateException if called after a dispatch method has been called    */
         /* within the same container dispatch cycle"                                  */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START4)) {
            result = asyres.getAndClearResult(testcase);
            if (result == null) {
               result = tcd.getTestResultFailed(testcase);
               pac = req.startPortletAsync();
               pac.dispatch();
               try {
                  AsyncRunner runner = new AsyncRunner();
                  runner.init(pac, testcase);
                  pac.start(runner);
                  result.appendTcDetail("Method did not throw exception although the async context was already complete.");
               } catch (IllegalStateException e) {
                  result.setTcSuccess(true);
               } catch (Throwable t) {
                  result.appendTcDetail("Method threw unexpected exception: " + t.getMessage());
               }
               asyres.setResult(testcase, result);
               result = null;
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_cdi1                          */
         /* Details: "When CDI is available and the asynchronous thread is started     */
         /* through the PortletAsyncContext object, the asynchronous thread runs in    */
         /* the same context as the original request"                                  */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI1)) {
            result = tcd.getTestResultFailed(testcase);
            if (bean != null && beanRunner != null) {
               bean.setTestcase(testcase);
               pac = req.startPortletAsync();
               beanRunner.init(pac, testcase);
               pac.start(beanRunner);
               result = null;
            } else {
               result.appendTcDetail("CDI support not available.");
            }
            
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_cdi2                          */
         /* Details: "When CDI is available and the asynchronous thread is started     */
         /* through the PortletAsyncContext object, the PortletAsyncListener runs in   */
         /* the same context as the original request"                                  */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI2)) {
            result = tcd.getTestResultFailed(testcase);
            if (bean != null) {
               bean.setTestcase(testcase);
               pac = req.startPortletAsync();
               beanListener.setTestcase(testcase);
               pac.addListener(beanListener);
               // Force a timeout to get the listener to run
               pac.setTimeout(100);
               result = null;
            } else {
               result.appendTcDetail("CDI support not available.");
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_cdi3                          */
         /* Details: "When CDI is available and the asynchronous thread is started     */
         /* through the PortletAsyncContext object, the resource filter runs in the    */
         /* same context as the original request"                                      */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI3)) {
            // output is written in the filter during the async dispatch
            if (req.getDispatcherType() == DispatcherType.REQUEST) {
               result = tcd.getTestResultFailed(testcase);
               if (bean != null) {
                  bean.setTestcase(testcase);
                  pac = req.startPortletAsync();
                  pac.dispatch();
                  result = null;
               }
            }
            
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_onTimeout                     */
         /* Details: "The PortletAsyncListener object onTimeout(PortletAsyncEvent)     */
         /* method is called when a timeout occurs "                                   */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONTIMEOUT)) {
            pac = req.startPortletAsync();
            AsyncListener listener = new AsyncListener();
            listener.setTestcase(testcase);
            pac.addListener(listener);
            pac.setTimeout(100); 
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_onError                       */
         /* Details: "The PortletAsyncListener object onError(PortletAsyncEvent)       */
         /* method is called if an exception is thrown in an asynchronous thread       */
         /* started through the PortletAsyncContext object "                           */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONERROR)) {
            result = asyres.getAndClearResult(testcase);
            if (result == null) {
               result = tcd.getTestResultFailed(testcase);
               pac = req.startPortletAsync();
               AsyncListener listener = new AsyncListener();
               listener.setTestcase(testcase);
               pac.addListener(listener);
               pac.setTimeout(2000); 
               AsyncRunner runner = new AsyncRunner();
               runner.init(pac, testcase);
               pac.start(runner);
               result = null;
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_onComplete                    */
         /* Details: "The PortletAsyncListener object onComplete(PortletAsyncEvent)    */
         /* method is called when asynchronous processing completes "                  */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONCOMPLETE)) {
            result = asyres.getAndClearResult(testcase);
            if (result == null) {
               writer.write("repeat");     // signal the JS fetch code to repeat
               result = tcd.getTestResultFailed(testcase);
               pac = req.startPortletAsync();
               AsyncListener listener = new AsyncListener();
               listener.setTestcase(testcase);
               pac.addListener(listener);
               pac.complete();
               result = null;
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_onStartAsync                  */
         /* Details: "The PortletAsyncListener object onStartAsync(PortletAsyncEvent)  */
         /* method is called when asynchronous processing is restarted "               */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONSTARTASYNC)) {
            boolean isDispatched = new Boolean((String) session.getAttribute(testcase));
            if (isDispatched) {
               // 2nd time thru
               session.removeAttribute(testcase);
               result = tcd.getTestResultFailed(testcase);
               pac = req.getPortletAsyncContext();
               if (pac != null) {
                  req.startPortletAsync();
                  result = null;
               } else {
                  result.appendTcDetail("Couldn't retrieve PortletAsyncContext object");
               }
            } else {
               // 1st time thru
               try {
                  pac = req.startPortletAsync();
                  AsyncListener listener = new AsyncListener();
                  listener.setTestcase(testcase);
                  pac.addListener(listener);
                  pac.dispatch();
                  session.setAttribute(testcase, "true");
               } catch (Throwable t) {
                  result = tcd.getTestResultFailed(testcase);
                  result.appendTcDetail("Exception starting or dispatching async: " + t.getMessage());
               }
            }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getPortletAsyncContext        */
         /* Details: "The PortletAsyncEvent object getPortletAsyncContext() method     */
         /* returns the PortletAsyncContext object for the request"                    */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT)) {
            // test performed in onTimeout method
            pac = req.startPortletAsync();
            AsyncListener listener = new AsyncListener();
            listener.setTestcase(testcase);
            pac.addListener(listener);
            pac.setTimeout(20); 
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getSuppliedRequest1           */
         /* Details: "The PortletAsyncEvent object getSuppliedRequest() method returns */
         /* null if no resource request was supplied when the PortletAsyncListener was */
         /* added "                                                                    */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST1)) {
            // test performed in onTimeout method
            pac = req.startPortletAsync();
            AsyncListener listener = new AsyncListener();
            listener.setTestcase(testcase);
            pac.addListener(listener);
            pac.setTimeout(20); 
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getSuppliedRequest2           */
         /* Details: "The PortletAsyncEvent object getSuppliedRequest() method returns */
         /* the supplied request if a resource request was supplied when the           */
         /* PortletAsyncListener was added "                                           */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST2)) {
            // test performed in onTimeout method
            pac = req.startPortletAsync();
            AsyncListener listener = new AsyncListener();
            listener.setTestcase(testcase);
            pac.addListener(listener, req, resp);
            pac.setTimeout(20); 
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getSuppliedResponse1          */
         /* Details: "The PortletAsyncEvent object getSuppliedResponse() method        */
         /* returns null if no resource response was supplied when the                 */
         /* PortletAsyncListener was added "                                           */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE1)) {
            // test performed in onTimeout method
            pac = req.startPortletAsync();
            AsyncListener listener = new AsyncListener();
            listener.setTestcase(testcase);
            pac.addListener(listener);
            pac.setTimeout(20); 
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getSuppliedResponse2          */
         /* Details: "The PortletAsyncEvent object getSuppliedResponse() method        */
         /* returns the supplied response if a resource response was supplied when the */
         /* PortletAsyncListener was added "                                           */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE2)) {
            // test performed in onTimeout method
            pac = req.startPortletAsync();
            AsyncListener listener = new AsyncListener();
            listener.setTestcase(testcase);
            pac.addListener(listener, req, resp);
            pac.setTimeout(20); 
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getThrowable1                 */
         /* Details: "The PortletAsyncEvent object getThrowable() method returns null  */
         /* within the PortletAsyncListener object onComplete(), onTimeout(), and      */
         /* onStartAsync() methods"                                                    */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE1)) {
            // test performed in onTimeout method
            pac = req.startPortletAsync();
            AsyncListener listener = new AsyncListener();
            listener.setTestcase(testcase);
            pac.addListener(listener);
            pac.setTimeout(20); 
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getThrowable2                 */
         /* Details: "The PortletAsyncEvent object getThrowable() method returns the   */
         /* Throwable object associated with the error within the PortletAsyncListener */
         /* object onError() method"                                                   */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE2)) {
            result = asyres.getAndClearResult(testcase);
            if (result == null) {
               result = tcd.getTestResultFailed(testcase);
               pac = req.startPortletAsync();
               AsyncListener listener = new AsyncListener();
               listener.setTestcase(testcase);
               pac.addListener(listener);
               pac.setTimeout(2000); 
               AsyncRunner runner = new AsyncRunner();
               runner.init(pac, testcase);
               pac.start(runner);
               result = null;
            }
         
         } else {
            writer.write("Unknown test case:" + testcase);
         }
      
      } catch (Throwable t) {
         StringWriter sw = new StringWriter();
         PrintWriter pw = new PrintWriter(sw);
         t.printStackTrace(pw);
         pw.flush();
         String trace = sw.toString().replaceAll("\\n", "<br>");
         
         if (result != null) {
            result.setTcSuccess(false);
            result.appendTcDetail("Unexpected exception processing test: <br>" + trace);
         } else {
            writer.write("Unexpected exception processing test: <br>" + trace);
         }
      }

      if (result != null) {
         writer.write(result.toString());
      }
      
      if (doComplete && pac != null) {
         pac.complete();
      }

   }

}
