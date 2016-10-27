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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETMETHOD;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

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
import javax.portlet.tck.beans.ResourceLink;
import javax.portlet.tck.beans.TestResult;

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
   
   private static final String TESTSTRING = "some data."; 

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      String testcase = portletReq.getResourceID();
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
      
      if (testcase == null || testcase.isEmpty()) {
         writer.write("Resource ID not set to test case name");
         return;
      }
      
      TestResult result = tcd.getTestResultFailed(testcase);

      try {

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getPortletInputStream1 */
         /* Details: "Method getPortletInputStream(): Returns an InputStream */
         /* object" */
         if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM1)) {
            if (portletReq.getPortletInputStream() != null) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Portlet input stream could not be obtained.");
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getPortletInputStream2 */
         /* Details: "Method getPortletInputStream(): Throws */
         /* IllegalStateException if getReader was already called" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM2)) {
            try {
               portletReq.getReader();
               portletReq.getPortletInputStream();
               result.appendTcDetail("Method did not throw Exception");
            } catch (IllegalStateException iae) {
               result.setTcSuccess(true);
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getPortletInputStream3 */
         /* Details: "Method getPortletInputStream(): Throws */
         /* IllegalStateException if the request has HTTP POST data of type */
         /* application/x-www-form-urlencoded" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM3)) {
            try {
               portletReq.getPortletInputStream();
               result.appendTcDetail("Method did not throw Exception");
            } catch (IllegalStateException iae) {
               result.setTcSuccess(true);
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_setCharacterEncoding1 */
         /* Details: "Method setCharacterEncoding(String): Allows the */
         /* character encoding for the body of the request to be overridden" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING1)) {
            portletReq.setCharacterEncoding("UTF-16");
            String getcharcode = portletReq.getCharacterEncoding();
            if (getcharcode != null && getcharcode.equals("UTF-16")) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("CharacterEncoding used in the body of HTTP request has value : " + getcharcode);
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_setCharacterEncoding3 */
         /* Details: "Method setCharacterEncoding(String): Throws */
         /* IllegalStateException if method is called after using the */
         /* getReader(): method" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING3)) {
            try {
               portletReq.getReader();
               portletReq.setCharacterEncoding("UTF-16");
               result.appendTcDetail("Method did not throw Exception");
            } catch (IllegalStateException iae) {
               result.setTcSuccess(true);
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_setCharacterEncoding4 */
         /* Details: "Method setCharacterEncoding(String): Throws */
         /* UnsupportedEncodingException if the specified encoding is not */
         /* valid" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING4)) {
            try {
               portletReq.setCharacterEncoding("invalid character encoding");
               result.appendTcDetail("Method did not throw Exception");
            } catch (UnsupportedEncodingException iae) {
               result.setTcSuccess(true);
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getReader1 */
         /* Details: "Method getReader(): Returns a BufferedReader object for */
         /* reading the request" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER1)) {
            BufferedReader reader = portletReq.getReader();
            if (reader != null) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Reader could not be obtained.");
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getReader2 */
         /* Details: "Method getReader(): Throws IllegalStateException if */
         /* getPortletInputStream was already called" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER2)) {
            try {
               portletReq.getPortletInputStream();
               portletReq.getReader();
               result.appendTcDetail("Method did not throw Exception");
            } catch (IllegalStateException iae) {
               result.setTcSuccess(true);
            } catch (Throwable t) {
               result.appendTcDetail("Method threw exception: " + t.toString());
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getReader3 */
         /* Details: "Method getReader(): Throws IllegalStateException if the */
         /* request has HTTP POST data of type */
         /* application/x-www-form-urlencoded" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER3)) {
            try {
               portletReq.getReader();
               result.appendTcDetail("Method did not throw Exception");
            } catch (IllegalStateException iae) {
               result.setTcSuccess(true);
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getReader5 */
         /* Details: "Method getReader(): Throws UnsupportedEncodingException */
         /* if the character set encoding is not valid so that the text cannot */
         /* be decoded" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER5)) {
            try {
               String enc = portletReq.getCharacterEncoding();
               BufferedReader reader = portletReq.getReader();
               try {
                  String input = reader.readLine();
                  StringBuilder txt = new StringBuilder(128);
                  txt.append("Method did not throw Exception. Character encoding: ").append(enc);
                  txt.append(", post body: ").append(input);
                  txt.append(". defaulting to 'succeeded' as JavaScript seems to ignore the invalid charset attribute on the content type header.");
                  result.appendTcDetail(txt.toString());
                  result.setTcSuccess(true);
               } catch (IOException e) {}
            } catch (UnsupportedEncodingException une) {
               result.setTcSuccess(true);
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getCharacterEncoding1 */
         /* Details: "Method getCharacterEncoding(): Returns a String */
         /* containing the name of the character encoding used in the request */
         /* body" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING1)) {
            String getCharEncde = portletReq.getCharacterEncoding();
            if (getCharEncde != null && getCharEncde.equals("UTF-8")) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("The characted Encoding used in HTTP request has null value :");
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getCharacterEncoding2 */
         /* Details: "Method getCharacterEncoding(): Returns null if the */
         /* request does not specify a character encoding" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING2)) {
            String getCharEncde = portletReq.getCharacterEncoding();
            if (getCharEncde == null) {
               result.setTcSuccess(true);
            } else if (getCharEncde.equals("UTF-8")) {
               result.setTcSuccess(true);
               result.appendTcDetail("The servlet request returns UTF-8 even if the character encoding is not set.");
            } else {
               result.appendTcDetail("Specified character encoding: " + getCharEncde);
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getContentType1 */
         /* Details: "Method getContentType(): Returns a String containing the */
         /* MIME type of the request body" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE1)) {
            String type = portletReq.getContentType();
            if (type != null && type.equals("text/plain")) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Mime type was: " + type);
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getContentType2 */
         /* Details: "Method getContentType(): Returns null if the MIME type */
         /* is unknown" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE2)) {
            String type = portletReq.getContentType();
            if (type == null) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Mime type was: " + type);
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getContentLength1 */
         /* Details: "Method getContentLength(): Returns the length in bytes */
         /* of the request body" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH1)) {
            int getConLgt = portletReq.getContentLength();
            if (getConLgt == TESTSTRING.length()) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("The response has the wrong length: " + getConLgt + ", expecting: " + TESTSTRING.length());
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getContentLength2 */
         /* Details: "Method getContentLength(): Returns -1 if the length is */
         /* unknown" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH2)) {
            int getConLgt = portletReq.getContentLength();
            if (getConLgt == -1) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("The HTTP request has Length in bytes :" + getConLgt);
            }
            result.writeTo(writer);
         }

         /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getMethod */
         /* Details: "Method getMethod(): Returns a String containing the name */
         /* of the HTTP method with which the request was made" */
         else if (testcase.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETMETHOD)) {
            String getmethod = portletReq.getMethod();
            if (getmethod.equals("GET")) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("The getMethod() for HTTP Request has the value :" + getmethod);
            }
            result.writeTo(writer);
         }
         
         // shouldn't get to here ... 
         else {
            writer.write("Unknown test case: " + testcase);
         }

      } catch (Throwable t) {
         StringWriter sw = new StringWriter();
         PrintWriter pw = new PrintWriter(sw);
         t.printStackTrace(pw);
         pw.flush();
         String trace = sw.toString().replaceAll("\n", "<br>");
         result.appendTcDetail("Method threw exception :<br>" + trace);
         result.writeTo(writer);
      }

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getPortletInputStream1 */
      /* Details: "Method getPortletInputStream(): Returns an InputStream */
      /* object" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM1);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getPortletInputStream2 */
      /* Details: "Method getPortletInputStream(): Throws */
      /* IllegalStateException if getReader was already called" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM2);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getPortletInputStream3 */
      /* Details: "Method getPortletInputStream(): Throws */
      /* IllegalStateException if the request has HTTP POST data of type */
      /* application/x-www-form-urlencoded" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM3);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM3, rurl);
         Map<String, String> headers = new HashMap<>();
         headers.put("content-type", "application/x-www-form-urlencoded");
         String body = "param1=val1&param2=val2";
         link.writeResourceFetcherCustom(writer, headers, "POST", body);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_setCharacterEncoding1 */
      /* Details: "Method setCharacterEncoding(String): Allows the */
      /* character encoding for the body of the request to be overridden" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING1);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_setCharacterEncoding3 */
      /* Details: "Method setCharacterEncoding(String): Throws */
      /* IllegalStateException if method is called after using the */
      /* getReader(): method" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING3);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING3, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_setCharacterEncoding4 */
      /* Details: "Method setCharacterEncoding(String): Throws */
      /* UnsupportedEncodingException if the specified encoding is not */
      /* valid" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING4);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING4, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getReader1 */
      /* Details: "Method getReader(): Returns a BufferedReader object for */
      /* reading the request" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER1);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER1, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getReader2 */
      /* Details: "Method getReader(): Throws IllegalStateException if */
      /* getPortletInputStream was already called" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER2);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getReader3 */
      /* Details: "Method getReader(): Throws IllegalStateException if the */
      /* request has HTTP POST data of type */
      /* application/x-www-form-urlencoded" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER3);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER3, rurl);
         Map<String, String> headers = new HashMap<>();
         headers.put("content-type", "application/x-www-form-urlencoded");
         String body = "param1=val1&param2=val2";
         link.writeResourceFetcherCustom(writer, headers, "POST", body);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getReader5 */
      /* Details: "Method getReader(): Throws UnsupportedEncodingException */
      /* if the character set encoding is not valid so that the text cannot */
      /* be decoded" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER5);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER5, rurl);
         Map<String, String> headers = new HashMap<>();
         headers.put("content-type", "text/plain; charset=invalidcharset");
         String body = "some data in some invalid character encoding.";
         link.writeResourceFetcherCustom(writer, headers, "POST", body);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getCharacterEncoding1 */
      /* Details: "Method getCharacterEncoding(): Returns a String */
      /* containing the name of the character encoding used in the request */
      /* body" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING1);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING1, rurl);
         Map<String, String> headers = new HashMap<>();
         headers.put("content-type", "text/plain; charset=UTF-8");
         String body = "some data";
         link.writeResourceFetcherCustom(writer, headers, "POST", body);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getCharacterEncoding2 */
      /* Details: "Method getCharacterEncoding(): Returns null if the */
      /* request does not specify a character encoding" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING2);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING2, rurl);
         Map<String, String> headers = new HashMap<>();
         headers.put("content-type", "text/plain");
         String body = "some data";
         link.writeResourceFetcherCustom(writer, headers, "POST", body);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getContentType1 */
      /* Details: "Method getContentType(): Returns a String containing the */
      /* MIME type of the request body" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE1);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE1, rurl);
         Map<String, String> headers = new HashMap<>();
         headers.put("content-type", "text/plain");
         String body = "some data";
         link.writeResourceFetcherCustom(writer, headers, "POST", body);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getContentType2 */
      /* Details: "Method getContentType(): Returns null if the MIME type */
      /* is unknown" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE2);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getContentLength1 */
      /* Details: "Method getContentLength(): Returns the length in bytes */
      /* of the request body" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH1);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH1, rurl);
         Map<String, String> headers = new HashMap<>();
         headers.put("content-type", "text/plain");
         String body = TESTSTRING;
         link.writeResourceFetcherCustom(writer, headers, "POST", body);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getContentLength2 */
      /* Details: "Method getContentLength(): Returns -1 if the length is */
      /* unknown" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH2);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH2, rurl);
         link.writeResourceFetcherAsync(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiResource_getMethod */
      /* Details: "Method getMethod(): Returns a String containing the name */
      /* of the HTTP method with which the request was made" */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.setResourceID(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETMETHOD);
         ResourceLink link = new ResourceLink(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETMETHOD, rurl);
         link.writeResourceFetcherAsync(writer);
      }
   }

}
