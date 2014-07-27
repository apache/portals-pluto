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
public class V2ResponseTests_RenderResponse implements Portlet {
   private static final String LOG_CLASS = 
         V2ResponseTests_RenderResponse.class.getName();
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

      /* TestCase: RenderResponse_implementsMimeResponse3 */
      /* Details: "All tests described for the PortletResponse execute correctly with the RenderResponse" */
      TestResult tr0 = tcd.getTestResultFailed(RENDERRESPONSE_IMPLEMENTSMIMERESPONSE3);
      /* TODO: implement test */

      /* TestCase: RenderResponse_implementsMimeResponse4 */
      /* Details: "All tests described for the MimeResponse execute correctly with the RenderResponse" */
      TestResult tr1 = tcd.getTestResultFailed(RENDERRESPONSE_IMPLEMENTSMIMERESPONSE4);
      /* TODO: implement test */

      /* TestCase: RenderResponse_setTitle1 */
      /* Details: "Returns void" */
      TestResult tr2 = tcd.getTestResultFailed(RENDERRESPONSE_SETTITLE1);
      /* TODO: implement test */

      /* TestCase: RenderResponse_setTitle2 */
      /* Details: "Sets the portlet title to the specified value" */
      TestResult tr3 = tcd.getTestResultFailed(RENDERRESPONSE_SETTITLE2);
      /* TODO: implement test */

      /* TestCase: RenderResponse_setNextPossiblePortletModes1 */
      /* Details: "Returns void" */
      TestResult tr4 = tcd.getTestResultFailed(RENDERRESPONSE_SETNEXTPOSSIBLEPORTLETMODES1);
      /* TODO: implement test */

      /* TestCase: RenderResponse_setNextPossiblePortletModes2 */
      /* Details: "Sets the next possible portlet modes to the specified value" */
      TestResult tr5 = tcd.getTestResultFailed(RENDERRESPONSE_SETNEXTPOSSIBLEPORTLETMODES2);
      /* TODO: implement test */

      /* TestCase: RenderResponse_setContentType1 */
      /* Details: "The portlet container will ignore any character encoding specified as part of the content type for render calls" */
      TestResult tr6 = tcd.getTestResultFailed(RENDERRESPONSE_SETCONTENTTYPE1);
      /* TODO: implement test */

      /* TestCase: RenderResponse_setContentType2 */
      /* Details: "Throws IllegalArgumentException if the content type is not valid" */
      TestResult tr7 = tcd.getTestResultFailed(RENDERRESPONSE_SETCONTENTTYPE2);
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

