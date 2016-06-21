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
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIEVENT_CANBECONFIGURED;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIEVENT_VALIDATE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIEVENT_VALIDATE2;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, but does
 * not publish them. Events are published in the main portlet for the test cases.
 */
public class EnvironmentTests_PreferencesValidator_ApiEvent_event implements Portlet, EventPortlet {
  private static final String LOG_CLASS =
      EnvironmentTests_PreferencesValidator_ApiEvent_event.class.getName();
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


    portletResp.setRenderParameters(portletReq);

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    StringWriter writer = new StringWriter();

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2EnvironmentTests_PreferencesValidator_ApiEvent_canBeConfigured */
    /* Details: "A PreferencesValidator can be configured in the */
    /* deployment descriptor" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIEVENT_CANBECONFIGURED);
    tr0.setTcSuccess(true);
    tr0.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PreferencesValidator_ApiEvent_validate1 */
    /* Details: "Method validate(PortletPreferences): The */
    /* validate(PortletPreferences): method is called when the */
    /* preferences are stored " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIEVENT_VALIDATE1);
    tr1.setTcSuccess(true);
    tr1.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PreferencesValidator_ApiEvent_validate2 */
    /* Details: "Method validate(PortletPreferences): If a */
    /* ValidatorException is thrown, the preferences are not stored" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIEVENT_VALIDATE2);
    tr2.setTcSuccess(true);
    tr2.writeTo(writer);

    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "EnvironmentTests_PreferencesValidator_ApiEvent", writer.toString(),
        APPLICATION_SCOPE);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    LOGGER.entering(LOG_CLASS, "event companion render");

    portletResp.setContentType("text/html");
    PrintWriter writer = portletResp.getWriter();
    writer.write("<h3>Event Companion Portlet </h3>\n");
    writer.write("<p>EnvironmentTests_PreferencesValidator_ApiEvent_event</p>\n");

    String msg = (String) portletReq.getPortletSession().getAttribute(
        RESULT_ATTR_PREFIX + "EnvironmentTests_PreferencesValidator_ApiEvent", APPLICATION_SCOPE);
    msg = (msg == null) ? "Not ready. click test case link." : msg;
    writer.write("<p>" + msg + "</p>\n");

  }

}
