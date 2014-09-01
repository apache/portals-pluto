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
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
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
 * portlet EnvironmentTests_PortletSession_ApiRender_event
 *
 */
public class EnvironmentTests_PortletSession_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         EnvironmentTests_PortletSession_ApiRender.class.getName();
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

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletReq.getPortletSession().getClass());

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_fieldAPPLICATION_SCOPE */
      /* Details: "Has int field APPLICATION_SCOPE with value of 0x01 "       */
      TestResult tr0 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_FIELDAPPLICATION_SCOPE);
      try {
         tr0.setTcSuccess(cc.hasField("APPLICATION_SCOPE", 0x01));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_fieldPORTLET_SCOPE */
      /* Details: "Has int field PORTLET_SCOPE with value of 0x02 "           */
      TestResult tr1 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_FIELDPORTLET_SCOPE);
      try {
         tr1.setTcSuccess(cc.hasField("PORTLET_SCOPE", 0x02));
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeA1 */
      /* Details: "Method getAttribute(String): Returns a java.lang.Object    */
      /* for the specified attribute name in the PORTLET_SCOPE"               */
      TestResult tr2 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA1);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeA2 */
      /* Details: "Method getAttribute(String): Returns null if no            */
      /* attribute with the specified name exists in the PORTLET_SCOPE"       */
      TestResult tr3 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA2);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeA3 */
      /* Details: "Method getAttribute(String): Throws                        */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr4 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA3);
      try {
         try {
            PortletSession sess = portletReq.getPortletSession();
            Object val = sess.getAttribute(null);
            tr4.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr4.setTcSuccess(true);
         } catch (Exception e) {
            tr4.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeA4 */
      /* Details: "Method getAttribute(String): Throws                        */
      /* IllegalStateException if the method is called on an invalidated      */
      /* session"                                                             */
      TestResult tr5 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA4);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeB1 */
      /* Details: "Method getAttribute(String): Returns a java.lang.Object    */
      /* for the specified attribute name in the specified scope"             */
      TestResult tr6 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB1);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeB2 */
      /* Details: "Method getAttribute(String): Returns null if no            */
      /* attribute with the specified name exists in the specified scope"     */
      TestResult tr7 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB2);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeB3 */
      /* Details: "Method getAttribute(String): Throws                        */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr8 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB3);
      try {
         try {
            PortletSession sess = portletReq.getPortletSession();
            Object val = sess.getAttribute(null);
            tr8.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr8.setTcSuccess(true);
         } catch (Exception e) {
            tr8.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeB4 */
      /* Details: "Method getAttribute(String): Throws                        */
      /* IllegalStateException if the method is called on an invalidated      */
      /* session"                                                             */
      TestResult tr9 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB4);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeNamesA1 */
      /* Details: "Method getAttributeNames(): Returns a                      */
      /* java.util.Enumeration&lt;java.lang.String&gt; of the available       */
      /* attribute names in the PORTLET_SCOPE"                                */
      TestResult tr10 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESA1);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeNamesA2 */
      /* Details: "Method getAttributeNames(): Returns an empty Enumeration   */
      /* if there are no attributes available in the PORTLET_SCOPE"           */
      TestResult tr11 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESA2);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeNamesB1 */
      /* Details: "Method getAttributeNames(int): Returns a                   */
      /* java.util.Enumeration&lt;java.lang.String&gt; of the available       */
      /* attribute names in the specified scope"                              */
      TestResult tr12 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESB1);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeNamesB2 */
      /* Details: "Method getAttributeNames(int): Returns an empty            */
      /* Enumeration if there are no attributes available in the specified    */
      /* scope"                                                               */
      TestResult tr13 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESB2);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getCreationTime1 */
      /* Details: "Method getCreationTime(): Returns a long containing the    */
      /* time the session was created in milliseconds since 1/1/1970  "       */
      TestResult tr14 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETCREATIONTIME1);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getCreationTime2 */
      /* Details: "Method getCreationTime(): Throws IllegalStateException     */
      /* if this method is called on an invalidated session"                  */
      TestResult tr15 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETCREATIONTIME2);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getId          */
      /* Details: "Method getId(): Returns a String containing a unique       */
      /* identifier for the session"                                          */
      TestResult tr16 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETID);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getLastAccessedTime */
      /* Details: "Method getLastAccessedTime(): Returns a long containing    */
      /* the last time the session was accessed in milliseconds since         */
      /* 1/1/1970"                                                            */
      TestResult tr17 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETLASTACCESSEDTIME);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getMaxInactiveInterval */
      /* Details: "Method getMaxInactiveInterval(): Returns the maximum       */
      /* time interval, in seconds, for which the portlet container keeps     */
      /* this session open between client accesses"                           */
      TestResult tr18 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETMAXINACTIVEINTERVAL);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_invalidate1    */
      /* Details: "Method invalidate(): Invalidates this session (all         */
      /* scopes): and unbinds any objects bound to it"                        */
      TestResult tr19 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_INVALIDATE1);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_invalidate2    */
      /* Details: "Method invalidate(): The underlying HTTP session is also   */
      /* invalidated"                                                         */
      TestResult tr20 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_INVALIDATE2);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_isNew1         */
      /* Details: "Method isNew(): Returns true if the client has not yet     */
      /* joined the session"                                                  */
      TestResult tr21 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_ISNEW1);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_isNew2         */
      /* Details: "Method isNew(): Returns false if the client has joined     */
      /* the session"                                                         */
      TestResult tr22 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_ISNEW2);
      /* TODO: implement test */
      tr22.appendTcDetail("Not implemented.");
      tr22.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeA1 */
      /* Details: "Method removeAttribute(String): Removes the attribute      */
      /* specified by the name from the PORTLET_SCOPE"                        */
      TestResult tr23 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA1);
      /* TODO: implement test */
      tr23.appendTcDetail("Not implemented.");
      tr23.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeA2 */
      /* Details: "Method removeAttribute(String): If there is no attribute   */
      /* by the specified name in the the PORTLET_SCOPE, this method does     */
      /* nothing"                                                             */
      TestResult tr24 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA2);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeA3 */
      /* Details: "Method removeAttribute(String): If an attribute was        */
      /* removed, the HttpSessionAttributeListener.attributeRemoved method    */
      /* is called on all HttpSessionAttributeListeners in the web            */
      /* application"                                                         */
      TestResult tr25 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA3);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeA4 */
      /* Details: "Method removeAttribute(String): Throws                     */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr26 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA4);
      try {
         try {
            PortletSession sess = portletReq.getPortletSession();
            sess.removeAttribute(null);
            tr26.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr26.setTcSuccess(true);
         } catch (Exception e) {
            tr26.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr26.appendTcDetail(e.toString());}
      tr26.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeB1 */
      /* Details: "Method removeAttribute(String, int): Removes the           */
      /* attribute specified by the name from the specified scope"            */
      TestResult tr27 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB1);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeB2 */
      /* Details: "Method removeAttribute(String, int): If there is no        */
      /* attribute by the specified name in the specified scope, this         */
      /* method does nothing"                                                 */
      TestResult tr28 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB2);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeB3 */
      /* Details: "Method removeAttribute(String, int): If an attribute was   */
      /* removed, the HttpSessionAttributeListener.attributeRemoved method    */
      /* is called on all HttpSessionAttributeListeners in the web            */
      /* application"                                                         */
      TestResult tr29 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB3);
      /* TODO: implement test */
      tr29.appendTcDetail("Not implemented.");
      tr29.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeB4 */
      /* Details: "Method removeAttribute(String, int): Throws                */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr30 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB4);
      try {
         try {
            PortletSession sess = portletReq.getPortletSession();
            sess.removeAttribute(null, 0x01);
            tr30.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr30.setTcSuccess(true);
         } catch (Exception e) {
            tr30.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr30.appendTcDetail(e.toString());}
      tr30.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA1 */
      /* Details: "Method setAttribute(String, Object): Stores an attribute   */
      /* object under the specified name in the PORTLET_SCOPE"                */
      TestResult tr31 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA1);
      /* TODO: implement test */
      tr31.appendTcDetail("Not implemented.");
      tr31.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA2 */
      /* Details: "Method setAttribute(String, Object): Replaces the          */
      /* attribute by the specified name if the attribute already exists"     */
      TestResult tr32 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA2);
      /* TODO: implement test */
      tr32.appendTcDetail("Not implemented.");
      tr32.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA3 */
      /* Details: "Method setAttribute(String, Object): Removes the           */
      /* attribute by the specified name if the object is null"               */
      TestResult tr33 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA3);
      /* TODO: implement test */
      tr33.appendTcDetail("Not implemented.");
      tr33.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA4 */
      /* Details: "Method setAttribute(String, Object): If the attribute      */
      /* object implements HttpSessionBindingListener, its                    */
      /* HttpSessionBindingListener.valueBound method is called"              */
      TestResult tr34 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA4);
      /* TODO: implement test */
      tr34.appendTcDetail("Not implemented.");
      tr34.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA5 */
      /* Details: "Method setAttribute(String, Object): If an existing        */
      /* attribute object implements HttpSessionBindingListener and is        */
      /* replaced, its HttpSessionBindingListener.valueUnbound method is      */
      /* called"                                                              */
      TestResult tr35 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA5);
      /* TODO: implement test */
      tr35.appendTcDetail("Not implemented.");
      tr35.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA6 */
      /* Details: "Method setAttribute(String, Object): If an attribute was   */
      /* replaced, the HttpSessionAttributeListener.attributeReplaced         */
      /* method is called on all HttpSessionAttributeListeners in the web     */
      /* application"                                                         */
      TestResult tr36 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA6);
      /* TODO: implement test */
      tr36.appendTcDetail("Not implemented.");
      tr36.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA7 */
      /* Details: "Method setAttribute(String, Object): If a new attribute    */
      /* was added, the HttpSessionAttributeListener.attributeAdded method    */
      /* is called on all HttpSessionAttributeListeners in the web            */
      /* application"                                                         */
      TestResult tr37 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA7);
      /* TODO: implement test */
      tr37.appendTcDetail("Not implemented.");
      tr37.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA8 */
      /* Details: "Method setAttribute(String, Object): Throws                */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr38 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA8);
      try {
         try {
            PortletSession sess = portletReq.getPortletSession();
            sess.setAttribute(null, "value");
            tr38.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr38.setTcSuccess(true);
         } catch (Exception e) {
            tr38.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr38.appendTcDetail(e.toString());}
      tr38.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB1 */
      /* Details: "Method setAttribute(String, Object, int): Stores an        */
      /* attribute object under the specified name in the specified scope"    */
      TestResult tr39 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB1);
      /* TODO: implement test */
      tr39.appendTcDetail("Not implemented.");
      tr39.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB2 */
      /* Details: "Method setAttribute(String, Object, int): Replaces the     */
      /* attribute by the specified name if the attribute already exists"     */
      TestResult tr40 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB2);
      /* TODO: implement test */
      tr40.appendTcDetail("Not implemented.");
      tr40.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB3 */
      /* Details: "Method setAttribute(String, Object, int): Removes the      */
      /* attribute by the specified name if the object is null"               */
      TestResult tr41 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB3);
      /* TODO: implement test */
      tr41.appendTcDetail("Not implemented.");
      tr41.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB4 */
      /* Details: "Method setAttribute(String, Object, int): If the           */
      /* attribute object implements HttpSessionBindingListener, its          */
      /* HttpSessionBindingListener.valueBound method is called"              */
      TestResult tr42 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB4);
      /* TODO: implement test */
      tr42.appendTcDetail("Not implemented.");
      tr42.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB5 */
      /* Details: "Method setAttribute(String, Object, int): If an existing   */
      /* attribute object implements HttpSessionBindingListener and is        */
      /* replaced, its HttpSessionBindingListener.valueUnbound method is      */
      /* called"                                                              */
      TestResult tr43 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB5);
      /* TODO: implement test */
      tr43.appendTcDetail("Not implemented.");
      tr43.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB6 */
      /* Details: "Method setAttribute(String, Object, int): If an            */
      /* attribute was replaced, the                                          */
      /* HttpSessionAttributeListener.attributeReplaced method is called on   */
      /* all HttpSessionAttributeListeners in the web application"            */
      TestResult tr44 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB6);
      /* TODO: implement test */
      tr44.appendTcDetail("Not implemented.");
      tr44.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB7 */
      /* Details: "Method setAttribute(String, Object, int): If a new         */
      /* attribute was added, the                                             */
      /* HttpSessionAttributeListener.attributeAdded method is called on      */
      /* all HttpSessionAttributeListeners in the web application"            */
      TestResult tr45 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB7);
      /* TODO: implement test */
      tr45.appendTcDetail("Not implemented.");
      tr45.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB8 */
      /* Details: "Method setAttribute(String, Object, int): Throws           */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr46 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB8);
      try {
         try {
            PortletSession sess = portletReq.getPortletSession();
            sess.setAttribute(null, "value", 0x01);
            tr46.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr46.setTcSuccess(true);
         } catch (Exception e) {
            tr46.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr46.appendTcDetail(e.toString());}
      tr46.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setMaxInactiveInterval1 */
      /* Details: "Method setMaxInactiveInterval(int): Specifies the time     */
      /* in seconds between client requests before the portlet contaner       */
      /* invalidates the session"                                             */
      TestResult tr47 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETMAXINACTIVEINTERVAL1);
      /* TODO: implement test */
      tr47.appendTcDetail("Not implemented.");
      tr47.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setMaxInactiveInterval2 */
      /* Details: "Method setMaxInactiveInterval(int): If the specified       */
      /* time is negative, the session should never timeout"                  */
      TestResult tr48 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETMAXINACTIVEINTERVAL2);
      /* TODO: implement test */
      tr48.appendTcDetail("Not implemented.");
      tr48.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getPortletContext */
      /* Details: "Method getPortletContext(): Returns the PortletContext     */
      /* object for this session"                                             */
      TestResult tr49 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETPORTLETCONTEXT);
      /* TODO: implement test */
      tr49.appendTcDetail("Not implemented.");
      tr49.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeMapA1 */
      /* Details: "Method getAttributeMap(): Returns an                       */
      /* java.util.Map&lt;java.lang.String,java.lang.Object&gt; object for    */
      /* the attributes available in the PORTLET_SCOPE"                       */
      TestResult tr50 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPA1);
      /* TODO: implement test */
      tr50.appendTcDetail("Not implemented.");
      tr50.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeMapA2 */
      /* Details: "Method getAttributeMap(): Returns an empty map if no       */
      /* attributes exist in the PORTLET_SCOPE"                               */
      TestResult tr51 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPA2);
      /* TODO: implement test */
      tr51.appendTcDetail("Not implemented.");
      tr51.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeMapB1 */
      /* Details: "Method getAttributeMap(int): Returns an                    */
      /* java.util.Map&lt;java.lang.String,java.lang.Object&gt; object for    */
      /* the attributes available in the PORTLET_SCOPE"                       */
      TestResult tr52 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPB1);
      /* TODO: implement test */
      tr52.appendTcDetail("Not implemented.");
      tr52.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeMapB2 */
      /* Details: "Method getAttributeMap(int): Returns an empty map if no    */
      /* attributes exist in the PORTLET_SCOPE"                               */
      TestResult tr53 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPB2);
      /* TODO: implement test */
      tr53.appendTcDetail("Not implemented.");
      tr53.writeTo(writer);

   }

}
