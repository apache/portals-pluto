/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package javax.portlet.tck.portlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTOR;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTORA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTORB;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTORC;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_EXTENDSEXCEPTION;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsException_PortletException_SIGRender_event
 *
 */
public class SigTestsException_PortletException_SIGRender implements Portlet {

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {

    portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();

    // Create result objects for the tests

    ClassChecker cc = new ClassChecker(javax.portlet.PortletException.class);

    /* TestCase: V2SigTestsException_PortletException_SIGRender_constructor */
    /* Details: "PortletException provides constructor PortletException() */
    /* " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTOR);
    try {
      Class<?>[] parms = null;
      tr0.setTcSuccess(cc.hasConstructor(parms));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsException_PortletException_SIGRender_constructorA */
    /* Details: "PortletException provides constructor */
    /* PortletException(String) " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTORA);
    try {
      Class<?>[] parms = {String.class};
      tr1.setTcSuccess(cc.hasConstructor(parms));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsException_PortletException_SIGRender_constructorB */
    /* Details: "PortletException provides constructor */
    /* PortletException(String, Throwable) " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTORB);
    try {
      Class<?>[] parms = {String.class, Throwable.class};
      tr2.setTcSuccess(cc.hasConstructor(parms));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsException_PortletException_SIGRender_constructorC */
    /* Details: "PortletException provides constructor */
    /* PortletException(Throwable) " */
    TestResult tr3 =
        tcd.getTestResultFailed(V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTORC);
    try {
      Class<?>[] parms = {Throwable.class};
      tr3.setTcSuccess(cc.hasConstructor(parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsException_PortletException_SIGRender_extendsException */
    /* Details: "PortletException extends Exception " */
    TestResult tr4 =
        tcd.getTestResultFailed(V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_EXTENDSEXCEPTION);
    try {
      tr4.setTcSuccess(cc.hasSuperclass(Exception.class));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

  }

}
