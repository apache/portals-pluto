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
package org.apache.pluto.descriptors.portlet10;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.om.ElementFactoryList;
import org.apache.pluto.om.portlet.Preference;
import org.apache.pluto.om.portlet.Preferences;

/**
 * Portlet persistent preference store. Used in: portlet <p>Java class for portlet-preferencesType complex type. <p>The
 * following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="portlet-preferencesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="preference" type="{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}preferenceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="preferences-validator" type="{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}preferences-validatorType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @version $Id$
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portlet-preferencesType", propOrder = { "preference", "preferencesValidator" })
public class PortletPreferencesType implements Preferences
{
    @XmlElement(name = "preference", type=PreferenceType.class)
    protected List<Preference> preference;
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
    
    public ElementFactoryList<Preference> getPortletPreferences()
    {
        if (preference == null || !(preference instanceof ElementFactoryList))
        {
            ElementFactoryList<Preference> lf = 
                new ElementFactoryList<Preference>( new ElementFactoryList.Factory<Preference>()
                {
                    public Class<? extends Preference> getElementClass()
                    {
                        return PreferenceType.class;
                    }

                    public Preference newElement()
                    {
                        return new PreferenceType();
                    }
                }); 
            if (preference != null)
            {
                lf.addAll(preference);
            }
            preference = lf;
        }
        return (ElementFactoryList<Preference>)preference;
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
