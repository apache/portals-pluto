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
import java.io.StringWriter;
import java.util.Collection;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.HeaderPortlet;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.MimeResponse;
import javax.portlet.PortalContext;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYA2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYC1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYC2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_SETPROPERTY1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_SETPROPERTY2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ENCODEURL1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ENCODEURL2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_GETNAMESPACE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT6;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC15_PortletResponse_ApiHeader")
public class HeaderPortletTests_SPEC15_PortletResponse_ApiHeader implements Portlet, HeaderPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

      PrintWriter writer = renderResponse.getWriter();
      String msg = (String) renderRequest.getAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_PortletResponse_ApiHeader");
      writer.write("<p>" + msg + "</p>");
      renderRequest.removeAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_PortletResponse_ApiHeader");

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyB1 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Adds an XML DOM */
      /* Element to the response for the specified key"                             */
      writer.write("<script type='text/javascript'>");
      writer.write("document.addEventListener('DOMContentLoaded', function(event) {");
      writer.write("  var scriptTag = document.getElementsByClassName('testProperty1');");
      writer.write("  if(scriptTag.length){");
      writer.write("    document.getElementById('V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyB1-result').innerHTML = 'Test Succeeded';");
      writer.write("  }");
      writer.write("});");
      writer.write("</script>");
      
      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyB2 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): If a DOM        */
      /* Element for the specified key already exists, the new element is added in  */
      /* addition to the existing element"                                          */
      writer.write("<script type='text/javascript'>");
      writer.write("document.addEventListener('DOMContentLoaded', function(event) {");
      writer.write("  var scriptTag = document.getElementsByClassName('testProperty2');");
      writer.write("  if(scriptTag.length){");
      writer.write("    document.getElementById('V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyB2-result').innerHTML = 'Test Succeeded';");
      writer.write("  }");
      writer.write("});");
      writer.write("</script>");

   }

   @Override
   public void renderHeaders(HeaderRequest headerRequest, HeaderResponse headerResponse)
         throws PortletException, IOException {
      
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      StringWriter writer = new StringWriter();
      
      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyA2 */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Throws            */
      /* IllegalArgumentException if the specified cookie is null"                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYA2);
         try{
            headerResponse.addProperty(null);
            result.appendTcDetail("Failed because no exception is raised.");
         } catch (IllegalArgumentException e){
           result.setTcSuccess(true);
           result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyB1 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Adds an XML DOM */
      /* Element to the response for the specified key"                             */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB1);
         if(headerRequest.getPortalContext().getProperty(PortalContext.MARKUP_HEAD_ELEMENT_SUPPORT)==null){
            result.setTcSuccess(true);
            result.appendTcDetail("addProperty(String, org.w3c.dom.Element) is not supported by portlal");
         } else {
            Element element = headerResponse.createElement("script");
            element.setAttribute("class", "testProperty1");
            headerResponse.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, element);
         } 
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyB2 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): If a DOM        */
      /* Element for the specified key already exists, the new element is added in  */
      /* addition to the existing element"                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB2);
         if(headerRequest.getPortalContext().getProperty(PortalContext.MARKUP_HEAD_ELEMENT_SUPPORT)==null){
            result.setTcSuccess(true);
            result.appendTcDetail("addProperty(String, org.w3c.dom.Element) is not supported by portlal");
         } else {
            Element element = headerResponse.createElement("script");
            element.setAttribute("class", "testProperty2");
            headerResponse.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, element);
         } 
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyB4 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Throws          */
      /* IllegalArgumentException if the specified key is null"                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB4);
         try{
            Element testElement = headerResponse.createElement("script");
            headerResponse.addProperty(null,testElement);
            result.appendTcDetail("Failed because no exception is raised.");
         } catch (IllegalArgumentException e){
           result.setTcSuccess(true);
           result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyC1 */
      /* Details: "Method addProperty(String, String): Adds a property value to an  */
      /* existing key to allow the key to have multiple values"                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYC1);
         headerResponse.addProperty("Access-Control-Allow-Origin", "/test1");
         headerResponse.addProperty("Access-Control-Allow-Origin", "/test2");
         Collection<String> corsHeader = headerResponse.getPropertyValues("Access-Control-Allow-Origin");
         if(corsHeader.contains("/test1") && corsHeader.contains("/test2")){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because multiple values are not ser for Access-Control-Allow-Origin response header");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyC2 */
      /* Details: "Method addProperty(String, String): Throws                       */
      /* IllegalArgumentException if the specified key is null"                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYC2);
         try{
            headerResponse.addProperty(null,"/test1");
            result.appendTcDetail("Failed because no exception is raised.");
         } catch (IllegalArgumentException e){
           result.setTcSuccess(true);
           result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_setProperty1 */
      /* Details: "Method setProperty(String, String): Sets a property value for    */
      /* the specified key"                                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_SETPROPERTY1);
         headerResponse.setProperty("Access-Control-Allow-Origin", "/test3");
         if(headerResponse.getProperty("Access-Control-Allow-Origin")!=null
               && headerResponse.getProperty("Access-Control-Allow-Origin").equals("/test3")){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because Access-Control-Allow-Origin response header is not set");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_setProperty2 */
      /* Details: "Method setProperty(String, String): Resets any existing property */
      /* values for the specified key"                                              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_SETPROPERTY2);
         Collection<String> corsHeader = headerResponse.getPropertyValues("Access-Control-Allow-Origin");
         
         if(corsHeader.contains("/test3") && !corsHeader.contains("/test1") && !corsHeader.contains("/test2")){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because Access-Control-Allow-Origin response header still had old values.");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_encodeURL1 */
      /* Details: "Method encodeURL(String): Returns a String representing the      */
      /* encoded URL"                                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ENCODEURL1);
         String encodedURL = headerResponse.encodeURL("/testing special$chars#in<url>");
         if(encodedURL!=null){
            result.setTcSuccess(true);
            result.appendTcDetail("/testing special$chars#in<url> is encoded as - " + encodedURL);
         } else {
            result.appendTcDetail("Failed because encoded URL is null");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_encodeURL2 */
      /* Details: "Method encodeURL(String): Throws IllegalArgumentException if the */
      /* input string is not an absolute URL and does not start with at \"/\"       */
      /* character"                                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ENCODEURL2);
         try{
            headerResponse.encodeURL("invalidURL");
            result.appendTcDetail("Failed because no exception is raised.");
         } catch (IllegalArgumentException e){
           result.setTcSuccess(true);
           result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_getNamespace1 */
      /* Details: "Method getNamespace(): Returns a String containing the namespace */
      /* value"                                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_GETNAMESPACE1);
         if(headerResponse.getNamespace()!=null){
            result.setTcSuccess(true);
            result.appendTcDetail("Namespace is found to be - "+headerResponse.getNamespace());
         } else {
            result.appendTcDetail("Failed because namespace is null");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement1 */
      /* Details: "Method createElement(String): Returns an org.w3c.dom.Element     */
      /* object for the specified tag name"                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT1);
         Element testElement = headerResponse.createElement("testTag");
         if(testElement.getTagName().equals("testTag")){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because element is not created with \"testTag\" tag name but "+testElement.getTagName());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement2 */
      /* Details: "Method createElement(String): The returned Element has nodeName  */
      /* set to the the specified tag name "                                        */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT2);
         Element testElement = headerResponse.createElement("testTag");
         if(testElement.getNodeName().equals("testTag")){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because element is not created with \"testTag\" node name but "+testElement.getNodeName());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement3 */
      /* Details: "Method createElement(String): The returned Element has localName */
      /* set to null"                                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT3);
         Element testElement = headerResponse.createElement("testTag");
         if(testElement.getLocalName()==null){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because element is not created with \"null\" local name but "+testElement.getLocalName());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement4 */
      /* Details: "Method createElement(String): The returned Element has prefix    */
      /* set to null"                                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT4);
         Element testElement = headerResponse.createElement("testTag");
         if(testElement.getPrefix()==null){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because element is not created with \"null\" prefix but "+testElement.getPrefix());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement5 */
      /* Details: "Method createElement(String): The returned Element has           */
      /* namespaceURI set to null"                                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT5);
         Element testElement = headerResponse.createElement("testTag");
         if(testElement.getNamespaceURI()==null){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because element is not created with \"null\" namespace URI but "+testElement.getNamespaceURI());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement6 */
      /* Details: "Method createElement(String): Throws org.w3c.dom.DOMException -  */
      /* INVALID_CHARACTER_ERR if the specified name contains an illegal character. */
      /* "                                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT6);
         try{
            headerResponse.createElement("<invalidTag>");
            result.appendTcDetail("Failed because no exception is raised while creating element with name <invalidTag>");
         } catch (DOMException e) {
            result.setTcSuccess(true);
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }
      
      headerRequest.setAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_PortletResponse_ApiHeader",
            writer.toString());
   }

}
