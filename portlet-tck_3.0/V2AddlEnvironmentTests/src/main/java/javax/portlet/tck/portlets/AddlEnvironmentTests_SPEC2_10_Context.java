/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package javax.portlet.tck.portlets;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.tck.beans.CompareUtils;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;
import javax.portlet.tck.servlet.StartupListener;
import javax.servlet.ServletContext;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined in the
 * /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate the test case names
 * defined in the additionalTCs.xml file into the complete list of test case names for execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will initiate the
 * events, but not process them. The processing is done in the companion portlet
 * AddlEnvironmentTests_SPEC2_10_Context_event
 * 
 */
public class AddlEnvironmentTests_SPEC2_10_Context implements Portlet, ResourceServingPortlet {

   private static final String TESTFILE      = "/testfiles/AddlEnvironmentTests_SPEC2_10_Context.html";

   private PortletConfig       portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @SuppressWarnings("deprecation")
   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(Constants.THREADID_ATTR, tid);

   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp) throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(Constants.THREADID_ATTR, tid);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(Constants.THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_portletContextServletContext1 */
      /* Details: "The initialization parameters accessible through the */
      /* PortletContext must be the same that are accessible through the */
      /* ServletContext of the portlet application" */
      /* Test Implementation */
      boolean succeeded = true;
      TestResult tr0 = tcd.getTestResultSucceeded(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT1);
      ServletContext servletContext = StartupListener.getServletContext();
      PortletContext portletContext = portletReq.getPortletSession().getPortletContext();

      // Compare the list of context-param entries from web.xml with those from portletContext.
      Enumeration<?> servletContextParamNames = servletContext.getInitParameterNames();
      while (servletContextParamNames.hasMoreElements()) {
         String servletContextParamName = (String) servletContextParamNames.nextElement();
         String servletContextParamValue = servletContext.getInitParameter(servletContextParamName);
         String portletContextParamValue = portletContext.getInitParameter(servletContextParamName);
         if ((servletContextParamValue == null) && (portletContextParamValue == null)) {
            tr0.appendTcDetail("<br/>servletContextParamName=[" + servletContextParamName
                  + "] servletContextParamValue=[null] == portletContextParamValue=null]");
         } else if (servletContextParamValue == null) {
            tr0.appendTcDetail("<br/>servletContextParamName=[" + servletContextParamName + "] servletContextParamValue=[null] != portletContextParamValue=["
                  + portletContextParamValue + "]");
            succeeded = false;
         } else if (portletContextParamValue == null) {
            tr0.appendTcDetail("<br/>servletContextParamName=[" + servletContextParamName + "] servletContextParamValue=[" + servletContextParamValue
                  + "] != portletContextParamValue=[null]");
            succeeded = false;
         } else {
            if (servletContextParamValue.equals(portletContextParamValue)) {
               tr0.appendTcDetail("<br/>servletContextParamName=[" + servletContextParamName + "] servletContextParamValue=[" + servletContextParamValue
                     + "] == portletContextParamValue=[" + portletContextParamValue + "]");
            } else {
               tr0.appendTcDetail("<br/>servletContextParamName=[" + servletContextParamName + "] servletContextParamValue=[" + servletContextParamValue
                     + "] != portletContextParamValue=[" + portletContextParamValue + "]");
               succeeded = false;
            }
         }
      }

      // Compare the list of context-param entries from from portletContext with those from web.xml
      Enumeration<?> portletContextParamNames = portletContext.getInitParameterNames();
      while (portletContextParamNames.hasMoreElements()) {
         String portletContextParamName = (String) portletContextParamNames.nextElement();
         String portletContextParamValue = portletContext.getInitParameter(portletContextParamName);
         String servletContextParamValue = servletContext.getInitParameter(portletContextParamName);
         if ((servletContextParamValue == null) && (portletContextParamValue == null)) {
            tr0.appendTcDetail("<br/>portletContextParamName=[" + portletContextParamName
                  + "] portletContextParamValue=[null] == portletContextParamValue=null]");
         } else if (servletContextParamValue == null) {
            tr0.appendTcDetail("<br/>portletContextParamName=[" + portletContextParamName + "] portletContextParamValue=[null] != servletContextParamValue=["
                  + servletContextParamValue + "]");
            succeeded = false;
         } else if (portletContextParamValue == null) {
            tr0.appendTcDetail("<br/>portletContextParamName=[" + portletContextParamName + "] portletContextParamValue=[" + portletContextParamValue
                  + "] != servletContextParamValue=[null]");
            succeeded = false;
         } else {
            if (portletContextParamValue.equals(servletContextParamValue)) {
               tr0.appendTcDetail("<br/>portletContextParamName=[" + portletContextParamName + "] portletContextParamValue=[" + portletContextParamValue
                     + "] == servletContextParamValue=[" + servletContextParamValue + "]");
            } else {
               tr0.appendTcDetail("<br/>portletContextParamName=[" + portletContextParamName + "] portletContextParamValue=[" + portletContextParamValue
                     + "] != servletContextParamValue=[" + servletContextParamValue + "]");
               succeeded = false;
            }
         }
      }
      tr0.setTcSuccess(succeeded);
      tr0.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_portletContextServletContext2 */
      /* Details: "The context initialization parameters are set in the */
      /* web.xml file" */
      succeeded = true;
      TestResult tr1 = tcd.getTestResultSucceeded(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT2);
      Map<String, String> configuredContextParams = StartupListener.getConfiguredContextParams();
      Set<Map.Entry<String, String>> entrySet = configuredContextParams.entrySet();
      for (Map.Entry<String, String> mapEntry : entrySet) {
         String webXmlContextParamName = mapEntry.getKey();
         String webXmlContextParamValue = mapEntry.getValue();
         String portletContextParamValue = portletContext.getInitParameter(webXmlContextParamName);
         if ((webXmlContextParamValue == null) && (portletContextParamValue == null)) {
            tr1.appendTcDetail("<br/>webXmlContextParamName=[" + webXmlContextParamName + "] webXmlContextParamValue=[null] == portletContextParamValue=null]");
         } else if (webXmlContextParamValue == null) {
            tr1.appendTcDetail("<br/>webXmlContextParamName=[" + webXmlContextParamName + "] webXmlContextParamValue=[null] != portletContextParamValue=["
                  + portletContextParamValue + "]");
            succeeded = false;
         } else if (portletContextParamValue == null) {
            tr1.appendTcDetail("<br/>webXmlContextParamName=[" + webXmlContextParamName + "] webXmlContextParamValue=[" + webXmlContextParamValue
                  + "] != portletContextParamValue=[null]");
            succeeded = false;
         } else {
            if (webXmlContextParamValue.equals(portletContextParamValue)) {
               tr1.appendTcDetail("<br/>webXmlContextParamName=[" + webXmlContextParamName + "] webXmlContextParamValue=[" + webXmlContextParamValue
                     + "] == portletContextParamValue=[" + portletContextParamValue + "]");
            } else {
               tr1.appendTcDetail("<br/>webXmlContextParamName=[" + webXmlContextParamName + "] webXmlContextParamValue=[" + webXmlContextParamValue
                     + "] != portletContextParamValue=[" + portletContextParamValue + "]");
               succeeded = false;
            }
         }
      }

      tr1.setTcSuccess(succeeded);
      tr1.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_portletContextServletContext3 */
      /* Details: "The PortletContext must offer access to the same set of */
      /* resources the ServletContext exposes" */
      succeeded = true;
      TestResult tr2 = tcd.getTestResultSucceeded(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT3);
      Set<String> servletResourcePaths = servletContext.getResourcePaths("/");
      Set<String> portletResourcePaths = portletContext.getResourcePaths("/");
      for (String servletResourcePath : servletResourcePaths) {
         if (servletResourcePath != null) {
            if (portletResourcePaths.contains(servletResourcePath)) {
               tr2.appendTcDetail("<br/>servletContext resourcePath=[" + servletResourcePath + "] is also available in portletContext");
            } else {
               tr2.appendTcDetail("<br/>servletContext resourcePath=[" + servletResourcePath + "] IS NOT AVAILABLE in portletContext");
               succeeded = false;
            }
         }
      }

      for (String portletResourcePath : portletResourcePaths) {
         if (portletResourcePath != null) {
            if (servletResourcePaths.contains(portletResourcePath)) {
               tr2.appendTcDetail("<br/>portletContext resourcePath=[" + portletResourcePath + "] is also available in servletContext");
            } else {
               tr2.appendTcDetail("<br/>portletContext resourcePath=[" + portletResourcePath + "] IS NOT AVAILABLE in servletContext");
               succeeded = false;
            }
         }
      }

      URL servletContextResourceURL = servletContext.getResource("/WEB-INF/web.xml");
      URL portletContextResourceURL = portletContext.getResource("/WEB-INF/web.xml");
      if (servletContextResourceURL.equals(portletContextResourceURL)) {
         tr2.appendTcDetail("<br/>servletContextResourceURL=[" + servletContextResourceURL + "] is also available in portletContext");
      } else {
         tr2.appendTcDetail("<br/>servletContextResourceURL=[" + servletContextResourceURL + "] IS NOT AVAILABLE in portletContext");
         succeeded = false;
      }
      tr2.setTcSuccess(succeeded);
      tr2.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_portletContextServletContext4 */
      /* Details: "The temporary working directory must be accessible as a */
      /* context attribute through the PortletContext using the attribute */
      /* name \"javax.servlet.context.tempdir\"" */
      succeeded = true;
      TestResult tr3 = tcd.getTestResultSucceeded(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT4);
      File servletContextTempDir = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
      File portletContextTempDir = (File) portletContext.getAttribute("javax.servlet.context.tempdir");
      if (servletContextTempDir.equals(portletContextTempDir)) {
         tr3.appendTcDetail("<br/>servletContextTempDir=[" + servletContextTempDir + "] is also available in portletContext");
      } else {
         tr3.appendTcDetail("<br/>servletContextTempDir=[" + servletContextTempDir + "] IS NOT AVAILABLE in portletContext");
         succeeded = false;
      }
      tr3.setTcSuccess(succeeded);
      tr3.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getAttribute */
      /* Details: "The PortletContext.getAttribute method provides the same */
      /* functionality as the ServletContext.getAttribute method" */
      TestResult tr4 = tcd.getTestResultFailed(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETATTRIBUTE);
      if (servletContext.getAttribute("javax.servlet.context.tempdir").equals(portletContext.getAttribute("javax.servlet.context.tempdir"))) {
         tr4.setTcSuccess(true);
      }
      tr4.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getAttributeNames */
      /* Details: "The PortletContext.getAttributeNames method provides the */
      /* same functionality as the ServletContext.getAttributeNames method" */
      TestResult tr5 = tcd.getTestResultSucceeded(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETATTRIBUTENAMES);
      Enumeration<?> portletConAttr = portletContext.getAttributeNames();
      Enumeration<?> servletConAttr = servletContext.getAttributeNames();
      while (portletConAttr.hasMoreElements()) {
         if (!portletConAttr.nextElement().equals(servletConAttr.nextElement())) {
            tr5.setTcSuccess(false);
         }
      }
      tr5.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getInitParameter */
      /* Details: "The PortletContext.getInitParameter method provides the */
      /* same functionality as the ServletContext.getInitParameter method" */
      TestResult tr6 = tcd.getTestResultFailed(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETINITPARAMETER);
      if (servletContext.getInitParameter("testParam1").equals(portletContext.getInitParameter("testParam1"))) {
         tr6.setTcSuccess(true);
      }
      tr6.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getInitParameterNames */
      /* Details: "The PortletContext.getInitParameterNames method provides */
      /* the same functionality as the ServletContext.getInitParameterNames */
      /* method" */
      TestResult tr7 = tcd.getTestResultSucceeded(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETINITPARAMETERNAMES);
      Enumeration<?> portletConInitParams = portletContext.getInitParameterNames();
      Enumeration<?> servletConInitParams = servletContext.getInitParameterNames();
      while (portletConInitParams.hasMoreElements()) {
         if (!portletConInitParams.nextElement().equals(servletConInitParams.nextElement())) {
            tr5.setTcSuccess(false);
         }
      }
      tr7.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getMimeType */
      /* Details: "The PortletContext.getMimeType method provides the same */
      /* functionality as the ServletContext.getMimeType method" */
      {
         TestResult tr8 = tcd.getTestResultFailed(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETMIMETYPE);
         String path = portletConfig.getPortletContext().getRealPath(TESTFILE);
         String scmt = servletContext.getMimeType(path);
         String pcmt = portletConfig.getPortletContext().getMimeType(path);
         StringBuilder txt = new StringBuilder(128);
         txt.append("portlet context MIME type: ").append(pcmt);
         txt.append(", servlet context MIME type: ").append(scmt);
         tr8.appendTcDetail(txt.toString());
         if (scmt == null && pcmt == null) {
            tr8.setTcSuccess(true);
         } else if (scmt != null && pcmt != null && pcmt.equals(scmt)) {
            tr8.setTcSuccess(true);
         }
         tr8.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getRealPath */
      /* Details: "The PortletContext.getRealPath method provides the same */
      /* functionality as the ServletContext.getRealPath method" */
      TestResult tr9 = tcd.getTestResultFailed(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETREALPATH);
      if (servletContext.getRealPath("./") == null) {
         if (portletContext.getRealPath("./") == null) {
            tr9.setTcSuccess(true);
         }
      } else {
         if (servletContext.getRealPath("./").equals(
             portletContext.getRealPath("./"))) {
            tr9.setTcSuccess(true);
         }
      }
      tr9.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getResource */
      /* Details: "The PortletContext.getResource method provides the same */
      /* functionality as the ServletContext.getResource method" */
      TestResult tr10 = tcd.getTestResultFailed(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETRESOURCE);
      if (portletContext.getResource("/").equals(servletContext.getResource("/"))) {
         tr10.setTcSuccess(true);
      }
      tr10.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getResourcePaths */
      /* Details: "The PortletContext.getResourcePaths method provides the */
      /* same functionality as the ServletContext.getResourcePaths method" */
      TestResult tr11 = tcd.getTestResultFailed(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETRESOURCEPATHS);
      if (portletContext.getResourcePaths("/").equals(servletContext.getResourcePaths("/"))) {
         tr11.setTcSuccess(true);
      }
      tr11.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_getResourceAsStream */
      /* Details: "The PortletContext.getResourceAsStream method provides */
      /* the same functionality as the ServletContext.getResourceAsStream */
      /* method" */
      {
         TestResult result = tcd.getTestResultFailed(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETRESOURCEASSTREAM);
         InputStream pcis = portletConfig.getPortletContext().getResourceAsStream(TESTFILE);
         InputStream scis = servletContext.getResourceAsStream(TESTFILE);
         if (pcis != null && scis != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(256);
            int val;

            while ((val = scis.read()) >= 0) {
               baos.write(val);
            }
            String scstr = baos.toString("UTF-8");

            baos.reset();
            while ((val = pcis.read()) >= 0) {
               baos.write(val);
            }
            String pcstr = baos.toString("UTF-8");
            CompareUtils.stringsEqual("ServletContext", scstr, "PortletContext", pcstr, result);

         } else {
            StringBuilder txt = new StringBuilder(128);
            txt.append("Test file could not be read.");
            txt.append(" stream from portlet context: ").append((pcis == null) ? "null" : "not null");
            txt.append(", stream from servlet context: ").append((scis == null) ? "null" : "not null");
            result.appendTcDetail(txt.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_log */
      /* Details: "The PortletContext.log method provides the same */
      /* functionality as the ServletContext.log method" */
      TestResult tr13 = tcd.getTestResultSucceeded(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_LOG);
      tr13.appendTcDetail("Test not possible. Ignored");
      tr13.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_removeAttribute */
      /* Details: "The PortletContext.removeAttribute method provides the */
      /* same functionality as the ServletContext.removeAttribute method" */
      TestResult tr14 = tcd.getTestResultFailed(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_REMOVEATTRIBUTE);
      portletContext.setAttribute("tr14", "true");
      servletContext.removeAttribute("tr14");
      if (portletContext.getAttribute("tr14") == null) {
         servletContext.setAttribute("tr14", "false");
         portletContext.removeAttribute("tr14");
         if (servletContext.getAttribute("tr14") == null) {
            tr14.setTcSuccess(true);
         } else {
            tr14.appendTcDetail("Failed because tr14 is not removed and its value is " + servletContext.getAttribute("tr14"));
         }
      } else {
         tr14.appendTcDetail("Failed because tr14 is not removed and its value is " + portletContext.getAttribute("tr14"));
      }
      tr14.writeTo(writer);

      /* TestCase: V2AddlEnvironmentTests_SPEC2_10_Context_setAttribute */
      /* Details: "The PortletContext.setAttribute method provides the same */
      /* functionality as the ServletContext.setAttribute method" */
      TestResult tr15 = tcd.getTestResultFailed(JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_SETATTRIBUTE);
      servletContext.setAttribute("tr15_a", "true");
      portletContext.setAttribute("tr15_b", "false");
      if (portletContext.getAttribute("tr15_a") != null && servletContext.getAttribute("tr15_b") != null
            && portletContext.getAttribute("tr15_a").equals("true") && servletContext.getAttribute("tr15_b").equals("false")) {
         tr15.setTcSuccess(true);
      }
      tr15.writeTo(writer);

   }

}
