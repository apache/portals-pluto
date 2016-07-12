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

import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_DISPATCH1;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_DISPATCH2;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_DISPATCH3;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_INVOKE2;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_INVOKE4;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_INVOKE7;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1A;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1B;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1C;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2A;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2B;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2C;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3A;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3B;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3C;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4A;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4B;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4C;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5A;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5B;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5C;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES6;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES7;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES8;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.constants.Constants.ATTR_DISPATCH_ACTION;
import static javax.portlet.tck.constants.Constants.ATTR_DISPATCH_TARGET;
import static javax.portlet.tck.constants.Constants.EXTRA_PATH;
import static javax.portlet.tck.constants.Constants.QUERY_STRING;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.SERVLET_PREFIX;
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
import javax.portlet.tck.beans.TestButton;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined in the
 * /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate the test case names
 * defined in the additionalTCs.xml file into the complete list of test case names for execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will initiate the
 * events, but not process them. The processing is done in the companion portlet
 * DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_event
 * 
 */
public class DispatcherTests6_SPEC2_19_FwdThenForwardServletAction implements Portlet, ResourceServingPortlet {

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

      // Multilevel forward / include
      portletReq.setAttribute(ATTR_DISPATCH_ACTION, "forward");
      String targ = SERVLET_PREFIX + "DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_servlet" + EXTRA_PATH + "?"
            + QUERY_STRING;
      portletReq.setAttribute(ATTR_DISPATCH_TARGET, targ);

      // Now do the actual dispatch
      String target = "/IncluderForwarderServlet" + "?" + QUERY_STRING;
      PortletRequestDispatcher rd = portletConfig.getPortletContext().getRequestDispatcher(target);
      rd.forward(portletReq, portletResp);
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
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX
            + "DispatcherTests6_SPEC2_19_FwdThenForwardServletAction", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "DispatcherTests6_SPEC2_19_FwdThenForwardServletAction",
               APPLICATION_SCOPE);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_dispatch1 */
      /* Details: "In a servlet forwarded to by the target of a forward, if */
      /* the path provided to getRequestDispatcher method contains query */
      /* strings, parameters specified in the query strings must be passed */
      /* to the target servlet during an forward" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_DISPATCH1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_dispatch2 */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* parameters specified in the query strings must be aggregated with */
      /* the portlet render parameters" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_DISPATCH2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_dispatch3 */
      /* Details: "In a servlet forwarded to by the target of a forward, if */
      /* query string parameters have the same names as render parameter */
      /* names, the query string parameters appear in the parameter values */
      /* array before the render parameter values" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_DISPATCH3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_invoke2 */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* parameters to the forward method for a target servlet can be the */
      /* request and response classes from the portlet lifecyle method */
      /* initiating the include" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_INVOKE2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_invoke4 */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the portlet container must invoke the target servlet in the same */
      /* thread as the PortletRequestDispatcher include invocation" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_INVOKE4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_invoke7 */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the path elements of the request object exposed to the target */
      /* servlet must reflect the path used to obtain the */
      /* RequestDispatcher" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_INVOKE7, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes1 */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the portlet request attribute javax.servlet.forward.request_uri */
      /* will be set, and equals the value from */
      /* HTTPServletRequest.getRequestURI for the first servlet in the */
      /* forward chain" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes1a */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the servlet request attribute javax.servlet.forward.request_uri */
      /* will be set, and equals the value from */
      /* HTTPServletRequest.getRequestURI for the first servlet in the */
      /* forward chain" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1A, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes1b */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the portlet request attribute javax.servlet.include.request_uri */
      /* will not be set" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1B, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes1c */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the servlet request attribute javax.servlet.include.request_uri */
      /* will not be set" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1C, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes2 */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the portlet request attribute javax.servlet.forward.context_path */
      /* will be set, and equals the value from */
      /* HTTPServletRequest.getContextPath for the first servlet in the */
      /* forward chain" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes2a */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the servlet request attribute javax.servlet.forward.context_path */
      /* will be set, and equals the value from */
      /* HTTPServletRequest.getContextPath for the first servlet in the */
      /* forward chain" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2A, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes2b */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the portlet request attribute javax.servlet.include.context_path */
      /* will not be set" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2B, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes2c */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the servlet request attribute javax.servlet.include.context_path */
      /* will not be set" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2C, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes3 */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the portlet request attribute javax.servlet.forward.servlet_path */
      /* will be set, and equals the value from */
      /* HTTPServletRequest.getServletPath for the first servlet in the */
      /* forward chain" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes3a */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the servlet request attribute javax.servlet.forward.servlet_path */
      /* will be set, and equals the value from */
      /* HTTPServletRequest.getServletPath for the first servlet in the */
      /* forward chain" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3A, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes3b */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the portlet request attribute javax.servlet.include.servlet_path */
      /* will not be set" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3B, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes3c */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the servlet request attribute javax.servlet.include.servlet_path */
      /* will not be set" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3C, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes4 */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the portlet request attribute javax.servlet.forward.path_info will */
      /* be set, and equals the value from HTTPServletRequest.getPathInfo */
      /* for the first servlet in the forward chain" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes4a */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the servlet request attribute javax.servlet.forward.path_info will */
      /* be set, and equals the value from HTTPServletRequest.getPathInfo */
      /* for the first servlet in the forward chain" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4A, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes4b */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the portlet request attribute javax.servlet.include.path_info will */
      /* not be set" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4B, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes4c */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the servlet request attribute javax.servlet.include.path_info will */
      /* not be set" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4C, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes5 */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the portlet request attribute javax.servlet.forward.query_string */
      /* will be set, and equals the value from */
      /* HTTPServletRequest.getQueryString for the first servlet in the */
      /* forward chain" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes5a */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the servlet request attribute javax.servlet.forward.query_string */
      /* will be set, and equals the value from */
      /* HTTPServletRequest.getQueryString for the first servlet in the */
      /* forward chain" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5A, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes5b */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the portlet request attribute javax.servlet.include.query_string */
      /* will not be set" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5B, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes5c */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the servlet request attribute javax.servlet.include.query_string */
      /* will not be set" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5C, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes6 */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* the request attribute javax.portlet.config must be set to the */
      /* javax.portlet.PortletConfig object" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES6, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes7 */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* for forwards from the processAction method, The request attribute */
      /* javax.portlet.request must be set to the */
      /* javax.portlet.ActionRequest object" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES7, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes8 */
      /* Details: "In a servlet forwarded to by the target of a forward, */
      /* for forwards from the processAction method, The request attribute */
      /* javax.portlet.response must be set to the */
      /* javax.portlet.ActionResponse object" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES8, aurl);
         tb.writeTo(writer);
      }

   }

}
