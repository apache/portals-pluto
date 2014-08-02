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

import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */
public class AddlPortletTests_SPEC2_15_Event implements Portlet {
   private static final String LOG_CLASS = 
         AddlPortletTests_SPEC2_15_Event.class.getName();
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
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
         throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest renderRequest, RenderResponse renderResponse)
         throws PortletException, IOException {
      
      if (LOGGER.isLoggable(Level.FINE)) {
         LOGGER.logp(Level.FINE, LOG_CLASS, "render", "Entry");
      }

      PrintWriter writer = renderResponse.getWriter();
      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: SPEC2_15_Event_event1                                      */
      /* Details: "Event names are defined in the deployment descriptor"      */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT1);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_event2                                      */
      /* Details: "Event value types are defined in the deployment            */
      /* descriptor"                                                          */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT2);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_event3                                      */
      /* Details: "The supported publishing events for the portlet are        */
      /* defined in the deployment descriptor"                                */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT3);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_event4                                      */
      /* Details: "The supported processing events for the portlet are        */
      /* defined in the deployment descriptor"                                */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT4);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_event5                                      */
      /* Details: "The portlet can use the EventRequest.getEvent method to    */
      /* obtain an Event object encapsulating the event name and value"       */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT5);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_event6                                      */
      /* Details: "The Event object must always have a name"                  */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT6);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_event7                                      */
      /* Details: "If the Event object has a value set when the event is      */
      /* published, the value must be based on the value defined in the       */
      /* deployment descriptor"                                               */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT7);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_event8                                      */
      /* Details: "If the Event object has a value set when the event is      */
      /* published, the value must be available from the Event object in      */
      /* the processEvent method"                                             */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT8);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_event9                                      */
      /* Details: "If the Event object does not have a value set when the     */
      /* event is published, the Event object available in the processEvent   */
      /* method must not have a value"                                        */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT9);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_event10                                     */
      /* Details: "The Event Qname object representing the name can be        */
      /* retrieved through the Event getQname method"                         */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT10);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_event11                                     */
      /* Details: "The local part of the Event Qname object representing      */
      /* the name can be retrieved through the Event getName method"          */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT11);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_event12                                     */
      /* Details: "Events are valid only in the current client request and    */
      /* the portlet container must therefore deliver all events within the   */
      /* current client request"                                              */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT12);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_event13                                     */
      /* Details: "Event distribution must be serialized for a specific       */
      /* portlet window per client request so that at any given time a        */
      /* portlet window is only processing one event in the processEvent      */
      /* method for the current client request"                               */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT13);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_event14                                     */
      /* Details: "Portlet event processing may occur after the processing    */
      /* of the action, if the portlet was target of an action URL, and       */
      /* must be finished before the render phase"                            */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT14);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_event15                                     */
      /* Details: "If a portlet throws an exception in the processEvent       */
      /* method, all operations on the EventResponse must be ignored"         */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT15);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_event16                                     */
      /* Details: "If a portlet throws a permanent UnavailableException,      */
      /* the portlet container must remove the portlet from service           */
      /* immediately, call the portlet's destroy method, and release the      */
      /* portlet object"                                                      */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENT16);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessAction1                         */
      /* Details: "The portlet can publish an event via the setEvent method   */
      /* in the processAction method"                                         */
      TestResult tr16 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSACTION1);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessAction2                         */
      /* Details: "The portlet can publish an event with its full Qname via   */
      /* the setEvent method in the processAction method"                     */
      TestResult tr17 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSACTION2);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessAction3                         */
      /* Details: "The portlet can publish an event with only the local       */
      /* part of the Qname via the setEvent method in the processAction       */
      /* method"                                                              */
      TestResult tr18 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSACTION3);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessAction4                         */
      /* Details: "If an event is published with only the local part of the   */
      /* Qname, the namespace must be the default namespace defined in the    */
      /* deployment descriptor"                                               */
      TestResult tr19 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSACTION4);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessAction5                         */
      /* Details: "If an event is published with only the local part of the   */
      /* Qname and no default namespace is defined in the deployment          */
      /* descriptor, the value javax.xml.XMLConstants.NULL_NS_URI must be     */
      /* used as the Qname namespace"                                         */
      TestResult tr20 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSACTION5);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessAction6                         */
      /* Details: "If an object is serializeable and has a valid JAXB         */
      /* binding or is a Java primitive type, it can be used as an event      */
      /* value"                                                               */
      TestResult tr21 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSACTION6);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessAction7                         */
      /* Details: "If a value is not serializeable, the setEvent method       */
      /* must throw an IllegalArgumentException"                              */
      TestResult tr22 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSACTION7);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessAction8                         */
      /* Details: "If a value does not have a valid JAXB binding and is not   */
      /* a Java primitve type, the setEvent method must throw an              */
      /* IllegalArgumentException"                                            */
      TestResult tr23 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSACTION8);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessAction9                         */
      /* Details: "The portlet can publish multiple events via the setEvent   */
      /* method in the processAction method"                                  */
      TestResult tr24 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSACTION9);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessEvent1                          */
      /* Details: "The portlet can publish an event via the setEvent method   */
      /* in the processEvent method"                                          */
      TestResult tr25 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSEVENT1);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessEvent2                          */
      /* Details: "The portlet can publish an event with its full Qname via   */
      /* the setEvent method in the processAction method"                     */
      TestResult tr26 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSEVENT2);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessEvent3                          */
      /* Details: "The portlet can publish an event with only the local       */
      /* part of the Qname via the setEvent method in the processAction       */
      /* method"                                                              */
      TestResult tr27 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSEVENT3);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessEvent4                          */
      /* Details: "If an event is published with only the local part of the   */
      /* Qname, the namespace must be the default namespace defined in the    */
      /* deployment descriptor"                                               */
      TestResult tr28 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSEVENT4);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessEvent5                          */
      /* Details: "If an event is published with only the local part of the   */
      /* Qname and no default namespace is defined in the deployment          */
      /* descriptor, the value javax.xml.XMLConstants.NULL_NS_URI must be     */
      /* used as the Qname namespace"                                         */
      TestResult tr29 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSEVENT5);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessEvent6                          */
      /* Details: "If an object is serializeable and has a valid JAXB         */
      /* binding or is a Java primitive type, it can be used as an event      */
      /* value"                                                               */
      TestResult tr30 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSEVENT6);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessEvent7                          */
      /* Details: "If a value is not serializeable, the setEvent method       */
      /* must throw an IllegalArgumentException"                              */
      TestResult tr31 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSEVENT7);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessEvent8                          */
      /* Details: "If a value does not have a valid JAXB binding and is not   */
      /* a Java primitve type, the setEvent method must throw an              */
      /* IllegalArgumentException"                                            */
      TestResult tr32 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSEVENT8);
      /* TODO: implement test */

      /* TestCase: SPEC2_15_Event_eventProcessEvent9                          */
      /* Details: "The portlet can publish multiple events via the setEvent   */
      /* method in the processEvent method"                                   */
      TestResult tr33 = tcd.getTestResultFailed(SPEC2_15_EVENT_EVENTPROCESSEVENT9);
      /* TODO: implement test */



      // Write the results to the output stream

      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);
      tr3.writeTo(writer);
      tr4.writeTo(writer);
      tr5.writeTo(writer);
      tr6.writeTo(writer);
      tr7.writeTo(writer);
      tr8.writeTo(writer);
      tr9.writeTo(writer);
      tr10.writeTo(writer);
      tr11.writeTo(writer);
      tr12.writeTo(writer);
      tr13.writeTo(writer);
      tr14.writeTo(writer);
      tr15.writeTo(writer);
      tr16.writeTo(writer);
      tr17.writeTo(writer);
      tr18.writeTo(writer);
      tr19.writeTo(writer);
      tr20.writeTo(writer);
      tr21.writeTo(writer);
      tr22.writeTo(writer);
      tr23.writeTo(writer);
      tr24.writeTo(writer);
      tr25.writeTo(writer);
      tr26.writeTo(writer);
      tr27.writeTo(writer);
      tr28.writeTo(writer);
      tr29.writeTo(writer);
      tr30.writeTo(writer);
      tr31.writeTo(writer);
      tr32.writeTo(writer);
      tr33.writeTo(writer);


   }

}

