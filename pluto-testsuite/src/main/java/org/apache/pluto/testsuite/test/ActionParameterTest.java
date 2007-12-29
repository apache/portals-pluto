/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
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
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;

import org.apache.pluto.testsuite.TestResult;
import org.apache.pluto.testsuite.TestUtils;
import org.apache.pluto.testsuite.annotations.DefaultTestPhase;

/**
 */
@DefaultTestPhase(PortletRequest.ACTION_PHASE)
public class ActionParameterTest extends AbstractReflectivePortletTest {

	/** Parameter key encoded in the action URL. */
    public static final String KEY = "org.apache.pluto.testsuite.PARAM_ACTION_KEY";

    /** Parameter value encoded in the action URL. */
    public static final String VALUE = "org.apache.pluto.testsuite.ACTION_VALUE";


    // Test Methods ------------------------------------------------------------

    protected TestResult checkGetActionParameter(ActionRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Ensure parameters encoded in action URL are "
        		+ "available in the action request.");

        String value = request.getParameter(KEY);
        if (value != null && value.equals(VALUE)) {
        	result.setReturnCode(TestResult.PASSED);
        } else {
        	TestUtils.failOnAssertion("parameter", value, VALUE, result);
        }
        return result;
    }

    protected TestResult checkGetActionParamerMap(ActionRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Ensure parameters encoded in action URL are "
        		+ "available in the action request parameter map.");

        Map<String, String[]> parameterMap = request.getParameterMap();
        String[] values = parameterMap.get(KEY);
        if (values != null && values.length == 1 && VALUE.equals(values[0])) {
        	result.setReturnCode(TestResult.PASSED);
        } else {
        	TestUtils.failOnAssertion("parameter values",
        			values, new String[] { VALUE }, result);
        }
        return result;
    }

    protected TestResult checkParameterNames(ActionRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Ensure parameters encoded in action URL "
        		+ "exists in the parameter name enumeration.");

        boolean hasParameterName = false;
        for (Enumeration<String> en = request.getParameterNames();
        		!hasParameterName && en.hasMoreElements(); ) {
        	String name = en.nextElement();
        	if (KEY.equals(name)) {
        		hasParameterName = true;
        	}
        }

        if (hasParameterName) {
        	result.setReturnCode(TestResult.PASSED);
        } else {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResultMessage("Parameter name " + KEY
        			+ " not found in parameter name enumeration.");
        }
        return result;
    }

}
