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
 * portlet SigTestsEvent_PortletRequest_SIGEvent_event
 *
 */
public class SigTestsEvent_PortletRequest_SIGEvent implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         SigTestsEvent_PortletRequest_SIGEvent.class.getName();
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
             "SigTestsEvent_PortletRequest_SIGEvent");
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

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldACTION_PHASE  */
      /* Details: "EventRequest has String field ACTION_PHASE "               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_fieldACTION_PHASE", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldACTION_SCOPE_ID */
      /* Details: "EventRequest has String field ACTION_SCOPE_ID "            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_fieldACTION_SCOPE_ID", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldBASIC_AUTH    */
      /* Details: "EventRequest has String field BASIC_AUTH "                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_fieldBASIC_AUTH", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldCCPP_PROFILE  */
      /* Details: "EventRequest has String field CCPP_PROFILE "               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_fieldCCPP_PROFILE", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldCLIENT_CERT_AUTH */
      /* Details: "EventRequest has String field CLIENT_CERT_AUTH "           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_fieldCLIENT_CERT_AUTH", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldDIGEST_AUTH   */
      /* Details: "EventRequest has String field DIGEST_AUTH "                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_fieldDIGEST_AUTH", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldEVENT_PHASE   */
      /* Details: "EventRequest has String field EVENT_PHASE "                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_fieldEVENT_PHASE", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldFORM_AUTH     */
      /* Details: "EventRequest has String field FORM_AUTH "                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_fieldFORM_AUTH", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldLIFECYCLE_PHASE */
      /* Details: "EventRequest has String field LIFECYCLE_PHASE "            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_fieldLIFECYCLE_PHASE", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_HEADERS */
      /* Details: "EventRequest has String field RENDER_HEADERS "             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_HEADERS", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_MARKUP */
      /* Details: "EventRequest has String field RENDER_MARKUP "              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_MARKUP", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_PART   */
      /* Details: "EventRequest has String field RENDER_PART "                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_PART", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_PHASE  */
      /* Details: "EventRequest has String field RENDER_PHASE "               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_PHASE", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldRESOURCE_PHASE */
      /* Details: "EventRequest has String field RESOURCE_PHASE "             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_fieldRESOURCE_PHASE", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldUSER_INFO     */
      /* Details: "EventRequest has String field USER_INFO "                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_fieldUSER_INFO", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttribute    */
      /* Details: "EventRequest has a getAttribute(String)  method "          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttribute", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttributeNames */
      /* Details: "EventRequest has a getAttributeNames()  method "           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttributeNames", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttributeNamesReturns */
      /* Details: "EventRequest method getAttributeNames() returns            */
      /* java.util.Enumeration "                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttributeNamesReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttributeReturns */
      /* Details: "EventRequest method getAttribute(String) returns Object    */
      /* "                                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttributeReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAuthType     */
      /* Details: "EventRequest has a getAuthType()  method "                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAuthType", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAuthTypeReturns */
      /* Details: "EventRequest method getAuthType() returns String "         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAuthTypeReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetContextPath  */
      /* Details: "EventRequest has a getContextPath()  method "              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetContextPath", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetContextPathReturns */
      /* Details: "EventRequest method getContextPath() returns String "      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetContextPathReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetCookies      */
      /* Details: "EventRequest has a getCookies()  method "                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetCookies", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetCookiesReturns */
      /* Details: "EventRequest method getCookies() returns                   */
      /* javax.servlet.http.Cookie[] "                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetCookiesReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocale       */
      /* Details: "EventRequest has a getLocale()  method "                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocale", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocaleReturns */
      /* Details: "EventRequest method getLocale() returns java.util.Locale   */
      /* "                                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocaleReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocales      */
      /* Details: "EventRequest has a getLocales()  method "                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocales", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocalesReturns */
      /* Details: "EventRequest method getLocales() returns                   */
      /* java.util.Enumeration "                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocalesReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameter    */
      /* Details: "EventRequest has a getParameter(String)  method "          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameter", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterMap */
      /* Details: "EventRequest has a getParameterMap()  method "             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterMap", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterMapReturns */
      /* Details: "EventRequest method getParameterMap() returns              */
      /* java.util.Map "                                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterMapReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterNames */
      /* Details: "EventRequest has a getParameterNames()  method "           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterNames", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterNamesReturns */
      /* Details: "EventRequest method getParameterNames() returns            */
      /* java.util.Enumeration "                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterNamesReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterReturns */
      /* Details: "EventRequest method getParameter(String) returns String    */
      /* "                                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterValues */
      /* Details: "EventRequest has a getParameterValues(String)  method "    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterValues", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterValuesReturns */
      /* Details: "EventRequest method getParameterValues(String) returns     */
      /* String[] "                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterValuesReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortalContext */
      /* Details: "EventRequest has a getPortalContext()  method "            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortalContext", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortalContextReturns */
      /* Details: "EventRequest method getPortalContext() returns             */
      /* PortalContext "                                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortalContextReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletMode  */
      /* Details: "EventRequest has a getPortletMode()  method "              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletMode", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletModeReturns */
      /* Details: "EventRequest method getPortletMode() returns PortletMode   */
      /* "                                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletModeReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSession */
      /* Details: "EventRequest has a getPortletSession()  method "           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSession", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSessionA */
      /* Details: "EventRequest has a getPortletSession(boolean)  method "    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSessionA", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSessionReturns */
      /* Details: "EventRequest method getPortletSession() returns            */
      /* PortletSession "                                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSessionReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSessionReturnsA */
      /* Details: "EventRequest method getPortletSession(boolean) returns     */
      /* PortletSession "                                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSessionReturnsA", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPreferences  */
      /* Details: "EventRequest has a getPreferences()  method "              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPreferences", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPreferencesReturns */
      /* Details: "EventRequest method getPreferences() returns               */
      /* PortletPreferences "                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPreferencesReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPrivateParameterMap */
      /* Details: "EventRequest has a getPrivateParameterMap()  method "      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPrivateParameterMap", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPrivateParameterMapReturns */
      /* Details: "EventRequest method getPrivateParameterMap() returns       */
      /* java.util.Map "                                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPrivateParameterMapReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetProperties   */
      /* Details: "EventRequest has a getProperties(String)  method "         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetProperties", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertiesReturns */
      /* Details: "EventRequest method getProperties(String) returns          */
      /* java.util.Enumeration "                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertiesReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetProperty     */
      /* Details: "EventRequest has a getProperty(String)  method "           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetProperty", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertyNames */
      /* Details: "EventRequest has a getPropertyNames()  method "            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertyNames", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertyNamesReturns */
      /* Details: "EventRequest method getPropertyNames() returns             */
      /* java.util.Enumeration "                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertyNamesReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertyReturns */
      /* Details: "EventRequest method getProperty(String) returns String "   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertyReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPublicParameterMap */
      /* Details: "EventRequest has a getPublicParameterMap()  method "       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPublicParameterMap", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPublicParameterMapReturns */
      /* Details: "EventRequest method getPublicParameterMap() returns        */
      /* java.util.Map "                                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPublicParameterMapReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRemoteUser   */
      /* Details: "EventRequest has a getRemoteUser()  method "               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRemoteUser", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRemoteUserReturns */
      /* Details: "EventRequest method getRemoteUser() returns String "       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRemoteUserReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRequestedSessionId */
      /* Details: "EventRequest has a getRequestedSessionId()  method "       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRequestedSessionId", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRequestedSessionIdReturns */
      /* Details: "EventRequest method getRequestedSessionId() returns        */
      /* String "                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRequestedSessionIdReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentType */
      /* Details: "EventRequest has a getResponseContentType()  method "      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentType", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentTypeReturns */
      /* Details: "EventRequest method getResponseContentType() returns       */
      /* String "                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentTypeReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentTypes */
      /* Details: "EventRequest has a getResponseContentTypes()  method "     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentTypes", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentTypesReturns */
      /* Details: "EventRequest method getResponseContentTypes() returns      */
      /* java.util.Enumeration "                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentTypesReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetScheme       */
      /* Details: "EventRequest has a getScheme()  method "                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetScheme", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetSchemeReturns */
      /* Details: "EventRequest method getScheme() returns String "           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetSchemeReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerName   */
      /* Details: "EventRequest has a getServerName()  method "               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerName", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerNameReturns */
      /* Details: "EventRequest method getServerName() returns String "       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerNameReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerPort   */
      /* Details: "EventRequest has a getServerPort()  method "               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerPort", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerPortReturns */
      /* Details: "EventRequest method getServerPort() returns int "          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerPortReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetUserPrincipal */
      /* Details: "EventRequest has a getUserPrincipal()  method "            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetUserPrincipal", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetUserPrincipalReturns */
      /* Details: "EventRequest method getUserPrincipal() returns             */
      /* java.security.Principal "                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetUserPrincipalReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowID     */
      /* Details: "EventRequest has a getWindowID()  method "                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowID", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowIDReturns */
      /* Details: "EventRequest method getWindowID() returns String "         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowIDReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowState  */
      /* Details: "EventRequest has a getWindowState()  method "              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowState", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowStateReturns */
      /* Details: "EventRequest method getWindowState() returns WindowState   */
      /* "                                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowStateReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsPortletModeAllowed */
      /* Details: "EventRequest has a isPortletModeAllowed(PortletMode)       */
      /* method "                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasIsPortletModeAllowed", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsPortletModeAllowedReturns */
      /* Details: "EventRequest method isPortletModeAllowed(PortletMode)      */
      /* returns boolean "                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasIsPortletModeAllowedReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsRequestedSessionIdValid */
      /* Details: "EventRequest has a isRequestedSessionIdValid()  method "   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasIsRequestedSessionIdValid", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsRequestedSessionIdValidReturns */
      /* Details: "EventRequest method isRequestedSessionIdValid() returns    */
      /* boolean "                                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasIsRequestedSessionIdValidReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsSecure        */
      /* Details: "EventRequest has a isSecure()  method "                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasIsSecure", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsSecureReturns */
      /* Details: "EventRequest method isSecure() returns boolean "           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasIsSecureReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsUserInRole    */
      /* Details: "EventRequest has a isUserInRole(String)  method "          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasIsUserInRole", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsUserInRoleReturns */
      /* Details: "EventRequest method isUserInRole(String) returns boolean   */
      /* "                                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasIsUserInRoleReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsWindowStateAllowed */
      /* Details: "EventRequest has a isWindowStateAllowed(WindowState)       */
      /* method "                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasIsWindowStateAllowed", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsWindowStateAllowedReturns */
      /* Details: "EventRequest method isWindowStateAllowed(WindowState)      */
      /* returns boolean "                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasIsWindowStateAllowedReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasRemoveAttribute */
      /* Details: "EventRequest has a removeAttribute(String)  method "       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasRemoveAttribute", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasRemoveAttributeReturns */
      /* Details: "EventRequest method removeAttribute(String) returns void   */
      /* "                                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasRemoveAttributeReturns", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasSetAttribute    */
      /* Details: "EventRequest has a setAttribute(String, Object)  method    */
      /* "                                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasSetAttribute", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasSetAttributeReturns */
      /* Details: "EventRequest method setAttribute(String, Object) returns   */
      /* void "                                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2SigTestsEvent_PortletRequest_SIGEvent_hasSetAttributeReturns", aurl);
         tb.writeTo(writer);
      }

   }

}
