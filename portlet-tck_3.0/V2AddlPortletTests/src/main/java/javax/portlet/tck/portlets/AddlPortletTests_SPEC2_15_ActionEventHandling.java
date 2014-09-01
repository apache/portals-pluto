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
 * portlet AddlPortletTests_SPEC2_15_ActionEventHandling_event
 *
 */
public class AddlPortletTests_SPEC2_15_ActionEventHandling implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlPortletTests_SPEC2_15_ActionEventHandling.class.getName();
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

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction1 */
      /* Details: "The portlet can publish an event via the setEvent method   */
      /* in the processAction method"                                         */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction2 */
      /* Details: "The portlet can publish an event with its full Qname via   */
      /* the setEvent method in the processAction method"                     */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction3 */
      /* Details: "The portlet can publish an event with only the local       */
      /* part of the Qname via the setEvent method in the processAction       */
      /* method"                                                              */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction4 */
      /* Details: "If an event is published with only the local part of the   */
      /* Qname, the namespace must be the default namespace defined in the    */
      /* deployment descriptor"                                               */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction5 */
      /* Details: "If an event is published with only the local part of the   */
      /* Qname and no default namespace is defined in the deployment          */
      /* descriptor, the value javax.xml.XMLConstants.NULL_NS_URI must be     */
      /* used as the Qname namespace"                                         */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION5);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction6 */
      /* Details: "If an object is serializeable and has a valid JAXB         */
      /* binding or is a Java primitive type, it can be used as an event      */
      /* value"                                                               */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION6);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction7 */
      /* Details: "If a value is not serializeable, the setEvent method       */
      /* must throw an IllegalArgumentException"                              */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION7);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction8 */
      /* Details: "If a value does not have a valid JAXB binding and is not   */
      /* a Java primitve type, the setEvent method must throw an              */
      /* IllegalArgumentException"                                            */
      TestResult tr7 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION8);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction9 */
      /* Details: "The portlet can publish multiple events via the setEvent   */
      /* method in the processAction method"                                  */
      TestResult tr8 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION9);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_15_ActionEventHandling",
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
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_15_ActionEventHandling", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_15_ActionEventHandling", APPLICATION_SCOPE);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction1 */
      /* Details: "The portlet can publish an event via the setEvent method   */
      /* in the processAction method"                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction2 */
      /* Details: "The portlet can publish an event with its full Qname via   */
      /* the setEvent method in the processAction method"                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction3 */
      /* Details: "The portlet can publish an event with only the local       */
      /* part of the Qname via the setEvent method in the processAction       */
      /* method"                                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction4 */
      /* Details: "If an event is published with only the local part of the   */
      /* Qname, the namespace must be the default namespace defined in the    */
      /* deployment descriptor"                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction5 */
      /* Details: "If an event is published with only the local part of the   */
      /* Qname and no default namespace is defined in the deployment          */
      /* descriptor, the value javax.xml.XMLConstants.NULL_NS_URI must be     */
      /* used as the Qname namespace"                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction6 */
      /* Details: "If an object is serializeable and has a valid JAXB         */
      /* binding or is a Java primitive type, it can be used as an event      */
      /* value"                                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction6", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction7 */
      /* Details: "If a value is not serializeable, the setEvent method       */
      /* must throw an IllegalArgumentException"                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction7", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction8 */
      /* Details: "If a value does not have a valid JAXB binding and is not   */
      /* a Java primitve type, the setEvent method must throw an              */
      /* IllegalArgumentException"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction8", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction9 */
      /* Details: "The portlet can publish multiple events via the setEvent   */
      /* method in the processAction method"                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction9", aurl);
         tb.writeTo(writer);
      }

   }

}
