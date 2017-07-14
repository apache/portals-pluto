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
import java.io.StringWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYB;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYRETURNSB;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASCREATEELEMENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASCREATEELEMENTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASENCODEURL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASENCODEURLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASGETNAMESPACE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASGETNAMESPACERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASSETPROPERTY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASSETPROPERTYRETURNS;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, but does
 * not publish them. Events are published in the main portlet for the test cases.
 */
public class SigTestsEvent_PortletResponse_SIGEvent_event implements Portlet, EventPortlet {

  private final Logger LOGGER = LoggerFactory.getLogger(SigTestsEvent_PortletResponse_SIGEvent_event.class);

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {
    LOGGER.trace("event companion processAction - ERROR!!");
  }

  @Override
  public void processEvent(EventRequest portletReq, EventResponse portletResp)
      throws PortletException, IOException {

    portletResp.setRenderParameters(portletReq);

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    StringWriter writer = new StringWriter();

    JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();

    // Create result objects for the tests

    ClassChecker cc = new ClassChecker(portletResp.getClass());

    /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasAddProperty */
    /* Details: "EventResponse has a addProperty(String, String) method */
    /* " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTY);
    try {
      String name = "addProperty";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, String.class};
      tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyA */
    /* Details: "EventResponse has a */
    /* addProperty(javax.servlet.http.Cookie) method " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYA);
    try {
      String name = "addProperty";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {javax.servlet.http.Cookie.class};
      tr1.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyB */
    /* Details: "EventResponse has a addProperty(String, */
    /* org.w3c.dom.Element) method " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYB);
    try {
      String name = "addProperty";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, org.w3c.dom.Element.class};
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyReturns */
    /* Details: "EventResponse method addProperty(String, String) returns */
    /* void " */
    TestResult tr3 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYRETURNS);
    try {
      String name = "addProperty";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, String.class};
      tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyReturnsA */
    /* Details: "EventResponse method */
    /* addProperty(javax.servlet.http.Cookie) returns void " */
    TestResult tr4 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYRETURNSA);
    try {
      String name = "addProperty";
      Class<?> retType = void.class;
      Class<?>[] parms = {javax.servlet.http.Cookie.class};
      tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyReturnsB */
    /* Details: "EventResponse method addProperty(String, */
    /* org.w3c.dom.Element) returns void " */
    TestResult tr5 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYRETURNSB);
    try {
      String name = "addProperty";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, org.w3c.dom.Element.class};
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasCreateElement */
    /* Details: "EventResponse has a createElement(String) throws */
    /* org.w3c.dom.DOMException method " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASCREATEELEMENT);
    try {
      String name = "createElement";
      Class<?>[] exceptions = {org.w3c.dom.DOMException.class};
      Class<?>[] parms = {String.class};
      tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasCreateElementReturns */
    /* Details: "EventResponse method createElement(String) returns */
    /* org.w3c.dom.Element " */
    TestResult tr7 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASCREATEELEMENTRETURNS);
    try {
      String name = "createElement";
      Class<?> retType = org.w3c.dom.Element.class;
      Class<?>[] parms = {String.class};
      tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasEncodeURL */
    /* Details: "EventResponse has a encodeURL(String)  method " */
    TestResult tr8 = tcd.getTestResultFailed(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASENCODEURL);
    try {
      String name = "encodeURL";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasEncodeURLReturns */
    /* Details: "EventResponse method encodeURL(String) returns String " */
    TestResult tr9 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASENCODEURLRETURNS);
    try {
      String name = "encodeURL";
      Class<?> retType = String.class;
      Class<?>[] parms = {String.class};
      tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasGetNamespace */
    /* Details: "EventResponse has a getNamespace()  method " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASGETNAMESPACE);
    try {
      String name = "getNamespace";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasGetNamespaceReturns */
    /* Details: "EventResponse method getNamespace() returns String " */
    TestResult tr11 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASGETNAMESPACERETURNS);
    try {
      String name = "getNamespace";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasSetProperty */
    /* Details: "EventResponse has a setProperty(String, String) method */
    /* " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASSETPROPERTY);
    try {
      String name = "setProperty";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, String.class};
      tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsEvent_PortletResponse_SIGEvent_hasSetPropertyReturns */
    /* Details: "EventResponse method setProperty(String, String) returns */
    /* void " */
    TestResult tr13 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASSETPROPERTYRETURNS);
    try {
      String name = "setProperty";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, String.class};
      tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "SigTestsEvent_PortletResponse_SIGEvent", writer.toString(),
        APPLICATION_SCOPE);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    portletResp.setContentType("text/html");
    PrintWriter writer = portletResp.getWriter();
    writer.write("<h3>Event Companion Portlet </h3>\n");
    writer.write("<p>SigTestsEvent_PortletResponse_SIGEvent_event</p>\n");

    String msg = (String) portletReq.getPortletSession().getAttribute(
        RESULT_ATTR_PREFIX + "SigTestsEvent_PortletResponse_SIGEvent", APPLICATION_SCOPE);
    msg = (msg == null) ? "Not ready. click test case link." : msg;
    writer.write("<p>" + msg + "</p>\n");

  }

}
