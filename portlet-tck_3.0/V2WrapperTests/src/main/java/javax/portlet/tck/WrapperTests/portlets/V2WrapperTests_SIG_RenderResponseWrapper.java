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

package javax.portlet.tck.WrapperTests.portlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */
public class V2WrapperTests_SIG_RenderResponseWrapper implements Portlet {
   private static final String LOG_CLASS = 
         V2WrapperTests_SIG_RenderResponseWrapper.class.getName();
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
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
         throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest renderRequest, RenderResponse renderResponse)
         throws PortletException, IOException {
      
      if (LOGGER.isLoggable(Level.FINE)) {
         LOGGER.logp(Level.FINE, LOG_CLASS, "render", "Entry");
      }

      PrintWriter writer = renderResponse.getWriter();
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
      ClassChecker cc = new ClassChecker(RenderResponseWrapper.class);

      // Create result objects for the tests

      /* TestCase: RenderResponseWrapper_SIG_extendsPortletResponseWrapper */
      /* Details: "Extends PortletResponseWrapper " */
      TestResult tr0 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_EXTENDSPORTLETRESPONSEWRAPPER);
      {
         tr0.setTcSuccess(cc.hasSuperclass(PortletResponseWrapper.class));
      }

      /* TestCase: RenderResponseWrapper_SIG_implementsRenderResponse */
      /* Details: "Implements RenderResponse " */
      TestResult tr1 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_IMPLEMENTSRENDERRESPONSE);
      {
         tr1.setTcSuccess(cc.implementsInterface(RenderResponse.class));
      }

      /* TestCase: RenderResponseWrapper_SIG_constructor */
      /* Details: "Provides constructor RenderResponseWrapper(RenderResponse) " */
      TestResult tr2 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_CONSTRUCTOR);
      {
         Class<?>[] parms = {RenderResponse.class};
         tr2.setTcSuccess(cc.hasConstructor(parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasFlushBuffer */
      /* Details: "Has a flushBuffer() throws java.io.IOException method " */
      TestResult tr3 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASFLUSHBUFFER);
      {
         String name = "flushBuffer";
         Class<?>[] exceptions = {java.io.IOException.class};
         Class<?>[] parms = null;
         tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasFlushBufferReturns */
      /* Details: "Method flushBuffer() returns void " */
      TestResult tr4 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASFLUSHBUFFERRETURNS);
      {
         String name = "flushBuffer";
         Class<?> retType = void.class;
         Class<?>[] parms = null;
         tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetBufferSize */
      /* Details: "Has a getBufferSize()  method " */
      TestResult tr5 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETBUFFERSIZE);
      {
         String name = "getBufferSize";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetBufferSizeReturns */
      /* Details: "Method getBufferSize() returns int " */
      TestResult tr6 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETBUFFERSIZERETURNS);
      {
         String name = "getBufferSize";
         Class<?> retType = int.class;
         Class<?>[] parms = null;
         tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetCharacterEncoding */
      /* Details: "Has a getCharacterEncoding()  method " */
      TestResult tr7 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETCHARACTERENCODING);
      {
         String name = "getCharacterEncoding";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetCharacterEncodingReturns */
      /* Details: "Method getCharacterEncoding() returns String " */
      TestResult tr8 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETCHARACTERENCODINGRETURNS);
      {
         String name = "getCharacterEncoding";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetContentType */
      /* Details: "Has a getContentType()  method " */
      TestResult tr9 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETCONTENTTYPE);
      {
         String name = "getContentType";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetContentTypeReturns */
      /* Details: "Method getContentType() returns String " */
      TestResult tr10 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETCONTENTTYPERETURNS);
      {
         String name = "getContentType";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetLocale */
      /* Details: "Has a getLocale()  method " */
      TestResult tr11 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETLOCALE);
      {
         String name = "getLocale";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr11.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetLocaleReturns */
      /* Details: "Method getLocale() returns java.util.Locale " */
      TestResult tr12 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETLOCALERETURNS);
      {
         String name = "getLocale";
         Class<?> retType = java.util.Locale.class;
         Class<?>[] parms = null;
         tr12.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetPortletOutputStream */
      /* Details: "Has a getPortletOutputStream() throws java.io.IOException method " */
      TestResult tr13 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETPORTLETOUTPUTSTREAM);
      {
         String name = "getPortletOutputStream";
         Class<?>[] exceptions = {java.io.IOException.class};
         Class<?>[] parms = null;
         tr13.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetPortletOutputStreamReturns */
      /* Details: "Method getPortletOutputStream() returns java.io.OutputStream " */
      TestResult tr14 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETPORTLETOUTPUTSTREAMRETURNS);
      {
         String name = "getPortletOutputStream";
         Class<?> retType = java.io.OutputStream.class;
         Class<?>[] parms = null;
         tr14.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetWriter */
      /* Details: "Has a getWriter() throws java.io.IOException method " */
      TestResult tr15 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETWRITER);
      {
         String name = "getWriter";
         Class<?>[] exceptions = {java.io.IOException.class};
         Class<?>[] parms = null;
         tr15.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetWriterReturns */
      /* Details: "Method getWriter() returns java.io.PrintWriter " */
      TestResult tr16 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETWRITERRETURNS);
      {
         String name = "getWriter";
         Class<?> retType = java.io.PrintWriter.class;
         Class<?>[] parms = null;
         tr16.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasIsCommitted */
      /* Details: "Has a isCommitted()  method " */
      TestResult tr17 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASISCOMMITTED);
      {
         String name = "isCommitted";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr17.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasIsCommittedReturns */
      /* Details: "Method isCommitted() returns boolean " */
      TestResult tr18 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASISCOMMITTEDRETURNS);
      {
         String name = "isCommitted";
         Class<?> retType = boolean.class;
         Class<?>[] parms = null;
         tr18.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasReset */
      /* Details: "Has a reset()  method " */
      TestResult tr19 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASRESET);
      {
         String name = "reset";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr19.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasResetReturns */
      /* Details: "Method reset() returns void " */
      TestResult tr20 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASRESETRETURNS);
      {
         String name = "reset";
         Class<?> retType = void.class;
         Class<?>[] parms = null;
         tr20.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasResetBuffer */
      /* Details: "Has a resetBuffer()  method " */
      TestResult tr21 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASRESETBUFFER);
      {
         String name = "resetBuffer";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr21.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasResetBufferReturns */
      /* Details: "Method resetBuffer() returns void " */
      TestResult tr22 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASRESETBUFFERRETURNS);
      {
         String name = "resetBuffer";
         Class<?> retType = void.class;
         Class<?>[] parms = null;
         tr22.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasSetBufferSize */
      /* Details: "Has a setBufferSize(int)  method " */
      TestResult tr23 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASSETBUFFERSIZE);
      {
         String name = "setBufferSize";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {int.class};
         tr23.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasSetBufferSizeReturns */
      /* Details: "Method setBufferSize(int) returns void " */
      TestResult tr24 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASSETBUFFERSIZERETURNS);
      {
         String name = "setBufferSize";
         Class<?> retType = void.class;
         Class<?>[] parms = {int.class};
         tr24.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasSetContentType */
      /* Details: "Has a setContentType(String)  method " */
      TestResult tr25 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASSETCONTENTTYPE);
      {
         String name = "setContentType";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr25.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasSetContentTypeReturns */
      /* Details: "Method setContentType(String) returns void " */
      TestResult tr26 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASSETCONTENTTYPERETURNS);
      {
         String name = "setContentType";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr26.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasSetTitle */
      /* Details: "Has a setTitle(String)  method " */
      TestResult tr27 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASSETTITLE);
      {
         String name = "setTitle";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr27.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasSetTitleReturns */
      /* Details: "Method setTitle(String) returns void " */
      TestResult tr28 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASSETTITLERETURNS);
      {
         String name = "setTitle";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr28.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetCacheControl */
      /* Details: "Has a getCacheControl()  method " */
      TestResult tr29 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETCACHECONTROL);
      {
         String name = "getCacheControl";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr29.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetCacheControlReturns */
      /* Details: "Method getCacheControl() returns CacheControl " */
      TestResult tr30 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETCACHECONTROLRETURNS);
      {
         String name = "getCacheControl";
         Class<?> retType = CacheControl.class;
         Class<?>[] parms = null;
         tr30.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasSetNextPossiblePortletModes */
      /* Details: "Has a setNextPossiblePortletModes(java.util.Collection)  method " */
      TestResult tr31 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASSETNEXTPOSSIBLEPORTLETMODES);
      {
         String name = "setNextPossiblePortletModes";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {java.util.Collection.class};
         tr31.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasSetNextPossiblePortletModesReturns */
      /* Details: "Method setNextPossiblePortletModes(java.util.Collection) returns void " */
      TestResult tr32 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASSETNEXTPOSSIBLEPORTLETMODESRETURNS);
      {
         String name = "setNextPossiblePortletModes";
         Class<?> retType = void.class;
         Class<?>[] parms = {java.util.Collection.class};
         tr32.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetResponse */
      /* Details: "Has a getResponse()  method " */
      TestResult tr33 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETRESPONSE);
      {
         String name = "getResponse";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr33.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetResponseReturns */
      /* Details: "Method getResponse() returns RenderResponse " */
      TestResult tr34 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETRESPONSERETURNS);
      {
         String name = "getResponse";
         Class<?> retType = RenderResponse.class;
         Class<?>[] parms = null;
         tr34.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasSetResponse */
      /* Details: "Has a setResponse(RenderResponse)  method " */
      TestResult tr35 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASSETRESPONSE);
      {
         String name = "setResponse";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {RenderResponse.class};
         tr35.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasSetResponseReturns */
      /* Details: "Method setResponse(RenderResponse) returns void " */
      TestResult tr36 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASSETRESPONSERETURNS);
      {
         String name = "setResponse";
         Class<?> retType = void.class;
         Class<?>[] parms = {RenderResponse.class};
         tr36.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasCreateActionURL */
      /* Details: "Has a createActionURL() throws IllegalStateException method " */
      TestResult tr37 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASCREATEACTIONURL);
      {
         String name = "createActionURL";
         Class<?>[] exceptions = {IllegalStateException.class};
         Class<?>[] parms = null;
         tr37.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasCreateActionURLReturns */
      /* Details: "Method createActionURL() returns PortletURL " */
      TestResult tr38 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASCREATEACTIONURLRETURNS);
      {
         String name = "createActionURL";
         Class<?> retType = PortletURL.class;
         Class<?>[] parms = null;
         tr38.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasCreateRenderURL */
      /* Details: "Has a createRenderURL() throws IllegalStateException method " */
      TestResult tr39 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASCREATERENDERURL);
      {
         String name = "createRenderURL";
         Class<?>[] exceptions = {IllegalStateException.class};
         Class<?>[] parms = null;
         tr39.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasCreateRenderURLReturns */
      /* Details: "Method createRenderURL() returns PortletURL " */
      TestResult tr40 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASCREATERENDERURLRETURNS);
      {
         String name = "createRenderURL";
         Class<?> retType = PortletURL.class;
         Class<?>[] parms = null;
         tr40.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasCreateResourceURL */
      /* Details: "Has a createResourceURL() throws IllegalStateException method " */
      TestResult tr41 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASCREATERESOURCEURL);
      {
         String name = "createResourceURL";
         Class<?>[] exceptions = {IllegalStateException.class};
         Class<?>[] parms = null;
         tr41.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasCreateResourceURLReturns */
      /* Details: "Method createResourceURL() returns ResourceURL " */
      TestResult tr42 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASCREATERESOURCEURLRETURNS);
      {
         String name = "createResourceURL";
         Class<?> retType = ResourceURL.class;
         Class<?>[] parms = null;
         tr42.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetResponseA */
      /* Details: "Has a getResponse()  method " */
      TestResult tr43 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETRESPONSEA);
      {
         String name = "getResponse";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr43.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponseWrapper_SIG_hasGetResponseReturnsA */
      /* Details: "Method getResponse() returns PortletResponse " */
      TestResult tr44 = tcd.getTestResultFailed(RENDERRESPONSEWRAPPER_SIG_HASGETRESPONSERETURNSA);
      {
         String name = "getResponse";
         Class<?> retType = PortletResponse.class;
         Class<?>[] parms = null;
         tr44.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }



      // Write the results to the output stream

      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);
      tr3.writeTo(writer);
      tr4.writeTo(writer);
      tr5.writeTo(writer);
      tr6.writeTo(writer);
      tr7.writeTo(writer);
      tr8.writeTo(writer);
      tr9.writeTo(writer);
      tr10.writeTo(writer);
      tr11.writeTo(writer);
      tr12.writeTo(writer);
      tr13.writeTo(writer);
      tr14.writeTo(writer);
      tr15.writeTo(writer);
      tr16.writeTo(writer);
      tr17.writeTo(writer);
      tr18.writeTo(writer);
      tr19.writeTo(writer);
      tr20.writeTo(writer);
      tr21.writeTo(writer);
      tr22.writeTo(writer);
      tr23.writeTo(writer);
      tr24.writeTo(writer);
      tr25.writeTo(writer);
      tr26.writeTo(writer);
      tr27.writeTo(writer);
      tr28.writeTo(writer);
      tr29.writeTo(writer);
      tr30.writeTo(writer);
      tr31.writeTo(writer);
      tr32.writeTo(writer);
      tr33.writeTo(writer);
      tr34.writeTo(writer);
      tr35.writeTo(writer);
      tr36.writeTo(writer);
      tr37.writeTo(writer);
      tr38.writeTo(writer);
      tr39.writeTo(writer);
      tr40.writeTo(writer);
      tr41.writeTo(writer);
      tr42.writeTo(writer);
      tr43.writeTo(writer);
      tr44.writeTo(writer);


   }

}

