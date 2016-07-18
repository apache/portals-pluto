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

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC15_MimeResponse_ApiHeader")
public class HeaderPortletTests_SPEC15_MimeResponse_ApiHeader implements Portlet {
   
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

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldEXPIRATION_CACHE  */
      /* Details: "Has String field EXPIRATION_CACHE with value of                  */
      /* \"portlet.expiration-cache\""                                              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDEXPIRATION_CACHE );
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldCACHE_SCOPE  */
      /* Details: "Has String field CACHE_SCOPE with value of                       */
      /* \"portlet.cache-scope\""                                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDCACHE_SCOPE );
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldPUBLIC_SCOPE  */
      /* Details: "Has String field PUBLIC_SCOPE with value of                      */
      /* \"portlet.public-scope\""                                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDPUBLIC_SCOPE );
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldPRIVATE_SCOPE  */
      /* Details: "Has String field PRIVATE_SCOPE with value of                     */
      /* \"portlet.private-scope\""                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDPRIVATE_SCOPE );
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldETAG     */
      /* Details: "Has String field ETAG with value of \"portlet.ETag\""            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDETAG );
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldUSE_CACHED_CONTENT  */
      /* Details: "Has String field USE_CACHED_CONTENT with value of                */
      /* \"portlet.use-cached-content\""                                            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDUSE_CACHED_CONTENT );
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldNAMESPACED_RESPONSE */
      /* Details: "Has String field NAMESPACED_RESPONSE with value of               */
      /* \"X-JAVAX-PORTLET-NAMESPACED-RESPONSE\""                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDNAMESPACED_RESPONSE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldMARKUP_HEAD_ELEMENT */
      /* Details: "Has String field MARKUP_HEAD_ELEMENT with value of               */
      /* \"javax.portlet.markup.head.element\""                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDMARKUP_HEAD_ELEMENT);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getContentType1 */
      /* Details: "Method getContentType(): Returns a String containing the MIME    */
      /* type that can be used with the response"                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCONTENTTYPE1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getContentType2 */
      /* Details: "Method getContentType(): Returns null if no content type is set" */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCONTENTTYPE2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_setContentType1 */
      /* Details: "Method setContentType(String): Sets the MIME type for the        */
      /* response"                                                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETCONTENTTYPE1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_setContentType2 */
      /* Details: "Method setContentType(String): Has no effect if called after the */
      /* getWriter method has been called"                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETCONTENTTYPE2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_setContentType3 */
      /* Details: "Method setContentType(String): Has no effect if called after the */
      /* getPortletOutputStream method has been called"                             */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETCONTENTTYPE3);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_setContentType4 */
      /* Details: "Method setContentType(String): Throws IllegalArgumentException   */
      /* if the specified MIME type is invalid"                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETCONTENTTYPE4);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getCharacterEncoding */
      /* Details: "Method getCharacterEncoding(): Returns a String containing the   */
      /* name of the charset used for the response body"                            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCHARACTERENCODING);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getWriter1    */
      /* Details: "Method getWriter(): Returns a PrintWriter object"                */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETWRITER1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getWriter2    */
      /* Details: "Method getWriter(): Throws IllegalStateException if called after */
      /* the getPortletOutputStream method has been called"                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETWRITER2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getLocale     */
      /* Details: "Method getLocale(): Returns an java.util.Locale representing the */
      /* locale assigned to the response"                                           */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETLOCALE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_setBufferSize1 */
      /* Details: "Method setBufferSize(int): Sets the preferred buffer size for    */
      /* the response body"                                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETBUFFERSIZE1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_setBufferSize2 */
      /* Details: "Method setBufferSize(int): Throws IllegalStateException if       */
      /* called after content has been written"                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETBUFFERSIZE2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getBufferSize1 */
      /* Details: "Method getBufferSize(): Returns an int designating the actual    */
      /* buffer size used for the response"                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETBUFFERSIZE1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getBufferSize2 */
      /* Details: "Method getBufferSize(): Returns null if buffering is not used"   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETBUFFERSIZE2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_flushBuffer1  */
      /* Details: "Method flushBuffer(): Returns void and flushes buffer to         */
      /* OutputStream"                                                              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FLUSHBUFFER1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_resetBuffer1  */
      /* Details: "Method resetBuffer(): Returns void and clears and data and       */
      /* properties from the buffer"                                                */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESETBUFFER1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_resetBuffer2  */
      /* Details: "Method resetBuffer(): Throws IllegalStateException if called     */
      /* after the response has been committed"                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESETBUFFER2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_isCommitted1  */
      /* Details: "Method isCommitted(): Returns true if the response has been      */
      /* committed"                                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_ISCOMMITTED1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_isCommitted2  */
      /* Details: "Method isCommitted(): Returns false if the response has not been */
      /* committed"                                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_ISCOMMITTED2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_reset1        */
      /* Details: "Method reset(): Returns void and clears and data and properties  */
      /* from the buffer"                                                           */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESET1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_reset2        */
      /* Details: "Method reset(): Throws IllegalStateException if called after the */
      /* response has been committed"                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESET2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getPortletOutputStream1 */
      /* Details: "Method getPortletOutputStream(): Returns a PortletOutputStream   */
      /* object"                                                                    */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETPORTLETOUTPUTSTREAM1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getPortletOutputStream2 */
      /* Details: "Method getPortletOutputStream(): Throws IllegalStateException if */
      /* called after the getWriter method has been called"                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETPORTLETOUTPUTSTREAM2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_createRenderURL */
      /* Details: "Method createRenderURL(): Returns a PortletURL object            */
      /* representing a render URL targeting the portlet"                           */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_CREATERENDERURL);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_createActionURL */
      /* Details: "Method createActionURL(): Returns a PortletURL object            */
      /* representing an action URL targeting the portlet"                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_CREATEACTIONURL);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_createResourceURL */
      /* Details: "Method createResourceURL(): Returns a ResourceURL object         */
      /* targeting the portlet"                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_CREATERESOURCEURL);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getCacheControl */
      /* Details: "Method getCacheControl(): Returns a CacheControl object"         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCACHECONTROL);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

   }

}
