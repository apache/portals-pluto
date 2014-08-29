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
 * portlet EnvironmentTests_PortletRequestDispatcher_ApiRender_event
 *
 */
public class EnvironmentTests_PortletRequestDispatcher_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         EnvironmentTests_PortletRequestDispatcher_ApiRender.class.getName();
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

      /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA1 */
      /* Details: "Method include(PortletRequest, PortletResponse):           */
      /* Includes the content of a JSP page in the response"                  */
      TestResult tr0 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA2 */
      /* Details: "Method include(PortletRequest, PortletResponse):           */
      /* Includes the content of a HTML Page in the response"                 */
      TestResult tr1 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA3 */
      /* Details: "Method include(PortletRequest, PortletResponse): The       */
      /* included servlet cannot change the status code. The attempt is       */
      /* ignored"                                                             */
      TestResult tr2 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA4 */
      /* Details: "Method include(PortletRequest, PortletResponse): The       */
      /* included servlet cannot set the headers. The attempt is ignored"     */
      TestResult tr3 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB1 */
      /* Details: "Method include(RenderRequest, RenderResponse): Includes    */
      /* the content of a JSP page in the response"                           */
      TestResult tr4 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB1);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB2 */
      /* Details: "Method include(RenderRequest, RenderResponse): Includes    */
      /* the content of a HTML Page in the response"                          */
      TestResult tr5 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB2);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB3 */
      /* Details: "Method include(RenderRequest, RenderResponse): The         */
      /* included servlet cannot change the status code. The attempt is       */
      /* ignored"                                                             */
      TestResult tr6 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB3);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB4 */
      /* Details: "Method include(RenderRequest, RenderResponse): The         */
      /* included servlet cannot set the headers. The attempt is ignored"     */
      TestResult tr7 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB4);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward1 */
      /* Details: "Method forward(PortletRequest, PortletResponse): Can       */
      /* forward to a JSP page to create the response"                        */
      TestResult tr8 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD1);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward2 */
      /* Details: "Method forward(PortletRequest, PortletResponse): Can       */
      /* forward to a HTML Page to create the response"                       */
      TestResult tr9 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD2);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward3 */
      /* Details: "Method forward(PortletRequest, PortletResponse): Throws    */
      /* IllegalStateException if the response was already committed"         */
      TestResult tr10 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD3);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward4 */
      /* Details: "Method forward(PortletRequest, PortletResponse): Throws    */
      /* PortletException if the forwarded servlet throws any excpetion       */
      /* other than IOException or a runtime exception "                      */
      TestResult tr11 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD4);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

   }

}
