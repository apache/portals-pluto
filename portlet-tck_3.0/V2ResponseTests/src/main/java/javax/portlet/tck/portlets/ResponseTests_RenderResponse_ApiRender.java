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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETCONTENTTYPE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETTITLE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETNEXTPOSSIBLEPORTLETMODES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETCONTENTTYPE2;
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
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
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
 * ResponseTests_RenderResponse_ApiRender_event
 *
 */
public class ResponseTests_RenderResponse_ApiRender implements Portlet {

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

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      /* TestCase: V2ResponseTests_RenderResponse_ApiRender_setContentType2 */
      /* Details: "Method setContentType(String): Throws */
      /* IllegalArgumentException if the content type is not valid" */
      TestResult tr3 = tcd.getTestResultFailed(
          V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETCONTENTTYPE2);
      try {
         portletResp.setContentType("Invalid");
         tr3.appendTcDetail("Method did not throw Exception");
      } catch (IllegalArgumentException iae) {
         tr3.setTcSuccess(true);
      }
      PrintWriter writer = portletResp.getWriter();
      tr3.writeTo(writer);

      // Create result objects for the tests

      /* TestCase: V2ResponseTests_RenderResponse_ApiRender_setTitle2 */
      /* Details: "Method setTitle(String): Sets the portlet title to the */
      /* specified value" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETTITLE2);
      tr0.setTcSuccess(true);
      tr0.writeTo(writer);

      /*
       * TestCase:
       * V2ResponseTests_RenderResponse_ApiRender_setNextPossiblePortletModes2
       */
      /* Details: "Method */
      /* setNextPossiblePortletModes(java.util.Collection): Sets the next */
      /* possible portlet modes to the specified value" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETNEXTPOSSIBLEPORTLETMODES2);
      tr1.setTcSuccess(true);
      tr1.writeTo(writer);

      /* TestCase: V2ResponseTests_RenderResponse_ApiRender_setContentType1 */
      /* Details: "Method setContentType(String): The portlet container */
      /* will ignore any character encoding specified as part of the */
      /* content type for render calls" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETCONTENTTYPE1);
      tr2.setTcSuccess(true);
      tr2.writeTo(writer);

   }

}
