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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETDEFAULTNAMESPACE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETER1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETER3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETERNAMES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPORTLETCONTEXT;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPORTLETNAME;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPROCESSINGEVENTQNAMES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPUBLICRENDERPARAMETERNAMES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPUBLISHINGEVENTQNAMES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETRESOURCEBUNDLE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETSUPPORTEDLOCALES1;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.xml.namespace.QName;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for
 * events, this portlet will initiate the events, but not process them. The
 * processing is done in the companion portlet
 * PortletTests_PortletConfig_ApiRender_event
 *
 */
public class PortletTests_PortletConfig_ApiRender implements Portlet {

   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getPortletName */
      /* Details: "Method getPortletName(): Returns a String containing the */
      /* portlet name" */
      TestResult tr0 = tcd.getTestResultSucceeded(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPORTLETNAME);
      String portletName = portletConfig.getPortletName();
      if (!portletName.equals(this.getClass().getSimpleName())) {
         tr0.setTcSuccess(false);
         StringBuilder txt = new StringBuilder(128);
         txt.append("Portlet name did not match class name. Portlet name: ")
               .append(portletName);
         txt.append(", Class name: ").append(this.getClass().getSimpleName());
         tr0.appendTcDetail(txt.toString());
      }
      tr0.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getPortletContext */
      /* Details: "Method getPortletContext(): Returns the PortletContext */
      /* object associated with the portlet" */
      TestResult tr1 = tcd.getTestResultSucceeded(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPORTLETCONTEXT);
      PortletContext pc = portletConfig.getPortletContext();
      if (pc == null) {
         tr1.setTcSuccess(false);
         StringBuilder txt = new StringBuilder(128);
         txt.append("The Portlet Context is null");
         tr1.appendTcDetail(txt.toString());
      }
      tr1.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getResourceBundle */
      /* Details: "Method getResourceBundle(Locale): Returns the */
      /* ResourceBundle for the specified locale" */
      TestResult tr2 = tcd.getTestResultSucceeded(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETRESOURCEBUNDLE);
      Locale loc = portletReq.getLocale();
      ResourceBundle rb = portletConfig.getResourceBundle(loc);
      if (rb != null) {
         tr2.setTcSuccess(true);
      } else {
         tr2.appendTcDetail("The Resource Bundle Does not exist");
      }
      tr2.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getInitParameter1 */
      /* Details: "Method getInitParameter(String): Returns a String */
      /* containing the initialization parameter value for the given name" */
      TestResult tr3 = tcd.getTestResultSucceeded(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETER1);
      String val = portletConfig.getInitParameter("param1");
      if ((val == null) || !val.equals("value1")) {
         tr3.setTcSuccess(false);
         StringBuilder txt3 = new StringBuilder(128);
         txt3.append("Value for param1 was not 'value1' but ").append(val);
         tr3.appendTcDetail(txt3.toString());
      }
      tr3.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getInitParameter3 */
      /* Details: "Method getInitParameter(String): Throws */
      /* IllegalArgumentException if the name parameter is null" */
      TestResult tr4 = tcd.getTestResultFailed(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETER3);
      try {
         try {
            String val1 = portletConfig.getInitParameter(null);
            tr4.appendTcDetail("Method did not throw an exception." + val1);
         } catch (IllegalArgumentException iae) {
            tr4.setTcSuccess(true);
         } catch (Exception e) {
            tr4.appendTcDetail(e.toString());
         }
      } catch (Exception e) {
         tr4.appendTcDetail(e.toString());
      }
      tr4.writeTo(writer);

      /*
       * TestCase: V2PortletTests_PortletConfig_ApiRender_getInitParameterNames1
       */
      /* Details: "Method getInitParameterNames(): Returns an */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the names */
      /* of the initialization parameters" */
      TestResult tr5 = tcd.getTestResultFailed(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETERNAMES1);
      Enumeration<String> parms = portletConfig.getInitParameterNames();
      List<String> list = Collections.list(parms);
      if (list.size() == 3) {
         if (list.contains("param1") && list.contains("param2")
               && list.contains("param3")) {
            tr5.setTcSuccess(true);
         } else {
            tr5.appendTcDetail(
                  "Parameter names don't match: " + list.toString());
         }
      } else {
         tr5.appendTcDetail(
               "Parameter name enumeration had invalid length: " + list.size());
      }
      tr5.writeTo(writer);

