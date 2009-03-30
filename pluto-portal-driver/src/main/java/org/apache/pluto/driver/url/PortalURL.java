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
package org.apache.pluto.driver.url;

import java.util.Collection;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.ServletContext;

import org.apache.pluto.driver.services.portal.PageConfig;

/**
 * Created by IntelliJ IDEA.
 * User: ddewolf
 * Date: Sep 4, 2006
 * Time: 5:17:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PortalURL extends Cloneable {
    void setRenderPath(String renderPath);

    String getRenderPath();

    void addParameter(PortalURLParameter param);
    
    void addPublicRenderParametersNew(Map<String, String[]> parameters);

    Collection<PortalURLParameter> getParameters();

    public void addPublicParameterCurrent(String name, String[] values);

    public Map<String, String[]> getPublicParameters();
    
    Map<String, String[]> getNewPublicParameters();
    
    Map<String, String[]> getPrivateRenderParameters();
    
    void setActionWindow(String actionWindow);

    String getActionWindow();

    Map<String, PortletMode> getPortletModes();

    PortletMode getPortletMode(String windowId);

    void setPortletMode(String windowId, PortletMode portletMode);

    Map<String, WindowState> getWindowStates();

    WindowState getWindowState(String windowId);

    void setWindowState(String windowId, WindowState windowState);

    void clearParameters(String windowId);

    /**
     * 
     * @deprecated use toURL(boolean) instead
     */
    String toString();
    
    String toURL(boolean absolute);

    String getServerURI();

    String getServletPath();

    PortalURL clone();

    String getResourceWindow();

	void setResourceWindow(String window);

	PageConfig getPageConfig(ServletContext servletContext);

	void addPublicParameterActionResourceParameter(String parameterName, String value);
	
	void setCacheability(String cacheLevel);
	String getCacheability();
	
	void setResourceID(String resourceID);
	String getResourceID();
	
	void merge(PortalURL url, String windowId);	
}
