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
package org.apache.pluto.container.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PreferencesValidator;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.PortletPreference;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.PortletPreferencesService;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.util.StringManager;

/**
 * Implementation of the <code>javax.portlet.PortletPreferences</code>
 * interface.
 * 
 * @see PortletPreferences
 * @see PortletPreferenceImpl
 */
public class PortletPreferencesImpl implements PortletPreferences {
	
	/** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PortletPreferencesImpl.class);
    
    private static final StringManager EXCEPTIONS = StringManager.getManager(
    		PortletPreferencesImpl.class.getPackage().getName());
    
    
    // Private Member Variables ------------------------------------------------
    
    /** The portlet preferences service provided by the portal. */
    private PortletPreferencesService preferencesService;

    private PortletWindow window;

    private PortletRequest request;
    
    /**
     * Default portlet preferences retrieved from portlet.xml, and used for
     * resetting portlet preferences.
     */
    private Map<String,PortletPreference> defaultPreferences;
    
    /**
     * Current portlet preferences: key is the preference name as a string,
     * value is the PortletPreference instance.
     */
    private final Map<String, PortletPreference> preferences = new HashMap<String, PortletPreference>();

    // Constructor -------------------------------------------------------------
    
    /**
     * Constructs an instance.
     * @param container  the portlet container.
     * @param window  the internal portlet window.
     * @param request  the internal portlet request.
     */
    public PortletPreferencesImpl(PortletContainer container,
                                  PortletWindow window,
                                  PortletRequest request)
    {
        this.window = window;
        this.request = request;
        
        // Get the portlet preferences service from container.
        preferencesService = container.getContainerServices()
        		.getPortletPreferencesService();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Using PortletPreferencesService: "
            		+ preferencesService.getClass().getName());
        }
        
        try {
            // Put default portlet preferences into preferences map.
            defaultPreferences = preferencesService.getDefaultPreferences(window, request);
            if (defaultPreferences != null) {
                for (PortletPreference p : defaultPreferences.values()) {
                    preferences.put(p.getName(), p.clone());
                }
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("Loaded default preferences: " + toString());
            }
            
            // Merge stored portlet preferences into preferences map.
            
            Map<String,PortletPreference> storedPreferences = preferencesService
            		.getStoredPreferences(window, request);
            preferences.putAll(storedPreferences);
        	
        } catch (PortletContainerException ex) {
            LOG.error("Error retrieving preferences.", ex);
            //TODO: Rethrow up the stack????
        }
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Merged stored preferences: " + toString());
        }
    }
    
    
    // PortletPreferences Impl -------------------------------------------------
    
    public boolean isReadOnly(String key) {
        if (key == null) {
            throw new IllegalArgumentException(
            		EXCEPTIONS.getString("error.null", "Preference key "));
        }
        PortletPreference pref = preferences.get(key);
        return (pref != null && pref.isReadOnly());
    }

    public String getValue(String key, String defaultValue) {
        String[] values = getValues(key, new String[] { defaultValue });
        String value = null;
        if (values != null && values.length > 0) {
        	value = values[0];
        }
        if (value == null) {
        	value = defaultValue;
        }
        return value;
    }

    public String[] getValues(String key, String[] defaultValues) {
        if (key == null) {
            throw new IllegalArgumentException(
            		EXCEPTIONS.getString("error.null", "Preference key "));
        }
        String[] values = null;
        PortletPreference pref = preferences.get(key);
        if (pref != null) {
            values = pref.getValues();
        }
        if (values == null) {
            values = defaultValues;
        }
        return values;
    }

    public void setValue(String key, String value) throws ReadOnlyException {
        if (isReadOnly(key)) {
            throw new ReadOnlyException(EXCEPTIONS.getString(
            		"error.preference.readonly", key));
        }
        PortletPreference pref = preferences.get(key);
        if (pref != null) {
            pref.setValues(new String[] { value });
        } else {
            pref = new PortletPreferenceImpl(key, new String[] { value });
            preferences.put(key, pref);
        }
    }

    public void setValues(String key, String[] values) throws ReadOnlyException {
        if (isReadOnly(key)) {
            throw new ReadOnlyException(EXCEPTIONS.getString(
            		"error.preference.readonly", key));
        }
        PortletPreference pref = preferences.get(key);
        if (pref != null) {
            pref.setValues(values);
        } else {
            pref = new PortletPreferenceImpl(key, values);
            preferences.put(key, pref);
        }
    }

    public Enumeration<String> getNames() {
        return new Vector<String>(preferences.keySet()).elements();
    }

    public Map<String,String[]> getMap() {
        Map<String,String[]> map = new HashMap<String,String[]>();
        for (PortletPreference pref : preferences.values()) {
            map.put(pref.getName(),
                    pref.getValues() != null ? pref.getValues().clone() : null);
        }
        return Collections.unmodifiableMap(map);
    }
    
    public void reset(String key) throws ReadOnlyException {
    	// Read-only preferences cannot be reset.
        if (isReadOnly(key)) {
            throw new ReadOnlyException(EXCEPTIONS.getString(
            		"error.preference.readonly", key));
        }
        // Try to reset preference to the default values.
        PortletPreference p = defaultPreferences.get(key);
        if (p != null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Resetting preference for key: " + key);
            }
            preferences.put(key,p.clone());
        }       
        // Remove preference if default values are not defined (PLT.14.1).
        else {
        	if (LOG.isDebugEnabled()) {
        		LOG.debug("Resetting preference to null for key: " + key);
        	}
        	preferences.remove(key);
        }
    }
    
    /**
     * Stores the portlet preferences to a persistent storage. This method
     * should only be invoked within <code>processAction()</code> method.
     * 
     * @see #internalStore()
     * 
     * @throws IllegalStateException  if this method is not invoked within
     *         <code>processAction()</code> method.
     * @throws ValidatorException  if the portlet preferences are not valid.
     * @throws IOException  if an error occurs with the persistence mechanism.
     */
    public void store() throws IOException, ValidatorException {
        if (PortletRequest.RENDER_PHASE.equals(request.getAttribute(PortletRequest.LIFECYCLE_PHASE))) {
            throw new IllegalStateException(
                	"store is not allowed during RENDER phase.");
        }
        internalStore();
    }
    
    
    // Private Methods ---------------------------------------------------------
    
    /**
     * Stores the portlet preferences to a persistent storage. If a preferences
     * validator is defined for this portlet, this method firstly validates the
     * portlet preferences.
     * <p>
     * This method is invoked internally, thus it does not check the portlet
     * request method ID (METHOD_RENDER or METHOD_ACTION).
     * </p>
     * @throws ValidatorException  if the portlet preferences are not valid.
     * @throws IOException  if an error occurs with the persistence mechanism.
     */
    protected final void internalStore() throws IOException, ValidatorException {
        // Validate the preferences before storing, if a validator is defined.
        //   If the preferences cannot pass the validation,
        //   an ValidatorException will be thrown out.
        PortletDefinition portletD = window.getPortletDefinition();
        PreferencesValidator validator = preferencesService.getPreferencesValidator(portletD);
        if (validator != null)
        {
            validator.validate(this);
        }
        // Store the portlet preferences.
        try {
        	preferencesService.store(window, request, preferences);
        } catch (PortletContainerException ex) {
            LOG.error("Error storing preferences.", ex);
            throw new IOException("Error storing perferences: " + ex.getMessage());
        }
    }
    
    
    // Object Methods ----------------------------------------------------------
    
    /**
     * Returns the string representation of this object. Preferences are
     * separated by ';' character, while values in one preference are separated
     * by ',' character.
     * @return the string representation of this object.
     * @see java.lang.Object#toString()
     */
    public String toString() {
    	StringBuffer buffer = new StringBuffer();    	
    	buffer.append(getClass().getName()).append("[");
    	for (PortletPreference p : preferences.values()) {
            buffer.append(p.getName());
            buffer.append("(readOnly:").append(p.isReadOnly()).append(")=");
            String[] values = p.getValues();
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    buffer.append(values[i]);
                    if (i < values.length - 1) {
                        buffer.append(",");
                    }
                }
            } else {
                buffer.append("NULL");
            }
            buffer.append(";");
    	}
    	buffer.append("]");
    	return buffer.toString();
    }
}
