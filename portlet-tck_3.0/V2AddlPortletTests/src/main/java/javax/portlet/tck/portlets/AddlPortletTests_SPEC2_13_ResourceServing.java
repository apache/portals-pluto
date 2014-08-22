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

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.xml.namespace.QName;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet AddlPortletTests_SPEC2_13_ResourceServing_event
 *
 */
public class AddlPortletTests_SPEC2_13_ResourceServing implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlPortletTests_SPEC2_13_ResourceServing.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs2  */
      /* Details: "When a resource URL is invoked, the portlet container      */
      /* must not call the processAction method"                              */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS2);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs4  */
      /* Details: "After a resource URL has been created, the portlet mode    */
      /* set on the resource URL cannot be changed"                           */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS4);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs5  */
      /* Details: "After a resource URL has been created, the window state    */
      /* set on the resource URL cannot be changed"                           */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS5);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs6  */
      /* Details: "After a resource URL has been created, the render          */
      /* parameters set on the resource URL cannot be changed"                */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS6);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs7  */
      /* Details: "After a resource URL has been created, a parameter set     */
      /* on the resource URL is a resource parameter, not a render            */
      /* parameter"                                                           */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS7);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs8  */
      /* Details: "After a resource URL has been created, a parameter set     */
      /* on the URL with the same name as an exsisting render parameter       */
      /* results in a multivalued parameter containing both the resource      */
      /* pramaeter values and the render parameter values"                    */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS8);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs9  */
      /* Details: "In the resulting multivalued parameter after a resource    */
      /* parameter is added with the same name as a render parameter, the     */
      /* the render parameter values must be the last entries in the          */
      /* parameter value array"                                               */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS9);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write("<div id=\"AddlPortletTests_SPEC2_13_ResourceServing\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write("         document.getElementById(\"AddlPortletTests_SPEC2_13_ResourceServing\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
