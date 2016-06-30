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

import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.PortletSession.PORTLET_SCOPE;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_DECODEATTRIBUTENAME1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_DECODEATTRIBUTENAME2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTE1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTE2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTE3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTENAMES1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTENAMES2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTENAMES3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION11;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_INVALIDATE;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_REMOVEATTRIBUTE1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_REMOVEATTRIBUTE2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_REMOVEATTRIBUTE3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETATTRIBUTE1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETATTRIBUTE2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETATTRIBUTE3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE3;
import static javax.portlet.tck.constants.Constants.BUTTON_PARAM_NAME;
import static javax.portlet.tck.constants.Constants.JSP_PREFIX;
import static javax.portlet.tck.constants.Constants.JSP_SUFFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSessionUtil;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestLink;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupLink;
import javax.portlet.tck.constants.Constants;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlEnvironmentTests_SPEC2_18_Sessions_event
 *
 */
@SuppressWarnings("deprecation")
public class AddlEnvironmentTests_SPEC2_18_Sessions implements Portlet {

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

    portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

  }


  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_scope1 */
    /* Details: "PortletSession objects must be scoped at the portlet */
    /* application context level" */
    TestResult tr0 = tcd.getTestResultSucceeded(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE1);
    tr0.appendTcDetail("Not implemented. Set to success because it would test servlet container functionality.");
    tr0.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_scope2 */
    /* Details: "The portlet container must not share the PortletSession */
    /* object or the attributes stored in it among different portlet */
    /* applications or among different user sessions" */
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr1", "true",
        PORTLET_SCOPE);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_scope3 */
    /* Details: "Any object stored in the session using the */
    /* APPLICATION_SCOPE is available to any portlet that belongs to the */
    /* same portlet application and that handles a request in the same */
    /* session" */
    {
       portletReq.getPortletSession().setAttribute(
             V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE3, "true",
           APPLICATION_SCOPE);
       
       // add setup link to make sure this is executed before the testing portlet executes.
       PortletURL rurl = portletResp.createRenderURL();
       rurl.setParameter(BUTTON_PARAM_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE3);
       TestSetupLink link = new TestSetupLink(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE3, rurl);
       link.writeTo(writer);
    }

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_scope4 */
    /* Details: "Any Object stored in the session using the PORTLET_SCOPE */
    /* must be available to the portlet during requests for the same */
    /* portlet window that stored the object" */
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr3", "true",
        PORTLET_SCOPE);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_scope5 */
    /* Details: "The PORTLET_SCOPE object must be stored in the */
    /* APPLICATION_SCOPE with the attribute name */
    /* 'javax.portlet.p.&lt;ID&gt;?&lt;ATTRIBUTE_NAME&gt;', where */
    /* &lt;ID&gt; must be equal to the ID returned by the */
    /* PortletRequest.getWindowID()" */
    TestResult tr4 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE5);
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr4", "true",
        PORTLET_SCOPE);
    String tr4_success = (String) portletReq.getPortletSession()
        .getAttribute("javax.portlet.p." + portletReq.getWindowID() + "?"
            + Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr4",
            APPLICATION_SCOPE);
    if (tr4_success != null && tr4_success.equals("true")) {
      tr4.setTcSuccess(true);
    } else {
      tr4.appendTcDetail("Failed becuase there is no attribute with key \"javax.portlet.p."
          + portletReq.getWindowID() + "?" + Constants.RESULT_ATTR_PREFIX
          + "AddlEnvironmentTests_SPEC2_18_Sessions_tr4\"");
    }
    tr4.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_setAttribute1 */
    /* Details: "The setAttribute method can bind an object to the */
    /* session in PORTLET_SCOPE" */
    TestResult tr5 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETATTRIBUTE1);
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr5", "true",
        PORTLET_SCOPE);
    String tr5_success = (String) portletReq.getPortletSession().getAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr5", PORTLET_SCOPE);
    if (tr5_success != null && tr5_success.equals("true")) {
      tr5.setTcSuccess(true);
    } else {
      tr5.appendTcDetail("Failed becuase there is no attribute with key \""
          + Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr5\"");
    }
    tr5.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_setAttribute2 */
    /* Details: "The setAttribute method that does not take a scope */
    /* parameter binds an object to the session in PORTLET_SCOPE" */
    TestResult tr6 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETATTRIBUTE2);
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr6", "true");
    String tr6_success = (String) portletReq.getPortletSession().getAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr6", PORTLET_SCOPE);
    if (tr6_success != null && tr6_success.equals("true")) {
      tr6.setTcSuccess(true);
    } else {
      tr6.appendTcDetail("Failed becuase there is no attribute with key \""
          + Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr6\"");
    }
    tr6.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_setAttribute3 */
    /* Details: "The setAttribute method can bind an object to the */
    /* session in APPLICATION_SCOPE" */
    TestResult tr7 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETATTRIBUTE3);
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr7", "true",
        APPLICATION_SCOPE);
    String tr7_success = (String) portletReq.getPortletSession().getAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr7",
        APPLICATION_SCOPE);
    if (tr7_success != null && tr7_success.equals("true")) {
      tr7.setTcSuccess(true);
    } else {
      tr7.appendTcDetail("Failed becuase there is no attribute with key \""
          + Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr7\"");
    }
    tr7.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttribute1 */
    /* Details: "The getAttribute method is used to retrieve attributes */
    /* stored in the session in PORTLET_SCOPE" */
    TestResult tr8 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTE1);
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr8", "true",
        PORTLET_SCOPE);
    String tr8_success = (String) portletReq.getPortletSession().getAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr8", PORTLET_SCOPE);
    if (tr8_success != null && tr8_success.equals("true")) {
      tr8.setTcSuccess(true);
    } else {
      tr8.appendTcDetail("Failed becuase there is no attribute with key \""
          + Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr8\"");
    }
    tr8.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttribute2 */
    /* Details: "The getAttribute method that does not take a scope */
    /* parameter retrieves attributes stored in the session in */
    /* PORTLET_SCOPE" */
    TestResult tr9 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTE2);
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr9", "true",
        PORTLET_SCOPE);
    String tr9_success = (String) portletReq.getPortletSession()
        .getAttribute(Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr9");
    if (tr9_success != null && tr9_success.equals("true")) {
      tr9.setTcSuccess(true);
    } else {
      tr9.appendTcDetail("Failed becuase there is no attribute with key \""
          + Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr9\"");
    }
    tr9.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttribute3 */
    /* Details: "The getAttribute method is used to retrieve attributes */
    /* stored in the session in APPLICATION_SCOPE" */
    TestResult tr10 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTE3);
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr10", "true",
        APPLICATION_SCOPE);
    String tr10_success = (String) portletReq.getPortletSession().getAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr10",
        APPLICATION_SCOPE);
    if (tr10_success != null && tr10_success.equals("true")) {
      tr10.setTcSuccess(true);
    } else {
      tr10.appendTcDetail("Failed becuase there is no attribute with key \""
          + Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr10\"");
    }
    tr10.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_removeAttribute1 */
    /* Details: "The removeAttribute method is used to remove attributes */
    /* stored in the session in PORTLET_SCOPE" */
    TestResult tr11 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_REMOVEATTRIBUTE1);
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr11", "true",
        PORTLET_SCOPE);
    portletReq.getPortletSession().removeAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr11",
        PORTLET_SCOPE);
    String tr11_success = (String) portletReq.getPortletSession().getAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr11",
        PORTLET_SCOPE);
    if (tr11_success == null) {
      tr11.setTcSuccess(true);
    } else {
      tr11.appendTcDetail("Failed because \"" + Constants.RESULT_ATTR_PREFIX
          + "AddlEnvironmentTests_SPEC2_18_Sessions_tr11\" attribute is still present in session");
    }
    tr11.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_removeAttribute2 */
    /* Details: "The removeAttribute method that does not take a scope */
    /* parameter remove attributes stored in the session in */
    /* PORTLET_SCOPE" */
    TestResult tr12 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_REMOVEATTRIBUTE2);
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr12", "true",
        PORTLET_SCOPE);
    portletReq.getPortletSession().removeAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr12");
    String tr12_success = (String) portletReq.getPortletSession().getAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr12",
        PORTLET_SCOPE);
    if (tr12_success == null) {
      tr12.setTcSuccess(true);
    } else {
      tr12.appendTcDetail("Failed because \"" + Constants.RESULT_ATTR_PREFIX
          + "AddlEnvironmentTests_SPEC2_18_Sessions_tr12\" attribute is still present in session");
    }
    tr12.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_removeAttribute3 */
    /* Details: "The removeAttribute method is used to remove attributes */
    /* stored in the session in APPLICATION_SCOPE" */
    TestResult tr13 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_REMOVEATTRIBUTE3);
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr13", "true",
        APPLICATION_SCOPE);
    portletReq.getPortletSession().removeAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr13",
        APPLICATION_SCOPE);
    String tr13_success = (String) portletReq.getPortletSession().getAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr13",
        APPLICATION_SCOPE);
    if (tr13_success == null) {
      tr13.setTcSuccess(true);
    } else {
      tr13.appendTcDetail("Failed because \"" + Constants.RESULT_ATTR_PREFIX
          + "AddlEnvironmentTests_SPEC2_18_Sessions_tr13\" attribute is still present in session");
    }
    tr13.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttributeNames1 */
    /* Details: "The getAttributeNames method can retrieve an */
    /* Enumeration&lt;String&gt; of all attribute names stored in the */
    /* session in PORTLET_SCOPE" */
    TestResult tr14 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTENAMES1);
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr14", "true",
        PORTLET_SCOPE);
    Enumeration<String> sessionAttributes_tr14 =
        portletReq.getPortletSession().getAttributeNames(PORTLET_SCOPE);
    while (sessionAttributes_tr14.hasMoreElements()) {
      if (sessionAttributes_tr14.nextElement()
          .equals(Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr14")) {
        tr14.setTcSuccess(true);
      }
    }
    if (!tr14.isTcSuccess()) {
      tr14.appendTcDetail("Failed because cannot find the attribute " + Constants.RESULT_ATTR_PREFIX
          + "AddlEnvironmentTests_SPEC2_18_Sessions_tr14" + " in the Enumeration");
    }
    tr14.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttributeNames2 */
    /* Details: "The getAttributeNames method that does not take a scope */
    /* parameter retrieves an Enumeration&lt;String&gt; of all attribute */
    /* names stored in the session in PORTLET_SCOPE" */
    TestResult tr15 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTENAMES2);
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr15", "true",
        PORTLET_SCOPE);
    Enumeration<String> sessionAttributes_tr15 = portletReq.getPortletSession().getAttributeNames();
    while (sessionAttributes_tr15.hasMoreElements()) {
      if (sessionAttributes_tr15.nextElement()
          .equals(Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr15")) {
        tr15.setTcSuccess(true);
      }
    }
    if (!tr15.isTcSuccess()) {
      tr15.appendTcDetail("Failed because cannot find the attribute " + Constants.RESULT_ATTR_PREFIX
          + "AddlEnvironmentTests_SPEC2_18_Sessions_tr15" + " in the Enumeration");
    }
    tr15.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttributeNames3 */
    /* Details: "The getAttributeNames method can retrieve an */
    /* Enumeration&lt;String&gt; of all attribute names stored in the */
    /* session in APPLICATION_SCOPE" */
    TestResult tr16 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTENAMES3);
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr16", "true",
        APPLICATION_SCOPE);
    Enumeration<String> sessionAttributes_tr16 =
        portletReq.getPortletSession().getAttributeNames(APPLICATION_SCOPE);
    while (sessionAttributes_tr16.hasMoreElements()) {
      if (sessionAttributes_tr16.nextElement()
          .equals(Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr16")) {
        tr16.setTcSuccess(true);
      }
    }
    if (!tr16.isTcSuccess()) {
      tr16.appendTcDetail("Failed because cannot find the attribute " + Constants.RESULT_ATTR_PREFIX
          + "AddlEnvironmentTests_SPEC2_18_Sessions_tr16" + " in the Enumeration");
    }
    tr16.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_decodeAttributeName1 */
    /* Details: "The PortletSessionUtil.decodeAttributeName method */
    /* returns the attribute name without the prefix for an attribute */
    /* name retrieved from the HttpSession" */
    TestResult tr17 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_DECODEATTRIBUTENAME1);
    portletReq.getPortletSession().setAttribute("javax.portlet.p.id?tr17", "true", PORTLET_SCOPE);
    if (PortletSessionUtil.decodeAttributeName("javax.portlet.p.id?tr17").equals("tr17")) {
      tr17.setTcSuccess(true);
    } else {
      tr17.appendTcDetail("Failed because decoded attribute name is not tr17 but "
          + PortletSessionUtil.decodeAttributeName("javax.portlet.p.id?tr17"));
    }
    tr17.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_decodeAttributeName2 */
    /* Details: "The PortletSessionUtil.decodeAttributeName method */
    /* returns the attribute name without the prefix for an attribute */
    /* name retrieved from the PortletSession in APPLICATION_SCOPE" */
    TestResult tr18 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_DECODEATTRIBUTENAME2);
    portletReq.getPortletSession().setAttribute("javax.portlet.p.id?tr18", "true",
        APPLICATION_SCOPE);
    if (PortletSessionUtil.decodeAttributeName("javax.portlet.p.id?tr18").equals("tr18")) {
      tr18.setTcSuccess(true);
    } else {
      tr18.appendTcDetail("Failed because decoded attribute name is not tr18 but "
          + PortletSessionUtil.decodeAttributeName("javax.portlet.p.id?tr18"));
    }
    tr18.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession7 */
    /* Details: "The attribute names retrieved from the HttpSession must */
    /* have the speficied prefixing if PORTLET_SCOPE scope is used" */
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr25", "true",
        PORTLET_SCOPE);

    PortletRequestDispatcher rd = portletConfig.getPortletContext()
        .getNamedDispatcher("AddlEnvironmentTests_SPEC2_18_Sessions_servlet");
    rd.include(portletReq, portletResp);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession1 */
    /* Details: "Data stored in the HttpSession by a servlet in the same */
    /* web application is accessible to portlets through the */
    /* PortletSession in APPLICATION_SCOPE" */
    TestResult tr19 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION1);
    String tr19_success = (String) portletReq.getPortletSession().getAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr19",
        APPLICATION_SCOPE);
    if (tr19_success != null && tr19_success.equals("true")) {
      tr19.setTcSuccess(true);
    } else {
      tr19.appendTcDetail("Failed becuase there is no attribute with key \""
          + Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr19\"");
    }
    tr19.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession3 */
    /* Details: "Data stored by portlets in the PortletSession is */
    /* accessible to servlets and JSPs through the HttpSession" */
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr21", "true",
        APPLICATION_SCOPE);

    String target = JSP_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions" + JSP_SUFFIX;
    PortletRequestDispatcher rd2 = portletConfig.getPortletContext().getRequestDispatcher(target);
    rd2.include(portletReq, portletResp);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession2 */
    /* Details: "Data stored in the HttpSession by a JSP in the same web */
    /* application is accessible to portlets through the PortletSession */
    /* in APPLICATION_SCOPE" */
    TestResult tr20 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION2);
    String tr20_success = (String) portletReq.getPortletSession().getAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr20",
        APPLICATION_SCOPE);
    if (tr20_success != null && tr20_success.equals("true")) {
      tr20.setTcSuccess(true);
    } else {
      tr20.appendTcDetail("Failed becuase there is no attribute with key \""
          + Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr20\"");
    }
    tr20.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession6 */
    /* Details: "The attribute names retrieved from the HttpSession must */
    /* be the same as those retrieve from the PortletSession if */
    /* APPLICATION_SCOPE scope is used" */
    TestResult tr24 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION6);
    String tr24_success = (String) portletReq.getPortletSession().getAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr24",
        APPLICATION_SCOPE);
    if (tr24_success != null && tr24_success.equals("true")) {
      tr24.setTcSuccess(true);
    } else {
      tr24.appendTcDetail("Failed becuase there is no attribute with key \""
          + Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr24\"");
    }
    tr24.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession4 */
    /* Details: "If the HttpSession object is invalidated, the */
    /* PortletSession object must also be invalidated by the portlet */
    /* container" */
    {
       String tcid = portletReq.getParameter(BUTTON_PARAM_NAME);
       if (tcid == null || !tcid.equals(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION4)) {
          
          // generate test link 
          
          PortletURL rurl = portletResp.createRenderURL();
          rurl.setParameter(BUTTON_PARAM_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION4);
          TestLink tl = new TestLink(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION4, rurl);
          tl.writeTo(writer);
       } else {
          
          // perform test
          
          TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION4);
          PortletRequestDispatcher rd3 = portletConfig.getPortletContext()
              .getNamedDispatcher("AddlEnvironmentTests_SPEC2_18_Sessions_invalidate1");
          rd3.include(portletReq, portletResp);
          if (!portletReq.isRequestedSessionIdValid()) {
            result.setTcSuccess(true);
          } else {
            result.appendTcDetail("Failed because session is not invalidated.");
          }
          result.writeTo(writer);
       }
    }

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession11 */
    /* Details: "The portlet session follows the same semantic */
    /* considerations as the servlet session" */
    TestResult tr28 = tcd.getTestResultSucceeded(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION11);
    tr28.appendTcDetail("Test case ignored.");
    tr28.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_invalidate */
    /* Details: "The PortletSession.invalidate method provides the same */
    /* functionality as the corresponding HttpSession.invalidate method" */
    {
       String tcid = portletReq.getParameter(BUTTON_PARAM_NAME);
       if (tcid == null || !tcid.equals(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_INVALIDATE)) {
          
          // generate test link 
          
          PortletURL rurl = portletResp.createRenderURL();
          rurl.setParameter(BUTTON_PARAM_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_INVALIDATE);
          TestLink tl = new TestLink(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_INVALIDATE, rurl);
          tl.writeTo(writer);
       } else {
          
          // perform test
          
          TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_INVALIDATE);
          portletReq.getPortletSession(true).invalidate();
          if (!portletReq.isRequestedSessionIdValid()) {
            result.setTcSuccess(true);
          } else {
            result.appendTcDetail("Failed because session is not invalidated.");
          }
          result.writeTo(writer);
       }
    }

  }

}
