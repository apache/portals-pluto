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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.portlet.WindowState;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL22;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL23;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL24;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL25;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL26;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL27;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE6;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.JSP_PREFIX;
import static javax.portlet.tck.constants.Constants.JSP_SUFFIX;
import static javax.portlet.tck.constants.Constants.QUERY_STRING;
import static javax.portlet.ResourceURL.PAGE;


/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_event
 * 
 * @author ahmed
 */
public class PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource extends GenericPortlet {

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {

    String action = portletReq.getParameter("action");
    if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL1")) {

      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL1 Details: "The
       * portlet actionURL tag creates a URL that must point to the current portlet and must trigger
       * an action request with the supplied parameters"
       */
      portletResp.setRenderParameter("tr13", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL2")
        && portletReq.getParameter("tr14_value") != null
        && "true".equals(portletReq.getParameter("tr14_value"))) {

      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL2 Details:
       * "Parameters may be added to the URL by including the param tag between the actionURL start
       * and end tags"
       */
      portletResp.setRenderParameter("tr14", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL3")
        && portletReq.getWindowState().equals(WindowState.MINIMIZED)) {

      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL3 Details:
       * "The optional actionURL \"windowState\" attribute can specify the desired window state
       * after the URL is triggered"
       */
      portletResp.setRenderParameter("tr15", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL5")
        && portletReq.getWindowState().equals(WindowState.MINIMIZED)) {

      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL5 Details:
       * "The \"windowState\" attribute is not case sensitive"
       */
      portletResp.setRenderParameter("tr17", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL6")
        && (portletReq.getWindowState().toString())
            .equals(portletReq.getParameter("windowStateTr18"))) {

      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL6 Details:
       * "The \"windowState\" attribute is not specified, the current window state is retained when
       * the URL is triggered"
       */
      portletResp.setRenderParameter("tr18", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL7")
        && (portletReq.getPortletMode()).equals(PortletMode.VIEW)) {

      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL7 Details:
       * "The optional actionURL \"portletMode\" attribute can specify the desired portlet mode
       * after the URL is triggered"
       */
      portletResp.setRenderParameter("tr19", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL9")
        && (portletReq.getPortletMode()).equals(PortletMode.VIEW)) {

      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL9 Details:
       * "The \"portletMode\" attribute is not case sensitive"
       */
      portletResp.setRenderParameter("tr21", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL10")
        && (portletReq.getPortletMode().toString())
            .equals(portletReq.getParameter("portletModeTr22"))) {

      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL10 Details:
       * "The \"portletMode\" attribute is not specified, the current portlet mode is retained when
       * the URL is triggered"
       */
      portletResp.setRenderParameter("tr22", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL11")) {

      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL11 Details:
       * "The optional actionURL \"var\" attribute can specify a scoped variable for exporting the
       * action URL"
       */
      portletResp.setRenderParameter("tr23", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL12")
        && portletReq.getParameter("actionURLTr24") != null
        && "".equals(portletReq.getParameter("actionURLTr24"))) {

      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL12 Details:
       * "If the actionURL \"var\" attribute is specified, the URL is not written to the JspWriter"
       */
      portletResp.setRenderParameter("tr24", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL13")
        && portletReq.getParameter("actionURLTr25") != null
        && !"".equals(portletReq.getParameter("actionURLTr25"))) {

      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL13 Details:
       * "If the actionURL \"var\" attribute is not specified, the URL is written to the JspWriter"
       */
      portletResp.setRenderParameter("tr25", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL14")
        && portletReq.isSecure()) {

      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL14 Details:
       * "If the optional actionURL \"secure\" attribute is set to true, the resulting URL should
       * require a secure connection"
       */
      portletResp.setRenderParameter("tr26", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL15")
        && !portletReq.isSecure()) {

      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL15 Details:
       * "If the optional actionURL \"secure\" attribute is set to false, the resulting URL does not
       * need to require a secure connection"
       */
      portletResp.setRenderParameter("tr27", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL18")
        && portletReq.getParameter("renderParamTr29") != null
        && "true".equals(portletReq.getParameter("renderParamTr29"))) {
      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL18 Details: "If
       * the optional actionURL \"copyCurrentRenderParameters\" attribute is set to true, the
       * current private render parameters are attached to the URL"
       */
      portletResp.setRenderParameter("tr29", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL19")
        && portletReq.getParameter("renderParamTr30") != null
        && "true".equals(portletReq.getParameter("renderParamTr30"))
        && portletReq.getParameter("actionURLTr30") != null
        && "true".equals(portletReq.getParameter("actionURLTr30"))) {
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL19 */
      /* Details: "If the optional actionURL */
      /* \"copyCurrentRenderParameters\" attribute is set to true, */
      /* additional parameters specified with the &lt;portlet:param&gt; */
      /* element are merged with the render parameters" */
      portletResp.setRenderParameter("tr30", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL20")
        && portletReq.getParameterValues("renderParamTr31") != null
        && portletReq.getParameterValues("renderParamTr31").length == 2
        && "false".equals(portletReq.getParameterValues("renderParamTr31")[0])
        && "true".equals(portletReq.getParameterValues("renderParamTr31")[1])) {
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL20 */
      /* Details: "If the optional actionURL */
      /* \"copyCurrentRenderParameters\" attribute is set to true, */
      /* additional parameters specified with the &lt;portlet:param&gt; */
      /* element appear in the values array before the render parameter */
      /* values if there is a name conflict" */
      portletResp.setRenderParameter("tr31", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL21")
        && portletReq.getParameterValues("renderParamTr32") == null) {
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL21 */
      /* Details: "If the optional actionURL */
      /* \"copyCurrentRenderParameters\" attribute is set to false, the */
      /* current render parameters are not attached to the URL" */
      portletResp.setRenderParameter("tr32", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL27")) {
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL27 */
      /* Details: "If the optional actionURL \"name\" attribute is set, the */
      /* provided name string is used by GenericPortlet to dispatch the */
      /* request to the coresponding annotated method" */
      try {
        super.processAction(portletReq, portletResp);
      } catch (Exception e) {
        portletResp.setRenderParameter("tr37_error", e.getMessage());
      }
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL28")
        && portletReq.getParameter("javax.portlet.action") != null
        && "actionNameTr28".equals(portletReq.getParameter("javax.portlet.action"))) {
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL28 */
      /* Details: "Setting the \"name\" attribute will add a parameter to */
      /* the action URL with the name of \"javax.portlet.action\"" */
      portletResp.setRenderParameter("tr38", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL12")
        && portletReq.getParameter("renderURLTr52") != null
        && "".equals(portletReq.getParameter("renderURLTr52"))) {
      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL12 Details:
       * "If the renderURL \"var\" attribute is specified, the URL is not written to the JspWriter"
       */
      portletResp.setRenderParameter("tr52", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL13")
        && portletReq.getParameter("renderURLTr53") != null
        && !"".equals(portletReq.getParameter("renderURLTr53"))) {
      /*
       * TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL13 Details:
       * "If the renderURL \"var\" attribute is not specified, the URL is written to the JspWriter"
       */
      portletResp.setRenderParameter("tr53", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL6")
        && portletReq.getParameter("resourceURLTr70") != null
        && "".equals(portletReq.getParameter("resourceURLTr70"))) {
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL6 */
      /* Details: "If the resourceURL \"var\" attribute is specified, the */
      /* URL is not written to the JspWriter" */
      portletResp.setRenderParameter("tr70", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL7")
        && portletReq.getParameter("resourceURLTr71") != null
        && !"".equals(portletReq.getParameter("resourceURLTr71"))) {
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL7 */
      /* Details: "If the resourceURL \"var\" attribute is not specified, */
      /* the URL is written to the JspWriter" */
      portletResp.setRenderParameter("tr71", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction1")
        && portletReq.getParameter("tr90_value") != null
        && "true".equals(portletReq.getParameter("tr90_value"))) {
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction1 */
      /* Details: "The param tag can be used within the actionURL tag to */
      /* add a parameter" */
      portletResp.setRenderParameter("tr90", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction2")
        && portletReq.getParameter("tr91_value") != null) {
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction2 */
      /* Details: "The param tag required attribute \"name\" defines the */
      /* parameter name" */
      portletResp.setRenderParameter("tr91", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction3")
        && (portletReq.getParameterValues("tr92_value")).length == 2) {
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction3 */
      /* Details: "If more than one tags appear in the actionURL tag, the */
      /* values must be stored as a multivalued array in order of */
      /* appearance within the actionURL tag" */
      portletResp.setRenderParameter("tr92", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction5")
        && portletReq.getParameter("tr94_value") != null
        && "true".equals(portletReq.getParameter("tr94_value"))) {
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction5 */
      /* Details: "The param tag required attribute \"value\" defines the */
      /* parameter value" */
      portletResp.setRenderParameter("tr94", "true");
    } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction6")
        && portletReq.getParameter("tr95_value") == null) {
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction6 */
      /* Details: "If the \"value\" attribute is null or empty, the */
      /* parameter is removed" */
      portletResp.setRenderParameter("tr95", "true");
    } else {
      portletResp.setRenderParameters(portletReq.getParameterMap());
    }
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

  }

  /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL27 */
  /* Details: "If the optional actionURL \"name\" attribute is set, the */
  /* provided name string is used by GenericPortlet to dispatch the */
  /* request to the coresponding annotated method" */
  @ProcessAction(name = "actionNameTr27")
  public void actionUrlViaName(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {
    portletResp.setRenderParameter("tr37", "true");
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);
  }

  @Override
  public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
      throws PortletException, IOException {
    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    if (portletReq.getParameter("action") != null) {
      String action = portletReq.getParameter("action");
      if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL1")) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL1 */
        /* Details: "The portlet resourceURL tag creates a URL that must */
        /* point to the current portlet and must trigger an resource request */
        /* with the supplied parameters" */
        TestResult tr65 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL1);
        tr65.setTcSuccess(true);
        tr65.writeTo(writer);
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL2")) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL2 */
        /* Details: "The resourceURL must preserve the current portlet mode, */
        /* window state and render parameters" */
        TestResult tr66 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL2);
        if (portletReq.getParameter("portletModeTr66") != null
            && portletReq.getParameter("windowStateTr66") != null
            && (portletReq.getPortletMode().toString())
                .equals(portletReq.getParameter("portletModeTr66"))
            && (portletReq.getWindowState().toString())
                .equals(portletReq.getParameter("windowStateTr66"))) {
          tr66.setTcSuccess(true);
        }
        tr66.writeTo(writer);
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL3")) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL3 */
        /* Details: "Resource parameters may be added to the URL by including */
        /* the param tag between the resourceURL start and end tags" */
        // Didn't send any new parameter because action parameter is itself generated by param tag
        TestResult tr67 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL3);
        tr67.setTcSuccess(true);
        tr67.writeTo(writer);
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL4")
          && portletReq.getParameterValues("renderParamTr68") != null
          && portletReq.getParameterValues("renderParamTr68").length == 2
          && "false".equals(portletReq.getParameterValues("renderParamTr68")[0])
          && "true".equals(portletReq.getParameterValues("renderParamTr68")[1])) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL4 */
        /* Details: "The resource parameters specified with the */
        /* &lt;portlet:param&gt; element appear in the values array before */
        /* the render parameter values if there is a name conflict" */
        TestResult tr68 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL4);
        tr68.setTcSuccess(true);
        tr68.writeTo(writer);
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL5")) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL5 */
        /* Details: "The optional resourceURL \"var\" attribute can specify a */
        /* scoped variable for exporting the action URL" */
        TestResult tr69 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL5);
        tr69.setTcSuccess(true);
        tr69.writeTo(writer);
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL22")
          && portletReq.getResourceID() != null
          && "resourceURLTr84".equals(portletReq.getResourceID())) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL22 */
        /*
         * Details: "Setting the \"id\" attribute will add an ID to the resourceURL which can /* be
         * retrieved by \"getResourceID()\" method of ResourceRequest"
         */
        TestResult tr84 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL22);
        tr84.setTcSuccess(true);
        tr84.writeTo(writer);
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL23")
          && (portletReq.getCacheability()).equals(ResourceURL.PORTLET)) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL23 */
        /* Details: "If the optional resourceURL \"cacheability\" attribute */
        /* is set, the cacheability is set accordingly" */
        TestResult tr85 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL23);
        tr85.setTcSuccess(true);
        tr85.writeTo(writer);
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL24")
          && (portletReq.getCacheability()).equals(ResourceURL.PAGE)) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL24 */
        /* Details: "If the optional resourceURL \"cacheability\" attribute */
        /* is not set, the current cacheability setting is retained" */
        TestResult tr86 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL24);
        tr86.setTcSuccess(true);
        tr86.writeTo(writer);
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL25")
          && (portletReq.getCacheability()).equals(ResourceURL.FULL)) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL25 */
        /* Details: "If the cacheability is set to PAGE in a Resource phase */
        /* include with cacheability = FULL, a JspException with the */
        /* IllegalStateException that caused this error is thrown" */
        TestResult tr87 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL25);
        try {
          String target = JSP_PREFIX + "PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_tr87"
              + JSP_SUFFIX + "?" + QUERY_STRING;
          PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(target);
          rd.include(portletReq, portletResp);
        } catch (Exception e) {
          tr87.setTcSuccess(true);
          tr87.appendTcDetail(e.getMessage());
        }
        tr87.writeTo(writer);
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL26")
          && (portletReq.getCacheability()).equals(ResourceURL.FULL)) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL26 */
        /* Details: "If the cacheability is set to PORTLET in a Resource */
        /* phase include with cacheability = FULL, a JspException with the */
        /* IllegalStateException that caused this error is thrown" */
        TestResult tr88 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL26);
        try {
          String target = JSP_PREFIX + "PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_tr88"
              + JSP_SUFFIX + "?" + QUERY_STRING;
          PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(target);
          rd.include(portletReq, portletResp);
        } catch (Exception e) {
          tr88.setTcSuccess(true);
          tr88.appendTcDetail(e.getMessage());
        }
        tr88.writeTo(writer);
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL27")
          && (portletReq.getCacheability()).equals(ResourceURL.PORTLET)) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL27 */
        /* Details: "If the cacheability is set to PORTLET in a Resource */
        /* phase include with cacheability = FULL, a JspException with the */
        /* IllegalStateException that caused this error is thrown" */
        TestResult tr89 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL27);
        try {
          String target = JSP_PREFIX + "PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_tr87"
              + JSP_SUFFIX + "?" + QUERY_STRING;
          PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(target);
          rd.include(portletReq, portletResp);
        } catch (Exception e) {
          tr89.setTcSuccess(true);
          tr89.appendTcDetail(e.getMessage());
        }
        tr89.writeTo(writer);
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource1")
          && portletReq.getParameter("tr102_value") != null
          && "true".equals(portletReq.getParameter("tr102_value"))) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource1 */
        /* Details: "The param tag can be used within the resourceURL tag to */
        /* add a parameter" */
        TestResult tr102 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE1);
        tr102.setTcSuccess(true);
        tr102.writeTo(writer);
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource2")
          && portletReq.getParameter("tr103_value") != null) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource2 */
        /* Details: "The param tag required attribute \"name\" defines the */
        /* parameter name" */
        TestResult tr103 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE2);
        tr103.setTcSuccess(true);
        tr103.writeTo(writer);
        portletReq.setAttribute("tr103", "true");
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource3")
          && (portletReq.getParameterValues("tr104_value")).length == 2) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource3 */
        /* Details: "If more than one tags appear in the resourceURL tag, the */
        /* values must be stored as a multivalued array in order of */
        /* appearance within the resourceURL tag" */
        TestResult tr104 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE3);
        tr104.setTcSuccess(true);
        tr104.writeTo(writer);
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource5")
          && portletReq.getParameter("tr106_value") != null
          && "true".equals(portletReq.getParameter("tr106_value"))) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource5 */
        /* Details: "The param tag required attribute \"value\" defines the */
        /* parameter value" */
        TestResult tr106 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE5);
        tr106.setTcSuccess(true);
        tr106.writeTo(writer);
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource6")
          && portletReq.getParameter("tr107_value") == null) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource6 */
        /* Details: "If the \"value\" attribute is null or empty, no action */
        /* is performed" */
        TestResult tr107 = tcd.getTestResultFailed(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE6);
        tr107.setTcSuccess(true);
        tr107.writeTo(writer);
      } else {
        // Now do the actual dispatch
        String target = JSP_PREFIX + "PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource"
            + JSP_SUFFIX + "?" + QUERY_STRING;
        PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(target);
        rd.include(portletReq, portletResp);
      }
    } else {
      // Now do the actual dispatch
      String target = JSP_PREFIX + "PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource"
          + JSP_SUFFIX + "?" + QUERY_STRING;
      PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(target);
      rd.include(portletReq, portletResp);
    }
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {
    ResourceURL resurl = portletResp.createResourceURL();
    resurl.setCacheability(PAGE);
    if (portletReq.getParameter("action") != null) {
      String action = portletReq.getParameter("action");
      if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL1")) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL1 */
        /* Details: "The portlet renderURL tag creates a URL that must point */
        /* to the current portlet and must trigger an render request with the */
        /* supplied parameters" */
        resurl.setParameter("tr41", "true");
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL2")) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL2 */
        /* Details: "Parameters may be added to the URL by including the */
        /* param tag between the renderURL start and end tags" */
        resurl.setParameter("tr42", "true");
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL3")
          && portletReq.getWindowState().equals(WindowState.MINIMIZED)) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL3 */
        /* Details: "The optional renderURL \"windowState\" attribute can */
        /* specify the desired window state after the URL is triggered" */
        resurl.setParameter("tr43", "true");
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL5")
          && portletReq.getWindowState().equals(WindowState.MINIMIZED)) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL5 */
        /* Details: "The \"windowState\" attribute is not case sensitive" */
        resurl.setParameter("tr45", "true");
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL6")
          && (portletReq.getWindowState().toString())
              .equals(portletReq.getParameter("windowStateTr46"))) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL6 */
        /* Details: "The \"windowState\" attribute is not specified, the */
        /* current window state is retained when the URL is triggered" */
        resurl.setParameter("tr46", "true");
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL7")
          && (portletReq.getPortletMode()).equals(PortletMode.VIEW)) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL7 */
        /* Details: "The optional renderURL \"portletMode\" attribute can */
        /* specify the desired portlet mode after the URL is triggered" */
        resurl.setParameter("tr47", "true");
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL9")
          && (portletReq.getPortletMode()).equals(PortletMode.VIEW)) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL9 */
        /* Details: "The \"portletMode\" attribute is not case sensitive" */
        resurl.setParameter("tr49", "true");
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL10")
          && (portletReq.getPortletMode().toString())
              .equals(portletReq.getParameter("portletModeTr50"))) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL10 */
        /* Details: "The \"portletMode\" attribute is not specified, the */
        /* current portlet mode is retained when the URL is triggered" */
        resurl.setParameter("tr50", "true");
      } else if (action
          .equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL11")) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL11 */
        /* Details: "The optional renderURL \"var\" attribute can specify a */
        /* scoped variable for exporting the action URL" */
        resurl.setParameter("tr51", "true");
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL18")
          && portletReq.getParameter("renderParamTr57") != null
          && "true".equals(portletReq.getParameter("renderParamTr57"))) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL18 */
        /* Details: "If the optional renderURL */
        /* \"copyCurrentRenderParameters\" attribute is set to true, the */
        /* current private render parameters are attached to the URL" */
        resurl.setParameter("tr57", "true");
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL19")
          && portletReq.getParameter("renderParamTr58") != null
          && "true".equals(portletReq.getParameter("renderParamTr58"))
          && portletReq.getParameter("renderURLTr58") != null
          && "true".equals(portletReq.getParameter("renderURLTr58"))) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL19 */
        /* Details: "If the optional renderURL */
        /* \"copyCurrentRenderParameters\" attribute is set to true, */
        /* additional parameters specified with the &lt;portlet:param&gt; */
        /* element are merged with the render parameters" */
        resurl.setParameter("tr58", "true");
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL20")
          && portletReq.getParameterValues("renderParamTr59") != null
          && portletReq.getParameterValues("renderParamTr59").length == 2
          && "false".equals(portletReq.getParameterValues("renderParamTr59")[0])
          && "true".equals(portletReq.getParameterValues("renderParamTr59")[1])) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL20 */
        /* Details: "If the optional renderURL */
        /* \"copyCurrentRenderParameters\" attribute is set to true, */
        /* additional parameters specified with the &lt;portlet:param&gt; */
        /* element appear in the values array before the render parameter */
        /* values if there is a name conflict" */
        resurl.setParameter("tr59", "true");
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL21")
          && portletReq.getParameterValues("renderParamTr60") == null) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL21 */
        /* Details: "If the optional renderURL */
        /* \"copyCurrentRenderParameters\" attribute is set to false, the */
        /* current render parameters are not attached to the URL" */
        resurl.setParameter("tr60", "true");
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender1")
          && portletReq.getParameter("tr96_value") != null
          && "true".equals(portletReq.getParameter("tr96_value"))) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender1 */
        /* Details: "The param tag can be used within the renderURL tag to */
        /* add a parameter" */
        resurl.setParameter("tr96", "true");
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender2")
          && portletReq.getParameter("tr97_value") != null) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender2 */
        /* Details: "The param tag required attribute \"name\" defines the */
        /* parameter name" */
        resurl.setParameter("tr97", "true");
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender3")
          && (portletReq.getParameterValues("tr98_value")).length == 2) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender3 */
        /* Details: "If more than one tags appear in the renderURL tag, the */
        /* values must be stored as a multivalued array in order of */
        /* appearance within the renderURL tag" */
        resurl.setParameter("tr98", "true");
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender5")
          && portletReq.getParameter("tr100_value") != null
          && "true".equals(portletReq.getParameter("tr100_value"))) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender5 */
        /* Details: "The param tag required attribute \"value\" defines the */
        /* parameter value" */
        resurl.setParameter("tr100", "true");
      } else if (action.equals("V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender6")
          && portletReq.getParameter("tr101_value") == null) {
        /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender6 */
        /* Details: "If the \"value\" attribute is null or empty, the */
        /* parameter is removed" */
        resurl.setParameter("tr101", "true");
      }
    }
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    writer.write(
        "<div id=\"PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource\">no resource output.</div>\n");

    writer.write("<script>\n");
    writer.write("(function () {\n");
    writer.write("   var xhr = new XMLHttpRequest();\n");
    writer.write("   xhr.onreadystatechange=function() {\n");
    writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
    writer.write(
        "         document.getElementById(\"PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource\").innerHTML=xhr.responseText;\n");

    /*
     * Eval function Interpret JS code returned by the AJAX call. Following are the script tags with
     * ids, which need to be evaluated (interpreted) by browser. These JS script tags are necessary
     * for testing ResourceURL tags, since resourceURL requires an AJAX function written in JS to
     * get the HTML content. For eg - The first script tag "getResourceCall" (See line 12 of
     * PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource.jsp) is a JS function used by all other
     * script tags below to bring resource content via AJAX request. Since this script tag is
     * already being returned by the current AJAX request, browser won't interpret it as JS unless
     * being told.
     */
    writer.write("         eval(document.getElementById('getResourceCall').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr65').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr66').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr67').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr68').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr69').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr84').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr85').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr86').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr87').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr88').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr89').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr102').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr103').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr104').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr106').innerHTML);");
    writer.write("         eval(document.getElementById('scriptTr107').innerHTML);");

    writer.write("      }\n");
    writer.write("   };\n");
    writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
    writer.write("   xhr.send();\n");
    writer.write("})();\n");
    writer.write("</script>\n");
  }

}
