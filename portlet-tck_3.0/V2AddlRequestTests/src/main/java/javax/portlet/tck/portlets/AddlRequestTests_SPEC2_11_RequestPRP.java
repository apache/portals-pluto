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

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */
public class AddlRequestTests_SPEC2_11_RequestPRP implements Portlet {
   private static final String LOG_CLASS = 
         AddlRequestTests_SPEC2_11_RequestPRP.class.getName();
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
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
         throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest renderRequest, RenderResponse renderResponse)
         throws PortletException, IOException {
      
      if (LOGGER.isLoggable(Level.FINE)) {
         LOGGER.logp(Level.FINE, LOG_CLASS, "render", "Entry");
      }

      PrintWriter writer = renderResponse.getWriter();
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: SPEC2_11_RequestPRP_publicRenderParameters1                */
      /* Details: "Public render parameters can be declared in the            */
      /* deployment descriptor using the public-render-parameter element"     */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_11_REQUESTPRP_PUBLICRENDERPARAMETERS1);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestPRP_publicRenderParameters2                */
      /* Details: "The portlet can specify the public render parameters it    */
      /* would like to share via the supported-public-render-parameter        */
      /* element in the deployment descriptor"                                */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_11_REQUESTPRP_PUBLICRENDERPARAMETERS2);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestPRP_publicRenderParameters4                */
      /* Details: "Public render parameters are available in the              */
      /* processAction method"                                                */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_11_REQUESTPRP_PUBLICRENDERPARAMETERS4);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestPRP_publicRenderParameters5                */
      /* Details: "Public render parameters are available in the              */
      /* processEvent method"                                                 */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_11_REQUESTPRP_PUBLICRENDERPARAMETERS5);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestPRP_publicRenderParameters6                */
      /* Details: "Public render parameters are available in the render       */
      /* method"                                                              */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_11_REQUESTPRP_PUBLICRENDERPARAMETERS6);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestPRP_publicRenderParameters7                */
      /* Details: "Public render parameters are available in the              */
      /* serveResource method"                                                */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_11_REQUESTPRP_PUBLICRENDERPARAMETERS7);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestPRP_publicRenderParameters8                */
      /* Details: "The portlet container must only send those public render   */
      /* parameters to a portlet which the portlet has defined support for    */
      /* using supported-public-render-parameter element in the               */
      /* portlet.xml"                                                         */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_11_REQUESTPRP_PUBLICRENDERPARAMETERS8);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestPRP_publicRenderParameters9                */
      /* Details: "The portlet container must only share those render         */
      /* parameters of a portlet which the portlet has declared as            */
      /* supported public render parameters using                             */
      /* supported-public-render-parameter element in the portlet.xml"        */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_11_REQUESTPRP_PUBLICRENDERPARAMETERS9);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestPRP_publicRenderParameters10               */
      /* Details: "If the portlet was the target of a render URL on which a   */
      /* specific public render parameter is set, the portlet must receive    */
      /* at least this render parameter"                                      */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_11_REQUESTPRP_PUBLICRENDERPARAMETERS10);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestPRP_publicRenderParameters11               */
      /* Details: "If the portlet sets an action parameter with the same      */
      /* name as a public render parameter, this results in a multi-valued    */
      /* parameter. The public render parameter values must be the last       */
      /* entries in the parameter value array"                                */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_11_REQUESTPRP_PUBLICRENDERPARAMETERS11);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestPRP_publicRenderParameters12               */
      /* Details: "If the portlet sets a resource parameter with the same     */
      /* name as a public render parameter, this results in a multi-valued    */
      /* parameter. The public render parameter values must be the last       */
      /* entries in the parameter value array"                                */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_11_REQUESTPRP_PUBLICRENDERPARAMETERS12);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestPRP_publicRenderParameters13               */
      /* Details: "A public render parameter can be deleted using the         */
      /* removePublicRenderParameter method on the StateAwareResponse or      */
      /* the PortletURL"                                                      */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_11_REQUESTPRP_PUBLICRENDERPARAMETERS13);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestPRP_publicRenderParameters15               */
      /* Details: "A map of private parameters can be obtained through the    */
      /* getPrivateParameterMap method"                                       */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_11_REQUESTPRP_PUBLICRENDERPARAMETERS15);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestPRP_publicRenderParameters16               */
      /* Details: "A map of public parameters can be obtained through the     */
      /* getPublicParameterMap method"                                        */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_11_REQUESTPRP_PUBLICRENDERPARAMETERS16);
      /* TODO: implement test */



      // Write the results to the output stream

      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);
      tr3.writeTo(writer);
      tr4.writeTo(writer);
      tr5.writeTo(writer);
      tr6.writeTo(writer);
      tr7.writeTo(writer);
      tr8.writeTo(writer);
      tr9.writeTo(writer);
      tr10.writeTo(writer);
      tr11.writeTo(writer);
      tr12.writeTo(writer);
      tr13.writeTo(writer);


   }

}

