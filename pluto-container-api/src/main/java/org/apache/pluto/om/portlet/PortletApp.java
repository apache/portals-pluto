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


public interface PortletApp {

	/**
	 * Retrieve the portlets which exist within this application.
	 * @return
	 */
	public abstract List getPortlets();

	/**
	 * Set the portlets that exist within this application.
	 * @param portlets
	 */
	public abstract void setPortlets(List<Portlet> portlets);

	/**
	 * @return Returns the events.
	 */
	public abstract List<EventDefinition> getEvents();

	/**
	 * @param events The events to set.
	 */
	public abstract void setEvents(List<EventDefinition> events);

	/**
	 * @return Returns the public render parameter.
	 */
	public abstract List<PublicRenderParam> getRender();

	/**
	 * @param render The public render parameter to set.
	 */
	public abstract void setRender(List<PublicRenderParam> render);

	public abstract String getVersion();

	public abstract void setVersion(String version);

	public abstract List<CustomPortletMode> getCustomPortletMode();

	public abstract void setCustomPortletMode(
			List<CustomPortletMode> customPortletMode);

	public abstract List<CustomWindowState> getCustomWindowState();

	public abstract void setCustomWindowState(
			List<CustomWindowState> customWindowState);

	public abstract List<UserAttribute> getUserAttribute();

	public abstract void setUserAttribute(List<UserAttribute> userAttribute);

	public abstract List<SecurityConstraint> getSecurityConstraint();

	public abstract void setSecurityConstraint(
			List<SecurityConstraint> securityConstraint);

	public abstract String getResourceBundle();

	public abstract void setResourceBundle(String resourceBundle);

	public abstract List<Filter> getFilter();

	public abstract void setFilter(List<Filter> filter);

	public abstract List<FilterMapping> getFilterMapping();

	public abstract void setFilterMapping(List<FilterMapping> filterMapping);

	public abstract List<Listener> getListener();

	public abstract void setListener(List<Listener> listener);

	public abstract String getDefaultNamespace();

	public abstract void setDefaultNamespace(String defaultNamespace);

	public abstract List<ContainerRuntimeOption> getContainerRuntimeOption();

}