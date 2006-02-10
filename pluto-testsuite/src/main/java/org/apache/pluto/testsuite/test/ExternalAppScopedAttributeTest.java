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

import org.apache.pluto.testsuite.TestResult;

import javax.portlet.PortletSession;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public class ExternalAppScopedAttributeTest extends AbstractReflectivePortletTest {

    public static final String INT_KEY = "org.apache.pluto.testsuite.INTERNALLY_SET_APP_SCOPED_SESSION_TEST_KEY";
    public static final String EXT_KEY = "org.apache.pluto.testsuite.EXTERNALLY_SET_APP_SCOPED_SESSION_TEST_KEY";
    public static final String VALUE = "Should be visible to all Portlets and Web Resources.";

    protected TestResult checkSetHereSeenElsewhere(PortletSession session) {
        TestResult res = new TestResult();
        res.setName("Session Visibility Test");
        res.setDesc("Ensure application scoped attributes set here can be seen elsewhere.");
        res.setReturnCode(TestResult.WARNING);
        res.setResults("Click the provided link to validate test.");

        session.setAttribute(INT_KEY, VALUE, PortletSession.APPLICATION_SCOPE);
        return res;
    }

    protected TestResult checkSetElsewhereSeenHere(PortletSession session) {
        TestResult res = new TestResult();
        res.setName("Session Visibility Test");
        res.setDesc("Ensure application scoped attributes set elsewhere can be seen here.");

        Object val = session.getAttribute(EXT_KEY, PortletSession.APPLICATION_SCOPE);
        if(VALUE.equals(val)) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.WARNING);
            res.setResults("This test will not pass until you have opened the external resource using the link provided below.");
        }
        return res;
    }
}
