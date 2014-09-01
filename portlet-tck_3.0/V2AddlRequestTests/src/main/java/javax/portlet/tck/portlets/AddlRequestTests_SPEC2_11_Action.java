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
 * portlet AddlRequestTests_SPEC2_11_Action_event
 *
 */
public class AddlRequestTests_SPEC2_11_Action implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlRequestTests_SPEC2_11_Action.class.getName();
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

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters1             */
      /* Details: "If a portlet receives a request from a client request      */
      /* targeted to the portlet itself, the parameters must be the string    */
      /* parameters encoded in the URL (added when creating the PortletURL)   */
      /* and the string parameters sent by the client to the portlet as       */
      /* part of the client request"                                          */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters2             */
      /* Details: "The parameters the request object returns must be          */
      /* \"x-www-form-urlencoded\" decoded"                                   */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters6             */
      /* Details: "The getParameterMap method must return an unmodifiable     */
      /* Map object"                                                          */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS6);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters8             */
      /* Details: "If the portlet is performing an HTML Form submission via   */
      /* HTTP method POST the post form data will be populated to the         */
      /* portlet request parameter set if the content type is                 */
      /* application/x-www-form-urlencoded"                                   */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS8);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters9             */
      /* Details: "If the portlet is performing an HTML Form submission via   */
      /* the HTTP method GET the form data set is appended to the portlet     */
      /* URL used for the form submission and are therefore accessible as     */
      /* request parameters for the portlet"                                  */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS9);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters15 */
      /* Details: "A map of private parameters can be obtained through the    */
      /* getPrivateParameterMap method"                                       */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS15);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters16 */
      /* Details: "A map of public parameters can be obtained through the     */
      /* getPublicParameterMap method"                                        */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS16);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters4 */
      /* Details: "Public render parameters are available in the              */
      /* processAction method"                                                */
      TestResult tr7 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS4);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters11 */
      /* Details: "If the portlet sets an action parameter with the same      */
      /* name as a public render parameter, this results in a multi-valued    */
      /* parameter. The public render parameter values must be the last       */
      /* entries in the parameter value array"                                */
      TestResult tr8 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS11);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_Action",
                   writer.toString(), APPLICATION_SCOPE);
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

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_Action", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_Action", APPLICATION_SCOPE);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters1             */
      /* Details: "If a portlet receives a request from a client request      */
      /* targeted to the portlet itself, the parameters must be the string    */
      /* parameters encoded in the URL (added when creating the PortletURL)   */
      /* and the string parameters sent by the client to the portlet as       */
      /* part of the client request"                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Action_parameters1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters2             */
      /* Details: "The parameters the request object returns must be          */
      /* \"x-www-form-urlencoded\" decoded"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Action_parameters2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters6             */
      /* Details: "The getParameterMap method must return an unmodifiable     */
      /* Map object"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Action_parameters6", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters8             */
      /* Details: "If the portlet is performing an HTML Form submission via   */
      /* HTTP method POST the post form data will be populated to the         */
      /* portlet request parameter set if the content type is                 */
      /* application/x-www-form-urlencoded"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Action_parameters8", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_parameters9             */
      /* Details: "If the portlet is performing an HTML Form submission via   */
      /* the HTTP method GET the form data set is appended to the portlet     */
      /* URL used for the form submission and are therefore accessible as     */
      /* request parameters for the portlet"                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Action_parameters9", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters15 */
      /* Details: "A map of private parameters can be obtained through the    */
      /* getPrivateParameterMap method"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters15", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters16 */
      /* Details: "A map of public parameters can be obtained through the     */
      /* getPublicParameterMap method"                                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters16", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters4 */
      /* Details: "Public render parameters are available in the              */
      /* processAction method"                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters11 */
      /* Details: "If the portlet sets an action parameter with the same      */
      /* name as a public render parameter, this results in a multi-valued    */
      /* parameter. The public render parameter values must be the last       */
      /* entries in the parameter value array"                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters11", aurl);
         tb.writeTo(writer);
      }

   }

}