      /*
       * TestCase:
       * V2PortletTests_PortletConfig_ApiRender_getPublicRenderParameterNames1
       */
      /* Details: "Method getPublicRenderParameterNames(): Returns an */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the names */
      /* of the public render parameters" */
      TestResult tr6 = tcd.getTestResultFailed(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPUBLICRENDERPARAMETERNAMES1);
      Enumeration<String> Renderparms = portletConfig
            .getPublicRenderParameterNames();
      List<String> list1 = Collections.list(Renderparms);
      if (list1.size() == 1) {
         if (list1.contains("tckPRP1")) {
            tr6.setTcSuccess(true);
         } else {
            tr6.appendTcDetail("Public render Parameter did not match  :"
                  + list1.toString());
         }
      } else {
         tr6.appendTcDetail("Parameter name had invalid length" + list1.size());
      }
      tr6.writeTo(writer);

      /*
       * TestCase: V2PortletTests_PortletConfig_ApiRender_getDefaultNamespace1
       */
      /* Details: "Method getDefaultNamespace(): Returns a String */
      /* containing the default namespace for events and public render */
      /* parameters as defined in the deployment descriptor" */
      TestResult tr7 = tcd.getTestResultFailed(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETDEFAULTNAMESPACE1);
      String str = portletConfig.getDefaultNamespace();
      if (str.equals("https://www.apache.org")) {
         tr7.setTcSuccess(true);
      } else {
         tr7.appendTcDetail("The default namespace is :" + str.toString());
      }
      tr7.writeTo(writer);

      /*
       * TestCase:
       * V2PortletTests_PortletConfig_ApiRender_getPublishingEventQNames1
       */
      /* Details: "Method getPublishingEventQNames(): Returns an */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the */
      /* publishing event qnames as defined in the deployment descriptor" */
      TestResult tr8 = tcd.getTestResultFailed(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPUBLISHINGEVENTQNAMES1);
      Enumeration<QName> pubeventqname = portletConfig
            .getPublishingEventQNames();
      List<QName> list8 = Collections.list(pubeventqname);
      if (list8.size() == 1) {
         QName goodQN = new QName(
               "http://www.apache.org/portals/pluto/portlet-tck_3.0",
               "PortletTests_Event_ApiEvent");
         if (goodQN.equals(list8.get(0))) {
            tr8.setTcSuccess(true);
         } else {
            tr8.appendTcDetail(
                  "The PublishingEventQNames does not match the actual value :"
                        + list8.toString());
         }
      } else {
         tr8.appendTcDetail(
               "PublishingEventQNames had invalid length" + list8.size());
      }
      tr8.writeTo(writer);

      /*
       * TestCase:
       * V2PortletTests_PortletConfig_ApiRender_getProcessingEventQNames1
       */
      /* Details: "Method getProcessingEventQNames(): Returns an */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the */
      /* processing event qnames as defined in the deployment descriptor" */
      TestResult tr9 = tcd.getTestResultFailed(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPROCESSINGEVENTQNAMES1);
      Enumeration<QName> proeventqname = portletConfig
            .getProcessingEventQNames();
      List<QName> list9 = Collections.list(proeventqname);
      if (list9.size() == 1) {
         QName goodQN = new QName(
               "http://www.apache.org/portals/pluto/portlet-tck_3.0",
               "PortletTests_Event_ApiEvent");
         if (goodQN.equals(list9.get(0))) {
            tr9.setTcSuccess(true);
         } else {
            tr9.appendTcDetail(
                  "The ProcessingEventQNames does not match the actual value :"
                        + list9.toString());
         }
      } else {
         tr9.appendTcDetail(
               "PublishingEventQNames had invalid length" + list9.size());
      }
      tr9.writeTo(writer);

