/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package javax.portlet.tck.portlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupButton;
import javax.portlet.tck.beans.TestSetupLink;
import javax.servlet.http.Cookie;
import javax.xml.namespace.QName;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT14;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE3;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;
import static javax.portlet.tck.constants.Constants.BUTTON_PARAM_NAME;
import static javax.portlet.tck.constants.Constants.SETUP_ID;
import static javax.portlet.tck.constants.Constants.TCKPAGE;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.ResourceURL.PAGE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined in the
 * /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate the test case names
 * defined in the additionalTCs.xml file into the complete list of test case names for execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will initiate the
 * events, but not process them. The processing is done in the companion portlet AddlResponseTests_SPEC2_12_Action_event
 * 
 */
public class AddlResponseTests_SPEC2_12_Action implements Portlet, ResourceServingPortlet, EventPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {

      // portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      String action = portletReq.getParameter(BUTTON_PARAM_NAME);
      portletResp.setRenderParameter(BUTTON_PARAM_NAME, action);

      if (action != null) {
         if (action.equals("V2AddlResponseTests_SPEC2_12_Action_cookie1")) {
            /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie1 */
            /* Details: "Cookies set during the Action phase should be available */
            /* to the portlet during the Render phase" */
            Cookie c = new Cookie("action_tr0_cookie", "true");
            c.setMaxAge(100);
            c.setPath("/");
            portletResp.addProperty(c);
            portletResp.setRenderParameter("tr0", "true");
         } else if (action.equals("V2AddlResponseTests_SPEC2_12_Action_cookie2")) {
            /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie2 */
            /* Details: "Cookies set during the Action phase should be available */
            /* to the portlet during the Resource phase" */
            Cookie c = new Cookie("action_tr1_cookie", "true");
            c.setMaxAge(100);
            c.setPath("/");
            portletResp.addProperty(c);
            portletResp.setRenderParameter("tr1", "true");
         } else if (action.equals("V2AddlResponseTests_SPEC2_12_Action_cookie3")) {
            /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie3 */
            /* Details: "Cookies set during the Action phase should be available */
            /* to the portlet during the Event phase" */
            if (portletReq.getParameter("tr2") != null && portletReq.getParameter("tr2").equals("true")) {
               portletResp.setRenderParameter("tr2", "true");
               QName eventQName = new QName(TCKNAMESPACE, "AddlResponseTests_SPEC2_12_Action");
               portletResp.setEvent(eventQName, "Hi!");
            } else {
               Cookie c = new Cookie("action_tr2_cookie", "true");
               c.setMaxAge(100);
               c.setPath("/");
               portletResp.addProperty(c);
               portletResp.setRenderParameter("tr2", "true");
            }
         } else if (action.equals("V2AddlResponseTests_SPEC2_12_Action_cookie4")) {
            /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie4 */
            /* Details: "Cookies set during the Action phase should be available */
            /* to the portlet during a subsequent request triggered by a URL" */
            if (portletReq.getParameter("tr3") != null && portletReq.getParameter("tr3").equals("true")) {
               Cookie[] cookies = portletReq.getCookies();

               StringBuilder txt = new StringBuilder(128);
               txt.append("<p>Debug info:");
               txt.append("<br>");

               txt.append("# Cookies: ").append(cookies.length).append("<br>");
               TestResult tr3 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE4);
               for (Cookie c : cookies) {
                  txt.append("Name: ").append(c.getName());
                  txt.append(", Value: ").append(c.getValue()).append("<br>");
                  if (c.getName().equals("action_tr3_cookie") && c.getValue().equals("true")) {
                     txt.append("<br>").append("Found my cookie!").append("<br>");
                     c.setMaxAge(0);
                     c.setValue("");
                     tr3.setTcSuccess(true);
                  }
               }
               tr3.writeTo(writer);
               txt.append("</p>");
               writer.append(txt.toString());
            } else {
               Cookie c = new Cookie("action_tr3_cookie", "true");
               c.setMaxAge(100);
               c.setPath("/");
               portletResp.addProperty(c);
               portletResp.setRenderParameter("tr3", "true");
            }
         } else if (action.equals("V2AddlResponseTests_SPEC2_12_Action_redirect1")) {
            /* TestCase: V2AddlResponseTests_SPEC2_12_Action_redirect1 */
            /* Details: "If a relative path is supplied to the sendRedirect */
            /* method, an IllegalArgumentException must be thrown" */
            try {
               portletResp.sendRedirect("V2AddlRequestTests");
            } catch (IllegalArgumentException e) {
               portletResp.setRenderParameter("tr4", e.toString());
            }
         } else if (action.equals(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12 + SETUP_ID)) {

            /* TestCase: V2AddlResponseTests_SPEC2_12_Action_redirect12 */
            /* Details: "If a new private render parameter value is set on the */
            /* ActionResponse before the redirect, the new private render */
            /* parameter value must be set on the attached render URL" */
            
            // these parameters get added to the render URL passed to the redirect target
            portletResp.setRenderParameter(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12, "true");
            portletResp.setRenderParameter(BUTTON_PARAM_NAME, V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12);
            
            StringBuilder txt = new StringBuilder(128);
            txt.append(portletReq.getContextPath());
            txt.append("/AddlResponseTests_SPEC_12_Action_servlet");
            txt.append("?").append(BUTTON_PARAM_NAME).append("=").append(action);
            txt.append("#testFragment");     
            portletResp.sendRedirect(txt.toString(), TCKPAGE);
            
         } else if (action.equals(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT14 + SETUP_ID)) {
            /* TestCase: V2AddlResponseTests_SPEC2_12_Action_redirect14 */
            /* Details: "If a new public render parameter value is set on the */
            /* ActionResponse before the redirect, the new public render */
            /* parameter value must be set on the attached render URL" */
            
            // these parameters get added to the render URL passed to the redirect target
            portletResp.setRenderParameter("tckPRP1", "true");
            portletResp.setRenderParameter(BUTTON_PARAM_NAME, V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT14);
            
            StringBuilder txt = new StringBuilder(128);
            txt.append(portletReq.getContextPath());
            txt.append("/AddlResponseTests_SPEC_12_Action_servlet");
            txt.append("?").append(BUTTON_PARAM_NAME).append("=").append(action);
            portletResp.sendRedirect(txt.toString(), TCKPAGE);
         }

