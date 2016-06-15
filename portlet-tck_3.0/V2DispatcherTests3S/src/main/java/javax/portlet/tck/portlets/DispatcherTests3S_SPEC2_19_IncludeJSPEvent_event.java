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
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPEVENT_DISPATCH4;
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
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.tck.beans.CompareUtils;
import javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, but does not publish them.
 * Events are published in the main portlet for the test cases.
 */
public class DispatcherTests3S_SPEC2_19_IncludeJSPEvent_event implements Portlet, EventPortlet, ResourceServingPortlet {

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
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp) throws PortletException,
         IOException {
   }

   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp) throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq);

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
      String target = JSP_PREFIX + "DispatcherTests3S_SPEC2_19_IncludeJSPEvent" + JSP_SUFFIX + "?" + QUERY_STRING;
      PortletRequestDispatcher rd = portletConfig.getPortletContext().getRequestDispatcher(target);
      rd.include(portletReq, portletResp);

      Map<String, String[]> newmap = new HashMap<String, String[]>();
      for (String name : portletReq.getParameterMap().keySet()) {
         String[] vals = portletReq.getParameterValues(name);
         vals = (vals == null) ? null : vals.clone();
         newmap.put(name, vals);
      }

      JSR286DispatcherTestCaseDetails tcd = new JSR286DispatcherTestCaseDetails();

      /* TestCase: DispatcherTests3S_SPEC2_19_IncludeJSPEvent_dispatch4 */
      /* Details: "The parameters associated with a request dispatcher are */
      /* scoped only for the duration of the include or forward call" */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPEVENT_DISPATCH4);
      CompareUtils.mapsEqual("Before dispatch", oldmap, "After dispatch", newmap, tr0);
      tr0.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
            Constants.RESULT_ATTR_PREFIX + V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPEVENT_DISPATCH4, writer.toString(),
            APPLICATION_SCOPE);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>DispatcherTests3S_SPEC2_19_IncludeJSPEvent_event</p>\n");

      String msg = (String) portletReq.getPortletSession().getAttribute(
            RESULT_ATTR_PREFIX + V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPEVENT_DISPATCH4, APPLICATION_SCOPE);

      if (msg != null) {
         portletReq.getPortletSession().removeAttribute(
               RESULT_ATTR_PREFIX + V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPEVENT_DISPATCH4, APPLICATION_SCOPE);
      }

      msg = (msg == null) ? "Not ready. click test case link." : msg;
      writer.write("<p>" + msg + "</p>\n");

   }

}
