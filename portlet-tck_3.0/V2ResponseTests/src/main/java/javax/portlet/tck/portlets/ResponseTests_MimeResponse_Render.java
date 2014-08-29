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
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet ResponseTests_MimeResponse_Render_event
 *
 */
public class ResponseTests_MimeResponse_Render implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         ResponseTests_MimeResponse_Render.class.getName();
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

      /* TestCase: V2ResponseTests_MimeResponse_Render_fieldEXPIRATION_CACHE  */
      /* Details: "Has String field EXPIRATION_CACHE with value of            */
      /* \"portlet.expiration-cache\""                                        */
      TestResult tr0 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_FIELDEXPIRATION_CACHE );
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_fieldCACHE_SCOPE       */
      /* Details: "Has String field CACHE_SCOPE with value of                 */
      /* \"portlet.cache-scope\""                                             */
      TestResult tr1 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_FIELDCACHE_SCOPE );
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_fieldPUBLIC_SCOPE      */
      /* Details: "Has String field PUBLIC_SCOPE with value of                */
      /* \"portlet.public-scope\""                                            */
      TestResult tr2 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_FIELDPUBLIC_SCOPE );
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_fieldPRIVATE_SCOPE     */
      /* Details: "Has String field PRIVATE_SCOPE with value of               */
      /* \"portlet.private-scope\""                                           */
      TestResult tr3 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_FIELDPRIVATE_SCOPE );
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_fieldETAG              */
      /* Details: "Has String field ETAG with value of \"portlet.ETag\""      */
      TestResult tr4 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_FIELDETAG );
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_fieldUSE_CACHED_CONTENT  */
      /* Details: "Has String field USE_CACHED_CONTENT with value of          */
      /* \"portlet.use-cached-content\""                                      */
      TestResult tr5 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_FIELDUSE_CACHED_CONTENT );
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_fieldNAMESPACED_RESPONSE */
      /* Details: "Has String field NAMESPACED_RESPONSE with value of         */
      /* \"X-JAVAX-PORTLET-NAMESPACED-RESPONSE\""                             */
      TestResult tr6 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_FIELDNAMESPACED_RESPONSE);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_fieldMARKUP_HEAD_ELEMENT */
      /* Details: "Has String field MARKUP_HEAD_ELEMENT with value of         */
      /* \"javax.portlet.markup.head.element\""                               */
      TestResult tr7 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_FIELDMARKUP_HEAD_ELEMENT);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_getContentType1        */
      /* Details: "Method getContentType(): Returns a String containing the   */
      /* MIME type that can be used with the response"                        */
      TestResult tr8 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_GETCONTENTTYPE1);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_getContentType2        */
      /* Details: "Method getContentType(): Returns null if no content type   */
      /* is set"                                                              */
      TestResult tr9 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_GETCONTENTTYPE2);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_setContentType1        */
      /* Details: "Method setContentType(String): Sets the MIME type for      */
      /* the response"                                                        */
      TestResult tr10 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_SETCONTENTTYPE1);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_setContentType4        */
      /* Details: "Method setContentType(String): Throws                      */
      /* IllegalArgumentException if the specified MIME type is invalid"      */
      TestResult tr11 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_SETCONTENTTYPE4);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_getCharacterEncoding   */
      /* Details: "Method getCharacterEncoding(): Returns a String            */
      /* containing the name of the charset used for the response body"       */
      TestResult tr12 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_GETCHARACTERENCODING);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_getWriter1             */
      /* Details: "Method getWriter(): Returns a PrintWriter object"          */
      TestResult tr13 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_GETWRITER1);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_getWriter2             */
      /* Details: "Method getWriter(): Throws IllegalStateException if        */
      /* called after the getPortletOutputStream method has been called"      */
      TestResult tr14 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_GETWRITER2);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_getLocale              */
      /* Details: "Method getLocale(): Returns an java.util.Locale            */
      /* representing the locale assigned to the response"                    */
      TestResult tr15 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_GETLOCALE);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_setBufferSize1         */
      /* Details: "Method setBufferSize(int): Sets the preferred buffer       */
      /* size for the response body"                                          */
      TestResult tr16 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_SETBUFFERSIZE1);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_setBufferSize2         */
      /* Details: "Method setBufferSize(int): Throws IllegalStateException    */
      /* if called after content has been written"                            */
      TestResult tr17 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_SETBUFFERSIZE2);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_getBufferSize1         */
      /* Details: "Method getBufferSize(): Returns an int designating the     */
      /* actual buffer size used for the response"                            */
      TestResult tr18 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_GETBUFFERSIZE1);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_getBufferSize2         */
      /* Details: "Method getBufferSize(): Returns null if buffering is not   */
      /* used"                                                                */
      TestResult tr19 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_GETBUFFERSIZE2);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_flushBuffer1           */
      /* Details: "Method flushBuffer(): Returns void and flushes buffer to   */
      /* OutputStream"                                                        */
      TestResult tr20 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_FLUSHBUFFER1);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_resetBuffer1           */
      /* Details: "Method resetBuffer(): Returns void and clears and data     */
      /* and properties from the buffer"                                      */
      TestResult tr21 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_RESETBUFFER1);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_resetBuffer2           */
      /* Details: "Method resetBuffer(): Throws IllegalStateException if      */
      /* called after the response has been committed"                        */
      TestResult tr22 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_RESETBUFFER2);
      /* TODO: implement test */
      tr22.appendTcDetail("Not implemented.");
      tr22.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_isCommitted1           */
      /* Details: "Method isCommitted(): Returns true if the response has     */
      /* been committed"                                                      */
      TestResult tr23 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_ISCOMMITTED1);
      /* TODO: implement test */
      tr23.appendTcDetail("Not implemented.");
      tr23.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_isCommitted2           */
      /* Details: "Method isCommitted(): Returns false if the response has    */
      /* not been committed"                                                  */
      TestResult tr24 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_ISCOMMITTED2);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_reset1                 */
      /* Details: "Method reset(): Returns void and clears and data and       */
      /* properties from the buffer"                                          */
      TestResult tr25 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_RESET1);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_reset2                 */
      /* Details: "Method reset(): Throws IllegalStateException if called     */
      /* after the response has been committed"                               */
      TestResult tr26 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_RESET2);
      /* TODO: implement test */
      tr26.appendTcDetail("Not implemented.");
      tr26.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_getPortletOutputStream1 */
      /* Details: "Method getPortletOutputStream(): Returns a                 */
      /* PortletOutputStream object"                                          */
      TestResult tr27 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_GETPORTLETOUTPUTSTREAM1);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_getPortletOutputStream2 */
      /* Details: "Method getPortletOutputStream(): Throws                    */
      /* IllegalStateException if called after the getWriter method has       */
      /* been called"                                                         */
      TestResult tr28 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_GETPORTLETOUTPUTSTREAM2);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_createRenderURL        */
      /* Details: "Method createRenderURL(): Returns a PortletURL object      */
      /* representing a render URL targeting the portlet"                     */
      TestResult tr29 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_CREATERENDERURL);
      /* TODO: implement test */
      tr29.appendTcDetail("Not implemented.");
      tr29.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_createActionURL        */
      /* Details: "Method createActionURL(): Returns a PortletURL object      */
      /* representing an action URL targeting the portlet"                    */
      TestResult tr30 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_CREATEACTIONURL);
      /* TODO: implement test */
      tr30.appendTcDetail("Not implemented.");
      tr30.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_createResourceURL      */
      /* Details: "Method createResourceURL(): Returns a ResourceURL object   */
      /* targeting the portlet"                                               */
      TestResult tr31 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_CREATERESOURCEURL);
      /* TODO: implement test */
      tr31.appendTcDetail("Not implemented.");
      tr31.writeTo(writer);

      /* TestCase: V2ResponseTests_MimeResponse_Render_getCacheControl        */
      /* Details: "Method getCacheControl(): Returns a CacheControl object"   */
      TestResult tr32 = tcd.getTestResultFailed(V2RESPONSETESTS_MIMERESPONSE_RENDER_GETCACHECONTROL);
      /* TODO: implement test */
      tr32.appendTcDetail("Not implemented.");
      tr32.writeTo(writer);

   }

}
