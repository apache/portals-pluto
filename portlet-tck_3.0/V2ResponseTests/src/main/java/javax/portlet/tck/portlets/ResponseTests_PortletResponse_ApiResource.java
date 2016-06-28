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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYA2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYC1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYC2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_SETPROPERTY1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_SETPROPERTY2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_SETPROPERTY3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ENCODEURL1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ENCODEURL2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_GETNAMESPACE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT6;
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
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for
 * events, this portlet will initiate the events, but not process them. The
 * processing is done in the companion portlet
 * ResponseTests_PortletResponse_ApiResource_event
 *
 */
public class ResponseTests_PortletResponse_ApiResource
      implements Portlet, ResourceServingPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

   }

   @Override
   public void serveResource(ResourceRequest portletReq,
         ResourceResponse portletResp) throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyA1 */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Adds the */
      /* specified cookie property to the response" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYA1);
      tr0.setTcSuccess(true);
      tr0.appendTcDetail(
            "This Method Could not be tested as Specified Property cannot be added to the response for this Test Portlets ");
      tr0.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyA2 */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Throws */
      /* IllegalArgumentException if the specified cookie is null" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYA2);
      try {
         try {
            portletResp.addProperty(null);
            tr1.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr1.setTcSuccess(true);
         } catch (Exception e) {
            tr1.appendTcDetail(e.toString());
         }
      } catch (Exception e) {
         tr1.appendTcDetail(e.toString());
      }
      tr1.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyB1 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Adds an */
      /* XML DOM Element to the response for the specified key" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB1);
      tr2.setTcSuccess(true);
      tr2.appendTcDetail(
            "This Method Could not be tested as XML DOM element cannot be added to the response for this Test Portlets ");
      tr2.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyB2 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): If a */
      /* DOM Element for the specified key already exists, the new element */
      /* is added in addition to the existing element" */
      TestResult tr3 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB2);
      tr3.setTcSuccess(true);
      tr3.appendTcDetail(
            "This Method Could not be tested as XML DOM element cannot be added to the response for this Test Portlets ");
      tr3.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyB3 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): If the */
      /* specified DOM Element value is null, the key is removed from the */
      /* response" */
      TestResult tr4 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB3);
      tr4.setTcSuccess(true);
      tr4.appendTcDetail(
            "This Method Could not be tested as XML DOM element cannot be added to the response for this Test Portlets ");
      tr4.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyB4 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Throws */
      /* IllegalArgumentException if the specified key is null" */
      TestResult tr5 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB4);
      try {
         try {
            org.w3c.dom.Element el = portletResp.createElement("p");
            portletResp.addProperty((String) null, el);
            tr5.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr5.setTcSuccess(true);
         } catch (Exception e) {
            tr5.appendTcDetail(e.toString());
         }
      } catch (Exception e) {
         tr5.appendTcDetail(e.toString());
      }
      tr5.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyC1 */
      /* Details: "Method addProperty(String, String): A property can be */
      /* added" */
      TestResult tr6 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYC1);
      tr6.setTcSuccess(true);
      tr6.appendTcDetail(
            "This Method could not be Tested as Property cannot be added to the Response for this Test Portlet");
      tr6.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_addPropertyC2 */
      /* Details: "Method addProperty(String, String): Throws */
      /* IllegalArgumentException if the specified key is null" */
      TestResult tr7 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYC2);
      try {
         try {
            portletResp.addProperty(null, "value");
            tr7.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr7.setTcSuccess(true);
         } catch (Exception e) {
            tr7.appendTcDetail(e.toString());
         }
      } catch (Exception e) {
         tr7.appendTcDetail(e.toString());
      }
      tr7.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_setProperty1 */
      /* Details: "Method setProperty(String, String): Sets a property */
      /* value for the specified key" */
      TestResult tr8 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_SETPROPERTY1);
      tr8.setTcSuccess(true);
      tr8.appendTcDetail(
            "This Method Could not be Tested as Property value cannot be added to Response for this Test Portlet");
      tr8.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_setProperty2 */
      /* Details: "Method setProperty(String, String): Resets any existing */
      /* property values for the specified key" */
      TestResult tr9 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_SETPROPERTY2);
      tr9.setTcSuccess(true);
      tr9.appendTcDetail(
            "This Method Could not be Tested as Property value cannot be added to Response for this Test Portlet");
      tr9.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_setProperty3 */
      /* Details: "Method setProperty(String, String): Throws */
      /* IllegalArgumentException if the specified key is null" */
      TestResult tr10 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_SETPROPERTY3);
      try {
         try {
            portletResp.setProperty(null, "value");
            tr10.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr10.setTcSuccess(true);
         } catch (Exception e) {
            tr10.appendTcDetail(e.toString());
         }
      } catch (Exception e) {
         tr10.appendTcDetail(e.toString());
      }
      tr10.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_encodeURL1 */
      /* Details: "Method encodeURL(String): Returns a String representing */
      /* the encoded URL" */
      TestResult tr11 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ENCODEURL1);
      try {
         String ecode = portletResp.encodeURL("/sample.img");
         if (ecode.equals("/sample.img")) {
            tr11.setTcSuccess(true);
         }
      } catch (IllegalArgumentException iae) {
         tr11.appendTcDetail(iae.toString());
      }
      tr11.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_encodeURL2 */
      /* Details: "Method encodeURL(String): Throws */
      /* IllegalArgumentException if the input string is not an absolute */
      /* URL and does not start with at \"/\" character" */
      TestResult tr12 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ENCODEURL2);
      try {
         portletResp.encodeURL("sample.img");
         tr12.appendTcDetail("Method Did not Throw Exception");
      } catch (IllegalArgumentException iae) {
         tr12.setTcSuccess(true);
      }
      tr12.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_getNamespace1 */
      /* Details: "Method getNamespace(): Returns a String containing the */
      /* namespace value" */
      TestResult tr13 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_GETNAMESPACE1);
      String getName = portletResp.getNamespace();
      if (getName != null) {
         tr13.setTcSuccess(true);
      }
      tr13.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_createElement1 */
      /* Details: "Method createElement(String): Returns an */
      /* org.w3c.dom.Element object for the specified tag name" */
      TestResult tr14 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT1);
      try {
         org.w3c.dom.Element el = portletResp.createElement("Test1");
         if (el.getTagName().toString().equals("Test1")) {
            tr14.setTcSuccess(true);
         }

      } catch (org.w3c.dom.DOMException de) {
         tr14.appendTcDetail(de.toString());
      }
      tr14.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_createElement2 */
      /* Details: "Method createElement(String): The returned Element has */
      /* nodeName set to the the specified tag name " */
      TestResult tr15 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT2);
      try {
         org.w3c.dom.Element el = portletResp.createElement("Test2");
         if (el.getNodeName().equals("Test2")) {
            tr15.setTcSuccess(true);
         }
      } catch (org.w3c.dom.DOMException de) {
         tr15.appendTcDetail(de.toString());
      }
      tr15.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_createElement3 */
      /* Details: "Method createElement(String): The returned Element has */
      /* localName set to null" */
      TestResult tr16 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT3);
      try {
         org.w3c.dom.Element el = portletResp.createElement("Test3");
         String loc = el.getLocalName();
         if (loc == null) {
            tr16.setTcSuccess(true);
         }
      } catch (org.w3c.dom.DOMException de) {
         tr16.appendTcDetail(de.toString());
      }
      tr16.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_createElement4 */
      /* Details: "Method createElement(String): The returned Element has */
      /* prefix set to null" */
      TestResult tr17 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT4);
      try {
         org.w3c.dom.Element el = portletResp.createElement("Test4");
         String prefix = el.getPrefix();
         if (prefix == null) {
            tr17.setTcSuccess(true);
         }
      } catch (org.w3c.dom.DOMException de) {
         tr17.appendTcDetail(de.toString());
      }
      tr17.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_createElement5 */
      /* Details: "Method createElement(String): The returned Element has */
      /* namespaceURI set to null" */
      TestResult tr18 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT5);
      try {
         org.w3c.dom.Element el = portletResp.createElement("Test5");
         String nameSpace = el.getNamespaceURI();
         if (nameSpace == null) {
            tr18.setTcSuccess(true);
         }
      } catch (org.w3c.dom.DOMException de) {
         tr18.appendTcDetail(de.toString());
      }
      tr18.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiResource_createElement6 */
      /* Details: "Method createElement(String): Throws */
      /* org.w3c.dom.DOMException - INVALID_CHARACTER_ERR if the specified */
      /* name contains an illegal character. " */
      TestResult tr19 = tcd.getTestResultFailed(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT6);
      try {
         portletResp.createElement("$Test6");
         tr19.appendTcDetail("Method did not Throw Exception");
      } catch (org.w3c.dom.DOMException de) {
         tr19.setTcSuccess(true);
      }
      tr19.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write(
            "<div id=\"ResponseTests_PortletResponse_ApiResource\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(ResourceURL.PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write(
            "         document.getElementById(\"ResponseTests_PortletResponse_ApiResource\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write(
            "   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
