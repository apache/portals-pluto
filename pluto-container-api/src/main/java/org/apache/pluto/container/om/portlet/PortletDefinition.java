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

import javax.xml.namespace.QName;

public interface PortletDefinition {
    
    String getPortletName();

    PortletApplicationDefinition getApplication();

    InitParam getInitParam(String paramName);
	List<? extends InitParam> getInitParams();
	InitParam addInitParam(String paramName);
	
	String getPortletClass();
	void setPortletClass(String portletClass);

	PortletInfo getPortletInfo();

	Preferences getPortletPreferences();

    List<? extends EventDefinitionReference> getSupportedProcessingEvents();
    EventDefinitionReference addSupportedProcessingEvent(QName qname);
    EventDefinitionReference addSupportedProcessingEvent(String name);
    
    List<? extends EventDefinitionReference> getSupportedPublishingEvents();
    EventDefinitionReference addSupportedPublishingEvent(QName qname);
    EventDefinitionReference addSupportedPublishingEvent(String name);

	List<String> getSupportedPublicRenderParameters();
	void addSupportedPublicRenderParameter(String identifier);

	String getResourceBundle();
	void setResourceBundle(String resourceBundle);

	SecurityRoleRef getSecurityRoleRef(String roleName);
	List<? extends SecurityRoleRef> getSecurityRoleRefs();
	SecurityRoleRef addSecurityRoleRef(String roleName);

	Supports getSupports(String mimeType);
	List<? extends Supports> getSupports();
	Supports addSupports(String mimeType);

	Description getDescription(Locale locale);
    List<? extends Description> getDescriptions();
    Description addDescription(String lang);

	DisplayName getDisplayName(Locale locale);
    List<? extends DisplayName> getDisplayNames();
    DisplayName addDisplayName(String lang);

	List<String> getSupportedLocales();
	void addSupportedLocale(String lang);

	int getExpirationCache();
    void setExpirationCache(int expirationCache);

	String getCacheScope();
	void setCacheScope(String cacheScope);

	ContainerRuntimeOption getContainerRuntimeOption(String name);
	List<? extends ContainerRuntimeOption> getContainerRuntimeOptions();
	ContainerRuntimeOption addContainerRuntimeOption(String name);
}