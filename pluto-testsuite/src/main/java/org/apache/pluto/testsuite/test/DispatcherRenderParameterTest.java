/*
 * Copyright 2004 The Apache Software Foundation
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
import org.apache.pluto.testsuite.TestResult;

import java.io.IOException;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @version 1.0
 * @since Mar 9, 2005
 */
public class DispatcherRenderParameterTest 
extends AbstractReflectivePortletTest {
	
	/** Internal logger. */
	private static final Log LOG = LogFactory.getLog(
			DispatcherRenderParameterTest.class);
	
	// Static Final Constants --------------------------------------------------
	
	private static final String KEY_TARGET = "target";
	
	private static final String TARGET_PARAMS = "testParams";
	private static final String TARGET_SAME_NAME_PARAM = "testSameNameParam";
	private static final String TARGET_INVALID_PARAMS = "testInvalidParams";
	
    private static final String KEY_A = "includedTestKeyA";
    private static final String VALUE_A = "includedTestValueA";
    
    private static final String KEY_B = "includedTestKeyB";
    private static final String VALUE_B = "includedTestValueB";
    
    private static final String KEY_C = "includedTestKeyC";
    private static final String VALUE_C1 = "valueOneOfKeyC";
    private static final String VALUE_C2 = "valueTwoOfKeyC";
    private static final String VALUE_C3 = "valueThreeOfKeyC";
    
    public static final String RESULT_KEY =
    	DispatcherRenderParameterTest.class.getName() + ".RESULT_KEY";
    
    
    /**
     * No-arg constructor that does nothing.
     */
    public DispatcherRenderParameterTest() {
    	// Do nothing.
    }

    public String getTestSuiteName() {
        return "Dispatcher Render Parameter Test";
    }
    
    
    // Protected Test/Check Methods --------------------------------------------
    
    protected TestResult checkIncludedParameters(PortletContext context,
                                                 PortletRequest request,
                                                 PortletResponse response)
    throws IOException, PortletException {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("/tests/include?")
    			.append(KEY_TARGET).append("=").append(TARGET_PARAMS)
    			.append("&").append(KEY_A).append("=").append(VALUE_A)
    			.append("&").append(KEY_B).append("=").append(VALUE_B);
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("Dispatching to: " + buffer.toString());
    	}
        PortletRequestDispatcher dispatcher = context.getRequestDispatcher(
        		buffer.toString());
        dispatcher.include((RenderRequest) request, (RenderResponse) response);

        TestResult result = new TestResult();
        result.setName("Dispatcher Render Parameter Test");
        result.setDesc("Ensure query parameters added "
        		+ "during dispatching are attached to the request.");
        if (request.getAttribute(RESULT_KEY) != null
        		&& Boolean.TRUE.equals(request.getAttribute(RESULT_KEY))) {
            result.setReturnCode(TestResult.PASSED);
        } else {
            result.setReturnCode(TestResult.FAILED);
            result.setResults("Unable to find expected parameter");
        }
        request.removeAttribute(RESULT_KEY);
        return result;
    }
    
    
    protected TestResult checkSameNameParameter(PortletContext context,
                                                PortletRequest request,
                                                PortletResponse response)
    throws IOException, PortletException {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("/tests/include?")
    			.append(KEY_TARGET).append("=").append(TARGET_SAME_NAME_PARAM)
    			.append("&").append(KEY_C).append("=").append(VALUE_C1)
    			.append("&").append(KEY_C).append("=").append(VALUE_C2)
    			.append("&").append(KEY_C).append("=").append(VALUE_C3);
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("Dispatching to: " + buffer.toString());
    	}
    	PortletRequestDispatcher dispatcher = context.getRequestDispatcher(
    			buffer.toString());
    	dispatcher.include((RenderRequest) request, (RenderResponse) response);
    	
    	TestResult result = new TestResult();
    	result.setName("Dispatcher Render Parameter Test");
    	result.setDesc("Ensure query parameters with the same name added "
    			+ "during dispatching are attached to the request.");
    	if (request.getAttribute(RESULT_KEY) != null
    			&& Boolean.TRUE.equals(request.getAttribute(RESULT_KEY))) {
    		result.setReturnCode(TestResult.PASSED);
    	} else {
    		result.setReturnCode(TestResult.FAILED);
    		result.setResults("Unable to find expected parameter");
    	}
    	request.removeAttribute(RESULT_KEY);
    	return result;
    }
    
    
    protected TestResult checkInvalidParameters(PortletContext context,
                                                PortletRequest request,
                                                PortletResponse response)
    throws IOException, PortletException {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("/tests/include?")
    			.append(KEY_TARGET).append("=").append(TARGET_INVALID_PARAMS)
    			.append("&").append(KEY_A)
    			.append("&").append(KEY_B).append("=").append(VALUE_B)
    			.append("&").append(KEY_C).append("=");
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("Dispatching to: " + buffer.toString());
    	}
    	PortletRequestDispatcher dispatcher = context.getRequestDispatcher(
    			buffer.toString());
    	dispatcher.include((RenderRequest) request, (RenderResponse) response);
    	
    	TestResult result = new TestResult();
    	result.setName("Dispatcher Render Parameter Test");
    	result.setDesc("Ensure invalid query parameters added "
    			+ "during dispatching are ignored.");
    	if (request.getAttribute(RESULT_KEY) != null
    			&& Boolean.TRUE.equals(request.getAttribute(RESULT_KEY))) {
    		result.setReturnCode(TestResult.PASSED);
    	} else {
    		result.setReturnCode(TestResult.FAILED);
    		result.setResults("Unable to find expected parameter");
    	}
    	request.removeAttribute(RESULT_KEY);
    	return result;
    }
    
    
    // Nested Servlet Class ----------------------------------------------------
    
    /**
     * Nested static servlet class which is the target of dispatching.
     * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
     * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
     */
    public static class TargetServlet extends GenericServlet {

        public TargetServlet() {
        	// Do nothing.
        }
        
        
        // GenericServlet Impl -------------------------------------------------
        
        public void service(ServletRequest request, ServletResponse response)
        throws ServletException, IOException {
        	String target = request.getParameter(KEY_TARGET);
        	if (TARGET_PARAMS.equals(target)) {
        		checkParameters(request);
        	} else if (TARGET_SAME_NAME_PARAM.equals(target)) {
        		checkSameNameParameter(request);
        	} else if (TARGET_INVALID_PARAMS.equals(target)) {
        		checkInvalidParameters(request);
        	}
        }
        
        public String getServletInfo() {
            return "Dispather Render Parameter Include Servlet";
        }
        
        
        // Private Methods -----------------------------------------------------
        
        /**
         * Check that parameters A and B are available in the dispatching
         * request.
         * @param request  the servlet request.
         */
        private void checkParameters(ServletRequest request) {
            String valueA = request.getParameter(KEY_A);
            String valueB = request.getParameter(KEY_B);
            if (VALUE_A.equals(valueA) && VALUE_B.equals(valueB)) {
                request.setAttribute(RESULT_KEY, Boolean.TRUE);
            }
        }
        
        /**
         * Check that parameter C has three values.
         * @param request  the servlet reqeust.
         */
        private void checkSameNameParameter(ServletRequest request) {
        	String[] values = request.getParameterValues(KEY_C);
        	if (values != null && values.length == 3
        			&& VALUE_C1.equals(values[0])
        			&& VALUE_C2.equals(values[1])
        			&& VALUE_C3.equals(values[2])) {
        		request.setAttribute(RESULT_KEY, Boolean.TRUE);
        	}
        }
        
        /**
         * Check that invalid parameter A is ignored, parameter B is attached
         * to the dispatching request with the correct value, and parameter C
         * is attached to the dispatching request with an empty string.
         * @param request  the servlet request.
         */
        private void checkInvalidParameters(ServletRequest request) {
        	String valueA = request.getParameter(KEY_A);
        	String valueB = request.getParameter(KEY_B);
        	String valueC = request.getParameter(KEY_C);
        	if (valueA == null && VALUE_B.equals(valueB) && "".equals(valueC)) {
        		request.setAttribute(RESULT_KEY, Boolean.TRUE);
        	}
        }
        
    }
    
}

