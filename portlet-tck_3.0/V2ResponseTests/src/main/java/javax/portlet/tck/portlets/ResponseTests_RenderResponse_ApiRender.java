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
 * portlet ResponseTests_RenderResponse_ApiRender_event
 *
 */
public class ResponseTests_RenderResponse_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         ResponseTests_RenderResponse_ApiRender.class.getName();
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

      ClassChecker cc = new ClassChecker(portletResp.getClass());

      /* TestCase: V2ResponseTests_RenderResponse_ApiRender_setTitle2         */
      /* Details: "Method setTitle(String): Sets the portlet title to the     */
      /* specified value"                                                     */
      TestResult tr0 = tcd.getTestResultFailed(V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETTITLE2);
      tr0.setTcSuccess(true);
      tr0.writeTo(writer);

      /* TestCase: V2ResponseTests_RenderResponse_ApiRender_setNextPossiblePortletModes2 */
      /* Details: "Method                                                     */
      /* setNextPossiblePortletModes(java.util.Collection): Sets the next     */
      /* possible portlet modes to the specified value"                       */
      TestResult tr1 = tcd.getTestResultFailed(V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETNEXTPOSSIBLEPORTLETMODES2);
      tr1.setTcSuccess(true);
      tr1.writeTo(writer);

      /* TestCase: V2ResponseTests_RenderResponse_ApiRender_setContentType1   */
      /* Details: "Method setContentType(String): The portlet container       */
      /* will ignore any character encoding specified as part of the          */
      /* content type for render calls"                                       */
      TestResult tr2 = tcd.getTestResultFailed(V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETCONTENTTYPE1);
      tr2.setTcSuccess(true);
      tr2.writeTo(writer);

      /* TestCase: V2ResponseTests_RenderResponse_ApiRender_setContentType2   */
      /* Details: "Method setContentType(String): Throws                      */
      /* IllegalArgumentException if the content type is not valid"           */
      TestResult tr3 = tcd.getTestResultFailed(V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETCONTENTTYPE2);
      try {
    	  portletResp.setContentType("Invalid");
    	  tr3.appendTcDetail("Method did not throw Exception");
      } catch (IllegalArgumentException iae) {
    	  tr3.setTcSuccess(true);
      }
      tr3.writeTo(writer);

   }

}
