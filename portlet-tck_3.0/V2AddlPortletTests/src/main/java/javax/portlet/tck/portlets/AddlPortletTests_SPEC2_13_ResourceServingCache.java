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
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */
public class AddlPortletTests_SPEC2_13_ResourceServingCache implements Portlet {
   private static final String LOG_CLASS = 
         AddlPortletTests_SPEC2_13_ResourceServingCache.class.getName();
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
      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: SPEC2_13_ResourceServingCache_caching1                     */
      /* Details: "If portlet URLs are included in the markup, portals /      */
      /* portlet containers must create correct portlet URLs for all          */
      /* text-based markup types."                                            */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHING1);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_caching2                     */
      /* Details: "The portlet can use the setCacheability method to set      */
      /* the cache level for the ResourceURL"                                 */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHING2);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_caching3                     */
      /* Details: "If the cache level is not set, a generated resource URL    */
      /* has the cacheability of the request in which it was created"         */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHING3);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingFULL1                 */
      /* Details: "If the cache level is set to FULL, the resource URL does   */
      /* not contain the current render parameters"                           */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL1);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingFULL2                 */
      /* Details: "If the cache level is set to FULL, the resource URL does   */
      /* not contain the current portlet mode"                                */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL2);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingFULL3                 */
      /* Details: "If the cache level is set to FULL, the resource URL does   */
      /* not contain the current window state"                                */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL3);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingFULL4                 */
      /* Details: "If the cache level is set to FULL, the resource URL does   */
      /* not contain the current page state"                                  */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL4);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingFULL5                 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to FULL, a resource URL with      */
      /* cacheability set to FULL may be generated"                           */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL5);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingFULL6                 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to FULL, setting cacheability     */
      /* on a resource URL to PORTLET results in an an                        */
      /* IllegalStateException"                                               */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL6);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingFULL7                 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to FULL, setting cacheability     */
      /* on a resource URL to PAGE results in an an IllegalStateException"    */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL7);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingFULL8                 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to FULL, an attempt to create a   */
      /* render URL results in an an IllegalStateException"                   */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL8);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingFULL9                 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to FULL, an attempt to create     */
      /* an action URL results in an an IllegalStateException"                */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL9);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPORTLET1              */
      /* Details: "If the cache level is set to PORTLET, the resource URL     */
      /* contains the current render parameters"                              */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET1);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPORTLET2              */
      /* Details: "If the cache level is set to PORTLET, the resource URL     */
      /* contains the current portlet mode"                                   */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET2);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPORTLET3              */
      /* Details: "If the cache level is set to PORTLET, the resource URL     */
      /* contains the current window state"                                   */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET3);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPORTLET4              */
      /* Details: "If the cache level is set to PORTLET, the resource URL     */
      /* does not contain the current page state"                             */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET4);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPORTLET5              */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PORTLET, a resource URL with   */
      /* cacheability set to FULL may be generated"                           */
      TestResult tr16 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET5);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPORTLET6              */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PORTLET, a resource URL with   */
      /* cacheability set to PORTLET may be generated"                        */
      TestResult tr17 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET6);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPORTLET7              */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PORTLET, setting               */
      /* cacheability on a resource URL to PAGE results in an an              */
      /* IllegalStateException"                                               */
      TestResult tr18 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET7);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPORTLET8              */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PORTLET, an attempt to         */
      /* create a render URL results in an an IllegalStateException"          */
      TestResult tr19 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET8);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPORTLET9              */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PORTLET, an attempt to         */
      /* create an action URL results in an an IllegalStateException"         */
      TestResult tr20 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET9);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPAGE1                 */
      /* Details: "If the cache level is set to PAGE, the resource URL        */
      /* contains the current render parameters"                              */
      TestResult tr21 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE1);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPAGE2                 */
      /* Details: "If the cache level is set to PAGE, the resource URL        */
      /* contains the current PAGE mode"                                      */
      TestResult tr22 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE2);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPAGE3                 */
      /* Details: "If the cache level is set to PAGE, the resource URL        */
      /* contains the current window state"                                   */
      TestResult tr23 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE3);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPAGE4                 */
      /* Details: "If the cache level is set to PAGE, the resource URL        */
      /* contains the current page state"                                     */
      TestResult tr24 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE4);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPAGE5                 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PAGE, a resource URL with      */
      /* cacheability set to FULL may be generated"                           */
      TestResult tr25 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE5);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPAGE6                 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PAGE, a resource URL with      */
      /* cacheability set to PORTLET may be generated"                        */
      TestResult tr26 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE6);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPAGE7                 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PAGE, a resource URL with      */
      /* cacheability set to PAGE may be generated"                           */
      TestResult tr27 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE7);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPAGE8                 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PAGE, a render URL may be      */
      /* generated"                                                           */
      TestResult tr28 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE8);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServingCache_cachingPAGE9                 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PAGE, an action URL may be     */
      /* generated"                                                           */
      TestResult tr29 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE9);
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


   }

}

