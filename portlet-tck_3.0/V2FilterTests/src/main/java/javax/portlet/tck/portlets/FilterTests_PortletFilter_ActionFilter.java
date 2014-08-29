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
 * portlet FilterTests_PortletFilter_ActionFilter_event
 *
 */
public class FilterTests_PortletFilter_ActionFilter implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         FilterTests_PortletFilter_ActionFilter.class.getName();
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

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2FilterTests_PortletFilter_ActionFilter_initAction1       */
      /* Details: "The init(FilterConfig): method is called when an           */
      /* ActionFilter is configured"                                          */
      TestResult tr0 = tcd.getTestResultFailed(V2FILTERTESTS_PORTLETFILTER_ACTIONFILTER_INITACTION1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2FilterTests_PortletFilter_ActionFilter_initAction2       */
      /* Details: "The init(FilterConfig): method for an ActionFilter is      */
      /* passed a FilterConfig object"                                        */
      TestResult tr1 = tcd.getTestResultFailed(V2FILTERTESTS_PORTLETFILTER_ACTIONFILTER_INITACTION2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2FilterTests_PortletFilter_ActionFilter_initAction3       */
      /* Details: "If the init(FilterConfig): method for an ActionFilter      */
      /* throws a PortletException, the filter is not placed in service"      */
      TestResult tr2 = tcd.getTestResultFailed(V2FILTERTESTS_PORTLETFILTER_ACTIONFILTER_INITACTION3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "FilterTests_PortletFilter_ActionFilter",
                   writer.toString(), APPLICATION_SCOPE);
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

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "FilterTests_PortletFilter_ActionFilter", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "FilterTests_PortletFilter_ActionFilter", APPLICATION_SCOPE);
      }

      /* TestCase: V2FilterTests_PortletFilter_ActionFilter_initAction1       */
      /* Details: "The init(FilterConfig): method is called when an           */
      /* ActionFilter is configured"                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2FilterTests_PortletFilter_ActionFilter_initAction1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2FilterTests_PortletFilter_ActionFilter_initAction2       */
      /* Details: "The init(FilterConfig): method for an ActionFilter is      */
      /* passed a FilterConfig object"                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2FilterTests_PortletFilter_ActionFilter_initAction2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2FilterTests_PortletFilter_ActionFilter_initAction3       */
      /* Details: "If the init(FilterConfig): method for an ActionFilter      */
      /* throws a PortletException, the filter is not placed in service"      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2FilterTests_PortletFilter_ActionFilter_initAction3", aurl);
         tb.writeTo(writer);
      }

   }

}
