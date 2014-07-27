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

package javax.portlet.tck.EnvironmentTests.portlets;

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
public class V2EnvironmentTests_PortletSession implements Portlet {
   private static final String LOG_CLASS = 
         V2EnvironmentTests_PortletSession.class.getName();
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
      ClassChecker cc = new ClassChecker(renderRequest.getPortletSession().getClass());

      // Create result objects for the tests

      /* TestCase: PortletSession_fieldAPPLICATION_SCOPE */
      /* Details: "Has int field APPLICATION_SCOPE with value of 0x01 " */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETSESSION_FIELDAPPLICATION_SCOPE);
      {
         tr0.setTcSuccess(cc.hasField("APPLICATION_SCOPE", "0x01"));
      }

      /* TestCase: PortletSession_fieldPORTLET_SCOPE */
      /* Details: "Has int field PORTLET_SCOPE with value of 0x02 " */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETSESSION_FIELDPORTLET_SCOPE);
      {
         tr1.setTcSuccess(cc.hasField("PORTLET_SCOPE", "0x02"));
      }

      /* TestCase: PortletSession_getAttributeA1 */
      /* Details: "Returns a java.lang.Object for the specified attribute name in the PORTLET_SCOPE" */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTEA1);
      /* TODO: implement test */

      /* TestCase: PortletSession_getAttributeA2 */
      /* Details: "Returns null if no attribute with the specified name exists in the PORTLET_SCOPE" */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTEA2);
      /* TODO: implement test */

      /* TestCase: PortletSession_getAttributeA3 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTEA3);
      /* TODO: implement test */

      /* TestCase: PortletSession_getAttributeA4 */
      /* Details: "Throws IllegalStateException if the method is called on an invalidated session" */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTEA4);
      /* TODO: implement test */

      /* TestCase: PortletSession_getAttributeB1 */
      /* Details: "Returns a java.lang.Object for the specified attribute name in the specified scope" */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTEB1);
      /* TODO: implement test */

      /* TestCase: PortletSession_getAttributeB2 */
      /* Details: "Returns null if no attribute with the specified name exists in the specified scope" */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTEB2);
      /* TODO: implement test */

      /* TestCase: PortletSession_getAttributeB3 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTEB3);
      /* TODO: implement test */

      /* TestCase: PortletSession_getAttributeB4 */
      /* Details: "Throws IllegalStateException if the method is called on an invalidated session" */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTEB4);
      /* TODO: implement test */

      /* TestCase: PortletSession_getAttributeNamesA1 */
      /* Details: "Returns a java.util.Enumeration<java.lang.String> of the available attribute names in the PORTLET_SCOPE" */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTENAMESA1);
      /* TODO: implement test */

      /* TestCase: PortletSession_getAttributeNamesA2 */
      /* Details: "Returns an empty Enumeration if there are no attributes available in the PORTLET_SCOPE" */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTENAMESA2);
      /* TODO: implement test */

      /* TestCase: PortletSession_getAttributeNamesB1 */
      /* Details: "Returns a java.util.Enumeration<java.lang.String> of the available attribute names in the specified scope" */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTENAMESB1);
      /* TODO: implement test */

      /* TestCase: PortletSession_getAttributeNamesB2 */
      /* Details: "Returns an empty Enumeration if there are no attributes available in the specified scope" */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTENAMESB2);
      /* TODO: implement test */

      /* TestCase: PortletSession_getCreationTime1 */
      /* Details: "Returns a long containing the time the session was created in milliseconds since 1/1/1970  " */
      TestResult tr14 = tcd.getTestResultFailed(PORTLETSESSION_GETCREATIONTIME1);
      /* TODO: implement test */

      /* TestCase: PortletSession_getCreationTime2 */
      /* Details: "Throws IllegalStateException if this method is called on an invalidated session" */
      TestResult tr15 = tcd.getTestResultFailed(PORTLETSESSION_GETCREATIONTIME2);
      /* TODO: implement test */

      /* TestCase: PortletSession_getId */
      /* Details: "Returns a String containing a unique identifier for the session" */
      TestResult tr16 = tcd.getTestResultFailed(PORTLETSESSION_GETID);
      /* TODO: implement test */

      /* TestCase: PortletSession_getLastAccessedTime */
      /* Details: "Returns a long containing the last time the session was accessed in milliseconds since 1/1/1970" */
      TestResult tr17 = tcd.getTestResultFailed(PORTLETSESSION_GETLASTACCESSEDTIME);
      /* TODO: implement test */

      /* TestCase: PortletSession_getMaxInactiveInterval */
      /* Details: "Returns the maximum time interval, in seconds, for which the portlet container keeps this session open between client accesses" */
      TestResult tr18 = tcd.getTestResultFailed(PORTLETSESSION_GETMAXINACTIVEINTERVAL);
      /* TODO: implement test */

      /* TestCase: PortletSession_invalidate1 */
      /* Details: "Invalidates this session (all scopes) and unbinds any objects bound to it" */
      TestResult tr19 = tcd.getTestResultFailed(PORTLETSESSION_INVALIDATE1);
      /* TODO: implement test */

      /* TestCase: PortletSession_invalidate2 */
      /* Details: "The underlying HTTP session is also invalidated" */
      TestResult tr20 = tcd.getTestResultFailed(PORTLETSESSION_INVALIDATE2);
      /* TODO: implement test */

      /* TestCase: PortletSession_isNew1 */
      /* Details: "Returns true if the client has not yet joined the session" */
      TestResult tr21 = tcd.getTestResultFailed(PORTLETSESSION_ISNEW1);
      /* TODO: implement test */

      /* TestCase: PortletSession_isNew2 */
      /* Details: "Returns false if the client has joined the session" */
      TestResult tr22 = tcd.getTestResultFailed(PORTLETSESSION_ISNEW2);
      /* TODO: implement test */

      /* TestCase: PortletSession_removeAttributeA1 */
      /* Details: "Removes the attribute specified by the name from the PORTLET_SCOPE" */
      TestResult tr23 = tcd.getTestResultFailed(PORTLETSESSION_REMOVEATTRIBUTEA1);
      /* TODO: implement test */

      /* TestCase: PortletSession_removeAttributeA2 */
      /* Details: "If there is no attribute by the specified name in the the PORTLET_SCOPE, this method does nothing" */
      TestResult tr24 = tcd.getTestResultFailed(PORTLETSESSION_REMOVEATTRIBUTEA2);
      /* TODO: implement test */

      /* TestCase: PortletSession_removeAttributeA3 */
      /* Details: "If an attribute was removed, the HttpSessionAttributeListener.attributeRemoved method is called on all HttpSessionAttributeListeners in the web application" */
      TestResult tr25 = tcd.getTestResultFailed(PORTLETSESSION_REMOVEATTRIBUTEA3);
      /* TODO: implement test */

      /* TestCase: PortletSession_removeAttributeA4 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr26 = tcd.getTestResultFailed(PORTLETSESSION_REMOVEATTRIBUTEA4);
      /* TODO: implement test */

      /* TestCase: PortletSession_removeAttributeB1 */
      /* Details: "Removes the attribute specified by the name from the specified scope" */
      TestResult tr27 = tcd.getTestResultFailed(PORTLETSESSION_REMOVEATTRIBUTEB1);
      /* TODO: implement test */

      /* TestCase: PortletSession_removeAttributeB2 */
      /* Details: "If there is no attribute by the specified name in the specified scope, this method does nothing" */
      TestResult tr28 = tcd.getTestResultFailed(PORTLETSESSION_REMOVEATTRIBUTEB2);
      /* TODO: implement test */

      /* TestCase: PortletSession_removeAttributeB3 */
      /* Details: "If an attribute was removed, the HttpSessionAttributeListener.attributeRemoved method is called on all HttpSessionAttributeListeners in the web application" */
      TestResult tr29 = tcd.getTestResultFailed(PORTLETSESSION_REMOVEATTRIBUTEB3);
      /* TODO: implement test */

      /* TestCase: PortletSession_removeAttributeB4 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr30 = tcd.getTestResultFailed(PORTLETSESSION_REMOVEATTRIBUTEB4);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeA1 */
      /* Details: "Stores an attribute object under the specified name in the PORTLET_SCOPE" */
      TestResult tr31 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEA1);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeA2 */
      /* Details: "Replaces the attribute by the specified name if the attribute already exists" */
      TestResult tr32 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEA2);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeA3 */
      /* Details: "Removes the attribute by the specified name if the object is null" */
      TestResult tr33 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEA3);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeA4 */
      /* Details: "If the attribute object implements HttpSessionBindingListener, its HttpSessionBindingListener.valueBound method is called" */
      TestResult tr34 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEA4);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeA5 */
      /* Details: "If an existing attribute object implements HttpSessionBindingListener and is replaced, its HttpSessionBindingListener.valueUnbound method is called" */
      TestResult tr35 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEA5);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeA6 */
      /* Details: "If an attribute was replaced, the HttpSessionAttributeListener.attributeReplaced method is called on all HttpSessionAttributeListeners in the web application" */
      TestResult tr36 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEA6);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeA7 */
      /* Details: "If a new attribute was added, the HttpSessionAttributeListener.attributeAdded method is called on all HttpSessionAttributeListeners in the web application" */
      TestResult tr37 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEA7);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeA8 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr38 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEA8);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeB1 */
      /* Details: "Stores an attribute object under the specified name in the specified scope" */
      TestResult tr39 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEB1);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeB2 */
      /* Details: "Replaces the attribute by the specified name if the attribute already exists" */
      TestResult tr40 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEB2);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeB3 */
      /* Details: "Removes the attribute by the specified name if the object is null" */
      TestResult tr41 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEB3);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeB4 */
      /* Details: "If the attribute object implements HttpSessionBindingListener, its HttpSessionBindingListener.valueBound method is called" */
      TestResult tr42 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEB4);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeB5 */
      /* Details: "If an existing attribute object implements HttpSessionBindingListener and is replaced, its HttpSessionBindingListener.valueUnbound method is called" */
      TestResult tr43 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEB5);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeB6 */
      /* Details: "If an attribute was replaced, the HttpSessionAttributeListener.attributeReplaced method is called on all HttpSessionAttributeListeners in the web application" */
      TestResult tr44 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEB6);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeB7 */
      /* Details: "If a new attribute was added, the HttpSessionAttributeListener.attributeAdded method is called on all HttpSessionAttributeListeners in the web application" */
      TestResult tr45 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEB7);
      /* TODO: implement test */

      /* TestCase: PortletSession_setAttributeB8 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr46 = tcd.getTestResultFailed(PORTLETSESSION_SETATTRIBUTEB8);
      /* TODO: implement test */

      /* TestCase: PortletSession_setMaxInactiveInterval1 */
      /* Details: "Specifies the time in seconds between client requests before the portlet contaner invalidates the session" */
      TestResult tr47 = tcd.getTestResultFailed(PORTLETSESSION_SETMAXINACTIVEINTERVAL1);
      /* TODO: implement test */

      /* TestCase: PortletSession_setMaxInactiveInterval2 */
      /* Details: "If the specified time is negative, the session should never timeout" */
      TestResult tr48 = tcd.getTestResultFailed(PORTLETSESSION_SETMAXINACTIVEINTERVAL2);
      /* TODO: implement test */

      /* TestCase: PortletSession_getPortletContext */
      /* Details: "Returns the PortletContext object for this session" */
      TestResult tr49 = tcd.getTestResultFailed(PORTLETSESSION_GETPORTLETCONTEXT);
      /* TODO: implement test */

      /* TestCase: PortletSession_getAttributeMapA1 */
      /* Details: "Returns an java.util.Map<java.lang.String,java.lang.Object> object for the attributes available in the PORTLET_SCOPE" */
      TestResult tr50 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTEMAPA1);
      /* TODO: implement test */

      /* TestCase: PortletSession_getAttributeMapA2 */
      /* Details: "Returns an empty map if no attributes exist in the PORTLET_SCOPE" */
      TestResult tr51 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTEMAPA2);
      /* TODO: implement test */

      /* TestCase: PortletSession_getAttributeMapB1 */
      /* Details: "Returns an java.util.Map<java.lang.String,java.lang.Object> object for the attributes available in the PORTLET_SCOPE" */
      TestResult tr52 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTEMAPB1);
      /* TODO: implement test */

      /* TestCase: PortletSession_getAttributeMapB2 */
      /* Details: "Returns an empty map if no attributes exist in the PORTLET_SCOPE" */
      TestResult tr53 = tcd.getTestResultFailed(PORTLETSESSION_GETATTRIBUTEMAPB2);
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

