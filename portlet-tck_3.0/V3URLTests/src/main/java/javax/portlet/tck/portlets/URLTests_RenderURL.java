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

import javax.inject.Inject;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.tck.beans.CompareUtils;
import javax.portlet.tck.beans.TestLink;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import java.io.IOException;
import java.io.PrintWriter;

import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_RENDERURL_GETFRAGMENTIDENTIFIER;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_RENDERURL_GETFRAGMENTIDENTIFIER2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_RENDERURL_SETPARAMETERB7;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for
 * events, this portlet will initiate the events, but not process them. The
 * processing is done in the companion portlet PortletContextTests_Context_event
 * 
 */

public class URLTests_RenderURL {

   @Inject
   PortletConfig portletConfig;

   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {
   }

   public void serveResource(ResourceRequest portletReq,
         ResourceResponse portletResp) throws PortletException, IOException {
   }

   @RenderMethod(portletNames = "RenderURLTests")
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      RenderURL renderURL = portletResp.createRenderURL();

      /* TestCase: V3URLTests_RenderURL_setFragmentIdentifier. */
      /*
       * Details: "Sets a fragment identifier on the URL."
       */
      {
         TestResult tr0 = tcd
               .getTestResultFailed(V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER);
         renderURL.setFragmentIdentifier("tr0");
         if (renderURL.getFragmentIdentifier() != null
               && renderURL.getFragmentIdentifier().equals("tr0")) {
            tr0.appendTcDetail(
                  "Found fragment identifier tr0 in " + renderURL.toString());
            tr0.setTcSuccess(true);
         } else {
            tr0.appendTcDetail(
                  "Failed because fragment identifier tr0 is not found in "
                        + renderURL.toString());
         }
         tr0.writeTo(writer);
      }

      /* TestCase: V3URLTests_RenderURL_getFragmentIdentifier. */
      /*
       * Details: "Gets the fragment identifier previously set on the URL."
       */
      {
         TestResult tr5 = tcd
               .getTestResultFailed(V3URLTESTS_RENDERURL_GETFRAGMENTIDENTIFIER);
         renderURL.setFragmentIdentifier("tr5");
         if (renderURL.getFragmentIdentifier() != null
               && renderURL.getFragmentIdentifier().equals("tr5")) {
            tr5.appendTcDetail(
                  "Found fragment identifier tr5 in " + renderURL.toString());
            tr5.setTcSuccess(true);
         } else {
            tr5.appendTcDetail(
                  "Failed because fragment identifier tr5 is not found in "
                        + renderURL.toString());
         }
         tr5.writeTo(writer);
      }

      /* TestCase: V3URLTests_RenderURL_setFragmentIdentifier2. */
      /*
       * Details: A URL can have only a single fragment identifier. Any
       * previously set fragment identifier will be replaced."
       */
      {
         TestResult tr1 = tcd.getTestResultFailed(
               V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER2);
         renderURL.setFragmentIdentifier("tr1");
         if (renderURL.getFragmentIdentifier() != null
               && renderURL.getFragmentIdentifier().equals("tr1")) {
            tr1.appendTcDetail(
                  "Found fragment identifier tr1 in " + renderURL.toString());
            tr1.setTcSuccess(true);
         } else {
            tr1.appendTcDetail(
                  "Failed because fragment identifier tr1 is not found in "
                        + renderURL.toString());
         }
         tr1.writeTo(writer);
      }

      /* TestCase: V3URLTests_RenderURL_setFragmentIdentifier3. */
      /*
       * Details: The fragment identifier consists of additional information
       * appended to the URL after a '#' character."
       */
      {
         TestResult tr2 = tcd.getTestResultFailed(
               V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER3);
         renderURL.setFragmentIdentifier("tr2");
         if (renderURL.toString().split("#")[1].equals("tr2")) {
            tr2.appendTcDetail(
                  "Found fragment identifier tr2 appended at the end of renderURL - "
                        + renderURL.toString());
            tr2.setTcSuccess(true);
         } else {
            tr2.appendTcDetail(
                  "Failed because fragment identifier tr2 is not found/appended at the end in renderURL - "
                        + renderURL.toString());
         }
         tr2.writeTo(writer);
      }

