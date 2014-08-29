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
 * portlet WrapperTests_PortletRequestWrapper_ApiRender_event
 *
 */
public class WrapperTests_PortletRequestWrapper_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         WrapperTests_PortletRequestWrapper_ApiRender.class.getName();
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

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getAttribute */
      /* Details: "Method getAttribute(String): Calls wrapped method"         */
      TestResult tr0 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETATTRIBUTE);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getAttributeNames */
      /* Details: "Method getAttributeNames(): Calls wrapped method"          */
      TestResult tr1 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETATTRIBUTENAMES);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getAuthType */
      /* Details: "Method getAuthType(): Calls wrapped method"                */
      TestResult tr2 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETAUTHTYPE);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getContextPath */
      /* Details: "Method getContextPath(): Calls wrapped method"             */
      TestResult tr3 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETCONTEXTPATH);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getCookies  */
      /* Details: "Method getCookies(): Calls wrapped method"                 */
      TestResult tr4 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETCOOKIES);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getLocale   */
      /* Details: "Method getLocale(): Calls wrapped method"                  */
      TestResult tr5 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETLOCALE);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getLocales  */
      /* Details: "Method getLocales(): Calls wrapped method"                 */
      TestResult tr6 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETLOCALES);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getParameter */
      /* Details: "Method getParameter(String): Calls wrapped method"         */
      TestResult tr7 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETER);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getParameterMap */
      /* Details: "Method getParameterMap(): Calls wrapped method"            */
      TestResult tr8 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETERMAP);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getParameterNames */
      /* Details: "Method getParameterNames(): Calls wrapped method"          */
      TestResult tr9 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETERNAMES);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getParameterValues */
      /* Details: "Method getParameterValues(String): Calls wrapped method"   */
      TestResult tr10 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETERVALUES);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getPortalContext */
      /* Details: "Method getPortalContext(): Calls wrapped method"           */
      TestResult tr11 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTALCONTEXT);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getPortletMode */
      /* Details: "Method getPortletMode(): Calls wrapped method"             */
      TestResult tr12 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTLETMODE);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getPortletSessionA */
      /* Details: "Method getPortletSession(): Calls wrapped method"          */
      TestResult tr13 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTLETSESSIONA);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getPortletSessionB */
      /* Details: "Method getPortletSession(boolean): Calls wrapped method"   */
      TestResult tr14 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTLETSESSIONB);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getPreferences */
      /* Details: "Method getPreferences(): Calls wrapped method"             */
      TestResult tr15 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPREFERENCES);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getProperties */
      /* Details: "Method getProperties(String): Calls wrapped method"        */
      TestResult tr16 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPROPERTIES);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getProperty */
      /* Details: "Method getProperty(String): Calls wrapped method"          */
      TestResult tr17 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPROPERTY);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getPropertyNames */
      /* Details: "Method getPropertyNames(): Calls wrapped method"           */
      TestResult tr18 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPROPERTYNAMES);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getRemoteUser */
      /* Details: "Method getRemoteUser(): Calls wrapped method"              */
      TestResult tr19 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETREMOTEUSER);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getRequestedSessionId */
      /* Details: "Method getRequestedSessionId(): Calls wrapped method"      */
      TestResult tr20 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETREQUESTEDSESSIONID);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getResponseContentType */
      /* Details: "Method getResponseContentType(): Calls wrapped method"     */
      TestResult tr21 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETRESPONSECONTENTTYPE);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getResponseContentTypes */
      /* Details: "Method getResponseContentTypes(): Calls wrapped method"    */
      TestResult tr22 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETRESPONSECONTENTTYPES);
      /* TODO: implement test */
      tr22.appendTcDetail("Not implemented.");
      tr22.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getScheme   */
      /* Details: "Method getScheme(): Calls wrapped method"                  */
      TestResult tr23 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETSCHEME);
      /* TODO: implement test */
      tr23.appendTcDetail("Not implemented.");
      tr23.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getServerName */
      /* Details: "Method getServerName(): Calls wrapped method"              */
      TestResult tr24 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETSERVERNAME);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getServerPort */
      /* Details: "Method getServerPort(): Calls wrapped method"              */
      TestResult tr25 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETSERVERPORT);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getUserPrincipal */
      /* Details: "Method getUserPrincipal(): Calls wrapped method"           */
      TestResult tr26 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETUSERPRINCIPAL);
      /* TODO: implement test */
      tr26.appendTcDetail("Not implemented.");
      tr26.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getWindowID */
      /* Details: "Method getWindowID(): Calls wrapped method"                */
      TestResult tr27 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETWINDOWID);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getWindowState */
      /* Details: "Method getWindowState(): Calls wrapped method"             */
      TestResult tr28 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETWINDOWSTATE);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_isPortletModeAllowed */
      /* Details: "Method isPortletModeAllowed(PortletMode): Calls wrapped    */
      /* method"                                                              */
      TestResult tr29 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISPORTLETMODEALLOWED);
      /* TODO: implement test */
      tr29.appendTcDetail("Not implemented.");
      tr29.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_isRequestedSessionIdValid */
      /* Details: "Method isRequestedSessionIdValid(): Calls wrapped          */
      /* method"                                                              */
      TestResult tr30 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISREQUESTEDSESSIONIDVALID);
      /* TODO: implement test */
      tr30.appendTcDetail("Not implemented.");
      tr30.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_isSecure    */
      /* Details: "Method isSecure(): Calls wrapped method"                   */
      TestResult tr31 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISSECURE);
      /* TODO: implement test */
      tr31.appendTcDetail("Not implemented.");
      tr31.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_isUserInRole */
      /* Details: "Method isUserInRole(): Calls wrapped method"               */
      TestResult tr32 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISUSERINROLE);
      /* TODO: implement test */
      tr32.appendTcDetail("Not implemented.");
      tr32.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_isWindowStateAllowed */
      /* Details: "Method isWindowStateAllowed(WindowState): Calls wrapped    */
      /* method"                                                              */
      TestResult tr33 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISWINDOWSTATEALLOWED);
      /* TODO: implement test */
      tr33.appendTcDetail("Not implemented.");
      tr33.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_removeAttribute */
      /* Details: "Method removeAttribute(String): Calls wrapped method"      */
      TestResult tr34 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_REMOVEATTRIBUTE);
      /* TODO: implement test */
      tr34.appendTcDetail("Not implemented.");
      tr34.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_setAttribute */
      /* Details: "Method setAttribute(String, Object): Calls wrapped         */
      /* method"                                                              */
      TestResult tr35 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_SETATTRIBUTE);
      /* TODO: implement test */
      tr35.appendTcDetail("Not implemented.");
      tr35.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getRequest  */
      /* Details: "Method getRequest(): Returns wrapped PortletRequest        */
      /* object"                                                              */
      TestResult tr36 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETREQUEST);
      /* TODO: implement test */
      tr36.appendTcDetail("Not implemented.");
      tr36.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_setRequest  */
      /* Details: "Method setRequest(PortletRequest): Allows wrapped          */
      /* PortletRequest object to be set"                                     */
      TestResult tr37 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_SETREQUEST);
      /* TODO: implement test */
      tr37.appendTcDetail("Not implemented.");
      tr37.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getPrivateParameterMap */
      /* Details: "Method getPrivateParameterMap(): Calls wrapped method"     */
      TestResult tr38 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPRIVATEPARAMETERMAP);
      /* TODO: implement test */
      tr38.appendTcDetail("Not implemented.");
      tr38.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getPublicParameterMap */
      /* Details: "Method getPublicParameterMap(): Calls wrapped method"      */
      TestResult tr39 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPUBLICPARAMETERMAP);
      /* TODO: implement test */
      tr39.appendTcDetail("Not implemented.");
      tr39.writeTo(writer);

   }

}
