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

import java.io.IOException;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * <B>TODO</B>: Document
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Mar 9, 2005
 */
public class DispatcherRenderParameterTest 
    extends AbstractReflectivePortletTest  {

    public static final String KEY_A = "includedTestKey";
    public static final String VAL_A = "includedTestVal";
    public static final String KEY_B = "bTestKey";
    public static final String VAL_B = "bTestVal";
    public static final String RESULT_KEY = "org.apache.pluto.testsuite.RESULTKEY";
    

    public DispatcherRenderParameterTest() {

    }

    public String getTestSuiteName() {
        return "Dispatcher Render Parameter Test";
    }
    
    protected TestResult checkIncludedParameterTest(PortletContext ctx,
                                                    PortletRequest req,
                                                    PortletResponse res)
    throws IOException, PortletException {
        PortletRequestDispatcher disp =
            ctx.getRequestDispatcher("/tests/include?"+KEY_A+"="+VAL_A+"&"+KEY_B+"="+VAL_B);
        
        disp.include((RenderRequest)req, (RenderResponse)res);

        TestResult result = new TestResult();
        result.setName("Dispatcher Render Parameter Test");
        result.setDesc("Ensure query parameters added during dispatching are attached to the request.");
        if(req.getAttribute(RESULT_KEY)!=null && Boolean.TRUE.equals(req.getAttribute(RESULT_KEY))) {
            result.setReturnCode(TestResult.PASSED);
        }
        else {
            result.setReturnCode(TestResult.FAILED);
            result.setResults("Unable to find expected parameter");
        }
        return result;
    }
    

}

