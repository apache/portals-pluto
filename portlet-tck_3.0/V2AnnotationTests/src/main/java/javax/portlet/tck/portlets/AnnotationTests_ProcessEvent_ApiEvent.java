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

import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ANNOTATIONTESTS_PROCESSEVENT_APIEVENT_QNAME;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ANNOTATIONTESTS_PROCESSEVENT_APIEVENT_NAME;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.TestButton;
import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AnnotationTests_ProcessEvent_ApiEvent_event
 *
 */
public class AnnotationTests_ProcessEvent_ApiEvent extends GenericPortlet {

  @SuppressWarnings("unused")
  private final Logger LOGGER = LoggerFactory.getLogger(AnnotationTests_ProcessEvent_ApiEvent.class);

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {

    portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    if (portletReq.getParameter(BUTTON_PARAM_NAME)
        .startsWith(V2ANNOTATIONTESTS_PROCESSEVENT_APIEVENT_QNAME)) {
      QName eventQName = new QName(TCKNAMESPACE, "AnnotationTests_ProcessEvent_ApiEvent");
      portletResp.setEvent(eventQName, "Hi!");
      LOGGER.trace("Firing event: {}", eventQName.toString());
    } else if (portletReq.getParameter(BUTTON_PARAM_NAME)
        .startsWith(V2ANNOTATIONTESTS_PROCESSEVENT_APIEVENT_NAME)) {
      portletResp.setEvent("AnnotationTests_ProcessEvent_ApiEvent2", "Hi!");
      LOGGER.trace("Firing event: AnnotationTests_ProcessEvent_ApiEvent2");
    }
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    /* TestCase: V2AnnotationTests_ProcessEvent_ApiEvent_qname */
    /* Details: "Method qname(): On an event request, the method is */
    /* executed if the Event qname matches the qname field" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ANNOTATIONTESTS_PROCESSEVENT_APIEVENT_QNAME, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AnnotationTests_ProcessEvent_ApiEvent_name */
    /* Details: "Method name(): On an event request, the method is */
    /* executed if the Event name matches the name field" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ANNOTATIONTESTS_PROCESSEVENT_APIEVENT_NAME, aurl);
      tb.writeTo(writer);
    }

  }

}
