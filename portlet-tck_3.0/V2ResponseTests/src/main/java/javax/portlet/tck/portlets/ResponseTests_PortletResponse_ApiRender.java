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
import javax.security.auth.login.Configuration;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
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
 * portlet ResponseTests_PortletResponse_ApiRender_event
 *
 */
public class ResponseTests_PortletResponse_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         ResponseTests_PortletResponse_ApiRender.class.getName();
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

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletResp.getClass());

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_addPropertyA1    */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Adds the    */
      /* specified cookie property to the response"                           */
      TestResult tr0 = tcd.getTestResultSucceeded(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYA1);
      tr0.appendTcDetail("This Method Could not be tested as Specified Property cannot be added to the response for this Test Portlets ");
      tr0.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_addPropertyA2    */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Throws      */
      /* IllegalArgumentException if the specified cookie is null"            */
      TestResult tr1 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYA2);
      try {
         try {
            portletResp.addProperty(null);
            tr1.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr1.setTcSuccess(true);
         } catch (Exception e) {
            tr1.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_addPropertyB1    */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Adds an   */
      /* XML DOM Element to the response for the specified key"               */
      TestResult tr2 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYB1);
      tr2.setTcSuccess(true);
      tr2.appendTcDetail("This Method Could not be tested as XML DOM element cannot be added to the response for this Test Portlets ");
      tr2.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_addPropertyB3    */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): If the    */
      /* specified DOM Element value is null, the key is removed from the     */
      /* response"                                                            */
      TestResult tr3 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYB3);
      tr3.setTcSuccess(true);
      tr3.appendTcDetail("This Method Could not be tested as XML DOM element cannot be added to the response for this Test Portlets ");
      tr3.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_addPropertyB4    */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Throws    */
      /* IllegalArgumentException if the specified key is null"               */
      TestResult tr4 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYB4);
      try {
         try {
            org.w3c.dom.Element el = portletResp.createElement("p");
            portletResp.addProperty((String)null, el);
            tr4.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr4.setTcSuccess(true);
         } catch (Exception e) {
            tr4.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_addPropertyC1    */
      /* Details: "Method addProperty(String, String): A property can be      */
      /* added"                                                               */
      TestResult tr5 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYC1);
      tr5.setTcSuccess(true);
      tr5.appendTcDetail("This Method could not be Tested as Property cannot be added to the Response for this Test Portlet");
      tr5.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_addPropertyC2    */
      /* Details: "Method addProperty(String, String): Throws                 */
      /* IllegalArgumentException if the specified key is null"               */
      TestResult tr6 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYC2);
      try {
         try {
            portletResp.addProperty(null, "value");
            tr6.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr6.setTcSuccess(true);
         } catch (Exception e) {
            tr6.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_setProperty1     */
      /* Details: "Method setProperty(String, String): Sets a property        */
      /* value for the specified key"                                         */
      TestResult tr7 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_SETPROPERTY1);
      tr7.setTcSuccess(true);
      tr7.appendTcDetail("This Method Could not be Tested as Property value cannot be added to Response for this Test Portlet");
      tr7.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_setProperty3     */
      /* Details: "Method setProperty(String, String): Throws                 */
      /* IllegalArgumentException if the specified key is null"               */
      TestResult tr8 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_SETPROPERTY3);
      try {
         try {
            portletResp.setProperty(null, "value");
            tr8.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr8.setTcSuccess(true);
         } catch (Exception e) {
            tr8.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_encodeURL1       */
      /* Details: "Method encodeURL(String): Returns a String representing    */
      /* the encoded URL"                                                     */
      TestResult tr9 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ENCODEURL1);
      
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_encodeURL2       */
      /* Details: "Method encodeURL(String): Throws                           */
      /* IllegalArgumentException if the input string is not an absolute      */
      /* URL and does not start with at \"/\" character"                      */
      TestResult tr10 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ENCODEURL2);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_getNamespace1    */
      /* Details: "Method getNamespace(): Returns a String containing the     */
      /* namespace value"                                                     */
      TestResult tr11 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_GETNAMESPACE1);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_createElement1   */
      /* Details: "Method createElement(String): Returns an                   */
      /* org.w3c.dom.Element object for the specified tag name"               */
      TestResult tr12 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT1);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_createElement2   */
      /* Details: "Method createElement(String): The returned Element has     */
      /* nodeName set to the the specified tag name "                         */
      TestResult tr13 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT2);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_createElement3   */
      /* Details: "Method createElement(String): The returned Element has     */
      /* localName set to null"                                               */
      TestResult tr14 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT3);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_createElement4   */
      /* Details: "Method createElement(String): The returned Element has     */
      /* prefix set to null"                                                  */
      TestResult tr15 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT4);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_createElement5   */
      /* Details: "Method createElement(String): The returned Element has     */
      /* namespaceURI set to null"                                            */
      TestResult tr16 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT5);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2ResponseTests_PortletResponse_ApiRender_createElement6   */
      /* Details: "Method createElement(String): Throws                       */
      /* org.w3c.dom.DOMException - INVALID_CHARACTER_ERR if the specified    */
      /* name contains an illegal character. "                                */
      TestResult tr17 = tcd.getTestResultFailed(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT6);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

   }

}
