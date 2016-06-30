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

import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETCONTEXTTESTS_CONTEXT_GETCLASSLOADER;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETCONTEXTTESTS_CONTEXT_GETCONTEXTPATH;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETCONTEXTTESTS_CONTEXT_GETEFFECTIVEMAJORVERSION;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETCONTEXTTESTS_CONTEXT_GETEFFECTIVEMINORVERSION;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined in the
 * /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate the test case names
 * defined in the additionalTCs.xml file into the complete list of test case names for execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will initiate the
 * events, but not process them. The processing is done in the companion portlet
 * PortletContextTests_Context_event
 * 
 */
public class PortletContextTests_Context {

   @Inject
   PortletContext portletContext;

   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {
   }

   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp) throws PortletException, IOException {
   }

   @RenderMethod(portletNames = "PortletContextTests_Context")
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V3PortletContextTests_Context_getClassLoader */
      /* Details: "The PortletContext.getClassLoader method returns the */
      /* class loader for this portlet application." */
      {
         TestResult result = tcd.getTestResultSucceeded(V3PORTLETCONTEXTTESTS_CONTEXT_GETCLASSLOADER);
         ClassLoader loader = portletContext.getClassLoader();
         if (loader == null) {
            result.setTcSuccess(false);
            result.appendTcDetail("ClassLoader was null.");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3PortletContextTests_Context_getContextPath */
      /* Details: "The PortletContext.getContextPath method returns the */
      /* context path for this portlet application." */
      {
         TestResult result = tcd.getTestResultSucceeded(V3PORTLETCONTEXTTESTS_CONTEXT_GETCONTEXTPATH);
         String path = portletContext.getContextPath();
         result.appendTcDetail("Context path: " + path);
         if (path == null) {
            result.setTcSuccess(false);
            result.appendTcDetail("Context path was null.");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3PortletContextTests_Context_getEffectiveMinorVersion */
      /* Details: "The PortletContext.getEffectiveMinorVersion method */
      /* returns the minor version of the Portlet API used by the portlet */
      /* application running in this PortletContext. " */
      {
         TestResult result = tcd.getTestResultSucceeded(V3PORTLETCONTEXTTESTS_CONTEXT_GETEFFECTIVEMINORVERSION);
         int minor = portletContext.getEffectiveMinorVersion();
         result.appendTcDetail("Effective minor version: " + minor);
         if (minor != 0) {
            result.setTcSuccess(false);
            result.appendTcDetail("Effective minor version was not 0.");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3PortletContextTests_Context_getEffectiveMajorVersion */
      /* Details: "The PortletContext.getEffectiveMajorVersion method */
      /* returns the major version of the Portlet API used by the portlet */
      /* application running in this PortletContext. " */
      {
         TestResult result = tcd.getTestResultSucceeded(V3PORTLETCONTEXTTESTS_CONTEXT_GETEFFECTIVEMAJORVERSION);
         int major = portletContext.getEffectiveMajorVersion();
         result.appendTcDetail("Effective major version: " + major);
         if (major != 3) {
            result.setTcSuccess(false);
            result.appendTcDetail("Effective major version was not 3.");
         }
         result.writeTo(writer);
      }

   }

}
