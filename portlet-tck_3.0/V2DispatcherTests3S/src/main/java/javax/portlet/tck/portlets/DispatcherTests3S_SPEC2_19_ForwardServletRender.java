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

import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS3S_SPEC2_19_FORWARDSERVLETRENDER_DISPATCH4;
import static javax.portlet.tck.constants.Constants.QUERY_STRING;
import static javax.portlet.tck.constants.Constants.SERVLET_PREFIX;
import static javax.portlet.tck.constants.Constants.SERVLET_SUFFIX;
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
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.tck.beans.CompareUtils;
import javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined in the
 * /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate the test case names
 * defined in the additionalTCs.xml file into the complete list of test case names for execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will initiate the
 * events, but not process them. The processing is done in the companion portlet
 * DispatcherTests3S_SPEC2_19_ForwardServletRender_event
 * 
 */
public class DispatcherTests3S_SPEC2_19_ForwardServletRender implements Portlet, ResourceServingPortlet {

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

      new StringWriter();

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
      PortletSession portletSession = portletReq.getPortletSession();
      TestResult tr0 = (TestResult) portletSession.getAttribute(V2DISPATCHERTESTS3S_SPEC2_19_FORWARDSERVLETRENDER_DISPATCH4);
      if (tr0 == null) {

         Map<String, String[]> oldmap = new HashMap<String, String[]>();
         for (String name : portletReq.getParameterMap().keySet()) {
            String[] vals = portletReq.getParameterValues(name);
            vals = (vals == null) ? null : vals.clone();
            oldmap.put(name, vals);
         }

         // Now do the actual dispatch
         String target = SERVLET_PREFIX + "DispatcherTests3S_SPEC2_19_ForwardServletRender_servlet" + SERVLET_SUFFIX + "?" + QUERY_STRING;
         PortletRequestDispatcher rd = portletConfig.getPortletContext().getRequestDispatcher(target);
         rd.forward(portletReq, portletResp);

         Map<String, String[]> newmap = new HashMap<String, String[]>();
         for (String name : portletReq.getParameterMap().keySet()) {
            String[] vals = portletReq.getParameterValues(name);
            vals = (vals == null) ? null : vals.clone();
            newmap.put(name, vals);
         }

         JSR286DispatcherTestCaseDetails tcd = new JSR286DispatcherTestCaseDetails();

         /* TestCase: DispatcherTests3S_SPEC2_19_ForwardServletRender_dispatch4 */
         /* Details: "The parameters associated with a request dispatcher are */
         /* scoped only for the duration of the include or forward call" */
         tr0 = tcd.getTestResultFailed(V2DISPATCHERTESTS3S_SPEC2_19_FORWARDSERVLETRENDER_DISPATCH4);
         CompareUtils.mapsEqual("Before dispatch", oldmap, "After dispatch", newmap, tr0);
         portletSession.setAttribute(V2DISPATCHERTESTS3S_SPEC2_19_FORWARDSERVLETRENDER_DISPATCH4, tr0);
      } else {
         tr0.writeTo(writer);
         portletSession.removeAttribute(V2DISPATCHERTESTS3S_SPEC2_19_FORWARDSERVLETRENDER_DISPATCH4);
      }
   }

}
