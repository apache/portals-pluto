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
import java.io.InputStream;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Iterator;
import java.util.HashMap;

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
import org.apache.pluto.portalImpl.portlet.test.ContextInitParameterTest;

public class TestPortlet extends GenericPortlet {

    private String portletName;

    private List configs;
    private Map tests;

    public void init() throws PortletException {
        portletName = getInitParameter("display-name");
        if(portletName==null) {
            portletName = "Test Portlet";
        }

        String configFile = getInitParameter("config");
        if(configFile==null) {
            configFile = "/WEB-INF/testsuite-config.xml";
        }

        InputStream in = getPortletContext().getResourceAsStream(configFile);
        if( in !=null ) {
            TestConfigFactory fact = new TestConfigFactory();
            try {
                configs = fact.createTests(in);
                tests = new HashMap();
                Iterator it = configs.iterator();
                int i = 0;
                while(it.hasNext()) {
                    TestConfig config = (TestConfig)it.next();
                    String name=  config.getTestClassName();
                    if(name != null) {
                        Class cl = Class.forName(config.getTestClassName());
                        PortletTest test = (PortletTest)cl.newInstance();
                        test.init(config.getInitParameters());
                        tests.put(String.valueOf(i++), test);
                    }
                    else {
                        i++;
                    }

                }
            }
            catch (Throwable t) {
                throw new PortletException("Unable to read configuration", t);
            }
        }
        else {
            throw new IllegalStateException("Configuration File Not Found");
        }
    }


    public void processAction (ActionRequest request,
                               ActionResponse response)
    throws PortletException, java.io.IOException {

        String testId = getTestId(request);
        PortletTest test = (PortletTest)tests.get(testId);

        if(test!=null && test instanceof ActionTest) {
            TestResults results = test.doTest(getPortletConfig(),
                                              getPortletContext(),
                                              request, response);
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

        TestConfig config = null;
        if(testId != null) {
            config = (TestConfig)configs.get(Integer.parseInt(testId));
        }

        PortletTest test = (PortletTest)tests.get(testId);
        response.setTitle(portletName);

        PortletMode mode = request.getPortletMode();
        WindowState state = request.getWindowState();
        if (!state.equals(WindowState.MINIMIZED) && PortletMode.VIEW.equals(mode)) {
        	response.setContentType("text/html");

            if(test != null && !(test instanceof ActionTest) ) {
                TestResults results = test.doTest(getPortletConfig(),
                                                  getPortletContext(),
                                                  request, response);
                request.setAttribute("results", results);
            }
            else if(test != null) {
                PortletSession session = request.getPortletSession();
                TestResults results = (TestResults)session.getAttribute(test.getClass().getName());
                request.setAttribute("results", results);
            }

            if(testId == null) {
                request.setAttribute("tests", configs);
            }

            PortletContext context = getPortletContext();
            PortletRequestDispatcher rd = null;
            if(config != null) {
                rd = context.getRequestDispatcher(config.getDisplayURI());
            }
            else {
                rd = context.getRequestDispatcher("/jsp/introduction.jsp");
            }
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
        String testId =   req.getParameter("testId");
        String previous = req.getParameter("previousTestId");
        String next     = req.getParameter("nextTestId");

        if((testId == null || testId.trim().length()==0)
           && next == null && previous == null && tests.size() > 0) {
            return null;
        }
        // Retrieve the test which is next to the previous
        else if(testId == null && previous !=null) {
            int pId = Integer.parseInt(previous);
            if(pId >= configs.size()-1) {
                testId = "0";
            }
            else {
                testId = String.valueOf(pId+1);
            }
        }
        // Retrieve the test which is previous to the next
        else if(testId == null && next !=null) {
            int nId = Integer.parseInt(next);
            if(nId <= 0) {
                testId = String.valueOf(configs.size()-1);
            }
            else {
                testId = String.valueOf(nId - 1);
            }
        }

        return testId;
    }
}
