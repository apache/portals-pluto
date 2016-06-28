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
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYB;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYRETURNSB;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASCREATEELEMENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASCREATEELEMENTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASENCODEURL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASENCODEURLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASGETNAMESPACE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASGETNAMESPACERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASSETPROPERTY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASSETPROPERTYRETURNS;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsAction_PortletResponse_SIGAction_event
 *
 */
public class SigTestsAction_PortletResponse_SIGAction implements Portlet {

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

    StringWriter writer = new StringWriter();

    JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();

    // Create result objects for the tests

    ClassChecker cc = new ClassChecker(portletResp.getClass());

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasAddProperty */
    /* Details: "ActionResponse has a addProperty(String, String) method */
    /* " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTY);
    try {
      String name = "addProperty";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, String.class};
      tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasAddPropertyA */
    /* Details: "ActionResponse has a */
    /* addProperty(javax.servlet.http.Cookie) method " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYA);
    try {
      String name = "addProperty";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {javax.servlet.http.Cookie.class};
      tr1.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasAddPropertyB */
    /* Details: "ActionResponse has a addProperty(String, */
    /* org.w3c.dom.Element) method " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYB);
    try {
      String name = "addProperty";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, org.w3c.dom.Element.class};
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasAddPropertyReturns */
    /* Details: "ActionResponse method addProperty(String, String) */
    /* returns void " */
    TestResult tr3 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYRETURNS);
    try {
      String name = "addProperty";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, String.class};
      tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasAddPropertyReturnsA */
    /* Details: "ActionResponse method */
    /* addProperty(javax.servlet.http.Cookie) returns void " */
    TestResult tr4 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYRETURNSA);
    try {
      String name = "addProperty";
      Class<?> retType = void.class;
      Class<?>[] parms = {javax.servlet.http.Cookie.class};
      tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasAddPropertyReturnsB */
    /* Details: "ActionResponse method addProperty(String, */
    /* org.w3c.dom.Element) returns void " */
    TestResult tr5 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYRETURNSB);
    try {
      String name = "addProperty";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, org.w3c.dom.Element.class};
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasCreateElement */
    /* Details: "ActionResponse has a createElement(String) throws */
    /* org.w3c.dom.DOMException method " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASCREATEELEMENT);
    try {
      String name = "createElement";
      Class<?>[] exceptions = {org.w3c.dom.DOMException.class};
      Class<?>[] parms = {String.class};
      tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasCreateElementReturns */
    /* Details: "ActionResponse method createElement(String) returns */
    /* org.w3c.dom.Element " */
    TestResult tr7 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASCREATEELEMENTRETURNS);
    try {
      String name = "createElement";
      Class<?> retType = org.w3c.dom.Element.class;
      Class<?>[] parms = {String.class};
      tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasEncodeURL */
    /* Details: "ActionResponse has a encodeURL(String)  method " */
    TestResult tr8 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASENCODEURL);
    try {
      String name = "encodeURL";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasEncodeURLReturns */
    /* Details: "ActionResponse method encodeURL(String) returns String " */
    TestResult tr9 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASENCODEURLRETURNS);
    try {
      String name = "encodeURL";
      Class<?> retType = String.class;
      Class<?>[] parms = {String.class};
      tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasGetNamespace */
    /* Details: "ActionResponse has a getNamespace()  method " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASGETNAMESPACE);
    try {
      String name = "getNamespace";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasGetNamespaceReturns */
    /* Details: "ActionResponse method getNamespace() returns String " */
    TestResult tr11 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASGETNAMESPACERETURNS);
    try {
      String name = "getNamespace";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasSetProperty */
    /* Details: "ActionResponse has a setProperty(String, String) method */
    /* " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASSETPROPERTY);
    try {
      String name = "setProperty";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, String.class};
      tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasSetPropertyReturns */
    /* Details: "ActionResponse method setProperty(String, String) */
    /* returns void " */
    TestResult tr13 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASSETPROPERTYRETURNS);
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
        Constants.RESULT_ATTR_PREFIX + "SigTestsAction_PortletResponse_SIGAction",
        writer.toString(), APPLICATION_SCOPE);
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    PortletSession ps = portletReq.getPortletSession();
    String msg =
        (String) ps.getAttribute(RESULT_ATTR_PREFIX + "SigTestsAction_PortletResponse_SIGAction",
            APPLICATION_SCOPE);
    if (msg != null) {
      writer.write("<p>" + msg + "</p><br/>\n");
      ps.removeAttribute(RESULT_ATTR_PREFIX + "SigTestsAction_PortletResponse_SIGAction",
          APPLICATION_SCOPE);
    }

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasAddProperty */
    /* Details: "ActionResponse has a addProperty(String, String) method */
    /* " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTY, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasAddPropertyA */
    /* Details: "ActionResponse has a */
    /* addProperty(javax.servlet.http.Cookie) method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYA, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasAddPropertyB */
    /* Details: "ActionResponse has a addProperty(String, */
    /* org.w3c.dom.Element) method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYB, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasAddPropertyReturns */
    /* Details: "ActionResponse method addProperty(String, String) */
    /* returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYRETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasAddPropertyReturnsA */
    /* Details: "ActionResponse method */
    /* addProperty(javax.servlet.http.Cookie) returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYRETURNSA, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasAddPropertyReturnsB */
    /* Details: "ActionResponse method addProperty(String, */
    /* org.w3c.dom.Element) returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYRETURNSB, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasCreateElement */
    /* Details: "ActionResponse has a createElement(String) throws */
    /* org.w3c.dom.DOMException method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASCREATEELEMENT, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasCreateElementReturns */
    /* Details: "ActionResponse method createElement(String) returns */
    /* org.w3c.dom.Element " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_PortletResponse_SIGAction_hasCreateElementReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasEncodeURL */
    /* Details: "ActionResponse has a encodeURL(String)  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASENCODEURL, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasEncodeURLReturns */
    /* Details: "ActionResponse method encodeURL(String) returns String " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASENCODEURLRETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasGetNamespace */
    /* Details: "ActionResponse has a getNamespace()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASGETNAMESPACE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasGetNamespaceReturns */
    /* Details: "ActionResponse method getNamespace() returns String " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASGETNAMESPACERETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasSetProperty */
    /* Details: "ActionResponse has a setProperty(String, String) method */
    /* " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASSETPROPERTY, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_PortletResponse_SIGAction_hasSetPropertyReturns */
    /* Details: "ActionResponse method setProperty(String, String) */
    /* returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASSETPROPERTYRETURNS, aurl);
      tb.writeTo(writer);
    }

  }

}
