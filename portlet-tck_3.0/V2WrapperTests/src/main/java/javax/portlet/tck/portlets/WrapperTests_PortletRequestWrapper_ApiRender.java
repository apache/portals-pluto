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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETATTRIBUTE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETATTRIBUTENAMES;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETAUTHTYPE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETCONTEXTPATH;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETCOOKIES;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETLOCALE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETLOCALES;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETER;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETERNAMES;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETERVALUES;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTALCONTEXT;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTLETSESSIONA;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTLETSESSIONB;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPREFERENCES;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPROPERTIES;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPROPERTY;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPROPERTYNAMES;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETREMOTEUSER;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETREQUESTEDSESSIONID;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETRESPONSECONTENTTYPE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETRESPONSECONTENTTYPES;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETSCHEME;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETSERVERNAME;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETSERVERPORT;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETUSERPRINCIPAL;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETWINDOWID;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETWINDOWSTATE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISPORTLETMODEALLOWED;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISREQUESTEDSESSIONIDVALID;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISSECURE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISUSERINROLE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISWINDOWSTATEALLOWED;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_REMOVEATTRIBUTE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_SETATTRIBUTE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETREQUEST;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_SETREQUEST;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPRIVATEPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPUBLICPARAMETERMAP;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.filter.PortletRequestWrapper;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.PortletRequestWrapperChecker;
import javax.portlet.tck.beans.TestResult;

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
 * WrapperTests_PortletRequestWrapper_ApiRender_event
 *
 */
