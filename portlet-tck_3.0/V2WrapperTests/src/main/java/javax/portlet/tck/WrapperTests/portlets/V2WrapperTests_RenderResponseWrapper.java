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
public class V2WrapperTests_RenderResponseWrapper implements Portlet {
   private static final String LOG_CLASS = 
         V2WrapperTests_RenderResponseWrapper.class.getName();
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
      ClassChecker cc = new ClassChecker(RenderResponseWrapper.class);

      // Create result objects for the tests

      /* TestCase: RenderResponseWrapper_flushBuffer */
      /* Details: "Calls wrapped method" */
      TestResult tr0 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_FLUSHBUFFER);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_getBufferSize */
      /* Details: "Calls wrapped method" */
      TestResult tr1 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_GETBUFFERSIZE);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_getCharacterEncoding */
      /* Details: "Calls wrapped method" */
      TestResult tr2 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_GETCHARACTERENCODING);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_getContentType */
      /* Details: "Calls wrapped method" */
      TestResult tr3 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_GETCONTENTTYPE);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_getLocale */
      /* Details: "Calls wrapped method" */
      TestResult tr4 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_GETLOCALE);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_getPortletOutputStream */
      /* Details: "Calls wrapped method" */
      TestResult tr5 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_GETPORTLETOUTPUTSTREAM);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_getWriter */
      /* Details: "Calls wrapped method" */
      TestResult tr6 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_GETWRITER);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_isCommitted */
      /* Details: "Calls wrapped method" */
      TestResult tr7 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_ISCOMMITTED);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_reset */
      /* Details: "Calls wrapped method" */
      TestResult tr8 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_RESET);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_resetBuffer */
      /* Details: "Calls wrapped method" */
      TestResult tr9 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_RESETBUFFER);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_setBufferSize */
      /* Details: "Calls wrapped method" */
      TestResult tr10 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SETBUFFERSIZE);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_setContentType */
      /* Details: "Calls wrapped method" */
      TestResult tr11 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SETCONTENTTYPE);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_setTitle */
      /* Details: "Calls wrapped method" */
      TestResult tr12 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SETTITLE);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_getCacheControl */
      /* Details: "Calls wrapped method" */
      TestResult tr13 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_GETCACHECONTROL);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_setNextPossiblePortletModes */
      /* Details: "Calls wrapped method" */
      TestResult tr14 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SETNEXTPOSSIBLEPORTLETMODES);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_getResponse */
      /* Details: "Calls wrapped method" */
      TestResult tr15 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_GETRESPONSE);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_setResponse */
      /* Details: "Calls wrapped method" */
      TestResult tr16 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SETRESPONSE);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_createActionURL */
      /* Details: "Calls wrapped method" */
      TestResult tr17 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_CREATEACTIONURL);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_createRenderURL */
      /* Details: "Calls wrapped method" */
      TestResult tr18 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_CREATERENDERURL);
      /* TODO: implement test */

      /* TestCase: RenderResponseWrapper_createResourceURL */
      /* Details: "Calls wrapped method" */
      TestResult tr19 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_CREATERESOURCEURL);
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


   }

}

