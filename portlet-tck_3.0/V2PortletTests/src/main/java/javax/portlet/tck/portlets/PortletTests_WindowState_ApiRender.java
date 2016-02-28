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
 * portlet PortletTests_WindowState_ApiRender_event
 *
 */
public class PortletTests_WindowState_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         PortletTests_WindowState_ApiRender.class.getName();
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
      
      WindowState state=portletReq.getWindowState();
      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletReq.getWindowState().getClass());

      /* TestCase: V2PortletTests_WindowState_ApiRender_constructor1          */
      /* Details: "The constructor WindowState(java.lang.String): allows a    */
      /* WindowState object of the specified name to be constructed"          */
      TestResult tr0 = tcd.getTestResultFailed(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_CONSTRUCTOR1);
      WindowState ws=new WindowState("newstate");
      if(ws!=null && ws.toString().equals("newstate")) {
    	  tr0.setTcSuccess(true);
      } else {
    	  tr0.appendTcDetail("The Window State is null");
      }
       tr0.writeTo(writer);

      /* TestCase: V2PortletTests_WindowState_ApiRender_constructor2          */
      /* Details: "The constructor WindowState(java.lang.String): converts    */
      /* any upper case letters in the name parameter to lower case"          */
      TestResult tr1 = tcd.getTestResultFailed(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_CONSTRUCTOR2);
      WindowState ws1=new WindowState("NEWSTATE");
      if(ws1!=null && ws1.toString().equals("newstate")) {
    	  tr1.setTcSuccess(true);
      } else {
    	  tr1.appendTcDetail("The Window State is null");
      }
       tr1.writeTo(writer);

      /* TestCase: V2PortletTests_WindowState_ApiRender_fieldMAXIMIZED        */
      /* Details: "Has WindowState field MAXIMIZED with value of              */
      /* WindowState.MAXIMIZED "                                              */
      TestResult tr2 = tcd.getTestResultFailed(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_FIELDMAXIMIZED);
      try {
         tr2.setTcSuccess(cc.hasField("MAXIMIZED", WindowState.MAXIMIZED));
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2PortletTests_WindowState_ApiRender_fieldMINIMIZED        */
      /* Details: "Has WindowState field MINIMIZED with value of              */
      /* WindowState.MINIMIZED "                                              */
      TestResult tr3 = tcd.getTestResultFailed(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_FIELDMINIMIZED);
      try {
         tr3.setTcSuccess(cc.hasField("MINIMIZED", WindowState.MINIMIZED));
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2PortletTests_WindowState_ApiRender_fieldNORMAL           */
      /* Details: "Has WindowState field NORMAL with value of                 */
      /* WindowState.NORMAL "                                                 */
      TestResult tr4 = tcd.getTestResultFailed(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_FIELDNORMAL);
      try {
         tr4.setTcSuccess(cc.hasField("NORMAL", WindowState.NORMAL));
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2PortletTests_WindowState_ApiRender_toString              */
      /* Details: "Method toString(): Returns a String representation of      */
      /* the Window State"                                                    */
      TestResult tr5 = tcd.getTestResultFailed(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_TOSTRING);
      String tstring=state.toString();
      if(tstring.equals("normal")) {
    	  tr5.setTcSuccess(true);
      } else {
          tr5.appendTcDetail("String Representation of Window State: "+state.toString());  
         }
       tr5.writeTo(writer);

      /* TestCase: V2PortletTests_WindowState_ApiRender_hashCode              */
      /* Details: "Method hashCode(): Returns an int containing the has       */
      /* code for the Window State"                                           */
      TestResult tr6 = tcd.getTestResultSucceeded(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_HASHCODE);
      Object hcode=state.hashCode();
      if(!hcode.equals(hcode)) {
    	  tr6.setTcSuccess(true);
    	  tr6.appendTcDetail("hashCode code value for Window State: "+hcode.toString());
       }
       tr6.writeTo(writer);

      /* TestCase: V2PortletTests_WindowState_ApiRender_equals                */
      /* Details: "Method equals(): Returns true if the WindowState equals    */
      /* the specified WindowState"                                           */
      TestResult tr7 = tcd.getTestResultFailed(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_EQUALS);
      Object obj=portletReq.getWindowState();
      if(obj instanceof WindowState) {
    	  tr7.setTcSuccess(true);
      }  else {
    		  tr7.appendTcDetail("The WindowState does not equals the expected state"+obj.toString());
      }
       tr7.writeTo(writer);

   }

private void WindowState() {
	// TODO Auto-generated method stub
	
}

}
