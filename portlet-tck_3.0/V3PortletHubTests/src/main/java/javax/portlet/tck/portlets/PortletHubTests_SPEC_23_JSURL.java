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

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL0;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL6;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL7;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL8;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL9;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLA;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLB;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLC;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.tck.beans.TestButtonAsync;
import javax.portlet.tck.beans.TestResultAsync;
import javax.portlet.tck.util.ModuleTestCaseDetails;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "PortletHubTests_SPEC_23_JSURL")
public class PortletHubTests_SPEC_23_JSURL implements Portlet {
   
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

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl1               */
      /* Details: "The portlet hub createResourceUrl function returns a string if   */
      /* called with no arguments"                                                  */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL1);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl2               */
      /* Details: "The portlet hub createResourceUrl function returns a string if   */
      /* called with a resource parameters argument"                                */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL2);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl3               */
      /* Details: "The portlet hub createResourceUrl function returns a string if   */
      /* called with resource parameters and cacheability arguments"                */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL3);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl4               */
      /* Details: "The portlet hub createResourceUrl function returns a string if   */
      /* called with resource parameters, cacheability, and resource ID arguments"  */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL4);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl5               */
      /* Details: "The portlet hub createResourceUrl function returns a string if   */
      /* called with a resource ID argument and with the resource parameters and    */
      /* cacheability arguments null "                                              */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL5);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL5);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl6               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* cacheability set to \"cacheLevelPage\""                                    */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL6);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL6);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl7               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* cacheability set to \"cacheLevelPortlet\""                                 */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL7);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL7);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl8               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* cacheability set to \"cacheLevelFull\""                                    */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL8);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL8);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl9               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* the resource parameters set as expected"                                   */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL9);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL9);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl0               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* multivalued resource parameters set as expected"                           */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL0);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL0);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlA               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* multivalued resource parameters containing null set as expected"           */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLA);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLA);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlB               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* the render state set when cacheability = cacheLevelPage"                   */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLB);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLB);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlC               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* the render state set when cacheability = cacheLevelPortlet"                */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLC);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLC);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlD               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with no */
      /* render state set when cacheability = cacheLevelFull"                       */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLD);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLD);
         result.writeTo(writer);
      }

      writer.write("<script>");
      writer.write("   var tck = tck || {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSURL = {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSURL.pid = '" + portletResp.getNamespace() + "';");
      writer.write("</script>");

      writer.write("<form  id='PortletHubTests_SPEC_23_JSURL-dummyForm' onsubmit='return false;' enctype='application/x-www-form-urlencoded'>");
      writer.write("</form>");

      StringBuilder txt = new StringBuilder(128);
      txt.append("<script type='text/javascript' src='");
      txt.append(portletConfig.getPortletContext().getContextPath());
      txt.append("/javascript/PortletHubTests_SPEC_23_JSURL.js'></script>\n");

      writer.write(txt.toString());


   }

}
