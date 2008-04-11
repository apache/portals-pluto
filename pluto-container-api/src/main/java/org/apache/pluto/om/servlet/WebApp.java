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
package org.apache.pluto.om.servlet;

import java.util.List;

import org.apache.pluto.om.common.Icon;

public interface WebApp {

	public abstract Icon getIcon();

	public abstract void setIcon(Icon icon);

	public abstract String getDisplayName();

	public abstract void setDisplayName(String displayName);

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract boolean isDistributable();

	public abstract Distributable getDistributable();

	public abstract void setDistributable();

	public abstract void setDistributable(boolean distributable);

	public abstract List getContextParams();

	public abstract void setContextParams(List contextParams);

	public abstract List getFilters();

	public abstract void setFilters(List filters);

	public abstract List getFilterMappings();

	public abstract void setFilterMappings(List filterMappings);

	public abstract List getListeners();

	public abstract void setListeners(List listeners);

	public abstract List getServlets();

	public abstract void setServlets(List servlets);

	public abstract List getServletMappings();

	public abstract void setServletMappings(List servletMappings);

	public abstract SessionConfig getSessionConfig();

	public abstract void setSessionConfig(SessionConfig sessionConfig);

	public abstract List getMimeMappings();

	public abstract void setMimeMappings(List mimeMappings);

	public abstract WelcomeFileList getWelcomeFileList();

	public abstract void setWelcomeFileList(WelcomeFileList welcomeFileList);

	public abstract List getErrorPages();

	public abstract void setErrorPages(List errorPages);

	public abstract List getTaglibs();

	public abstract void setTaglibs(List taglibs);

	public abstract List getResourceRefs();

	public abstract void setResourceRefs(List resourceRefs);

	public abstract List getSecurityConstraints();

	public abstract void setSecurityConstraints(List securityConstraints);

	public abstract LoginConfig getLoginConfig();

	public abstract void setLoginConfig(LoginConfig loginConfig);

	public abstract List getSecurityRoles();

	public abstract void setSecurityRoles(List securityRoles);

	public abstract List getEnvEntrys();

	public abstract void setEnvEntrys(List envEntrys);

	public abstract List getEjbRefs();

	public abstract void setEjbRefs(List ejbRefs);

	public abstract String getServletVersion();

	public abstract void setServletVersion(String servletVersion);

	public abstract Servlet getServlet(String name);

	public abstract ServletMapping getServletMapping(String uri);

}