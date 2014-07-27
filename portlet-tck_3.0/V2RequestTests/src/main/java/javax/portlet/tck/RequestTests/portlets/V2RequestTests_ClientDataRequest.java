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

package javax.portlet.tck.RequestTests.portlets;

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
public class V2RequestTests_ClientDataRequest implements Portlet {
   private static final String LOG_CLASS = 
         V2RequestTests_ClientDataRequest.class.getName();
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
      ClassChecker cc = new ClassChecker(ActionRequestWrapper.class);

      // Create result objects for the tests

      /* TestCase: ClientDataRequest_extendsPortletRequest1 */
      /* Details: "ClientDataRequest extendsPortletRequest" */
      TestResult tr0 = tcd.getTestResultFailed(CLIENTDATAREQUEST_EXTENDSPORTLETREQUEST1);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_extendsPortletRequest2 */
      /* Details: "All tests described for the PortletRequest execute correctly with the ClientDataRequest" */
      TestResult tr1 = tcd.getTestResultFailed(CLIENTDATAREQUEST_EXTENDSPORTLETREQUEST2);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getPortletInputStream1 */
      /* Details: "Returns an InputStream object" */
      TestResult tr2 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETPORTLETINPUTSTREAM1);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getPortletInputStream2 */
      /* Details: "Throws IllegalStateException if getReader was already called" */
      TestResult tr3 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETPORTLETINPUTSTREAM2);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getPortletInputStream3 */
      /* Details: "Throws IllegalStateException if the request has HTTP POST data of type application/x-www-form-urlencoded" */
      TestResult tr4 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETPORTLETINPUTSTREAM3);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getPortletInputStream4 */
      /* Details: "Throws IOException if an error occurs during IO" */
      TestResult tr5 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETPORTLETINPUTSTREAM4);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_setCharacterEncoding1 */
      /* Details: "Allows the character encoding for the body of the request to be overridden" */
      TestResult tr6 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SETCHARACTERENCODING1);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_setCharacterEncoding2 */
      /* Details: "Throws IllegalStateException if method is called after reading request parameters" */
      TestResult tr7 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SETCHARACTERENCODING2);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_setCharacterEncoding3 */
      /* Details: "Throws IllegalStateException if method is called after using the getReader() method" */
      TestResult tr8 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SETCHARACTERENCODING3);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_setCharacterEncoding4 */
      /* Details: "Throws UnsupportedEncodingException if the specified encoding is not valid" */
      TestResult tr9 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SETCHARACTERENCODING4);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getReader1 */
      /* Details: "Returns a BufferedReader object for reading the request" */
      TestResult tr10 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETREADER1);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getReader2 */
      /* Details: "Throws IllegalStateException if getPortletInputStream was already called" */
      TestResult tr11 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETREADER2);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getReader3 */
      /* Details: "Throws IllegalStateException if the request has HTTP POST data of type application/x-www-form-urlencoded" */
      TestResult tr12 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETREADER3);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getReader4 */
      /* Details: "Throws IOException if an error occurs during IO" */
      TestResult tr13 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETREADER4);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getReader5 */
      /* Details: "Throws UnsupportedEncodingException if the character set encoding is not valid so that the text cannot be decoded" */
      TestResult tr14 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETREADER5);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getCharacterEncoding1 */
      /* Details: "Returns a String containing the name of the character encoding used in the request body" */
      TestResult tr15 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETCHARACTERENCODING1);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getCharacterEncoding2 */
      /* Details: "Returns null if the request does not specify a character encoding" */
      TestResult tr16 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETCHARACTERENCODING2);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getContentType1 */
      /* Details: "Returns a String containing the MIME type of the request body" */
      TestResult tr17 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETCONTENTTYPE1);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getContentType2 */
      /* Details: "Returns null if the MIME type is unknown" */
      TestResult tr18 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETCONTENTTYPE2);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getContentLength1 */
      /* Details: "Returns the length in bytes of the request body" */
      TestResult tr19 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETCONTENTLENGTH1);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getContentLength2 */
      /* Details: "Returns -1 if the length is unknown" */
      TestResult tr20 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETCONTENTLENGTH2);
      /* TODO: implement test */

      /* TestCase: ClientDataRequest_getMethod */
      /* Details: "Returns a String containing the name of the HTTP method with which the request was made" */
      TestResult tr21 = tcd.getTestResultFailed(CLIENTDATAREQUEST_GETMETHOD);
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


   }

}

