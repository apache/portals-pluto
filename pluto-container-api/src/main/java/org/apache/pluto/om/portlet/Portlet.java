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

import org.apache.pluto.om.ElementFactoryList;
import org.apache.pluto.om.common.Description;
import org.apache.pluto.om.common.DisplayName;
import org.apache.pluto.om.common.InitParam;
import org.apache.pluto.om.common.SecurityRoleRef;

public interface Portlet {
    
	/**
	 * Returns a string representation of this instance.
	 * FIXME: more info!
	 * @return a string representation of this instance.
	 */
	String toString();

	/**
	 * Returns the hash code for this instance.
	 * @return the hash code for this instance.
	 */
	int hashCode();
	
	String getId();
	
	void setId(String id);
	
	PortletApp getApplication();

	ElementFactoryList<InitParam> getInitParams();

	String getPortletClass();

	void setPortletClass(String portletClass);

	PortletInfo getPortletInfo();

    PortletInfo getPortletInfo(boolean create);

	String getPortletName();

	void setPortletName(String portletName);

	PortletPreferences getPortletPreferences();

    PortletPreferences getPortletPreferences(boolean create);

    ElementFactoryList<EventDefinitionReference> getSupportedProcessingEvents();

    ElementFactoryList<EventDefinitionReference> getSupportedPublishingEvents();

	List<String> getSupportedPublicRenderParameters();

	void setSupportedPublicRenderParameters(List<String> publicRenderParameters);

	String getResourceBundle();

	void setResourceBundle(String resourceBundle);

	ElementFactoryList<SecurityRoleRef> getSecurityRoleRefs();

	ElementFactoryList<Supports> getSupports();

	ElementFactoryList<Description> getDescriptions();

    ElementFactoryList<DisplayName> getDisplayNames();

	List<String> getSupportedLocales();

	void setSupportedLocales(List<String> supportedLocales);

	int getExpirationCache();
	
	String getCacheScope();
	
	void setCacheScope(String cacheScope);

	void setExpirationCache(int expirationCache);

	ElementFactoryList<ContainerRuntimeOption> getContainerRuntimeOptions();
}