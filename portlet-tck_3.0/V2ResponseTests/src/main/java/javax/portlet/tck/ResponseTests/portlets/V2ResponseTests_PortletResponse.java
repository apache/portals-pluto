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

package javax.portlet.tck.ResponseTests.portlets;

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
public class V2ResponseTests_PortletResponse implements Portlet {
   private static final String LOG_CLASS = 
         V2ResponseTests_PortletResponse.class.getName();
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
      ClassChecker cc = new ClassChecker(renderResponse.getClass());

      // Create result objects for the tests

      /* TestCase: PortletResponse_addPropertyA1 */
      /* Details: "Adds the specified cookie property to the response" */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETRESPONSE_ADDPROPERTYA1);
      /* TODO: implement test */

      /* TestCase: PortletResponse_addPropertyA2 */
      /* Details: "Throws IllegalArgumentException if the specified cookie is null" */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETRESPONSE_ADDPROPERTYA2);
      /* TODO: implement test */

      /* TestCase: PortletResponse_addPropertyB1 */
      /* Details: "Adds an XML DOM Element to the response for the specified key" */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETRESPONSE_ADDPROPERTYB1);
      /* TODO: implement test */

      /* TestCase: PortletResponse_addPropertyB2 */
      /* Details: "If a DOM Element for the specified key already exists, the new element is added in addition to the existing element" */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETRESPONSE_ADDPROPERTYB2);
      /* TODO: implement test */

      /* TestCase: PortletResponse_addPropertyB3 */
      /* Details: "If the specified DOM Element value is null, the key is removed from the response" */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETRESPONSE_ADDPROPERTYB3);
      /* TODO: implement test */

      /* TestCase: PortletResponse_addPropertyB4 */
      /* Details: "Throws IllegalArgumentException if the specified key is null" */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETRESPONSE_ADDPROPERTYB4);
      /* TODO: implement test */

      /* TestCase: PortletResponse_addPropertyC1 */
      /* Details: "Adds a property value to an existing key to allow the key to have multiple values" */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETRESPONSE_ADDPROPERTYC1);
      /* TODO: implement test */

      /* TestCase: PortletResponse_addPropertyC2 */
      /* Details: "Throws IllegalArgumentException if the specified key is null" */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETRESPONSE_ADDPROPERTYC2);
      /* TODO: implement test */

      /* TestCase: PortletResponse_setProperty1 */
      /* Details: "Sets a property value for the specified key" */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETRESPONSE_SETPROPERTY1);
      /* TODO: implement test */

      /* TestCase: PortletResponse_setProperty2 */
      /* Details: "Resets any existing property values for the specified key" */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETRESPONSE_SETPROPERTY2);
      /* TODO: implement test */

      /* TestCase: PortletResponse_setProperty3 */
      /* Details: "Throws IllegalArgumentException if the specified key is null" */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETRESPONSE_SETPROPERTY3);
      /* TODO: implement test */

      /* TestCase: PortletResponse_encodeURL1 */
      /* Details: "Returns a String representing the encoded URL" */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETRESPONSE_ENCODEURL1);
      /* TODO: implement test */

      /* TestCase: PortletResponse_encodeURL2 */
      /* Details: "Throws IllegalArgumentException if the input string is not an absolute URL and does not start with at \"/\" character" */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETRESPONSE_ENCODEURL2);
      /* TODO: implement test */

      /* TestCase: PortletResponse_getNamespace1 */
      /* Details: "Returns a String containing the namespace value" */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETRESPONSE_GETNAMESPACE1);
      /* TODO: implement test */

      /* TestCase: PortletResponse_getNamespace2 */
      /* Details: "The returned namespace is constant for the lifetime of the portlet window" */
      TestResult tr14 = tcd.getTestResultFailed(PORTLETRESPONSE_GETNAMESPACE2);
      /* TODO: implement test */

      /* TestCase: PortletResponse_createElement1 */
      /* Details: "Returns an org.w3c.dom.Element object for the specified tag name" */
      TestResult tr15 = tcd.getTestResultFailed(PORTLETRESPONSE_CREATEELEMENT1);
      /* TODO: implement test */

      /* TestCase: PortletResponse_createElement2 */
      /* Details: "The returned Element has nodeName set to the the specified tag name " */
      TestResult tr16 = tcd.getTestResultFailed(PORTLETRESPONSE_CREATEELEMENT2);
      /* TODO: implement test */

      /* TestCase: PortletResponse_createElement3 */
      /* Details: "The returned Element has localName set to null" */
      TestResult tr17 = tcd.getTestResultFailed(PORTLETRESPONSE_CREATEELEMENT3);
      /* TODO: implement test */

      /* TestCase: PortletResponse_createElement4 */
      /* Details: "The returned Element has prefix set to null" */
      TestResult tr18 = tcd.getTestResultFailed(PORTLETRESPONSE_CREATEELEMENT4);
      /* TODO: implement test */

      /* TestCase: PortletResponse_createElement5 */
      /* Details: "The returned Element has namespaceURI set to null" */
      TestResult tr19 = tcd.getTestResultFailed(PORTLETRESPONSE_CREATEELEMENT5);
      /* TODO: implement test */

      /* TestCase: PortletResponse_createElement6 */
      /* Details: "Throws org.w3c.dom.DOMException - INVALID_CHARACTER_ERR if the specified name contains an illegal character. " */
      TestResult tr20 = tcd.getTestResultFailed(PORTLETRESPONSE_CREATEELEMENT6);
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


   }

}

