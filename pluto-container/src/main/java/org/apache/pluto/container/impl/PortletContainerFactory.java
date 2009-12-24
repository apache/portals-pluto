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
package org.apache.pluto.container.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.ContainerServices;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.util.ArgumentUtility;

/**
 * Factory used to create new PortletContainer instances.  The factor constructs
 * the underlying pluto container implementation by using the the given
 * container services.
 *
 * @version 1.0
 * @since Sep 18, 2004
 * @deprecated just use blueprint or spring to construct the PortletContainer
 */
public class PortletContainerFactory {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PortletContainerFactory.class);


    /** Singleton instance of the <code>PortletContainerFactory</code>. */
    private static final PortletContainerFactory FACTORY =
    		new PortletContainerFactory();

    /**
     * Accessor method for the singleton instance of the
     * <code>PortletContainerFactory</code>.
     * @return singleton instance of the PortletContainerFactory
     */
    public static PortletContainerFactory getInstance() {
    	return FACTORY;
    }

    /**
     * Private constructor that prevents external instantiation.
     */
    private PortletContainerFactory() {
    	// Do nothing.
    }

    /**
     * Create a container with the given containerName, initialized from the given
     * servlet config, and using the given container services.
     * @param containerName  the name of the portlet container.
     * @param requiredServices  the required portlet container services.
     * @return newly created PortletContainer instance.
     * @throws PortletContainerException
     */
    public PortletContainer createContainer(
    		String containerName,
    		ContainerServices requiredServices)
    throws PortletContainerException {
        ArgumentUtility.validateNotNull("requiredServices", requiredServices);
        ArgumentUtility.validateNotEmpty("containerName", containerName);

        PortletContainer container = new PortletContainerImpl(
        		containerName, requiredServices);

        if (LOG.isInfoEnabled()) {
            LOG.info("Portlet Container [" + containerName + "] created.");
        }
        return container;
    }
}

