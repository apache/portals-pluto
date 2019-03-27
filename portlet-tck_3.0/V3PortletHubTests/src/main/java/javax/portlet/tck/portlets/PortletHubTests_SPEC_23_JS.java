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

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS6;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS7;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS8;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS9;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT6;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT7;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT8;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT9;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITA;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITB;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITC;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITD;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER6;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER7;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER8;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.Dependency;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.tck.beans.TestResultAsync;
import javax.portlet.tck.util.ModuleTestCaseDetails;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "PortletHubTests_SPEC_23_JS",
    dependencies = @Dependency(name = "PortletHub", scope = "javax.portlet", version="3.0.0"))
public class PortletHubTests_SPEC_23_JS implements Portlet {
   
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

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register1                           */
      /* Details: "The portlet hub provides a global namespace var portlet of type  */
      /* object"                                                                    */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register2                           */
      /* Details: "The global portlet object register property is type function"    */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register3                           */
      /* Details: "The portlet hub register function throws a TypeError if no       */
      /* portlet ID argument is provided"                                           */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register4                           */
      /* Details: "The portlet hub register function throws a TypeError if too many */
      /* (&gt;1) arguments are provided"                                            */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register5                           */
      /* Details: "The portlet hub register function throws a TypeError if the      */
      /* portlet ID is not a string"                                                */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER5);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register6                           */
      /* Details: "The portlet hub register function throws a TypeError if the      */
      /* portlet ID is undefined"                                                   */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER6);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register7                           */
      /* Details: "The portlet hub register function throws a TypeError if the      */
      /* portlet ID is null"                                                        */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER7);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register8                           */
      /* Details: "The portlet hub register function The promise fails if the       */
      /* portlet ID is not defined for the portlet hub"                             */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER8);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register9                           */
      /* Details: "The portlet hub register function returns a PortletInit object   */
      /* when provided with a valid portlet ID"                                     */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER9);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit1                        */
      /* Details: "The PortletInit object portletModes property is an array"        */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit2                        */
      /* Details: "The PortletInit object windowStates property is an array"        */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit3                        */
      /* Details: "The PortletInit object action property is type function"         */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit4                        */
      /* Details: "The PortletInit object addEventListener property is type         */
      /* function"                                                                  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit5                        */
      /* Details: "The PortletInit object createResourceUrl property is type        */
      /* function"                                                                  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT5);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit6                        */
      /* Details: "The PortletInit object dispatchClientEvent property is type      */
      /* function"                                                                  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT6);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit7                        */
      /* Details: "The PortletInit object isInProgress property is type function"   */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT7);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit8                        */
      /* Details: "The PortletInit object newParameters property is type function"  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT8);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit9                        */
      /* Details: "The PortletInit object newState property is type function"       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT9);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInitA                        */
      /* Details: "The PortletInit object removeEventListener property is type      */
      /* function"                                                                  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITA);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInitB                        */
      /* Details: "The PortletInit object setRenderState property is type function" */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITB);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInitC                        */
      /* Details: "The PortletInit object startPartialAction property is type       */
      /* function"                                                                  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITC);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInitD                        */
      /* Details: "The PortletInit object constants property is type object"        */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITD);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants1                          */
      /* Details: "The Constants object VIEW property is type string and equal to   */
      /* 'view'"                                                                    */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants2                          */
      /* Details: "The Constants object EDIT property is type string and equal to   */
      /* 'edit'"                                                                    */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants3                          */
      /* Details: "The Constants object HELP property is type string and equal to   */
      /* 'help'"                                                                    */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants4                          */
      /* Details: "The Constants object NORMAL property is type string and equal to */
      /* 'normal'"                                                                  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants5                          */
      /* Details: "The Constants object MINIMIZED property is type string and equal */
      /* to 'minimized'"                                                            */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS5);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants6                          */
      /* Details: "The Constants object MAXIMIZED property is type string and equal */
      /* to 'maximized'"                                                            */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS6);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants7                          */
      /* Details: "The Constants object FULL property is type string and equal to   */
      /* 'cacheLevelFull'"                                                          */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS7);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants8                          */
      /* Details: "The Constants object PORTLET property is type string and equal   */
      /* to 'cacheLevelPortlet'"                                                    */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS8);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants9                          */
      /* Details: "The Constants object PAGE property is type string and equal to   */
      /* 'cacheLevelPage'"                                                          */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS9);
         result.writeTo(writer);
      }

      writer.write("<script>");
      writer.write("   var tck = tck || {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JS = {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JS.pid = '" + portletResp.getNamespace() + "';");
      writer.write("</script>");

      writer.write("<form  id='PortletHubTests_SPEC_23_JS-dummyForm' onsubmit='return false;' enctype='application/x-www-form-urlencoded'>");
      writer.write("</form>");

      StringBuilder txt = new StringBuilder(128);
      txt.append("<script type='text/javascript' src='");
      txt.append(portletConfig.getPortletContext().getContextPath());
      txt.append("/javascript/PortletHubTests_SPEC_23_JS.js'></script>\n");

      writer.write(txt.toString());


   }

}
