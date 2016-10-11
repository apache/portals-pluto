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

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONERROR1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONERROR2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONERROR3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE5;

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

@PortletConfiguration(portletName = "PortletHubTests_SPEC_23_JSListener")
public class PortletHubTests_SPEC_23_JSListener implements Portlet {
   
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

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange1              */
      /* Details: "After an onStateChange listener is added, the portlet hub calls  */
      /* the onStateChange function"                                                */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange2              */
      /* Details: "The onStateChange listener type argument has the value           */
      /* 'portlet.onStateChange'"                                                   */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange3              */
      /* Details: "The onStateChange listener renderState argument is a valid       */
      /* RenderState object"                                                        */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange4              */
      /* Details: "A previously added onStateChangeListener can be removed"         */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE4);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange5              */
      /* Details: "The portlet hub throws a TypeError if a previously added         */
      /* onStateChange listener is removed twice"                                   */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE5);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE5);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onError1                    */
      /* Details: "An onError listener can be added"                                */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONERROR1);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONERROR1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onError2                    */
      /* Details: "A previously added onError listener can be removed"              */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONERROR2);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONERROR2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onError3                    */
      /* Details: "The portlet hub throws a TypeError if a previously added onError */
      /* listener is removed twice"                                                 */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONERROR3);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONERROR3);
         result.writeTo(writer);
      }

      writer.write("<script>");
      writer.write("   var tck = tck || {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSListener = {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSListener.pid = '" + portletResp.getNamespace() + "';");
      writer.write("</script>");

      writer.write("<form  id='PortletHubTests_SPEC_23_JSListener-dummyForm' onsubmit='return false;' enctype='application/x-www-form-urlencoded'>");
      writer.write("</form>");

      StringBuilder txt = new StringBuilder(128);
      txt.append("<script type='text/javascript' src='");
      txt.append(portletConfig.getPortletContext().getContextPath());
      txt.append("/javascript/PortletHubTests_SPEC_23_JSListener.js'></script>\n");

      writer.write(txt.toString());


   }

}
