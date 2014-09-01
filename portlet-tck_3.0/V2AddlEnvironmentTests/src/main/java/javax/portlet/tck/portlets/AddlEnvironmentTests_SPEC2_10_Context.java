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
 * portlet AddlEnvironmentTests_SPEC2_10_Context_event
 *
 */
public class AddlEnvironmentTests_SPEC2_10_Context implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlEnvironmentTests_SPEC2_10_Context.class.getName();
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

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_portletContextServletContext1 */
      /* Details: "The initialization parameters accessible through the       */
      /* PortletContext must be the same that are accessible through the      */
      /* ServletContext of the portlet application"                           */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_portletContextServletContext2 */
      /* Details: "The context initialization parameters are set in the       */
      /* web.xml file"                                                        */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_portletContextServletContext3 */
      /* Details: "The PortletContext must offer access to the same set of    */
      /* resources the ServletContext exposes"                                */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_portletContextServletContext4 */
      /* Details: "The temporary working directory must be accessible as a    */
      /* context attribute through the PortletContext using the attribute     */
      /* name \"javax.servlet.context.tempdir\""                              */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getAttribute       */
      /* Details: "The PortletContext.getAttribute method provides the same   */
      /* functionality as the ServletContext.getAttribute method"             */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETATTRIBUTE);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getAttributeNames  */
      /* Details: "The PortletContext.getAttributeNames method provides the   */
      /* same functionality as the ServletContext.getAttributeNames method"   */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETATTRIBUTENAMES);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getInitParameter   */
      /* Details: "The PortletContext.getInitParameter method provides the    */
      /* same functionality as the ServletContext.getInitParameter method"    */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETINITPARAMETER);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getInitParameterNames */
      /* Details: "The PortletContext.getInitParameterNames method provides   */
      /* the same functionality as the ServletContext.getInitParameterNames   */
      /* method"                                                              */
      TestResult tr7 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETINITPARAMETERNAMES);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getMimeType        */
      /* Details: "The PortletContext.getMimeType method provides the same    */
      /* functionality as the ServletContext.getMimeType method"              */
      TestResult tr8 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETMIMETYPE);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getRealPath        */
      /* Details: "The PortletContext.getRealPath method provides the same    */
      /* functionality as the ServletContext.getRealPath method"              */
      TestResult tr9 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETREALPATH);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getResource        */
      /* Details: "The PortletContext.getResource method provides the same    */
      /* functionality as the ServletContext.getResource method"              */
      TestResult tr10 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETRESOURCE);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getResourcePaths   */
      /* Details: "The PortletContext.getResourcePaths method provides the    */
      /* same functionality as the ServletContext.getResourcePaths method"    */
      TestResult tr11 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETRESOURCEPATHS);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getResourceAsStream */
      /* Details: "The PortletContext.getResourceAsStream method provides     */
      /* the same functionality as the ServletContext.getResourceAsStream     */
      /* method"                                                              */
      TestResult tr12 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETRESOURCEASSTREAM);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_log                */
      /* Details: "The PortletContext.log method provides the same            */
      /* functionality as the ServletContext.log method"                      */
      TestResult tr13 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_LOG);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_removeAttribute    */
      /* Details: "The PortletContext.removeAttribute method provides the     */
      /* same functionality as the ServletContext.removeAttribute method"     */
      TestResult tr14 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_REMOVEATTRIBUTE);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_setAttribute       */
      /* Details: "The PortletContext.setAttribute method provides the same   */
      /* functionality as the ServletContext.setAttribute method"             */
      TestResult tr15 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_SETATTRIBUTE);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

   }

}
