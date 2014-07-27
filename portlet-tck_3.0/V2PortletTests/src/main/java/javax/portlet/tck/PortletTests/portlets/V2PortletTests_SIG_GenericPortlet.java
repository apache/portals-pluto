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

package javax.portlet.tck.PortletTests.portlets;

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
public class V2PortletTests_SIG_GenericPortlet implements Portlet {
   private static final String LOG_CLASS = 
         V2PortletTests_SIG_GenericPortlet.class.getName();
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
      ClassChecker cc = new ClassChecker(GenericPortlet.class);

      // Create result objects for the tests

      /* TestCase: GenericPortlet_SIG_implementsPortlet */
      /* Details: "Implements Portlet " */
      TestResult tr0 = tcd.getTestResultFailed(GENERICPORTLET_SIG_IMPLEMENTSPORTLET);
      {
         tr0.setTcSuccess(cc.implementsInterface(Portlet.class));
      }

      /* TestCase: GenericPortlet_SIG_implementsPortletConfig */
      /* Details: "Implements PortletConfig " */
      TestResult tr1 = tcd.getTestResultFailed(GENERICPORTLET_SIG_IMPLEMENTSPORTLETCONFIG);
      {
         tr1.setTcSuccess(cc.implementsInterface(PortletConfig.class));
      }

      /* TestCase: GenericPortlet_SIG_implementsEventPortlet */
      /* Details: "Implements EventPortlet " */
      TestResult tr2 = tcd.getTestResultFailed(GENERICPORTLET_SIG_IMPLEMENTSEVENTPORTLET);
      {
         tr2.setTcSuccess(cc.implementsInterface(EventPortlet.class));
      }

      /* TestCase: GenericPortlet_SIG_implementsResourceServingPortlet */
      /* Details: "Implements ResourceServingPortlet " */
      TestResult tr3 = tcd.getTestResultFailed(GENERICPORTLET_SIG_IMPLEMENTSRESOURCESERVINGPORTLET);
      {
         tr3.setTcSuccess(cc.implementsInterface(ResourceServingPortlet.class));
      }

      /* TestCase: GenericPortlet_SIG_constructor */
      /* Details: "Provides constructor GenericPortlet() " */
      TestResult tr4 = tcd.getTestResultFailed(GENERICPORTLET_SIG_CONSTRUCTOR);
      {
         Class<?>[] parms = null;
         tr4.setTcSuccess(cc.hasConstructor(parms));
      }

