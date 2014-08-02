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
public class PortletTagLibraryTests_SPEC2_26_TagLibRender implements Portlet {
   private static final String LOG_CLASS = 
         PortletTagLibraryTests_SPEC2_26_TagLibRender.class.getName();
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

      /* TestCase: SPEC2_26_TagLibRender_defineObjectsRender1                 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable RenderRequest renderRequest to the              */
      /* corresponding object"                                                */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_DEFINEOBJECTSRENDER1);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_defineObjectsRender2                 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable ResourceRequest resourceRequest to be null or   */
      /* undefined"                                                           */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_DEFINEOBJECTSRENDER2);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_defineObjectsRender3                 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable ActionRequest actionRequest to be null or       */
      /* undefined"                                                           */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_DEFINEOBJECTSRENDER3);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_defineObjectsRender4                 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable EventRequest eventRequest to be null or         */
      /* undefined"                                                           */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_DEFINEOBJECTSRENDER4);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_defineObjectsRender5                 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable RenderResponse renderResponse to the            */
      /* corresponding object"                                                */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_DEFINEOBJECTSRENDER5);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_defineObjectsRender6                 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable ResourceResponse resourceResponse to be null    */
      /* or undefined"                                                        */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_DEFINEOBJECTSRENDER6);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_defineObjectsRender7                 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable ActionResponse actionResponse to be null or     */
      /* undefined"                                                           */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_DEFINEOBJECTSRENDER7);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_defineObjectsRender8                 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable EventResponse eventResponse to be null or       */
      /* undefined"                                                           */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_DEFINEOBJECTSRENDER8);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_defineObjectsRender9                 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable PortletConfig portletConfig"                    */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_DEFINEOBJECTSRENDER9);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_defineObjectsRender10                */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable PortletSession portletSession, providing        */
      /* access to the portletSession, does not create a new session, only    */
      /* returns an existing session or null if no session exists."           */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_DEFINEOBJECTSRENDER10);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_defineObjectsRender11                */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable Map<String, Object> portletSessionScope,        */
      /* providing access to the portletSession attributes as a Map           */
      /* equivalent to the PortletSession.getAttributeMap() call, does not    */
      /* create a new session, only returns an existing session. If no        */
      /* session attributes exist this method returns an empty Map."          */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_DEFINEOBJECTSRENDER11);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_defineObjectsRender12                */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable PortletPreferences portletPreferences,          */
      /* providing access to the portlet preferences."                        */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_DEFINEOBJECTSRENDER12);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_defineObjectsRender13                */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable Map<String, String[]>                           */
      /* portletPreferencesValues, providing access to the portlet            */
      /* preferences as a Map, equivalent to the                              */
      /* PortletPreferences.getMap() call. If no portlet preferences exist,   */
      /* the Map is empty."                                                   */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_DEFINEOBJECTSRENDER13);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL1                           */
      /* Details: "The portlet renderURL tag creates a URL that must point    */
      /* to the current portlet and must trigger an render request with the   */
      /* supplied parameters"                                                 */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL1);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL2                           */
      /* Details: "Parameters may be added to the URL by including the        */
      /* param tag between the renderURL start and end tags"                  */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL2);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL3                           */
      /* Details: "The optional renderURL \"windowState\" attribute can       */
      /* specify the desired window state after the URL is triggered"         */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL3);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL4                           */
      /* Details: "If the \"windowState\" attribute specifies an invalid      */
      /* value, a JspException with the PortletException that caused this     */
      /* error as root cause is thrown"                                       */
      TestResult tr16 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL4);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL5                           */
      /* Details: "The \"windowState\" attribute is not case sensitive"       */
      TestResult tr17 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL5);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL6                           */
      /* Details: "The \"windowState\" attribute is not specified, the        */
      /* current window state is retained when the URL is triggered"          */
      TestResult tr18 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL6);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL7                           */
      /* Details: "The optional renderURL \"portletMode\" attribute can       */
      /* specify the desired portlet mode after the URL is triggered"         */
      TestResult tr19 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL7);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL8                           */
      /* Details: "If the \"portletMode\" attribute specifies an invalid      */
      /* value, a JspException with the PortletException that caused this     */
      /* error as root cause is thrown"                                       */
      TestResult tr20 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL8);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL9                           */
      /* Details: "The \"portletMode\" attribute is not case sensitive"       */
      TestResult tr21 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL9);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL10                          */
      /* Details: "The \"portletMode\" attribute is not specified, the        */
      /* current portlet mode is retained when the URL is triggered"          */
      TestResult tr22 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL10);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL11                          */
      /* Details: "The optional renderURL \"var\" attribute can specify a     */
      /* scoped variable for exporting the action URL"                        */
      TestResult tr23 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL11);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL12                          */
      /* Details: "If the renderURL \"var\" attribute is specified, the URL   */
      /* is not written to the JspWriter"                                     */
      TestResult tr24 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL12);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL13                          */
      /* Details: "If the renderURL \"var\" attribute is not specified, the   */
      /* URL is written to the JspWriter"                                     */
      TestResult tr25 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL13);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL14                          */
      /* Details: "If the optional renderURL \"secure\" attribute is set to   */
      /* true, the resulting URL should require a secure connection"          */
      TestResult tr26 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL14);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL15                          */
      /* Details: "If the optional renderURL \"secure\" attribute is set to   */
      /* false, the resulting URL does not need to require a secure           */
      /* connection"                                                          */
      TestResult tr27 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL15);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL17                          */
      /* Details: "The \"secure\" attribute is not specified, the security    */
      /* setting is retained"                                                 */
      TestResult tr28 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL17);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL18                          */
      /* Details: "If the optional renderURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true, the        */
      /* current private render parameters are attached to the URL"           */
      TestResult tr29 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL18);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL19                          */
      /* Details: "If the optional renderURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the <portlet:param> element     */
      /* are merged with the render parameters"                               */
      TestResult tr30 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL19);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL20                          */
      /* Details: "If the optional renderURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the <portlet:param> element     */
      /* appear in the values array before the render parameter values if     */
      /* there is a name conflict"                                            */
      TestResult tr31 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL20);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL21                          */
      /* Details: "If the optional renderURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to false, the       */
      /* current render parameters are not attached to the URL"               */
      TestResult tr32 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL21);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL22                          */
      /* Details: "If the \"copyCurrentRenderParameters\" attribute           */
      /* specifies an invalid value, a JspException is thrown"                */
      TestResult tr33 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL22);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL23                          */
      /* Details: "The \"copyCurrentRenderParameters\" attribute is not       */
      /* specified, the security setting is retained"                         */
      TestResult tr34 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL23);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL25                          */
      /* Details: "If the optional renderURL \"escapeXML\" attribute is set   */
      /* to false, the characters \"<>&'\\\"\" are not converted to their     */
      /* entity codes"                                                        */
      TestResult tr35 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL25);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibRender_renderURL26                          */
      /* Details: "The \"escapeXML\" attribute default value is true"         */
      TestResult tr36 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRENDER_RENDERURL26);
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


   }

}

