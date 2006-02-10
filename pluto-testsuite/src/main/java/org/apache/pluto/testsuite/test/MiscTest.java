/*
 * Copyright 2003,2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.testsuite.test;

import java.util.Enumeration;
import java.util.Properties;

import javax.portlet.PortletContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.WindowState;

import org.apache.pluto.testsuite.ExpectedResults;
import org.apache.pluto.testsuite.TestResult;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public class MiscTest extends AbstractReflectivePortletTest {


    protected TestResult checkContextMajorVersion(PortletContext ctx) {
        TestResult res = new TestResult();
        res.setName("Major Version Test");
        res.setDesc("Make sure that the expected major version number is returned.");
        Properties props = ExpectedResults.getExpectedProperties();
        String major = String.valueOf(ctx.getMajorVersion());
        if(major.equals(props.getProperty("expected.version.major"))) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Major Version: "+major+". Expected: "+props.getProperty("expected.version.major"));
        }
        return res;
    }

    protected TestResult checkContextMinorVersion(PortletContext ctx) {
        TestResult res = new TestResult();
        res.setName("Minor Version Test");
        res.setDesc("Make sure that the expected minor version number is returned.");
        Properties props = ExpectedResults.getExpectedProperties();
        String minor = String.valueOf(ctx.getMinorVersion());
        if(minor.equals(props.getProperty("expected.version.minor"))) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Minor Version: "+minor+". Expected: "+props.getProperty("expected.version.minor"));
        }
        return res;
    }



    protected TestResult checkContextServerInfo(PortletContext ctx) {
        TestResult res = new TestResult();
        res.setName("Server Info Test");
        res.setDesc("Make sure that the expected server info is returned.");
        Properties props = ExpectedResults.getExpectedProperties();
        if(ctx.getServerInfo().equals(props.getProperty("expected.serverInfo"))) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Server info: "+ctx.getServerInfo()+". Expected: "+props.getProperty("expected.serverInfo"));
        }
        return res;
    }

    protected TestResult checkPortalInfo(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Portal Info Test");
        res.setDesc("Make sure that the expected portal info is returned.");
        Properties props = ExpectedResults.getExpectedProperties();
        if(req.getPortalContext().getPortalInfo().equals(props.getProperty("expected.portalInfo"))) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Portal info: "+req.getPortalContext().getPortalInfo()+". Expected: "+props.getProperty("expected.portalInfo"));
        }
        return res;
    }

    /**
     * Test to ensure that the basic modes are supported.
     * @todo Enhance to check for custom modes.
     * @param req
     * @return
     */
    protected TestResult checkSupportedModes(PortletRequest req)  {
        TestResult res = new TestResult();
        res.setName("Supported Modes Test");
        res.setDesc("Make sure that the expected modes are returned.");

        boolean hasView = false;
        boolean hasEdit = false;
        boolean hasHelp = false;

        Enumeration enumerator= req.getPortalContext().getSupportedPortletModes();
        while(enumerator.hasMoreElements()) {
            PortletMode mode = (PortletMode)enumerator.nextElement();
            if(mode.equals(PortletMode.VIEW)) {
                hasView  = true;
            }
            else if(mode.equals(PortletMode.EDIT)) {
                hasEdit  = true;
            }
            else if(mode.equals(PortletMode.HELP)) {
                hasHelp  = true;
            }
        }

        if(hasView && hasEdit &&  hasHelp) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            StringBuffer sb = new StringBuffer();
            if(!hasView) {
                sb.append("'View' mode not found. ");
            }
            if(!hasEdit) {
                sb.append("'Edit' mode not found. ");
            }
            if(!hasHelp) {
                sb.append("'Help' mode not found. ");
            }
        }
        return res;
    }

    protected TestResult checkSupportedWindowSates(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Supported Window States Test");
        res.setDesc("Make sure that the expected states are returned.");

        boolean hasMin = false;
        boolean hasMax = false;
        boolean hasNor = false;

        Enumeration enumerator= req.getPortalContext().getSupportedWindowStates();
        while(enumerator.hasMoreElements()) {
            WindowState mode = (WindowState)enumerator.nextElement();
            if(mode.equals(WindowState.MINIMIZED)) {
                hasMin  = true;
            }
            else if(mode.equals(WindowState.MAXIMIZED)) {
                hasMax  = true;
            }
            else if(mode.equals(WindowState.NORMAL)) {
                hasNor  = true;
            }
        }

        if(hasMin && hasMax &&  hasNor) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            StringBuffer sb = new StringBuffer();
            if(!hasMin) {
                sb.append("'Minimized' state not found. ");
            }
            if(!hasMax) {
                sb.append("'Maximized' state not found. ");
            }
            if(!hasNor) {
                sb.append("'Normal' state not found. ");
            }
        }
        return res;
    }

}
