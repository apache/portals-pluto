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
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_FRACTIONSECOND;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_HMS_HOUR;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_HMS_MINUTE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_HMS_SECOND;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_TIMEZONE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_YMD_DAY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_YMD_MONTH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_YMD_YEAR;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_ONLINE_EMAIL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_ONLINE_URI;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_CITY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_COUNTRY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_NAME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_ORGANIZATION;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_POSTALCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_STATEPROV;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_STREET;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_COMMENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_EXT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_INTCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_LOCCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_NUMBER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_COMMENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_EXT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_INTCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_LOCCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_NUMBER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_COMMENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_EXT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_INTCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_LOCCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_NUMBER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_COMMENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_EXT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_INTCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_LOCCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_NUMBER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_DEPARTMENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_EMPLOYER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_GENDER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_ONLINE_EMAIL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_ONLINE_URI;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_CITY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_COUNTRY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_NAME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_ORGANIZATION;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_POSTALCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_STATEPROV;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_STREET;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_COMMENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_EXT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_INTCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_LOCCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_NUMBER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_COMMENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_EXT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_INTCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_LOCCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_NUMBER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_COMMENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_EXT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_INTCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_LOCCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_NUMBER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_COMMENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_EXT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_INTCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_LOCCODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_NUMBER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_JOBTITLE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_LOGIN_ID;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_FAMILY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_GIVEN;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_MIDDLE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_NICKNAME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_PREFIX;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_SUFFIX;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASTOSTRING;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASTOSTRINGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUEOF;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUEOFRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_ISENUM;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_event
 *
 */
public class SigTestsRender_PortletRequest$P3PUserInfos_SIGRender implements Portlet {

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

