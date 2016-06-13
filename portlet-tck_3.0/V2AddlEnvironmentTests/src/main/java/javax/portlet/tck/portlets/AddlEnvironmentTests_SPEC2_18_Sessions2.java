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

import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.portlet.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlEnvironmentTests_SPEC2_18_Sessions_event
 * @author ahmed
 */
public class AddlEnvironmentTests_SPEC2_18_Sessions2 implements Portlet {
  private static final String LOG_CLASS = AddlEnvironmentTests_SPEC2_18_Sessions2.class.getName();
  private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

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
    LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

    portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

  }


  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {
    LOGGER.entering(LOG_CLASS, "main portlet render entry");

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_scope2 */
    /* Details: "The portlet container must not share the PortletSession */
    /* object or the attributes stored in it among different portlet */
    /* applications or among different user sessions" */
    TestResult tr1 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE2);
    String tr1_success = (String) portletReq.getPortletSession()
        .getAttribute(Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr1",
            PORTLET_SCOPE);
    if (tr1_success == null) {
      tr1.setTcSuccess(true);
    } else {
      tr1.appendTcDetail("Failed becuase AddlEnvironmentTests_SPEC2_18_Sessions_tr1 is found "
          + "even though it was saved by another portlet in PORTLET_SCOPE");
    }
    tr1.writeTo(writer);
    
    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_scope3 */
    /* Details: "Any object stored in the session using the */
    /* APPLICATION_SCOPE is available to any portlet that belongs to the */
    /* same portlet application and that handles a request in the same */
    /* session" */
    TestResult tr2 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE3);
    String tr2_success = (String) portletReq.getPortletSession()
        .getAttribute(Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr2",
            APPLICATION_SCOPE);
    if (tr2_success != null && tr2_success.equals("true")) {
      tr2.setTcSuccess(true);
    } else {
      tr2.appendTcDetail("Failed becuase AddlEnvironmentTests_SPEC2_18_Sessions_tr2 is not found "
          + "even though it was saved by another portlet in APPLICATION_SCOPE");
    }
    tr2.writeTo(writer);
    
    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_scope4 */
    /* Details: "Any Object stored in the session using the PORTLET_SCOPE */
    /* must be available to the portlet during requests for the same */
    /* portlet window that stored the object" */
    TestResult tr3 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE4);
    String tr3_success = (String) portletReq.getPortletSession()
        .getAttribute(Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr3",
            PORTLET_SCOPE);
    if (tr3_success == null) {
      tr3.setTcSuccess(true);
    } else {
      tr3.appendTcDetail("Failed becuase AddlEnvironmentTests_SPEC2_18_Sessions_tr3 is found "
          + "even though it was saved by another portlet in PORTLET_SCOPE");
    }
    tr3.writeTo(writer);
    
    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession5 */
    /* Details: "If the PortletSession object is invalidated by a */
    /* portlet, the portlet container must invalidate the associated */
    /* HttpSession object" */

    PortletRequestDispatcher rd = portletConfig.getPortletContext()
        .getNamedDispatcher("AddlEnvironmentTests_SPEC2_18_Sessions_invalidate2");
    rd.include(portletReq, portletResp);
  }

}
