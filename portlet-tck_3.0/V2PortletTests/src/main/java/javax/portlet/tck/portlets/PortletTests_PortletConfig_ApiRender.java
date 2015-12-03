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
 * portlet PortletTests_PortletConfig_ApiRender_event
 *
 */
public class PortletTests_PortletConfig_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         PortletTests_PortletConfig_ApiRender.class.getName();
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

      ClassChecker cc = new ClassChecker(portletConfig.getClass());

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getPortletName      */
      /* Details: "Method getPortletName(): Returns a String containing the   */
      /* portlet name"                                                        */
      TestResult tr0 = tcd.getTestResultSucceeded(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPORTLETNAME);
      String portletName = portletConfig.getPortletName();
      if (!portletName.equals(this.getClass().getSimpleName())) {
         tr0.setTcSuccess(false);
         StringBuilder txt = new StringBuilder(128);
         txt.append("Portlet name did not match class name. Portlet name: ").append(portletName);
         txt.append(", Class name: ").append(this.getClass().getSimpleName());
         tr0.appendTcDetail(txt.toString());
      }
      tr0.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getPortletContext   */
      /* Details: "Method getPortletContext(): Returns the PortletContext     */
      /* object associated with the portlet"                                  */
      TestResult tr1 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPORTLETCONTEXT);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getResourceBundle   */
      /* Details: "Method getResourceBundle(Locale): Returns the              */
      /* ResourceBundle for the specified locale"                             */
      TestResult tr2 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETRESOURCEBUNDLE);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getInitParameter1   */
      /* Details: "Method getInitParameter(String): Returns a String          */
      /* containing the initialization parameter value for the given name"    */
      TestResult tr3 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETER1);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getInitParameter3   */
      /* Details: "Method getInitParameter(String): Throws                    */
      /* IllegalArgumentException if the name parameter is null"              */
      TestResult tr4 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETER3);
      try {
         try {
            String val = portletConfig.getInitParameter(null);
            tr4.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr4.setTcSuccess(true);
         } catch (Exception e) {
            tr4.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getInitParameterNames1 */
      /* Details: "Method getInitParameterNames(): Returns an                 */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the names   */
      /* of the initialization parameters"                                    */
      TestResult tr5 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETERNAMES1);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getPublicRenderParameterNames1 */
      /* Details: "Method getPublicRenderParameterNames(): Returns an         */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the names   */
      /* of the public render parameters"                                     */
      TestResult tr6 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPUBLICRENDERPARAMETERNAMES1);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getDefaultNamespace1 */
      /* Details: "Method getDefaultNamespace(): Returns a String             */
      /* containing the default namespace for events and public render        */
      /* parameters as defined in the deployment descriptor"                  */
      TestResult tr7 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETDEFAULTNAMESPACE1);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getPublishingEventQNames1 */
      /* Details: "Method getPublishingEventQNames(): Returns an              */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the         */
      /* publishing event qnames as defined in the deployment descriptor"     */
      TestResult tr8 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPUBLISHINGEVENTQNAMES1);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getProcessingEventQNames1 */
      /* Details: "Method getProcessingEventQNames(): Returns an              */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the         */
      /* processing event qnames as defined in the deployment descriptor"     */
      TestResult tr9 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPROCESSINGEVENTQNAMES1);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getSupportedLocales1 */
      /* Details: "Method getSupportedLocales(): Returns an                   */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the names   */
      /* of the supported locales as defined in the deployment descriptor"    */
      TestResult tr10 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETSUPPORTEDLOCALES1);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getContainerRuntimeOptions1 */
      /* Details: "Method getContainerRuntimeOptions(): Returns an            */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object      */
      /* containing the container runtime options as defined in the           */
      /* deployment descriptor"                                               */
      TestResult tr11 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS1);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getContainerRuntimeOptions2 */
      /* Details: "Method getContainerRuntimeOptions(): If the same option    */
      /* is defined at the portlet application and at the portlet level,      */
      /* the definition at the portlet level takes precedence"                */
      TestResult tr12 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS2);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getContainerRuntimeOptions3 */
      /* Details: "Method getContainerRuntimeOptions(): If the portlet        */
      /* container does not support a runtime option defined in the portlet   */
      /* descriptor, that option will not be returned in this map"            */
      TestResult tr13 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS3);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getContainerRuntimeOptions4 */
      /* Details: "Method getContainerRuntimeOptions(): Returns an empty      */
      /* map if no container runtime options have been defined "              */
      TestResult tr14 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS4);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

   }

}
