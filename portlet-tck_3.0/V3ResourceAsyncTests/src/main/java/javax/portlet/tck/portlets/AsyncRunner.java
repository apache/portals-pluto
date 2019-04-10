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

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH7;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONERROR;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START1;

import javax.inject.Inject;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.portlet.PortletAsyncContext;

/**
 * To be run in separate thread for execution of certain tck tests.
 * 
 * @author Scott Nicklous
 */
public class AsyncRunner implements Runnable {

   private PortletAsyncContext pac;
   private String              testcase;

   public void init(PortletAsyncContext actx, String testcase) {
      this.pac = actx;
      this.testcase = testcase;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Runnable#run()
    */
   @Override
   public void run() {
      
      TestResult result = null;
      PrintWriter writer = null;
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      try {

         Thread.sleep(100);
         writer = pac.getResourceResponse().getWriter();

         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete2 */
         /* Details: "The PortletAsyncContext object complete() method completes */
         /* asynchronous processing within an asynchronous thread" */
         if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE2)) {
            writer.write("repeat");     // signal the JS fetch code to repeat
            pac.complete();

            /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch2                     */
            /* Details: "The PortletAsyncContext object dispatch() method dispatches to   */
            /* the resource method if called from within an asynchronous thread"          */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH2)) {
            pac.dispatch();
            
            /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch7                     */
            /* Details: "The PortletAsyncContext object dispatch(String) method           */
            /* dispatches to the given path if called from within an asynchronous thread" */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH7)) {
            pac.dispatch("/dispatchTarget");
            
            /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_start1                        */
            /* Details: "The PortletAsyncContext object start(Runnable) method causes an    */
            /* asynchronous thread to run"                                                */
         } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_START1)) {
            result = tcd.getTestResultSucceeded(testcase);
         
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
         } else if (writer != null) {
            writer.write("Unexpected exception processing test: <br>" + trace);
         }
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_onError                       */
      /* Details: "The PortletAsyncListener object onError(PortletAsyncEvent)       */
      /* method is called if an exception is thrown in an asynchronous thread       */
      /* started through the PortletAsyncContext object "                           */
      if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_ONERROR)) {
         throw new Error("Forced exception in async thread. Test case: " + testcase);
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getThrowable2                 */
         /* Details: "The PortletAsyncEvent object getThrowable() method returns the   */
         /* Throwable object associated with the error within the PortletAsyncListener */
         /* object onError() method"                                                   */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETTHROWABLE2)) {
         throw new Error("Forced exception in async thread. Test case: " + testcase);
         
      }

      if (result != null && writer != null) {
         try {
            result.writeTo(writer);
            pac.complete();
         } catch (IOException e) {
         }
      }

   }

}
