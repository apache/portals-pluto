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
import javax.portlet.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
import static javax.portlet.PortletSession.*;
import org.apache.commons.lang3.StringUtils;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, but does
 * not publish them. Events are published in the main portlet for the test cases.
 * @author ahmed
 */
public class AddlRequestTests_SPEC2_11_EventReq_event implements Portlet, EventPortlet {
  private static final String LOG_CLASS = AddlRequestTests_SPEC2_11_EventReq_event.class.getName();
  private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {
    LOGGER.entering(LOG_CLASS, "event companion processAction - ERROR!!");
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

    // Create result objects for the tests

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_contentType1 */
    /* Details: "The getResponseContentType method returns a String */
    /* representing the default content type the portlet container */
    /* assumes for the output" */
    TestResult tr0 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_CONTENTTYPE1);
    if (portletReq.getResponseContentType() != null
        && !portletReq.getResponseContentType().isEmpty())
      tr0.setTcSuccess(true);
    tr0.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_contentType2 */
    /* Details: "The getResponseContentTypes method returns an */
    /* Enumeration of String elements representing the acceptable content */
    /* types for the output in order of preference" */
    TestResult tr1 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_CONTENTTYPE2);
    Enumeration<String> contentTypesTr1 = portletReq.getResponseContentTypes();
    if (contentTypesTr1 != null && contentTypesTr1.hasMoreElements()
        && !contentTypesTr1.nextElement().isEmpty())
      tr1.setTcSuccess(true);
    tr1.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_contentType3 */
    /* Details: "The first element of the Enumeration returned by the */
    /* getResponseContentTypes method must equal the value returned by */
    /* the getResponseContentType method" */
    TestResult tr2 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_CONTENTTYPE3);
    if (portletReq.getResponseContentTypes().nextElement()
        .equals(portletReq.getResponseContentType()))
      tr2.setTcSuccess(true);
    tr2.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_contentType4 */
    /* Details: "If a portlet defines support for all content types using */
    /* a wildcard and the portlet container supports all content types, */
    /* the getResponseContentType may return the wildcard" */
    TestResult tr3 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_CONTENTTYPE4);
    if (portletReq.getResponseContentType().equals("*/*")) {
      tr3.setTcSuccess(true);
    } else {
      tr3.appendTcDetail("Content type is " + portletReq.getResponseContentType());
    }
    tr3.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_contentType5 */
    /* Details: "If a portlet defines support for all content types using */
    /* a wildcard and the portlet container supports all content types, */
    /* the getResponseContentType may return the preferred content type" */
    TestResult tr4 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_CONTENTTYPE5);
    if (portletReq.getResponseContentType().equals("*/*")) {
      tr4.setTcSuccess(true);
    } else {
      tr4.appendTcDetail("Content type is " + portletReq.getResponseContentType());
    }
    tr4.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_windowId4 */
    /* Details: "The string returned by getWindowID method must be the */
    /* same ID used for scoping portlet-scope session attributes" */
    TestResult tr5 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_WINDOWID4);
    portletReq.getPortletSession().setAttribute("tr5", portletReq.getWindowID(), PORTLET_SCOPE);
    String tr5SessionAttribute = (String) portletReq.getPortletSession()
        .getAttribute("javax.portlet.p." + portletReq.getWindowID() + "?tr5", APPLICATION_SCOPE);
    if (tr5SessionAttribute != null && tr5SessionAttribute.equals(portletReq.getWindowID())) {
      tr5.setTcSuccess(true);
    } else {
      tr5.appendTcDetail(
          "Couldn't find javax.portlet.p." + portletReq.getWindowID() + ".tr5 attribute");
    }
    tr5.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_contentType8 */
    /* Details: "Within the processEvent method, the content type must */
    /* include only the MIME type, not the character set" */
    TestResult tr6 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_CONTENTTYPE8);
    if (!StringUtils.containsIgnoreCase(portletReq.getResponseContentType(), "UTF-8"))
      tr6.setTcSuccess(true);
    tr6.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_contentType9 */
    /* Details: "Within the processEvent method, the */
    /* getResponseContentTypes method must return only the content types */
    /* supported by the current portlet mode" */
    TestResult tr7 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_CONTENTTYPE9);
    Enumeration<String> contentTypesTr7 = portletReq.getResponseContentTypes();
    if (contentTypesTr7.nextElement().equals("*/*") && !contentTypesTr7.hasMoreElements())
      tr7.setTcSuccess(true);
    tr7.writeTo(writer);

    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_EventReq", writer.toString(),
        APPLICATION_SCOPE);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    LOGGER.entering(LOG_CLASS, "event companion render");

    portletResp.setContentType("text/html");
    PrintWriter writer = portletResp.getWriter();
    writer.write("<h3>Event Companion Portlet </h3>\n");
    writer.write("<p>AddlRequestTests_SPEC2_11_EventReq_event</p>\n");

    String msg = (String) portletReq.getPortletSession()
        .getAttribute(RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_EventReq", APPLICATION_SCOPE);
    msg = (msg == null) ? "Not ready. click test case link." : msg;
    writer.write("<p>" + msg + "</p>\n");

  }

}
