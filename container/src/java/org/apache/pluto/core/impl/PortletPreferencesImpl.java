/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
/* 

 */

package org.apache.pluto.core.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PreferencesValidator;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

import org.apache.pluto.om.ControllerObjectAccess;
import org.apache.pluto.om.common.Preference;
import org.apache.pluto.om.common.PreferenceCtrl;
import org.apache.pluto.om.common.PreferenceSet;
import org.apache.pluto.om.common.PreferenceSetCtrl;
import org.apache.pluto.om.entity.PortletEntity;
import org.apache.pluto.om.entity.PortletEntityCtrl;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.portlet.PortletDefinitionCtrl;
import org.apache.pluto.util.Enumerator;


public class PortletPreferencesImpl implements PortletPreferences
{
    private List    preferenceSetList  = new LinkedList();
    private HashMap changedPreferences = new HashMap();
    private HashSet removedPreferences = new HashSet();


    // current method used for managing these preferences
    private Integer methodId = null;

    private PortletEntity portletEntity = null;
    private PortletDefinition portletDefinition = null;


    public PortletPreferencesImpl(Integer methodId, PortletEntity portletEntity)
    {
        this.methodId = methodId;

        this.portletEntity = portletEntity;
        this.portletDefinition = portletEntity.getPortletDefinition();

        // fill list of preference sets
        preferenceSetList.add(portletEntity.getPreferenceSet());
        preferenceSetList.add(portletDefinition.getPreferenceSet());

    }

    public PortletPreferencesImpl(Integer methodId, PortletDefinition portletDefinition)
    {
        this.methodId = methodId;

        this.portletDefinition = portletDefinition;     

        // fill list of preference sets
        preferenceSetList.add(portletDefinition.getPreferenceSet());
    }

    // javax.portlet.PortletPreferences implementation --------------------------------------------
    public boolean isReadOnly(String key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException("key == null");
        }

        // default is false
        boolean isReadOnly = false;

