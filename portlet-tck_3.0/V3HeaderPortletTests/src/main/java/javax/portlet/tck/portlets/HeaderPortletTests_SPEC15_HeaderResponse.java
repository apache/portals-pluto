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
import javax.portlet.annotations.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import static javax.portlet.tck.util.ModuleTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC15_HeaderResponse")
public class HeaderPortletTests_SPEC15_HeaderResponse implements Portlet {
   
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
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_setTitle              */
      /* Details: "This method sets the title of the portlet."                      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_setTitle2             */
      /* Details: "Test for empty string."                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_setTitle3             */
      /* Details: "Test for null string."                                           */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_setContentType        */
      /* Details: "The portlet container will ignore any character encoding         */
      /* specified as part of the content type for render calls."                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETCONTENTTYPE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_getWriter             */
      /* Details: "Data written to the HeaderResponse writer is added to the        */
      /* aggregated portal document HEAD section."                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_GETWRITER);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_getPortletOutputStream */
      /* Details: "Data written to the HeaderResponse writer is added to the        */
      /* aggregated portal document HEAD section."                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_GETPORTLETOUTPUTSTREAM);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency         */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - Adds a dependency on a page-level resource that is managed by the        */
      /* portal."                                                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency2        */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - The dependency added by this method can be shared with other portlets."  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency3        */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - The dependency added dynamically through this method is added to the     */
      /* statically declared dependencies for the portlet for the current rendering */
      /* cycle only."                                                               */
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
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY4);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency5        */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - Throws IllegalArgumentException - if name is null."                      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY5);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency6        */
      /* Details: "Method addDependency(String name, String scope, String version)  */
      /* - Throws IllegalArgumentException - if name is empty."                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY6);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency7        */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - Adds a dependency on a page-level resource that is        */
      /* managed by the portal and adds a resource for addition to the page for the */
      /* dependency."                                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY7);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency8        */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - The portal may choose to include the later version of the */
      /* resource on the page if 2 same dependencies with different version are     */
      /* declared."                                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY8);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency9        */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - Conflicting case when the dependency is added with this   */
      /* method and also with addProperty method?"                                  */
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
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency11       */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - Throws IllegalArgumentException - if name is empty."      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY11);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency12       */
      /* Details: "Method addDependency(String name, String scope, String version,  */
      /* String markup) - Throws IllegalArgumentException - if markup does not      */
      /* contain valid tags for the document HEAD section."                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY12);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

   }

}
