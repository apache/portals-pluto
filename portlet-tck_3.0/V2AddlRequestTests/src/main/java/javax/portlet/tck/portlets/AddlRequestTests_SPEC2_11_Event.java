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
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupLink;
import javax.xml.namespace.QName;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS12;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS15;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS16;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS5;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlRequestTests_SPEC2_11_Event_event
 * 
 * @author ahmed
 */
public class AddlRequestTests_SPEC2_11_Event implements Portlet, EventPortlet {

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {

    portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    QName eventQName = new QName(TCKNAMESPACE, "AddlRequestTests_SPEC2_11_Event");
    portletResp.setEvent(eventQName, "Hi!");
  }


  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    /* TestCase: V2AddlRequestTests_SPEC2_11_Event_parameters2 */
    /* Details: "The parameters the request object returns must be */
    /* \"x-www-form-urlencoded\" decoded" */
    if (portletReq.getParameter("tr1_success") == null) {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      aurl.setParameter("tr1", "true&<>\"'");
      TestButton tb = new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS2, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Event_parameters6 */
    /* Details: "The getParameterMap method must return an unmodifiable */
    /* Map object" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS6, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Event_parameters12 */
    /* Details: "If a portlet receives an event that is the result of a */
    /* client request targeted to another portlet in the portal page, the */
    /* parameters should be the same parameters as of the previous render */
    /* request from this client" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS12, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Event_publicRenderParameters15 */
    /* Details: "A map of private parameters can be obtained through the */
    /* getPrivateParameterMap method" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      aurl.setParameter("tr4", "true");
      TestButton tb =
          new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS15, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Event_publicRenderParameters16 */
    /* Details: "A map of public parameters can be obtained through the */
    /* getPublicParameterMap method" */
    {
      if (portletReq.getParameter("tckPRP2") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tckPRP2", "true");
        TestSetupLink tl =
            new TestSetupLink(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS16, purl);
        tl.writeTo(writer);
      } else {
        PortletURL aurl = portletResp.createActionURL();
        aurl.setParameters(portletReq.getPrivateParameterMap());
        TestButton tb =
            new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS16, aurl);
        tb.writeTo(writer);
      }
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Event_publicRenderParameters5 */
    /* Details: "Public render parameters are available in the */
    /* processEvent method" */
    {
      if (portletReq.getParameter("tckPRP2") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tckPRP2", "true");
        TestSetupLink tl =
            new TestSetupLink(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS5, purl);
        tl.writeTo(writer);
      } else {
        PortletURL aurl = portletResp.createActionURL();
        aurl.setParameters(portletReq.getPrivateParameterMap());
        TestButton tb =
            new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS5, aurl);
        tb.writeTo(writer);
      }
    }
  }

  @Override
  public void processEvent(EventRequest portletReq, EventResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    StringWriter writer = new StringWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2AddlRequestTests_SPEC2_11_Event_parameters2 */
    /* Details: "The parameters the request object returns must be */
    /* \"x-www-form-urlencoded\" decoded" */
    TestResult tr1 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS2);
    if (portletReq.getParameter("tr1") != null
        && portletReq.getParameter("tr1").equals("true&<>\"'")) {
      tr1.setTcSuccess(true);
      portletResp.setRenderParameter("tr1_success", "true");
    }
    tr1.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_Event_parameters6 */
    /* Details: "The getParameterMap method must return an unmodifiable */
    /* Map object" */
    TestResult tr2 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS6);
    if (portletReq.getParameterMap().containsKey("inputval")
        && "V2AddlRequestTests_SPEC2_11_Event_parameters6"
            .equals(portletReq.getParameterMap().get("inputval")[0])) {
      String tr2TestStringArray[] = {"Modified Value"};
      try {
        portletReq.getParameterMap().put("inputval", tr2TestStringArray);
        if ("V2AddlRequestTests_SPEC2_11_Event_parameters6"
            .equals(portletReq.getParameterMap().get("inputval")[0])) {
          tr2.setTcSuccess(true);
        }
      } catch (UnsupportedOperationException e) {
        tr2.setTcSuccess(true);
      }
    }
    tr2.writeTo(writer);



    /* TestCase: V2AddlRequestTests_SPEC2_11_Event_publicRenderParameters15 */
    /* Details: "A map of private parameters can be obtained through the */
    /* getPrivateParameterMap method" */
    TestResult tr4 =
        tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS15);
    if (portletReq.getPrivateParameterMap() != null
        && portletReq.getPrivateParameterMap().containsKey("tr4")
        && portletReq.getPrivateParameterMap().get("tr4")[0].equals("true")) {
      tr4.setTcSuccess(true);
    }
    tr4.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_Event_publicRenderParameters16 */
    /* Details: "A map of public parameters can be obtained through the */
    /* getPublicParameterMap method" */
    TestResult tr5 =
        tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS16);
    if (portletReq.getPublicParameterMap() != null
        && portletReq.getPublicParameterMap().containsKey("tckPRP2")) {
      tr5.setTcSuccess(true);
    }
    tr5.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_Event_publicRenderParameters5 */
    /* Details: "Public render parameters are available in the */
    /* processEvent method" */
    TestResult tr6 =
        tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS5);
    Map<String, String[]> publicParamMapTr6 = portletReq.getPublicParameterMap();
    if (publicParamMapTr6 != null && publicParamMapTr6.containsKey("tckPRP2")
        && publicParamMapTr6.get("tckPRP2")[0].equals("true")) {
      tr6.setTcSuccess(true);
    } else {
      tr6.appendTcDetail("Render parameter tckPRP2 is not found or is not equal \"true\".");
    }
    tr6.writeTo(writer);

    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_Event", writer.toString(),
        APPLICATION_SCOPE);

  }

}
