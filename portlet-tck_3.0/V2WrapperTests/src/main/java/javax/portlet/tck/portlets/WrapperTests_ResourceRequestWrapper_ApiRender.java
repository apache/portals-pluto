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
 * portlet WrapperTests_ResourceRequestWrapper_ApiRender_event
 *
 */
public class WrapperTests_ResourceRequestWrapper_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         WrapperTests_ResourceRequestWrapper_ApiRender.class.getName();
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

      /* TestCase: V2WrapperTests_ResourceRequestWrapper_ApiRender_getPortletInputStream */
      /* Details: "Method getPortletInputStream(): Calls wrapped method"      */
      TestResult tr0 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRENDER_GETPORTLETINPUTSTREAM);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceRequestWrapper_ApiRender_getReader  */
      /* Details: "Method getReader(): Calls wrapped method"                  */
      TestResult tr1 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRENDER_GETREADER);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceRequestWrapper_ApiRender_setCharacterEncoding */
      /* Details: "Method setCharacterEncoding(String): Calls wrapped         */
      /* method"                                                              */
      TestResult tr2 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRENDER_SETCHARACTERENCODING);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceRequestWrapper_ApiRender_getRequest */
      /* Details: "Method getRequest(): Returns wrapped ResourceRequest       */
      /* object"                                                              */
      TestResult tr3 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRENDER_GETREQUEST);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceRequestWrapper_ApiRender_setRequest */
      /* Details: "Method setRequest(ResourceRequest): Allows wrapped         */
      /* ResourceRequest object to be set"                                    */
      TestResult tr4 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRENDER_SETREQUEST);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceRequestWrapper_ApiRender_getCharacterEncoding */
      /* Details: "Method getCharacterEncoding(): Calls wrapped method"       */
      TestResult tr5 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRENDER_GETCHARACTERENCODING);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceRequestWrapper_ApiRender_getContentLength */
      /* Details: "Method getContentLength(): Calls wrapped method"           */
      TestResult tr6 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRENDER_GETCONTENTLENGTH);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceRequestWrapper_ApiRender_getContentType */
      /* Details: "Method getContentType(): Calls wrapped method"             */
      TestResult tr7 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRENDER_GETCONTENTTYPE);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceRequestWrapper_ApiRender_getETag    */
      /* Details: "Method getETag(): Calls wrapped method"                    */
      TestResult tr8 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRENDER_GETETAG);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceRequestWrapper_ApiRender_getMethod  */
      /* Details: "Method getMethod(): Calls wrapped method"                  */
      TestResult tr9 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRENDER_GETMETHOD);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceRequestWrapper_ApiRender_getResourceID */
      /* Details: "Method getResourceID(): Calls wrapped method"              */
      TestResult tr10 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRENDER_GETRESOURCEID);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceRequestWrapper_ApiRender_getPrivateRenderParameterMap */
      /* Details: "Method getPrivateRenderParameterMap(): Calls wrapped       */
      /* method"                                                              */
      TestResult tr11 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRENDER_GETPRIVATERENDERPARAMETERMAP);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceRequestWrapper_ApiRender_getCacheability */
      /* Details: "Method getCacheability(): Calls wrapped method"            */
      TestResult tr12 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRENDER_GETCACHEABILITY);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

   }

}
