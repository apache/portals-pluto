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

@PortletConfiguration(portletName = "PortletHubTests_SPEC_23_JSRS")
public class PortletHubTests_SPEC_23_JSRS implements Portlet {
   
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

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState1                   */
      /* Details: "The portlet hub setRenderState function causes the onStateChange */
      /* listener to be called"                                                     */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE1);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState2                   */
      /* Details: "The portlet hub setRenderState function allows the portlet mode  */
      /* to be set to \"EDIT\""                                                     */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE2);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState3                   */
      /* Details: "The portlet hub setRenderState function allows the portlet mode  */
      /* to be set to \"VIEW\""                                                     */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE3);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState4                   */
      /* Details: "The portlet hub setRenderState function allows the window state  */
      /* to be set to \"MAXIMIZED\""                                                */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE4);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState5                   */
      /* Details: "The portlet hub setRenderState function allows the window state  */
      /* to be set to \"NORMAL\""                                                   */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE5);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE5);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState6                   */
      /* Details: "The portlet hub setRenderState function allows a new parameter   */
      /* \"NewParm\" to be set to \"NewVal\""                                       */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE6);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE6);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState7                   */
      /* Details: "The portlet hub setRenderState function allows parameter         */
      /* \"NewParm\" to be set to [\"NewVal1\", \"NewVal2\"]"                       */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE7);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE7);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState8                   */
      /* Details: "The portlet hub setRenderState function allows a new parameter   */
      /* \"NewParm\" to be deleted"                                                 */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE8);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE8);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState9                   */
      /* Details: "The portlet hub setRenderState function allows all parameters to */
      /* be deleted"                                                                */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE9);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE9);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState0                   */
      /* Details: "The portlet hub setRenderState function allows several           */
      /* parameters to be set"                                                      */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE0);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE0);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderStateA                   */
      /* Details: "The portlet hub setRenderState function allows setting the state */
      /* back to the original test data"                                            */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATEA);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATEA);
         result.writeTo(writer);
      }

      writer.write("<script>");
      writer.write("   var tck = tck || {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSRS = {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSRS.pid = '" + portletResp.getNamespace() + "';");
      writer.write("</script>");

      writer.write("<form  id='PortletHubTests_SPEC_23_JSRS-dummyForm' onsubmit='return false;' enctype='application/x-www-form-urlencoded'>");
      writer.write("</form>");

      StringBuilder txt = new StringBuilder(128);
      txt.append("<script type='text/javascript' src='");
      txt.append(portletConfig.getPortletContext().getContextPath());
      txt.append("/javascript/PortletHubTests_SPEC_23_JSRS.js'></script>\n");

      writer.write(txt.toString());


   }

}
