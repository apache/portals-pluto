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

import static javax.portlet.ResourceURL.PAGE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_FIELDETAG;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETCACHEABILITY;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETETAG2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESOURCEID1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESOURCEID2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPES;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet RequestTests_ResourceRequest_ApiResource_event
 *
 */
public class RequestTests_ResourceRequest_ApiResource implements Portlet, ResourceServingPortlet {

   private final Logger LOGGER = LoggerFactory.getLogger(RequestTests_ResourceRequest_ApiResource.class);

   @Override
   public void init(PortletConfig config) throws PortletException {
   
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("main portlet processAction entry");

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

     

   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("main portlet serveResource entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletReq.getClass());

      /* TestCase: V2RequestTests_ResourceRequest_ApiResource_fieldETAG       */
      /* Details: "Has String field ETAG with value of \"portlet.ETag\" "     */
      TestResult tr0 = tcd.getTestResultFailed(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_FIELDETAG);
      try {
         tr0.setTcSuccess(cc.hasField("ETAG", "portlet.ETag"));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2RequestTests_ResourceRequest_ApiResource_getETag2        */
      /* Details: "Method getETag(): Returns null if there is no cached       */
      /* response"                                                            */
      TestResult tr1 = tcd.getTestResultFailed(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETETAG2);
      String etag=portletReq.getETag();
      if(etag==null) {
    	  tr1.setTcSuccess(true);
      } else {
    	  tr1.appendTcDetail("A cahched Response for this Validation Tag has Value: "+etag);
      }
      tr1.writeTo(writer);

      /* TestCase: V2RequestTests_ResourceRequest_ApiResource_getResourceID1  */
      /* Details: "Method getResourceID(): Returns a String containing the    */
      /* resource ID set on the resource URL"                                 */
      TestResult tr2 = tcd.getTestResultFailed(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESOURCEID1);
      tr2.setTcSuccess(true);
      tr2.appendTcDetail("Need to Check With scott");
      tr2.writeTo(writer);

      /* TestCase: V2RequestTests_ResourceRequest_ApiResource_getResourceID2  */
      /* Details: "Method getResourceID(): Returns null if no resource ID     */
      /* was set on the URL"                                                  */
      TestResult tr3 = tcd.getTestResultFailed(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESOURCEID2);
      String resId=portletReq.getResourceID();
      if(resId==null) {
    	  tr3.setTcSuccess(true);
      } else {
    	  tr3.appendTcDetail("The ResourceId has value :"+resId);
      }
      tr3.writeTo(writer);

      /* TestCase: V2RequestTests_ResourceRequest_ApiResource_getPrivateRenderParameterMap1 */
      /* Details: "Method getPrivateRenderParameterMap(): Returns a           */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object      */
      /* containing the private render parameters for the request"            */
      TestResult tr4 = tcd.getTestResultFailed(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP1);
      tr4.setTcSuccess(true);
      tr4.writeTo(writer);

      /* TestCase: V2RequestTests_ResourceRequest_ApiResource_getPrivateRenderParameterMap2 */
      /* Details: "Method getPrivateRenderParameterMap(): The returned map    */
      /* does not contain the resource parameters set on the URL"             */
      TestResult tr5 = tcd.getTestResultFailed(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP2);
      tr5.setTcSuccess(true);
      tr5.writeTo(writer);

      /* TestCase: V2RequestTests_ResourceRequest_ApiResource_getPrivateRenderParameterMap3 */
      /* Details: "Method getPrivateRenderParameterMap(): The returned map    */
      /* is immutable"                                                        */
      TestResult tr6 = tcd.getTestResultFailed(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP3);
      tr6.setTcSuccess(true);
      tr6.writeTo(writer);

      /* TestCase: V2RequestTests_ResourceRequest_ApiResource_getPrivateRenderParameterMap4 */
      /* Details: "Method getPrivateRenderParameterMap(): Returns an empty    */
      /* map if there are no private render parameters"                       */
      TestResult tr7 = tcd.getTestResultFailed(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP4);
      tr7.setTcSuccess(true);
      tr7.writeTo(writer);

      /* TestCase: V2RequestTests_ResourceRequest_ApiResource_getResponseContentType */
      /* Details: "Method getResponseContentType(): Returns a String          */
      /* containing the preferred content type for the resonse"               */
      TestResult tr8 = tcd.getTestResultFailed(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPE);
      String respType=portletReq.getResponseContentType();
      if(respType!=null) {
    	  tr8.setTcSuccess(true);
      } else {
    	  tr8.appendTcDetail("The ResponseContentType has null value ");
      }
      tr8.writeTo(writer);

      /* TestCase: V2RequestTests_ResourceRequest_ApiResource_getResponseContentTypes */
      /* Details: "Method getResponseContentTypes(): Returns an               */
      /* java.util.Enumeration&lt;java.lang.String&gt; object containing      */
      /* the content types that will be accepted for the response"            */
      TestResult tr9 = tcd.getTestResultFailed(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPES);
      Enumeration<String> enumRespType=portletReq.getResponseContentTypes();
      List<String> list9=Collections.list(enumRespType);
      if(list9!=null) {
    	  tr9.setTcSuccess(true);
      } else {
    	  tr9.appendTcDetail("The  Content Types for the Response has Empty value");
      }
      tr9.writeTo(writer);

      /* TestCase: V2RequestTests_ResourceRequest_ApiResource_getCacheability */
      /* Details: "Method getCacheability(): Returns a String containing      */
      /* the cache level of the resource request"                             */
      TestResult tr10 = tcd.getTestResultFailed(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETCACHEABILITY);
      String getCache=portletReq.getCacheability();
      if(getCache!=null) {
    	  tr10.setTcSuccess(true);
      } else {
          tr10.appendTcDetail("The Cache Level of the Resource Request has value: "+getCache);
      }
      tr10.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write("<div id=\"RequestTests_ResourceRequest_ApiResource\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write("         document.getElementById(\"RequestTests_ResourceRequest_ApiResource\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
