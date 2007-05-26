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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.portlet.Event;
import javax.portlet.PortletException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.Constants;
import org.apache.pluto.EventContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.core.PortletContainerImpl;
import org.apache.pluto.descriptors.portlet.EventDefinitionDD;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.core.PortletWindowImpl;
import org.apache.pluto.driver.services.portal.PortletApplicationConfig;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.impl.PortalURLParserImpl;
import org.apache.pluto.spi.EventProvider;

public class EventProviderImpl implements org.apache.pluto.spi.EventProvider {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(EventProviderImpl.class);

	private static final long WAITING_CYCLE = 100;
	
	private int eventNumber = 0;
    
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    ThreadGroup threadGroup = new ThreadGroup("FireEventThreads");
    
    /**
     * Map that contains our events. The key is a string with the name of the event. 
     * The value is a List with all associated PortletWindows.
     * FIXME: should be in another class
     */
    private static Map<String, List<String>> portalEvts = 
    	new HashMap<String, List<String>>(100);
    private static Map<String, EventDefinitionDD> portalEvtsDefs = 
    	new HashMap<String, EventDefinitionDD>(100);

    //private Map<Event,Boolean> savedEvents = new HashMap<Event,Boolean>();
    
    private EventList savedEvents = new EventList();
    
    //private Map<Event, List<String>> savedEventsAndPortlets = new HashMap<Event, List<String>>();
    
    private Map<PortletWindow,PortletWindowThread> portletWindowThreads = new HashMap<PortletWindow, PortletWindowThread>();
    	
    /**
     * factory method
     * gets the EventProvider out of the Request, or sets a new one
     * @param request The {@link HttpServletRequest} of the EventProvider
     * @param response The {@link HttpServletResponse} of the EventProvider
     * @return The corresponding EventProvierImpl instance
     */
    public static EventProviderImpl getEventProviderImpl(HttpServletRequest request,
    		HttpServletResponse response) {
    	EventProviderImpl event = (EventProviderImpl) request.getAttribute(Constants.PROVIDER);
    	if (event == null) {
    		event = new EventProviderImpl();
    		event.request = request;
    		event.response = response;
    		request.setAttribute(Constants.PROVIDER, event);
    	}
    	return event;
    }
    
    /**
     * factory method, for accessing the static elements without a
     * request / response
     * FIXME: bad idea 
     * @return The EventProvider for accessing the static elements
     */
    public static EventProvider getEventProviderImpl() {
		return new EventProviderImpl();
	}
   
    /**
     * c'tor
     */
    public EventProviderImpl(){
    	
    }
    
    /**
     * Register an event, which should be fired within that request
     * @param event
     * @throws {@link IOException} 
     * @throws {@link ServletException} 
     * @throws {@link PortletContainerException}
     * @throws {@link PortletException}
     */
    public void registerToFireEvent(Event event) 
    throws ServletException, IOException, PortletException, PortletContainerException {
    	savedEvents.addEvent(event, ++eventNumber);	
    }

	/**
	 * Get all Portlets, which are registered to this event
     * @param evtLabel	- the name of the event
     * @return String list of associated InternalPortletWindows
     */
    public List<String> getAllPortletNames(String evtLabel) {
    	return portalEvts.get(evtLabel);
    }
    
    /**
     * Bind an PortletWindow to an event and/or create a new event label.
     * If the event label isn't already in the portalEvts hashmap, add it.
     * 
     * 
     * @param evtLabel - the event we want to add
     * @param portletName - null or the pw to be associated with the event
     */
    public void registerEvent(String evtLabel, String portletName, EventDefinitionDD eventDefinitionDD) {
    	if (evtLabel == null)
    		return ;
    	
    	// check, if event by that name already exists 
    	if (portalEvts.containsKey(evtLabel)) {
    		if (portletName != null) {
    			// we don't want duplicate Portlet Window entries, so leave 'em out
    			if (!this.containsValue(portletName, portalEvts.get(evtLabel))){
    				portalEvts.get(evtLabel).add(portletName);
    			}
    			
    		}
    	}
    	
    	else {
    		List<String> list = new ArrayList<String>();
    		if (portletName != null) 
    			list.add(portletName);
    		portalEvts.put(evtLabel, list);
    		// add EventDefinition
        	portalEvtsDefs.put(evtLabel, eventDefinitionDD);
    	}
    }
    
    /**
     * 
     * @param evtLabel - creates a new event with an empty ArrayList
     */
    public void registerEvent(String evtLabel) {
    	if (evtLabel != null)
    		registerEvent(evtLabel, null, null);
    }
	
    /**
     * 
     * @param evtLabel - removes an event
     */
    public synchronized void removeEvent(String evtLabel) {
    	if (!portalEvts.containsKey(evtLabel)) 
    		return ;
    	
    	portalEvts.remove(evtLabel);
    }
    
    /**
     * 
     * @param pw - the InternalPortletWindow to be removed
     * @param evtLabelsList - pw is removed from the events listed herein or all events if evtLabelsList is null
     */
    public synchronized void removePortletName(String portletName, List<String> evtLabelsList) {
    	
    	// set up a list of events that are going to be looked up for the portlet window we want
    	// to remove OR just a list of all events
    	List<String> listOfEvtLabels = (evtLabelsList==null)?this.getAllEventLabelsList():evtLabelsList;
    	
    	// iterate through the elements of the evtLabelsList and remove the InternalPortletWindow if any
    	List<String> tmp;
    	for (String element : listOfEvtLabels) {
    		tmp = portalEvts.get(element);
    		if (this.containsValue(portletName, tmp))
    			tmp.remove(portletName);	
    	}
    }
    
