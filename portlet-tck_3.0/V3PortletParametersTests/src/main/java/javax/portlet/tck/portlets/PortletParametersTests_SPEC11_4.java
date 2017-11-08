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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableResourceParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4_CLONE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4_GETNAMES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4_GETVALUE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4_GETVALUES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4_SIZE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */

@PortletConfiguration(portletName = "PortletParametersTests_SPEC11_4", publicParams = {"names_public1"})
public class PortletParametersTests_SPEC11_4 implements Portlet, ResourceServingPortlet {

    private PortletConfig portletConfig = null;

    private final static String SPEC_11_4_GETNAMES_STATUS = "SPEC_11_4_GETNAMES_STATUS";
    private final static String SPEC_11_4_GETNAMES_MESSAGE = "SPEC_11_4_GETNAMES_MESSAGE";
    private final static String SPEC_11_4_GETVALUE_STATUS = "SPEC_11_4_GETVALUE_STATUS";
    private final static String SPEC_11_4_GETVALUE_MESSAGE = "SPEC_11_4_GETVALUE_MESSAGE";
    private final static String SPEC_11_4_GETVALUES_STATUS = "SPEC_11_4_GETVALUES_STATUS";
    private final static String SPEC_11_4_GETVALUES_MESSAGE = "SPEC_11_4_GETVALUES_MESSAGE";
    private final static String SPEC_11_4_SIZE_STATUS = "SPEC_11_4_SIZE_STATUS";
    private final static String SPEC_11_4_SIZE_MESSAGE = "SPEC_11_4_SIZE_MESSAGE";
    private final static String SPEC_11_4_CLONE_STATUS = "SPEC_11_4_CLONE_STATUS";
    private final static String SPEC_11_4_CLONE_MESSAGE = "SPEC_11_4_CLONE_MESSAGE";

    @Override
    public void init(PortletConfig config) throws PortletException {
        this.portletConfig = config;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
    }

    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
        ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

