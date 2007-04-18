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
package org.apache.pluto.descriptors.portlet;

import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Portlet preference definition in portlet.xml.
 * 
 * @see PortletPreferencesDD
 * 
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @since Jun 29, 2005
 *
 * 
 * 			Persistent preference values that may be used for customization 
 * 			and personalization by the portlet.
 * 			Used in: portlet-preferences
 * 			
 * 
 * <p>Java class for preferenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="preferenceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}nameType"/>
 *         &lt;element name="value" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}valueType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="read-only" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}read-onlyType" minOccurs="0"/>
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
@XmlType(name = "preferenceType", propOrder = {
    "name","name1",
    "values","values1",
    "readOnly","readOnly1"
})
public class PortletPreferenceDD {
	
	/** The preference name. */
	@XmlElement(name = "name")
    private String name = null;
    
    /** The preference name. */
	@XmlElement(name = "name", namespace = PortletDD.QNAME_JSR168)
    private String name1 = null;
    
    /** The preference values. */
    @XmlElement(name = "value")
    private List<String> values = null;
    
    /** The preference values. */
    @XmlElement(name = "value", namespace = PortletDD.QNAME_JSR168)
    private List<String> values1 = null;
    
    /** Flag indicating if this preference is marked as read-only. */
    @XmlElement(name = "read-only")
    private boolean readOnly = false;
    
    /** Flag indicating if this preference is marked as read-only. */
    @XmlElement(name = "read-only", namespace = PortletDD.QNAME_JSR168)
    private boolean readOnly1 = false;
    
    
    // Public Methods ----------------------------------------------------------
    
    public String getName() {
    	if (name != null)
    		return name;
    	return name1;
    }

    public void setName(String name) {
    	this.name = name;
    	this.name1 = name;
    }

    public List<String> getValues() {
    	if (values != null)
    		return values;
    	return values1;
    }
    
    public void setValues(List<String> values) {
    	this.values = values;
    	this.values1 = values;
    }
    
    public boolean isReadOnly() {
    	return readOnly || readOnly1;
    }
    
    public void setReadOnly(boolean readOnly) {
    	this.readOnly = readOnly;
    	this.readOnly1 = readOnly;
    }
    
}
