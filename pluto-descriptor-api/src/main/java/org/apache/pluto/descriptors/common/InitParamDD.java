/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
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
package org.apache.pluto.descriptors.common;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.om.common.InitParam;
import org.apache.pluto.om.portlet.Portlet;

/**
 * Initialization Parameter configuration.
 *
 * @version $Id: InitParamDD.java 157038 2005-03-11 03:44:40Z ddewolf $
 * @since Feb 28, 2005
 *
 * 
 *                      The init-param element contains a name/value pair as an 
 *                      initialization param of the portlet
 *                      Used in:portlet
 *                      
 * 
 * <p>Java class for init-paramType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="init-paramType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}descriptionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="name" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}nameType"/>
 *         &lt;element name="value" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}valueType"/>
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
@XmlType(name = "init-paramType", propOrder = {
    "description", "description1",
    "paramName", "paramName1",
    "paramValue", "paramValue1",
    "descriptions", "descriptions1"
})
public class InitParamDD implements InitParam {
	
	/** The description of the parameter. */
	@XmlElement(name = "description")
    private String description;
	
	/** The description of the parameter. */
	@XmlElement(name = "description", namespace = Portlet.QNAME_JSR168)
    private String description1;

	/** The description list. */
	@XmlElement(name = "descriptions")
    private List<String> descriptions;
	
	/** The description list. */
	@XmlElement(name = "descriptions", namespace = Portlet.QNAME_JSR168)
    private List descriptions1;

	/** The name of the parameter. */
	@XmlElement(name = "name")
    private String paramName;
	
	/** The name of the parameter. */
	@XmlElement(name = "name", namespace = Portlet.QNAME_JSR168)
    private String paramName1;

    /** The value of the parameter. */
	@XmlElement(name = "value")
    private String paramValue;
	
	/** The value of the parameter. */
	@XmlElement(name = "value", namespace = Portlet.QNAME_JSR168)
    private String paramValue1;

    

    /**
     * Default Constructor.
     */
    public InitParamDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.InitParam#getParamName()
	 */
    public String getParamName() {
    	if (paramName!= null)
    		return paramName;
    	return paramName1;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.InitParam#setParamName(java.lang.String)
	 */
    public void setParamName(String paramName) {
    	this.paramName = paramName;
    	this.paramName1 = paramName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.InitParam#getParamValue()
	 */
    public String getParamValue() {
    	if (paramValue != null)
    		return paramValue;
    	return paramValue1;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.InitParam#setParamValue(java.lang.String)
	 */
    public void setParamValue(String paramValue) {
    	this.paramValue = paramValue;
    	this.paramValue1 = paramValue;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.InitParam#getDescription()
	 */
    public String getDescription() {
    	if (description != null)
    		return description;
    	return description1;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.InitParam#setDescription(java.lang.String)
	 */
    public void setDescription(String description) {
    	this.description = description;
    	this.description1 = description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.InitParam#getDescriptions()
	 */
    public List getDescriptions() {
    	if (descriptions != null)
    		return descriptions;
    	return descriptions1;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.InitParam#setDescriptions(java.util.List)
	 */
    public void setDescriptions(List<String> descriptions) {
    	this.descriptions = descriptions;
    	this.descriptions1 = descriptions;
    }
}

