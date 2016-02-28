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
 * portlet PortletTests_PortletMode_ApiRender_event
 *
 */
public class PortletTests_PortletMode_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         PortletTests_PortletMode_ApiRender.class.getName();
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
     
      PortletMode mode=portletReq.getPortletMode();
      
      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletReq.getPortletMode().getClass());

      /* TestCase: V2PortletTests_PortletMode_ApiRender_constructor1          */
      /* Details: "The constructor PortletMode(java.lang.String): allows a    */
      /* PortletMode object of the specified name to be constructed"          */
      TestResult tr0 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETMODE_APIRENDER_CONSTRUCTOR1);
      WindowState ws=new WindowState("newmode");
      if(ws!=null && ws.toString().equals("newmode")) {
    	  tr0.setTcSuccess(true);
      } else {
    	  tr0.appendTcDetail("The Portlet Mode is null");
      }
       tr0.writeTo(writer);

      /* TestCase: V2PortletTests_PortletMode_ApiRender_constructor2          */
      /* Details: "The constructor PortletMode(java.lang.String): converts    */
      /* any upper case letters in the name parameter to lower case"          */
      TestResult tr1 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETMODE_APIRENDER_CONSTRUCTOR2);
      WindowState ws1=new WindowState("NEWMODE");
      if(ws1!=null && ws1.toString().equals("newmode")) {
    	  tr1.setTcSuccess(true);
      } else {
    	  tr1.appendTcDetail("The Portlet Mode is null");
      }
      tr1.writeTo(writer);

      /* TestCase: V2PortletTests_PortletMode_ApiRender_fieldEDIT             */
      /* Details: "Has PortletMode field EDIT with value of                   */
      /* PortletMode.EDIT "                                                   */
      TestResult tr2 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETMODE_APIRENDER_FIELDEDIT);
      try {
         tr2.setTcSuccess(cc.hasField("EDIT", PortletMode.EDIT));
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2PortletTests_PortletMode_ApiRender_fieldHELP             */
      /* Details: "Has PortletMode field HELP with value of                   */
      /* PortletMode.HELP "                                                   */
      TestResult tr3 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETMODE_APIRENDER_FIELDHELP);
      try {
         tr3.setTcSuccess(cc.hasField("HELP", PortletMode.HELP));
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2PortletTests_PortletMode_ApiRender_fieldVIEW             */
      /* Details: "Has PortletMode field VIEW with value of                   */
      /* PortletMode.VIEW "                                                   */
      TestResult tr4 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETMODE_APIRENDER_FIELDVIEW);
      try {
         tr4.setTcSuccess(cc.hasField("VIEW", PortletMode.VIEW));
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2PortletTests_PortletMode_ApiRender_toString              */
      /* Details: "Method toString(): Returns a String representation of      */
      /* the portlet mode"                                                    */
      TestResult tr5 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETMODE_APIRENDER_TOSTRING);
      String tstring=mode.toString();
      if(tstring.equals("view")) {
    	  tr5.setTcSuccess(true);
      } else {
          tr5.appendTcDetail("String Representation of Portlet Mode: "+mode.toString());  
         }
       tr5.writeTo(writer);
      

      /* TestCase: V2PortletTests_PortletMode_ApiRender_hashCode              */
      /* Details: "Method hashCode(): Returns an int containing the has       */
      /* code for the portlet mode"                                           */
      TestResult tr6 = tcd.getTestResultSucceeded(V2PORTLETTESTS_PORTLETMODE_APIRENDER_HASHCODE);
      Object hcode=mode.hashCode();
      if(!hcode.equals(hcode)) {
    	  tr6.setTcSuccess(true);
    	  tr6.appendTcDetail("hashCode code value for Portlet Mode: "+hcode.toString());
       }
       tr6.writeTo(writer);
      

      /* TestCase: V2PortletTests_PortletMode_ApiRender_equals                */
      /* Details: "Method equals(): Returns true if the PortletMode equals    */
      /* the specified PortletMode"                                           */
      TestResult tr7 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLETMODE_APIRENDER_EQUALS);
      Object obj=portletReq.getPortletMode();
      if(obj instanceof PortletMode) {
    	  tr7.setTcSuccess(true);
      }  else {
    		  tr7.appendTcDetail("The PortletMode does not equals the expected value"+obj.toString());
      }
      tr7.writeTo(writer);
   }

}
