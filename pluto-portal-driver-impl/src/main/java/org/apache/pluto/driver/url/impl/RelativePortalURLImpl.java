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
package org.apache.pluto.driver.url.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortalURLParameter;
import org.apache.pluto.driver.url.PortalURLParser;

/**
 * The portal URL.
 * @since 1.0
 */
public class RelativePortalURLImpl implements PortalURL {

    private static final Logger LOG = LoggerFactory.getLogger(RelativePortalURLImpl.class);

    private String urlBase;
    private String servletPath;
    private String renderPath;
    private String actionWindow;
    private String resourceWindow;
    private String cacheLevel;
    private String resourceID;

    private Map<String, String[]> publicParameterCurrent = new HashMap<String, String[]>();

    private Map<String, String[]> publicParameterNew = new HashMap<String, String[]>();
    private Map<String, String[]> privateRenderParameters = new HashMap<String, String[]>();
    
    /**
     * PortalURLParser used to construct the string
     * representation of this portal url.
     */
    private PortalURLParser urlParser;

    /** The window states: key is the window ID, value is WindowState. */
    private Map<String, WindowState> windowStates = new HashMap<String, WindowState>();

    private Map<String, PortletMode> portletModes = new HashMap<String, PortletMode>();

    /** Parameters of the portlet windows. */
    private Map<String, PortalURLParameter> parameters = new HashMap<String, PortalURLParameter>();

    /**
     * Constructs a PortalURLImpl instance using customized port.
     * @param urlBase      the absolute (protocol://domain:port) request url base
     * @param contextPath  the servlet context path.
     * @param servletName  the servlet name.
     * @param urlParser    the {@link PortalURLParser} used to construct a string representation of the url.
     */
    public RelativePortalURLImpl(String urlBase, String contextPath, String servletName, PortalURLParser urlParser) {
        this.urlBase = urlBase;
    	StringBuffer buffer = new StringBuffer();
    	buffer.append(contextPath);
    	buffer.append(servletName);
        servletPath = buffer.toString();
        this.urlParser = urlParser;
    }

    /**
     * Internal private constructor used by method <code>clone()</code>.
     * @see #clone()
     */
    private RelativePortalURLImpl() {
    	// Do nothing.
    }

    // Public Methods ----------------------------------------------------------

    public void setRenderPath(String renderPath) {
        this.renderPath = renderPath;
    }

    public String getRenderPath() {
        return renderPath;
    }

    public void addParameter(PortalURLParameter param) {
        parameters.put(param.getWindowId() + param.getName(), param);
    }

    public Collection<PortalURLParameter> getParameters() {
        return parameters.values();
    }

    public void setActionWindow(String actionWindow) {
        this.actionWindow = actionWindow;
    }

    public String getActionWindow() {
        return actionWindow;
    }

    public Map<String, PortletMode> getPortletModes() {
        return Collections.unmodifiableMap(portletModes);
    }

    public PortletMode getPortletMode(String windowId) {
        PortletMode mode = portletModes.get(windowId);
        if (mode == null) {
            mode = PortletMode.VIEW;
        }
        return mode;
    }

    public void setPortletMode(String windowId, PortletMode portletMode) {
        portletModes.put(windowId, portletMode);
    }

    public Map<String, WindowState> getWindowStates() {
        return Collections.unmodifiableMap(windowStates);
    }

    /**
     * Returns the window state of the specified window.
     * @param windowId  the window ID.
     * @return the window state. Default to NORMAL.
     */
    public WindowState getWindowState(String windowId) {
        WindowState state = windowStates.get(windowId);
        if (state == null) {
            state = WindowState.NORMAL;
        }
        return state;
    }

    /**
     * Sets the window state of the specified window.
     * @param windowId  the window ID.
     * @param windowState  the window state.
     */
    public void setWindowState(String windowId, WindowState windowState) {
        this.windowStates.put(windowId, windowState);
    }

    /**
     * Clear parameters of the specified window.
     * @param windowId  the window ID.
     */
    public void clearParameters(String windowId) {
    	for (Iterator<Map.Entry<String, PortalURLParameter>> it = parameters.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, PortalURLParameter> entry = it.next();
            PortalURLParameter param = entry.getValue();
            if (param.getWindowId()!=null){
            	if (param.getWindowId().equals(windowId)) {
                	it.remove();
                }
            }
        }
    }
    
    public void setCacheability(String cacheLevel)
    {
        this.cacheLevel = cacheLevel;
    }
    
    public String getCacheability()
    {
        return cacheLevel;
    }
    
    public void setResourceID(String resourceID)
    {
        this.resourceID = resourceID;
    }
    
    public String getResourceID()
    {
        return resourceID;
    }

    /**
     * Converts to a string representing the portal URL.
     * @deprecated use toURL(boolean absolute) instead
     * @return a string representing the portal URL.
     * @see PortalURLParserImpl#toString(org.apache.pluto.driver.url.PortalURL)
     */
    public String toString() {
        return toURL(false);
    }
    
