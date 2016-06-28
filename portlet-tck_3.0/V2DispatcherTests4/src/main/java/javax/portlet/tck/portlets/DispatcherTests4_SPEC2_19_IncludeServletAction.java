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

import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETACTION_INVOKE3;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETACTION_INVOKE8;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.constants.Constants.QUERY_STRING;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.SERVLET_PREFIX;
import static javax.portlet.tck.constants.Constants.SERVLET_SUFFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

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
import javax.portlet.filter.ActionRequestWrapper;
import javax.portlet.filter.ActionResponseWrapper;
import javax.portlet.tck.beans.TestButton;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined in the
 * /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate the test case names
 * defined in the additionalTCs.xml file into the complete list of test case names for execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will initiate the
 * events, but not process them. The processing is done in the companion portlet
 * DispatcherTests4_SPEC2_19_IncludeServletAction_event
 * 
 */
public class DispatcherTests4_SPEC2_19_IncludeServletAction implements Portlet, ResourceServingPortlet {

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

      // Prereq for: V2DispatcherTests4_SPEC2_19_IncludeServletAction_invoke3
      portletReq = new ActionRequestWrapper(portletReq);
      portletResp = new ActionResponseWrapper(portletResp);

      {
         // Prereq for: V2DispatcherTests4_SPEC2_19_IncludeServletAction_invoke8
         // include the multiple include portlet
         String target = "/MultipleIncludeServlet?" + QUERY_STRING;
         PortletRequestDispatcher rd = portletConfig.getPortletContext().getRequestDispatcher(target);
         rd.include(portletReq, portletResp);
      }

      // Now do the actual dispatch
      String target = SERVLET_PREFIX + "DispatcherTests4_SPEC2_19_IncludeServletAction_servlet" + SERVLET_SUFFIX + "?"
            + QUERY_STRING;
      PortletRequestDispatcher rd = portletConfig.getPortletContext().getRequestDispatcher(target);
      rd.include(portletReq, portletResp);
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
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "DispatcherTests4_SPEC2_19_IncludeServletAction",
            APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "DispatcherTests4_SPEC2_19_IncludeServletAction", APPLICATION_SCOPE);
      }

      /* TestCase: V2DispatcherTests4_SPEC2_19_IncludeServletAction_invoke3 */
      /* Details: "Parameters to the include method for a target servlet */
      /* can be wrapped request and response classes from the portlet */
      /* lifecyle method initiating the include" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETACTION_INVOKE3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests4_SPEC2_19_IncludeServletAction_invoke8 */
      /* Details: "The portlet can include multiple servlets during the */
      /* same lifecycle method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETACTION_INVOKE8, aurl);
         tb.writeTo(writer);
      }

   }

}
