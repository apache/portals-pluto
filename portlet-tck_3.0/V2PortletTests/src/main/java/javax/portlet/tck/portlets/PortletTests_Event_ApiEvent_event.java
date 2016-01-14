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

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.xml.namespace.QName;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import static javax.portlet.PortletSession.*;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, 
 * but does not publish them. Events are published in the main portlet for the test cases. 
 */
public class PortletTests_Event_ApiEvent_event implements Portlet, EventPortlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         PortletTests_Event_ApiEvent_event.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "event companion processAction - ERROR!!");
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "event companion serveResource - ERROR!!");
   }

   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "event companion processEvent");


      portletResp.setRenderParameters(portletReq);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletReq.getEvent().getClass());
      
      Event evt=portletReq.getEvent();
   
      /* TestCase: V2PortletTests_Event_ApiEvent_getQName1                    */
      /* Details: "Method getQName(): Returns the javax.xml.namespace.QName   */
      /* object for the Event"                                                */
      TestResult tr0 = tcd.getTestResultSucceeded(V2PORTLETTESTS_EVENT_APIEVENT_GETQNAME1);
      QName qn = evt.getQName();
      QName xmlqn = new QName("http://www.apache.org/portals/pluto/portlet-tck_3.0", "PortletTests_Event_ApiEvent");
      if (qn == null) {
         tr0.appendTcDetail("QName is null.");
      } else if (!qn.equals(xmlqn)) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("QName is not expected value.");
         txt.append(" Expected: ").append(xmlqn);
         txt.append(" Actual: ").append(qn);
         tr0.appendTcDetail(txt.toString());
      }
      tr0.writeTo(writer);

      /* TestCase: V2PortletTests_Event_ApiEvent_getQName2                    */
      /* Details: "Method getQName(): Returned value may not be null"         */
      TestResult tr1 = tcd.getTestResultSucceeded(V2PORTLETTESTS_EVENT_APIEVENT_GETQNAME2);
      QName qn1 = evt.getQName();
      if (qn1 == null) {
         tr0.appendTcDetail("QName is null.");
      } 
      tr1.writeTo(writer);
      
      /* TestCase: V2PortletTests_Event_ApiEvent_getName1                     */
      /* Details: "Method getName(): Returns a String containing the event    */
      /* local name"                                                          */
      TestResult tr2 = tcd.getTestResultSucceeded(V2PORTLETTESTS_EVENT_APIEVENT_GETNAME1);
      String qn2 = evt.getName();
      String evtname="PortletTests_Event_ApiEvent";
      if(qn2==null) {
    	  tr2.appendTcDetail("Local Part of Event name is Null.");
      } else if(!qn2.equals(evtname)) {
      StringBuilder txt = new StringBuilder(128);
      txt.append("EventName is not expected value.");
      txt.append(" Expected: ").append(evtname);
      txt.append(" Actual: ").append(qn2);
      tr2.appendTcDetail(txt.toString());
      }
      
      tr2.writeTo(writer);
      
      /* TestCase: V2PortletTests_Event_ApiEvent_getName2                     */
      /* Details: "Method getName(): Returned value may not be null"          */
      TestResult tr3 = tcd.getTestResultSucceeded(V2PORTLETTESTS_EVENT_APIEVENT_GETNAME2);
      if(qn2==null) {
    	  tr3.appendTcDetail("Event name is Null.");
      } 
      
      tr3.writeTo(writer);

      /* TestCase: V2PortletTests_Event_ApiEvent_getValue1                    */
      /* Details: "Method getValue(String, String): Returns a                 */
      /* java.io.Serializable object representing the event payload"          */
      TestResult tr4 = tcd.getTestResultFailed(V2PORTLETTESTS_EVENT_APIEVENT_GETVALUE1);
      try
      {
      Object val=evt.getValue();
      if ((val instanceof String)) {
    	  String txt = (String) val;
    	  if (txt.equals("Hi!")) {
            tr4.setTcSuccess(true);  
    	  } else {  
			tr4.appendTcDetail("The EventPayloadvalue did not match actual value :" + txt);	
    	    }
       } 
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);
      
      /* TestCase: V2PortletTests_Event_ApiEvent_getValue2                    */
      /* Details: "Method getValue(String, String): Returned value is null    */
      /* if the event has no payload"                                         */
      TestResult tr5 = tcd.getTestResultSucceeded(V2PORTLETTESTS_EVENT_APIEVENT_GETVALUE2);
      Serializable val1=evt.getValue();
      if(val1==null) {
    	  tr5.appendTcDetail("EventPayload is null");
      }
      tr5.writeTo(writer);
      
      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "PortletTests_Event_ApiEvent",
                   writer.toString(), APPLICATION_SCOPE);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      
      LOGGER.entering(LOG_CLASS, "event companion render");

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>PortletTests_Event_ApiEvent_event</p>\n");

      String msg = (String) portletReq.getPortletSession()
            .getAttribute(RESULT_ATTR_PREFIX + "PortletTests_Event_ApiEvent", APPLICATION_SCOPE);
      msg = (msg==null) ? "Not ready. click test case link." : msg;
      writer.write("<p>" + msg + "</p>\n");

   }

}
