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
public class AddlResponseTests_SPEC2_12_ResponseContent implements Portlet {
   private static final String LOG_CLASS = 
         AddlResponseTests_SPEC2_12_ResponseContent.class.getName();
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

      /* TestCase: SPEC2_12_ResponseContent_contentType5                      */
      /* Details: "If the setContentType method is not called before the      */
      /* getWriter or getPortletOutputStream method is used, the portlet      */
      /* container uses the content type returned by                          */
      /* getResponseContentType"                                              */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_12_RESPONSECONTENT_CONTENTTYPE5);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseContent_buffering9                        */
      /* Details: "If the reset method is used after the response has been    */
      /* committed, the response and its buffer must remain unchanged"        */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_12_RESPONSECONTENT_BUFFERING9);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseContent_buffering10                       */
      /* Details: "The resetBuffer method clears data in the buffer when      */
      /* the response is not committed"                                       */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_12_RESPONSECONTENT_BUFFERING10);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseContent_buffering11                       */
      /* Details: "The resetBuffer method does not clear any properties set   */
      /* before use of the resetBuffer method"                                */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_12_RESPONSECONTENT_BUFFERING11);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseContent_buffering13                       */
      /* Details: "If the resetBuffer method is used after the response has   */
      /* been committed, the response and its buffer must remain unchanged"   */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_12_RESPONSECONTENT_BUFFERING13);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseContent_characterEncoding2                */
      /* Details: "The character encoding can be set via the setLocale        */
      /* method and a locale-encoding-mapping-list mapping in the web.xml     */
      /* deployment descriptor"                                               */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_12_RESPONSECONTENT_CHARACTERENCODING2);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseContent_characterEncoding3                */
      /* Details: "The character encoding can be set via the setContentType   */
      /* method if the given content type string provides a value for the     */
      /* charset attribute"                                                   */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_12_RESPONSECONTENT_CHARACTERENCODING3);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseContent_characterEncoding4                */
      /* Details: "If the portlet does not set the character encoding, the    */
      /* portlet container uses UTF-8 as the default character encoding"      */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_12_RESPONSECONTENT_CHARACTERENCODING4);
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


   }

}