      /* TestCase: GenericPortlet_SIG_hasInit */
      /* Details: "Has a init(PortletConfig) throws PortletException method " */
      TestResult tr5 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASINIT);
      {
         String name = "init";
         Class<?>[] exceptions = {PortletException.class};
         Class<?>[] parms = {PortletConfig.class};
         tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasInitReturns */
      /* Details: "Method init(PortletConfig) returns void " */
      TestResult tr6 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASINITRETURNS);
      {
         String name = "init";
         Class<?> retType = void.class;
         Class<?>[] parms = {PortletConfig.class};
         tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasInitA */
      /* Details: "Has a init() throws PortletException method " */
      TestResult tr7 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASINITA);
      {
         String name = "init";
         Class<?>[] exceptions = {PortletException.class};
         Class<?>[] parms = null;
         tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasInitReturnsA */
      /* Details: "Method init() returns void " */
      TestResult tr8 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASINITRETURNSA);
      {
         String name = "init";
         Class<?> retType = void.class;
         Class<?>[] parms = null;
         tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasProcessAction */
      /* Details: "Has a processAction(ActionRequest, ActionResponse) throws PortletException, java.io.IOException method " */
      TestResult tr9 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASPROCESSACTION);
      {
         String name = "processAction";
         Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
         Class<?>[] parms = {ActionRequest.class, ActionResponse.class};
         tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasProcessActionReturns */
      /* Details: "Method processAction(ActionRequest, ActionResponse) returns void " */
      TestResult tr10 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASPROCESSACTIONRETURNS);
      {
         String name = "processAction";
         Class<?> retType = void.class;
         Class<?>[] parms = {ActionRequest.class, ActionResponse.class};
         tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasRender */
      /* Details: "Has a render(RenderRequest, RenderResponse) throws PortletException, java.io.IOException method " */
      TestResult tr11 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASRENDER);
      {
         String name = "render";
         Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr11.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasRenderReturns */
      /* Details: "Method render(RenderRequest, RenderResponse) returns void " */
      TestResult tr12 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASRENDERRETURNS);
      {
         String name = "render";
         Class<?> retType = void.class;
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr12.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasGetTitle */
      /* Details: "Has a getTitle(RenderRequest)  method " */
      TestResult tr13 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETTITLE);
      {
         String name = "getTitle";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {RenderRequest.class};
         tr13.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasGetTitleReturns */
      /* Details: "Method getTitle(RenderRequest) returns String " */
      TestResult tr14 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETTITLERETURNS);
      {
         String name = "getTitle";
         Class<?> retType = String.class;
         Class<?>[] parms = {RenderRequest.class};
         tr14.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasDoDispatch */
      /* Details: "Has a doDispatch(RenderRequest, RenderResponse) throws PortletException, java.io.IOException method " */
      TestResult tr15 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASDODISPATCH);
      {
         String name = "doDispatch";
         Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr15.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasDoDispatchReturns */
      /* Details: "Method doDispatch(RenderRequest, RenderResponse) returns void " */
      TestResult tr16 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASDODISPATCHRETURNS);
      {
         String name = "doDispatch";
         Class<?> retType = void.class;
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr16.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasDoView */
      /* Details: "Has a doView(RenderRequest, RenderResponse) throws PortletException, java.io.IOException method " */
      TestResult tr17 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASDOVIEW);
      {
         String name = "doView";
         Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr17.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasDoViewReturns */
      /* Details: "Method doView(RenderRequest, RenderResponse) returns void " */
      TestResult tr18 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASDOVIEWRETURNS);
      {
         String name = "doView";
         Class<?> retType = void.class;
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr18.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasDoEdit */
      /* Details: "Has a doEdit(RenderRequest, RenderResponse) throws PortletException, java.io.IOException method " */
      TestResult tr19 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASDOEDIT);
      {
         String name = "doEdit";
         Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr19.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasDoEditReturns */
      /* Details: "Method doEdit(RenderRequest, RenderResponse) returns void " */
      TestResult tr20 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASDOEDITRETURNS);
      {
         String name = "doEdit";
         Class<?> retType = void.class;
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr20.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasDoHelp */
      /* Details: "Has a doHelp(RenderRequest, RenderResponse) throws PortletException, java.io.IOException method " */
      TestResult tr21 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASDOHELP);
      {
         String name = "doHelp";
         Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr21.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasDoHelpReturns */
      /* Details: "Method doHelp(RenderRequest, RenderResponse) returns void " */
      TestResult tr22 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASDOHELPRETURNS);
      {
         String name = "doHelp";
         Class<?> retType = void.class;
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr22.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasGetPortletConfig */
      /* Details: "Has a getPortletConfig()  method " */
      TestResult tr23 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETPORTLETCONFIG);
      {
         String name = "getPortletConfig";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr23.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasGetPortletConfigReturns */
      /* Details: "Method getPortletConfig() returns PortletConfig " */
      TestResult tr24 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETPORTLETCONFIGRETURNS);
      {
         String name = "getPortletConfig";
         Class<?> retType = PortletConfig.class;
         Class<?>[] parms = null;
         tr24.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasDestroy */
      /* Details: "Has a destroy()  method " */
      TestResult tr25 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASDESTROY);
      {
         String name = "destroy";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr25.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasDestroyReturns */
      /* Details: "Method destroy() returns void " */
      TestResult tr26 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASDESTROYRETURNS);
      {
         String name = "destroy";
         Class<?> retType = void.class;
         Class<?>[] parms = null;
         tr26.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasGetPortletName */
      /* Details: "Has a getPortletName()  method " */
      TestResult tr27 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETPORTLETNAME);
      {
         String name = "getPortletName";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr27.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasGetPortletNameReturns */
      /* Details: "Method getPortletName() returns String " */
      TestResult tr28 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETPORTLETNAMERETURNS);
      {
         String name = "getPortletName";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr28.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasGetPortletContext */
      /* Details: "Has a getPortletContext()  method " */
      TestResult tr29 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETPORTLETCONTEXT);
      {
         String name = "getPortletContext";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr29.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasGetPortletContextReturns */
      /* Details: "Method getPortletContext() returns PortletContext " */
      TestResult tr30 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETPORTLETCONTEXTRETURNS);
      {
         String name = "getPortletContext";
         Class<?> retType = PortletContext.class;
         Class<?>[] parms = null;
         tr30.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasGetResourceBundle */
      /* Details: "Has a getResourceBundle(java.util.Locale)  method " */
      TestResult tr31 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETRESOURCEBUNDLE);
      {
         String name = "getResourceBundle";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {java.util.Locale.class};
         tr31.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasGetResourceBundleReturns */
      /* Details: "Method getResourceBundle(java.util.Locale) returns java.util.ResourceBundle " */
      TestResult tr32 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETRESOURCEBUNDLERETURNS);
      {
         String name = "getResourceBundle";
         Class<?> retType = java.util.ResourceBundle.class;
         Class<?>[] parms = {java.util.Locale.class};
         tr32.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasGetInitParameter */
      /* Details: "Has a getInitParameter(String)  method " */
      TestResult tr33 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETINITPARAMETER);
      {
         String name = "getInitParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr33.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasGetInitParameterReturns */
      /* Details: "Method getInitParameter(String) returns String " */
      TestResult tr34 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETINITPARAMETERRETURNS);
      {
         String name = "getInitParameter";
         Class<?> retType = String.class;
         Class<?>[] parms = {String.class};
         tr34.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasGetInitParameterNames */
      /* Details: "Has a getInitParameterNames()  method " */
      TestResult tr35 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETINITPARAMETERNAMES);
      {
         String name = "getInitParameterNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr35.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasGetInitParameterNamesReturns */
      /* Details: "Method getInitParameterNames() returns java.util.Enumeration " */
      TestResult tr36 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETINITPARAMETERNAMESRETURNS);
      {
         String name = "getInitParameterNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr36.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasGetProcessingEventQNames */
      /* Details: "Has a getProcessingEventQNames()  method " */
      TestResult tr37 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETPROCESSINGEVENTQNAMES);
      {
         String name = "getProcessingEventQNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr37.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasGetProcessingEventQNamesReturns */
      /* Details: "Method getProcessingEventQNames() returns java.util.Enumeration " */
      TestResult tr38 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETPROCESSINGEVENTQNAMESRETURNS);
      {
         String name = "getProcessingEventQNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr38.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasGetPublishingEventQNames */
      /* Details: "Has a getPublishingEventQNames()  method " */
      TestResult tr39 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETPUBLISHINGEVENTQNAMES);
      {
         String name = "getPublishingEventQNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr39.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasGetPublishingEventQNamesReturns */
      /* Details: "Method getPublishingEventQNames() returns java.util.Enumeration " */
      TestResult tr40 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETPUBLISHINGEVENTQNAMESRETURNS);
      {
         String name = "getPublishingEventQNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr40.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasGetSupportedLocales */
      /* Details: "Has a getSupportedLocales()  method " */
      TestResult tr41 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETSUPPORTEDLOCALES);
      {
         String name = "getSupportedLocales";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr41.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasGetSupportedLocalesReturns */
      /* Details: "Method getSupportedLocales() returns java.util.Enumeration " */
      TestResult tr42 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETSUPPORTEDLOCALESRETURNS);
      {
         String name = "getSupportedLocales";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr42.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasGetContainerRuntimeOptions */
      /* Details: "Has a getContainerRuntimeOptions()  method " */
      TestResult tr43 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETCONTAINERRUNTIMEOPTIONS);
      {
         String name = "getContainerRuntimeOptions";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr43.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasGetContainerRuntimeOptionsReturns */
      /* Details: "Method getContainerRuntimeOptions() returns java.util.Map " */
      TestResult tr44 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETCONTAINERRUNTIMEOPTIONSRETURNS);
      {
         String name = "getContainerRuntimeOptions";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr44.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasServeResource */
      /* Details: "Has a serveResource(ResourceRequest, ResourceResponse) throws PortletException, java.io.IOException method " */
      TestResult tr45 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASSERVERESOURCE);
      {
         String name = "serveResource";
         Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
         Class<?>[] parms = {ResourceRequest.class, ResourceResponse.class};
         tr45.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasServeResourceReturns */
      /* Details: "Method serveResource(ResourceRequest, ResourceResponse) returns void " */
      TestResult tr46 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASSERVERESOURCERETURNS);
      {
         String name = "serveResource";
         Class<?> retType = void.class;
         Class<?>[] parms = {ResourceRequest.class, ResourceResponse.class};
         tr46.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasProcessEvent */
      /* Details: "Has a processEvent(EventRequest, EventResponse) throws PortletException, java.io.IOException method " */
      TestResult tr47 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASPROCESSEVENT);
      {
         String name = "processEvent";
         Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
         Class<?>[] parms = {EventRequest.class, EventResponse.class};
         tr47.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasProcessEventReturns */
      /* Details: "Method processEvent(EventRequest, EventResponse) returns void " */
      TestResult tr48 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASPROCESSEVENTRETURNS);
      {
         String name = "processEvent";
         Class<?> retType = void.class;
         Class<?>[] parms = {EventRequest.class, EventResponse.class};
         tr48.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasDoHeaders */
      /* Details: "Has a doHeaders(RenderRequest, RenderResponse)  method " */
      TestResult tr49 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASDOHEADERS);
      {
         String name = "doHeaders";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr49.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasDoHeadersReturns */
      /* Details: "Method doHeaders(RenderRequest, RenderResponse) returns void " */
      TestResult tr50 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASDOHEADERSRETURNS);
      {
         String name = "doHeaders";
         Class<?> retType = void.class;
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr50.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasGetNextPossiblePortletModes */
      /* Details: "Has a getNextPossiblePortletModes(RenderRequest)  method " */
      TestResult tr51 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETNEXTPOSSIBLEPORTLETMODES);
      {
         String name = "getNextPossiblePortletModes";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {RenderRequest.class};
         tr51.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasGetNextPossiblePortletModesReturns */
      /* Details: "Method getNextPossiblePortletModes(RenderRequest) returns java.util.Collection " */
      TestResult tr52 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETNEXTPOSSIBLEPORTLETMODESRETURNS);
      {
         String name = "getNextPossiblePortletModes";
         Class<?> retType = java.util.Collection.class;
         Class<?>[] parms = {RenderRequest.class};
         tr52.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasGetPublicRenderParameterNames */
      /* Details: "Has a getPublicRenderParameterNames()  method " */
      TestResult tr53 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETPUBLICRENDERPARAMETERNAMES);
      {
         String name = "getPublicRenderParameterNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr53.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasGetPublicRenderParameterNamesReturns */
      /* Details: "Method getPublicRenderParameterNames() returns java.util.Enumeration " */
      TestResult tr54 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETPUBLICRENDERPARAMETERNAMESRETURNS);
      {
         String name = "getPublicRenderParameterNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr54.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: GenericPortlet_SIG_hasGetDefaultNamespace */
      /* Details: "Has a getDefaultNamespace()  method " */
      TestResult tr55 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETDEFAULTNAMESPACE);
      {
         String name = "getDefaultNamespace";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr55.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: GenericPortlet_SIG_hasGetDefaultNamespaceReturns */
      /* Details: "Method getDefaultNamespace() returns String " */
      TestResult tr56 = tcd.getTestResultFailed(GENERICPORTLET_SIG_HASGETDEFAULTNAMESPACERETURNS);
      {
         String name = "getDefaultNamespace";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr56.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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
      tr45.writeTo(writer);
      tr46.writeTo(writer);
      tr47.writeTo(writer);
      tr48.writeTo(writer);
      tr49.writeTo(writer);
      tr50.writeTo(writer);
      tr51.writeTo(writer);
      tr52.writeTo(writer);
      tr53.writeTo(writer);
      tr54.writeTo(writer);
      tr55.writeTo(writer);
      tr56.writeTo(writer);


   }

}

