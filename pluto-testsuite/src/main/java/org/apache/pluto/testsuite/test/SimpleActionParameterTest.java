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

import org.apache.pluto.testsuite.ActionTest;
import org.apache.pluto.testsuite.TestResult;
import org.apache.pluto.testsuite.TestUtils;

import java.util.Enumeration;
import java.util.Map;

import javax.portlet.PortletRequest;

/**
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class SimpleActionParameterTest extends AbstractReflectivePortletTest
implements ActionTest {
	
	/** Parameter key encoded in the action URL. */
    public static final String KEY = "org.apache.pluto.testsuite.PARAM_TEST_KEY";
    
    /** Parameter value encoded in the action URL. */
    public static final String VALUE = "org.apache.pluto.testsuite.PARAM_TEST_VALUE";
    
    
    // Test Methods ------------------------------------------------------------
    
    protected TestResult checkGetActionParameterInActionURL(PortletRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Ensure parameters encoded in action URL are "
        		+ "available in the action request.");

        String value = request.getParameter(KEY);
        if (value != null && value.equals(VALUE)) {
        	result.setReturnCode(TestResult.PASSED);
        } else {
        	TestUtils.failOnAssertion("actionParameter", value, VALUE, result);
        }
        return result;
    }

    protected TestResult checkGetActionParamerMap(PortletRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Ensure parameters encoded in action URL are "
        		+ "available in the action request parameter map.");
        
        Map parameterMap = request.getParameterMap();
        String[] values = (String[]) parameterMap.get(KEY);
        if (values != null && values.length == 1 && VALUE.equals(values[0])) {
        	result.setReturnCode(TestResult.PASSED);
        } else if (values == null) {
        	TestUtils.failOnAssertion("action parameter values",
        	                          values,
        	                          new String[] { VALUE },
        	                          result);
        } else if (values.length != 1) {
        	TestUtils.failOnAssertion("length of action parameter values",
        	                          String.valueOf(values.length),
        	                          String.valueOf(1),
        	                          result);
        } else {
        	TestUtils.failOnAssertion("action parameter values",
        	                          values,
        	                          new String[] { VALUE },
        	                          result);
        }
        return result;
    }
    
    /*
     * TODO:
     *
    protected TestResult checkGetActionParameterMap_2(PortletRequest request) {
    	TestResult result = new TestResult();
    	result.setDescription("Ensure parameters encoded in action URL are "
    			+ "available in the action request parameter map.");
    	
    	Map parameterMap = request.getParameterMap();
    	String[] values = (String[]) parameterMap.get(KEY + "_2");
    	
    	
    	
    	if (values != null) {
    		System.err.println("\n\nLog parameter values...\n");
    		for (int i = 0; i < values.length; i++) {
    			System.err.println("values[" + i + "] = " + values[i]);
    		}
    	}
    	
    	if (values != null && values.length == 2
    			&& "FIRST VALUE".equals(values[0])
    			&& "SECOND VALUE".equals(values[1])) {
    		result.setReturnCode(TestResult.PASSED);
    	} else {
    		TestUtils.failOnAssertion("action parameter values",
    		                          values,
    		                          new String[] { "FIRST VALUE", "SECOND VALUE" },
    		                          result);
    	}
    	return result;
    }
    */
    
    protected TestResult checkParameterNames(PortletRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Ensure parameters encoded in action URL "
        		+ "exists in the parameter name enumeration.");

        boolean nameFound = false;
        for (Enumeration en = request.getParameterNames();
        		!nameFound && en.hasMoreElements(); ) {
        	String name = (String) en.nextElement();
        	if (KEY.equals(name)) {
        		nameFound = true;
        	}
        }
        
        if (nameFound) {
        	result.setReturnCode(TestResult.PASSED);
        } else {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResultMessage("Parameter name " + KEY
        			+ " not found in parameter name enumeration.");
        }
        return result;
    }
    
}
