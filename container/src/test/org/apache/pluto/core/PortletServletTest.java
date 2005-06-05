/*
 * Copyright 2005 The Apache Software Foundation.
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
package org.apache.pluto.core;

import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;

import org.apache.pluto.util.PlutoTestCase;
import org.jmock.Mock;
import org.jmock.core.constraint.StringContains;
import org.jmock.core.stub.ReturnStub;

/**
 * Test Class
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since June 1, 2005
 */
public class PortletServletTest extends PlutoTestCase {

    private PortletServlet servlet;
    private Mock servletConfigMock = new Mock(ServletConfig.class);
    private Mock servletContextMock = new Mock(ServletContext.class);
    private String servletName = "Test Servlet Name";

    /*
    public void setUp() throws Exception {
        super.setUp();

        // Setup the Servlet Context
        servletContextMock.expects(atLeastOnce()).method("getResourceAsStream").with(new StringContains("portlet.xml"));
        servletContextMock.expects(atLeastOnce()).method("log").withAnyArguments();
        ServletContext ctx = (ServletContext)servletContextMock.proxy();

        // Setup the Servlet Config
        servletConfigMock.expects(atLeastOnce()).method("getServletContext").withNoArguments().will(new ReturnStub(ctx));
        servletConfigMock.expects(atLeastOnce()).method("getInitParameter").with(eq("portlet-name")).will(new ReturnStub("test-portlet"));
        servletConfigMock.expects(atLeastOnce()).method("getServletName").withNoArguments().will(new ReturnStub(servletName));
        ServletConfig config = (ServletConfig)servletConfigMock.proxy();

        // Setup the Servlet
        servlet = new PortletServlet();
        servlet.init(config);
    }
    */

    public void testGetServletName() {
        //assertEquals(servletName, servlet.getServletName());
    }

    /*
    We need a little more refactoring to make this use a few more services.
    public void testGetServletInfo() {
        ResourceBundle bundle = ResourceBundle.getBundle("org.apache.pluto.environment");
        String name = bundle.getString("pluto.container.name");
        String version = bundle.getString("pluto.container.version");
        assertContains("ServletInfo does not contain the container name.", name, servlet.getServletInfo());
        assertContains("ServletInfo does not contain the container version.", version, servlet.getServletInfo());
    }
    */
}
