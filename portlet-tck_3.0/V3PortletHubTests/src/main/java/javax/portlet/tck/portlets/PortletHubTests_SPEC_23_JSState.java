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

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE6;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE7;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETPORTLETMODE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETPORTLETMODE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE6;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETWINDOWSTATE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETWINDOWSTATE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PORTLETMODE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_REMOVE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_REMOVE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_REMOVE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETPORTLETMODE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETPORTLETMODE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETPORTLETMODE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETWINDOWSTATE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETWINDOWSTATE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETWINDOWSTATE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_STATE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_STATE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_STATE3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSSTATE_WINDOWSTATE;

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
import javax.portlet.tck.beans.TestResultAsync;
import javax.portlet.tck.util.ModuleTestCaseDetails;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "PortletHubTests_SPEC_23_JSState")
public class PortletHubTests_SPEC_23_JSState implements Portlet {
   
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

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_Parameters1                    */
      /* Details: "The PortletInit object newParameters function returns a          */
      /* Parameters object"                                                         */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_Parameters2                    */
      /* Details: "The PortletInit object newParameters function returns a          */
      /* Parameters object containing no parameters"                                */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_Parameters3                    */
      /* Details: "The PortletInit object newParameters function returns a          */
      /* Parameters object containing cloned values if passed a parameters object"  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_State1                         */
      /* Details: "The PortletInit object newState function returns a State object  */
      /* "                                                                          */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_STATE1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_State2                         */
      /* Details: "The PortletInit object newState function returns a State object  */
      /* containing no parameters if not passed a State object"                     */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_STATE2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_State3                         */
      /* Details: "The PortletInit object newState function returns a State object  */
      /* containing cloned values if passed a State object"                         */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_STATE3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone                          */
      /* Details: "The RenderState object clone property is type function"          */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_setPortletMode                 */
      /* Details: "The RenderState object setPortletMode property is type function" */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETPORTLETMODE);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getPortletMode                 */
      /* Details: "The RenderState object getPortletMode property is type function" */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETPORTLETMODE);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_setWindowState                 */
      /* Details: "The RenderState object setWindowState property is type function" */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETWINDOWSTATE);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getWindowState                 */
      /* Details: "The RenderState object getWindowState property is type function" */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETWINDOWSTATE);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_setValue                       */
      /* Details: "The RenderState object setValue property is type function"       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValue                       */
      /* Details: "The RenderState object getValue property is type function"       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValues                      */
      /* Details: "The RenderState object getValues property is type function"      */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_remove                         */
      /* Details: "The RenderState object remove property is type function"         */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_REMOVE);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_parameters                     */
      /* Details: "The RenderState object parameters property is type object"       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_portletMode                    */
      /* Details: "The RenderState object portletMode property is type string"      */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PORTLETMODE);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_windowState                    */
      /* Details: "The RenderState object windowState property is type string"      */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_WINDOWSTATE);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone1                         */
      /* Details: "The RenderState object clone function returns a new object       */
      /* instance"                                                                  */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone2                         */
      /* Details: "The RenderState object clone function returns a RenderState      */
      /* object with the required properties"                                       */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone3                         */
      /* Details: "The RenderState object clone function returns a RenderState      */
      /* object with the same portlet mode"                                         */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone4                         */
      /* Details: "The RenderState object clone function returns a RenderState      */
      /* object with the same window state"                                         */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone5                         */
      /* Details: "The RenderState object clone function returns a RenderState      */
      /* object with no parameters if the original had no parameters"               */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE5);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone6                         */
      /* Details: "The RenderState object clone function returns a RenderState      */
      /* object with the same single-value parameters if the original had           */
      /* single-value parameters"                                                   */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE6);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone7                         */
      /* Details: "The RenderState object clone function returns a RenderState      */
      /* object with the same multi-value parameters if the original had            */
      /* multi-value parameters"                                                    */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE7);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_setPortletMode1                */
      /* Details: "The RenderState object setPortletMode function throws a          */
      /* TypeError if the argument is not a string"                                 */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETPORTLETMODE1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_setPortletMode2                */
      /* Details: "The RenderState object setPortletMode function sets the portlet  */
      /* mode"                                                                      */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETPORTLETMODE2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getPortletMode1                */
      /* Details: "The RenderState object getPortletMode function returns the       */
      /* portlet mode"                                                              */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETPORTLETMODE1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_setWindowState1                */
      /* Details: "The RenderState object setWindowState function throws a          */
      /* TypeError if the argument is not a string"                                 */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETWINDOWSTATE1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_setWindowState2                */
      /* Details: "The RenderState object setWindowState function sets the window   */
      /* state"                                                                     */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETWINDOWSTATE2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getWindowState1                */
      /* Details: "The RenderState object getWindowState function returns the       */
      /* window state"                                                              */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETWINDOWSTATE1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_setValue1                      */
      /* Details: "The RenderState object setValue function throws a TypeError if   */
      /* the parameter name is not a string"                                        */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_setValue2                      */
      /* Details: "The RenderState object setValue function throws a TypeError if   */
      /* the parameter value is not a string or array"                              */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_setValue3                      */
      /* Details: "The RenderState object setValue function can set a single-valued */
      /* parameter"                                                                 */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_setValue4                      */
      /* Details: "The RenderState object setValue function can set a multi-valued  */
      /* parameter"                                                                 */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_setValue5                      */
      /* Details: "The RenderState object setValue function can set a parameter to  */
      /* null"                                                                      */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE5);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValue1                      */
      /* Details: "The RenderState object getValue function throws a TypeError if   */
      /* the parameter name is not a string"                                        */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValue2                      */
      /* Details: "The RenderState object getValue function returns a single-valued */
      /* parameter"                                                                 */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValue3                      */
      /* Details: "The RenderState object getValue function returns null if the     */
      /* parameter was set to null"                                                 */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValue4                      */
      /* Details: "The RenderState object getValue function returns the first value */
      /* of a multi-valued parameter"                                               */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValue5                      */
      /* Details: "The RenderState object getValue function returns undefined if    */
      /* the parameter name does not exist and there is no default"                 */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE5);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValue6                      */
      /* Details: "The RenderState object getValue function returns the default if  */
      /* the parameter name does not exist and a default is provided"               */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE6);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValues1                     */
      /* Details: "The RenderState object getValues function throws a TypeError if  */
      /* the parameter name is not a string"                                        */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValues2                     */
      /* Details: "The RenderState object getValues function returns an array of    */
      /* strings for a multi-valued parameter"                                      */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValues3                     */
      /* Details: "The RenderState object getValues function returns undefined if   */
      /* the parameter name does not exist and there is no default"                 */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValues4                     */
      /* Details: "The RenderState object getValues function returns the default if */
      /* the parameter name does not exist and a default is provided"               */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_remove1                        */
      /* Details: "The RenderState object remove function throws a TypeError if the */
      /* parameter name is not a string"                                            */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_REMOVE1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSState_remove2                        */
      /* Details: "The RenderState object remove function removes an existing       */
      /* parameter"                                                                 */
      {
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_REMOVE2);
         result.writeTo(writer);
      }

      writer.write("<script>");
      writer.write("   var tck = tck || {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSState = {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSState.pid = '" + portletResp.getNamespace() + "';");
      writer.write("</script>");

      writer.write("<form  id='PortletHubTests_SPEC_23_JSState-dummyForm' onsubmit='return false;' enctype='application/x-www-form-urlencoded'>");
      writer.write("</form>");

      StringBuilder txt = new StringBuilder(128);
      txt.append("<script type='text/javascript' src='");
      txt.append(portletConfig.getPortletContext().getContextPath());
      txt.append("/javascript/PortletHubTests_SPEC_23_JSState.js'></script>\n");

      writer.write(txt.toString());


   }

}
