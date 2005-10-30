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
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public abstract class AbstractReflectivePortletTest implements PortletTest {
	
	/** Internal logger. */
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
     * Invoke text methods using java reflection. All 'check*' methods are
     * invoked and test results are saved into <code>TestResults</code> object. 
     */
    public TestResults doTest(PortletConfig config,
                              PortletContext context,
                              PortletRequest request,
                              PortletResponse response) {
        TestResults results = new TestResults(getTestSuiteName());
        Class klass = getClass();
        Method[] methods = klass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().startsWith("check")) {
            	if (LOG.isDebugEnabled()) {
            		LOG.debug("Invoking test method: " + methods[i].getName());
            	}
                try {
                    results.add(invoke(methods[i],
                                       config,
                                       context,
                                       request,
                                       response));
                } catch (Exception ex) {
                	LOG.error("Failed invoking " + methods[i].getName(), ex);
                    TestResult result = new TestResult();
                    result.setName(methods[i].getName());
                    result.setDesc("Unknown");
                    result.setReturnCode(TestResult.FAILED);
                    result.setResults(ex.getMessage());
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
    
    private TestResult invoke(Method method,
                              PortletConfig config,
                              PortletContext context,
                              PortletRequest request,
                              PortletResponse response)
    throws IllegalAccessException, InvocationTargetException {

        Class[] paramTypes = method.getParameterTypes();
        Object[] paramValues = new Object[paramTypes.length];

        for (int i = 0; i < paramTypes.length; i++) {
            if (paramTypes[i].equals(PortletContext.class)) {
                paramValues[i] = context;
            }
            if (paramTypes[i].equals(PortletRequest.class)) {
                paramValues[i] = request;
            }
            if (paramTypes[i].equals(PortletResponse.class)) {
                paramValues[i] = response;
            }
            if (paramTypes[i].equals(PortletSession.class)) {
                paramValues[i] = request.getPortletSession();
            }
            if (paramTypes[i].equals(PortletConfig.class)) {
                paramValues[i] = config;
            }
        }
        TestResult result = (TestResult) method.invoke(this, paramValues);
        return result;
    }

}
