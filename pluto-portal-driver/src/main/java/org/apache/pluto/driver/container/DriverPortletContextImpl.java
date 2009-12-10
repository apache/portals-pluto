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
package org.apache.pluto.driver.container;

import javax.servlet.ServletContext;

import org.apache.pluto.container.RequestDispatcherService;
import org.apache.pluto.container.driver.DriverPortletContext;
import org.apache.pluto.container.impl.PortletContextImpl;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;

/**
 * Pluto's Portlet Context Implementation. This class implements the
 * <code>InternalPortletContext</code> which provides container specific
 * information needed for processing.
 * 
 * @version 1.1
 */
public class DriverPortletContextImpl extends PortletContextImpl implements DriverPortletContext {
	
    // Private Member Variables ------------------------------------------------
    
    protected ClassLoader contextClassLoader;

    // Constructor -------------------------------------------------------------
    
    /**
     * Constructs an instance.
     * @param servletContext  the servlet context in which we are contained.
     * @param portletApp  the portlet application descriptor.
     */
    public DriverPortletContextImpl(ServletContext servletContext,
                              PortletApplicationDefinition portletApp,
                              RequestDispatcherService rdService)
    {
        super(servletContext, portletApp, PlutoContainerInfo.getInfo(), Configuration.getSupportedContainerRuntimeOptions(), rdService);
        init();
    }
    
    private void init() {
        setContextClassLoader(Thread.currentThread().getContextClassLoader());
    }
    
    public String getApplicationName() {
        return portletApp.getName();
    }
    
    /**
     * ClassLoader associated with this context.
     * @return
     */
    public ClassLoader getContextClassLoader() {
        return contextClassLoader;
    }

    /**
     * ClassLoader associated with this context.
     * @param contextClassLoader
     */
    public void setContextClassLoader(ClassLoader contextClassLoader) {
        this.contextClassLoader = contextClassLoader;
    }
}

