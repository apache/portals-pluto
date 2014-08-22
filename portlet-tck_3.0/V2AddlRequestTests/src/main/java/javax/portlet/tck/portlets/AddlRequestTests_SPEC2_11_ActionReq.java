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
 * portlet AddlRequestTests_SPEC2_11_ActionReq_event
 *
 */
public class AddlRequestTests_SPEC2_11_ActionReq implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlRequestTests_SPEC2_11_ActionReq.class.getName();
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

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_contentType1         */
      /* Details: "The getResponseContentType method returns a String         */
      /* representing the default content type the portlet container          */
      /* assumes for the output"                                              */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_CONTENTTYPE1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_contentType2         */
      /* Details: "The getResponseContentTypes method returns an              */
      /* Enumeration of String elements representing the acceptable content   */
      /* types for the output in order of preference"                         */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_CONTENTTYPE2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_contentType3         */
      /* Details: "The first element of the Enumeration returned by the       */
      /* getResponseContentTypes method must equal the value returned by      */
      /* the getResponseContentType method"                                   */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_CONTENTTYPE3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_contentType4         */
      /* Details: "If a portlet defines support for all content types using   */
      /* a wildcard and the portlet container supports all content types,     */
      /* the getResponseContentType may return the wildcard"                  */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_CONTENTTYPE4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_contentType5         */
      /* Details: "If a portlet defines support for all content types using   */
      /* a wildcard and the portlet container supports all content types,     */
      /* the getResponseContentType may return the preferred content type"    */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_CONTENTTYPE5);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_windowId4            */
      /* Details: "The string returned by getWindowID method must be the      */
      /* same ID used for scoping portlet-scope session attributes"           */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_WINDOWID4);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_contentType6         */
      /* Details: "Within the processAction method, the content type must     */
      /* include only the MIME type, not the character set"                   */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_CONTENTTYPE6);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_contentType7         */
      /* Details: "Within the processAction method, the                       */
      /* getResponseContentTypes method must return only the content types    */
      /* supported by the current portlet mode"                               */
      TestResult tr7 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_CONTENTTYPE7);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_ActionReq",
                   writer.toString(), APPLICATION_SCOPE);
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

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_ActionReq", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_ActionReq", APPLICATION_SCOPE);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_contentType1         */
      /* Details: "The getResponseContentType method returns a String         */
      /* representing the default content type the portlet container          */
      /* assumes for the output"                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_ActionReq_contentType1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_contentType2         */
      /* Details: "The getResponseContentTypes method returns an              */
      /* Enumeration of String elements representing the acceptable content   */
      /* types for the output in order of preference"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_ActionReq_contentType2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_contentType3         */
      /* Details: "The first element of the Enumeration returned by the       */
      /* getResponseContentTypes method must equal the value returned by      */
      /* the getResponseContentType method"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_ActionReq_contentType3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_contentType4         */
      /* Details: "If a portlet defines support for all content types using   */
      /* a wildcard and the portlet container supports all content types,     */
      /* the getResponseContentType may return the wildcard"                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_ActionReq_contentType4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_contentType5         */
      /* Details: "If a portlet defines support for all content types using   */
      /* a wildcard and the portlet container supports all content types,     */
      /* the getResponseContentType may return the preferred content type"    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_ActionReq_contentType5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_windowId4            */
      /* Details: "The string returned by getWindowID method must be the      */
      /* same ID used for scoping portlet-scope session attributes"           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_ActionReq_windowId4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_contentType6         */
      /* Details: "Within the processAction method, the content type must     */
      /* include only the MIME type, not the character set"                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_ActionReq_contentType6", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_ActionReq_contentType7         */
      /* Details: "Within the processAction method, the                       */
      /* getResponseContentTypes method must return only the content types    */
      /* supported by the current portlet mode"                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_ActionReq_contentType7", aurl);
         tb.writeTo(writer);
      }

   }

}
