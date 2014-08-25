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
 * portlet AddlFilterTests_SPEC2_20_Resource_event
 *
 */
public class AddlFilterTests_SPEC2_20_Resource implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlFilterTests_SPEC2_20_Resource.class.getName();
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

      /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filter1                */
      /* Details: "A filter declaration can be configured in the deployment   */
      /* descriptor"                                                          */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filter6                */
      /* Details: "A filter declaration can contain multiple                  */
      /* &lt;lifecycle&gt; tags for a single filter class"                    */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER6);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filter7                */
      /* Details: "The filter declaration can contain initialization          */
      /* parameters which can be read by the filter through the               */
      /* FilterConfig object"                                                 */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER7);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filter8                */
      /* Details: "For each filter declaration, the filter instance must      */
      /* receive all initialization parameters defined in the filter          */
      /* declaration"                                                         */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER8);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filter9                */
      /* Details: "For each filter declaration, the filter instance must      */
      /* receive only initialization parameters defined in the filter         */
      /* declaration"                                                         */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER9);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filter10               */
      /* Details: "For multiple filter declarations for a single filter       */
      /* class, the filter instance must receive all initialization           */
      /* parameters defined in the filter declaration"                        */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER10);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filter11               */
      /* Details: "For multiple filter declarations for a single filter       */
      /* class, the filter instance must receive only initialization          */
      /* parameters defined in the filter declaration"                        */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER11);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filter12               */
      /* Details: "A filter class can appear in multiple filter               */
      /* declarations"                                                        */
      TestResult tr7 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER12);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filter13               */
      /* Details: "A filter declaration can be mapped to a portlet through    */
      /* the deployment descriptor &lt;filter-mapping&gt; element"            */
      TestResult tr8 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER13);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filter14               */
      /* Details: "Filters can be associated with groups of portlets using    */
      /* the '*' character as a wildcard at the end of a string to indicate   */
      /* that the filter must be applied to any portlet whose name starts     */
      /* with the characters before the \"*\" character"                      */
      TestResult tr9 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER14);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filter15               */
      /* Details: "The order the container uses in building the chain of      */
      /* filters to be applied for a particular request is the order in       */
      /* which the &lt;portlet-name&gt; matching filter mappings appear in    */
      /* the deployment descriptor"                                           */
      TestResult tr10 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER15);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filter5                */
      /* Details: "If the filter declaration specifies the                    */
      /* &lt;lifecycle&gt; tag value RESOURCE_PHASE, the                      */
      /* ResourceFilter.doFilter method is called"                            */
      TestResult tr11 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER5);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filterWrapper7         */
      /* Details: "An RESOURCE_PHASE filter can wrap the ResourceRequest      */
      /* object with a custom wrapper"                                        */
      TestResult tr12 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTERWRAPPER7);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filterWrapper8         */
      /* Details: "An RESOURCE_PHASE filter can wrap the ResourceResponse     */
      /* object with a custom wrapper"                                        */
      TestResult tr13 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTERWRAPPER8);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write("<div id=\"AddlFilterTests_SPEC2_20_Resource\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write("         document.getElementById(\"AddlFilterTests_SPEC2_20_Resource\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
