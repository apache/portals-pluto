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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.testsuite.TestConfig;
import org.apache.pluto.testsuite.PortletTest;
import org.apache.pluto.testsuite.TestResult;
import org.apache.pluto.testsuite.TestResults;

import javax.portlet.PortletResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletContext;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;

/**
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public abstract class AbstractReflectivePortletTest implements PortletTest {
	
	/** Logger. */
	private static final Log LOG = LogFactory.getLog(
			AbstractReflectivePortletTest.class);
	
    private Map initParameters = null;
    private TestConfig config = null;
    
    
    // PortletTest Impl --------------------------------------------------------
    
    public void init(TestConfig config) {
        this.config = config;
        this.initParameters = config.getInitParameters();
    }
    
    public Map getRenderParameters(PortletRequest request) {
        return new HashMap();
    }

    public TestConfig getConfig() {
        return config;
    }
    
    /**
     * Returns the test suite name. The test suite name is the portlet test
     * class name without package name prefix.
     * @return the test suite name.
     */
    public String getTestSuiteName() {
    	String className = getClass().getName();
    	int index = className.lastIndexOf(".");
    	if (index >= 0 && index < className.length() - 1) {
    		return className.substring(index + 1);
    	} else {
    		return className;
    	}
    }
    
    /**
     * Invoke test methods using java reflection. All 'check*' methods are
     * invoked and test results are saved into <code>TestResults</code> object.
     * @param config  the portlet config.
     * @param context  the portlet context.
     * @param request  the portlet request.
     * @param response  the portlet response.
     * @return the test results including several TestResult instances. 
     */
    public TestResults doTest(PortletConfig config,
                              PortletContext context,
                              PortletRequest request,
                              PortletResponse response) {
        TestResults results = new TestResults(getTestSuiteName());
        Method[] methods = getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().startsWith("check")) {
            	debugWithName("Invoking test method: " + methods[i].getName());
                try {
                	TestResult result = invoke(methods[i],
                			config, context, request, response);
                	if (result.getName() == null) {
                		result.setName(methods[i].getName());
                	}
                	results.add(result);
                	debugWithName("Test Result: " + result);
                } catch (Throwable th) {
                	String message = "Error invoking " + methods[i].getName()
                			+ " (" + th.getClass().getName() + "): "
                			+ th.getMessage();
                	errorWithName(message, th);
                    TestResult result = new TestResult();
                    result.setName(methods[i].getName());
                    result.setReturnCode(TestResult.FAILED);
                    result.setResultMessage(message);
                    results.add(result);
                }
            }
        }
        return results;
    }
    
    
    // Protected Methods -------------------------------------------------------
    
    protected Map getInitParameters() {
        return initParameters;
    }

    // Private Methods ---------------------------------------------------------
    
    private void debugWithName(String message) {
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("Test [" + getClass().getName() + "]: " + message);
    	}
    }
    
    private void errorWithName(String message, Throwable cause) {
    	if (LOG.isErrorEnabled()) {
    		LOG.error("Test [" + getClass().getName() + "]: " + message, cause);
    	}
    }
    
    /**
     * Invokes the test method ('<code>check*</code>') by preparing method
     * parameters. A test method may accept the following types of parameters:
     * <ul>
     *   <li><code>javax.portlet.PortletConfig</code></li>
     *   <li><code>javax.portlet.PortletContext</code></li>
     *   <li><code>javax.portlet.PortletRequest</code></li>
     *   <li><code>javax.portlet.PortletResponse</code></li>
     *   <li><code>javax.portlet.PortletSession</code></li>
     * </ul>
     */
    private TestResult invoke(Method method,
                              PortletConfig config,
                              PortletContext context,
                              PortletRequest request,
                              PortletResponse response)
    throws IllegalAccessException, InvocationTargetException {

        Class[] paramTypes = method.getParameterTypes();
        Object[] paramValues = new Object[paramTypes.length];

        for (int i = 0; i < paramTypes.length; i++) {
            if (paramTypes[i].equals(PortletConfig.class)) {
                paramValues[i] = config;
            } else if (paramTypes[i].equals(PortletContext.class)) {
                paramValues[i] = context;
            } else if (paramTypes[i].equals(PortletRequest.class)) {
                paramValues[i] = request;
            } else if (paramTypes[i].equals(PortletResponse.class)) {
                paramValues[i] = response;
            } else if (paramTypes[i].equals(PortletSession.class)) {
                paramValues[i] = request.getPortletSession();
            }
        }
        TestResult result = (TestResult) method.invoke(this, paramValues);
        return result;
    }
    
    
    // Object Methods ----------------------------------------------------------
    
    /**
     * Override of toString() that prints out names and values of variables.
     * @see java.lang.Object#toString()
     */
    public String toString(){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append(getClass().getName());
    	buffer.append("[initParameters=").append(initParameters);
    	buffer.append(";config=").append(config).append("]");    	
    	return buffer.toString();
    }
}
