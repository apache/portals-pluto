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
 * portlet RequestTests_ResourceRequest_ApiResource_event
 *
 */
public class RequestTests_ResourceRequest_ApiResource implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         RequestTests_ResourceRequest_ApiResource.class.getName();
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
      Map<String,String[]> s=portletReq.getPrivateRenderParameterMap();
      tr4.appendTcDetail("Not implemented."+s.size());
      tr4.writeTo(writer);

      /* TestCase: V2RequestTests_ResourceRequest_ApiResource_getPrivateRenderParameterMap2 */
      /* Details: "Method getPrivateRenderParameterMap(): The returned map    */
      /* does not contain the resource parameters set on the URL"             */
      TestResult tr5 = tcd.getTestResultFailed(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP2);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2RequestTests_ResourceRequest_ApiResource_getPrivateRenderParameterMap3 */
      /* Details: "Method getPrivateRenderParameterMap(): The returned map    */
      /* is immutable"                                                        */
      TestResult tr6 = tcd.getTestResultFailed(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP3);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2RequestTests_ResourceRequest_ApiResource_getPrivateRenderParameterMap4 */
      /* Details: "Method getPrivateRenderParameterMap(): Returns an empty    */
      /* map if there are no private render parameters"                       */
      TestResult tr7 = tcd.getTestResultFailed(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP4);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
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
    	  tr9.appendTcDetail("The Enumeration of Content Types for the Response has Empty value");
      }
      tr9.writeTo(writer);

      /* TestCase: V2RequestTests_ResourceRequest_ApiResource_getCacheability */
      /* Details: "Method getCacheability(): Returns a String containing      */
      /* the cache level of the resource request"                             */
      TestResult tr10 = tcd.getTestResultFailed(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETCACHEABILITY);
      String getCache=portletReq.getCacheability();
      if(getCache.equals("cacheLevelPage")) {
    	  tr10.setTcSuccess(true);
      } else {
          tr10.appendTcDetail("The Cache Level of the Resource Request has value: "+getCache);
      }
      tr10.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

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
