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
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONCOMPLETE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONERROR;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONSTARTASYNC;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONTIMEOUT;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_SETTIMEOUT;

import java.io.IOException;

import javax.inject.Inject;
import javax.portlet.PortletAsyncContext;
import javax.portlet.PortletAsyncEvent;
import javax.portlet.PortletAsyncListener;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

/**
 * Portelt async listener for TCK tests
 * 
 * @author Scott Nicklous
 */
public class AsyncListener implements PortletAsyncListener {
   
   private String testcase;
   
   private ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
   private AsyncResults asyres = AsyncResults.getAsyncResults();

   @Inject private AsyncBean bean;

   
   public void setTestcase(String tc) {
      testcase = tc;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncListener#onComplete(javax.portlet.PortletAsyncEvent)
    */
   @Override
   public void onComplete(PortletAsyncEvent evt) throws IOException {
      
      TestResult result = null;
      
      // Note that the results can't be written in the onComplete method, since the
      // response is already closed.
      
      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_addListener1                  */
      /* Details: "The PortletAsyncContext object addListener(PortletAsyncListener) */
      /* method adds a portlet asynchronous listener"                               */
      if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER1)) {
         result = tcd.getTestResultSucceeded(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER1);
         asyres.setResult(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER1, result);
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_addListener3                  */
         /* Details: "The PortletAsyncContext object addListener(PortletAsyncListener, */
         /* ResourceRequest, ResourceResponse) method adds a portlet asynchronous      */
         /* listener"                                                                  */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER3)) {
         result = tcd.getTestResultSucceeded(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER3);
         asyres.setResult(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ADDLISTENER3, result);


         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete1                     */
         /* Details: "The PortletAsyncContext object complete() method completes       */
         /* asynchronous processing within the original resource request"              */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE1)) {
         result = tcd.getTestResultSucceeded(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE1);
         asyres.setResult(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE1, result);

         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete2                     */
         /* Details: "The PortletAsyncContext object complete() method completes       */
         /* asynchronous processing within an asynchronous thread"                     */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE2)) {
         result = tcd.getTestResultSucceeded(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE2);
         asyres.setResult(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE2, result);
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_onComplete                    */
         /* Details: "The PortletAsyncListener object onComplete(PortletAsyncEvent)    */
         /* method is called when asynchronous processing completes "                  */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONCOMPLETE)) {
         result = tcd.getTestResultSucceeded(testcase);
         asyres.setResult(testcase, result);

      }
      
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncListener#onError(javax.portlet.PortletAsyncEvent)
    */
   @Override
   public void onError(PortletAsyncEvent evt) throws IOException {

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_onError                       */
      /* Details: "The PortletAsyncListener object onError(PortletAsyncEvent)       */
      /* method is called if an exception is thrown in an asynchronous thread       */
      /* started through the PortletAsyncContext object "                           */
      if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONERROR)) {
         TestResult result = tcd.getTestResultSucceeded(testcase);
         ResourceResponse resp = evt.getPortletAsyncContext().getResourceResponse();
         resp.getWriter().write(result.toString());
         evt.getPortletAsyncContext().complete();
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getThrowable2                 */
         /* Details: "The PortletAsyncEvent object getThrowable() method returns the   */
         /* Throwable object associated with the error within the PortletAsyncListener */
         /* object onError() method"                                                   */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE2)) {
         TestResult result = tcd.getTestResultFailed(testcase);
         Throwable t = evt.getThrowable();
         if (t != null) {
            result.setTcSuccess(true);
            result.appendTcDetail("Throwable was present: " + t.getMessage());
         } else {
            result.appendTcDetail("Throwable from event was null.");
         }
         ResourceResponse resp = evt.getPortletAsyncContext().getResourceResponse();
         resp.getWriter().write(result.toString());
         evt.getPortletAsyncContext().complete();

      }
}

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncListener#onStartAsync(javax.portlet.PortletAsyncEvent)
    */
   @Override
   public void onStartAsync(PortletAsyncEvent evt) throws IOException {
      
      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_onStartAsync                  */
      /* Details: "The PortletAsyncListener object onStartAsync(PortletAsyncEvent)  */
      /* method is called when asynchronous processing is restarted "               */
      if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONSTARTASYNC)) {
         TestResult result = tcd.getTestResultSucceeded(testcase);
         ResourceResponse resp = evt.getPortletAsyncContext().getResourceResponse();
         resp.getWriter().write(result.toString());
         evt.getPortletAsyncContext().complete();
         
      }

   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncListener#onTimeout(javax.portlet.PortletAsyncEvent)
    */
   @Override
   public void onTimeout(PortletAsyncEvent evt) throws IOException {

      PortletAsyncContext pac = evt.getPortletAsyncContext();
      TestResult result = null;

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_setTimeout                    */
      /* Details: "The PortletAsyncContext object setTimeout() method sets the      */
      /* asynchronous timeout value"                                                */
      if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_SETTIMEOUT)) {
         result = tcd.getTestResultSucceeded(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_SETTIMEOUT);
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_cdi2                          */
         /* Details: "When CDI is available and the asynchronous thread is started     */
         /* through the PortletAsyncContext object, the PortletAsyncListener runs in   */
         /* the same context as the original request"                                  */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI2)) {
         result = tcd.getTestResultFailed(testcase);
         String btc = bean.getTestcase();
         if (btc != null && btc.equals(testcase)) {
            result.setTcSuccess(true);
         } else {
            StringBuilder txt = new StringBuilder(128);
            txt.append("value from injected bean not as expected. ");
            txt.append("Expected: ").append(testcase);
            txt.append(", Actual: ").append(btc);
            result.appendTcDetail(txt.toString());
         }         
         
      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_onTimeout                     */
      /* Details: "The PortletAsyncListener object onTimeout(PortletAsyncEvent)     */
      /* method is called when a timeout occurs "                                   */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONTIMEOUT)) {
         result = tcd.getTestResultSucceeded(testcase);
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getPortletAsyncContext        */
         /* Details: "The PortletAsyncEvent object getPortletAsyncContext() method     */
         /* returns the PortletAsyncContext object for the request"                    */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETPORTLETASYNCCONTEXT)) {
         result = tcd.getTestResultSucceeded(testcase);
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getSuppliedRequest1           */
         /* Details: "The PortletAsyncEvent object getSuppliedRequest() method returns */
         /* null if no resource request was supplied when the PortletAsyncListener was */
         /* added "                                                                    */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST1)) {
         result = tcd.getTestResultFailed(testcase);
         ResourceRequest testreq = evt.getSuppliedRequest();
         if (testreq != null) {
            result.appendTcDetail("resource request from PortletAsyncEvent was unexpectedly not null.");
         } else {
            result.setTcSuccess(true);
         }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getSuppliedRequest2           */
         /* Details: "The PortletAsyncEvent object getSuppliedRequest() method returns */
         /* the supplied request if a resource request was supplied when the           */
         /* PortletAsyncListener was added "                                           */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDREQUEST2)) {
         result = tcd.getTestResultFailed(testcase);
         ResourceRequest testreq = evt.getSuppliedRequest();
         if (testreq == null) {
            result.appendTcDetail("resource request from PortletAsyncEvent was unexpectedly null.");
         } else {
            result.setTcSuccess(true);
         }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getSuppliedResponse1          */
         /* Details: "The PortletAsyncEvent object getSuppliedResponse() method        */
         /* returns null if no resource response was supplied when the                 */
         /* PortletAsyncListener was added "                                           */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE1)) {
         result = tcd.getTestResultFailed(testcase);
         ResourceResponse testresp = evt.getSuppliedResponse();
         if (testresp != null) {
            result.appendTcDetail("resource response from PortletAsyncEvent was unexpectedly not null.");
         } else {
            result.setTcSuccess(true);
         }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getSuppliedResponse2          */
         /* Details: "The PortletAsyncEvent object getSuppliedResponse() method        */
         /* returns the supplied response if a resource response was supplied when the */
         /* PortletAsyncListener was added "                                           */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETSUPPLIEDRESPONSE2)) {
         result = tcd.getTestResultFailed(testcase);
         ResourceResponse testresp = evt.getSuppliedResponse();
         if (testresp == null) {
            result.appendTcDetail("resource response from PortletAsyncEvent was unexpectedly null.");
         } else {
            result.setTcSuccess(true);
         }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getThrowable1                 */
         /* Details: "The PortletAsyncEvent object getThrowable() method returns null  */
         /* within the PortletAsyncListener object onComplete(), onTimeout(), and      */
         /* onStartAsync() methods"                                                    */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE1)) {
         result = tcd.getTestResultFailed(testcase);
         if (evt.getThrowable() != null) {
            result.appendTcDetail("Throwable from PortletAsyncEvent was unexpectedly not null.");
         } else {
            result.setTcSuccess(true);
         }
         
      } else {
         result = tcd.getTestResultFailed(testcase);
         result.appendTcDetail("Timed out.");
      }
      
      if (result != null) {
         ResourceResponse resp = pac.getResourceResponse();
         resp.getWriter().write(result.toString());
         pac.complete();
      }
      
   }

}
