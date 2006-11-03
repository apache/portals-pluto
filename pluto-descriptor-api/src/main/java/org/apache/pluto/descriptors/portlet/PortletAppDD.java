/*
 * Copyright 2005 The Apache Software Foundation
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
package org.apache.pluto.descriptors.portlet;

import java.util.ArrayList;
import java.util.List;

/**
 * Portlet Application Configuration.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version $Id: PortletAppDD.java 157475 2005-03-14 22:13:18Z ddewolf $
 * @since Mar 6, 2005
 */
public class PortletAppDD {

    /** The defined portlets within the system. */
    private List portlets = new ArrayList();

    /** The defined Portlet Events within the system. */
    private List<EventDefinitionDD> events = new ArrayList<EventDefinitionDD>();
    
    /** The defined Shared Render Parameter within the system. */
    private List<SharedRenderParamDD> render = new ArrayList<SharedRenderParamDD>();

    /**
     * Default Constructor.
     */
    public PortletAppDD() {
    }

    /**
     * Retrieve the portlets which exist within this application.
     * @return
     */
    public List getPortlets() {
        return portlets;
    }

    /**
     * Set the portlets that exist within this application.
     * @param portlets
     */
    public void setPortlets(List portlets) {
        this.portlets = portlets;
    }
    
    /**
	 * @return Returns the events.
	 */
	public List<EventDefinitionDD> getEvents() {
		return events;
	}

	/**
	 * @param events The events to set.
	 */
	public void setEvents(List<EventDefinitionDD> events) {
		this.events = events;
	}

	/**
	 * @return Returns the shared render parameter.
	 */
	public List<SharedRenderParamDD> getRender() {
		return render;
	}

	/**
	 * @param render The shared render parameter to set.
	 */
	public void setRender(List<SharedRenderParamDD> render) {
		this.render = render;
	}
}

