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

import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */
public class AddlEnvironmentTests_SPEC2_10_ContextOptions implements Portlet {
   private static final String LOG_CLASS = 
         AddlEnvironmentTests_SPEC2_10_ContextOptions.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
         throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest renderRequest, RenderResponse renderResponse)
         throws PortletException, IOException {
      
      if (LOGGER.isLoggable(Level.FINE)) {
         LOGGER.logp(Level.FINE, LOG_CLASS, "render", "Entry");
      }

      PrintWriter writer = renderResponse.getWriter();
      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: SPEC2_10_ContextOptions_containerRuntimeOptions1           */
      /* Details: "The getContainerRuntimeOptions method returns an           */
      /* enumeration of type String containing the keys of all container      */
      /* runtime options that the current portlet container supports."        */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_10_CONTEXTOPTIONS_CONTAINERRUNTIMEOPTIONS1);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_ContextOptions_actionScopedRequestAttributes1     */
      /* Details: "The container runtime option                               */
      /* \"javax.portlet.actionScopedRequestAttributes\" must be supported    */
      /* by the portlet container"                                            */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES1);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_ContextOptions_actionScopedRequestAttributes2     */
      /* Details: "If the actionScopedRequestAttributes option is set to      */
      /* TRUE, request attributes that are set in an action persist until a   */
      /* new action occurs"                                                   */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES2);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_ContextOptions_actionScopedRequestAttributes3     */
      /* Details: "If the option is set to TRUE and an attribute is set       */
      /* during an action request, the portlet container sets a render        */
      /* parameter with the name PortletRequest.ACTION_SCOPE_ID               */
      /* (\"javax.portlet.as\")"                                              */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES3);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_ContextOptions_actionScopedRequestAttributes4     */
      /* Details: "If the option is set to TRUE and an attribute is set       */
      /* during an action request, the attribute can be accessed in an        */
      /* event request that was initiated by the same action request"         */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_ContextOptions_actionScopedRequestAttributes5     */
      /* Details: "If the option is set to TRUE and an attribute is set       */
      /* during an action request, the attribute can be accessed in a         */
      /* subsequent render request"                                           */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_ContextOptions_actionScopedRequestAttributes6     */
      /* Details: "If the option is set to TRUE, a request attribute set      */
      /* during an event request is persisted in the same manner as an        */
      /* attribute set during action processing"                              */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES6);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_ContextOptions_actionScopedRequestAttributes7     */
      /* Details: "If the option is set to TRUE, receiving an action starts   */
      /* a new action scope with a new scope ID, all previous attributes      */
      /* are no longer accessible, new attributes can be stored"              */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES7);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_ContextOptions_actionScopedRequestAttributes8     */
      /* Details: "If the option is set to TRUE, receiving a render without   */
      /* an existing scope ID starts a new action scope with a new scope      */
      /* ID, all previous attributes are no longer accessible, new            */
      /* attributes can be stored"                                            */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES8);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_ContextOptions_actionScopedRequestAttributes9     */
      /* Details: "If the option is set to TRUE, receiving an event without   */
      /* an existing scope ID starts a new action scope with a new scope      */
      /* ID, all previous attributes are no longer accessible, new            */
      /* attributes can be stored"                                            */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_ContextOptions_actionScopedRequestAttributes0     */
      /* Details: "If the option is set to TRUE, receiving an event with an   */
      /* existing scope ID after the first render for this scope had          */
      /* occurred starts a new action scope with a new scope ID, all          */
      /* previous attributes are no longer accessible, new attributes can     */
      /* be stored"                                                           */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES0);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_ContextOptions_actionScopedRequestAttributes11    */
      /* Details: "The render parameter PortletRequest.ACTION_SCOPE_ID        */
      /* (\"javax.portlet.as\") can be removed from a URL in a                */
      /* PortletURLGenerationListener"                                        */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_ContextOptions_actionScopedRequestAttributes12    */
      /* Details: "The render parameter PortletRequest.ACTION_SCOPE_ID        */
      /* (\"javax.portlet.as\") can be removed from a ResourceURL in a        */
      /* PortletURLGenerationListener"                                        */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES12);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_ContextOptions_actionScopedRequestAttributes13    */
      /* Details: "If the actionScopedRequestAttributes option is set to      */
      /* FALSE, request attributes that are set in an action are released     */
      /* at the end of the request"                                           */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES13);
      /* TODO: implement test */



      // Write the results to the output stream

      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);
      tr3.writeTo(writer);
      tr4.writeTo(writer);
      tr5.writeTo(writer);
      tr6.writeTo(writer);
      tr7.writeTo(writer);
      tr8.writeTo(writer);
      tr9.writeTo(writer);
      tr10.writeTo(writer);
      tr11.writeTo(writer);
      tr12.writeTo(writer);
      tr13.writeTo(writer);


   }

}

