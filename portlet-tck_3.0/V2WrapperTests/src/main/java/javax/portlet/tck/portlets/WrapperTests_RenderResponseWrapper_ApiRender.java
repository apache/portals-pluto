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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_FLUSHBUFFER;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETBUFFERSIZE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETLOCALE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETPORTLETOUTPUTSTREAM;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETWRITER;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_ISCOMMITTED;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_RESET;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_RESETBUFFER;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETBUFFERSIZE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETTITLE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETCACHECONTROL;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETNEXTPOSSIBLEPORTLETMODES;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETRESPONSE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETRESPONSE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_CREATEACTIONURL;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_CREATERENDERURL;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_CREATERESOURCEURL;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.RenderResponseWrapper;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.RenderResponseWrapperChecker;
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
 * WrapperTests_RenderResponseWrapper_ApiRender_event
 *
 */
public class WrapperTests_RenderResponseWrapper_ApiRender implements Portlet {

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

      RenderResponseWrapperChecker wc = new RenderResponseWrapperChecker(
            portletResp);
      RenderResponseWrapper wpr = new RenderResponseWrapper(portletResp);
      wpr.setResponse(wc);
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2WrapperTests_RenderResponseWrapper_ApiRender_flushBuffer */
      /* Details: "Method flushBuffer(): Calls wrapped method" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_FLUSHBUFFER);
      try {
         Object[] args = {};
         wc.prepare(tr0, "flushBuffer", args);
         wpr.flushBuffer();
      } catch (Exception e) {
         tr0.appendTcDetail(e.toString());
      }
      tr0.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_RenderResponseWrapper_ApiRender_getBufferSize
       */
      /* Details: "Method getBufferSize(): Calls wrapped method" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETBUFFERSIZE);
      try {
         Object[] args = {};
         wc.prepare(tr1, "getBufferSize", args);
         wc.checkRetval(wpr.getBufferSize());
      } catch (Exception e) {
         tr1.appendTcDetail(e.toString());
      }
      tr1.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_RenderResponseWrapper_ApiRender_getCharacterEncoding
       */
      /* Details: "Method getCharacterEncoding(): Calls wrapped method" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETCHARACTERENCODING);
      try {
         Object[] args = {};
         wc.prepare(tr2, "getCharacterEncoding", args);
         wc.checkRetval(wpr.getCharacterEncoding());
      } catch (Exception e) {
         tr2.appendTcDetail(e.toString());
      }
      tr2.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_RenderResponseWrapper_ApiRender_getContentType
       */
      /* Details: "Method getContentType(): Calls wrapped method" */
      TestResult tr3 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETCONTENTTYPE);
      try {
         Object[] args = {};
         wc.prepare(tr3, "getContentType", args);
         wc.checkRetval(wpr.getContentType());
      } catch (Exception e) {
         tr3.appendTcDetail(e.toString());
      }
      tr3.writeTo(writer);

      /* TestCase: V2WrapperTests_RenderResponseWrapper_ApiRender_getLocale */
      /* Details: "Method getLocale(): Calls wrapped method" */
      TestResult tr4 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETLOCALE);
      try {
         Object[] args = {};
         wc.prepare(tr4, "getLocale", args);
         wc.checkRetval(wpr.getLocale());
      } catch (Exception e) {
         tr4.appendTcDetail(e.toString());
      }
      tr4.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_RenderResponseWrapper_ApiRender_getPortletOutputStream
       */
      /* Details: "Method getPortletOutputStream(): Calls wrapped method" */
      TestResult tr5 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETPORTLETOUTPUTSTREAM);
      try {
         Object[] args = {};
         wc.prepare(tr5, "getPortletOutputStream", args);
         wc.checkRetval(wpr.getPortletOutputStream());
      } catch (Exception e) {
         tr5.appendTcDetail(e.toString());
      }
      tr5.writeTo(writer);

      /* TestCase: V2WrapperTests_RenderResponseWrapper_ApiRender_getWriter */
      /* Details: "Method getWriter(): Calls wrapped method" */
      TestResult tr6 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETWRITER);
      try {
         Object[] args = {};
         wc.prepare(tr6, "getWriter", args);
         wc.checkRetval(wpr.getWriter());
      } catch (Exception e) {
         tr6.appendTcDetail(e.toString());
      }
      tr6.writeTo(writer);

      /* TestCase: V2WrapperTests_RenderResponseWrapper_ApiRender_isCommitted */
      /* Details: "Method isCommitted(): Calls wrapped method" */
      TestResult tr7 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_ISCOMMITTED);
      try {
         Object[] args = {};
         wc.prepare(tr7, "isCommitted", args);
         wc.checkRetval(wpr.isCommitted());
      } catch (Exception e) {
         tr7.appendTcDetail(e.toString());
      }
      tr7.writeTo(writer);

      /* TestCase: V2WrapperTests_RenderResponseWrapper_ApiRender_reset */
      /* Details: "Method reset(): Calls wrapped method" */
      TestResult tr8 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_RESET);
      try {
         Object[] args = {};
         wc.prepare(tr8, "reset", args);
         wpr.reset();
      } catch (Exception e) {
         tr8.appendTcDetail(e.toString());
      }
      tr8.writeTo(writer);

      /* TestCase: V2WrapperTests_RenderResponseWrapper_ApiRender_resetBuffer */
      /* Details: "Method resetBuffer(): Calls wrapped method" */
      TestResult tr9 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_RESETBUFFER);
      try {
         Object[] args = {};
         wc.prepare(tr9, "resetBuffer", args);
         wpr.resetBuffer();
      } catch (Exception e) {
         tr9.appendTcDetail(e.toString());
      }
      tr9.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_RenderResponseWrapper_ApiRender_setBufferSize
       */
      /* Details: "Method setBufferSize(int): Calls wrapped method" */
      TestResult tr10 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETBUFFERSIZE);
      try {
         int parm1 = 42;
         Object[] args = { parm1 };
         wc.prepare(tr10, "setBufferSize", args);
         wpr.setBufferSize(parm1);
      } catch (Exception e) {
         tr10.appendTcDetail(e.toString());
      }
      tr10.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_RenderResponseWrapper_ApiRender_setContentType
       */
      /* Details: "Method setContentType(String): Calls wrapped method" */
      TestResult tr11 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETCONTENTTYPE);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr11, "setContentType", args);
         wpr.setContentType(parm1);
      } catch (Exception e) {
         tr11.appendTcDetail(e.toString());
      }
      tr11.writeTo(writer);

      /* TestCase: V2WrapperTests_RenderResponseWrapper_ApiRender_setTitle */
      /* Details: "Method setTitle(String): Calls wrapped method" */
      TestResult tr12 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETTITLE);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr12, "setTitle", args);
         wpr.setTitle(parm1);
      } catch (Exception e) {
         tr12.appendTcDetail(e.toString());
      }
      tr12.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_RenderResponseWrapper_ApiRender_getCacheControl
       */
      /* Details: "Method getCacheControl(): Calls wrapped method" */
      TestResult tr13 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETCACHECONTROL);
      try {
         Object[] args = {};
         wc.prepare(tr13, "getCacheControl", args);
         wc.checkRetval(wpr.getCacheControl());
      } catch (Exception e) {
         tr13.appendTcDetail(e.toString());
      }
      tr13.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_RenderResponseWrapper_ApiRender_setNextPossiblePortletModes
       */
      /* Details: "Method */
      /* setNextPossiblePortletModes(java.util.Collection): Calls wrapped */
      /* method" */
      TestResult tr14 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETNEXTPOSSIBLEPORTLETMODES);
      try {
         PortletMode[] modes = { PortletMode.EDIT, PortletMode.VIEW };
         ArrayList<PortletMode> parm1 = new ArrayList<PortletMode>(
               Arrays.asList(modes));
         Object[] args = { parm1 };
         wc.prepare(tr14, "setNextPossiblePortletModes", args);
         wpr.setNextPossiblePortletModes(parm1);
      } catch (Exception e) {
         tr14.appendTcDetail(e.toString());
      }
      tr14.writeTo(writer);

      /* TestCase: V2WrapperTests_RenderResponseWrapper_ApiRender_getResponse */
      /* Details: "Method getResponse(): Returns wrapped RenderResponse */
      /* object" */
      TestResult tr15 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETRESPONSE);
      try {
         // The retrieved request / response object should be the wrapper
         // checker instance
         RenderResponse r = wpr.getResponse();
         tr15.setTcSuccess(r == wc);
      } catch (Exception e) {
         tr15.appendTcDetail(e.toString());
      }
      tr15.writeTo(writer);

      /* TestCase: V2WrapperTests_RenderResponseWrapper_ApiRender_setResponse */
      /* Details: "Method setResponse(RenderResponse): Allows wrapped */
      /* RenderResponse object to be set " */
      TestResult tr16 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETRESPONSE);
      try {
         // tested by method set up
         tr16.setTcSuccess(true);
      } catch (Exception e) {
         tr16.appendTcDetail(e.toString());
      }
      tr16.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_RenderResponseWrapper_ApiRender_createActionURL
       */
      /* Details: "Method createActionURL(): Calls wrapped method" */
      TestResult tr17 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_CREATEACTIONURL);
      try {
         Object[] args = {};
         wc.prepare(tr17, "createActionURL", args);
         wc.checkRetval(wpr.createActionURL());
      } catch (Exception e) {
         tr17.appendTcDetail(e.toString());
      }
      tr17.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_RenderResponseWrapper_ApiRender_createRenderURL
       */
      /* Details: "Method createRenderURL(): Calls wrapped method" */
      TestResult tr18 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_CREATERENDERURL);
      try {
         Object[] args = {};
         wc.prepare(tr18, "createRenderURL", args);
         wc.checkRetval(wpr.createRenderURL());
      } catch (Exception e) {
         tr18.appendTcDetail(e.toString());
      }
      tr18.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_RenderResponseWrapper_ApiRender_createResourceURL
       */
      /* Details: "Method createResourceURL(): Calls wrapped method" */
      TestResult tr19 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_CREATERESOURCEURL);
      try {
         Object[] args = {};
         wc.prepare(tr19, "createResourceURL", args);
         wc.checkRetval(wpr.createResourceURL());
      } catch (Exception e) {
         tr19.appendTcDetail(e.toString());
      }
      tr19.writeTo(writer);

   }

}
