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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETMODE_APIRENDER_CONSTRUCTOR1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETMODE_APIRENDER_CONSTRUCTOR2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETMODE_APIRENDER_EQUALS;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETMODE_APIRENDER_FIELDEDIT;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETMODE_APIRENDER_FIELDHELP;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETMODE_APIRENDER_FIELDVIEW;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETMODE_APIRENDER_HASHCODE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETMODE_APIRENDER_TOSTRING;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.ClassChecker;
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
 * PortletTests_PortletMode_ApiRender_event
 *
 */
public class PortletTests_PortletMode_ApiRender implements Portlet {

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

   @SuppressWarnings("unused")
   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      PortletMode mode = portletReq.getPortletMode();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(
            portletReq.getPortletMode().getClass());

      /* TestCase: V2PortletTests_PortletMode_ApiRender_constructor1 */
      /* Details: "The constructor PortletMode(java.lang.String): allows a */
      /* PortletMode object of the specified name to be constructed" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2PORTLETTESTS_PORTLETMODE_APIRENDER_CONSTRUCTOR1);
      PortletMode pm = new PortletMode("newmode");
      if (pm != null && pm.toString().equals("newmode")) {
         tr0.setTcSuccess(true);
      } else {
         tr0.appendTcDetail("The Portlet Mode has null value");
      }
      tr0.writeTo(writer);

      /* TestCase: V2PortletTests_PortletMode_ApiRender_constructor2 */
      /* Details: "The constructor PortletMode(java.lang.String): converts */
      /* any upper case letters in the name parameter to lower case" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2PORTLETTESTS_PORTLETMODE_APIRENDER_CONSTRUCTOR2);
      PortletMode pm1 = new PortletMode("NEWMODE");
      if (pm1 != null && pm1.toString().equals("newmode")) {
         tr1.setTcSuccess(true);
      } else {
         tr1.appendTcDetail("The Portlet Mode has null value");
      }
      tr1.writeTo(writer);

      /* TestCase: V2PortletTests_PortletMode_ApiRender_fieldEDIT */
      /* Details: "Has PortletMode field EDIT with value of */
      /* PortletMode.EDIT " */
      TestResult tr2 = tcd.getTestResultFailed(
            V2PORTLETTESTS_PORTLETMODE_APIRENDER_FIELDEDIT);
      try {
         tr2.setTcSuccess(cc.hasField("EDIT", PortletMode.EDIT));
      } catch (Exception e) {
         tr2.appendTcDetail(e.toString());
      }
      tr2.writeTo(writer);

      /* TestCase: V2PortletTests_PortletMode_ApiRender_fieldHELP */
      /* Details: "Has PortletMode field HELP with value of */
      /* PortletMode.HELP " */
      TestResult tr3 = tcd.getTestResultFailed(
            V2PORTLETTESTS_PORTLETMODE_APIRENDER_FIELDHELP);
      try {
         tr3.setTcSuccess(cc.hasField("HELP", PortletMode.HELP));
      } catch (Exception e) {
         tr3.appendTcDetail(e.toString());
      }
      tr3.writeTo(writer);

      /* TestCase: V2PortletTests_PortletMode_ApiRender_fieldVIEW */
      /* Details: "Has PortletMode field VIEW with value of */
      /* PortletMode.VIEW " */
      TestResult tr4 = tcd.getTestResultFailed(
            V2PORTLETTESTS_PORTLETMODE_APIRENDER_FIELDVIEW);
      try {
         tr4.setTcSuccess(cc.hasField("VIEW", PortletMode.VIEW));
      } catch (Exception e) {
         tr4.appendTcDetail(e.toString());
      }
      tr4.writeTo(writer);

      /* TestCase: V2PortletTests_PortletMode_ApiRender_toString */
      /* Details: "Method toString(): Returns a String representation of */
      /* the portlet mode" */
      TestResult tr5 = tcd
            .getTestResultFailed(V2PORTLETTESTS_PORTLETMODE_APIRENDER_TOSTRING);
      String tstring = mode.toString();
      if (tstring.equals("view")) {
         tr5.setTcSuccess(true);
      } else {
         tr5.appendTcDetail(
               "String Representation of Portlet Mode: " + mode.toString());
      }
      tr5.writeTo(writer);

      /* TestCase: V2PortletTests_PortletMode_ApiRender_hashCode */
      /* Details: "Method hashCode(): Returns an int containing the has */
      /* code for the portlet mode" */
      TestResult tr6 = tcd.getTestResultSucceeded(
            V2PORTLETTESTS_PORTLETMODE_APIRENDER_HASHCODE);
      Object hcode = mode.hashCode();
      if (hcode != null) {
         tr6.setTcSuccess(true);
      } else {
         tr6.appendTcDetail("The hascode has null value");
      }
      tr6.writeTo(writer);

      /* TestCase: V2PortletTests_PortletMode_ApiRender_equals */
      /* Details: "Method equals(): Returns true if the PortletMode equals */
      /* the specified PortletMode" */
      TestResult tr7 = tcd
            .getTestResultFailed(V2PORTLETTESTS_PORTLETMODE_APIRENDER_EQUALS);
      PortletMode pmn1 = new PortletMode("NewMode");
      PortletMode pmn2 = new PortletMode("newmode");
      if (pmn1.equals(pmn2)) {
         tr7.setTcSuccess(true);
      } else {
         tr7.appendTcDetail("The Portlet Modes are not equal");
      }

      tr7.writeTo(writer);
   }

}
