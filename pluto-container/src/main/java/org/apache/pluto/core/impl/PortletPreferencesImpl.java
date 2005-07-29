/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
/* 

 */

package org.apache.pluto.core.impl;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.portlet.PortletPreferences;
import javax.portlet.PreferencesValidator;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

import org.apache.pluto.Constants;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.core.InternalPortletRequest;
import org.apache.pluto.core.InternalPortletWindow;
import org.apache.pluto.core.PortletPreference;
import org.apache.pluto.core.PortletEntity;
import org.apache.pluto.services.PortletPreferencesFactory;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;


public class PortletPreferencesImpl implements PortletPreferences {
    private static final Log LOG = LogFactory.getLog(PortletPreferencesImpl.class);

    private PortletPreferencesFactory factory;

    private InternalPortletWindow window;

    private InternalPortletRequest request;

    private Map preferences;


    // current method used for managing these preferences
    private Integer methodId = null;


    public PortletPreferencesImpl(PortletContainer container,
                                  InternalPortletWindow window,
                                  InternalPortletRequest request,
                                  Integer methodId) {
        this.factory =
        container.getContainerServices().getPortletPreferencesFactory();
        this.window = window;
        this.request = request;
        this.methodId = methodId;

        this.preferences = new java.util.HashMap();

        PortletEntity entity = window.getPortletEntity();
        PortletPreference[] prefs = entity.getDefaultPreferences();

        for (int i = 0; i < prefs.length; i++) {
            preferences.put(prefs[i].getName(), prefs[i]);
        }

        PortletPreferencesFactory factory
            = container.getContainerServices().getPortletPreferencesFactory();

        try {
            prefs = factory.getStoredPreferences(window, request);
        }
        catch(PortletContainerException pe) {
            LOG.error("Error retrieving preferences.", pe);
        }

        for (int i = 0; i < prefs.length; i++) {
            preferences.put(prefs[i].getName(), prefs[i]);
        }

    }

    public boolean isReadOnly(String key) {
        if (key == null) {
            throw new IllegalArgumentException("key == null");
        }

        PortletPreference pref = (PortletPreference) preferences.get(key);
        return pref == null ? true : pref.isReadOnly();
    }

    public String getValue(String key, String def) {
        if (key == null) {
            throw new IllegalArgumentException("key == null");
        }

        String[] value = null;

        PortletPreference pref = (PortletPreference) preferences.get(key);
        if (pref != null) {
            value = pref.getValues();
        } else {
            value = new String[]{def};
        }
        return value.length > 0 ? value[0] : null;
    }

    public String[] getValues(String key, String[] def) {
        if (key == null) {
            throw new IllegalArgumentException("key == null");
        }

        String[] values = null;
        PortletPreference pref = (PortletPreference) preferences.get(key);

        if (pref != null) {
            values = pref.getValues();
        } else {
            values = def;
        }
        return values;
    }

    public void setValue(String key, String value) throws ReadOnlyException {
        if (key == null) {
            throw new IllegalArgumentException("key == null");
        }

        PortletPreference pref = (PortletPreference) preferences.get(key);

        if (pref != null && pref.isReadOnly()) {
            throw new ReadOnlyException("Preference [" + key + "] is read only");
        } else if (pref != null) {
            pref.setValues(new String[]{value});
        } else {
            pref = new PortletPreferenceImpl(key, new String[]{value});
            preferences.put(key, pref);
        }
    }

    public void setValues(String key, String[] values)
        throws ReadOnlyException {
        if (key == null) {
            throw new IllegalArgumentException("key == null");
        }

        PortletPreference pref = (PortletPreference) preferences.get(key);

        if (pref != null && pref.isReadOnly()) {
            throw new ReadOnlyException("Preference [" + key + "] is read only");
        } else if (pref != null) {
            pref.setValues(values);
        } else {
            pref = new PortletPreferenceImpl(key, values);
            preferences.put(key, pref);
        }
    }

    public Enumeration getNames() {
        return new Vector(preferences.keySet()).elements();
    }

    public Map getMap() {
        Map map = new java.util.HashMap();
        Iterator it = preferences.keySet().iterator();
        while (it.hasNext()) {
            PortletPreference pref = (PortletPreference)preferences.get(it.next());
            map.put(pref.getName(), pref.getValues());
        }
        return Collections.unmodifiableMap(map);
    }

    public void reset(String key) throws ReadOnlyException {
        if (key == null) {
            throw new IllegalArgumentException("key == null");
        }

        PortletPreference pref = (PortletPreference) preferences.get(key);
        if (pref.isReadOnly()) {
            throw new ReadOnlyException(
                "preference attribute called " + key + " may not be modified");
        }

        // I think we should remove all preferences which are stored --
        // NOT reset them to how they were stored before!
        /*
        PortletPreference[] preferences = factory.getStoredPreferences(window, request);
        for(int i=0;i<preferences.length;i++) {
            preferences.put(preference.getName(), preference);
        }
         */

    }

    public void store() throws java.io.IOException, ValidatorException {
        // not allowed when not called in action
        if (!Constants.METHOD_ACTION.equals(methodId)) {
            throw new java.lang.IllegalStateException(
                "store is only allowed inside a processAction call");
        }

        String validatorClass =
            window.getPortletEntity()
                .getPortletDefinition()
                .getPortletPreferences()
                .getPreferencesValidator();

        if (validatorClass != null) {
            try {
                PreferencesValidator validator =
                    (PreferencesValidator) Class.forName(validatorClass).newInstance();
                validator.validate(this);
            } catch (InstantiationException e) {
                throw new ValidatorException(e, null);
            } catch (IllegalAccessException e) {
                throw new ValidatorException(e, null);
            } catch (ClassNotFoundException t) {
                throw new ValidatorException(t, null);
            }
        }

        PortletPreference[] pref =
            (PortletPreference[]) preferences.values().toArray(
                new PortletPreference[preferences.size()]);

        try {
            factory.store(window, request, pref);
        }
        catch(PortletContainerException pe) {
            LOG.error("Error storing preferences.", pe);
        }
    }
    // --------------------------------------------------------------------------------------------


}