    public synchronized void removePortletName(String portletName){
    	removePortletName(portletName,null);
    }

    /**
     * 
     * @return String enumeration containing all events
     */
    public Enumeration<String> getAllEventLabelsEnumeration () {
    	Vector<String> v = new Vector<String>();
    	
    	for (String element : portalEvts.keySet()) {
    		v.add(element);
    	}
    	return v.elements();
    }
    
    /**
     * 
     * @return String list containing all events
     */
    public List<String> getAllEventLabelsList () {
    	List<String> l = new ArrayList<String>();
    	
    	for (String element : portalEvts.keySet()) {
    		l.add(element);
    	}
   
    	return l;	
    }
    
    // private
    
    /**
     * returns if InternalPortletWindow pw is contained in the ArrayList l of PortletWindows
     */
    private boolean containsValue(String portletName, List<String> l) {
    	
    	for (String element : l)
    		if (element.equals(portletName))
    			return true;
    	
    	return false;
    }

	/**
	 * @return Returns the savedEvents.
	 */
	public List<Event> getAllSavedEvents() {
		return savedEvents.getEvents();
	}


	/**
	 * Fire all saved events
	 * Note, that the order isn't important @see PLT14.3.2 
	 * @param eventContainer The {@link PortletContainerImpl} to fire the events
	 */
	public void fireEvents(EventContainer eventContainer) {
		ServletContext servletContext = eventContainer.getServletContext();
		DriverConfiguration driverConfig = (DriverConfiguration) servletContext.getAttribute(
        		AttributeKeys.DRIVER_CONFIG);

		PortalURL portalURL = PortalURLParserImpl.getParser().parse(request);
		
		// for every event there is one extra event, thats why we need E*2+1
		while (savedEvents.hasMoreEvents() && savedEvents.getSize() < Constants.MAX_EVENTS_SIZE){ //* 2 + 1) {
			
			Event eActual = getArbitraryEvent();

        	List<String> portletNames = (eActual.getName() != null) ? portalEvts.get(eActual.getName().toString()) : null;
        	
        	Collection<PortletWindowConfig> portlets = getAllPortletsInPortal(driverConfig);
        	
        	// iterate all portlets in the portal        	
        	for (PortletWindowConfig config : portlets) {
        		PortletWindow window = new PortletWindowImpl(config, portalURL);
        		if (portletNames != null) {
        			for (String portlet : portletNames) {
        				if (portlet.equals(config.getId())){
        					
        					PortletWindowThread portletWindowThread = 
        						getPortletWindowThread(eventContainer, config, window);

        					portletWindowThread.addEvent(eActual);
 
        					portletWindowThread.start();
        				}
        			}
        		}
        	}
        	
        	this.savedEvents.setProcessed(eActual);
    		
		}
		waitForEventExecution();
	}

	/**
	 * gets the right PortletWindowThread or makes a new one,
	 * if theres none
	 * @param eventContainer
	 * @param config
	 * @param window
	 * @return
	 */
	private PortletWindowThread getPortletWindowThread(EventContainer eventContainer, PortletWindowConfig config, PortletWindow window) {
		PortletWindowThread portletWindowThread = portletWindowThreads.get(window);
		if (portletWindowThread == null){
			portletWindowThread = new PortletWindowThread(
					threadGroup,config.getId(),this, window, eventContainer);
			portletWindowThreads.put(window, portletWindowThread);
		}
		return portletWindowThread;
	}

	/**
	 * Wait for event execution.
	 */
	private void waitForEventExecution() {
		long counter = 0;
		while (threadGroup.activeCount()>0) {
			try {
				counter =+ WAITING_CYCLE;
				if (counter > 500) {
					threadGroup.stop();
				}
				Thread.sleep(WAITING_CYCLE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Gets all portlets in portal.
	 * 
	 * @param driverConfig the driver config
	 * 
	 * @return the all portlets in portal
	 */
	private Collection<PortletWindowConfig> getAllPortletsInPortal(DriverConfiguration driverConfig) {
		Collection<PortletWindowConfig> allPortlets = new ArrayList<PortletWindowConfig>();
		Iterator<PortletApplicationConfig> portletApps = driverConfig.getPortletApplications().iterator();
		while (portletApps.hasNext()){
			PortletApplicationConfig portletApp = portletApps.next();
			Collection<PortletWindowConfig> portlets = portletApp.getPortlets();
			allPortlets.addAll(portlets);
		}
		return allPortlets;
	}

	/**
	 * gets an arbitrary event, which is not processed yet.
	 * @return the arbitrary event
	 */
	private Event getArbitraryEvent() {
		Event eActual = null;
		for (Event event : this.savedEvents.getEvents()) {
			if (this.savedEvents.isNotProcessed(event)){
				eActual = event;
			}				
		}
		return eActual;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.spi.EventProvider#getEventDefinition(javax.xml.namespace.QName)
	 */
	public EventDefinitionDD getEventDefinition(QName qname) {
		return portalEvtsDefs.get(qname.toString());
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.spi.EventProvider#getEvent(java.lang.String, int)
	 */
	public Event getEvent(String eventName, int eventNumber) {
		return savedEvents.getEvent(eventName, eventNumber);
	}
	
	/**
	 * Gets the saved events.
	 * 
	 * @return the saved events
	 */
	public EventList getSavedEvents(){
		return savedEvents;
	}
}
