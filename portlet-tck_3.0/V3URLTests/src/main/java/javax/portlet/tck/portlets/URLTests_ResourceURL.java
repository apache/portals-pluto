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
import javax.portlet.ResourceURL;
import javax.portlet.MutableResourceParameters;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;
import javax.portlet.tck.beans.CompareUtils;
import javax.portlet.tck.beans.ResourceLink;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_RESOURCEURL_GETRESOURCEPARAMETERS;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_RESOURCEURL_GETRESOURCEPARAMETERS2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_RESOURCEURL_GETRESOURCEPARAMETERS3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_RESOURCEURL_SETPARAMETERB7;

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

public class URLTests_ResourceURL {

   @Inject
   PortletConfig portletConfig;

   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {
   }

   @ServeResourceMethod(portletNames = "ResourceURLTests")
   public void serveResource(ResourceRequest portletReq,
         ResourceResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();

      // evaluate results for test case
      // V3URLTests_ResourceURL_setParameterB7
      {
         ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
         TestResult tr8 = tcd.getTestResultFailed(
             V3URLTESTS_RESOURCEURL_SETPARAMETERB7);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
             .equals("V3URLTests_ResourceURL_setParameterB7")) {
            String[] aval = portletReq.getParameterValues("parm1");
            String[] eval = null;
            CompareUtils.arraysEqual("Request", aval, " expected: ", eval, tr8);
            tr8.writeTo(writer);
         }
      }
   }

   @RenderMethod(portletNames = "ResourceURLTests")
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      ResourceURL resourceURL = portletResp.createResourceURL();
      MutableResourceParameters mutableResourceParams = resourceURL
            .getResourceParameters();

      /* TestCase: V3URLTests_ResourceURL_getResourceParameters */
      /*
       * Details: "Initially the returned object is empty."
       */
      {
         TestResult tr0 = tcd
               .getTestResultFailed(V3URLTESTS_RESOURCEURL_GETRESOURCEPARAMETERS);
         if (mutableResourceParams != null && mutableResourceParams.isEmpty()) {
            tr0.setTcSuccess(true);
         } else {
            tr0.appendTcDetail("Failed because " + mutableResourceParams.size()
                  + " resource parameters exist");
         }
         tr0.writeTo(writer);
      }

      /* TestCase: V3URLTests_ResourceURL_getResourceParameters2 */
      /*
       * Details: "Modifying the parameter values encapsulated by the returned
       * object directly modifies the resource parameters applied to the URL."
       */
      {
         TestResult tr1 = tcd
               .getTestResultFailed(V3URLTESTS_RESOURCEURL_GETRESOURCEPARAMETERS2);
         mutableResourceParams.setValue("tr1", "true");
         Map<String, String[]> actionParameterMap = resourceURL.getParameterMap();
         if (actionParameterMap.containsKey("tr1")
               && actionParameterMap.get("tr1")[0].equals("true")) {
            tr1.setTcSuccess(true);
         } else {
            tr1.appendTcDetail(
                  "Failed because resource parameter tr1 set on the returned object is not present in ResourceURL");
         }
         tr1.writeTo(writer);
      }

      /* TestCase: V3URLTests_ResourceURL_getResourceParameters3 */
      /*
       * Details: "Gets the resource parameter values set for this URL."
       */
      {
         TestResult tr2 = tcd
               .getTestResultFailed(V3URLTESTS_RESOURCEURL_GETRESOURCEPARAMETERS3);
         mutableResourceParams.setValue("tr2", "true");
         MutableResourceParameters mutableResourceParams_tr2 = resourceURL
               .getResourceParameters();
         if (!mutableResourceParams_tr2.isEmpty()
               && mutableResourceParams_tr2.getNames().contains("tr2")
               && mutableResourceParams_tr2.getValue("tr2").equals("true")) {
            tr2.setTcSuccess(true);
         } else {
            tr2.appendTcDetail(
                  "Failed because resource parameter tr2 set in resourceURL cannot be found.");
         }
         tr2.writeTo(writer);
      }

      /* TestCase: V3URLTests_ResourceURL_setParameterB7 */
      /* Details: "Method setParameter(String, String[]): If the value is */
      /* null, all values for the specified key are removed" */
      TestResult tr8 = tcd.getTestResultFailed(
          V3URLTESTS_RESOURCEURL_SETPARAMETERB7);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
             "V3URLTests_ResourceURL_setParameterB7");
         turl.setParameter("parm1", new String[] { "val1", "val2", "val3" });
         turl.setParameter("parm1", (String[]) null);

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
             "V3URLTests_ResourceURL_setParameterB7", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr8.appendTcDetail(e);
         tr8.writeTo(writer);
      }

   }

}
