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
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupLink;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS8;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS9;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS15;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS16;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS11;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlRequestTests_SPEC2_11_Action_event
 * 
 * @author ahmed
 */
public class AddlRequestTests_SPEC2_11_Action implements Portlet {

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
    StringWriter writer = new StringWriter();

    String action = portletReq.getParameter("inputval");
    if ("V2AddlRequestTests_SPEC2_11_Action_parameters2".equals(action)) {
      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters2 */
      /* Details: "The parameters the request object returns must be */
      /* \"x-www-form-urlencoded\" decoded" */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS2);
      if (portletReq.getParameter("tr1") != null
          && portletReq.getParameter("tr1").equals("true&<>\"'")) {
        tr1.setTcSuccess(true);
      }
      tr1.writeTo(writer);
    } else if ("V2AddlRequestTests_SPEC2_11_Action_parameters6".equals(action)) {
      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters6 */
      /* Details: "The getParameterMap method must return an unmodifiable */
      /* Map object" */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS6);
      if (portletReq.getParameterMap().containsKey("inputval")
          && "V2AddlRequestTests_SPEC2_11_Action_parameters6"
              .equals(portletReq.getParameterMap().get("inputval")[0])) {
        String tr2TestStringArray[] = {"Modified Value"};
        portletReq.getParameterMap().put("inputval", tr2TestStringArray);
        if ("V2AddlRequestTests_SPEC2_11_Action_parameters6"
            .equals(portletReq.getParameterMap().get("inputval")[0])) {
          tr2.setTcSuccess(true);
        }
      }
      tr2.writeTo(writer);
    } else if ("V2AddlRequestTests_SPEC2_11_Action_parameters8".equals(action)) {
      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters8 */
      /* Details: "If the portlet is performing an HTML Form submission via */
      /* HTTP method POST the post form data will be populated to the */
      /* portlet request parameter set if the content type is */
      /* application/x-www-form-urlencoded" */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS8);
      if (portletReq.getProperty("Content-Type").equals("application/x-www-form-urlencoded")
          && portletReq.getParameter("tr3") != null
          && portletReq.getParameter("tr3").equals("true")) {
        tr3.setTcSuccess(true);
      }
      tr3.writeTo(writer);
    } else if ("V2AddlRequestTests_SPEC2_11_Action_parameters9".equals(action)) {
      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters9 */
      /* Details: "If the portlet is performing an HTML Form submission via */
      /* the HTTP method GET the form data set is appended to the portlet */
      /* URL used for the form submission and are therefore accessible as */
      /* request parameters for the portlet" */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS9);
      if (portletReq.getParameter("tr4") != null && portletReq.getParameter("tr4").equals("true")) {
        tr4.setTcSuccess(true);
      }
      tr4.writeTo(writer);
    } else if ("V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters15".equals(action)) {
      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters15 */
      /* Details: "A map of private parameters can be obtained through the */
      /* getPrivateParameterMap method" */
      TestResult tr5 =
          tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS15);
      Map<String, String[]> privateParamMap = portletReq.getPrivateParameterMap();
      if (privateParamMap != null && privateParamMap.containsKey("tr5")
          && privateParamMap.get("tr5")[0].equals("true")) {
        tr5.setTcSuccess(true);
      }
      tr5.writeTo(writer);
    } else if ("V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters16".equals(action)) {
      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters16 */
      /* Details: "A map of public parameters can be obtained through the */
      /* getPublicParameterMap method" */
      TestResult tr6 =
          tcd.getTestResultFailed("V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters16");
      if (portletReq.getPublicParameterMap() != null
          && portletReq.getPublicParameterMap().containsKey("tckPRP1")) {
        tr6.setTcSuccess(true);
      } else {
        tr6.appendTcDetail("No public render parameter found.");
      }
      tr6.writeTo(writer);
    } else if ("V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters4".equals(action)) {
      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters4 */
      /* Details: "Public render parameters are available in the */
      /* processAction method" */
      TestResult tr7 =
          tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS4);
      Map<String, String[]> publicParamMapTr7 = portletReq.getPublicParameterMap();
      if (publicParamMapTr7 != null && publicParamMapTr7.containsKey("tckPRP1")
          && publicParamMapTr7.get("tckPRP1")[0].equals("true")) {
        tr7.setTcSuccess(true);
      } else {
        tr7.appendTcDetail("Render parameter tckPRP1 is not found or is not equal to \"true\".");
      }
      tr7.writeTo(writer);
    } else if ("V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters11".equals(action)) {
      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters11 */
      /* Details: "If the portlet sets an action parameter with the same */
      /* name as a public render parameter, this results in a multi-valued */
      /* parameter. The public render parameter values must be the last */
      /* entries in the parameter value array" */
      TestResult tr8 =
          tcd.getTestResultFailed("V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters11");
      String[] mergedParamsTr8 = portletReq.getParameterValues("tckPRP1");
      if (mergedParamsTr8 != null && mergedParamsTr8.length == 2
          && mergedParamsTr8[0].equals("false") && mergedParamsTr8[1].equals("true")) {
        tr8.setTcSuccess(true);
      } else {
        tr8.appendTcDetail(
            "Render parameter tckPRP1 is not found or is not equal {\"false\",\"true\"}.");
      }
      tr8.writeTo(writer);
    } else {
      portletResp.setRenderParameters(portletReq.getParameterMap());
    }

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_Action", writer.toString(),
        APPLICATION_SCOPE);
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    PortletSession ps = portletReq.getPortletSession();
    String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_Action",
        APPLICATION_SCOPE);
    if (msg != null) {
      writer.write("<p>" + msg + "</p><br/>\n");
      ps.removeAttribute(RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_Action",
          APPLICATION_SCOPE);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters2 */
    /* Details: "The parameters the request object returns must be */
    /* \"x-www-form-urlencoded\" decoded" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      aurl.setParameter("tr1", "true&<>\"'");
      TestButton tb = new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS2, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters6 */
    /* Details: "The getParameterMap method must return an unmodifiable */
    /* Map object" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS6, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters8 */
    /* Details: "If the portlet is performing an HTML Form submission via */
    /* HTTP method POST the post form data will be populated to the */
    /* portlet request parameter set if the content type is */
    /* application/x-www-form-urlencoded" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      writer.write(
          "<div class=\"portletTCKTestcase\" name=\"V2AddlRequestTests_SPEC2_11_Action_parameters8\">");
      writer.write("<h4>V2AddlRequestTests_SPEC2_11_Action_parameters8 button (POST):</h4>");
      writer.write(
          "<form class=\"portletTCKButton\" action=\"" + aurl.toString() + "\" method=\"post\">");
      writer.write("<input type=\"hidden\" name=\"tr3\" value=\"true\"/>");
      writer
          .write("<input type=\"submit\" value=\"V2AddlRequestTests_SPEC2_11_Action_parameters8\"");
      writer.write(
          "name=\"inputval\" id=\"V2AddlRequestTests_SPEC2_11_Action_parameters8-clickme\"></form></div>");
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters9 */
    /* Details: "If the portlet is performing an HTML Form submission via */
    /* the HTTP method GET the form data set is appended to the portlet */
    /* URL used for the form submission and are therefore accessible as */
    /* request parameters for the portlet" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      writer.write(
          "<div class=\"portletTCKTestcase\" name=\"V2AddlRequestTests_SPEC2_11_Action_parameters9\">");
      writer.write("<h4>V2AddlRequestTests_SPEC2_11_Action_parameters9 button (GET):</h4>");
      writer.write(
          "<form class=\"portletTCKButton\" action=\"" + aurl.toString() + "\" method=\"get\">");
      writer.write("<input type=\"hidden\" name=\"tr4\" value=\"true\"/>");
      writer
          .write("<input type=\"submit\" value=\"V2AddlRequestTests_SPEC2_11_Action_parameters9\"");
      writer.write(
          "name=\"inputval\" id=\"V2AddlRequestTests_SPEC2_11_Action_parameters9-clickme\"></form></div>");
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters15 */
    /* Details: "A map of private parameters can be obtained through the */
    /* getPrivateParameterMap method" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      aurl.setParameter("tr5", "true");
      TestButton tb =
          new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS15, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters16 */
    /* Details: "A map of public parameters can be obtained through the */
    /* getPublicParameterMap method" */
    {
      if (portletReq.getParameter("tckPRP1") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tckPRP1", "true");
        TestSetupLink tl =
            new TestSetupLink(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS16, purl);
        tl.writeTo(writer);
      } else {
        PortletURL aurl = portletResp.createActionURL();
        aurl.setParameters(portletReq.getPrivateParameterMap());
        TestButton tb =
            new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS16, aurl);
        tb.writeTo(writer);
      }
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters4 */
    /* Details: "Public render parameters are available in the */
    /* processAction method" */
    {
      if (portletReq.getParameter("tckPRP1") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tckPRP1", "true");
        TestSetupLink tl =
            new TestSetupLink(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS4, purl);
        tl.writeTo(writer);
      } else {
        PortletURL aurl = portletResp.createActionURL();
        aurl.setParameters(portletReq.getPrivateParameterMap());
        TestButton tb =
            new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS4, aurl);
        tb.writeTo(writer);
      }
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters11 */
    /* Details: "If the portlet sets an action parameter with the same */
    /* name as a public render parameter, this results in a multi-valued */
    /* parameter. The public render parameter values must be the last */
    /* entries in the parameter value array" */
    {
      if (portletReq.getParameter("tckPRP1") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tckPRP1", "true");
        TestSetupLink tl =
            new TestSetupLink(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS11, purl);
        tl.writeTo(writer);
      } else {
        PortletURL aurl = portletResp.createActionURL();
        aurl.setParameters(portletReq.getPrivateParameterMap());
        aurl.setParameter("tckPRP1", "false");
        TestButton tb =
            new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS11, aurl);
        tb.writeTo(writer);
      }
    }

  }

}
