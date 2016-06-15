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
import javax.portlet.PortalContext;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.WindowState;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDACTION_PHASE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDACTION_SCOPE_ID;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDBASIC_AUTH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDCCPP_PROFILE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDCLIENT_CERT_AUTH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDDIGEST_AUTH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDEVENT_PHASE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDFORM_AUTH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDLIFECYCLE_PHASE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_HEADERS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_MARKUP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_PART;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_PHASE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRESOURCE_PHASE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDUSER_INFO;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTENAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTENAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETAUTHTYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETAUTHTYPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCONTEXTPATH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCONTEXTPATHRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCOOKIES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCOOKIESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERMAPRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERNAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERVALUES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERVALUESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTALCONTEXT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTALCONTEXTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETMODERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSION;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSIONA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSIONRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSIONRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPREFERENCES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPREFERENCESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPRIVATEPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPRIVATEPARAMETERMAPRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTIES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTIESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTYNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTYNAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTYRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPUBLICPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPUBLICPARAMETERMAPRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREMOTEUSER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREMOTEUSERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREQUESTEDSESSIONID;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREQUESTEDSESSIONIDRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSCHEME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSCHEMERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERNAME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERNAMERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERPORT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERPORTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETUSERPRINCIPAL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETUSERPRINCIPALRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWID;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWIDRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWSTATE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWSTATERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISPORTLETMODEALLOWED;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISPORTLETMODEALLOWEDRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISREQUESTEDSESSIONIDVALID;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISREQUESTEDSESSIONIDVALIDRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISSECURE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISSECURERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISUSERINROLE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISUSERINROLERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISWINDOWSTATEALLOWED;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISWINDOWSTATEALLOWEDRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASREMOVEATTRIBUTE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASREMOVEATTRIBUTERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASSETATTRIBUTE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASSETATTRIBUTERETURNS;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.ResourceURL.PAGE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsResource_PortletRequest_SIGResource_event
 *
 */
