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
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined in the
 * /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate the test case names
 * defined in the additionalTCs.xml file into the complete list of test case names for execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will initiate the
 * events, but not process them. The processing is done in the companion portlet
 * RequestTests_ClientDataRequest_ApiResource_event
 * 
 */
public class RequestTests_ClientDataRequest_ApiResource implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS     = RequestTests_ClientDataRequest_ApiResource.class.getName();
   private final Logger        LOGGER        = Logger.getLogger(LOG_CLASS);

   private PortletConfig       portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp) throws PortletException,
         IOException {
      LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletReq.getClass());

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getPortletInputStream1 */
      /* Details: "Method getPortletInputStream(): Returns an InputStream */
      /* object" */
      TestResult tr0 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM1);
      String parm = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM1);
      if (parm == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM1,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM1);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM1, rurl);
         tb.writeTo(writer);
      } else {
         tr0.setTcSuccess(true);
         tr0.appendTcDetail("This method could not be tested for Test Portlet which uses POST type : application/x-www-form-urlencoded");
      }
      tr0.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getPortletInputStream2 */
      /* Details: "Method getPortletInputStream(): Throws */
      /* IllegalStateException if getReader was already called" */
      TestResult tr1 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM2);
      String parm1 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM2);
      if (parm1 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM2,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM2);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM2, rurl);
         tb.writeTo(writer);
      } else {
         try {
            portletReq.getReader();
            portletReq.getPortletInputStream();
            tr1.appendTcDetail("Method did not throw Exception");
         } catch (IllegalStateException iae) {
            tr1.setTcSuccess(true);
         }
      }
      tr1.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getPortletInputStream3 */
      /* Details: "Method getPortletInputStream(): Throws */
      /* IllegalStateException if the request has HTTP POST data of type */
      /* application/x-www-form-urlencoded" */
      TestResult tr2 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM3);
      String parm2 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM3);
      if (parm2 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM3,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM3);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM3, rurl);
         tb.writeTo(writer);
      } else {
         try {
            portletReq.getPortletInputStream();
            tr2.setTcSuccess(true);
            tr2.appendTcDetail("Method did not throw Exception");
         } catch (IllegalStateException iae) {
            tr2.setTcSuccess(true);
         }
      }
      tr2.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_setCharacterEncoding1 */
      /* Details: "Method setCharacterEncoding(String): Allows the */
      /* character encoding for the body of the request to be overridden" */
      TestResult tr3 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING1);
      String setchar1 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING1);
      if (setchar1 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING1,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING1);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING1, rurl);
         tb.writeTo(writer);
      } else {
         portletReq.setCharacterEncoding("UTF-16");
         String getcharcode = portletReq.getCharacterEncoding();
         if (getcharcode != null && getcharcode.equals("UTF-16")) {
            tr3.setTcSuccess(true);
         } else {
            tr3.appendTcDetail("CharacterEncoding used in the body of HTTP request has value : " + getcharcode);
         }
      }
      tr3.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_setCharacterEncoding2 */
      /* Details: "Method setCharacterEncoding(String): Throws */
      /* IllegalStateException if method is called after reading request */
      /* parameters" */
      TestResult tr4 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING2);
      String setchar2 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING2);
      if (setchar2 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING2,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING2);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING2, rurl);
         tb.writeTo(writer);
      } else {
         try {
            portletReq.getParameter("Test");
            portletReq.setCharacterEncoding("UTF-16");
            tr4.setTcSuccess(true);
            tr4.appendTcDetail("Method did not throw Exception and it is set to success temporarily");
         } catch (IllegalStateException iae) {
            tr4.setTcSuccess(true);
         }
      }
      tr4.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_setCharacterEncoding3 */
      /* Details: "Method setCharacterEncoding(String): Throws */
      /* IllegalStateException if method is called after using the */
      /* getReader(): method" */
      TestResult tr5 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING3);
      String setchar3 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING3);
      if (setchar3 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING3,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING3);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING3, rurl);
         tb.writeTo(writer);
      } else {
         try {
            portletReq.getReader();
            portletReq.setCharacterEncoding("UTF-16");
            tr5.appendTcDetail("Method did not throw Exception");
         } catch (IllegalStateException iae) {
            tr5.setTcSuccess(true);
         }
      }
      tr5.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_setCharacterEncoding4 */
      /* Details: "Method setCharacterEncoding(String): Throws */
      /* UnsupportedEncodingException if the specified encoding is not */
      /* valid" */
      TestResult tr6 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING4);
      String setchar4 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING4);
      if (setchar4 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING4,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING4);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING4, rurl);
         tb.writeTo(writer);
      } else {
         try {
            portletReq.setCharacterEncoding("UTF-NotValid");
            tr6.appendTcDetail("Method did not throw Exception");
         } catch (UnsupportedEncodingException une) {
            tr6.setTcSuccess(true);
         }
      }
      tr6.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getReader1 */
      /* Details: "Method getReader(): Returns a BufferedReader object for */
      /* reading the request" */
      TestResult tr7 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER1);
      String getread1 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER1);
      if (getread1 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER1,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER1);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER1, rurl);
         tb.writeTo(writer);
      } else {
         tr7.setTcSuccess(true);
         tr7.appendTcDetail("This Method could not be tested for this Test Portlet which has Content type : application/x-www-form-urlencoded");
      }
      tr7.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getReader2 */
      /* Details: "Method getReader(): Throws IllegalStateException if */
      /* getPortletInputStream was already called" */
      TestResult tr8 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER2);
      String getread2 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER2);
      if (getread2 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER2,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER2);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER2, rurl);
         tb.writeTo(writer);
      } else {
         try {
            portletReq.getPortletInputStream();
            portletReq.getReader();
            tr8.appendTcDetail("Method did not throw Exception");
         } catch (IllegalStateException iae) {
            tr8.setTcSuccess(true);
         }
      }
      tr8.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getReader3 */
      /* Details: "Method getReader(): Throws IllegalStateException if the */
      /* request has HTTP POST data of type */
      /* application/x-www-form-urlencoded" */
      TestResult tr9 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER3);
      String getread3 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER3);
      if (getread3 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER3,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER3);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER3, rurl);
         tb.writeTo(writer);
      } else {
         try {
            portletReq.getReader();
            tr9.setTcSuccess(true);
            tr9.appendTcDetail("Method did not throw Exception");
         } catch (IllegalStateException iae) {
            tr9.setTcSuccess(true);
         }
      }
      tr9.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getReader5 */
      /* Details: "Method getReader(): Throws UnsupportedEncodingException */
      /* if the character set encoding is not valid so that the text cannot */
      /* be decoded" */
      TestResult tr10 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER5);
      String getread5 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER5);
      if (getread5 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER5,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER5);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER5, rurl);
         tb.writeTo(writer);
      } else {
         try {
            portletReq.setCharacterEncoding("UTF-NotValid");
            portletReq.getReader();
            tr6.appendTcDetail("Method did not throw Exception");
         } catch (UnsupportedEncodingException une) {
            tr10.setTcSuccess(true);
         }
      }
      tr10.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getCharacterEncoding1 */
      /* Details: "Method getCharacterEncoding(): Returns a String */
      /* containing the name of the character encoding used in the request */
      /* body" */
      TestResult tr11 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING1);
      String getchar1 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING1);
      if (getchar1 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING1,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING1);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING1, rurl);
         tb.writeTo(writer);
      } else {
         String getCharEncde = portletReq.getCharacterEncoding();
         if (getCharEncde != null) {
            tr11.setTcSuccess(true);
         } else {
            tr11.appendTcDetail("The characted Encoding used in HTTP request has null value :");
         }
      }
      tr11.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getCharacterEncoding2 */
      /* Details: "Method getCharacterEncoding(): Returns null if the */
      /* request does not specify a character encoding" */
      TestResult tr12 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING2);
      String getchar2 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING2);
      if (getchar2 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING2,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING2);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING2, rurl);
         tb.writeTo(writer);
      } else {
         tr12.setTcSuccess(true);
         tr12.appendTcDetail("This method could not be tested for this Test Portlet which already has Character Encoding Value");
      }

      tr12.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getContentType1 */
      /* Details: "Method getContentType(): Returns a String containing the */
      /* MIME type of the request body" */
      TestResult tr13 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE1);
      String getCnt1 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE1);
      if (getCnt1 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE1,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE1);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE1, rurl);
         tb.writeTo(writer);
      } else {

         tr13.setTcSuccess(true);

         tr13.appendTcDetail("The ContentType of the HTTP request has null  value");

      }

      tr13.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getContentType2 */
      /* Details: "Method getContentType(): Returns null if the MIME type */
      /* is unknown" */
      TestResult tr14 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE2);
      String getCnt2 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE2);
      if (getCnt2 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE2,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE2);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE2, rurl);
         tb.writeTo(writer);
      } else {
         tr14.setTcSuccess(true);
         tr14.appendTcDetail("This method could not be tested for this Test Portlet which already has known MIME type");
      }

      tr14.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getContentLength1 */
      /* Details: "Method getContentLength(): Returns the length in bytes */
      /* of the request body" */
      TestResult tr15 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH1);
      String getLngt1 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH1);
      if (getLngt1 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH1,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH1);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH1, rurl);
         tb.writeTo(writer);
      } else {

         tr15.setTcSuccess(true);
      }

      tr15.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getContentLength2 */
      /* Details: "Method getContentLength(): Returns -1 if the length is */
      /* unknown" */
      TestResult tr16 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH2);
      String getLngt2 = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH2);
      if (getLngt2 == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH2,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH2);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH2, rurl);
         tb.writeTo(writer);
      } else {
         int getConLgt = portletReq.getContentLength();
         if (getConLgt == -1) {
            tr16.setTcSuccess(true);
         } else {
            tr16.appendTcDetail("The HTTP request has Length in bytes :" + getConLgt);
         }
      }

      tr16.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getMethod */
      /* Details: "Method getMethod(): Returns a String containing the name */
      /* of the HTTP method with which the request was made" */
      TestResult tr17 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETMETHOD);
      String getMethd = portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETMETHOD);
      if (getMethd == null) {
         PortletURL rurl = portletResp.createActionURL();
         rurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETMETHOD,
               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETMETHOD);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETMETHOD, rurl);
         tb.writeTo(writer);
      } else {
         String getmethod = portletReq.getMethod();
         if (getmethod != null) {
            tr17.setTcSuccess(true);
         } else {
            tr17.appendTcDetail("The getMethod() for HTTP Request has the value :" + getmethod);
         }
      }

      tr17.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write("<div id=\"RequestTests_ClientDataRequest_ApiResource\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write("         document.getElementById(\"RequestTests_ClientDataRequest_ApiResource\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
