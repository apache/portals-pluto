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


public interface PortletApplicationDefinition {

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
    
    PortletDefinition getPortlet(String portletName);
	/**
	 * Retrieve the portlets which exist within this application.
	 * @return
	 */
	ElementFactoryList<PortletDefinition> getPortlets();

	/**
	 * @return Returns the events.
	 */
	ElementFactoryList<EventDefinition> getEventDefinitions();

	PublicRenderParameter getPublicRenderParameter(String identifier);
	/**
	 * @return Returns the public render parameter.
	 */
	ElementFactoryList<PublicRenderParameter> getPublicRenderParameters();

	String getVersion();
	void setVersion(String version);

	CustomPortletMode getCustomPortletMode(String name);
	ElementFactoryList<CustomPortletMode> getCustomPortletModes();

    CustomWindowState getCustomWindowState(String name);
	ElementFactoryList<CustomWindowState> getCustomWindowStates();

	UserAttribute getUserAttribute(String name);
	ElementFactoryList<UserAttribute> getUserAttributes();

	ElementFactoryList<SecurityConstraint> getSecurityConstraints();

	String getResourceBundle();
	void setResourceBundle(String resourceBundle);

	Filter getFilter(String filterName);
	ElementFactoryList<Filter> getFilters();

	FilterMapping getFilterMapping(String filterName);
	ElementFactoryList<FilterMapping> getFilterMappings();

	ElementFactoryList<Listener> getListeners();

	String getDefaultNamespace();
	void setDefaultNamespace(String defaultNamespace);

	ContainerRuntimeOption getContainerRuntimeOption(String name);
	ElementFactoryList<ContainerRuntimeOption> getContainerRuntimeOptions();
}