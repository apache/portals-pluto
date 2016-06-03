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

import java.io.*;
import java.util.logging.*;
import javax.xml.namespace.QName;
import javax.portlet.*;
import javax.portlet.tck.beans.*;
import static javax.portlet.tck.constants.Constants.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlRequestTests_SPEC2_11_EventReq_event
 * @author ahmed
 */
public class AddlRequestTests_SPEC2_11_EventReq implements Portlet {
  private static final String LOG_CLASS = AddlRequestTests_SPEC2_11_EventReq.class.getName();
  private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {
    LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

    portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    QName eventQName = new QName(TCKNAMESPACE, "AddlRequestTests_SPEC2_11_EventReq");
    portletResp.setEvent(eventQName, "Hi!");
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {
    LOGGER.entering(LOG_CLASS, "main portlet render entry");

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_contentType1 */
    /* Details: "The getResponseContentType method returns a String */
    /* representing the default content type the portlet container */
    /* assumes for the output" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_EventReq_contentType1", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_contentType2 */
    /* Details: "The getResponseContentTypes method returns an */
    /* Enumeration of String elements representing the acceptable content */
    /* types for the output in order of preference" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_EventReq_contentType2", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_contentType3 */
    /* Details: "The first element of the Enumeration returned by the */
    /* getResponseContentTypes method must equal the value returned by */
    /* the getResponseContentType method" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_EventReq_contentType3", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_contentType4 */
    /* Details: "If a portlet defines support for all content types using */
    /* a wildcard and the portlet container supports all content types, */
    /* the getResponseContentType may return the wildcard" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_EventReq_contentType4", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_contentType5 */
    /* Details: "If a portlet defines support for all content types using */
    /* a wildcard and the portlet container supports all content types, */
    /* the getResponseContentType may return the preferred content type" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_EventReq_contentType5", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_windowId4 */
    /* Details: "The string returned by getWindowID method must be the */
    /* same ID used for scoping portlet-scope session attributes" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_EventReq_windowId4", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_contentType8 */
    /* Details: "Within the processEvent method, the content type must */
    /* include only the MIME type, not the character set" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_EventReq_contentType8", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_EventReq_contentType9 */
    /* Details: "Within the processEvent method, the */
    /* getResponseContentTypes method must return only the content types */
    /* supported by the current portlet mode" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_EventReq_contentType9", aurl);
      tb.writeTo(writer);
    }

  }

}