        /* TestCase: V3PortletParametersTests_SPEC11_4_getNames                        */
        /* Details: "Returns a set of strings representing the resource parameter names */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4_GETNAMES);
            ResourceParameters resourceParameters = resourceRequest.getResourceParameters();
            if (!resourceParameters.isEmpty()) {
                boolean valid = true;
                if (!resourceParameters.getNames().contains("names_private1")) {
                    result.appendTcDetail("resource parameter names_private1 not found");
                    valid = false;
                }
                if (!resourceParameters.getNames().contains("names_private2")) {
                    result.appendTcDetail("resource parameter names_private2 not found");
                    valid = false;
                }
                if (!resourceParameters.getNames().contains("names_public1")) {
                    result.appendTcDetail("resource parameter names_public1 not found");
                    valid = false;
                }
                if (!resourceParameters.getNames().contains("names_multi")) {
                    result.appendTcDetail("resource parameter names_multi not found");
                    valid = false;
                }
                if (resourceParameters.getNames().contains("null")) {
                    result.appendTcDetail("resource parameter null should not be set");
                    valid = false;
                }
                if (valid) {
                    result.appendTcDetail("successfully set and read RESOURCE parameter names");
                    result.setTcSuccess(true);
                }
                PortletSession session = resourceRequest.getPortletSession();
                session.setAttribute(SPEC_11_4_GETNAMES_STATUS, result.isTcSuccess());
                session.setAttribute(SPEC_11_4_GETNAMES_MESSAGE, result.getTcDetail());
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_4_getValue                       */
        /* Details: "Returns a resource parameter value as a string for a given name    */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4_GETVALUE);
            ResourceParameters resourceParameters = resourceRequest.getResourceParameters();
            if (!resourceParameters.isEmpty()) {
                boolean valid = true;
                String trPrivate = resourceParameters.getValue("names_private1");
                if (trPrivate == null || !trPrivate.equals("one")) {
                    result.appendTcDetail("failed to get resource parameter value for names_private1");
                    valid = false;
                }
                trPrivate = resourceParameters.getValue("names_private2");
                if (trPrivate == null || !trPrivate.equals("two")) {
                    result.appendTcDetail("failed to get resource parameter value for names_private2");
                    valid = false;
                }
                trPrivate = resourceParameters.getValue("names_multi");
                if (trPrivate == null || !trPrivate.equals("a")) {
                    result.appendTcDetail("failed to get first resource parameter value for names_multi");
                    valid = false;
                }
                String trPublic = resourceParameters.getValue("names_public1");
                if (trPublic == null || !trPublic.equals("three")) {
                    result.appendTcDetail("failed to get resource parameter value for names_public1");
                    valid = false;
                }
                String nullsOk = resourceParameters.getValue("names_nullok1");
                if (nullsOk != null) {
                    result.appendTcDetail("expected null value for names_nullok1 resource parameter");
                    valid = false;
                }
                String decoded = resourceParameters.getValue("names_encode1");
                if (decoded == null || !decoded.equals("url&enco ded")) {
                    result.appendTcDetail("failed to get decoded resource parameter for names_encode1");
                    valid = false;
                }
                if (valid) {
                    result.appendTcDetail("successfully getValue on resource parameters");
                    result.setTcSuccess(true);
                }
                PortletSession session = resourceRequest.getPortletSession();
                session.setAttribute(SPEC_11_4_GETVALUE_STATUS, result.isTcSuccess());
                session.setAttribute(SPEC_11_4_GETVALUE_MESSAGE, result.getTcDetail());
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_4_getValues                      */
        /* Details: "Returns all resource parameter values as a string array for a name */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4_GETVALUES);
            ResourceParameters resourceParams = resourceRequest.getResourceParameters();
            if (!resourceParams.isEmpty()) {
                boolean valid = true;
                String[] values = resourceParams.getValues("names_private1");
                if (values == null || !values[0].equals("one")) {
                    result.appendTcDetail("failed to get resource parameter values for names_private1");
                    valid = false;
                }
                values = resourceParams.getValues("names_private2");
                if (values == null || !values[0].equals("two")) {
                    result.appendTcDetail("failed to get resource parameter values for names_private2");
                    valid = false;
                }
                values = resourceParams.getValues("names_multi");
                if (values == null || !Arrays.asList(values).contains("a") || !Arrays.asList(values).contains("b") ||
                        !Arrays.asList(values).contains("c")) {
                    result.appendTcDetail("failed to get all resource parameter values for names_multi");
                    valid = false;
                }
                values = resourceParams.getValues("names_public1");
                if (values == null || !values[0].equals("three")) {
                    result.appendTcDetail("failed to get resource parameters values for names_public1");
                    valid = false;
                }
                values = resourceParams.getValues("names_nullsok2");
                if (values == null || values[0] != null || !values[1].equals("notnull") || values[2] != null) {
                    result.appendTcDetail("failed to get resource parameters values for names_nullsok2");
                    valid = false;
                }
                if (valid) {
                    result.appendTcDetail("successfully getValues on resource parameters");
                    result.setTcSuccess(true);
                }
                PortletSession session = resourceRequest.getPortletSession();
                session.setAttribute(SPEC_11_4_GETVALUES_STATUS, result.isTcSuccess());
                session.setAttribute(SPEC_11_4_GETVALUES_MESSAGE, result.getTcDetail());
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_4_size                           */
        /* Details: "Returns the number of resource parameters available"              */
        {
            TestResult result = tcd.getTestResultSucceeded(V3PORTLETPARAMETERSTESTS_SPEC11_4_SIZE);
            ResourceParameters resourceParams = resourceRequest.getResourceParameters();
            int expectedCount = (resourceParams.isEmpty()) ? 0 : 7;
            if (expectedCount != resourceParams.size()) {
                result.appendTcDetail("Failed to get correct Resource Parameters count, expected: " + expectedCount + ", found: " + resourceParams.size());
                result.setTcSuccess(false);
            }
            else {
                result.appendTcDetail("Found correct count of Render parameters.");
            }
            PortletSession session = resourceRequest.getPortletSession();
            session.setAttribute(SPEC_11_4_SIZE_STATUS, result.isTcSuccess());
            session.setAttribute(SPEC_11_4_SIZE_MESSAGE, result.getTcDetail());
        }

        /* TestCase: V3PortletParametersTests_SPEC11_4_clone                          */
        /* Details: "Clones the given resource parameters returning a mutable copy of  */
        /* the parameters"                                                            */
        {
            ResourceParameters resourceParams = resourceRequest.getResourceParameters();
            MutableResourceParameters mrp = resourceParams.clone();
            TestResult result = tcd.getTestResultSucceeded(V3PORTLETPARAMETERSTESTS_SPEC11_4_CLONE);
            // check that original and clone have same parameters
            if (resourceParams.size() == mrp.size()) {
                // same # params, but if param name differs, its a bug
                for (String name : mrp.getNames()) {
                    if (!resourceParams.getNames().contains(name)) {
                        result.setTcSuccess(false);
                        result.appendTcDetail("Original does not contain parameter: " + name);
                        break;
                    }
                }
            } else {
                // there is a differing number of parameters, so fail test
                result.setTcSuccess(false);
                result.appendTcDetail("differing number parameters.");
            }
            // test if the objects are independent:
            if (result.isTcSuccess() == true) {

                mrp.setValue("SomeParamName", "SomeParamValue");
                if (mrp.size() == resourceParams.size()) {
                    // if they are the same size, something went wrong
                    result.setTcSuccess(false);
                    result.appendTcDetail("after adding parameter, both objects same size: " + mrp.size());
                } else {
                    // If the original object contains the new parameter,
                    // the clone must somehow be linked with the original, so
                    // this is an error.
                    if (resourceParams.getNames().contains("SomeParamName")) {
                        result.setTcSuccess(false);
                        result.appendTcDetail("Original contains parameter added to clone.");
                    }
                }
            }
            if (result.isTcSuccess()) {
                result.setTcDetail("Clone on Resource parameters successful");
            }
            PortletSession session = resourceRequest.getPortletSession();
            session.setAttribute(SPEC_11_4_CLONE_STATUS, result.isTcSuccess());
            session.setAttribute(SPEC_11_4_CLONE_MESSAGE, result.getTcDetail());
        }

    }

    @Override
    public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

        PrintWriter writer = portletResp.getWriter();
        ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

        {
            RenderParameters resourceParams = portletReq.getRenderParameters();
            if (resourceParams.isEmpty()) {
                ResourceURL resourceURL = portletResp.createResourceURL();
                MutableResourceParameters mutableResourceParameters = resourceURL.getResourceParameters();
                // Setup Private Tests
                mutableResourceParameters.setValue("names_private1", "one");
                mutableResourceParameters.setValue("names_private2", "two");
                mutableResourceParameters.setValues("names_multi", "a", "b", "c");
                // Setup Public Test
                mutableResourceParameters.setValue("names_public1", "three");
                mutableResourceParameters.setValue("names_nullok1", null);
                mutableResourceParameters.setValues("names_nullsok2", null, "notnull", null);
                // Setup Encoding Test
                mutableResourceParameters.setValue("names_encode1", "url&enco ded");

                writer.write(
                    "<div id=\"PortletParametersTests_SPEC11_4_Resource\">no resource output.</div>\n");
                writer.write("<script>\n");
                writer.write("(function () {\n");
                writer.write("   var xhr = new XMLHttpRequest();\n");
                writer.write("   xhr.onreadystatechange=function() {\n");
                writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
                writer.write(
                    "         document.getElementById(\"PortletParametersTests_SPEC11_4_Resource\").innerHTML=xhr.responseText;\n");
                writer.write("      }\n");
                writer.write("   };\n");
                writer.write(
                    "   xhr.open(\"GET\",\"" + resourceURL.toString() + "\",true);\n");
                writer.write("   xhr.send();\n");
                writer.write("})();\n");
                writer.write("</script>\n");

                // Setup NULL Tests
                boolean exceptionCaught = false;
                try {
                    mutableResourceParameters.setValue(null, "bad");
                } catch (RuntimeException e) {
                    exceptionCaught = true;
                }
                if (!exceptionCaught) {
                    TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4_GETNAMES);
                    result.writeTo(writer);
                }
            }
        }

        /* TestCase: V3ResourceParametersTests_SPEC11_4_getNames                        */
        /* Details: "Returns a set of strings representing the portlet parameter names */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4_GETNAMES);
            PortletSession session = portletReq.getPortletSession();
            Boolean success = (Boolean) session.getAttribute(SPEC_11_4_GETNAMES_STATUS);
            String message = (String) session.getAttribute(SPEC_11_4_GETNAMES_MESSAGE);
            if (success != null) {
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_4_GETNAMES_STATUS);
                session.removeAttribute(SPEC_11_4_GETNAMES_MESSAGE);
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_4_getValue                       */
        /* Details: "Returns a resource parameter value as a string for a given name    */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4_GETVALUE);
            PortletSession session = portletReq.getPortletSession();
            Boolean success = (Boolean) session.getAttribute(SPEC_11_4_GETVALUE_STATUS);
            String message = (String) session.getAttribute(SPEC_11_4_GETVALUE_MESSAGE);
            if (success != null) {
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_4_GETVALUE_STATUS);
                session.removeAttribute(SPEC_11_4_GETVALUE_MESSAGE);
            }
        }
        
        /* TestCase: V3PortletParametersTests_SPEC11_4_getValues                      */
        /* Details: "Returns all resource parameter values as a string array for a name */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4_GETVALUES);
            PortletSession session = portletReq.getPortletSession();
            Boolean success = (Boolean) session.getAttribute(SPEC_11_4_GETVALUES_STATUS);
            String message = (String) session.getAttribute(SPEC_11_4_GETVALUES_MESSAGE);
            if (success != null) {
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_4_GETVALUES_STATUS);
                session.removeAttribute(SPEC_11_4_GETVALUES_MESSAGE);
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_4_size                           */
        /* Details: "Returns the number of resource parameters available"              */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4_SIZE);
            PortletSession session = portletReq.getPortletSession();
            Boolean success = (Boolean) session.getAttribute(SPEC_11_4_SIZE_STATUS);
            String message = (String) session.getAttribute(SPEC_11_4_SIZE_MESSAGE);
            if (success != null) {
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_4_SIZE_STATUS);
                session.removeAttribute(SPEC_11_4_SIZE_MESSAGE);
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_4_clone                          */
        /* Details: "Clones the given resource parameters returning a mutable copy of  */
        /* the parameters"                                                            */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4_CLONE);
            PortletSession session = portletReq.getPortletSession();
            Boolean success = (Boolean) session.getAttribute(SPEC_11_4_CLONE_STATUS);
            String message = (String) session.getAttribute(SPEC_11_4_CLONE_MESSAGE);
            if (success != null) {
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_4_CLONE_STATUS);
                session.removeAttribute(SPEC_11_4_CLONE_MESSAGE);
            }
            else {
                result.setTcSuccess(true);
                result.setTcDetail("Resource Clone test is setup and ready to run");
                result.writeTo(writer);
            }
        }


    }
}
