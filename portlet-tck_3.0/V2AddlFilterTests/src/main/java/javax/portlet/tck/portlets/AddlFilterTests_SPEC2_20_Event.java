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
 * portlet AddlFilterTests_SPEC2_20_Event_event
 *
 */
public class AddlFilterTests_SPEC2_20_Event implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlFilterTests_SPEC2_20_Event.class.getName();
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
             "AddlFilterTests_SPEC2_20_Event");
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

      /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filter1                   */
      /* Details: "A filter declaration can be configured in the deployment   */
      /* descriptor"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Event_filter1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filter6                   */
      /* Details: "A filter declaration can contain multiple                  */
      /* &lt;lifecycle&gt; tags for a single filter class"                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Event_filter6", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filter7                   */
      /* Details: "The filter declaration can contain initialization          */
      /* parameters which can be read by the filter through the               */
      /* FilterConfig object"                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Event_filter7", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filter8                   */
      /* Details: "For each filter declaration, the filter instance must      */
      /* receive all initialization parameters defined in the filter          */
      /* declaration"                                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Event_filter8", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filter9                   */
      /* Details: "For each filter declaration, the filter instance must      */
      /* receive only initialization parameters defined in the filter         */
      /* declaration"                                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Event_filter9", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filter10                  */
      /* Details: "For multiple filter declarations for a single filter       */
      /* class, the filter instance must receive all initialization           */
      /* parameters defined in the filter declaration"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Event_filter10", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filter11                  */
      /* Details: "For multiple filter declarations for a single filter       */
      /* class, the filter instance must receive only initialization          */
      /* parameters defined in the filter declaration"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Event_filter11", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filter12                  */
      /* Details: "A filter class can appear in multiple filter               */
      /* declarations"                                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Event_filter12", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filter13                  */
      /* Details: "A filter declaration can be mapped to a portlet through    */
      /* the deployment descriptor &lt;filter-mapping&gt; element"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Event_filter13", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filter14                  */
      /* Details: "Filters can be associated with groups of portlets using    */
      /* the '*' character as a wildcard at the end of a string to indicate   */
      /* that the filter must be applied to any portlet whose name starts     */
      /* with the characters before the \"*\" character"                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Event_filter14", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filter15                  */
      /* Details: "The order the container uses in building the chain of      */
      /* filters to be applied for a particular request is the order in       */
      /* which the &lt;portlet-name&gt; matching filter mappings appear in    */
      /* the deployment descriptor"                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Event_filter15", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filterWrapper3            */
      /* Details: "An EVENT_PHASE filter can wrap the EventRequest object     */
      /* with a custom wrapper"                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Event_filterWrapper3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filterWrapper4            */
      /* Details: "An EVENT_PHASE filter can wrap the EventResponse object    */
      /* with a custom wrapper"                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Event_filterWrapper4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filter4                   */
      /* Details: "If the filter declaration specifies the                    */
      /* &lt;lifecycle&gt; tag value EVENT_PHASE, the EventFilter.doFilter    */
      /* method is called"                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Event_filter4", aurl);
         tb.writeTo(writer);
      }

   }

}
