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
import javax.portlet.annotations.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import static javax.portlet.tck.util.ModuleTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC15_Header")
public class HeaderPortletTests_SPEC15_Header implements Portlet {
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters10                  */
      /* Details: "The portlet-container must not propagate parameters received in  */
      /* an action or event request to subsequent header requests of the portlet"   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS10);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters11                  */
      /* Details: "If a portlet receives a render request that is the result of a   */
      /* client request targeted to another portlet in the portal page, the         */
      /* parameters should be the same parameters as of the previous render request */
      /* from this client"                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS11);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters13                  */
      /* Details: "If a portlet receives a render request that is the result of     */
      /* invoking a render URL targeting this portlet the render parameters         */
      /* received with the render request must be the parameters set on the render  */
      /* URL"                                                                       */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS13);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters15                  */
      /* Details: "Render parameters get automatically cleared if the portlet       */
      /* receives a processAction or processEvent call"                             */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS15);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_properties1                   */
      /* Details: "The portlet can use the getProperty method to access single      */
      /* portal property and optionally-available HTTP header values"               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_properties2                   */
      /* Details: "The portlet can use the getProperties method to access multiple  */
      /* portal property and optionally-available HTTP header values by the same    */
      /* property name"                                                             */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_properties3                   */
      /* Details: "The portlet can use the getPropertyNames method to obtain an     */
      /* Enumeration of all available property names"                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_properties4                   */
      /* Details: "The portlet can access cookies provided by the current request   */
      /* using the getCookies method"                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES4);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters1                   */
      /* Details: "If a portlet receives a request from a client request targeted   */
      /* to the portlet itself, the parameters must be the string parameters        */
      /* encoded in the URL (added when creating the PortletURL) and the string     */
      /* parameters sent by the client to the portlet as part of the client         */
      /* request"                                                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters2                   */
      /* Details: "The parameters the header object returns must be                 */
      /* \"x-www-form-urlencoded\" decoded"                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters3                   */
      /* Details: "The getParameterValues method returns an array of String objects */
      /* containing all the parameter values associated with a parameter name"      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters4                   */
      /* Details: "The value returned from the getParameter method must be the      */
      /* first value in the array of String objects returned by getParameterValues" */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS4);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters6                   */
      /* Details: "The getParameterMap method must return an unmodifiable Map       */
      /* object"                                                                    */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS6);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters7                   */
      /* Details: "If the request does not have any parameters, the getParameterMap */
      /* must return an empty Map object"                                           */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS7);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_publicRenderParameters14      */
      /* Details: "Portlets can access a merged set of public and private           */
      /* parameters via the getParameter methods"                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS14);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_publicRenderParameters15      */
      /* Details: "A map of private parameters can be obtained through the          */
      /* getPrivateParameterMap method"                                             */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS15);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_publicRenderParameters16      */
      /* Details: "A map of public parameters can be obtained through the           */
      /* getPublicParameterMap method"                                              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS16);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_publicRenderParameters6       */
      /* Details: "Public render parameters are available in the header method"     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS6);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_publicRenderParameters13a     */
      /* Details: "A public render parameter can be deleted using the               */
      /* removePublicRenderParameter method on the PortletURL"                      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS13A);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_cookie8                       */
      /* Details: "Cookies set during the Header phase should be available to the   */
      /* portlet during the Resource phase"                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE8);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_cookie9                       */
      /* Details: "Cookies set during the Header phase should be available to the   */
      /* portlet during a subsequent Action phase"                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE9);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_cookie10                      */
      /* Details: "Cookies set during the Header phase should be available to the   */
      /* portlet during a subsequent Render phase"                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE10);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_cookie11                      */
      /* Details: "Cookies set during the Header phase should be available to the   */
      /* portlet during a subsequent request triggered by a URL"                    */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE11);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_cookie12                      */
      /* Details: "Cookies set during the Header phase after the response has been  */
      /* committed are ignored"                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE12);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_contentType5                  */
      /* Details: "If the setContentType method is not called before the getWriter  */
      /* or getPortletOutputStream method is used, the portlet container uses the   */
      /* content type returned by getResponseContentType"                           */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_CONTENTTYPE5);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_characterEncoding2            */
      /* Details: "The character encoding can be set via the setLocale method and a */
      /* locale-encoding-mapping-list mapping in the web.xml deployment descriptor" */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_CHARACTERENCODING2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_characterEncoding3            */
      /* Details: "The character encoding can be set via the setContentType method  */
      /* if the given content type string provides a value for the charset          */
      /* attribute"                                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_CHARACTERENCODING3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_characterEncoding4            */
      /* Details: "If the portlet does not set the character encoding, the portlet  */
      /* container uses UTF-8 as the default character encoding"                    */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_CHARACTERENCODING4);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

   }

}
