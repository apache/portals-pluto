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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_FLUSHBUFFER;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETBUFFERSIZE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETLOCALE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETPORTLETOUTPUTSTREAM;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETWRITER;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_ISCOMMITTED;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_RESET;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_RESETBUFFER;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETBUFFERSIZE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETCACHECONTROL;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETLOCALE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETCONTENTLENGTH;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETRESPONSE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETRESPONSE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_CREATEACTIONURL;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_CREATERENDERURL;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_CREATERESOURCEURL;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

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
import javax.portlet.filter.ResourceResponseWrapper;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.ResourceResponseWrapperChecker;
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
 * WrapperTests_ResourceResponseWrapper_ApiResource_event
 *
 */
public class WrapperTests_ResourceResponseWrapper_ApiResource
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

      ResourceResponseWrapperChecker wc = new ResourceResponseWrapperChecker(
            portletResp);
      ResourceResponseWrapper wpr = new ResourceResponseWrapper(portletResp);
      wpr.setResponse(wc);
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /*
       * TestCase:
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_flushBuffer
       */
      /* Details: "Method flushBuffer(): Calls wrapped method" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_FLUSHBUFFER);
      try {
         Object[] args = {};
         wc.prepare(tr0, "flushBuffer", args);
         wpr.flushBuffer();
      } catch (Exception e) {
         tr0.appendTcDetail(e.toString());
      }
      tr0.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_getBufferSize
       */
      /* Details: "Method getBufferSize(): Calls wrapped method" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETBUFFERSIZE);
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
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_getCharacterEncoding
       */
      /* Details: "Method getCharacterEncoding(): Calls wrapped method" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETCHARACTERENCODING);
      try {
         Object[] args = {};
         wc.prepare(tr2, "getCharacterEncoding", args);
         wc.checkRetval(wpr.getCharacterEncoding());
      } catch (Exception e) {
         tr2.appendTcDetail(e.toString());
      }
      tr2.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_getContentType
       */
      /* Details: "Method getContentType(): Calls wrapped method" */
      TestResult tr3 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETCONTENTTYPE);
      try {
         Object[] args = {};
         wc.prepare(tr3, "getContentType", args);
         wc.checkRetval(wpr.getContentType());
      } catch (Exception e) {
         tr3.appendTcDetail(e.toString());
      }
      tr3.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_ResourceResponseWrapper_ApiResource_getLocale
       */
      /* Details: "Method getLocale(): Calls wrapped method" */
      TestResult tr4 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETLOCALE);
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
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_getPortletOutputStream
       */
      /* Details: "Method getPortletOutputStream(): Calls wrapped method" */
      TestResult tr5 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETPORTLETOUTPUTSTREAM);
      try {
         Object[] args = {};
         wc.prepare(tr5, "getPortletOutputStream", args);
         wc.checkRetval(wpr.getPortletOutputStream());
      } catch (Exception e) {
         tr5.appendTcDetail(e.toString());
      }
      tr5.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_ResourceResponseWrapper_ApiResource_getWriter
       */
      /* Details: "Method getWriter(): Calls wrapped method" */
      TestResult tr6 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETWRITER);
      try {
         Object[] args = {};
         wc.prepare(tr6, "getWriter", args);
         wc.checkRetval(wpr.getWriter());
      } catch (Exception e) {
         tr6.appendTcDetail(e.toString());
      }
      tr6.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_isCommitted
       */
      /* Details: "Method isCommitted(): Calls wrapped method" */
      TestResult tr7 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_ISCOMMITTED);
      try {
         Object[] args = {};
         wc.prepare(tr7, "isCommitted", args);
         wc.checkRetval(wpr.isCommitted());
      } catch (Exception e) {
         tr7.appendTcDetail(e.toString());
      }
      tr7.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiResource_reset */
      /* Details: "Method reset(): Calls wrapped method" */
      TestResult tr8 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_RESET);
      try {
         Object[] args = {};
         wc.prepare(tr8, "reset", args);
         wpr.reset();
      } catch (Exception e) {
         tr8.appendTcDetail(e.toString());
      }
      tr8.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_resetBuffer
       */
      /* Details: "Method resetBuffer(): Calls wrapped method" */
      TestResult tr9 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_RESETBUFFER);
      try {
         Object[] args = {};
         wc.prepare(tr9, "resetBuffer", args);
         wpr.resetBuffer();
      } catch (Exception e) {
         tr9.appendTcDetail(e.toString());
      }
      tr9.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_setBufferSize
       */
      /* Details: "Method setBufferSize(int): Calls wrapped method" */
      TestResult tr10 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETBUFFERSIZE);
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
       * TestCase:
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_setContentType
       */
      /* Details: "Method setContentType(String): Calls wrapped method" */
      TestResult tr11 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETCONTENTTYPE);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr11, "setContentType", args);
         wpr.setContentType(parm1);
      } catch (Exception e) {
         tr11.appendTcDetail(e.toString());
      }
      tr11.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_getCacheControl
       */
      /* Details: "Method getCacheControl(): Calls wrapped method" */
      TestResult tr12 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETCACHECONTROL);
      try {
         Object[] args = {};
         wc.prepare(tr12, "getCacheControl", args);
         wc.checkRetval(wpr.getCacheControl());
      } catch (Exception e) {
         tr12.appendTcDetail(e.toString());
      }
      tr12.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_setCharacterEncoding
       */
      /* Details: "Method setCharacterEncoding(String): Calls wrapped */
      /* method" */
      TestResult tr13 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETCHARACTERENCODING);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr13, "setCharacterEncoding", args);
         wpr.setCharacterEncoding(parm1);
      } catch (Exception e) {
         tr13.appendTcDetail(e.toString());
      }
      tr13.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_ResourceResponseWrapper_ApiResource_setLocale
       */
      /* Details: "Method setLocale(Locale): Calls wrapped method" */
      TestResult tr14 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETLOCALE);
      try {
         Locale parm1 = new Locale("en");
         Object[] args = { parm1 };
         wc.prepare(tr14, "setLocale", args);
         wpr.setLocale(parm1);
      } catch (Exception e) {
         tr14.appendTcDetail(e.toString());
      }
      tr14.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_setContentLength
       */
      /* Details: "Method setContentLength(int): Calls wrapped method" */
      TestResult tr15 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETCONTENTLENGTH);
      try {
         int parm1 = 42;
         Object[] args = { parm1 };
         wc.prepare(tr15, "setContentLength", args);
         wpr.setContentLength(parm1);
      } catch (Exception e) {
         tr15.appendTcDetail(e.toString());
      }
      tr15.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_getResponse
       */
      /* Details: "Method getResponse(): Returns wrapped RespurceResponse */
      /* object" */
      TestResult tr16 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETRESPONSE);
      try {
         // The retrieved request / response object should be the wrapper
         // checker instance
         ResourceResponse r = wpr.getResponse();
         tr16.setTcSuccess(r == wc);
      } catch (Exception e) {
         tr16.appendTcDetail(e.toString());
      }
      tr16.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_setResponse
       */
      /* Details: "Method setResponse(ResourceResponse): Allows wrapped */
      /* ResourceResponse object to be set" */
      TestResult tr17 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETRESPONSE);
      try {
         // tested by method set up
         tr17.setTcSuccess(true);
      } catch (Exception e) {
         tr17.appendTcDetail(e.toString());
      }
      tr17.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_createActionURL
       */
      /* Details: "Method createActionURL(): Calls wrapped method" */
      TestResult tr18 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_CREATEACTIONURL);
      try {
         Object[] args = {};
         wc.prepare(tr18, "createActionURL", args);
         wc.checkRetval(wpr.createActionURL());
      } catch (Exception e) {
         tr18.appendTcDetail(e.toString());
      }
      tr18.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_createRenderURL
       */
      /* Details: "Method createRenderURL(): Calls wrapped method" */
      TestResult tr19 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_CREATERENDERURL);
      try {
         Object[] args = {};
         wc.prepare(tr19, "createRenderURL", args);
         wc.checkRetval(wpr.createRenderURL());
      } catch (Exception e) {
         tr19.appendTcDetail(e.toString());
      }
      tr19.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceResponseWrapper_ApiResource_createResourceURL
       */
      /* Details: "Method createResourceURL(): Calls wrapped method" */
      TestResult tr20 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_CREATERESOURCEURL);
      try {
         Object[] args = {};
         wc.prepare(tr20, "createResourceURL", args);
         wc.checkRetval(wpr.createResourceURL());
      } catch (Exception e) {
         tr20.appendTcDetail(e.toString());
      }
      tr20.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write(
            "<div id=\"WrapperTests_ResourceResponseWrapper_ApiResource\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(ResourceURL.PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write(
            "         document.getElementById(\"WrapperTests_ResourceResponseWrapper_ApiResource\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write(
            "   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
