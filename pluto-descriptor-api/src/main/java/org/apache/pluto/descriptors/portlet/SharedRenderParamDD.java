/*
 * Copyright 2006 The Apache Software Foundation
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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Initialization Event Definitions
 * 
 * @author <a href="mailto:dettborn@dettborn.minet.uni-jena.de">Torsten Dettborn</a>
 *
 *
 * 
 * 			The shared-render-parameters defines a render parameter that is allowed to be shared
 * 			with other portlets.
 * 			The identifier must be used for referencing this shared render parameter in the portlet code.
 * 			Used in: portlet-app
 * 			
 * 
 * <p>Java class for shared-render-parameterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shared-render-parameterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}descriptionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}QName" maxOccurs="unbounded"/>
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
@XmlType(name = "shared-render-parameterType", propOrder = {
    "description",
    "identifier",
    "name"
})

public class SharedRenderParamDD {
	
	/**
	 * Descripton of the shared render Parameter
	 */
	private String description;
	
	/**
	 * Identifier
	 */
	private String identifier;
	
	/**
	 * Name of the shared render Parameter
	 */
	private String name;		

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description The description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the ID
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param id The ID to set
	 */
	public void setIdentifier(String id) {
		identifier = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
