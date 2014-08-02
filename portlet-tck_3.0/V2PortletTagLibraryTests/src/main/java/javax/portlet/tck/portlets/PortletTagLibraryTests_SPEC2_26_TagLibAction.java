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
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */
public class PortletTagLibraryTests_SPEC2_26_TagLibAction implements Portlet {
   private static final String LOG_CLASS = 
         PortletTagLibraryTests_SPEC2_26_TagLibAction.class.getName();
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
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsAction1                 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable RenderRequest renderRequest to be null or       */
      /* undefined"                                                           */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSACTION1);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsAction2                 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable ResourceRequest resourceRequest to be null or   */
      /* undefined"                                                           */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSACTION2);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsAction3                 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable ActionRequest actionRequest to the              */
      /* corresponding object"                                                */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSACTION3);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsAction4                 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable EventRequest eventRequest to be null or         */
      /* undefined"                                                           */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSACTION4);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsAction5                 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable RenderResponse renderResponse to be null or     */
      /* undefined"                                                           */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSACTION5);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsAction6                 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable ResourceResponse resourceResponse to be null    */
      /* or undefined"                                                        */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSACTION6);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsAction7                 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable ActionResponse actionResponse to the            */
      /* corresponding object"                                                */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSACTION7);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsAction8                 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable EventResponse eventResponse to be null or       */
      /* undefined"                                                           */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSACTION8);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsAction9                 */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable PortletConfig portletConfig"                    */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSACTION9);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsAction10                */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable PortletSession portletSession, providing        */
      /* access to the portletSession, does not create a new session, only    */
      /* returns an existing session or null if no session exists."           */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSACTION10);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsAction11                */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable Map<String, Object> portletSessionScope,        */
      /* providing access to the portletSession attributes as a Map           */
      /* equivalent to the PortletSession.getAttributeMap() call, does not    */
      /* create a new session, only returns an existing session. If no        */
      /* session attributes exist this method returns an empty Map."          */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSACTION11);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsAction12                */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable PortletPreferences portletPreferences,          */
      /* providing access to the portlet preferences."                        */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSACTION12);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsAction13                */
      /* Details: "When included in the Action phase, the defineObjects tag   */
      /* defines the variable Map<String, String[]>                           */
      /* portletPreferencesValues, providing access to the portlet            */
      /* preferences as a Map, equivalent to the                              */
      /* PortletPreferences.getMap() call. If no portlet preferences exist,   */
      /* the Map is empty."                                                   */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSACTION13);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsEvent1                  */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable RenderRequest renderRequest to be null or       */
      /* undefined"                                                           */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSEVENT1);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsEvent2                  */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable ResourceRequest resourceRequest to be null or   */
      /* undefined"                                                           */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSEVENT2);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsEvent3                  */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable ActionRequest actionRequest to be null or       */
      /* undefined"                                                           */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSEVENT3);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsEvent4                  */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable EventRequest eventRequest to the                */
      /* corresponding object"                                                */
      TestResult tr16 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSEVENT4);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsEvent5                  */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable RenderResponse renderResponse to be null or     */
      /* undefined"                                                           */
      TestResult tr17 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSEVENT5);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsEvent6                  */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable ResourceResponse resourceResponse to be null    */
      /* or undefined"                                                        */
      TestResult tr18 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSEVENT6);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsEvent7                  */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable ActionResponse actionResponse to be null or     */
      /* undefined"                                                           */
      TestResult tr19 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSEVENT7);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsEvent8                  */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable EventResponse eventResponse to the              */
      /* corresponding object"                                                */
      TestResult tr20 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSEVENT8);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsEvent9                  */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable PortletConfig portletConfig"                    */
      TestResult tr21 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSEVENT9);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsEvent10                 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable PortletSession portletSession, providing        */
      /* access to the portletSession, does not create a new session, only    */
      /* returns an existing session or null if no session exists."           */
      TestResult tr22 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSEVENT10);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsEvent11                 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable Map<String, Object> portletSessionScope,        */
      /* providing access to the portletSession attributes as a Map           */
      /* equivalent to the PortletSession.getAttributeMap() call, does not    */
      /* create a new session, only returns an existing session. If no        */
      /* session attributes exist this method returns an empty Map."          */
      TestResult tr23 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSEVENT11);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsEvent12                 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable PortletPreferences portletPreferences,          */
      /* providing access to the portlet preferences."                        */
      TestResult tr24 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSEVENT12);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_defineObjectsEvent13                 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable Map<String, String[]>                           */
      /* portletPreferencesValues, providing access to the portlet            */
      /* preferences as a Map, equivalent to the                              */
      /* PortletPreferences.getMap() call. If no portlet preferences exist,   */
      /* the Map is empty."                                                   */
      TestResult tr25 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_DEFINEOBJECTSEVENT13);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL1                           */
      /* Details: "The portlet actionURL tag creates a URL that must point    */
      /* to the current portlet and must trigger an action request with the   */
      /* supplied parameters"                                                 */
      TestResult tr26 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL1);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL2                           */
      /* Details: "Parameters may be added to the URL by including the        */
      /* param tag between the actionURL start and end tags"                  */
      TestResult tr27 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL2);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL3                           */
      /* Details: "The optional actionURL \"windowState\" attribute can       */
      /* specify the desired window state after the URL is triggered"         */
      TestResult tr28 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL3);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL4                           */
      /* Details: "If the \"windowState\" attribute specifies an invalid      */
      /* value, a JspException with the PortletException that caused this     */
      /* error as root cause is thrown"                                       */
      TestResult tr29 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL4);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL5                           */
      /* Details: "The \"windowState\" attribute is not case sensitive"       */
      TestResult tr30 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL5);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL6                           */
      /* Details: "The \"windowState\" attribute is not specified, the        */
      /* current window state is retained when the URL is triggered"          */
      TestResult tr31 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL6);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL7                           */
      /* Details: "The optional actionURL \"portletMode\" attribute can       */
      /* specify the desired portlet mode after the URL is triggered"         */
      TestResult tr32 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL7);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL8                           */
      /* Details: "If the \"portletMode\" attribute specifies an invalid      */
      /* value, a JspException with the PortletException that caused this     */
      /* error as root cause is thrown"                                       */
      TestResult tr33 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL8);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL9                           */
      /* Details: "The \"portletMode\" attribute is not case sensitive"       */
      TestResult tr34 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL9);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL10                          */
      /* Details: "The \"portletMode\" attribute is not specified, the        */
      /* current portlet mode is retained when the URL is triggered"          */
      TestResult tr35 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL10);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL11                          */
      /* Details: "The optional actionURL \"var\" attribute can specify a     */
      /* scoped variable for exporting the action URL"                        */
      TestResult tr36 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL11);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL12                          */
      /* Details: "If the actionURL \"var\" attribute is specified, the URL   */
      /* is not written to the JspWriter"                                     */
      TestResult tr37 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL12);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL13                          */
      /* Details: "If the actionURL \"var\" attribute is not specified, the   */
      /* URL is written to the JspWriter"                                     */
      TestResult tr38 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL13);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL14                          */
      /* Details: "If the optional actionURL \"secure\" attribute is set to   */
      /* true, the resulting URL should require a secure connection"          */
      TestResult tr39 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL14);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL15                          */
      /* Details: "If the optional actionURL \"secure\" attribute is set to   */
      /* false, the resulting URL does not need to require a secure           */
      /* connection"                                                          */
      TestResult tr40 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL15);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL17                          */
      /* Details: "The \"secure\" attribute is not specified, the security    */
      /* setting is retained"                                                 */
      TestResult tr41 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL17);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL18                          */
      /* Details: "If the optional actionURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true, the        */
      /* current private render parameters are attached to the URL"           */
      TestResult tr42 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL18);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL19                          */
      /* Details: "If the optional actionURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the <portlet:param> element     */
      /* are merged with the render parameters"                               */
      TestResult tr43 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL19);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL20                          */
      /* Details: "If the optional actionURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the <portlet:param> element     */
      /* appear in the values array before the render parameter values if     */
      /* there is a name conflict"                                            */
      TestResult tr44 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL20);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL21                          */
      /* Details: "If the optional actionURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to false, the       */
      /* current render parameters are not attached to the URL"               */
      TestResult tr45 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL21);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL22                          */
      /* Details: "If the \"copyCurrentRenderParameters\" attribute           */
      /* specifies an invalid value, a JspException is thrown"                */
      TestResult tr46 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL22);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL23                          */
      /* Details: "The \"copyCurrentRenderParameters\" attribute is not       */
      /* specified, the security setting is retained"                         */
      TestResult tr47 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL23);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL25                          */
      /* Details: "If the optional actionURL \"escapeXML\" attribute is set   */
      /* to false, the characters \"<>&'\\\"\" are not converted to their     */
      /* entity codes"                                                        */
      TestResult tr48 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL25);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL26                          */
      /* Details: "The \"escapeXML\" attribute default value is true"         */
      TestResult tr49 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL26);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL27                          */
      /* Details: "If the optional actionURL \"name\" attribute is set, the   */
      /* provided name string is used by GenericPortlet to dispatch the       */
      /* request to the coresponding annotated method"                        */
      TestResult tr50 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL27);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL28                          */
      /* Details: "Setting the \"name\" attribute will add a parameter to     */
      /* the action URL with the name of \"javax.portlet.action\""            */
      TestResult tr51 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL28);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL29                          */
      /* Details: "If this tag is used in markup provided by a                */
      /* serveResource call that was directly or indirectly triggered via a   */
      /* resource URL of type FULL, a JspException with the                   */
      /* IllegalStateException that caused this error is thrown"              */
      TestResult tr52 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL29);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibAction_actionURL30                          */
      /* Details: "If this tag is used in markup provided by a                */
      /* serveResource call that was directly or indirectly triggered via a   */
      /* resource URL of type PORTLET, a JspException with the                */
      /* IllegalStateException that caused this error is thrown"              */
      TestResult tr53 = tcd.getTestResultFailed(SPEC2_26_TAGLIBACTION_ACTIONURL30);
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
      tr18.writeTo(writer);
      tr19.writeTo(writer);
      tr20.writeTo(writer);
      tr21.writeTo(writer);
      tr22.writeTo(writer);
      tr23.writeTo(writer);
      tr24.writeTo(writer);
      tr25.writeTo(writer);
      tr26.writeTo(writer);
      tr27.writeTo(writer);
      tr28.writeTo(writer);
      tr29.writeTo(writer);
      tr30.writeTo(writer);
      tr31.writeTo(writer);
      tr32.writeTo(writer);
      tr33.writeTo(writer);
      tr34.writeTo(writer);
      tr35.writeTo(writer);
      tr36.writeTo(writer);
      tr37.writeTo(writer);
      tr38.writeTo(writer);
      tr39.writeTo(writer);
      tr40.writeTo(writer);
      tr41.writeTo(writer);
      tr42.writeTo(writer);
      tr43.writeTo(writer);
      tr44.writeTo(writer);
      tr45.writeTo(writer);
      tr46.writeTo(writer);
      tr47.writeTo(writer);
      tr48.writeTo(writer);
      tr49.writeTo(writer);
      tr50.writeTo(writer);
      tr51.writeTo(writer);
      tr52.writeTo(writer);
      tr53.writeTo(writer);


   }

}

