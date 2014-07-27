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

package javax.portlet.tck.RequestTests.portlets;

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
public class V2RequestTests_SIG_PortletRequest$P3PUserInfos implements Portlet {
   private static final String LOG_CLASS = 
         V2RequestTests_SIG_PortletRequest$P3PUserInfos.class.getName();
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
      ClassChecker cc = new ClassChecker(PortletRequest.P3PUserInfos.class);

      // Create result objects for the tests

      /* TestCase: PortletRequest$P3PUserInfos_SIG_isEnum */
      /* Details: "Is an Enum " */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_ISENUM);
      {
         tr0.setTcSuccess(cc.isEnum());
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BDATE_YMD_YEAR */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BDATE_YMD_YEAR " */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BDATE_YMD_YEAR);
      {
         tr1.setTcSuccess(cc.hasField("USER_BDATE_YMD_YEAR"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BDATE_YMD_MONTH */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BDATE_YMD_MONTH " */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BDATE_YMD_MONTH);
      {
         tr2.setTcSuccess(cc.hasField("USER_BDATE_YMD_MONTH"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BDATE_YMD_DAY */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BDATE_YMD_DAY " */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BDATE_YMD_DAY);
      {
         tr3.setTcSuccess(cc.hasField("USER_BDATE_YMD_DAY"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BDATE_HMS_HOUR */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BDATE_HMS_HOUR " */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BDATE_HMS_HOUR);
      {
         tr4.setTcSuccess(cc.hasField("USER_BDATE_HMS_HOUR"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BDATE_HMS_MINUTE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BDATE_HMS_MINUTE " */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BDATE_HMS_MINUTE);
      {
         tr5.setTcSuccess(cc.hasField("USER_BDATE_HMS_MINUTE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BDATE_HMS_SECOND */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BDATE_HMS_SECOND " */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BDATE_HMS_SECOND);
      {
         tr6.setTcSuccess(cc.hasField("USER_BDATE_HMS_SECOND"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BDATE_FRACTIONSECOND */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BDATE_FRACTIONSECOND " */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BDATE_FRACTIONSECOND);
      {
         tr7.setTcSuccess(cc.hasField("USER_BDATE_FRACTIONSECOND"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BDATE_TIMEZONE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BDATE_TIMEZONE " */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BDATE_TIMEZONE);
      {
         tr8.setTcSuccess(cc.hasField("USER_BDATE_TIMEZONE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_GENDER */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_GENDER " */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_GENDER);
      {
         tr9.setTcSuccess(cc.hasField("USER_GENDER"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_EMPLOYER */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_EMPLOYER " */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_EMPLOYER);
      {
         tr10.setTcSuccess(cc.hasField("USER_EMPLOYER"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_DEPARTMENT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_DEPARTMENT " */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_DEPARTMENT);
      {
         tr11.setTcSuccess(cc.hasField("USER_DEPARTMENT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_JOBTITLE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_JOBTITLE " */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_JOBTITLE);
      {
         tr12.setTcSuccess(cc.hasField("USER_JOBTITLE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_NAME_PREFIX */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_NAME_PREFIX " */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_NAME_PREFIX);
      {
         tr13.setTcSuccess(cc.hasField("USER_NAME_PREFIX"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_NAME_GIVEN */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_NAME_GIVEN " */
      TestResult tr14 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_NAME_GIVEN);
      {
         tr14.setTcSuccess(cc.hasField("USER_NAME_GIVEN"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_NAME_FAMILY */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_NAME_FAMILY " */
      TestResult tr15 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_NAME_FAMILY);
      {
         tr15.setTcSuccess(cc.hasField("USER_NAME_FAMILY"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_NAME_MIDDLE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_NAME_MIDDLE " */
      TestResult tr16 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_NAME_MIDDLE);
      {
         tr16.setTcSuccess(cc.hasField("USER_NAME_MIDDLE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_NAME_SUFFIX */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_NAME_SUFFIX " */
      TestResult tr17 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_NAME_SUFFIX);
      {
         tr17.setTcSuccess(cc.hasField("USER_NAME_SUFFIX"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_NAME_NICKNAME */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_NAME_NICKNAME " */
      TestResult tr18 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_NAME_NICKNAME);
      {
         tr18.setTcSuccess(cc.hasField("USER_NAME_NICKNAME"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_LOGIN_ID */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_LOGIN_ID " */
      TestResult tr19 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_LOGIN_ID);
      {
         tr19.setTcSuccess(cc.hasField("USER_LOGIN_ID"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_POSTAL_NAME */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_NAME " */
      TestResult tr20 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_POSTAL_NAME);
      {
         tr20.setTcSuccess(cc.hasField("USER_HOMEINFO_POSTAL_NAME"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_POSTAL_STREET */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_STREET " */
      TestResult tr21 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_POSTAL_STREET);
      {
         tr21.setTcSuccess(cc.hasField("USER_HOMEINFO_POSTAL_STREET"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_POSTAL_CITY */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_CITY " */
      TestResult tr22 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_POSTAL_CITY);
      {
         tr22.setTcSuccess(cc.hasField("USER_HOMEINFO_POSTAL_CITY"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_POSTAL_STATEPROV */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_STATEPROV " */
      TestResult tr23 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_POSTAL_STATEPROV);
      {
         tr23.setTcSuccess(cc.hasField("USER_HOMEINFO_POSTAL_STATEPROV"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_POSTAL_POSTALCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_POSTALCODE " */
      TestResult tr24 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_POSTAL_POSTALCODE);
      {
         tr24.setTcSuccess(cc.hasField("USER_HOMEINFO_POSTAL_POSTALCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_POSTAL_COUNTRY */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_COUNTRY " */
      TestResult tr25 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_POSTAL_COUNTRY);
      {
         tr25.setTcSuccess(cc.hasField("USER_HOMEINFO_POSTAL_COUNTRY"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_POSTAL_ORGANIZATION */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_ORGANIZATION " */
      TestResult tr26 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_POSTAL_ORGANIZATION);
      {
         tr26.setTcSuccess(cc.hasField("USER_HOMEINFO_POSTAL_ORGANIZATION"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_TELEPHONE_INTCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_TELEPHONE_INTCODE " */
      TestResult tr27 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_INTCODE);
      {
         tr27.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_TELEPHONE_INTCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_TELEPHONE_LOCCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_TELEPHONE_LOCCODE " */
      TestResult tr28 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_LOCCODE);
      {
         tr28.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_TELEPHONE_LOCCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_TELEPHONE_NUMBER */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_TELEPHONE_NUMBER " */
      TestResult tr29 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_NUMBER);
      {
         tr29.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_TELEPHONE_NUMBER"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_TELEPHONE_EXT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_TELEPHONE_EXT " */
      TestResult tr30 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_EXT);
      {
         tr30.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_TELEPHONE_EXT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_TELEPHONE_COMMENT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_TELEPHONE_COMMENT " */
      TestResult tr31 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_COMMENT);
      {
         tr31.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_TELEPHONE_COMMENT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_FAX_INTCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_FAX_INTCODE " */
      TestResult tr32 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_FAX_INTCODE);
      {
         tr32.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_FAX_INTCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_FAX_LOCCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_FAX_LOCCODE " */
      TestResult tr33 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_FAX_LOCCODE);
      {
         tr33.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_FAX_LOCCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_FAX_NUMBER */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_FAX_NUMBER " */
      TestResult tr34 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_FAX_NUMBER);
      {
         tr34.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_FAX_NUMBER"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_FAX_EXT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_FAX_EXT " */
      TestResult tr35 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_FAX_EXT);
      {
         tr35.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_FAX_EXT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_FAX_COMMENT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_FAX_COMMENT " */
      TestResult tr36 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_FAX_COMMENT);
      {
         tr36.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_FAX_COMMENT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_MOBILE_INTCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_MOBILE_INTCODE " */
      TestResult tr37 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_MOBILE_INTCODE);
      {
         tr37.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_MOBILE_INTCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_MOBILE_LOCCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_MOBILE_LOCCODE " */
      TestResult tr38 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_MOBILE_LOCCODE);
      {
         tr38.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_MOBILE_LOCCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_MOBILE_NUMBER */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_MOBILE_NUMBER " */
      TestResult tr39 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_MOBILE_NUMBER);
      {
         tr39.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_MOBILE_NUMBER"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_MOBILE_EXT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_MOBILE_EXT " */
      TestResult tr40 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_MOBILE_EXT);
      {
         tr40.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_MOBILE_EXT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_MOBILE_COMMENT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_MOBILE_COMMENT " */
      TestResult tr41 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_MOBILE_COMMENT);
      {
         tr41.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_MOBILE_COMMENT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_PAGER_INTCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_PAGER_INTCODE " */
      TestResult tr42 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_PAGER_INTCODE);
      {
         tr42.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_PAGER_INTCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_PAGER_LOCCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_PAGER_LOCCODE " */
      TestResult tr43 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_PAGER_LOCCODE);
      {
         tr43.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_PAGER_LOCCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_PAGER_NUMBER */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_PAGER_NUMBER " */
      TestResult tr44 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_PAGER_NUMBER);
      {
         tr44.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_PAGER_NUMBER"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_PAGER_EXT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_PAGER_EXT " */
      TestResult tr45 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_PAGER_EXT);
      {
         tr45.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_PAGER_EXT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_TELECOM_PAGER_COMMENT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_PAGER_COMMENT " */
      TestResult tr46 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_TELECOM_PAGER_COMMENT);
      {
         tr46.setTcSuccess(cc.hasField("USER_HOMEINFO_TELECOM_PAGER_COMMENT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_ONLINE_EMAIL */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_ONLINE_EMAIL " */
      TestResult tr47 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_ONLINE_EMAIL);
      {
         tr47.setTcSuccess(cc.hasField("USER_HOMEINFO_ONLINE_EMAIL"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_HOMEINFO_ONLINE_URI */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_HOMEINFO_ONLINE_URI " */
      TestResult tr48 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_HOMEINFO_ONLINE_URI);
      {
         tr48.setTcSuccess(cc.hasField("USER_HOMEINFO_ONLINE_URI"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_POSTAL_NAME */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_NAME " */
      TestResult tr49 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_POSTAL_NAME);
      {
         tr49.setTcSuccess(cc.hasField("USER_BUSINESSINFO_POSTAL_NAME"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_POSTAL_STREET */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_STREET " */
      TestResult tr50 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_POSTAL_STREET);
      {
         tr50.setTcSuccess(cc.hasField("USER_BUSINESSINFO_POSTAL_STREET"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_POSTAL_CITY */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_CITY " */
      TestResult tr51 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_POSTAL_CITY);
      {
         tr51.setTcSuccess(cc.hasField("USER_BUSINESSINFO_POSTAL_CITY"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_POSTAL_STATEPROV */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_STATEPROV " */
      TestResult tr52 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_POSTAL_STATEPROV);
      {
         tr52.setTcSuccess(cc.hasField("USER_BUSINESSINFO_POSTAL_STATEPROV"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_POSTAL_POSTALCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_POSTALCODE " */
      TestResult tr53 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_POSTAL_POSTALCODE);
      {
         tr53.setTcSuccess(cc.hasField("USER_BUSINESSINFO_POSTAL_POSTALCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_POSTAL_COUNTRY */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_COUNTRY " */
      TestResult tr54 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_POSTAL_COUNTRY);
      {
         tr54.setTcSuccess(cc.hasField("USER_BUSINESSINFO_POSTAL_COUNTRY"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_POSTAL_ORGANIZATION */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_ORGANIZATION " */
      TestResult tr55 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_POSTAL_ORGANIZATION);
      {
         tr55.setTcSuccess(cc.hasField("USER_BUSINESSINFO_POSTAL_ORGANIZATION"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_TELEPHONE_INTCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_TELEPHONE_INTCODE " */
      TestResult tr56 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_INTCODE);
      {
         tr56.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_TELEPHONE_INTCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_TELEPHONE_LOCCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_TELEPHONE_LOCCODE " */
      TestResult tr57 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_LOCCODE);
      {
         tr57.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_TELEPHONE_LOCCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_TELEPHONE_NUMBER */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_TELEPHONE_NUMBER " */
      TestResult tr58 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_NUMBER);
      {
         tr58.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_TELEPHONE_NUMBER"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_TELEPHONE_EXT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_TELEPHONE_EXT " */
      TestResult tr59 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_EXT);
      {
         tr59.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_TELEPHONE_EXT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_TELEPHONE_COMMENT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_TELEPHONE_COMMENT " */
      TestResult tr60 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_COMMENT);
      {
         tr60.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_TELEPHONE_COMMENT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_FAX_INTCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_FAX_INTCODE " */
      TestResult tr61 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_FAX_INTCODE);
      {
         tr61.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_FAX_INTCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_FAX_LOCCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_FAX_LOCCODE " */
      TestResult tr62 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_FAX_LOCCODE);
      {
         tr62.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_FAX_LOCCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_FAX_NUMBER */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_FAX_NUMBER " */
      TestResult tr63 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_FAX_NUMBER);
      {
         tr63.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_FAX_NUMBER"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_FAX_EXT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_FAX_EXT " */
      TestResult tr64 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_FAX_EXT);
      {
         tr64.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_FAX_EXT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_FAX_COMMENT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_FAX_COMMENT " */
      TestResult tr65 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_FAX_COMMENT);
      {
         tr65.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_FAX_COMMENT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_MOBILE_INTCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_MOBILE_INTCODE " */
      TestResult tr66 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_INTCODE);
      {
         tr66.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_MOBILE_INTCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_MOBILE_LOCCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_MOBILE_LOCCODE " */
      TestResult tr67 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_LOCCODE);
      {
         tr67.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_MOBILE_LOCCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_MOBILE_NUMBER */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_MOBILE_NUMBER " */
      TestResult tr68 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_NUMBER);
      {
         tr68.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_MOBILE_NUMBER"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_MOBILE_EXT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_MOBILE_EXT " */
      TestResult tr69 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_EXT);
      {
         tr69.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_MOBILE_EXT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_MOBILE_COMMENT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_MOBILE_COMMENT " */
      TestResult tr70 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_COMMENT);
      {
         tr70.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_MOBILE_COMMENT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_PAGER_INTCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_PAGER_INTCODE " */
      TestResult tr71 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_INTCODE);
      {
         tr71.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_PAGER_INTCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_PAGER_LOCCODE */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_PAGER_LOCCODE " */
      TestResult tr72 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_LOCCODE);
      {
         tr72.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_PAGER_LOCCODE"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_PAGER_NUMBER */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_PAGER_NUMBER " */
      TestResult tr73 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_NUMBER);
      {
         tr73.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_PAGER_NUMBER"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_PAGER_EXT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_PAGER_EXT " */
      TestResult tr74 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_EXT);
      {
         tr74.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_PAGER_EXT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_TELECOM_PAGER_COMMENT */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_PAGER_COMMENT " */
      TestResult tr75 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_COMMENT);
      {
         tr75.setTcSuccess(cc.hasField("USER_BUSINESSINFO_TELECOM_PAGER_COMMENT"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_ONLINE_EMAIL */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_ONLINE_EMAIL " */
      TestResult tr76 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_ONLINE_EMAIL);
      {
         tr76.setTcSuccess(cc.hasField("USER_BUSINESSINFO_ONLINE_EMAIL"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_fieldUSER_BUSINESSINFO_ONLINE_URI */
      /* Details: "Has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_ONLINE_URI " */
      TestResult tr77 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_FIELDUSER_BUSINESSINFO_ONLINE_URI);
      {
         tr77.setTcSuccess(cc.hasField("USER_BUSINESSINFO_ONLINE_URI"));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_hasValues */
      /* Details: "Has a values()  method " */
      TestResult tr78 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_HASVALUES);
      {
         String name = "values";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr78.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_hasValuesReturns */
      /* Details: "Method values() returns PortletRequest.P3PUserInfos[] " */
      TestResult tr79 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_HASVALUESRETURNS);
      {
         String name = "values";
         Class<?> retType = PortletRequest.P3PUserInfos[].class;
         Class<?>[] parms = null;
         tr79.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_hasValueOf */
      /* Details: "Has a valueOf(String)  method " */
      TestResult tr80 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_HASVALUEOF);
      {
         String name = "valueOf";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr80.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_hasValueOfReturns */
      /* Details: "Method valueOf(String) returns PortletRequest.P3PUserInfos " */
      TestResult tr81 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_HASVALUEOFRETURNS);
      {
         String name = "valueOf";
         Class<?> retType = PortletRequest.P3PUserInfos.class;
         Class<?>[] parms = {String.class};
         tr81.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_hasToString */
      /* Details: "Has a toString()  method " */
      TestResult tr82 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_HASTOSTRING);
      {
         String name = "toString";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr82.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest$P3PUserInfos_SIG_hasToStringReturns */
      /* Details: "Method toString() returns String " */
      TestResult tr83 = tcd.getTestResultFailed(PORTLETREQUEST$P3PUSERINFOS_SIG_HASTOSTRINGRETURNS);
      {
         String name = "toString";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr83.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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
      tr57.writeTo(writer);
      tr58.writeTo(writer);
      tr59.writeTo(writer);
      tr60.writeTo(writer);
      tr61.writeTo(writer);
      tr62.writeTo(writer);
      tr63.writeTo(writer);
      tr64.writeTo(writer);
      tr65.writeTo(writer);
      tr66.writeTo(writer);
      tr67.writeTo(writer);
      tr68.writeTo(writer);
      tr69.writeTo(writer);
      tr70.writeTo(writer);
      tr71.writeTo(writer);
      tr72.writeTo(writer);
      tr73.writeTo(writer);
      tr74.writeTo(writer);
      tr75.writeTo(writer);
      tr76.writeTo(writer);
      tr77.writeTo(writer);
      tr78.writeTo(writer);
      tr79.writeTo(writer);
      tr80.writeTo(writer);
      tr81.writeTo(writer);
      tr82.writeTo(writer);
      tr83.writeTo(writer);


   }

}

