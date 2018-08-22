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
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ActionURL;
import javax.portlet.CacheControl;
import javax.portlet.HeaderPortlet;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;
import javax.portlet.ResourceURL;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.Supports;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDEXPIRATION_CACHE ;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDCACHE_SCOPE ;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDPUBLIC_SCOPE ;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDPRIVATE_SCOPE ;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDETAG ;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDUSE_CACHED_CONTENT ;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDNAMESPACED_RESPONSE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDMARKUP_HEAD_ELEMENT;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCONTENTTYPE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETCONTENTTYPE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCONTENTTYPE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETCONTENTTYPE4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCHARACTERENCODING;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETWRITER1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETLOCALE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_ISCOMMITTED2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETBUFFERSIZE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESETBUFFER1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESET1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETBUFFERSIZE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETBUFFERSIZE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FLUSHBUFFER1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESETBUFFER2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_ISCOMMITTED1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESET2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETPORTLETOUTPUTSTREAM2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_CREATERENDERURL;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_CREATEACTIONURL;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_CREATERESOURCEURL;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCACHECONTROL;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC15_MimeResponse_ApiHeader1", supports = {
      @Supports(mimeType = "*/*"), @Supports(mimeType = "text/html") })
public class HeaderPortletTests_SPEC15_MimeResponse_ApiHeader1 implements Portlet, HeaderPortlet {

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
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_MimeResponse_ApiHeader1");
      writer.write("<p>" + msg + "</p>\n");
      renderRequest.removeAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_MimeResponse_ApiHeader1");
   }

   @Override
   public void renderHeaders(HeaderRequest headerRequest, HeaderResponse headerResponse)
         throws PortletException, IOException {
      
      StringWriter writer = new StringWriter();
      
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      
      ClassChecker cc = new ClassChecker(headerResponse.getClass());

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldEXPIRATION_CACHE  */
      /* Details: "Has String field EXPIRATION_CACHE with value of                  */
      /* \"portlet.expiration-cache\""                                              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDEXPIRATION_CACHE );
         try {
            result.setTcSuccess(
                  cc.hasField("EXPIRATION_CACHE", "portlet.expiration-cache"));
         } catch (Exception e) {
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldCACHE_SCOPE  */
      /* Details: "Has String field CACHE_SCOPE with value of                       */
      /* \"portlet.cache-scope\""                                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDCACHE_SCOPE );
         try {
            result.setTcSuccess(cc.hasField("CACHE_SCOPE", "portlet.cache-scope"));
         } catch (Exception e) {
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldPUBLIC_SCOPE  */
      /* Details: "Has String field PUBLIC_SCOPE with value of                      */
      /* \"portlet.public-scope\""                                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDPUBLIC_SCOPE );
         try {
            result.setTcSuccess(cc.hasField("PUBLIC_SCOPE", "portlet.public-scope"));
         } catch (Exception e) {
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldPRIVATE_SCOPE  */
      /* Details: "Has String field PRIVATE_SCOPE with value of                     */
      /* \"portlet.private-scope\""                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDPRIVATE_SCOPE );
         try {
            result.setTcSuccess(
                  cc.hasField("PRIVATE_SCOPE", "portlet.private-scope"));
         } catch (Exception e) {
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldETAG     */
      /* Details: "Has String field ETAG with value of \"portlet.ETag\""            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDETAG );
         try {
            result.setTcSuccess(cc.hasField("ETAG", "portlet.ETag"));
         } catch (Exception e) {
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldUSE_CACHED_CONTENT  */
      /* Details: "Has String field USE_CACHED_CONTENT with value of                */
      /* \"portlet.use-cached-content\""                                            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDUSE_CACHED_CONTENT );
         try {
            result.setTcSuccess(
                  cc.hasField("USE_CACHED_CONTENT", "portlet.use-cached-content"));
         } catch (Exception e) {
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldNAMESPACED_RESPONSE */
      /* Details: "Has String field NAMESPACED_RESPONSE with value of               */
      /* \"X-JAVAX-PORTLET-NAMESPACED-RESPONSE\""                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDNAMESPACED_RESPONSE);
         try {
            result.setTcSuccess(cc.hasField("NAMESPACED_RESPONSE",
                  "X-JAVAX-PORTLET-NAMESPACED-RESPONSE"));
         } catch (Exception e) {
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldMARKUP_HEAD_ELEMENT */
      /* Details: "Has String field MARKUP_HEAD_ELEMENT with value of               */
      /* \"javax.portlet.markup.head.element\""                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDMARKUP_HEAD_ELEMENT);
         try {
            result.setTcSuccess(cc.hasField("MARKUP_HEAD_ELEMENT",
                  "javax.portlet.markup.head.element"));
         } catch (Exception e) {
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getContentType2 */
      /* Details: "Method getContentType(): Returns null if no content type is set" */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCONTENTTYPE2);
         String getType2 = headerResponse.getContentType();
         if (getType2 == null) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because content type is already set to be "+getType2);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_setContentType1 */
      /* Details: "Method setContentType(String): Sets the MIME type for the        */
      /* response"                                                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETCONTENTTYPE1);
         try {
            headerResponse.setContentType("text/html");
            String type = headerResponse.getContentType();
            if (type.equals("text/html")) {
               result.setTcSuccess(true);
               result.appendTcDetail("Mime Type set to text/html");
            }
         } catch (IllegalArgumentException iae) {
            result.appendTcDetail(iae.toString());
         }
         result.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getContentType1 */
      /* Details: "Method getContentType(): Returns a String containing the MIME    */
      /* type that can be used with the response"                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCONTENTTYPE1);
         String getType1 = headerResponse.getContentType();
         if (getType1 != null) {
            result.setTcSuccess(true);
            result.appendTcDetail("Mime Type is "+getType1);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_setContentType4 */
      /* Details: "Method setContentType(String): Throws IllegalArgumentException   */
      /* if the specified MIME type is invalid"                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETCONTENTTYPE4);
         try {
            headerResponse.setContentType("invalid");
            result.appendTcDetail("Method did not throw Exception");
         } catch (IllegalArgumentException iae) {
            result.appendTcDetail(iae.toString());
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getCharacterEncoding */
      /* Details: "Method getCharacterEncoding(): Returns a String containing the   */
      /* name of the charset used for the response body"                            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCHARACTERENCODING);
         String getChar = headerResponse.getCharacterEncoding();
         if (getChar != null) {
            result.setTcSuccess(true);
            result.appendTcDetail("Charset is "+getChar);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getWriter1    */
      /* Details: "Method getWriter(): Returns a PrintWriter object"                */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETWRITER1);
         try {
            PrintWriter pw = headerResponse.getWriter();
            if (pw != null) {
               result.setTcSuccess(true);
            }
         } catch (IOException ie) {
            result.appendTcDetail(ie.toString());
         }
         result.writeTo(writer);
      }
      
      

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getLocale     */
      /* Details: "Method getLocale(): Returns an java.util.Locale representing the */
      /* locale assigned to the response"                                           */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETLOCALE);
         Locale lc = headerResponse.getLocale();
         if (lc != null) {
            result.appendTcDetail("Locale is "+lc);
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_isCommitted2  */
      /* Details: "Method isCommitted(): Returns false if the response has not been */
      /* committed"                                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_ISCOMMITTED2);
         result.setTcSuccess(!headerResponse.isCommitted());
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_setBufferSize1 */
      /* Details: "Method setBufferSize(int): Sets the preferred buffer size for    */
      /* the response body"                                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETBUFFERSIZE1);
         headerResponse.setBufferSize(256);
         if(headerResponse.getBufferSize()==256){
            result.setTcSuccess(true);
            result.appendTcDetail("Buffer size is set to "+headerResponse.getBufferSize());
         } else {
            result.appendTcDetail("Failed because buffer size is not set to 256 but "+headerResponse.getBufferSize());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_resetBuffer1  */
      /* Details: "Method resetBuffer(): Returns void and clears and data and       */
      /* properties from the buffer"                                                */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESETBUFFER1);
         try{
            PrintWriter pw = headerResponse.getWriter();
            pw.write("This will not be printed.");
            headerResponse.resetBuffer();
            result.setTcSuccess(true);
         } catch(Exception e) {
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_reset1        */
      /* Details: "Method reset(): Returns void and clears and data and properties  */
      /* from the buffer"                                                           */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESET1);
         try{
            PrintWriter pw = headerResponse.getWriter();
            pw.write("This will not be printed.");
            headerResponse.reset();
            result.setTcSuccess(true);
         } catch(Exception e) {
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_setBufferSize2 */
      /* Details: "Method setBufferSize(int): Throws IllegalStateException if       */
      /* called after content has been written"                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETBUFFERSIZE2);
         headerResponse.flushBuffer();
         try{
            headerResponse.setBufferSize(128);
         } catch(IllegalStateException e){
            result.setTcSuccess(true);
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getBufferSize1 */
      /* Details: "Method getBufferSize(): Returns an int designating the actual    */
      /* buffer size used for the response"                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETBUFFERSIZE1);
         int size = headerResponse.getBufferSize();
         if (size != 0) {
            result.appendTcDetail("BufferSize is found to be "+size);
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_flushBuffer1  */
      /* Details: "Method flushBuffer(): Returns void and flushes buffer to         */
      /* OutputStream"                                                              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FLUSHBUFFER1);
         try{
            headerResponse.flushBuffer();
            result.setTcSuccess(true);
         } catch (Exception e){
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_resetBuffer2  */
      /* Details: "Method resetBuffer(): Throws IllegalStateException if called     */
      /* after the response has been committed"                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESETBUFFER2);
         try{
            headerResponse.resetBuffer();
         } catch(IllegalStateException e){
            result.setTcSuccess(true);
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_isCommitted1  */
      /* Details: "Method isCommitted(): Returns true if the response has been      */
      /* committed"                                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_ISCOMMITTED1);
         result.setTcSuccess((headerResponse.isCommitted()));
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_reset2        */
      /* Details: "Method reset(): Throws IllegalStateException if called after the */
      /* response has been committed"                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESET2);
         try{
            headerResponse.reset();
         } catch(IllegalStateException e){
            result.setTcSuccess(true);
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getPortletOutputStream2 */
      /* Details: "Method getPortletOutputStream(): Throws IllegalStateException if */
      /* called after the getWriter method has been called"                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETPORTLETOUTPUTSTREAM2);
         try {
            headerResponse.getPortletOutputStream();
            result.appendTcDetail("Method did not throw Exception");
         } catch (IllegalStateException ise) {
            result.appendTcDetail(ise.toString());
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_createRenderURL */
      /* Details: "Method createRenderURL(): Returns a PortletURL object            */
      /* representing a render URL targeting the portlet"                           */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_CREATERENDERURL);
         RenderURL rurl = headerResponse.createRenderURL();
         if(rurl!=null && !rurl.equals("")){
            result.setTcSuccess(true);
            result.appendTcDetail("RenderURL created successfully - "+rurl.toString());
         } else {
            result.appendTcDetail("Failed because cannot create render URL");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_createActionURL */
      /* Details: "Method createActionURL(): Returns a PortletURL object            */
      /* representing an action URL targeting the portlet"                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_CREATEACTIONURL);
         ActionURL aurl = headerResponse.createActionURL();
         if(aurl!=null && !aurl.equals("")){
            result.setTcSuccess(true);
            result.appendTcDetail("ActionURL created successfully - "+aurl.toString());
         } else {
            result.appendTcDetail("Failed because cannot create action URL");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_createResourceURL */
      /* Details: "Method createResourceURL(): Returns a ResourceURL object         */
      /* targeting the portlet"                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_CREATERESOURCEURL);
         ResourceURL resurl = headerResponse.createResourceURL();
         if(resurl!=null && !resurl.equals("")){
            result.setTcSuccess(true);
            result.appendTcDetail("ResourceURL created successfully - "+resurl.toString());
         } else {
            result.appendTcDetail("Failed because cannot create resource URL");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getCacheControl */
      /* Details: "Method getCacheControl(): Returns a CacheControl object"         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCACHECONTROL);
         CacheControl gcc = headerResponse.getCacheControl();
         if (gcc != null) {
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }
      
      headerRequest.setAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_MimeResponse_ApiHeader1",
            writer.toString());
   }

}
