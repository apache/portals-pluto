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
package org.apache.pluto.portalImpl.portlet.test;

import java.util.Map;
import java.util.Properties;

import javax.portlet.PortletContext;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import org.apache.pluto.testsuite.ExpectedResults;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public class SecurityMappingTest extends AbstractReflectivePortletTest {

    public String getTestSuiteName() {
        return "Security Mapping Tests";
    }

    public Map doPrerequisiteAction(PortletContext context, ActionRequest req,
                                    ActionResponse res) {
        return new java.util.HashMap();
    }

    protected TestResult checkIsUserInMappedRole(PortletRequest req) {
        TestResult res = isUserLoggedIn(req);
        res.setName("User In Mapped Role Test");
        res.setDesc("Test if user is in mapped role");
        if(TestResult.WARNING.equals(res.getReturnCode())) {
            return res;
        }

        Properties props = ExpectedResults.getExpectedProperties();
        String role = props.getProperty("expected.security.role.mapped");

        if(req.isUserInRole(role)) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.WARNING);
            res.setReturnCode("User is not in the expected '"+role+"' role.  This may be due to misconfiuration.");
        }

        return res;
    }

    protected TestResult checkIsUserInUnmappedRole(PortletRequest req) {
        TestResult res = isUserLoggedIn(req);
        res.setName("User In Unmapped Role Test");
        res.setDesc("Test if user is in unmapped role");
        if(TestResult.WARNING.equals(res.getReturnCode())) {
            return res;
        }

        Properties props = ExpectedResults.getExpectedProperties();
        String role = props.getProperty("expected.security.role");

        if(req.isUserInRole(role)) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.WARNING);
            res.setReturnCode("User is not in the expected '"+role+"' role.  This may be due to misconfiuration.");
        }

        return res;
    }

    protected TestResult checkIsUserIndUndeclaredRole(PortletRequest req) {
        TestResult res = isUserLoggedIn(req);
        res.setName("User In Undeclared Role Test");
        res.setDesc("Test if user is in undeclared role");
        if(TestResult.WARNING.equals(res.getReturnCode())) {
            return res;
        }

        if(!req.isUserInRole("fakeTestRoleFooBar")) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setReturnCode("User is in the fake role named 'fakeTestRoleFooBar'");
        }

        return res;
    }


    private TestResult isUserLoggedIn(PortletRequest req) {
        if (req.getRemoteUser()==null) {
            TestResult res = new TestResult();
            res.setReturnCode(TestResult.WARNING);
            res.setResults("User is not logged in.");
            return res;
        }
        return new TestResult();
    }
}
