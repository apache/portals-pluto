/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package javax.portlet.tck.portlets;

import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPACTION_DISPATCH4;
import static javax.portlet.tck.constants.Constants.JSP_PREFIX;
import static javax.portlet.tck.constants.Constants.JSP_SUFFIX;
import static javax.portlet.tck.constants.Constants.QUERY_STRING;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.tck.beans.CompareUtils;
import javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined in the
 * /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate the test case names
 * defined in the additionalTCs.xml file into the complete list of test case names for execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will initiate the
 * events, but not process them. The processing is done in the companion portlet
 * DispatcherTests3S_SPEC2_19_IncludeJSPAction_event
 * 
 */
public class DispatcherTests3S_SPEC2_19_IncludeJSPAction implements Portlet, ResourceServingPortlet {

   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      Map<String, String[]> oldmap = new HashMap<String, String[]>();
      for (String name : portletReq.getParameterMap().keySet()) {
         String[] vals = portletReq.getParameterValues(name);
         vals = (vals == null) ? null : vals.clone();
         oldmap.put(name, vals);
      }

      // Now do the actual dispatch
      String target = JSP_PREFIX + "DispatcherTests3S_SPEC2_19_IncludeJSPAction" + JSP_SUFFIX + "?" + QUERY_STRING;
      PortletRequestDispatcher rd = portletConfig.getPortletContext().getRequestDispatcher(target);
      rd.include(portletReq, portletResp);

      Map<String, String[]> newmap = new HashMap<String, String[]>();
      for (String name : portletReq.getParameterMap().keySet()) {
         String[] vals = portletReq.getParameterValues(name);
         vals = (vals == null) ? null : vals.clone();
         newmap.put(name, vals);
      }

      JSR286DispatcherTestCaseDetails tcd = new JSR286DispatcherTestCaseDetails();

      /* TestCase: DispatcherTests3S_SPEC2_19_IncludeJSPAction_dispatch4 */
      /* Details: "The parameters associated with a request dispatcher are */
      /* scoped only for the duration of the include or forward call" */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPACTION_DISPATCH4);
      CompareUtils.mapsEqual("Before dispatch", oldmap, "After dispatch", newmap, tr0);
      tr0.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
            Constants.RESULT_ATTR_PREFIX + V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPACTION_DISPATCH4, writer.toString(),
            APPLICATION_SCOPE);

   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp) throws PortletException,
         IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      portletResp.getWriter();

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPACTION_DISPATCH4,
            APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPACTION_DISPATCH4, APPLICATION_SCOPE);
      }

      /* TestCase: V2DispatcherTests3S_SPEC2_19_IncludeJSPAction_dispatch4 */
      /* Details: "The parameters associated with a request dispatcher are */
      /* scoped only for the duration of the include or forward call" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPACTION_DISPATCH4, aurl);
         tb.writeTo(writer);
      }

   }

}
