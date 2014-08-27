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
 * portlet SigTestsFilter_FilterConfig_SIGRender_event
 *
 */
public class SigTestsFilter_FilterConfig_SIGRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         SigTestsFilter_FilterConfig_SIGRender.class.getName();
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

      JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetFilterName   */
      /* Details: "FilterConfig has a getFilterName()  method "               */
      TestResult tr0 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETFILTERNAME);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetFilterNameReturns */
      /* Details: "FilterConfig method getFilterName() returns String "       */
      TestResult tr1 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETFILTERNAMERETURNS);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetInitParameter */
      /* Details: "FilterConfig has a getInitParameter(String)  method "      */
      TestResult tr2 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETER);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetInitParameterNames */
      /* Details: "FilterConfig has a getInitParameterNames()  method "       */
      TestResult tr3 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETERNAMES);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetInitParameterNamesReturns */
      /* Details: "FilterConfig method getInitParameterNames() returns        */
      /* java.util.Enumeration "                                              */
      TestResult tr4 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetInitParameterReturns */
      /* Details: "FilterConfig method getInitParameter(String) returns       */
      /* String "                                                             */
      TestResult tr5 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETERRETURNS);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetPortletContext */
      /* Details: "FilterConfig has a getPortletContext()  method "           */
      TestResult tr6 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETPORTLETCONTEXT);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetPortletContextReturns */
      /* Details: "FilterConfig method getPortletContext() returns            */
      /* PortletContext "                                                     */
      TestResult tr7 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETPORTLETCONTEXTRETURNS);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

   }

}
