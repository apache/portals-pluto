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
package org.apache.pluto.driver.container;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PreferencesValidator;
import javax.portlet.ValidatorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.PortletPreference;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.PortletPreferencesService;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.impl.PortletPreferenceImpl;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.Preference;
import org.apache.pluto.container.om.portlet.Preferences;

/**
 * Default implementation of the portlet preferences service. The portlet
 * preferences service is a singleton held by the pluto portlet container.
 *
 * @see javax.portlet.PortletPreferences
 * @see org.apache.pluto.container.impl.PortletPreferencesImpl
 * @see javax.portlet.PortletPreferences
 *
 */
public class DefaultPortletPreferencesService
implements PortletPreferencesService {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(
			DefaultPortletPreferencesService.class);


	// Private Member Variables ------------------------------------------------

	/**
	 * The in-memory portlet preferences storage: key is the preference name as
	 * a string, value is an array of PortletPreference objects.
	 */
	private Map<String,Map<String,PortletPreference>> storage = new HashMap<String,Map<String,PortletPreference>>();

   /**
     * The preferences validator cache: key is the portlet definition, value is
     * the portlet preferences validator instance.
     */
    private Map<PortletDefinition, PreferencesValidator> cache = new HashMap<PortletDefinition, PreferencesValidator>();


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
     * @see org.apache.pluto.container.om.portlet.impl.PreferenceType
     */
    public Map<String,PortletPreference> getDefaultPreferences( PortletWindow portletWindow,
                                                              PortletRequest request )
      throws PortletContainerException {
        Map<String,PortletPreference> preferences = null;
        PortletDefinition portlet = portletWindow.getPortletDefinition();
        Preferences prefs = portlet.getPortletPreferences();
        if (prefs != null && prefs.getPortletPreferences() != null) {
            preferences = new HashMap<String,PortletPreference>(prefs.getPortletPreferences().size());
            for (Preference pref : prefs.getPortletPreferences()) {
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
	public Map<String,PortletPreference> getStoredPreferences(
			PortletWindow portletWindow,
			PortletRequest request)
	throws PortletContainerException {
        String key = getFormattedKey(portletWindow, request);
        Map<String,PortletPreference> preferences = storage.get(key);
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
                      Map<String,PortletPreference> preferences)
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
    	buffer.append("portletName=").append(portletWindow.getPortletDefinition().getPortletName());
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
    private Map<String,PortletPreference> clonePreferences(
    		Map <String,PortletPreference> preferences) {
    	if (preferences == null) {
    		return null;
    	}
    	Map <String,PortletPreference> copy =
    			new HashMap<String,PortletPreference>(preferences.size());
    	for (PortletPreference p : preferences.values()) {
    	    copy.put(p.getName(), p.clone());
    	}
    	return copy;
    }
    
    public PreferencesValidator getPreferencesValidator(PortletDefinition portletDD)
    throws ValidatorException {

        // Try to retrieve the validator from cache.
        PreferencesValidator validator = cache.get(portletDD);
        if (validator != null) {
            return validator;
        }

        // Try to construct the validator instance for the portlet definition.
        Preferences portletPreferencesDD = portletDD.getPortletPreferences();
        
        if (portletPreferencesDD != null) {
            String className = portletPreferencesDD.getPreferencesValidator();
            if (className != null) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Creating preferences validator: " + className);
                }
                ClassLoader loader = Thread.currentThread().getContextClassLoader();
                try {
                    Class<?> clazz = loader.loadClass(className);
                    validator = (PreferencesValidator) clazz.newInstance();
                    cache.put(portletDD, validator);
                } catch (InstantiationException ex) {
                    LOG.error("Error instantiating validator.", ex);
                    throw new ValidatorException(ex, null);
                } catch (IllegalAccessException ex) {
                    LOG.error("Error instantiating validator.", ex);
                    throw new ValidatorException(ex, null);
                } catch (ClassNotFoundException ex) {
                    LOG.error("Error instantiating validator.", ex);
                    throw new ValidatorException(ex, null);
                } catch (ClassCastException ex) {
                    LOG.error("Error casting instance to PreferencesValidator.", ex);
                    throw new ValidatorException(ex, null);
                }
            }
        }
        return validator;
    }
    
}
