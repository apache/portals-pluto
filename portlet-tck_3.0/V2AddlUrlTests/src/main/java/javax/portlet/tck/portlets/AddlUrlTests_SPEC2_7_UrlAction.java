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
 * portlet AddlUrlTests_SPEC2_7_UrlAction_event
 *
 */
public class AddlUrlTests_SPEC2_7_UrlAction implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlUrlTests_SPEC2_7_UrlAction.class.getName();
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

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL1                */
      /* Details: "When a action URL is triggered, the processAction method   */
      /* must be invoked"                                                     */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLURLTESTS_SPEC2_7_URLACTION_ACTIONURL1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL2                */
      /* Details: "When action parameters are set on a action URL, those      */
      /* parameters must become action parameters of the request resulting    */
      /* from triggering the actionURL"                                       */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLURLTESTS_SPEC2_7_URLACTION_ACTIONURL2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL3                */
      /* Details: "When action parameters are set on a action URL, those      */
      /* parameters must become action parameters of the request resulting    */
      /* from triggering the actionURL"                                       */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLURLTESTS_SPEC2_7_URLACTION_ACTIONURL3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL4                */
      /* Details: "Action parameters can be set on the action URL through     */
      /* the setParameter(String, String) method"                             */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLURLTESTS_SPEC2_7_URLACTION_ACTIONURL4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL5                */
      /* Details: "Action parameters can be set on the action URL through     */
      /* the setParameter(String, String[]) method"                           */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLURLTESTS_SPEC2_7_URLACTION_ACTIONURL5);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL6                */
      /* Details: "Action parameters can be set on the action URL through     */
      /* the setParameterMap(Map<String, String[]>) method"                   */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLURLTESTS_SPEC2_7_URLACTION_ACTIONURL6);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL7                */
      /* Details: "If a parameter with an existing name is set through one    */
      /* of the setParameter methods, the existing value is repalced with     */
      /* the new value"                                                       */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLURLTESTS_SPEC2_7_URLACTION_ACTIONURL7);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL8                */
      /* Details: "When an action URL is created, render parameters from      */
      /* the current request are not automatically copied to the new action   */
      /* URL"                                                                 */
      TestResult tr7 = tcd.getTestResultFailed(V2ADDLURLTESTS_SPEC2_7_URLACTION_ACTIONURL8);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "AddlUrlTests_SPEC2_7_UrlAction",
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
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "AddlUrlTests_SPEC2_7_UrlAction", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "AddlUrlTests_SPEC2_7_UrlAction", APPLICATION_SCOPE);
      }

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL1                */
      /* Details: "When a action URL is triggered, the processAction method   */
      /* must be invoked"                                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlUrlTests_SPEC2_7_UrlAction_actionURL1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL2                */
      /* Details: "When action parameters are set on a action URL, those      */
      /* parameters must become action parameters of the request resulting    */
      /* from triggering the actionURL"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlUrlTests_SPEC2_7_UrlAction_actionURL2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL3                */
      /* Details: "When action parameters are set on a action URL, those      */
      /* parameters must become action parameters of the request resulting    */
      /* from triggering the actionURL"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlUrlTests_SPEC2_7_UrlAction_actionURL3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL4                */
      /* Details: "Action parameters can be set on the action URL through     */
      /* the setParameter(String, String) method"                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlUrlTests_SPEC2_7_UrlAction_actionURL4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL5                */
      /* Details: "Action parameters can be set on the action URL through     */
      /* the setParameter(String, String[]) method"                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlUrlTests_SPEC2_7_UrlAction_actionURL5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL6                */
      /* Details: "Action parameters can be set on the action URL through     */
      /* the setParameterMap(Map<String, String[]>) method"                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlUrlTests_SPEC2_7_UrlAction_actionURL6", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL7                */
      /* Details: "If a parameter with an existing name is set through one    */
      /* of the setParameter methods, the existing value is repalced with     */
      /* the new value"                                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlUrlTests_SPEC2_7_UrlAction_actionURL7", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlUrlTests_SPEC2_7_UrlAction_actionURL8                */
      /* Details: "When an action URL is created, render parameters from      */
      /* the current request are not automatically copied to the new action   */
      /* URL"                                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlUrlTests_SPEC2_7_UrlAction_actionURL8", aurl);
         tb.writeTo(writer);
      }

   }

}
