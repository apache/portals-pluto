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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_EVENT_APIEVENT_GETVALUE2;
import static javax.portlet.tck.constants.Constants.BUTTON_PARAM_NAME;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

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
import javax.portlet.tck.beans.TestButton;
import javax.xml.namespace.QName;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet PortletTests_Event_ApiEvent_event
 *
 */
public class PortletTests_Event_ApiEvent implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         PortletTests_Event_ApiEvent.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);
   
 
   @Override
   public void init(PortletConfig config) throws PortletException {
 
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      
      QName eventQName = new QName(TCKNAMESPACE,
             "PortletTests_Event_ApiEvent");
      String val = portletReq.getParameter(BUTTON_PARAM_NAME);
      if (val != null  && val.equals(V2PORTLETTESTS_EVENT_APIEVENT_GETVALUE2)) {  
            portletResp.setEvent(eventQName,null);
      }
      else { 
    	    portletResp.setEvent(eventQName,"Hi");
      }
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: V2PortletTests_Event_ApiEvent_getQName1                    */
      /* Details: "Method getQName(): Returns the javax.xml.namespace.QName   */
      /* object for the Event"                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTests_Event_ApiEvent_getQName1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTests_Event_ApiEvent_getQName2                    */
      /* Details: "Method getQName(): Returned value may not be null"         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTests_Event_ApiEvent_getQName2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTests_Event_ApiEvent_getName1                     */
      /* Details: "Method getName(): Returns a String containing the event    */
      /* local name"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTests_Event_ApiEvent_getName1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTests_Event_ApiEvent_getName2                     */
      /* Details: "Method getName(): Returned value may not be null"          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTests_Event_ApiEvent_getName2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTests_Event_ApiEvent_getValue1                    */
      /* Details: "Method getValue(String, String): Returns a                 */
      /* java.io.Serializable object representing the event payload"          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTests_Event_ApiEvent_getValue1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2PortletTests_Event_ApiEvent_getValue2                    */
      /* Details: "Method getValue(String, String): Returned value is null    */
      /* if the event has no payload"                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2PortletTests_Event_ApiEvent_getValue2", aurl);
         tb.writeTo(writer);
      }

   }

}
