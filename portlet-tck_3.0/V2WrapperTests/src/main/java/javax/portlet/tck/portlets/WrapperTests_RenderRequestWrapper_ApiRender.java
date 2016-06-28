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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERREQUESTWRAPPER_APIRENDER_GETREQUEST;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERREQUESTWRAPPER_APIRENDER_SETREQUEST;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERREQUESTWRAPPER_APIRENDER_GETETAG;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.RenderRequestWrapper;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.RenderRequestWrapperChecker;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for
 * events, this portlet will initiate the events, but not process them. The
 * processing is done in the companion portlet
 * WrapperTests_RenderRequestWrapper_ApiRender_event
 *
 */
public class WrapperTests_RenderRequestWrapper_ApiRender implements Portlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      RenderRequestWrapperChecker wc = new RenderRequestWrapperChecker(
            portletReq);
      RenderRequestWrapper wpr = new RenderRequestWrapper(portletReq);
      wpr.setRequest(wc);
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2WrapperTests_RenderRequestWrapper_ApiRender_getRequest */
      /* Details: "Method getRequest(): Returns wrapped RenderRequest */
      /* object" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERREQUESTWRAPPER_APIRENDER_GETREQUEST);
      try {
         // The retrieved request / response object should be the wrapper
         // checker instance
         RenderRequest r = wpr.getRequest();
         tr0.setTcSuccess(r == wc);
      } catch (Exception e) {
         tr0.appendTcDetail(e.toString());
      }
      tr0.writeTo(writer);

      /* TestCase: V2WrapperTests_RenderRequestWrapper_ApiRender_setRequest */
      /* Details: "Method setRequest(RenderRequest): Allows wrapped */
      /* RenderRequest object to be set " */
      TestResult tr1 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERREQUESTWRAPPER_APIRENDER_SETREQUEST);
      try {
         // tested by method set up
         tr1.setTcSuccess(true);
      } catch (Exception e) {
         tr1.appendTcDetail(e.toString());
      }
      tr1.writeTo(writer);

      /* TestCase: V2WrapperTests_RenderRequestWrapper_ApiRender_getETag */
      /* Details: "Method getETag(): Calls wrapped method" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERREQUESTWRAPPER_APIRENDER_GETETAG);
      try {
         Object[] args = {};
         wc.prepare(tr2, "getETag", args);
         wc.checkRetval(wpr.getETag());
      } catch (Exception e) {
         tr2.appendTcDetail(e.toString());
      }
      tr2.writeTo(writer);

   }

}
