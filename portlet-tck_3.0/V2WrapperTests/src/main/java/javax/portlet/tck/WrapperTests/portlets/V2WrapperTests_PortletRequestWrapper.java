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

package javax.portlet.tck.WrapperTests.portlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */
public class V2WrapperTests_PortletRequestWrapper implements Portlet {
   private static final String LOG_CLASS = 
         V2WrapperTests_PortletRequestWrapper.class.getName();
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
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
         throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest renderRequest, RenderResponse renderResponse)
         throws PortletException, IOException {
      
      if (LOGGER.isLoggable(Level.FINE)) {
         LOGGER.logp(Level.FINE, LOG_CLASS, "render", "Entry");
      }

      PrintWriter writer = renderResponse.getWriter();
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
      ClassChecker cc = new ClassChecker(PortletRequestWrapper.class);

      // Create result objects for the tests

      /* TestCase: PortletRequestWrapper_getAttribute */
      /* Details: "Calls wrapped method" */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETATTRIBUTE);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getAttributeNames */
      /* Details: "Calls wrapped method" */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETATTRIBUTENAMES);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getAuthType */
      /* Details: "Calls wrapped method" */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETAUTHTYPE);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getContextPath */
      /* Details: "Calls wrapped method" */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETCONTEXTPATH);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getCookies */
      /* Details: "Calls wrapped method" */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETCOOKIES);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getLocale */
      /* Details: "Calls wrapped method" */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETLOCALE);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getLocales */
      /* Details: "Calls wrapped method" */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETLOCALES);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getParameter */
      /* Details: "Calls wrapped method" */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETPARAMETER);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getParameterMap */
      /* Details: "Calls wrapped method" */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETPARAMETERMAP);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getParameterNames */
      /* Details: "Calls wrapped method" */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETPARAMETERNAMES);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getParameterValues */
      /* Details: "Calls wrapped method" */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETPARAMETERVALUES);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getPortalContext */
      /* Details: "Calls wrapped method" */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETPORTALCONTEXT);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getPortletMode */
      /* Details: "Calls wrapped method" */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETPORTLETMODE);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getPortletSessionA */
      /* Details: "Calls wrapped method" */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETPORTLETSESSIONA);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getPortletSessionB */
      /* Details: "Calls wrapped method" */
      TestResult tr14 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETPORTLETSESSIONB);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getPreferences */
      /* Details: "Calls wrapped method" */
      TestResult tr15 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETPREFERENCES);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getProperties */
      /* Details: "Calls wrapped method" */
      TestResult tr16 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETPROPERTIES);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getProperty */
      /* Details: "Calls wrapped method" */
      TestResult tr17 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETPROPERTY);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getPropertyNames */
      /* Details: "Calls wrapped method" */
      TestResult tr18 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETPROPERTYNAMES);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getRemoteUser */
      /* Details: "Calls wrapped method" */
      TestResult tr19 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETREMOTEUSER);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getRequestedSessionId */
      /* Details: "Calls wrapped method" */
      TestResult tr20 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETREQUESTEDSESSIONID);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getResponseContentType */
      /* Details: "Calls wrapped method" */
      TestResult tr21 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETRESPONSECONTENTTYPE);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getResponseContentTypes */
      /* Details: "Calls wrapped method" */
      TestResult tr22 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETRESPONSECONTENTTYPES);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getScheme */
      /* Details: "Calls wrapped method" */
      TestResult tr23 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETSCHEME);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getServerName */
      /* Details: "Calls wrapped method" */
      TestResult tr24 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETSERVERNAME);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getServerPort */
      /* Details: "Calls wrapped method" */
      TestResult tr25 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETSERVERPORT);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getUserPrincipal */
      /* Details: "Calls wrapped method" */
      TestResult tr26 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETUSERPRINCIPAL);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getWindowID */
      /* Details: "Calls wrapped method" */
      TestResult tr27 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETWINDOWID);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getWindowState */
      /* Details: "Calls wrapped method" */
      TestResult tr28 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETWINDOWSTATE);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_isPortletModeAllowed */
      /* Details: "Calls wrapped method" */
      TestResult tr29 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_ISPORTLETMODEALLOWED);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_isRequestedSessionIdValid */
      /* Details: "Calls wrapped method" */
      TestResult tr30 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_ISREQUESTEDSESSIONIDVALID);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_isSecure */
      /* Details: "Calls wrapped method" */
      TestResult tr31 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_ISSECURE);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_isUserInRole */
      /* Details: "Calls wrapped method" */
      TestResult tr32 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_ISUSERINROLE);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_isWindowStateAllowed */
      /* Details: "Calls wrapped method" */
      TestResult tr33 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_ISWINDOWSTATEALLOWED);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_removeAttribute */
      /* Details: "Calls wrapped method" */
      TestResult tr34 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_REMOVEATTRIBUTE);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_setAttribute */
      /* Details: "Calls wrapped method" */
      TestResult tr35 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SETATTRIBUTE);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getRequest */
      /* Details: "Returns wrapped PortletRequest object" */
      TestResult tr36 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETREQUEST);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_setRequest */
      /* Details: "Allows wrapped PortletRequest object to be set" */
      TestResult tr37 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SETREQUEST);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getPrivateParameterMap */
      /* Details: "Calls wrapped method" */
      TestResult tr38 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETPRIVATEPARAMETERMAP);
      /* TODO: implement test */

      /* TestCase: PortletRequestWrapper_getPublicParameterMap */
      /* Details: "Calls wrapped method" */
      TestResult tr39 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_GETPUBLICPARAMETERMAP);
      /* TODO: implement test */



      // Write the results to the output stream

      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);
      tr3.writeTo(writer);
      tr4.writeTo(writer);
      tr5.writeTo(writer);
      tr6.writeTo(writer);
      tr7.writeTo(writer);
      tr8.writeTo(writer);
      tr9.writeTo(writer);
      tr10.writeTo(writer);
      tr11.writeTo(writer);
      tr12.writeTo(writer);
      tr13.writeTo(writer);
      tr14.writeTo(writer);
      tr15.writeTo(writer);
      tr16.writeTo(writer);
      tr17.writeTo(writer);
      tr18.writeTo(writer);
      tr19.writeTo(writer);
      tr20.writeTo(writer);
      tr21.writeTo(writer);
      tr22.writeTo(writer);
      tr23.writeTo(writer);
      tr24.writeTo(writer);
      tr25.writeTo(writer);
      tr26.writeTo(writer);
      tr27.writeTo(writer);
      tr28.writeTo(writer);
      tr29.writeTo(writer);
      tr30.writeTo(writer);
      tr31.writeTo(writer);
      tr32.writeTo(writer);
      tr33.writeTo(writer);
      tr34.writeTo(writer);
      tr35.writeTo(writer);
      tr36.writeTo(writer);
      tr37.writeTo(writer);
      tr38.writeTo(writer);
      tr39.writeTo(writer);


   }

}

