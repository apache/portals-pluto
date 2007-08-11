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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.descriptors.portlet.PortletDD;

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
    "paramValue", "paramValue1"
})
public class InitParamDD {
	
	/** The description of the parameter. */
	@XmlElement(name = "description")
    private String description;
	
	/** The description of the parameter. */
	@XmlElement(name = "description", namespace = PortletDD.QNAME_JSR168)
    private String description1;

    /** The name of the parameter. */
	@XmlElement(name = "name")
    private String paramName;
	
	/** The name of the parameter. */
	@XmlElement(name = "name", namespace = PortletDD.QNAME_JSR168)
    private String paramName1;

    /** The value of the parameter. */
	@XmlElement(name = "value")
    private String paramValue;
	
	/** The value of the parameter. */
	@XmlElement(name = "value", namespace = PortletDD.QNAME_JSR168)
    private String paramValue1;

    

    /**
     * Default Constructor.
     */
    public InitParamDD() {

    }

    /**
     * Retrieve the name of the parameter.
     * @return
     */
    public String getParamName() {
    	if (paramName!= null)
    		return paramName;
    	return paramName1;
    }

    /**
     * Set the name of the parameter.
     * @param paramName
     */
    public void setParamName(String paramName) {
    	this.paramName = paramName;
    	this.paramName1 = paramName;
    }

    /**
     * Get the name of the parameter.
     * @return
     */
    public String getParamValue() {
    	if (paramValue != null)
    		return paramValue;
    	return paramValue1;
    }

    /**
     * Set the value of the parameter.
     * @param paramValue
     */
    public void setParamValue(String paramValue) {
    	this.paramValue = paramValue;
    	this.paramValue1 = paramValue;
    }

    /**
     * Retrieve the description.
     * @return
     */
    public String getDescription() {
    	if (description != null)
    		return description;
    	return description1;
    }

    /**
     * Set the description of the parameter.
     * @param description
     */
    public void setDescription(String description) {
    	this.description = description;
    	this.description1 = description;
    }

}

