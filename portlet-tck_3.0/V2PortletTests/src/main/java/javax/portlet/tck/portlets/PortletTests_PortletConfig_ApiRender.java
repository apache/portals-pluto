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
private static final Locale Locale = null;
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
      String portletName=portletConfig.getPortletName();
      if (!portletName.equals(this.getClass().getSimpleName())) {
    	  tr0.setTcSuccess(false);
    	  StringBuilder txt=new StringBuilder(128);
    	  txt.append("Portlet Name did not match Class name. Portlet name:").append(portletName);
    	  txt.append(", Class name:").append(this.getClass().getSimpleName());
          tr0.appendTcDetail(txt.toString());
       }
      tr0.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getPortletContext   */
      /* Details: "Method getPortletContext(): Returns the PortletContext     */
      /* object associated with the portlet"                                  */
      TestResult tr1 = tcd.getTestResultSucceeded(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPORTLETCONTEXT);
      PortletContext pc=portletConfig.getPortletContext();
      if (pc==null) {
    	 tr1.setTcSuccess(false);
    	 StringBuilder txt=new StringBuilder(128);
         txt.append("The Portlet Context is null");
         tr1.appendTcDetail(txt.toString());
    	  
      }
      
      tr1.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getResourceBundle   */
      /* Details: "Method getResourceBundle(Locale): Returns the              */
      /* ResourceBundle for the specified locale"                             */
      TestResult tr2 = tcd.getTestResultSucceeded(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETRESOURCEBUNDLE);
      Locale loc=java.util.Locale.getDefault();
      ResourceBundle rb=portletConfig.getResourceBundle(loc);
      StringBuilder txt2=new StringBuilder(128);
      txt2.append("The value is").append(rb);
      tr2.appendTcDetail(txt2.toString());
      tr2.writeTo(writer);

      
      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getInitParameter1   */
      /* Details: "Method getInitParameter(String): Returns a String          */
      /* containing the initialization parameter value for the given name"    */
      TestResult tr3 = tcd.getTestResultSucceeded(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETERNAMES1);
      String val = portletConfig.getInitParameter("param1");
      if ((val == null) || !val.equals("value1")) {
         tr3.setTcSuccess(false);
         StringBuilder txt3 = new StringBuilder(128);
         txt3.append("Value for param1 was not 'value1' but ").append(val);
         tr3.appendTcDetail(txt3.toString());
      }
      tr3.writeTo(writer);
      

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getInitParameter3   */
      /* Details: "Method getInitParameter(String): Throws                    */
      /* IllegalArgumentException if the name parameter is null"              */
      TestResult tr4 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETER3);
      try {
         try {
            String val1 = portletConfig.getInitParameter(null);
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
      Enumeration<String> parms = portletConfig.getInitParameterNames();
      List<String> list = Collections.list(parms);
      if (list.size() == 3 ) {
         if (list.contains("param1") && list.contains("param2") && list.contains("param3")) {
            tr5.setTcSuccess(true);
         } else {
            tr5.appendTcDetail("Parameter names don't match: " + list.toString());
         }
      } else {
         tr5.appendTcDetail("Parameter name enumeration had invalid length: " + list.size());
      }
      tr5.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getPublicRenderParameterNames1 */
      /* Details: "Method getPublicRenderParameterNames(): Returns an         */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the names   */
      /* of the public render parameters"                                     */
      TestResult tr6 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPUBLICRENDERPARAMETERNAMES1);
      Enumeration<String> Renderparms = portletConfig.getPublicRenderParameterNames();
      List<String> list1 = Collections.list(Renderparms);
      if (list1.size() == 1 ) {
           if (list1.contains("tckPRP1")) {
    	       tr6.setTcSuccess(true);
           } else {
    	        tr6.appendTcDetail("Public render Parameter did not match  :" +list1.toString());
             }
      } else {
    	  tr6.appendTcDetail("Parameter name had invalid length" +list1.size());
      }
      tr6.writeTo(writer);
      
      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getDefaultNamespace1 */
      /* Details: "Method getDefaultNamespace(): Returns a String             */
      /* containing the default namespace for events and public render        */
      /* parameters as defined in the deployment descriptor"                  */
      TestResult tr7 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETDEFAULTNAMESPACE1);
      String str =portletConfig.getDefaultNamespace();
      StringBuilder txt7=new StringBuilder(128);
      if(str.equals("https://www.apache.org")) {
    	  tr7.setTcSuccess(true);
      } else { 
          txt7.append("The default namespace is :").append(str);
          tr7.appendTcDetail(txt7.toString());
         }   
      tr7.writeTo(writer);
      
      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getPublishingEventQNames1 */
      /* Details: "Method getPublishingEventQNames(): Returns an              */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the         */
      /* publishing event qnames as defined in the deployment descriptor"     */
      TestResult tr8 = tcd.getTestResultSucceeded(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPUBLISHINGEVENTQNAMES1);
      Enumeration<QName> eventqname=portletConfig.getPublishingEventQNames();
      List<QName> list8=Collections.list(eventqname);
      StringBuilder txt8=new StringBuilder(128);
      txt8.append("Number of entries: ").append(list8.size()).append(", Values: ");
      String sep = "";
      for (QName qn : list8) {
    	  txt8.append(sep).append(qn.toString());
    	  sep = ", ";
      }
      tr8.appendTcDetail(txt8.toString());
      tr8.writeTo(writer);
      
      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getProcessingEventQNames1 */
      /* Details: "Method getProcessingEventQNames(): Returns an              */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the         */
      /* processing event qnames as defined in the deployment descriptor"     */
      TestResult tr9 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPROCESSINGEVENTQNAMES1);
      Enumeration<QName> nm1=portletConfig.getProcessingEventQNames();
      QName qname1=new QName("http://www.apache.org/portals/pluto/portlet-tck_3.0", "PortletTests_Event_ApiEvent");
      if (nm1 == null) {
          tr9.appendTcDetail("PublishEventQName is null.");
       } else if (!nm1.equals(qname1)) {
          StringBuilder txt9 = new StringBuilder(128);
          txt9.append("PublishEventQName is not expected value.");
          txt9.append(" Expected: ").append(qname1);
          txt9.append(" Actual: ").append(nm1);
          tr9.appendTcDetail(txt9.toString());
         }
        tr9.writeTo(writer);


      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getSupportedLocales1 */
      /* Details: "Method getSupportedLocales(): Returns an                   */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the names   */
      /* of the supported locales as defined in the deployment descriptor"    */
      TestResult tr10 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETSUPPORTEDLOCALES1);
      Enumeration<java.util.Locale> locale=portletConfig.getSupportedLocales();
      List<Locale> list10 = Collections.list(locale);
      if (list10.size() == 1 ) {
          if (list10.contains(Locale.forLanguageTag("en_us"))) {
   	       tr10.setTcSuccess(true);
          } else {
   	        tr10.appendTcDetail("Locales did not match  :" +list10.toString());
            }
     } else {
   	  tr10.appendTcDetail("Locales had invalid length" +list10.size());
     }
     tr10.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender_getContainerRuntimeOptions1 */
      /* Details: "Method getContainerRuntimeOptions(): Returns an            */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object      */
      /* containing the container runtime options as defined in the           */
      /* deployment descriptor"                                               */
      TestResult tr11 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS1);
      Map<String,String[]> runoption=portletConfig.getContainerRuntimeOptions();
      String[] val2 = runoption.get("somename");
      Set<String> keys = runoption.keySet();
    		  
    
      

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

   }

}
