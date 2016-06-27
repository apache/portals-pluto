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
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.xml.namespace.QName;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_5_INITIALIZATION_INITIALIZATION6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_5_RENDERGENERICPORTLET_EVENTDISPATCHING2;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for
 * events, this portlet will initiate the events, but not process them. The
 * processing is done in the companion portlet
 * AddlPortletTests_SPEC2_5_RenderGenericPortlet_event
 * 
 * @author ahmed
 */
public class AddlPortletTests_SPEC2_5_RenderGenericPortlet
      extends GenericPortlet {

   @Override
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      QName eventQName = new QName(TCKNAMESPACE,
            "AddlPortletTests_SPEC2_5_RenderGenericPortlet");
      portletResp.setEvent(eventQName, "Hi!");

      portletResp.setEvent(
            "AddlPortletTests_SPEC2_5_RenderGenericPortlet_localPart", "Hi!");

      TestResult tr0 = tcd.getTestResultFailed(
            "V2AddlPortletTests_SPEC2_5_RenderGenericPortlet_actionDispatching2");
      try {
         super.processAction(portletReq, portletResp);
      } catch (PortletException e) {
         tr0.setTcSuccess(true);
         tr0.appendTcDetail(e.toString());
      }
      portletReq.getPortletSession().setAttribute(
            RESULT_ATTR_PREFIX
                  + "AddlPortletTests_SPEC2_5_RenderGenericPortlet",
            tr0.toString(), APPLICATION_SCOPE);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: V2AddlPortletTests_SPEC2_5_Initialization_initialization6 */
      /* Details: "A RuntimeException thrown during initialization must be */
      /* handled as a PortletException" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2ADDLPORTLETTESTS_SPEC2_5_INITIALIZATION_INITIALIZATION6);
      tr0.appendTcDetail(""
            + "<script>"
            + "   var initializationPortlet = document.getElementById('V2AddlPortletTests_SPEC2_5_Initialization_initialization6');"
            + "   if(initializationPortlet==null){"
            + "      document.getElementById('V2AddlPortletTests_SPEC2_5_Initialization_initialization6-result').innerHTML = 'Test Succeeded';"
            + "   }"
            + "</script>");
      tr0.writeTo(writer);

      /*
      /* TestCase: V2AddlPortletTests_SPEC2_5_RenderGenericPortlet_actionDispatching2
      /* Details: "If the ActionRequest.ACTION_NAME parameter is not set on */
      /* the action URL, the GenericPortlet processAction method will throw */
      /* a PortletException" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2AddlPortletTests_SPEC2_5_RenderGenericPortlet_actionDispatching2",
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V2AddlPortletTests_SPEC2_5_RenderGenericPortlet_eventDispatching1
       */
      /* Details: "The GenericPortlet processEvent method will dispatch the */
      /* request to a subclass method annotated with the tag */
      /* @ProcessEvent(qname=&lt;eventname&gt;), where &lt;eventname&gt; */
      /* must be in the format provided by Qname.toString()" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2AddlPortletTests_SPEC2_5_RenderGenericPortlet_eventDispatching1",
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V2AddlPortletTests_SPEC2_5_RenderGenericPortlet_eventDispatching2
       */
      /* Details: "The GenericPortlet processEvent method will dispatch the */
      /* request to a subclass method annotated with the tag */
      /* @ProcessEvent(name=&lt;event_name_local_part&gt;)" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2AddlPortletTests_SPEC2_5_RenderGenericPortlet_eventDispatching2",
               aurl);
         tb.writeTo(writer);
      }

   }

   @ProcessEvent(name = "AddlPortletTests_SPEC2_5_RenderGenericPortlet_localPart")
   public void processEvent(EventRequest portletReq, EventResponse response)
         throws PortletException, IOException {
      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      /*
       * TestCase:
       * V2AddlPortletTests_SPEC2_5_RenderGenericPortlet_eventDispatching2
       */
      /* Details: "The GenericPortlet processEvent method will dispatch the */
      /* request to a subclass method annotated with the tag */
      /* @ProcessEvent(name=&lt;event_name_local_part&gt;)" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2ADDLPORTLETTESTS_SPEC2_5_RENDERGENERICPORTLET_EVENTDISPATCHING2);
      tr2.setTcSuccess(true);
      portletReq.getPortletSession().setAttribute(
            RESULT_ATTR_PREFIX
                  + "AddlPortletTests_SPEC2_5_RenderGenericPortlet_event_b",
            tr2.toString(), APPLICATION_SCOPE);

   }

}
