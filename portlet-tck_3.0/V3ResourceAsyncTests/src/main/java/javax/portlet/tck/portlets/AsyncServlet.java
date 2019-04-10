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

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE6;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH6;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH7;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet to act as the target of an asynchronous dispatch.
 * 
 * @author Scott Nicklous
 */
@WebServlet(urlPatterns = "/dispatchTarget", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      String testcase = req.getParameter("testcase");
      PrintWriter writer = resp.getWriter();
      TestResult result = null;
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_getDispatcherType5 */
      /* Details: "The ResourceRequest object getDispatcherType() method returns */
      /* the value DispatcherType.ASYNC within the dispatch target method when the */
      /* PortletAsyncContext object dispatch(String) method is used to dispatch to */
      /* the resource method " */
      if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE5)) {
         result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_GETDISPATCHERTYPE5);
         DispatcherType dt = req.getDispatcherType();
         if (dt == DispatcherType.ASYNC) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Unexpected dispatcher type in dispatch target method: " + dt.name());
         }
         writer.write(result.toString());

         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_complete6                     */
         /* Details: "The PortletAsyncContext object complete() method throws an       */
         /* IllegalStateException if called after the PortletAsyncContext object       */
         /* dispatch(String) method has been called"                                   */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE6)) {
         HttpSession session = req.getSession();
         result = (TestResult) session.getAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE6);
         if (result == null) {
            result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE6);
            result.appendTcDetail("No session attribute available, expecting test result under attribute name: " + V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE6);
         }
         session.removeAttribute(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_COMPLETE6);
         writer.write(result.toString());
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch6                     */
         /* Details: "The PortletAsyncContext object dispatch(String) method           */
         /* dispatches to the given path if called from within the original resource   */
         /* request"                                                                   */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH6)) {
         result = tcd.getTestResultSucceeded(testcase);
         writer.write(result.toString());
         
         /* TestCase: V3ResourceAsyncTests_SPEC_21_Async_dispatch7                     */
         /* Details: "The PortletAsyncContext object dispatch(String) method           */
         /* dispatches to the given path if called from within an asynchronous thread" */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_ASYNC_DISPATCH7)) {
         result = tcd.getTestResultSucceeded(testcase);
         writer.write(result.toString());
         
      }
   }

}
