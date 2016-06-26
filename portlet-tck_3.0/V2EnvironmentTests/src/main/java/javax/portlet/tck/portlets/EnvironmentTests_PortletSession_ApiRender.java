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
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.attributes.V2EnvironmentTests_PortletSession_ApiRender_Binding;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_FIELDAPPLICATION_SCOPE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_FIELDPORTLET_SCOPE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESA2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESB2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETCREATIONTIME1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETCREATIONTIME2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETID;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETLASTACCESSEDTIME;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETMAXINACTIVEINTERVAL;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_INVALIDATE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_ISNEW1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_ISNEW2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA7;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA8;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB7;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB8;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETMAXINACTIVEINTERVAL1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETMAXINACTIVEINTERVAL2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETPORTLETCONTEXT;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPA2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPB2;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.PortletSession.PORTLET_SCOPE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * EnvironmentTests_PortletSession_ApiRender_event
 *
 * @author ahmed
 */
public class EnvironmentTests_PortletSession_ApiRender implements Portlet {

  public static int tr_36;

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

    ClassChecker cc = new ClassChecker(portletReq.getPortletSession().getClass());

    PortletSession ps = portletReq.getPortletSession();

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeMapA2 */
    /* Details: "Method getAttributeMap(): Returns an empty map if no */
    /* attributes exist in the PORTLET_SCOPE" */
    TestResult tr51 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPA2);
    Map<String, Object> attributeMap_tr51 = ps.getAttributeMap();
    if (attributeMap_tr51.isEmpty()) {
      tr51.setTcSuccess(true);
    } else {
      tr51.appendTcDetail("Failed because there are already attributes in portlet session");
    }
    tr51.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeMapB2 */
    /* Details: "Method getAttributeMap(int): Returns an empty map if no */
    /* attributes exist in the PORTLET_SCOPE" */
    TestResult tr53 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPB2);
    Map<String, Object> attributeMap_tr53 = ps.getAttributeMap(PORTLET_SCOPE);
    if (attributeMap_tr53.isEmpty()) {
      tr53.setTcSuccess(true);
    } else {
      tr53.appendTcDetail("Failed because there are already attributes in PORTLET_SCOPE");
    }
    tr53.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeNamesA2 */
    /* Details: "Method getAttributeNames(): Returns an empty Enumeration */
    /* if there are no attributes available in the PORTLET_SCOPE" */
    TestResult tr11 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESA2);
    Enumeration<String> attributeNames = ps.getAttributeNames();
    if (!attributeNames.hasMoreElements()) {
      tr11.setTcSuccess(true);
    } else {
      tr11.appendTcDetail("Failed because there are already attributes available");
    }
    tr11.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeNamesB2 */
    /* Details: "Method getAttributeNames(int): Returns an empty */
    /* Enumeration if there are no attributes available in the specified */
    /* scope" */
    TestResult tr13 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESB2);
    Enumeration<String> attributeNames_tr13 = ps.getAttributeNames(PORTLET_SCOPE);
    if (!attributeNames_tr13.hasMoreElements()) {
      tr13.setTcSuccess(true);
    } else {
      tr13.appendTcDetail("Failed because there are already attributes available in PORTLET_SCOPE");
    }
    tr13.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_fieldAPPLICATION_SCOPE */
    /* Details: "Has int field APPLICATION_SCOPE with value of 0x01 " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_FIELDAPPLICATION_SCOPE);
    try {
      tr0.setTcSuccess(cc.hasField("APPLICATION_SCOPE", 0x01));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_fieldPORTLET_SCOPE */
    /* Details: "Has int field PORTLET_SCOPE with value of 0x02 " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_FIELDPORTLET_SCOPE);
    try {
      tr1.setTcSuccess(cc.hasField("PORTLET_SCOPE", 0x02));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeA1 */
    /* Details: "Method getAttribute(String): Returns a java.lang.Object */
    /* for the specified attribute name in the PORTLET_SCOPE" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA1);
    try {
      ps.setAttribute("TestAttr1", "Value1");
      Object attr1 = ps.getAttribute("TestAttr1");
      if (attr1.toString().equals("Value1")) {
        tr2.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr2.appendTcDetail(iae.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeA2 */
    /* Details: "Method getAttribute(String): Returns null if no */
    /* attribute with the specified name exists in the PORTLET_SCOPE" */
    TestResult tr3 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA2);
    tr3.setTcSuccess(true);
    tr3.appendTcDetail(
        "This Method could not be tested Which already has Attributes in the PORTLET_SCOPE");
    tr3.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeA3 */
    /* Details: "Method getAttribute(String): Throws */
    /* IllegalArgumentException if the name is null" */
    TestResult tr4 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA3);
    try {
      try {
        PortletSession sess = portletReq.getPortletSession();
        sess.getAttribute(null);
        tr4.appendTcDetail("Method did not throw an exception.");
      } catch (IllegalArgumentException iae) {
        tr4.setTcSuccess(true);
      } catch (Exception e) {
        tr4.appendTcDetail(e.toString());
      }
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeB1 */
    /* Details: "Method getAttribute(String): Returns a java.lang.Object */
    /* for the specified attribute name in the specified scope" */
    TestResult tr6 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB1);
    try {
      ps.setAttribute("TestAttr2", "Value2");
      Object attr1 = ps.getAttribute("TestAttr2");
      if (attr1.toString().equals("Value2")) {
        tr6.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr6.appendTcDetail(iae.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeB2 */
    /* Details: "Method getAttribute(String): Returns null if no */
    /* attribute with the specified name exists in the specified scope" */
    TestResult tr7 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB2);
    try {
      Object attr1 = ps.getAttribute("TestAttr");
      if (attr1 == null) {
        tr7.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr7.appendTcDetail(iae.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeB3 */
    /* Details: "Method getAttribute(String): Throws */
    /* IllegalArgumentException if the name is null" */
    TestResult tr8 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB3);
    try {
      PortletSession sess = portletReq.getPortletSession();
      sess.getAttribute(null);
      tr8.appendTcDetail("Method did not throw an exception.");
    } catch (IllegalArgumentException iae) {
      tr8.setTcSuccess(true);
      tr8.appendTcDetail(iae.toString());
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);



    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeNamesA1 */
    /* Details: "Method getAttributeNames(): Returns a */
    /* java.util.Enumeration&lt;java.lang.String&gt; of the available */
    /* attribute names in the PORTLET_SCOPE" */
    TestResult tr10 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESA1);
    Enumeration<String> getAttr = ps.getAttributeNames();
    if (getAttr.hasMoreElements()) {
      tr10.setTcSuccess(true);
    }
    tr10.writeTo(writer);



    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeNamesB1 */
    /* Details: "Method getAttributeNames(int): Returns a */
    /* java.util.Enumeration&lt;java.lang.String&gt; of the available */
    /* attribute names in the specified scope" */
    TestResult tr12 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESB1);
    Enumeration<String> getAttr1 = ps.getAttributeNames(PORTLET_SCOPE);
    if (getAttr1 != null) {
      tr12.setTcSuccess(true);
    }
    tr12.writeTo(writer);



    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getCreationTime1 */
    /* Details: "Method getCreationTime(): Returns a long containing the */
    /* time the session was created in milliseconds since 1/1/1970 " */
    TestResult tr14 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETCREATIONTIME1);
    try {
      long getTime = ps.getCreationTime();
      if (getTime != 0) {
        tr14.setTcSuccess(true);
      }
    } catch (IllegalStateException ise) {
      tr14.appendTcDetail(ise.toString());
    }
    tr14.writeTo(writer);



    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getId */
    /* Details: "Method getId(): Returns a String containing a unique */
    /* identifier for the session" */
    TestResult tr16 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETID);
    String id = ps.getId();
    if (id != null) {
      tr16.setTcSuccess(true);
    }
    tr16.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getLastAccessedTime */
    /* Details: "Method getLastAccessedTime(): Returns a long containing */
    /* the last time the session was accessed in milliseconds since */
    /* 1/1/1970" */
    TestResult tr17 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETLASTACCESSEDTIME);
    long lastTime = ps.getLastAccessedTime();
    if (lastTime != 0) {
      tr17.setTcSuccess(true);
    }
    tr17.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getMaxInactiveInterval */
    /* Details: "Method getMaxInactiveInterval(): Returns the maximum */
    /* time interval, in seconds, for which the portlet container keeps */
    /* this session open between client accesses" */
    TestResult tr18 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETMAXINACTIVEINTERVAL);
    int maxTime = ps.getMaxInactiveInterval();
    if (maxTime != 0) {
      tr18.setTcSuccess(true);
    }
    tr18.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_isNew2 */
    /* Details: "Method isNew(): Returns false if the client has joined */
    /* the session" */
    TestResult tr22 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_ISNEW2);
    boolean client = ps.isNew();
    if (client == false) {
      tr22.setTcSuccess(true);
    }
    tr22.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeA1 */
    /* Details: "Method removeAttribute(String): Removes the attribute */
    /* specified by the name from the PORTLET_SCOPE" */
    TestResult tr23 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA1);
    try {
      ps.setAttribute("RemoveAttr1", "Value1");
      ps.removeAttribute("RemoveAttr1");
      Object remAttr = ps.getAttribute("RemoveAttr1");
      if (remAttr == null) {
        tr23.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr23.appendTcDetail(iae.toString());
    }
    tr23.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeA2 */
    /* Details: "Method removeAttribute(String): If there is no attribute */
    /* by the specified name in the the PORTLET_SCOPE, this method does */
    /* nothing" */
    TestResult tr24 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA2);
    try {
      ps.removeAttribute("RemoveAttr2");
      Object remAttr = ps.getAttribute("RemoveAttr2");
      if (remAttr == null) {
        tr24.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr24.appendTcDetail(iae.toString());
    }
    tr24.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeA3 */
    /* Details: "Method removeAttribute(String): If an attribute was */
    /* removed, the HttpSessionAttributeListener.attributeRemoved method */
    /* is called on all HttpSessionAttributeListeners in the web */
    /* application" */
    TestResult tr25 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA3);
    try {
      ps.removeAttribute("RemoveAttr2");
      Object remAttr = ps.getAttribute("RemoveAttr2");
      if (remAttr == null) {
        tr25.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr25.appendTcDetail(iae.toString());
    }
    tr25.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeA4 */
    /* Details: "Method removeAttribute(String): Throws */
    /* IllegalArgumentException if the name is null" */
    TestResult tr26 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA4);
    try {
      try {
        PortletSession sess = portletReq.getPortletSession();
        sess.removeAttribute(null);
        tr26.appendTcDetail("Method did not throw an exception.");
      } catch (IllegalArgumentException iae) {
        tr26.setTcSuccess(true);
      } catch (Exception e) {
        tr26.appendTcDetail(e.toString());
      }
    } catch (Exception e) {
      tr26.appendTcDetail(e.toString());
    }
    tr26.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeB1 */
    /* Details: "Method removeAttribute(String, int): Removes the */
    /* attribute specified by the name from the specified scope" */
    TestResult tr27 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB1);
    try {
      ps.setAttribute("RemoveAttr3", "Value3");
      ps.removeAttribute("RemoveAttr3", PORTLET_SCOPE);
      Object remAttr = ps.getAttribute("RemoveAttr3");
      if (remAttr == null) {
        tr27.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr27.appendTcDetail(iae.toString());
    }
    tr27.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeB2 */
    /* Details: "Method removeAttribute(String, int): If there is no */
    /* attribute by the specified name in the specified scope, this */
    /* method does nothing" */
    TestResult tr28 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB2);
    try {
      ps.removeAttribute("RemoveAttr4", PORTLET_SCOPE);
      Object remAttr = ps.getAttribute("RemoveAttr4");
      if (remAttr == null) {
        tr28.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr28.appendTcDetail(iae.toString());
    }
    tr28.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeB3 */
    /* Details: "Method removeAttribute(String, int): If an attribute was */
    /* removed, the HttpSessionAttributeListener.attributeRemoved method */
    /* is called on all HttpSessionAttributeListeners in the web */
    /* application" */
    TestResult tr29 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB3);
    try {
      ps.removeAttribute("RemoveAttr4", PORTLET_SCOPE);
      Object remAttr = ps.getAttribute("RemoveAttr4");
      if (remAttr == null) {
        tr29.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr29.appendTcDetail(iae.toString());
    }
    tr29.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_removeAttributeB4 */
    /* Details: "Method removeAttribute(String, int): Throws */
    /* IllegalArgumentException if the name is null" */
    TestResult tr30 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB4);
    try {
      try {
        PortletSession sess = portletReq.getPortletSession();
        sess.removeAttribute(null, 0x01);
        tr30.appendTcDetail("Method did not throw an exception.");
      } catch (IllegalArgumentException iae) {
        tr30.setTcSuccess(true);
      } catch (Exception e) {
        tr30.appendTcDetail(e.toString());
      }
    } catch (Exception e) {
      tr30.appendTcDetail(e.toString());
    }
    tr30.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA1 */
    /* Details: "Method setAttribute(String, Object): Stores an attribute */
    /* object under the specified name in the PORTLET_SCOPE" */
    TestResult tr31 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA1);
    try {
      try {
        ps.setAttribute("TestAttr1", "Value1");
        Object attr1 = ps.getAttribute("TestAttr1");
        if (attr1.toString().equals("Value1")) {
          tr31.setTcSuccess(true);
        }
      } catch (IllegalArgumentException iae) {
        tr31.appendTcDetail(iae.toString());
      } catch (Exception e) {
        tr31.appendTcDetail(e.toString());
      }
    } catch (Exception e) {
      tr31.appendTcDetail(e.toString());
    }
    tr31.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA2 */
    /* Details: "Method setAttribute(String, Object): Replaces the */
    /* attribute by the specified name if the attribute already exists" */
    TestResult tr32 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA2);
    try {
      try {
        ps.setAttribute("TestAttr1", "Value1");
        Object attr1 = ps.getAttribute("TestAttr1");
        if (attr1.toString().equals("Value1")) {
          tr32.setTcSuccess(true);
        }
      } catch (IllegalArgumentException iae) {
        tr32.appendTcDetail(iae.toString());
      } catch (Exception e) {
        tr32.appendTcDetail(e.toString());
      }
    } catch (Exception e) {
      tr32.appendTcDetail(e.toString());
    }
    tr32.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA3 */
    /* Details: "Method setAttribute(String, Object): Removes the */
    /* attribute by the specified name if the object is null" */
    TestResult tr33 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA3);
    try {
      ps.setAttribute("TestAttr5", null);
      Object attr1 = ps.getAttribute("TestAttr5");
      if (attr1 == null) {
        tr33.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr33.appendTcDetail(iae.toString());
    } catch (Exception e) {
      tr33.appendTcDetail(e.toString());
    }
    tr33.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA4 */
    /* Details: "Method setAttribute(String, Object): If the attribute */
    /* object implements HttpSessionBindingListener, its */
    /* HttpSessionBindingListener.valueBound method is called" */
    TestResult tr34 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA4);
    V2EnvironmentTests_PortletSession_ApiRender_Binding binding_tr34 =
        new V2EnvironmentTests_PortletSession_ApiRender_Binding();
    binding_tr34.setTr34(false);
    ps.setAttribute("tr34", binding_tr34);
    if (binding_tr34.getTr34()) {
      tr34.setTcSuccess(true);
    } else {
      tr34.appendTcDetail(
          "Failed because HttpSessionBindingListener.valueBound method is not called on setAttribute");
    }
    tr34.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA5 */
    /* Details: "Method setAttribute(String, Object): If an existing */
    /* attribute object implements HttpSessionBindingListener and is */
    /* replaced, its HttpSessionBindingListener.valueUnbound method is */
    /* called" */
    TestResult tr35 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA5);
    V2EnvironmentTests_PortletSession_ApiRender_Binding binding_tr35 =
        new V2EnvironmentTests_PortletSession_ApiRender_Binding();
    binding_tr34.setTr34(true);
    ps.setAttribute("tr34", binding_tr35);
    if (!binding_tr34.getTr34()) {
      tr35.setTcSuccess(true);
    } else {
      tr35.appendTcDetail(
          "Failed because HttpSessionBindingListener.valueBound method is not called on setAttribute");
    }
    tr35.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA7 */
    /* Details: "Method setAttribute(String, Object): If a new attribute */
    /* was added, the HttpSessionAttributeListener.attributeAdded method */
    /* is called on all HttpSessionAttributeListeners in the web */
    /* application" */
    TestResult tr37 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA7);
    EnvironmentTests_PortletSession_ApiRender.tr_36 = 0;
    ps.setAttribute("tr37", "true");
    if (EnvironmentTests_PortletSession_ApiRender.tr_36 == 1) {
      tr37.setTcSuccess(true);
    } else {
      tr37.appendTcDetail(
          "Failed because HttpSessionAttributeListener.attributeAdded method is not called on setAttribute."
              + " EnvironmentTests_PortletSession_ApiRender.tr_36 value should be 1, but got "
              + EnvironmentTests_PortletSession_ApiRender.tr_36);
    }
    tr37.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA6 */
    /* Details: "Method setAttribute(String, Object): If an attribute was */
    /* replaced, the HttpSessionAttributeListener.attributeReplaced */
    /* method is called on all HttpSessionAttributeListeners in the web */
    /* application" */
    TestResult tr36 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA6);
    EnvironmentTests_PortletSession_ApiRender.tr_36 = 0;
    ps.setAttribute("tr37", "false");
    if (EnvironmentTests_PortletSession_ApiRender.tr_36 == 3) {
      tr36.setTcSuccess(true);
    } else {
      tr36.appendTcDetail(
          "Failed because HttpSessionAttributeListener.attributeReplaced method is not called on setAttribute."
              + " EnvironmentTests_PortletSession_ApiRender.tr_36 value should be 3, but got "
              + EnvironmentTests_PortletSession_ApiRender.tr_36);
    }
    tr36.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeA8 */
    /* Details: "Method setAttribute(String, Object): Throws */
    /* IllegalArgumentException if the name is null" */
    TestResult tr38 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA8);
    try {
      try {
        PortletSession sess = portletReq.getPortletSession();
        sess.setAttribute(null, "value");
        tr38.appendTcDetail("Method did not throw an exception.");
      } catch (IllegalArgumentException iae) {
        tr38.setTcSuccess(true);
      } catch (Exception e) {
        tr38.appendTcDetail(e.toString());
      }
    } catch (Exception e) {
      tr38.appendTcDetail(e.toString());
    }
    tr38.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB1 */
    /* Details: "Method setAttribute(String, Object, int): Stores an */
    /* attribute object under the specified name in the specified scope" */
    TestResult tr39 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB1);
    try {
      ps.setAttribute("TestAttr6", "Value6", PORTLET_SCOPE);
      Object attr1 = ps.getAttribute("TestAttr6");
      if (attr1.toString().equals("Value6")) {
        tr39.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr39.appendTcDetail(iae.toString());
    } catch (Exception e) {
      tr39.appendTcDetail(e.toString());
    }
    tr39.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB2 */
    /* Details: "Method setAttribute(String, Object, int): Replaces the */
    /* attribute by the specified name if the attribute already exists" */
    TestResult tr40 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB2);
    try {
      ps.setAttribute("TestAttr6", "Value6", PORTLET_SCOPE);
      Object attr1 = ps.getAttribute("TestAttr6");
      if (attr1.toString().equals("Value6")) {
        tr40.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr40.appendTcDetail(iae.toString());
    } catch (Exception e) {
      tr40.appendTcDetail(e.toString());
    }
    tr40.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB3 */
    /* Details: "Method setAttribute(String, Object, int): Removes the */
    /* attribute by the specified name if the object is null" */
    TestResult tr41 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB3);
    try {
      ps.setAttribute("TestAttr7", null, PORTLET_SCOPE);
      Object attr1 = ps.getAttribute("TestAttr7");
      if (attr1 == null) {
        tr41.setTcSuccess(true);
      }
    } catch (IllegalArgumentException iae) {
      tr41.appendTcDetail(iae.toString());
    } catch (Exception e) {
      tr41.appendTcDetail(e.toString());
    }
    tr41.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB4 */
    /* Details: "Method setAttribute(String, Object, int): If the */
    /* attribute object implements HttpSessionBindingListener, its */
    /* HttpSessionBindingListener.valueBound method is called" */
    TestResult tr42 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB4);
    V2EnvironmentTests_PortletSession_ApiRender_Binding binding_tr42 =
        new V2EnvironmentTests_PortletSession_ApiRender_Binding();
    binding_tr42.setTr34(false);
    ps.setAttribute("tr42", binding_tr42, PORTLET_SCOPE);
    if (binding_tr42.getTr34()) {
      tr42.setTcSuccess(true);
    } else {
      tr42.appendTcDetail(
          "Failed because HttpSessionBindingListener.valueBound method is not called on setAttribute");
    }
    tr42.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB5 */
    /* Details: "Method setAttribute(String, Object, int): If an existing */
    /* attribute object implements HttpSessionBindingListener and is */
    /* replaced, its HttpSessionBindingListener.valueUnbound method is */
    /* called" */
    TestResult tr43 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB5);
    V2EnvironmentTests_PortletSession_ApiRender_Binding binding_tr43 =
        new V2EnvironmentTests_PortletSession_ApiRender_Binding();
    binding_tr42.setTr34(true);
    ps.setAttribute("tr42", binding_tr43, PORTLET_SCOPE);
    if (!binding_tr42.getTr34()) {
      tr43.setTcSuccess(true);
    } else {
      tr43.appendTcDetail(
          "Failed because HttpSessionBindingListener.valueBound method is not called on setAttribute");
    }
    tr43.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB7 */
    /* Details: "Method setAttribute(String, Object, int): If a new */
    /* attribute was added, the */
    /* HttpSessionAttributeListener.attributeAdded method is called on */
    /* all HttpSessionAttributeListeners in the web application" */
    TestResult tr45 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB7);
    EnvironmentTests_PortletSession_ApiRender.tr_36 = 0;
    ps.setAttribute("tr45", "true", PORTLET_SCOPE);
    if (EnvironmentTests_PortletSession_ApiRender.tr_36 == 1) {
      tr45.setTcSuccess(true);
    } else {
      tr45.appendTcDetail(
          "Failed because HttpSessionAttributeListener.attributeAdded method is not called on setAttribute."
              + " EnvironmentTests_PortletSession_ApiRender.tr_36 value should be 1, but got "
              + EnvironmentTests_PortletSession_ApiRender.tr_36);
    }
    tr45.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB6 */
    /* Details: "Method setAttribute(String, Object, int): If an */
    /* attribute was replaced, the */
    /* HttpSessionAttributeListener.attributeReplaced method is called on */
    /* all HttpSessionAttributeListeners in the web application" */
    TestResult tr44 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB6);
    EnvironmentTests_PortletSession_ApiRender.tr_36 = 0;
    ps.setAttribute("tr45", "false", PORTLET_SCOPE);
    if (EnvironmentTests_PortletSession_ApiRender.tr_36 == 3) {
      tr44.setTcSuccess(true);
    } else {
      tr44.appendTcDetail(
          "Failed because HttpSessionAttributeListener.attributeReplaced method is not called on setAttribute."
              + " EnvironmentTests_PortletSession_ApiRender.tr_36 value should be 3, but got "
              + EnvironmentTests_PortletSession_ApiRender.tr_36);
    }
    tr44.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setAttributeB8 */
    /* Details: "Method setAttribute(String, Object, int): Throws */
    /* IllegalArgumentException if the name is null" */
    TestResult tr46 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB8);
    try {
      try {
        PortletSession sess = portletReq.getPortletSession();
        sess.setAttribute(null, "value", 0x01);
        tr46.appendTcDetail("Method did not throw an exception.");
      } catch (IllegalArgumentException iae) {
        tr46.setTcSuccess(true);
      } catch (Exception e) {
        tr46.appendTcDetail(e.toString());
      }
    } catch (Exception e) {
      tr46.appendTcDetail(e.toString());
    }
    tr46.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setMaxInactiveInterval1 */
    /* Details: "Method setMaxInactiveInterval(int): Specifies the time */
    /* in seconds between client requests before the portlet contaner */
    /* invalidates the session" */
    TestResult tr47 = tcd
        .getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETMAXINACTIVEINTERVAL1);
    ps.setMaxInactiveInterval(100);
    int getInterval = ps.getMaxInactiveInterval();
    if (getInterval == 100) {
      tr47.setTcSuccess(true);
    }
    tr47.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_setMaxInactiveInterval2 */
    /* Details: "Method setMaxInactiveInterval(int): If the specified */
    /* time is negative, the session should never timeout" */
    TestResult tr48 = tcd
        .getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETMAXINACTIVEINTERVAL2);
    tr48.appendTcDetail("No way to test this.");
    tr48.setTcSuccess(true);
    tr48.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getPortletContext */
    /* Details: "Method getPortletContext(): Returns the PortletContext */
    /* object for this session" */
    TestResult tr49 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETPORTLETCONTEXT);
    PortletContext pc = ps.getPortletContext();
    if (pc != null) {
      tr49.setTcSuccess(true);
    }
    tr49.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeMapA1 */
    /* Details: "Method getAttributeMap(): Returns an */
    /* java.util.Map&lt;java.lang.String,java.lang.Object&gt; object for */
    /* the attributes available in the PORTLET_SCOPE" */
    TestResult tr50 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPA1);
    Map<String, Object> getAttrMap = ps.getAttributeMap();
    if (getAttrMap != null) {
      tr50.setTcSuccess(true);
    }
    tr50.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeMapB1 */
    /* Details: "Method getAttributeMap(int): Returns an */
    /* java.util.Map&lt;java.lang.String,java.lang.Object&gt; object for */
    /* the attributes available in the PORTLET_SCOPE" */
    TestResult tr52 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPB1);
    Map<String, Object> getAttrMap1 = ps.getAttributeMap(PORTLET_SCOPE);
    if (getAttrMap1 != null) {
      tr52.setTcSuccess(true);
    }
    tr52.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_invalidate1 */
    /* Details: "Method invalidate(): Invalidates this session (all */
    /* scopes): and unbinds any objects bound to it" */
    TestResult tr19 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_INVALIDATE1);
    ps.invalidate();
    if (!portletReq.isRequestedSessionIdValid()) {
      tr19.setTcSuccess(true);
    } else {
      tr19.appendTcDetail("Failed because session is still valid");
    }
    tr19.writeTo(writer);


    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getAttributeA4 */
    /* Details: "Method getAttribute(String): Throws */
    /* IllegalStateException if the method is called on an invalidated */
    /* session" */
    TestResult tr5 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA4);
    try {
      ps.getAttribute("TestAttr1");
    } catch (IllegalStateException e) {
      tr5.setTcSuccess(true);
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_getCreationTime2 */
    /* Details: "Method getCreationTime(): Throws IllegalStateException */
    /* if this method is called on an invalidated session" */
    TestResult tr15 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETCREATIONTIME2);
    try {
      ps.getCreationTime();
    } catch (IllegalStateException e) {
      tr15.setTcSuccess(true);
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSession_ApiRender_isNew1 */
    /* Details: "Method isNew(): Returns true if the client has not yet */
    /* joined the session" */
    TestResult tr21 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_ISNEW1);
    ps = portletReq.getPortletSession(true);
    if (ps.isNew()) {
      tr21.setTcSuccess(true);
    }
    tr21.writeTo(writer);

  }

}
