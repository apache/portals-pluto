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
 * portlet AddlPortletTests_SPEC2_15_EventEventHandling_event
 *
 */
public class AddlPortletTests_SPEC2_15_EventEventHandling implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlPortletTests_SPEC2_15_EventEventHandling.class.getName();
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

      QName eventQName = new QName(TCKNAMESPACE,
             "AddlPortletTests_SPEC2_15_EventEventHandling");
      portletResp.setEvent(eventQName, "Hi!");
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

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event5      */
      /* Details: "The portlet can use the EventRequest.getEvent method to    */
      /* obtain an Event object encapsulating the event name and value"       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_event5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event6      */
      /* Details: "The Event object must always have the name field set"      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_event6", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event7      */
      /* Details: "If the Event object has a value set when the event is      */
      /* published, the value must be based on the value defined in the       */
      /* deployment descriptor"                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_event7", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event8      */
      /* Details: "If the Event object has a value set when the event is      */
      /* published, the value must be available from the Event object in      */
      /* the processEvent method"                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_event8", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event9      */
      /* Details: "If the Event object does not have a value set when the     */
      /* event is published, the Event object available in the processEvent   */
      /* method must not have a value"                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_event9", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event10     */
      /* Details: "The Event Qname object representing the name can be        */
      /* retrieved through the Event getQname method"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_event10", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event11     */
      /* Details: "The local part of the Event Qname object representing      */
      /* the name can be retrieved through the Event getName method"          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_event11", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event15     */
      /* Details: "If a portlet throws an exception in the processEvent       */
      /* method, all operations on the EventResponse must be ignored"         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_event15", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event16     */
      /* Details: "If a portlet throws a permanent UnavailableException       */
      /* during event processing, the portlet container must remove the       */
      /* portlet from service immediately, call the portlet's destroy         */
      /* method, and release the portlet object"                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_event16", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent1 */
      /* Details: "The portlet can publish an event via the setEvent method   */
      /* in the processEvent method"                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent2 */
      /* Details: "The portlet can publish an event with its full Qname via   */
      /* the setEvent method in the processAction method"                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent3 */
      /* Details: "The portlet can publish an event with only the local       */
      /* part of the Qname via the setEvent method in the processAction       */
      /* method"                                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent4 */
      /* Details: "If an event is published with only the local part of the   */
      /* Qname, the namespace must be the default namespace defined in the    */
      /* deployment descriptor"                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent5 */
      /* Details: "If an event is published with only the local part of the   */
      /* Qname and no default namespace is defined in the deployment          */
      /* descriptor, the value javax.xml.XMLConstants.NULL_NS_URI must be     */
      /* used as the Qname namespace"                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent6 */
      /* Details: "If an object is serializeable and has a valid JAXB         */
      /* binding or is a Java primitive type, it can be used as an event      */
      /* value"                                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent6", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent7 */
      /* Details: "If a value is not serializeable, the setEvent method       */
      /* must throw an IllegalArgumentException"                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent7", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent8 */
      /* Details: "If a value does not have a valid JAXB binding and is not   */
      /* a Java primitve type, the setEvent method must throw an              */
      /* IllegalArgumentException"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent8", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent9 */
      /* Details: "The portlet can publish multiple events via the setEvent   */
      /* method in the processEvent method"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent9", aurl);
         tb.writeTo(writer);
      }

   }

}
