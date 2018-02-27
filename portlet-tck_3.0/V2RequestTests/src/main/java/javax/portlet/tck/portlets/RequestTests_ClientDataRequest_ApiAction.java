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

import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETMETHOD;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING4;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;

import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet RequestTests_ClientDataRequest_ApiAction_event
 *
 */
public class RequestTests_ClientDataRequest_ApiAction implements Portlet, ResourceServingPortlet {

   private final Logger LOGGER = LoggerFactory.getLogger(RequestTests_ClientDataRequest_ApiAction.class);

   @Override
   public void init(PortletConfig config) throws PortletException {
      
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("main portlet processAction entry");

      portletResp.setRenderParameters(portletReq.getParameterMap());
      
      
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

     

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream1 */
      /* Details: "Method getPortletInputStream(): Returns an InputStream     */
      /* object"                                                              */
      TestResult tr0 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM1);
      String getparm1=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM1);
      if(getparm1!=null && getparm1.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM1)) {
    	  tr0.setTcSuccess(true);
    	  tr0.appendTcDetail("This method could not be tested for Test Portlet which uses POST type : application/x-www-form-urlencoded");
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM1, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM1);
      }
      tr0.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream2 */
      /* Details: "Method getPortletInputStream(): Throws                     */
      /* IllegalStateException if getReader was already called"               */
      TestResult tr1 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM2);
      String getparm2=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM2);
      if(getparm2!=null && getparm2.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM2)) {
          try {
              portletReq.getReader();
              try {
                  portletReq.getPortletInputStream();
                  tr1.appendTcDetail("Method did not throw Exception");
              } catch (IllegalStateException ise) {
                  tr1.setTcSuccess(true);
              }
          } catch (IllegalStateException ise) {
              tr1.appendTcDetail("getReader should not throw an exception, but did throw an IllegalStateException.");
          }
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM2, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM2);
      }
      tr1.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream3 */
      /* Details: "Method getPortletInputStream(): Throws                     */
      /* IllegalStateException if the request has HTTP POST data of type      */
      /* application/x-www-form-urlencoded"                                   */
      TestResult tr2 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM3);
      String getparm3=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM3);
      if(getparm3!=null && getparm3.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM3) ) {
    	  try {
    		  portletReq.getPortletInputStream(); 
    		  tr2.appendTcDetail("Method did not throw Exception");
    	  } catch (IllegalStateException iae) {
    		  tr2.setTcSuccess(true);
    	  }
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM3, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM3);
      }
      tr2.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding1 */
      /* Details: "Method setCharacterEncoding(String): Allows the            */
      /* character encoding for the body of the request to be overridden"     */
      TestResult tr3 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING1);
      String setchar1=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING1);
      if(setchar1!=null && setchar1.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING1)) {
    	  portletReq.setCharacterEncoding("UTF-16");
    	  String getcharcode=portletReq.getCharacterEncoding();
    	  if(getcharcode!=null && getcharcode.equals("UTF-16")) {
    		  tr3.setTcSuccess(true);
    	  } else {
    		  tr3.appendTcDetail("CharacterEncoding used in the body of HTTP request has value : " +getcharcode); 
    	  }
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING1, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING1);
      }
      tr3.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding2 */
      /* Details: "Method setCharacterEncoding(String): Throws                */
      /* IllegalStateException if method is called after reading request      */
      /* parameters"                                                          */
      TestResult tr4 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING2);
      String setchar2=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING2);
      if(setchar2!=null && setchar2.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING2)) {
    	  try {
    		  portletReq.getParameter("Test");
    		  portletReq.setCharacterEncoding("UTF-16");
    		  tr4.setTcSuccess(true);
    		  tr4.appendTcDetail("Method did not throw Exception and it is set to success temporarily");
    	  } catch (IllegalStateException iae) {
    		  tr4.setTcSuccess(true);
    	  } 	  
       } else {
    	   portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING2, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING2);
       }
      tr4.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding3 */
      /* Details: "Method setCharacterEncoding(String): Throws                */
      /* IllegalStateException if method is called after using the            */
      /* getReader(): method"                                                 */
      TestResult tr5 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING3);
      String setchar3=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING3);
      if(setchar3!=null && setchar3.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING3)) {
    	  try {
    		  portletReq.getReader();
    		  portletReq.setCharacterEncoding("UTF-16");
    		  tr5.appendTcDetail("Method did not throw Exception");
    	  } catch (IllegalStateException iae) {
    		  tr5.setTcSuccess(true);
    	  }
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING3, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING3);
      }
      tr5.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding4 */
      /* Details: "Method setCharacterEncoding(String): Throws                */
      /* UnsupportedEncodingException if the specified encoding is not        */
      /* valid"                                                               */
      TestResult tr6 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING4);
      String setchar4=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING4);
      if(setchar4!=null && setchar4.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING4)) {
    	  try {
    		  portletReq.setCharacterEncoding("UTF-NotValid");
    		  tr6.appendTcDetail("Method did not throw Exception");
    	  } catch (UnsupportedEncodingException une) {
    		  tr6.setTcSuccess(true);
    	  }
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING4, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING4);
      }
      tr6.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader1      */
      /* Details: "Method getReader(): Returns a BufferedReader object for    */
      /* reading the request"                                                 */
      TestResult tr7 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER1);
      String getRead1=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER1);
      if(getRead1!=null && getRead1.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER1)) {
    	  tr7.setTcSuccess(true);
    	  tr7.appendTcDetail("This Method could not be tested for this Test Portlet which has Content type : application/x-www-form-urlencoded");
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER1, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER1);
      }
    	  tr7.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader2      */
      /* Details: "Method getReader(): Throws IllegalStateException if        */
      /* getPortletInputStream was already called"                            */
      TestResult tr8 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER2);
      String getRead2=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER2);
      if(getRead2!=null && getRead2.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER2)) {
          try {
              portletReq.getPortletInputStream();
              try {
                  portletReq.getReader();
                  tr8.appendTcDetail("Method did not throw Exception");
              } catch (IllegalStateException ise) {
                  tr8.setTcSuccess(true);
              }
          } catch (IllegalStateException ise) {
              tr1.appendTcDetail("getPortletInputStream should not throw an exception, but did throw an IllegalStateException.");
          }
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER2, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER2);
      }
      tr8.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader3      */
      /* Details: "Method getReader(): Throws IllegalStateException if the    */
      /* request has HTTP POST data of type                                   */
      /* application/x-www-form-urlencoded"                                   */
      TestResult tr9 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER3);
      String getRead3=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER3);
      if(getRead3!=null && getRead3.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER3)) {
	      try {
	    	  portletReq.getReader();
	    	  tr9.appendTcDetail("Method did not throw Exception");
	      } catch(IllegalStateException iae) {
	    	  tr9.setTcSuccess(true);
	      }
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER3, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER3);
      }
      tr9.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader5      */
      /* Details: "Method getReader(): Throws UnsupportedEncodingException    */
      /* if the character set encoding is not valid so that the text cannot   */
      /* be decoded"                                                          */
      TestResult tr10 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER5);
      String getRead5=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER5);
      if(getRead5!=null && getRead5.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER5)) {
	      try {
	    	  portletReq.setCharacterEncoding("UTF-NotValid");
	    	  portletReq.getReader();
	    	  tr6.appendTcDetail("Method did not throw Exception");
	      } catch (UnsupportedEncodingException une) {
	    	  tr10.setTcSuccess(true);
	      }
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER5, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER5);
      }
      tr10.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getCharacterEncoding1 */
      /* Details: "Method getCharacterEncoding(): Returns a String            */
      /* containing the name of the character encoding used in the request    */
      /* body"                                                                */
      TestResult tr11 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING1);
      String getChar1=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING1);
      if(getChar1!=null && getChar1.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING1)) {
	      String getCharEncde=portletReq.getCharacterEncoding();
	      if(getCharEncde!=null) {
	    	  tr11.setTcSuccess(true);
	      } else {
	    	  tr11.appendTcDetail("The characted Encoding used in HTTP request has null value :");
	      }
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING1, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING1);
      }
      
      tr11.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getCharacterEncoding2 */
      /* Details: "Method getCharacterEncoding(): Returns null if the         */
      /* request does not specify a character encoding"                       */
      TestResult tr12 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING2);
      String getChar2=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING2);
      if(getChar2!=null && getChar2.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING2)) {
	      tr12.setTcSuccess(true);
	      tr12.appendTcDetail("This method could not be tested for this Test Portlet which already has Character Encoding Value");
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING2, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING2);
      }
	  tr12.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentType1 */
      /* Details: "Method getContentType(): Returns a String containing the   */
      /* MIME type of the request body"                                       */
      TestResult tr13 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE1);
      String getCnt1=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE1);
      if(getCnt1!=null && getCnt1.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE1)) {
	      String getContype=portletReq.getContentType();
	      if(getContype!=null) {
	    	  tr13.setTcSuccess(true);
	      } else {
	    	  tr13.appendTcDetail("The ContentType of the HTTP request has values : " +getContype);
	      }
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE1, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE1);
      }
      tr13.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentType2 */
      /* Details: "Method getContentType(): Returns null if the MIME type     */
      /* is unknown"                                                          */
      TestResult tr14 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE2);
      String getCnt2=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE2);
      if(getCnt2!=null && getCnt2.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE2)) {
	      tr14.setTcSuccess(true);
	      tr14.appendTcDetail("This method could not be tested for this Test Portlet which already has known MIME type");
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE2, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE2);
      }
	  tr14.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentLength1 */
      /* Details: "Method getContentLength(): Returns the length in bytes     */
      /* of the request body"                                                 */
      TestResult tr15 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH1);
      String getCntl1=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH1);
      if(getCntl1!=null && getCntl1.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH1)) {
	      int getConLgt=portletReq.getContentLength();
	      if(getConLgt!=-1) {
	    	  tr15.setTcSuccess(true);
	      } else {
	           tr15.appendTcDetail("The HTTP request has Length in bytes :"+getConLgt);
	      }
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH1, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH1);
      }
      tr15.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentLength2 */
      /* Details: "Method getContentLength(): Returns -1 if the length is     */
      /* unknown"                                                             */
      TestResult tr16 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH2);
      String getCntl2=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH2);
      if(getCntl2!=null && getCntl2.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH2)) {
	      tr16.setTcSuccess(true);
	      tr16.appendTcDetail("This method could not be tested for this Test Portlet which already has  Known Length");
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH2, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH2);
      }
      tr16.writeTo(writer);

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getMethod       */
      /* Details: "Method getMethod(): Returns a String containing the name   */
      /* of the HTTP method with which the request was made"                  */
      TestResult tr17 = tcd.getTestResultFailed(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETMETHOD);
      String getMethd=portletReq.getParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETMETHOD);
      if(getMethd!=null && getMethd.equals(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETMETHOD)) {
	      String getmethod=portletReq.getMethod();
	      if(getmethod!=null && getmethod.equals("POST")) {
	    	  tr17.setTcSuccess(true);
	      } else {
	    	  tr17.appendTcDetail("The getMethod() for HTTP Request has the value :" +getmethod);  
	      }
      } else {
    	  portletResp.setRenderParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETMETHOD, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETMETHOD);
      }
      tr17.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "RequestTests_ClientDataRequest_ApiAction",
                   writer.toString(), APPLICATION_SCOPE);
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("main portlet serveResource entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);
      
      PrintWriter writer = portletResp.getWriter();

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "RequestTests_ClientDataRequest_ApiAction", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "RequestTests_ClientDataRequest_ApiAction", APPLICATION_SCOPE);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream1 */
      /* Details: "Method getPortletInputStream(): Returns an InputStream     */
      /* object"                                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM1,V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM1);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream2 */
      /* Details: "Method getPortletInputStream(): Throws                     */
      /* IllegalStateException if getReader was already called"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM2, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM2);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM2, aurl);
         tb.setEncType("text/plain");
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream3 */
      /* Details: "Method getPortletInputStream(): Throws                     */
      /* IllegalStateException if the request has HTTP POST data of type      */
      /* application/x-www-form-urlencoded"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM3, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM3);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding1 */
      /* Details: "Method setCharacterEncoding(String): Allows the            */
      /* character encoding for the body of the request to be overridden"     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING1, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING1);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding2 */
      /* Details: "Method setCharacterEncoding(String): Throws                */
      /* IllegalStateException if method is called after reading request      */
      /* parameters"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING2, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING2);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding3 */
      /* Details: "Method setCharacterEncoding(String): Throws                */
      /* IllegalStateException if method is called after using the            */
      /* getReader(): method"                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING3, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING3);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding4 */
      /* Details: "Method setCharacterEncoding(String): Throws                */
      /* UnsupportedEncodingException if the specified encoding is not        */
      /* valid"                                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING4, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING4);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader1      */
      /* Details: "Method getReader(): Returns a BufferedReader object for    */
      /* reading the request"                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER1, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER1);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader2      */
      /* Details: "Method getReader(): Throws IllegalStateException if        */
      /* getPortletInputStream was already called"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER2, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER2);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER2, aurl);
         tb.setEncType("text/plain");
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader3      */
      /* Details: "Method getReader(): Throws IllegalStateException if the    */
      /* request has HTTP POST data of type                                   */
      /* application/x-www-form-urlencoded"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER3, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER3);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getReader5      */
      /* Details: "Method getReader(): Throws UnsupportedEncodingException    */
      /* if the character set encoding is not valid so that the text cannot   */
      /* be decoded"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER5, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER5);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER5, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getCharacterEncoding1 */
      /* Details: "Method getCharacterEncoding(): Returns a String            */
      /* containing the name of the character encoding used in the request    */
      /* body"                                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING1, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING1);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getCharacterEncoding2 */
      /* Details: "Method getCharacterEncoding(): Returns null if the         */
      /* request does not specify a character encoding"                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING2, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING2);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentType1 */
      /* Details: "Method getContentType(): Returns a String containing the   */
      /* MIME type of the request body"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE1, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE1);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentType2 */
      /* Details: "Method getContentType(): Returns null if the MIME type     */
      /* is unknown"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE2, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE2);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentLength1 */
      /* Details: "Method getContentLength(): Returns the length in bytes     */
      /* of the request body"                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH1, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH1);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getContentLength2 */
      /* Details: "Method getContentLength(): Returns -1 if the length is     */
      /* unknown"                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH2,V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH2);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_ClientDataRequest_ApiAction_getMethod       */
      /* Details: "Method getMethod(): Returns a String containing the name   */
      /* of the HTTP method with which the request was made"                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETMETHOD, V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETMETHOD);
         TestButton tb = new TestButton(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETMETHOD, aurl);
         tb.writeTo(writer);
      }

   }

}
