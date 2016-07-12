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
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.constants.Constants.JSP_PREFIX;
import static javax.portlet.tck.constants.Constants.JSP_SUFFIX;
import static javax.portlet.tck.constants.Constants.QUERY_STRING;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
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
public class EnvironmentTests_PortletRequestDispatcher_ApiRender implements Portlet {

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

    PortletSession ps = renderReq.getPortletSession();
    String msg = (String) ps.getAttribute(
        RESULT_ATTR_PREFIX + "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward1",
        APPLICATION_SCOPE);
    if (msg != null) {
      writer.write("<p>" + msg + "</p><br/>\n");
      ps.removeAttribute(
          RESULT_ATTR_PREFIX + "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward1",
          APPLICATION_SCOPE);
    }

    // Create result objects for the tests

    PortletRequest portletReq = renderReq;
    PortletResponse portletResp = renderResp;

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA1 */
    /* Details: "Method include(PortletRequest, PortletResponse): */
    /* Includes the content of a JSP page in the response" */
    String target_tr0 =
        JSP_PREFIX + "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA1" + JSP_SUFFIX
            + "?" + QUERY_STRING;
    PortletRequestDispatcher rd_tr0 =
        portletConfig.getPortletContext().getRequestDispatcher(target_tr0);
    rd_tr0.include(portletReq, portletResp);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA2 */
    /* Details: "Method include(PortletRequest, PortletResponse): */
    /* Includes the content of a HTML Page in the response" */
    String target_tr1 = HTML_PREFIX
        + "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA2" + HTML_SUFFIX;
    PortletRequestDispatcher rd_tr1 =
        portletConfig.getPortletContext().getRequestDispatcher(target_tr1);
    rd_tr1.include(portletReq, portletResp);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA3 */
    /* Details: "Method include(PortletRequest, PortletResponse): The */
    /* included servlet cannot change the status code. The attempt is */
    /* ignored" */
    String target_tr2 = SERVLET_PREFIX
        + "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_PortletRequest_Include"
        + SERVLET_SUFFIX;
    PortletRequestDispatcher rd_tr2 =
        portletConfig.getPortletContext().getRequestDispatcher(target_tr2);
    rd_tr2.include(portletReq, portletResp);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB1 */
    /* Details: "Method include(RenderRequest, RenderResponse): Includes */
    /* the content of a JSP page in the response" */
    String target_tr3 =
        JSP_PREFIX + "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB1" + JSP_SUFFIX
            + "?" + QUERY_STRING;
    PortletRequestDispatcher rd_tr3 =
        portletConfig.getPortletContext().getRequestDispatcher(target_tr3);
    rd_tr3.include(portletReq, portletResp);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB2 */
    /* Details: "Method include(RenderRequest, RenderResponse): Includes */
    /* the content of a HTML Page in the response" */
    String target_tr4 = HTML_PREFIX
        + "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB2" + HTML_SUFFIX;
    PortletRequestDispatcher rd_tr4 =
        portletConfig.getPortletContext().getRequestDispatcher(target_tr4);
    rd_tr4.include(portletReq, portletResp);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB3 */
    /* Details: "Method include(RenderRequest, RenderResponse): The */
    /* included servlet cannot change the status code. The attempt is */
    /* ignored" */
    String target_tr5 = SERVLET_PREFIX
        + "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_RenderRequest_Include"
        + SERVLET_SUFFIX;
    PortletRequestDispatcher rd_tr5 =
        portletConfig.getPortletContext().getRequestDispatcher(target_tr5);
    rd_tr5.include(portletReq, portletResp);



  }

}
