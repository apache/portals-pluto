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
 * portlet AddlRequestTests_SPEC2_11_Render_event
 *
 */
public class AddlRequestTests_SPEC2_11_Render implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlRequestTests_SPEC2_11_Render.class.getName();
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

      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters10            */
      /* Details: "The portlet-container must not propagate parameters        */
      /* received in an action or event request to subsequent render          */
      /* requests of the portlet"                                             */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS10);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters11            */
      /* Details: "If a portlet receives a render request that is the         */
      /* result of a client request targeted to another portlet in the        */
      /* portal page, the parameters should be the same parameters as of      */
      /* the previous render request from this client"                        */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS11);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters13            */
      /* Details: "If a portlet receives a render request that is the         */
      /* result of invoking a render URL targeting this portlet the render    */
      /* parameters received with the render request must be the parameters   */
      /* set on the render URL"                                               */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS13);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters15            */
      /* Details: "Render parameters get automatically cleared if the         */
      /* portlet receives a processAction or processEvent call"               */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS15);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters1             */
      /* Details: "If a portlet receives a request from a client request      */
      /* targeted to the portlet itself, the parameters must be the string    */
      /* parameters encoded in the URL (added when creating the PortletURL)   */
      /* and the string parameters sent by the client to the portlet as       */
      /* part of the client request"                                          */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS1);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters2             */
      /* Details: "The parameters the request object returns must be          */
      /* \"x-www-form-urlencoded\" decoded"                                   */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS2);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters6             */
      /* Details: "The getParameterMap method must return an unmodifiable     */
      /* Map object"                                                          */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS6);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters15 */
      /* Details: "A map of private parameters can be obtained through the    */
      /* getPrivateParameterMap method"                                       */
      TestResult tr7 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS15);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters16 */
      /* Details: "A map of public parameters can be obtained through the     */
      /* getPublicParameterMap method"                                        */
      TestResult tr8 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS16);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters1 */
      /* Details: "Public render parameters can be declared in the            */
      /* deployment descriptor using the public-render-parameter element"     */
      TestResult tr9 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS1);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters2 */
      /* Details: "The portlet can specify the public render parameters it    */
      /* would like to share via the supported-public-render-parameter        */
      /* element in the deployment descriptor"                                */
      TestResult tr10 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS2);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters6 */
      /* Details: "Public render parameters are available in the render       */
      /* method"                                                              */
      TestResult tr11 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS6);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters13 */
      /* Details: "A public render parameter can be deleted using the         */
      /* removePublicRenderParameter method on the StateAwareResponse "       */
      TestResult tr12 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS13);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters13a */
      /* Details: "A public render parameter can be deleted using the         */
      /* removePublicRenderParameter method on the PortletURL"                */
      TestResult tr13 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS13A);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

   }

}
