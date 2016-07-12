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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.CompareUtils;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.ResourceLink;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupLink;

import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL8;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETRESOURCEID;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDFULL;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDPAGE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDPORTLET;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDSHARED;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL7;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL9;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_RESOURCEURL_APIRENDERRESURL_GETCACHEABILITY;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY2;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for
 * events, this portlet will initiate the events, but not process them. The
 * processing is done in the companion portlet
 * URLTests_ResourceURL_ApiRenderResurl_event
 *
 */
public class URLTests_ResourceURL_ApiRenderResurl
      implements Portlet, ResourceServingPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

   }

   @Override
   public void serveResource(ResourceRequest portletReq,
         ResourceResponse portletResp) throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      // evaluate results for test case
      // V2URLTests_ResourceURL_ApiRenderResurl_resourceURL4
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr4 = tcd.getTestResultFailed(
               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL4);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_ResourceURL_ApiRenderResurl_resourceURL4")) {
            String[] vals = portletReq.getParameterValues("tckPRP1");
            String[] evals = { "resourceParm", "renderParm" };
            CompareUtils.arraysEqual("Request parameter name=tckPRP1 ", vals,
                  " expected ", evals, tr4);
            tr4.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_ResourceURL_ApiRenderResurl_resourceURL5
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr5 = tcd.getTestResultFailed(
               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL5);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_ResourceURL_ApiRenderResurl_resourceURL5")) {
            String[] vals = portletReq.getParameterValues("parm1");
            String[] evals = { "resourceParm", "renderParm" };
            CompareUtils.arraysEqual("Request parameter name=parm1 ", vals,
                  " expected ", evals, tr5);
            tr5.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_ResourceURL_ApiRenderResurl_resourceURL6
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr6 = tcd.getTestResultFailed(
               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL6);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_ResourceURL_ApiRenderResurl_resourceURL6")) {
            String val = portletReq.getParameter("tckPRP1");
            CompareUtils.stringsEqual("Request parameter name=tckPRP1 ", val,
                  " expected ",
                  "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL6", tr6);
            tr6.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_ResourceURL_ApiRenderResurl_resourceURL8
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr8 = tcd.getTestResultFailed(
               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL8);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_ResourceURL_ApiRenderResurl_resourceURL8")) {
            String val = portletReq.getParameter("parm1");
            CompareUtils.stringsEqual("Request parameter name=parm1 ", val,
                  " expected ",
                  "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL8", tr8);
            tr8.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_ResourceURL_ApiRenderResurl_setResourceID
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr10 = tcd.getTestResultFailed(
               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETRESOURCEID);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_ResourceURL_ApiRenderResurl_setResourceID")) {
            String resid = portletReq.getResourceID();
            boolean ok = (resid.equals("TestResourceID"));
            if (!ok) {
               tr10.appendTcDetail(
                     "ResourceID expected: \"TestResourceID\", actual: "
                           + resid);
            }
            tr10.setTcSuccess(ok);
            tr10.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_ResourceURL_ApiRenderResurl_setCacheability1
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr12 = tcd.getTestResultFailed(
               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY1);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_ResourceURL_ApiRenderResurl_setCacheability1")) {
            String c = portletReq.getCacheability();
            boolean ok = (c.equals(ResourceURL.PORTLET));
            if (!ok) {
               tr12.appendTcDetail("Cacheability expected: "
                     + ResourceURL.PORTLET + ", actual: " + c);
            }
            tr12.setTcSuccess(ok);
            tr12.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_ResourceURL_ApiRenderResurl_setCacheability3
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr14 = tcd.getTestResultFailed(
               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY3);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_ResourceURL_ApiRenderResurl_setCacheability3")) {
            try {
               ResourceURL rurl = portletResp.createResourceURL();
               rurl.setCacheability(ResourceURL.PAGE);
            } catch (IllegalStateException ise) {
               tr14.setTcSuccess(true);
            } catch (Exception e) {
               tr14.appendTcDetail(e);
            }
            tr14.writeTo(writer);
         }
      }

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ResourceURL url = portletResp.createResourceURL();
      ClassChecker cc = new ClassChecker(url.getClass());

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_fieldFULL */
      /* Details: "Has String field FULL with value of \"cacheLevelFull\" " */
      TestResult tr0 = tcd.getTestResultFailed(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDFULL);
      try {
         tr0.setTcSuccess(cc.hasField("FULL", "cacheLevelFull"));
      } catch (Exception e) {
         tr0.appendTcDetail(e);
      }
      tr0.writeTo(writer);

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_fieldPAGE */
      /* Details: "Has String field PAGE with value of \"cacheLevelPage\" " */
      TestResult tr1 = tcd.getTestResultFailed(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDPAGE);
      try {
         tr1.setTcSuccess(cc.hasField("PAGE", "cacheLevelPage"));
      } catch (Exception e) {
         tr1.appendTcDetail(e);
      }
      tr1.writeTo(writer);

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_fieldPORTLET */
      /* Details: "Has String field PORTLET with value of */
      /* \"cacheLevelPortlet\" " */
      TestResult tr2 = tcd.getTestResultFailed(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDPORTLET);
      try {
         tr2.setTcSuccess(cc.hasField("PORTLET", "cacheLevelPortlet"));
      } catch (Exception e) {
         tr2.appendTcDetail(e);
      }
      tr2.writeTo(writer);

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_fieldSHARED */
      /* Details: "Has String field SHARED with value of */
      /* \"javax.portlet.shared\" " */
      TestResult tr3 = tcd.getTestResultFailed(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDSHARED);
      try {
         tr3.setTcSuccess(cc.hasField("SHARED", "javax.portlet.shared"));
      } catch (Exception e) {
         tr3.appendTcDetail(e);
      }
      tr3.writeTo(writer);

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_resourceURL4 */
      /* Details: "A resource parameter with the same name as a public */
      /* render parameter appears before the public render parameter in the */
      /* values array" */
      TestResult tr4 = tcd.getTestResultFailed(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL4);
      try {
         // set a parameter through the setup link
         PortletURL rurl = portletResp.createRenderURL();
         rurl.setParameter("tckPRP1", "renderParm");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL4", rurl);
         tsl.writeTo(writer);

         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL4");
         turl.setParameter("tckPRP1", "resourceParm");

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL4", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr4.appendTcDetail(e);
         tr4.writeTo(writer);
      }

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_resourceURL5 */
      /* Details: "A resource parameter with the same name as a private */
      /* render parameter appears before the private render parameter in */
      /* the values array" */
      TestResult tr5 = tcd.getTestResultFailed(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL5);
      try {
         // set a parameter through the setup link
         PortletURL rurl = portletResp.createRenderURL();
         rurl.setParameter("parm1", "renderParm");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL5", rurl);
         tsl.writeTo(writer);

         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL5");
         turl.setParameter("parm1", "resourceParm");

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL5", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr5.appendTcDetail(e);
         tr5.writeTo(writer);
      }

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_resourceURL6 */
      /* Details: "When a resource URL is created, public render parameters */
      /* from the current request are automatically copied to the new */
      /* resource URL" */
      TestResult tr6 = tcd.getTestResultFailed(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL6);
      try {
         // set a parameter through the setup link
         PortletURL rurl = portletResp.createRenderURL();
         rurl.setParameter("tckPRP1",
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL6");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL6", rurl);
         tsl.writeTo(writer);

         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL6");

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL6", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr6.appendTcDetail(e);
         tr6.writeTo(writer);
      }

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_resourceURL7 */
      /* Details: "When a resource URL is created, the automatically copied */
      /* public render parameters are hidden to the ResourceURL */
      /* getParameter method" */
      TestResult tr7 = tcd.getTestResultFailed(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL7);
      try {
         // set a parameter through the setup link
         PortletURL rurl = portletResp.createRenderURL();
         rurl.setParameter("tckPRP1",
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL7");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL7", rurl);
         tsl.writeTo(writer);

         ResourceURL turl = portletResp.createResourceURL();
         String[] vals = (String[]) turl.getParameterMap().get("tckPRP1");
         CompareUtils.arraysEqual("Request parameter name=tckPRP1 ", vals,
               " expected ", null, tr7);
      } catch (Exception e) {
         tr7.appendTcDetail(e);
      }
      tr7.writeTo(writer);

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_resourceURL8 */
      /* Details: "When a resource URL is created, private render */
      /* parameters from the current request are automatically copied to */
      /* the new resource URL" */
      TestResult tr8 = tcd.getTestResultFailed(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL8);
      try {
         // set a parameter through the setup link
         PortletURL rurl = portletResp.createRenderURL();
         rurl.setParameter("parm1",
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL8");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL8", rurl);
         tsl.writeTo(writer);

         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL8");

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL8", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr8.appendTcDetail(e);
         tr8.writeTo(writer);
      }

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_resourceURL9 */
      /* Details: "When a resource URL is created, the automatically copied */
      /* private render parameters are hidden to the ResourceURL */
      /* getParameter method" */
      TestResult tr9 = tcd.getTestResultFailed(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL9);
      try {
         // set a parameter through the setup link
         PortletURL rurl = portletResp.createRenderURL();
         rurl.setParameter("parm1",
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL9");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL9", rurl);
         tsl.writeTo(writer);

         ResourceURL turl = portletResp.createResourceURL();
         String[] vals = (String[]) turl.getParameterMap().get("parm1");
         CompareUtils.arraysEqual("Request parameter name=parm1 ", vals,
               " expected ", null, tr9);
      } catch (Exception e) {
         tr9.appendTcDetail(e);
      }
      tr9.writeTo(writer);

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_setResourceID */
      /* Details: "Method setResourceID(String): Sets the specified String */
      /* as the portlet resource ID" */
      TestResult tr10 = tcd.getTestResultFailed(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETRESOURCEID);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_ResourceURL_ApiRenderResurl_setResourceID");
         turl.setResourceID("TestResourceID");

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_ResourceURL_ApiRenderResurl_setResourceID", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr10.appendTcDetail(e);
         tr10.writeTo(writer);
      }

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_getCacheability */
      /* Details: "Method getCacheability(): Returns a String containing */
      /* the cacheability level set on the resource URL" */
      TestResult tr11 = tcd.getTestResultFailed(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_GETCACHEABILITY);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_ResourceURL_ApiRenderResurl_getCacheability");
         String c = turl.getCacheability();
         boolean ok = ((c != null) && ResourceURL.PAGE.equals(c));
         if (!ok) {
            tr11.appendTcDetail("Cacheability expected: " + ResourceURL.PAGE
                  + ", actual: " + c);
         }
         tr11.setTcSuccess(ok);
      } catch (Exception e) {
         tr11.appendTcDetail(e);
      }
      tr11.writeTo(writer);

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_setCacheability1 */
      /* Details: "Method setCacheability(String): Sets the cacheability */
      /* level for the resource URL" */
      TestResult tr12 = tcd.getTestResultFailed(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY1);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_ResourceURL_ApiRenderResurl_setCacheability1");
         turl.setCacheability(ResourceURL.PORTLET);

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_ResourceURL_ApiRenderResurl_setCacheability1", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr12.appendTcDetail(e);
         tr12.writeTo(writer);
      }

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_setCacheability2 */
      /* Details: "Method setCacheability(String): Throws */
      /* IllegalArgumentException if the input parameter does not have a */
      /* value of \"FULL\", \"PAGE\", or \"PORTLET\"" */
      TestResult tr13 = tcd.getTestResultFailed(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY2);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_ResourceURL_ApiRenderResurl_setCacheability2");
         try {
            turl.setCacheability("InvalidCacheability");
            ;
         } catch (IllegalArgumentException iae) {
            tr13.setTcSuccess(true);
         } catch (Exception e) {
            tr13.appendTcDetail(e);
         }
      } catch (Exception e) {
         tr13.appendTcDetail(e);
      }
      tr13.writeTo(writer);

      /* TestCase: V2URLTests_ResourceURL_ApiRenderResurl_setCacheability3 */
      /* Details: "Method setCacheability(String): Throws */
      /* IllegalStateException if the specified cacheability level is */
      /* weaker than the cacheability level for the parent resource URL" */
      TestResult tr14 = tcd.getTestResultFailed(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY3);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_ResourceURL_ApiRenderResurl_setCacheability3");
         turl.setCacheability(ResourceURL.PORTLET);

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_ResourceURL_ApiRenderResurl_setCacheability3", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr14.appendTcDetail(e);
         tr14.writeTo(writer);
      }

   }

}
