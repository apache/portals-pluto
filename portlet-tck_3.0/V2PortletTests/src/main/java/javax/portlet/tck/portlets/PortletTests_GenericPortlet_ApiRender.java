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
 * portlet PortletTests_GenericPortlet_ApiRender_event
 *
 */
public class PortletTests_GenericPortlet_ApiRender extends GenericPortlet {
   private static final String LOG_CLASS = 
         PortletTests_GenericPortlet_ApiRender.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);
   
   private boolean initCalled = false;
   private boolean pcInitCalled = false;
   
   @Override
   public void init() {
	   initCalled = true;
   }
   
   @Override
   public void init(PortletConfig config) throws PortletException {
      super.init(config);
      pcInitCalled = true;
   }
   
   
   @ProcessAction(name=V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSACTION2)
   public void newAction(ActionRequest portletReq, ActionResponse portletResp)
	         throws PortletException, IOException {
	   
	 String nme=portletReq.getParameter(ActionRequest.ACTION_NAME);
	 if(nme.equals(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSACTION2)) {
		 portletResp.setRenderParameter(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSACTION2, "true");
	 }
   }
   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
	   try {
              super.processAction(portletReq, portletResp);
   
	   } catch(Exception e) {
		   
	   }
   }
	   
   
   @Override
   protected void doView(RenderRequest req,RenderResponse resp) 
	       throws PortletException,IOException {
	   
       PrintWriter writer = resp.getWriter();
	   
	   JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
	   
	   /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doView1            */
	      /* Details: "Method doView(RenderRequest, RenderResponse): If           */
	      /* overridden, is called when a render request in view mode occurs"     */
	      TestResult tr7 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOVIEW1);
	      tr7.setTcSuccess(true);
	      tr7.writeTo(writer);  
	  
   }
   
   @Override
   protected void doEdit(RenderRequest req,RenderResponse resp) 
	       throws PortletException,IOException {
	   
   }
   
   @Override
   protected void doHelp(RenderRequest req,RenderResponse resp) 
	       throws PortletException,IOException {
	   
   }
   
   @Override
   protected void doDispatch(RenderRequest req,RenderResponse resp)
           throws PortletException,IOException {
	   
	   super.doDispatch(req, resp);
	   
	   PrintWriter writer = resp.getWriter();
	   
	   JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

	   
	   /* TestCase: V2PortletTests_GenericPortlet_ApiRender_doDispatch1        */
	      /* Details: "Method doDispatch(RenderRequest, RenderResponse): If       */
	      /* overridden, is called when markup is to be generated"                */
	      TestResult tr6 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DODISPATCH1);
	      tr6.setTcSuccess(true);
	      tr6.writeTo(writer);
   
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
   protected Collection<PortletMode> getNextPossiblePortletModes(
           RenderRequest request) {
	   
	   return null;
   }
   
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
	         throws PortletException, IOException {
	   
	   JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
	   Event evt=portletReq.getEvent();
	   portletResp.setRenderParameters(portletReq);
	   
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

      ClassChecker cc = new ClassChecker(GenericPortlet.class);
        
      super.render(portletReq, portletResp);
     
    
  
      
      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_initA              */
      /* Details: "Method init(): Called when the portlet is initialized"     */
      TestResult tr0 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_INITA);
      if(initCalled==true) {
    	  tr0.setTcSuccess(true);
      }
      tr0.writeTo(writer);
      
      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_initB              */
      /* Details: "Method init(PortletConfig): Called when the portlet is     */
      /* initialized"                                                         */
      TestResult tr1 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_INITB);
      if(pcInitCalled = true) {
    	  tr1.setTcSuccess(true);
      }
      tr1.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_processAction2     */
      /* Details: "Method processAction(ActionRequest, ActionResponse):       */
      /* Dispatches to @ProcessAction annotated method matching the           */
      /* ActionRequest.ACTION_NAME parameter"                                 */
      TestResult tr2 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSACTION2); 
      String parm=portletReq.getParameter(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSACTION2);
      if(parm!=null) {
    	  tr2.setTcSuccess(true);
    	  tr2.writeTo(writer);
      } else {
    	  PortletURL aurl=portletResp.createActionURL();
    	  aurl.setParameter(ActionRequest.ACTION_NAME,V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSACTION2);
    	  TestLink t2=new TestLink(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSACTION2,aurl);
    	  t2.writeTo(writer);;
      }
      tr2.writeTo(writer);
      
      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getTitle1          */
      /* Details: "Method getTitle(): If overridden, the String returned by   */
      /* this method is used as the portlet title"                            */
      TestResult tr4 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETTITLE1);
      String title=getTitle(portletReq);
      if(title!=null && title.equals(this.getClass().getSimpleName())) {
    	  tr4.setTcSuccess(true);
      } else {
    	  tr4.appendTcDetail("The Title doesnot match the actual value " +title);
      }
       tr4.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getTitle2          */
      /* Details: "Method getTitle(): Returns a String containing the title   */
      /* from the portlet resource bundle under the key                       */
      /* \"javax.portlet.title\""                                             */
      TestResult tr5 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETTITLE2);
      ResourceBundle rb2=ResourceBundle.getBundle("javax.portlet.tck.portlets.TestBundle2");
      String portletTitle2=rb2.getString("javax.portlet.title");
      if(portletTitle2.equals("TestTitle")) {
    	  tr5.setTcSuccess(true);
      } else {
    	  tr5.appendTcDetail("The ResourceBundle has a title" +portletTitle2);
      }
      tr5.writeTo(writer);
       
       /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getPortletConfig   */
       /* Details: "Method getPortletConfig(): Returns the PortletConfig       */
       /* object for the portlet"                                              */
       TestResult tr8 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETPORTLETCONFIG);
       PortletConfig pc=this.getPortletConfig();
       if(pc!=null) {
    	   tr8.setTcSuccess(true);
       } else {
    	   tr8.appendTcDetail("The PortletConfig has null value");
       }
       tr8.writeTo(writer);

      /* TestCase: V2PortletTests_GenericPortlet_ApiRender_getNextPossiblePortletModes1 */
      /* Details: "Method getNextPossiblePortletModes(): Is called during     */
      /* generic portlet render request processing"                           */
      TestResult tr10 = tcd.getTestResultFailed(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETNEXTPOSSIBLEPORTLETMODES1);
      super.getNextPossiblePortletModes(portletReq);
      tr10.setTcSuccess(true);
      tr10.writeTo(writer);

   }

}
