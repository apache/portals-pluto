/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package javax.portlet.tck.portlets;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES0;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES12;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES13;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5A;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES8;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_CONTAINERRUNTIMEOPTIONS1;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.ResourceLink;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestLink;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupButton;
import javax.portlet.tck.constants.Constants;
import javax.xml.namespace.QName;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined in the
 * /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate the test case names
 * defined in the additionalTCs.xml file into the complete list of test case names for execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will initiate the
 * events, but not process them. The processing is done in the companion portlet
 * AddlEnvironmentTests_SPEC2_10_ContextOptions_event
 * 
 */
public class AddlEnvironmentTests_SPEC2_10_ContextOptions implements Portlet, ResourceServingPortlet, EventPortlet {

   private static final String ATTRIB_NAME   = "attribName";

   private boolean             isActionScopedRequestAttributesSupported;
   private PortletConfig       portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;

      List<String> supportedContainerRuntimeOptions = Collections.list(config.getPortletContext().getContainerRuntimeOptions());
      isActionScopedRequestAttributesSupported = supportedContainerRuntimeOptions.contains("javax.portlet.actionScopedRequestAttributes");
   }

   @Override
   public void destroy() {
   }

   @SuppressWarnings("deprecation")
   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp) throws PortletException, IOException {

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      String tc = (String) portletReq.getEvent().getValue();
      portletResp.setRenderParameter(Constants.BUTTON_PARAM_NAME, tc);

      if (tc != null) {
         if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4)) {
            TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4);

            if (isActionScopedRequestAttributesSupported) {
               String[] scope = portletReq.getParameterValues(PortletRequest.ACTION_SCOPE_ID);
               result.appendTcDetail("Action scope ID: " + Arrays.toString(scope));

               String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
               if (attrib != null && attrib.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4)) {
                  result.setTcSuccess(true);
               } else {
                  result.appendTcDetail("Attribute was: " + attrib);
               }
            }
            else {
			   result.appendTcDetail("Portlet container does not support javax.portlet.actionScopedRequestAttributes.");
			   result.setTcSuccess(true);
			}

            portletReq.getPortletSession().setAttribute(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4, result);
         }

         if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES6)) {
            portletReq.setAttribute(ATTRIB_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES6);
         }

         if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9)) {
            // by not setting any attribute, we show that a new scope was created.
            portletResp.setRenderParameter(Constants.BUTTON_PARAM_NAME, tc);
         }
      }
   }

   @SuppressWarnings("deprecation")
   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {

      String tc = portletReq.getParameter(Constants.BUTTON_PARAM_NAME);
      portletResp.setRenderParameter(Constants.BUTTON_PARAM_NAME, tc);
      if (tc != null) {

         if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES2)) {
            portletReq.setAttribute(ATTRIB_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES2);
         }

         else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5)) {
            portletReq.setAttribute(ATTRIB_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5);
         }

         else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5A)) {
            portletReq.setAttribute(ATTRIB_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5A);
         }

         else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11 + Constants.SETUP_ID)) {
            portletReq.setAttribute(ATTRIB_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11);
         }

         else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11)) {
            // intentionally left blank
         }

         else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES12 + Constants.SETUP_ID)) {
            portletReq.setAttribute(ATTRIB_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES12);
         }

         else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES7 + Constants.SETUP_ID)) {
            portletReq.setAttribute(ATTRIB_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES7);
         }

         else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES7)) {
            // intentionally left blank
         }

         else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9 + Constants.SETUP_ID)) {
            portletReq.setAttribute(ATTRIB_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9);
         }

         else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9)) {
            portletReq.setAttribute(ATTRIB_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9);
         }

         else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES0 + Constants.SETUP_ID)) {
            portletReq.setAttribute(ATTRIB_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES0);
         }

         else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES0)) {
            // intentionally left blank
         }

         else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES8 + Constants.SETUP_ID)) {
            portletReq.setAttribute(ATTRIB_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES8);
         }

         else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4)) {
            portletReq.setAttribute(ATTRIB_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4);
            QName qn = new QName(Constants.TCKNAMESPACE, this.getClass().getSimpleName());
            portletResp.setEvent(qn, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4);
         }

         else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES6)) {
            portletReq.removeAttribute(ATTRIB_NAME);
            QName qn = new QName(Constants.TCKNAMESPACE, this.getClass().getSimpleName());
            portletResp.setEvent(qn, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES6);
         }
      }

   }

   @SuppressWarnings("deprecation")
   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp) throws PortletException, IOException {

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
      PrintWriter writer = portletResp.getWriter();

      String tc = (String) portletReq.getParameter(Constants.BUTTON_PARAM_NAME);
      if (tc != null) {
         
         if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5A)) {
            TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5A);

            if (isActionScopedRequestAttributesSupported) {
               String[] scope = portletReq.getParameterValues(PortletRequest.ACTION_SCOPE_ID);
               result.appendTcDetail("Action scope ID: " + ((scope == null) ? "null" : Arrays.toString(scope)));

               String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
               if (attrib != null && attrib.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5A)) {
                  result.setTcSuccess(true);
               } else {
                  result.appendTcDetail("Attribute was: " + attrib);
               }
            }
            else {
			   result.appendTcDetail("Portlet container does not support javax.portlet.actionScopedRequestAttributes.");
			   result.setTcSuccess(true);
			}
            result.writeTo(writer);
         }

         else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES12)) {
            TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES12);

            if (isActionScopedRequestAttributesSupported) {
               String[] scope = portletReq.getParameterValues(PortletRequest.ACTION_SCOPE_ID);
               result.appendTcDetail("Action scope ID: " + ((scope == null) ? "null" : Arrays.toString(scope)));

               String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
               if (attrib == null && scope == null) {
                  result.setTcSuccess(true);
               } else {
                  StringBuilder txt = new StringBuilder(128);
                  txt.append("Attribute was: ").append((attrib == null) ? "null" : attrib);
                  txt.append(", action scope ID was: ").append((scope == null) ? "null" : Arrays.toString(scope));
                  result.appendTcDetail(txt.toString());
               }
            }
			else {
			   result.appendTcDetail("Portlet container does not support javax.portlet.actionScopedRequestAttributes.");
			   result.setTcSuccess(true);
			}
            result.writeTo(writer);
         }

      }

   }

   @SuppressWarnings("deprecation")
   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_ContextOptions_containerRuntimeOptions1 */
      /* Details: "The getContainerRuntimeOptions method returns an */
      /* enumeration of type String containing the keys of all container */
      /* runtime options that the current portlet container supports." */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_CONTAINERRUNTIMEOPTIONS1);
      if (isActionScopedRequestAttributesSupported) {
         Enumeration<String> runtimeOptions = portletConfig.getPortletContext().getContainerRuntimeOptions();
         if (runtimeOptions != null && runtimeOptions.hasMoreElements()) {
            tr0.setTcSuccess(true);
         }
         else {
            tr0.appendTcDetail("Failed because getContainerRuntimeOptions() returned null or no elements");
         }
      }
      else {
         tr0.appendTcDetail("Portlet container does not support javax.portlet.actionScopedRequestAttributes.");
         tr0.setTcSuccess(true);
      }
      tr0.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes1 */
      /* Details: "The container runtime option */
      /* \"javax.portlet.actionScopedRequestAttributes\" must be supported */
      /* by the portlet container" */
      {
         TestResult tr1 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES1);
         if (isActionScopedRequestAttributesSupported) {
            Enumeration<String> rtEnum = portletConfig.getPortletContext().getContainerRuntimeOptions();
            if (rtEnum == null) {
               tr1.appendTcDetail("Supported Container runtime options is null.");
            }
            else {
               List<String> rtlist = Collections.list(rtEnum);
               if (rtlist.contains("javax.portlet.actionScopedRequestAttributes")) {
                  tr1.setTcSuccess(true);
               }
               else {
                  StringBuilder txt = new StringBuilder(128);
                  txt.append("javax.portlet.actionScopedRequestAttributes is not supported.");
                  txt.append(" Supported options: ").append(rtlist.toString());
                  tr1.appendTcDetail(txt.toString());
               }
            }
         }
         else {
            tr1.appendTcDetail("Portlet container does not support javax.portlet.actionScopedRequestAttributes.");
            tr1.setTcSuccess(true);
         }
         tr1.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes13 */
      /* Details: "The actionScopedRequestAttributes option can be set to TRUE */
      {
         TestResult tr13 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES13);
         if (isActionScopedRequestAttributesSupported) {
            Map<String, String[]> options = portletConfig.getContainerRuntimeOptions();
            if (options == null) {
               tr13.appendTcDetail("Container runtime options from portletConfig is null.");
            }
            else {
               String[] vals = options.get("javax.portlet.actionScopedRequestAttributes");
               if (vals != null && vals.length > 0 && Boolean.parseBoolean(vals[0]) == true) {
                  tr13.setTcSuccess(true);
               }
               else {
                  StringBuilder txt = new StringBuilder(128);
                  txt.append("javax.portlet.actionScopedRequestAttributes option is not supported.");
                  txt.append(" Values for option: ").append((vals == null) ? "null" : Arrays.toString(vals));
                  tr13.appendTcDetail(txt.toString());
               }
            }
         }
         else {
            tr13.appendTcDetail("Portlet container does not support javax.portlet.actionScopedRequestAttributes.");
            tr13.setTcSuccess(true);
         }
         tr13.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes2 */
      /* Details: "If the actionScopedRequestAttributes option is set to */
      /* TRUE, request attributes that are set in an action persist until a */
      /* new action occurs" */
      {
         String tc = portletReq.getParameter(Constants.BUTTON_PARAM_NAME);
         if (tc != null && tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES2)) {
            TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES2);
            if (isActionScopedRequestAttributesSupported) {
               String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
               if (attrib != null && attrib.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES2)) {
                  result.setTcSuccess(true);
               }
               else {
                  result.appendTcDetail("Attribute was: " + attrib);
               }
            }
            else {
               result.appendTcDetail("Portlet container does not support javax.portlet.actionScopedRequestAttributes.");
               result.setTcSuccess(true);
            }
            result.writeTo(writer);
         }
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes3 */
      /* Details: "If the option is set to TRUE and an attribute is set */
      /* during an action request, the portlet container sets a render */
      /* parameter with the name PortletRequest.ACTION_SCOPE_ID */
      /* (\"javax.portlet.as\")" */
      {
         String tc = portletReq.getParameter(Constants.BUTTON_PARAM_NAME);
         if (tc != null && tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES3)) {
            TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES3);
            if (isActionScopedRequestAttributesSupported) {
               String[] scope = portletReq.getParameterValues(PortletRequest.ACTION_SCOPE_ID);
               if (scope != null) {
                  result.appendTcDetail("Action scope ID: " + Arrays.toString(scope));
                  result.setTcSuccess(true);
               }
               else {
                  result.appendTcDetail("Scope render parameter was null.");
               }
            }
            else {
               result.appendTcDetail("Portlet container does not support javax.portlet.actionScopedRequestAttributes.");
               result.setTcSuccess(true);
            }
            result.writeTo(writer);
         }
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes4 */
      /* Details: "If the option is set to TRUE and an attribute is set */
      /* during an action request, the attribute can be accessed in an */
      /* event request that was initiated by the same action request" */
      {
         String tc = portletReq.getParameter(Constants.BUTTON_PARAM_NAME);
         if (tc != null && tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4)) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult result = (TestResult) ps.getAttribute(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4);
            ps.removeAttribute(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4);
            if (result == null) {
               result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4);
               result.appendTcDetail("Could not obtain test result.");
            }
            result.writeTo(writer);
         }
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes5 */
      /* Details: "If the option is set to TRUE and an attribute is set */
      /* during an action request, the attribute can be accessed in a */
      /* subsequent render request" */
      {
         String tc = portletReq.getParameter(Constants.BUTTON_PARAM_NAME);
         if (tc != null && tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5)) {
            TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5);
            if (isActionScopedRequestAttributesSupported) {
               String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
               if (attrib != null && attrib.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5)) {
                  result.setTcSuccess(true);
               }
               else {
                  result.appendTcDetail("Attribute was: " + attrib);
               }
            }
            else {
               result.appendTcDetail("Portlet container does not support javax.portlet.actionScopedRequestAttributes.");
               result.setTcSuccess(true);
            }
            result.writeTo(writer);
         }
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestATTRIBUTES5A */
      /* Details: "If the option is set to TRUE and an attribute is set */
      /* during an action request, the attribute can be accessed in a */
      /* subsequent resource request" */
      {
         String tc = portletReq.getParameter(Constants.BUTTON_PARAM_NAME);
         if (tc != null && tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5A)) {
            ResourceURL resurl = portletResp.createResourceURL();
            ResourceLink rl = new ResourceLink(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5A, resurl);
            rl.writeResourceFetcherImmediate(writer);
         }
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5A, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes6 */
      /* Details: "If the option is set to TRUE, a request attribute set */
      /* during an event request is persisted in the same manner as an */
      /* attribute set during action processing" */
      {
         String tc = portletReq.getParameter(Constants.BUTTON_PARAM_NAME);
         if (tc != null && tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES6)) {
            TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES6);
            if (isActionScopedRequestAttributesSupported) {
               String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
               if (attrib != null && attrib.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES6)) {
                  result.setTcSuccess(true);
               }
               else {
                  result.appendTcDetail("Attribute was: " + attrib);
               }
            }
            else {
               result.appendTcDetail("Portlet container does not support javax.portlet.actionScopedRequestAttributes.");
               result.setTcSuccess(true);
            }
            result.writeTo(writer);
         }
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES6, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes7 */
      /* Details: "If the option is set to TRUE, receiving an action starts */
      /* a new action scope with a new scope ID, all previous attributes */
      /* are no longer accessible, new attributes can be stored" */
      {
         String tc = portletReq.getParameter(Constants.BUTTON_PARAM_NAME);
         if (tc != null) {
            if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES7 + Constants.SETUP_ID)) {
               String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
               if (isActionScopedRequestAttributesSupported &&
                   (attrib == null || !attrib.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES7))) {
                  
                  TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES7);
                  result.appendTcDetail("Attribute was: " + attrib);
                  result.writeTo(writer);
                  
               } else {

                  PortletURL aurl = portletResp.createActionURL();
                  TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES7, aurl);
                  tb.writeTo(writer);

               }

            } else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES7)) {

               TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES7);
               if (isActionScopedRequestAttributesSupported) {
                  String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
                  if (attrib == null) {
                     result.setTcSuccess(true);
                  }
                  else {
                     result.appendTcDetail("Attribute was: " + attrib);
                  }
               }
               else {
                  result.appendTcDetail("Portlet container does not support javax.portlet.actionScopedRequestAttributes.");
                  result.setTcSuccess(true);
               }
               result.writeTo(writer);

            }
         }
         
         if (tc == null || !tc.startsWith(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES7)) {

            PortletURL aurl = portletResp.createActionURL();
            TestSetupButton tb = new TestSetupButton(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES7, aurl);
            tb.writeTo(writer);

         }
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes8 */
      /* Details: "If the option is set to TRUE, receiving a render without */
      /* an existing scope ID starts a new action scope with a new scope */
      /* ID, all previous attributes are no longer accessible, new */
      /* attributes can be stored" */
      {
         String tc = portletReq.getParameter(Constants.BUTTON_PARAM_NAME);
         if (tc != null) {
            if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES8 + Constants.SETUP_ID)) {
               String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
               if (isActionScopedRequestAttributesSupported &&
                   (attrib == null || !attrib.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES8))) {
                  
                  TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES8);
                  result.appendTcDetail("Attribute was: " + attrib);
                  result.writeTo(writer);
                  
               } else {

                  PortletURL rurl = portletResp.createRenderURL();
                  rurl.setParameter(Constants.BUTTON_PARAM_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES8);
                  rurl.setParameter(PortletRequest.ACTION_SCOPE_ID, (String)null);
                  TestLink link = new TestLink(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES8, rurl);
                  link.writeTo(writer);

               }

            } else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES8)) {

               TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES8);
               if (isActionScopedRequestAttributesSupported) {
                  String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
                  if (attrib == null) {
                     result.setTcSuccess(true);
                  }
                  else {
                     result.appendTcDetail("Attribute was: " + attrib);
                  }
               }
               else {
                  result.appendTcDetail("Portlet container does not support javax.portlet.actionScopedRequestAttributes.");
                  result.setTcSuccess(true);
               }
               result.writeTo(writer);

            }
         }
         
         if (tc == null || !tc.startsWith(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES8)) {

            PortletURL aurl = portletResp.createActionURL();
            TestSetupButton tb = new TestSetupButton(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES8, aurl);
            tb.writeTo(writer);

         }
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes9 */
      /* Details: "If the option is set to TRUE, receiving an event without */
      /* an existing scope ID starts a new action scope with a new scope */
      /* ID, all previous attributes are no longer accessible, new */
      /* attributes can be stored" */
      {
         String tc = portletReq.getParameter(Constants.BUTTON_PARAM_NAME);
         if (tc != null) {
            if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9 + Constants.SETUP_ID)) {
               String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
               if (isActionScopedRequestAttributesSupported &&
                   (attrib == null || !attrib.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9))) {
                  
                  TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9);
                  result.appendTcDetail("Attribute was: " + attrib);
                  result.writeTo(writer);
                  
               }

            } else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9)) {

               TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9);

               if (isActionScopedRequestAttributesSupported) {
                  String[] scope = portletReq.getParameterValues(PortletRequest.ACTION_SCOPE_ID);
                  result.appendTcDetail("Action scope ID: " + ((scope == null) ? "null" : Arrays.toString(scope)));

                  String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
                  if (attrib == null) {
                     result.setTcSuccess(true);
                  }
                  else {
                     result.appendTcDetail("Attribute was: " + attrib);
                  }
               }
               else {
                  result.appendTcDetail("Portlet container does not support javax.portlet.actionScopedRequestAttributes.");
                  result.setTcSuccess(true);
               }
               result.writeTo(writer);

            }
         }

         PortletURL aurl = portletResp.createActionURL();
         TestSetupButton tb = new TestSetupButton(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes0 */
      /* Details: "The parameter PortletRequest.ACTION_SCOPE_ID */
      /* (\"javax.portlet.as\") can be removed from an action URL */
      {
         String tc = portletReq.getParameter(Constants.BUTTON_PARAM_NAME);
         if (tc != null) {
            if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES0 + Constants.SETUP_ID)) {
               String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
               if (isActionScopedRequestAttributesSupported &&
                   (attrib == null || !attrib.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES0))) {
                  
                  TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES0);
                  result.appendTcDetail("Attribute was: " + attrib);
                  result.writeTo(writer);
                  
               } else {

                  PortletURL aurl = portletResp.createActionURL();
                  aurl.setParameter(PortletRequest.ACTION_SCOPE_ID, (String)null);
                  TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES0, aurl);
                  tb.writeTo(writer);

               }

            } else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES0)) {

               TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES0);

               if (isActionScopedRequestAttributesSupported) {
                  String[] scope = portletReq.getParameterValues(PortletRequest.ACTION_SCOPE_ID);
                  result.appendTcDetail("Action scope ID: " + ((scope == null) ? "null" : Arrays.toString(scope)));

                  String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
                  if (attrib == null) {
                     result.setTcSuccess(true);
                  }
                  else {
                     result.appendTcDetail("Attribute was: " + attrib);
                  }
               }
               else {
                  result.appendTcDetail("Portlet container does not support javax.portlet.actionScopedRequestAttributes.");
                  result.setTcSuccess(true);
               }
               result.writeTo(writer);

            }
         }
         
         if (tc == null || !tc.startsWith(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES0)) {

            PortletURL aurl = portletResp.createActionURL();
            TestSetupButton tb = new TestSetupButton(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES0, aurl);
            tb.writeTo(writer);

         }
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes11 */
      /* Details: "The render parameter PortletRequest.ACTION_SCOPE_ID */
      /* (\"javax.portlet.as\") can be removed from a render URL */
      {
         String tc = portletReq.getParameter(Constants.BUTTON_PARAM_NAME);
         if (tc != null) {
            if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11 + Constants.SETUP_ID)) {
               String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
               if (isActionScopedRequestAttributesSupported &&
                   (attrib == null || !attrib.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11))) {
                  
                  TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11);
                  result.appendTcDetail("Attribute was: " + attrib);
                  result.writeTo(writer);
                  
               } else {

                  PortletURL rurl = portletResp.createRenderURL();
                  rurl.setParameter(Constants.BUTTON_PARAM_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11);
                  rurl.setParameter(PortletRequest.ACTION_SCOPE_ID, (String)null);
                  TestLink link = new TestLink(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11, rurl);
                  link.writeTo(writer);

               }

            } else if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11)) {

               TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11);
               if (isActionScopedRequestAttributesSupported) {
                  String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
                  if (attrib == null) {
                     result.setTcSuccess(true);
                  }
                  else {
                     result.appendTcDetail("Attribute was: " + attrib);
                  }
               }
               else {
                  result.appendTcDetail("Portlet container does not support javax.portlet.actionScopedRequestAttributes.");
                  result.setTcSuccess(true);
               }
               result.writeTo(writer);

            }
         }
         
         if (tc == null || !tc.startsWith(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11)) {

            PortletURL aurl = portletResp.createActionURL();
            TestSetupButton tb = new TestSetupButton(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11, aurl);
            tb.writeTo(writer);

         }
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes12 */
      /* Details: "The render parameter PortletRequest.ACTION_SCOPE_ID */
      /* (\"javax.portlet.as\") can be removed from a ResourceURL */
      {
         String tc = portletReq.getParameter(Constants.BUTTON_PARAM_NAME);
         if (tc != null) {
            if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES12 + Constants.SETUP_ID)) {
               String attrib = (String) portletReq.getAttribute(ATTRIB_NAME);
               if (isActionScopedRequestAttributesSupported &&
                   (attrib == null || !attrib.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES12))) {
                  
                  TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES12);
                  result.appendTcDetail("Attribute was: " + attrib);
                  result.writeTo(writer);
                  
               } else {

                  ResourceURL rurl = portletResp.createResourceURL();
                  rurl.setParameter(Constants.BUTTON_PARAM_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES12);
                  rurl.setParameter(PortletRequest.ACTION_SCOPE_ID, (String)null);
                  ResourceLink link = new ResourceLink(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES12, rurl);
                  link.writeResourceFetcherImmediate(writer);

               }

            }
         }
         
         if (tc == null || !tc.startsWith(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES12)) {

            PortletURL aurl = portletResp.createActionURL();
            TestSetupButton tb = new TestSetupButton(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES12, aurl);
            tb.writeTo(writer);

         }
      }

   }

}
