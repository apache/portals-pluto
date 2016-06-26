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
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETER1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETERNAMES1;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * EnvironmentTests_PortletContext_ApiRender_event
 *
 * @author ahmed
 */
public class EnvironmentTests_PortletContext_ApiRender2 implements Portlet {

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

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getInitParameter1 */
    /* Details: "Method getInitParameter(String): Returns a */
    /* java.lang.String PortletContext initialization parameter value for */
    /* the specified name" */
    TestResult tr32 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETER1);
    String initParam1 = portletConfig.getInitParameter("initParam1");
    if (initParam1!=null && initParam1.equals("true")) {
      tr32.setTcSuccess(true);
    } else {
      tr32.appendTcDetail("Failed because initialization parameter initParam1 is not found.");
    }
    tr32.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getInitParameterNames1 */
    /* Details: "Method getInitParameterNames(): Returns an */
    /* java.util.Enumeration&lt;java.lang.String&gt; containing the */
    /* InitParameter names in the PortletContext" */
    TestResult tr39 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETERNAMES1);
    Enumeration<String> getInitNames = portletConfig.getInitParameterNames();
    List<String> li39 = Collections.list(getInitNames);
    if (!li39.isEmpty()) {
      tr39.setTcSuccess(true);
    }
    tr39.writeTo(writer);
  }

}
