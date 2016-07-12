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
import javax.portlet.CacheControl;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETEXPIRATIONTIME3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_ISPUBLICSCOPE5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_USECACHEDCONTENT3;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * EnvironmentTests_CacheControl_ApiRender_event
 *
 * @author ahmed
 */
public class EnvironmentTests_CacheControl_ApiResource2 implements Portlet {

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

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    // Create result objects for the tests

    CacheControl chc = portletResp.getCacheControl();

    /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_getExpirationTime3 */
    /* Details: "Method getExpirationTime(): Returns 0 if the expiration */
    /* time has not been set and no default is set in the deployment */
    /* descriptor" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETEXPIRATIONTIME3);
    int getExpTime = chc.getExpirationTime();
    if (getExpTime == 0) {
      tr2.setTcSuccess(true);
    } else {
      tr2.appendTcDetail("The getExpirationTime did not match the Specified Time :" + getExpTime);
    }
    tr2.writeTo(writer);

    /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_isPublicScope5 */
    /* Details: "Method isPublicScope(): Returns false if the caching */
    /* scope has not been set with the setPublicScope method and has not */
    /* been set in the deployment descriptor" */
    TestResult tr9 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_ISPUBLICSCOPE5);
    if (!chc.isPublicScope()) {
      tr9.setTcSuccess(true);
    } else {
      tr9.appendTcDetail("Failed because isPublicScope() returned true");
    }
    tr9.writeTo(writer);

    /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_useCachedContent3 */
    /* Details: "Method useCachedContent(): Returns false if the use */
    /* cached content indicator has not been set" */
    TestResult tr19 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_USECACHEDCONTENT3);
    if (!chc.useCachedContent()) {
      tr19.setTcSuccess(true);
    }
    tr19.writeTo(writer);

  }

}
