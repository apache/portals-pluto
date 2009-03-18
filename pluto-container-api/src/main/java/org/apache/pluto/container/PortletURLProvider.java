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

import javax.portlet.PortletMode;
import javax.portlet.PortletSecurityException;
import javax.portlet.WindowState;

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

    Map<String, String[]> getRenderParameters();
    Map<String, String[]> getPublicRenderParameters();
    
    String getCacheability();
    void setCacheability(String cacheLevel);
    
    String getResourceID();
    void setResourceID(String resourceID);
    
    String toURL();
    
    void write(Writer out, boolean escapeXML) throws IOException;

    /**
     * Gets the mutable map of vendor-specific properties as set on the BaseURL
     * @return parameters a map containing the name and value(s) of the properties (may return null)
     */
    public Map<String, List<String>> getProperties();
}
