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
public class PortletTagLibraryTests_SPEC2_26_TagLibResource implements Portlet {
   private static final String LOG_CLASS = 
         PortletTagLibraryTests_SPEC2_26_TagLibResource.class.getName();
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

      /* TestCase: SPEC2_26_TagLibResource_defineObjectsResource1             */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable RenderRequest renderRequest to be null or   */
      /* undefined"                                                           */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_DEFINEOBJECTSRESOURCE1);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_defineObjectsResource2             */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable ResourceRequest resourceRequest to the      */
      /* corresponding object"                                                */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_DEFINEOBJECTSRESOURCE2);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_defineObjectsResource3             */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable ActionRequest actionRequest to be null or   */
      /* undefined"                                                           */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_DEFINEOBJECTSRESOURCE3);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_defineObjectsResource4             */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable EventRequest eventRequest to be null or     */
      /* undefined"                                                           */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_DEFINEOBJECTSRESOURCE4);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_defineObjectsResource5             */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable RenderResponse renderResponse to be null    */
      /* or undefined"                                                        */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_DEFINEOBJECTSRESOURCE5);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_defineObjectsResource6             */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable ResourceResponse resourceResponse to the    */
      /* corresponding object"                                                */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_DEFINEOBJECTSRESOURCE6);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_defineObjectsResource7             */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable ActionResponse actionResponse to be null    */
      /* or undefined"                                                        */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_DEFINEOBJECTSRESOURCE7);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_defineObjectsResource8             */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable EventResponse eventResponse to be null or   */
      /* undefined"                                                           */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_DEFINEOBJECTSRESOURCE8);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_defineObjectsResource9             */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable PortletConfig portletConfig"                */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_DEFINEOBJECTSRESOURCE9);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_defineObjectsResource10            */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable PortletSession portletSession, providing    */
      /* access to the portletSession, does not create a new session, only    */
      /* returns an existing session or null if no session exists."           */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_DEFINEOBJECTSRESOURCE10);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_defineObjectsResource11            */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable Map<String, Object> portletSessionScope,    */
      /* providing access to the portletSession attributes as a Map           */
      /* equivalent to the PortletSession.getAttributeMap() call, does not    */
      /* create a new session, only returns an existing session. If no        */
      /* session attributes exist this method returns an empty Map."          */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_DEFINEOBJECTSRESOURCE11);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_defineObjectsResource12            */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable PortletPreferences portletPreferences,      */
      /* providing access to the portlet preferences."                        */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_DEFINEOBJECTSRESOURCE12);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_defineObjectsResource13            */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable Map<String, String[]>                       */
      /* portletPreferencesValues, providing access to the portlet            */
      /* preferences as a Map, equivalent to the                              */
      /* PortletPreferences.getMap() call. If no portlet preferences exist,   */
      /* the Map is empty."                                                   */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_DEFINEOBJECTSRESOURCE13);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL1                       */
      /* Details: "The portlet resourceURL tag creates a URL that must        */
      /* point to the current portlet and must trigger an resource request    */
      /* with the supplied parameters"                                        */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL1);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL2                       */
      /* Details: "The resourceURL must preserve the current portlet mode,    */
      /* window state and render parameters"                                  */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL2);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL3                       */
      /* Details: "Resource parameters may be added to the URL by including   */
      /* the param tag between the resourceURL start and end tags"            */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL3);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL4                       */
      /* Details: "The resource parameters specified with the                 */
      /* <portlet:param> element appear in the values array before the        */
      /* render parameter values if there is a name conflict"                 */
      TestResult tr16 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL4);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL5                       */
      /* Details: "The optional resourceURL \"var\" attribute can specify a   */
      /* scoped variable for exporting the action URL"                        */
      TestResult tr17 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL5);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL6                       */
      /* Details: "If the resourceURL \"var\" attribute is specified, the     */
      /* URL is not written to the JspWriter"                                 */
      TestResult tr18 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL6);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL7                       */
      /* Details: "If the resourceURL \"var\" attribute is not specified,     */
      /* the URL is written to the JspWriter"                                 */
      TestResult tr19 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL7);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL8                       */
      /* Details: "If the optional resourceURL \"secure\" attribute is set    */
      /* to true, the resulting URL should require a secure connection"       */
      TestResult tr20 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL8);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL9                       */
      /* Details: "If the optional resourceURL \"secure\" attribute is set    */
      /* to false, the resulting URL does not need to require a secure        */
      /* connection"                                                          */
      TestResult tr21 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL9);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL11                      */
      /* Details: "The \"secure\" attribute is not specified, the security    */
      /* setting is retained"                                                 */
      TestResult tr22 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL11);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL12                      */
      /* Details: "If the optional resourceURL                                */
      /* \"copyCurrentRenderParameters\" attribute is set to true, the        */
      /* current private render parameters are attached to the URL"           */
      TestResult tr23 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL12);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL13                      */
      /* Details: "If the optional resourceURL                                */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the <portlet:param> element     */
      /* are merged with the render parameters"                               */
      TestResult tr24 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL13);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL14                      */
      /* Details: "If the optional resourceURL                                */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the <portlet:param> element     */
      /* appear in the values array before the render parameter values if     */
      /* there is a name conflict"                                            */
      TestResult tr25 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL14);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL15                      */
      /* Details: "If the optional resourceURL                                */
      /* \"copyCurrentRenderParameters\" attribute is set to false, the       */
      /* current render parameters are not attached to the URL"               */
      TestResult tr26 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL15);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL16                      */
      /* Details: "If the \"copyCurrentRenderParameters\" attribute           */
      /* specifies an invalid value, a JspException is thrown"                */
      TestResult tr27 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL16);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL17                      */
      /* Details: "The \"copyCurrentRenderParameters\" attribute is not       */
      /* specified, the security setting is retained"                         */
      TestResult tr28 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL17);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL19                      */
      /* Details: "If the optional resourceURL \"escapeXML\" attribute is     */
      /* set to false, the characters \"<>&'\\\"\" are not converted to       */
      /* their entity codes"                                                  */
      TestResult tr29 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL19);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL20                      */
      /* Details: "The \"escapeXML\" attribute default value is true"         */
      TestResult tr30 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL20);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL21                      */
      /* Details: "If the optional resourceURL \"id\" attribute is set, the   */
      /* provided id string is used by GenericPortlet to dispatch the         */
      /* request to the coresponding annotated method"                        */
      TestResult tr31 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL21);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL22                      */
      /* Details: "Setting the \"id\" attribute will add a parameter to the   */
      /* action URL with the id of \"javax.portlet.action\""                  */
      TestResult tr32 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL22);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL23                      */
      /* Details: "If the optional resourceURL \"cacheability\" attribute     */
      /* is set, the cacheability is set accordingly"                         */
      TestResult tr33 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL23);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL24                      */
      /* Details: "If the optional resourceURL \"cacheability\" attribute     */
      /* is not set, the current cacheability setting is retained"            */
      TestResult tr34 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL24);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL25                      */
      /* Details: "If the cacheability is set to PAGE in a Resource phase     */
      /* include with cacheability = FULL, a JspException with the            */
      /* IllegalStateException that caused this error is thrown"              */
      TestResult tr35 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL25);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL26                      */
      /* Details: "If the cacheability is set to PORTLET in a Resource        */
      /* phase include with cacheability = FULL, a JspException with the      */
      /* IllegalStateException that caused this error is thrown"              */
      TestResult tr36 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL26);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibResource_resourceURL27                      */
      /* Details: "If the cacheability is set to PAGE in a Resource phase     */
      /* include with cacheability = PORTLET, a JspException with the         */
      /* IllegalStateException that caused this error is thrown"              */
      TestResult tr37 = tcd.getTestResultFailed(SPEC2_26_TAGLIBRESOURCE_RESOURCEURL27);
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


   }

}

