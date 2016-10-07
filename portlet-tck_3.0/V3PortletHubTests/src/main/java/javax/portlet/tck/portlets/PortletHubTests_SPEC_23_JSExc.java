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

@PortletConfiguration(portletName = "PortletHubTests_SPEC_23_JSExc")
public class PortletHubTests_SPEC_23_JSExc implements Portlet {
   
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

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener1                */
      /* Details: "The PortletInit object addEventListener function throws an       */
      /* IllegalArgumentException if no argument is provided"                       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener2                */
      /* Details: "The PortletInit object addEventListener function throws an       */
      /* IllegalArgumentException if 1 argument is provided"                        */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener3                */
      /* Details: "The PortletInit object addEventListener function throws an       */
      /* IllegalArgumentException if too many (&gt;2) arguments are provided"       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener4                */
      /* Details: "The PortletInit object addEventListener function throws an       */
      /* IllegalArgumentException if the type argument is not a string"             */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener5                */
      /* Details: "The PortletInit object addEventListener function throws an       */
      /* IllegalArgumentException if the function argument is not a function"       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER5);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener6                */
      /* Details: "The PortletInit object addEventListener function throws an       */
      /* IllegalArgumentException if the type is null"                              */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER6);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener7                */
      /* Details: "The PortletInit object addEventListener function throws an       */
      /* IllegalArgumentException if the function is null"                          */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER7);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener8                */
      /* Details: "The PortletInit object addEventListener function throws an       */
      /* IllegalArgumentException if the type begins with \"portlet.\" but is       */
      /* neither \"portlet.onStateChange\" or \"portlet.onError\""                  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER8);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_removeEventListener1             */
      /* Details: "The PortletInit object removeEventListener function throws an    */
      /* IllegalArgumentException if no argument is provided"                       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_REMOVEEVENTLISTENER1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_removeEventListener2             */
      /* Details: "The PortletInit object removeEventListener function throws an    */
      /* IllegalArgumentException if too many (&gt;1) arguments are provided"       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_REMOVEEVENTLISTENER2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_removeEventListener3             */
      /* Details: "The PortletInit object removeEventListener function throws an    */
      /* IllegalArgumentException if the handle is null"                            */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_REMOVEEVENTLISTENER3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_removeEventListener4             */
      /* Details: "The PortletInit object removeEventListener function throws an    */
      /* IllegalArgumentException if the handle is undefined"                       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_REMOVEEVENTLISTENER4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_removeEventListener5             */
      /* Details: "The PortletInit object removeEventListener function throws an    */
      /* IllegalArgumentException if the handle has an invalid value"               */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_REMOVEEVENTLISTENER5);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_createResourceUrl1               */
      /* Details: "The PortletInit object createResourceUrl function throws an      */
      /* IllegalArgumentException if too many (&gt;3) arguments are provided"       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_CREATERESOURCEURL1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_createResourceUrl2               */
      /* Details: "The PortletInit object createResourceUrl function throws an      */
      /* IllegalArgumentException if resource parameters is invalid"                */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_CREATERESOURCEURL2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_createResourceUrl3               */
      /* Details: "The PortletInit object createResourceUrl function throws an      */
      /* IllegalArgumentException if the cacheability argument is invalid"          */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_CREATERESOURCEURL3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState1                  */
      /* Details: "The PortletInit object setRenderState function throws an         */
      /* IllegalArgumentException if no argument is provided"                       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState2                  */
      /* Details: "The PortletInit object setRenderState function throws an         */
      /* IllegalArgumentException if too many (&gt;1) arguments are provided"       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState3                  */
      /* Details: "The PortletInit object setRenderState function throws an         */
      /* IllegalArgumentException if the argument is not an object"                 */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState4                  */
      /* Details: "The PortletInit object setRenderState function throws an         */
      /* IllegalArgumentException if the single argument is null"                   */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState5                  */
      /* Details: "The PortletInit object setRenderState function throws an         */
      /* IllegalArgumentException if the argument does not have a \"parameters\"    */
      /* property"                                                                  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE5);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState6                  */
      /* Details: "The PortletInit object setRenderState function throws an         */
      /* IllegalArgumentException if the argument does not have a \"windowState\"   */
      /* property"                                                                  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE6);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState7                  */
      /* Details: "The PortletInit object setRenderState function throws an         */
      /* IllegalArgumentException if the argument does not have a \"portletMode\"   */
      /* property"                                                                  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE7);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState9                  */
      /* Details: "The PortletInit object setRenderState function throws an         */
      /* NotInitializedException if no onStateChange listener is registered"        */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE9);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderStateA                  */
      /* Details: "The PortletInit object setRenderState function throws an         */
      /* IllegalArgumentException if \"windowState\" has an invalid value"          */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATEA);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderStateB                  */
      /* Details: "The PortletInit object setRenderState function throws an         */
      /* IllegalArgumentException if \"portletMode\" has an invalid value"          */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATEB);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action1                          */
      /* Details: "The PortletInit object action function throws an                 */
      /* IllegalArgumentException if too many (&gt;2) arguments are provided"       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action2                          */
      /* Details: "The PortletInit object action function throws an                 */
      /* IllegalArgumentException if a single argument is null"                     */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action3                          */
      /* Details: "The PortletInit object action function throws an                 */
      /* IllegalArgumentException if the element argument is null"                  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action4                          */
      /* Details: "The PortletInit object action function throws an                 */
      /* IllegalArgumentException if action parameters is null"                     */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action5                          */
      /* Details: "The PortletInit object action function throws an                 */
      /* IllegalArgumentException if action parameters is invalid"                  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION5);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action6                          */
      /* Details: "The PortletInit object action function throws an                 */
      /* IllegalArgumentException if the element argument is invalid"               */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION6);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action7                          */
      /* Details: "The PortletInit object action function throws an                 */
      /* IllegalArgumentException if there are 2 element arguments"                 */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION7);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action8                          */
      /* Details: "The PortletInit object action function throws an                 */
      /* IllegalArgumentException if there are 2 action parameters arguments"       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION8);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_actionA                          */
      /* Details: "The PortletInit object action function throws an                 */
      /* NotInitializedException if no onStateChange listener is registered."       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTIONA);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_startPartialAction1              */
      /* Details: "The PortletInit object startPartialAction function throws an     */
      /* IllegalArgumentException if too many (&gt;1) arguments are provided"       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_STARTPARTIALACTION1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_startPartialAction2              */
      /* Details: "The PortletInit object startPartialAction function throws an     */
      /* IllegalArgumentException if the single argument is null"                   */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_STARTPARTIALACTION2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_startPartialAction3              */
      /* Details: "The PortletInit object startPartialAction function throws an     */
      /* IllegalArgumentException if action parameters is invalid"                  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_STARTPARTIALACTION3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSExc_startPartialAction4              */
      /* Details: "The PortletInit object startPartialAction function throws an     */
      /* NotInitializedException if no onStateChange listener is registered."       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSEXC_STARTPARTIALACTION4);
         result.writeTo(writer);
      }

      writer.write("<script>");
      writer.write("   var tck = tck || {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSExc = {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSExc.pid = '" + portletResp.getNamespace() + "';");
      writer.write("</script>");

      writer.write("<form  id='PortletHubTests_SPEC_23_JSExc-dummyForm' onsubmit='return false;' enctype='application/x-www-form-urlencoded'>");
      writer.write("</form>");

      StringBuilder txt = new StringBuilder(128);
      txt.append("<script type='text/javascript' src='");
      txt.append(portletConfig.getPortletContext().getContextPath());
      txt.append("/javascript/PortletHubTests_SPEC_23_JSExc.js'></script>\n");

      writer.write(txt.toString());


   }

}
