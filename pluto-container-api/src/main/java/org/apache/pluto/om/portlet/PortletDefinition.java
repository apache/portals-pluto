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

import java.util.List;
import java.util.Locale;

import org.apache.pluto.om.ElementFactoryList;

public interface PortletDefinition {
    
	PortletApplicationDefinition getApplication();
	void setApplication(PortletApplicationDefinition application);

    InitParam getInitParam(String paramName);
	ElementFactoryList<InitParam> getInitParams();
	
	String getPortletClass();
	void setPortletClass(String portletClass);

	PortletInfo getPortletInfo();
    PortletInfo getPortletInfo(boolean create);

	String getPortletName();
	void setPortletName(String portletName);

	Preferences getPortletPreferences();
    Preferences getPortletPreferences(boolean create);

    ElementFactoryList<EventDefinitionReference> getSupportedProcessingEvents();
    ElementFactoryList<EventDefinitionReference> getSupportedPublishingEvents();

	List<String> getSupportedPublicRenderParameters();

	String getResourceBundle();
	void setResourceBundle(String resourceBundle);

	SecurityRoleRef getSecurityRoleRef(String roleName);
	ElementFactoryList<SecurityRoleRef> getSecurityRoleRefs();

	Supports getSupports(String mimeType);
	ElementFactoryList<Supports> getSupports();

	Description getDescription(Locale locale);
	ElementFactoryList<Description> getDescriptions();

	DisplayName getDisplayName(Locale locale);
    ElementFactoryList<DisplayName> getDisplayNames();

	List<String> getSupportedLocales();

	int getExpirationCache();
    void setExpirationCache(int expirationCache);

	String getCacheScope();
	void setCacheScope(String cacheScope);

	ContainerRuntimeOption getContainerRuntimeOption(String name);
	ElementFactoryList<ContainerRuntimeOption> getContainerRuntimeOptions();
}