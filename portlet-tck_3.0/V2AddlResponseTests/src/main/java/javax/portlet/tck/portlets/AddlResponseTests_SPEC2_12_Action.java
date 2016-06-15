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
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlResponseTests_SPEC2_12_Action_event
 *
 */
public class AddlResponseTests_SPEC2_12_Action implements Portlet, ResourceServingPortlet {
  private static final String LOG_CLASS = AddlResponseTests_SPEC2_12_Action.class.getName();
  private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

  private PortletConfig portletConfig = null;

  @Override
  public void init(PortletConfig config) throws PortletException {
    this.portletConfig = config;
  }

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {
    LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

    //portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    StringWriter writer = new StringWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    // Create result objects for the tests

    String action = portletReq.getParameter("inputval");

    if (action != null) {
      if (action.equals("V2AddlResponseTests_SPEC2_12_Action_cookie1")) {
        /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie1 */
        /* Details: "Cookies set during the Action phase should be available */
        /* to the portlet during the Render phase" */
        Cookie c = new Cookie("tr0_cookie", "true");
        c.setPath(portletReq.getContextPath());
        c.setMaxAge(100);
        c.setDomain("localhost");
        c.setVersion(0);
        portletResp.addProperty(c);
        portletResp.setRenderParameter("tr0", "true");
      } else if (action.equals("V2AddlResponseTests_SPEC2_12_Action_cookie2")) {
        /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie2 */
        /* Details: "Cookies set during the Action phase should be available */
        /* to the portlet during the Resource phase" */
        TestResult tr1 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE2);
        /* TODO: implement test */
        tr1.appendTcDetail("Not implemented.");
        tr1.writeTo(writer);
      } else if (action.equals("V2AddlResponseTests_SPEC2_12_Action_cookie3")) {
        /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie3 */
        /* Details: "Cookies set during the Action phase should be available */
        /* to the portlet during the Event phase" */
        TestResult tr2 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE3);
        /* TODO: implement test */
        tr2.appendTcDetail("Not implemented.");
        tr2.writeTo(writer);
      } else if (action.equals("V2AddlResponseTests_SPEC2_12_Action_cookie4")) {
        /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie4 */
        /* Details: "Cookies set during the Action phase should be available */
        /* to the portlet during a subsequent request triggered by a URL" */
        TestResult tr3 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE4);
        /* TODO: implement test */
        tr3.appendTcDetail("Not implemented.");
        tr3.writeTo(writer);
      } else if (action.equals("V2AddlResponseTests_SPEC2_12_Action_redirect1")) {
        /* TestCase: V2AddlResponseTests_SPEC2_12_Action_redirect1 */
        /* Details: "If a relative path is supplied to the sendRedirect */
        /* method, an IllegalArgumentException must be thrown" */
        // TODO: How to catch this exception. Also, thrown exception is not IllegalArgumentException
        // Problem - If I start the path from ../ or ./ it pluto reads it as 3/ or 4/ respectively. 
        //           If I start the path from / pluto considers it as full path which is allowed
        try{
          portletResp.sendRedirect("../V2AddlRequestTests");
        } catch (Exception e){
          portletResp.setRenderParameter("tr4", e.toString());
        }
      } else if (action.equals("V2AddlResponseTests_SPEC2_12_Action_redirect12")) {
        /* TestCase: V2AddlResponseTests_SPEC2_12_Action_redirect12 */
        /* Details: "If a new private render parameter value is set on the */
        /* ActionResponse before the redirect, the new private render */
        /* parameter value must be set on the attached render URL" */
        TestResult tr5 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12);
        /* TODO: implement test */
        tr5.appendTcDetail("Not implemented.");
        tr5.writeTo(writer);
      } else if (action.equals("V2AddlResponseTests_SPEC2_12_Action_redirect12")) {
        /* TestCase: V2AddlResponseTests_SPEC2_12_Action_redirect14 */
        /* Details: "If a new public render parameter value is set on the */
        /* ActionResponse before the redirect, the new public render */
        /* parameter value must be set on the attached render URL" */
        TestResult tr6 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT14);
        /* TODO: implement test */
        tr6.appendTcDetail("Not implemented.");
        tr6.writeTo(writer);
      }
    }
    // portletReq.getPortletSession().setAttribute(
    // Constants.RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Action", writer.toString(),
    // APPLICATION_SCOPE);
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

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();
    /*
     * PortletSession ps = portletReq.getPortletSession(); String msg = (String)
     * ps.getAttribute(RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Action", APPLICATION_SCOPE);
     * if (msg != null) { writer.write("<p>" + msg + "</p><br/>\n");
     * ps.removeAttribute(RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Action",
     * APPLICATION_SCOPE); }
     */
    /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie1 */
    /* Details: "Cookies set during the Action phase should be available */
    /* to the portlet during the Render phase" */
    if (portletReq.getParameter("tr0") != null && portletReq.getParameter("tr0").equals("true")) {
      Cookie[] cookies = portletReq.getCookies();
      System.out.println(cookies.length);
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE1);
      for (Cookie c : cookies) {
        System.out.println(c.getName() + " " + c.getValue());
        if (c.getName().equals("tr0_cookie") && c.getValue().equals("true")) {
          System.out.println(c.getName() + " " + c.getValue());
          tr0.setTcSuccess(true);
        }
      }
      tr0.writeTo(writer);
    } else {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlResponseTests_SPEC2_12_Action_cookie1", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie2 */
    /* Details: "Cookies set during the Action phase should be available */
    /* to the portlet during the Resource phase" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlResponseTests_SPEC2_12_Action_cookie2", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie3 */
    /* Details: "Cookies set during the Action phase should be available */
    /* to the portlet during the Event phase" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlResponseTests_SPEC2_12_Action_cookie3", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Action_cookie4 */
    /* Details: "Cookies set during the Action phase should be available */
    /* to the portlet during a subsequent request triggered by a URL" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlResponseTests_SPEC2_12_Action_cookie4", aurl);
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
      TestButton tb = new TestButton("V2AddlResponseTests_SPEC2_12_Action_redirect1", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Action_redirect12 */
    /* Details: "If a new private render parameter value is set on the */
    /* ActionResponse before the redirect, the new private render */
    /* parameter value must be set on the attached render URL" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlResponseTests_SPEC2_12_Action_redirect12", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Action_redirect14 */
    /* Details: "If a new public render parameter value is set on the */
    /* ActionResponse before the redirect, the new public render */
    /* parameter value must be set on the attached render URL" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlResponseTests_SPEC2_12_Action_redirect14", aurl);
      tb.writeTo(writer);
    }

  }

}
