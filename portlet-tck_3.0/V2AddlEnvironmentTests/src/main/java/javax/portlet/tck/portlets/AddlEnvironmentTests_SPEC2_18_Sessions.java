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
public class AddlEnvironmentTests_SPEC2_18_Sessions implements Portlet {
   private static final String LOG_CLASS = 
         AddlEnvironmentTests_SPEC2_18_Sessions.class.getName();
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

      /* TestCase: SPEC2_18_Sessions_scope1                                   */
      /* Details: "PortletSession objects must be scoped at the portlet       */
      /* application context level"                                           */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_SCOPE1);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_scope2                                   */
      /* Details: "The portlet container must not share the PortletSession    */
      /* object or the attributes stored in it among different portlet        */
      /* applications or among different user sessions"                       */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_SCOPE2);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_scope3                                   */
      /* Details: "Any object stored in the session using the                 */
      /* APPLICATION_SCOPE is available to any portlet that belongs to the    */
      /* same portlet application and that handles a request in the same      */
      /* session"                                                             */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_SCOPE3);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_scope4                                   */
      /* Details: "Any Object stored in the session using the PORTLET_SCOPE   */
      /* must be available to the portlet during requests for the same        */
      /* portlet window that stored the object"                               */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_SCOPE4);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_scope5                                   */
      /* Details: "The PORTLET_SCOPE object must be stored in the             */
      /* APPLICATION_SCOPE with the attribute name                            */
      /* 'javax.portlet.p.<ID>?<ATTRIBUTE_NAME>', where <ID> must be equal    */
      /* to the ID returned by the PortletRequest.getWindowID()"              */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_SCOPE5);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_setAttribute1                            */
      /* Details: "The setAttribute method can bind an object to the          */
      /* session in PORTLET_SCOPE"                                            */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_SETATTRIBUTE1);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_setAttribute2                            */
      /* Details: "The setAttribute method that does not take a scope         */
      /* parameter binds an object to the session in PORTLET_SCOPE"           */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_SETATTRIBUTE2);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_setAttribute3                            */
      /* Details: "The setAttribute method can bind an object to the          */
      /* session in APPLICATION_SCOPE"                                        */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_SETATTRIBUTE3);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_getAttribute1                            */
      /* Details: "The getAttribute method is used to retrieve attributes     */
      /* stored in the session in PORTLET_SCOPE"                              */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_GETATTRIBUTE1);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_getAttribute2                            */
      /* Details: "The getAttribute method that does not take a scope         */
      /* parameter retrieves attributes stored in the session in              */
      /* PORTLET_SCOPE"                                                       */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_GETATTRIBUTE2);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_getAttribute3                            */
      /* Details: "The getAttribute method is used to retrieve attributes     */
      /* stored in the session in APPLICATION_SCOPE"                          */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_GETATTRIBUTE3);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_removeAttribute1                         */
      /* Details: "The removeAttribute method is used to remove attributes    */
      /* stored in the session in PORTLET_SCOPE"                              */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_REMOVEATTRIBUTE1);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_removeAttribute2                         */
      /* Details: "The removeAttribute method that does not take a scope      */
      /* parameter remove attributes stored in the session in                 */
      /* PORTLET_SCOPE"                                                       */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_REMOVEATTRIBUTE2);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_removeAttribute3                         */
      /* Details: "The removeAttribute method is used to remove attributes    */
      /* stored in the session in APPLICATION_SCOPE"                          */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_REMOVEATTRIBUTE3);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_getAttributeNames1                       */
      /* Details: "The getAttributeNames method can retrieve an               */
      /* Enumeration<String> of all attribute names stored in the session     */
      /* in PORTLET_SCOPE"                                                    */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_GETATTRIBUTENAMES1);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_getAttributeNames2                       */
      /* Details: "The getAttributeNames method that does not take a scope    */
      /* parameter retrieves an Enumeration<String> of all attribute names    */
      /* stored in the session in PORTLET_SCOPE"                              */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_GETATTRIBUTENAMES2);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_getAttributeNames3                       */
      /* Details: "The getAttributeNames method can retrieve an               */
      /* Enumeration<String> of all attribute names stored in the session     */
      /* in APPLICATION_SCOPE"                                                */
      TestResult tr16 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_GETATTRIBUTENAMES3);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_decodeAttributeName1                     */
      /* Details: "The PortletSessionUtil.decodeAttributeName method          */
      /* returns the attribute name without the prefix for an attribute       */
      /* name retrieved from the HTTPSession"                                 */
      TestResult tr17 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_DECODEATTRIBUTENAME1);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_decodeAttributeName2                     */
      /* Details: "The PortletSessionUtil.decodeAttributeName method          */
      /* returns the attribute name without the prefix for an attribute       */
      /* name retrieved from the PortletSession in APPLICATION_SCOPE"         */
      TestResult tr18 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_DECODEATTRIBUTENAME2);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession1                             */
      /* Details: "Data stored in the HttpSession by a servlet in the same    */
      /* web application is accessible to portlets through the                */
      /* PortletSession in APPLICATION_SCOPE"                                 */
      TestResult tr19 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION1);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession2                             */
      /* Details: "Data stored in the HttpSession by a JSP in the same web    */
      /* application is accessible to portlets through the PortletSession     */
      /* in APPLICATION_SCOPE"                                                */
      TestResult tr20 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION2);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession3                             */
      /* Details: "Data stored by portlets in the PortletSession is           */
      /* accessible to servlets and JSPs through the HttpSession"             */
      TestResult tr21 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION3);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession4                             */
      /* Details: "If the HttpSession object is invalidated, the              */
      /* PortletSession object must also be invalidated by the portlet        */
      /* container"                                                           */
      TestResult tr22 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION4);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession5                             */
      /* Details: "If the PortletSession object is invalidated by a           */
      /* portlet, the portlet container must invalidate the associated        */
      /* HttpSession object"                                                  */
      TestResult tr23 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION5);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession6                             */
      /* Details: "The attribute names retrieved from the HTTPSession must    */
      /* be the same as those retrieve from the PortletSession if             */
      /* APPLICATION_SCOPE scope is used"                                     */
      TestResult tr24 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION6);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession7                             */
      /* Details: "The attribute names retrieved from the HTTPSession must    */
      /* have the speficied prefixing if PORTLET_SCOPE scope is used"         */
      TestResult tr25 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION7);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession8                             */
      /* Details: "The portlet session follows the timeout behavior of the    */
      /* servlet session"                                                     */
      TestResult tr26 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION8);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession9                             */
      /* Details: "The portlet session follows the last accessed times        */
      /* behavior of the servlet session"                                     */
      TestResult tr27 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION9);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession11                            */
      /* Details: "The portlet session follows the same semantic              */
      /* considerations as the servlet session"                               */
      TestResult tr28 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION11);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession12                            */
      /* Details: "The PortletSession getCreationTime method provides the     */
      /* same functionality as the corresponding HTTPSession method"          */
      TestResult tr29 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION12);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession13                            */
      /* Details: "The PortletSession getId method provides the same          */
      /* functionality as the corresponding HTTPSession method"               */
      TestResult tr30 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION13);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession14                            */
      /* Details: "The PortletSession getLastAccessTime method provides the   */
      /* same functionality as the corresponding HTTPSession method"          */
      TestResult tr31 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION14);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession15                            */
      /* Details: "The PortletSession getMaxInctiveInterval method provides   */
      /* the same functionality as the corresponding HTTPSession method"      */
      TestResult tr32 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION15);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession16                            */
      /* Details: "The PortletSession invalidate method provides the same     */
      /* functionality as the corresponding HTTPSession method"               */
      TestResult tr33 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION16);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession17                            */
      /* Details: "The PortletSession isNew method provides the same          */
      /* functionality as the corresponding HTTPSession method"               */
      TestResult tr34 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION17);
      /* TODO: implement test */

      /* TestCase: SPEC2_18_Sessions_httpSession18                            */
      /* Details: "The PortletSession setMaxInactiveInterval method           */
      /* provides the same functionality as the corresponding HTTPSession     */
      /* method"                                                              */
      TestResult tr35 = tcd.getTestResultFailed(SPEC2_18_SESSIONS_HTTPSESSION18);
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


   }

}

