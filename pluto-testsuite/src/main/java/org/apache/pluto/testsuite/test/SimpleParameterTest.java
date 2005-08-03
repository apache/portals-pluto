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
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public class SimpleParameterTest extends AbstractReflectivePortletTest {
    public static final String KEY = "org.apache.pluto.testsuite.PARAM_TEST_KEY";
    public static final String VALUE = "org.apache.pluto.testsuite.PARAM_TEST_VALUE";

    private static final String IKEY = "org.apache.pluto.testsuite.PARAM_TEST_KEY_I";

    public String getTestSuiteName() {
        return "Simple Parameter Test";
    }

    public Map getRenderParameters(PortletRequest req) {
        Map map = new HashMap(req.getParameterMap());
        map.put(IKEY, new String[] {VALUE});
        return map;
    }

    protected TestResult checkSentParameters(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Sent Parameter Test");
        res.setDesc("Ensure that parameters sent through the action query stream have made it all the way through");

        String val = req.getParameter(KEY);
        if(val == null || !VALUE.equals(val)) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Expected : "+VALUE+" retrieved "+val);
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }
        return res;
    }


    protected TestResult checkInternalRenderParameters(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Render Parameters Test");
        res.setDesc("Enumerate through all render parameters sent in the action");

        String val = req.getParameter(IKEY);
        if(val == null || !VALUE.equals(val)) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Expected : "+VALUE+" retrieved "+val);
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }
        return res;
    }

    protected TestResult checkParameterNames(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Test Parameter Names Enumeration.");
        res.setDesc("Enumerate through all expected names.");

        boolean hasExternal = false;
        boolean hasInternal = false;
        Enumeration enumerator= req.getParameterNames();
        while(enumerator.hasMoreElements()) {
            String val = enumerator.nextElement().toString();
            if(KEY.equals(val)) {
                hasExternal = true;
            }
            if(IKEY.equals(val)) {
                hasInternal = true;
            }
        }
        if(!hasInternal || !hasExternal) {
            res.setReturnCode(TestResult.FAILED);
            StringBuffer sb = new StringBuffer();
            if(!hasInternal) {
                sb.append("Internal Parameter Not Found. ");
            }
            if(!hasExternal) {
                sb.append("External Parameter Not Found. ");
            }
            res.setResults(sb.toString());
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }
        return res;
    }
}
