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
 * portlet RequestTests_PortletRequest_ApiRender_event
 *
 */
public class RequestTests_PortletRequest_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         RequestTests_PortletRequest_ApiRender.class.getName();
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

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_fieldUSER_INFO     */
      /* Details: "Has String field USER_INFO with value of                   */
      /* \"javax.portlet.userinfo\" "                                         */
      TestResult tr0 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDUSER_INFO);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_fieldCCPP_PROFILE  */
      /* Details: "Has String field CCPP_PROFILE with value of                */
      /* \"javax.portlet.ccpp\" "                                             */
      TestResult tr1 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDCCPP_PROFILE);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_fieldBASIC_AUTH    */
      /* Details: "Has String field BASIC_AUTH with value of \"BASIC\" "      */
      TestResult tr2 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDBASIC_AUTH);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_fieldFORM_AUTH     */
      /* Details: "Has String field FORM_AUTH with value of \"FORM\" "        */
      TestResult tr3 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDFORM_AUTH);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_fieldCLIENT_CERT_AUTH */
      /* Details: "Has String field CLIENT_CERT_AUTH with value of            */
      /* \"CLIENT_CERT\" "                                                    */
      TestResult tr4 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDCLIENT_CERT_AUTH);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_fieldDIGEST_AUTH   */
      /* Details: "Has String field DIGEST_AUTH with value of \"DIGEST\" "    */
      TestResult tr5 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDDIGEST_AUTH);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_fieldACTION_PHASE  */
      /* Details: "Has String field ACTION_PHASE with value of                */
      /* \"ACTION_PHASE\" "                                                   */
      TestResult tr6 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDACTION_PHASE);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_fieldEVENT_PHASE   */
      /* Details: "Has String field EVENT_PHASE with value of                 */
      /* \"EVENT_PHASE\" "                                                    */
      TestResult tr7 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDEVENT_PHASE);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_fieldRENDER_PHASE  */
      /* Details: "Has String field RENDER_PHASE with value of                */
      /* \"RENDER_PHASE\" "                                                   */
      TestResult tr8 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDRENDER_PHASE);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_fieldRESOURCE_PHASE */
      /* Details: "Has String field RESOURCE_PHASE with value of              */
      /* \"RESOURCE_PHASE\" "                                                 */
      TestResult tr9 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDRESOURCE_PHASE);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_fieldLIFECYCLE_PHASE */
      /* Details: "Has String field LIFECYCLE_PHASE with value of             */
      /* \"javax.portlet.lifecycle_phase\" "                                  */
      TestResult tr10 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDLIFECYCLE_PHASE);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_fieldRENDER_PART   */
      /* Details: "Has String field RENDER_PART with value of                 */
      /* \"javax.portlet.render_part\" "                                      */
      TestResult tr11 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDRENDER_PART);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_fieldRENDER_HEADERS */
      /* Details: "Has String field RENDER_HEADERS with value of              */
      /* \"RENDER_HEADERS\" "                                                 */
      TestResult tr12 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDRENDER_HEADERS);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_fieldRENDER_MARKUP */
      /* Details: "Has String field RENDER_MARKUP with value of               */
      /* \"RENDER_MARKUP\" "                                                  */
      TestResult tr13 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDRENDER_MARKUP);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_fieldACTION_SCOPE_ID */
      /* Details: "Has String field ACTION_SCOPE_ID with value of             */
      /* \"javax.portlet.as\" "                                               */
      TestResult tr14 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDACTION_SCOPE_ID);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_isWindowStateAllowed1 */
      /* Details: "Method isWindowStateAllowed(WindowState): Returns true     */
      /* if the specified WindowState is allowed"                             */
      TestResult tr15 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISWINDOWSTATEALLOWED1);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_isWindowStateAllowed2 */
      /* Details: "Method isWindowStateAllowed(WindowState): Returns false    */
      /* if the specified WindowState is not allowed"                         */
      TestResult tr16 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISWINDOWSTATEALLOWED2);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_isPortletModeAllowed1 */
      /* Details: "Method isPortletModeAllowed(PortletMode): Returns true     */
      /* if the specified PortletMode is allowed"                             */
      TestResult tr17 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISPORTLETMODEALLOWED1);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_isPortletModeAllowed2 */
      /* Details: "Method isPortletModeAllowed(PortletMode): Returns false    */
      /* if the specified PortletMode is not allowed"                         */
      TestResult tr18 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISPORTLETMODEALLOWED2);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPortletMode     */
      /* Details: "Method getPortletMode(): Returns current PortletMode "     */
      TestResult tr19 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETMODE);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getWindowState     */
      /* Details: "Method getWindowState(): Returns current WindowState"      */
      TestResult tr20 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETWINDOWSTATE);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPreferences     */
      /* Details: "Method getPreferences(): Returns the PortletPreferences    */
      /* object associated with the portlet"                                  */
      TestResult tr21 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPREFERENCES);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPortletSessionA1 */
      /* Details: "Method getPortletSession(): Returns current                */
      /* PortletSession if one already exists"                                */
      TestResult tr22 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONA1);
      /* TODO: implement test */
      tr22.appendTcDetail("Not implemented.");
      tr22.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPortletSessionA2 */
      /* Details: "Method getPortletSession(): Returns new PortletSession     */
      /* if one does not already exist"                                       */
      TestResult tr23 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONA2);
      /* TODO: implement test */
      tr23.appendTcDetail("Not implemented.");
      tr23.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPortletSessionB1 */
      /* Details: "Method getPortletSession(boolean): If input flag is        */
      /* true, returns current PortletSession if one already exists"          */
      TestResult tr24 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONB1);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPortletSessionB2 */
      /* Details: "Method getPortletSession(boolean): If input flag is        */
      /* true, returns new PortletSession if one does not already exist"      */
      TestResult tr25 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONB2);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPortletSessionB3 */
      /* Details: "Method getPortletSession(boolean): If input flag is        */
      /* false, returns current PortletSession if one already exists"         */
      TestResult tr26 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONB3);
      /* TODO: implement test */
      tr26.appendTcDetail("Not implemented.");
      tr26.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPortletSessionB4 */
      /* Details: "Method getPortletSession(boolean): If input flag is        */
      /* false, returns null if one does not already exist"                   */
      TestResult tr27 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONB4);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getProperty1       */
      /* Details: "Method getProperty(String): If specified request           */
      /* property exists, returns its value "                                 */
      TestResult tr28 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTY1);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getProperty2       */
      /* Details: "Method getProperty(String): If specified request           */
      /* property does not exist, returns null"                               */
      TestResult tr29 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTY2);
      /* TODO: implement test */
      tr29.appendTcDetail("Not implemented.");
      tr29.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getProperty3       */
      /* Details: "Method getProperty(String): Throws                         */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr30 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTY3);
      /* TODO: implement test */
      tr30.appendTcDetail("Not implemented.");
      tr30.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getProperties1     */
      /* Details: "Method getProperties(String): If specified request         */
      /* property exists, returns its values as an Enumeration "              */
      TestResult tr31 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTIES1);
      /* TODO: implement test */
      tr31.appendTcDetail("Not implemented.");
      tr31.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getProperties2     */
      /* Details: "Method getProperties(String): If specified request         */
      /* property does not exist, returns an empty Enumeration"               */
      TestResult tr32 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTIES2);
      /* TODO: implement test */
      tr32.appendTcDetail("Not implemented.");
      tr32.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getProperties3     */
      /* Details: "Method getProperties(String): Throws                       */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr33 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTIES3);
      /* TODO: implement test */
      tr33.appendTcDetail("Not implemented.");
      tr33.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPropertyNames1  */
      /* Details: "Method getPropertyNames(): Returns an Enumeration of all   */
      /* request property names"                                              */
      TestResult tr34 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTYNAMES1);
      /* TODO: implement test */
      tr34.appendTcDetail("Not implemented.");
      tr34.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPropertyNames2  */
      /* Details: "Method getPropertyNames(): Returns an empty Enumeration    */
      /* if there are no request properties defined"                          */
      TestResult tr35 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTYNAMES2);
      /* TODO: implement test */
      tr35.appendTcDetail("Not implemented.");
      tr35.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPortalContext   */
      /* Details: "Method getPortalContext(): Returns the context of the      */
      /* portal"                                                              */
      TestResult tr36 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTALCONTEXT);
      /* TODO: implement test */
      tr36.appendTcDetail("Not implemented.");
      tr36.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getAuthType1       */
      /* Details: "Method getAuthType(): Returns a String indicating the      */
      /* authentication type if the request was authenticated"                */
      TestResult tr37 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETAUTHTYPE1);
      /* TODO: implement test */
      tr37.appendTcDetail("Not implemented.");
      tr37.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getAuthType2       */
      /* Details: "Method getAuthType(): Returns null if the request was      */
      /* not authenticated"                                                   */
      TestResult tr38 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETAUTHTYPE2);
      /* TODO: implement test */
      tr38.appendTcDetail("Not implemented.");
      tr38.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getContextPath1    */
      /* Details: "Method getContextPath(): Returns a String representing     */
      /* the context path associated with the portlet"                        */
      TestResult tr39 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETCONTEXTPATH1);
      /* TODO: implement test */
      tr39.appendTcDetail("Not implemented.");
      tr39.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getContextPath2    */
      /* Details: "Method getContextPath(): Returns an empty String if the    */
      /* portlet is deployed in the default context"                          */
      TestResult tr40 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETCONTEXTPATH2);
      /* TODO: implement test */
      tr40.appendTcDetail("Not implemented.");
      tr40.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getContextPath3    */
      /* Details: "Method getContextPath(): If the context path is not        */
      /* empty, it must start with \"/\" and may not end with \"/\""          */
      TestResult tr41 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETCONTEXTPATH3);
      /* TODO: implement test */
      tr41.appendTcDetail("Not implemented.");
      tr41.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getRemoteUser1     */
      /* Details: "Method getRemoteUser(): Returns a String representing      */
      /* the login of the user if the request is authenticated"               */
      TestResult tr42 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETREMOTEUSER1);
      /* TODO: implement test */
      tr42.appendTcDetail("Not implemented.");
      tr42.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getRemoteUser2     */
      /* Details: "Method getRemoteUser(): Returns null if the request has    */
      /* not been authenticated"                                              */
      TestResult tr43 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETREMOTEUSER2);
      /* TODO: implement test */
      tr43.appendTcDetail("Not implemented.");
      tr43.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getUserPrincipal1  */
      /* Details: "Method getUserPrincipal(): Returns a                       */
      /* java.security.Principal object representing the user if the          */
      /* request has been authenticated"                                      */
      TestResult tr44 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETUSERPRINCIPAL1);
      /* TODO: implement test */
      tr44.appendTcDetail("Not implemented.");
      tr44.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getUserPrincipal2  */
      /* Details: "Method getUserPrincipal(): Returns null if the request     */
      /* has not been authenticated"                                          */
      TestResult tr45 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETUSERPRINCIPAL2);
      /* TODO: implement test */
      tr45.appendTcDetail("Not implemented.");
      tr45.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_isUserInRole1      */
      /* Details: "Method isUserInRole(): Returns true if the authenticated   */
      /* user is in the specified role"                                       */
      TestResult tr46 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISUSERINROLE1);
      /* TODO: implement test */
      tr46.appendTcDetail("Not implemented.");
      tr46.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_isUserInRole2      */
      /* Details: "Method isUserInRole(): Returns false if the                */
      /* authenticated user is not in the specified role"                     */
      TestResult tr47 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISUSERINROLE2);
      /* TODO: implement test */
      tr47.appendTcDetail("Not implemented.");
      tr47.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_isUserInRole3      */
      /* Details: "Method isUserInRole(): Returns false if the user is not    */
      /* authenticated"                                                       */
      TestResult tr48 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISUSERINROLE3);
      /* TODO: implement test */
      tr48.appendTcDetail("Not implemented.");
      tr48.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getAttribute1      */
      /* Details: "Method getAttribute(String): Returns a java.lang.Object    */
      /* for the specified attribute name"                                    */
      TestResult tr49 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETATTRIBUTE1);
      /* TODO: implement test */
      tr49.appendTcDetail("Not implemented.");
      tr49.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getAttribute2      */
      /* Details: "Method getAttribute(String): Returns null if no            */
      /* attribute with the specified name exists"                            */
      TestResult tr50 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETATTRIBUTE2);
      /* TODO: implement test */
      tr50.appendTcDetail("Not implemented.");
      tr50.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getAttribute3      */
      /* Details: "Method getAttribute(String): Throws                        */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr51 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETATTRIBUTE3);
      /* TODO: implement test */
      tr51.appendTcDetail("Not implemented.");
      tr51.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getAttributeNames1 */
      /* Details: "Method getAttributeNames(): Returns a                      */
      /* java.util.Enumeration&lt;java.lang.String&gt; of the available       */
      /* attribute names"                                                     */
      TestResult tr52 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETATTRIBUTENAMES1);
      /* TODO: implement test */
      tr52.appendTcDetail("Not implemented.");
      tr52.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getAttributeNames2 */
      /* Details: "Method getAttributeNames(): Returns an empty Enumeration   */
      /* if there are no attributes available"                                */
      TestResult tr53 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETATTRIBUTENAMES2);
      /* TODO: implement test */
      tr53.appendTcDetail("Not implemented.");
      tr53.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getParameter1      */
      /* Details: "Method getParameter(String): Returns String value of       */
      /* parameter specified by the name"                                     */
      TestResult tr54 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETER1);
      /* TODO: implement test */
      tr54.appendTcDetail("Not implemented.");
      tr54.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getParameter2      */
      /* Details: "Method getParameter(String): Returns String value of a     */
      /* public render parameter specified by the name"                       */
      TestResult tr55 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETER2);
      /* TODO: implement test */
      tr55.appendTcDetail("Not implemented.");
      tr55.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getParameter3      */
      /* Details: "Method getParameter(String): Returns null if no            */
      /* parameter exists for the specified name"                             */
      TestResult tr56 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETER3);
      /* TODO: implement test */
      tr56.appendTcDetail("Not implemented.");
      tr56.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getParameter4      */
      /* Details: "Method getParameter(String): Returns first String value    */
      /* from values array if use with a multivalued parameter"               */
      TestResult tr57 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETER4);
      /* TODO: implement test */
      tr57.appendTcDetail("Not implemented.");
      tr57.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getParameter5      */
      /* Details: "Method getParameter(String): Throws                        */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr58 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETER5);
      /* TODO: implement test */
      tr58.appendTcDetail("Not implemented.");
      tr58.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getParameterNames1 */
      /* Details: "Method getParameterNames(): Returns a                      */
      /* java.util.Enumeration&lt;java.lang.String&gt; of the available       */
      /* parameter names"                                                     */
      TestResult tr59 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERNAMES1);
      /* TODO: implement test */
      tr59.appendTcDetail("Not implemented.");
      tr59.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getParameterNames2 */
      /* Details: "Method getParameterNames(): Returns an empty Enumeration   */
      /* if there are no parameters available"                                */
      TestResult tr60 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERNAMES2);
      /* TODO: implement test */
      tr60.appendTcDetail("Not implemented.");
      tr60.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getParameterValues1 */
      /* Details: "Method getParameterValues(String): Returns String[]        */
      /* value of parameter specified by the name"                            */
      TestResult tr61 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERVALUES1);
      /* TODO: implement test */
      tr61.appendTcDetail("Not implemented.");
      tr61.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getParameterValues2 */
      /* Details: "Method getParameterValues(String): Returns String[]        */
      /* value of a public render parameter specified by the name"            */
      TestResult tr62 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERVALUES2);
      /* TODO: implement test */
      tr62.appendTcDetail("Not implemented.");
      tr62.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getParameterValues3 */
      /* Details: "Method getParameterValues(String): Returns null if no      */
      /* parameter exists for the specified name"                             */
      TestResult tr63 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERVALUES3);
      /* TODO: implement test */
      tr63.appendTcDetail("Not implemented.");
      tr63.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getParameterValues4 */
      /* Details: "Method getParameterValues(String): Throws                  */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr64 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERVALUES4);
      /* TODO: implement test */
      tr64.appendTcDetail("Not implemented.");
      tr64.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getParameterMap1   */
      /* Details: "Method getParameterMap(): Returns an                       */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object      */
      /* for the parameter names and values if parameters are available"      */
      TestResult tr65 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERMAP1);
      /* TODO: implement test */
      tr65.appendTcDetail("Not implemented.");
      tr65.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getParameterMap2   */
      /* Details: "Method getParameterMap(): The returned map contains all    */
      /* public and private parameters for the request"                       */
      TestResult tr66 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERMAP2);
      /* TODO: implement test */
      tr66.appendTcDetail("Not implemented.");
      tr66.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getParameterMap3   */
      /* Details: "Method getParameterMap(): Returns an empty map if no       */
      /* parameters exist"                                                    */
      TestResult tr67 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERMAP3);
      /* TODO: implement test */
      tr67.appendTcDetail("Not implemented.");
      tr67.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_isSecure1          */
      /* Details: "Method isSecure(): Returns true if the request was made    */
      /* through a secure channel"                                            */
      TestResult tr68 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISSECURE1);
      /* TODO: implement test */
      tr68.appendTcDetail("Not implemented.");
      tr68.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_isSecure2          */
      /* Details: "Method isSecure(): Returns false if the request was not    */
      /* made through a secure channel"                                       */
      TestResult tr69 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISSECURE2);
      /* TODO: implement test */
      tr69.appendTcDetail("Not implemented.");
      tr69.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_setAttribute1      */
      /* Details: "Method setAttribute(String, Object): Stores an attribute   */
      /* object under the specified name in the request"                      */
      TestResult tr70 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_SETATTRIBUTE1);
      /* TODO: implement test */
      tr70.appendTcDetail("Not implemented.");
      tr70.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_setAttribute2      */
      /* Details: "Method setAttribute(String, Object): Removes the           */
      /* attribute by the specified name if the object is null"               */
      TestResult tr71 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_SETATTRIBUTE2);
      /* TODO: implement test */
      tr71.appendTcDetail("Not implemented.");
      tr71.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_setAttribute3      */
      /* Details: "Method setAttribute(String, Object): Throws                */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr72 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_SETATTRIBUTE3);
      /* TODO: implement test */
      tr72.appendTcDetail("Not implemented.");
      tr72.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_removeAttribute1   */
      /* Details: "Method removeAttribute(String): Removes the attribute      */
      /* specified by the name from the request"                              */
      TestResult tr73 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_REMOVEATTRIBUTE1);
      /* TODO: implement test */
      tr73.appendTcDetail("Not implemented.");
      tr73.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_removeAttribute2   */
      /* Details: "Method removeAttribute(String): Throws                     */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr74 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_REMOVEATTRIBUTE2);
      /* TODO: implement test */
      tr74.appendTcDetail("Not implemented.");
      tr74.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getRequestedSessionId1 */
      /* Details: "Method getRequestedSessionId(): Returns the session ID     */
      /* indicated in the client request"                                     */
      TestResult tr75 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETREQUESTEDSESSIONID1);
      /* TODO: implement test */
      tr75.appendTcDetail("Not implemented.");
      tr75.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getRequestedSessionId2 */
      /* Details: "Method getRequestedSessionId(): Returns null if no         */
      /* session ID was indicated in the client request"                      */
      TestResult tr76 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETREQUESTEDSESSIONID2);
      /* TODO: implement test */
      tr76.appendTcDetail("Not implemented.");
      tr76.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_isRequestedSessionIdValid1 */
      /* Details: "Method isRequestedSessionIdValid(): Returns true if the    */
      /* session ID is valid"                                                 */
      TestResult tr77 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISREQUESTEDSESSIONIDVALID1);
      /* TODO: implement test */
      tr77.appendTcDetail("Not implemented.");
      tr77.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_isRequestedSessionIdValid2 */
      /* Details: "Method isRequestedSessionIdValid(): Returns false if the   */
      /* session ID is not valid"                                             */
      TestResult tr78 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISREQUESTEDSESSIONIDVALID2);
      /* TODO: implement test */
      tr78.appendTcDetail("Not implemented.");
      tr78.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getResponseContentType1 */
      /* Details: "Method getResponseContentType(): Returns a String          */
      /* representing the portal preferred content type for the response if   */
      /* the content type is defined in the portlet descriptor  "             */
      TestResult tr79 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETRESPONSECONTENTTYPE1);
      /* TODO: implement test */
      tr79.appendTcDetail("Not implemented.");
      tr79.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getResponseContentType2 */
      /* Details: "Method getResponseContentType(): Returns an empty          */
      /* Enumeration if the content type is not defined in the portlet        */
      /* descriptor"                                                          */
      TestResult tr80 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETRESPONSECONTENTTYPE2);
      /* TODO: implement test */
      tr80.appendTcDetail("Not implemented.");
      tr80.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getResponseContentTypes1 */
      /* Details: "Method getResponseContentTypes(): Returns an               */
      /* java.util.Enumeration&lt;java.lang.String&gt; object representing    */
      /* the portal preferred content types for the response if the content   */
      /* types are defined in the portlet descriptor"                         */
      TestResult tr81 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETRESPONSECONTENTTYPES1);
      /* TODO: implement test */
      tr81.appendTcDetail("Not implemented.");
      tr81.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getResponseContentTypes2 */
      /* Details: "Method getResponseContentTypes(): Returns an empty         */
      /* Enumeration if the content types are not defined in the portlet      */
      /* descriptor"                                                          */
      TestResult tr82 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETRESPONSECONTENTTYPES2);
      /* TODO: implement test */
      tr82.appendTcDetail("Not implemented.");
      tr82.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getLocale          */
      /* Details: "Method getLocale(): Returns an java.util.Locale object     */
      /* representing the preferred Locale for the response"                  */
      TestResult tr83 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETLOCALE);
      /* TODO: implement test */
      tr83.appendTcDetail("Not implemented.");
      tr83.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getLocales         */
      /* Details: "Method getLocales(): Returns an                            */
      /* java.util.Enumeration&lt;java.util.Locale&gt; of the Locales in      */
      /* which the portal will accept content"                                */
      TestResult tr84 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETLOCALES);
      /* TODO: implement test */
      tr84.appendTcDetail("Not implemented.");
      tr84.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getScheme          */
      /* Details: "Method getScheme(): Returns a String value representing    */
      /* the scheme name for the request"                                     */
      TestResult tr85 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETSCHEME);
      /* TODO: implement test */
      tr85.appendTcDetail("Not implemented.");
      tr85.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getServerName      */
      /* Details: "Method getServerName(): Returns a String value             */
      /* representing the host name for the request"                          */
      TestResult tr86 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETSERVERNAME);
      /* TODO: implement test */
      tr86.appendTcDetail("Not implemented.");
      tr86.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getServerPort      */
      /* Details: "Method getServerPort(): Returns an int value               */
      /* representing the port number for the request"                        */
      TestResult tr87 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETSERVERPORT);
      /* TODO: implement test */
      tr87.appendTcDetail("Not implemented.");
      tr87.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getWindowID        */
      /* Details: "Method getWindowID(): Returns a String value               */
      /* representing the portlet window ID"                                  */
      TestResult tr88 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETWINDOWID);
      /* TODO: implement test */
      tr88.appendTcDetail("Not implemented.");
      tr88.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getCookies1        */
      /* Details: "Method getCookies(): Returns a                             */
      /* javax.servlet.http.Cookie[] array containing the cookies for this    */
      /* request"                                                             */
      TestResult tr89 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETCOOKIES1);
      /* TODO: implement test */
      tr89.appendTcDetail("Not implemented.");
      tr89.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getCookies2        */
      /* Details: "Method getCookies(): Returns null if no cookies are        */
      /* present"                                                             */
      TestResult tr90 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETCOOKIES2);
      /* TODO: implement test */
      tr90.appendTcDetail("Not implemented.");
      tr90.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPrivateParameterMap1 */
      /* Details: "Method getPrivateParameterMap(): Returns an                */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object      */
      /* for the private parameter names and values if available"             */
      TestResult tr91 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPRIVATEPARAMETERMAP1);
      /* TODO: implement test */
      tr91.appendTcDetail("Not implemented.");
      tr91.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPrivateParameterMap2 */
      /* Details: "Method getPrivateParameterMap(): The returned map is       */
      /* immutable"                                                           */
      TestResult tr92 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPRIVATEPARAMETERMAP2);
      /* TODO: implement test */
      tr92.appendTcDetail("Not implemented.");
      tr92.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPrivateParameterMap3 */
      /* Details: "Method getPrivateParameterMap(): Returns an empty map if   */
      /* no private parameters exist"                                         */
      TestResult tr93 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPRIVATEPARAMETERMAP3);
      /* TODO: implement test */
      tr93.appendTcDetail("Not implemented.");
      tr93.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPublicParameterMap1 */
      /* Details: "Method getPublicParameterMap(): Returns an                 */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object      */
      /* for the public parameter names and values if available"              */
      TestResult tr94 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPUBLICPARAMETERMAP1);
      /* TODO: implement test */
      tr94.appendTcDetail("Not implemented.");
      tr94.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPublicParameterMap2 */
      /* Details: "Method getPublicParameterMap(): The returned map is        */
      /* immutable"                                                           */
      TestResult tr95 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPUBLICPARAMETERMAP2);
      /* TODO: implement test */
      tr95.appendTcDetail("Not implemented.");
      tr95.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_getPublicParameterMap3 */
      /* Details: "Method getPublicParameterMap(): Returns an empty map if    */
      /* no public parameters exist"                                          */
      TestResult tr96 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPUBLICPARAMETERMAP3);
      /* TODO: implement test */
      tr96.appendTcDetail("Not implemented.");
      tr96.writeTo(writer);

      /* TestCase: V2RequestTests_PortletRequest_ApiRender_exists             */
      /* Details: "The P3PUserInfos exists as a public static enum"           */
      TestResult tr97 = tcd.getTestResultFailed(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_EXISTS);
      /* TODO: implement test */
      tr97.appendTcDetail("Not implemented.");
      tr97.writeTo(writer);

   }

}
