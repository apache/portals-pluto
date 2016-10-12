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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
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
public class PortletHubTests_SPEC_23_JSURL implements Portlet, ResourceServingPortlet {
   
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

   @Override
   public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
      
      String status = "OK";
      String testcase = request.getRenderParameters().getValue("testcase");
      ResourceParameters rp = request.getResourceParameters();
      
      if (testcase == null || testcase.isEmpty()) {
         if (request.getCacheability().equals(ResourceURL.FULL)) {
            status = "OK " + ResourceURL.FULL;
         } else {
            status = "Failed. No test case parameter present.";
         }
         
         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl1               */
         /* Details: "The portlet hub createResourceUrl function returns a string if   */
         /* called with no arguments"                                                  */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL1)) {
         if (!rp.isEmpty()) {
            List<String> names = new ArrayList<String>(rp.getNames());
            status = "Resource Parameters were unexpectedly present: " + names.toString(); 
         }

         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl2               */
         /* Details: "The portlet hub createResourceUrl function returns a string if   */
         /* called with a resource parameters argument"                                */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL2)) {
         String param = rp.getValue("param1");
         if (param == null || !param.equals("val1")) {
            status = "Failed. Invalid resource parameter value: " + param;
         }

         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl3               */
         /* Details: "The portlet hub createResourceUrl function returns a string if   */
         /* called with resource parameters and cacheability arguments"                */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL3)) {
         String param = rp.getValue("param1");
         String ca = request.getCacheability();
         if (param == null || !param.equals("val1")) {
            status = "Failed. Invalid resource parameter value: " + param;
         } else if (ca == null || !ca.equals(ResourceURL.PAGE)) {
            status = "Failed. Invalid cacheability option: " + ca;
         }

         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl4               */
         /* Details: "The portlet hub createResourceUrl function returns a string if   */
         /* called with resource parameters, cacheability, and resource ID arguments"  */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL4)) {
         String param = rp.getValue("param1");
         String resid = request.getResourceID();
         String ca = request.getCacheability();
         if (param == null || !param.equals("val1")) {
            status = "Failed. Invalid resource parameter value: " + param;
         } else if (resid == null || !resid.equals("resourceId")) {
            status = "Failed. Invalid resource ID: " + resid;
         } else if (ca == null || !ca.equals(ResourceURL.PAGE)) {
            status = "Failed. Invalid cacheability option: " + ca;
         }

         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl5               */
         /* Details: "The portlet hub createResourceUrl function returns a string if   */
         /* called with a resource ID argument and with the resource parameters and    */
         /* cacheability arguments null "                                              */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL5)) {
         String resid = request.getResourceID();
         String ca = request.getCacheability();
         if (!rp.isEmpty()) {
            List<String> names = new ArrayList<String>(rp.getNames());
            status = "Failed. Resource parameter were unexpectedly present: " + names.toString();;
         } else if (resid == null || !resid.equals("resourceId")) {
            status = "Failed. Invalid resource ID: " + resid;
         } else if (ca == null || !ca.equals(ResourceURL.PAGE)) {
            status = "Failed. Invalid cacheability option: " + ca;
         }

         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl6               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* cacheability set to \"cacheLevelPage\""                                    */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL6)) {
         String ca = request.getCacheability();
         if (ca == null || !ca.equals(ResourceURL.PAGE)) {
            status = "Failed. Invalid cacheability option: " + ca;
         }

         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl7               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* cacheability set to \"cacheLevelPortlet\""                                 */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL7)) {
         String ca = request.getCacheability();
         if (ca == null || !ca.equals(ResourceURL.PORTLET)) {
            status = "Failed. Invalid cacheability option: " + ca;
         }

         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl8               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* cacheability set to \"cacheLevelFull\""                                    */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL8)) {
         // taken care of above, since there is no testcase parameter
         status = "Failed. Test case parameter present: " + testcase;

         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl9               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* the resource parameters set as expected"                                   */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL9)) {
         String param = rp.getValue("param1");
         if (param == null || !param.equals("val1")) {
            status = "Failed. Invalid resource parameter value: " + param;
         }

         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl0               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* multivalued resource parameters set as expected"                           */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL0)) {
         String[] vals = rp.getValues("param1");
         if (vals == null || vals.length != 2 || vals[0] == null || vals[1] == null || 
               !vals[0].equals("val1") || !vals[1].equals("val2")) {
            status = "Failed. Invalid values: " + (vals == null ? "null" : Arrays.asList(vals).toString());
         }

         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlA               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* multivalued resource parameters containing null set as expected"           */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLA)) {
         String[] vals = rp.getValues("param1");
         if (vals == null || vals.length != 3 || vals[0] == null || vals[1] == null || 
               !vals[0].equals("val1") || !vals[1].equals("val2") || 
               vals[2] != null) {
            status = "Failed. Invalid values: " + (vals == null ? "null" : Arrays.asList(vals).toString());
         }

         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlB               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* the render state set when cacheability = cacheLevelPage"                   */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLB)) {

         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlC               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* the render state set when cacheability = cacheLevelPortlet"                */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLC)) {

         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlD               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with no */
         /* render state set when cacheability = cacheLevelFull"                       */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLD)) {
         // taken care of above, since there is no testcase parameter
         status = "Failed. Test case parameter present: " + testcase;
         
      } else {
         status = "Failed. Unknown test case: " + testcase;
      }
      
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/plain");
      response.getWriter().write(status);
      
   }

}
