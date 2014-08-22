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
 * portlet PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_event
 *
 */
public class PortletTagLibraryTests_SPEC2_26_IncludeJSPAction implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         PortletTagLibraryTests_SPEC2_26_IncludeJSPAction.class.getName();
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

      // Now do the actual dispatch
      String target = JSP_PREFIX + "PortletTagLibraryTests_SPEC2_26_IncludeJSPAction" + JSP_SUFFIX + "?" + QUERY_STRING;
      PortletRequestDispatcher rd = portletConfig.getPortletContext()
            .getRequestDispatcher(target);
      rd.include(portletReq, portletResp);
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

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "PortletTagLibraryTests_SPEC2_26_IncludeJSPAction", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "PortletTagLibraryTests_SPEC2_26_IncludeJSPAction", APPLICATION_SCOPE);
      }

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects1 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable RenderRequest renderRequest to be null or       */
      /* undefined"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects2 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable ResourceRequest resourceRequest to be null or   */
      /* undefined"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects3 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable ActionRequest actionRequest to the              */
      /* corresponding object"                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects4 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable EventRequest eventRequest to be null or         */
      /* undefined"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects5 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable RenderResponse renderResponse to be null or     */
      /* undefined"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects6 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable ResourceResponse resourceResponse to be null    */
      /* or undefined"                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects6", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects7 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable ActionResponse actionResponse to the            */
      /* corresponding object"                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects7", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects8 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable EventResponse eventResponse to be null or       */
      /* undefined"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects8", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects9 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable PortletConfig portletConfig"                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects9", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects10 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable PortletSession portletSession, providing        */
      /* access to the portletSession, does not create a new session, only    */
      /* returns an existing session or null if no session exists."           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects10", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects11 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable Map<String, Object> portletSessionScope,        */
      /* providing access to the portletSession attributes as a Map           */
      /* equivalent to the PortletSession.getAttributeMap() call, does not    */
      /* create a new session, only returns an existing session. If no        */
      /* session attributes exist this method returns an empty Map."          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects11", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects12 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable PortletPreferences portletPreferences,          */
      /* providing access to the portlet preferences."                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects12", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects13 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable Map<String, String[]>                           */
      /* portletPreferencesValues, providing access to the portlet            */
      /* preferences as a Map, equivalent to the                              */
      /* PortletPreferences.getMap() call. If no portlet preferences exist,   */
      /* the Map is empty."                                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects13", aurl);
         tb.writeTo(writer);
      }

   }

}
