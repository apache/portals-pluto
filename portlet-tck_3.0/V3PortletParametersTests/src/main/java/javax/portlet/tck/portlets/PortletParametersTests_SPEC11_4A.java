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
import javax.portlet.HeaderPortlet;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.MutableActionParameters;
import javax.portlet.MutableRenderParameters;
import javax.portlet.MutableResourceParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
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
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupButton;
import javax.portlet.tck.beans.TestSetupLink;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_GETNAMES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_GETVALUES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_SIZE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_GETNAMES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_SIZE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_GETVALUES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4A_RENDER_PHASE_GETNAMES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4A_RENDER_PHASE_SIZE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4A_RENDER_PHASE_GETVALUES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4A_RESOURCE_PHASE_GETNAMES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4A_RESOURCE_PHASE_GETVALUES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETPARAMETERSTESTS_SPEC11_4A_RESOURCE_PHASE_SIZE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */

@PortletConfiguration(portletName = "PortletParametersTests_SPEC11_4A", publicParams = {"myPRP1", "myPRP2"})
public class PortletParametersTests_SPEC11_4A implements Portlet,
    HeaderPortlet, ResourceServingPortlet {

    private PortletConfig portletConfig = null;

    private final static String SPEC_11_4A_ACTION_PHASE_GETNAMES_STATUS = "SPEC_11_4A_ACTION_PHASE_GETNAMES_STATUS";
    private final static String SPEC_11_4A_ACTION_PHASE_GETNAMES_MESSAGE = "SPEC_11_4A_ACTION_PHASE_GETNAMES_MESSAGE";
    private final static String SPEC_11_4A_ACTION_PHASE_GETVALUES_STATUS = "SPEC_11_4A_ACTION_PHASE_GETVALUES_STATUS";
    private final static String SPEC_11_4A_ACTION_PHASE_GETVALUES_MESSAGE = "SPEC_11_4A_ACTION_PHASE_GETVALUES_MESSAGE";
    private final static String SPEC_11_4A_ACTION_PHASE_SIZE_STATUS = "SPEC_11_4A_ACTION_PHASE_SIZE_STATUS";
    private final static String SPEC_11_4A_ACTION_PHASE_SIZE_MESSAGE = "SPEC_11_4A_ACTION_PHASE_SIZE_MESSAGE";
    private final static String SPEC_11_4A_HEADER_PHASE_GETNAMES_STATUS = "SPEC_11_4A_HEADER_PHASE_GETNAMES_STATUS";
    private final static String SPEC_11_4A_HEADER_PHASE_GETNAMES_MESSAGE = "SPEC_11_4A_HEADER_PHASE_GETNAMES_MESSAGE";
    private final static String SPEC_11_4A_HEADER_PHASE_GETVALUES_STATUS = "SPEC_11_4A_HEADER_PHASE_GETVALUES_STATUS";
    private final static String SPEC_11_4A_HEADER_PHASE_GETVALUES_MESSAGE = "SPEC_11_4A_HEADER_PHASE_GETVALUES_MESSAGE";
    private final static String SPEC_11_4A_HEADER_PHASE_SIZE_STATUS = "SPEC_11_4A_HEADER_PHASE_SIZE_STATUS";
    private final static String SPEC_11_4A_HEADER_PHASE_SIZE_MESSAGE = "SPEC_11_4A_HEADER_PHASE_SIZE_MESSAGE";

    @Override
    public void init(PortletConfig config) throws PortletException {
        this.portletConfig = config;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, IOException {
        ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

        /* TestCase: V3PortletParametersTests_SPEC11_4A_actionPhaseGetNames */
        /* Details: "Returns one set of strings containing the action parameter names and another containing the render parameter names */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_GETNAMES);
            ActionParameters actionParameters = actionRequest.getActionParameters();
            RenderParameters renderParameters = actionRequest.getRenderParameters();
            if (!actionParameters.isEmpty()) {
                boolean valid = true;
                Set<String> actionParameterNames = actionParameters.getNames();
                if (!actionParameterNames.contains("myActionParam1")) {
                    result.appendTcDetail("action parameter myActionParam1 not found");
                    valid = false;
                }
                if (!actionParameterNames.contains("myPRP1")) {
                    result.appendTcDetail("action parameter myPRP1 (same name as public render parameter) not found");
                    valid = false;
                }
                Set<String> renderParameterNames = renderParameters.getNames();
                if (!renderParameterNames.contains("myRenderParam1") || renderParameters.isPublic("myRenderParam1")) {
                    result.appendTcDetail("private render parameter myRenderParam1 not found");
                    valid = false;
                }
                if (!renderParameterNames.contains("myPRP1") || !renderParameters.isPublic("myPRP1")) {
                    result.appendTcDetail("public render parameter myPRP1 not found");
                    valid = false;
                }
                if (!renderParameterNames.contains("myPRP2") || !renderParameters.isPublic("myPRP2")) {
                    result.appendTcDetail("public render parameter myPRP2 not found");
                    valid = false;
                }
                if (valid) {
                    result.appendTcDetail("successfully set and read ACTION and RENDER parameter names");
                    result.setTcSuccess(true);
                }
                PortletSession session = actionRequest.getPortletSession();
                session.setAttribute(SPEC_11_4A_ACTION_PHASE_GETNAMES_STATUS, result.isTcSuccess());
                session.setAttribute(SPEC_11_4A_ACTION_PHASE_GETNAMES_MESSAGE, result.getTcDetail());
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_4A_actionPhaseGetValues */
        /* Details: "Returns one string array of action parameter values for a given name, and another with render parameter values for a different name */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_GETVALUES);
            ActionParameters actionParameters = actionRequest.getActionParameters();
            RenderParameters renderParameters = actionRequest.getRenderParameters();
            if (!actionParameters.isEmpty() && !renderParameters.isEmpty()) {
                boolean valid = true;
                String[] trPrivate = actionParameters.getValues("myActionParam1");
                if (trPrivate == null || (trPrivate.length != 3) || !trPrivate[0].equals("a") || !trPrivate[1].equals("b") || !trPrivate[2].equals("c")) {
                    result.appendTcDetail("failed to get action parameter values for myActionParam1");
                    valid = false;
                }
                trPrivate = actionRequest.getParameterValues("myPRP1");
                if (trPrivate == null || (trPrivate.length != 4) || !trPrivate[0].equals("actionParamValue") || !trPrivate[1].equals("x") || !trPrivate[2].equals("y") || !trPrivate[3].equals("z")) {
                    result.appendTcDetail("failed to get combined PRP+ACTION parameter values for myPRP1");
                    valid = false;
                }
                String[] myRenderParam1 = renderParameters.getValues("myRenderParam1");
                if (myRenderParam1 == null || (myRenderParam1.length != 1) || renderParameters.isPublic("myRenderParam1") || !myRenderParam1[0].equals("abc")) {
                    result.appendTcDetail("failed to get public render parameter value for myRenderParam1");
                    valid = false;
                }
                String[] myPRP1 = renderParameters.getValues("myPRP1");
                if (myPRP1 == null || (myPRP1.length != 3) || !renderParameters.isPublic("myPRP1") || !myPRP1[0].equals("x") || !myPRP1[1].equals("y") || !myPRP1[2].equals("z")) {
                    result.appendTcDetail("failed to get public render parameter value for myPRP1");
                    valid = false;
                }
                String[] myPRP2 = renderParameters.getValues("myPRP2");
                if (myPRP2 == null || (myPRP2.length != 1) || !renderParameters.isPublic("myPRP2") || !myPRP2[0].equals("xyz")) {
                    result.appendTcDetail("failed to get public render parameter value for myPRP2");
                    valid = false;
                }
                if (valid) {
                    result.appendTcDetail("successfully getValues on action and render parameters");
                    result.setTcSuccess(true);
                }
                PortletSession session = actionRequest.getPortletSession();
                session.setAttribute(SPEC_11_4A_ACTION_PHASE_GETVALUES_STATUS, result.isTcSuccess());
                session.setAttribute(SPEC_11_4A_ACTION_PHASE_GETVALUES_MESSAGE, result.getTcDetail());
            }
        }

        /* TestCase: V3PortletParametersTests_SPEC11_4A_actionPhaseSize */
        /* Details: "Returns the number of action and render parameters available" */
        {
            TestResult result = tcd.getTestResultSucceeded(V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_SIZE);
            ActionParameters actionParams = actionRequest.getActionParameters();
            RenderParameters renderParams = actionRequest.getRenderParameters();
            int expectedActionCount = 3; // myActionParam1, inputval, and myPRP1
            int expectedRenderCount = 3; // myRenderParm1, myPRP1, and myPRP2
            if (expectedActionCount != actionParams.size()) {
                result.appendTcDetail("Failed to get correct Action Parameters count, expected: " + expectedActionCount + ", found: " + actionParams.size());
                result.setTcSuccess(false);
            }
            else if (expectedRenderCount != renderParams.size()) {
                result.appendTcDetail("Failed to get correct Render Parameters count, expected: " + expectedRenderCount + ", found: " + renderParams.size());
                result.setTcSuccess(false);
            }
            else {
                result.appendTcDetail("Found correct count of Action and Render parameters.");
            }
            PortletSession session = actionRequest.getPortletSession();
            session.setAttribute(SPEC_11_4A_ACTION_PHASE_SIZE_STATUS, result.isTcSuccess());
            session.setAttribute(SPEC_11_4A_ACTION_PHASE_SIZE_MESSAGE, result.getTcDetail());
        }

        MutableRenderParameters mutableRenderParameters = actionResponse.getRenderParameters();
        mutableRenderParameters.setValue("myPRP2", "valueFromActionPhase");
    }

    @Override
    public void renderHeaders(
        HeaderRequest headerRequest, HeaderResponse headerResponse)
        throws PortletException, IOException {
        {
            RenderParameters renderParameters =
                headerRequest.getRenderParameters();
            if (!renderParameters.isEmpty()) {
                TestCaseDetails tcd = new ModuleTestCaseDetails();
                executeHeaderRenderTests(tcd, headerRequest, PortletRequest.HEADER_PHASE, renderParameters, null);
            }
        }
    }

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

        PrintWriter writer = renderResponse.getWriter();

        {
            RenderParameters renderParameters = renderRequest.getRenderParameters();
            if (renderParameters.isEmpty()) {
                ActionURL actionURL = renderResponse.createActionURL();
                MutableActionParameters mutableActionParameters = actionURL.getActionParameters();
                // Setup Action Parameter Tests
                mutableActionParameters.setValues("myActionParam1", "a", "b", "c");
                mutableActionParameters.setValues("myPRP1", "actionParamValue");
                // Setup Public Render Parameter Test
                MutableRenderParameters mutableRenderParameters = actionURL.getRenderParameters();
                mutableRenderParameters.setValues("myRenderParam1", "abc");
                mutableRenderParameters.setValues("myPRP1", "x", "y", "z");
                mutableRenderParameters.setValues("myPRP2", "xyz");
                TestSetupButton tb = new TestSetupButton(
                    V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_GETNAMES,
                    actionURL);
                tb.writeTo(writer);
            }
            else {

                // Setup ResourceURL, XHR, and DOM replacement for the RESOURCE_PHASE
                writer.write(
                    "<div id=\"PortletParametersTests_SPEC11_4A_ResourcePhase\">no resource output.</div>\n");
                ResourceURL resourceURL = renderResponse.createResourceURL();
                MutableResourceParameters mutableResourceParameters =
                    resourceURL.getResourceParameters();
                mutableResourceParameters.setValues("myResourceParam1", "1", "2", "3");
                mutableResourceParameters.setValues("myPRP2", "valueFromResourcePhase");
                writer.write("<script>\n");
                writer.write("(function () {\n");
                writer.write("   var xhr = new XMLHttpRequest();\n");
                writer.write("   xhr.onreadystatechange=function() {\n");
                writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
                writer.write(
                    "         document.getElementById(\"PortletParametersTests_SPEC11_4A_ResourcePhase\").innerHTML=xhr.responseText;\n");
                writer.write("      }\n");
                writer.write("   };\n");
                writer.write(
                    "   xhr.open(\"GET\",\"" + resourceURL.toString() + "\",true);\n");
                writer.write("   xhr.send();\n");
                writer.write("})();\n");
                writer.write("</script>\n");

                TestCaseDetails tcd = new ModuleTestCaseDetails();

                writer.write("<hr />");

                /* TestCase: V3PortletParametersTests_SPEC11_4A_headerPhaseGetNames         */
                /* Details: "Returns a set of strings containing the render parameter names */
                tcd.getTestResultFailed(
                    V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_GETNAMES);
                TestResult result;
                result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_GETNAMES);
                PortletSession session = renderRequest.getPortletSession();
                Boolean success = (Boolean) session.getAttribute(SPEC_11_4A_HEADER_PHASE_GETNAMES_STATUS);
                String message = (String) session.getAttribute(SPEC_11_4A_HEADER_PHASE_GETNAMES_MESSAGE);
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_4A_HEADER_PHASE_GETNAMES_STATUS);
                session.removeAttribute(SPEC_11_4A_HEADER_PHASE_GETNAMES_MESSAGE);

                /* TestCase: V3PortletParametersTests_SPEC11_4A_headerPhaseGetValues            */
                /* Details: "Returns a string array of render parameter values for a given name */
                result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_GETVALUES);
                session = renderRequest.getPortletSession();
                success = (Boolean) session.getAttribute(SPEC_11_4A_HEADER_PHASE_GETVALUES_STATUS);
                message = (String) session.getAttribute(SPEC_11_4A_HEADER_PHASE_GETVALUES_MESSAGE);
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_4A_HEADER_PHASE_GETVALUES_STATUS);
                session.removeAttribute(SPEC_11_4A_HEADER_PHASE_GETVALUES_MESSAGE);

                /* TestCase: V3PortletParametersTests_SPEC11_4A_headerPhaseSize            */
                /* Details: "Returns the number of action and render parameters available" */
                result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_SIZE);
                session = renderRequest.getPortletSession();
                success = (Boolean) session.getAttribute(SPEC_11_4A_HEADER_PHASE_SIZE_STATUS);
                message = (String) session.getAttribute(SPEC_11_4A_HEADER_PHASE_SIZE_MESSAGE);
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_4A_HEADER_PHASE_SIZE_STATUS);
                session.removeAttribute(SPEC_11_4A_HEADER_PHASE_SIZE_MESSAGE);

                executeHeaderRenderTests(tcd, renderRequest, PortletRequest.RENDER_PHASE, renderParameters, writer);

                /* TestCase: V3PortletParametersTests_SPEC11_4A_actionPhaseGetNames            */
                /* Details: "Returns a set of strings representing the portlet parameter names */
                tcd.getTestResultFailed(
                    V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_GETNAMES);
                writer.write("<hr />");
                result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_GETNAMES);
                session = renderRequest.getPortletSession();
                success = (Boolean) session.getAttribute(SPEC_11_4A_ACTION_PHASE_GETNAMES_STATUS);
                message = (String) session.getAttribute(SPEC_11_4A_ACTION_PHASE_GETNAMES_MESSAGE);
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_4A_ACTION_PHASE_GETNAMES_STATUS);
                session.removeAttribute(SPEC_11_4A_ACTION_PHASE_GETNAMES_MESSAGE);

                /* TestCase: V3PortletParametersTests_SPEC11_4A_actionPhaseGetValues          */
                /* Details: "Returns all action parameter values as a string array for a name */
                result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_GETVALUES);
                session = renderRequest.getPortletSession();
                success = (Boolean) session.getAttribute(SPEC_11_4A_ACTION_PHASE_GETVALUES_STATUS);
                message = (String) session.getAttribute(SPEC_11_4A_ACTION_PHASE_GETVALUES_MESSAGE);
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_4A_ACTION_PHASE_GETVALUES_STATUS);
                session.removeAttribute(SPEC_11_4A_ACTION_PHASE_GETVALUES_MESSAGE);

                /* TestCase: V3PortletParametersTests_SPEC11_4A_actionPhaseSize            */
                /* Details: "Returns the number of action and render parameters available" */
                result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_SIZE);
                session = renderRequest.getPortletSession();
                success = (Boolean) session.getAttribute(SPEC_11_4A_ACTION_PHASE_SIZE_STATUS);
                message = (String) session.getAttribute(SPEC_11_4A_ACTION_PHASE_SIZE_MESSAGE);
                result.setTcSuccess(success);
                result.setTcDetail(message);
                result.writeTo(writer);
                session.removeAttribute(SPEC_11_4A_ACTION_PHASE_SIZE_STATUS);
                session.removeAttribute(SPEC_11_4A_ACTION_PHASE_SIZE_MESSAGE);
            }
        }
    }

    private void executeHeaderRenderTests(TestCaseDetails tcd, RenderRequest renderRequest, String lifecyclePhase,
                                          RenderParameters renderParameters, PrintWriter writer)
        throws IOException {

        boolean headerPhase = PortletRequest.HEADER_PHASE.equals(lifecyclePhase);

        if (writer != null) {
            writer.write("<hr />");
        }

        Set<String> renderParameterNames = renderParameters.getNames();
        TestResult result;
        if (headerPhase) {
            /* TestCase: V3PortletParametersTests_SPEC11_4A_headerPhaseGetNames */
            /* Details: "Returns a set of strings containing the render parameter names */
            result = tcd.getTestResultSucceeded(V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_GETNAMES);
        }
        else {
            /* TestCase: V3PortletParametersTests_SPEC11_4A_renderPhaseGetNames */
            /* Details: "Returns a set of strings containing the render parameter names */
            result = tcd.getTestResultSucceeded(V3PORTLETPARAMETERSTESTS_SPEC11_4A_RENDER_PHASE_GETNAMES);
        }
        if (!renderParameterNames.contains("myRenderParam1") || renderParameters.isPublic("myRenderParam1")) {
            result.appendTcDetail("private render parameter myRenderParam1 not found");
            result.setTcSuccess(false);
        }
        else if (!renderParameterNames.contains("myPRP1") || !renderParameters.isPublic("myPRP1")) {
            result.appendTcDetail("public render parameter myPRP1 not found");
            result.setTcSuccess(false);
        }
        else if (!renderParameterNames.contains("myPRP2") || !renderParameters.isPublic("myPRP2")) {
            result.appendTcDetail("public render parameter myPRP2 not found");
            result.setTcSuccess(false);
        }
        else {
            result.appendTcDetail("successfully read RENDER parameter names");
        }
        if (headerPhase) {
            PortletSession session = renderRequest.getPortletSession();
            session.setAttribute(SPEC_11_4A_HEADER_PHASE_GETNAMES_STATUS, result.isTcSuccess());
            session.setAttribute(SPEC_11_4A_HEADER_PHASE_GETNAMES_MESSAGE, result.getTcDetail());
        }
        else {
            result.writeTo(writer);
        }

        if (headerPhase) {
            /* TestCase: V3PortletParametersTests_SPEC11_4A_headerPhaseGetValues */
            /* Details: "Returns a string array of render parameter values for a given name */
            result = tcd.getTestResultSucceeded(V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_GETVALUES);
        }
        else {
            /* TestCase: V3PortletParametersTests_SPEC11_4A_renderPhaseGetValues */
            /* Details: "Returns a string array of render parameter values for a given name */
            result = tcd.getTestResultSucceeded(V3PORTLETPARAMETERSTESTS_SPEC11_4A_RENDER_PHASE_GETVALUES);
        }
        String[] myRenderParam1 = renderParameters.getValues("myRenderParam1");
        String[] myPRP1 = renderParameters.getValues("myPRP1");
        String[] myPRP2 = renderParameters.getValues("myPRP2");
        if ((myRenderParam1 == null) || (myRenderParam1.length != 1) || renderParameters.isPublic("myRenderParam1") || !myRenderParam1[0].equals("abc")) {
            result.appendTcDetail("failed to get public render parameter value for myRenderParam1");
            result.setTcSuccess(false);
        }
        else if (myPRP1 == null || (myPRP1.length != 3) || !renderParameters.isPublic("myPRP1") || !myPRP1[0].equals("x") || !myPRP1[1].equals("y") || !myPRP1[2].equals("z")) {
            result.appendTcDetail("failed to get public render parameter value for myPRP1");
            result.setTcSuccess(false);
        }
        else if ((myPRP2 == null) || (myPRP2.length != 1) || !renderParameters.isPublic("myPRP2") || !myPRP2[0].equals("valueFromActionPhase")) {
            result.appendTcDetail("failed to get public render parameter value for myPRP2");
            result.setTcSuccess(false);
        }
        else {
            result.appendTcDetail("successfully getValues on render parameters");
        }
        if (headerPhase) {
            PortletSession session = renderRequest.getPortletSession();
            session.setAttribute(SPEC_11_4A_HEADER_PHASE_GETVALUES_STATUS, result.isTcSuccess());
            session.setAttribute(SPEC_11_4A_HEADER_PHASE_GETVALUES_MESSAGE, result.getTcDetail());
        }
        else {
            result.writeTo(writer);
        }

        if (headerPhase) {
            /* TestCase: V3PortletParametersTests_SPEC11_4A_headerPhaseSize */
            /* Details: "Returns the number of action and render parameters available" */
            result = tcd.getTestResultSucceeded(V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_SIZE);
        }
        else {
            /* TestCase: V3PortletParametersTests_SPEC11_4A_renderPhaseSize */
            /* Details: "Returns the number of action and render parameters available" */
            result = tcd.getTestResultSucceeded(V3PORTLETPARAMETERSTESTS_SPEC11_4A_RENDER_PHASE_SIZE);
        }
        int expectedCount = 3; // myRenderParam1, myPRP1, and myPRP2
        if (expectedCount != renderParameters.size()) {
            result.appendTcDetail("Failed to get correct Render Parameters count, expected: " + expectedCount + ", found: " + renderParameters.size());
            result.setTcSuccess(false);
        }
        else {
            result.appendTcDetail("Found correct count of Render parameters.");
        }
        if (headerPhase) {
            PortletSession session = renderRequest.getPortletSession();
            session.setAttribute(SPEC_11_4A_HEADER_PHASE_SIZE_STATUS, result.isTcSuccess());
            session.setAttribute(SPEC_11_4A_HEADER_PHASE_SIZE_MESSAGE, result.getTcDetail());
        }
        else {
            result.writeTo(writer);
        }
    }

    @Override
    public void serveResource(
        ResourceRequest resourceRequest, ResourceResponse resourceResponse)
        throws PortletException, IOException {

        PrintWriter writer = resourceResponse.getWriter();
        ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

        /* TestCase: V3PortletParametersTests_SPEC11_4A_resourcePhaseGetNames */
        /* Details: "Returns one set of strings containing the resource parameter names and another containing the render parameter names */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4A_RESOURCE_PHASE_GETNAMES);
            ResourceParameters resourceParameters = resourceRequest.getResourceParameters();
            RenderParameters renderParameters = resourceRequest.getRenderParameters();
            if (!resourceParameters.isEmpty()) {
                boolean valid = true;
                Set<String> resourceParameterNames = resourceParameters.getNames();
                if (!resourceParameterNames.contains("myResourceParam1")) {
                    result.appendTcDetail("resource parameter myResourceParam1 not found");
                    valid = false;
                }
                Set<String> renderParameterNames = renderParameters.getNames();
                if (!renderParameterNames.contains("myPRP1") || !renderParameters.isPublic("myPRP1")) {
                    result.appendTcDetail("public render parameter myPRP1 not found");
                    valid = false;
                }
                if (valid) {
                    result.appendTcDetail("successfully set and read RESOURCE and RENDER parameter names");
                    result.setTcSuccess(true);
                }
            }
            result.writeTo(writer);
        }

        /* TestCase: V3PortletParametersTests_SPEC11_4A_resourcePhaseGetValues */
        /* Details: "Returns one string array of resource parameter values for a given name, and another with render parameter values for a different name */
        {
            TestResult result = tcd.getTestResultFailed(V3PORTLETPARAMETERSTESTS_SPEC11_4A_RESOURCE_PHASE_GETVALUES);
            ResourceParameters resourceParameters = resourceRequest.getResourceParameters();
            RenderParameters renderParameters = resourceRequest.getRenderParameters();
            if (!resourceParameters.isEmpty() && !renderParameters.isEmpty()) {
                boolean valid = true;
                String[] trPrivate = resourceParameters.getValues("myResourceParam1");
                if (trPrivate == null || (trPrivate.length != 3) || !trPrivate[0].equals("1") || !trPrivate[1].equals("2") || !trPrivate[2].equals("3")) {
                    result.appendTcDetail("failed to get resource parameter values for myResourceParam1");
                    valid = false;
                }
                String[] myPRP2 = resourceParameters.getValues("myPRP2");
                if (myPRP2 == null || (myPRP2.length != 1) || !myPRP2[0].equals("valueFromResourcePhase")) {
                    result.appendTcDetail("failed to get RESOURCE parameter value for myPRP2");
                    valid = false;
                }
                myPRP2 = resourceRequest.getParameterValues("myPRP2");
                if (myPRP2 == null || (myPRP2.length != 2) || !myPRP2[0].equals("valueFromResourcePhase") || !myPRP2[1].equals("valueFromActionPhase")) {
                    result.appendTcDetail("failed to get combined PRP+RESOURCE parameter values for myPRP2");
                    valid = false;
                }
                String[] myRenderParam1 = renderParameters.getValues("myRenderParam1");
                if (myRenderParam1 == null || (myRenderParam1.length != 1) || renderParameters.isPublic("myRenderParam1") || !myRenderParam1[0].equals("abc")) {
                    result.appendTcDetail("failed to get public render parameter value for myRenderParam1");
                    valid = false;
                }
                String[] myPRP1 = renderParameters.getValues("myPRP1");
                if (myPRP1 == null || (myPRP1.length != 3) || !renderParameters.isPublic("myPRP1") || !myPRP1[0].equals("x") || !myPRP1[1].equals("y") || !myPRP1[2].equals("z")) {
                    result.appendTcDetail("failed to get public render parameter value for myPRP1");
                    valid = false;
                }
                myPRP2 = renderParameters.getValues("myPRP2");
                if (myPRP2 == null || (myPRP2.length != 1) || !renderParameters.isPublic("myPRP2") || !myPRP2[0].equals("valueFromActionPhase")) {
                    result.appendTcDetail("failed to get public render parameter value for myPRP2");
                    valid = false;
                }
                if (valid) {
                    result.appendTcDetail("successfully getValues on resource and render parameters");
                    result.setTcSuccess(true);
                }
            }
            result.writeTo(writer);
        }

        /* TestCase: V3PortletParametersTests_SPEC11_4A_resourcePhaseSize */
        /* Details: "Returns the number of resource and render parameters available" */
        {
            TestResult result = tcd.getTestResultSucceeded(V3PORTLETPARAMETERSTESTS_SPEC11_4A_RESOURCE_PHASE_SIZE);
            ResourceParameters resourceParams = resourceRequest.getResourceParameters();
            RenderParameters renderParams = resourceRequest.getRenderParameters();
            int expectedResourceCount = 2; // myResourceParam1, and myPRP2=valueFromResourcePhase
            int expectedRenderCount = 3; // myRenderParam1, myPRP1, and myPRP2=valueFromActionPhase
            if (expectedResourceCount != resourceParams.size()) {
                result.appendTcDetail("Failed to get correct Resource Parameters count, expected: " + expectedResourceCount + ", found: " + resourceParams.size());
                result.setTcSuccess(false);
            }
            else if (expectedRenderCount != renderParams.size()) {
                result.appendTcDetail("Failed to get correct Render Parameters count, expected: " + expectedRenderCount + ", found: " + renderParams.size());
                result.setTcSuccess(false);
            }
            else {
                result.appendTcDetail("Found correct count of Resource and Render parameters.");
            }
            result.writeTo(writer);
        }
    }
}
