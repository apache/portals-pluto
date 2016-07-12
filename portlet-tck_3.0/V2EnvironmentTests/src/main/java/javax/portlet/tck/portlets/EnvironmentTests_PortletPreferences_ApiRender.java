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
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_SETVALUE4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETNAMES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETNAMES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETMAP1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETMAP2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_RESET2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_STORE5;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * EnvironmentTests_PortletPreferences_ApiRender_event
 *
 * @author ahmed
 */
public class EnvironmentTests_PortletPreferences_ApiRender implements Portlet {

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

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    // Create result objects for the tests

    PortletPreferences pp = portletReq.getPreferences();

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_isReadOnly1 */
    /* Details: "Method isReadOnly(String): Returns true if the */
    /* preference specified by the key is defined to be read-only in the */
    /* deployment descriptor" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY1);
    boolean readPref1 = pp.isReadOnly("TestPreference1");
    if (readPref1 == true) {
      tr0.setTcSuccess(true);
    }
    tr0.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_isReadOnly2 */
    /* Details: "Method isReadOnly(String): Returns false if the */
    /* preference specified by the key is not defined to be read-only in */
    /* the deployment descriptor" */
    TestResult tr1 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY2);
    boolean readPref2 = pp.isReadOnly("TestPreference2");
    if (readPref2 == false) {
      tr1.setTcSuccess(true);
    }
    tr1.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_isReadOnly3 */
    /* Details: "Method isReadOnly(String): Returns false if the */
    /* preference specified by the key is undefined" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY3);
    boolean readPref3 = pp.isReadOnly("PreferenceUndefined");
    if (readPref3 == false) {
      tr2.setTcSuccess(true);
    }
    tr2.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_isReadOnly4 */
    /* Details: "Method isReadOnly(String): Throws */
    /* IllegalArgumentException if the key is null" */
    TestResult tr3 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY4);
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

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_getValue1 */
    /* Details: "Method getValue(String, String): Returns the first */
    /* String value for the specified key" */
    TestResult tr4 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE1);
    try {
      String getVal = pp.getValue("TestPreference2", null);
      if (getVal != null && getVal.equals("Value2")) {
        tr4.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr4.appendTcDetail(iae.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_getValue2 */
    /* Details: "Method getValue(String, String): Returns the specified */
    /* default value if there is no value for the specified key " */
    TestResult tr5 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE2);
    try {
      String getVal = pp.getValue("TestPreference3", "TestDefault");
      if (getVal.equals("TestDefault")) {
        tr5.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr5.appendTcDetail(iae.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_getValue3 */
    /* Details: "Method getValue(String, String): Returns the specified */
    /* default value if the existing value for the specified key is null */
    /* " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE3);
    try {
      String getVal = pp.getValue("TestPreference3", "TestDefault1");
      if (getVal.equals("TestDefault1")) {
        tr6.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr6.appendTcDetail(iae.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_getValue4 */
    /* Details: "Method getValue(String, String): Throws */
    /* IllegalArgumentException if the key is null" */
    TestResult tr7 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE4);
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

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_getValues1 */
    /* Details: "Method getValues(String, String[]): Returns the values */
    /* String[] for the specified key" */
    TestResult tr8 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES1);
    try {
      String[] getVals = pp.getValues("TestPreference2", null);
      if (getVals[0].equals("Value2") && getVals[1].equals("Value3")) {
        tr8.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr8.appendTcDetail(iae.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_getValues2 */
    /* Details: "Method getValues(String, String[]): Returns the */
    /* specified default String[] if there is no Values for the specified */
    /* key " */
    TestResult tr9 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES2);
    try {
      String[] getVals = pp.getValues("TestPreference3", new String[] {"val2", "val3"});
      if (getVals[0].equals("val2") && getVals[1].equals("val3")) {
        tr9.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr9.appendTcDetail(iae.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_getValues3 */
    /* Details: "Method getValues(String, String[]): Returns the */
    /* specified default String[] if the existing String[] for the */
    /* specified key is null " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES3);
    try {
      String[] getVals = pp.getValues("TestPreference3", new String[] {"val2", "val3"});
      if (getVals[0].equals("val2") && getVals[1].equals("val3")) {
        tr10.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr10.appendTcDetail(iae.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_getValues4 */
    /* Details: "Method getValues(String, String[]): Throws */
    /* IllegalArgumentException if the key is null" */
    TestResult tr11 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES4);
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

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_setValue4 */
    /* Details: "Method setValue(String, String): Throws */
    /* ReadOnlyException if the preference cannot be modified for this */
    /* request" */
    TestResult tr12 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_SETVALUE4);
    try {
      pp.setValue("TestPreference1", "Value1");
      tr12.appendTcDetail("Method Did Not Throw Exception");
    } catch (ReadOnlyException roe) {
      tr12.setTcSuccess(true);
      tr12.appendTcDetail(roe.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_getNames1 */
    /* Details: "Method getNames(): Returns an */
    /* java.util.Enumeration&lt;java.lang.String&gt; containing the */
    /* available preference keys" */
    TestResult tr13 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETNAMES1);
    Enumeration<String> getNam = pp.getNames();
    if (getNam != null) {
      tr13.setTcSuccess(true);
    }
    tr13.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_getNames2 */
    /* Details: "Method getNames(): Returns an empty Enumeration if no */
    /* preference keys are available" */
    TestResult tr14 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETNAMES2);
    tr14.setTcSuccess(true);
    tr14.appendTcDetail(
        "This Method could not tested under this Portlet which already has set of Preferences");
    tr14.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_getMap1 */
    /* Details: "Method getMap(): Returns an */
    /* java.util.Map&lt;java.lang.String&gt; containing the available */
    /* preferences" */
    TestResult tr15 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETMAP1);
    Map<String, String[]> getPref = pp.getMap();
    if (getPref != null) {
      tr15.setTcSuccess(true);
    }
    tr15.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_getMap2 */
    /* Details: "Method getMap(): Returns an empty Map if no preferences */
    /* are available" */
    TestResult tr16 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETMAP2);
    tr16.setTcSuccess(true);
    tr16.appendTcDetail(
        "This Method could not tested under this Portlet which already has set of Preferences");
    tr16.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_reset2 */
    /* Details: "Method reset(String): Throws ReadOnlyException if the */
    /* preference cannot be modified for this request" */
    TestResult tr17 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_RESET2);
    try {
      pp.reset("TestPreference1");
      tr17.appendTcDetail("Method Did Not Throw Exception");
    } catch (ReadOnlyException roe) {
      tr17.appendTcDetail(roe.toString());
      tr17.setTcSuccess(true);
    }
    tr17.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiRender_store5 */
    /* Details: "Method store(): Throws IllegalStateException if store(): */
    /* is called in the render method " */
    TestResult tr18 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_STORE5);
    try {
      pp.store();
    } catch (IllegalStateException ise) {
      tr18.appendTcDetail(ise.toString());
      tr18.setTcSuccess(true);
    }
    tr18.writeTo(writer);

  }

}
