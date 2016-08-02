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
import java.nio.charset.Charset;

import javax.portlet.*;
import javax.portlet.annotations.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.PortletSession.PORTLET_SCOPE;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.util.ModuleTestCaseDetails.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC15_HeaderResponse2", supports = {
      @Supports(mimeType = "text/html") })
public class HeaderPortletTests_SPEC15_HeaderResponse2 implements Portlet, HeaderPortlet {
   
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
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {
      
      PrintWriter writer = portletResp.getWriter();
      
      String msg = (String) portletReq.getPortletSession().getAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_HeaderResponse2",
            PORTLET_SCOPE);
      writer.write("<p>" + msg + "</p>\n");
      portletReq.getPortletSession().removeAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_HeaderResponse2",
            PORTLET_SCOPE);
      
      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_getPortletOutputStream */
      /* Details: "Data written to the HeaderResponse writer is added to the        */
      /* aggregated portal document HEAD section."                                  */
      writer.write("<script type='text/javascript'>");
      writer.write("$( document ).ready(function() {");
      writer.write("  var outputStreamTag = $('#output-stream-tag');");
      writer.write("  if(outputStreamTag.length){");
      writer.write("    $('#V3HeaderPortletTests_SPEC15_HeaderResponse_getPortletOutputStream-result').html('Test Succeeded');");
      writer.write("  }");
      writer.write("});");
      writer.write("</script>");

   }

   @Override
   public void renderHeaders(HeaderRequest portletReq, HeaderResponse portletResp)
         throws PortletException, IOException {
      
      StringWriter writer = new StringWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_getPortletOutputStream */
      /* Details: "Data written to the HeaderResponse writer is added to the        */
      /* aggregated portal document HEAD section."                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_GETPORTLETOUTPUTSTREAM);
         OutputStream os = portletResp.getPortletOutputStream();
         String script = "<script id='output-stream-tag'></script>";
         os.write(script.getBytes(Charset.forName("UTF-8")));
         os.close();
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency         */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - Adds a dependency on a page-level resource that is managed by the        */
      /* portal."                                                                   */
      /* TODO: Can this really be tested? Try moving in new portlet which renders after this one. */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency2        */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - The dependency added by this method can be shared with other portlets."  */
      // TODO: Can this really be tested?
      //       Try moving in new portlet which renders after this one. Maybe its the same test as above one*/
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }
      
      portletReq.getPortletSession().setAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_HeaderResponse2",
            writer.toString(), PORTLET_SCOPE);
   }

}
