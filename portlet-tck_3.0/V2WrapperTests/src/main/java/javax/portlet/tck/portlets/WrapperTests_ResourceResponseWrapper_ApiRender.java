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
 * portlet WrapperTests_ResourceResponseWrapper_ApiRender_event
 *
 */
public class WrapperTests_ResourceResponseWrapper_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         WrapperTests_ResourceResponseWrapper_ApiRender.class.getName();
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

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_flushBuffer */
      /* Details: "Method flushBuffer(): Calls wrapped method"                */
      TestResult tr0 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_FLUSHBUFFER);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_getBufferSize */
      /* Details: "Method getBufferSize(): Calls wrapped method"              */
      TestResult tr1 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_GETBUFFERSIZE);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_getCharacterEncoding */
      /* Details: "Method getCharacterEncoding(): Calls wrapped method"       */
      TestResult tr2 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_GETCHARACTERENCODING);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_getContentType */
      /* Details: "Method getContentType(): Calls wrapped method"             */
      TestResult tr3 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_GETCONTENTTYPE);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_getLocale */
      /* Details: "Method getLocale(): Calls wrapped method"                  */
      TestResult tr4 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_GETLOCALE);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_getPortletOutputStream */
      /* Details: "Method getPortletOutputStream(): Calls wrapped method"     */
      TestResult tr5 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_GETPORTLETOUTPUTSTREAM);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_getWriter */
      /* Details: "Method getWriter(): Calls wrapped method"                  */
      TestResult tr6 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_GETWRITER);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_isCommitted */
      /* Details: "Method isCommitted(): Calls wrapped method"                */
      TestResult tr7 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_ISCOMMITTED);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_reset     */
      /* Details: "Method reset(): Calls wrapped method"                      */
      TestResult tr8 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_RESET);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_resetBuffer */
      /* Details: "Method resetBuffer(): Calls wrapped method"                */
      TestResult tr9 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_RESETBUFFER);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_setBufferSize */
      /* Details: "Method setBufferSize(int): Calls wrapped method"           */
      TestResult tr10 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_SETBUFFERSIZE);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_setContentType */
      /* Details: "Method setContentType(String): Calls wrapped method"       */
      TestResult tr11 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_SETCONTENTTYPE);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_getCacheControl */
      /* Details: "Method getCacheControl(): Calls wrapped method"            */
      TestResult tr12 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_GETCACHECONTROL);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_setCharacterEncoding */
      /* Details: "Method setCharacterEncoding(String): Calls wrapped         */
      /* method"                                                              */
      TestResult tr13 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_SETCHARACTERENCODING);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_setLocale */
      /* Details: "Method setLocale(Locale): Calls wrapped method"            */
      TestResult tr14 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_SETLOCALE);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_setContentLength */
      /* Details: "Method setContentLength(int): Calls wrapped method"        */
      TestResult tr15 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_SETCONTENTLENGTH);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_getResponse */
      /* Details: "Method getResponse(): Returns wrapped RespurceResponse     */
      /* object"                                                              */
      TestResult tr16 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_GETRESPONSE);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_setResponse */
      /* Details: "Method setResponse(ResourceResponse): Allows wrapped       */
      /* ResourceResponse object to be set"                                   */
      TestResult tr17 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_SETRESPONSE);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_createActionURL */
      /* Details: "Method createActionURL(): Calls wrapped method"            */
      TestResult tr18 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_CREATEACTIONURL);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_createRenderURL */
      /* Details: "Method createRenderURL(): Calls wrapped method"            */
      TestResult tr19 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_CREATERENDERURL);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2WrapperTests_ResourceResponseWrapper_ApiRender_createResourceURL */
      /* Details: "Method createResourceURL(): Calls wrapped method"          */
      TestResult tr20 = tcd.getTestResultFailed(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRENDER_CREATERESOURCEURL);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

   }

}
