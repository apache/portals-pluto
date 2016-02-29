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
public class PortletTests_GenericPortlet_ApiRender extends GenericPortlet {
   private static final String LOG_CLASS = 
         PortletTests_GenericPortlet_ApiRender.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);
   
   private boolean initCalled = false;
   
   @Override
   public void init() {
	   initCalled = true;
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

      
      
      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getPortletConfig   */
      /* Details: "Method getPortletConfig(): Returns the PortletConfig       */
      /* object for the portlet"                                              */
      TestResult tr31 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETPORTLETCONFIG);
      String pc=getPortletConfig().getPortletName();
      if(pc.equals("PortletTests_GenericPortlet_ApiRender")) {
    	  tr31.setTcSuccess(true);
      } else {
    	  tr31.appendTcDetail("The PortletName does not match the actual name :"+pc.toString());
      }
      tr31.writeTo(writer);
      
      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_initA              */
      /* Details: "Method init(): Called when the portlet is initialized"     */
      TestResult tr0 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_INITA);
      if(this.initCalled==true) {
    	  tr0.setTcSuccess(true);
      }
      tr0.writeTo(writer);
      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_initB              */
      /* Details: "Method init(PortletConfig): Called when the portlet is     */
      /* initialized"                                                         */
      TestResult tr1 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_INITB);
      

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_processAction1     */
      /* Details: "Method processAction(ActionRequest, ActionResponse): If    */
      /* overridden, the Portlet.processAction tests execute correctly"       */
      TestResult tr2 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSACTION1);
      try {
          String name = "processAction";
          Class<?> retType = void.class;
          Class<?>[] parms = {ActionRequest.class, ActionResponse.class};
          tr2.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
       } catch(Exception e) {tr2.appendTcDetail(e.toString());}
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
      try {
          String name = "processAction";
          Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
          Class<?>[] parms = {ActionRequest.class, ActionResponse.class};
          tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
       } catch(Exception e) {tr4.appendTcDetail(e.toString());}
       tr4.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_render1            */
      /* Details: "Method render(RenderRequest, RenderResponse): If           */
      /* overridden, Portlet.render tests execute correctly"                  */
      TestResult tr5 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_RENDER1);
      try {
          String name = "render";
          Class<?> retType = void.class;
          Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
          tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
       } catch(Exception e) {tr5.appendTcDetail(e.toString());}
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
      try {
          String name = "render";
          Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
          Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
          tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
       } catch(Exception e) {tr14.appendTcDetail(e.toString());}
       tr14.writeTo(writer);
       
      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getTitle1          */
      /* Details: "Method getTitle(): If overridden, the String returned by   */
      /* this method is used as the portlet title"                            */
      TestResult tr15 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETTITLE1);
      try {
          String name = "getTitle";
          Class<?>[] exceptions = null;
          Class<?>[] parms = {RenderRequest.class};
          tr15.setTcSuccess(cc.hasMethod(name, parms, exceptions));
       } catch(Exception e) {tr15.appendTcDetail(e.toString());}
       tr15.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getTitle2          */
      /* Details: "Method getTitle(): Returns a String containing the title   */
      /* from the portlet resource bundle under the key                       */
      /* \"javax.portlet.title\""                                             */
      TestResult tr16 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETTITLE2);
      try {
          String name = "getTitle";
          Class<?> retType = String.class;
          Class<?>[] parms = {RenderRequest.class};
          tr16.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
       } catch(Exception e) {tr16.appendTcDetail(e.toString());}
       tr16.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getTitle3          */
      /* Details: "Method getTitle(): Returns null if no title is available   */
      /* from the portlet resource bundle"                                    */
      TestResult tr17 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETTITLE3);
      try {
          String name = "getTitle";
          Class<?> retType = null;
          Class<?>[] parms = {RenderRequest.class};
          tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
       } catch(Exception e) {tr17.appendTcDetail(e.toString());}
       tr17.writeTo(writer);
      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doDispatch1        */
      /* Details: "Method doDispatch(RenderRequest, RenderResponse): If       */
      /* overridden, is called when markup is to be generated"                */
      TestResult tr18 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DODISPATCH1);
      try {
          String name = "doDispatch";
          Class<?> retType = void.class;
          Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
          tr18.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
       } catch(Exception e) {tr18.appendTcDetail(e.toString());}
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
      try {
          String name = "doDispatch";
          Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
          Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
          tr24.setTcSuccess(cc.hasMethod(name, parms, exceptions));
       } catch(Exception e) {tr24.appendTcDetail(e.toString());}
       tr24.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doView1            */
      /* Details: "Method doView(RenderRequest, RenderResponse): If           */
      /* overridden, is called when a render request in view mode occurs"     */
      TestResult tr25 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOVIEW1);
      try {
          String name = "doView";
          Class<?> retType = void.class;
          Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
          tr25.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
       } catch(Exception e) {tr25.appendTcDetail(e.toString());}
       tr25.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doView2            */
      /* Details: "Method doView(RenderRequest, RenderResponse): If not       */
      /* overridden, throws a PortletException"                               */
      TestResult tr26 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOVIEW2);
      try {
          String name = "doView";
          Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
          Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
          tr26.setTcSuccess(cc.hasMethod(name, parms, exceptions));
       } catch(Exception e) {tr26.appendTcDetail(e.toString());}
       tr26.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doEdit1            */
      /* Details: "Method doEdit(RenderRequest, RenderResponse): If           */
      /* overridden, is called when a render request in edit mode occurs"     */
      TestResult tr27 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOEDIT1);
      try {
          String name = "doEdit";
          Class<?> retType = void.class;
          Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
          tr27.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
       } catch(Exception e) {tr27.appendTcDetail(e.toString());}
       tr27.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doEdit2            */
      /* Details: "Method doEdit(RenderRequest, RenderResponse): If not       */
      /* overridden, throws a PortletException"                               */
      TestResult tr28 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOEDIT2);
      try {
          String name = "doEdit";
          Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
          Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
          tr28.setTcSuccess(cc.hasMethod(name, parms, exceptions));
       } catch(Exception e) {tr28.appendTcDetail(e.toString());}
       tr28.writeTo(writer);


      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doHelp1            */
      /* Details: "Method doHelp(RenderRequest, RenderResponse): If           */
      /* overridden, is called when a render request in help mode occurs"     */
      TestResult tr29 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOHELP1);
      try {
          String name = "doHelp";
          Class<?> retType = void.class;
          Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
          tr29.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
       } catch(Exception e) {tr29.appendTcDetail(e.toString());}
       tr29.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doHelp2            */
      /* Details: "Method doHelp(RenderRequest, RenderResponse): If not       */
      /* overridden, throws a PortletException"                               */
      TestResult tr30 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOHELP2);
      try {
          String name = "doHelp";
          Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
          Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
          tr30.setTcSuccess(cc.hasMethod(name, parms, exceptions));
       } catch(Exception e) {tr30.appendTcDetail(e.toString());}
       tr30.writeTo(writer);


      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_destroy            */
      /* Details: "Method destroy(): Called by the portlet container to       */
      /* indicate to a portlet that the portlet is being taken out of         */
      /* service. "                                                           */
      TestResult tr32 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DESTROY);
      try {
          String name = "destroy";
          Class<?> retType = void.class;
          Class<?>[] parms = null;
          tr32.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
       } catch(Exception e) {tr32.appendTcDetail(e.toString());}
       tr32.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_serveResource1     */
      /* Details: "Method serveResource(ResourceRequest, ResourceResponse):   */
      /* Is called when a ResourceURL targeting the portlet is triggered"     */
      TestResult tr33 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_SERVERESOURCE1);
      try {
          String name = "serveResource";
          Class<?> retType = void.class;
          Class<?>[] parms = {ResourceRequest.class, ResourceResponse.class};
          tr33.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
       } catch(Exception e) {tr33.appendTcDetail(e.toString());}
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
      try {
          String name = "processEvent";
          Class<?> retType = void.class;
          Class<?>[] parms = {EventRequest.class, EventResponse.class};
          tr36.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
       } catch(Exception e) {tr36.appendTcDetail(e.toString());}
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
      try {
          String name = "doHeaders";
          Class<?>[] exceptions = null;
          Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
          tr39.setTcSuccess(cc.hasMethod(name, parms, exceptions));
       } catch(Exception e) {tr39.appendTcDetail(e.toString());}
       tr39.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doHeaders2         */
      /* Details: "Method doHeaders(RenderRequest, RenderResponse): The       */
      /* default implementation does nothing"                                 */
      TestResult tr40 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOHEADERS2);
      try {
          String name = "doHeaders";
          Class<?> retType = void.class;
          Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
          tr40.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
       } catch(Exception e) {tr40.appendTcDetail(e.toString());}
       tr40.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getNextPossiblePortletModes1 */
      /* Details: "Method getNextPossiblePortletModes(): Is called during     */
      /* generic portlet render request processing"                           */
      TestResult tr41 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETNEXTPOSSIBLEPORTLETMODES1);
      try {
          String name = "getNextPossiblePortletModes";
          Class<?> retType = java.util.Collection.class;
          Class<?>[] parms = {RenderRequest.class};
          tr41.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
       } catch(Exception e) {tr41.appendTcDetail(e.toString());}
       tr41.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getNextPossiblePortletModes2 */
      /* Details: "Method getNextPossiblePortletModes(): The default          */
      /* implementation returns null"                                         */
      TestResult tr42 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETNEXTPOSSIBLEPORTLETMODES2);
      try {
          String name = "getNextPossiblePortletModes";
          Class<?>[] exceptions = null;
          Class<?>[] parms = {RenderRequest.class};
          tr42.setTcSuccess(cc.hasMethod(name, parms, exceptions));
       } catch(Exception e) {tr42.appendTcDetail(e.toString());}
       tr42.writeTo(writer);
   }

}
