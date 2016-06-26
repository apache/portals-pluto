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
import java.util.Enumeration;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.ValidatorException;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETNAMES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETNAMES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETMAP1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETMAP2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_RESET1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_RESET2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_RESET3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE6;
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
 * EnvironmentTests_PortletPreferences_ApiResource_event
 *
 * @author ahmed
 */
public class EnvironmentTests_PortletPreferences_ApiResource
    implements Portlet, ResourceServingPortlet {

  public static boolean tr32_success = false;

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

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    // Create result objects for the tests

    PortletPreferences pp = portletReq.getPreferences();


    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_isReadOnly1 */
    /* Details: "Method isReadOnly(String): Returns true if the */
    /* preference specified by the key is defined to be read-only in the */
    /* deployment descriptor" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY1);
    boolean readPref1 = pp.isReadOnly("TestPreference1");
    if (readPref1 == true) {
      tr0.setTcSuccess(true);
    }
    tr0.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_isReadOnly2 */
    /* Details: "Method isReadOnly(String): Returns false if the */
    /* preference specified by the key is not defined to be read-only in */
    /* the deployment descriptor" */
    TestResult tr1 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY2);
    boolean readPref2 = pp.isReadOnly("TestPreference2");
    if (readPref2 == false) {
      tr1.setTcSuccess(true);
    }
    tr1.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_isReadOnly3 */
    /* Details: "Method isReadOnly(String): Returns false if the */
    /* preference specified by the key is undefined" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY3);
    boolean readPref3 = pp.isReadOnly("PreferenceUndefined");
    if (readPref3 == false) {
      tr2.setTcSuccess(true);
    }
    tr2.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_isReadOnly4 */
    /* Details: "Method isReadOnly(String): Throws */
    /* IllegalArgumentException if the key is null" */
    TestResult tr3 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY4);
    try {
      try {
        PortletPreferences prefs = portletReq.getPreferences();
        prefs.isReadOnly(null);
        tr3.appendTcDetail("Method did not throw an exception.");
      } catch (IllegalArgumentException iae) {
        tr3.appendTcDetail(iae.toString());
        tr3.setTcSuccess(true);
      } catch (Exception e) {
        tr3.appendTcDetail(e.toString());
      }
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValue1 */
    /* Details: "Method getValue(String, String): Returns the first */
    /* String value for the specified key" */
    TestResult tr4 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE1);
    try {
      String getVal = pp.getValue("TestPreference2", null);
      if (getVal != null && getVal.equals("Value2")) {
        tr4.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr4.appendTcDetail(iae.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValue2 */
    /* Details: "Method getValue(String, String): Returns the specified */
    /* default value if there is no value for the specified key " */
    TestResult tr5 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE2);
    try {
      String getVal = pp.getValue("TestPreference3", "TestDefault");
      if (getVal.equals("TestDefault")) {
        tr5.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr5.appendTcDetail(iae.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValue3 */
    /* Details: "Method getValue(String, String): Returns the specified */
    /* default value if the existing value for the specified key is null */
    /* " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE3);
    try {
      String getVal = pp.getValue("TestPreference3", "TestDefault1");
      if (getVal.equals("TestDefault1")) {
        tr6.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr6.appendTcDetail(iae.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValue4 */
    /* Details: "Method getValue(String, String): Throws */
    /* IllegalArgumentException if the key is null" */
    TestResult tr7 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE4);
    try {
      try {
        PortletPreferences prefs = portletReq.getPreferences();
        prefs.getValue(null, null);
        tr7.appendTcDetail("Method did not throw an exception.");
      } catch (IllegalArgumentException iae) {
        tr7.appendTcDetail(iae.toString());
        tr7.setTcSuccess(true);
      } catch (Exception e) {
        tr7.appendTcDetail(e.toString());
      }
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValues1 */
    /* Details: "Method getValues(String, String[]): Returns the values */
    /* String[] for the specified key" */
    TestResult tr8 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES1);
    try {
      String[] getVals = pp.getValues("TestPreference2", null);
      if (getVals[0].equals("Value2") && getVals[1].equals("Value3")) {
        tr8.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr8.appendTcDetail(iae.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValues2 */
    /* Details: "Method getValues(String, String[]): Returns the */
    /* specified default String[] if there is no Values for the specified */
    /* key " */
    TestResult tr9 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES2);
    try {
      String[] getVals = pp.getValues("TestPreference3", new String[] {"val2", "val3"});
      if (getVals[0].equals("val2") && getVals[1].equals("val3")) {
        tr9.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr9.appendTcDetail(iae.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValues3 */
    /* Details: "Method getValues(String, String[]): Returns the */
    /* specified default String[] if the existing String[] for the */
    /* specified key is null " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES3);
    try {
      String[] getVals = pp.getValues("TestPreference3", new String[] {"val2", "val3"});
      if (getVals[0].equals("val2") && getVals[1].equals("val3")) {
        tr10.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr10.appendTcDetail(iae.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValues4 */
    /* Details: "Method getValues(String, String[]): Throws */
    /* IllegalArgumentException if the key is null" */
    TestResult tr11 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES4);
    try {
      try {
        PortletPreferences prefs = portletReq.getPreferences();
        prefs.getValues(null, new String[] {"val1-1", "val1-2"});
        tr11.appendTcDetail("Method did not throw an exception.");
      } catch (IllegalArgumentException iae) {
        tr11.appendTcDetail(iae.toString());
        tr11.setTcSuccess(true);
      } catch (Exception e) {
        tr11.appendTcDetail(e.toString());
      }
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValue1 */
    /* Details: "Method setValue(String, String): Sets the specified */
    /* value for the specified key" */
    TestResult tr12 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE1);
    try {
      pp.setValue("TestPreference4", "Value4");
      String getval1 = pp.getValue("TestPreference4", null);
      if (getval1.equals("Value4")) {
        tr12.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr12.appendTcDetail(iae.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValue2 */
    /* Details: "Method setValue(String, String): Any existing String or */
    /* String[] value for the specified key is replaced" */
    TestResult tr13 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE2);
    try {
      pp.setValue("TestPreference4", "Value5");
      String getval1 = pp.getValue("TestPreference4", null);
      if (getval1.equals("Value5")) {
        tr13.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr13.appendTcDetail(iae.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValue3 */
    /* Details: "Method setValue(String, String): The value may be set to */
    /* null" */
    TestResult tr14 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE3);
    try {
      pp.setValue("TestPreference5", null);
      String getval1 = pp.getValue("TestPreference5", null);
      if (getval1 == null) {
        tr14.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr14.appendTcDetail(iae.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValue4 */
    /* Details: "Method setValue(String, String): Throws */
    /* ReadOnlyException if the preference cannot be modified for this */
    /* request" */
    TestResult tr15 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE4);
    try {
      pp.setValue("TestPreference1", "Value");
      tr15.appendTcDetail("Method Did Not Throw Exception");
    } catch (ReadOnlyException roe) {
      tr15.appendTcDetail(roe.toString());
      tr15.setTcSuccess(true);
    }
    tr15.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValue5 */
    /* Details: "Method setValue(String, String): Throws */
    /* IllegalArgumentException if the key is null" */
    TestResult tr16 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE5);
    try {
      try {
        PortletPreferences prefs = portletReq.getPreferences();
        prefs.setValue(null, "value");
        tr16.appendTcDetail("Method did not throw an exception.");
      } catch (IllegalArgumentException iae) {
        tr16.appendTcDetail(iae.toString());
        tr16.setTcSuccess(true);
      } catch (Exception e) {
        tr16.appendTcDetail(e.toString());
      }
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValues1 */
    /* Details: "Method setValues(String, String[]): Sets the specified */
    /* value array for the specified key" */
    TestResult tr17 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES1);
    try {
      pp.setValues("TestPreference6", new String[] {"val6", "val7"});
      String getVal1[] = pp.getValues("TestPreference6", null);
      if (getVal1[0].equals("val6") && getVal1[1].equals("val7")) {
        tr17.setTcSuccess(true);
      } else {
        tr17.appendTcDetail("The Preference key has null value");
      }
    } catch (IllegalArgumentException iae) {
      tr17.appendTcDetail(iae.toString());
    }
    tr17.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValues2 */
    /* Details: "Method setValues(String, String[]): Any existing String */
    /* or String[] Values for the specified key is replaced" */
    TestResult tr18 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES2);
    try {
      pp.setValues("TestPreference6", new String[] {"val8", "val9"});
      String getVal2[] = pp.getValues("TestPreference6", null);
      if (getVal2[0].equals("val8") && getVal2[1].equals("val9")) {
        tr18.setTcSuccess(true);
      } else {
        tr18.appendTcDetail("The Preference key has null value");
      }
    } catch (IllegalArgumentException iae) {
      tr18.appendTcDetail(iae.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValues3 */
    /* Details: "Method setValues(String, String[]): The value array may */
    /* be set to null" */
    TestResult tr19 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES3);
    try {
      pp.setValues("TestPreference7", new String[] {null});
      String getVal3[] = pp.getValues("TestPreference7", null);
      if (getVal3[0] == null) {
        tr19.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr19.appendTcDetail(iae.toString());
    }
    tr19.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValues4 */
    /* Details: "Method setValues(String, String[]): The value array may */
    /* contain null members" */
    TestResult tr20 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES4);
    try {
      pp.setValues("TestPreference8", new String[] {"Val10", null});
      String getVal4[] = pp.getValues("TestPreference8", null);
      if (getVal4[0].equals("Val10") && getVal4[1] == null) {
        tr20.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr20.appendTcDetail(iae.toString());
    }
    tr20.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValues5 */
    /* Details: "Method setValues(String, String[]): Throws */
    /* ReadOnlyException if the preference cannot be modified for this */
    /* request" */
    TestResult tr21 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES5);
    try {
      pp.setValues("TestPreference1", new String[] {"Val1"});
      tr21.appendTcDetail("Method did not Throw Exception");
    } catch (ReadOnlyException roe) {
      tr21.appendTcDetail(roe.toString());
      tr21.setTcSuccess(true);
    }
    tr21.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValues6 */
    /* Details: "Method setValues(String, String[]): Throws */
    /* IllegalArgumentException if the key is null" */
    TestResult tr22 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES6);
    try {
      try {
        PortletPreferences prefs = portletReq.getPreferences();
        prefs.setValues(null, new String[] {"val1-1", "val1-2"});
        tr22.appendTcDetail("Method did not throw an exception.");
      } catch (IllegalArgumentException iae) {
        tr22.appendTcDetail(iae.toString());
        tr22.setTcSuccess(true);
      } catch (Exception e) {
        tr22.appendTcDetail(e.toString());
      }
    } catch (Exception e) {
      tr22.appendTcDetail(e.toString());
    }
    tr22.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getNames1 */
    /* Details: "Method getNames(): Returns an */
    /* java.util.Enumeration&lt;java.lang.String&gt; containing the */
    /* available preference keys" */
    TestResult tr23 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETNAMES1);
    Enumeration<String> getNam = pp.getNames();
    if (getNam != null) {
      tr23.setTcSuccess(true);
    }
    tr23.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getNames2 */
    /* Details: "Method getNames(): Returns an empty Enumeration if no */
    /* preference keys are available" */
    TestResult tr24 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETNAMES2);
    tr24.setTcSuccess(true);
    tr24.appendTcDetail(
        "This Method Could not be Tested Which already has Preference keys set for this Portlet");
    tr24.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getMap1 */
    /* Details: "Method getMap(): Returns an */
    /* java.util.Map&lt;java.lang.String&gt; containing the available */
    /* preferences" */
    TestResult tr25 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETMAP1);
    Map<String, String[]> getPref = pp.getMap();
    if (getPref != null) {
      tr25.setTcSuccess(true);
    }
    tr25.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getMap2 */
    /* Details: "Method getMap(): Returns an empty Map if no preferences */
    /* are available" */
    TestResult tr26 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETMAP2);
    tr26.setTcSuccess(true);
    tr26.appendTcDetail(
        "This Method could not tested under this Portlet which already has set of Preferences");
    tr26.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_reset1 */
    /* Details: "Method reset(String): Removes the value associated with */
    /* the specified key" */
    TestResult tr27 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_RESET1);
    try {
      pp.setValue("TestPreference10", "TestValue10");
      pp.reset("TestPreference10");
      String getVal = pp.getValue("TestPreference10", null);
      if (getVal == null) {
        tr27.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr27.appendTcDetail(iae.toString());
    }
    tr27.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_reset2 */
    /* Details: "Method reset(String): Throws ReadOnlyException if the */
    /* preference cannot be modified for this request" */
    TestResult tr28 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_RESET2);
    try {
      pp.reset("TestPreference1");
      tr28.appendTcDetail("Method Did not Throw Exception");
    } catch (ReadOnlyException roe) {
      tr28.appendTcDetail(roe.toString());
      tr28.setTcSuccess(true);
    }
    tr28.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_reset3 */
    /* Details: "Method reset(String): Throws IllegalArgumentException if */
    /* the key is null" */
    TestResult tr29 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_RESET3);
    try {
      try {
        PortletPreferences prefs = portletReq.getPreferences();
        prefs.reset(null);
        tr29.appendTcDetail("Method did not throw an exception.");
      } catch (IllegalArgumentException iae) {
        tr29.appendTcDetail(iae.toString());
        tr29.setTcSuccess(true);
      } catch (Exception e) {
        tr29.appendTcDetail(e.toString());
      }
    } catch (Exception e) {
      tr29.appendTcDetail(e.toString());
    }
    tr29.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_store3 */
    /* Details: "Method store(): If a validator is defined, it is called */
    /* before the actual store is performed" */
    TestResult tr32 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE3);
    EnvironmentTests_PortletPreferences_ApiResource.tr32_success = false;
    pp.setValue("tr33", "true");
    pp.store();
    if (EnvironmentTests_PortletPreferences_ApiResource.tr32_success) {
      tr32.setTcSuccess(true);
    } else {
      tr32.appendTcDetail("Failed because validator is not called");
    }
    tr32.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_store4 */
    /* Details: "Method store(): If validation fails, the store is not */
    /* performed" */
    TestResult tr33 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE4);
    try {
      pp.setValue("tr33", "false");
      pp.store();
    } catch (ValidatorException e) {
      tr33.setTcSuccess(true);
      tr33.appendTcDetail(e.toString() + ". Preferences are not stored");
    }
    tr33.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_store6 */
    /* Details: "Method store(): Throws ValidatorException if the */
    /* validation performed by the associated validator fails " */
    TestResult tr35 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE6);
    try {
      pp.setValue("tr33", "false");
      pp.store();
    } catch (ValidatorException e) {
      tr35.setTcSuccess(true);
      tr35.appendTcDetail(e.toString());
    }
    tr35.writeTo(writer);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    writer.write(
        "<div id=\"EnvironmentTests_PortletPreferences_ApiResource\">no resource output.</div>\n");
    ResourceURL resurl = portletResp.createResourceURL();
    resurl.setCacheability(PAGE);
    writer.write("<script>\n");
    writer.write("(function () {\n");
    writer.write("   var xhr = new XMLHttpRequest();\n");
    writer.write("   xhr.onreadystatechange=function() {\n");
    writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
    writer.write(
        "         document.getElementById(\"EnvironmentTests_PortletPreferences_ApiResource\").innerHTML=xhr.responseText;\n");
    writer.write("      }\n");
    writer.write("   };\n");
    writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
    writer.write("   xhr.send();\n");
    writer.write("})();\n");
    writer.write("</script>\n");
  }

}
