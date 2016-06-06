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
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
import static javax.portlet.PortletSession.*;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, 
 * but does not publish them. Events are published in the main portlet for the test cases. 
 */
public class AddlEnvironmentTests_SPEC2_17_EventPreferences_event implements Portlet, EventPortlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlEnvironmentTests_SPEC2_17_EventPreferences_event.class.getName();
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
     LOGGER.entering(LOG_CLASS, "event companion processAction entry");
     
     portletResp.setRenderParameters(portletReq.getPrivateParameterMap());

     long tid = Thread.currentThread().getId();
     portletReq.setAttribute(THREADID_ATTR, tid);

     StringWriter writer = new StringWriter();
     
     JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
     PortletPreferences portletPrefs = portletReq.getPreferences();
     
     /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store1    */
     /* Details: "The store method persists preference changes previously    */
     /* made during the processAction method"                                */
     if (portletReq.getParameter("tr2") != null && portletReq.getParameter("tr2").equals("true")) {
       TestResult tr2 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE1);
       if (portletPrefs.getValue("tr2", null).equals("true")) {
         tr2.setTcSuccess(true);
       } else {
         tr2.appendTcDetail(
             "Failed because tr2 value is not true but " + portletPrefs.getValue("tr2", null));
       }
       tr2.writeTo(writer);
     }
     
     /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store4    */
     /* Details: "If preference changes are made during the processAction    */
     /* method, but the method completes without store being called, the     */
     /* preference changes are discarded"                                    */
     if (portletReq.getParameter("tr3") != null && portletReq.getParameter("tr3").equals("true")) {
       TestResult tr3 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE4);
       if (portletPrefs.getValue("tr3", null).equals("false")) {
         tr3.setTcSuccess(true);
       } else {
         tr3.appendTcDetail(
             "Failed because tr3 value is not true but " + portletPrefs.getValue("tr3", null));
       }
       tr3.writeTo(writer);
     }
     
     String msg = (String) portletReq.getPortletSession()
         .getAttribute(RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_17_EventPreferences", APPLICATION_SCOPE);
     msg = msg + writer.toString();
     portletReq.getPortletSession().setAttribute(
         Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_17_EventPreferences",
        msg, APPLICATION_SCOPE);
     
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "event companion serveResource - ERROR!!");
   }

   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "event companion processEvent");


      portletResp.setRenderParameters(portletReq);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
      
      PortletPreferences portletPrefs = portletReq.getPreferences();

      // Create result objects for the tests

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_setValues4 */
      /* Details: "The setValues method allows the value array to be set to   */
      /* null"                                                                */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_SETVALUES4);
      try {
        portletPrefs.setValues("tr0", null);
        tr0.setTcSuccess(true);
      } catch (Exception e) {
        tr0.appendTcDetail(e.toString());
      }
      tr0.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_reset1    */
      /* Details: "The reset method sets the value of the specified           */
      /* preference to its default value. The actual default value itself     */
      /* is implementation-specific and cannot be tested."                    */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_RESET1);
      portletPrefs.setValue("tr1", "false");
      portletPrefs.reset("tr1");
      if (portletPrefs.getValue("tr1", null).equals("true")) {
        tr1.setTcSuccess(true);
      } else {
        tr1.appendTcDetail(
            "Failed because tr1 value is not true but " + portletPrefs.getValue("tr1", null));
      }
      tr1.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store1    */
      /* Details: "The store method persists preference changes previously    */
      /* made during the processAction method"                                */
      portletResp.setRenderParameter("tr2", "true");
      portletPrefs.setValue("tr2", "true");
      portletPrefs.store();

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store4    */
      /* Details: "If preference changes are made during the processAction    */
      /* method, but the method completes without store being called, the     */
      /* preference changes are discarded"                                    */
      portletResp.setRenderParameter("tr3", "true");
      portletPrefs.setValue("tr3", "true");

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment3 */
      /* Details: "A preference attribute definition may indicate if the      */
      /* attribute is read only"                                              */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT3);
      if (portletPrefs.isReadOnly("tr4")) {
        tr4.setTcSuccess(true);
      } else {
        tr4.appendTcDetail("Failed because tr4 is not read-only");
      }
      tr4.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment4 */
      /* Details: "If a preference attribute definition does not contain      */
      /* the read-only setting, it will be modifiable in the processAction    */
      /* method"                                                              */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT4);
      try {
        portletPrefs.setValue("tr5", "true");
        if (portletPrefs.getValue("tr5", null).equals("true")) {
          tr5.setTcSuccess(true);
        } else {
          tr5.appendTcDetail(
              "Failed because tr5 is not true but " + portletPrefs.getValue("tr5", null));
        }
      } catch (Exception e) {
        tr5.appendTcDetail(e.toString());
      }
      tr5.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment7 */
      /* Details: "If a preference attribute definition contains the          */
      /* read-only setting, it will not be modifiable in the processAction    */
      /* method"                                                              */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT7);
      try {
        portletPrefs.setValue("tr6", "true");
      } catch (ReadOnlyException e) {
        tr6.setTcSuccess(true);
        tr6.appendTcDetail(e.toString());
      }
      tr6.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment10 */
      /* Details: "A preference attribute not defined in the deployment       */
      /* descriptor may be added programmatically in the processAction        */
      /* method"                                                              */
      TestResult tr7 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT10);
      try {
        portletPrefs.setValue("tr7", "true");
        tr7.setTcSuccess(true);
      } catch (ReadOnlyException e) {
        tr7.appendTcDetail(e.toString());
      }
      tr7.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_17_EventPreferences",
                   writer.toString(), APPLICATION_SCOPE);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      
      LOGGER.entering(LOG_CLASS, "event companion render");

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>AddlEnvironmentTests_SPEC2_17_EventPreferences_event</p>\n");

      String msg = (String) portletReq.getPortletSession()
            .getAttribute(RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_17_EventPreferences", APPLICATION_SCOPE);
      msg = (msg==null) ? "Not ready. click test case link." : msg;
      writer.write("<p>" + msg + "</p>\n");
      
      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store1    */
      /* Details: "The store method persists preference changes previously    */
      /* made during the processAction method"                                */
      if (portletReq.getParameter("tr2") != null && portletReq.getParameter("tr2").equals("true")) {
        PortletURL aurl = portletResp.createActionURL();
        aurl.setParameters(portletReq.getPrivateParameterMap());
        TestButton tb =
            new TestButton("V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store1", aurl);
        tb.writeTo(writer);
      }
      
      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment3 */
      /* Details: "A preference attribute definition may indicate if the      */
      /* attribute is read only"                                              */
      if (portletReq.getParameter("tr3") != null && portletReq.getParameter("tr3").equals("true")) {
        PortletURL aurl = portletResp.createActionURL();
        aurl.setParameters(portletReq.getPrivateParameterMap());
        TestButton tb =
            new TestButton("V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store4", aurl);
        tb.writeTo(writer);
      }

   }

}
