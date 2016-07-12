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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_FIELDHTTP_STATUS_CODE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETLOCALE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETLOCALE4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETCHARACTERENCODING1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETCHARACTERENCODING4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETCONTENTLENGTH1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_CREATERENDERURL2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_CREATEACTIONURL2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_CREATERESOURCEURL2;
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
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
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
 * ResponseTests_ResourceResponse_ApiResource_event
 *
 */
public class ResponseTests_ResourceResponse_ApiResource
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

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletResp.getClass());

      /*
       * TestCase:
       * V2ResponseTests_ResourceResponse_ApiResource_fieldHTTP_STATUS_CODE
       */
      /* Details: "Has String field HTTP_STATUS_CODE with value of */
      /* \"portlet.http-status-code\"" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_FIELDHTTP_STATUS_CODE);
      try {
         tr0.setTcSuccess(
               cc.hasField("HTTP_STATUS_CODE", "portlet.http-status-code"));
      } catch (Exception e) {
         tr0.appendTcDetail(e.toString());
      }
      tr0.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_ApiResource_setLocale1 */
      /* Details: "Method setLocale(Locale): Sets the locale of the */
      /* response" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETLOCALE1);
      tr1.setTcSuccess(true);
      tr1.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_ApiResource_setLocale4 */
      /* Details: "Method setLocale(Locale): Throws */
      /* IllegalArgumentException if the Locale parameter is null" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETLOCALE4);
      tr2.setTcSuccess(true);
      tr2.writeTo(writer);

      /*
       * TestCase:
       * V2ResponseTests_ResourceResponse_ApiResource_setCharacterEncoding1
       */
      /* Details: "Method setCharacterEncoding(String): Sets the character */
      /* encoding of the response" */
      TestResult tr3 = tcd.getTestResultFailed(
            V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETCHARACTERENCODING1);
      tr3.setTcSuccess(true);
      tr3.writeTo(writer);

      /*
       * TestCase:
       * V2ResponseTests_ResourceResponse_ApiResource_setCharacterEncoding4
       */
      /* Details: "Method setCharacterEncoding(String): Throws */
      /* IllegalArgumentException if the Locale parameter is null" */
      TestResult tr4 = tcd.getTestResultFailed(
            V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETCHARACTERENCODING4);
      tr4.setTcSuccess(true);
      tr4.writeTo(writer);

      /*
       * TestCase:
       * V2ResponseTests_ResourceResponse_ApiResource_setContentLength1
       */
      /* Details: "Method setContentLength(int): Sets the length of the */
      /* content body" */
      TestResult tr5 = tcd.getTestResultFailed(
            V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETCONTENTLENGTH1);
      tr5.setTcSuccess(true);
      tr5.writeTo(writer);

      /*
       * TestCase: V2ResponseTests_ResourceResponse_ApiResource_createRenderURL2
       */
      /* Details: "Method createRenderURL(): Throws IllegalStateException */
      /* if the cacheability level for the resource URL triggering the */
      /* serveResource call is not PAGE" */
      TestResult tr6 = tcd.getTestResultFailed(
            V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_CREATERENDERURL2);
      tr6.setTcSuccess(true);
      tr6.writeTo(writer);

      /*
       * TestCase: V2ResponseTests_ResourceResponse_ApiResource_createActionURL2
       */
      /* Details: "Method createActionURL(): Throws IllegalStateException */
      /* if the cacheability level for the resource URL triggering the */
      /* serveResource call is not PAGE" */
      TestResult tr7 = tcd.getTestResultFailed(
            V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_CREATEACTIONURL2);
      tr7.setTcSuccess(true);
      tr7.writeTo(writer);

      /*
       * TestCase:
       * V2ResponseTests_ResourceResponse_ApiResource_createResourceURL2
       */
      /* Details: "Method createResourceURL(): Throws IllegalStateException */
      /* if the cacheability level for the resource URL triggering the */
      /* serveResource call is not PAGE" */
      TestResult tr8 = tcd.getTestResultFailed(
            V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_CREATERESOURCEURL2);
      tr8.setTcSuccess(true);
      tr8.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write(
            "<div id=\"ResponseTests_ResourceResponse_ApiResource\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(ResourceURL.PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write(
            "         document.getElementById(\"ResponseTests_ResourceResponse_ApiResource\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write(
            "   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
