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
 * portlet WrapperTests_PortletResponseWrapper_ApiRender_event
 *
 */
public class WrapperTests_PortletResponseWrapper_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         WrapperTests_PortletResponseWrapper_ApiRender.class.getName();
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

      PortletResponseWrapperChecker wc = new PortletResponseWrapperChecker(portletResp);
      PortletResponseWrapper wpr = new PortletResponseWrapper(portletResp);
      wpr.setResponse(wc);
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(PortletResponseWrapper.class);

      /* TestCase: V2WrapperTests_PortletResponseWrapper_ApiRender_addPropertyA */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Calls       */
      /* wrapped method"                                                      */
      TestResult tr0 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_ADDPROPERTYA);
      try {
         Cookie parm1 = new Cookie("name", "Alice");
         Object[] args = {parm1};
         wc.prepare(tr0, "addProperty", args);
         wpr.addProperty(parm1);
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletResponseWrapper_ApiRender_addPropertyB */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Calls     */
      /* wrapped method"                                                      */
      TestResult tr1 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_ADDPROPERTYB);
      try {
         String parm1 = "val1";
         org.w3c.dom.Element parm2 = portletResp.createElement("p");
         Object[] args = {parm1, parm2};
         wc.prepare(tr1, "addProperty", args);
         wpr.addProperty(parm1, parm2);
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletResponseWrapper_ApiRender_addPropertyC */
      /* Details: "Method addProperty(String, String): Calls wrapped          */
      /* method"                                                              */
      TestResult tr2 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_ADDPROPERTYC);
      try {
         String parm1 = "val1";
         String parm2 = "val2";
         Object[] args = {parm1, parm2};
         wc.prepare(tr2, "addProperty", args);
         wpr.addProperty(parm1, parm2);
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletResponseWrapper_ApiRender_encodeURL  */
      /* Details: "Method encodeURL(String): Calls wrapped method"            */
      TestResult tr3 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_ENCODEURL);
      try {
         String parm1 = "val1";
         Object[] args = {parm1};
         wc.prepare(tr3, "encodeURL", args);
         wc.checkRetval(wpr.encodeURL(parm1));
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletResponseWrapper_ApiRender_getNamespace */
      /* Details: "Method getNamespace(): Calls wrapped method"               */
      TestResult tr4 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_GETNAMESPACE);
      try {
         Object[] args = {};
         wc.prepare(tr4, "getNamespace", args);
         wc.checkRetval(wpr.getNamespace());
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletResponseWrapper_ApiRender_setProperty */
      /* Details: "Method setProperty(String, String): Calls wrapped          */
      /* method"                                                              */
      TestResult tr5 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_SETPROPERTY);
      try {
         String parm1 = "val1";
         String parm2 = "val2";
         Object[] args = {parm1, parm2};
         wc.prepare(tr5, "setProperty", args);
         wpr.setProperty(parm1, parm2);
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletResponseWrapper_ApiRender_getResponse */
      /* Details: "Method getResponse(): Returns wrapped PortletResponse      */
      /* object"                                                              */
      TestResult tr6 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_GETRESPONSE);
      try {
         // The retrieved request / response object should be the wrapper checker instance
         PortletResponse r = wpr.getResponse();
         tr6.setTcSuccess(r == wc);
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletResponseWrapper_ApiRender_setResponse */
      /* Details: "Method setResponse(PortletResponse): Allows wrapped        */
      /* PortletResponse object to be set"                                    */
      TestResult tr7 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_SETRESPONSE);
      try {
         // tested by method set up 
         tr7.setTcSuccess(true);
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletResponseWrapper_ApiRender_createElement */
      /* Details: "Method createElement(String): Calls wrapped method"        */
      TestResult tr8 = tcd.getTestResultFailed(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_CREATEELEMENT);
      try {
         String parm1 = "val1";
         Object[] args = {parm1};
         wc.prepare(tr8, "createElement", args);
         wc.checkRetval(wpr.createElement(parm1));
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

   }

}
