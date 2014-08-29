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
 * portlet URLTests_PortletURL_ApiRenderRenurl_event
 *
 */
public class URLTests_PortletURL_ApiRenderRenurl implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         URLTests_PortletURL_ApiRenderRenurl.class.getName();
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

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_setWindowState1      */
      /* Details: "Method setWindowState(WindowState): Sets the WindowState   */
      /* to be used when the URL is activated"                                */
      TestResult tr0 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETWINDOWSTATE1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_setWindowState2      */
      /* Details: "Method setWindowState(WindowState): Throws                 */
      /* WindowStateException if the portal does not support the specified    */
      /* Window State"                                                        */
      TestResult tr1 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETWINDOWSTATE2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_setWindowState3      */
      /* Details: "Method setWindowState(WindowState): Throws                 */
      /* WindowStateException if the specified WindowState is not declared    */
      /* in the deployment descriptor"                                        */
      TestResult tr2 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETWINDOWSTATE3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_setWindowState4      */
      /* Details: "Method setWindowState(WindowState): Throws                 */
      /* WindowStateException if the user is not allowed to switch to the     */
      /* specified WindowState"                                               */
      TestResult tr3 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETWINDOWSTATE4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode1      */
      /* Details: "Method setPortletMode(PortletMode): Sets the PortletMode   */
      /* to be used when the URL is activated"                                */
      TestResult tr4 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETPORTLETMODE1);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode2      */
      /* Details: "Method setPortletMode(PortletMode): Throws                 */
      /* PortletModeException if the portal does not support the specified    */
      /* Window State"                                                        */
      TestResult tr5 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETPORTLETMODE2);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode3      */
      /* Details: "Method setPortletMode(PortletMode): Throws                 */
      /* PortletModeException if the specified PortletMode is not declared    */
      /* in the deployment descriptor"                                        */
      TestResult tr6 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETPORTLETMODE3);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode4      */
      /* Details: "Method setPortletMode(PortletMode): Throws                 */
      /* PortletModeException if the user is not allowed to switch to the     */
      /* specified PortletMode"                                               */
      TestResult tr7 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETPORTLETMODE4);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_getPortletMode1      */
      /* Details: "Method getPortletMode(): Returns the PortletMode object    */
      /* set on the URL"                                                      */
      TestResult tr8 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETPORTLETMODE1);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_getPortletMode2      */
      /* Details: "Method getPortletMode(): Returns null if the PortletMode   */
      /* has not been set"                                                    */
      TestResult tr9 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETPORTLETMODE2);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_getWindowState1      */
      /* Details: "Method getWindowState(): Returns the WindowState object    */
      /* set on the URL"                                                      */
      TestResult tr10 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETWINDOWSTATE1);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_getWindowState2      */
      /* Details: "Method getWindowState(): Returns null if the Window        */
      /* State has not been set"                                              */
      TestResult tr11 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETWINDOWSTATE2);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_removePublicRenderParameter1 */
      /* Details: "Method removePublicRenderParameter(String): Removes the    */
      /* specified public render parameter"                                   */
      TestResult tr12 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_REMOVEPUBLICRENDERPARAMETER1);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_removePublicRenderParameter2 */
      /* Details: "Method removePublicRenderParameter(String): Throws         */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr13 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_REMOVEPUBLICRENDERPARAMETER2);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

   }

}
