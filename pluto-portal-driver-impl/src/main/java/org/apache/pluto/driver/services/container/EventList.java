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
package org.apache.pluto.driver.services.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.Event;

/**
 * The Class EventList.
 * Stores events in a list.
 */
public class EventList {
	
	/** The events. */
	private Map<Event,EventAttribute> events = new HashMap<Event, EventAttribute>();;
	
	/**
	 * Adds an event.
	 * 
	 * @param event the event
	 * @param eventNumber the event number
	 */
	public void addEvent(Event event, int eventNumber){
		events.put(event, new EventAttribute(eventNumber));
	}

	/**
	 * Gets the events.
	 * 
	 * @return the events
	 */
	public List<Event> getEvents() {
		List<Event> list = new ArrayList<Event>();
		for (Event event : events.keySet()) {
			list.add(event);
		}
		return list;
	}

	/**
	 * Checks if the event is not processed.
	 * 
	 * @param event the event
	 * 
	 * @return true, if is not processed
	 */
	public boolean isNotProcessed(Event event) {
		return events.get(event).isNotProcessed();
	}

	/**
	 * Checks for more events.
	 * 
	 * @return true, if has more events
	 */
	public boolean hasMoreEvents() {
		Collection<EventAttribute> attr = this.events.values();
		for (EventAttribute attribute : attr) {
			if (attribute.isNotProcessed())
				return true;
		}
		return false;
	}

	/**
	 * Sets the processed.
	 * 
	 * @param event the processed
	 */
	public void setProcessed(Event event) {
		EventAttribute attr = events.remove(event);
		attr.setNotProcessed(false);
		events.put(event, attr);
	}
	
	/**
	 * Gets the event.
	 * 
	 * @param eventName the event name
	 * @param eventNumber the event number
	 * 
	 * @return the event
	 */
	public Event getEvent(String eventName, int eventNumber){
		for (Event event : getEvents()) {
			if ((event.getName() != null) && (event.getName().toString().equals(eventName)))
				if (events.get(event).getEventNumber() == eventNumber)
					return event;
		}
		return null;
	}
	
	/**
	 * Gets the number.
	 * 
	 * @param event the event
	 * 
	 * @return the number
	 */
	public int getNumber(Event event){
		return events.get(event).getEventNumber();
	}
	
	/**
	 * Gets the size.
	 * 
	 * @return the size
	 */
	public int getSize() {
		return events.size();
	}

}
