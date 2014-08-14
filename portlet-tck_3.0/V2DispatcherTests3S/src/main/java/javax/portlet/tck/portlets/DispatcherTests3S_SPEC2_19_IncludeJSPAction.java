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
 * portlet DispatcherTests3S_SPEC2_19_IncludeJSPAction_event
 *
 */
public class DispatcherTests3S_SPEC2_19_IncludeJSPAction implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         DispatcherTests3S_SPEC2_19_IncludeJSPAction.class.getName();
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

      Cookie c = new Cookie(COOKIE_PREFIX +"DispatcherTests3S_SPEC2_19_IncludeJSPAction", COOKIE_VALUE);
      c.setMaxAge(10);
      portletResp.addProperty(c);
      portletResp.addProperty(PROP_PREFIX +"DispatcherTests3S_SPEC2_19_IncludeJSPAction", PROP_VALUE);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute("void", tid);

      StringWriter writer = new StringWriter();

      PortletRequestDispatcher rd = portletConfig.getPortletContext()
            .getRequestDispatcher("/WEB-INF/jsp/DispatcherTests3S_SPEC2_19_IncludeJSPAction.jsp?qparm1=qvalue1&qparm2=qvalue2");
      rd.include(portletReq, portletResp);
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");

      Cookie c = new Cookie(COOKIE_PREFIX +"DispatcherTests3S_SPEC2_19_IncludeJSPAction", COOKIE_VALUE);
      c.setMaxAge(10);
      portletResp.addProperty(c);
      portletResp.addProperty(PROP_PREFIX +"DispatcherTests3S_SPEC2_19_IncludeJSPAction", PROP_VALUE);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute("void", tid);

      PrintWriter writer = portletResp.getWriter();

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      Cookie c = new Cookie(COOKIE_PREFIX +"DispatcherTests3S_SPEC2_19_IncludeJSPAction", COOKIE_VALUE);
      c.setMaxAge(10);
      portletResp.addProperty(c);
      portletResp.addProperty(PROP_PREFIX +"DispatcherTests3S_SPEC2_19_IncludeJSPAction", PROP_VALUE);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute("void", tid);

      PrintWriter writer = portletResp.getWriter();

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "DispatcherTests3S_SPEC2_19_IncludeJSPAction", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "DispatcherTests3S_SPEC2_19_IncludeJSPAction", APPLICATION_SCOPE);
      } else {

         /* TestCase: V2DispatcherTests3S_SPEC2_19_IncludeJSPAction_dispatch4    */
         /* Details: "The parameters associated with a request dispatcher are    */
         /* scoped only for the duration of the include or forward call"         */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherTests3S_SPEC2_19_IncludeJSPAction_dispatch4", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherTests3S_SPEC2_19_IncludeJSPAction_invoke3      */
         /* Details: "Parameters to the include method for a target servlet      */
         /* can be wrapped request and response classes from the portlet         */
         /* lifecyle method initiating the include"                              */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherTests3S_SPEC2_19_IncludeJSPAction_invoke3", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherTests3S_SPEC2_19_IncludeJSPAction_invoke8      */
         /* Details: "The portlet can include multiple servlets during the       */
         /* same lifecycle method"                                               */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherTests3S_SPEC2_19_IncludeJSPAction_invoke8", aurl);
            tb.writeTo(writer);
         }

      }
   }

}
