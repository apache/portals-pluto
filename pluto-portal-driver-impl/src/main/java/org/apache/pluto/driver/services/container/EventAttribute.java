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

/**
 * The Class EventAttribute.
 * Stores the attributes for a given event.
 */
@Deprecated
public class EventAttribute {
	
	/** The event number. */
	private int eventNumber;
	
	/** The processed flag. */
	private boolean notProcessed;
	
	/**
	 * The Constructor.
	 * 
	 * @param eventNumber the event number
	 */
	public EventAttribute(int eventNumber) {
		super();
		this.eventNumber = eventNumber;
		notProcessed = true;
	}
	
	/**
	 * The Constructor.
	 * 
	 * @param processed the processed flag
	 * @param eventNumber the event number
	 */
	public EventAttribute(int eventNumber, boolean processed) {
		super();
		this.eventNumber = eventNumber;
		this.notProcessed = processed;
	}
	
	/**
	 * Gets the event number.
	 * 
	 * @return the eventNumber
	 */
	public int getEventNumber() {
		return eventNumber;
	}
	
	/**
	 * Sets the event number.
	 * 
	 * @param eventNumber the eventNumber to set
	 */
	public void setEventNumber(int eventNumber) {
		this.eventNumber = eventNumber;
	}
	
	/**
	 * Checks if is not processed.
	 * 
	 * @return the processed
	 */
	public boolean isNotProcessed() {
		return notProcessed;
	}
	
	/**
	 * Sets processed.
	 * 
	 * @param processed the processed to set
	 */
	public void setNotProcessed(boolean processed) {
		this.notProcessed = processed;
	}

}
