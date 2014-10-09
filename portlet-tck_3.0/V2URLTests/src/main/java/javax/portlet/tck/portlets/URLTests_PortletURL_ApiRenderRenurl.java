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
 * portlet URLTests_PortletURL_ApiRenderRenurl_event
 *
 */
public class URLTests_PortletURL_ApiRenderRenurl implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         URLTests_PortletURL_ApiRenderRenurl.class.getName();
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

      PortletURL url = portletResp.createRenderURL();
      ClassChecker cc = new ClassChecker(url.getClass());

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_setWindowState1      */
      /* Details: "Method setWindowState(WindowState): Sets the WindowState   */
      /* to be used when the URL is activated"                                */
      TestResult tr0 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETWINDOWSTATE1);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_PortletURL_ApiRenderRenurl_setWindowState1");
         turl.setWindowState(WindowState.NORMAL);

         // if possible set the window state to full through the setup link
         if (portletReq.isWindowStateAllowed(WindowState.MAXIMIZED)) {
            PortletURL rurl = portletResp.createRenderURL();
            rurl.setWindowState(WindowState.MAXIMIZED);
            TestSetupLink tsl = new TestSetupLink("V2URLTests_PortletURL_ApiRenderRenurl_setWindowState1", rurl);
            tsl.writeTo(writer);
         }
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_PortletURL_ApiRenderRenurl_setWindowState1", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval.equals("V2URLTests_PortletURL_ApiRenderRenurl_setWindowState1")) {
            WindowState ws = portletReq.getWindowState();
            boolean ok = (ws.equals(WindowState.NORMAL));
            if (!ok) {
               String wstr = (ws==null) ? "null" : ws.toString();
               tr0.appendTcDetail("WindowState expected: " + WindowState.NORMAL + ", actual: " + wstr);
            }
            tr0.setTcSuccess(ok);
         }
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_setWindowState2      */
      /* Details: "Method setWindowState(WindowState): Throws                 */
      /* WindowStateException if the portal does not support the specified    */
      /* Window State"                                                        */
      TestResult tr1 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETWINDOWSTATE2);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_PortletURL_ApiRenderRenurl_setWindowState2");
         try {
            WindowState ws = new WindowState("UnsupportedState");
            turl.setWindowState(ws);
         } catch(WindowStateException e) {
            tr1.setTcSuccess(true);
         }
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode1      */
      /* Details: "Method setPortletMode(PortletMode): Sets the PortletMode   */
      /* to be used when the URL is activated"                                */
      TestResult tr2 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETPORTLETMODE1);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode1");
         turl.setPortletMode(PortletMode.VIEW);

         // if possible set the window state to full through the setup link
         if (portletReq.isPortletModeAllowed(PortletMode.EDIT)) {
            PortletURL rurl = portletResp.createRenderURL();
            rurl.setPortletMode(PortletMode.EDIT);
            TestSetupLink tsl = new TestSetupLink("V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode1", rurl);
            tsl.writeTo(writer);
         }
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode1", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval.equals("V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode1")) {
            PortletMode pm = portletReq.getPortletMode();
            boolean ok = (pm.equals(PortletMode.VIEW));
            if (!ok) {
               String pstr = (pm==null) ? "null" : pm.toString();
               tr2.appendTcDetail("PortletMode expected: " + PortletMode.VIEW + ", actual: " + pstr);
            }
            tr2.setTcSuccess(ok);
         }
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode2      */
      /* Details: "Method setPortletMode(PortletMode): Throws                 */
      /* PortletModeException if the portal does not support the specified    */
      /* PortletMode"                                                         */
      TestResult tr3 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETPORTLETMODE2);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode2");
         try {
            PortletMode pm = new PortletMode("UnsupportedMode");
            turl.setPortletMode(pm);
         } catch(PortletModeException e) {
            tr3.setTcSuccess(true);
         }
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode3      */
      /* Details: "Method setPortletMode(PortletMode): Throws                 */
      /* PortletModeException if the specified PortletMode is not declared    */
      /* in the deployment descriptor"                                        */
      TestResult tr4 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETPORTLETMODE3);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode3");
         try {
            turl.setPortletMode(PortletMode.HELP);
         } catch(PortletModeException e) {
            tr4.setTcSuccess(true);
         }
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_getPortletMode1      */
      /* Details: "Method getPortletMode(): Returns the PortletMode object    */
      /* set on the URL"                                                      */
      TestResult tr5 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETPORTLETMODE1);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_PortletURL_ApiRenderRenurl_getPortletMode1");
         turl.setPortletMode(PortletMode.VIEW);
         PortletMode pm = turl.getPortletMode();
         boolean ok = (pm != null);
         if (!ok) {
            tr5.appendTcDetail("PortletMode expected: " + PortletMode.VIEW + ", actual: " + "null");
         }
         tr5.setTcSuccess(ok);
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_getPortletMode2      */
      /* Details: "Method getPortletMode(): Returns null if the PortletMode   */
      /* has not been set"                                                    */
      TestResult tr6 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETPORTLETMODE2);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_PortletURL_ApiRenderRenurl_getPortletMode2");
         PortletMode pm = turl.getPortletMode();
         boolean ok = (pm == null);
         if (!ok) {
            tr6.appendTcDetail("PortletMode expected: null, actual: " + pm.toString());
         }
         tr6.setTcSuccess(ok);
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_getWindowState1      */
      /* Details: "Method getWindowState(): Returns the WindowState object    */
      /* set on the URL"                                                      */
      TestResult tr7 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETWINDOWSTATE1);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_PortletURL_ApiRenderRenurl_getWindowState1");
         turl.setWindowState(WindowState.NORMAL);
         WindowState ws = turl.getWindowState();
         boolean ok = (ws != null);
         if (!ok) {
            tr7.appendTcDetail("WindowState expected: " + WindowState.NORMAL + ", actual: " + "null");
         }
         tr7.setTcSuccess(ok);
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_getWindowState2      */
      /* Details: "Method getWindowState(): Returns null if the Window        */
      /* State has not been set"                                              */
      TestResult tr8 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETWINDOWSTATE2);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_PortletURL_ApiRenderRenurl_getWindowState2");
         WindowState ws = turl.getWindowState();
         boolean ok = (ws == null);
         if (!ok) {
            tr8.appendTcDetail("WindowState expected: null, actual: " + ws.toString());
         }
         tr8.setTcSuccess(ok);
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_removePublicRenderParameter1 */
      /* Details: "Method removePublicRenderParameter(String): Removes the    */
      /* specified public render parameter"                                   */
      TestResult tr9 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_REMOVEPUBLICRENDERPARAMETER1);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_PortletURL_ApiRenderRenurl_removePublicRenderParameter1");
         turl.removePublicRenderParameter("tckPRP1");
         