    /**
     * Converts to a string representing the portal URL.
     * @return a string representing the portal URL.
     * @see PortalURLParserImpl#toString(org.apache.pluto.driver.url.PortalURL)
     */
    public String toURL(boolean absolute)
    {
        String result = urlParser.toString(this);
        if (absolute)
        {
            return urlBase + result;
        }
        return result;
    }

    /**
     * Returns the server URI (protocol, name, port).
     * @return the server URI portion of the portal URL.
     * @deprecated
     */
    @Deprecated
    public String getServerURI() {
        return null;
    }

    /**
     * Returns the servlet path (context path + servlet name).
     * @return the servlet path.
     */
    public String getServletPath() {
        return servletPath;
    }

    /**
     * Clone a copy of itself.
     * @return a copy of itself.
     */
    public synchronized PortalURL clone() {
    	RelativePortalURLImpl portalURL = new RelativePortalURLImpl();
    	portalURL.servletPath = this.servletPath;
    	portalURL.parameters = new HashMap<String, PortalURLParameter>(parameters);
    	portalURL.privateRenderParameters = new HashMap<String, String[]>(privateRenderParameters);
    	portalURL.portletModes = new HashMap<String, PortletMode>(portletModes);
    	portalURL.windowStates = new HashMap<String, WindowState>(windowStates);
    	portalURL.cacheLevel = cacheLevel;
    	portalURL.resourceID = resourceID;
    	portalURL.renderPath = renderPath;
    	portalURL.actionWindow = actionWindow;
        portalURL.urlParser = urlParser;
    	portalURL.resourceWindow = resourceWindow;
    	portalURL.publicParameterCurrent = publicParameterCurrent;
        return portalURL;
    }
//JSR-286 methods

    public void addPublicRenderParametersNew(Map<String, String[]> parameters){
    	for (Iterator<String> iter=parameters.keySet().iterator(); iter.hasNext();) {
			String key = iter.next();
			if (publicParameterNew.containsKey(key)){
				publicParameterNew.remove(key);
			}
			String[] values = parameters.get(key);
            publicParameterNew.put(key, values);
		}
    }


    public void addPublicParameterCurrent(String name, String[] values){
    	publicParameterCurrent.put(name, values);
    }

    public void addPublicParameterActionResourceParameter(String parameterName, String value) {
    	//add at the first position
		if (publicParameterCurrent.containsKey(parameterName)){
			String[] tmp = publicParameterCurrent.get(parameterName);

			String[] values = new String[tmp.length + 1];
			values[0] = value;
			for (int i = 0; i < tmp.length; i++) {
				values[i+1] = tmp[i];
			}
			publicParameterCurrent.remove(parameterName);
			publicParameterCurrent.put(parameterName, values.clone());
		}
		else
			publicParameterCurrent.put(parameterName, new String[]{value});
	}

    public Map<String, String[]> getPublicParameters() {
    	Map<String,String[]> tmp = new HashMap<String, String[]>();

		for (Iterator<String> iter = publicParameterCurrent.keySet().iterator(); iter.hasNext();) {
           String paramname = iter.next();
           if (!publicParameterNew.containsKey(paramname)){
               String[] paramvalue = publicParameterCurrent.get(paramname);
               tmp.put(paramname, paramvalue);
           }
        }
		for (Iterator<String> iter = publicParameterNew.keySet().iterator();iter.hasNext();){
			String paramname = iter.next();
			String[] paramvalue = publicParameterNew.get(paramname);
			if (paramvalue[0]!=null){
				tmp.put(paramname, paramvalue);
			}
		}
		return tmp;
    }
    
    public Map<String, String[]> getNewPublicParameters()
    {
        return publicParameterNew;
    }
    
    public Map<String, String[]> getPrivateRenderParameters()
    {
        return privateRenderParameters;
    }


	public PageConfig getPageConfig(ServletContext servletContext) {
		String requestedPageId = getRenderPath();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Requested Page: " + requestedPageId);
        }
        return ((DriverConfiguration) servletContext.getAttribute(
        		AttributeKeys.DRIVER_CONFIG)).getPageConfig(requestedPageId);
	}

    public String getResourceWindow() {
		return resourceWindow;
	}

	public void setResourceWindow(String resourceWindow) {
		this.resourceWindow = resourceWindow;
	}

	public synchronized void merge(PortalURL url, String windowId)
	{
        actionWindow = url.getActionWindow();
        resourceWindow = url.getResourceWindow();
        setPortletMode(windowId, url.getPortletMode(windowId));
        setWindowState(windowId, url.getWindowState(windowId));
        setCacheability(url.getCacheability());
        setResourceID(url.getResourceID());
        clearParameters(windowId);
        for (PortalURLParameter param : url.getParameters())
        {
            if (windowId.equals(param.getWindowId()))
            {
                addParameter(new PortalURLParameter(param.getWindowId(), param.getName(), param.getValues()));
            }
        }
        Map<String, String[]> newPublicParameters = url.getNewPublicParameters();
        for (Map.Entry<String, String[]> entry : newPublicParameters.entrySet())
        {
            if (entry.getValue()[0] == null)
            {
                publicParameterCurrent.remove(entry.getKey());
            }
            else
            {
                publicParameterCurrent.put(entry.getKey(), entry.getValue());
            }
        }
	}
}
