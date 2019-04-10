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
package org.apache.pluto.container;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletMode;
import javax.portlet.PortletSecurityException;
import javax.portlet.WindowState;

import org.apache.pluto.container.PortletURLProvider.ParamType;

/**
 * Defines the interface used by the portlet container to create Portlet URLs.
 * This provider must be implemented by the Portal and provided via the
 * container services upon initialization of the container.
 *
 * @version 1.0
 */
public interface PortletURLProvider {

    enum TYPE { ACTION, RENDER, RESOURCE };
    
    TYPE getType();
    
    // For JSR 362 parameter handling
    enum ParamType {
       ACTION,
       RENDER,
       RESOURCE,
       PUBLIC
    }

    /**
     * Returns a parameter map for the specified window and type.
     * 
     * V3.0 method.
     * 
     * @param windowId
     * @param type
     * @return
     */
    Map<String, String[]> getParameterMap(String windowId, ParamType type);

    /**
     * Sets a parameter of the given type for the window.
     * 
     * V3 method.
     * 
     * @param windowId
     * @param name
     * @param type
     * @param strings
     */
    void setParameter(String windowId, String name, ParamType type, String[] strings);

    /**
     * Removes the given parameter
     * 
     * V3 method.
     * 
     * @param windowId
     * @param name
     * @param type
     */
    void removeParameter(String windowId, String name, ParamType type);

    /**
     * Gets the public render parameter names for this window.
     * 
     * @param windowId
     * @return
     */
    Set<String> getPublicParameterNames(String windowId);

    /**
     * Sets the new portlet mode at the URL. If no mode is set at the URL the
     * currently active mode is used.
     * @param mode the new portlet mode
     */
    void setPortletMode(PortletMode mode);
    
    PortletMode getPortletMode();

    /**
     * Sets the new window state at the URL. If no state is set at the URL the
     * currently active state is used.
     * @param state the new window state
     */
    void setWindowState(WindowState state);
    
    WindowState getWindowState();

    void setSecure(boolean secure) throws PortletSecurityException;
    boolean isSecure();
    
    /**
     * Add a public render parameter for given window ID and parameter name
     *  
     * @param qn           QName
     * @param identifier   Identifier for PRP
     * @param values       values array
     */
    void addPublicRenderParameter(String windowId, String name, String[] values);
    
    /**
     * Remove the PRP for the given window ID and parameter name
     * 
     * @param windowId
     * @param name
     */
    void removePublicRenderParameter(String windowId, String name);
    
    /**
     * Returns <code>true</code> if the given name representa a public render
     * parameter for the given window.
     * 
     * @param windowId
     * @param name
     * @return
     */
    boolean isPublicRenderParameter(String windowId, String name);
    
    /**
     * Retrieves the available private parameter names for the given window ID
     * @param windowId
     * @return
     */
    Set<String> getPrivateParameterNames(String windowId);
    
    /**
     * Gets the values array for the given window ID and private parameter name
     * @param windowId
     * @param name
     * @return
     */
    String[] getParameterValues(String windowId, String name);

    /**
     * Adds the specified private parameter if not already present, or updates the
     * values for the parameter if it is already present.
     * @param windowId
     * @param name
     * @param values
     */
    void setParameter(String windowId, String name, String[] values);
    
    /** 
     * Removes the private parameter for the given window and name. Does nothing if the
     * given parameter is not present.
     * @param windowId
     * @param name
     */
    void removeParameter(String windowId, String name);
    
    String getCacheability();
    void setCacheability(String cacheLevel);
    
    String getResourceID();
    void setResourceID(String resourceID);
    
    String toURL();
    
    void write(Writer out, boolean escapeXML) throws IOException;
    
    Appendable append(Appendable out, boolean escapeXML) throws IOException;
    
    /**
     * Gets the mutable map of vendor-specific properties as set on the BaseURL
     * @return parameters a map containing the name and value(s) of the properties (may return null)
     */
    public Map<String, List<String>> getProperties();

    /**
     * Marks the URL for authenticated access
     * 
     * @param authenticated
     */
    void setAuthenticated(boolean authenticated);

    /**
     * Returns current authenticated setting
     * 
     * @return
     */
    boolean getAuthenticated();

    /**
     * Sets the fragment identifier on a render URL
     * @param fragment
     */
    void setFragmentIdentifier(String fragment);

    /**
     * Gets the current fragment identifier for the render URL
     * @return
     */
    String getFragmentIdentifier();

    /**
     * Cears parameters of specified type
     * @param type
     */
    void clearParameters(String WindowId, ParamType paramType);
}
