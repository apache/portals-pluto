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

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI2;

import java.io.IOException;

import javax.inject.Inject;
import javax.portlet.PortletAsyncEvent;
import javax.portlet.PortletAsyncListener;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.PortletRequestScoped;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

/**
 * Portlet async listener for TCK tests
 * 
 * @author Scott Nicklous
 */
@PortletRequestScoped
public class AsyncBeanListener implements PortletAsyncListener {
   
   private String testcase;
   
   private ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

   @Inject private AsyncBean bean;

   
   public void setTestcase(String tc) {
      testcase = tc;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncListener#onComplete(javax.portlet.PortletAsyncEvent)
    */
   @Override
   public void onComplete(PortletAsyncEvent evt) throws IOException {
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncListener#onError(javax.portlet.PortletAsyncEvent)
    */
   @Override
   public void onError(PortletAsyncEvent evt) throws IOException {
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncListener#onStartAsync(javax.portlet.PortletAsyncEvent)
    */
   @Override
   public void onStartAsync(PortletAsyncEvent evt) throws IOException {
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncListener#onTimeout(javax.portlet.PortletAsyncEvent)
    */
   @Override
   public void onTimeout(PortletAsyncEvent evt) throws IOException {

         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_cdi2                          */
         /* Details: "When CDI is available and the asynchronous thread is started     */
         /* through the PortletAsyncContext object, the PortletAsyncListener runs in   */
         /* the same context as the original request"                                  */
      if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI2)) {
         TestResult result = tcd.getTestResultFailed(testcase);
         assert bean != null;       // otherwise TC logic is broken
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
         ResourceResponse resp = evt.getPortletAsyncContext().getResourceResponse();
         resp.getWriter().write(result.toString());

      }
   }

}
