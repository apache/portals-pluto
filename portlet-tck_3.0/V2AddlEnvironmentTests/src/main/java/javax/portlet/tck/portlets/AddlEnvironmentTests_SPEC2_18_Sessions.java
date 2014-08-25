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
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet AddlEnvironmentTests_SPEC2_18_Sessions_event
 *
 */
public class AddlEnvironmentTests_SPEC2_18_Sessions implements Portlet, ResourceServingPortlet {
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
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_scope1            */
      /* Details: "PortletSession objects must be scoped at the portlet       */
      /* application context level"                                           */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_scope2            */
      /* Details: "The portlet container must not share the PortletSession    */
      /* object or the attributes stored in it among different portlet        */
      /* applications or among different user sessions"                       */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_scope3            */
      /* Details: "Any object stored in the session using the                 */
      /* APPLICATION_SCOPE is available to any portlet that belongs to the    */
      /* same portlet application and that handles a request in the same      */
      /* session"                                                             */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_scope4            */
      /* Details: "Any Object stored in the session using the PORTLET_SCOPE   */
      /* must be available to the portlet during requests for the same        */
      /* portlet window that stored the object"                               */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_scope5            */
      /* Details: "The PORTLET_SCOPE object must be stored in the             */
      /* APPLICATION_SCOPE with the attribute name                            */
      /* 'javax.portlet.p.&lt;ID&gt;?&lt;ATTRIBUTE_NAME&gt;', where           */
      /* &lt;ID&gt; must be equal to the ID returned by the                   */
      /* PortletRequest.getWindowID()"                                        */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE5);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_setAttribute1     */
      /* Details: "The setAttribute method can bind an object to the          */
      /* session in PORTLET_SCOPE"                                            */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETATTRIBUTE1);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_setAttribute2     */
      /* Details: "The setAttribute method that does not take a scope         */
      /* parameter binds an object to the session in PORTLET_SCOPE"           */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETATTRIBUTE2);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_setAttribute3     */
      /* Details: "The setAttribute method can bind an object to the          */
      /* session in APPLICATION_SCOPE"                                        */
      TestResult tr7 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETATTRIBUTE3);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttribute1     */
      /* Details: "The getAttribute method is used to retrieve attributes     */
      /* stored in the session in PORTLET_SCOPE"                              */
      TestResult tr8 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTE1);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttribute2     */
      /* Details: "The getAttribute method that does not take a scope         */
      /* parameter retrieves attributes stored in the session in              */
      /* PORTLET_SCOPE"                                                       */
      TestResult tr9 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTE2);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttribute3     */
      /* Details: "The getAttribute method is used to retrieve attributes     */
      /* stored in the session in APPLICATION_SCOPE"                          */
      TestResult tr10 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTE3);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_removeAttribute1  */
      /* Details: "The removeAttribute method is used to remove attributes    */
      /* stored in the session in PORTLET_SCOPE"                              */
      TestResult tr11 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_REMOVEATTRIBUTE1);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_removeAttribute2  */
      /* Details: "The removeAttribute method that does not take a scope      */
      /* parameter remove attributes stored in the session in                 */
      /* PORTLET_SCOPE"                                                       */
      TestResult tr12 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_REMOVEATTRIBUTE2);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_removeAttribute3  */
      /* Details: "The removeAttribute method is used to remove attributes    */
      /* stored in the session in APPLICATION_SCOPE"                          */
      TestResult tr13 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_REMOVEATTRIBUTE3);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttributeNames1 */
      /* Details: "The getAttributeNames method can retrieve an               */
      /* Enumeration&lt;String&gt; of all attribute names stored in the       */
      /* session in PORTLET_SCOPE"                                            */
      TestResult tr14 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTENAMES1);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttributeNames2 */
      /* Details: "The getAttributeNames method that does not take a scope    */
      /* parameter retrieves an Enumeration&lt;String&gt; of all attribute    */
      /* names stored in the session in PORTLET_SCOPE"                        */
      TestResult tr15 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTENAMES2);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttributeNames3 */
      /* Details: "The getAttributeNames method can retrieve an               */
      /* Enumeration&lt;String&gt; of all attribute names stored in the       */
      /* session in APPLICATION_SCOPE"                                        */
      TestResult tr16 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTENAMES3);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_decodeAttributeName1 */
      /* Details: "The PortletSessionUtil.decodeAttributeName method          */
      /* returns the attribute name without the prefix for an attribute       */
      /* name retrieved from the HttpSession"                                 */
      TestResult tr17 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_DECODEATTRIBUTENAME1);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_decodeAttributeName2 */
      /* Details: "The PortletSessionUtil.decodeAttributeName method          */
      /* returns the attribute name without the prefix for an attribute       */
      /* name retrieved from the PortletSession in APPLICATION_SCOPE"         */
      TestResult tr18 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_DECODEATTRIBUTENAME2);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession1      */
      /* Details: "Data stored in the HttpSession by a servlet in the same    */
      /* web application is accessible to portlets through the                */
      /* PortletSession in APPLICATION_SCOPE"                                 */
      TestResult tr19 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION1);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession2      */
      /* Details: "Data stored in the HttpSession by a JSP in the same web    */
      /* application is accessible to portlets through the PortletSession     */
      /* in APPLICATION_SCOPE"                                                */
      TestResult tr20 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION2);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession3      */
      /* Details: "Data stored by portlets in the PortletSession is           */
      /* accessible to servlets and JSPs through the HttpSession"             */
      TestResult tr21 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION3);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession4      */
      /* Details: "If the HttpSession object is invalidated, the              */
      /* PortletSession object must also be invalidated by the portlet        */
      /* container"                                                           */
      TestResult tr22 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION4);
      /* TODO: implement test */
      tr22.appendTcDetail("Not implemented.");
      tr22.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession5      */
      /* Details: "If the PortletSession object is invalidated by a           */
      /* portlet, the portlet container must invalidate the associated        */
      /* HttpSession object"                                                  */
      TestResult tr23 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION5);
      /* TODO: implement test */
      tr23.appendTcDetail("Not implemented.");
      tr23.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession6      */
      /* Details: "The attribute names retrieved from the HttpSession must    */
      /* be the same as those retrieve from the PortletSession if             */
      /* APPLICATION_SCOPE scope is used"                                     */
      TestResult tr24 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION6);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession7      */
      /* Details: "The attribute names retrieved from the HttpSession must    */
      /* have the speficied prefixing if PORTLET_SCOPE scope is used"         */
      TestResult tr25 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION7);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession8      */
      /* Details: "The portlet session follows the timeout behavior of the    */
      /* servlet session"                                                     */
      TestResult tr26 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION8);
      /* TODO: implement test */
      tr26.appendTcDetail("Not implemented.");
      tr26.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession9      */
      /* Details: "The portlet session follows the last accessed times        */
      /* behavior of the servlet session"                                     */
      TestResult tr27 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION9);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession11     */
      /* Details: "The portlet session follows the same semantic              */
      /* considerations as the servlet session"                               */
      TestResult tr28 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION11);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getCreationTime   */
      /* Details: "The PortletSession.getCreationTime method provides the     */
      /* same functionality as the corresponding                              */
      /* HttpSession.getCreationTime method"                                  */
      TestResult tr29 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETCREATIONTIME);
      /* TODO: implement test */
      tr29.appendTcDetail("Not implemented.");
      tr29.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getId             */
      /* Details: "The PortletSession.getId method provides the same          */
      /* functionality as the corresponding HttpSession.getId method"         */
      TestResult tr30 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETID);
      /* TODO: implement test */
      tr30.appendTcDetail("Not implemented.");
      tr30.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getLastAccessTime */
      /* Details: "The PortletSession.getLastAccessTime method provides the   */
      /* same functionality as the corresponding                              */
      /* HttpSession.getLastAccessTime method"                                */
      TestResult tr31 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETLASTACCESSTIME);
      /* TODO: implement test */
      tr31.appendTcDetail("Not implemented.");
      tr31.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getMaxInctiveInterval */
      /* Details: "The PortletSession.getMaxInctiveInterval method provides   */
      /* the same functionality as the corresponding                          */
      /* HttpSession.getMaxInctiveInterval method"                            */
      TestResult tr32 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETMAXINCTIVEINTERVAL);
      /* TODO: implement test */
      tr32.appendTcDetail("Not implemented.");
      tr32.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_invalidate        */
      /* Details: "The PortletSession.invalidate method provides the same     */
      /* functionality as the corresponding HttpSession.invalidate method"    */
      TestResult tr33 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_INVALIDATE);
      /* TODO: implement test */
      tr33.appendTcDetail("Not implemented.");
      tr33.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_isNew             */
      /* Details: "The PortletSession.isNew method provides the same          */
      /* functionality as the corresponding HttpSession.isNew method"         */
      TestResult tr34 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_ISNEW);
      /* TODO: implement test */
      tr34.appendTcDetail("Not implemented.");
      tr34.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_setMaxInactiveInterval */
      /* Details: "The PortletSession.setMaxInactiveInterval method           */
      /* provides the same functionality as the corresponding                 */
      /* HttpSession.setMaxInactiveInterval method"                           */
      TestResult tr35 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETMAXINACTIVEINTERVAL);
      /* TODO: implement test */
      tr35.appendTcDetail("Not implemented.");
      tr35.writeTo(writer);

   }

}
