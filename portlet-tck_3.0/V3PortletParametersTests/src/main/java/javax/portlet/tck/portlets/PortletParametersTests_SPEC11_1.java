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
import javax.portlet.MutableRenderParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.PortletQName;
import javax.portlet.annotations.PublicRenderParameterDefinition;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupLink;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_1_CLONE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_1_GETNAMES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_1_GETVALUE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_1_GETVALUES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_1_SIZE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */

@PortletApplication(
        publicParams = {
                @PublicRenderParameterDefinition(identifier = "myPRP1", qname = @PortletQName(localPart = "myPRP1", namespaceURI = "")),
                @PublicRenderParameterDefinition(identifier = "myPRP2", qname = @PortletQName(localPart = "myPRP2", namespaceURI = "")),
                @PublicRenderParameterDefinition(identifier = "names_public1", qname = @PortletQName(localPart = "names_public1", namespaceURI = ""))
        })
@PortletConfiguration(portletName = "PortletParametersTests_SPEC11_1", publicParams = {"names_public1"})
public class PortletParametersTests_SPEC11_1 implements Portlet {

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

        {
            RenderParameters renderParams = portletReq.getRenderParameters();
            if (renderParams.isEmpty()) {
                RenderURL renderURL = portletResp.createRenderURL();
                MutableRenderParameters mutableRenderParams = renderURL.getRenderParameters();
                // Setup Private Tests
                mutableRenderParams.setValue("names_private1", "one");
                mutableRenderParams.setValue("names_private2", "two");
                mutableRenderParams.setValues("names_multi", "a", "b", "c");
                // Setup Public Test
                mutableRenderParams.setValue("names_public1", "three");
                mutableRenderParams.setValue("names_nullok1", null);
                mutableRenderParams.setValues("names_nullsok2", null, "notnull", null);
                // Setup Encoding Test
                mutableRenderParams.setValue("names_encode1", "url&enco ded");
                TestSetupLink tb = new TestSetupLink(
                        V3PORTLETPARAMETERSTESTS_SPEC11_1_GETNAMES,
                        renderURL);
                tb.writeTo(writer);

                // Setup NULL Tests
                boolean exceptionCaught = false;
                try {
                    mutableRenderParams.setValue(null, "bad");
                } catch (RuntimeException e) {
                    exceptionCaught = true;
                }
                if (!exceptionCaught) {
                    TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_1_GETNAMES);
                    result.writeTo(writer);
                }
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_1_getNames                        */
        /* Details: "Returns a set of strings representing the portlet parameter names */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_1_GETNAMES);
            RenderParameters renderParams = portletReq.getRenderParameters();
            if (!renderParams.isEmpty()) {
                boolean valid = true;
                if (!renderParams.getNames().contains("names_private1")) {
                    result.appendTcDetail("private render parameter names_private1 not found");
                    valid = false;
                }
                if (!renderParams.getNames().contains("names_private2")) {
                    result.appendTcDetail("private render parameter names_private2 not found");
                    valid = false;
                }
                if (!renderParams.getNames().contains("names_public1")) {
                    result.appendTcDetail("private render parameter names_public1 not found");
                    valid = false;
                }
                if (!renderParams.getNames().contains("names_multi")) {
                    result.appendTcDetail("private render parameter names_multi not found");
                    valid = false;
                }
                if (!renderParams.isPublic("names_public1")) {
                    result.appendTcDetail("expected public render parameter");
                    valid = false;
                }
                if (renderParams.getNames().contains("null")) {
                    result.appendTcDetail("private render parameter null should not be set");
                    valid = false;
                }
                if (valid) {
                    result.appendTcDetail("successfully set and read private and public render parameter names");
                    result.setTcSuccess(true);
                }
                result.writeTo(writer);
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_1_getValue                       */
        /* Details: "Returns a single portlet parameter value as a string for a given */
        /* name"                                                                      */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_1_GETVALUE);
            RenderParameters renderParams = portletReq.getRenderParameters();
            if (!renderParams.isEmpty()) {
                boolean valid = true;
                String trPrivate = renderParams.getValue("names_private1");
                if (trPrivate == null || !trPrivate.equals("one")) {
                    result.appendTcDetail("failed to get private render parameter value for names_private1");
                    valid = false;
                }
                trPrivate = renderParams.getValue("names_private2");
                if (trPrivate == null || !trPrivate.equals("two")) {
                    result.appendTcDetail("failed to get private render parameter value for names_private2");
                    valid = false;
                }
                trPrivate = renderParams.getValue("names_multi");
                if (trPrivate == null || !trPrivate.equals("a")) {
                    result.appendTcDetail("failed to get first private render parameter value for names_multi");
                    valid = false;
                }
                String trPublic = renderParams.getValue("names_public1");
                if (trPublic == null || !trPublic.equals("three")) {
                    result.appendTcDetail("failed to get public render parameter value for names_public1");
                    valid = false;
                }
                if (!renderParams.isPublic("names_public1")) {
                    result.appendTcDetail("expected public render parameter value for names_public1");
                    valid = false;
                }
                String nullsOk = renderParams.getValue("names_nullok1");
                if (nullsOk != null) {
                    result.appendTcDetail("expected null value for names_nullok1 render parameter");
                    valid = false;
                }
                String decoded = renderParams.getValue("names_encode1");
                if (decoded == null || !decoded.equals("url&enco ded")) {
                    result.appendTcDetail("failed to get decoded private render parameter for names_encode1");
                    valid = false;
                }
                if (valid) {
                    result.appendTcDetail("successfully getValue on private and public render parameters");
                    result.setTcSuccess(true);
                }
                result.writeTo(writer);
            }

        }

        /* TestCase: V3PortletParametersTests_SPEC11_1_getValues                      */
        /* Details: "Returns all portlet parameter value as a string array for a      */
        /* given name"                                                                */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_1_GETVALUES);
            RenderParameters renderParams = portletReq.getRenderParameters();
            if (!renderParams.isEmpty()) {
                boolean valid = true;
                String[] values = renderParams.getValues("names_private1");
                if (values == null || !values[0].equals("one")) {
                    result.appendTcDetail("failed to get private render parameter values for names_private1");
                    valid = false;
                }
                values = renderParams.getValues("names_private2");
                if (values == null || !values[0].equals("two")) {
                    result.appendTcDetail("failed to get private render parameter values for names_private2");
                    valid = false;
                }
                values = renderParams.getValues("names_multi");
                if (values == null || !Arrays.asList(values).contains("a") || !Arrays.asList(values).contains("b") ||
                        !Arrays.asList(values).contains("c")) {
                    result.appendTcDetail("failed to get all private render parameter values for names_multi");
                    valid = false;
                }
                values = renderParams.getValues("names_public1");
                if (values == null || !values[0].equals("three")) {
                    result.appendTcDetail("failed to get public render parameters values for names_public1");
                    valid = false;
                }
                values = renderParams.getValues("names_nullsok2");
                if (values == null || values[0] != null || !values[1].equals("notnull") || values[2] != null) {
                    result.appendTcDetail("failed to get public render parameters values for names_nullsok2");
                    valid = false;
                }
                if (valid) {
                    result.appendTcDetail("successfully getValues on private and public render parameters");
                    result.setTcSuccess(true);
                }
                result.writeTo(writer);
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_1_size                           */
        /* Details: "Returns the number of portlet parameters available"              */
        {
            TestResult result = tcd.getTestResultSucceeded(V3PORTLETPARAMETERSTESTS_SPEC11_1_SIZE);
            RenderParameters renderParams = portletReq.getRenderParameters();
            int expectedCount = (renderParams.isEmpty()) ? 0 : 7;
            if (expectedCount != renderParams.size()) {
                result.appendTcDetail("Failed to get correct Render Parameters count, expected: " + expectedCount + ", found: " + renderParams.size());
                result.setTcSuccess(false);
            }
            else {
                result.appendTcDetail("Found correct count of Render parameters.");
            }
            result.writeTo(writer);
        }

        /* TestCase: V3PortletParametersTests_SPEC11_1_clone                          */
        /* Details: "Clones the given portlet parameters returning a mutable copy of  */
        /* the parameters"                                                            */
        {
            RenderParameters renderParams = portletReq.getRenderParameters();
            MutableRenderParameters mrp = renderParams.clone();
            TestResult result = tcd.getTestResultSucceeded(V3PORTLETPARAMETERSTESTS_SPEC11_1_CLONE);
            // check that original and clone have same parameters
            if (renderParams.size() == mrp.size()) {
                // same # params, but if param name differs, its a bug
                for (String name : mrp.getNames()) {
                    if (!renderParams.getNames().contains(name)) {
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
                if (mrp.size() == renderParams.size()) {
                    // if they are the same size, something went wrong
                    result.setTcSuccess(false);
                    result.appendTcDetail("after adding parameter, both objects same size: " + mrp.size());
                } else {
                    // If the original object contains the new parameter,
                    // the clone must somehow be linked with the original, so
                    // this is an error.
                    if (renderParams.getNames().contains("SomeParamName")) {
                        result.setTcSuccess(false);
                        result.appendTcDetail("Original contains parameter added to clone.");
                    }
                }
            }
            result.writeTo(writer);
        }
    }
}
