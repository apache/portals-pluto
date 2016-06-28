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

import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA7;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB10;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB11;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB7;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB8;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB9;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet ResponseTests_ActionResponse_ApiAction_event
 *
 */
public class ResponseTests_ActionResponse_ApiAction implements Portlet {
   
   @SuppressWarnings("unused")
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

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      @SuppressWarnings("unused")
	ClassChecker cc = new ClassChecker(portletResp.getClass());

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectA1    */
      /* Details: "Method sendRedirect(String): Allows a redirect response    */
      /* to be sent to the client"                                            */
      TestResult tr0 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA1);
      tr0.setTcSuccess(true);
      tr0.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectA2    */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalArgumentException if a relative path URL is specified"        */
      TestResult tr1 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA2);
      try {
    	  portletResp.sendRedirect("/Test");
    	  
    	  tr1.appendTcDetail("Method Did not Throw Exception");
      } catch (IllegalStateException ise) {
    	  tr1.setTcSuccess(true);
      }
      tr1.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectA3    */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setPortletMode has been called before       */
      /* this method "                                                        */
      TestResult tr2 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA3);
      try {
    	  portletResp.setPortletMode(PortletMode.VIEW);
    	  portletResp.sendRedirect("/Test");
    	  
    	  tr2.appendTcDetail("Method Did not Throw Exception");
      } catch (IllegalStateException ise) {
    	  tr2.setTcSuccess(true);
      }
      tr2.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectA4    */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setWindowState has been called before       */
      /* this method "                                                        */
      TestResult tr3 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA4);
      try {
    	  portletResp.setWindowState(WindowState.NORMAL);
    	  portletResp.sendRedirect("/Test");
    	  
    	  tr3.appendTcDetail("Method Did not Throw Exception");
      } catch (IllegalStateException ise) {
    	  tr3.setTcSuccess(true);
      }
      tr3.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectA5    */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setRenderParameter has been called before   */
      /* this method "                                                        */
      TestResult tr4 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA5);
      try {
    	  portletResp.setRenderParameter("Test1", "Test2");
    	  portletResp.sendRedirect("/Test");
    	  
    	  tr4.appendTcDetail("Method Did not Throw Exception");
      } catch (IllegalStateException ise) {
    	  tr4.setTcSuccess(true);
      }
      tr4.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectA6    */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setRenderParameters has been called         */
      /* before this method "                                                 */
      TestResult tr5 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA6);
      try {
    	  portletResp.setRenderParameter("Test1", "Test2");
    	  portletResp.sendRedirect("/Test");
    	  
    	  tr5.appendTcDetail("Method Did not Throw Exception");
      } catch (IllegalStateException ise) {
    	  tr5.setTcSuccess(true);
      }
      tr5.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectA7    */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if removePublicRenderParameter has been        */
      /* called before this method"                                           */
      TestResult tr6 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA7);
      try {
    	  portletResp.removePublicRenderParameter("Test");
    	  portletResp.sendRedirect("/Test");
    	  
    	  tr6.appendTcDetail("Method Did not Throw Exception");
      } catch (IllegalStateException ise) {
    	  tr6.setTcSuccess(true);
      }
      tr6.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB1    */
      /* Details: "Method sendRedirect(String, String): Allows a redirect     */
      /* response to be sent to the client"                                   */
      TestResult tr7 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB1);
      tr7.setTcSuccess(true);
      tr7.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB2    */
      /* Details: "Method sendRedirect(String, String): Encodes a render      */
      /* URL as a parameter under the specified name on the redirect URL"     */
      TestResult tr8 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB2);
      tr8.setTcSuccess(true);
      tr8.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB3    */
      /* Details: "Method sendRedirect(String, String): The encoded render    */
      /* URL contains the currently set PortletMode"                          */
      TestResult tr9 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB3);
      tr9.setTcSuccess(true);
      tr9.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB4    */
      /* Details: "Method sendRedirect(String, String): The encoded render    */
      /* URL contains the currently set WindowState"                          */
      TestResult tr10 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB4);
      tr10.setTcSuccess(true);
      tr10.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB5    */
      /* Details: "Method sendRedirect(String, String): The encoded render    */
      /* URL contains the currently set render parameters"                    */
      TestResult tr11 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB5);
      tr11.setTcSuccess(true);
      tr11.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB6    */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalArgumentException if a relative path URL is specified"        */
      TestResult tr12 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB6);
      try {
    	  portletResp.sendRedirect("/Test");
    	  
    	  tr12.appendTcDetail("Method Did not Throw Exception");
      } catch (IllegalStateException ise) {
    	  tr12.setTcSuccess(true);
      }
      tr12.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB7    */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setPortletMode has been called before       */
      /* this method "                                                        */
      TestResult tr13 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB7);
      try {
    	  portletResp.setPortletMode(PortletMode.VIEW);
    	  portletResp.sendRedirect("/Test");
    	  
    	  tr13.appendTcDetail("Method Did not Throw Exception");
      } catch (IllegalStateException ise) {
    	  tr13.setTcSuccess(true);
      }
      
      tr13.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB8    */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setWindowState has been called before       */
      /* this method "                                                        */
      TestResult tr14 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB8);
      try {
    	  portletResp.setWindowState(WindowState.NORMAL);
    	  portletResp.sendRedirect("/Test");
    	  
    	  tr14.appendTcDetail("Method Did not Throw Exception");
      } catch (IllegalStateException ise) {
    	  tr14.setTcSuccess(true);
      }
      tr14.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB9    */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setRenderParameter has been called before   */
      /* this method "                                                        */
      TestResult tr15 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB9);
      try {
    	  portletResp.setRenderParameter("Test1", "Test2");
    	  portletResp.sendRedirect("/Test");
    	  
    	  tr15.appendTcDetail("Method Did not Throw Exception");
      } catch (IllegalStateException ise) {
    	  tr15.setTcSuccess(true);
      }
      tr15.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB10   */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setRenderParameters has been called         */
      /* before this method "                                                 */
      TestResult tr16 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB10);
      try {
    	  portletResp.setRenderParameter("Test1", "Test2");
    	  portletResp.sendRedirect("/Test");
    	  
    	  tr16.appendTcDetail("Method Did not Throw Exception");
      } catch (IllegalStateException ise) {
    	  tr16.setTcSuccess(true);
      }
      tr16.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB11   */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if removePublicRenderParameter has been        */
      /* called before this method"                                           */
      TestResult tr17 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB11);
      try {
    	  portletResp.removePublicRenderParameter("Test");
    	  portletResp.sendRedirect("/Test");
    	  
    	  tr17.appendTcDetail("Method Did not Throw Exception");
      } catch (IllegalStateException ise) {
    	  tr17.setTcSuccess(true);
      }
      tr17.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "ResponseTests_ActionResponse_ApiAction",
                   writer.toString(), APPLICATION_SCOPE);
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "ResponseTests_ActionResponse_ApiAction", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "ResponseTests_ActionResponse_ApiAction", APPLICATION_SCOPE);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectA1    */
      /* Details: "Method sendRedirect(String): Allows a redirect response    */
      /* to be sent to the client"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectA2    */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalArgumentException if a relative path URL is specified"        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectA3    */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setPortletMode has been called before       */
      /* this method "                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectA4    */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setWindowState has been called before       */
      /* this method "                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectA5    */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setRenderParameter has been called before   */
      /* this method "                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA5, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectA6    */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setRenderParameters has been called         */
      /* before this method "                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA6, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectA7    */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if removePublicRenderParameter has been        */
      /* called before this method"                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA7, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB1    */
      /* Details: "Method sendRedirect(String, String): Allows a redirect     */
      /* response to be sent to the client"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB2    */
      /* Details: "Method sendRedirect(String, String): Encodes a render      */
      /* URL as a parameter under the specified name on the redirect URL"     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB3    */
      /* Details: "Method sendRedirect(String, String): The encoded render    */
      /* URL contains the currently set PortletMode"                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB4    */
      /* Details: "Method sendRedirect(String, String): The encoded render    */
      /* URL contains the currently set WindowState"                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB5    */
      /* Details: "Method sendRedirect(String, String): The encoded render    */
      /* URL contains the currently set render parameters"                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB5, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB6    */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalArgumentException if a relative path URL is specified"        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB6, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB7    */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setPortletMode has been called before       */
      /* this method "                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB7, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB8    */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setWindowState has been called before       */
      /* this method "                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB8, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB9    */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setRenderParameter has been called before   */
      /* this method "                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB9, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB10   */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setRenderParameters has been called         */
      /* before this method "                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB10, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_ApiAction_sendRedirectB11   */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if removePublicRenderParameter has been        */
      /* called before this method"                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB11, aurl);
         tb.writeTo(writer);
      }

   }

}
