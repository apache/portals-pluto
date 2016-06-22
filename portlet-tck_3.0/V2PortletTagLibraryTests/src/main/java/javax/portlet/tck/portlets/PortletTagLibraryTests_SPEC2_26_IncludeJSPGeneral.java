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
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.JSP_PREFIX;
import static javax.portlet.tck.constants.Constants.JSP_SUFFIX;
import static javax.portlet.tck.constants.Constants.QUERY_STRING;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS4;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_event
 * 
 * @author ahmed
 */
public class PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral implements Portlet {

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
    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    /*
     * TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_defineObjects4 Details: "The
     * defineObjects tag must not define any attribute and it must not contain any body content"
     */
    TestResult tr3 =
        tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS4);
    try {
      String target = JSP_PREFIX + "PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneralTr3"
          + JSP_SUFFIX + "?" + QUERY_STRING;
      PortletRequestDispatcher rd = portletConfig.getPortletContext().getRequestDispatcher(target);
      rd.include(portletReq, portletResp);
    } catch (PortletException e) {
      tr3.setTcSuccess(true);
      tr3.appendTcDetail(e.getMessage());
    }
    tr3.writeTo(writer);

    /*
     * TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_defineObjects3 Details: "The
     * version 1.0 tag library may be referenced using &lt;%@ taglib uri=\
     * "http://java.sun.com/portlet\" prefix=\"portlet\" %&gt;"
     */
    TestResult tr0 =
        tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS3);
    try {
      String target = JSP_PREFIX + "PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneralTr0"
          + JSP_SUFFIX + "?" + QUERY_STRING;
      PortletRequestDispatcher rd = portletConfig.getPortletContext().getRequestDispatcher(target);
      rd.include(portletReq, portletResp);
    } catch (PortletException e) {
      tr0.setTcSuccess(true);
      tr0.appendTcDetail(e.getMessage());
    }
    tr0.writeTo(writer);


    /*
     * TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_defineObjects2 Details: "In
     * order to obtain version 2 support, the tag library must be specified as &lt;%@ taglib uri=\
     * "http://java.sun.com/portlet_2_0\" prefix=\"portlet\" %&gt;"
     */
    TestResult tr2 =
        tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS2);
    try {
      // Now do the actual dispatch
      String target = JSP_PREFIX + "PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral" + JSP_SUFFIX
          + "?" + QUERY_STRING;
      PortletRequestDispatcher rd = portletConfig.getPortletContext().getRequestDispatcher(target);
      rd.include(portletReq, portletResp);
      tr2.setTcSuccess(true);
    } catch (PortletException e) {
      tr2.appendTcDetail(e.getMessage());
      tr2.setTcSuccess(false);
    }
    tr2.writeTo(writer);

  }

}
