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
import java.io.PrintWriter;
import java.io.StringWriter;

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
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.Supports;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_GETWRITER;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY6;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY7;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY8;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY10;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY11;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY12;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC15_HeaderResponse1", supports = {
      @Supports(mimeType = "text/html"), @Supports(mimeType = "*/*") })
public class HeaderPortletTests_SPEC15_HeaderResponse1 implements Portlet, HeaderPortlet {

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
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_HeaderResponse1");
      writer.write("<p>" + msg + "</p>\n");
      renderRequest.removeAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_HeaderResponse1");

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_getWriter             */
      /* Details: "Data written to the HeaderResponse writer is added to the        */
      /* aggregated portal document HEAD section."                                  */
      writer.write("<script type='text/javascript'>");
      writer.write("document.addEventListener('DOMContentLoaded', function(event) {");
      writer.write("  var jQueryTag = document.getElementsByClassName('jquery-tag');");
      writer.write("  if(jQueryTag.length){");
      writer.write("    document.getElementById('V3HeaderPortletTests_SPEC15_HeaderResponse_getWriter-result').innerHTML = 'Test Succeeded';");
      writer.write("  }");
      writer.write("});");
      writer.write("</script>");
      
      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency7        */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - Adds a dependency on a page-level resource that is        */
      /* managed by the portal and adds a resource for addition to the page for the */
      /* dependency."                                                               */
      writer.write("<script type='text/javascript'>");
      writer.write("document.addEventListener('DOMContentLoaded', function(event) {");
      writer.write("  var dependencyTag = document.getElementsByClassName('dependency-test');");
      writer.write("  if(dependencyTag.length){");
      writer.write("    document.getElementById('V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency7-result').innerHTML= 'Test Succeeded';");
      writer.write("  }");
      writer.write("});");
      writer.write("</script>");
      
      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency8        */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - The portal may choose to include the later version of the */
      /* resource on the page if 2 same dependencies with different version are     */
      /* declared."                                                                 */
      writer.write("<script type='text/javascript'>");
      writer.write("document.addEventListener('DOMContentLoaded', function(event) {");
      writer.write("  var dependencyTag2_1 = document.getElementsByClassName('dependency-test2-1');");
      writer.write("  var dependencyTag2_2 = document.getElementsByClassName('dependency-test2-2');");
      writer.write("  if(dependencyTag2_1.length==0 && dependencyTag2_2.length>0){");
      writer.write("    document.getElementById('V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency8-result').innerHTML= 'Test Succeeded';");
      writer.write("  }");
      writer.write("});");
      writer.write("</script>");
      
      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency2        */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - The dependency added by this method can be shared with other portlets."  */
      writer.write("<script type='text/javascript'>");
      writer.write("document.addEventListener('DOMContentLoaded', function(event) {");
      writer.write("  if (typeof window.portlet != 'undefined') { ");
      writer.write("    document.getElementById('V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency2-result').innerHTML= 'Test Succeeded';");
      writer.write("  }");
      writer.write("});");
      writer.write("</script>");

   }

   @Override
   public void renderHeaders(HeaderRequest headerRequest, HeaderResponse headerResponse)
         throws PortletException, IOException {
      
      StringWriter writer = new StringWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_setTitle              */
      /* Details: "This method sets the title of the portlet."                      */
      {
         TestResult result = tcd.getTestResultSucceeded(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE);
         headerResponse.setTitle("some title");
         result.appendTcDetail("Cannot be tested as a portal is not required to display the portlet title."
               + " Also there is no method to get the changed title.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_setTitle2             */
      /* Details: "An empty string can be set as title of portlet."                 */
      {
         TestResult result = tcd.getTestResultSucceeded(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE2);
         headerResponse.setTitle("");
         result.appendTcDetail("Cannot be tested as a portal is not required to display the portlet title."
               + " Also there is no method to get the changed title.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_setTitle3             */
      /* Details: "Setting title as null restores the original title."              */
      {
         TestResult result = tcd.getTestResultSucceeded(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE3);
         headerResponse.setTitle(null);
         result.appendTcDetail("Cannot be tested as a portal is not required to display the portlet title."
               + " Also there is no method to get the changed title.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_getWriter             */
      /* Details: "Data written to the HeaderResponse writer is added to the        */
      /* aggregated portal document HEAD section."                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_GETWRITER);
         PrintWriter pw = headerResponse.getWriter();
         pw.write("<script class='jquery-tag'></script>");
         pw.close();
         result.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency2        */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - The dependency added by this method can be shared with other portlets."  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY2);
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency5        */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - Throws IllegalArgumentException - if name is null."                      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY5);
         try{
            headerResponse.addDependency(null, "testDependency", "1.0");
            result.appendTcDetail("Failed because no exception is raised.");
         } catch (IllegalArgumentException e){
           result.setTcSuccess(true);
           result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency6        */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - Throws IllegalArgumentException - if name is empty."                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY6);
         try{
            headerResponse.addDependency("", "testDependency", "1.0");
            result.appendTcDetail("Failed because no exception is raised.");
         } catch (IllegalArgumentException e){
           result.setTcSuccess(true);
           result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency7        */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - Adds a dependency on a page-level resource that is        */
      /* managed by the portal and adds a resource for addition to the page for the */
      /* dependency."                                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY7);
         headerResponse.addDependency("testDependency", "testDependency", "1.0", "<script class='dependency-test'></script>");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency8        */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - The portal may choose to include the later version of the */
      /* resource on the page if 2 same dependencies with different version are     */
      /* declared."                                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY8);
         headerResponse.addDependency("testDependency2", "testDependency2", "1.0", "<script class='dependency-test2-1'></script>");
         headerResponse.addDependency("testDependency2", "testDependency2", "2.0", "<script class='dependency-test2-2'></script>");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency10       */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - Throws IllegalArgumentException - if name is null."       */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY10);
         try{
            headerResponse.addDependency(null, "testDependency", "1.0", "<script class='dependency-test'></script>");
            result.appendTcDetail("Failed because no exception is raised.");
         } catch (IllegalArgumentException e){
           result.setTcSuccess(true);
           result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency11       */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - Throws IllegalArgumentException - if name is empty."      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY11);
         try{
            headerResponse.addDependency("", "testDependency", "1.0", "<script class='dependency-test'></script>");
            result.appendTcDetail("Failed because no exception is raised.");
         } catch (IllegalArgumentException e){
           result.setTcSuccess(true);
           result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency12       */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - Throws IllegalArgumentException - if markup does not      */
      /* contain valid tags for the document HEAD section."                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY12);
         try{
            headerResponse.addDependency("testDependency", "testDependency", "1.0", "<invalid class='dependency-test'></invalid>");
            result.appendTcDetail("Failed because no exception is raised.");
         } catch (IllegalArgumentException e){
           result.setTcSuccess(true);
           result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }
      
      headerRequest.setAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_HeaderResponse1",
            writer.toString());
   }

}
