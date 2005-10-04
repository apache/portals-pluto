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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public class SimpleRenderParameterTest extends AbstractReflectivePortletTest {

    public static final String KEY = "org.apache.pluto.testsuite.PARAM_TEST_KEY";
    public static final String VALUE = "org.apache.pluto.testsuite.PARAM_TEST_VALUE";

    private static final String IKEY = "org.apache.pluto.testsuite.PARAM_TEST_KEY_I";

    public String getTestSuiteName() {
        return "Simple Parameter Test";
    }

    // Unlike other tests, we DON'T want to include anything but the test id.
    public Map getRenderParameters(PortletRequest req) {
        Map map = new HashMap();
        map.put(IKEY, new String[] {VALUE});
        return map;
    }

    protected TestResult checkActionParametersNotHere(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("No Action Parameters Test");
        res.setDesc("Ensure that parameters sent through the action query stream have NOT made it.");

        String val = req.getParameter(KEY);
        if(val != null) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Retrieved action parameter ("+KEY+"="+VALUE+" inappropriately");
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }
        return res;
    }


    protected TestResult checkInternalRenderParameter(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Render Parameter Test");
        res.setDesc("Validate the appropriate render parameters");

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

    protected TestResult checkInternalRenderParameterValues(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Render Parameter Values Test");
        res.setDesc("Validate the appropriate render parameter values");

        String[] val = req.getParameterValues(IKEY);
        if(val == null || val.length<1 || !VALUE.equals(val[0])) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Expected : "+VALUE+" retrieved "+val);
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }
        return res;
    }

    protected TestResult checkParameterMap(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Render Parameter Map Test");
        res.setName("Check the contents of the render parameter map");

        Map map = req.getParameterMap();
        String[] val = (String[])map.get(IKEY);
        if(map.containsKey(KEY) || val==null || val.length < 1 || !VALUE.equals(val[0])) {
            res.setReturnCode(TestResult.FAILED);
            if(map.containsKey(KEY)) {
                res.setResults("Found Action Parameter: "+KEY+"="+map.get(KEY));
            }
            if(!map.containsKey(IKEY) || val.length <1 || !VALUE.equals(val[0])) {
                res.setResults("Render Parameter: "+IKEY+"="+(val.length<1?"null":val[0])+" does not contain the expected value: "+VALUE);
            }
            return res;
        }
        res.setReturnCode(TestResult.PASSED);
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
        if(!hasInternal || hasExternal) {
            res.setReturnCode(TestResult.FAILED);
            StringBuffer sb = new StringBuffer();
            if(!hasInternal) {
                sb.append("Render Parameter Not Found. ");
            }
            if(!hasExternal) {
                sb.append("Action Parameter Found. ");
            }
            res.setResults(sb.toString());
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }
        return res;
    }
}
