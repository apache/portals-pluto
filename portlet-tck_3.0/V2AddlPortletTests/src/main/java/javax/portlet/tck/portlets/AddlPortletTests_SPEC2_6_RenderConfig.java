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
 * portlet AddlPortletTests_SPEC2_6_RenderConfig_event
 *
 */
public class AddlPortletTests_SPEC2_6_RenderConfig implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlPortletTests_SPEC2_6_RenderConfig.class.getName();
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

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getResourceBundle1 */
      /* Details: "The resource bundle defined in the deployment descriptor   */
      /* &lt;resource-bundle&gt; element can be obtained through the          */
      /* PortletConfig object"                                                */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getResourceBundle2 */
      /* Details: "If the resource bundle contains a                          */
      /* \"javax.portlet.title\" property, the value defined in the bundle    */
      /* is returned by the corresponding getString method call"              */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getResourceBundle3 */
      /* Details: "If the resource bundle contains a                          */
      /* \"javax.portlet.short-title\" property, the value defined in the     */
      /* bundle is returned by the corresponding getString method call"       */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getResourceBundle4 */
      /* Details: "If the resource bundle contains a                          */
      /* \"javax.portlet.keywords\" property, the value defined in the        */
      /* bundle is returned by the corresponding getString method call"       */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getPublishingEventQnames3 */
      /* Details: "getPublishingEventQnames - If the event was defined        */
      /* using the &lt;name&gt; element rather than the &lt;qname&gt;         */
      /* element, default namespace defined with the                          */
      /* &lt;default-namespace&gt; element must be added as the event         */
      /* namespace"                                                           */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPUBLISHINGEVENTQNAMES3);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getPublishingEventQnames4 */
      /* Details: "getPublishingEventQnames - If the event was defined        */
      /* using the &lt;name&gt; element rather than the &lt;qname&gt;         */
      /* element and there is no default namespace defined, the value         */
      /* XMLConstants.NULL_NS_URI must be added as the event namespace"       */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPUBLISHINGEVENTQNAMES4);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getProcessingEventQnames3 */
      /* Details: "getProcessingEventQnames - If the event was defined        */
      /* using the &lt;name&gt; element rather than the &lt;qname&gt;         */
      /* element, default namespace defined with the                          */
      /* &lt;default-namespace&gt; element must be added as the event         */
      /* namespace"                                                           */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPROCESSINGEVENTQNAMES3);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getProcessingEventQnames4 */
      /* Details: "getProcessingEventQnames - If the event was defined        */
      /* using the &lt;name&gt; element rather than the &lt;qname&gt;         */
      /* element and there is no default namespace defined, the value         */
      /* XMLConstants.NULL_NS_URI must be added as the event namespace"       */
      TestResult tr7 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPROCESSINGEVENTQNAMES4);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getContainerRuntimeOptions6 */
      /* Details: "The returned Map contains values defined in the            */
      /* deployment descriptor &lt;container-runtime-option&gt; elements at   */
      /* the portlet application level"                                       */
      TestResult tr8 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS6);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getContainerRuntimeOptions7 */
      /* Details: "The returned Map contains values defined in the            */
      /* deployment descriptor &lt;container-runtime-option&gt; elements at   */
      /* the portlet level"                                                   */
      TestResult tr9 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS7);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getContainerRuntimeOptions8 */
      /* Details: "If the deployment descriptor contains                      */
      /* &lt;container-runtime-option&gt; elements defined at both the        */
      /* portlet and the portlet application levels, the returned Map         */
      /* contains a merger of all values"                                     */
      TestResult tr10 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS8);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getContainerRuntimeOptions9 */
      /* Details: "If the deployment descriptor contains                      */
      /* &lt;container-runtime-option&gt; elements of the same name defined   */
      /* at both the portlet and the portlet application levels, the          */
      /* returned Map contains a the value defined at the portlet level"      */
      TestResult tr11 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS9);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

   }

}
