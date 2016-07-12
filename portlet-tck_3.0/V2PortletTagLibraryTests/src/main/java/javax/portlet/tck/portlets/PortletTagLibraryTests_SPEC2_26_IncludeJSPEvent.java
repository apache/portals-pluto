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

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS8;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS9;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS10;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS11;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS12;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS13;
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
 * PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_event
 * 
 * @author ahmed
 */
public class PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent implements Portlet {

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

    QName eventQName = new QName(TCKNAMESPACE, "PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent");
    portletResp.setEvent(eventQName, "Hi!");
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects1 */
    /* Details: "When included in the Event phase, the defineObjects tag */
    /* defines the variable RenderRequest renderRequest to be null or */
    /* undefined" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS1, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects2 */
    /* Details: "When included in the Event phase, the defineObjects tag */
    /* defines the variable ResourceRequest resourceRequest to be null or */
    /* undefined" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS2, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects3 */
    /* Details: "When included in the Event phase, the defineObjects tag */
    /* defines the variable ActionRequest actionRequest to be null or */
    /* undefined" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS3, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects4 */
    /* Details: "When included in the Event phase, the defineObjects tag */
    /* defines the variable EventRequest eventRequest to the */
    /* corresponding object" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS4, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects5 */
    /* Details: "When included in the Event phase, the defineObjects tag */
    /* defines the variable RenderResponse renderResponse to be null or */
    /* undefined" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS5, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects6 */
    /* Details: "When included in the Event phase, the defineObjects tag */
    /* defines the variable ResourceResponse resourceResponse to be null */
    /* or undefined" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS6, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects7 */
    /* Details: "When included in the Event phase, the defineObjects tag */
    /* defines the variable ActionResponse actionResponse to be null or */
    /* undefined" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS7, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects8 */
    /* Details: "When included in the Event phase, the defineObjects tag */
    /* defines the variable EventResponse eventResponse to the */
    /* corresponding object" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS8, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects9 */
    /* Details: "When included in the Event phase, the defineObjects tag */
    /* defines the variable PortletConfig portletConfig" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS9, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects10 */
    /* Details: "When included in the Event phase, the defineObjects tag */
    /* defines the variable PortletSession portletSession, providing */
    /* access to the portletSession, does not create a new session, only */
    /* returns an existing session or null if no session exists." */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS10, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects11 */
    /* Details: "When included in the Event phase, the defineObjects tag */
    /* defines the variable Map&lt;String, Object&gt; */
    /* portletSessionScope, providing access to the portletSession */
    /* attributes as a Map equivalent to the */
    /* PortletSession.getAttributeMap() call, does not create a new */
    /* session, only returns an existing session. If no session */
    /* attributes exist this method returns an empty Map." */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS11, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects12 */
    /* Details: "When included in the Event phase, the defineObjects tag */
    /* defines the variable PortletPreferences portletPreferences, */
    /* providing access to the portlet preferences." */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS12, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects13 */
    /* Details: "When included in the Event phase, the defineObjects tag */
    /* defines the variable Map&lt;String, String[]&gt; */
    /* portletPreferencesValues, providing access to the portlet */
    /* preferences as a Map, equivalent to the */
    /* PortletPreferences.getMap() call. If no portlet preferences exist, */
    /* the Map is empty." */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS13, aurl);
      tb.writeTo(writer);
    }

  }

}
