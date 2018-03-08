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
import java.io.StringWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;


/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 * 
 * @author ahmed
 */
public class AddlFilterTests_SPEC2_20_FilterMultiple implements ActionFilter {

  FilterConfig config;

  public void init(FilterConfig config) throws PortletException {
    this.config = config;
  }

  public void doFilter(ActionRequest portletReq, ActionResponse portletResp, FilterChain chain)
      throws IOException, PortletException {

    String portletNameAction =
        (String) config.getPortletContext().getAttribute("PortletNameAction");
    String filterName = config.getFilterName();

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter10 */
    /* Details: "For multiple filter declarations for a single filter */
    /* class, the filter instance must receive all initialization */
    /* parameters defined in the filter declaration" */
    if (portletNameAction != null && portletNameAction.equals("AddlFilterTests_SPEC2_20_Action")
        && filterName.equals("AddlFilterTests_SPEC2_20_Filter1a")) {
      List<String> initParams = Collections.list(config.getInitParameterNames());
      if (initParams.contains("tr4") && initParams.contains("tr5")) {
        AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr5b_success = true;
        AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr6b_success = true;
      } else {
        AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr5b_success = false;
        AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr6b_success = false;
      }
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter15 */
    /* Details: "The order the container uses in building the chain of */
    /* filters to be applied for a particular request is the order in */
    /* which the &lt;portlet-name&gt; matching filter mappings appear in */
    /* the deployment descriptor" */
    if (portletNameAction != null && portletNameAction.equals("AddlFilterTests_SPEC2_20_Action")
        && filterName.equals("AddlFilterTests_SPEC2_20_Filter1a")
        && AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr10a_success) {
      AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr10b_success = true;
    }

    chain.doFilter(portletReq, portletResp);
  }

  public void destroy() {
    // free resources
  }
}
