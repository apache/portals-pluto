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

package javax.portlet.tck.WrapperTests.portlets;

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
public class V2WrapperTests_ResourceResponseWrapper implements Portlet {
   private static final String LOG_CLASS = 
         V2WrapperTests_ResourceResponseWrapper.class.getName();
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
      ClassChecker cc = new ClassChecker(ResourceResponseWrapper.class);

      // Create result objects for the tests

      /* TestCase: ResourceResponseWrapper_flushBuffer */
      /* Details: "Calls wrapped method" */
      TestResult tr0 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_FLUSHBUFFER);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_getBufferSize */
      /* Details: "Calls wrapped method" */
      TestResult tr1 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_GETBUFFERSIZE);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_getCharacterEncoding */
      /* Details: "Calls wrapped method" */
      TestResult tr2 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_GETCHARACTERENCODING);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_getContentType */
      /* Details: "Calls wrapped method" */
      TestResult tr3 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_GETCONTENTTYPE);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_getLocale */
      /* Details: "Calls wrapped method" */
      TestResult tr4 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_GETLOCALE);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_getPortletOutputStream */
      /* Details: "Calls wrapped method" */
      TestResult tr5 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_GETPORTLETOUTPUTSTREAM);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_getWriter */
      /* Details: "Calls wrapped method" */
      TestResult tr6 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_GETWRITER);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_isCommitted */
      /* Details: "Calls wrapped method" */
      TestResult tr7 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_ISCOMMITTED);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_reset */
      /* Details: "Calls wrapped method" */
      TestResult tr8 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_RESET);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_resetBuffer */
      /* Details: "Calls wrapped method" */
      TestResult tr9 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_RESETBUFFER);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_setBufferSize */
      /* Details: "Calls wrapped method" */
      TestResult tr10 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_SETBUFFERSIZE);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_setContentType */
      /* Details: "Calls wrapped method" */
      TestResult tr11 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_SETCONTENTTYPE);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_getCacheControl */
      /* Details: "Calls wrapped method" */
      TestResult tr12 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_GETCACHECONTROL);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_setCharacterEncoding */
      /* Details: "Calls wrapped method" */
      TestResult tr13 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_SETCHARACTERENCODING);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_setLocale */
      /* Details: "Calls wrapped method" */
      TestResult tr14 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_SETLOCALE);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_setContentLength */
      /* Details: "Calls wrapped method" */
      TestResult tr15 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_SETCONTENTLENGTH);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_getResponse */
      /* Details: "Returns wrapped RespurceResponse object" */
      TestResult tr16 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_GETRESPONSE);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_setResponse */
      /* Details: "Allows wrapped ResourceResponse object to be set" */
      TestResult tr17 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_SETRESPONSE);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_createActionURL */
      /* Details: "Calls wrapped method" */
      TestResult tr18 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_CREATEACTIONURL);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_createRenderURL */
      /* Details: "Calls wrapped method" */
      TestResult tr19 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_CREATERENDERURL);
      /* TODO: implement test */

      /* TestCase: ResourceResponseWrapper_createResourceURL */
      /* Details: "Calls wrapped method" */
      TestResult tr20 = tcd.getTestResultFailed(RESOURCERESPONSEWRAPPER_CREATERESOURCEURL);
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

