/*
 * Copyright 2006 The Apache Software Foundation.
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
package org.apache.pluto;


import java.io.IOException;

import javax.portlet.Event;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The publicized entry point into Pluto for firing events
 * @author <a href="mailto:chrisra@cs.uni-jena.de">Christian Raschka</a>
 */
public interface EventContainer {
	
	/**
     * Indicates that an event should be fired in the current request and calls
     * the processEvent method of this portlet.
     * @param PortletWindow the portlet Window
     * @param request               the servlet request
     * @param response              the servlet response
	 * @param eventNumber 
     * @throws PortletException          if one portlet has trouble fulfilling
     *                                   the request
	 * @throws PortletContainerException 
     * @throws PortletContainerException if the portlet container implementation
     *                                   has trouble fulfilling the request
     */
	public void fireEvent(HttpServletRequest request, HttpServletResponse response, 
			PortletWindow window, Event event) throws PortletException, IOException, PortletContainerException;
}
