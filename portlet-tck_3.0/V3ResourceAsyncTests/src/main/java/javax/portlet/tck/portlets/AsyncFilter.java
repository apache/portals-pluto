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

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.portlet.PortletAsyncContext;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.PortletLifecycleFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.ResourceFilter;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import javax.servlet.DispatcherType;

/**
 * @author Scott Nicklous
 * 
 */
@PortletLifecycleFilter(portletNames = "ResourceAsyncTests_SPEC_21_Async")
public class AsyncFilter implements ResourceFilter {

   @Inject private AsyncBean bean;

   /*
    * (non-Javadoc)
    * 
    * @see javax.portlet.filter.PortletFilter#init(javax.portlet.filter.FilterConfig)
    */
   @Override
   public void init(FilterConfig filterConfig) throws PortletException {
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.portlet.filter.PortletFilter#destroy()
    */
   @Override
   public void destroy() {
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.portlet.filter.ResourceFilter#doFilter(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse,
    * javax.portlet.filter.FilterChain)
    */
   @Override
   public void doFilter(ResourceRequest req, ResourceResponse resp, FilterChain chain) throws IOException, PortletException {

      PrintWriter writer = resp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      String testcase = req.getResourceParameters().getValue("testcase");
      TestResult result = null;
      PortletSession session = req.getPortletSession();

      chain.doFilter(req, resp);

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType2 */
      /* Details: "The ResourceRequest object getDispatcherType() method returns */
      /* the value DispatcherType.REQUEST within the resource filter before the */
      /* container dispatch cycle in which asynchronous processing is started */
      /* returns" */
      if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE2)) {
         result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE2);
         DispatcherType dt = req.getDispatcherType();
         if (dt == DispatcherType.REQUEST) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Unexpected dispatcher type: " + dt.name());
         }
         writer.write(result.toString());

         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType4 */
         /* Details: "The ResourceRequest object getDispatcherType() method returns */
         /* the value DispatcherType.ASYNC within the resource filter when the */
         /* PortletAsyncContext object dispatch() method is used to dispatch to the */
         /* resource method " */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE4)) {
         boolean isDispatched = new Boolean((String) session.getAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE4));
         if (isDispatched) {
            // 2nd time thru
            session.removeAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE4);
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE4);
            DispatcherType dt = req.getDispatcherType();
            if (dt == DispatcherType.ASYNC) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Unexpected dispatcher type: " + dt.name());
            }
            writer.write(result.toString());
         } else {
            // 1st time thru
            try {
               PortletAsyncContext pac = req.startPortletAsync();
               pac.dispatch();
               session.setAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE4, "true");
            } catch (Throwable t) {
               result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE4);
               result.appendTcDetail("Exception starting or dispatching async: " + t.getMessage());
            }
         }
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_cdi3                          */
         /* Details: "When CDI is available and the asynchronous thread is started     */
         /* through the PortletAsyncContext object, the resource filter runs in the    */
         /* same context as the original request"                                      */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_CDI3)) {
         if (bean != null) {
            DispatcherType dt = req.getDispatcherType();
            if (dt == DispatcherType.ASYNC) {
               // setup is performed in the portlet resource method
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
               writer.write(result.toString());
            }
         } else {
            result = tcd.getTestResultFailed(testcase);
            result.appendTcDetail("CDI support not available.");
            writer.write(result.toString());
         }

      }
   }
}
