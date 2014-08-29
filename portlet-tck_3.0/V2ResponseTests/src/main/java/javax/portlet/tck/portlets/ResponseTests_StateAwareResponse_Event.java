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
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
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
 * portlet ResponseTests_StateAwareResponse_Event_event
 *
 */
public class ResponseTests_StateAwareResponse_Event implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         ResponseTests_StateAwareResponse_Event.class.getName();
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
             "ResponseTests_StateAwareResponse_Event");
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

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setWindowState1   */
      /* Details: "Method setWindowState(WindowState): Sets the WindowState   */
      /* to the specified value"                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setWindowState1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setWindowState2   */
      /* Details: "Method setWindowState(WindowState): Throws                 */
      /* WindowStateException if the portlet cannot switch to the specified   */
      /* WindowState"                                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setWindowState2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setWindowState3   */
      /* Details: "Method setWindowState(WindowState): Throws                 */
      /* IllegalStateException if the method is invoked after the             */
      /* sendRedirect method has been called"                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setWindowState3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setPortletMode1   */
      /* Details: "Method setPortletMode(PortletMode): Sets the PortletMode   */
      /* to the specified value"                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setPortletMode1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setPortletMode2   */
      /* Details: "Method setPortletMode(PortletMode): Throws                 */
      /* PortletModeException if the portlet cannot switch to the specified   */
      /* PortletMode"                                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setPortletMode2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setPortletMode3   */
      /* Details: "Method setPortletMode(PortletMode): Throws                 */
      /* IllegalStateException if the method is invoked after the             */
      /* sendRedirect method has been called"                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setPortletMode3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameters1 */
      /* Details: "Method setRenderParameters(java.util.Map): Sets the        */
      /* render parameter map to the specified value"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameters1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameters2 */
      /* Details: "Method setRenderParameters(java.util.Map): Public render   */
      /* parameters can be set through the map"                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameters2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameters3 */
      /* Details: "Method setRenderParameters(java.util.Map): Private         */
      /* render parameters can be set through the map"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameters3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameters4 */
      /* Details: "Method setRenderParameters(java.util.Map): Previously      */
      /* existing private render parameters not contained in the specified    */
      /* input map are removed"                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameters4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameters5 */
      /* Details: "Method setRenderParameters(java.util.Map): Previously      */
      /* existing public render parameters not contained in the specified     */
      /* input map remain unchanged"                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameters5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameters6 */
      /* Details: "Method setRenderParameters(java.util.Map): Parameters      */
      /* that are set are available in subsequent render requests"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameters6", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameters7 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalArgumentException if the input map is null"                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameters7", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameters8 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalArgumentException if any key in the map is null"              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameters8", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameters9 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalArgumentException if any key in the map is the empty string   */
      /* (\"\") "                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameters9", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameters10 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalArgumentException if the values array for any key is null "   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameters10", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameters11 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalArgumentException if any element in any values array is       */
      /* null "                                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameters11", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameters12 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalStateException if the method is invoked after the             */
      /* sendRedirect method has been called"                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameters12", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameterA1 */
      /* Details: "Method setRenderParameter(String, String): Sets the        */
      /* parameter value for the specified name"                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameterA1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameterA2 */
      /* Details: "Method setRenderParameter(String, String): A private       */
      /* parameter can be set"                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameterA2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameterA3 */
      /* Details: "Method setRenderParameter(String, String): A public        */
      /* parameter can be set"                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameterA3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameterA4 */
      /* Details: "Method setRenderParameter(String, String): All             */
      /* previously existing values for the specified name are removed"       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameterA4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameterA5 */
      /* Details: "Method setRenderParameter(String, String): If the value    */
      /* is null, all values for the specified name are removed"              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameterA5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameterA6 */
      /* Details: "Method setRenderParameter(String, String): Parameters      */
      /* that are set are available in subsequent render requests"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameterA6", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameterA7 */
      /* Details: "Method setRenderParameter(String, String): Throws          */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameterA7", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameterA8 */
      /* Details: "Method setRenderParameter(String, String): Throws          */
      /* IllegalStateException if the method is invoked after the             */
      /* sendRedirect method has been called"                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameterA8", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameterB1 */
      /* Details: "Method setRenderParameter(String, String[]): Sets the      */
      /* parameter values for the specified name."                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameterB1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameterB2 */
      /* Details: "Method setRenderParameter(String, String[]): All           */
      /* existing values are removed"                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameterB2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameterB3 */
      /* Details: "Method setRenderParameter(String, String[]): Parameters    */
      /* that are set are available in subsequent render requests"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameterB3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameterB4 */
      /* Details: "Method setRenderParameter(String, String[]): Throws        */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameterB4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameterB5 */
      /* Details: "Method setRenderParameter(String, String[]): Throws        */
      /* IllegalArgumentException if the values array is null"                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameterB5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setRenderParameterB6 */
      /* Details: "Method setRenderParameter(String, String[]): Throws        */
      /* IllegalStateException if the method is invoked after the             */
      /* sendRedirect method has been called"                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setRenderParameterB6", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setEventA1        */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Publishes an event with the specified name    */
      /* and payload"                                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setEventA1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setEventA2        */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Throws IllegalArgumentException if the name   */
      /* is null"                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setEventA2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setEventA3        */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Throws IllegalArgumentException if the        */
      /* value is not serializable"                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setEventA3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setEventA4        */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Throws IllegalArgumentException if the        */
      /* value does not have a valid JAXB binding"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setEventA4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setEventA5        */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Throws IllegalArgumentException if the        */
      /* value object type is not as specified in the deployment              */
      /* descriptor"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setEventA5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setEventB1        */
      /* Details: "Method setEvent(String, java.io.Serializable): Publishes   */
      /* an event with the specified name and payload"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setEventB1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setEventB2        */
      /* Details: "Method setEvent(String, java.io.Serializable): Throws      */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setEventB2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setEventB3        */
      /* Details: "Method setEvent(String, java.io.Serializable): Throws      */
      /* IllegalArgumentException if the value is not serializable"           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setEventB3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setEventB4        */
      /* Details: "Method setEvent(String, java.io.Serializable): Throws      */
      /* IllegalArgumentException if the value does not have a valid JAXB     */
      /* binding"                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setEventB4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_setEventB5        */
      /* Details: "Method setEvent(String, java.io.Serializable): Throws      */
      /* IllegalArgumentException if the value object type is not as          */
      /* specified in the deployment descriptor"                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_setEventB5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_getRenderParameterMap1 */
      /* Details: "Method getRenderParameterMap(): Returns a map of the       */
      /* render parameters currently set on the response"                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_getRenderParameterMap1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_getRenderParameterMap2 */
      /* Details: "Method getRenderParameterMap(): The returned map           */
      /* contains public render parameters"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_getRenderParameterMap2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_getRenderParameterMap3 */
      /* Details: "Method getRenderParameterMap(): The returned map           */
      /* contains private render parameters"                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_getRenderParameterMap3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_getRenderParameterMap4 */
      /* Details: "Method getRenderParameterMap(): An empty map is returned   */
      /* if no parameters have been set "                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_getRenderParameterMap4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_getPortletMode1   */
      /* Details: "Method getPortletMode(): Returns the current PortletMode   */
      /* for the portlet"                                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_getPortletMode1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_getPortletMode2   */
      /* Details: "Method getPortletMode(): Returns null if no PortletMode    */
      /* has been set"                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_getPortletMode2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_getWindowState1   */
      /* Details: "Method getWindowState(): Returns the current WindowState   */
      /* for the portlet"                                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_getWindowState1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_getWindowState2   */
      /* Details: "Method getWindowState(): Returns null if no WindowState    */
      /* has been set"                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_getWindowState2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_removePublicRenderParameter1 */
      /* Details: "Method removePublicRenderParameter(String): Removes the    */
      /* specified public render parameter"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_removePublicRenderParameter1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_Event_removePublicRenderParameter2 */
      /* Details: "Method removePublicRenderParameter(String): Throws         */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_StateAwareResponse_Event_removePublicRenderParameter2", aurl);
         tb.writeTo(writer);
      }

   }

}
