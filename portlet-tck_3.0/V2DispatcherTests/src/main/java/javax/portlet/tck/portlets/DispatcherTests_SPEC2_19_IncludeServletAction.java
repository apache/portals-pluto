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
 * portlet DispatcherTests_SPEC2_19_IncludeServletAction_event
 *
 */
public class DispatcherTests_SPEC2_19_IncludeServletAction implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         DispatcherTests_SPEC2_19_IncludeServletAction.class.getName();
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

      Cookie c = new Cookie(COOKIE_PREFIX +"DispatcherTests_SPEC2_19_IncludeServletAction", COOKIE_VALUE);
      c.setMaxAge(10);
      portletResp.addProperty(c);
      portletResp.addProperty(PROP_PREFIX +"DispatcherTests_SPEC2_19_IncludeServletAction", PROP_VALUE);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute("void", tid);

      StringWriter writer = new StringWriter();

      PortletRequestDispatcher rd = portletConfig.getPortletContext()
            .getRequestDispatcher("/DispatcherTests_SPEC2_19_IncludeServletAction_servlet?qparm1=qvalue1&qparm2=qvalue2");
      rd.include(portletReq, portletResp);
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");

      Cookie c = new Cookie(COOKIE_PREFIX +"DispatcherTests_SPEC2_19_IncludeServletAction", COOKIE_VALUE);
      c.setMaxAge(10);
      portletResp.addProperty(c);
      portletResp.addProperty(PROP_PREFIX +"DispatcherTests_SPEC2_19_IncludeServletAction", PROP_VALUE);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute("void", tid);

      PrintWriter writer = portletResp.getWriter();

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      Cookie c = new Cookie(COOKIE_PREFIX +"DispatcherTests_SPEC2_19_IncludeServletAction", COOKIE_VALUE);
      c.setMaxAge(10);
      portletResp.addProperty(c);
      portletResp.addProperty(PROP_PREFIX +"DispatcherTests_SPEC2_19_IncludeServletAction", PROP_VALUE);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute("void", tid);

      PrintWriter writer = portletResp.getWriter();

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "DispatcherTests_SPEC2_19_IncludeServletAction", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "DispatcherTests_SPEC2_19_IncludeServletAction", APPLICATION_SCOPE);
      } else {

         /* TestCase: SPEC2_19_IncludeServletAction_dispatch1                    */
         /* Details: "If the path provided to getRequestDispatcher method        */
         /* contains query strings, parameters specified in the query strings    */
         /* must be passed to the target servlet during an include"              */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_dispatch1", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_dispatch2                    */
         /* Details: "Parameters specified in the query strings must be          */
         /* aggregated with the portlet render parameters"                       */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_dispatch2", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_dispatch3                    */
         /* Details: "If query string parameters have the same names as render   */
         /* parameter names, the query string parameters appear in the           */
         /* parameter values array before the render parameter values"           */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_dispatch3", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_dispatch4                    */
         /* Details: "The parameters associated with a request dispatcher are    */
         /* scoped only for the duration of the include or forward call"         */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_dispatch4", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_invoke1                      */
         /* Details: "The PortletRequestDispatcher include method can target a   */
         /* servlet "                                                            */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_invoke1", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_invoke2                      */
         /* Details: "Parameters to the include method for a target servlet      */
         /* can be the request and response classes from the portlet lifecyle    */
         /* method initiating the include"                                       */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_invoke2", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_invoke3                      */
         /* Details: "Parameters to the include method for a target servlet      */
         /* can be wrapped request and response classes from the portlet         */
         /* lifecyle method initiating the include"                              */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_invoke3", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_invoke4                      */
         /* Details: "The portlet container must invoke the target servlet in    */
         /* the same thread as the PortletRequestDispatcher include              */
         /* invocation"                                                          */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_invoke4", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_invoke5                      */
         /* Details: "Cookies set by the portlet before the include call         */
         /* remain valid"                                                        */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_invoke5", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_invoke6                      */
         /* Details: "Properties set by the portlet before the include call      */
         /* remain valid"                                                        */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_invoke6", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_invoke7                      */
         /* Details: "The path elements of the request object exposed to the     */
         /* target servlet must reflect the path used to obtain the              */
         /* RequestDispatcher"                                                   */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_invoke7", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_invoke8                      */
         /* Details: "The portlet can include multiple servlets during the       */
         /* same lifecycle method"                                               */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_invoke8", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_invoke9                      */
         /* Details: "The included servlet must be handled as an HTTP GET        */
         /* request"                                                             */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_invoke9", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_state1                       */
         /* Details: "A window state set by the portlet before the include       */
         /* call remains valid"                                                  */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_state1", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_state2                       */
         /* Details: "A portlet mode set by the portlet before the include       */
         /* call remains valid"                                                  */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_state2", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_state3                       */
         /* Details: "Render parameters set by the portlet before the include    */
         /* call remain valid"                                                   */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_state3", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_attributes1                  */
         /* Details: "If the request dispatcher is obtained through the          */
         /* getRequestDispatcher method, the request attribute                   */
         /* javax.servlet.include.request_uri will be set, and equals the        */
         /* value from HTTPServletRequest.getRequestURI for the first servlet    */
         /* in the include chain"                                                */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_attributes1", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_attributes2                  */
         /* Details: "If the request dispatcher is obtained through the          */
         /* getRequestDispatcher method, the request attribute                   */
         /* javax.servlet.include.context_path will be set, and equals the       */
         /* value from HTTPServletRequest.getContestPath for the first servlet   */
         /* in the include chain"                                                */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_attributes2", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_attributes3                  */
         /* Details: "If the request dispatcher is obtained through the          */
         /* getRequestDispatcher method, the request attribute                   */
         /* javax.servlet.include.servlet_path will be set, and equals the       */
         /* value from HTTPServletRequest.getServletPath for the first servlet   */
         /* in the include chain"                                                */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_attributes3", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_attributes4                  */
         /* Details: "If the request dispatcher is obtained through the          */
         /* getRequestDispatcher method, the request attribute                   */
         /* javax.servlet.include.path_info will be set, and equals the value    */
         /* from HTTPServletRequest.getPathInfo for the first servlet in the     */
         /* include chain"                                                       */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_attributes4", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_attributes5                  */
         /* Details: "If the request dispatcher is obtained through the          */
         /* getRequestDispatcher method, the request attribute                   */
         /* javax.servlet.include.query_string will be set, and equals the       */
         /* value from HTTPServletRequest.getQueryString for the first servlet   */
         /* in the include chain"                                                */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_attributes5", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_attributes6                  */
         /* Details: "The request attribute javax.portlet.config must be set     */
         /* to the javax.portlet.PortletConfig object"                           */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_attributes6", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_attributes7                  */
         /* Details: "For includes from the processAction method, The request    */
         /* attribute javax.portlet.request must be set to the                   */
         /* javax.portlet.ActionRequest object"                                  */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_attributes7", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: SPEC2_19_IncludeServletAction_attributes8                  */
         /* Details: "For includes from the processAction method, The request    */
         /* attribute javax.portlet.response must be set to the                  */
         /* javax.portlet.ActionResponse object"                                 */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("SPEC2_19_IncludeServletAction_attributes8", aurl);
            tb.writeTo(writer);
         }

      }
   }

}
