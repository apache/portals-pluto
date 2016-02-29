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
import javax.xml.xpath.XPathConstants;
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
 * portlet PortletTests_PortletConfig_ApiRender2_event
 *
 */
public class PortletTests_PortletConfig_ApiRender2 implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         PortletTests_PortletConfig_ApiRender2.class.getName();
private static final String XMLConstants = null;
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

      /* TestCase: V2PortletTests_PortletConfig_ApiRender2_getInitParameter2  */
      /* Details: "Method getInitParameter(String): Returns null if the       */
      /* specified initialization parameter does not exist"                   */
      TestResult tr0 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETINITPARAMETER2);
      String val = portletConfig.getInitParameter("param1");
      if (val == null) {
         tr0.setTcSuccess(true);
      } else {
         tr0.appendTcDetail(" The value for the parameter is : " +val);
    
      }
      tr0.writeTo(writer);
      
      /* TestCase: V2PortletTests_PortletConfig_ApiRender2_getInitParameterNames2 */
      /* Details: "Method getInitParameterNames(): Returns an empty           */
      /* Enumeration if there are no initialization parameters available "    */
      TestResult tr1 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETINITPARAMETERNAMES2);
      Enumeration<String> parms = portletConfig.getInitParameterNames();
      List<String> list1 = Collections.list(parms);
      if (list1.size() == 0 ) {
            tr1.setTcSuccess(true);
      } else {
            tr1.appendTcDetail("The Init Parameter names are : " +list1.toString());
           }
      tr1.writeTo(writer);   
      
      /* TestCase: V2PortletTests_PortletConfig_ApiRender2_getPublicRenderParameterNames2 */
      /* Details: "Method getPublicRenderParameterNames(): Returns an empty   */
      /* Enumeration if there are no public render parameters are defined "   */
      TestResult tr2 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETPUBLICRENDERPARAMETERNAMES2);
      Enumeration<String> Renderparms = portletConfig.getPublicRenderParameterNames();
      List<String> list2 = Collections.list(Renderparms);
      if (list2.size() == 0 ) {
    	       tr2.setTcSuccess(true);
           } else {
    	        tr2.appendTcDetail("Public render Parameters are  :" +list2.toString());
             }
      tr2.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender2_getDefaultNamespace2 */
      /* Details: "Method getDefaultNamespace(): Returns                      */
      /* XMLConstants.NULL_NS_URI if no default namespace is defined in the   */
      /* deployment descriptor "                                              */
      TestResult tr3 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETDEFAULTNAMESPACE2);
      String str =portletConfig.getDefaultNamespace();
      if(str==null || str.equals("https://www.apache.org")) {
    	  tr3.setTcSuccess(true);
      } else {
    	  tr3.appendTcDetail("The default Namespace is :" +str);
      }
       tr3.writeTo(writer);

      /* TestCase: V2PortletTests_PortletConfig_ApiRender2_getPublishingEventQNames2 */
      /* Details: "Method getPublishingEventQNames(): Returns an empty        */
      /* Enumeration if there are no processing events are defined"           */
      TestResult tr4 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETPUBLISHINGEVENTQNAMES2);
      Enumeration<QName> pubevntqname=portletConfig.getPublishingEventQNames();
      List<QName> list4=Collections.list(pubevntqname);
      if(list4.size()==0) {
    	  tr4.setTcSuccess(true);
      } else {
    	  tr4.appendTcDetail("The Publish Event Qnames are "+list4.toString());
      }
       tr4.writeTo(writer);


      /* TestCase: V2PortletTests_PortletConfig_ApiRender2_getProcessingEventQNames2 */
      /* Details: "Method getProcessingEventQNames(): Returns an empty        */
      /* Enumeration if there are no processing events are defined"           */
      TestResult tr5 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETPROCESSINGEVENTQNAMES2);
      Enumeration<QName> proevntqname=portletConfig.getProcessingEventQNames();
      List<QName> list5=Collections.list(proevntqname);
      if(list5.size()==0) {
    	  tr5.setTcSuccess(true);
      } else {
    	  tr5.appendTcDetail("The Process Event Qnames are "+list5.toString());
      }
      tr5.writeTo(writer);


      /* TestCase: V2PortletTests_PortletConfig_ApiRender2_getSupportedLocales2 */
      /* Details: "Method getSupportedLocales(): Returns an empty             */
      /* Enumeration if there are no supported locales are defined"           */
      TestResult tr6 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETSUPPORTEDLOCALES2);
      Enumeration<java.util.Locale> locale=portletConfig.getSupportedLocales();
      List<Locale> list10 = Collections.list(locale);
      if (list10.size() == 0 ) {
   	       tr6.setTcSuccess(true);
          } else {
   	        tr6.appendTcDetail("The supported Locales are :" +list10.toString());
          }
       tr6.writeTo(writer);

   }

}
