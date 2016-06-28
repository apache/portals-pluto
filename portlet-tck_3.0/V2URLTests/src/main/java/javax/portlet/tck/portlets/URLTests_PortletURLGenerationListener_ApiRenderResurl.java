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
import java.io.StringWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.ResourceLink;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL7;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet URLTests_PortletURLGenerationListener_ApiRenderResurl_event
 *
 */
public class URLTests_PortletURLGenerationListener_ApiRenderResurl implements Portlet, ResourceServingPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {


      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {


      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      // evaluate results for test case V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL1
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr0 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL1);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval !=  null &&  tcval.equals("V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL1")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Resource");
            if (!ok) {
               tr0.appendTcDetail("Parameter not set by listener. Expected: Resource, actual: " + val);
            }
            tr0.setTcSuccess(ok);
            tr0.writeTo(writer);
         }
      }

      // evaluate results for test case V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL2
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr1 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL2);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval !=  null &&  tcval.equals("V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL2")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Resource");
            if (!ok) {
               tr1.appendTcDetail("Parameter not set by listener. Expected: Resource, actual: " + val);
            }
            tr1.setTcSuccess(ok);
            tr1.writeTo(writer);
         }
      }

      // evaluate results for test case V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL3
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr2 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL3);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval !=  null &&  tcval.equals("V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL3")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Resource");
            if (!ok) {
               tr2.appendTcDetail("Parameter not set by listener. Expected: Resource, actual: " + val);
            }
            tr2.setTcSuccess(ok);
            tr2.writeTo(writer);
         }
      }

      // evaluate results for test case V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL4
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr3 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL4);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval !=  null &&  tcval.equals("V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL4")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Resource");
            if (!ok) {
               tr3.appendTcDetail("Parameter not set by listener. Expected: Resource, actual: " + val);
            }
            tr3.setTcSuccess(ok);
            tr3.writeTo(writer);
         }
      }

      // evaluate results for test case V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL5
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr4 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL5);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval !=  null &&  tcval.equals("V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL5")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Resource");
            if (!ok) {
               tr4.appendTcDetail("Parameter not set by listener. Expected: Resource, actual: " + val);
            }
            tr4.setTcSuccess(ok);
            tr4.writeTo(writer);
         }
      }

      // evaluate results for test case V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL7
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr5 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL7);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval !=  null &&  tcval.equals("V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL7")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Resource");
            if (!ok) {
               tr5.appendTcDetail("Parameter not set by listener. Expected: Resource, actual: " + val);
            }
            tr5.setTcSuccess(ok);
            tr5.writeTo(writer);
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

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL1 */
      /* Details: "Method filterResourceURL(ResourceURL): The                 */
      /* filterResourceURL(ResourceURL): method is called before the          */
      /* toString() method is executed"                                       */
      TestResult tr0 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL1);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL1");
         String urlstr = turl.toString();
         
         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL1, urlstr);
         rl.writeResourceFetcher(writer);
      } catch(Exception e) {
         tr0.appendTcDetail(e);
         tr0.writeTo(writer);
      }

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL2 */
      /* Details: "Method filterResourceURL(ResourceURL): The                 */
      /* filterResourceURL(ResourceURL): method is called before the          */
      /* write(Writer out) method is executed"                                */
      TestResult tr1 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL2);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL2");
         StringWriter tsw = new StringWriter();
         turl.write(tsw);
         String urlstr = tsw.toString();
         
         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL2, urlstr);
         rl.writeResourceFetcher(writer);
      } catch(Exception e) {
         tr1.appendTcDetail(e);
         tr1.writeTo(writer);
      }

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL3 */
      /* Details: "Method filterResourceURL(ResourceURL): The                 */
      /* filterResourceURL(ResourceURL): method is called before the          */
      /* write(Writer out, boolean escapeXML) method is executed"             */
      TestResult tr2 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL3);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL3");
         StringWriter tsw = new StringWriter();
         turl.write(tsw, true);
         String urlstr = tsw.toString();
         
         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL3, urlstr);
         rl.writeResourceFetcher(writer);
      } catch(Exception e) {
         tr2.appendTcDetail(e);
         tr2.writeTo(writer);
      }

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL4 */
      /* Details: "Method filterResourceURL(ResourceURL): The                 */
      /* filterResourceURL method is passed the ResourceURL object            */
      /* representing the resource URL"                                       */
      TestResult tr3 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL4);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL4");
         String urlstr = turl.toString();
         
         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL4, urlstr);
         rl.writeResourceFetcher(writer);
      } catch(Exception e) {
         tr3.appendTcDetail(e);
         tr3.writeTo(writer);
      }

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL5 */
      /* Details: "Method filterResourceURL(ResourceURL): The input URL       */
      /* object can be modified by setting a parameter and the modified URL   */
      /* object is processed by the ResourceURL toString or write method"     */
      TestResult tr4 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL5);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL5");
         String urlstr = turl.toString();
         
         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL5, urlstr);
         rl.writeResourceFetcher(writer);
      } catch(Exception e) {
         tr4.appendTcDetail(e);
         tr4.writeTo(writer);
      }

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL7 */
      /* Details: "Method filterResourceURL(ResourceURL): The input URL       */
      /* object can be modified by setting the resource ID and the modified   */
      /* URL object is processed by the ResourceURL toString or write         */
      /* method"                                                              */
      TestResult tr5 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL7);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL7");
         String urlstr = turl.toString();
         
         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL7, urlstr);
         rl.writeResourceFetcher(writer);
      } catch(Exception e) {
         tr5.appendTcDetail(e);
         tr5.writeTo(writer);
      }

   }

}
