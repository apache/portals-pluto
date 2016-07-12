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
import javax.xml.namespace.QName;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_ACTION5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_ACTION6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_ACTION7;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;
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
 * AddlPortletTests_SPEC2_5_ActionHandling_event
 * 
 * @author ahmed
 */
public class AddlPortletTests_SPEC2_5_ActionHandling implements Portlet {

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {
    portletResp.sendRedirect(portletReq.getProperty("Referer"));

    StringWriter writer = new StringWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2AddlPortletTests_SPEC2_5_ActionHandling_action5 */
    /* Details: "If the portlet issues a redirect during action */
    /* processing, the portlet container allows the processAction method */
    /* to complete" */
    TestResult tr0 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_ACTION5);
    tr0.setTcSuccess(true);
    tr0.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_5_ActionHandling_action6 */
    /* Details: "If the portlet issues a redirect during action */
    /* processing, the portlet container must send the redirect back to */
    /* the user agent and finalize the request processing." */
    TestResult tr1 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_ACTION6);
    tr1.setTcSuccess(true);
    tr1.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_5_ActionHandling_action7 */
    /* Details: "If the portlet issues a redirect during action */
    /* processing, events that were set are not processed" */
    QName eventQName = new QName(TCKNAMESPACE, "AddlPortletTests_SPEC2_5_ActionHandling");
    portletResp.setEvent(eventQName, "Hi!");

    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_5_ActionHandling_event_tr2", "true",
        APPLICATION_SCOPE);

    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_5_ActionHandling", writer.toString(),
        APPLICATION_SCOPE);
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    PortletSession ps = portletReq.getPortletSession();
    String msg =
        (String) ps.getAttribute(RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_5_ActionHandling",
            APPLICATION_SCOPE);
    if (msg != null) {
      writer.write("<p>" + msg + "</p><br/>\n");
      ps.removeAttribute(RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_5_ActionHandling",
          APPLICATION_SCOPE);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_5_ActionHandling_action5 */
    /* Details: "If the portlet issues a redirect during action */
    /* processing, the portlet container allows the processAction method */
    /* to complete" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_ACTION5, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_5_ActionHandling_action6 */
    /* Details: "If the portlet issues a redirect during action */
    /* processing, the portlet container must send the redirect back to */
    /* the user agent and finalize the request processing." */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_ACTION6, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_5_ActionHandling_action7 */
    /* Details: "If the portlet issues a redirect during action */
    /* processing, events that were set are not processed" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_ACTION7, aurl);
      tb.writeTo(writer);
    }

  }

}
