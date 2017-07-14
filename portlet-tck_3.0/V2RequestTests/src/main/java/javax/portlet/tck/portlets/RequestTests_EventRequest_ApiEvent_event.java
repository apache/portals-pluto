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

import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_EVENTREQUEST_APIEVENT_GETEVENT;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_EVENTREQUEST_APIEVENT_GETMETHOD;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;
import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, 
 * but does not publish them. Events are published in the main portlet for the test cases. 
 */
public class RequestTests_EventRequest_ApiEvent_event implements Portlet, EventPortlet, ResourceServingPortlet {

   private final Logger LOGGER = LoggerFactory.getLogger(RequestTests_EventRequest_ApiEvent_event.class);

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
      QName eventQName = new QName(TCKNAMESPACE,
              "PortletTests_Event_ApiEvent");
       portletResp.setEvent(eventQName, "Hi!");
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("event companion serveResource - ERROR!!");
   }

   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("event companion processEvent");


      portletResp.setRenderParameters(portletReq);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

     

      /* TestCase: V2RequestTests_EventRequest_ApiEvent_getEvent              */
      /* Details: "Method getEvent(): Returns the Event object that           */
      /* triggered the call to the processEvent method"                       */
      TestResult tr0 = tcd.getTestResultFailed(V2REQUESTTESTS_EVENTREQUEST_APIEVENT_GETEVENT);
      Event evt=portletReq.getEvent();
      if(evt!=null) {
    	  tr0.setTcSuccess(true);
      } 
      tr0.writeTo(writer);

      /* TestCase: V2RequestTests_EventRequest_ApiEvent_getMethod             */
      /* Details: "Method getMethod(): Returns a String containing the name   */
      /* of the HTTP method with which the request was made"                  */
      TestResult tr1 = tcd.getTestResultFailed(V2REQUESTTESTS_EVENTREQUEST_APIEVENT_GETMETHOD);
      String getmethod=portletReq.getMethod();
      if(getmethod.equals("POST")) {
    	  tr1.setTcSuccess(true);
      } else {
    	  tr1.appendTcDetail("The getMethod() for HTTP Request has the value :" +getmethod);  
      }
      tr1.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "RequestTests_EventRequest_ApiEvent",
                   writer.toString(), APPLICATION_SCOPE);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      
      LOGGER.trace("event companion render");

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>RequestTests_EventRequest_ApiEvent_event</p>\n");

      String msg = (String) portletReq.getPortletSession()
            .getAttribute(RESULT_ATTR_PREFIX + "RequestTests_EventRequest_ApiEvent", APPLICATION_SCOPE);
      msg = (msg==null) ? "Not ready. click test case link." : msg;
      writer.write("<p>" + msg + "</p>\n");

   }

}