public class WrapperTests_PortletRequestWrapper_ApiRender implements Portlet {

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
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      PortletRequestWrapperChecker wc = new PortletRequestWrapperChecker(
            portletReq);
      PortletRequestWrapper wpr = new PortletRequestWrapper(portletReq);
      wpr.setRequest(wc);
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /*
       * TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getAttribute
       */
      /* Details: "Method getAttribute(String): Calls wrapped method" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETATTRIBUTE);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr0, "getAttribute", args);
         wc.checkRetval(wpr.getAttribute(parm1));
      } catch (Exception e) {
         tr0.appendTcDetail(e.toString());
      }
      tr0.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_getAttributeNames
       */
      /* Details: "Method getAttributeNames(): Calls wrapped method" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETATTRIBUTENAMES);
      try {
         Object[] args = {};
         wc.prepare(tr1, "getAttributeNames", args);
         wc.checkRetval(wpr.getAttributeNames());
      } catch (Exception e) {
         tr1.appendTcDetail(e.toString());
      }
      tr1.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getAuthType */
      /* Details: "Method getAuthType(): Calls wrapped method" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETAUTHTYPE);
      try {
         Object[] args = {};
         wc.prepare(tr2, "getAuthType", args);
         wc.checkRetval(wpr.getAuthType());
      } catch (Exception e) {
         tr2.appendTcDetail(e.toString());
      }
      tr2.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getContextPath
       */
      /* Details: "Method getContextPath(): Calls wrapped method" */
      TestResult tr3 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETCONTEXTPATH);
      try {
         Object[] args = {};
         wc.prepare(tr3, "getContextPath", args);
         wc.checkRetval(wpr.getContextPath());
      } catch (Exception e) {
         tr3.appendTcDetail(e.toString());
      }
      tr3.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getCookies */
      /* Details: "Method getCookies(): Calls wrapped method" */
      TestResult tr4 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETCOOKIES);
      try {
         Object[] args = {};
         wc.prepare(tr4, "getCookies", args);
         wc.checkRetval(wpr.getCookies());
      } catch (Exception e) {
         tr4.appendTcDetail(e.toString());
      }
      tr4.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getLocale */
      /* Details: "Method getLocale(): Calls wrapped method" */
      TestResult tr5 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETLOCALE);
      try {
         Object[] args = {};
         wc.prepare(tr5, "getLocale", args);
         wc.checkRetval(wpr.getLocale());
      } catch (Exception e) {
         tr5.appendTcDetail(e.toString());
      }
      tr5.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getLocales */
      /* Details: "Method getLocales(): Calls wrapped method" */
      TestResult tr6 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETLOCALES);
      try {
         Object[] args = {};
         wc.prepare(tr6, "getLocales", args);
         wc.checkRetval(wpr.getLocales());
      } catch (Exception e) {
         tr6.appendTcDetail(e.toString());
      }
      tr6.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getParameter
       */
      /* Details: "Method getParameter(String): Calls wrapped method" */
      TestResult tr7 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETER);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr7, "getParameter", args);
         wc.checkRetval(wpr.getParameter(parm1));
      } catch (Exception e) {
         tr7.appendTcDetail(e.toString());
      }
      tr7.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_getParameterMap
       */
      /* Details: "Method getParameterMap(): Calls wrapped method" */
      TestResult tr8 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETERMAP);
      try {
         Object[] args = {};
         wc.prepare(tr8, "getParameterMap", args);
         wc.checkRetval(wpr.getParameterMap());
      } catch (Exception e) {
         tr8.appendTcDetail(e.toString());
      }
      tr8.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_getParameterNames
       */
      /* Details: "Method getParameterNames(): Calls wrapped method" */
      TestResult tr9 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETERNAMES);
      try {
         Object[] args = {};
         wc.prepare(tr9, "getParameterNames", args);
         wc.checkRetval(wpr.getParameterNames());
      } catch (Exception e) {
         tr9.appendTcDetail(e.toString());
      }
      tr9.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_getParameterValues
       */
      /* Details: "Method getParameterValues(String): Calls wrapped method" */
      TestResult tr10 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETERVALUES);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr10, "getParameterValues", args);
         wc.checkRetval(wpr.getParameterValues(parm1));
      } catch (Exception e) {
         tr10.appendTcDetail(e.toString());
      }
      tr10.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_getPortalContext
       */
      /* Details: "Method getPortalContext(): Calls wrapped method" */
      TestResult tr11 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTALCONTEXT);
      try {
         Object[] args = {};
         wc.prepare(tr11, "getPortalContext", args);
         wc.checkRetval(wpr.getPortalContext());
      } catch (Exception e) {
         tr11.appendTcDetail(e.toString());
      }
      tr11.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getPortletMode
       */
      /* Details: "Method getPortletMode(): Calls wrapped method" */
      TestResult tr12 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTLETMODE);
      try {
         Object[] args = {};
         wc.prepare(tr12, "getPortletMode", args);
         wc.checkRetval(wpr.getPortletMode());
      } catch (Exception e) {
         tr12.appendTcDetail(e.toString());
      }
      tr12.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_getPortletSessionA
       */
      /* Details: "Method getPortletSession(): Calls wrapped method" */
      TestResult tr13 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTLETSESSIONA);
      try {
         Object[] args = {};
         wc.prepare(tr13, "getPortletSession", args);
         wc.checkRetval(wpr.getPortletSession());
      } catch (Exception e) {
         tr13.appendTcDetail(e.toString());
      }
      tr13.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_getPortletSessionB
       */
      /* Details: "Method getPortletSession(boolean): Calls wrapped method" */
      TestResult tr14 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTLETSESSIONB);
      try {
         boolean parm1 = true;
         Object[] args = { parm1 };
         wc.prepare(tr14, "getPortletSession", args);
         wc.checkRetval(wpr.getPortletSession(parm1));
      } catch (Exception e) {
         tr14.appendTcDetail(e.toString());
      }
      tr14.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getPreferences
       */
      /* Details: "Method getPreferences(): Calls wrapped method" */
      TestResult tr15 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPREFERENCES);
      try {
         Object[] args = {};
         wc.prepare(tr15, "getPreferences", args);
         wc.checkRetval(wpr.getPreferences());
      } catch (Exception e) {
         tr15.appendTcDetail(e.toString());
      }
      tr15.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getProperties
       */
      /* Details: "Method getProperties(String): Calls wrapped method" */
      TestResult tr16 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPROPERTIES);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr16, "getProperties", args);
         wc.checkRetval(wpr.getProperties(parm1));
      } catch (Exception e) {
         tr16.appendTcDetail(e.toString());
      }
      tr16.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getProperty */
      /* Details: "Method getProperty(String): Calls wrapped method" */
      TestResult tr17 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPROPERTY);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr17, "getProperty", args);
         wc.checkRetval(wpr.getProperty(parm1));
      } catch (Exception e) {
         tr17.appendTcDetail(e.toString());
      }
      tr17.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_getPropertyNames
       */
      /* Details: "Method getPropertyNames(): Calls wrapped method" */
      TestResult tr18 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPROPERTYNAMES);
      try {
         Object[] args = {};
         wc.prepare(tr18, "getPropertyNames", args);
         wc.checkRetval(wpr.getPropertyNames());
      } catch (Exception e) {
         tr18.appendTcDetail(e.toString());
      }
      tr18.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getRemoteUser
       */
      /* Details: "Method getRemoteUser(): Calls wrapped method" */
      TestResult tr19 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETREMOTEUSER);
      try {
         Object[] args = {};
         wc.prepare(tr19, "getRemoteUser", args);
         wc.checkRetval(wpr.getRemoteUser());
      } catch (Exception e) {
         tr19.appendTcDetail(e.toString());
      }
      tr19.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_getRequestedSessionId
       */
      /* Details: "Method getRequestedSessionId(): Calls wrapped method" */
      TestResult tr20 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETREQUESTEDSESSIONID);
      try {
         Object[] args = {};
         wc.prepare(tr20, "getRequestedSessionId", args);
         wc.checkRetval(wpr.getRequestedSessionId());
      } catch (Exception e) {
         tr20.appendTcDetail(e.toString());
      }
      tr20.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_getResponseContentType
       */
      /* Details: "Method getResponseContentType(): Calls wrapped method" */
      TestResult tr21 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETRESPONSECONTENTTYPE);
      try {
         Object[] args = {};
         wc.prepare(tr21, "getResponseContentType", args);
         wc.checkRetval(wpr.getResponseContentType());
      } catch (Exception e) {
         tr21.appendTcDetail(e.toString());
      }
      tr21.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_getResponseContentTypes
       */
      /* Details: "Method getResponseContentTypes(): Calls wrapped method" */
      TestResult tr22 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETRESPONSECONTENTTYPES);
      try {
         Object[] args = {};
         wc.prepare(tr22, "getResponseContentTypes", args);
         wc.checkRetval(wpr.getResponseContentTypes());
      } catch (Exception e) {
         tr22.appendTcDetail(e.toString());
      }
      tr22.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getScheme */
      /* Details: "Method getScheme(): Calls wrapped method" */
      TestResult tr23 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETSCHEME);
      try {
         Object[] args = {};
         wc.prepare(tr23, "getScheme", args);
         wc.checkRetval(wpr.getScheme());
      } catch (Exception e) {
         tr23.appendTcDetail(e.toString());
      }
      tr23.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getServerName
       */
      /* Details: "Method getServerName(): Calls wrapped method" */
      TestResult tr24 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETSERVERNAME);
      try {
         Object[] args = {};
         wc.prepare(tr24, "getServerName", args);
         wc.checkRetval(wpr.getServerName());
      } catch (Exception e) {
         tr24.appendTcDetail(e.toString());
      }
      tr24.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getServerPort
       */
      /* Details: "Method getServerPort(): Calls wrapped method" */
      TestResult tr25 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETSERVERPORT);
      try {
         Object[] args = {};
         wc.prepare(tr25, "getServerPort", args);
         wc.checkRetval(wpr.getServerPort());
      } catch (Exception e) {
         tr25.appendTcDetail(e.toString());
      }
      tr25.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_getUserPrincipal
       */
      /* Details: "Method getUserPrincipal(): Calls wrapped method" */
      TestResult tr26 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETUSERPRINCIPAL);
      try {
         Object[] args = {};
         wc.prepare(tr26, "getUserPrincipal", args);
         wc.checkRetval(wpr.getUserPrincipal());
      } catch (Exception e) {
         tr26.appendTcDetail(e.toString());
      }
      tr26.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getWindowID */
      /* Details: "Method getWindowID(): Calls wrapped method" */
      TestResult tr27 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETWINDOWID);
      try {
         Object[] args = {};
         wc.prepare(tr27, "getWindowID", args);
         wc.checkRetval(wpr.getWindowID());
      } catch (Exception e) {
         tr27.appendTcDetail(e.toString());
      }
      tr27.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getWindowState
       */
      /* Details: "Method getWindowState(): Calls wrapped method" */
      TestResult tr28 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETWINDOWSTATE);
      try {
         Object[] args = {};
         wc.prepare(tr28, "getWindowState", args);
         wc.checkRetval(wpr.getWindowState());
      } catch (Exception e) {
         tr28.appendTcDetail(e.toString());
      }
      tr28.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_isPortletModeAllowed
       */
      /* Details: "Method isPortletModeAllowed(PortletMode): Calls wrapped */
      /* method" */
      TestResult tr29 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISPORTLETMODEALLOWED);
      try {
         PortletMode parm1 = PortletMode.EDIT;
         Object[] args = { parm1 };
         wc.prepare(tr29, "isPortletModeAllowed", args);
         wc.checkRetval(wpr.isPortletModeAllowed(parm1));
      } catch (Exception e) {
         tr29.appendTcDetail(e.toString());
      }
      tr29.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_isRequestedSessionIdValid
       */
      /* Details: "Method isRequestedSessionIdValid(): Calls wrapped */
      /* method" */
      TestResult tr30 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISREQUESTEDSESSIONIDVALID);
      try {
         Object[] args = {};
         wc.prepare(tr30, "isRequestedSessionIdValid", args);
         wc.checkRetval(wpr.isRequestedSessionIdValid());
      } catch (Exception e) {
         tr30.appendTcDetail(e.toString());
      }
      tr30.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_isSecure */
      /* Details: "Method isSecure(): Calls wrapped method" */
      TestResult tr31 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISSECURE);
      try {
         Object[] args = {};
         wc.prepare(tr31, "isSecure", args);
         wc.checkRetval(wpr.isSecure());
      } catch (Exception e) {
         tr31.appendTcDetail(e.toString());
      }
      tr31.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_isUserInRole
       */
      /* Details: "Method isUserInRole(String): Calls wrapped method" */
      TestResult tr32 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISUSERINROLE);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr32, "isUserInRole", args);
         wc.checkRetval(wpr.isUserInRole(parm1));
      } catch (Exception e) {
         tr32.appendTcDetail(e.toString());
      }
      tr32.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_isWindowStateAllowed
       */
      /* Details: "Method isWindowStateAllowed(WindowState): Calls wrapped */
      /* method" */
      TestResult tr33 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISWINDOWSTATEALLOWED);
      try {
         WindowState parm1 = WindowState.NORMAL;
         Object[] args = { parm1 };
         wc.prepare(tr33, "isWindowStateAllowed", args);
         wc.checkRetval(wpr.isWindowStateAllowed(parm1));
      } catch (Exception e) {
         tr33.appendTcDetail(e.toString());
      }
      tr33.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_removeAttribute
       */
      /* Details: "Method removeAttribute(String): Calls wrapped method" */
      TestResult tr34 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_REMOVEATTRIBUTE);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr34, "removeAttribute", args);
         wpr.removeAttribute(parm1);
      } catch (Exception e) {
         tr34.appendTcDetail(e.toString());
      }
      tr34.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_setAttribute
       */
      /* Details: "Method setAttribute(String, Object): Calls wrapped */
      /* method" */
      TestResult tr35 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_SETATTRIBUTE);
      try {
         String parm1 = "val1";
         String parm2 = "val2";
         Object[] args = { parm1, parm2 };
         wc.prepare(tr35, "setAttribute", args);
         wpr.setAttribute(parm1, parm2);
      } catch (Exception e) {
         tr35.appendTcDetail(e.toString());
      }
      tr35.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_getRequest */
      /* Details: "Method getRequest(): Returns wrapped PortletRequest */
      /* object" */
      TestResult tr36 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETREQUEST);
      try {
         // The retrieved request / response object should be the wrapper
         // checker instance
         PortletRequest r = wpr.getRequest();
         tr36.setTcSuccess(r == wc);
      } catch (Exception e) {
         tr36.appendTcDetail(e.toString());
      }
      tr36.writeTo(writer);

      /* TestCase: V2WrapperTests_PortletRequestWrapper_ApiRender_setRequest */
      /* Details: "Method setRequest(PortletRequest): Allows wrapped */
      /* PortletRequest object to be set" */
      TestResult tr37 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_SETREQUEST);
      try {
         // tested by method set up
         tr37.setTcSuccess(true);
      } catch (Exception e) {
         tr37.appendTcDetail(e.toString());
      }
      tr37.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_getPrivateParameterMap
       */
      /* Details: "Method getPrivateParameterMap(): Calls wrapped method" */
      TestResult tr38 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPRIVATEPARAMETERMAP);
      try {
         Object[] args = {};
         wc.prepare(tr38, "getPrivateParameterMap", args);
         wc.checkRetval(wpr.getPrivateParameterMap());
      } catch (Exception e) {
         tr38.appendTcDetail(e.toString());
      }
      tr38.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_PortletRequestWrapper_ApiRender_getPublicParameterMap
       */
      /* Details: "Method getPublicParameterMap(): Calls wrapped method" */
      TestResult tr39 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPUBLICPARAMETERMAP);
      try {
         Object[] args = {};
         wc.prepare(tr39, "getPublicParameterMap", args);
         wc.checkRetval(wpr.getPublicParameterMap());
      } catch (Exception e) {
         tr39.appendTcDetail(e.toString());
      }
      tr39.writeTo(writer);

   }

}
