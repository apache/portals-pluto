/*
 * Copyright 2004 The Apache Software Foundation
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
package org.apache.pluto.portalImpl.portlet.test;

import java.util.Enumeration;

import javax.portlet.PortletContext;
import javax.portlet.PortletSession;

/**
 * <B>TODO</B>: Document
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 15, 2004
 */
public class ContextInitParameterTest extends AbstractReflectivePortletTest  {
    private static final String TEST_PARAM_NAME = "test-parameter-name";
    private static final String TEST_PARAM_VAL = "test-parameter-val";

    public ContextInitParameterTest() {

    }

    public String getTestSuiteName() {
        return "Context Init Parameter Test";
    }

    protected TestResult checkEnumerationContainsElements(PortletContext ctx) {
        TestResult res = new TestResult();
        res.setName("Get Init Parameter Enumeration Test");
        res.setDesc("Test the initialization parameter enumeration.");

        Enumeration enum = ctx.getInitParameterNames();
        if (enum.hasMoreElements()) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("No init parameters found.");
        }
        return res;
    }

    protected TestResult checkEnumerationContainsNames(PortletContext ctx) {
        TestResult res = new TestResult();
        res.setName("Init Parameter Names in Enumeration Test");
        res.setDesc("Test to make sure that the expected init parameters exist.");

        boolean found = false;
        Enumeration enum = ctx.getInitParameterNames();
        while(enum.hasMoreElements()) {
            String name = (String)enum.nextElement();
            if(TEST_PARAM_NAME.equals(name)) {
                found = true;
            }
        }

        if(found) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Expected init parameter '"+TEST_PARAM_NAME+"' no found.");
        }

        return res;
    }

    protected TestResult checkGetInitParameter(PortletContext context) {
        TestResult res = new TestResult();
        res.setName("Init Parameter Retrieved Test");
        res.setDesc("Test to make sure that init parameters are successfully retrieved.");

        String val = context.getInitParameter(TEST_PARAM_NAME);
        if(TEST_PARAM_VAL.equals(val)) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Expected value not found for key '"+TEST_PARAM_NAME+"'.  Found '"+TEST_PARAM_VAL+"'");
        }
        return res;
    }

    protected TestResult checkGetContextFromSession(PortletSession session) {
        TestResult res = new TestResult();
        res.setName("PortletContext Retrieved From Session Test");
        res.setDesc("Test ensures that the PortletContext can be retrieved from the session.");

        PortletContext ctx = session.getPortletContext();
        if(ctx != null) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Portlet Context is Null");
        }
        return res;
    }
}

