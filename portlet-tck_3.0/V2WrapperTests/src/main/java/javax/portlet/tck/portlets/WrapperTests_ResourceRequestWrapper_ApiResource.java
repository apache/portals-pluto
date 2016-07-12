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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETPORTLETINPUTSTREAM;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETREADER;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_SETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETREQUEST;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_SETREQUEST;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCONTENTLENGTH;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETETAG;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETMETHOD;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETRESOURCEID;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCACHEABILITY;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;

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
import javax.portlet.filter.ResourceRequestWrapper;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.ResourceRequestWrapperChecker;
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
 * WrapperTests_ResourceRequestWrapper_ApiResource_event
 *
 */
public class WrapperTests_ResourceRequestWrapper_ApiResource
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

      ResourceRequestWrapperChecker wc = new ResourceRequestWrapperChecker(
            portletReq);
      ResourceRequestWrapper wpr = new ResourceRequestWrapper(portletReq);
      wpr.setRequest(wc);
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /*
       * TestCase:
       * V2WrapperTests_ResourceRequestWrapper_ApiResource_getPortletInputStream
       */
      /* Details: "Method getPortletInputStream(): Calls wrapped method" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETPORTLETINPUTSTREAM);
      try {
         Object[] args = {};
         wc.prepare(tr0, "getPortletInputStream", args);
         wc.checkRetval(wpr.getPortletInputStream());
      } catch (Exception e) {
         tr0.appendTcDetail(e.toString());
      }
      tr0.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_ResourceRequestWrapper_ApiResource_getReader
       */
      /* Details: "Method getReader(): Calls wrapped method" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETREADER);
      try {
         Object[] args = {};
         wc.prepare(tr1, "getReader", args);
         wc.checkRetval(wpr.getReader());
      } catch (Exception e) {
         tr1.appendTcDetail(e.toString());
      }
      tr1.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceRequestWrapper_ApiResource_setCharacterEncoding
       */
      /* Details: "Method setCharacterEncoding(String): Calls wrapped */
      /* method" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_SETCHARACTERENCODING);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr2, "setCharacterEncoding", args);
         wpr.setCharacterEncoding(parm1);
      } catch (Exception e) {
         tr2.appendTcDetail(e.toString());
      }
      tr2.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_ResourceRequestWrapper_ApiResource_getRequest
       */
      /* Details: "Method getRequest(): Returns wrapped ResourceRequest */
      /* object" */
      TestResult tr3 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETREQUEST);
      try {
         // The retrieved request / response object should be the wrapper
         // checker instance
         ResourceRequest r = wpr.getRequest();
         tr3.setTcSuccess(r == wc);
      } catch (Exception e) {
         tr3.appendTcDetail(e.toString());
      }
      tr3.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_ResourceRequestWrapper_ApiResource_setRequest
       */
      /* Details: "Method setRequest(ResourceRequest): Allows wrapped */
      /* ResourceRequest object to be set" */
      TestResult tr4 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_SETREQUEST);
      try {
         // tested by method set up
         tr4.setTcSuccess(true);
      } catch (Exception e) {
         tr4.appendTcDetail(e.toString());
      }
      tr4.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceRequestWrapper_ApiResource_getCharacterEncoding
       */
      /* Details: "Method getCharacterEncoding(): Calls wrapped method" */
      TestResult tr5 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCHARACTERENCODING);
      try {
         Object[] args = {};
         wc.prepare(tr5, "getCharacterEncoding", args);
         wc.checkRetval(wpr.getCharacterEncoding());
      } catch (Exception e) {
         tr5.appendTcDetail(e.toString());
      }
      tr5.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceRequestWrapper_ApiResource_getContentLength
       */
      /* Details: "Method getContentLength(): Calls wrapped method" */
      TestResult tr6 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCONTENTLENGTH);
      try {
         Object[] args = {};
         wc.prepare(tr6, "getContentLength", args);
         wc.checkRetval(wpr.getContentLength());
      } catch (Exception e) {
         tr6.appendTcDetail(e.toString());
      }
      tr6.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceRequestWrapper_ApiResource_getContentType
       */
      /* Details: "Method getContentType(): Calls wrapped method" */
      TestResult tr7 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCONTENTTYPE);
      try {
         Object[] args = {};
         wc.prepare(tr7, "getContentType", args);
         wc.checkRetval(wpr.getContentType());
      } catch (Exception e) {
         tr7.appendTcDetail(e.toString());
      }
      tr7.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceRequestWrapper_ApiResource_getETag */
      /* Details: "Method getETag(): Calls wrapped method" */
      TestResult tr8 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETETAG);
      try {
         Object[] args = {};
         wc.prepare(tr8, "getETag", args);
         wc.checkRetval(wpr.getETag());
      } catch (Exception e) {
         tr8.appendTcDetail(e.toString());
      }
      tr8.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_ResourceRequestWrapper_ApiResource_getMethod
       */
      /* Details: "Method getMethod(): Calls wrapped method" */
      TestResult tr9 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETMETHOD);
      try {
         Object[] args = {};
         wc.prepare(tr9, "getMethod", args);
         wc.checkRetval(wpr.getMethod());
      } catch (Exception e) {
         tr9.appendTcDetail(e.toString());
      }
      tr9.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceRequestWrapper_ApiResource_getResourceID
       */
      /* Details: "Method getResourceID(): Calls wrapped method" */
      TestResult tr10 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETRESOURCEID);
      try {
         Object[] args = {};
         wc.prepare(tr10, "getResourceID", args);
         wc.checkRetval(wpr.getResourceID());
      } catch (Exception e) {
         tr10.appendTcDetail(e.toString());
      }
      tr10.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceRequestWrapper_ApiResource_getPrivateRenderParameterMap
       */
      /* Details: "Method getPrivateRenderParameterMap(): Calls wrapped */
      /* method" */
      TestResult tr11 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP);
      try {
         Object[] args = {};
         wc.prepare(tr11, "getPrivateRenderParameterMap", args);
         wc.checkRetval(wpr.getPrivateRenderParameterMap());
      } catch (Exception e) {
         tr11.appendTcDetail(e.toString());
      }
      tr11.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ResourceRequestWrapper_ApiResource_getCacheability
       */
      /* Details: "Method getCacheability(): Calls wrapped method" */
      TestResult tr12 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCACHEABILITY);
      try {
         Object[] args = {};
         wc.prepare(tr12, "getCacheability", args);
         wc.checkRetval(wpr.getCacheability());
      } catch (Exception e) {
         tr12.appendTcDetail(e.toString());
      }
      tr12.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write(
            "<div id=\"WrapperTests_ResourceRequestWrapper_ApiResource\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(ResourceURL.PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write(
            "         document.getElementById(\"WrapperTests_ResourceRequestWrapper_ApiResource\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write(
            "   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
