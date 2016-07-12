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
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.PortletFilter;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSFILTER_ACTIONFILTER_SIGRENDER_HASDOFILTER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSFILTER_ACTIONFILTER_SIGRENDER_HASDOFILTERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSFILTER_ACTIONFILTER_SIGRENDER_IMPLEMENTSPORTLETFILTER;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsFilter_ActionFilter_SIGRender_event
 *
 */
public class SigTestsFilter_ActionFilter_SIGRender implements Portlet {

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

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();

    // Create result objects for the tests

    ClassChecker cc = new ClassChecker(ActionFilter.class);

    /* TestCase: V2SigTestsFilter_ActionFilter_SIGRender_hasDoFilter */
    /* Details: "ActionFilter has a doFilter(ActionRequest, */
    /* ActionResponse, javax.portlet.filter.FilterChain) throws */
    /* java.io.IOException, PortletException method " */
    TestResult tr0 = tcd.getTestResultFailed(V2SIGTESTSFILTER_ACTIONFILTER_SIGRENDER_HASDOFILTER);
    try {
      String name = "doFilter";
      Class<?>[] exceptions = {java.io.IOException.class, PortletException.class};
      Class<?>[] parms =
          {ActionRequest.class, ActionResponse.class, javax.portlet.filter.FilterChain.class};
      tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsFilter_ActionFilter_SIGRender_hasDoFilterReturns */
    /* Details: "ActionFilter method doFilter(ActionRequest, */
    /* ActionResponse, javax.portlet.filter.FilterChain) returns void " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2SIGTESTSFILTER_ACTIONFILTER_SIGRENDER_HASDOFILTERRETURNS);
    try {
      String name = "doFilter";
      Class<?> retType = void.class;
      Class<?>[] parms =
          {ActionRequest.class, ActionResponse.class, javax.portlet.filter.FilterChain.class};
      tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsFilter_ActionFilter_SIGRender_implementsPortletFilter */
    /* Details: "ActionFilter implements PortletFilter " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSFILTER_ACTIONFILTER_SIGRENDER_IMPLEMENTSPORTLETFILTER);
    try {
      tr2.setTcSuccess(cc.implementsInterface(PortletFilter.class));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

  }

}
