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

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC15_HeaderResponse1", supports = {
      @Supports(mimeType = "text/html"), @Supports(mimeType = "*/*") })
public class HeaderPortletTests_SPEC15_HeaderResponse1 implements Portlet, HeaderPortlet {
   
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
      
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      
      PrintWriter writer = portletResp.getWriter();
      
      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_setContentType        */
      /* Details: "The portlet container will ignore any character encoding         */
      /* specified as part of the content type for render calls."                   */
      if(portletResp.getContentType().equals("*/*")){
         portletResp.setContentType("text/html;charset=ANSI");
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETCONTENTTYPE);
         String charEncoding = portletResp.getCharacterEncoding();
         if(charEncoding.equals("UTF-8")){
            result.setTcSuccess(true);
            result.appendTcDetail("Character encoding is not changed in render method. "+charEncoding);
         } else {
            result.appendTcDetail("Failed because Character encoding is changed in render method. "+charEncoding);
         }
         result.writeTo(writer);
      }
      
      String msg = (String) portletReq.getPortletSession().getAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_HeaderResponse1",
            PORTLET_SCOPE);
      writer.write("<p>" + msg + "</p>\n");
      portletReq.getPortletSession().removeAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_HeaderResponse1",
            PORTLET_SCOPE);
      
      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_getWriter             */
      /* Details: "Data written to the HeaderResponse writer is added to the        */
      /* aggregated portal document HEAD section."                                  */
      writer.write("<script type='text/javascript'>");
      writer.write("$( document ).ready(function() {");
      writer.write("  var jQueryTag = $('#jquery-tag');");
      writer.write("  if(jQueryTag.length){");
      writer.write("    $('#V3HeaderPortletTests_SPEC15_HeaderResponse_getWriter-result').html('Test Succeeded');");
      writer.write("  }");
      writer.write("});");
      writer.write("</script>");
      
      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency7        */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - Adds a dependency on a page-level resource that is        */
      /* managed by the portal and adds a resource for addition to the page for the */
      /* dependency."                                                               */
      writer.write("<script type='text/javascript'>");
      writer.write("$( document ).ready(function() {");
      writer.write("  var dependencyTag = $('#dependency-test');");
      writer.write("  if(dependencyTag.length){");
      writer.write("    $('#V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency7-result').html('Test Succeeded');");
      writer.write("  }");
      writer.write("});");
      writer.write("</script>");
      
      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency8        */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - The portal may choose to include the later version of the */
      /* resource on the page if 2 same dependencies with different version are     */
      /* declared."                                                                 */
      writer.write("<script type='text/javascript'>");
      writer.write("$( document ).ready(function() {");
      writer.write("  var dependencyTag2_1 = $('#dependency-test2-1');");
      writer.write("  var dependencyTag2_2 = $('#dependency-test2-2');");
      writer.write("  if(dependencyTag2_1.length==0 && dependencyTag2_2.length>0){");
      writer.write("    $('#V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency8-result').html('Test Succeeded');");
      writer.write("  }");
      writer.write("});");
      writer.write("</script>");

   }

   @Override
   public void renderHeaders(HeaderRequest portletReq, HeaderResponse portletResp)
         throws PortletException, IOException {
      
      StringWriter writer = new StringWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_setTitle              */
      /* Details: "This method sets the title of the portlet."                      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE);
         // TODO: This method is setting title of all portlets. 
         //       How to test this method, i.e., How to get changed title?
         portletResp.setTitle("some title");
         result.appendTcDetail("Portlet title is found to be ");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_setTitle2             */
      /* Details: "An empty string can be set as title of portlet."                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE2);
         // TODO: This method is setting title of all portlets. 
         //       How to test this method, i.e., How to get changed title?
         //       Fix the description
         portletResp.setTitle("");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_setTitle3             */
      /* Details: "Setting title as null restores the original title."              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE3);
         // TODO: This method is setting title of all portlets. 
         //       How to test this method, i.e., How to get changed title?
         //       Fix the description
         portletResp.setTitle(null);
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_setContentType        */
      /* Details: "The portlet container will ignore any character encoding         */
      /* specified as part of the content type for render calls."                   */
      // TODO: Setting charset here not working anyway. Test case passes because 
      //       default charset is utf-8
      // To confirm see test case - V3HeaderPortletTests_SPEC15_Header_characterEncoding3
      portletResp.setContentType("*/*;charset=utf-8");
     

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_getWriter             */
      /* Details: "Data written to the HeaderResponse writer is added to the        */
      /* aggregated portal document HEAD section."                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_GETWRITER);
         PrintWriter pw = portletResp.getWriter();
         pw.write("<script id='jquery-tag' src='https://code.jquery.com/jquery-3.1.0.min.js'></script>");
         pw.close();
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency3        */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - The dependency added dynamically through this method is added to the     */
      /* statically declared dependencies for the portlet for the current rendering */
      /* cycle only."                                                               */
      // TODO: What is the meaning of this? How do I test this?
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency4        */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - Conflicting case when the dependency is added with this method and also  */
      /* with addProperty method?"                                                  */
      // TODO: How do I add javascript by addProperty method? Reference - HeaderResponse.addDependency()
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY4);
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency5        */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - Throws IllegalArgumentException - if name is null."                      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY5);
         try{
            portletResp.addDependency(null, "testDependency", "1.0");
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
            portletResp.addDependency("", "testDependency", "1.0");
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
         portletResp.addDependency("testDependency", "testDependency", "1.0", "<script id='dependency-test'></script>");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency8        */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - The portal may choose to include the later version of the */
      /* resource on the page if 2 same dependencies with different version are     */
      /* declared."                                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY8);
         portletResp.addDependency("testDependency2", "testDependency2", "1.0", "<script id='dependency-test2-1'></script>");
         portletResp.addDependency("testDependency2", "testDependency2", "2.0", "<script id='dependency-test2-2'></script>");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency9        */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - Conflicting case when the dependency is added with this   */
      /* method and also with addProperty method?"                                  */
      // TODO: How to I add javascript by addProperty method? Reference - HeaderResponse.addDependendy()
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY9);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency10       */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - Throws IllegalArgumentException - if name is null."       */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY10);
         try{
            portletResp.addDependency(null, "testDependency", "1.0", "<script id='dependency-test'></script>");
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
            portletResp.addDependency("", "testDependency", "1.0", "<script id='dependency-test'></script>");
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
            portletResp.addDependency("testDependency", "testDependency", "1.0", "<invalid id='dependency-test'></invalid>");
            result.appendTcDetail("Failed because no exception is raised.");
         } catch (IllegalArgumentException e){
           result.setTcSuccess(true);
           result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }
      
      portletReq.getPortletSession().setAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_HeaderResponse1",
            writer.toString(), PORTLET_SCOPE);
   }

}
