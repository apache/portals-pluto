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
 * portlet ResponseTests_ActionResponse_Action_event
 *
 */
public class ResponseTests_ActionResponse_Action implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         ResponseTests_ActionResponse_Action.class.getName();
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

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectA1       */
      /* Details: "Method sendRedirect(String): Allows a redirect response    */
      /* to be sent to the client"                                            */
      TestResult tr0 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTA1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectA2       */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalArgumentException if a relative path URL is specified"        */
      TestResult tr1 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTA2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectA3       */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setPortletMode has been called before       */
      /* this method "                                                        */
      TestResult tr2 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTA3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectA4       */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setWindowState has been called before       */
      /* this method "                                                        */
      TestResult tr3 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTA4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectA5       */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setRenderParameter has been called before   */
      /* this method "                                                        */
      TestResult tr4 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTA5);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectA6       */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setRenderParameters has been called         */
      /* before this method "                                                 */
      TestResult tr5 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTA6);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectA7       */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if removePublicRenderParameter has been        */
      /* called before this method"                                           */
      TestResult tr6 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTA7);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB1       */
      /* Details: "Method sendRedirect(String, String): Allows a redirect     */
      /* response to be sent to the client"                                   */
      TestResult tr7 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTB1);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB2       */
      /* Details: "Method sendRedirect(String, String): Encodes a render      */
      /* URL as a parameter under the specified name on the redirect URL"     */
      TestResult tr8 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTB2);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB3       */
      /* Details: "Method sendRedirect(String, String): The encoded render    */
      /* URL contains the currently set PortletMode"                          */
      TestResult tr9 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTB3);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB4       */
      /* Details: "Method sendRedirect(String, String): The encoded render    */
      /* URL contains the currently set WindowState"                          */
      TestResult tr10 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTB4);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB5       */
      /* Details: "Method sendRedirect(String, String): The encoded render    */
      /* URL contains the currently set render parameters"                    */
      TestResult tr11 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTB5);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB6       */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalArgumentException if a relative path URL is specified"        */
      TestResult tr12 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTB6);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB7       */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setPortletMode has been called before       */
      /* this method "                                                        */
      TestResult tr13 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTB7);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB8       */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setWindowState has been called before       */
      /* this method "                                                        */
      TestResult tr14 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTB8);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB9       */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setRenderParameter has been called before   */
      /* this method "                                                        */
      TestResult tr15 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTB9);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB10      */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setRenderParameters has been called         */
      /* before this method "                                                 */
      TestResult tr16 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTB10);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB11      */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if removePublicRenderParameter has been        */
      /* called before this method"                                           */
      TestResult tr17 = tcd.getTestResultFailed(V2RESPONSETESTS_ACTIONRESPONSE_ACTION_SENDREDIRECTB11);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "ResponseTests_ActionResponse_Action",
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
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "ResponseTests_ActionResponse_Action", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "ResponseTests_ActionResponse_Action", APPLICATION_SCOPE);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectA1       */
      /* Details: "Method sendRedirect(String): Allows a redirect response    */
      /* to be sent to the client"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectA1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectA2       */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalArgumentException if a relative path URL is specified"        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectA2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectA3       */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setPortletMode has been called before       */
      /* this method "                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectA3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectA4       */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setWindowState has been called before       */
      /* this method "                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectA4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectA5       */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setRenderParameter has been called before   */
      /* this method "                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectA5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectA6       */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if setRenderParameters has been called         */
      /* before this method "                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectA6", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectA7       */
      /* Details: "Method sendRedirect(String): Throws                        */
      /* IllegalStateException if removePublicRenderParameter has been        */
      /* called before this method"                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectA7", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB1       */
      /* Details: "Method sendRedirect(String, String): Allows a redirect     */
      /* response to be sent to the client"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectB1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB2       */
      /* Details: "Method sendRedirect(String, String): Encodes a render      */
      /* URL as a parameter under the specified name on the redirect URL"     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectB2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB3       */
      /* Details: "Method sendRedirect(String, String): The encoded render    */
      /* URL contains the currently set PortletMode"                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectB3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB4       */
      /* Details: "Method sendRedirect(String, String): The encoded render    */
      /* URL contains the currently set WindowState"                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectB4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB5       */
      /* Details: "Method sendRedirect(String, String): The encoded render    */
      /* URL contains the currently set render parameters"                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectB5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB6       */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalArgumentException if a relative path URL is specified"        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectB6", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB7       */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setPortletMode has been called before       */
      /* this method "                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectB7", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB8       */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setWindowState has been called before       */
      /* this method "                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectB8", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB9       */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setRenderParameter has been called before   */
      /* this method "                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectB9", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB10      */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if setRenderParameters has been called         */
      /* before this method "                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectB10", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_ActionResponse_Action_sendRedirectB11      */
      /* Details: "Method sendRedirect(String, String): Throws                */
      /* IllegalStateException if removePublicRenderParameter has been        */
      /* called before this method"                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_ActionResponse_Action_sendRedirectB11", aurl);
         tb.writeTo(writer);
      }

   }

}
