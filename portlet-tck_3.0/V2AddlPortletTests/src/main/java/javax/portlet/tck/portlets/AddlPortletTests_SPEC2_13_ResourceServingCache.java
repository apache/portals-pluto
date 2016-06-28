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
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestLink;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHING2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHING3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL8;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL9;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET8;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET9;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE8;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE9;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.ResourceURL.PAGE;
import static javax.portlet.ResourceURL.PORTLET;
import static javax.portlet.ResourceURL.FULL;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlPortletTests_SPEC2_13_ResourceServingCache_event
 * 
 * @author ahmed
 */
public class AddlPortletTests_SPEC2_13_ResourceServingCache
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

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    String action = portletReq.getParameter("action");

    if (action != null) {
      if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_caching2")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_caching2 */
        /* Details: "The portlet can use the setCacheability method to set */
        /* the cache level for the ResourceURL" */
        TestResult tr1 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHING2);
        if (portletReq.getCacheability().equals(ResourceURL.FULL)) {
          tr1.setTcSuccess(true);
        }
        tr1.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_caching3")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_caching3 */
        /* Details: "If the cache level is not set, a generated resource URL */
        /* has the cacheability of the request in which it was created" */
        TestResult tr2 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHING3);
        if (portletReq.getParameter("tr2") != null
            && portletReq.getParameter("tr2").equals(portletReq.getCacheability())) {
          tr2.setTcSuccess(true);
        }
        tr2.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL1")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL1 */
        /* Details: "If the cache level is set to FULL, the resource URL does */
        /* not contain the current render parameters" */
        TestResult tr3 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL1);
        if (portletReq.getParameter("tr3") == null) {
          tr3.setTcSuccess(true);
        } else {
          tr3.appendTcDetail(
              "Failed because render parameter \"tr3\" is still present in FULL cacheability");
        }
        tr3.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL5")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL5 */
        /* Details: "In a resource request resulting from triggering a */
        /* resource URL with cacheability set to FULL, a resource URL with */
        /* cacheability set to FULL may be generated" */
        TestResult tr7 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL5);
        try {
          ResourceURL tr7_resourceURL = portletResp.createResourceURL();
          tr7_resourceURL.setCacheability(FULL);
          tr7.appendTcDetail("ResourceURL successfully created - " + tr7_resourceURL.toString());
          tr7.setTcSuccess(true);
        } catch (IllegalStateException e) {
          tr7.setTcSuccess(false);
          tr7.appendTcDetail(e.getMessage());
        }
        tr7.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL6")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL6 */
        /* Details: "In a resource request resulting from triggering a */
        /* resource URL with cacheability set to FULL, setting cacheability */
        /* on a resource URL to PORTLET results in an an */
        /* IllegalStateException" */
        TestResult tr8 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL6);
        try {
          ResourceURL tr8_resourceURL = portletResp.createResourceURL();
          tr8_resourceURL.setCacheability(PORTLET);
          tr8.appendTcDetail("ResourceURL successfully created - " + tr8_resourceURL.toString());
        } catch (IllegalStateException e) {
          tr8.setTcSuccess(true);
          tr8.appendTcDetail(e.getMessage());
        }
        tr8.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL7")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL7 */
        /* Details: "In a resource request resulting from triggering a */
        /* resource URL with cacheability set to FULL, setting cacheability */
        /* on a resource URL to PAGE results in an an IllegalStateException" */
        TestResult tr9 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL7);
        try {
          ResourceURL tr9_resourceURL = portletResp.createResourceURL();
          tr9_resourceURL.setCacheability(PAGE);
          tr9.appendTcDetail("ResourceURL successfully created - " + tr9_resourceURL.toString());
        } catch (IllegalStateException e) {
          tr9.setTcSuccess(true);
          tr9.appendTcDetail(e.getMessage());
        }
        tr9.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL8")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL8 */
        /* Details: "In a resource request resulting from triggering a */
        /* resource URL with cacheability set to FULL, an attempt to create a */
        /* render URL results in an an IllegalStateException" */
        TestResult tr10 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL8);
        try {
          PortletURL tr10_renderURL = portletResp.createRenderURL();
          tr10.appendTcDetail("RenderURL successfully created - " + tr10_renderURL.toString());
        } catch (IllegalStateException e) {
          tr10.setTcSuccess(true);
          tr10.appendTcDetail(e.getMessage());
        }
        tr10.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL9")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL9 */
        /* Details: "In a resource request resulting from triggering a */
        /* resource URL with cacheability set to FULL, an attempt to create */
        /* an action URL results in an an IllegalStateException" */
        TestResult tr11 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL9);
        try {
          PortletURL tr11_actionURL = portletResp.createActionURL();
          tr11.appendTcDetail("ActionURL successfully created - " + tr11_actionURL.toString());
        } catch (IllegalStateException e) {
          tr11.setTcSuccess(true);
          tr11.appendTcDetail(e.getMessage());
        }
        tr11.writeTo(writer);
      } else if (action
          .equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET1")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET1 */
        /* Details: "If the cache level is set to PORTLET, the resource URL */
        /* contains the current render parameters" */
        TestResult tr12 = tcd
            .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET1);
        if (portletReq.getParameter("tr12") != null
            && portletReq.getParameter("tr12").equals("true")) {
          tr12.setTcSuccess(true);
        } else {
          tr12.appendTcDetail("Render parameter \"tr12\" is not present in ResourceRequest");
        }
        tr12.writeTo(writer);
      } else if (action
          .equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET2")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET2 */
        /* Details: "If the cache level is set to PORTLET, the resource URL */
        /* contains the current portlet mode" */
        TestResult tr13 = tcd
            .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET2);
        if (portletReq.getParameter("tr13") != null
            && portletReq.getParameter("tr13").equals(portletReq.getPortletMode().toString())) {
          tr13.setTcSuccess(true);
        } else {
          tr13.appendTcDetail("Failed because ResourceURL is not in " + portletReq.getPortletMode()
              + " portlet mode.");
        }
        tr13.writeTo(writer);
      } else if (action
          .equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET3")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET3 */
        /* Details: "If the cache level is set to PORTLET, the resource URL */
        /* contains the current window state" */
        TestResult tr14 = tcd
            .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET3);
        if (portletReq.getParameter("tr14") != null
            && portletReq.getParameter("tr14").equals(portletReq.getWindowState().toString())) {
          tr14.setTcSuccess(true);
        } else {
          tr14.appendTcDetail("Failed because ResourceURL is not in " + portletReq.getWindowState()
              + " window state.");
        }
        tr14.writeTo(writer);
      } else if (action
          .equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET4")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET4 */
        /* Details: "If the cache level is set to PORTLET, the resource URL */
        /* does not contain the current page state" */
        TestResult tr15 = tcd
            .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET4);
        if (portletReq.getParameter("tr15") != null
            && portletReq.getParameter("tr15").equals("true")
            && portletReq.getParameter("tr15_windowState") != null && portletReq
                .getParameter("tr15_windowState").equals(portletReq.getWindowState().toString())) {
          tr15.setTcSuccess(true);
        } else {
          tr15.appendTcDetail("Failed because ResourceURL is not in " + portletReq.getWindowState()
              + " window state or render parameter \"tr15\" is missing");
        }
        tr15.writeTo(writer);
      } else if (action
          .equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET5")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET5 */
        /* Details: "In a resource request resulting from triggering a */
        /* resource URL with cacheability set to PORTLET, a resource URL with */
        /* cacheability set to FULL may be generated" */
        TestResult tr16 = tcd
            .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET5);
        try {
          ResourceURL tr16_resourceURL = portletResp.createResourceURL();
          tr16_resourceURL.setCacheability(FULL);
          tr16.appendTcDetail("ResourceURL successfully created - " + tr16_resourceURL.toString());
          tr16.setTcSuccess(true);
        } catch (IllegalStateException e) {
          tr16.setTcSuccess(false);
          tr16.appendTcDetail(e.getMessage());
        }
        tr16.writeTo(writer);
      } else if (action
          .equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET6")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET6 */
        /* Details: "In a resource request resulting from triggering a */
        /* resource URL with cacheability set to PORTLET, a resource URL with */
        /* cacheability set to PORTLET may be generated" */
        TestResult tr17 = tcd
            .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET6);
        try {
          ResourceURL tr17_resourceURL = portletResp.createResourceURL();
          tr17_resourceURL.setCacheability(PORTLET);
          tr17.appendTcDetail("ResourceURL successfully created - " + tr17_resourceURL.toString());
          tr17.setTcSuccess(true);
        } catch (IllegalStateException e) {
          tr17.setTcSuccess(false);
          tr17.appendTcDetail(e.getMessage());
        }
        tr17.writeTo(writer);
      } else if (action
          .equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET7")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET7 */
        /* Details: "In a resource request resulting from triggering a */
        /* resource URL with cacheability set to PORTLET, setting */
        /* cacheability on a resource URL to PAGE results in an an */
        /* IllegalStateException" */
        TestResult tr18 = tcd
            .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET7);
        try {
          ResourceURL tr18_resourceURL = portletResp.createResourceURL();
          tr18_resourceURL.setCacheability(PAGE);
          tr18.appendTcDetail("ResourceURL successfully created - " + tr18_resourceURL.toString());
        } catch (IllegalStateException e) {
          tr18.setTcSuccess(true);
          tr18.appendTcDetail(e.getMessage());
        }
        tr18.writeTo(writer);
      } else if (action
          .equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET8")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET8 */
        /* Details: "In a resource request resulting from triggering a */
        /* resource URL with cacheability set to PORTLET, an attempt to */
        /* create a render URL results in an an IllegalStateException" */
        TestResult tr19 = tcd
            .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET8);
        try {
          PortletURL tr19_renderURL = portletResp.createRenderURL();
          tr19.appendTcDetail("RenderURL successfully created - " + tr19_renderURL.toString());
        } catch (IllegalStateException e) {
          tr19.setTcSuccess(true);
          tr19.appendTcDetail(e.getMessage());
        }
        tr19.writeTo(writer);
      } else if (action
          .equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET9")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET9 */
        /* Details: "In a resource request resulting from triggering a */
        /* resource URL with cacheability set to PORTLET, an attempt to */
        /* create an action URL results in an an IllegalStateException" */
        TestResult tr20 = tcd
            .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET9);
        try {
          PortletURL tr20_actionURL = portletResp.createActionURL();
          tr20.appendTcDetail("ActionURL successfully created - " + tr20_actionURL.toString());
        } catch (IllegalStateException e) {
          tr20.setTcSuccess(true);
          tr20.appendTcDetail(e.getMessage());
        }
        tr20.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE1")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE1 */
        /* Details: "If the cache level is set to PAGE, the resource URL */
        /* contains the current render parameters" */
        TestResult tr21 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE1);
        if (portletReq.getParameter("tr21") != null
            && portletReq.getParameter("tr21").equals("true")) {
          tr21.setTcSuccess(true);
        } else {
          tr21.appendTcDetail("Render parameter \"tr21\" is not present in ResourceRequest");
        }
        tr21.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE2")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE2 */
        /* Details: "If the cache level is set to PAGE, the resource URL */
        /* contains the current PAGE mode" */
        TestResult tr22 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE2);
        if (portletReq.getParameter("tr22") != null
            && portletReq.getParameter("tr22").equals(portletReq.getPortletMode().toString())) {
          tr22.setTcSuccess(true);
        } else {
          tr22.appendTcDetail("Failed because ResourceURL is not in " + portletReq.getPortletMode()
              + " portlet mode.");
        }
        tr22.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE3")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE3 */
        /* Details: "If the cache level is set to PAGE, the resource URL */
        /* contains the current window state" */
        TestResult tr23 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE3);
        if (portletReq.getParameter("tr23") != null
            && portletReq.getParameter("tr23").equals(portletReq.getWindowState().toString())) {
          tr23.setTcSuccess(true);
        } else {
          tr23.appendTcDetail("Failed because ResourceURL is not in " + portletReq.getWindowState()
              + " window state.");
        }
        tr23.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE4")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE4 */
        /* Details: "If the cache level is set to PAGE, the resource URL */
        /* contains the current page state" */
        TestResult tr24 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE4);
        if (portletReq.getParameter("tr24") != null
            && portletReq.getParameter("tr24").equals("true")
            && portletReq.getParameter("tr24_windowState") != null && portletReq
                .getParameter("tr24_windowState").equals(portletReq.getWindowState().toString())) {
          tr24.setTcSuccess(true);
        } else {
          tr24.appendTcDetail("Failed because ResourceURL is not in " + portletReq.getWindowState()
              + " window state or render parameter \"tr24\" is missing");
        }
        tr24.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE5")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE5 */
        /* Details: "In a resource request resulting from triggering a */
        /* resource URL with cacheability set to PAGE, a resource URL with */
        /* cacheability set to FULL may be generated" */
        TestResult tr25 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE5);
        try {
          ResourceURL tr25_resourceURL = portletResp.createResourceURL();
          tr25_resourceURL.setCacheability(FULL);
          tr25.appendTcDetail("ResourceURL successfully created - " + tr25_resourceURL.toString());
          tr25.setTcSuccess(true);
        } catch (IllegalStateException e) {
          tr25.setTcSuccess(false);
          tr25.appendTcDetail(e.getMessage());
        }
        tr25.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE6")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE6 */
        /* Details: "In a resource request resulting from triggering a */
        /* resource URL with cacheability set to PAGE, a resource URL with */
        /* cacheability set to PORTLET may be generated" */
        TestResult tr26 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE6);
        try {
          ResourceURL tr26_resourceURL = portletResp.createResourceURL();
          tr26_resourceURL.setCacheability(PORTLET);
          tr26.appendTcDetail("ResourceURL successfully created - " + tr26_resourceURL.toString());
          tr26.setTcSuccess(true);
        } catch (IllegalStateException e) {
          tr26.setTcSuccess(false);
          tr26.appendTcDetail(e.getMessage());
        }
        tr26.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE7")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE7 */
        /* Details: "In a resource request resulting from triggering a */
        /* resource URL with cacheability set to PAGE, a resource URL with */
        /* cacheability set to PAGE may be generated" */
        TestResult tr27 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE7);
        try {
          ResourceURL tr27_resourceURL = portletResp.createResourceURL();
          tr27_resourceURL.setCacheability(PAGE);
          tr27.appendTcDetail("ResourceURL successfully created - " + tr27_resourceURL.toString());
          tr27.setTcSuccess(true);
        } catch (IllegalStateException e) {
          tr27.setTcSuccess(false);
          tr27.appendTcDetail(e.getMessage());
        }
        tr27.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE8")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE8 */
        /* Details: "In a resource request resulting from triggering a */
        /* resource URL with cacheability set to PAGE, a render URL may be */
        /* generated" */
        TestResult tr28 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE8);
        try {
          PortletURL tr28_renderURL = portletResp.createRenderURL();
          tr28.appendTcDetail("ResourceURL successfully created - " + tr28_renderURL.toString());
          tr28.setTcSuccess(true);
        } catch (IllegalStateException e) {
          tr28.setTcSuccess(false);
          tr28.appendTcDetail(e.getMessage());
        }
        tr28.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE9")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE9 */
        /* Details: "In a resource request resulting from triggering a */
        /* resource URL with cacheability set to PAGE, an action URL may be */
        /* generated" */
        TestResult tr29 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE9);
        try {
          PortletURL tr29_actionURL = portletResp.createActionURL();
          tr29.appendTcDetail("ResourceURL successfully created - " + tr29_actionURL.toString());
          tr29.setTcSuccess(true);
        } catch (IllegalStateException e) {
          tr29.setTcSuccess(false);
          tr29.appendTcDetail(e.getMessage());
        }
        tr29.writeTo(writer);
      }
    }
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    writer.write("<script type=\"text/javascript\" id=\"getResourceCall\">");
    writer.write("  function getResource(testCase, URL) {");
    writer.write("    var xhr = new XMLHttpRequest();");
    writer.write("    xhr.onreadystatechange=function() {");
    writer.write("      if (xhr.readyState==4 && xhr.status==200) {");
    writer.write("        document.getElementById(testCase).innerHTML = xhr.responseText;");
    writer.write("      }");
    writer.write("    };");
    writer.write("    xhr.open(\"POST\",URL,true);");
    writer.write("    xhr.send();");
    writer.write("  }");
    writer.write("</script>");

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_caching2 */
    /* Details: "The portlet can use the setCacheability method to set */
    /* the cache level for the ResourceURL" */
    {
      ResourceURL resurlTr1 = portletResp.createResourceURL();
      resurlTr1.setCacheability(FULL);
      resurlTr1.setParameter("action", "V2AddlPortletTests_SPEC2_13_ResourceServingCache_caching2");
      writer.write("<DIV id=\"tr1_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr1_ResourceServingCache','" + resurlTr1.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_caching3 */
    /* Details: "If the cache level is not set, a generated resource URL */
    /* has the cacheability of the request in which it was created" */
    {
      ResourceURL resurlTr2 = portletResp.createResourceURL();
      resurlTr2.setParameter("tr2", resurlTr2.getCacheability());
      resurlTr2.setParameter("action", "V2AddlPortletTests_SPEC2_13_ResourceServingCache_caching3");
      writer.write("<DIV id=\"tr2_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr2_ResourceServingCache','" + resurlTr2.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL1 */
    /* Details: "If the cache level is set to FULL, the resource URL does */
    /* not contain the current render parameters" */
    {
      if (portletReq.getParameter("tr3") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tr3", "true");
        TestLink tl =
            new TestLink(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL1, purl);
        tl.writeTo(writer);
      } else {
        ResourceURL resurlTr3 = portletResp.createResourceURL();
        resurlTr3.setCacheability(FULL);
        resurlTr3.setParameter("action",
            "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL1");
        writer.write("<DIV id=\"tr3_ResourceServingCache\"></DIV>");
        writer.write("<script type=\"text/javascript\">");
        writer.write("getResource('tr3_ResourceServingCache','" + resurlTr3.toString() + "');");
        writer.write("</script>");
      }
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL5 */
    /* Details: "In a resource request resulting from triggering a */
    /* resource URL with cacheability set to FULL, a resource URL with */
    /* cacheability set to FULL may be generated" */
    {
      ResourceURL resurlTr7 = portletResp.createResourceURL();
      resurlTr7.setCacheability(FULL);
      resurlTr7.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL5");
      writer.write("<DIV id=\"tr7_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr7_ResourceServingCache','" + resurlTr7.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL6 */
    /* Details: "In a resource request resulting from triggering a */
    /* resource URL with cacheability set to FULL, setting cacheability */
    /* on a resource URL to PORTLET results in an an */
    /* IllegalStateException" */
    {
      ResourceURL resurlTr8 = portletResp.createResourceURL();
      resurlTr8.setCacheability(FULL);
      resurlTr8.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL6");
      writer.write("<DIV id=\"tr8_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr8_ResourceServingCache','" + resurlTr8.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL7 */
    /* Details: "In a resource request resulting from triggering a */
    /* resource URL with cacheability set to FULL, setting cacheability */
    /* on a resource URL to PAGE results in an an IllegalStateException" */
    {
      ResourceURL resurlTr9 = portletResp.createResourceURL();
      resurlTr9.setCacheability(FULL);
      resurlTr9.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL7");
      writer.write("<DIV id=\"tr9_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr9_ResourceServingCache','" + resurlTr9.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL8 */
    /* Details: "In a resource request resulting from triggering a */
    /* resource URL with cacheability set to FULL, an attempt to create a */
    /* render URL results in an an IllegalStateException" */
    {
      ResourceURL resurlTr10 = portletResp.createResourceURL();
      resurlTr10.setCacheability(FULL);
      resurlTr10.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL8");
      writer.write("<DIV id=\"tr10_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr10_ResourceServingCache','" + resurlTr10.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL9 */
    /* Details: "In a resource request resulting from triggering a */
    /* resource URL with cacheability set to FULL, an attempt to create */
    /* an action URL results in an an IllegalStateException" */
    {
      ResourceURL resurlTr11 = portletResp.createResourceURL();
      resurlTr11.setCacheability(FULL);
      resurlTr11.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL9");
      writer.write("<DIV id=\"tr11_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr11_ResourceServingCache','" + resurlTr11.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET1 */
    /* Details: "If the cache level is set to PORTLET, the resource URL */
    /* contains the current render parameters" */
    {
      if (portletReq.getParameter("tr12") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tr12", "true");
        TestLink tl =
            new TestLink(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET1, purl);
        tl.writeTo(writer);
      } else {
        ResourceURL resurlTr12 = portletResp.createResourceURL();
        resurlTr12.setCacheability(PORTLET);
        resurlTr12.setParameter("action",
            "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET1");
        writer.write("<DIV id=\"tr12_ResourceServingCache\"></DIV>");
        writer.write("<script type=\"text/javascript\">");
        writer.write("getResource('tr12_ResourceServingCache','" + resurlTr12.toString() + "');");
        writer.write("</script>");
      }
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET2 */
    /* Details: "If the cache level is set to PORTLET, the resource URL */
    /* contains the current portlet mode" */
    {
      ResourceURL resurlTr13 = portletResp.createResourceURL();
      resurlTr13.setCacheability(PORTLET);
      resurlTr13.setParameter("tr13", portletReq.getPortletMode().toString());
      resurlTr13.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET2");
      writer.write("<DIV id=\"tr13_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr13_ResourceServingCache','" + resurlTr13.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET3 */
    /* Details: "If the cache level is set to PORTLET, the resource URL */
    /* contains the current window state" */
    {
      ResourceURL resurlTr14 = portletResp.createResourceURL();
      resurlTr14.setCacheability(PORTLET);
      resurlTr14.setParameter("tr14", portletReq.getWindowState().toString());
      resurlTr14.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET3");
      writer.write("<DIV id=\"tr14_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr14_ResourceServingCache','" + resurlTr14.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET4 */
    /* Details: "If the cache level is set to PORTLET, the resource URL */
    /* does not contain the current page state" */
    {
      if (portletReq.getParameter("tr15") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tr15", "true");
        TestLink tl =
            new TestLink(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET4, purl);
        tl.writeTo(writer);
      } else {
        ResourceURL resurlTr15 = portletResp.createResourceURL();
        resurlTr15.setCacheability(PORTLET);
        resurlTr15.setParameter("tr15_windowState", portletReq.getWindowState().toString());
        resurlTr15.setParameter("action",
            "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET4");
        writer.write("<DIV id=\"tr15_ResourceServingCache\"></DIV>");
        writer.write("<script type=\"text/javascript\">");
        writer.write("getResource('tr15_ResourceServingCache','" + resurlTr15.toString() + "');");
        writer.write("</script>");
      }
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET5 */
    /* Details: "In a resource request resulting from triggering a */
    /* resource URL with cacheability set to PORTLET, a resource URL with */
    /* cacheability set to FULL may be generated" */
    {
      ResourceURL resurlTr16 = portletResp.createResourceURL();
      resurlTr16.setCacheability(PORTLET);
      resurlTr16.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET5");
      writer.write("<DIV id=\"tr16_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr16_ResourceServingCache','" + resurlTr16.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET6 */
    /* Details: "In a resource request resulting from triggering a */
    /* resource URL with cacheability set to PORTLET, a resource URL with */
    /* cacheability set to PORTLET may be generated" */
    {
      ResourceURL resurlTr17 = portletResp.createResourceURL();
      resurlTr17.setCacheability(PORTLET);
      resurlTr17.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET6");
      writer.write("<DIV id=\"tr17_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr17_ResourceServingCache','" + resurlTr17.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET7 */
    /* Details: "In a resource request resulting from triggering a */
    /* resource URL with cacheability set to PORTLET, setting */
    /* cacheability on a resource URL to PAGE results in an an */
    /* IllegalStateException" */
    {
      ResourceURL resurlTr18 = portletResp.createResourceURL();
      resurlTr18.setCacheability(PORTLET);
      resurlTr18.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET7");
      writer.write("<DIV id=\"tr18_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr18_ResourceServingCache','" + resurlTr18.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET8 */
    /* Details: "In a resource request resulting from triggering a */
    /* resource URL with cacheability set to PORTLET, an attempt to */
    /* create a render URL results in an an IllegalStateException" */
    {
      ResourceURL resurlTr19 = portletResp.createResourceURL();
      resurlTr19.setCacheability(PORTLET);
      resurlTr19.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET8");
      writer.write("<DIV id=\"tr19_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr19_ResourceServingCache','" + resurlTr19.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET9 */
    /* Details: "In a resource request resulting from triggering a */
    /* resource URL with cacheability set to PORTLET, an attempt to */
    /* create an action URL results in an an IllegalStateException" */
    {
      ResourceURL resurlTr20 = portletResp.createResourceURL();
      resurlTr20.setCacheability(PORTLET);
      resurlTr20.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET9");
      writer.write("<DIV id=\"tr20_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr20_ResourceServingCache','" + resurlTr20.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE1 */
    /* Details: "If the cache level is set to PAGE, the resource URL */
    /* contains the current render parameters" */
    {
      if (portletReq.getParameter("tr21") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tr21", "true");
        TestLink tl =
            new TestLink(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE1, purl);
        tl.writeTo(writer);
      } else {
        ResourceURL resurlTr21 = portletResp.createResourceURL();
        resurlTr21.setCacheability(PORTLET);
        resurlTr21.setParameter("action",
            "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE1");
        writer.write("<DIV id=\"tr21_ResourceServingCache\"></DIV>");
        writer.write("<script type=\"text/javascript\">");
        writer.write("getResource('tr21_ResourceServingCache','" + resurlTr21.toString() + "');");
        writer.write("</script>");
      }
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE2 */
    /* Details: "If the cache level is set to PAGE, the resource URL */
    /* contains the current PAGE mode" */
    {
      ResourceURL resurlTr22 = portletResp.createResourceURL();
      resurlTr22.setCacheability(PAGE);
      resurlTr22.setParameter("tr22", portletReq.getPortletMode().toString());
      resurlTr22.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE2");
      writer.write("<DIV id=\"tr22_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr22_ResourceServingCache','" + resurlTr22.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE3 */
    /* Details: "If the cache level is set to PAGE, the resource URL */
    /* contains the current window state" */
    {
      ResourceURL resurlTr23 = portletResp.createResourceURL();
      resurlTr23.setCacheability(PAGE);
      resurlTr23.setParameter("tr23", portletReq.getWindowState().toString());
      resurlTr23.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE3");
      writer.write("<DIV id=\"tr23_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr23_ResourceServingCache','" + resurlTr23.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE4 */
    /* Details: "If the cache level is set to PAGE, the resource URL */
    /* contains the current page state" */
    {
      if (portletReq.getParameter("tr24") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tr24", "true");
        TestLink tl =
            new TestLink(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE4, purl);
        tl.writeTo(writer);
      } else {
        ResourceURL resurlTr24 = portletResp.createResourceURL();
        resurlTr24.setCacheability(PAGE);
        resurlTr24.setParameter("tr24_windowState", portletReq.getWindowState().toString());
        resurlTr24.setParameter("action",
            "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE4");
        writer.write("<DIV id=\"tr24_ResourceServingCache\"></DIV>");
        writer.write("<script type=\"text/javascript\">");
        writer.write("getResource('tr24_ResourceServingCache','" + resurlTr24.toString() + "');");
        writer.write("</script>");
      }
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE5 */
    /* Details: "In a resource request resulting from triggering a */
    /* resource URL with cacheability set to PAGE, a resource URL with */
    /* cacheability set to FULL may be generated" */
    {
      ResourceURL resurlTr25 = portletResp.createResourceURL();
      resurlTr25.setCacheability(PAGE);
      resurlTr25.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE5");
      writer.write("<DIV id=\"tr25_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr25_ResourceServingCache','" + resurlTr25.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE6 */
    /* Details: "In a resource request resulting from triggering a */
    /* resource URL with cacheability set to PAGE, a resource URL with */
    /* cacheability set to PORTLET may be generated" */
    {
      ResourceURL resurlTr26 = portletResp.createResourceURL();
      resurlTr26.setCacheability(PAGE);
      resurlTr26.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE6");
      writer.write("<DIV id=\"tr26_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr26_ResourceServingCache','" + resurlTr26.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE7 */
    /* Details: "In a resource request resulting from triggering a */
    /* resource URL with cacheability set to PAGE, a resource URL with */
    /* cacheability set to PAGE may be generated" */
    {
      ResourceURL resurlTr27 = portletResp.createResourceURL();
      resurlTr27.setCacheability(PAGE);
      resurlTr27.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE7");
      writer.write("<DIV id=\"tr27_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr27_ResourceServingCache','" + resurlTr27.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE8 */
    /* Details: "In a resource request resulting from triggering a */
    /* resource URL with cacheability set to PAGE, a render URL may be */
    /* generated" */
    {
      ResourceURL resurlTr28 = portletResp.createResourceURL();
      resurlTr28.setCacheability(PAGE);
      resurlTr28.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE8");
      writer.write("<DIV id=\"tr28_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr28_ResourceServingCache','" + resurlTr28.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE9 */
    /* Details: "In a resource request resulting from triggering a */
    /* resource URL with cacheability set to PAGE, an action URL may be */
    /* generated" */
    {
      ResourceURL resurlTr29 = portletResp.createResourceURL();
      resurlTr29.setCacheability(PAGE);
      resurlTr29.setParameter("action",
          "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE9");
      writer.write("<DIV id=\"tr29_ResourceServingCache\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr29_ResourceServingCache','" + resurlTr29.toString() + "');");
      writer.write("</script>");
    }
  }

}
