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
package org.apache.pluto.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.internal.InternalPortletPreference;
import org.apache.pluto.internal.impl.PortletPreferenceImpl;
import org.apache.pluto.om.portlet.Portlet;
import org.apache.pluto.om.portlet.PortletPreference;
import org.apache.pluto.om.portlet.PortletPreferences;
import org.apache.pluto.spi.optional.PortletPreferencesService;

/**
 * Default implementation of the portlet preferences service. The portlet
 * preferences service is a singleton held by the pluto portlet container.
 *
 * @see javax.portlet.PortletPreferences
 * @see org.apache.pluto.internal.impl.PortletPreferencesImpl
 * @see javax.portlet.PortletPreferences
 *
 */
public class DefaultPortletPreferencesService
implements PortletPreferencesService {

	/** Logger. */
	private static final Log LOG = LogFactory.getLog(
			DefaultPortletPreferencesService.class);


	// Private Member Variables ------------------------------------------------

	/**
	 * The in-memory portlet preferences storage: key is the preference name as
	 * a string, value is an array of PortletPreference objects.
	 */
	private Map<String,Map<String,InternalPortletPreference>> storage = new HashMap<String,Map<String,InternalPortletPreference>>();


	// Constructor -------------------------------------------------------------

	/**
	 * Default no-arg constructor.
	 */
	public DefaultPortletPreferencesService() {
		// Do nothing.
	}


	// PortletPreferencesService Impl ------------------------------------------

    /**
     * Returns a map of default preferences for a PortletWindow. The default
     * preferences are retrieved from the portlet application descriptor.
     * <p>
     * Data retrieved from <code>portlet.xml</code> are injected into the domain
     * object <code>PortletPreference</code>. This method converts the domain
     * objects into <code>PortletPreference</code> objects.
     * </p>
     * <p>
     * Note that if no value is bound to a given preference key,
     * <code>PortletPreference.getValues()</code> will return an empty string
     * list, but the value array of <code>PortletPreference</code> should be set
     * to null (instead of an empty array).
     * </p>
     * <p>
     * This method never returns null, but the values held by PortletPreference
     * may be null.
     * </p>
     * @return the default preferences set
     * 
     * @see org.apache.pluto.descriptors.portlet.PortletPreferenceDD
     */
    public Map<String,InternalPortletPreference> getDefaultPreferences( PortletWindow portletWindow,
                                                              PortletRequest request )
      throws PortletContainerException {
        Map<String,InternalPortletPreference> preferences = null;
        Portlet portlet = portletWindow.getPortletEntity().getPortletDefinition();
        PortletPreferences prefs = portlet.getPortletPreferences();
        if (prefs != null && prefs.getPortletPreferences() != null) {
            preferences = new HashMap<String,InternalPortletPreference>(prefs.getPortletPreferences().size());
            for (PortletPreference pref : prefs.getPortletPreferences()) {
                String[] values = null;
                if (pref.getValues() != null && pref.getValues().size() > 0) {
                    values = pref.getValues().toArray(new String[pref.getValues().size()]);
                }
                preferences.put(pref.getName(), new PortletPreferenceImpl(pref.getName(), values, pref.isReadOnly()));
            }
        }
        return preferences;
    }

	/**
	 * Returns the stored portlet preferences map. The preferences managed by
	 * this service should be protected from being directly accessed, so this
	 * method returns a cloned copy of the stored preferences.
	 *
	 * @param portletWindow  the portlet window.
	 * @param request  the portlet request from which the remote user is retrieved.
	 * @return a copy of the stored portlet preferences map.
	 * @throws PortletContainerException
	 */
	public Map<String,InternalPortletPreference> getStoredPreferences(
			PortletWindow portletWindow,
			PortletRequest request)
	throws PortletContainerException {
        String key = getFormattedKey(portletWindow, request);
        Map<String,InternalPortletPreference> preferences = storage.get(key);
        if (preferences == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("No portlet preferences found for: " + key);
            }
            return Collections.emptyMap();
        } else {
        	if (LOG.isDebugEnabled()) {
        		LOG.debug("Got " + preferences.size() + " stored preferences.");
        	}
        	return clonePreferences(preferences);
        }
    }

	/**
	 * Stores the portlet preferences to the in-memory storage. This method
	 * should be invoked after the portlet preferences are validated by the
	 * preference validator (if defined).
	 * <p>
	 * The preferences managed by this service should be protected from being
	 * directly accessed, so this method clones the passed-in preferences map
	 * and saves it.
	 * </p>
	 *
	 * @see javax.portlet.PortletPreferences#store()
	 *
	 * @param portletWindow  the portlet window
	 * @param request  the portlet request from which the remote user is retrieved.
	 * @param preferences  the portlet preferences to store.
	 * @throws PortletContainerException
	 */
    public void store(PortletWindow portletWindow,
                      PortletRequest request,
                      Map<String,InternalPortletPreference> preferences)
    throws PortletContainerException {
        String key = getFormattedKey(portletWindow, request);
        storage.put(key, clonePreferences(preferences));
        if (LOG.isDebugEnabled()) {
            LOG.debug("Portlet preferences stored for: " + key);
        }
    }


    // Private Methods ---------------------------------------------------------

    /**
     * Formats the preference key for the portlet preference using specified
     * portlet window and remote user.
     * @param portletWindow  the portlet window.
     * @param request  the remote request.
     */
    private String getFormattedKey(PortletWindow portletWindow,
                                   PortletRequest request) {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("user=").append(request.getRemoteUser()).append(";");
    	buffer.append("portletName=").append(portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
    	return buffer.toString();
    }

    /**
     * Clones a PortletPreference map. This method performs a deep clone on
     * the passed-in portlet preferences map. Every PortletPreference object
     * in the map are cloned (via the <code>PortletPreference.clone()</code>
     * method) and injected into the new map.
     *
     * @param preferences  the portlet preferences map to clone.
     * @return a deep-cloned copy of the portlet preferences map.
     */
    private Map<String,InternalPortletPreference> clonePreferences(
    		Map <String,InternalPortletPreference> preferences) {
    	if (preferences == null) {
    		return null;
    	}
    	Map <String,InternalPortletPreference> copy =
    			new HashMap<String,InternalPortletPreference>(preferences.size());
    	for (InternalPortletPreference p : preferences.values()) {
    	    copy.put(p.getName(), p.clone());
    	}
    	return copy;
    }
}