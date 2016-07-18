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
import javax.portlet.annotations.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import static javax.portlet.tck.util.ModuleTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC14_PortletRequest_ApiHeader")
public class HeaderPortletTests_SPEC14_PortletRequest_ApiHeader implements Portlet {
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldUSER_INFO */
      /* Details: "Has String field USER_INFO with value of                         */
      /* \"javax.portlet.userinfo\" "                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDUSER_INFO);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldCCPP_PROFILE */
      /* Details: "Has String field CCPP_PROFILE with value of                      */
      /* \"javax.portlet.ccpp\" "                                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDCCPP_PROFILE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldBASIC_AUTH */
      /* Details: "Has String field BASIC_AUTH with value of \"BASIC\" "            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDBASIC_AUTH);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldFORM_AUTH */
      /* Details: "Has String field FORM_AUTH with value of \"FORM\" "              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDFORM_AUTH);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldCLIENT_CERT_AUTH */
      /* Details: "Has String field CLIENT_CERT_AUTH with value of \"CLIENT_CERT\"  */
      /* "                                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDCLIENT_CERT_AUTH);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldDIGEST_AUTH */
      /* Details: "Has String field DIGEST_AUTH with value of \"DIGEST\" "          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDDIGEST_AUTH);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldACTION_PHASE */
      /* Details: "Has String field ACTION_PHASE with value of \"ACTION_PHASE\" "   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDACTION_PHASE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldEVENT_PHASE */
      /* Details: "Has String field EVENT_PHASE with value of \"EVENT_PHASE\" "     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDEVENT_PHASE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldRENDER_PHASE */
      /* Details: "Has String field RENDER_PHASE with value of \"RENDER_PHASE\" "   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_PHASE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldRESOURCE_PHASE */
      /* Details: "Has String field RESOURCE_PHASE with value of \"RESOURCE_PHASE\" */
      /* "                                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRESOURCE_PHASE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldHEADER_PHASE */
      /* Details: "Has String field HEADER_PHASE with value of \"HEADER_PHASE\" "   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDHEADER_PHASE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldLIFECYCLE_PHASE */
      /* Details: "Has String field LIFECYCLE_PHASE with value of                   */
      /* \"javax.portlet.lifecycle_phase\" "                                        */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDLIFECYCLE_PHASE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldRENDER_PART */
      /* Details: "Has String field RENDER_PART with value of                       */
      /* \"javax.portlet.render_part\" "                                            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_PART);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldRENDER_HEADERS */
      /* Details: "Has String field RENDER_HEADERS with value of \"RENDER_HEADERS\" */
      /* "                                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_HEADERS);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldRENDER_MARKUP */
      /* Details: "Has String field RENDER_MARKUP with value of \"RENDER_MARKUP\" " */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_MARKUP);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldACTION_SCOPE_ID */
      /* Details: "Has String field ACTION_SCOPE_ID with value of                   */
      /* \"javax.portlet.as\" "                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDACTION_SCOPE_ID);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isWindowStateAllowed1 */
      /* Details: "Method isWindowStateAllowed(WindowState): Returns true if the    */
      /* specified WindowState is allowed"                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISWINDOWSTATEALLOWED1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isWindowStateAllowed2 */
      /* Details: "Method isWindowStateAllowed(WindowState): Returns false if the   */
      /* specified WindowState is not allowed"                                      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISWINDOWSTATEALLOWED2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isPortletModeAllowed1 */
      /* Details: "Method isPortletModeAllowed(PortletMode): Returns true if the    */
      /* specified PortletMode is allowed"                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISPORTLETMODEALLOWED1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isPortletModeAllowed2 */
      /* Details: "Method isPortletModeAllowed(PortletMode): Returns false if the   */
      /* specified PortletMode is not allowed"                                      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISPORTLETMODEALLOWED2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPreferences */
      /* Details: "Method getPreferences(): Returns the PortletPreferences object   */
      /* associated with the portlet"                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPREFERENCES);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionA1 */
      /* Details: "Method getPortletSession(): Returns current PortletSession if    */
      /* one already exists"                                                        */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONA1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionA2 */
      /* Details: "Method getPortletSession(): Returns new PortletSession if one    */
      /* does not already exist"                                                    */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONA2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionB1 */
      /* Details: "Method getPortletSession(boolean): If input flag is true,        */
      /* returns current PortletSession if one already exists"                      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionB2 */
      /* Details: "Method getPortletSession(boolean): If input flag is true,        */
      /* returns new PortletSession if one does not already exist"                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionB3 */
      /* Details: "Method getPortletSession(boolean): If input flag is false,       */
      /* returns current PortletSession if one already exists"                      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionB4 */
      /* Details: "Method getPortletSession(boolean): If input flag is false,       */
      /* returns null if one does not already exist"                                */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB4);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperty1 */
      /* Details: "Method getProperty(String): If specified request property        */
      /* exists, returns its value "                                                */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTY1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperty2 */
      /* Details: "Method getProperty(String): If specified request property does   */
      /* not exist, returns null"                                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTY2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperty3 */
      /* Details: "Method getProperty(String): Throws IllegalArgumentException if   */
      /* the name is null"                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTY3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperties1 */
      /* Details: "Method getProperties(String): If specified request property      */
      /* exists, returns its values as an Enumeration "                             */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTIES1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperties2 */
      /* Details: "Method getProperties(String): If specified request property does */
      /* not exist, returns an empty Enumeration"                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTIES2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperties3 */
      /* Details: "Method getProperties(String): Throws IllegalArgumentException if */
      /* the name is null"                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTIES3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPropertyNames1 */
      /* Details: "Method getPropertyNames(): Returns an Enumeration of all request */
      /* property names"                                                            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTYNAMES1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPropertyNames2 */
      /* Details: "Method getPropertyNames(): Returns an empty Enumeration if there */
      /* are no request properties defined"                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTYNAMES2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortalContext */
      /* Details: "Method getPortalContext(): Returns the context of the portal"    */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTALCONTEXT);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAuthType1 */
      /* Details: "Method getAuthType(): Returns a String indicating the            */
      /* authentication type if the request was authenticated"                      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETAUTHTYPE1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAuthType2 */
      /* Details: "Method getAuthType(): Returns null if the request was not        */
      /* authenticated"                                                             */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETAUTHTYPE2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getContextPath1 */
      /* Details: "Method getContextPath(): Returns a String representing the       */
      /* context path associated with the portlet"                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCONTEXTPATH1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getContextPath2 */
      /* Details: "Method getContextPath(): Returns an empty String if the portlet  */
      /* is deployed in the default context"                                        */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCONTEXTPATH2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getContextPath3 */
      /* Details: "Method getContextPath(): If the context path is not empty, it    */
      /* must start with \"/\" and may not end with \"/\""                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCONTEXTPATH3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getRemoteUser1 */
      /* Details: "Method getRemoteUser(): Returns a String representing the login  */
      /* of the user if the request is authenticated"                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREMOTEUSER1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getRemoteUser2 */
      /* Details: "Method getRemoteUser(): Returns null if the request has not been */
      /* authenticated"                                                             */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREMOTEUSER2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getUserPrincipal1 */
      /* Details: "Method getUserPrincipal(): Returns a java.security.Principal     */
      /* object representing the user if the request has been authenticated"        */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETUSERPRINCIPAL1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getUserPrincipal2 */
      /* Details: "Method getUserPrincipal(): Returns null if the request has not   */
      /* been authenticated"                                                        */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETUSERPRINCIPAL2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isUserInRole1 */
      /* Details: "Method isUserInRole(): Returns true if the authenticated user is */
      /* in the specified role"                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISUSERINROLE1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isUserInRole2 */
      /* Details: "Method isUserInRole(): Returns false if the authenticated user   */
      /* is not in the specified role"                                              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISUSERINROLE2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isUserInRole3 */
      /* Details: "Method isUserInRole(): Returns false if the user is not          */
      /* authenticated"                                                             */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISUSERINROLE3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAttribute1 */
      /* Details: "Method getAttribute(String): Returns a java.lang.Object for the  */
      /* specified attribute name"                                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTE1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAttribute2 */
      /* Details: "Method getAttribute(String): Returns null if no attribute with   */
      /* the specified name exists"                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTE2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAttribute3 */
      /* Details: "Method getAttribute(String): Throws IllegalArgumentException if  */
      /* the name is null"                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTE3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAttributeNames1 */
      /* Details: "Method getAttributeNames(): Returns a                            */
      /* java.util.Enumeration&lt;java.lang.String&gt; of the available attribute   */
      /* names"                                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTENAMES1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAttributeNames2 */
      /* Details: "Method getAttributeNames(): Returns an empty Enumeration if      */
      /* there are no attributes available"                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTENAMES2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameter1 */
      /* Details: "Method getParameter(String): Returns String value of parameter   */
      /* specified by the name"                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameter2 */
      /* Details: "Method getParameter(String): Returns String value of a public    */
      /* render parameter specified by the name"                                    */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameter3 */
      /* Details: "Method getParameter(String): Returns null if no parameter exists */
      /* for the specified name"                                                    */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameter4 */
      /* Details: "Method getParameter(String): Returns first String value from     */
      /* values array if use with a multivalued parameter"                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER4);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameter5 */
      /* Details: "Method getParameter(String): Throws IllegalArgumentException if  */
      /* the name is null"                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER5);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterNames1 */
      /* Details: "Method getParameterNames(): Returns a                            */
      /* java.util.Enumeration&lt;java.lang.String&gt; of the available parameter   */
      /* names"                                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERNAMES1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterNames2 */
      /* Details: "Method getParameterNames(): Returns an empty Enumeration if      */
      /* there are no parameters available"                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERNAMES2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterValues1 */
      /* Details: "Method getParameterValues(String): Returns String[] value of     */
      /* parameter specified by the name"                                           */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterValues2 */
      /* Details: "Method getParameterValues(String): Returns String[] value of a   */
      /* public render parameter specified by the name"                             */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterValues3 */
      /* Details: "Method getParameterValues(String): Returns null if no parameter  */
      /* exists for the specified name"                                             */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterValues4 */
      /* Details: "Method getParameterValues(String): Throws                        */
      /* IllegalArgumentException if the name is null"                              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES4);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterMap1 */
      /* Details: "Method getParameterMap(): Returns an                             */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the    */
      /* parameter names and values if parameters are available"                    */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERMAP1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterMap2 */
      /* Details: "Method getParameterMap(): The returned map contains all public   */
      /* and private parameters for the request"                                    */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERMAP2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterMap3 */
      /* Details: "Method getParameterMap(): Returns an empty map if no parameters  */
      /* exist"                                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERMAP3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isSecure1   */
      /* Details: "Method isSecure(): Returns true if the request was made through  */
      /* a secure channel"                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISSECURE1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isSecure2   */
      /* Details: "Method isSecure(): Returns false if the request was not made     */
      /* through a secure channel"                                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISSECURE2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_setAttribute1 */
      /* Details: "Method setAttribute(String, Object): Stores an attribute object  */
      /* under the specified name in the request"                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_setAttribute2 */
      /* Details: "Method setAttribute(String, Object): Removes the attribute by    */
      /* the specified name if the object is null"                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_setAttribute3 */
      /* Details: "Method setAttribute(String, Object): Throws                      */
      /* IllegalArgumentException if the name is null"                              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_removeAttribute1 */
      /* Details: "Method removeAttribute(String): Removes the attribute specified  */
      /* by the name from the request"                                              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_REMOVEATTRIBUTE1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_removeAttribute2 */
      /* Details: "Method removeAttribute(String): Throws IllegalArgumentException  */
      /* if the name is null"                                                       */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_REMOVEATTRIBUTE2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getRequestedSessionId1 */
      /* Details: "Method getRequestedSessionId(): Returns the session ID indicated */
      /* in the client request"                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREQUESTEDSESSIONID1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getRequestedSessionId2 */
      /* Details: "Method getRequestedSessionId(): Returns null if no session ID    */
      /* was indicated in the client request"                                       */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREQUESTEDSESSIONID2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isRequestedSessionIdValid1 */
      /* Details: "Method isRequestedSessionIdValid(): Returns true if the session  */
      /* ID is valid"                                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISREQUESTEDSESSIONIDVALID1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isRequestedSessionIdValid2 */
      /* Details: "Method isRequestedSessionIdValid(): Returns false if the session */
      /* ID is not valid"                                                           */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISREQUESTEDSESSIONIDVALID2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getResponseContentType1 */
      /* Details: "Method getResponseContentType(): Returns a String representing   */
      /* the portal preferred content type for the response if the content type is  */
      /* defined in the portlet descriptor "                                        */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETRESPONSECONTENTTYPE1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getResponseContentType2 */
      /* Details: "Method getResponseContentType(): Returns an empty Enumeration if */
      /* the content type is not defined in the portlet descriptor"                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETRESPONSECONTENTTYPE2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getResponseContentTypes1 */
      /* Details: "Method getResponseContentTypes(): Returns an                     */
      /* java.util.Enumeration&lt;java.lang.String&gt; object representing the      */
      /* portal preferred content types for the response if the content types are   */
      /* defined in the portlet descriptor"                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETRESPONSECONTENTTYPES1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getResponseContentTypes2 */
      /* Details: "Method getResponseContentTypes(): Returns an empty Enumeration   */
      /* if the content types are not defined in the portlet descriptor"            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETRESPONSECONTENTTYPES2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getLocale   */
      /* Details: "Method getLocale(): Returns an java.util.Locale object           */
      /* representing the preferred Locale for the response"                        */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETLOCALE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getLocales  */
      /* Details: "Method getLocales(): Returns an                                  */
      /* java.util.Enumeration&lt;java.util.Locale&gt; of the Locales in which the  */
      /* portal will accept content"                                                */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETLOCALES);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getScheme   */
      /* Details: "Method getScheme(): Returns a String value representing the      */
      /* scheme name for the request"                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETSCHEME);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getServerName */
      /* Details: "Method getServerName(): Returns a String value representing the  */
      /* host name for the request"                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETSERVERNAME);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getServerPort */
      /* Details: "Method getServerPort(): Returns an int value representing the    */
      /* port number for the request"                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETSERVERPORT);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getWindowID */
      /* Details: "Method getWindowID(): Returns a String value representing the    */
      /* portlet window ID"                                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETWINDOWID);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getCookies1 */
      /* Details: "Method getCookies(): Returns a javax.servlet.http.Cookie[] array */
      /* containing the cookies for this request"                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCOOKIES1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getCookies2 */
      /* Details: "Method getCookies(): Returns null if no cookies are present"     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCOOKIES2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPrivateParameterMap1 */
      /* Details: "Method getPrivateParameterMap(): Returns an                      */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the    */
      /* private parameter names and values if available"                           */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPRIVATEPARAMETERMAP1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPrivateParameterMap2 */
      /* Details: "Method getPrivateParameterMap(): The returned map is immutable"  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPRIVATEPARAMETERMAP2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPrivateParameterMap3 */
      /* Details: "Method getPrivateParameterMap(): Returns an empty map if no      */
      /* private parameters exist"                                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPRIVATEPARAMETERMAP3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPublicParameterMap1 */
      /* Details: "Method getPublicParameterMap(): Returns an                       */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the    */
      /* public parameter names and values if available"                            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPUBLICPARAMETERMAP1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPublicParameterMap2 */
      /* Details: "Method getPublicParameterMap(): The returned map is immutable"   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPUBLICPARAMETERMAP2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPublicParameterMap3 */
      /* Details: "Method getPublicParameterMap(): Returns an empty map if no       */
      /* public parameters exist"                                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPUBLICPARAMETERMAP3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_exists      */
      /* Details: "The P3PUserInfos exists as a public static enum"                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_EXISTS);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

   }

}
