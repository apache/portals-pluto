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
import java.util.Map;

import javax.portlet.Event;
import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.xml.namespace.QName;

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
    Map<String, String[]> getRenderParameters();
    Map<String, String[]> getPublicRenderParameters();
    EventProvider getEventProvider();
    List<Event> getEvents();
    
    /**
     * Add a public render parameter including QName to allow for use of
     * PRP mapping algorithm.
     *  
     * @param qn           QName
     * @param identifier   Identifier for PRP
     * @param values       values array
     */
    void addPublicRenderParameter(QName qn, String identifier, String[] values);
    
    /**
     * Remove the PRP referred to by the QName
     * 
     * @param qn
     */
    void removePublicRenderParameter(QName qn);

}
