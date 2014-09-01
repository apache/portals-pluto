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
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet AddlRequestTests_SPEC2_11_Event_event
 *
 */
public class AddlRequestTests_SPEC2_11_Event implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlRequestTests_SPEC2_11_Event.class.getName();
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
      LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      QName eventQName = new QName(TCKNAMESPACE,
             "AddlRequestTests_SPEC2_11_Event");
      portletResp.setEvent(eventQName, "Hi!");
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: V2AddlRequestTests_SPEC2_11_Event_parameters1              */
      /* Details: "If a portlet receives a request from a client request      */
      /* targeted to the portlet itself, the parameters must be the string    */
      /* parameters encoded in the URL (added when creating the PortletURL)   */
      /* and the string parameters sent by the client to the portlet as       */
      /* part of the client request"                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Event_parameters1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_Event_parameters2              */
      /* Details: "The parameters the request object returns must be          */
      /* \"x-www-form-urlencoded\" decoded"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Event_parameters2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_Event_parameters6              */
      /* Details: "The getParameterMap method must return an unmodifiable     */
      /* Map object"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Event_parameters6", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_Event_parameters12             */
      /* Details: "If a portlet receives an event that is the result of a     */
      /* client request targeted to another portlet in the portal page, the   */
      /* parameters should be the same parameters as of the previous render   */
      /* request from this client"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Event_parameters12", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_Event_publicRenderParameters15 */
      /* Details: "A map of private parameters can be obtained through the    */
      /* getPrivateParameterMap method"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Event_publicRenderParameters15", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_Event_publicRenderParameters16 */
      /* Details: "A map of public parameters can be obtained through the     */
      /* getPublicParameterMap method"                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Event_publicRenderParameters16", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_Event_publicRenderParameters5  */
      /* Details: "Public render parameters are available in the              */
      /* processEvent method"                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Event_publicRenderParameters5", aurl);
         tb.writeTo(writer);
      }

   }

}
