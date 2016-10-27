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

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_GETDISPATCHERTYPE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_GETPORTLETASYNCCONTEXT;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_ISASYNCSTARTED;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_ISASYNCSUPPORTED;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_STARTASYNC1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_STARTASYNC2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletAsyncContext;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.tck.beans.ResourceLink;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import javax.servlet.DispatcherType;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "ResourceAsyncTests_SPEC_21_NoAsync")
public class ResourceAsyncTests_SPEC_21_NoAsync implements Portlet, ResourceServingPortlet {
   
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
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: V3ResourceAsyncTests_SPEC_21_NoAsync_isAsyncSupported            */
      /* Details: "The ResourceRequest object isAsyncSupported() method returns     */
      /* false if the portlet does not support async processing"                    */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_ISASYNCSUPPORTED) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_ISASYNCSUPPORTED, rurl);
         link.writeResourceFetcherImmediate(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_NoAsync_isAsyncStarted              */
      /* Details: "The ResourceRequest object isAsyncStarted() method returns false */
      /* if the portlet does not support async processing"                          */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_ISASYNCSTARTED) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_ISASYNCSTARTED, rurl);
         link.writeResourceFetcherImmediate(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_NoAsync_startAsync1                 */
      /* Details: "The ResourceRequest object startAsync() method throws an         */
      /* IllegalStateException if the portlet does not support async processing"    */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_STARTASYNC1) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_STARTASYNC1, rurl);
         link.writeResourceFetcherImmediate(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_NoAsync_startAsync2                 */
      /* Details: "The ResourceRequest object startAsync(ResourceRequest,           */
      /* ResourceResponse) method throws an IllegalStateException if the portlet    */
      /* does not support async processing"                                         */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_STARTASYNC2) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_STARTASYNC2, rurl);
         link.writeResourceFetcherImmediate(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_NoAsync_getDispatcherType           */
      /* Details: "The ResourceRequest object getDispatcherType() method returns    */
      /* the value DispatcherType.REQUEST within the resource method if the portlet */
      /* does not support async processing"                                         */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_GETDISPATCHERTYPE) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_GETDISPATCHERTYPE, rurl);
         link.writeResourceFetcherImmediate(writer);
      }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_NoAsync_getPortletAsyncContext      */
      /* Details: "The ResourceRequest object getPortletAsyncContext() method       */
      /* returns the value null if the portlet does not support async processing"   */
      {
         ResourceURL rurl = portletResp.createResourceURL();
         rurl.getResourceParameters().setValue("testcase",V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_GETPORTLETASYNCCONTEXT) ;
         ResourceLink link = new ResourceLink(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_GETPORTLETASYNCCONTEXT, rurl);
         link.writeResourceFetcherImmediate(writer);
      }

   }

   @SuppressWarnings("unused")
   @Override
   public void serveResource(ResourceRequest req, ResourceResponse resp) throws PortletException, IOException {

      resp.setContentType("text/html");
      resp.setCharacterEncoding("UTF-8");
      PrintWriter writer = resp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      String testcase = req.getResourceParameters().getValue("testcase");
      TestResult result = null;
      
      if (testcase == null) {
         writer.write("Unknown test case: null");

      /* TestCase: V3ResourceAsyncTests_SPEC_21_NoAsync_isAsyncSupported            */
      /* Details: "The ResourceRequest object isAsyncSupported() method returns     */
      /* false if the portlet does not support async processing"                    */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_ISASYNCSUPPORTED)) {
         result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_ISASYNCSUPPORTED);
         if (req.isAsyncSupported() == false) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("isAsyncSupported returns true when async is not supported.");
         }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_NoAsync_isAsyncStarted              */
      /* Details: "The ResourceRequest object isAsyncStarted() method returns false */
      /* if the portlet does not support async processing"                          */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_ISASYNCSTARTED)) {
         result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_ISASYNCSTARTED);
         if (req.isAsyncStarted() == false) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("isAsyncStarted returns true when async is not supported.");
         }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_NoAsync_startAsync1                 */
      /* Details: "The ResourceRequest object startAsync() method throws an         */
      /* IllegalStateException if the portlet does not support async processing"    */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_STARTASYNC1)) {
         result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_STARTASYNC1);
         try {
            PortletAsyncContext ctx = req.startPortletAsync();
            result.appendTcDetail("startPortletAsync did not throw exception although async is not supported.");
         } catch (IllegalStateException e) {
            result.setTcSuccess(true);
         } catch (Throwable t) {
            result.appendTcDetail("startPortletAsync threw unexpected exception type: " + t.getMessage());
         }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_NoAsync_startAsync2                 */
      /* Details: "The ResourceRequest object startAsync(ResourceRequest,           */
      /* ResourceResponse) method throws an IllegalStateException if the portlet    */
      /* does not support async processing"                                         */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_STARTASYNC2)) {
         result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_STARTASYNC2);
         try {
            PortletAsyncContext ctx = req.startPortletAsync(req, resp);
            result.appendTcDetail("startPortletAsync did not throw exception although async is not supported.");
         } catch (IllegalStateException e) {
            result.setTcSuccess(true);
         } catch (Throwable t) {
            result.appendTcDetail("startPortletAsync threw unexpected exception type: " + t.getMessage());
         }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_NoAsync_getDispatcherType           */
      /* Details: "The ResourceRequest object getDispatcherType() method returns    */
      /* the value DispatcherType.REQUEST within the resource method if the portlet */
      /* does not support async processing"                                         */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_GETDISPATCHERTYPE)) {
         result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_GETDISPATCHERTYPE);
         DispatcherType dt = req.getDispatcherType();
         if (dt == DispatcherType.REQUEST) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Unexpected dispatcher type: " + dt.name());
         }

      /* TestCase: V3ResourceAsyncTests_SPEC_21_NoAsync_getPortletAsyncContext      */
      /* Details: "The ResourceRequest object getPortletAsyncContext() method       */
      /* throws an IllegalStateException if the portlet does not support async processing"   */
      } else if (testcase.equals(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_GETPORTLETASYNCCONTEXT)) {
         result = tcd.getTestResultFailed(V3RESOURCEASYNCTESTS_SPEC_21_NOASYNC_GETPORTLETASYNCCONTEXT);
         try {
            PortletAsyncContext ctx = req.getPortletAsyncContext();
            result.appendTcDetail("Method did not throw exception although async is not supported.");
         } catch (IllegalStateException e) {
            result.setTcSuccess(true);
         } catch (Throwable t) {
            result.appendTcDetail("Method threw unexpected exception type: " + t.getMessage());
         }

      } else {
         writer.write("Unknown test case:" + testcase);
      }

      if (result != null) {
         writer.write(result.toString());
      }

   }

}