      /*
       * TestCase: V2PortletTests_PortletConfig_ApiRender_getSupportedLocales1
       */
      /* Details: "Method getSupportedLocales(): Returns an */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the names */
      /* of the supported locales as defined in the deployment descriptor" */
      TestResult tr10 = tcd.getTestResultFailed(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETSUPPORTEDLOCALES1);
      ArrayList<Locale> list10 = Collections
            .list(portletConfig.getSupportedLocales());
      if (list10.size() == 1) {
         if (list10.contains(Locale
               .forLanguageTag(Locale.forLanguageTag("en").toLanguageTag()))) {
            tr10.setTcSuccess(true);
         } else {
            tr10.appendTcDetail(
                  "Locales did not match   :" + list10.toString());
         }
      } else {
         tr10.appendTcDetail("Locales had invalid length" + list10.size());
      }
      tr10.writeTo(writer);

      /*
       * different containers expect different options
       */
      PortletContext portletContext = portletConfig.getPortletContext();
      String expectedSize = portletContext.getInitParameter("javax.portlet.portletConfig.getContainerRuntimeOptions.EXPECTED_SIZE");
      String expectedOption = portletContext.getInitParameter("javax.portlet.portletConfig.getContainerRuntimeOptions.EXPECTED_OPTION");
      String expectedValue = portletContext.getInitParameter("javax.portlet.portletConfig.getContainerRuntimeOptions.EXPECTED_VALUE");

      /*
       * TestCase:
       * V2PortletTests_PortletConfig_ApiRender_getContainerRuntimeOptions1
       */
      /* Details: "Method getContainerRuntimeOptions(): Returns an */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object */
      /* containing the container runtime options as defined in the */
      /* deployment descriptor" */
      TestResult tr11 = tcd.getTestResultFailed(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS1);
      Map<String, String[]> runoption1 = portletConfig
            .getContainerRuntimeOptions();

      if (runoption1.size() == Integer.parseInt(expectedSize)) {
         if (runoption1 != null && runoption1
               .containsKey(expectedOption)) {
            tr11.setTcSuccess(true);
         } else {
            tr11.appendTcDetail(
                  "No supported runtime options are defined in deployment descriptor");
         }
      } else {
         tr11.appendTcDetail("The container Runtime Options had invalid length"
               + runoption1.size());
      }

      tr11.writeTo(writer);

      /*
       * TestCase:
       * V2PortletTests_PortletConfig_ApiRender_getContainerRuntimeOptions2
       */
      /* Details: "Method getContainerRuntimeOptions(): If the same option */
      /* is defined at the portlet application and at the portlet level, */
      /* the definition at the portlet level takes precedence" */
      TestResult tr12 = tcd.getTestResultFailed(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS2);
      Map<String, String[]> runoption2 = portletConfig
            .getContainerRuntimeOptions();
      String[] val5 = runoption2.get(expectedOption);
      if (runoption2.size() == Integer.parseInt(expectedSize)) {
         if (runoption2 != null
               && runoption2.containsKey(expectedOption)
               && val5[0].equals(expectedValue)) {
            tr12.setTcSuccess(true);
         } else {
            tr12.appendTcDetail(
                  "No supported runtime options are defined in deployment descriptor");
         }
      } else {
         tr12.appendTcDetail("The container Runtime Options had invalid length"
               + runoption2.size());
      }
      tr12.writeTo(writer);

      /*
       * TestCase:
       * V2PortletTests_PortletConfig_ApiRender_getContainerRuntimeOptions3
       */
      /* Details: "Method getContainerRuntimeOptions(): If the portlet */
      /* container does not support a runtime option defined in the portlet */
      /* descriptor, that option will not be returned in this map" */
      TestResult tr13 = tcd.getTestResultFailed(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS3);
      Map<String, String[]> runoption3 = portletConfig
            .getContainerRuntimeOptions();
      if (runoption3.size() == Integer.parseInt(expectedSize)) {
         if (runoption3 != null && !runoption3.containsKey("newruntimeoption")) {
            tr13.setTcSuccess(true);
         } else {
            tr13.appendTcDetail(
                  "No supported runtime options are defined in deployment descriptor");
         }
      } else {
         tr13.appendTcDetail("The container Runtime Options had invalid length"
               + runoption3.size());
      }
      tr13.writeTo(writer);

   }

}
