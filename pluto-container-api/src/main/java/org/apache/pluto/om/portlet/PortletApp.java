/*
 * Copyright 2008 The Apache Software Foundation
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
package org.apache.pluto.om.portlet;

import org.apache.pluto.om.ElementFactoryList;


public interface PortletApp {

    /**
     * The name of the Portlet Application
     * <br/>
     */
    String getName();
    
    /**
     * Set the name for the Portlet Application
     * @param name
     */
    void setName(String name);
    
    /**
     * The id the Portlet Application
     * <br/>
     * Note: for the Pluto container default descriptor implementation this equals
     *       to the contextPath of the Web Applications
     * @return
     */
    String getId();
    
    /**
     * Set the id the Portlet Application
     * <br/>
     * Note: for the Pluto container default descriptor implementation this equals
     *       to the contextPath of the Web Applications
     * @return
     */
    void setId(String id);
    
	/**
	 * Retrieve the portlets which exist within this application.
	 * @return
	 */
	ElementFactoryList<Portlet> getPortlets();

	/**
	 * @return Returns the events.
	 */
	ElementFactoryList<EventDefinition> getEventDefinitions();

	/**
	 * @return Returns the public render parameter.
	 */
	ElementFactoryList<PublicRenderParameter> getPublicRenderParameters();

	String getVersion();

	void setVersion(String version);

	ElementFactoryList<CustomPortletMode> getCustomPortletModes();

	ElementFactoryList<CustomWindowState> getCustomWindowStates();

	ElementFactoryList<UserAttribute> getUserAttributes();

	ElementFactoryList<SecurityConstraint> getSecurityConstraints();

	String getResourceBundle();

	void setResourceBundle(String resourceBundle);

	ElementFactoryList<Filter> getFilters();

	ElementFactoryList<FilterMapping> getFilterMappings();

	ElementFactoryList<Listener> getListeners();

	String getDefaultNamespace();

	void setDefaultNamespace(String defaultNamespace);

	ElementFactoryList<ContainerRuntimeOption> getContainerRuntimeOptions();
}