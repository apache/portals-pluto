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
package org.apache.pluto.container.om.portlet;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.namespace.QName;

public interface PortletApplicationDefinition {

    String JSR_168_VERSION = "1.0";
    String JSR_286_VERSION = "2.0";

    String getName();
    void setName(String name);
    
    String getContextPath();
    void setContextPath(String contextPath);
    
    PortletDefinition getPortlet(String portletName);
	List<? extends PortletDefinition> getPortlets();
	PortletDefinition addPortlet(String name);
	
	List<? extends EventDefinition> getEventDefinitions();
	EventDefinition addEventDefinition(String name);
    EventDefinition addEventDefinition(QName qname);

	PublicRenderParameter getPublicRenderParameter(String identifier);
	List<? extends PublicRenderParameter> getPublicRenderParameters();
	PublicRenderParameter addPublicRenderParameter(String name, String identifier);
    PublicRenderParameter addPublicRenderParameter(QName qname, String identifier);

	String getVersion();
	void setVersion(String version);

	CustomPortletMode getCustomPortletMode(String name);
	List<? extends CustomPortletMode> getCustomPortletModes();
	CustomPortletMode addCustomPortletMode(String name);

    CustomWindowState getCustomWindowState(String name);
	List<? extends CustomWindowState> getCustomWindowStates();
	CustomWindowState addCustomWindowState(String name);

	UserAttribute getUserAttribute(String name);
	List<? extends UserAttribute> getUserAttributes();
	UserAttribute addUserAttribute(String name);

	List<? extends SecurityConstraint> getSecurityConstraints();
	SecurityConstraint addSecurityConstraint(String transportGuarantee);

	String getResourceBundle();
	void setResourceBundle(String resourceBundle);

	Filter getFilter(String filterName);
	List<? extends Filter> getFilters();
	Filter addFilter(String filterName);

	FilterMapping getFilterMapping(String filterName);
	List<? extends FilterMapping> getFilterMappings();
	FilterMapping addFilterMapping(String filterName);

	List<? extends Listener> getListeners();
	Listener addListener(String listenerClass);

	String getDefaultNamespace();
	void setDefaultNamespace(String defaultNamespace);

	ContainerRuntimeOption getContainerRuntimeOption(String name);
	List<? extends ContainerRuntimeOption> getContainerRuntimeOptions();
	ContainerRuntimeOption addContainerRuntimeOption(String name);

    Map<Locale, String> getLocaleEncodingMappings();
    void addLocaleEncodingMapping(Locale locale, String encoding);
}