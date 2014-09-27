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
 * portlet URLTests_BaseURL_ApiRenderRenurl_event
 *
 */
public class URLTests_BaseURL_ApiRenderRenurl implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         URLTests_BaseURL_ApiRenderRenurl.class.getName();
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

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameterA1          */
      /* Details: "Method setParameter(String, String): Sets the parameter    */
      /* value for the specified name"                                        */
      TestResult tr0 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA1);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderRenurl_setParameterA1");
         turl.setParameter("parm1", "val1");
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameterA1", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameterA1")) {
            String aval = portletReq.getParameter("parm1");
            String eval = "val1";
            CompareUtils.stringsEqual("Request", aval, " expected: ", eval, tr0);
         }
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameterA2          */
      /* Details: "Method setParameter(String, String): A private parameter   */
      /* can be set"                                                          */
      TestResult tr1 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA2);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderRenurl_setParameterA2");
         turl.setParameter("parm1", "val1");
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameterA2", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameterA2")) {
            String aval = portletReq.getParameter("parm1");
            String eval = "val1";
            CompareUtils.stringsEqual("Request", aval, " expected: ", eval, tr1);
         }
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameterA3          */
      /* Details: "Method setParameter(String, String): A public parameter    */
      /* can be set"                                                          */
      TestResult tr2 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA3);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderRenurl_setParameterA3");
         turl.setParameter("tckPRP1", "V2URLTests_BaseURL_ApiRenderRenurl_setParameterA3");
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameterA3", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameterA3")) {
            String aval = portletReq.getParameter("tckPRP1");
            String eval = "V2URLTests_BaseURL_ApiRenderRenurl_setParameterA3";
            CompareUtils.stringsEqual("Request", aval, " expected: ", eval, tr2);
         }
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameterA6          */
      /* Details: "Method setParameter(String, String): All previously        */
      /* existing values for the specified key are removed"                   */
      TestResult tr3 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA6);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderRenurl_setParameterA6");
         turl.setParameter("parm1", "oldVal");
         turl.setParameter("parm1", "newVal");
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameterA6", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameterA6")) {
            String aval = portletReq.getParameter("parm1");
            String eval = "newVal";
            CompareUtils.stringsEqual("Request", aval, " expected: ", eval, tr3);
         }
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameterA7          */
      /* Details: "Method setParameter(String, String): If the value is       */
      /* null, all values for the specified key are removed"                  */
      TestResult tr4 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA7);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderRenurl_setParameterA7");
         turl.setParameter("parm1", "val1");
         turl.setParameter("parm1", (String)null);
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameterA7", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameterA7")) {
            String aval = portletReq.getParameter("parm1");
            String eval = null;
            CompareUtils.stringsEqual("Request", aval, " expected: ", eval, tr4);
         }
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameterA8          */
      /* Details: "Method setParameter(String, String): Throws                */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr5 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA8);
      try {
         try {
            PortletURL turl = portletResp.createRenderURL();
            turl.setParameter(null, "value");
            tr5.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr5.setTcSuccess(true);
         } catch (Exception e) {
            tr5.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameterB1          */
      /* Details: "Method setParameter(String, String[]): Sets the            */
      /* parameter value array for the specified name"                        */
      TestResult tr6 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB1);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderRenurl_setParameterB1");
         turl.setParameter("parm1", new String[]{"val1", "val2"});
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameterB1", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameterB1")) {
            String[] aval = portletReq.getParameterValues("parm1");
            String[] eval = new String[]{"val1", "val2"};
            CompareUtils.arraysEqual("Request", aval, " expected: ", eval, tr6);
         }
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameterB2          */
      /* Details: "Method setParameter(String, String[]): A private           */
      /* parameter can be set"                                                */
      TestResult tr7 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB2);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderRenurl_setParameterB2");
         turl.setParameter("parm1", new String[]{"val1", "val2"});
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameterB2", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameterB2")) {
            String[] aval = portletReq.getParameterValues("parm1");
            String[] eval = new String[]{"val1", "val2"};
            CompareUtils.arraysEqual("Request", aval, " expected: ", eval, tr7);
         }
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameterB3          */
      /* Details: "Method setParameter(String, String[]): A public            */
      /* parameter can be set"                                                */
      TestResult tr8 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB3);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderRenurl_setParameterB3");
         turl.setParameter("tckPRP1", new String[]{"val1", "val2"});
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameterB3", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameterB3")) {
            String[] aval = portletReq.getParameterValues("tckPRP1");
            String[] eval = new String[]{"val1", "val2"};
            CompareUtils.arraysEqual("Request", aval, " expected: ", eval, tr8);
         }
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameterB6          */
      /* Details: "Method setParameter(String, String[]): All previously      */
      /* existing values for the specified key are removed"                   */
      TestResult tr9 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB6);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderRenurl_setParameterB6");
         turl.setParameter("parm1", new String[]{"val1", "val2", "val3"});
         turl.setParameter("parm1", new String[]{"newVal"});
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameterB6", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameterB6")) {
            String[] aval = portletReq.getParameterValues("parm1");
            String[] eval = new String[]{"newVal"};
            CompareUtils.arraysEqual("Request", aval, " expected: ", eval, tr9);
         }
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameterB7          */
      /* Details: "Method setParameter(String, String[]): If the value is     */
      /* null, all values for the specified key are removed"                  */
      TestResult tr10 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB7);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderRenurl_setParameterB7");
         turl.setParameter("parm1", new String[]{"val1", "val2", "val3"});
         turl.setParameter("parm1", (String[])null);
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameterB7", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameterB7")) {
            String[] aval = portletReq.getParameterValues("parm1");
            String[] eval = null;
            CompareUtils.arraysEqual("Request", aval, " expected: ", eval, tr10);
         }
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameterB8          */
      /* Details: "Method setParameter(String, String[]): Throws              */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr11 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB8);
      try {
         try {
            PortletURL turl = portletResp.createRenderURL();
            turl.setParameter(null, new String[]{"val1-1", "val1-2"});
            tr11.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr11.setTcSuccess(true);
         } catch (Exception e) {
            tr11.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr11.appendTcDetail(e.toString());}
      tr11.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameters1          */
      /* Details: "Method setParameters(java.util.Map): Sets the parameter    */
      /* map to the specified value"                                          */
      TestResult tr12 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS1);
      try {
         PortletURL turl = portletResp.createRenderURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderRenurl_setParameters1"});
         parms.put("parm1", new String[]{"val1", "val2"});
         turl.setParameters(parms);
         
         // Use setup link to set public render parameter to known value
         PortletURL rurl = portletResp.createRenderURL();
         rurl.removePublicRenderParameter("tckPRP1");
         TestSetupLink tsl = new TestSetupLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameters1", rurl);
         tsl.writeTo(writer);
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameters1", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameters1")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderRenurl_setParameters1"});
            eval.put("parm1", new String[]{"val1", "val2"});
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr12);
         }
      } catch(Exception e) {tr12.appendTcDetail(e.toString());}
      tr12.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameters2          */
      /* Details: "Method setParameters(java.util.Map): Public parameters     */
      /* can be set through the map"                                          */
      TestResult tr13 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS2);
      try {
         PortletURL turl = portletResp.createRenderURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderRenurl_setParameters2"});
         parms.put("tckPRP1", new String[]{"val1", "V2URLTests_BaseURL_ApiRenderRenurl_setParameters2"});
         turl.setParameters(parms);
         
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameters2", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameters2")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderRenurl_setParameters2"});
            eval.put("tckPRP1", new String[]{"val1", "V2URLTests_BaseURL_ApiRenderRenurl_setParameters2"});
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr13);
         }
      } catch(Exception e) {tr13.appendTcDetail(e.toString());}
      tr13.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameters3          */
      /* Details: "Method setParameters(java.util.Map): Private parameters    */
      /* can be set through the map"                                          */
      TestResult tr14 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS3);
      try {
         PortletURL turl = portletResp.createRenderURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderRenurl_setParameters3"});
         parms.put("parm1", new String[]{"val1", "val2"});
         turl.setParameters(parms);
         
         // Use setup link to set public render parameter to known value
         PortletURL rurl = portletResp.createRenderURL();
         rurl.removePublicRenderParameter("tckPRP1");
         TestSetupLink tsl = new TestSetupLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameters3", rurl);
         tsl.writeTo(writer);
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameters3", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameters3")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderRenurl_setParameters3"});
            eval.put("parm1", new String[]{"val1", "val2"});
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr14);
         }
      } catch(Exception e) {tr14.appendTcDetail(e.toString());}
      tr14.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameters6          */
      /* Details: "Method setParameters(java.util.Map): Previously existing   */
      /* private parameters not contained in the specified input map are      */
      /* removed"                                                             */
      TestResult tr15 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS6);
      try {
         PortletURL turl = portletResp.createRenderURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderRenurl_setParameters6"});
         turl.setParameter("oldParm", "oldVal");
         parms.put("parm1", new String[]{"val1", "val2"});
         turl.setParameters(parms);
         
         // Use setup link to set public render parameter to known value
         PortletURL rurl = portletResp.createRenderURL();
         rurl.removePublicRenderParameter("tckPRP1");
         TestSetupLink tsl = new TestSetupLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameters6", rurl);
         tsl.writeTo(writer);
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameters6", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameters6")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderRenurl_setParameters6"});
            eval.put("parm1", new String[]{"val1", "val2"});
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr15);
         }
      } catch(Exception e) {tr15.appendTcDetail(e.toString());}
      tr15.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameters7          */
      /* Details: "Method setParameters(java.util.Map): Previously existing   */
      /* public parameters not contained in the specified input map remain    */
      /* unchanged"                                                           */
      TestResult tr16 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS7);
      try {
         PortletURL turl = portletResp.createRenderURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderRenurl_setParameters7"});
         parms.put("parm1", new String[]{"val1", "val2"});
         turl.setParameters(parms);
         
         // Use setup link to set public render parameter to known value
         PortletURL rurl = portletResp.createRenderURL();
         rurl.setParameter("tckPRP1", "V2URLTests_BaseURL_ApiRenderRenurl_setParameters7");
         TestSetupLink tsl = new TestSetupLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameters7", rurl);
         tsl.writeTo(writer);
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameters7", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameters7")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderRenurl_setParameters7"});
            eval.put("parm1", new String[]{"val1", "val2"});
            eval.put("tckPRP1", new String[]{"V2URLTests_BaseURL_ApiRenderRenurl_setParameters7"});
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr16);
         }
      } catch(Exception e) {tr16.appendTcDetail(e.toString());}
      tr16.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameters8          */
      /* Details: "Method setParameters(java.util.Map): Parameters that are   */
      /* set are available in requests initiated through the URL"             */
      TestResult tr17 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS8);
      try {
         PortletURL turl = portletResp.createRenderURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderRenurl_setParameters8"});
         parms.put("parm1", new String[]{"val1", "val2"});
         turl.setParameters(parms);
         
         // Use setup link to set public render parameter to known value
         PortletURL rurl = portletResp.createRenderURL();
         rurl.removePublicRenderParameter("tckPRP1");
         TestSetupLink tsl = new TestSetupLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameters8", rurl);
         tsl.writeTo(writer);
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setParameters8", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setParameters8")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderRenurl_setParameters8"});
            eval.put("parm1", new String[]{"val1", "val2"});
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr17);
         }
      } catch(Exception e) {tr17.appendTcDetail(e.toString());}
      tr17.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameters9          */
      /* Details: "Method setParameters(java.util.Map): Throws                */
      /* IllegalArgumentException if the input map is null"                   */
      TestResult tr18 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS9);
      try {
         try {
            PortletURL turl = portletResp.createRenderURL();
            turl.setParameters((Map<String, String[]>)null);
            tr18.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr18.setTcSuccess(true);
         } catch (Exception e) {
            tr18.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr18.appendTcDetail(e.toString());}
      tr18.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameters10         */
      /* Details: "Method setParameters(java.util.Map): Throws                */
      /* IllegalArgumentException if any key in the map is null"              */
      TestResult tr19 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS10);
      try {
         try {
            PortletURL turl = portletResp.createRenderURL();
            Map<String, String[]> parms = new HashMap<String, String[]>();
            parms.put("parm1", new String[]{"val1-1", "val1-2"});
            parms.put(null, new String[]{"val2-1", "val2-2"});
            turl.setParameters(parms);
            tr19.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr19.setTcSuccess(true);
         } catch (Exception e) {
            tr19.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr19.appendTcDetail(e.toString());}
      tr19.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameters12         */
      /* Details: "Method setParameters(java.util.Map): Throws                */
      /* IllegalArgumentException if the values array for any key is null "   */
      TestResult tr20 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS12);
      try {
         try {
            PortletURL turl = portletResp.createRenderURL();
            Map<String, String[]> parms = new HashMap<String, String[]>();
            parms.put("parm1", new String[]{"val1-1", "val1-2"});
            parms.put("parm2", null);
            turl.setParameters(parms);
            tr20.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr20.setTcSuccess(true);
         } catch (Exception e) {
            tr20.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr20.appendTcDetail(e.toString());}
      tr20.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setParameters13         */
      /* Details: "Method setParameters(java.util.Map): Throws                */
      /* IllegalArgumentException if any element in the values array is       */
      /* null "                                                               */
      TestResult tr21 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS13);
      try {
         try {
            PortletURL turl = portletResp.createRenderURL();
            Map<String, String[]> parms = new HashMap<String, String[]>();
            parms.put("parm1", new String[]{null, "val1-2"});
            parms.put("parm2", new String[]{"val2-1", "val2-2"});
            turl.setParameters(parms);
            tr21.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr21.setTcSuccess(true);
         } catch (Exception e) {
            tr21.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr21.appendTcDetail(e.toString());}
      tr21.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setSecure2              */
      /* Details: "Method setSecure(boolean): If the input parameter is       */
      /* true, the resulting URL uses a secure connection (HTTPS)"            */
      TestResult tr22 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETSECURE2);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderRenurl_setSecure2");
         try {
            turl.setSecure(true);
         } catch(PortletSecurityException e) {
            // handle as successful completion, since runtime does not support setting            turl.setParameter("ok", "true");
         }
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_setSecure2", turl);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_setSecure2")) {
            String val = portletReq.getParameter("ok");
            boolean ok = (val != null);
            ok = ok || portletReq.isSecure();
            tr22.setTcSuccess(ok);
         }
      } catch(Exception e) {tr22.appendTcDetail(e.toString());}
      tr22.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_toString                */
      /* Details: "Method toString(): Returns a String containing the         */
      /* portlet URL representation to be included in the markup"             */
      TestResult tr23 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_TOSTRING);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderRenurl_toString");
         String urlstr = turl.toString();
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_toString", urlstr);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_toString")) {
            // If execution makes it to here, the test was successful
            tr23.setTcSuccess(true);
         }
      } catch(Exception e) {tr23.appendTcDetail(e.toString());}
      tr23.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_getParameterMap1        */
      /* Details: "Method getParameterMap(): Returns an                       */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object      */
      /* for the parameter names and values if parameters are available"      */
      TestResult tr24 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_GETPARAMETERMAP1);
      try {
         PortletURL turl = portletResp.createRenderURL();
         Map<String, String[]> parms = turl.getParameterMap();
         if (parms == null) {
            tr24.appendTcDetail("Returned map is null."); 
         } else {
            tr24.setTcSuccess(true);
         }
      } catch(Exception e) {tr24.appendTcDetail(e.toString());}
      tr24.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_getParameterMap2        */
      /* Details: "Method getParameterMap(): The returned map contains all    */
      /* public and private parameters for the request"                       */
      TestResult tr25 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_GETPARAMETERMAP2);
      try {
         PortletURL turl = portletResp.createRenderURL();
         Map<String, String[]> testparms = new HashMap<String, String[]>();
         turl.setParameter("parm1", "val1");
         testparms.put("parm1", new String[]{"val1"});
         turl.setParameter("tckPRP1", "PRPval1");
         testparms.put("tckPRP1", new String[]{"PRPval1"});
         Map<String, String[]> parms = turl.getParameterMap();
         CompareUtils.mapsEqual("Test parameters", testparms, "Parameters from URL", parms, tr25);
      } catch(Exception e) {tr25.appendTcDetail(e.toString());}
      tr25.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_getParameterMap6        */
      /* Details: "Method getParameterMap(): Returns an empty map if no       */
      /* parameters exist"                                                    */
      TestResult tr26 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_GETPARAMETERMAP6);
      try {
         PortletURL turl = portletResp.createRenderURL();
         Map<String, String[]> parms = turl.getParameterMap();
         if (parms == null) {
            tr26.appendTcDetail("Returned map is null."); 
         } else {
            tr26.setTcSuccess(parms.isEmpty());
         }
      } catch(Exception e) {tr26.appendTcDetail(e.toString());}
      tr26.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_writeA1                 */
      /* Details: "Method write(Writer out): Writes the URL to the output     */
      /* stream through the provided Writer"                                  */
      TestResult tr27 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_WRITEA1);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderRenurl_writeA1");
         StringWriter tsw = new StringWriter();
         turl.write(tsw);
         String urlstr = tsw.toString();
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_writeA1", urlstr);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_writeA1")) {
            // If execution makes it to here, the test was successful
            tr27.setTcSuccess(true);
         }
      } catch(Exception e) {tr27.appendTcDetail(e.toString());}
      tr27.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_writeB1                 */
      /* Details: "Method write(Writer out, boolean escapeXML): Writes the    */
      /* URL to the output stream through the provided Writer"                */
      TestResult tr28 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_WRITEB1);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderRenurl_writeB1");
         StringWriter tsw = new StringWriter();
         turl.write(tsw, true);
         String urlstr = tsw.toString();
         
         // add the execution link
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderRenurl_writeB1", urlstr);
         tl.writeTo(writer);
         
         // evaluate results
         String tcval = portletReq.getParameter("tc");
         if (tcval.equals("V2URLTests_BaseURL_ApiRenderRenurl_writeB1")) {
            // If execution makes it to here, the test was successful
            tr28.setTcSuccess(true);
         }
      } catch(Exception e) {tr28.appendTcDetail(e.toString());}
      tr28.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_addProperty1            */
      /* Details: "Method addProperty(String, String): A property can be      */
      /* added"                                                               */
      TestResult tr29 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_ADDPROPERTY1);
      try {
         // Test if method can be called. Not possible to check resulting property values.
         PortletURL turl = portletResp.createRenderURL();
         turl.addProperty("prop1", "val1");
         tr29.setTcSuccess(true);
      } catch(Exception e) {tr29.appendTcDetail(e.toString());}
      tr29.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_addProperty3            */
      /* Details: "Method addProperty(String, String): Throws                 */
      /* IllegalArgumentException if the specified key is null"               */
      TestResult tr30 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_ADDPROPERTY3);
      try {
         try {
            PortletURL turl = portletResp.createRenderURL();
            turl.addProperty(null, "value");
            tr30.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr30.setTcSuccess(true);
         } catch (Exception e) {
            tr30.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr30.appendTcDetail(e.toString());}
      tr30.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setProperty1            */
      /* Details: "Method setProperty(String, String): Sets a property        */
      /* value for the specified key"                                         */
      TestResult tr31 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPROPERTY1);
      try {
         // Test if method can be called. Not possible to check resulting property values.
         PortletURL turl = portletResp.createRenderURL();
         turl.setProperty("prop1", "val1");
         tr31.setTcSuccess(true);
      } catch(Exception e) {tr31.appendTcDetail(e.toString());}
      tr31.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderRenurl_setProperty3            */
      /* Details: "Method setProperty(String, String): Throws                 */
      /* IllegalArgumentException if the specified key is null"               */
      TestResult tr32 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPROPERTY3);
      try {
         try {
            PortletURL turl = portletResp.createRenderURL();
            turl.setProperty(null, "value");
            tr32.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr32.setTcSuccess(true);
         } catch (Exception e) {
            tr32.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr32.appendTcDetail(e.toString());}
      tr32.writeTo(writer);

   }

}
