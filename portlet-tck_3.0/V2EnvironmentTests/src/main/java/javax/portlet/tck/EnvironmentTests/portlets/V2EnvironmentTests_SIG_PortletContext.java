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

package javax.portlet.tck.EnvironmentTests.portlets;

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
public class V2EnvironmentTests_SIG_PortletContext implements Portlet {
   private static final String LOG_CLASS = 
         V2EnvironmentTests_SIG_PortletContext.class.getName();
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
      ClassChecker cc = new ClassChecker(portletConfig.getPortletContext().getClass());

      // Create result objects for the tests

      /* TestCase: PortletContext_SIG_hasGetServerInfo */
      /* Details: "Has a getServerInfo()  method " */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETSERVERINFO);
      {
         String name = "getServerInfo";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetServerInfoReturns */
      /* Details: "Method getServerInfo() returns String " */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETSERVERINFORETURNS);
      {
         String name = "getServerInfo";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasGetRequestDispatcher */
      /* Details: "Has a getRequestDispatcher(String)  method " */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETREQUESTDISPATCHER);
      {
         String name = "getRequestDispatcher";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetRequestDispatcherReturns */
      /* Details: "Method getRequestDispatcher(String) returns PortletRequestDispatcher " */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETREQUESTDISPATCHERRETURNS);
      {
         String name = "getRequestDispatcher";
         Class<?> retType = PortletRequestDispatcher.class;
         Class<?>[] parms = {String.class};
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasGetNamedDispatcher */
      /* Details: "Has a getNamedDispatcher(String)  method " */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETNAMEDDISPATCHER);
      {
         String name = "getNamedDispatcher";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetNamedDispatcherReturns */
      /* Details: "Method getNamedDispatcher(String) returns PortletRequestDispatcher " */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETNAMEDDISPATCHERRETURNS);
      {
         String name = "getNamedDispatcher";
         Class<?> retType = PortletRequestDispatcher.class;
         Class<?>[] parms = {String.class};
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasGetResourceAsStream */
      /* Details: "Has a getResourceAsStream(String)  method " */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETRESOURCEASSTREAM);
      {
         String name = "getResourceAsStream";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetResourceAsStreamReturns */
      /* Details: "Method getResourceAsStream(String) returns java.io.InputStream " */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETRESOURCEASSTREAMRETURNS);
      {
         String name = "getResourceAsStream";
         Class<?> retType = java.io.InputStream.class;
         Class<?>[] parms = {String.class};
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasGetMajorVersion */
      /* Details: "Has a getMajorVersion()  method " */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETMAJORVERSION);
      {
         String name = "getMajorVersion";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetMajorVersionReturns */
      /* Details: "Method getMajorVersion() returns int " */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETMAJORVERSIONRETURNS);
      {
         String name = "getMajorVersion";
         Class<?> retType = int.class;
         Class<?>[] parms = null;
         tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasGetMinorVersion */
      /* Details: "Has a getMinorVersion()  method " */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETMINORVERSION);
      {
         String name = "getMinorVersion";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetMinorVersionReturns */
      /* Details: "Method getMinorVersion() returns int " */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETMINORVERSIONRETURNS);
      {
         String name = "getMinorVersion";
         Class<?> retType = int.class;
         Class<?>[] parms = null;
         tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasGetMimeType */
      /* Details: "Has a getMimeType(String)  method " */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETMIMETYPE);
      {
         String name = "getMimeType";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetMimeTypeReturns */
      /* Details: "Method getMimeType(String) returns String " */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETMIMETYPERETURNS);
      {
         String name = "getMimeType";
         Class<?> retType = String.class;
         Class<?>[] parms = {String.class};
         tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasGetRealPath */
      /* Details: "Has a getRealPath(String)  method " */
      TestResult tr14 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETREALPATH);
      {
         String name = "getRealPath";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetRealPathReturns */
      /* Details: "Method getRealPath(String) returns String " */
      TestResult tr15 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETREALPATHRETURNS);
      {
         String name = "getRealPath";
         Class<?> retType = String.class;
         Class<?>[] parms = {String.class};
         tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasGetResourcePaths */
      /* Details: "Has a getResourcePaths(String)  method " */
      TestResult tr16 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETRESOURCEPATHS);
      {
         String name = "getResourcePaths";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetResourcePathsReturns */
      /* Details: "Method getResourcePaths(String) returns java.util.Set " */
      TestResult tr17 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETRESOURCEPATHSRETURNS);
      {
         String name = "getResourcePaths";
         Class<?> retType = java.util.Set.class;
         Class<?>[] parms = {String.class};
         tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasGetResource */
      /* Details: "Has a getResource(String) throws java.net.MalformedURLException method " */
      TestResult tr18 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETRESOURCE);
      {
         String name = "getResource";
         Class<?>[] exceptions = {java.net.MalformedURLException.class};
         Class<?>[] parms = {String.class};
         tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetResourceReturns */
      /* Details: "Method getResource(String) returns java.net.URL " */
      TestResult tr19 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETRESOURCERETURNS);
      {
         String name = "getResource";
         Class<?> retType = java.net.URL.class;
         Class<?>[] parms = {String.class};
         tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasGetAttribute */
      /* Details: "Has a getAttribute(String)  method " */
      TestResult tr20 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETATTRIBUTE);
      {
         String name = "getAttribute";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr20.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetAttributeReturns */
      /* Details: "Method getAttribute(String) returns Object " */
      TestResult tr21 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETATTRIBUTERETURNS);
      {
         String name = "getAttribute";
         Class<?> retType = Object.class;
         Class<?>[] parms = {String.class};
         tr21.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasGetAttributeNames */
      /* Details: "Has a getAttributeNames()  method " */
      TestResult tr22 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETATTRIBUTENAMES);
      {
         String name = "getAttributeNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr22.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetAttributeNamesReturns */
      /* Details: "Method getAttributeNames() returns java.util.Enumeration " */
      TestResult tr23 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETATTRIBUTENAMESRETURNS);
      {
         String name = "getAttributeNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr23.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasGetInitParameter */
      /* Details: "Has a getInitParameter(String)  method " */
      TestResult tr24 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETINITPARAMETER);
      {
         String name = "getInitParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr24.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetInitParameterReturns */
      /* Details: "Method getInitParameter(String) returns String " */
      TestResult tr25 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETINITPARAMETERRETURNS);
      {
         String name = "getInitParameter";
         Class<?> retType = String.class;
         Class<?>[] parms = {String.class};
         tr25.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasGetInitParameterNames */
      /* Details: "Has a getInitParameterNames()  method " */
      TestResult tr26 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETINITPARAMETERNAMES);
      {
         String name = "getInitParameterNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr26.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetInitParameterNamesReturns */
      /* Details: "Method getInitParameterNames() returns java.util.Enumeration " */
      TestResult tr27 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETINITPARAMETERNAMESRETURNS);
      {
         String name = "getInitParameterNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr27.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasLog */
      /* Details: "Has a log(String)  method " */
      TestResult tr28 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASLOG);
      {
         String name = "log";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr28.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasLogReturns */
      /* Details: "Method log(String) returns void " */
      TestResult tr29 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASLOGRETURNS);
      {
         String name = "log";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr29.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasLogA */
      /* Details: "Has a log(String, Throwable)  method " */
      TestResult tr30 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASLOGA);
      {
         String name = "log";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, Throwable.class};
         tr30.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasLogReturnsA */
      /* Details: "Method log(String, Throwable) returns void " */
      TestResult tr31 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASLOGRETURNSA);
      {
         String name = "log";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, Throwable.class};
         tr31.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasRemoveAttribute */
      /* Details: "Has a removeAttribute(String)  method " */
      TestResult tr32 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASREMOVEATTRIBUTE);
      {
         String name = "removeAttribute";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr32.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasRemoveAttributeReturns */
      /* Details: "Method removeAttribute(String) returns void " */
      TestResult tr33 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASREMOVEATTRIBUTERETURNS);
      {
         String name = "removeAttribute";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr33.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasSetAttribute */
      /* Details: "Has a setAttribute(String, Object)  method " */
      TestResult tr34 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASSETATTRIBUTE);
      {
         String name = "setAttribute";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, Object.class};
         tr34.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasSetAttributeReturns */
      /* Details: "Method setAttribute(String, Object) returns void " */
      TestResult tr35 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASSETATTRIBUTERETURNS);
      {
         String name = "setAttribute";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, Object.class};
         tr35.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasGetPortletContextName */
      /* Details: "Has a getPortletContextName()  method " */
      TestResult tr36 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETPORTLETCONTEXTNAME);
      {
         String name = "getPortletContextName";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr36.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetPortletContextNameReturns */
      /* Details: "Method getPortletContextName() returns String " */
      TestResult tr37 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETPORTLETCONTEXTNAMERETURNS);
      {
         String name = "getPortletContextName";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr37.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletContext_SIG_hasGetContainerRuntimeOptions */
      /* Details: "Has a getContainerRuntimeOptions()  method " */
      TestResult tr38 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETCONTAINERRUNTIMEOPTIONS);
      {
         String name = "getContainerRuntimeOptions";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr38.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletContext_SIG_hasGetContainerRuntimeOptionsReturns */
      /* Details: "Method getContainerRuntimeOptions() returns java.util.Enumeration " */
      TestResult tr39 = tcd.getTestResultFailed(PORTLETCONTEXT_SIG_HASGETCONTAINERRUNTIMEOPTIONSRETURNS);
      {
         String name = "getContainerRuntimeOptions";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr39.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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


   }

}

