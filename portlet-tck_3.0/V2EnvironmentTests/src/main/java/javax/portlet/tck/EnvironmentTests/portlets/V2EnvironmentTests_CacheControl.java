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
public class V2EnvironmentTests_CacheControl implements Portlet {
   private static final String LOG_CLASS = 
         V2EnvironmentTests_CacheControl.class.getName();
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
      ClassChecker cc = new ClassChecker(renderResponse.getCacheControl().getClass());

      // Create result objects for the tests

      /* TestCase: CacheControl_getExpirationTime1 */
      /* Details: "Returns the expiration time set through setExpirationTime" */
      TestResult tr0 = tcd.getTestResultFailed(CACHECONTROL_GETEXPIRATIONTIME1);
      /* TODO: implement test */

      /* TestCase: CacheControl_getExpirationTime2 */
      /* Details: "Returns the default expiration time from the deployment descriptor if the expiration time has not been set" */
      TestResult tr1 = tcd.getTestResultFailed(CACHECONTROL_GETEXPIRATIONTIME2);
      /* TODO: implement test */

      /* TestCase: CacheControl_getExpirationTime3 */
      /* Details: "Returns 0 if the expiration time has not been set and no default is set in the deployment descriptor" */
      TestResult tr2 = tcd.getTestResultFailed(CACHECONTROL_GETEXPIRATIONTIME3);
      /* TODO: implement test */

      /* TestCase: CacheControl_setExpirationTime1 */
      /* Details: "Sets the expiration time for the current response to the specified value" */
      TestResult tr3 = tcd.getTestResultFailed(CACHECONTROL_SETEXPIRATIONTIME1);
      /* TODO: implement test */

      /* TestCase: CacheControl_setExpirationTime2 */
      /* Details: "If the expiration value is set to 0, caching is disabled" */
      TestResult tr4 = tcd.getTestResultFailed(CACHECONTROL_SETEXPIRATIONTIME2);
      /* TODO: implement test */

      /* TestCase: CacheControl_setExpirationTime3 */
      /* Details: "If the expiration value is set to -1, the cache does not expire" */
      TestResult tr5 = tcd.getTestResultFailed(CACHECONTROL_SETEXPIRATIONTIME3);
      /* TODO: implement test */

      /* TestCase: CacheControl_isPublicScope1 */
      /* Details: "Returns true if the caching scope has been set to public through the setPublicScope method" */
      TestResult tr6 = tcd.getTestResultFailed(CACHECONTROL_ISPUBLICSCOPE1);
      /* TODO: implement test */

      /* TestCase: CacheControl_isPublicScope2 */
      /* Details: "Returns true if the caching scope default has been set to public in the deployment descriptor " */
      TestResult tr7 = tcd.getTestResultFailed(CACHECONTROL_ISPUBLICSCOPE2);
      /* TODO: implement test */

      /* TestCase: CacheControl_isPublicScope3 */
      /* Details: "Returns false if the caching scope has been set to non-public through the setPublicScope method " */
      TestResult tr8 = tcd.getTestResultFailed(CACHECONTROL_ISPUBLICSCOPE3);
      /* TODO: implement test */

      /* TestCase: CacheControl_isPublicScope4 */
      /* Details: "Returns false if the caching scope  default has been set to public in the deployment descriptor" */
      TestResult tr9 = tcd.getTestResultFailed(CACHECONTROL_ISPUBLICSCOPE4);
      /* TODO: implement test */

      /* TestCase: CacheControl_isPublicScope5 */
      /* Details: "Returns false if the caching scope has not been set ans has no default" */
      TestResult tr10 = tcd.getTestResultFailed(CACHECONTROL_ISPUBLICSCOPE5);
      /* TODO: implement test */

      /* TestCase: CacheControl_setPublicScope1 */
      /* Details: "If the input parameter is true, the cache scope is set to public" */
      TestResult tr11 = tcd.getTestResultFailed(CACHECONTROL_SETPUBLICSCOPE1);
      /* TODO: implement test */

      /* TestCase: CacheControl_setPublicScope2 */
      /* Details: "If the input parameter is false, the cache scope is set to non-public" */
      TestResult tr12 = tcd.getTestResultFailed(CACHECONTROL_SETPUBLICSCOPE2);
      /* TODO: implement test */

      /* TestCase: CacheControl_getETag1 */
      /* Details: "Returns a String containing the ETag for the current response" */
      TestResult tr13 = tcd.getTestResultFailed(CACHECONTROL_GETETAG1);
      /* TODO: implement test */

      /* TestCase: CacheControl_getETag2 */
      /* Details: "Returns null if no ETag is set on the response" */
      TestResult tr14 = tcd.getTestResultFailed(CACHECONTROL_GETETAG2);
      /* TODO: implement test */

      /* TestCase: CacheControl_setETag1 */
      /* Details: "Sets an ETag for the current response" */
      TestResult tr15 = tcd.getTestResultFailed(CACHECONTROL_SETETAG1);
      /* TODO: implement test */

      /* TestCase: CacheControl_setETag2 */
      /* Details: "A previously-set ETag is overwritten" */
      TestResult tr16 = tcd.getTestResultFailed(CACHECONTROL_SETETAG2);
      /* TODO: implement test */

      /* TestCase: CacheControl_setETag3 */
      /* Details: "Removes the ETag if the input parameter is null" */
      TestResult tr17 = tcd.getTestResultFailed(CACHECONTROL_SETETAG3);
      /* TODO: implement test */

      /* TestCase: CacheControl_useCachedContent1 */
      /* Details: "Returns true if cached content has been set to valid through the setUseCachedContent method" */
      TestResult tr18 = tcd.getTestResultFailed(CACHECONTROL_USECACHEDCONTENT1);
      /* TODO: implement test */

      /* TestCase: CacheControl_useCachedContent2 */
      /* Details: "Returns false if cached content has been set to invalid through the setUseCachedContent method" */
      TestResult tr19 = tcd.getTestResultFailed(CACHECONTROL_USECACHEDCONTENT2);
      /* TODO: implement test */

      /* TestCase: CacheControl_useCachedContent3 */
      /* Details: "Returns false if the use cached content indcator has not been set" */
      TestResult tr20 = tcd.getTestResultFailed(CACHECONTROL_USECACHEDCONTENT3);
      /* TODO: implement test */

      /* TestCase: CacheControl_setUseCachedContent1 */
      /* Details: "If set to true, the cached content is valid " */
      TestResult tr21 = tcd.getTestResultFailed(CACHECONTROL_SETUSECACHEDCONTENT1);
      /* TODO: implement test */

      /* TestCase: CacheControl_setUseCachedContent2 */
      /* Details: "If set to false, the cached content is invalid " */
      TestResult tr22 = tcd.getTestResultFailed(CACHECONTROL_SETUSECACHEDCONTENT2);
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


   }

}

