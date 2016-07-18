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

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC14_HeaderReq")
public class HeaderPortletTests_SPEC14_HeaderReq implements Portlet {
   
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

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType1               */
      /* Details: "The getResponseContentType method returns a String representing  */
      /* the default content type the portlet container assumes for the output"     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType2               */
      /* Details: "The getResponseContentTypes method returns an Enumeration of     */
      /* String elements representing the acceptable content types for the output   */
      /* in order of preference"                                                    */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType3               */
      /* Details: "The first element of the Enumeration returned by the             */
      /* getResponseContentTypes method must equal the value returned by the        */
      /* getResponseContentType method"                                             */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType4               */
      /* Details: "If a portlet defines support for all content types using a       */
      /* wildcard and the portlet container supports all content types, the         */
      /* getResponseContentType may return the wildcard"                            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE4);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType5               */
      /* Details: "If a portlet defines support for all content types using a       */
      /* wildcard and the portlet container supports all content types, the         */
      /* getResponseContentType may return the preferred content type"              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE5);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_windowId1                  */
      /* Details: "The getWindowID method returns a String representing the current */
      /* window ID"                                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_WINDOWID1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_windowId4                  */
      /* Details: "The string returned by getWindowID method must be the same ID    */
      /* used for scoping portlet-scope session attributes"                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_WINDOWID4);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType10              */
      /* Details: "Within the header method, the content type must include only the */
      /* MIME type, not the character set"                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE10);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType11              */
      /* Details: "Within the header method, the getResponseContentTypes method     */
      /* must return only the content types supported by the current portlet mode"  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE11);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType13              */
      /* Details: "The character set of the response can be retrieved via the       */
      /* HeaderResponse.getCharacterEncoding method"                                */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE13);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

   }

}
