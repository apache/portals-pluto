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
package org.apache.pluto.internal.impl;

import org.apache.pluto.PortletEntity;
import org.apache.pluto.om.portlet.PortletDefinition;

/**
 * The PortletEntity encapsulates all data pertaining to a single portlet
 * instance.  This instance may appear zero or more times per user. The
 * PortletEntity consists of two primary peices of information, the Portlet
 * Definition as defined by the {@link PortletType} and the Wrapping Servlet
 * information as defined by the{@link ServletDD}
 * 
 */
public class PortletEntityImpl implements PortletEntity {
	
    // Private Member Variables ------------------------------------------------
    
    /** The cached PortletDD retrieved from the portlet descriptor registry. */
    private PortletDefinition portletDefinition;
    
    // Constructor -------------------------------------------------------------
    
    public PortletEntityImpl(PortletDefinition portletDefinition) {
        this.portletDefinition = portletDefinition;
    }
    
    
    // PortletEntity Impl ------------------------------------------------------
    
    /**
     * Returns the portlet description. The return value cannot be NULL.
     * @return the portlet description.
     */
    public PortletDefinition getPortletDefinition() {
        return portletDefinition;
    }
}