         portletReq.getPortletSession().setAttribute(RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Action", writer.toString(), APPLICATION_SCOPE);
      }
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp) throws PortletException, IOException {

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie2 */
      /* Details: "Cookies set during the Action phase should be available */
      /* to the portlet during the Resource phase" */
      if (portletReq.getParameter("tr1") != null && portletReq.getParameter("tr1").equals("true")) {
         Cookie[] cookies = portletReq.getCookies();

         StringBuilder txt = new StringBuilder(128);
         txt.append("<p>Debug info:");
         txt.append("<br>");
         txt.append("# Cookies: ").append(cookies.length).append("<br>");
         TestResult tr1 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE2);
         for (Cookie c : cookies) {
            txt.append("Name: ").append(c.getName());
            txt.append(", Value: ").append(c.getValue()).append("<br>");
            if (c.getName().equals("action_tr1_cookie") && c.getValue().equals("true")) {
               txt.append("<br>").append("Found my cookie!").append("<br>");
               c.setMaxAge(0);
               c.setValue("");
               tr1.setTcSuccess(true);
            }
         }
         tr1.writeTo(writer);
         txt.append("</p>");
         writer.append(txt.toString());
      }

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();
      String action = portletReq.getParameter(BUTTON_PARAM_NAME);

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Action", APPLICATION_SCOPE)
            + (String) ps.getAttribute(RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Action_event", APPLICATION_SCOPE);
      if (msg != null && !msg.equals("nullnull") && !msg.equals("null")) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Action", APPLICATION_SCOPE);
         ps.removeAttribute(RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Action_event", APPLICATION_SCOPE);
      }

      /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie1 */
      /* Details: "Cookies set during the Action phase should be available */
      /* to the portlet during the Render phase" */
      if (portletReq.getParameter("tr0") != null && portletReq.getParameter("tr0").equals("true")) {
         Cookie[] cookies = portletReq.getCookies();

         StringBuilder txt = new StringBuilder(128);
         txt.append("<p>Debug info:");
         txt.append("<br>");

         txt.append("# Cookies: ").append(cookies.length).append("<br>");
         TestResult tr0 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE1);
         for (Cookie c : cookies) {
            txt.append("Name: ").append(c.getName());
            txt.append(", Value: ").append(c.getValue()).append("<br>");
            if (c.getName().equals("action_tr0_cookie") && c.getValue().equals("true")) {
               txt.append("<br>").append("Found my cookie!").append("<br>");
               c.setMaxAge(0);
               c.setValue("");
               tr0.setTcSuccess(true);
            }
         }
         tr0.writeTo(writer);
         txt.append("</p>");
         writer.append(txt.toString());
      } else {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie2 */
      /* Details: "Cookies set during the Action phase should be available */
      /* to the portlet during the Resource phase" */
      if (portletReq.getParameter("tr1") != null && portletReq.getParameter("tr1").equals("true")) {
         writer.write("<div id=\"AddlResponseTests_SPEC2_11_Action\">no resource output.</div>\n");
         ResourceURL resurl = portletResp.createResourceURL();
         resurl.setCacheability(PAGE);
         writer.write("<script>\n");
         writer.write("(function () {\n");
         writer.write("   var xhr = new XMLHttpRequest();\n");
         writer.write("   xhr.onreadystatechange=function() {\n");
         writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
         writer.write("         document.getElementById(\"AddlResponseTests_SPEC2_11_Action\").innerHTML=xhr.responseText;\n");
         writer.write("      }\n");
         writer.write("   };\n");
         writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
         writer.write("   xhr.send();\n");
         writer.write("})();\n");
         writer.write("</script>\n");
      } else {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie3 */
      /* Details: "Cookies set during the Action phase should be available */
      /* to the portlet during the Event phase" */
      if (portletReq.getParameter("tr2") != null && portletReq.getParameter("tr2").equals("true")) {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE3, aurl);
         tb.writeTo(writer);
      } else {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         aurl.setParameter("inputval", "V2AddlResponseTests_SPEC2_12_Action_cookie3");
         TestSetupLink tb = new TestSetupLink(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie4 */
      /* Details: "Cookies set during the Action phase should be available */
      /* to the portlet during a subsequent request triggered by a URL" */
      if (portletReq.getParameter("tr3") != null && portletReq.getParameter("tr3").equals("true")) {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE4, aurl);
         tb.writeTo(writer);
      } else {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         aurl.setParameter("inputval", "V2AddlResponseTests_SPEC2_12_Action_cookie4");
         TestSetupLink tb = new TestSetupLink(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlResponseTests_SPEC2_12_Action_redirect1 */
      /* Details: "If a relative path is supplied to the sendRedirect */
      /* method, an IllegalArgumentException must be thrown" */
      if (portletReq.getParameter("tr4") != null) {
         TestResult tr4 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT1);
         tr4.setTcSuccess(true);
         tr4.appendTcDetail(portletReq.getParameter("tr4"));
         tr4.writeTo(writer);
      } else {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlResponseTests_SPEC2_12_Action_redirect12 */
      /* Details: "If a new private render parameter value is set on the */
      /* ActionResponse before the redirect, the new private render */
      /* parameter value must be set on the attached render URL" */
      {
         if (action != null && action.equals(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12)) {
            TestResult result = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12);
            String val = portletReq.getParameter(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12);
            if (val != null && val.equals("true")) {
               result.setTcSuccess(true);
            } else {
               StringBuilder txt = new StringBuilder(128);
               txt.append("Parameter ").append(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12);
               txt.append(" had invalid value: ").append(val);
               result.appendTcDetail(txt.toString());
            }
            result.writeTo(writer);
         } else {
            PortletURL aurl = portletResp.createActionURL();
            TestSetupButton tb = new TestSetupButton(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12, aurl);
            tb.writeTo(writer);
         }
      }

      /* TestCase: V2AddlResponseTests_SPEC2_12_Action_redirect14 */
      /* Details: "If a new public render parameter value is set on the */
      /* ActionResponse before the redirect, the new public render */
      /* parameter value must be set on the attached render URL" */
      // TODO: Fix test case.
      {
         if (action != null && action.equals(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT14)) {
            TestResult result = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT14);
            String val = portletReq.getParameter("tckPRP1");
            if (val != null && val.equals("true")) {
               result.setTcSuccess(true);
            } else {
               StringBuilder txt = new StringBuilder(128);
               txt.append("Parameter ").append("tckPRP1");
               txt.append(" had invalid value: ").append(val);
               result.appendTcDetail(txt.toString());
            }
            result.writeTo(writer);
         } else {
            PortletURL aurl = portletResp.createActionURL();
            TestSetupButton tb = new TestSetupButton(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT14, aurl);
            tb.writeTo(writer);
         }
      }

   }

   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp) throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie3 */
      /* Details: "Cookies set during the Action phase should be available */
      /* to the portlet during the Event phase" */
      if (portletReq.getParameter("tr2") != null && portletReq.getParameter("tr2").equals("true")) {
         Cookie[] cookies = portletReq.getCookies();

         StringBuilder txt = new StringBuilder(128);
         txt.append("<p>Debug info:");
         txt.append("<br>");
         txt.append("# Cookies: ").append(cookies.length).append("<br>");
         TestResult tr2 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE3);
         for (Cookie c : cookies) {
            txt.append("Name: ").append(c.getName());
            txt.append(", Value: ").append(c.getValue()).append("<br>");
            if (c.getName().equals("action_tr2_cookie") && c.getValue().equals("true")) {
               txt.append("<br>").append("Found my cookie!").append("<br>");
               c.setMaxAge(0);
               c.setValue("");
               tr2.setTcSuccess(true);
            }
         }
         tr2.writeTo(writer);
         txt.append("</p>");
         writer.append(txt.toString());
      }
      portletReq.getPortletSession().setAttribute(RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Action_event", writer.toString(), APPLICATION_SCOPE);
   }

}
