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
 * portlet FilterTests_ActionFilter_ApiActionFilter_event
 *
 */
public class FilterTests_ActionFilter_ApiActionFilter implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         FilterTests_ActionFilter_ApiActionFilter.class.getName();
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

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "FilterTests_ActionFilter_ApiActionFilter", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "FilterTests_ActionFilter_ApiActionFilter", APPLICATION_SCOPE);
      }

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_canBeConfigured1 */
      /* Details: "An ActionFilter can be configured in the portlet           */
      /* descriptor"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2FilterTests_ActionFilter_ApiActionFilter_canBeConfigured1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_canBeConfigured2 */
      /* Details: "Multiple ActionFilter classes can be configured in the     */
      /* portlet descriptor"                                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2FilterTests_ActionFilter_ApiActionFilter_canBeConfigured2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterIsCalled */
      /* Details: "The doFilter(ActionRequest, ActionResponse,                */
      /* FilterChain): method is called before the processAction method for   */
      /* the portlet"                                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2FilterTests_ActionFilter_ApiActionFilter_doFilterIsCalled", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterProcessAction1 */
      /* Details: "After the doFilter(ActionRequest, ActionResponse,          */
      /* FilterChain): method has sucessfully completed and invokes the       */
      /* next filter, the processActionMethod is called"                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2FilterTests_ActionFilter_ApiActionFilter_doFilterProcessAction1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterProcessAction2 */
      /* Details: "After the doFilter(ActionRequest, ActionResponse,          */
      /* FilterChain): method has sucessfully completed and invokes the       */
      /* next filter, the next filter in the chain is called if multiple      */
      /* filters are defined"                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2FilterTests_ActionFilter_ApiActionFilter_doFilterProcessAction2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterBlock   */
      /* Details: "If the doFilter(ActionRequest, ActionResponse,             */
      /* FilterChain): method does not invoke the next filter,                */
      /* processAction is not called"                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2FilterTests_ActionFilter_ApiActionFilter_doFilterBlock", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterException1 */
      /* Details: "If the doFilter(ActionRequest, ActionResponse,             */
      /* FilterChain): method throws an UnavailableException, processAction   */
      /* is not called"                                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2FilterTests_ActionFilter_ApiActionFilter_doFilterException1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterException2 */
      /* Details: "If the doFilter(ActionRequest, ActionResponse,             */
      /* FilterChain): method throws an UnavailableException, no further      */
      /* filter is called"                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2FilterTests_ActionFilter_ApiActionFilter_doFilterException2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterExamine */
      /* Details: "Method doFilter(ActionRequest, ActionResponse,             */
      /* FilterChain): After the next filter has been successfully invoked,   */
      /* the ActionResponse may be examined"                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2FilterTests_ActionFilter_ApiActionFilter_doFilterExamine", aurl);
         tb.writeTo(writer);
      }

   }

}