public class SigTestsResource_PortletRequest_SIGResource
    implements Portlet, ResourceServingPortlet {

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
  public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();

    // Create result objects for the tests

    ClassChecker cc = new ClassChecker(portletReq.getClass());

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_fieldACTION_PHASE */
    /* Details: "ResourceRequest has String field ACTION_PHASE " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDACTION_PHASE);
    try {
      tr0.setTcSuccess(cc.hasField("ACTION_PHASE"));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_fieldACTION_SCOPE_ID */
    /* Details: "ResourceRequest has String field ACTION_SCOPE_ID " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDACTION_SCOPE_ID);
    try {
      tr1.setTcSuccess(cc.hasField("ACTION_SCOPE_ID"));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_fieldBASIC_AUTH */
    /* Details: "ResourceRequest has String field BASIC_AUTH " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDBASIC_AUTH);
    try {
      tr2.setTcSuccess(cc.hasField("BASIC_AUTH"));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_fieldCCPP_PROFILE */
    /* Details: "ResourceRequest has String field CCPP_PROFILE " */
    TestResult tr3 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDCCPP_PROFILE);
    try {
      tr3.setTcSuccess(cc.hasField("CCPP_PROFILE"));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_fieldCLIENT_CERT_AUTH */
    /* Details: "ResourceRequest has String field CLIENT_CERT_AUTH " */
    TestResult tr4 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDCLIENT_CERT_AUTH);
    try {
      tr4.setTcSuccess(cc.hasField("CLIENT_CERT_AUTH"));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_fieldDIGEST_AUTH */
    /* Details: "ResourceRequest has String field DIGEST_AUTH " */
    TestResult tr5 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDDIGEST_AUTH);
    try {
      tr5.setTcSuccess(cc.hasField("DIGEST_AUTH"));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_fieldEVENT_PHASE */
    /* Details: "ResourceRequest has String field EVENT_PHASE " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDEVENT_PHASE);
    try {
      tr6.setTcSuccess(cc.hasField("EVENT_PHASE"));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_fieldFORM_AUTH */
    /* Details: "ResourceRequest has String field FORM_AUTH " */
    TestResult tr7 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDFORM_AUTH);
    try {
      tr7.setTcSuccess(cc.hasField("FORM_AUTH"));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_fieldLIFECYCLE_PHASE */
    /* Details: "ResourceRequest has String field LIFECYCLE_PHASE " */
    TestResult tr8 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDLIFECYCLE_PHASE);
    try {
      tr8.setTcSuccess(cc.hasField("LIFECYCLE_PHASE"));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_fieldRENDER_HEADERS */
    /* Details: "ResourceRequest has String field RENDER_HEADERS " */
    TestResult tr9 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_HEADERS);
    try {
      tr9.setTcSuccess(cc.hasField("RENDER_HEADERS"));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_fieldRENDER_MARKUP */
    /* Details: "ResourceRequest has String field RENDER_MARKUP " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_MARKUP);
    try {
      tr10.setTcSuccess(cc.hasField("RENDER_MARKUP"));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_fieldRENDER_PART */
    /* Details: "ResourceRequest has String field RENDER_PART " */
    TestResult tr11 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_PART);
    try {
      tr11.setTcSuccess(cc.hasField("RENDER_PART"));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_fieldRENDER_PHASE */
    /* Details: "ResourceRequest has String field RENDER_PHASE " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_PHASE);
    try {
      tr12.setTcSuccess(cc.hasField("RENDER_PHASE"));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_fieldRESOURCE_PHASE */
    /* Details: "ResourceRequest has String field RESOURCE_PHASE " */
    TestResult tr13 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRESOURCE_PHASE);
    try {
      tr13.setTcSuccess(cc.hasField("RESOURCE_PHASE"));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_fieldUSER_INFO */
    /* Details: "ResourceRequest has String field USER_INFO " */
    TestResult tr14 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDUSER_INFO);
    try {
      tr14.setTcSuccess(cc.hasField("USER_INFO"));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetAttribute */
    /* Details: "ResourceRequest has a getAttribute(String)  method " */
    TestResult tr15 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTE);
    try {
      String name = "getAttribute";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr15.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetAttributeNames */
    /* Details: "ResourceRequest has a getAttributeNames()  method " */
    TestResult tr16 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTENAMES);
    try {
      String name = "getAttributeNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetAttributeNamesReturns */
    /* Details: "ResourceRequest method getAttributeNames() returns */
    /* java.util.Enumeration " */
    TestResult tr17 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTENAMESRETURNS);
    try {
      String name = "getAttributeNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetAttributeReturns */
    /* Details: "ResourceRequest method getAttribute(String) returns */
    /* Object " */
    TestResult tr18 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTERETURNS);
    try {
      String name = "getAttribute";
      Class<?> retType = Object.class;
      Class<?>[] parms = {String.class};
      tr18.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetAuthType */
    /* Details: "ResourceRequest has a getAuthType()  method " */
    TestResult tr19 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETAUTHTYPE);
    try {
      String name = "getAuthType";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr19.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetAuthTypeReturns */
    /* Details: "ResourceRequest method getAuthType() returns String " */
    TestResult tr20 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETAUTHTYPERETURNS);
    try {
      String name = "getAuthType";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr20.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr20.appendTcDetail(e.toString());
    }
    tr20.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetContextPath */
    /* Details: "ResourceRequest has a getContextPath()  method " */
    TestResult tr21 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCONTEXTPATH);
    try {
      String name = "getContextPath";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr21.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr21.appendTcDetail(e.toString());
    }
    tr21.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetContextPathReturns */
    /* Details: "ResourceRequest method getContextPath() returns String " */
    TestResult tr22 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCONTEXTPATHRETURNS);
    try {
      String name = "getContextPath";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr22.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr22.appendTcDetail(e.toString());
    }
    tr22.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetCookies */
    /* Details: "ResourceRequest has a getCookies()  method " */
    TestResult tr23 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCOOKIES);
    try {
      String name = "getCookies";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr23.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr23.appendTcDetail(e.toString());
    }
    tr23.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetCookiesReturns */
    /* Details: "ResourceRequest method getCookies() returns */
    /* javax.servlet.http.Cookie[] " */
    TestResult tr24 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCOOKIESRETURNS);
    try {
      String name = "getCookies";
      Class<?> retType = javax.servlet.http.Cookie[].class;
      Class<?>[] parms = null;
      tr24.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr24.appendTcDetail(e.toString());
    }
    tr24.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetLocale */
    /* Details: "ResourceRequest has a getLocale()  method " */
    TestResult tr25 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALE);
    try {
      String name = "getLocale";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr25.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr25.appendTcDetail(e.toString());
    }
    tr25.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetLocaleReturns */
    /* Details: "ResourceRequest method getLocale() returns */
    /* java.util.Locale " */
    TestResult tr26 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALERETURNS);
    try {
      String name = "getLocale";
      Class<?> retType = java.util.Locale.class;
      Class<?>[] parms = null;
      tr26.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr26.appendTcDetail(e.toString());
    }
    tr26.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetLocales */
    /* Details: "ResourceRequest has a getLocales()  method " */
    TestResult tr27 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALES);
    try {
      String name = "getLocales";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr27.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr27.appendTcDetail(e.toString());
    }
    tr27.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetLocalesReturns */
    /* Details: "ResourceRequest method getLocales() returns */
    /* java.util.Enumeration " */
    TestResult tr28 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALESRETURNS);
    try {
      String name = "getLocales";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr28.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr28.appendTcDetail(e.toString());
    }
    tr28.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetParameter */
    /* Details: "ResourceRequest has a getParameter(String)  method " */
    TestResult tr29 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETER);
    try {
      String name = "getParameter";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr29.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr29.appendTcDetail(e.toString());
    }
    tr29.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetParameterMap */
    /* Details: "ResourceRequest has a getParameterMap()  method " */
    TestResult tr30 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERMAP);
    try {
      String name = "getParameterMap";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr30.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr30.appendTcDetail(e.toString());
    }
    tr30.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetParameterMapReturns */
    /* Details: "ResourceRequest method getParameterMap() returns */
    /* java.util.Map " */
    TestResult tr31 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERMAPRETURNS);
    try {
      String name = "getParameterMap";
      Class<?> retType = java.util.Map.class;
      Class<?>[] parms = null;
      tr31.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr31.appendTcDetail(e.toString());
    }
    tr31.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetParameterNames */
    /* Details: "ResourceRequest has a getParameterNames()  method " */
    TestResult tr32 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERNAMES);
    try {
      String name = "getParameterNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr32.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr32.appendTcDetail(e.toString());
    }
    tr32.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetParameterNamesReturns */
    /* Details: "ResourceRequest method getParameterNames() returns */
    /* java.util.Enumeration " */
    TestResult tr33 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERNAMESRETURNS);
    try {
      String name = "getParameterNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr33.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr33.appendTcDetail(e.toString());
    }
    tr33.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetParameterReturns */
    /* Details: "ResourceRequest method getParameter(String) returns */
    /* String " */
    TestResult tr34 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERRETURNS);
    try {
      String name = "getParameter";
      Class<?> retType = String.class;
      Class<?>[] parms = {String.class};
      tr34.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr34.appendTcDetail(e.toString());
    }
    tr34.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetParameterValues */
    /* Details: "ResourceRequest has a getParameterValues(String) method */
    /* " */
    TestResult tr35 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERVALUES);
    try {
      String name = "getParameterValues";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr35.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr35.appendTcDetail(e.toString());
    }
    tr35.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetParameterValuesReturns */
    /* Details: "ResourceRequest method getParameterValues(String) */
    /* returns String[] " */
    TestResult tr36 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERVALUESRETURNS);
    try {
      String name = "getParameterValues";
      Class<?> retType = String[].class;
      Class<?>[] parms = {String.class};
      tr36.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr36.appendTcDetail(e.toString());
    }
    tr36.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPortalContext */
    /* Details: "ResourceRequest has a getPortalContext()  method " */
    TestResult tr37 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTALCONTEXT);
    try {
      String name = "getPortalContext";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr37.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr37.appendTcDetail(e.toString());
    }
    tr37.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPortalContextReturns */
    /* Details: "ResourceRequest method getPortalContext() returns */
    /* PortalContext " */
    TestResult tr38 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTALCONTEXTRETURNS);
    try {
      String name = "getPortalContext";
      Class<?> retType = PortalContext.class;
      Class<?>[] parms = null;
      tr38.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr38.appendTcDetail(e.toString());
    }
    tr38.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPortletMode */
    /* Details: "ResourceRequest has a getPortletMode()  method " */
    TestResult tr39 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETMODE);
    try {
      String name = "getPortletMode";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr39.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr39.appendTcDetail(e.toString());
    }
    tr39.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPortletModeReturns */
    /* Details: "ResourceRequest method getPortletMode() returns */
    /* PortletMode " */
    TestResult tr40 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETMODERETURNS);
    try {
      String name = "getPortletMode";
      Class<?> retType = PortletMode.class;
      Class<?>[] parms = null;
      tr40.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr40.appendTcDetail(e.toString());
    }
    tr40.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPortletSession */
    /* Details: "ResourceRequest has a getPortletSession()  method " */
    TestResult tr41 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSION);
    try {
      String name = "getPortletSession";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr41.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr41.appendTcDetail(e.toString());
    }
    tr41.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPortletSessionA */
    /* Details: "ResourceRequest has a getPortletSession(boolean) method */
    /* " */
    TestResult tr42 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSIONA);
    try {
      String name = "getPortletSession";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {boolean.class};
      tr42.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr42.appendTcDetail(e.toString());
    }
    tr42.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPortletSessionReturns */
    /* Details: "ResourceRequest method getPortletSession() returns */
    /* PortletSession " */
    TestResult tr43 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSIONRETURNS);
    try {
      String name = "getPortletSession";
      Class<?> retType = PortletSession.class;
      Class<?>[] parms = null;
      tr43.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr43.appendTcDetail(e.toString());
    }
    tr43.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPortletSessionReturnsA */
    /* Details: "ResourceRequest method getPortletSession(boolean) */
    /* returns PortletSession " */
    TestResult tr44 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSIONRETURNSA);
    try {
      String name = "getPortletSession";
      Class<?> retType = PortletSession.class;
      Class<?>[] parms = {boolean.class};
      tr44.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr44.appendTcDetail(e.toString());
    }
    tr44.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPreferences */
    /* Details: "ResourceRequest has a getPreferences()  method " */
    TestResult tr45 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPREFERENCES);
    try {
      String name = "getPreferences";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr45.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr45.appendTcDetail(e.toString());
    }
    tr45.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPreferencesReturns */
    /* Details: "ResourceRequest method getPreferences() returns */
    /* PortletPreferences " */
    TestResult tr46 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPREFERENCESRETURNS);
    try {
      String name = "getPreferences";
      Class<?> retType = PortletPreferences.class;
      Class<?>[] parms = null;
      tr46.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr46.appendTcDetail(e.toString());
    }
    tr46.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPrivateParameterMap */
    /* Details: "ResourceRequest has a getPrivateParameterMap()  method " */
    TestResult tr47 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPRIVATEPARAMETERMAP);
    try {
      String name = "getPrivateParameterMap";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr47.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr47.appendTcDetail(e.toString());
    }
    tr47.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPrivateParameterMapReturns */
    /* Details: "ResourceRequest method getPrivateParameterMap() returns */
    /* java.util.Map " */
    TestResult tr48 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPRIVATEPARAMETERMAPRETURNS);
    try {
      String name = "getPrivateParameterMap";
      Class<?> retType = java.util.Map.class;
      Class<?>[] parms = null;
      tr48.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr48.appendTcDetail(e.toString());
    }
    tr48.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetProperties */
    /* Details: "ResourceRequest has a getProperties(String)  method " */
    TestResult tr49 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTIES);
    try {
      String name = "getProperties";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr49.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr49.appendTcDetail(e.toString());
    }
    tr49.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPropertiesReturns */
    /* Details: "ResourceRequest method getProperties(String) returns */
    /* java.util.Enumeration " */
    TestResult tr50 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTIESRETURNS);
    try {
      String name = "getProperties";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = {String.class};
      tr50.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr50.appendTcDetail(e.toString());
    }
    tr50.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetProperty */
    /* Details: "ResourceRequest has a getProperty(String)  method " */
    TestResult tr51 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTY);
    try {
      String name = "getProperty";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr51.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr51.appendTcDetail(e.toString());
    }
    tr51.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPropertyNames */
    /* Details: "ResourceRequest has a getPropertyNames()  method " */
    TestResult tr52 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTYNAMES);
    try {
      String name = "getPropertyNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr52.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr52.appendTcDetail(e.toString());
    }
    tr52.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPropertyNamesReturns */
    /* Details: "ResourceRequest method getPropertyNames() returns */
    /* java.util.Enumeration " */
    TestResult tr53 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTYNAMESRETURNS);
    try {
      String name = "getPropertyNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr53.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr53.appendTcDetail(e.toString());
    }
    tr53.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPropertyReturns */
    /* Details: "ResourceRequest method getProperty(String) returns */
    /* String " */
    TestResult tr54 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTYRETURNS);
    try {
      String name = "getProperty";
      Class<?> retType = String.class;
      Class<?>[] parms = {String.class};
      tr54.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr54.appendTcDetail(e.toString());
    }
    tr54.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPublicParameterMap */
    /* Details: "ResourceRequest has a getPublicParameterMap()  method " */
    TestResult tr55 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPUBLICPARAMETERMAP);
    try {
      String name = "getPublicParameterMap";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr55.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr55.appendTcDetail(e.toString());
    }
    tr55.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetPublicParameterMapReturns */
    /* Details: "ResourceRequest method getPublicParameterMap() returns */
    /* java.util.Map " */
    TestResult tr56 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPUBLICPARAMETERMAPRETURNS);
    try {
      String name = "getPublicParameterMap";
      Class<?> retType = java.util.Map.class;
      Class<?>[] parms = null;
      tr56.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr56.appendTcDetail(e.toString());
    }
    tr56.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetRemoteUser */
    /* Details: "ResourceRequest has a getRemoteUser()  method " */
    TestResult tr57 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREMOTEUSER);
    try {
      String name = "getRemoteUser";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr57.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr57.appendTcDetail(e.toString());
    }
    tr57.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetRemoteUserReturns */
    /* Details: "ResourceRequest method getRemoteUser() returns String " */
    TestResult tr58 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREMOTEUSERRETURNS);
    try {
      String name = "getRemoteUser";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr58.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr58.appendTcDetail(e.toString());
    }
    tr58.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetRequestedSessionId */
    /* Details: "ResourceRequest has a getRequestedSessionId()  method " */
    TestResult tr59 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREQUESTEDSESSIONID);
    try {
      String name = "getRequestedSessionId";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr59.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr59.appendTcDetail(e.toString());
    }
    tr59.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetRequestedSessionIdReturns */
    /* Details: "ResourceRequest method getRequestedSessionId() returns */
    /* String " */
    TestResult tr60 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREQUESTEDSESSIONIDRETURNS);
    try {
      String name = "getRequestedSessionId";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr60.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr60.appendTcDetail(e.toString());
    }
    tr60.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetResponseContentType */
    /* Details: "ResourceRequest has a getResponseContentType()  method " */
    TestResult tr61 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPE);
    try {
      String name = "getResponseContentType";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr61.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr61.appendTcDetail(e.toString());
    }
    tr61.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetResponseContentTypeReturns */
    /* Details: "ResourceRequest method getResponseContentType() returns */
    /* String " */
    TestResult tr62 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPERETURNS);
    try {
      String name = "getResponseContentType";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr62.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr62.appendTcDetail(e.toString());
    }
    tr62.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetResponseContentTypes */
    /* Details: "ResourceRequest has a getResponseContentTypes() method */
    /* " */
    TestResult tr63 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPES);
    try {
      String name = "getResponseContentTypes";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr63.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr63.appendTcDetail(e.toString());
    }
    tr63.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetResponseContentTypesReturns */
    /* Details: "ResourceRequest method getResponseContentTypes() returns */
    /* java.util.Enumeration " */
    TestResult tr64 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPESRETURNS);
    try {
      String name = "getResponseContentTypes";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr64.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr64.appendTcDetail(e.toString());
    }
    tr64.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetScheme */
    /* Details: "ResourceRequest has a getScheme()  method " */
    TestResult tr65 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSCHEME);
    try {
      String name = "getScheme";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr65.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr65.appendTcDetail(e.toString());
    }
    tr65.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetSchemeReturns */
    /* Details: "ResourceRequest method getScheme() returns String " */
    TestResult tr66 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSCHEMERETURNS);
    try {
      String name = "getScheme";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr66.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr66.appendTcDetail(e.toString());
    }
    tr66.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetServerName */
    /* Details: "ResourceRequest has a getServerName()  method " */
    TestResult tr67 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERNAME);
    try {
      String name = "getServerName";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr67.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr67.appendTcDetail(e.toString());
    }
    tr67.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetServerNameReturns */
    /* Details: "ResourceRequest method getServerName() returns String " */
    TestResult tr68 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERNAMERETURNS);
    try {
      String name = "getServerName";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr68.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr68.appendTcDetail(e.toString());
    }
    tr68.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetServerPort */
    /* Details: "ResourceRequest has a getServerPort()  method " */
    TestResult tr69 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERPORT);
    try {
      String name = "getServerPort";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr69.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr69.appendTcDetail(e.toString());
    }
    tr69.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetServerPortReturns */
    /* Details: "ResourceRequest method getServerPort() returns int " */
    TestResult tr70 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERPORTRETURNS);
    try {
      String name = "getServerPort";
      Class<?> retType = int.class;
      Class<?>[] parms = null;
      tr70.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr70.appendTcDetail(e.toString());
    }
    tr70.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetUserPrincipal */
    /* Details: "ResourceRequest has a getUserPrincipal()  method " */
    TestResult tr71 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETUSERPRINCIPAL);
    try {
      String name = "getUserPrincipal";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr71.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr71.appendTcDetail(e.toString());
    }
    tr71.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetUserPrincipalReturns */
    /* Details: "ResourceRequest method getUserPrincipal() returns */
    /* java.security.Principal " */
    TestResult tr72 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETUSERPRINCIPALRETURNS);
    try {
      String name = "getUserPrincipal";
      Class<?> retType = java.security.Principal.class;
      Class<?>[] parms = null;
      tr72.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr72.appendTcDetail(e.toString());
    }
    tr72.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetWindowID */
    /* Details: "ResourceRequest has a getWindowID()  method " */
    TestResult tr73 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWID);
    try {
      String name = "getWindowID";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr73.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr73.appendTcDetail(e.toString());
    }
    tr73.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetWindowIDReturns */
    /* Details: "ResourceRequest method getWindowID() returns String " */
    TestResult tr74 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWIDRETURNS);
    try {
      String name = "getWindowID";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr74.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr74.appendTcDetail(e.toString());
    }
    tr74.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetWindowState */
    /* Details: "ResourceRequest has a getWindowState()  method " */
    TestResult tr75 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWSTATE);
    try {
      String name = "getWindowState";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr75.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr75.appendTcDetail(e.toString());
    }
    tr75.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasGetWindowStateReturns */
    /* Details: "ResourceRequest method getWindowState() returns */
    /* WindowState " */
    TestResult tr76 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWSTATERETURNS);
    try {
      String name = "getWindowState";
      Class<?> retType = WindowState.class;
      Class<?>[] parms = null;
      tr76.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr76.appendTcDetail(e.toString());
    }
    tr76.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasIsPortletModeAllowed */
    /* Details: "ResourceRequest has a isPortletModeAllowed(PortletMode) */
    /* method " */
    TestResult tr77 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISPORTLETMODEALLOWED);
    try {
      String name = "isPortletModeAllowed";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {PortletMode.class};
      tr77.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr77.appendTcDetail(e.toString());
    }
    tr77.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasIsPortletModeAllowedReturns */
    /* Details: "ResourceRequest method isPortletModeAllowed(PortletMode) */
    /* returns boolean " */
    TestResult tr78 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISPORTLETMODEALLOWEDRETURNS);
    try {
      String name = "isPortletModeAllowed";
      Class<?> retType = boolean.class;
      Class<?>[] parms = {PortletMode.class};
      tr78.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr78.appendTcDetail(e.toString());
    }
    tr78.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasIsRequestedSessionIdValid */
    /* Details: "ResourceRequest has a isRequestedSessionIdValid() */
    /* method " */
    TestResult tr79 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISREQUESTEDSESSIONIDVALID);
    try {
      String name = "isRequestedSessionIdValid";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr79.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr79.appendTcDetail(e.toString());
    }
    tr79.writeTo(writer);

    /*
     * TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasIsRequestedSessionIdValidReturns
     */
    /* Details: "ResourceRequest method isRequestedSessionIdValid() */
    /* returns boolean " */
    TestResult tr80 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISREQUESTEDSESSIONIDVALIDRETURNS);
    try {
      String name = "isRequestedSessionIdValid";
      Class<?> retType = boolean.class;
      Class<?>[] parms = null;
      tr80.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr80.appendTcDetail(e.toString());
    }
    tr80.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasIsSecure */
    /* Details: "ResourceRequest has a isSecure()  method " */
    TestResult tr81 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISSECURE);
    try {
      String name = "isSecure";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr81.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr81.appendTcDetail(e.toString());
    }
    tr81.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasIsSecureReturns */
    /* Details: "ResourceRequest method isSecure() returns boolean " */
    TestResult tr82 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISSECURERETURNS);
    try {
      String name = "isSecure";
      Class<?> retType = boolean.class;
      Class<?>[] parms = null;
      tr82.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr82.appendTcDetail(e.toString());
    }
    tr82.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasIsUserInRole */
    /* Details: "ResourceRequest has a isUserInRole(String)  method " */
    TestResult tr83 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISUSERINROLE);
    try {
      String name = "isUserInRole";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr83.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr83.appendTcDetail(e.toString());
    }
    tr83.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasIsUserInRoleReturns */
    /* Details: "ResourceRequest method isUserInRole(String) returns */
    /* boolean " */
    TestResult tr84 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISUSERINROLERETURNS);
    try {
      String name = "isUserInRole";
      Class<?> retType = boolean.class;
      Class<?>[] parms = {String.class};
      tr84.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr84.appendTcDetail(e.toString());
    }
    tr84.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasIsWindowStateAllowed */
    /* Details: "ResourceRequest has a isWindowStateAllowed(WindowState) */
    /* method " */
    TestResult tr85 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISWINDOWSTATEALLOWED);
    try {
      String name = "isWindowStateAllowed";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {WindowState.class};
      tr85.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr85.appendTcDetail(e.toString());
    }
    tr85.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasIsWindowStateAllowedReturns */
    /* Details: "ResourceRequest method isWindowStateAllowed(WindowState) */
    /* returns boolean " */
    TestResult tr86 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISWINDOWSTATEALLOWEDRETURNS);
    try {
      String name = "isWindowStateAllowed";
      Class<?> retType = boolean.class;
      Class<?>[] parms = {WindowState.class};
      tr86.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr86.appendTcDetail(e.toString());
    }
    tr86.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasRemoveAttribute */
    /* Details: "ResourceRequest has a removeAttribute(String)  method " */
    TestResult tr87 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASREMOVEATTRIBUTE);
    try {
      String name = "removeAttribute";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr87.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr87.appendTcDetail(e.toString());
    }
    tr87.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasRemoveAttributeReturns */
    /* Details: "ResourceRequest method removeAttribute(String) returns */
    /* void " */
    TestResult tr88 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASREMOVEATTRIBUTERETURNS);
    try {
      String name = "removeAttribute";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr88.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr88.appendTcDetail(e.toString());
    }
    tr88.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasSetAttribute */
    /* Details: "ResourceRequest has a setAttribute(String, Object) */
    /* method " */
    TestResult tr89 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASSETATTRIBUTE);
    try {
      String name = "setAttribute";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, Object.class};
      tr89.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr89.appendTcDetail(e.toString());
    }
    tr89.writeTo(writer);

    /* TestCase: V2SigTestsResource_PortletRequest_SIGResource_hasSetAttributeReturns */
    /* Details: "ResourceRequest method setAttribute(String, Object) */
    /* returns void " */
    TestResult tr90 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASSETATTRIBUTERETURNS);
    try {
      String name = "setAttribute";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, Object.class};
      tr90.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr90.appendTcDetail(e.toString());
    }
    tr90.writeTo(writer);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    writer.write(
        "<div id=\"SigTestsResource_PortletRequest_SIGResource\">no resource output.</div>\n");
    ResourceURL resurl = portletResp.createResourceURL();
    resurl.setCacheability(PAGE);
    writer.write("<script>\n");
    writer.write("(function () {\n");
    writer.write("   var xhr = new XMLHttpRequest();\n");
    writer.write("   xhr.onreadystatechange=function() {\n");
    writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
    writer.write(
        "         document.getElementById(\"SigTestsResource_PortletRequest_SIGResource\").innerHTML=xhr.responseText;\n");
    writer.write("      }\n");
    writer.write("   };\n");
    writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
    writer.write("   xhr.send();\n");
    writer.write("})();\n");
    writer.write("</script>\n");
  }

}
