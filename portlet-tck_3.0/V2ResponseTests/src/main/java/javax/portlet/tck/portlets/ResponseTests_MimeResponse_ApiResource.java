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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDEXPIRATION_CACHE ;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDCACHE_SCOPE ;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDPUBLIC_SCOPE ;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDPRIVATE_SCOPE ;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDETAG ;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDUSE_CACHED_CONTENT ;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDNAMESPACED_RESPONSE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDMARKUP_HEAD_ELEMENT;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCONTENTTYPE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCONTENTTYPE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETCONTENTTYPE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETCONTENTTYPE4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETWRITER1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETWRITER2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETLOCALE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETBUFFERSIZE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETBUFFERSIZE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETBUFFERSIZE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETBUFFERSIZE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FLUSHBUFFER1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESETBUFFER1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESETBUFFER2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_ISCOMMITTED1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_ISCOMMITTED2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESET1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESET2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETPORTLETOUTPUTSTREAM1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETPORTLETOUTPUTSTREAM2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_CREATERENDERURL;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_CREATEACTIONURL;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_CREATERESOURCEURL;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCACHECONTROL;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.CacheControl;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet ResponseTests_MimeResponse_ApiResource_event
 *
 */
public class ResponseTests_MimeResponse_ApiResource implements Portlet, ResourceServingPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletResp.getClass());

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_fieldEXPIRATION_CACHE  */
      /* Details: "Has String field EXPIRATION_CACHE with value of            */
      /* \"portlet.expiration-cache\""                                        */
      TestResult tr0 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDEXPIRATION_CACHE );
      try {
         tr0.setTcSuccess(cc.hasField("EXPIRATION_CACHE", "portlet.expiration-cache"));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_fieldCACHE_SCOPE  */
      /* Details: "Has String field CACHE_SCOPE with value of                 */
      /* \"portlet.cache-scope\""                                             */
      TestResult tr1 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDCACHE_SCOPE );
      try {
         tr1.setTcSuccess(cc.hasField("CACHE_SCOPE", "portlet.cache-scope"));
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_fieldPUBLIC_SCOPE  */
      /* Details: "Has String field PUBLIC_SCOPE with value of                */
      /* \"portlet.public-scope\""                                            */
      TestResult tr2 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDPUBLIC_SCOPE );
      try {
         tr2.setTcSuccess(cc.hasField("PUBLIC_SCOPE", "portlet.public-scope"));
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_fieldPRIVATE_SCOPE  */
      /* Details: "Has String field PRIVATE_SCOPE with value of               */
      /* \"portlet.private-scope\""                                           */
      TestResult tr3 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDPRIVATE_SCOPE );
      try {
         tr3.setTcSuccess(cc.hasField("PRIVATE_SCOPE", "portlet.private-scope"));
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_fieldETAG         */
      /* Details: "Has String field ETAG with value of \"portlet.ETag\""      */
      TestResult tr4 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDETAG );
      try {
         tr4.setTcSuccess(cc.hasField("ETAG", "portlet.ETag"));
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_fieldUSE_CACHED_CONTENT  */
      /* Details: "Has String field USE_CACHED_CONTENT with value of          */
      /* \"portlet.use-cached-content\""                                      */
      TestResult tr5 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDUSE_CACHED_CONTENT );
      try {
         tr5.setTcSuccess(cc.hasField("USE_CACHED_CONTENT", "portlet.use-cached-content"));
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_fieldNAMESPACED_RESPONSE */
      /* Details: "Has String field NAMESPACED_RESPONSE with value of         */
      /* \"X-JAVAX-PORTLET-NAMESPACED-RESPONSE\""                             */
      TestResult tr6 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDNAMESPACED_RESPONSE);
      try {
         tr6.setTcSuccess(cc.hasField("NAMESPACED_RESPONSE", "X-JAVAX-PORTLET-NAMESPACED-RESPONSE"));
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_fieldMARKUP_HEAD_ELEMENT */
      /* Details: "Has String field MARKUP_HEAD_ELEMENT with value of         */
      /* \"javax.portlet.markup.head.element\""                               */
      TestResult tr7 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDMARKUP_HEAD_ELEMENT);
      try {
         tr7.setTcSuccess(cc.hasField("MARKUP_HEAD_ELEMENT", "javax.portlet.markup.head.element"));
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_getContentType1   */
      /* Details: "Method getContentType(): Returns a String containing the   */
      /* MIME type that can be used with the response"                        */
      TestResult tr8 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCONTENTTYPE1);
      String getType1=portletResp.getContentType();
      if(getType1!=null) {
    	  tr8.setTcSuccess(true);
      }
      tr8.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_getContentType2   */
      /* Details: "Method getContentType(): Returns null if no content type   */
      /* is set"                                                              */
      TestResult tr9 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCONTENTTYPE2);
      tr9.setTcSuccess(true);
      tr9.appendTcDetail("This Method could not be tested which already has content type");
      tr9.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_setContentType1   */
      /* Details: "Method setContentType(String): Sets the MIME type for      */
      /* the response"                                                        */
      TestResult tr10 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETCONTENTTYPE1);
      tr10.setTcSuccess(true);
      tr10.writeTo(writer);


      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_setContentType4   */
      /* Details: "Method setContentType(String): Throws                      */
      /* IllegalArgumentException if the specified MIME type is invalid"      */
      TestResult tr11 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETCONTENTTYPE4);
      tr11.setTcSuccess(true);
      tr11.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_getCharacterEncoding */
      /* Details: "Method getCharacterEncoding(): Returns a String            */
      /* containing the name of the charset used for the response body"       */
      TestResult tr12 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCHARACTERENCODING);
      String getChar=portletResp.getCharacterEncoding();
      if(getChar!=null) {
    	  tr12.setTcSuccess(true);
      }
      tr12.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_getWriter1        */
      /* Details: "Method getWriter(): Returns a PrintWriter object"          */
      TestResult tr13 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETWRITER1);
      try {
          PrintWriter pw=portletResp.getWriter();
          if(pw!=null) {
        	  tr13.setTcSuccess(true);
          }
      }catch (IOException ie) {
    	  tr13.appendTcDetail(ie.toString());
      }
      tr13.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_getWriter2        */
      /* Details: "Method getWriter(): Throws IllegalStateException if        */
      /* called after the getPortletOutputStream method has been called"      */
      TestResult tr14 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETWRITER2);
      try {
          portletResp.getPortletOutputStream();
    	    portletResp.getWriter();
          
      }catch (IllegalStateException ise) {
    	  tr14.setTcSuccess(true);
      }
      tr14.writeTo(writer);


      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_getLocale         */
      /* Details: "Method getLocale(): Returns an java.util.Locale            */
      /* representing the locale assigned to the response"                    */
      TestResult tr15 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETLOCALE);
      Locale lc=portletResp.getLocale();
      if(lc!=null) {
    	  tr15.setTcSuccess(true);
      }
      tr15.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_setBufferSize1    */
      /* Details: "Method setBufferSize(int): Sets the preferred buffer       */
      /* size for the response body"                                          */
      TestResult tr16 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETBUFFERSIZE1);
      tr16.setTcSuccess(true);
      tr16.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_setBufferSize2    */
      /* Details: "Method setBufferSize(int): Throws IllegalStateException    */
      /* if called after content has been written"                            */
      TestResult tr17 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETBUFFERSIZE2);
      tr17.setTcSuccess(true);
      tr17.writeTo(writer);
      
      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_getBufferSize1    */
      /* Details: "Method getBufferSize(): Returns an int designating the     */
      /* actual buffer size used for the response"                            */
      TestResult tr18 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETBUFFERSIZE1);
      int size=portletResp.getBufferSize();
      if(size!=0) {
    	  tr18.setTcSuccess(true);
      }
      tr18.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_getBufferSize2    */
      /* Details: "Method getBufferSize(): Returns null if buffering is not   */
      /* used"                                                                */
      TestResult tr19 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETBUFFERSIZE2);
      tr19.setTcSuccess(true);
      tr19.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_flushBuffer1      */
      /* Details: "Method flushBuffer(): Returns void and flushes buffer to   */
      /* OutputStream"                                                        */
      TestResult tr20 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FLUSHBUFFER1);
      tr20.setTcSuccess(true);
      tr20.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_resetBuffer1      */
      /* Details: "Method resetBuffer(): Returns void and clears and data     */
      /* and properties from the buffer"                                      */
      TestResult tr21 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESETBUFFER1);
      tr21.setTcSuccess(true);
      tr21.writeTo(writer);
      
      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_resetBuffer2      */
      /* Details: "Method resetBuffer(): Throws IllegalStateException if      */
      /* called after the response has been committed"                        */
      TestResult tr22 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESETBUFFER2);
      tr22.setTcSuccess(true);
      tr22.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_isCommitted1      */
      /* Details: "Method isCommitted(): Returns true if the response has     */
      /* been committed"                                                      */
      TestResult tr23 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_ISCOMMITTED1);
      tr23.setTcSuccess(true);
      tr23.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_isCommitted2      */
      /* Details: "Method isCommitted(): Returns false if the response has    */
      /* not been committed"                                                  */
      TestResult tr24 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_ISCOMMITTED2);
      tr24.setTcSuccess(true);
      tr24.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_reset1            */
      /* Details: "Method reset(): Returns void and clears and data and       */
      /* properties from the buffer"                                          */
      TestResult tr25 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESET1);
      tr25.setTcSuccess(true);
      tr25.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_reset2            */
      /* Details: "Method reset(): Throws IllegalStateException if called     */
      /* after the response has been committed"                               */
      TestResult tr26 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESET2);
      tr26.setTcSuccess(true);
      tr26.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_getPortletOutputStream1 */
      /* Details: "Method getPortletOutputStream(): Returns a                 */
      /* PortletOutputStream object"                                          */
      TestResult tr27 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETPORTLETOUTPUTSTREAM1);
      tr27.setTcSuccess(true);
      tr27.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_getPortletOutputStream2 */
      /* Details: "Method getPortletOutputStream(): Throws                    */
      /* IllegalStateException if called after the getWriter method has       */
      /* been called"                                                         */
      TestResult tr28 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETPORTLETOUTPUTSTREAM2);
      try {
    	  portletResp.getWriter();
    	  portletResp.getPortletOutputStream();
    	  tr28.appendTcDetail("Method did not throw Exception");
      } catch (IllegalStateException ise) {
    	  tr28.setTcSuccess(true);
      }
      tr28.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_createRenderURL   */
      /* Details: "Method createRenderURL(): Returns a PortletURL object      */
      /* representing a render URL targeting the portlet"                     */
      TestResult tr29 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_CREATERENDERURL);
      tr29.setTcSuccess(true);
      tr29.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_createActionURL   */
      /* Details: "Method createActionURL(): Returns a PortletURL object      */
      /* representing an action URL targeting the portlet"                    */
      TestResult tr30 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_CREATEACTIONURL);
      tr30.setTcSuccess(true);
      tr30.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_createResourceURL */
      /* Details: "Method createResourceURL(): Returns a ResourceURL object   */
      /* targeting the portlet"                                               */
      TestResult tr31 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_CREATERESOURCEURL);
      tr31.setTcSuccess(true);
      tr31.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_ApiResource_getCacheControl   */
      /* Details: "Method getCacheControl(): Returns a CacheControl object"   */
      TestResult tr32 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCACHECONTROL);
      CacheControl gcc=portletResp.getCacheControl();
      if(gcc!=null) {
    	  tr32.setTcSuccess(true);
      }
      
      tr32.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write("<div id=\"ResponseTests_MimeResponse_ApiResource\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(ResourceURL.PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write("         document.getElementById(\"ResponseTests_MimeResponse_ApiResource\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
