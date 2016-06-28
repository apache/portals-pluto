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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLET_APIRENDER_INIT1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLET_APIRENDER_RENDER1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_PORTLET_APIRENDER_RENDER2;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet PortletTests_Portlet_ApiRender_event
 *
 */
public class PortletTests_Portlet_ApiRender implements Portlet {
   
   private PortletConfig portletConfig = null;
   
   private boolean initCalled = false;
   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
      initCalled=true;
   }
   
   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {

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

      /* TestCase: V2PortletTests_Portlet_ApiRender_init1                     */
      /* Details: "Method init(PortletConfig): is called for the portlet      */
      /* defined in the deployment descriptor"                                */
      TestResult tr0 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLET_APIRENDER_INIT1);
      String name=portletConfig.getPortletName();
      try {
         if(name.equals(this.getClass().getSimpleName()) && initCalled==true) 
    	       tr0.setTcSuccess(true);
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      
      tr0.writeTo(writer);
      
      /* TestCase: V2PortletTests_Portlet_ApiRender_render1                   */
      /* Details: "Method render(RenderRequest, RenderResponse): is called    */
      /* when the portlet is to be rendered"                                  */
      TestResult tr1 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLET_APIRENDER_RENDER1);
      tr1.setTcSuccess(true);
      tr1.writeTo(writer);

      /* TestCase: V2PortletTests_Portlet_ApiRender_render2                   */
      /* Details: "Method render(RenderRequest, RenderResponse): is called    */
      /* when a Render URL for the portlet is triggered"                      */
      TestResult tr2 = tcd.getTestResultFailed(V2PORTLETTESTS_PORTLET_APIRENDER_RENDER2);
      {
          PortletURL rurl = portletResp.createRenderURL();
          rurl.setPortletMode(PortletMode.VIEW);
          tr2.setTcSuccess(true);       
          tr2.writeTo(writer);
       }
   }

}
