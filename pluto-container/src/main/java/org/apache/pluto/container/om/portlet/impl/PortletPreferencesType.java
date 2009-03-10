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
package org.apache.pluto.container.om.portlet.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.container.om.portlet.Preference;
import org.apache.pluto.container.om.portlet.Preferences;

/**
 * Portlet persistent preference store. Used in: portlet <p>Java class for portlet-preferencesType complex type. <p>The
 * following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;portlet-preferencesType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;preference&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}preferenceType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;preferences-validator&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}preferences-validatorType&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name=&quot;id&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}string&quot; /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * @version $Id$
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portlet-preferencesType", propOrder = { "preference", "preferencesValidator" })
public class PortletPreferencesType implements Preferences
{
    @XmlElement(name = "preference")
    protected List<PreferenceType> preference;
    @XmlElement(name = "preferences-validator")
    protected String preferencesValidator;

    public Preference getPortletPreference(String name)
    {
        for (Preference p : getPortletPreferences())
        {
            if (p.getName().equals(name))
            {
                return p;
            }
        }
        return null;
    }
    
    public List<? extends Preference> getPortletPreferences()
    {
        if (preference == null)
        {
            preference = new ArrayList<PreferenceType>();
        }
        return preference;
    }
    
    public Preference addPreference(String name)
    {
        if (getPortletPreference(name) != null)
        {
            throw new IllegalArgumentException("Portlet preference with name: "+name+" already defined");
        }
        PreferenceType pref = new PreferenceType();
        pref.setName(name);
        preference.add(pref);
        return pref;        
    }
    
    public String getPreferencesValidator()
    {
        return preferencesValidator;
    }

    public void setPreferencesValidator(String value)
    {
        preferencesValidator = value;
    }
}
