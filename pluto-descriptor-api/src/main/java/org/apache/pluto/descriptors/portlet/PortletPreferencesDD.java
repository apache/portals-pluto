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
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

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
public class PortletPreferencesDD {
	
	/** List of portlet preferences. */
	@XmlElement(name = "preference")
    private List<PortletPreferenceDD> portletPreferences = null;
	
	/** List of portlet preferences. */
	@XmlElement(name = "preference", namespace = PortletDD.QNAME_JSR168)
    private List<PortletPreferenceDD> portletPreferences1 = null;
    
    /** Portlet preferences validator class name. */
    @XmlElement(name = "preferences-validator")
    private String preferencesValidator;
    
    /** Portlet preferences validator class name. */
    @XmlElement(name = "preferences-validator", namespace = PortletDD.QNAME_JSR168)
    private String preferencesValidator1;

    public List<PortletPreferenceDD> getPortletPreferences() {
    	if (portletPreferences != null)
    		return portletPreferences;
    	return portletPreferences1;
    }

    public void setPortletPreferences(List<PortletPreferenceDD> portletPreferences) {
    	this.portletPreferences = portletPreferences;
    	this.portletPreferences1 = portletPreferences;
    }

    public String getPreferencesValidator() {
    	if (preferencesValidator != null)
    		return preferencesValidator;
    	return preferencesValidator1;
    }

    public void setPreferencesValidator(String preferencesValidator) {
    	this.preferencesValidator = preferencesValidator;
    	this.preferencesValidator1 = preferencesValidator;
    }
}
