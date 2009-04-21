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
package org.apache.pluto.testsuite;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.StateAwareResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Pluto testsuite's test portlet.
 *
 * @see TestConfig
 * @see PortletTest
 * @version 1.0
 */
public class TestPortlet extends GenericPortlet {

    /** Internal logger. */
    private static final Logger LOG = LoggerFactory.getLogger(TestPortlet.class);


    // Private Member Variables ------------------------------------------------

    /** List of test configurations. */
    private List<TestConfig> testConfigs;

    /**
     * Map of test instances: key is an integer ID (as a string), and value is
     * the <code>PortletTest</code> instances.
     */
    private Map<String, PortletTest> tests;


    // GenericPortlet Impl -----------------------------------------------------

    /**
     * Initialize the test portlet. This method reads the testsuite's config
     * files, constructs and initializes all <code>PortletTest</code> instances.
     * @throws PortletException if fail to read the configuration file.
     */
    @SuppressWarnings("unchecked")
    public void init() throws PortletException {

        // Get configuration file name.
        String configFile = getInitParameter("config");
        if (configFile == null) {
            configFile = "/WEB-INF/testsuite-config.xml";
        }

        // Get configuration file as an input stream.
        InputStream is = getPortletContext().getResourceAsStream(configFile);
        if (is == null) {
            String message = "Testsuite configuration file not found.";
            LOG.error(message);
            throw new PortletException(message);
        }

        // Load PortletTest instances: constructing and initializing.
        TestConfigFactory factory = new TestConfigFactory();
        try {
            testConfigs = factory.createTestConfigs(is);
            tests = new HashMap<String, PortletTest>();
            int i = 0;
            for (TestConfig testConfig : testConfigs) {
                String name = testConfig.getTestClassName();
                PortletTest test = null;
                if (name != null) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Loading test: " + name);
                    }
                    Class<PortletTest> clazz = (Class<PortletTest>)
                        Class.forName(testConfig.getTestClassName());
                    test = clazz.newInstance();
                } else {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Loading NoOpTest (test with no name).");
                    }
                    test = new NoOpTest();
                }
                test.init(testConfig);
                tests.put(String.valueOf(i++), test);
            }
        } catch (Throwable th) {
            String message = "Unable to read testsuite configuration.";
            LOG.error(message, th);
            throw new PortletException(message, th);
        }
    }


    public void processAction(ActionRequest request, ActionResponse response)
    throws PortletException, IOException {
        this.processStateAwarePhase(request, response);
    }
    
    protected void doHeaders(RenderRequest request, RenderResponse response) {
        if (PortletMode.VIEW.equals(request.getPortletMode())) {
            String testId = getTestId(request);
            PortletTest test = (PortletTest) tests.get(testId);
            if (test != null)
                test.doHeaders( getPortletConfig(), 
                                getPortletContext(), 
                                request,
                                response);
        }
    }

    private void processStateAwarePhase(
            PortletRequest request, StateAwareResponse response) {
        String testId = getTestId(request);
        PortletTest test = (PortletTest) tests.get(testId);
        if (test != null) {
            TestResults results = test.doTest(getPortletConfig(),
                                              getPortletContext(),
                                              request,
                                              response);
            PortletSession session = request.getPortletSession();
            TestResults existingResults = (TestResults) 
                session.getAttribute(test.getClass().getName());
            if (existingResults != null) {
                for (TestResult result : results.getCollection()) {
                    existingResults.add(result);
                }
            } else {
                session.setAttribute(test.getClass().getName(), results);
            }
        }
        Map<String, String[]> renderParameters = null;
        if (test != null) {
            renderParameters = test.getRenderParameters(request);
        }
        if (renderParameters == null) {
            renderParameters = new HashMap<String, String[]>();
        }
        renderParameters.put("testId", new String[] { testId });
        response.setRenderParameters(renderParameters);        
    }

    public void processEvent(EventRequest request, EventResponse response)
            throws PortletException, IOException {
        this.processStateAwarePhase(request, response);
    }


    public void serveResource(ResourceRequest request, ResourceResponse response)
            throws PortletException, IOException {
        String testId = getTestId(request);
        PortletTest test = (PortletTest) tests.get(testId);
        if (test != null) {
            TestResults results = test.doTest(getPortletConfig(),
                                              getPortletContext(),
                                              request,
                                              response);
            PortletSession session = request.getPortletSession();
            TestResults existing = (TestResults) session.getAttribute(
                    test.getClass().getName());
            if (existing != null) {
                for (TestResult result : results.getCollection()) {
                    existing.add(result);
                }
                request.setAttribute("results", existing);
                session.setAttribute(test.getClass().getName(), null);
            } else {
                request.setAttribute("results", results);
            }
        }
        if (test.getConfig().getDisplayURI().indexOf("load_resource_test") > -1) {
            response.setContentType("text/html");
            getPortletContext().getRequestDispatcher("/jsp/test_results.jsp")
                .include(request, response);
        }
    }
    
    /**
     * Serves up the <code>view</code> mode.
     * TODO: more javadoc.
     *
     * @param request  the protlet request.
     * @param response  the portlet response.
     */
    @Override
    public void doView(RenderRequest request, RenderResponse response)
    throws PortletException, IOException {

        // Get the current test ID, the test instance and its config.
        String testId = getTestId(request);
        TestConfig testConfig = null;
        PortletTest test = null;
        if (testId != null) {
            testConfig = (TestConfig) testConfigs.get(Integer.parseInt(testId));
            test = (PortletTest) tests.get(testId);
        }
        
        if (LOG.isDebugEnabled()) {
            for (Entry<String, String[]> e : request.getParameterMap().entrySet()) {
                LOG.debug(e.getKey() + " => " + Arrays.asList(e.getValue()));
            }
            
            LOG.debug("Test ID: " + testId);
            LOG.debug("Test Config: " + testConfig);
            if (testConfig != null) {
                LOG.debug("Test config view: " + testConfig.getDisplayURI());
            }
        }
        // For non-ActionTest, run test and save results in request.
        if (test != null) {
            TestResults results = test.doTest(getPortletConfig(),
                                              getPortletContext(),
                                              request,
                                              response);
            PortletSession session = request.getPortletSession();
            TestResults existing = (TestResults) session.getAttribute(
                    test.getClass().getName());
            if (existing != null) {
                for (TestResult result : results.getCollection()) {
                    existing.add(result);
                }
                request.setAttribute("results", existing);
                session.setAttribute(test.getClass().getName(), null);
            } else {
                request.setAttribute("results", results);
            }
        }

        if (testId == null) {
            request.setAttribute("testConfigs", testConfigs);
        } else {
            TestConfig nextTestConfig = null;
            TestConfig prevTestConfig = null;
            int index = testConfigs.indexOf(test.getConfig());
            if (index == 0) {
                prevTestConfig = (TestConfig) testConfigs.get(testConfigs.size() - 1);
                nextTestConfig = (TestConfig) testConfigs.get(index + 1);
            } else if (index == testConfigs.size() - 1) {
                prevTestConfig = (TestConfig) testConfigs.get(index - 1);
                nextTestConfig = (TestConfig) testConfigs.get(0);
            } else {
                prevTestConfig = (TestConfig) testConfigs.get(index - 1);
                nextTestConfig = (TestConfig) testConfigs.get(index + 1);
            }
            request.setAttribute("prevTest", prevTestConfig);
            request.setAttribute("nextTest", nextTestConfig);
            request.setAttribute("testId", new Integer(testId));
            request.setAttribute("test", test);
        }

        // Set content type for render response, and dispatch to JSP.
        response.setContentType("text/html");
        String displayUri = null;
        if (testConfig != null) {
            displayUri = testConfig.getDisplayURI();
        } else {
            displayUri = "/jsp/introduction.jsp";
        }
        PortletRequestDispatcher dispatcher = getPortletContext()
                .getRequestDispatcher(displayUri);
        dispatcher.include(request, response);
    }

    /**
     * Serves up the <code>edit</code> mode. This method dispatches the request
     * and response to the edit JSP page (<code>/jsp/edit.jsp</code>).
     * @param request  the portlet request.
     * @param response  the portlet response.
     */
    protected void doEdit(RenderRequest request, RenderResponse response)
    throws PortletException, IOException {
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher = getPortletContext()
                .getRequestDispatcher("/jsp/edit.jsp");
        dispatcher.include(request, response);
    }

    /**
     * Serves up the <code>help</code> mode. This method dispatches the request
     * and response to the help JSP page (<code>/jsp/help.jsp</code>).
     * @param request  the portlet request.
     * @param response  the portlet response.
     */
    protected void doHelp(RenderRequest request, RenderResponse response)
    throws PortletException, IOException {
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher = getPortletContext()
                .getRequestDispatcher("/jsp/help.jsp");
        dispatcher.include(request, response);
    }


    // Private Methods ---------------------------------------------------------

    /**
     * Returns the current test ID.
     * @param request  the portlet request.
     * @return the current test ID.
     */
    private String getTestId(PortletRequest request) {

        String testId = request.getParameter("testId");
        String prevTestId = request.getParameter("previousTestId");
        String nextTestId = request.getParameter("nextTestId");

        // If none of the parameters are available, return null.
        if ((testId == null || testId.trim().length() == 0)
                && nextTestId == null && prevTestId == null
                && tests.size() > 0) {
            return null;
        }

        // Retrieve the test which is next to the previous test.
        else if (testId == null && prevTestId != null) {
            int previousTestIdInt = Integer.parseInt(prevTestId);
            if (previousTestIdInt >= testConfigs.size() - 1) {
                testId = "0";
            } else {
                testId = String.valueOf(previousTestIdInt + 1);
            }
        }

        // Retrieve the test which is previous to the next test.
        else if (testId == null && nextTestId != null) {
            int nextTestIdInt = Integer.parseInt(nextTestId);
            if (nextTestIdInt <= 0) {
                testId = String.valueOf(testConfigs.size()-1);
            } else {
                testId = String.valueOf(nextTestIdInt - 1);
            }
        }

        // Return the current test ID.
        return testId;
    }
}
