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
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD4;
import static javax.portlet.tck.constants.Constants.BUTTON_PARAM_NAME;
import static javax.portlet.tck.constants.Constants.JSP_PREFIX;
import static javax.portlet.tck.constants.Constants.JSP_SUFFIX;
import static javax.portlet.tck.constants.Constants.QUERY_STRING;
import static javax.portlet.tck.constants.Constants.SERVLET_PREFIX;
import static javax.portlet.tck.constants.Constants.SERVLET_SUFFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * EnvironmentTests_PortletRequestDispatcher_ApiRender_event
 * 
 * @author ahmed
 */
public class EnvironmentTests_PortletRequestDispatcher_ApiRender2 implements Portlet {

  private PortletConfig portletConfig = null;
  private static final String HTML_PREFIX = "/WEB-INF/html/";
  private static final String HTML_SUFFIX = ".html";

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
  public void render(RenderRequest renderReq, RenderResponse renderResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    renderReq.setAttribute(THREADID_ATTR, tid);
    
    PrintWriter writer = renderResp.getWriter();

    // Create result objects for the tests

    PortletRequest portletReq = renderReq;
    PortletResponse portletResp = renderResp;
    
    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
    String tc = renderReq.getParameter(BUTTON_PARAM_NAME);
    
    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward1 */
    /* Details: "Method forward(PortletRequest, PortletResponse): Can */
    /* forward to a JSP page to create the response" */
    if (tc != null && tc.equals(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD1)) {
    String target_tr8 = JSP_PREFIX + "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward1" + JSP_SUFFIX
        + "?" + QUERY_STRING;
    PortletRequestDispatcher rd_tr8 =
        portletConfig.getPortletContext().getRequestDispatcher(target_tr8);
    rd_tr8.forward(portletReq, portletResp);
    } else if (tc==null) {
      PortletURL rurl = renderResp.createRenderURL();
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD1, rurl);
      tb.writeTo(writer);
    }
    
    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward2 */
    /* Details: "Method forward(PortletRequest, PortletResponse): Can */
    /* forward to a HTML Page to create the response" */
    if (tc != null && tc.equals(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD2)) {
      String target_tr9 =
          HTML_PREFIX + "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward2"
              + HTML_SUFFIX + "?" + QUERY_STRING;
      PortletRequestDispatcher rd_tr9 =
          portletConfig.getPortletContext().getRequestDispatcher(target_tr9);
      rd_tr9.forward(portletReq, portletResp);
    } else if (tc==null) {
      PortletURL rurl = renderResp.createRenderURL();
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD2, rurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward3 */
    /* Details: "Method forward(PortletRequest, PortletResponse): Throws */
    /* IllegalStateException if the response was already committed" */
    if (tc != null && tc.equals(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD3)) {
      TestResult tr10 =
          tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD3);
      String target_tr10 = SERVLET_PREFIX
          + "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_PortletRequest_Forward"
          + SERVLET_SUFFIX;
      PortletRequestDispatcher rd_tr10 =
          portletConfig.getPortletContext().getRequestDispatcher(target_tr10);
      try {
        rd_tr10.forward(portletReq, portletResp);
      } catch (Exception e) {
        tr10.setTcSuccess(true);
        tr10.appendTcDetail(e.toString());
      }
      tr10.writeTo(writer);
    } else if (tc==null) {
      PortletURL rurl = renderResp.createRenderURL();
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD3, rurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward4 */
    /* Details: "Method forward(PortletRequest, PortletResponse): Throws */
    /* PortletException if the forwarded servlet throws any excpetion */
    /* other than IOException or a runtime exception " */
    if (tc != null && tc.equals(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD4)) {
      TestResult tr11 =
          tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD4);
      String target_tr11 = SERVLET_PREFIX
          + "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_PortletRequest_Forward"
          + SERVLET_SUFFIX;
      PortletRequestDispatcher rd_tr11 =
          portletConfig.getPortletContext().getRequestDispatcher(target_tr11);
      try {
        rd_tr11.forward(portletReq, portletResp);
      } catch (Exception e) {
        tr11.setTcSuccess(true);
        tr11.appendTcDetail(e.toString());
      }
      tr11.writeTo(writer);
    } else if (tc==null) {
      PortletURL rurl = renderResp.createRenderURL();
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD4, rurl);
      tb.writeTo(writer);
    }
  }

}
