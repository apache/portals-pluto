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
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
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
 * portlet AddlPortletTests_SPEC2_13_ResourceServingCache_event
 *
 */
public class AddlPortletTests_SPEC2_13_ResourceServingCache implements Portlet, ResourceServingPortlet {
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

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_caching1  */
      /* Details: "If portlet URLs are included in the markup, portals /      */
      /* portlet containers must create correct portlet URLs for all          */
      /* text-based markup types."                                            */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHING1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_caching2  */
      /* Details: "The portlet can use the setCacheability method to set      */
      /* the cache level for the ResourceURL"                                 */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHING2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_caching3  */
      /* Details: "If the cache level is not set, a generated resource URL    */
      /* has the cacheability of the request in which it was created"         */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHING3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL1 */
      /* Details: "If the cache level is set to FULL, the resource URL does   */
      /* not contain the current render parameters"                           */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL1);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL2 */
      /* Details: "If the cache level is set to FULL, the resource URL does   */
      /* not contain the current portlet mode"                                */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL2);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL3 */
      /* Details: "If the cache level is set to FULL, the resource URL does   */
      /* not contain the current window state"                                */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL3);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL4 */
      /* Details: "If the cache level is set to FULL, the resource URL does   */
      /* not contain the current page state"                                  */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL4);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL5 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to FULL, a resource URL with      */
      /* cacheability set to FULL may be generated"                           */
      TestResult tr7 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL5);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL6 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to FULL, setting cacheability     */
      /* on a resource URL to PORTLET results in an an                        */
      /* IllegalStateException"                                               */
      TestResult tr8 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL6);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL7 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to FULL, setting cacheability     */
      /* on a resource URL to PAGE results in an an IllegalStateException"    */
      TestResult tr9 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL7);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL8 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to FULL, an attempt to create a   */
      /* render URL results in an an IllegalStateException"                   */
      TestResult tr10 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL8);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL9 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to FULL, an attempt to create     */
      /* an action URL results in an an IllegalStateException"                */
      TestResult tr11 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL9);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET1 */
      /* Details: "If the cache level is set to PORTLET, the resource URL     */
      /* contains the current render parameters"                              */
      TestResult tr12 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET1);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET2 */
      /* Details: "If the cache level is set to PORTLET, the resource URL     */
      /* contains the current portlet mode"                                   */
      TestResult tr13 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET2);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET3 */
      /* Details: "If the cache level is set to PORTLET, the resource URL     */
      /* contains the current window state"                                   */
      TestResult tr14 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET3);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET4 */
      /* Details: "If the cache level is set to PORTLET, the resource URL     */
      /* does not contain the current page state"                             */
      TestResult tr15 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET4);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET5 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PORTLET, a resource URL with   */
      /* cacheability set to FULL may be generated"                           */
      TestResult tr16 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET5);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET6 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PORTLET, a resource URL with   */
      /* cacheability set to PORTLET may be generated"                        */
      TestResult tr17 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET6);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET7 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PORTLET, setting               */
      /* cacheability on a resource URL to PAGE results in an an              */
      /* IllegalStateException"                                               */
      TestResult tr18 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET7);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET8 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PORTLET, an attempt to         */
      /* create a render URL results in an an IllegalStateException"          */
      TestResult tr19 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET8);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET9 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PORTLET, an attempt to         */
      /* create an action URL results in an an IllegalStateException"         */
      TestResult tr20 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET9);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE1 */
      /* Details: "If the cache level is set to PAGE, the resource URL        */
      /* contains the current render parameters"                              */
      TestResult tr21 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE1);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE2 */
      /* Details: "If the cache level is set to PAGE, the resource URL        */
      /* contains the current PAGE mode"                                      */
      TestResult tr22 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE2);
      /* TODO: implement test */
      tr22.appendTcDetail("Not implemented.");
      tr22.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE3 */
      /* Details: "If the cache level is set to PAGE, the resource URL        */
      /* contains the current window state"                                   */
      TestResult tr23 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE3);
      /* TODO: implement test */
      tr23.appendTcDetail("Not implemented.");
      tr23.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE4 */
      /* Details: "If the cache level is set to PAGE, the resource URL        */
      /* contains the current page state"                                     */
      TestResult tr24 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE4);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE5 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PAGE, a resource URL with      */
      /* cacheability set to FULL may be generated"                           */
      TestResult tr25 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE5);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE6 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PAGE, a resource URL with      */
      /* cacheability set to PORTLET may be generated"                        */
      TestResult tr26 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE6);
      /* TODO: implement test */
      tr26.appendTcDetail("Not implemented.");
      tr26.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE7 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PAGE, a resource URL with      */
      /* cacheability set to PAGE may be generated"                           */
      TestResult tr27 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE7);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE8 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PAGE, a render URL may be      */
      /* generated"                                                           */
      TestResult tr28 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE8);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE9 */
      /* Details: "In a resource request resulting from triggering a          */
      /* resource URL with cacheability set to PAGE, an action URL may be     */
      /* generated"                                                           */
      TestResult tr29 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE9);
      /* TODO: implement test */
      tr29.appendTcDetail("Not implemented.");
      tr29.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write("<div id=\"AddlPortletTests_SPEC2_13_ResourceServingCache\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write("         document.getElementById(\"AddlPortletTests_SPEC2_13_ResourceServingCache\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
