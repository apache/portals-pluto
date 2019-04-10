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

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.inject.Inject;
import javax.portlet.PortletAsyncContext;
import javax.portlet.annotations.PortletRequestScoped;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

/**
 * To be run in separate thread for execution of certain tck tests.
 * 
 * @author Scott Nicklous
 */
@PortletRequestScoped
public class AsyncBeanRunner implements Runnable {

   private PortletAsyncContext pac;
   private String              testcase;

   @Inject private AsyncBean bean;

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
            
            /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_cdi1                          */
            /* Details: "When CDI is available and the asynchronous thread is started     */
            /* through the PortletAsyncContext object, the asynchronous thread runs in    */
            /* the same context as the original request"                                  */
         if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI1)) {
            result = tcd.getTestResultFailed(testcase);
            assert bean != null;          // otherwise testcase logic is broken
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
      
      if (result != null && writer != null) {
         try {
            result.writeTo(writer);
            pac.complete();
         } catch (IOException e) {
         }
      }

   }

}
