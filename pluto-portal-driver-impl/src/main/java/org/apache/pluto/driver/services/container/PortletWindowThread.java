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
import java.util.List;

import javax.portlet.Event;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.EventContainer;
import org.apache.pluto.PortletWindow;

public class PortletWindowThread extends Thread {
	
	private EventProviderImpl eventProvider;
	
	private PortletWindow portletWindow;
	
	private EventContainer eventContainer;
	
	private List<Event> events = new ArrayList<Event>();

	public PortletWindowThread(ThreadGroup group, String name,
			EventProviderImpl eventProvider, PortletWindow window, EventContainer eventContainer) {
		super(group, name);
		this.eventProvider = eventProvider;
		this.portletWindow = window;
		this.eventContainer = eventContainer;		
	}

	public PortletWindowThread(String name, 
			EventProviderImpl eventProvider, PortletWindow window, EventContainer eventContainer) {
		super(name);
		this.eventProvider = eventProvider;
		this.portletWindow = window;
		this.eventContainer = eventContainer;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		super.run();
		while (events.size() > 0) {
			HttpServletRequest req = eventProvider.getRequest();
			HttpServletResponse res = eventProvider.getResponse();
			try {
				synchronized (this) {
					eventContainer.fireEvent(req, res, portletWindow, events.get(0).getName(),
							eventProvider.getSavedEvents().getNumber(events.get(0)));
					//wait();
					Thread.sleep(1);
					events.remove(0);				
				}
			} catch (InterruptedException e){
				System.out.println();
				System.out.println("============interupted exception===============");
				e.printStackTrace();
			} catch (PortletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

	public void addEvent(Event event) {
		this.events.add(event);	
	}

}