    ClassChecker cc = new ClassChecker(PortletRequest.P3PUserInfos.class);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_FRACTIONSECOND
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_BDATE_FRACTIONSECOND " */
    TestResult tr0 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_FRACTIONSECOND);
    try {
      tr0.setTcSuccess(cc.hasField("USER_BDATE_FRACTIONSECOND"));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_HMS_HOUR */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_BDATE_HMS_HOUR " */
    TestResult tr1 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_HMS_HOUR);
    try {
      tr1.setTcSuccess(cc.hasField("USER_BDATE_HMS_HOUR"));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /*
     * TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_HMS_MINUTE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_BDATE_HMS_MINUTE " */
    TestResult tr2 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_HMS_MINUTE);
    try {
      tr2.setTcSuccess(cc.hasField("USER_BDATE_HMS_MINUTE"));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /*
     * TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_HMS_SECOND
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_BDATE_HMS_SECOND " */
    TestResult tr3 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_HMS_SECOND);
    try {
      tr3.setTcSuccess(cc.hasField("USER_BDATE_HMS_SECOND"));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_TIMEZONE */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_BDATE_TIMEZONE " */
    TestResult tr4 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_TIMEZONE);
    try {
      tr4.setTcSuccess(cc.hasField("USER_BDATE_TIMEZONE"));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_YMD_DAY */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_BDATE_YMD_DAY " */
    TestResult tr5 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_YMD_DAY);
    try {
      tr5.setTcSuccess(cc.hasField("USER_BDATE_YMD_DAY"));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_YMD_MONTH */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_BDATE_YMD_MONTH " */
    TestResult tr6 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_YMD_MONTH);
    try {
      tr6.setTcSuccess(cc.hasField("USER_BDATE_YMD_MONTH"));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_YMD_YEAR */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_BDATE_YMD_YEAR " */
    TestResult tr7 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_YMD_YEAR);
    try {
      tr7.setTcSuccess(cc.hasField("USER_BDATE_YMD_YEAR"));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_ONLINE_EMAIL
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_BUSINESSINFO_ONLINE_EMAIL " */
    TestResult tr8 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_ONLINE_EMAIL);
    try {
      tr8.setTcSuccess(cc.hasField("USER_BUSINESSINFO_ONLINE_EMAIL"));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_ONLINE_URI
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_BUSINESSINFO_ONLINE_URI " */
    TestResult tr9 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_ONLINE_URI);
    try {
      tr9.setTcSuccess(cc.hasField("USER_BUSINESSINFO_ONLINE_URI"));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_POSTAL_CITY
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_CITY " */
    TestResult tr10 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_CITY);
    try {
      tr10.setTcSuccess(cc.hasField("USER_BUSINESSINFO_POSTAL_CITY"));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_POSTAL_COUNTRY
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_COUNTRY */
    /* " */
    TestResult tr11 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_COUNTRY);
    try {
      tr11.setTcSuccess(cc.hasField("USER_BUSINESSINFO_POSTAL_COUNTRY"));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_POSTAL_NAME
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_NAME " */
    TestResult tr12 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_NAME);
    try {
      tr12.setTcSuccess(cc.hasField("USER_BUSINESSINFO_POSTAL_NAME"));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_POSTAL_ORGANIZATION
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_POSTAL_ORGANIZATION " */
    TestResult tr13 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_ORGANIZATION);
    try {
      tr13.setTcSuccess(cc.hasField("USER_BUSINESSINFO_POSTAL_ORGANIZATION"));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_POSTAL_POSTALCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_POSTAL_POSTALCODE " */
    TestResult tr14 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_POSTALCODE);
    try {
      tr14.setTcSuccess(cc.hasField("USER_BUSINESSINFO_POSTAL_POSTALCODE"));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_POSTAL_STATEPROV
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_POSTAL_STATEPROV " */
    TestResult tr15 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_STATEPROV);
    try {
      tr15.setTcSuccess(cc.hasField("USER_BUSINESSINFO_POSTAL_STATEPROV"));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_POSTAL_STREET
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_STREET */
    /* " */
    TestResult tr16 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_STREET);
    try {
      tr16.setTcSuccess(cc.hasField("USER_BUSINESSINFO_POSTAL_STREET"));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_FAX_COMMENT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_FAX_COMMENT " */
    TestResult tr17 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_COMMENT);
    try {
      tr17.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_FAX_COMMENT"));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_FAX_EXT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_FAX_EXT " */
    TestResult tr18 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_EXT);
    try {
      tr18.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_FAX_EXT"));
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_FAX_INTCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_FAX_INTCODE " */
    TestResult tr19 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_INTCODE);
    try {
      tr19.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_FAX_INTCODE"));
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_FAX_LOCCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_FAX_LOCCODE " */
    TestResult tr20 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_LOCCODE);
    try {
      tr20.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_FAX_LOCCODE"));
    } catch (Exception e) {
      tr20.appendTcDetail(e.toString());
    }
    tr20.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_FAX_NUMBER
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_FAX_NUMBER " */
    TestResult tr21 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_NUMBER);
    try {
      tr21.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_FAX_NUMBER"));
    } catch (Exception e) {
      tr21.appendTcDetail(e.toString());
    }
    tr21.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_MOBILE_COMMENT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_MOBILE_COMMENT " */
    TestResult tr22 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_COMMENT);
    try {
      tr22.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_MOBILE_COMMENT"));
    } catch (Exception e) {
      tr22.appendTcDetail(e.toString());
    }
    tr22.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_MOBILE_EXT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_MOBILE_EXT " */
    TestResult tr23 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_EXT);
    try {
      tr23.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_MOBILE_EXT"));
    } catch (Exception e) {
      tr23.appendTcDetail(e.toString());
    }
    tr23.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_MOBILE_INTCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_MOBILE_INTCODE " */
    TestResult tr24 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_INTCODE);
    try {
      tr24.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_MOBILE_INTCODE"));
    } catch (Exception e) {
      tr24.appendTcDetail(e.toString());
    }
    tr24.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_MOBILE_LOCCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_MOBILE_LOCCODE " */
    TestResult tr25 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_LOCCODE);
    try {
      tr25.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_MOBILE_LOCCODE"));
    } catch (Exception e) {
      tr25.appendTcDetail(e.toString());
    }
    tr25.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_MOBILE_NUMBER
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_MOBILE_NUMBER " */
    TestResult tr26 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_NUMBER);
    try {
      tr26.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_MOBILE_NUMBER"));
    } catch (Exception e) {
      tr26.appendTcDetail(e.toString());
    }
    tr26.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_PAGER_COMMENT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_PAGER_COMMENT " */
    TestResult tr27 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_COMMENT);
    try {
      tr27.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_PAGER_COMMENT"));
    } catch (Exception e) {
      tr27.appendTcDetail(e.toString());
    }
    tr27.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_PAGER_EXT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_PAGER_EXT " */
    TestResult tr28 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_EXT);
    try {
      tr28.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_PAGER_EXT"));
    } catch (Exception e) {
      tr28.appendTcDetail(e.toString());
    }
    tr28.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_PAGER_INTCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_PAGER_INTCODE " */
    TestResult tr29 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_INTCODE);
    try {
      tr29.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_PAGER_INTCODE"));
    } catch (Exception e) {
      tr29.appendTcDetail(e.toString());
    }
    tr29.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_PAGER_LOCCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_PAGER_LOCCODE " */
    TestResult tr30 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_LOCCODE);
    try {
      tr30.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_PAGER_LOCCODE"));
    } catch (Exception e) {
      tr30.appendTcDetail(e.toString());
    }
    tr30.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_PAGER_NUMBER
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_PAGER_NUMBER " */
    TestResult tr31 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_NUMBER);
    try {
      tr31.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_PAGER_NUMBER"));
    } catch (Exception e) {
      tr31.appendTcDetail(e.toString());
    }
    tr31.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_TELEPHONE_COMMENT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_TELEPHONE_COMMENT " */
    TestResult tr32 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_COMMENT);
    try {
      tr32.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_TELEPHONE_COMMENT"));
    } catch (Exception e) {
      tr32.appendTcDetail(e.toString());
    }
    tr32.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_TELEPHONE_EXT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_TELEPHONE_EXT " */
    TestResult tr33 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_EXT);
    try {
      tr33.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_TELEPHONE_EXT"));
    } catch (Exception e) {
      tr33.appendTcDetail(e.toString());
    }
    tr33.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_TELEPHONE_INTCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_TELEPHONE_INTCODE " */
    TestResult tr34 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_INTCODE);
    try {
      tr34.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_TELEPHONE_INTCODE"));
    } catch (Exception e) {
      tr34.appendTcDetail(e.toString());
    }
    tr34.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_TELEPHONE_LOCCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_TELEPHONE_LOCCODE " */
    TestResult tr35 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_LOCCODE);
    try {
      tr35.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_TELEPHONE_LOCCODE"));
    } catch (Exception e) {
      tr35.appendTcDetail(e.toString());
    }
    tr35.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_TELEPHONE_NUMBER
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_BUSINESSINFO_TELECOM_TELEPHONE_NUMBER " */
    TestResult tr36 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_NUMBER);
    try {
      tr36.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_TELEPHONE_NUMBER"));
    } catch (Exception e) {
      tr36.appendTcDetail(e.toString());
    }
    tr36.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_DEPARTMENT */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_DEPARTMENT " */
    TestResult tr37 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_DEPARTMENT);
    try {
      tr37.setTcSuccess(cc.hasField("USER_DEPARTMENT"));
    } catch (Exception e) {
      tr37.appendTcDetail(e.toString());
    }
    tr37.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_EMPLOYER */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_EMPLOYER " */
    TestResult tr38 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_EMPLOYER);
    try {
      tr38.setTcSuccess(cc.hasField("USER_EMPLOYER"));
    } catch (Exception e) {
      tr38.appendTcDetail(e.toString());
    }
    tr38.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_GENDER */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_GENDER " */
    TestResult tr39 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_GENDER);
    try {
      tr39.setTcSuccess(cc.hasField("USER_GENDER"));
    } catch (Exception e) {
      tr39.appendTcDetail(e.toString());
    }
    tr39.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_ONLINE_EMAIL
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_HOMEINFO_ONLINE_EMAIL " */
    TestResult tr40 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_ONLINE_EMAIL);
    try {
      tr40.setTcSuccess(cc.hasField("USER_HOMEINFO_ONLINE_EMAIL"));
    } catch (Exception e) {
      tr40.appendTcDetail(e.toString());
    }
    tr40.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_ONLINE_URI
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_HOMEINFO_ONLINE_URI " */
    TestResult tr41 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_ONLINE_URI);
    try {
      tr41.setTcSuccess(cc.hasField("USER_HOMEINFO_ONLINE_URI"));
    } catch (Exception e) {
      tr41.appendTcDetail(e.toString());
    }
    tr41.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_POSTAL_CITY
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_CITY " */
    TestResult tr42 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_CITY);
    try {
      tr42.setTcSuccess(cc.hasField("USER_HOMEINFO_POSTAL_CITY"));
    } catch (Exception e) {
      tr42.appendTcDetail(e.toString());
    }
    tr42.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_POSTAL_COUNTRY
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_COUNTRY " */
    TestResult tr43 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_COUNTRY);
    try {
      tr43.setTcSuccess(cc.hasField("USER_HOMEINFO_POSTAL_COUNTRY"));
    } catch (Exception e) {
      tr43.appendTcDetail(e.toString());
    }
    tr43.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_POSTAL_NAME
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_NAME " */
    TestResult tr44 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_NAME);
    try {
      tr44.setTcSuccess(cc.hasField("USER_HOMEINFO_POSTAL_NAME"));
    } catch (Exception e) {
      tr44.appendTcDetail(e.toString());
    }
    tr44.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_POSTAL_ORGANIZATION
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_POSTAL_ORGANIZATION " */
    TestResult tr45 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_ORGANIZATION);
    try {
      tr45.setTcSuccess(cc.hasField("USER_HOMEINFO_POSTAL_ORGANIZATION"));
    } catch (Exception e) {
      tr45.appendTcDetail(e.toString());
    }
    tr45.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_POSTAL_POSTALCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_POSTALCODE */
    /* " */
    TestResult tr46 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_POSTALCODE);
    try {
      tr46.setTcSuccess(cc.hasField("USER_HOMEINFO_POSTAL_POSTALCODE"));
    } catch (Exception e) {
      tr46.appendTcDetail(e.toString());
    }
    tr46.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_POSTAL_STATEPROV
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_STATEPROV " */
    TestResult tr47 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_STATEPROV);
    try {
      tr47.setTcSuccess(cc.hasField("USER_HOMEINFO_POSTAL_STATEPROV"));
    } catch (Exception e) {
      tr47.appendTcDetail(e.toString());
    }
    tr47.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_POSTAL_STREET
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_STREET " */
    TestResult tr48 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_STREET);
    try {
      tr48.setTcSuccess(cc.hasField("USER_HOMEINFO_POSTAL_STREET"));
    } catch (Exception e) {
      tr48.appendTcDetail(e.toString());
    }
    tr48.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_FAX_COMMENT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_FAX_COMMENT " */
    TestResult tr49 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_COMMENT);
    try {
      tr49.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_FAX_COMMENT"));
    } catch (Exception e) {
      tr49.appendTcDetail(e.toString());
    }
    tr49.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_FAX_EXT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_FAX_EXT " */
    TestResult tr50 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_EXT);
    try {
      tr50.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_FAX_EXT"));
    } catch (Exception e) {
      tr50.appendTcDetail(e.toString());
    }
    tr50.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_FAX_INTCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_FAX_INTCODE " */
    TestResult tr51 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_INTCODE);
    try {
      tr51.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_FAX_INTCODE"));
    } catch (Exception e) {
      tr51.appendTcDetail(e.toString());
    }
    tr51.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_FAX_LOCCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_FAX_LOCCODE " */
    TestResult tr52 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_LOCCODE);
    try {
      tr52.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_FAX_LOCCODE"));
    } catch (Exception e) {
      tr52.appendTcDetail(e.toString());
    }
    tr52.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_FAX_NUMBER
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_FAX_NUMBER */
    /* " */
    TestResult tr53 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_NUMBER);
    try {
      tr53.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_FAX_NUMBER"));
    } catch (Exception e) {
      tr53.appendTcDetail(e.toString());
    }
    tr53.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_MOBILE_COMMENT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_MOBILE_COMMENT " */
    TestResult tr54 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_COMMENT);
    try {
      tr54.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_MOBILE_COMMENT"));
    } catch (Exception e) {
      tr54.appendTcDetail(e.toString());
    }
    tr54.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_MOBILE_EXT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_MOBILE_EXT */
    /* " */
    TestResult tr55 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_EXT);
    try {
      tr55.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_MOBILE_EXT"));
    } catch (Exception e) {
      tr55.appendTcDetail(e.toString());
    }
    tr55.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_MOBILE_INTCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_MOBILE_INTCODE " */
    TestResult tr56 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_INTCODE);
    try {
      tr56.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_MOBILE_INTCODE"));
    } catch (Exception e) {
      tr56.appendTcDetail(e.toString());
    }
    tr56.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_MOBILE_LOCCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_MOBILE_LOCCODE " */
    TestResult tr57 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_LOCCODE);
    try {
      tr57.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_MOBILE_LOCCODE"));
    } catch (Exception e) {
      tr57.appendTcDetail(e.toString());
    }
    tr57.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_MOBILE_NUMBER
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_MOBILE_NUMBER " */
    TestResult tr58 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_NUMBER);
    try {
      tr58.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_MOBILE_NUMBER"));
    } catch (Exception e) {
      tr58.appendTcDetail(e.toString());
    }
    tr58.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_PAGER_COMMENT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_PAGER_COMMENT " */
    TestResult tr59 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_COMMENT);
    try {
      tr59.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_PAGER_COMMENT"));
    } catch (Exception e) {
      tr59.appendTcDetail(e.toString());
    }
    tr59.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_PAGER_EXT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_PAGER_EXT */
    /* " */
    TestResult tr60 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_EXT);
    try {
      tr60.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_PAGER_EXT"));
    } catch (Exception e) {
      tr60.appendTcDetail(e.toString());
    }
    tr60.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_PAGER_INTCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_PAGER_INTCODE " */
    TestResult tr61 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_INTCODE);
    try {
      tr61.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_PAGER_INTCODE"));
    } catch (Exception e) {
      tr61.appendTcDetail(e.toString());
    }
    tr61.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_PAGER_LOCCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_PAGER_LOCCODE " */
    TestResult tr62 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_LOCCODE);
    try {
      tr62.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_PAGER_LOCCODE"));
    } catch (Exception e) {
      tr62.appendTcDetail(e.toString());
    }
    tr62.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_PAGER_NUMBER
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_PAGER_NUMBER " */
    TestResult tr63 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_NUMBER);
    try {
      tr63.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_PAGER_NUMBER"));
    } catch (Exception e) {
      tr63.appendTcDetail(e.toString());
    }
    tr63.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_TELEPHONE_COMMENT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_TELEPHONE_COMMENT " */
    TestResult tr64 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_COMMENT);
    try {
      tr64.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_TELEPHONE_COMMENT"));
    } catch (Exception e) {
      tr64.appendTcDetail(e.toString());
    }
    tr64.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_TELEPHONE_EXT
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_TELEPHONE_EXT " */
    TestResult tr65 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_EXT);
    try {
      tr65.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_TELEPHONE_EXT"));
    } catch (Exception e) {
      tr65.appendTcDetail(e.toString());
    }
    tr65.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_TELEPHONE_INTCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_TELEPHONE_INTCODE " */
    TestResult tr66 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_INTCODE);
    try {
      tr66.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_TELEPHONE_INTCODE"));
    } catch (Exception e) {
      tr66.appendTcDetail(e.toString());
    }
    tr66.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_TELEPHONE_LOCCODE
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_TELEPHONE_LOCCODE " */
    TestResult tr67 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_LOCCODE);
    try {
      tr67.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_TELEPHONE_LOCCODE"));
    } catch (Exception e) {
      tr67.appendTcDetail(e.toString());
    }
    tr67.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_TELEPHONE_NUMBER
     */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field */
    /* USER_HOMEINFO_TELECOM_TELEPHONE_NUMBER " */
    TestResult tr68 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_NUMBER);
    try {
      tr68.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_TELEPHONE_NUMBER"));
    } catch (Exception e) {
      tr68.appendTcDetail(e.toString());
    }
    tr68.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_JOBTITLE */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_JOBTITLE " */
    TestResult tr69 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_JOBTITLE);
    try {
      tr69.setTcSuccess(cc.hasField("USER_JOBTITLE"));
    } catch (Exception e) {
      tr69.appendTcDetail(e.toString());
    }
    tr69.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_LOGIN_ID */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_LOGIN_ID " */
    TestResult tr70 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_LOGIN_ID);
    try {
      tr70.setTcSuccess(cc.hasField("USER_LOGIN_ID"));
    } catch (Exception e) {
      tr70.appendTcDetail(e.toString());
    }
    tr70.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_NAME_FAMILY */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_NAME_FAMILY " */
    TestResult tr71 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_FAMILY);
    try {
      tr71.setTcSuccess(cc.hasField("USER_NAME_FAMILY"));
    } catch (Exception e) {
      tr71.appendTcDetail(e.toString());
    }
    tr71.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_NAME_GIVEN */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_NAME_GIVEN " */
    TestResult tr72 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_GIVEN);
    try {
      tr72.setTcSuccess(cc.hasField("USER_NAME_GIVEN"));
    } catch (Exception e) {
      tr72.appendTcDetail(e.toString());
    }
    tr72.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_NAME_MIDDLE */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_NAME_MIDDLE " */
    TestResult tr73 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_MIDDLE);
    try {
      tr73.setTcSuccess(cc.hasField("USER_NAME_MIDDLE"));
    } catch (Exception e) {
      tr73.appendTcDetail(e.toString());
    }
    tr73.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_NAME_NICKNAME */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_NAME_NICKNAME " */
    TestResult tr74 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_NICKNAME);
    try {
      tr74.setTcSuccess(cc.hasField("USER_NAME_NICKNAME"));
    } catch (Exception e) {
      tr74.appendTcDetail(e.toString());
    }
    tr74.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_NAME_PREFIX */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_NAME_PREFIX " */
    TestResult tr75 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_PREFIX);
    try {
      tr75.setTcSuccess(cc.hasField("USER_NAME_PREFIX"));
    } catch (Exception e) {
      tr75.appendTcDetail(e.toString());
    }
    tr75.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_NAME_SUFFIX */
    /* Details: "PortletRequest$P3PUserInfos has */
    /* PortletRequest$P3PUserInfos field USER_NAME_SUFFIX " */
    TestResult tr76 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_SUFFIX);
    try {
      tr76.setTcSuccess(cc.hasField("USER_NAME_SUFFIX"));
    } catch (Exception e) {
      tr76.appendTcDetail(e.toString());
    }
    tr76.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_hasToString */
    /* Details: "PortletRequest$P3PUserInfos has a toString()  method " */
    TestResult tr77 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASTOSTRING);
    try {
      String name = "toString";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr77.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr77.appendTcDetail(e.toString());
    }
    tr77.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_hasToStringReturns */
    /* Details: "PortletRequest$P3PUserInfos method toString() returns */
    /* String " */
    TestResult tr78 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASTOSTRINGRETURNS);
    try {
      String name = "toString";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr78.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr78.appendTcDetail(e.toString());
    }
    tr78.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_hasValueOf */
    /* Details: "PortletRequest$P3PUserInfos has a valueOf(String) */
    /* method " */
    TestResult tr79 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUEOF);
    try {
      String name = "valueOf";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr79.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr79.appendTcDetail(e.toString());
    }
    tr79.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_hasValueOfReturns */
    /* Details: "PortletRequest$P3PUserInfos method valueOf(String) */
    /* returns PortletRequest.P3PUserInfos " */
    TestResult tr80 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUEOFRETURNS);
    try {
      String name = "valueOf";
      Class<?> retType = PortletRequest.P3PUserInfos.class;
      Class<?>[] parms = {String.class};
      tr80.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr80.appendTcDetail(e.toString());
    }
    tr80.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_hasValues */
    /* Details: "PortletRequest$P3PUserInfos has a values()  method " */
    TestResult tr81 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUES);
    try {
      String name = "values";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr81.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr81.appendTcDetail(e.toString());
    }
    tr81.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_hasValuesReturns */
    /* Details: "PortletRequest$P3PUserInfos method values() returns */
    /* PortletRequest.P3PUserInfos[] " */
    TestResult tr82 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUESRETURNS);
    try {
      String name = "values";
      Class<?> retType = PortletRequest.P3PUserInfos[].class;
      Class<?>[] parms = null;
      tr82.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr82.appendTcDetail(e.toString());
    }
    tr82.writeTo(writer);

    /* TestCase: V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_isEnum */
    /* Details: "PortletRequest$P3PUserInfos is an Enum " */
    TestResult tr83 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_ISENUM);
    try {
      tr83.setTcSuccess(cc.isEnum());
    } catch (Exception e) {
      tr83.appendTcDetail(e.toString());
    }
    tr83.writeTo(writer);

  }

}
