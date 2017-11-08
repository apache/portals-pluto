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

import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ActionURL;
import javax.portlet.MutableActionParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupLink;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_3_CLONE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_3_GETNAMES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_3_GETVALUE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_3_GETVALUES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_3_SIZE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */

@PortletConfiguration(portletName = "PortletParametersTests_SPEC11_3", publicParams = {"names_public1"})
public class PortletParametersTests_SPEC11_3 implements Portlet {

    private PortletConfig portletConfig = null;

    private final static String SPEC_11_3_GETNAMES_STATUS = "SPEC_11_3_GETNAMES_STATUS";
    private final static String SPEC_11_3_GETNAMES_MESSAGE = "SPEC_11_3_GETNAMES_MESSAGE";
    private final static String SPEC_11_3_GETVALUE_STATUS = "SPEC_11_3_GETVALUE_STATUS";
    private final static String SPEC_11_3_GETVALUE_MESSAGE = "SPEC_11_3_GETVALUE_MESSAGE";
    private final static String SPEC_11_3_GETVALUES_STATUS = "SPEC_11_3_GETVALUES_STATUS";
    private final static String SPEC_11_3_GETVALUES_MESSAGE = "SPEC_11_3_GETVALUES_MESSAGE";
    private final static String SPEC_11_3_SIZE_STATUS = "SPEC_11_3_SIZE_STATUS";
    private final static String SPEC_11_3_SIZE_MESSAGE = "SPEC_11_3_SIZE_MESSAGE";
    private final static String SPEC_11_3_CLONE_STATUS = "SPEC_11_3_CLONE_STATUS";
    private final static String SPEC_11_3_CLONE_MESSAGE = "SPEC_11_3_CLONE_MESSAGE";

