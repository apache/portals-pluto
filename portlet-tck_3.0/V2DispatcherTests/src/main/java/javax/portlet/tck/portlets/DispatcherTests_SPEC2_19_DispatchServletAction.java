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
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.*;
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
 * portlet DispatcherTests_SPEC2_19_DispatchServletAction_event
 *
 */
public class DispatcherTests_SPEC2_19_DispatchServletAction implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         DispatcherTests_SPEC2_19_DispatchServletAction.class.getName();
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

      Cookie c = new Cookie(COOKIE_PREFIX +"DispatcherTests_SPEC2_19_DispatchServletAction", COOKIE_VALUE);
      c.setMaxAge(10);
      portletResp.addProperty(c);
      portletResp.addProperty(PROP_PREFIX +"DispatcherTests_SPEC2_19_DispatchServletAction", PROP_VALUE);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute("void", tid);

      StringWriter writer = new StringWriter();

      JSR286DispatcherTestCaseDetails tcd = new JSR286DispatcherTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch1 */
      /* Details: "The PortletContext getRequestDispatcher method returns a   */
      /* PortletRequestDispatcher for a path within the portlet               */
      /* application"                                                         */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH1);
      try {
         PortletRequestDispatcher rd = portletConfig.getPortletContext()
               .getRequestDispatcher("/DispatcherTests_SPEC2_19_DispatchServletAction_servlet");
         tr0.setTcSuccess(rd != null);
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch2 */
      /* Details: "If the path provided to getRequestDispatcher method does   */
      /* not start with \"/\", the method returns null"                       */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH2);
      try {
         PortletRequestDispatcher rd = portletConfig.getPortletContext()
               .getRequestDispatcher("DispatcherTests_SPEC2_19_DispatchServletAction_servlet");
         tr1.setTcSuccess(rd == null);
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch3 */
      /* Details: "If the path provided to getRequestDispatcher method ends   */
      /* with \"/\", the method returns null"                                 */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH3);
      try {
         PortletRequestDispatcher rd = portletConfig.getPortletContext()
               .getRequestDispatcher("DispatcherTests_SPEC2_19_DispatchServletAction_servlet");
         tr2.setTcSuccess(rd == null);
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch4 */
      /* Details: "If the path provided to getRequestDispatcher method does   */
      /* not specify a valid path, the method returns null"                   */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH4);
      try {
         PortletRequestDispatcher rd = portletConfig.getPortletContext()
               .getRequestDispatcher("/Invalid/path.jsp");
         tr3.setTcSuccess(rd == null);
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch5 */
      /* Details: "The PortletContext getNamedDispatcher method returns a     */
      /* PortletRequestDispatcher for a servlet within the portlet            */
      /* application"                                                         */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH5);
      try {
         PortletRequestDispatcher rd = portletConfig.getPortletContext()
               .getNamedDispatcher("DispatcherTests_SPEC2_19_DispatchServletAction_servlet");
         tr4.setTcSuccess(rd != null);
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch6 */
      /* Details: "If the name provided to getNamedDispatcher method is not   */
      /* valid, the method returns null"                                      */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH6);
      try {
         PortletRequestDispatcher rd = portletConfig.getPortletContext()
               .getNamedDispatcher("Invalid Name");
         tr5.setTcSuccess(rd == null);
         
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "DispatcherTests_SPEC2_19_DispatchServletAction",
                   writer.toString(), APPLICATION_SCOPE);
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");

      Cookie c = new Cookie(COOKIE_PREFIX +"DispatcherTests_SPEC2_19_DispatchServletAction", COOKIE_VALUE);
      c.setMaxAge(10);
      portletResp.addProperty(c);
      portletResp.addProperty(PROP_PREFIX +"DispatcherTests_SPEC2_19_DispatchServletAction", PROP_VALUE);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute("void", tid);

      PrintWriter writer = portletResp.getWriter();

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      Cookie c = new Cookie(COOKIE_PREFIX +"DispatcherTests_SPEC2_19_DispatchServletAction", COOKIE_VALUE);
      c.setMaxAge(10);
      portletResp.addProperty(c);
      portletResp.addProperty(PROP_PREFIX +"DispatcherTests_SPEC2_19_DispatchServletAction", PROP_VALUE);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute("void", tid);

      PrintWriter writer = portletResp.getWriter();

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "DispatcherTests_SPEC2_19_DispatchServletAction", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "DispatcherTests_SPEC2_19_DispatchServletAction", APPLICATION_SCOPE);
      } else {

         /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch1 */
         /* Details: "The PortletContext getRequestDispatcher method returns a   */
         /* PortletRequestDispatcher for a path within the portlet               */
         /* application"                                                         */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch1", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch2 */
         /* Details: "If the path provided to getRequestDispatcher method does   */
         /* not start with \"/\", the method returns null"                       */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch2", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch3 */
         /* Details: "If the path provided to getRequestDispatcher method ends   */
         /* with \"/\", the method returns null"                                 */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch3", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch4 */
         /* Details: "If the path provided to getRequestDispatcher method does   */
         /* not specify a valid path, the method returns null"                   */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch4", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch5 */
         /* Details: "The PortletContext getNamedDispatcher method returns a     */
         /* PortletRequestDispatcher for a servlet within the portlet            */
         /* application"                                                         */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch5", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch6 */
         /* Details: "If the name provided to getNamedDispatcher method is not   */
         /* valid, the method returns null"                                      */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch6", aurl);
            tb.writeTo(writer);
         }

      }
   }

}
