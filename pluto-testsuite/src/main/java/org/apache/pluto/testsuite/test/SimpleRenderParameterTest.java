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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

/**
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class SimpleRenderParameterTest extends AbstractReflectivePortletTest {

    public static final String KEY = "org.apache.pluto.testsuite.PARAM_TEST_KEY";
    public static final String VALUE = "org.apache.pluto.testsuite.PARAM_TEST_VALUE";

    private static final String IKEY = "org.apache.pluto.testsuite.PARAM_TEST_KEY_I";
    
    // Unlike other tests, we DON'T want to include anything but the test id.
    public Map getRenderParameters(PortletRequest req) {
        Map map = new HashMap();
        map.put(IKEY, new String[] {VALUE});
        return map;
    }
    
    
    // Test Methods ------------------------------------------------------------
    
    protected TestResult checkActionParametersNotHere(PortletRequest req) {
        TestResult result = new TestResult();
        result.setDescription("Ensure that parameters sent through "
        		+ "the action query stream have NOT made it.");

        String val = req.getParameter(KEY);
        if (val != null) {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Retrieved action parameter ("+KEY+"="+VALUE+" inappropriately");
        } else {
        	result.setReturnCode(TestResult.PASSED);
        }
        return result;
    }


    protected TestResult checkInternalRenderParameter(PortletRequest req) {
        TestResult result = new TestResult();
        result.setDescription("Validate the appropriate render parameters.");
        String val = req.getParameter(IKEY);
        if (val == null || !VALUE.equals(val)) {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Expected : "+VALUE+" retrieved "+val);
        } else {
        	result.setReturnCode(TestResult.PASSED);
        }
        return result;
    }

    protected TestResult checkInternalRenderParameterValues(PortletRequest req) {
        TestResult result = new TestResult();
        result.setDescription("Validate the appropriate render parameter values.");

        String[] val = req.getParameterValues(IKEY);
        if(val == null || val.length<1 || !VALUE.equals(val[0])) {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Expected : "+VALUE+" retrieved "+val);
        }
        else {
        	result.setReturnCode(TestResult.PASSED);
        }
        return result;
    }

    protected TestResult checkParameterMap(PortletRequest req) {
        TestResult result = new TestResult();
        result.setDescription("Check the contents of the render parameter map.");

        Map map = req.getParameterMap();
        String[] val = (String[])map.get(IKEY);
        if(map.containsKey(KEY) || val==null || val.length < 1 || !VALUE.equals(val[0])) {
        	result.setReturnCode(TestResult.FAILED);
            if(map.containsKey(KEY)) {
            	result.setResults("Found Action Parameter: "+KEY+"="+map.get(KEY));
            }
            if(!map.containsKey(IKEY) || val.length <1 || !VALUE.equals(val[0])) {
            	result.setResults("Render Parameter: "+IKEY+"="+(val.length<1?"null":val[0])+" does not contain the expected value: "+VALUE);
            }
            return result;
        }
        result.setReturnCode(TestResult.PASSED);
        return result;
    }

    protected TestResult checkParameterNames(PortletRequest req) {
        TestResult result = new TestResult();
        result.setDescription("Enumerate through all expected names.");

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
        	result.setReturnCode(TestResult.FAILED);
            StringBuffer sb = new StringBuffer();
            if(!hasInternal) {
                sb.append("Render Parameter Not Found. ");
            }
            if(!hasExternal) {
                sb.append("Action Parameter Found. ");
            }
            result.setResults(sb.toString());
        }
        else {
        	result.setReturnCode(TestResult.PASSED);
        }
        return result;
    }
}
