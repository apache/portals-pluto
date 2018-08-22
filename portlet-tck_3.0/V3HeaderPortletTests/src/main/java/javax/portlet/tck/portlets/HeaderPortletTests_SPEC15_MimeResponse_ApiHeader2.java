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
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.HeaderPortlet;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.Supports;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETPORTLETOUTPUTSTREAM1 ;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETWRITER2 ;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETBUFFERSIZE2 ;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC15_MimeResponse_ApiHeader2", supports = {
      @Supports(mimeType = "*/*"), @Supports(mimeType = "text/html") })
public class HeaderPortletTests_SPEC15_MimeResponse_ApiHeader2 implements Portlet, HeaderPortlet {

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
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_MimeResponse_ApiHeader2");
      writer.write("<p>" + msg + "</p>\n");
      renderRequest.removeAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_MimeResponse_ApiHeader2");
   }

   @Override
   public void renderHeaders(HeaderRequest headerRequest, HeaderResponse headerResponse)
         throws PortletException, IOException {
      
      StringWriter writer = new StringWriter();
      
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      
      headerResponse.setContentType("text/html");
      
      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getPortletOutputStream1 */
      /* Details: "Method getPortletOutputStream(): Returns a PortletOutputStream   */
      /* object"                                                                    */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETPORTLETOUTPUTSTREAM1);
         try{
            OutputStream outputStream = headerResponse.getPortletOutputStream();
            if(outputStream!=null){
               result.setTcSuccess(true);
            }
         } catch(Exception e){
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getWriter2    */
      /* Details: "Method getWriter(): Throws IllegalStateException if called after */
      /* the getPortletOutputStream method has been called"                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETWRITER2);
         try {
            headerResponse.getWriter();
         } catch (IllegalStateException ise) {
            result.appendTcDetail(ise.toString());
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getBufferSize2 */
      /* Details: "Method getBufferSize(): Returns null if buffering is not used"   */

      {
         TestResult result = tcd.getTestResultSucceeded(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETBUFFERSIZE2);
         result.appendTcDetail("Cannot be tested as using buffers is implementation specific.");
         result.writeTo(writer);
      }
      
      headerRequest.setAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_MimeResponse_ApiHeader2",
            writer.toString());
   }

}
