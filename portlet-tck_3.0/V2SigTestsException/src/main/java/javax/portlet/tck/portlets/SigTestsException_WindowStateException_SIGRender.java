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
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.*;
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
 * portlet SigTestsException_WindowStateException_SIGRender_event
 *
 */
public class SigTestsException_WindowStateException_SIGRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         SigTestsException_WindowStateException_SIGRender.class.getName();
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

      JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(javax.portlet.WindowStateException.class);

      /* TestCase: V2SigTestsException_WindowStateException_SIGRender_constructor */
      /* Details: "WindowStateException provides constructor                  */
      /* WindowStateException(String, WindowState) "                          */
      TestResult tr0 = tcd.getTestResultFailed(V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_CONSTRUCTOR);
      try {
         Class<?>[] parms = {String.class, WindowState.class};
         tr0.setTcSuccess(cc.hasConstructor(parms));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2SigTestsException_WindowStateException_SIGRender_constructorA */
      /* Details: "WindowStateException provides constructor                  */
      /* WindowStateException(String, Throwable, WindowState) "               */
      TestResult tr1 = tcd.getTestResultFailed(V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_CONSTRUCTORA);
      try {
         Class<?>[] parms = {String.class, Throwable.class, WindowState.class};
         tr1.setTcSuccess(cc.hasConstructor(parms));
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2SigTestsException_WindowStateException_SIGRender_constructorB */
      /* Details: "WindowStateException provides constructor                  */
      /* WindowStateException(Throwable, WindowState) "                       */
      TestResult tr2 = tcd.getTestResultFailed(V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_CONSTRUCTORB);
      try {
         Class<?>[] parms = {Throwable.class, WindowState.class};
         tr2.setTcSuccess(cc.hasConstructor(parms));
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2SigTestsException_WindowStateException_SIGRender_extendsPortletException */
      /* Details: "WindowStateException extends PortletException "            */
      TestResult tr3 = tcd.getTestResultFailed(V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_EXTENDSPORTLETEXCEPTION);
      try {
         tr3.setTcSuccess(cc.hasSuperclass(PortletException.class));
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2SigTestsException_WindowStateException_SIGRender_hasGetState */
      /* Details: "WindowStateException has a getState()  method "            */
      TestResult tr4 = tcd.getTestResultFailed(V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_HASGETSTATE);
      try {
         String name = "getState";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2SigTestsException_WindowStateException_SIGRender_hasGetStateReturns */
      /* Details: "WindowStateException method getState() returns             */
      /* WindowState "                                                        */
      TestResult tr5 = tcd.getTestResultFailed(V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_HASGETSTATERETURNS);
      try {
         String name = "getState";
         Class<?> retType = WindowState.class;
         Class<?>[] parms = null;
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

   }

}
