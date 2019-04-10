/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */


package org.apache.pluto.container.om.portlet.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.apache.pluto.container.om.portlet.Preference;
import org.apache.pluto.container.om.portlet.Preferences;

/**
 * @author Scott Nicklous
 *
 */
public class PreferencesImpl implements Preferences {
   
   private final Map<String, Preference> prefs = new HashMap<String, Preference>();
   private String prefVal;
   private boolean isNullValidator = false;

   /**
    * Default constructor
    */
   public PreferencesImpl() {
   }
   
   /**
    * Copy constructor
    * @param pr
    */
   public PreferencesImpl(Preferences pr) {
      for (Preference pref : pr.getPortletPreferences()) {
         prefs.put(pref.getName(), new PreferenceImpl(pref));
      }
      prefVal = pr.getPreferencesValidator();
      isNullValidator = pr.isNullValidator();
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Preferences#getPortletPreference(java.lang.String)
    */
   @Override
   public Preference getPortletPreference(String name) {
      Preference pref = (prefs.get(name) == null) ? 
            null : new PreferenceImpl(prefs.get(name));
      return pref;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Preferences#getPortletPreferences()
    */
   @Override
   public List<Preference> getPortletPreferences() {
      ArrayList<Preference> rPrefs = new ArrayList<Preference>();
      for (Preference pref : prefs.values()) {
         rPrefs.add(new PreferenceImpl(pref));
      }
      return rPrefs;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Preferences#addPreference(org.apache.pluto.container.om.portlet.Preference)
    */
   @Override
   public void addPreference(Preference pref) {
      prefs.put(pref.getName(), new PreferenceImpl(pref));
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Preferences#getPreferencesValidator()
    */
   @Override
   public String getPreferencesValidator() {
      return prefVal;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Preferences#setPreferencesValidator(java.lang.String)
    */
   @Override
   public void setPreferencesValidator(String preferencesValidator) {
      prefVal = preferencesValidator;
   }

   /**
    * @return the isNullValidator
    */
   @Override
   public boolean isNullValidator() {
      return isNullValidator;
   }

   /**
    * @param isNullValidator the isNullValidator to set
    */
   @Override
   public void setNullValidator(boolean isNullValidator) {
      this.isNullValidator = isNullValidator;
   }

}
