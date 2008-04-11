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

import javax.xml.namespace.QName;

import org.apache.pluto.om.common.InitParam;
import org.apache.pluto.om.common.SecurityRoleRef;

public interface Portlet {

	// Private Member Variables ------------------------------------------------
	/**
	 * The value of the expirationCache property when no expiration cache was configured
	 * in portlet.xml for this portlet descriptor.
	 */
	public static final int EXPIRATION_CACHE_UNSET = Integer.MIN_VALUE;
	//	private static final int EXPIRATION_CACHE_DEFAULT = -2;
	public static final String QNAME_JSR168 = "http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd";

	/**
	 * Returns a string representation of this instance.
	 * FIXME: more info!
	 * @return a string representation of this instance.
	 */
	public abstract String toString();

	/**
	 * Returns the hash code for this instance.
	 * @return the hash code for this instance.
	 */
	public abstract int hashCode();

	public abstract List<InitParam> getInitParams();

	public abstract void setInitParams(List<InitParam> initParams);

	public abstract String getPortletClass();

	public abstract void setPortletClass(String portletClass);

	public abstract PortletInfo getPortletInfo();

	public abstract void setPortletInfo(PortletInfo portletInfo);

	public abstract String getPortletName();

	public abstract void setPortletName(String portletName);

	public abstract PortletPreferences getPortletPreferences();

	public abstract void setPortletPreferences(
			PortletPreferences portletPreferences);

	public abstract List<QName> getProcessingEvents();

	public abstract void setProcessingEvents(
			List<EventDefinitionReference> processingEvents);

	public abstract List<QName> getPublishingEvents();

	public abstract void setPublishingEvents(
			List<EventDefinitionReference> publishingEvents);

	public abstract List<String> getPublicRenderParameter();

	public abstract void setPublicRenderParameter(
			List<String> publicRenderParameter);

	public abstract String getResourceBundle();

	public abstract void setResourceBundle(String resourceBundle);

	public abstract List<SecurityRoleRef> getSecurityRoleRefs();

	public abstract void setSecurityRoleRefs(
			List<SecurityRoleRef> securityRoleRefs);

	public abstract List<Supports> getSupports();

	public abstract void setSupports(List<Supports> supports);

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract String getDisplayName();

	public abstract void setDisplayName(String displayName);

	public abstract List<String> getSupportedLocale();

	public abstract void setSupportedLocale(List<String> supportedLocale);

	public abstract ExpirationCache getExpirationCache();

	public abstract void setExpirationCache(
			ExpirationCache expirationCache);

	public abstract List<ContainerRuntimeOption> getContainerRuntimeOption();

}