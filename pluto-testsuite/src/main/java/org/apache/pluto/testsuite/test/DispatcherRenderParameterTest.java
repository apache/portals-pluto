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

    public static final String KEY_A = "includedTestKey";
    public static final String VAL_A = "includedTestVal";
    public static final String KEY_B = "bTestKey";
    public static final String VAL_B = "bTestVal";
    public static final String RESULT_KEY =
    	DispatcherRenderParameterTest.class.getName() + ".RESULT_KEY";
    

    public DispatcherRenderParameterTest() {

    }

    public String getTestSuiteName() {
        return "Dispatcher Render Parameter Test";
    }
    
    protected TestResult checkIncludedParameterTest(PortletContext context,
                                                    PortletRequest request,
                                                    PortletResponse response)
    throws IOException, PortletException {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("/tests/include?")
    			.append(KEY_A).append("=").append(VAL_A).append("&")
    			.append(KEY_B).append("=").append(VAL_B);
        PortletRequestDispatcher dispatcher = context.getRequestDispatcher(
        		buffer.toString());
        dispatcher.include((RenderRequest) request, (RenderResponse) response);

        TestResult result = new TestResult();
        result.setName("Dispatcher Render Parameter Test");
        result.setDesc("Ensure query parameters added during dispatching are attached to the request.");
        if (request.getAttribute(RESULT_KEY) != null
        		&& Boolean.TRUE.equals(request.getAttribute(RESULT_KEY))) {
            result.setReturnCode(TestResult.PASSED);
        } else {
            result.setReturnCode(TestResult.FAILED);
            result.setResults("Unable to find expected parameter");
        }
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

        public void service(ServletRequest request, ServletResponse response)
        throws ServletException, IOException {
            String valueA = request.getParameter(KEY_A);
            String valueB = request.getParameter(KEY_B);
            if (VAL_A.equals(valueA) && VAL_B.equals(valueB)) {
                request.setAttribute(RESULT_KEY, Boolean.TRUE);
            }
        }
        
        public String getServletInfo() {
            return "Dispather Render Parameter Include Servlet";
        }
    }
    
}

