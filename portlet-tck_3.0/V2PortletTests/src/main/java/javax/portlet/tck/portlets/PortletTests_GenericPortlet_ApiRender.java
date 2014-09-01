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
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
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
 * portlet PortletTests_GenericPortlet_ApiRender_event
 *
 */
public class PortletTests_GenericPortlet_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         PortletTests_GenericPortlet_ApiRender.class.getName();
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

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(GenericPortlet.class);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_initA              */
      /* Details: "Method init(): Called when the portlet is initialized"     */
      TestResult tr0 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_INITA);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_initB              */
      /* Details: "Method init(PortletConfig): Called when the portlet is     */
      /* initialized"                                                         */
      TestResult tr1 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_INITB);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_processAction1     */
      /* Details: "Method processAction(ActionRequest, ActionResponse): If    */
      /* overridden, the Portlet.processAction tests execute correctly"       */
      TestResult tr2 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSACTION1);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_processAction2     */
      /* Details: "Method processAction(ActionRequest, ActionResponse):       */
      /* Dispatches to @ProcessAction annotated method matching the           */
      /* ActionRequest.ACTION_NAME parameter"                                 */
      TestResult tr3 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSACTION2);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_processAction3     */
      /* Details: "Method processAction(ActionRequest, ActionResponse):       */
      /* Throws PortletException if no matching @ProcessAction annotated      */
      /* method found"                                                        */
      TestResult tr4 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSACTION3);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_render1            */
      /* Details: "Method render(RenderRequest, RenderResponse): If           */
      /* overridden, Portlet.render tests execute correctly"                  */
      TestResult tr5 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_RENDER1);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_render2            */
      /* Details: "Method render(RenderRequest, RenderResponse): If           */
      /* RENDER_PART=null, Calls the doHeaders(RenderRequest,                 */
      /* RenderResponse): method"                                             */
      TestResult tr6 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_RENDER2);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_render3            */
      /* Details: "Method render(RenderRequest, RenderResponse): If           */
      /* RENDER_PART=null, Sets the title on RenderResponse with the value    */
      /* returned by the getTitle(RenderRequest): method"                     */
      TestResult tr7 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_RENDER3);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_render4            */
      /* Details: "Method render(RenderRequest, RenderResponse): If           */
      /* RENDER_PART=null, Retrieves the next possible portlet modes from     */
      /* the PortletConfig and sets them on the RenderResponse"               */
      TestResult tr8 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_RENDER4);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_render5            */
      /* Details: "Method render(RenderRequest, RenderResponse): If           */
      /* RENDER_PART=null, Calls the DoDispatch(RenderRequest,                */
      /* RenderResponse): method "                                            */
      TestResult tr9 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_RENDER5);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_render6            */
      /* Details: "Method render(RenderRequest, RenderResponse): If           */
      /* RENDER_PART=RENDER_HEADERS, Calls the doHeaders(RenderRequest,       */
      /* RenderResponse): method"                                             */
      TestResult tr10 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_RENDER6);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_render7            */
      /* Details: "Method render(RenderRequest, RenderResponse): If           */
      /* RENDER_PART=RENDER_HEADERS, Sets the title on RenderResponse with    */
      /* the value returned by the getTitle(RenderRequest): method"           */
      TestResult tr11 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_RENDER7);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_render8            */
      /* Details: "Method render(RenderRequest, RenderResponse): If           */
      /* RENDER_PART=RENDER_HEADERS, Retrieves the next possible portlet      */
      /* modes from the PortletConfig and sets them on the RenderResponse"    */
      TestResult tr12 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_RENDER8);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_render9            */
      /* Details: "Method render(RenderRequest, RenderResponse): If           */
      /* RENDER_PART=RENDER_MARKUP, Calls the DoDispatch(RenderRequest,       */
      /* RenderResponse): method "                                            */
      TestResult tr13 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_RENDER9);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_render10           */
      /* Details: "Method render(RenderRequest, RenderResponse): If           */
      /* RENDER_PART=&lt;any other value&gt;, throws PortletException "       */
      TestResult tr14 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_RENDER10);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getTitle1          */
      /* Details: "Method getTitle(): If overridden, the String returned by   */
      /* this method is used as the portlet title"                            */
      TestResult tr15 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETTITLE1);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getTitle2          */
      /* Details: "Method getTitle(): Returns a String containing the title   */
      /* from the portlet resource bundle under the key                       */
      /* \"javax.portlet.title\""                                             */
      TestResult tr16 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETTITLE2);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getTitle3          */
      /* Details: "Method getTitle(): Returns null if no title is available   */
      /* from the portlet resource bundle"                                    */
      TestResult tr17 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETTITLE3);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doDispatch1        */
      /* Details: "Method doDispatch(RenderRequest, RenderResponse): If       */
      /* overridden, is called when markup is to be generated"                */
      TestResult tr18 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DODISPATCH1);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doDispatch2        */
      /* Details: "Method doDispatch(RenderRequest, RenderResponse): If not   */
      /* overridden, If the WindowState is minimized, no markup method is     */
      /* called and no markup is generated"                                   */
      TestResult tr19 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DODISPATCH2);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doDispatch3        */
      /* Details: "Method doDispatch(RenderRequest, RenderResponse): If not   */
      /* overridden and not minimized, the @RenderMode annotated method       */
      /* matching the current PortletMode is called "                         */
      TestResult tr20 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DODISPATCH3);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doDispatch4        */
      /* Details: "Method doDispatch(RenderRequest, RenderResponse): If not   */
      /* overridden, not minimized, and no annotated method is found, if      */
      /* the current render mode is \"view\", the doView(RenderRequest,       */
      /* RenderResponse): method is called  "                                 */
      TestResult tr21 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DODISPATCH4);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doDispatch5        */
      /* Details: "Method doDispatch(RenderRequest, RenderResponse): If not   */
      /* overridden, not minimized, and no annotated method is found, if      */
      /* the current render mode is \"edit\", the doEdit(RenderRequest,       */
      /* RenderResponse): method is called  "                                 */
      TestResult tr22 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DODISPATCH5);
      /* TODO: implement test */
      tr22.appendTcDetail("Not implemented.");
      tr22.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doDispatch6        */
      /* Details: "Method doDispatch(RenderRequest, RenderResponse): If not   */
      /* overridden, not minimized, and no annotated method is found, if      */
      /* the current render mode is \"help\", the doHelp(RenderRequest,       */
      /* RenderResponse): method is called  "                                 */
      TestResult tr23 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DODISPATCH6);
      /* TODO: implement test */
      tr23.appendTcDetail("Not implemented.");
      tr23.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doDispatch7        */
      /* Details: "Method doDispatch(RenderRequest, RenderResponse): If not   */
      /* overridden not minimized, no annotated method is found, ant the      */
      /* mode is not \"view\", \"edit\", or \"help\", throws a                */
      /* PortletException"                                                    */
      TestResult tr24 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DODISPATCH7);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doView1            */
      /* Details: "Method doView(RenderRequest, RenderResponse): If           */
      /* overridden, is called when a render request in view mode occurs"     */
      TestResult tr25 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOVIEW1);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doView2            */
      /* Details: "Method doView(RenderRequest, RenderResponse): If not       */
      /* overridden, throws a PortletException"                               */
      TestResult tr26 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOVIEW2);
      /* TODO: implement test */
      tr26.appendTcDetail("Not implemented.");
      tr26.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doEdit1            */
      /* Details: "Method doEdit(RenderRequest, RenderResponse): If           */
      /* overridden, is called when a render request in edit mode occurs"     */
      TestResult tr27 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOEDIT1);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doEdit2            */
      /* Details: "Method doEdit(RenderRequest, RenderResponse): If not       */
      /* overridden, throws a PortletException"                               */
      TestResult tr28 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOEDIT2);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doHelp1            */
      /* Details: "Method doHelp(RenderRequest, RenderResponse): If           */
      /* overridden, is called when a render request in help mode occurs"     */
      TestResult tr29 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOHELP1);
      /* TODO: implement test */
      tr29.appendTcDetail("Not implemented.");
      tr29.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doHelp2            */
      /* Details: "Method doHelp(RenderRequest, RenderResponse): If not       */
      /* overridden, throws a PortletException"                               */
      TestResult tr30 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOHELP2);
      /* TODO: implement test */
      tr30.appendTcDetail("Not implemented.");
      tr30.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getPortletConfig   */
      /* Details: "Method getPortletConfig(): Returns the PortletConfig       */
      /* object for the portlet"                                              */
      TestResult tr31 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETPORTLETCONFIG);
      /* TODO: implement test */
      tr31.appendTcDetail("Not implemented.");
      tr31.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_destroy            */
      /* Details: "Method destroy(): Called by the portlet container to       */
      /* indicate to a portlet that the portlet is being taken out of         */
      /* service. "                                                           */
      TestResult tr32 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DESTROY);
      /* TODO: implement test */
      tr32.appendTcDetail("Not implemented.");
      tr32.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_serveResource1     */
      /* Details: "Method serveResource(ResourceRequest, ResourceResponse):   */
      /* Is called when a ResourceURL targeting the portlet is triggered"     */
      TestResult tr33 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_SERVERESOURCE1);
      /* TODO: implement test */
      tr33.appendTcDetail("Not implemented.");
      tr33.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_serveResource2     */
      /* Details: "Method serveResource(ResourceRequest, ResourceResponse):   */
      /* Forwards the request to the ResourceID value if the method is not    */
      /* overridden and if the resource ID is not null"                       */
      TestResult tr34 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_SERVERESOURCE2);
      /* TODO: implement test */
      tr34.appendTcDetail("Not implemented.");
      tr34.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_serveResource3     */
      /* Details: "Method serveResource(ResourceRequest, ResourceResponse):   */
      /* Does nothing if the method is not overridden and if the resource     */
      /* ID is null"                                                          */
      TestResult tr35 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_SERVERESOURCE3);
      /* TODO: implement test */
      tr35.appendTcDetail("Not implemented.");
      tr35.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_processEvent1      */
      /* Details: "Method processEvent(EventRequest, EventResponse): Is       */
      /* called when an Event targeting the portlet occurs"                   */
      TestResult tr36 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSEVENT1);
      /* TODO: implement test */
      tr36.appendTcDetail("Not implemented.");
      tr36.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_processEvent2      */
      /* Details: "Method processEvent(EventRequest, EventResponse): The      */
      /* @ProcessEvent annotated method matching the current Event is         */
      /* called "                                                             */
      TestResult tr37 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSEVENT2);
      /* TODO: implement test */
      tr37.appendTcDetail("Not implemented.");
      tr37.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_processEvent3      */
      /* Details: "Method processEvent(EventRequest, EventResponse): If       */
      /* there is no matching annotated method, sets the render parameters    */
      /* on the EventResponse to equal the EventRequest parameters"           */
      TestResult tr38 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSEVENT3);
      /* TODO: implement test */
      tr38.appendTcDetail("Not implemented.");
      tr38.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doHeaders1         */
      /* Details: "Method doHeaders(RenderRequest, RenderResponse): Is        */
      /* called during generic portlet render request processing  "           */
      TestResult tr39 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOHEADERS1);
      /* TODO: implement test */
      tr39.appendTcDetail("Not implemented.");
      tr39.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doHeaders2         */
      /* Details: "Method doHeaders(RenderRequest, RenderResponse): The       */
      /* default implementation does nothing"                                 */
      TestResult tr40 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOHEADERS2);
      /* TODO: implement test */
      tr40.appendTcDetail("Not implemented.");
      tr40.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getNextPossiblePortletModes1 */
      /* Details: "Method getNextPossiblePortletModes(): Is called during     */
      /* generic portlet render request processing"                           */
      TestResult tr41 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETNEXTPOSSIBLEPORTLETMODES1);
      /* TODO: implement test */
      tr41.appendTcDetail("Not implemented.");
      tr41.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getNextPossiblePortletModes2 */
      /* Details: "Method getNextPossiblePortletModes(): The default          */
      /* implementation returns null"                                         */
      TestResult tr42 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETNEXTPOSSIBLEPORTLETMODES2);
      /* TODO: implement test */
      tr42.appendTcDetail("Not implemented.");
      tr42.writeTo(writer);

   }

}