// set the prp through the setup link
         PortletURL rurl = portletResp.createRenderURL();
         rurl.setParameter("tckPRP1", "V2URLTests_PortletURL_ApiRenderRenurl_removePublicRenderParameter1");
         TestSetupLink tsl = new TestSetupLink("V2URLTests_PortletURL_ApiRenderRenurl_removePublicRenderParameter1", rurl);
         tsl.writeTo(writer);
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_PortletURL_ApiRenderRenurl_removePublicRenderParameter1", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval.equals("V2URLTests_PortletURL_ApiRenderRenurl_removePublicRenderParameter1")) {
            String val = portletReq.getParameter("tckPRP1");
            CompareUtils.stringsEqual("Request PRP name=tckPRP1 ", val, " expected ", null, tr9);
         }
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: V2URLTests_PortletURL_ApiRenderRenurl_removePublicRenderParameter2 */
      /* Details: "Method removePublicRenderParameter(String): Throws         */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr10 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURL_APIRENDERRENURL_REMOVEPUBLICRENDERPARAMETER2);
      try {
         try {
            PortletURL turl = portletResp.createRenderURL();
            turl.removePublicRenderParameter(null);
            tr10.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr10.setTcSuccess(true);
         } catch (Exception e) {
            tr10.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

   }

}
