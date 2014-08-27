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
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.*;
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
 * portlet SigTestsEvent_StateAwareResponse_SIGEvent_event
 *
 */
public class SigTestsEvent_StateAwareResponse_SIGEvent implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         SigTestsEvent_StateAwareResponse_SIGEvent.class.getName();
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
             "SigTestsEvent_StateAwareResponse_SIGEvent");
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

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetPortletMode */
      /* Details: "EventResponse has a getPortletMode()  method "             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetPortletMode", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetPortletModeReturns */
      /* Details: "EventResponse method getPortletMode() returns              */
      /* PortletMode "                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetPortletModeReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetRenderParameterMap */
      /* Details: "EventResponse has a getRenderParameterMap()  method "      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetRenderParameterMap", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetRenderParameterMapReturns */
      /* Details: "EventResponse method getRenderParameterMap() returns       */
      /* java.util.Map "                                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetRenderParameterMapReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetWindowState */
      /* Details: "EventResponse has a getWindowState()  method "             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetWindowState", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetWindowStateReturns */
      /* Details: "EventResponse method getWindowState() returns              */
      /* WindowState "                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetWindowStateReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasRemovePublicRenderParameter */
      /* Details: "EventResponse has a removePublicRenderParameter(String)    */
      /* method "                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasRemovePublicRenderParameter", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasRemovePublicRenderParameterReturns */
      /* Details: "EventResponse method removePublicRenderParameter(String)   */
      /* returns void "                                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasRemovePublicRenderParameterReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEvent    */
      /* Details: "EventResponse has a setEvent(javax.xml.namespace.QName,    */
      /* java.io.Serializable)  method "                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEvent", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEventA   */
      /* Details: "EventResponse has a setEvent(String,                       */
      /* java.io.Serializable)  method "                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEventA", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEventReturns */
      /* Details: "EventResponse method setEvent(javax.xml.namespace.QName,   */
      /* java.io.Serializable) returns void "                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEventReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEventReturnsA */
      /* Details: "EventResponse method setEvent(String,                      */
      /* java.io.Serializable) returns void "                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEventReturnsA", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetPortletMode */
      /* Details: "EventResponse has a setPortletMode(PortletMode) throws     */
      /* PortletModeException method "                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetPortletMode", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetPortletModeReturns */
      /* Details: "EventResponse method setPortletMode(PortletMode) returns   */
      /* void "                                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetPortletModeReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameter */
      /* Details: "EventResponse has a setRenderParameter(String, String)     */
      /* method "                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameter", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterA */
      /* Details: "EventResponse has a setRenderParameter(String, String[])   */
      /* method "                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterA", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterReturns */
      /* Details: "EventResponse method setRenderParameter(String, String)    */
      /* returns void "                                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterReturnsA */
      /* Details: "EventResponse method setRenderParameter(String,            */
      /* String[]) returns void "                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterReturnsA", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameters */
      /* Details: "EventResponse has a setRenderParameters(java.util.Map)     */
      /* method "                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameters", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParametersReturns */
      /* Details: "EventResponse method setRenderParameters(java.util.Map)    */
      /* returns void "                                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParametersReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetWindowState */
      /* Details: "EventResponse has a setWindowState(WindowState) throws     */
      /* WindowStateException method "                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetWindowState", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetWindowStateReturns */
      /* Details: "EventResponse method setWindowState(WindowState) returns   */
      /* void "                                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetWindowStateReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_implementsPortletResponse */
      /* Details: "EventResponse implements PortletResponse "                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_StateAwareResponse_SIGEvent_implementsPortletResponse", aurl);
         tb.writeTo(writer);
      }

   }

}
