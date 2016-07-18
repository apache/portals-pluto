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

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC15_PortletResponse_ApiHeader")
public class HeaderPortletTests_SPEC15_PortletResponse_ApiHeader implements Portlet {
   
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

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyA1 */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Adds the          */
      /* specified cookie property to the response"                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYA1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyA2 */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Throws            */
      /* IllegalArgumentException if the specified cookie is null"                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYA2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyB1 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Adds an XML DOM */
      /* Element to the response for the specified key"                             */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyB2 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): If a DOM        */
      /* Element for the specified key already exists, the new element is added in  */
      /* addition to the existing element"                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyB3 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): If the          */
      /* specified DOM Element value is null, the key is removed from the response" */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyB4 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Throws          */
      /* IllegalArgumentException if the specified key is null"                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB4);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyC1 */
      /* Details: "Method addProperty(String, String): Adds a property value to an  */
      /* existing key to allow the key to have multiple values"                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYC1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyC2 */
      /* Details: "Method addProperty(String, String): Throws                       */
      /* IllegalArgumentException if the specified key is null"                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYC2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_setProperty1 */
      /* Details: "Method setProperty(String, String): Sets a property value for    */
      /* the specified key"                                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_SETPROPERTY1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_setProperty2 */
      /* Details: "Method setProperty(String, String): Resets any existing property */
      /* values for the specified key"                                              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_SETPROPERTY2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_setProperty3 */
      /* Details: "Method setProperty(String, String): Throws                       */
      /* IllegalArgumentException if the specified key is null"                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_SETPROPERTY3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_encodeURL1 */
      /* Details: "Method encodeURL(String): Returns a String representing the      */
      /* encoded URL"                                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ENCODEURL1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_encodeURL2 */
      /* Details: "Method encodeURL(String): Throws IllegalArgumentException if the */
      /* input string is not an absolute URL and does not start with at \"/\"       */
      /* character"                                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ENCODEURL2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_getNamespace1 */
      /* Details: "Method getNamespace(): Returns a String containing the namespace */
      /* value"                                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_GETNAMESPACE1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement1 */
      /* Details: "Method createElement(String): Returns an org.w3c.dom.Element     */
      /* object for the specified tag name"                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement2 */
      /* Details: "Method createElement(String): The returned Element has nodeName  */
      /* set to the the specified tag name "                                        */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement3 */
      /* Details: "Method createElement(String): The returned Element has localName */
      /* set to null"                                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement4 */
      /* Details: "Method createElement(String): The returned Element has prefix    */
      /* set to null"                                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT4);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement5 */
      /* Details: "Method createElement(String): The returned Element has           */
      /* namespaceURI set to null"                                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT5);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement6 */
      /* Details: "Method createElement(String): Throws org.w3c.dom.DOMException -  */
      /* INVALID_CHARACTER_ERR if the specified name contains an illegal character. */
      /* "                                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT6);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

   }

}
