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
 * portlet URLTests_PortletURLGenerationListener_ApiRender_event
 *
 */
public class URLTests_PortletURLGenerationListener_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         URLTests_PortletURLGenerationListener_ApiRender.class.getName();
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

      ClassChecker cc = new ClassChecker(PortletURLGenerationListener.class);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRender_configuration */
      /* Details: "A PortletURLGenerationListener can be configured in the    */
      /* portlet deployment descriptor"                                       */
      TestResult tr0 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDER_CONFIGURATION);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRender_filterActionURL1 */
      /* Details: "Method filterActionURL(PortletURL): The                    */
      /* filterActionURL(PortletURL): method is called before the toString    */
      /* or write methods are executed on an action URL"                      */
      TestResult tr1 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDER_FILTERACTIONURL1);
      try {
         PortletURL turl = portletResp.createRenderURL();
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRender_filterActionURL2 */
      /* Details: "Method filterActionURL(PortletURL): The filterActionURL    */
      /* method is passed the PortletURL object representing the action       */
      /* URL"                                                                 */
      TestResult tr2 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDER_FILTERACTIONURL2);
      try {
         PortletURL turl = portletResp.createRenderURL();
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRender_filterActionURL3 */
      /* Details: "Method filterActionURL(PortletURL): The input action URL   */
      /* object can be modified by setting a parameter and the modified URL   */
      /* object is processed by the PortletURL toString or write method"      */
      TestResult tr3 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDER_FILTERACTIONURL3);
      try {
         PortletURL turl = portletResp.createRenderURL();
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRender_filterActionURL4 */
      /* Details: "Method filterActionURL(PortletURL): The input action URL   */
      /* object can be modified by setting a property and the modified URL    */
      /* object is processed by the PortletURL toString or write method"      */
      TestResult tr4 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDER_FILTERACTIONURL4);
      try {
         PortletURL turl = portletResp.createRenderURL();
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRender_filterRenderURL5 */
      /* Details: "Method filterRenderURL(PortletURL): The                    */
      /* filterRenderURL(PortletURL): method is called before the toString    */
      /* or write methods are executed on an action URL"                      */
      TestResult tr5 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDER_FILTERRENDERURL5);
      try {
         PortletURL turl = portletResp.createRenderURL();
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRender_filterRenderURL6 */
      /* Details: "Method filterRenderURL(PortletURL): The filterRenderURL    */
      /* method is passed the PortletURL object representing the action       */
      /* URL"                                                                 */
      TestResult tr6 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDER_FILTERRENDERURL6);
      try {
         PortletURL turl = portletResp.createRenderURL();
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRender_filterRenderURL7 */
      /* Details: "Method filterRenderURL(PortletURL): The input action URL   */
      /* object can be modified by setting a parameter and the modified URL   */
      /* object is processed by the PortletURL toString or write method"      */
      TestResult tr7 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDER_FILTERRENDERURL7);
      try {
         PortletURL turl = portletResp.createRenderURL();
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRender_filterRenderURL8 */
      /* Details: "Method filterRenderURL(PortletURL): The input action URL   */
      /* object can be modified by setting a property and the modified URL    */
      /* object is processed by the PortletURL toString or write method"      */
      TestResult tr8 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDER_FILTERRENDERURL8);
      try {
         PortletURL turl = portletResp.createRenderURL();
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRender_filterResourceURL1 */
      /* Details: "Method filterResourceURL(ResourceURL): The                 */
      /* filterResourceURL(PortletURL): method is called before the           */
      /* toString or write methods are executed on an action URL"             */
      TestResult tr9 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDER_FILTERRESOURCEURL1);
      try {
         PortletURL turl = portletResp.createRenderURL();
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRender_filterResourceURL2 */
      /* Details: "Method filterResourceURL(ResourceURL): The                 */
      /* filterResourceURL method is passed the PortletURL object             */
      /* representing the action URL"                                         */
      TestResult tr10 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDER_FILTERRESOURCEURL2);
      try {
         PortletURL turl = portletResp.createRenderURL();
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRender_filterResourceURL3 */
      /* Details: "Method filterResourceURL(ResourceURL): The input action    */
      /* URL object can be modified by setting a parameter and the modified   */
      /* URL object is processed by the PortletURL toString or write          */
      /* method"                                                              */
      TestResult tr11 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDER_FILTERRESOURCEURL3);
      try {
         PortletURL turl = portletResp.createRenderURL();
      } catch(Exception e) {tr11.appendTcDetail(e.toString());}
      tr11.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRender_filterResourceURL4 */
      /* Details: "Method filterResourceURL(ResourceURL): The input action    */
      /* URL object can be modified by setting a property and the modified    */
      /* URL object is processed by the PortletURL toString or write          */
      /* method"                                                              */
      TestResult tr12 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDER_FILTERRESOURCEURL4);
      try {
         PortletURL turl = portletResp.createRenderURL();
      } catch(Exception e) {tr12.appendTcDetail(e.toString());}
      tr12.writeTo(writer);

      /* TestCase: V2URLTests_PortletURLGenerationListener_ApiRender_filterResourceURL5 */
      /* Details: "Method filterResourceURL(ResourceURL): The input action    */
      /* URL object can be modified by setting the resource ID and the        */
      /* modified URL object is processed by the PortletURL toString or       */
      /* write method"                                                        */
      TestResult tr13 = tcd.getTestResultFailed(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDER_FILTERRESOURCEURL5);
      try {
         PortletURL turl = portletResp.createRenderURL();
      } catch(Exception e) {tr13.appendTcDetail(e.toString());}
      tr13.writeTo(writer);

   }

}
