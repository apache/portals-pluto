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
public class AddlRequestTests_SPEC2_11_RequestParamsProps implements Portlet {
   private static final String LOG_CLASS = 
         AddlRequestTests_SPEC2_11_RequestParamsProps.class.getName();
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

      /* TestCase: SPEC2_11_RequestParamsProps_parameters1                    */
      /* Details: "If a portlet receives a request from a client request      */
      /* targeted to the portlet itself, the parameters must be the string    */
      /* parameters encoded in the URL (added when creating the PortletURL)   */
      /* and the string parameters sent by the client to the portlet as       */
      /* part of the client request"                                          */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_11_REQUESTPARAMSPROPS_PARAMETERS1);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestParamsProps_parameters2                    */
      /* Details: "The parameters the request object returns must be          */
      /* \"x-www-form-urlencoded\" decoded"                                   */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_11_REQUESTPARAMSPROPS_PARAMETERS2);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestParamsProps_parameters6                    */
      /* Details: "The getParameterMap method must return an unmodifiable     */
      /* Map object"                                                          */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_11_REQUESTPARAMSPROPS_PARAMETERS6);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestParamsProps_parameters8                    */
      /* Details: "If the portlet is performing an HTML Form submission via   */
      /* HTTP method POST the post form data will be populated to the         */
      /* portlet request parameter set if the content type is                 */
      /* application/x-www-form-urlencoded"                                   */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_11_REQUESTPARAMSPROPS_PARAMETERS8);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestParamsProps_parameters9                    */
      /* Details: "If the portlet is performing an HTML Form submission via   */
      /* the HTTP method GET the form data set is appended to the portlet     */
      /* URL used for the form submission and are therefore accessible as     */
      /* request parameters for the portlet"                                  */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_11_REQUESTPARAMSPROPS_PARAMETERS9);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestParamsProps_parameters10                   */
      /* Details: "The portlet-container must not propagate parameters        */
      /* received in an action or event request to subsequent render          */
      /* requests of the portlet"                                             */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_11_REQUESTPARAMSPROPS_PARAMETERS10);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestParamsProps_parameters11                   */
      /* Details: "If a portlet receives a render request that is the         */
      /* result of a client request targeted to another portlet in the        */
      /* portal page, the parameters should be the same parameters as of      */
      /* the previous render request from this client"                        */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_11_REQUESTPARAMSPROPS_PARAMETERS11);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestParamsProps_parameters12                   */
      /* Details: "If a portlet receives an event that is the result of a     */
      /* client request targeted to another portlet in the portal page, the   */
      /* parameters should be the same parameters as of the previous render   */
      /* request from this client"                                            */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_11_REQUESTPARAMSPROPS_PARAMETERS12);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestParamsProps_parameters13                   */
      /* Details: "If a portlet receives a render request that is the         */
      /* result of invoking a render URL targeting this portlet the render    */
      /* parameters received with the render request must be the parameters   */
      /* set on the render URL"                                               */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_11_REQUESTPARAMSPROPS_PARAMETERS13);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestParamsProps_parameters15                   */
      /* Details: "Render parameters get automatically cleared if the         */
      /* portlet receives a processAction or processEvent call"               */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_11_REQUESTPARAMSPROPS_PARAMETERS15);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_RequestParamsProps_parameters17                   */
      /* Details: "If the cacheability level of the resource URL is PORTLET   */
      /* or PAGE, the portlet must also receive the render parameters         */
      /* present in the request in which the URL was created"                 */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_11_REQUESTPARAMSPROPS_PARAMETERS17);
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


   }

}

