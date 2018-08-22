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

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.HeaderPortlet;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.Dependency;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.Supports;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_GETPORTLETOUTPUTSTREAM;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY3;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC15_HeaderResponse2", supports = {
      @Supports(mimeType = "text/html") },
      dependencies = @Dependency(name = "PortletHub", scope = "javax.portlet", version="3.0.0")
)
public class HeaderPortletTests_SPEC15_HeaderResponse2 implements Portlet, HeaderPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
      
      PrintWriter writer = renderResponse.getWriter();
      
      String msg = (String) renderRequest.getAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_HeaderResponse2");
      writer.write("<p>" + msg + "</p>\n");
      renderRequest.removeAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_HeaderResponse2");

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_getPortletOutputStream */
      /* Details: "Data written to the HeaderResponse writer is added to the        */
      /* aggregated portal document HEAD section."                                  */
      writer.write("<script type='text/javascript'>");
      writer.write("document.addEventListener('DOMContentLoaded', function(event) {");
      writer.write("  var outputStreamTag = document.getElementsByClassName('output-stream-tag');");
      writer.write("  if(outputStreamTag.length){");
      writer.write("    document.getElementById('V3HeaderPortletTests_SPEC15_HeaderResponse_getPortletOutputStream-result').innerHTML = 'Test Succeeded';");
      writer.write("  }");
      writer.write("});");
      writer.write("</script>");

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency         */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - Adds a dependency on a page-level resource that is managed by the        */
      /* portal."                                                                   */
      writer.write("<script type='text/javascript'>");
      writer.write("document.addEventListener('DOMContentLoaded', function(event) {");
      writer.write("  if (typeof window.portlet != 'undefined') { ");
      writer.write("    document.getElementById('V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency-result').innerHTML = 'Test Succeeded';");
      writer.write("  }");
      writer.write("});");
      writer.write("</script>");
   }

   @Override
   public void renderHeaders(HeaderRequest headerRequest, HeaderResponse headerResponse)
         throws PortletException, IOException {
      
      StringWriter writer = new StringWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_getPortletOutputStream */
      /* Details: "Data written to the HeaderResponse writer is added to the        */
      /* aggregated portal document HEAD section."                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_GETPORTLETOUTPUTSTREAM);
         OutputStream os = headerResponse.getPortletOutputStream();
         String script = "<script class='output-stream-tag'></script>";
         os.write(script.getBytes(Charset.forName("UTF-8")));
         os.close();
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency         */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - Adds a dependency on a page-level resource that is managed by the        */
      /* portal."                                                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY);
         headerResponse.addDependency("PortletHub", "javax.portlet", "3.0.0");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency2        */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - The dependency added by this method can be shared with other portlets."  */
      headerResponse.addDependency("PortletHub", "javax.portlet", "3.0.0");
      
      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency3        */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - The dependency added dynamically through this method is added to the     */
      /* statically declared dependencies for the portlet for the current rendering */
      /* cycle only."                                                               */
      {
         TestResult result = tcd.getTestResultSucceeded(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY3);
         result.appendTcDetail("Cannot be tested as the only dependency supported by portal"
               + " is PortletHub which is already added by other tests.");
         result.writeTo(writer);
      }
      
      headerRequest.setAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_HeaderResponse2",
            writer.toString());
   }

}
