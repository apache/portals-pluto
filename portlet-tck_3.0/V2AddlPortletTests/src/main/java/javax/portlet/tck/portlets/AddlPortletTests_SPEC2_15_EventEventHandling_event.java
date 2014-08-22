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
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
import static javax.portlet.PortletSession.*;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, 
 * but does not publish them. Events are published in the main portlet for the test cases. 
 */
public class AddlPortletTests_SPEC2_15_EventEventHandling_event implements Portlet, EventPortlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlPortletTests_SPEC2_15_EventEventHandling_event.class.getName();
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
      LOGGER.entering(LOG_CLASS, "event companion processAction - ERROR!!");
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "event companion serveResource - ERROR!!");
   }

   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "event companion processEvent");


      portletResp.setRenderParameters(portletReq);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event5      */
      /* Details: "The portlet can use the EventRequest.getEvent method to    */
      /* obtain an Event object encapsulating the event name and value"       */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT5);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event6      */
      /* Details: "The Event object must always have the name field set"      */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT6);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event7      */
      /* Details: "If the Event object has a value set when the event is      */
      /* published, the value must be based on the value defined in the       */
      /* deployment descriptor"                                               */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT7);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event8      */
      /* Details: "If the Event object has a value set when the event is      */
      /* published, the value must be available from the Event object in      */
      /* the processEvent method"                                             */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT8);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event9      */
      /* Details: "If the Event object does not have a value set when the     */
      /* event is published, the Event object available in the processEvent   */
      /* method must not have a value"                                        */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT9);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event10     */
      /* Details: "The Event Qname object representing the name can be        */
      /* retrieved through the Event getQname method"                         */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT10);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event11     */
      /* Details: "The local part of the Event Qname object representing      */
      /* the name can be retrieved through the Event getName method"          */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT11);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event15     */
      /* Details: "If a portlet throws an exception in the processEvent       */
      /* method, all operations on the EventResponse must be ignored"         */
      TestResult tr7 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT15);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event16     */
      /* Details: "If a portlet throws a permanent UnavailableException       */
      /* during event processing, the portlet container must remove the       */
      /* portlet from service immediately, call the portlet's destroy         */
      /* method, and release the portlet object"                              */
      TestResult tr8 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT16);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent1 */
      /* Details: "The portlet can publish an event via the setEvent method   */
      /* in the processEvent method"                                          */
      TestResult tr9 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT1);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent2 */
      /* Details: "The portlet can publish an event with its full Qname via   */
      /* the setEvent method in the processAction method"                     */
      TestResult tr10 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT2);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent3 */
      /* Details: "The portlet can publish an event with only the local       */
      /* part of the Qname via the setEvent method in the processAction       */
      /* method"                                                              */
      TestResult tr11 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT3);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent4 */
      /* Details: "If an event is published with only the local part of the   */
      /* Qname, the namespace must be the default namespace defined in the    */
      /* deployment descriptor"                                               */
      TestResult tr12 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT4);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent5 */
      /* Details: "If an event is published with only the local part of the   */
      /* Qname and no default namespace is defined in the deployment          */
      /* descriptor, the value javax.xml.XMLConstants.NULL_NS_URI must be     */
      /* used as the Qname namespace"                                         */
      TestResult tr13 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT5);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent6 */
      /* Details: "If an object is serializeable and has a valid JAXB         */
      /* binding or is a Java primitive type, it can be used as an event      */
      /* value"                                                               */
      TestResult tr14 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT6);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent7 */
      /* Details: "If a value is not serializeable, the setEvent method       */
      /* must throw an IllegalArgumentException"                              */
      TestResult tr15 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT7);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent8 */
      /* Details: "If a value does not have a valid JAXB binding and is not   */
      /* a Java primitve type, the setEvent method must throw an              */
      /* IllegalArgumentException"                                            */
      TestResult tr16 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT8);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent9 */
      /* Details: "The portlet can publish multiple events via the setEvent   */
      /* method in the processEvent method"                                   */
      TestResult tr17 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT9);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_15_EventEventHandling",
                   writer.toString(), APPLICATION_SCOPE);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      
      LOGGER.entering(LOG_CLASS, "event companion render");

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>AddlPortletTests_SPEC2_15_EventEventHandling_event</p>\n");

      String msg = (String) portletReq.getPortletSession()
            .getAttribute(RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_15_EventEventHandling", APPLICATION_SCOPE);
      msg = (msg==null) ? "Not ready. click test case link." : msg;
      writer.write("<p>" + msg + "</p>\n");

   }

}
