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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_RENDERREQUEST_APIRENDER_FIELDETAG;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_RENDERREQUEST_APIRENDER_GETETAG2;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet RequestTests_RenderRequest_ApiRender_event
 *
 */
public class RequestTests_RenderRequest_ApiRender implements Portlet, ResourceServingPortlet {

   private final Logger LOGGER = LoggerFactory.getLogger(RequestTests_RenderRequest_ApiRender.class);

   @Override
   public void init(PortletConfig config) throws PortletException {
      
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("main portlet processAction entry");

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      

   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("main portlet serveResource entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletReq.getClass());

      /* TestCase: V2RequestTests_RenderRequest_ApiRender_fieldETAG           */
      /* Details: "Has String field ETAG with value of \"portlet.ETag\" "     */
      TestResult tr0 = tcd.getTestResultFailed(V2REQUESTTESTS_RENDERREQUEST_APIRENDER_FIELDETAG);
      try {
         tr0.setTcSuccess(cc.hasField("ETAG", "portlet.ETag"));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2RequestTests_RenderRequest_ApiRender_getETag2            */
      /* Details: "Method getETag(): Returns null if there is no cached       */
      /* response"                                                            */
      TestResult tr1 = tcd.getTestResultFailed(V2REQUESTTESTS_RENDERREQUEST_APIRENDER_GETETAG2);
      String etag=portletReq.getETag();
      if(etag==null) {
    	  tr1.setTcSuccess(true);
      } else {
    	  tr1.appendTcDetail("A cahched Response for this Validation Tag has Value: "+etag);
      }
      tr1.writeTo(writer);

   }

}
