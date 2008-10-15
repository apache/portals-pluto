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
package org.apache.pluto.descriptors.portlet20;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
    @XmlElement(name = "preference", type=PreferenceType.class)
    protected List<Preference> preference;
    @XmlElement(name = "preferences-validator")
    protected String preferencesValidator;
    @XmlAttribute
    protected String id;

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

    public String getId()
    {
        return id;
    }

    public void setId(String value)
    {
        id = value;
    }
}
