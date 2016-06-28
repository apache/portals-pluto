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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETWINDOWSTATE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETWINDOWSTATE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETWINDOWSTATE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETPORTLETMODE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETPORTLETMODE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETPORTLETMODE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS7;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS8;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS10;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS11;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS12;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA7;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA8;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETPORTLETMODE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETPORTLETMODE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETWINDOWSTATE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETWINDOWSTATE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_REMOVEPUBLICRENDERPARAMETER1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_REMOVEPUBLICRENDERPARAMETER2;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.TestButton;
import javax.xml.namespace.QName;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet ResponseTests_StateAwareResponse_ApiEvent_event
 *
 */
public class ResponseTests_StateAwareResponse_ApiEvent implements Portlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      QName eventQName = new QName(TCKNAMESPACE,
             "ResponseTests_StateAwareResponse_ApiEvent");
      portletResp.setEvent(eventQName, "Hi!");
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setWindowState1 */
      /* Details: "Method setWindowState(WindowState): Sets the WindowState   */
      /* to the specified value"                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETWINDOWSTATE1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setWindowState2 */
      /* Details: "Method setWindowState(WindowState): Throws                 */
      /* WindowStateException if the portlet cannot switch to the specified   */
      /* WindowState"                                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETWINDOWSTATE2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setWindowState3 */
      /* Details: "Method setWindowState(WindowState): Throws                 */
      /* IllegalStateException if the method is invoked after the             */
      /* sendRedirect method has been called"                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETWINDOWSTATE3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setPortletMode1 */
      /* Details: "Method setPortletMode(PortletMode): Sets the PortletMode   */
      /* to the specified value"                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETPORTLETMODE1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setPortletMode2 */
      /* Details: "Method setPortletMode(PortletMode): Throws                 */
      /* PortletModeException if the portlet cannot switch to the specified   */
      /* PortletMode"                                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETPORTLETMODE2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setPortletMode3 */
      /* Details: "Method setPortletMode(PortletMode): Throws                 */
      /* IllegalStateException if the method is invoked after the             */
      /* sendRedirect method has been called"                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETPORTLETMODE3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters1 */
      /* Details: "Method setRenderParameters(java.util.Map): Sets the        */
      /* render parameter map to the specified value"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters2 */
      /* Details: "Method setRenderParameters(java.util.Map): Public render   */
      /* parameters can be set through the map"                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters3 */
      /* Details: "Method setRenderParameters(java.util.Map): Private         */
      /* render parameters can be set through the map"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters4 */
      /* Details: "Method setRenderParameters(java.util.Map): Previously      */
      /* existing private render parameters not contained in the specified    */
      /* input map are removed"                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters5 */
      /* Details: "Method setRenderParameters(java.util.Map): Previously      */
      /* existing public render parameters not contained in the specified     */
      /* input map remain unchanged"                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS5, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters6 */
      /* Details: "Method setRenderParameters(java.util.Map): Parameters      */
      /* that are set are available in subsequent render requests"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS6, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters7 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalArgumentException if the input map is null"                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS7, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters8 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalArgumentException if any key in the map is null"              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS8, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters10 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalArgumentException if the values array for any key is null "   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS10, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters11 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalArgumentException if any element in the values array is       */
      /* null "                                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS11, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters12 */
      /* Details: "Method setRenderParameters(java.util.Map): Throws          */
      /* IllegalStateException if the method is invoked after the             */
      /* sendRedirect method has been called"                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS12, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA1 */
      /* Details: "Method setRenderParameter(String, String): Sets the        */
      /* parameter value for the specified name"                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA2 */
      /* Details: "Method setRenderParameter(String, String): A private       */
      /* parameter can be set"                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA3 */
      /* Details: "Method setRenderParameter(String, String): A public        */
      /* parameter can be set"                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA4 */
      /* Details: "Method setRenderParameter(String, String): All             */
      /* previously existing values for the specified name are removed"       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA5 */
      /* Details: "Method setRenderParameter(String, String): If the value    */
      /* is null, all values for the specified name are removed"              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA5, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA6 */
      /* Details: "Method setRenderParameter(String, String): Parameters      */
      /* that are set are available in subsequent render requests"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA6, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA7 */
      /* Details: "Method setRenderParameter(String, String): Throws          */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA7, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA8 */
      /* Details: "Method setRenderParameter(String, String): Throws          */
      /* IllegalStateException if the method is invoked after the             */
      /* sendRedirect method has been called"                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA8, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB1 */
      /* Details: "Method setRenderParameter(String, String[]): Sets the      */
      /* parameter values for the specified name."                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB2 */
      /* Details: "Method setRenderParameter(String, String[]): All           */
      /* existing values are removed"                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB3 */
      /* Details: "Method setRenderParameter(String, String[]): Parameters    */
      /* that are set are available in subsequent render requests"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB4 */
      /* Details: "Method setRenderParameter(String, String[]): Throws        */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB5 */
      /* Details: "Method setRenderParameter(String, String[]): Throws        */
      /* IllegalArgumentException if the values array is null"                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB5, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB6 */
      /* Details: "Method setRenderParameter(String, String[]): Throws        */
      /* IllegalStateException if the method is invoked after the             */
      /* sendRedirect method has been called"                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB6, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventA1     */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Publishes an event with the specified name    */
      /* and payload"                                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventA2     */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Throws IllegalArgumentException if the name   */
      /* is null"                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventA3     */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Throws IllegalArgumentException if the        */
      /* value is not serializable"                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventA4     */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Throws IllegalArgumentException if the        */
      /* value does not have a valid JAXB binding"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventA5     */
      /* Details: "Method setEvent(javax.xml.namespace.QName,                 */
      /* java.io.Serializable): Throws IllegalArgumentException if the        */
      /* value object type is not as specified in the deployment              */
      /* descriptor"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA5, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventB1     */
      /* Details: "Method setEvent(String, java.io.Serializable): Publishes   */
      /* an event with the specified name and payload"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventB2     */
      /* Details: "Method setEvent(String, java.io.Serializable): Throws      */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventB3     */
      /* Details: "Method setEvent(String, java.io.Serializable): Throws      */
      /* IllegalArgumentException if the value is not serializable"           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventB4     */
      /* Details: "Method setEvent(String, java.io.Serializable): Throws      */
      /* IllegalArgumentException if the value does not have a valid JAXB     */
      /* binding"                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_setEventB5     */
      /* Details: "Method setEvent(String, java.io.Serializable): Throws      */
      /* IllegalArgumentException if the value object type is not as          */
      /* specified in the deployment descriptor"                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB5, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getRenderParameterMap1 */
      /* Details: "Method getRenderParameterMap(): Returns a map of the       */
      /* render parameters currently set on the response"                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getRenderParameterMap2 */
      /* Details: "Method getRenderParameterMap(): The returned map           */
      /* contains public render parameters"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getRenderParameterMap3 */
      /* Details: "Method getRenderParameterMap(): The returned map           */
      /* contains private render parameters"                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getRenderParameterMap4 */
      /* Details: "Method getRenderParameterMap(): An empty map is returned   */
      /* if no parameters have been set "                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getPortletMode1 */
      /* Details: "Method getPortletMode(): Returns the current PortletMode   */
      /* for the portlet"                                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETPORTLETMODE1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getPortletMode2 */
      /* Details: "Method getPortletMode(): Returns null if no PortletMode    */
      /* has been set"                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETPORTLETMODE2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getWindowState1 */
      /* Details: "Method getWindowState(): Returns the current WindowState   */
      /* for the portlet"                                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETWINDOWSTATE1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_getWindowState2 */
      /* Details: "Method getWindowState(): Returns null if no WindowState    */
      /* has been set"                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETWINDOWSTATE2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_removePublicRenderParameter1 */
      /* Details: "Method removePublicRenderParameter(String): Removes the    */
      /* specified public render parameter"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_REMOVEPUBLICRENDERPARAMETER1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_StateAwareResponse_ApiEvent_removePublicRenderParameter2 */
      /* Details: "Method removePublicRenderParameter(String): Throws         */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_REMOVEPUBLICRENDERPARAMETER2, aurl);
         tb.writeTo(writer);
      }

   }

}
