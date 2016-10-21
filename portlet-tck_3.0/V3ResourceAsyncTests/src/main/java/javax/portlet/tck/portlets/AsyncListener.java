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
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_SETTIMEOUT;

import java.io.IOException;

import javax.portlet.PortletAsyncEvent;
import javax.portlet.PortletAsyncListener;
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
   
   private boolean isTimeout = false;
   private boolean isStart = false;
   private boolean isError = false;
   
   private ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
   private AsyncResults asyres = AsyncResults.getAsyncResults();

   
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

      }
      
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncListener#onError(javax.portlet.PortletAsyncEvent)
    */
   @Override
   public void onError(PortletAsyncEvent evt) throws IOException {
      isError = true;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncListener#onStartAsync(javax.portlet.PortletAsyncEvent)
    */
   @Override
   public void onStartAsync(PortletAsyncEvent evt) throws IOException {
      isStart = true;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncListener#onTimeout(javax.portlet.PortletAsyncEvent)
    */
   @Override
   public void onTimeout(PortletAsyncEvent evt) throws IOException {
      isTimeout = true;
      
      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_setTimeout                    */
      /* Details: "The PortletAsyncContext object setTimeout() method sets the      */
      /* asynchronous timeout value"                                                */
      if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_SETTIMEOUT)) {
         TestResult result = tcd.getTestResultSucceeded(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_SETTIMEOUT);
         ResourceResponse resp = evt.getPortletAsyncContext().getResourceResponse();
         resp.getWriter().write(result.toString());
         evt.getPortletAsyncContext().complete();
      }
   }

}