      /* TestCase: V3URLTests_RenderURL_setFragmentIdentifier4. */
      /*
       * Details: Setting the fragment identifier to null will remove a fragment
       * identifier previously set through this method."
       */
      {
         TestResult tr3 = tcd.getTestResultFailed(
               V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER4);
         try {
            renderURL.setFragmentIdentifier(null);
            if (renderURL.getFragmentIdentifier() == null) {
               tr3.appendTcDetail(
                     "Fragment identifier is successfully removed from renderURL - "
                           + renderURL.toString());
               tr3.setTcSuccess(true);
            } else {
               tr3.appendTcDetail("Failed because fragment identifier "
                     + renderURL.getFragmentIdentifier()
                     + " is still present in renderURL - "
                     + renderURL.toString());
            }
         } catch (Exception e) {
            tr3.appendTcDetail(e.toString());
         }
         tr3.writeTo(writer);
      }
      
      /* TestCase: V3URLTests_RenderURL_getFragmentIdentifier2. */
      /*
       * Details: "Returns null if no fragment identifier has been set."
       */
      {
         TestResult tr6 = tcd.getTestResultFailed(
               V3URLTESTS_RENDERURL_GETFRAGMENTIDENTIFIER2);
         try {
            renderURL.setFragmentIdentifier(null);
            if (renderURL.getFragmentIdentifier() == null) {
               tr6.appendTcDetail("No fragment identifier exists in "
                     + renderURL.toString());
               tr6.setTcSuccess(true);
            } else {
               tr6.appendTcDetail("Failed because fragment identifier "
                     + renderURL.getFragmentIdentifier() + " is present in "
                     + renderURL.toString());
            }
         } catch (Exception e) {
            tr6.appendTcDetail(e.toString());
         }
         tr6.writeTo(writer);
      }

      /* TestCase: V3URLTests_RenderURL_setFragmentIdentifier5. */
      /*
       * Details: Setting the empty string as the fragment identifier will
       * create an empty fragment identifier."
       */
      {
         TestResult tr4 = tcd.getTestResultFailed(
               V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER5);
         renderURL.setFragmentIdentifier("");
         if (renderURL.getFragmentIdentifier().equals("")) {
            tr4.appendTcDetail(
                  "Empty fragment identifier is present in renderURL - "
                        + renderURL.toString());
            tr4.setTcSuccess(true);
         } else {
            tr4.appendTcDetail(
                  "Failed because fragment identifier is not empty in renderURL - "
                        + renderURL.toString());
         }
         tr4.writeTo(writer);
      }

      /* TestCase: V3URLTests_RenderURL_setParameterB7 */
      /* Details: "Method setParameter(String, String[]): If the value is */
      /* null, all values for the specified key are removed" */
      TestResult tr10 = tcd.getTestResultFailed(
          V3URLTESTS_RENDERURL_SETPARAMETERB7);
      try {
         PortletURL turl = portletResp.createRenderURL();
         turl.setParameter("tc",
             "V3URLTests_RenderURL_setParameterB7");
         turl.setParameter("parm1", new String[] { "val1", "val2", "val3" });
         turl.setParameter("parm1", (String[]) null);

         // add the execution link
         TestLink tl = new TestLink(
             "V3URLTests_RenderURL_setParameterB7", turl);
         tl.writeTo(writer);

         // evaluate results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
             .equals("V3URLTests_RenderURL_setParameterB7")) {
            String[] aval = portletReq.getParameterValues("parm1");
            String[] eval = null;
            CompareUtils.arraysEqual("Request", aval, " expected: ", eval,
                tr10);
         }
      } catch (Exception e) {
         tr10.appendTcDetail(e);
      }
      tr10.writeTo(writer);

   }

}
