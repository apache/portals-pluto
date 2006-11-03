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

import org.apache.pluto.EventContainer;
import org.apache.pluto.PortletContainerException;

	/**
	 * 
	 * @author <a href="mailto:ferdy@informatik.uni-jena.de">Fred Thiele</a>
	 * @author <a href="mailto:chrisra@cs.uni-jena.de">Christian Raschka</a>
	 * 
	 */

public interface EventProvider {

	/**
	 * 
	 * @param request
	 * @param response
	 * @param event
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
	public abstract List<String> getAllPortletNames(String evtLabel);

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
	 */
	public abstract void registerEvent(String evtLabel, String portletName);

	/**
	 * 
	 * @param evtLabel -
	 *            creates a new event with an empty ArrayList
	 */
	public abstract void registerEvent(String evtLabel);

	/**
	 * 
	 * @param evtLabel -
	 *            removes an event
	 */
	public abstract void removeEvent(String evtLabel);

	/**
	 * 
	 * @param pw -
	 *            the InternalPortletWindow to be removed
	 * @param evtLabelsList -
	 *            pw is removed from the events listed herein or all events if
	 *            evtLabelsList is null
	 */
	public abstract void removePortletName(String portletName,
			List<String> evtLabelsList);

	public abstract void removePortletName(String portletName);

	/**
	 * 
	 * @return Enumeration containing all events
	 */
	public abstract Enumeration<String> getAllEventLabelsEnumeration();

	/**
	 * 
	 * @return ArrayList containing all events
	 */
	public abstract List<String> getAllEventLabelsList();

	public abstract List<Event> getAllSavedEvents();

	public abstract void fireEvents(EventContainer container);
}