    @Override
    public void init(PortletConfig config) throws PortletException {
        this.portletConfig = config;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {
        ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

        /* TestCase: V3PortletParametersTests_SPEC11_3_getNames                        */
        /* Details: "Returns a set of strings representing the action parameter names */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_3_GETNAMES);
            ActionParameters actionParameters = portletReq.getActionParameters();
            if (!actionParameters.isEmpty()) {
                boolean valid = true;
                if (!actionParameters.getNames().contains("names_private1")) {
                    result.appendTcDetail("action parameter names_private1 not found");
                    valid = false;
                }
                if (!actionParameters.getNames().contains("names_private2")) {
                    result.appendTcDetail("action parameter names_private2 not found");
                    valid = false;
                }
                if (!actionParameters.getNames().contains("names_public1")) {
                    result.appendTcDetail("action parameter names_public1 not found");
                    valid = false;
                }
                if (!actionParameters.getNames().contains("names_multi")) {
                    result.appendTcDetail("action parameter names_multi not found");
                    valid = false;
                }
                if (actionParameters.getNames().contains("null")) {
                    result.appendTcDetail("action parameter null should not be set");
                    valid = false;
                }
                if (valid) {
                    result.appendTcDetail("successfully set and read ACTION parameter names");
                    result.setTcSuccess(true);
                }
                PortletSession session = portletReq.getPortletSession();
                session.setAttribute(SPEC_11_3_GETNAMES_STATUS, result.isTcSuccess());
                session.setAttribute(SPEC_11_3_GETNAMES_MESSAGE, result.getTcDetail());
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_3_getValue                       */
        /* Details: "Returns a action parameter value as a string for a given name    */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_3_GETVALUE);
            ActionParameters actionParameters = portletReq.getActionParameters();
            if (!actionParameters.isEmpty()) {
                boolean valid = true;
                String trPrivate = actionParameters.getValue("names_private1");
                if (trPrivate == null || !trPrivate.equals("one")) {
                    result.appendTcDetail("failed to get action parameter value for names_private1");
                    valid = false;
                }
                trPrivate = actionParameters.getValue("names_private2");
                if (trPrivate == null || !trPrivate.equals("two")) {
                    result.appendTcDetail("failed to get action parameter value for names_private2");
                    valid = false;
                }
                trPrivate = actionParameters.getValue("names_multi");
                if (trPrivate == null || !trPrivate.equals("a")) {
                    result.appendTcDetail("failed to get first action parameter value for names_multi");
                    valid = false;
                }
                String trPublic = actionParameters.getValue("names_public1");
                if (trPublic == null || !trPublic.equals("three")) {
                    result.appendTcDetail("failed to get action parameter value for names_public1");
                    valid = false;
                }
                String nullsOk = actionParameters.getValue("names_nullok1");
                if (nullsOk != null) {
                    result.appendTcDetail("expected null value for names_nullok1 action parameter");
                    valid = false;
                }
                String decoded = actionParameters.getValue("names_encode1");
                if (decoded == null || !decoded.equals("url&enco ded")) {
                    result.appendTcDetail("failed to get decoded action parameter for names_encode1");
                    valid = false;
                }
                if (valid) {
                    result.appendTcDetail("successfully getValue on action parameters");
                    result.setTcSuccess(true);
                }
                PortletSession session = portletReq.getPortletSession();
                session.setAttribute(SPEC_11_3_GETVALUE_STATUS, result.isTcSuccess());
                session.setAttribute(SPEC_11_3_GETVALUE_MESSAGE, result.getTcDetail());
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_3_getValues                      */
        /* Details: "Returns all action parameter values as a string array for a name */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_3_GETVALUES);
            ActionParameters actionParams = portletReq.getActionParameters();
            if (!actionParams.isEmpty()) {
                boolean valid = true;
                String[] values = actionParams.getValues("names_private1");
                if (values == null || !values[0].equals("one")) {
                    result.appendTcDetail("failed to get action parameter values for names_private1");
                    valid = false;
                }
                values = actionParams.getValues("names_private2");
                if (values == null || !values[0].equals("two")) {
                    result.appendTcDetail("failed to get action parameter values for names_private2");
                    valid = false;
                }
                values = actionParams.getValues("names_multi");
                if (values == null || !Arrays.asList(values).contains("a") || !Arrays.asList(values).contains("b") ||
                        !Arrays.asList(values).contains("c")) {
                    result.appendTcDetail("failed to get all action parameter values for names_multi");
                    valid = false;
                }
                values = actionParams.getValues("names_public1");
                if (values == null || !values[0].equals("three")) {
                    result.appendTcDetail("failed to get action parameters values for names_public1");
                    valid = false;
                }
                values = actionParams.getValues("names_nullsok2");
                if (values == null || values[0] != null || !values[1].equals("notnull") || values[2] != null) {
                    result.appendTcDetail("failed to get action parameters values for names_nullsok2");
                    valid = false;
                }
                if (valid) {
                    result.appendTcDetail("successfully getValues on action parameters");
                    result.setTcSuccess(true);
                }
                PortletSession session = portletReq.getPortletSession();
                session.setAttribute(SPEC_11_3_GETVALUES_STATUS, result.isTcSuccess());
                session.setAttribute(SPEC_11_3_GETVALUES_MESSAGE, result.getTcDetail());
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_3_size                           */
        /* Details: "Returns the number of action parameters available"              */
        {
            TestResult result = tcd.getTestResultSucceeded(V3PORTLETPARAMETERSTESTS_SPEC11_3_SIZE);
            ActionParameters actionParams = portletReq.getActionParameters();
            int expectedCount = (actionParams.isEmpty()) ? 0 : 7;
            if (expectedCount != actionParams.size()) {
                result.appendTcDetail("Failed to get correct Action Parameters count, expected: " + expectedCount + ", found: " + actionParams.size());
                result.setTcSuccess(false);
            }
            else {
                result.appendTcDetail("Found correct count of Action parameters.");
            }
            PortletSession session = portletReq.getPortletSession();
            session.setAttribute(SPEC_11_3_SIZE_STATUS, result.isTcSuccess());
            session.setAttribute(SPEC_11_3_SIZE_MESSAGE, result.getTcDetail());
        }

        /* TestCase: V3PortletParametersTests_SPEC11_3_clone                          */
        /* Details: "Clones the given action parameters returning a mutable copy of  */
        /* the parameters"                                                            */
        {
            ActionParameters actionParams = portletReq.getActionParameters();
            MutableActionParameters mrp = actionParams.clone();
            TestResult result = tcd.getTestResultSucceeded(V3PORTLETPARAMETERSTESTS_SPEC11_3_CLONE);
            // check that original and clone have same parameters
            if (actionParams.size() == mrp.size()) {
                // same # params, but if param name differs, its a bug
                for (String name : mrp.getNames()) {
                    if (!actionParams.getNames().contains(name)) {
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
                if (mrp.size() == actionParams.size()) {
                    // if they are the same size, something went wrong
                    result.setTcSuccess(false);
                    result.appendTcDetail("after adding parameter, both objects same size: " + mrp.size());
                } else {
                    // If the original object contains the new parameter,
                    // the clone must somehow be linked with the original, so
                    // this is an error.
                    if (actionParams.getNames().contains("SomeParamName")) {
                        result.setTcSuccess(false);
                        result.appendTcDetail("Original contains parameter added to clone.");
                    }
                }
            }
            if (result.isTcSuccess()) {
                result.setTcDetail("Clone on Action parameters successful");
            }
            PortletSession session = portletReq.getPortletSession();
            session.setAttribute(SPEC_11_3_CLONE_STATUS, result.isTcSuccess());
            session.setAttribute(SPEC_11_3_CLONE_MESSAGE, result.getTcDetail());
        }

    }

    @Override
    public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

        PrintWriter writer = portletResp.getWriter();
        ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

        {
            RenderParameters renderParams = portletReq.getRenderParameters();
            if (renderParams.isEmpty()) {
                ActionURL actionURL = portletResp.createActionURL();
                MutableActionParameters mutableActionParameters = actionURL.getActionParameters();
                // Setup Private Tests
                mutableActionParameters.setValue("names_private1", "one");
                mutableActionParameters.setValue("names_private2", "two");
                mutableActionParameters.setValues("names_multi", "a", "b", "c");
                // Setup Public Test
                mutableActionParameters.setValue("names_public1", "three");
                mutableActionParameters.setValue("names_nullok1", null);
                mutableActionParameters.setValues("names_nullsok2", null, "notnull", null);
                // Setup Encoding Test
                mutableActionParameters.setValue("names_encode1", "url&enco ded");
                TestSetupLink tb = new TestSetupLink(
                        V3PORTLETPARAMETERSTESTS_SPEC11_3_GETNAMES,
                        actionURL);
                tb.writeTo(writer);

                // Setup NULL Tests
                boolean exceptionCaught = false;
                try {
                    mutableActionParameters.setValue(null, "bad");
                } catch (RuntimeException e) {
                    exceptionCaught = true;
                }
                if (!exceptionCaught) {
                    TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_3_GETNAMES);
                    result.writeTo(writer);
                }
            }
        }

        /* TestCase: V3ActionParametersTests_SPEC11_3_getNames                        */
        /* Details: "Returns a set of strings representing the portlet parameter names */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_3_GETNAMES);
            PortletSession session = portletReq.getPortletSession();
            Boolean success = (Boolean) session.getAttribute(SPEC_11_3_GETNAMES_STATUS);
            String message = (String) session.getAttribute(SPEC_11_3_GETNAMES_MESSAGE);
            if (success != null) {
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_3_GETNAMES_STATUS);
                session.removeAttribute(SPEC_11_3_GETNAMES_MESSAGE);
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_3_getValue                       */
        /* Details: "Returns a action parameter value as a string for a given name    */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_3_GETVALUE);
            PortletSession session = portletReq.getPortletSession();
            Boolean success = (Boolean) session.getAttribute(SPEC_11_3_GETVALUE_STATUS);
            String message = (String) session.getAttribute(SPEC_11_3_GETVALUE_MESSAGE);
            if (success != null) {
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_3_GETVALUE_STATUS);
                session.removeAttribute(SPEC_11_3_GETVALUE_MESSAGE);
            }
        }
        
        /* TestCase: V3PortletParametersTests_SPEC11_3_getValues                      */
        /* Details: "Returns all action parameter values as a string array for a name */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_3_GETVALUES);
            PortletSession session = portletReq.getPortletSession();
            Boolean success = (Boolean) session.getAttribute(SPEC_11_3_GETVALUES_STATUS);
            String message = (String) session.getAttribute(SPEC_11_3_GETVALUES_MESSAGE);
            if (success != null) {
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_3_GETVALUES_STATUS);
                session.removeAttribute(SPEC_11_3_GETVALUES_MESSAGE);
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_3_size                           */
        /* Details: "Returns the number of action parameters available"              */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_3_SIZE);
            PortletSession session = portletReq.getPortletSession();
            Boolean success = (Boolean) session.getAttribute(SPEC_11_3_SIZE_STATUS);
            String message = (String) session.getAttribute(SPEC_11_3_SIZE_MESSAGE);
            if (success != null) {
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_3_SIZE_STATUS);
                session.removeAttribute(SPEC_11_3_SIZE_MESSAGE);
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_3_clone                          */
        /* Details: "Clones the given action parameters returning a mutable copy of  */
        /* the parameters"                                                            */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_3_CLONE);
            PortletSession session = portletReq.getPortletSession();
            Boolean success = (Boolean) session.getAttribute(SPEC_11_3_CLONE_STATUS);
            String message = (String) session.getAttribute(SPEC_11_3_CLONE_MESSAGE);
            if (success != null) {
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_3_CLONE_STATUS);
                session.removeAttribute(SPEC_11_3_CLONE_MESSAGE);
            }
            else {
                result.setTcSuccess(true);
                result.setTcDetail("Action Clone test is setup and ready to run");
                result.writeTo(writer);
            }
        }


    }
}
