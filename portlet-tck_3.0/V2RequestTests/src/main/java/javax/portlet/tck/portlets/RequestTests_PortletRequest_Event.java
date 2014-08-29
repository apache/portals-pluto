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
 * portlet RequestTests_PortletRequest_Event_event
 *
 */
public class RequestTests_PortletRequest_Event implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         RequestTests_PortletRequest_Event.class.getName();
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

      QName eventQName = new QName(TCKNAMESPACE,
             "RequestTests_PortletRequest_Event");
      portletResp.setEvent(eventQName, "Hi!");
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

      /* TestCase: V2RequestTests_PortletRequest_Event_fieldUSER_INFO         */
      /* Details: "Has String field USER_INFO with value of                   */
      /* \"javax.portlet.userinfo\" "                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_fieldUSER_INFO", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_fieldCCPP_PROFILE      */
      /* Details: "Has String field CCPP_PROFILE with value of                */
      /* \"javax.portlet.ccpp\" "                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_fieldCCPP_PROFILE", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_fieldBASIC_AUTH        */
      /* Details: "Has String field BASIC_AUTH with value of \"BASIC\" "      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_fieldBASIC_AUTH", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_fieldFORM_AUTH         */
      /* Details: "Has String field FORM_AUTH with value of \"FORM\" "        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_fieldFORM_AUTH", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_fieldCLIENT_CERT_AUTH  */
      /* Details: "Has String field CLIENT_CERT_AUTH with value of            */
      /* \"CLIENT_CERT\" "                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_fieldCLIENT_CERT_AUTH", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_fieldDIGEST_AUTH       */
      /* Details: "Has String field DIGEST_AUTH with value of \"DIGEST\" "    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_fieldDIGEST_AUTH", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_fieldACTION_PHASE      */
      /* Details: "Has String field ACTION_PHASE with value of                */
      /* \"ACTION_PHASE\" "                                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_fieldACTION_PHASE", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_fieldEVENT_PHASE       */
      /* Details: "Has String field EVENT_PHASE with value of                 */
      /* \"EVENT_PHASE\" "                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_fieldEVENT_PHASE", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_fieldRENDER_PHASE      */
      /* Details: "Has String field RENDER_PHASE with value of                */
      /* \"RENDER_PHASE\" "                                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_fieldRENDER_PHASE", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_fieldRESOURCE_PHASE    */
      /* Details: "Has String field RESOURCE_PHASE with value of              */
      /* \"RESOURCE_PHASE\" "                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_fieldRESOURCE_PHASE", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_fieldLIFECYCLE_PHASE   */
      /* Details: "Has String field LIFECYCLE_PHASE with value of             */
      /* \"javax.portlet.lifecycle_phase\" "                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_fieldLIFECYCLE_PHASE", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_fieldRENDER_PART       */
      /* Details: "Has String field RENDER_PART with value of                 */
      /* \"javax.portlet.render_part\" "                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_fieldRENDER_PART", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_fieldRENDER_HEADERS    */
      /* Details: "Has String field RENDER_HEADERS with value of              */
      /* \"RENDER_HEADERS\" "                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_fieldRENDER_HEADERS", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_fieldRENDER_MARKUP     */
      /* Details: "Has String field RENDER_MARKUP with value of               */
      /* \"RENDER_MARKUP\" "                                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_fieldRENDER_MARKUP", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_fieldACTION_SCOPE_ID   */
      /* Details: "Has String field ACTION_SCOPE_ID with value of             */
      /* \"javax.portlet.as\" "                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_fieldACTION_SCOPE_ID", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_isWindowStateAllowed1  */
      /* Details: "Method isWindowStateAllowed(WindowState): Returns true     */
      /* if the specified WindowState is allowed"                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_isWindowStateAllowed1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_isWindowStateAllowed2  */
      /* Details: "Method isWindowStateAllowed(WindowState): Returns false    */
      /* if the specified WindowState is not allowed"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_isWindowStateAllowed2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_isPortletModeAllowed1  */
      /* Details: "Method isPortletModeAllowed(PortletMode): Returns true     */
      /* if the specified PortletMode is allowed"                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_isPortletModeAllowed1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_isPortletModeAllowed2  */
      /* Details: "Method isPortletModeAllowed(PortletMode): Returns false    */
      /* if the specified PortletMode is not allowed"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_isPortletModeAllowed2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPortletMode         */
      /* Details: "Method getPortletMode(): Returns current PortletMode "     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPortletMode", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getWindowState         */
      /* Details: "Method getWindowState(): Returns current WindowState"      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getWindowState", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPreferences         */
      /* Details: "Method getPreferences(): Returns the PortletPreferences    */
      /* object associated with the portlet"                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPreferences", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPortletSessionA1    */
      /* Details: "Method getPortletSession(): Returns current                */
      /* PortletSession if one already exists"                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPortletSessionA1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPortletSessionA2    */
      /* Details: "Method getPortletSession(): Returns new PortletSession     */
      /* if one does not already exist"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPortletSessionA2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPortletSessionB1    */
      /* Details: "Method getPortletSession(boolean): If input flag is        */
      /* true, returns current PortletSession if one already exists"          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPortletSessionB1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPortletSessionB2    */
      /* Details: "Method getPortletSession(boolean): If input flag is        */
      /* true, returns new PortletSession if one does not already exist"      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPortletSessionB2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPortletSessionB3    */
      /* Details: "Method getPortletSession(boolean): If input flag is        */
      /* false, returns current PortletSession if one already exists"         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPortletSessionB3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPortletSessionB4    */
      /* Details: "Method getPortletSession(boolean): If input flag is        */
      /* false, returns null if one does not already exist"                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPortletSessionB4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getProperty1           */
      /* Details: "Method getProperty(String): If specified request           */
      /* property exists, returns its value "                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getProperty1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getProperty2           */
      /* Details: "Method getProperty(String): If specified request           */
      /* property does not exist, returns null"                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getProperty2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getProperty3           */
      /* Details: "Method getProperty(String): Throws                         */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getProperty3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getProperties1         */
      /* Details: "Method getProperties(String): If specified request         */
      /* property exists, returns its values as an Enumeration "              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getProperties1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getProperties2         */
      /* Details: "Method getProperties(String): If specified request         */
      /* property does not exist, returns an empty Enumeration"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getProperties2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getProperties3         */
      /* Details: "Method getProperties(String): Throws                       */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getProperties3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPropertyNames1      */
      /* Details: "Method getPropertyNames(): Returns an Enumeration of all   */
      /* request property names"                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPropertyNames1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPropertyNames2      */
      /* Details: "Method getPropertyNames(): Returns an empty Enumeration    */
      /* if there are no request properties defined"                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPropertyNames2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPortalContext       */
      /* Details: "Method getPortalContext(): Returns the context of the      */
      /* portal"                                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPortalContext", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getAuthType1           */
      /* Details: "Method getAuthType(): Returns a String indicating the      */
      /* authentication type if the request was authenticated"                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getAuthType1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getAuthType2           */
      /* Details: "Method getAuthType(): Returns null if the request was      */
      /* not authenticated"                                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getAuthType2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getContextPath1        */
      /* Details: "Method getContextPath(): Returns a String representing     */
      /* the context path associated with the portlet"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getContextPath1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getContextPath2        */
      /* Details: "Method getContextPath(): Returns an empty String if the    */
      /* portlet is deployed in the default context"                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getContextPath2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getContextPath3        */
      /* Details: "Method getContextPath(): If the context path is not        */
      /* empty, it must start with \"/\" and may not end with \"/\""          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getContextPath3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getRemoteUser1         */
      /* Details: "Method getRemoteUser(): Returns a String representing      */
      /* the login of the user if the request is authenticated"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getRemoteUser1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getRemoteUser2         */
      /* Details: "Method getRemoteUser(): Returns null if the request has    */
      /* not been authenticated"                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getRemoteUser2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getUserPrincipal1      */
      /* Details: "Method getUserPrincipal(): Returns a                       */
      /* java.security.Principal object representing the user if the          */
      /* request has been authenticated"                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getUserPrincipal1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getUserPrincipal2      */
      /* Details: "Method getUserPrincipal(): Returns null if the request     */
      /* has not been authenticated"                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getUserPrincipal2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_isUserInRole1          */
      /* Details: "Method isUserInRole(): Returns true if the authenticated   */
      /* user is in the specified role"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_isUserInRole1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_isUserInRole2          */
      /* Details: "Method isUserInRole(): Returns false if the                */
      /* authenticated user is not in the specified role"                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_isUserInRole2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_isUserInRole3          */
      /* Details: "Method isUserInRole(): Returns false if the user is not    */
      /* authenticated"                                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_isUserInRole3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getAttribute1          */
      /* Details: "Method getAttribute(String): Returns a java.lang.Object    */
      /* for the specified attribute name"                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getAttribute1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getAttribute2          */
      /* Details: "Method getAttribute(String): Returns null if no            */
      /* attribute with the specified name exists"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getAttribute2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getAttribute3          */
      /* Details: "Method getAttribute(String): Throws                        */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getAttribute3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getAttributeNames1     */
      /* Details: "Method getAttributeNames(): Returns a                      */
      /* java.util.Enumeration&lt;java.lang.String&gt; of the available       */
      /* attribute names"                                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getAttributeNames1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getAttributeNames2     */
      /* Details: "Method getAttributeNames(): Returns an empty Enumeration   */
      /* if there are no attributes available"                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getAttributeNames2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getParameter1          */
      /* Details: "Method getParameter(String): Returns String value of       */
      /* parameter specified by the name"                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getParameter1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getParameter2          */
      /* Details: "Method getParameter(String): Returns String value of a     */
      /* public render parameter specified by the name"                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getParameter2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getParameter3          */
      /* Details: "Method getParameter(String): Returns null if no            */
      /* parameter exists for the specified name"                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getParameter3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getParameter4          */
      /* Details: "Method getParameter(String): Returns first String value    */
      /* from values array if use with a multivalued parameter"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getParameter4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getParameter5          */
      /* Details: "Method getParameter(String): Throws                        */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getParameter5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getParameterNames1     */
      /* Details: "Method getParameterNames(): Returns a                      */
      /* java.util.Enumeration&lt;java.lang.String&gt; of the available       */
      /* parameter names"                                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getParameterNames1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getParameterNames2     */
      /* Details: "Method getParameterNames(): Returns an empty Enumeration   */
      /* if there are no parameters available"                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getParameterNames2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getParameterValues1    */
      /* Details: "Method getParameterValues(String): Returns String[]        */
      /* value of parameter specified by the name"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getParameterValues1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getParameterValues2    */
      /* Details: "Method getParameterValues(String): Returns String[]        */
      /* value of a public render parameter specified by the name"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getParameterValues2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getParameterValues3    */
      /* Details: "Method getParameterValues(String): Returns null if no      */
      /* parameter exists for the specified name"                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getParameterValues3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getParameterValues4    */
      /* Details: "Method getParameterValues(String): Throws                  */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getParameterValues4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getParameterMap1       */
      /* Details: "Method getParameterMap(): Returns an                       */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object      */
      /* for the parameter names and values if parameters are available"      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getParameterMap1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getParameterMap2       */
      /* Details: "Method getParameterMap(): The returned map contains all    */
      /* public and private parameters for the request"                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getParameterMap2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getParameterMap3       */
      /* Details: "Method getParameterMap(): Returns an empty map if no       */
      /* parameters exist"                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getParameterMap3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_isSecure1              */
      /* Details: "Method isSecure(): Returns true if the request was made    */
      /* through a secure channel"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_isSecure1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_isSecure2              */
      /* Details: "Method isSecure(): Returns false if the request was not    */
      /* made through a secure channel"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_isSecure2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_setAttribute1          */
      /* Details: "Method setAttribute(String, Object): Stores an attribute   */
      /* object under the specified name in the request"                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_setAttribute1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_setAttribute2          */
      /* Details: "Method setAttribute(String, Object): Removes the           */
      /* attribute by the specified name if the object is null"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_setAttribute2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_setAttribute3          */
      /* Details: "Method setAttribute(String, Object): Throws                */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_setAttribute3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_removeAttribute1       */
      /* Details: "Method removeAttribute(String): Removes the attribute      */
      /* specified by the name from the request"                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_removeAttribute1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_removeAttribute2       */
      /* Details: "Method removeAttribute(String): Throws                     */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_removeAttribute2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getRequestedSessionId1 */
      /* Details: "Method getRequestedSessionId(): Returns the session ID     */
      /* indicated in the client request"                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getRequestedSessionId1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getRequestedSessionId2 */
      /* Details: "Method getRequestedSessionId(): Returns null if no         */
      /* session ID was indicated in the client request"                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getRequestedSessionId2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_isRequestedSessionIdValid1 */
      /* Details: "Method isRequestedSessionIdValid(): Returns true if the    */
      /* session ID is valid"                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_isRequestedSessionIdValid1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_isRequestedSessionIdValid2 */
      /* Details: "Method isRequestedSessionIdValid(): Returns false if the   */
      /* session ID is not valid"                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_isRequestedSessionIdValid2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getResponseContentType1 */
      /* Details: "Method getResponseContentType(): Returns a String          */
      /* representing the portal preferred content type for the response if   */
      /* the content type is defined in the portlet descriptor  "             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getResponseContentType1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getResponseContentType2 */
      /* Details: "Method getResponseContentType(): Returns an empty          */
      /* Enumeration if the content type is not defined in the portlet        */
      /* descriptor"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getResponseContentType2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getResponseContentTypes1 */
      /* Details: "Method getResponseContentTypes(): Returns an               */
      /* java.util.Enumeration&lt;java.lang.String&gt; object representing    */
      /* the portal preferred content types for the response if the content   */
      /* types are defined in the portlet descriptor"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getResponseContentTypes1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getResponseContentTypes2 */
      /* Details: "Method getResponseContentTypes(): Returns an empty         */
      /* Enumeration if the content types are not defined in the portlet      */
      /* descriptor"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getResponseContentTypes2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getLocale              */
      /* Details: "Method getLocale(): Returns an java.util.Locale object     */
      /* representing the preferred Locale for the response"                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getLocale", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getLocales             */
      /* Details: "Method getLocales(): Returns an                            */
      /* java.util.Enumeration&lt;java.util.Locale&gt; of the Locales in      */
      /* which the portal will accept content"                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getLocales", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getScheme              */
      /* Details: "Method getScheme(): Returns a String value representing    */
      /* the scheme name for the request"                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getScheme", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getServerName          */
      /* Details: "Method getServerName(): Returns a String value             */
      /* representing the host name for the request"                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getServerName", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getServerPort          */
      /* Details: "Method getServerPort(): Returns an int value               */
      /* representing the port number for the request"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getServerPort", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getWindowID            */
      /* Details: "Method getWindowID(): Returns a String value               */
      /* representing the portlet window ID"                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getWindowID", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getCookies1            */
      /* Details: "Method getCookies(): Returns a                             */
      /* javax.servlet.http.Cookie[] array containing the cookies for this    */
      /* request"                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getCookies1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getCookies2            */
      /* Details: "Method getCookies(): Returns null if no cookies are        */
      /* present"                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getCookies2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPrivateParameterMap1 */
      /* Details: "Method getPrivateParameterMap(): Returns an                */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object      */
      /* for the private parameter names and values if available"             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPrivateParameterMap1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPrivateParameterMap2 */
      /* Details: "Method getPrivateParameterMap(): The returned map is       */
      /* immutable"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPrivateParameterMap2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPrivateParameterMap3 */
      /* Details: "Method getPrivateParameterMap(): Returns an empty map if   */
      /* no private parameters exist"                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPrivateParameterMap3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPublicParameterMap1 */
      /* Details: "Method getPublicParameterMap(): Returns an                 */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object      */
      /* for the public parameter names and values if available"              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPublicParameterMap1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPublicParameterMap2 */
      /* Details: "Method getPublicParameterMap(): The returned map is        */
      /* immutable"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPublicParameterMap2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_getPublicParameterMap3 */
      /* Details: "Method getPublicParameterMap(): Returns an empty map if    */
      /* no public parameters exist"                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_getPublicParameterMap3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_Event_exists                 */
      /* Details: "Method exists(): The P3PUserInfos exist as a public        */
      /* static enum"                                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2RequestTests_PortletRequest_Event_exists", aurl);
         tb.writeTo(writer);
      }

   }

}
