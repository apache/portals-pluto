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
import javax.portlet.tck.beans.TestButton;
import javax.xml.namespace.QName;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETWINDOWSTATE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETWINDOWSTATE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsEvent_StateAwareResponse_SIGEvent_event
 *
 */
public class SigTestsEvent_StateAwareResponse_SIGEvent implements Portlet {

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

    QName eventQName = new QName(TCKNAMESPACE, "SigTestsEvent_StateAwareResponse_SIGEvent");
    portletResp.setEvent(eventQName, "Hi!");
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetPortletMode */
    /* Details: "EventResponse has a getPortletMode()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETPORTLETMODE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetPortletModeReturns */
    /* Details: "EventResponse method getPortletMode() returns */
    /* PortletMode " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetPortletModeReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetRenderParameterMap */
    /* Details: "EventResponse has a getRenderParameterMap()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetRenderParameterMap", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetRenderParameterMapReturns */
    /* Details: "EventResponse method getRenderParameterMap() returns */
    /* java.util.Map " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetRenderParameterMapReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetWindowState */
    /* Details: "EventResponse has a getWindowState()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETWINDOWSTATE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetWindowStateReturns */
    /* Details: "EventResponse method getWindowState() returns */
    /* WindowState " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetWindowStateReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasRemovePublicRenderParameter */
    /* Details: "EventResponse has a removePublicRenderParameter(String) */
    /* method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasRemovePublicRenderParameter", aurl);
      tb.writeTo(writer);
    }

    /*
     * TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasRemovePublicRenderParameterReturns
     */
    /* Details: "EventResponse method removePublicRenderParameter(String) */
    /* returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasRemovePublicRenderParameterReturns",
          aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEvent */
    /* Details: "EventResponse has a setEvent(javax.xml.namespace.QName, */
    /* java.io.Serializable) method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENT, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEventA */
    /* Details: "EventResponse has a setEvent(String, */
    /* java.io.Serializable) method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTA, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEventReturns */
    /* Details: "EventResponse method setEvent(javax.xml.namespace.QName, */
    /* java.io.Serializable) returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTRETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEventReturnsA */
    /* Details: "EventResponse method setEvent(String, */
    /* java.io.Serializable) returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTRETURNSA, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetPortletMode */
    /* Details: "EventResponse has a setPortletMode(PortletMode) throws */
    /* PortletModeException method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETPORTLETMODE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetPortletModeReturns */
    /* Details: "EventResponse method setPortletMode(PortletMode) returns */
    /* void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetPortletModeReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameter */
    /* Details: "EventResponse has a setRenderParameter(String, String) */
    /* method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETER, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterA */
    /* Details: "EventResponse has a setRenderParameter(String, String[]) */
    /* method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterA", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterReturns */
    /* Details: "EventResponse method setRenderParameter(String, String) */
    /* returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterReturnsA */
    /* Details: "EventResponse method setRenderParameter(String, */
    /* String[]) returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterReturnsA", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameters */
    /* Details: "EventResponse has a setRenderParameters(java.util.Map) */
    /* method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameters", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParametersReturns */
    /* Details: "EventResponse method setRenderParameters(java.util.Map) */
    /* returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParametersReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetWindowState */
    /* Details: "EventResponse has a setWindowState(WindowState) throws */
    /* WindowStateException method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETWINDOWSTATE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetWindowStateReturns */
    /* Details: "EventResponse method setWindowState(WindowState) returns */
    /* void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetWindowStateReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_implementsPortletResponse */
    /* Details: "EventResponse implements PortletResponse " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_StateAwareResponse_SIGEvent_implementsPortletResponse", aurl);
      tb.writeTo(writer);
    }

  }

}