        // if managing the first layer of the preferences 
        // modifiable returns always true (for administration purposes)
        if (preferenceSetList.size() != 1)
        { // otherwise
            // iterate through all preferences
            Preference preference = null;
            ListIterator iter = preferenceSetList.listIterator();
            while ((preference == null) && (iter.hasNext()))
            {
                preference = ((PreferenceSet)iter.next()).get(key);
            }
            if (preference != null)
            {
                isReadOnly = preference.isReadOnly();
            }
        }
        return isReadOnly;
    }

    public String getValue(String key, String def)
    {
        if (key == null)
        {
            throw new IllegalArgumentException("key == null");
        }

        String[] defStr = new String[1];
        defStr[0] = def;

        String[] values = this.getValues(key, defStr);

        // null values are allowed
        if ((values == null) || (values.length==0))
        {
            return null;
        }

        return values[0];
    }

    public String[] getValues(String key, String[] def)
    {
        if (key == null)
        {
            throw new IllegalArgumentException("key == null");
        }

        // get modified preferences
        if (changedPreferences.containsKey(key))
        {
            return(String[]) changedPreferences.get(key);
        }

        // get all preference sets
        ListIterator iter = preferenceSetList.listIterator();

        // if removed preference do not look in first layer
        if (removedPreferences.contains(key))
        {
            iter.next();
        }

        // iterate through all preference sets
        Preference preference = null;
        while ((preference == null) && (iter.hasNext()))
        {
            preference = ((PreferenceSet)iter.next()).get(key);
        }

        if (preference == null || !preference.isValueSet())
        {
            // if preference not exists
            return def;
        }
        else
        { // if preference exists
            return this.getValuesFromPreference(preference);
        }
    }
    
    public void setValue(String key, String value) throws ReadOnlyException
    {
        if (key == null)
        {
            throw new IllegalArgumentException("key == null");
        }

        String[] values =  new String[1];
        values[0] = value;
        setValues(key, values);
    }

    public void setValues(String key, String[] values) throws ReadOnlyException
    {
        if (key == null)
        {
            throw new IllegalArgumentException("key == null");
        }

        if (isReadOnly(key))
        {
            throw new ReadOnlyException("Preference attribute called " + key + " may not be modified");
        }

        changedPreferences.put(key, values);
        removedPreferences.remove(key);

    }

    public Enumeration getNames()
    {
        HashSet keyset = new HashSet();
        ListIterator listIter = preferenceSetList.listIterator();
        Iterator changedIter = changedPreferences.keySet().iterator();
        Iterator removedIter = removedPreferences.iterator();

        // iterate through all modified preferences of first layer
        while (changedIter.hasNext())
        {
            keyset.add((String)changedIter.next());
        }

        // iterate through all existing preferences of first layer
        Iterator preferencesIter = ((PreferenceSet)listIter.next()).iterator();
        while (preferencesIter.hasNext())
        {
            String name = ((Preference)preferencesIter.next()).getName();
            keyset.add(name);
        }

        // iterate through all removed preferences of first layer      
        while (removedIter.hasNext())
        {
            keyset.remove((String)removedIter.next());
        }


        // iterate through all other preference sets
        while (listIter.hasNext())
        {
            preferencesIter = ((PreferenceSet)listIter.next()).iterator();

            // iterate through all preferences
            while (preferencesIter.hasNext())
            {
                String name = ((Preference)preferencesIter.next()).getName();
                keyset.add(name);
            }
        }


        return new Enumerator(keyset.iterator());

    }

    public Map getMap()
    {
        HashMap map = new HashMap();
        Enumeration enum = this.getNames();
        while (enum.hasMoreElements())
        {
            String name = (String)enum.nextElement();
            map.put(name, getValues(name,new String[]{"no value set"}));
        }

        return Collections.unmodifiableMap(map);
    }

    public void reset(String key) throws ReadOnlyException
    {
        if (key == null)
        {
            throw new IllegalArgumentException("key == null");
        }

        if (isReadOnly(key))
        {
            throw new ReadOnlyException("preference attribute called " + key + " may not be modified");
        }

        changedPreferences.remove(key);
        removedPreferences.add(key);
    }

    public void store() throws java.io.IOException,ValidatorException
    {
        // not allowed when called in render
        if (this.methodId.equals(org.apache.pluto.Constants.METHOD_RENDER))
        {
            throw new java.lang.IllegalStateException("store is only allowed inside a render call");
        }

        // validate preferences
        PreferencesValidator validator = portletDefinition.getPreferenceSet().getPreferencesValidator();
        if (validator != null)
        {
            validator.validate(this);
        }

        // transfer changes to the top preference set 
        PreferenceSet preferences = (PreferenceSet)preferenceSetList.get(0);
        PreferenceSetCtrl preferencesCtrl = (PreferenceSetCtrl)ControllerObjectAccess.get(preferences);

        // modified preferences
        Iterator iter = changedPreferences.keySet().iterator();
        while (iter.hasNext())
        {
            String key = (String) iter.next();
            String[] values = (String[])changedPreferences.get(key);

            // null values are allowed
            List newValues = null;
            if (values != null)
            {
                // convert values from string[] to collection
                newValues = new ArrayList(values.length);
                for (int i=0;i<values.length;i++)
                    newValues.add(values[i]);
            }

            // transfer changings
            Preference preference = preferences.get(key);
            if (preference != null)
            {
                // change preference
                PreferenceCtrl preferenceCtrl = (PreferenceCtrl)ControllerObjectAccess.get(preference);
                preferenceCtrl.setValues(newValues);
            }
            else
            {
                // add new preference
                preferencesCtrl.add(key, newValues); 
            }
        }
        changedPreferences.clear();

        // removed preferences
        iter = removedPreferences.iterator();
        while (iter.hasNext())
        {
            String key = (String) iter.next();
            preferencesCtrl.remove(key);
        }
        removedPreferences.clear();

        // store changes to the top preference set
        if (portletEntity != null)
        {
            PortletEntityCtrl portletEntityCtrl = (PortletEntityCtrl)ControllerObjectAccess.get(portletEntity);
            portletEntityCtrl.store();
        }
        else
        {
            PortletDefinitionCtrl portletDefinitionCtrl = (PortletDefinitionCtrl)ControllerObjectAccess.get(portletDefinition);
            portletDefinitionCtrl.store();
        }

    }
    // --------------------------------------------------------------------------------------------


    // internal methods ---------------------------------------------------------------------------
    private String[] getValuesFromPreference(Preference preference)
    {
        if (preference == null)
        {
            return null;
        }

        Iterator values = preference.getValues();

        // null values are allowed
        if (values == null)
        {
            return null;
        }

        if (!values.hasNext())
        {
            return new String[0];
        }

        // convert values from Iterator to string[]
        List newValues = new ArrayList();
        while (values.hasNext())
        {
            newValues.add(values.next());
        }

        return(String[])newValues.toArray(new String[newValues.size()]);
    }
    // --------------------------------------------------------------------------------------------
}
