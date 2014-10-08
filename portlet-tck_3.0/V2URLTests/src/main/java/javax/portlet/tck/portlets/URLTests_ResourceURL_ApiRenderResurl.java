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
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
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
 * portlet URLTests_ResourceURL_ApiRenderResurl_event
 *
 */
public class URLTests_ResourceURL_ApiRenderResurl implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         URLTests_ResourceURL_ApiRenderResurl.class.getName();
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

      // evaluate results for test case V2URLTests_ResourceURL_ApiRenderResurl_setResourceID
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr4 = tcd.getTestResultFailed(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETRESOURCEID);
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_ResourceURL_ApiRenderResurl_setResourceID")) {
            String resid = portletReq.getResourceID();
            boolean ok = (resid.equals("TestResourceID"));
            if (!ok) {
               tr4.appendTcDetail("ResourceID expected: \"TestResourceID\", actual: " + resid);
            }
            tr4.setTcSuccess(ok);
            tr4.writeTo(writer);
         }
      }

      // evaluate results for test case V2URLTests_ResourceURL_ApiRenderResurl_setCacheability1
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr6 = tcd.getTestResultFailed(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY1);
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_ResourceURL_ApiRenderResurl_setCacheability1")) {
            String c = portletReq.getCacheability();
            boolean ok = (c.equals(ResourceURL.PORTLET));
            if (!ok) {
               tr6.appendTcDetail("Cacheability expected: " + ResourceURL.PORTLET + ", actual: " + c);
            }
            tr6.setTcSuccess(ok);
            tr6.writeTo(writer);
         }
      }

      // evaluate results for test case V2URLTests_ResourceURL_ApiRenderResurl_setCacheability3
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr8 = tcd.getTestResultFailed(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY3);
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_ResourceURL_ApiRenderResurl_setCacheability3")) {
            try {
               ResourceURL rurl = portletResp.createResourceURL();
               rurl.setCacheability(ResourceURL.PAGE);
            } catch (IllegalStateException ise) {
               tr8.setTcSuccess(true);
            } catch (Exception e) {
               tr8.appendTcDetail(e.toString());
            }
            tr8.writeTo(writer);
         }
      }

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ResourceURL url = portletResp.createResourceURL();      ClassChecker cc = new ClassChecker(url.getClass());

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_fieldFULL           */
      /* Details: "Has String field FULL with value of \"cacheLevelFull\" "   */
      TestResult tr0 = tcd.getTestResultFailed(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDFULL);
      try {
         tr0.setTcSuccess(cc.hasField("FULL", "cacheLevelFull"));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_fieldPAGE           */
      /* Details: "Has String field PAGE with value of \"cacheLevelPage\" "   */
      TestResult tr1 = tcd.getTestResultFailed(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDPAGE);
      try {
         tr1.setTcSuccess(cc.hasField("PAGE", "cacheLevelPage"));
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_fieldPORTLET        */
      /* Details: "Has String field PORTLET with value of                     */
      /* \"cacheLevelPortlet\" "                                              */
      TestResult tr2 = tcd.getTestResultFailed(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDPORTLET);
      try {
         tr2.setTcSuccess(cc.hasField("PORTLET", "cacheLevelPortlet"));
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_fieldSHARED         */
      /* Details: "Has String field SHARED with value of                      */
      /* \"javax.portlet.shared\" "                                           */
      TestResult tr3 = tcd.getTestResultFailed(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDSHARED);
      try {
         tr3.setTcSuccess(cc.hasField("SHARED", "javax.portlet.shared"));
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_setResourceID       */
      /* Details: "Method setResourceID(String): Sets the specified String    */
      /* as the portlet resource ID"                                          */
      TestResult tr4 = tcd.getTestResultFailed(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETRESOURCEID);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_ResourceURL_ApiRenderResurl_setResourceID");
         turl.setResourceID("TestResourceID");
         
         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink("V2URLTests_ResourceURL_ApiRenderResurl_setResourceID", turl);
         rl.writeResourceFetcher(writer);
      } catch(Exception e) {
         tr4.appendTcDetail(e.toString());
         tr4.writeTo(writer);
      }

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_getCacheability     */
      /* Details: "Method getCacheability(): Returns a String containing      */
      /* the cacheability level set on the resource URL"                      */
      TestResult tr5 = tcd.getTestResultFailed(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_GETCACHEABILITY);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_ResourceURL_ApiRenderResurl_getCacheability");
         String c = turl.getCacheability();
         boolean ok = ((c != null) && ResourceURL.PAGE.equals(c));
         if (!ok) {
            tr5.appendTcDetail("Cacheability expected: " + ResourceURL.PAGE + ", actual: " + c);
         }
         tr5.setTcSuccess(ok);
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_setCacheability1    */
      /* Details: "Method setCacheability(String): Sets the cacheability      */
      /* level for the resource URL"                                          */
      TestResult tr6 = tcd.getTestResultFailed(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY1);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_ResourceURL_ApiRenderResurl_setCacheability1");
         turl.setCacheability(ResourceURL.PORTLET);
         
         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink("V2URLTests_ResourceURL_ApiRenderResurl_setCacheability1", turl);
         rl.writeResourceFetcher(writer);
      } catch(Exception e) {
         tr6.appendTcDetail(e.toString());
         tr6.writeTo(writer);
      }

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_setCacheability2    */
      /* Details: "Method setCacheability(String): Throws                     */
      /* IllegalArgumentException if the input parameter does not have a      */
      /* value of \"FULL\", \"PAGE\", or \"PORTLET\""                         */
      TestResult tr7 = tcd.getTestResultFailed(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY2);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_ResourceURL_ApiRenderResurl_setCacheability2");
         try {
            turl.setCacheability("InvalidCacheability");;
         } catch (IllegalArgumentException iae) {
            tr7.setTcSuccess(true);
         } catch (Exception e) {
            tr7.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_setCacheability3    */
      /* Details: "Method setCacheability(String): Throws                     */
      /* IllegalStateException if the specified cacheability level is         */
      /* weaker than the cacheability level for the parent resource URL"      */
      TestResult tr8 = tcd.getTestResultFailed(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY3);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_ResourceURL_ApiRenderResurl_setCacheability3");
         turl.setCacheability(ResourceURL.PORTLET);
         
         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink("V2URLTests_ResourceURL_ApiRenderResurl_setCacheability3", turl);
         rl.writeResourceFetcher(writer);
      } catch(Exception e) {
         tr8.appendTcDetail(e.toString());
         tr8.writeTo(writer);
      }

   }

}
