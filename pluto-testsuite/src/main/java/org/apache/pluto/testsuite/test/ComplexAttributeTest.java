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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletSession;
import java.util.Map;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public class ComplexAttributeTest extends AbstractReflectivePortletTest {

    private static final String BOGUS_KEY = "org.apache.pluto.testsuite.BOGUS_KEY";
    private static final String KEY = "org.apache.pluto.testsuite.KEY";
    private static final String VAL = "VALUE";


    public Map doPrerequisiteAction(PortletContext context, ActionRequest req,
                                    ActionResponse res) {
        return new java.util.HashMap();
    }

    protected TestResult checkGetEmptyApplicationScopedAttribute(PortletSession session) {
        TestResult res = new TestResult();
        res.setName("Get Empty Application Scoped Attribute Test");
        res.setDesc("Retrieve an attribute that has not been set in the session's application scope and ensure it's value is null.");

        Object val = session.getAttribute(BOGUS_KEY, PortletSession.APPLICATION_SCOPE);
        if(val == null) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Retrieved attribute value '"+val+"'; expected null.");
        }
        return res;
    }

    protected TestResult checkSetApplicationScopedAttribute(PortletSession session) {
        TestResult res = new TestResult();
        res.setName("Set Application Scoped Attribute Test");
        res.setDesc("Set an application scoped session attribute and ensure it's retrievable");

        session.setAttribute(KEY, VAL, PortletSession.APPLICATION_SCOPE);

        Object val = session.getAttribute(KEY, PortletSession.APPLICATION_SCOPE);
        if(VAL.equals(val)) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Retrieved attribute value '"+val+"'; expected '"+VAL+"'");
        }
        return res;
    }

    protected TestResult checkRemoveApplicationScopedAttribute(PortletSession session) {
        TestResult res = new TestResult();
        res.setName("Remove Application Scoped Attribute Test");
        res.setDesc("Remove an application scoped session attribute and ensure it's null.");

        session.setAttribute(KEY, VAL, PortletSession.APPLICATION_SCOPE);
        session.removeAttribute(KEY, PortletSession.APPLICATION_SCOPE);
        Object val = session.getAttribute(KEY, PortletSession.APPLICATION_SCOPE);
        if(null == val) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Retrieved attribute value '"+val+"'; expected null.");
        }
        return res;
    }
}
