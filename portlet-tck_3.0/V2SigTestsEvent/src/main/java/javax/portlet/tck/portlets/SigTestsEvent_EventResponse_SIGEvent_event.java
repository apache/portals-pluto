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

package javax.portlet.tck.portlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.StateAwareResponse;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_EVENTRESPONSE_SIGEVENT_HASSETRENDERPARAMETERS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_EVENTRESPONSE_SIGEVENT_HASSETRENDERPARAMETERSRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_EVENTRESPONSE_SIGEVENT_IMPLEMENTSSTATEAWARERESPONSE;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, 
 * but does not publish them. Events are published in the main portlet for the test cases. 
 */
public class SigTestsEvent_EventResponse_SIGEvent_event implements Portlet, EventPortlet {

   private final Logger LOGGER = LoggerFactory.getLogger(SigTestsEvent_EventResponse_SIGEvent_event.class);

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("event companion processAction - ERROR!!");
   }

   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
         throws PortletException, IOException {


      portletResp.setRenderParameters(portletReq);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletResp.getClass());

      /* TestCase: V2SigTestsEvent_EventResponse_SIGEvent_hasSetRenderParameters */
      /* Details: "EventResponse has a setRenderParameters(EventRequest)      */
      /* method "                                                             */
      TestResult tr0 = tcd.getTestResultFailed(V2SIGTESTSEVENT_EVENTRESPONSE_SIGEVENT_HASSETRENDERPARAMETERS);
      try {
         String name = "setRenderParameters";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {EventRequest.class};
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2SigTestsEvent_EventResponse_SIGEvent_hasSetRenderParametersReturns */
      /* Details: "EventResponse method setRenderParameters(EventRequest)     */
      /* returns void "                                                       */
      TestResult tr1 = tcd.getTestResultFailed(V2SIGTESTSEVENT_EVENTRESPONSE_SIGEVENT_HASSETRENDERPARAMETERSRETURNS);
      try {
         String name = "setRenderParameters";
         Class<?> retType = void.class;
         Class<?>[] parms = {EventRequest.class};
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2SigTestsEvent_EventResponse_SIGEvent_implementsStateAwareResponse */
      /* Details: "EventResponse implements StateAwareResponse "              */
      TestResult tr2 = tcd.getTestResultFailed(V2SIGTESTSEVENT_EVENTRESPONSE_SIGEVENT_IMPLEMENTSSTATEAWARERESPONSE);
      try {
         tr2.setTcSuccess(cc.implementsInterface(StateAwareResponse.class));
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "SigTestsEvent_EventResponse_SIGEvent",
                   writer.toString(), APPLICATION_SCOPE);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>SigTestsEvent_EventResponse_SIGEvent_event</p>\n");

      String msg = (String) portletReq.getPortletSession()
            .getAttribute(RESULT_ATTR_PREFIX + "SigTestsEvent_EventResponse_SIGEvent", APPLICATION_SCOPE);
      msg = (msg==null) ? "Not ready. click test case link." : msg;
      writer.write("<p>" + msg + "</p>\n");

   }

}
