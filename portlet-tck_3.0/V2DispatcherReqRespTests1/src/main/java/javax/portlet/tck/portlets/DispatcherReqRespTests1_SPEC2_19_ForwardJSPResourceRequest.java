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
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.*;
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
 * portlet DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_event
 *
 */
public class DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest.class.getName();
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

      // Prereq for: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getAttribute
      portletReq.setAttribute(ATTR_PREFIX +"V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getAttribute", "Value1");

      // Prereq for: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getAttributeNames
      portletReq.setAttribute(ATTR_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getAttributeNames", "Value1");

      PortletRequestDispatcher rd = portletConfig.getPortletContext()
            .getRequestDispatcher("/WEB-INF/jsp/DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest.jsp?qparm1=qvalue1&qparm2=qvalue2");
      rd.forward(portletReq, portletResp);
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      // TestSetupLink for: DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest
      {
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameter");
         if (val == null) {
            PortletURL rurl = ((RenderResponse)portletResp).createRenderURL();
            rurl.setParameters(portletReq.getPrivateParameterMap());
            rurl.setParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameter", "Value");
            TestSetupLink tl = new TestSetupLink("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameter", rurl);
            tl.writeTo(writer);
         }
      }

      // TestSetupLink for: DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest
      {
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterMap");
         if (val == null) {
            PortletURL rurl = ((RenderResponse)portletResp).createRenderURL();
            rurl.setParameters(portletReq.getPrivateParameterMap());
            rurl.setParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterMap", "Value");
            TestSetupLink tl = new TestSetupLink("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterMap", rurl);
            tl.writeTo(writer);
         }
      }

      // TestSetupLink for: DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest
      {
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterNames");
         if (val == null) {
            PortletURL rurl = ((RenderResponse)portletResp).createRenderURL();
            rurl.setParameters(portletReq.getPrivateParameterMap());
            rurl.setParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterNames", "Value");
            TestSetupLink tl = new TestSetupLink("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterNames", rurl);
            tl.writeTo(writer);
         }
      }

      // TestSetupLink for: DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest
      {
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterValues");
         if (val == null) {
            PortletURL rurl = ((RenderResponse)portletResp).createRenderURL();
            rurl.setParameters(portletReq.getPrivateParameterMap());
            rurl.setParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterValues", "Value");
            TestSetupLink tl = new TestSetupLink("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterValues", rurl);
            tl.writeTo(writer);
         }
      }

      writer.write("<div id=\"DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write("         document.getElementById(\"DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
