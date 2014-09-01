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
 * portlet SigTestsEvent_PortletResponse_SIGEvent_event
 *
 */
public class SigTestsEvent_PortletResponse_SIGEvent implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         SigTestsEvent_PortletResponse_SIGEvent.class.getName();
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
             "SigTestsEvent_PortletResponse_SIGEvent");
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

      /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasAddProperty    */
      /* Details: "EventResponse has a addProperty(String, String)  method    */
      /* "                                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletResponse_SIGEvent_hasAddProperty", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyA   */
      /* Details: "EventResponse has a                                        */
      /* addProperty(javax.servlet.http.Cookie)  method "                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyA", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyB   */
      /* Details: "EventResponse has a addProperty(String,                    */
      /* org.w3c.dom.Element)  method "                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyB", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyReturns */
      /* Details: "EventResponse method addProperty(String, String) returns   */
      /* void "                                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyReturnsA */
      /* Details: "EventResponse method                                       */
      /* addProperty(javax.servlet.http.Cookie) returns void "                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyReturnsA", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyReturnsB */
      /* Details: "EventResponse method addProperty(String,                   */
      /* org.w3c.dom.Element) returns void "                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyReturnsB", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasCreateElement  */
      /* Details: "EventResponse has a createElement(String) throws           */
      /* org.w3c.dom.DOMException method "                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletResponse_SIGEvent_hasCreateElement", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasCreateElementReturns */
      /* Details: "EventResponse method createElement(String) returns         */
      /* org.w3c.dom.Element "                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletResponse_SIGEvent_hasCreateElementReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasEncodeURL      */
      /* Details: "EventResponse has a encodeURL(String)  method "            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletResponse_SIGEvent_hasEncodeURL", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasEncodeURLReturns */
      /* Details: "EventResponse method encodeURL(String) returns String "    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletResponse_SIGEvent_hasEncodeURLReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasGetNamespace   */
      /* Details: "EventResponse has a getNamespace()  method "               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletResponse_SIGEvent_hasGetNamespace", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasGetNamespaceReturns */
      /* Details: "EventResponse method getNamespace() returns String "       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletResponse_SIGEvent_hasGetNamespaceReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasSetProperty    */
      /* Details: "EventResponse has a setProperty(String, String)  method    */
      /* "                                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletResponse_SIGEvent_hasSetProperty", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasSetPropertyReturns */
      /* Details: "EventResponse method setProperty(String, String) returns   */
      /* void "                                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletResponse_SIGEvent_hasSetPropertyReturns", aurl);
         tb.writeTo(writer);
      }

   }

}
