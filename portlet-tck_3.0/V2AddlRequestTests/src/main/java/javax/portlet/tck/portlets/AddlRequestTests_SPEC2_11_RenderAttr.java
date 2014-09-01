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

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.xml.namespace.QName;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet AddlRequestTests_SPEC2_11_RenderAttr_event
 *
 */
public class AddlRequestTests_SPEC2_11_RenderAttr implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlRequestTests_SPEC2_11_RenderAttr.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2AddlRequestTests_SPEC2_11_RenderAttr_attributes1         */
      /* Details: "The portlet can access a map with user information         */
      /* attributes via the request attribute PortletRequest.USER_INFO"       */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_RenderAttr_attributes2         */
      /* Details: "The PortletRequest.CCPP_PROFILE request attribute must     */
      /* return a javax.ccpp.Profile based on the current portlet request"    */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_RenderAttr_attributes3         */
      /* Details: "If the portlet container runtime option                    */
      /* javax.portlet.renderHeaders is set to TRUE, the RENDER_PART          */
      /* attribute will be set when the render method is called"              */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_RenderAttr_attributes4         */
      /* Details: "If the portlet container runtime option                    */
      /* javax.portlet.renderHeaders is set to TRUE, render method will be    */
      /* called first with the RENDER_PART attribute set to                   */
      /* \"RENDER_HEADERS\""                                                  */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_RenderAttr_attributes5         */
      /* Details: "If the portlet container runtime option                    */
      /* javax.portlet.renderHeaders is set to TRUE, render method will be    */
      /* called a second time with the RENDER_PART attribute set to           */
      /* \"RENDER_MARKUP\""                                                   */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES5);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_RenderAttr_attributes8         */
      /* Details: "During render processing, the LIFECYCLE_PHASE              */
      /* (\"javax.portlet.lifecycle_phase\") attribute will contain the       */
      /* string \"RENDER_PHASE\""                                             */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES8);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

   }

}
