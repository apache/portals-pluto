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

package org.apache.pluto.driver.services.container;

import java.util.List;

import javax.portlet.BaseURL;
import javax.portlet.PortletURL;
import javax.portlet.PortletURLGenerationListener;
import javax.portlet.ResourceURL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.om.portlet.Listener;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.spi.PortletURLListener;

public class PortletURLListenerImpl implements PortletURLListener {
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(PortletURLListenerImpl.class);
	private static PortletURLListenerImpl portletURLListener = new PortletURLListenerImpl();
	
	public static PortletURLListener getPortletURLListener(){
		return portletURLListener;
	}
	
	
	public synchronized void callListener(PortletApplicationDefinition portletApp, BaseURL baseURL, boolean isAction, boolean isResource){
		if (isAction&&isResource){
			String message = "It is not allowed to set both values from isAction and isResource to true";
			LOG.error(message, new IllegalArgumentException(message));
		}
		//this list is needed for the classnames
		List<? extends Listener> portletURLFilterList = portletApp.getListeners();
		//Iterate over the classnames and for each entry in the list the filter..URL is called.
		if (portletURLFilterList != null){
			for (Listener listener : portletURLFilterList) {
				ClassLoader loader = Thread.currentThread().getContextClassLoader();
				Class clazz;
				try {
					clazz = loader.loadClass(listener.getListenerClass() );
					if (clazz != null){
						PortletURLGenerationListener portletURLGenerationListener = (PortletURLGenerationListener)clazz.newInstance();
						if (isAction)
							portletURLGenerationListener.filterActionURL((PortletURL)baseURL);
						else if (isResource)
							portletURLGenerationListener.filterResourceURL((ResourceURL)baseURL);
						else
							portletURLGenerationListener.filterRenderURL((PortletURL)baseURL);
					}
				} catch (ClassNotFoundException e) {
					String message = "The class isn't found.";
					LOG.error(message);
				} catch (InstantiationException e) {
					String message = "The instantiation fail.";
					LOG.error(message);
				} catch (IllegalAccessException e) {
					String message = "IllegalAccessException";
					LOG.error(message);
				}
			}
		}
	}
}
