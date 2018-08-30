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

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ActionURL;
import javax.portlet.GenericPortlet;
import javax.portlet.MimeResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletSession;
import javax.portlet.RenderMode;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 */

public class RenderStateTests_SPEC2_12_MutableRenderState
      extends GenericPortlet {

   @Override
   public void processAction(ActionRequest actionRequest,
         ActionResponse actionResponse) throws PortletException, IOException {

      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      StringWriter writer = new StringWriter();

      ActionParameters actionParams = actionRequest.getActionParameters();
      String action = actionParams.getValue(Constants.BUTTON_PARAM_NAME);
      MutableRenderParameters renderParams = actionResponse.getRenderParameters();

      if (action != null) {
         if (action.equals(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_GETRENDERPARAMETERS)) {
            /*
             * TestCase:
             * V3RenderStateTests_SPEC2_12_MutableRenderState_getRenderParameters
             */
            /*
             * Details:
             * "Returns an MutableRenderParameters object representing the private and public render parameters."
             */
            if (!renderParams.isEmpty() && renderParams.isPublic("tr0_public")
                  && renderParams.getValue("tr0_public") != null
                  && renderParams.getValue("tr0_public").equals("true")
                  && renderParams.getValue("tr0_private") != null
                  && renderParams.getValue("tr0_private").equals("true")) {
               TestResult result = tcd.getTestResultFailed(
                     V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_GETRENDERPARAMETERS);
               result.setTcSuccess(true);
               result.writeTo(writer);
            }
         } else if (action.equals(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_GETRENDERPARAMETERS2)) {
            /*
             * TestCase:
             * V3RenderStateTests_SPEC2_12_MutableRenderState_getRenderParameters2
             */
            /*
             * Details:
             * "The MutableRenderParameters object return by this method is mutable."
             */
            renderParams.setValue("tr1", "true");
         } else if (action.equals(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE)) {
            /*
             * TestCase:
             * V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode
             */
            /*
             * Details:
             * "Sets the portlet mode of a portlet to the given portlet mode."
             */
            actionResponse.setPortletMode(PortletMode.HELP);
         } else if (action.equals(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE2)) {
            /*
             * TestCase:
             * V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode2
             */
            /*
             * Details:
             * "A custom portlet mode declared in deployment descriptor could be set."
             */
            actionResponse.setPortletMode(new PortletMode("custom1"));
            renderParams.setValue("tr_setPortlet2", "true");
         } else if (action.equals(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE3)) {
            /*
             * TestCase:
             * V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode3
             */
            /*
             * Details:
             * "Not more than one portlet mode can be set. If more than one portlet mode is set, only the last one set is valid."
             */
            actionResponse.setPortletMode(PortletMode.EDIT);
            actionResponse.setPortletMode(PortletMode.HELP);
         } else if (action.equals(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE4)) {
            /*
             * TestCase:
             * V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode4
             */
            /*
             * Details:
             * "Throws PortletModeException if the portlet cannot switch to this mode."
             */
            TestResult result = tcd.getTestResultFailed(
                  V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE4);
            try {
               actionResponse.setPortletMode(PortletMode.UNDEFINED);
            } catch (PortletModeException e) {
               result.setTcSuccess(true);
               result.appendTcDetail(e.toString());
            }
            result.writeTo(writer);
         } else if (action.equals(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE5)) {
            /*
             * TestCase:
             * V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode5
             */
            /*
             * Details:
             * "Throws IllegalStateException if the method is invoked after sendRedirect has been called."
             */
            TestResult result = tcd.getTestResultFailed(
                  V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE5);
            try {
               RenderURL redirectURL = actionResponse.createRedirectURL(
                   MimeResponse.Copy.NONE);
               actionResponse.sendRedirect(redirectURL.toString());
               actionResponse.setPortletMode(PortletMode.UNDEFINED);
            } catch (IllegalStateException e) {
               result.setTcSuccess(true);
               result.appendTcDetail(e.toString());
            }
            result.writeTo(writer);
         } else if (action.equals(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE6)) {
            /*
             * TestCase:
             * V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode6
             */
            /*
             * Details:
             * "Throws IllegalArgumentException if the input parameter is null."
             */
            TestResult result = tcd.getTestResultFailed(
                  V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE6);
            try {
               actionResponse.setPortletMode(null);
            } catch (IllegalArgumentException e) {
               result.setTcSuccess(true);
               result.appendTcDetail(e.toString());
            }
            result.writeTo(writer);
         } else if (action.equals(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE)) {
            /*
             * TestCase:
             * V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState
             */
            /*
             * Details:
             * "Sets the window state of a portlet to the given window state."
             */
            actionResponse.setWindowState(WindowState.NORMAL);
            renderParams.setValue("tr_setWindow", "true");
         } else if (action.equals(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE2)) {
            /*
             * TestCase:
             * V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState2
             */
            /*
             * Details:
             * "A custom window state declared in deployment descriptor could be set."
             */
            renderParams.setValue("tr_setWindow2", "true");
         } else if (action.equals(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE3)) {
            /*
             * TestCase:
             * V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState3
             */
            /*
             * Details:
             * "Not more than one window state can be set. If more than one window state is set, only the last one set is valid."
             */
            actionResponse.setWindowState(WindowState.MAXIMIZED);
            actionResponse.setWindowState(WindowState.NORMAL);
            renderParams.setValue("tr_setWindow3", "true");
         } else if (action.equals(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE4)) {
            /*
             * TestCase:
             * V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState4
             */
            /*
             * Details:
             * "Throws WindowStateException if the portlet cannot switch to this state."
             */
            TestResult result = tcd.getTestResultFailed(
                  V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE4);
            try {
               actionResponse.setWindowState(WindowState.UNDEFINED);
            } catch (WindowStateException e) {
               result.setTcSuccess(true);
               result.appendTcDetail(e.toString());
            }
            result.writeTo(writer);
         } else if (action.equals(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE5)) {
            /*
             * TestCase:
             * V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState5
             */
            /*
             * Details:
             * "Throws IllegalStateException if the method is invoked after sendRedirect has been called."
             */
            TestResult result = tcd.getTestResultFailed(
                  V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE5);
            try {
               RenderURL redirectURL = actionResponse.createRedirectURL(MimeResponse.Copy.NONE);
               actionResponse.sendRedirect(redirectURL.toString());
               actionResponse.setWindowState(WindowState.UNDEFINED);
            } catch (IllegalStateException e) {
               result.setTcSuccess(true);
               result.appendTcDetail(e.toString());
            }
            result.writeTo(writer);
         } else if (action.equals(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE6)) {
            /*
             * TestCase:
             * V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState6
             */
            /*
             * Details:
             * "Throws IllegalArgumentException if the input parameter is null."
             */
            TestResult result = tcd.getTestResultFailed(
                  V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE6);
            try {
               actionResponse.setWindowState(null);
            } catch (IllegalArgumentException e) {
               result.setTcSuccess(true);
               result.appendTcDetail(e.toString());
            }
            result.writeTo(writer);
         }
      }

      PortletSession ps = actionRequest.getPortletSession();
      ps.setAttribute(
            Constants.RESULT_ATTR_PREFIX
                  + "RenderStateTests_SPEC2_12_MutableRenderState",
            writer.toString());

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      RenderParameters renderParams = portletReq.getRenderParameters();

      /*
       * TestCase:
       * V3RenderStateTests_SPEC2_12_MutableRenderState_getRenderParameters
       */
      /*
       * Details:
       * "Returns an MutableRenderParameters object representing the private and public render parameters."
       */
      {
         ActionURL actionURL = portletResp.createActionURL();
         MutableRenderParameters mutableRenderParams = actionURL
               .getRenderParameters();
         mutableRenderParams.setValue("tr0_private", "true");
         mutableRenderParams.setValue("tr0_public", "true");
         TestButton tb = new TestButton(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_GETRENDERPARAMETERS,
               actionURL);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V3RenderStateTests_SPEC2_12_MutableRenderState_getRenderParameters2
       */
      /*
       * Details:
       * "The MutableRenderParameters object return by this method is mutable."
       */
      if (renderParams.getValue("tr1") != null
            && renderParams.getValue("tr1").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_GETRENDERPARAMETERS2);
         result.setTcSuccess(true);
         result.writeTo(writer);
      } else {
         ActionURL actionURL = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_GETRENDERPARAMETERS2,
               actionURL);
         tb.writeTo(writer);
      }

      /*
       * TestCase: V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode
       */
      /*
       * Details:
       * "Sets the portlet mode of a portlet to the given portlet mode."
       */
      if (portletReq.getPortletMode().equals(PortletMode.HELP)) {
         TestResult result = tcd.getTestResultFailed(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE);
         result.setTcSuccess(true);
         result.writeTo(writer);
      } else {
         ActionURL actionURL = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE,
               actionURL);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode2
       */
      /*
       * Details:
       * "A custom portlet mode declared in deployment descriptor could be set."
       */
      if (renderParams.getValue("tr_setPortlet2") == null) {
         ActionURL actionURL = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE2,
               actionURL);
         tb.writeTo(writer);
      } else {
         super.render(portletReq, portletResp);
      }

      /*
       * TestCase:
       * V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode3
       */
      /*
       * Details:
       * "Not more than one portlet mode can be set. If more than one portlet mode is set, only the last one set is valid."
       */
      if (portletReq.getPortletMode().equals(PortletMode.HELP)) {
         TestResult result = tcd.getTestResultFailed(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE3);
         result.setTcSuccess(true);
         result.writeTo(writer);
      } else {
         ActionURL actionURL = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE3,
               actionURL);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode4
       */
      /*
       * Details:
       * "Throws PortletModeException if the portlet cannot switch to this mode."
       */
      {
         ActionURL actionURL = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE4,
               actionURL);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode5
       */
      /*
       * Details:
       * "Throws IllegalStateException if the method is invoked after sendRedirect has been called."
       */
      {
         ActionURL actionURL = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE5,
               actionURL);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode6
       */
      /*
       * Details:
       * "Throws IllegalArgumentException if the input parameter is null."
       */
      {
         ActionURL actionURL = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE6,
               actionURL);
         tb.writeTo(writer);
      }

      /*
       * TestCase: V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState
       */
      /*
       * Details:
       * "Sets the window state of a portlet to the given window state."
       */
      if (renderParams.getValue("tr_setWindow") != null
            && renderParams.getValue("tr_setWindow").equals("true")
            && portletReq.getWindowState().equals(WindowState.NORMAL)) {
         TestResult result = tcd.getTestResultFailed(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE);
         result.setTcSuccess(true);
         result.writeTo(writer);
      } else {
         ActionURL actionURL = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE,
               actionURL);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState2
       */
      /*
       * Details:
       * "A custom window state declared in deployment descriptor could be set."
       */
      if (renderParams.getValue("tr_setWindow2") == null) {
         ActionURL actionURL = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE2,
               actionURL);
         tb.writeTo(writer);
      } else {
         TestResult result = tcd.getTestResultFailed(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE2);
         result.setTcSuccess(true);
         result.appendTcDetail("Cannot be tested as it is implementation specific");
         result.writeTo(writer);
      }

      /*
       * TestCase:
       * V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState3
       */
      /*
       * Details:
       * "Not more than one window state can be set. If more than one window state is set, only the last one set is valid."
       */
      if (renderParams.getValue("tr_setWindow3") != null
            && renderParams.getValue("tr_setWindow3").equals("true")
            && portletReq.getWindowState().equals(WindowState.NORMAL)) {
         TestResult result = tcd.getTestResultFailed(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE3);
         result.setTcSuccess(true);
         result.writeTo(writer);
      } else {
         ActionURL actionURL = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE3,
               actionURL);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState4
       */
      /*
       * Details:
       * "Throws WindowStateException if the portlet cannot switch to this state."
       */
      {
         ActionURL actionURL = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE4,
               actionURL);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState5
       */
      /*
       * Details:
       * "Throws IllegalStateException if the method is invoked after sendRedirect has been called."
       */
      {
         ActionURL actionURL = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE5,
               actionURL);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState6
       */
      /*
       * Details:
       * "Throws IllegalArgumentException if the input parameter is null."
       */
      {
         ActionURL actionURL = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE6,
               actionURL);
         tb.writeTo(writer);
      }
      
      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(Constants.RESULT_ATTR_PREFIX
            + "RenderStateTests_SPEC2_12_MutableRenderState");
      
      if (msg != null && msg.length() > 0) {
         writer.write("<p>" + msg + "</p>\n");
      }
      
      ps.removeAttribute(Constants.RESULT_ATTR_PREFIX
            + "RenderStateTests_SPEC2_12_MutableRenderState");

   }

   @RenderMode(name = "custom1")
   public void doView(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();

      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /*
       * TestCase:
       * V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode2
       */
      /*
       * Details:
       * "A custom portlet mode declared in deployment descriptor could be set."
       */
      RenderParameters renderParams = portletReq.getRenderParameters();
      if (renderParams.getValue("tr_setPortlet2") != null
            && renderParams.getValue("tr_setPortlet2").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE2);
         if (portletReq.getPortletMode().equals(new PortletMode("custom1"))) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail(
                  "Failed because portlet mode is not CUSTOM1 but "
                        + portletReq.getPortletMode().toString());
         }
         result.writeTo(writer);
      }
 
   }

}
