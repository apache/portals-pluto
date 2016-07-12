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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYA2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYB3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYB4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYC1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYC2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_SETPROPERTY1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_SETPROPERTY3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ENCODEURL1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ENCODEURL2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_GETNAMESPACE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT6;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.TestButton;
import javax.xml.namespace.QName;

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
 * ResponseTests_PortletResponse_ApiEvent_event
 *
 */
public class ResponseTests_PortletResponse_ApiEvent implements Portlet {

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

      QName eventQName = new QName(TCKNAMESPACE,
            "ResponseTests_PortletResponse_ApiEvent");
      portletResp.setEvent(eventQName, "Hi!");
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyA1 */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Adds the */
      /* specified cookie property to the response" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYA1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyA2 */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Throws */
      /* IllegalArgumentException if the specified cookie is null" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYA2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyB1 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Adds an */
      /* XML DOM Element to the response for the specified key" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYB1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyB3 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): If the */
      /* specified DOM Element value is null, the key is removed from the */
      /* response" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYB3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyB4 */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Throws */
      /* IllegalArgumentException if the specified key is null" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYB4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyC1 */
      /* Details: "Method addProperty(String, String): A property can be */
      /* added" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYC1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyC2 */
      /* Details: "Method addProperty(String, String): Throws */
      /* IllegalArgumentException if the specified key is null" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYC2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_setProperty1 */
      /* Details: "Method setProperty(String, String): Sets a property */
      /* value for the specified key" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_SETPROPERTY1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_setProperty3 */
      /* Details: "Method setProperty(String, String): Throws */
      /* IllegalArgumentException if the specified key is null" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_SETPROPERTY3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_encodeURL1 */
      /* Details: "Method encodeURL(String): Returns a String representing */
      /* the encoded URL" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ENCODEURL1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_encodeURL2 */
      /* Details: "Method encodeURL(String): Throws */
      /* IllegalArgumentException if the input string is not an absolute */
      /* URL and does not start with at \"/\" character" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ENCODEURL2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_getNamespace1 */
      /* Details: "Method getNamespace(): Returns a String containing the */
      /* namespace value" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_GETNAMESPACE1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement1 */
      /* Details: "Method createElement(String): Returns an */
      /* org.w3c.dom.Element object for the specified tag name" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement2 */
      /* Details: "Method createElement(String): The returned Element has */
      /* nodeName set to the the specified tag name " */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement3 */
      /* Details: "Method createElement(String): The returned Element has */
      /* localName set to null" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement4 */
      /* Details: "Method createElement(String): The returned Element has */
      /* prefix set to null" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement5 */
      /* Details: "Method createElement(String): The returned Element has */
      /* namespaceURI set to null" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT5, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement6 */
      /* Details: "Method createElement(String): Throws */
      /* org.w3c.dom.DOMException - INVALID_CHARACTER_ERR if the specified */
      /* name contains an illegal character. " */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT6, aurl);
         tb.writeTo(writer);
      }

   }

}
