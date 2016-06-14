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

import static javax.portlet.ResourceURL.PAGE;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH1;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH2;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH3;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH4;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH5;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH6;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_INVOKE2;
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
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined in the
 * /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate the test case names
 * defined in the additionalTCs.xml file into the complete list of test case names for execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will initiate the
 * events, but not process them. The processing is done in the companion portlet
 * DispatcherTests_SPEC2_19_DispatchServletResource_event
 * 
 */
public class DispatcherTests_SPEC2_19_DispatchServletResource implements Portlet, ResourceServingPortlet {

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

      PrintWriter writer = portletResp.getWriter();

      JSR286DispatcherTestCaseDetails tcd = new JSR286DispatcherTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletResource_dispatch1 */
      /* Details: "The PortletContext getRequestDispatcher method returns a */
      /* PortletRequestDispatcher for a path within the portlet */
      /* application" */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH1);
      try {
         PortletRequestDispatcher rd = portletConfig.getPortletContext().getRequestDispatcher(
               "/DispatcherTests_SPEC2_19_DispatchServletResource_servlet");
         tr0.setTcSuccess(rd != null);
      } catch (Exception e) {
         tr0.appendTcDetail(e.toString());
      }
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletResource_dispatch2 */
      /* Details: "If the path provided to getRequestDispatcher method does */
      /* not start with \"/\", the method returns null" */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH2);
      try {
         PortletRequestDispatcher rd = portletConfig.getPortletContext().getRequestDispatcher(
               "DispatcherTests_SPEC2_19_DispatchServletResource_servlet");
         tr1.setTcSuccess(rd == null);
      } catch (Exception e) {
         tr1.appendTcDetail(e.toString());
      }
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletResource_dispatch3 */
      /* Details: "If the path provided to getRequestDispatcher method ends */
      /* with \"/\", the method returns null" */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH3);
      try {
         PortletRequestDispatcher rd = portletConfig.getPortletContext().getRequestDispatcher(
               "DispatcherTests_SPEC2_19_DispatchServletResource_servlet");
         tr2.setTcSuccess(rd == null);
      } catch (Exception e) {
         tr2.appendTcDetail(e.toString());
      }
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletResource_dispatch4 */
      /* Details: "If the path provided to getRequestDispatcher method does */
      /* not specify a valid path, the method returns null" */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH4);
      try {
         PortletRequestDispatcher rd = portletConfig.getPortletContext().getRequestDispatcher(" Invalid path.jsp ");
         tr3.setTcSuccess(rd == null);
      } catch (Exception e) {
         tr3.appendTcDetail(e.toString());
      }
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletResource_dispatch5 */
      /* Details: "The PortletContext getNamedDispatcher method returns a */
      /* PortletRequestDispatcher for a servlet within the portlet */
      /* application" */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH5);
      try {
         PortletRequestDispatcher rd = portletConfig.getPortletContext().getNamedDispatcher(
               "DispatcherTests_SPEC2_19_DispatchServletResource_servlet");
         tr4.setTcSuccess(rd != null);
      } catch (Exception e) {
         tr4.appendTcDetail(e.toString());
      }
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletResource_dispatch6 */
      /* Details: "If the name provided to getNamedDispatcher method is not */
      /* valid, the method returns null" */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH6);
      try {
         PortletRequestDispatcher rd = portletConfig.getPortletContext().getNamedDispatcher("Invalid Name");
         tr5.setTcSuccess(rd == null);

      } catch (Exception e) {
         tr5.appendTcDetail(e.toString());
      }
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletResource_invoke2 */
      /* Details: "If the forward method is called after the response has */
      /* been committed, an IllegalStateException exception is thrown" */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_INVOKE2);
      try {
         PortletRequestDispatcher rd = portletConfig.getPortletContext().getRequestDispatcher(
               "/DispatcherTests_SPEC2_19_DispatchServletResource_servlet");
         writer.write("<p>Test output</p>");
         portletResp.flushBuffer();
         try {
            rd.forward(portletReq, portletResp);
         } catch (IllegalStateException ise) {
            tr6.setTcSuccess(true);
         }
      } catch (Exception e) {
         tr6.appendTcDetail(e.toString());
      }
      tr6.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write("<div id=\"DispatcherTests_SPEC2_19_DispatchServletResource\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write("         document.getElementById(\"DispatcherTests_SPEC2_19_DispatchServletResource\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
