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
package org.apache.pluto.descriptors.portlet;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.om.portlet.Portlet;
import org.apache.pluto.om.portlet.PortletPreference;
import org.apache.pluto.om.portlet.PortletPreferences;

/**
 * Portlet preferences definition in portlet.xml.
 *
 * @see PortletPreferenceDD
 * 
 * @since Jun 29, 2005
 *
 * 
 * 			Portlet persistent preference store.
 * 			Used in: portlet
 * 			
 * 
 * <p>Java class for portlet-preferencesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="portlet-preferencesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="preference" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}preferenceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="preferences-validator" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}preferences-validatorType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portlet-preferencesType", propOrder = {
    "portletPreferences","portletPreferences1",
    "preferencesValidator", "preferencesValidator1"
})
public class PortletPreferencesDD implements PortletPreferences {
	
	/** List of portlet preferences. */
	@XmlElement(name = "preference", type=PortletPreferenceDD.class)
    private List<PortletPreference> portletPreferences = null;
	
	/** List of portlet preferences. */
	@XmlElement(name = "preference", namespace = Portlet.QNAME_JSR168, type=PortletPreferenceDD.class)
    private List<PortletPreference> portletPreferences1 = null;
    
    /** Portlet preferences validator class name. */
    @XmlElement(name = "preferences-validator")
    private String preferencesValidator;
    
    /** Portlet preferences validator class name. */
    @XmlElement(name = "preferences-validator", namespace = Portlet.QNAME_JSR168)
    private String preferencesValidator1;

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletPreferences#getPortletPreferences()
	 */
    public List<PortletPreference> getPortletPreferences() {
    	if (portletPreferences != null)
    		return portletPreferences;
    	return portletPreferences1;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletPreferences#setPortletPreferences(java.util.List)
	 */
    public void setPortletPreferences(List<PortletPreference> portletPreferences) {
    	this.portletPreferences = portletPreferences;
    	this.portletPreferences1 = portletPreferences;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletPreferences#getPreferencesValidator()
	 */
    public String getPreferencesValidator() {
    	if (preferencesValidator != null)
    		return preferencesValidator;
    	return preferencesValidator1;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletPreferences#setPreferencesValidator(java.lang.String)
	 */
    public void setPreferencesValidator(String preferencesValidator) {
    	this.preferencesValidator = preferencesValidator;
    	this.preferencesValidator1 = preferencesValidator;
    }
}
