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
public class AddlPortletTests_SPEC2_6_Config implements Portlet {
   private static final String LOG_CLASS = 
         AddlPortletTests_SPEC2_6_Config.class.getName();
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

      /* TestCase: SPEC2_6_Config_getResourceBundle1                          */
      /* Details: "The resource bundle defined in the deployment descriptor   */
      /* <resource-bundle> element can be obtained through the                */
      /* PortletConfig object"                                                */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETRESOURCEBUNDLE1);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getResourceBundle2                          */
      /* Details: "If the resource bundle contains a                          */
      /* \"javax.portlet.title\" property, the value defined in the bundle    */
      /* is returned by the corresponding getString method call"              */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETRESOURCEBUNDLE2);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getResourceBundle3                          */
      /* Details: "If the resource bundle contains a                          */
      /* \"javax.portlet.short-title\" property, the value defined in the     */
      /* bundle is returned by the corresponding getString method call"       */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETRESOURCEBUNDLE3);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getResourceBundle4                          */
      /* Details: "If the resource bundle contains a                          */
      /* \"javax.portlet.keywords\" property, the value defined in the        */
      /* bundle is returned by the corresponding getString method call"       */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETRESOURCEBUNDLE4);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getResourceBundle5                          */
      /* Details: "If the resource bundle does not contain a                  */
      /* \"javax.portlet.title\" property, the value defined in the           */
      /* deployment descriptor <title> element is returned by the             */
      /* corresponding getString method call"                                 */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETRESOURCEBUNDLE5);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getResourceBundle6                          */
      /* Details: "If the resource bundle does not contain a                  */
      /* \"javax.portlet.short-title\" property, the value defined in the     */
      /* deployment descriptor <short-title> element is returned by the       */
      /* corresponding getString method call"                                 */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETRESOURCEBUNDLE6);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getResourceBundle7                          */
      /* Details: "If the resource bundle does not contain a                  */
      /* \"javax.portlet.keywords\" property, the value defined in the        */
      /* deployment descriptor <keywords> element is returned by the          */
      /* corresponding getString method call"                                 */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETRESOURCEBUNDLE7);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getResourceBundle8                          */
      /* Details: "If no resource bundle is defined, the value defined in     */
      /* the deployment descriptor <title> element is returned by the         */
      /* corresponding getString method call"                                 */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETRESOURCEBUNDLE8);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getResourceBundle9                          */
      /* Details: "If no resource bundle is defined, the value defined in     */
      /* the deployment descriptor <short-title> element is returned by the   */
      /* corresponding getString method call"                                 */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETRESOURCEBUNDLE9);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getResourceBundle10                         */
      /* Details: "If no resource bundle is defined, the value defined in     */
      /* the deployment descriptor <keywords> element is returned by the      */
      /* corresponding getString method call"                                 */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETRESOURCEBUNDLE10);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getPublishingEventQnames3                   */
      /* Details: "getPublishingEventQnames - If the event was defined        */
      /* using the <name> element rather than the <qname> element, default    */
      /* namespace defined with the <default-namespace> element must be       */
      /* added as the event namespace"                                        */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETPUBLISHINGEVENTQNAMES3);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getPublishingEventQnames4                   */
      /* Details: "getPublishingEventQnames - If the event was defined        */
      /* using the <name> element rather than the <qname> element and there   */
      /* is no default namespace defined, the value                           */
      /* XMLConstants.NULL_NS_URI must be added as the event namespace"       */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETPUBLISHINGEVENTQNAMES4);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getProcessingEventQnames3                   */
      /* Details: "getProcessingEventQnames - If the event was defined        */
      /* using the <name> element rather than the <qname> element, default    */
      /* namespace defined with the <default-namespace> element must be       */
      /* added as the event namespace"                                        */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETPROCESSINGEVENTQNAMES3);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getProcessingEventQnames4                   */
      /* Details: "getProcessingEventQnames - If the event was defined        */
      /* using the <name> element rather than the <qname> element and there   */
      /* is no default namespace defined, the value                           */
      /* XMLConstants.NULL_NS_URI must be added as the event namespace"       */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETPROCESSINGEVENTQNAMES4);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getContainerRuntimeOptions6                 */
      /* Details: "The returned Map contains values defined in the            */
      /* deployment descriptor <container-runtime-option> elements at the     */
      /* portlet application level"                                           */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETCONTAINERRUNTIMEOPTIONS6);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getContainerRuntimeOptions7                 */
      /* Details: "The returned Map contains values defined in the            */
      /* deployment descriptor <container-runtime-option> elements at the     */
      /* portlet level"                                                       */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETCONTAINERRUNTIMEOPTIONS7);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getContainerRuntimeOptions8                 */
      /* Details: "If the deployment descriptor contains                      */
      /* <container-runtime-option> elements defined at both the portlet      */
      /* and the portlet application levels, the returned Map contains a      */
      /* merger of all values"                                                */
      TestResult tr16 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETCONTAINERRUNTIMEOPTIONS8);
      /* TODO: implement test */

      /* TestCase: SPEC2_6_Config_getContainerRuntimeOptions9                 */
      /* Details: "If the deployment descriptor contains                      */
      /* <container-runtime-option> elements of the same name defined at      */
      /* both the portlet and the portlet application levels, the returned    */
      /* Map contains a the value defined at the portlet level"               */
      TestResult tr17 = tcd.getTestResultFailed(SPEC2_6_CONFIG_GETCONTAINERRUNTIMEOPTIONS9);
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
      tr14.writeTo(writer);
      tr15.writeTo(writer);
      tr16.writeTo(writer);
      tr17.writeTo(writer);


   }

}

