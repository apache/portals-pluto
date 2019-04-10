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

import java.util.List;
import java.util.Set;

import javax.portlet.Event;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletMode;
import javax.portlet.WindowState;

/**
 * @author <a href="mailto:ate@douma.nu">Ate Douma</a>
 * @version $Id$
 */
public interface PortletStateAwareResponseContext extends PortletResponseContext
{
    PortletMode getPortletMode();
    void setPortletMode(PortletMode portletMode);
    WindowState getWindowState();
    void setWindowState(WindowState windowState);
    EventProvider getEventProvider();
    List<Event> getEvents();
    
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
    
    /**
     * Returns a mutable render parameters object.
     * 
     * @return
     */
    MutableRenderParameters getRenderParameters(String windowId);
    
    /**
     * Called when exception occurs during action or event processing to throw away
     * any events or render parameters that have been set.
     */
    void reset();

}
