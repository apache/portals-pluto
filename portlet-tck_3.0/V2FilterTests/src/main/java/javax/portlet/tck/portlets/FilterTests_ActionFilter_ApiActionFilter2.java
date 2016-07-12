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
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERBLOCK;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * FilterTests_ActionFilter_ApiActionFilter_event
 * 
 * @author ahmed
 */
public class FilterTests_ActionFilter_ApiActionFilter2 implements Portlet {

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {
    portletResp.setRenderParameter("tr5", "false");
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterBlock */
    /* Details: "If the doFilter(ActionRequest, ActionResponse, */
    /* FilterChain): method does not invoke the next filter, */
    /* processAction is not called" */
    if (portletReq.getParameter("tr5_success") != null
        && portletReq.getParameter("tr5_success").equals("true")) {
      TestResult tr5 =
          tcd.getTestResultFailed(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERBLOCK);
      if (portletReq.getParameter("tr5") == null) {
        tr5.setTcSuccess(true);
      } else {
        tr5.appendTcDetail(
            "Failed because processAction was executed which set the tr5 parameter value to "
                + portletReq.getParameter("tr5"));
      }
      tr5.writeTo(writer);
    } else {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERBLOCK, aurl);
      tb.writeTo(writer);
    }

  }

}
