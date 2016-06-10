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
 * portlet URLTests_PortletURLGenerationListener_ApiRenderRenurl_event
 *
 */
public class URLTests_PortletURLGenerationListener_ApiRenderRenurl implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         URLTests_PortletURLGenerationListener_ApiRenderRenurl.class.getName();
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


      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {


      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {


      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(PortletURLGenerationListener.class);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL1 */
      /* Details: "Method filterRenderURL(PortletURL): The                    */
      /* filterRenderURL(PortletURL): method is called before the             */
      /* toString() method is executed"                                       */
      TestResult tr0 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRENURL_FILTERRENDERURL1);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL1");
         String urlstr = turl.toString();
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL1", urlstr);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval !=  null &&  tcval.equals("V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL1")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Render");
            if (!ok) {
               tr0.appendTcDetail("Parameter not set by listener. Expected: Render, actual: " + val);
            }
            tr0.setTcSuccess(ok);
         }
      } catch(Exception e) {tr0.appendTcDetail(e);}
      tr0.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL2 */
      /* Details: "Method filterRenderURL(PortletURL): The                    */
      /* filterRenderURL(PortletURL): method is called before the             */
      /* write(Writer out) method is executed"                                */
      TestResult tr1 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRENURL_FILTERRENDERURL2);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL2");
         StringWriter tsw = new StringWriter();
         turl.write(tsw);
         String urlstr = tsw.toString();
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL2", urlstr);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval !=  null &&  tcval.equals("V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL2")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Render");
            if (!ok) {
               tr1.appendTcDetail("Parameter not set by listener. Expected: Render, actual: " + val);
            }
            tr1.setTcSuccess(ok);
         }
      } catch(Exception e) {tr1.appendTcDetail(e);}
      tr1.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL3 */
      /* Details: "Method filterRenderURL(PortletURL): The                    */
      /* filterRenderURL(PortletURL): method is called before the             */
      /* write(Writer out, boolean escapeXML) method is executed"             */
      TestResult tr2 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRENURL_FILTERRENDERURL3);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL3");
         StringWriter tsw = new StringWriter();
         turl.write(tsw, true);
         String urlstr = tsw.toString();
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL3", urlstr);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval !=  null &&  tcval.equals("V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL3")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Render");
            if (!ok) {
               tr2.appendTcDetail("Parameter not set by listener. Expected: Render, actual: " + val);
            }
            tr2.setTcSuccess(ok);
         }
      } catch(Exception e) {tr2.appendTcDetail(e);}
      tr2.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL4 */
      /* Details: "Method filterRenderURL(PortletURL): The filterRenderURL    */
      /* method is passed the PortletURL object representing the render       */
      /* URL"                                                                 */
      TestResult tr3 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRENURL_FILTERRENDERURL4);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL4");
         String urlstr = turl.toString();
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL4", urlstr);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval !=  null &&  tcval.equals("V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL4")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Render");
            if (!ok) {
               tr3.appendTcDetail("Parameter not set by listener. Expected: Render, actual: " + val);
            }
            tr3.setTcSuccess(ok);
         }
      } catch(Exception e) {tr3.appendTcDetail(e);}
      tr3.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL5 */
      /* Details: "Method filterRenderURL(PortletURL): The input URL object   */
      /* can be modified by setting a parameter and the modified URL object   */
      /* is processed by the PortletURL toString or write method"             */
      TestResult tr4 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRENURL_FILTERRENDERURL5);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL5");
         String urlstr = turl.toString();
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL5", urlstr);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval !=  null &&  tcval.equals("V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL5")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Render");
            if (!ok) {
               tr4.appendTcDetail("Parameter not set by listener. Expected: Render, actual: " + val);
            }
            tr4.setTcSuccess(ok);
         }
      } catch(Exception e) {tr4.appendTcDetail(e);}
      tr4.writeTo(writer);

   }

}
