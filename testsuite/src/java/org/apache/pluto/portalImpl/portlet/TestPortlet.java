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
/* 

 */

package org.apache.pluto.portalImpl.portlet;

import javax.portlet.*;
import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;

import org.apache.pluto.portalImpl.portlet.test.SimpleAttributeTest;
import org.apache.pluto.portalImpl.portlet.test.PortletTest;
import org.apache.pluto.portalImpl.portlet.test.TestResults;
import org.apache.pluto.portalImpl.portlet.test.SimpleParameterTest;
import org.apache.pluto.portalImpl.portlet.test.SecurityMappingTest;
import org.apache.pluto.portalImpl.portlet.test.ComplexAttributeTest;
import org.apache.pluto.portalImpl.portlet.test.SimplePreferenceTest;
import org.apache.pluto.portalImpl.portlet.test.ActionTest;
import org.apache.pluto.portalImpl.portlet.test.MiscTest;
import org.apache.pluto.portalImpl.portlet.test.ExternalAppScopedAttributeTest;

public class TestPortlet extends GenericPortlet {

    public static final Map TESTS = new TreeMap();
    public static final ArrayList TEST_IDX;

    static {
        TESTS.put("01_simple_parameter_test", new SimpleParameterTest());
        TESTS.put("02_simple_attribute_test", new SimpleAttributeTest());
        TESTS.put("03_complex_attribute_test", new ComplexAttributeTest());
        TESTS.put("04_ext_app_scoped_attr_test", new ExternalAppScopedAttributeTest());
        TESTS.put("05_simple_preference_test", new SimplePreferenceTest());
        TESTS.put("06_portlet_mode_test", null);
        TESTS.put("07_window_state_test", null);
        TESTS.put("08_security_mapping_test", new SecurityMappingTest());
        TESTS.put("09_misc_test", new MiscTest());

        TEST_IDX = new ArrayList(TESTS.keySet());
    }

    private String portletName;
    public void init() {
        portletName = getPortletContext().getInitParameter("display-name");
        if(portletName==null) {
            portletName = "Test Portlet";
        }
    }


    public void processAction (ActionRequest request,
                               ActionResponse response)
    throws PortletException, java.io.IOException {

        String testId = getTestId(request);
        PortletTest test = (PortletTest)TESTS.get(testId);

        if(test!=null && test instanceof ActionTest) {
            TestResults results = test.doTest(getPortletContext(), request, response);
            request.getPortletSession().setAttribute(test.getClass().getName(), results);
        }
        Map renderParameters = null;

        if(test!=null) {
            renderParameters = renderParameters = test.getRenderParameters(request);
        }

        if(renderParameters==null) {
            renderParameters = new java.util.HashMap();
        }

        renderParameters.put("testId", new String[] {testId});
        response.setRenderParameters(renderParameters);
    }

    public void doDispatch(RenderRequest request,
                           RenderResponse response)
    throws PortletException, IOException {

        String testId = getTestId(request);
        PortletTest test = (PortletTest)TESTS.get(testId);
        response.setTitle(portletName);

        PortletMode mode = request.getPortletMode();
        WindowState state = request.getWindowState();
        if (!state.equals(WindowState.MINIMIZED) && PortletMode.VIEW.equals(mode)) {
        	response.setContentType("text/html");

            if(test != null && !(test instanceof ActionTest) ) {
                TestResults results = test.doTest(getPortletContext(), request, response);
                request.setAttribute("results", results);
            }
            else if(test != null) {
                PortletSession session = request.getPortletSession();
                TestResults results = (TestResults)session.getAttribute(test.getClass().getName());
                request.setAttribute("results", results);
            }

            if("xx_introduction".equals(testId)) {
                request.setAttribute("tests", TEST_IDX);
            }

            PortletContext context = getPortletContext();
            PortletRequestDispatcher rd = context.getRequestDispatcher("/jsp/"+testId.substring(3)+".jsp");
            rd.include(request,response);
        }

        else if(!state.equals(WindowState.MINIMIZED) && PortletMode.EDIT.equals(mode)) {
            PortletContext context = getPortletContext();
            PortletRequestDispatcher rd = context.getRequestDispatcher("/jsp/edit.jsp");
            rd.include(request,response);
        }

        else if(!state.equals(WindowState.MINIMIZED) && PortletMode.HELP.equals(mode)) {
            PortletContext context = getPortletContext();
            PortletRequestDispatcher rd = context.getRequestDispatcher("/jsp/help.jsp");
            rd.include(request,response);
        }
    }

    private String getTestId(PortletRequest req) {
        String testId = req.getParameter("testId");
        String previous = req.getParameter("previousTestId");
        String next     = req.getParameter("nextTestId");

        if(testId == null && next == null &&
           previous == null && TESTS.size() > 0) {
            testId = "xx_introduction";
        }
        // Retrieve the test which is next to the previous
        else if(testId == null && previous !=null) {
            int idx = TEST_IDX.indexOf(previous);
            if(idx >= TEST_IDX.size()-1) {
                testId = (String)TEST_IDX.get(0);
            }
            else {
                testId = (String)TEST_IDX.get(idx+1);
            }
        }
        // Retrieve the test which is previous to the next
        else if(testId == null && next !=null) {
            int idx = TEST_IDX.indexOf(next);
            if(idx <= 0) {
                testId = (String)TEST_IDX.get(TEST_IDX.size()-1);
            }
            else {
                testId = (String)TEST_IDX.get(idx - 1);
            }
        }

        return testId;
    }
}
