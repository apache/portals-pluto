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
package org.apache.pluto.spi;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.Event;
import javax.portlet.PortletException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import org.apache.pluto.EventContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.descriptors.portlet.EventDefinitionDD;
import org.apache.pluto.descriptors.portlet.PortletAppDD;

	/**
	 * 
	 * @author <a href="mailto:ferdy@informatik.uni-jena.de">Fred Thiele</a>
	 * @author <a href="mailto:chrisra@cs.uni-jena.de">Christian Raschka</a>
	 * 
	 */

public interface EventProvider {

	/**
	 * 
	 * @param event
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws PortletException
	 * @throws PortletContainerException
	 */
	public abstract void registerToFireEvent(Event event)
			throws ServletException, IOException, PortletException,
			PortletContainerException;

	/**
	 * @param evtLabel -
	 *            the name of the event
	 * @return ArrayList of associated InternalPortletWindows
	 */
//	public abstract List<String> getAllPortletNames(String evtLabel);

	/**
	 * Bind an InternalPortletWindow to an event and/or create a new event
	 * label. If the event label isn't already in the portalEvts hashmap, add
	 * it.
	 * 
	 * 
	 * @param evtLabel -
	 *            the event we want to add
	 * @param portletName -
	 *            null or the pw to be associated with the event
	 * @param eventDefinitionDD TODO
	 */
//	public abstract void registerEvent(String evtLabel, String portletName, EventDefinitionDD eventDefinitionDD);

	/**
	 * 
	 * @param evtLabel -
	 *            creates a new event with an empty ArrayList
	 */
//	public abstract void registerEvent(String evtLabel);

	/**
	 * 
	 * @param evtLabel -
	 *            removes an event
	 */
//	public abstract void removeEvent(String evtLabel);

	/**
	 * 
	 * @param pw -
	 *            the InternalPortletWindow to be removed
	 * @param evtLabelsList -
	 *            pw is removed from the events listed herein or all events if
	 *            evtLabelsList is null
	 */
//	public abstract void removePortletName(String portletName,
//			List<String> evtLabelsList);

	/**
	 * Removes the portlet name.
	 * 
	 * @param portletName the portlet name
	 */
//	public abstract void removePortletName(String portletName);

	/**
	 * 
	 * @return Enumeration containing all events
	 */
//	public abstract Enumeration<String> getAllEventLabelsEnumeration();

	/**
	 * 
	 * @return String list containing all events
	 */
//	public abstract List<String> getAllEventLabelsList();

	/**
	 * Gets all saved events.
	 * 
	 * @return the saved events
	 */
//	public abstract List<Event> getAllSavedEvents();
	
	/**
	 * Gets the event.
	 * 
	 * @param eventName the event name
	 * @param eventNumber the event number
	 * 
	 * @return the event
	 */
//	public abstract Event getEvent(String eventName, int eventNumber);

	/**
	 * Fire events.
	 * 
	 * @param container the event container
	 */
	public abstract void fireEvents(EventContainer container);

	/**
	 * Gets the event definition from DD
	 * 
	 * @param qname the qname
	 * 
	 * @return the event definition
	 */
	public abstract EventDefinitionDD getEventDefinition(QName qname);
	
	/**
	 * Register event definition DD.
	 * 
	 * @param eventDefinitionDD the event definition DD
	 */
//	public abstract void registerEventDefinitionDD(EventDefinitionDD eventDefinitionDD);
	
	/**
	 * Gets the request.
	 * 
	 * @return the request
	 */
	public HttpServletRequest getRequest();
	
	/**
	 * Gets the response.
	 * 
	 * @return the response
	 */
	public HttpServletResponse getResponse();
	
	/**
	 * Gets the default event namespace.
	 * 
	 * @return the default event namespace
	 */
	public abstract String getDefaultEventNamespace(String portletName);
	
	/**
	 * Sets the default event namespace.
	 * 
	 * @return the string
	 */
//	public abstract void setDefaultEventNamespace(PortletAppDD portletAppDD);
}
