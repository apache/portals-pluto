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

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

/**
 * Initialization Event Definitions
 * 
 * @author <a href="mailto:chrisra@cs.uni-jena.de">Christian Raschka</a>
 *
 * 
 * 			The event-definitionType is used to declare events the portlet can either
 * 			receive or emit.
 * 			The name must be unique and must be the one the 
 * 			portlet is using in its code for referencing this event.
 * 			Used in: portlet-app
 * 			
 * 
 * <p>Java class for event-definitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="event-definitionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}descriptionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *         &lt;element name="alias" type="{http://www.w3.org/2001/XMLSchema}QName" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="java-class" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}fully-qualified-classType" minOccurs="0"/>
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
@XmlType(name = "event-definitionType", propOrder = {
    "description",
    "name",
    "qname",
    "alias",
    "javaClass"
})
public class EventDefinitionDD {
	
	/**
	 * Descripton of the Event
	 */
	private String description;
	
	/**
	 * Name of the Event
	 * <choice>
	 * 		<element name="qname" type="xs:QName"/>
	 * 		<element name="name" type="string"/>
	 * </choice>
	 */
	private String name;
	private QName qname;	
	
	/**
	 * Java-Type of the Event
	 */
	@XmlElement(name = "value-type")
	private String javaClass;
	
	/**
	 * XML-Type of the Event
	 */
	@XmlTransient
	private String xmlType;
	
	/**
	 * Alias names of the Event
	 */
	@XmlElement ( name = "alias")
	private List<QName> alias;
	
	/**
	 * (optional) Event ID
	 */
	//@XmlElement(name = "id")
	@XmlAttribute ( name = "id")
	private String iD;

	/**
	 * @return Returns the alias.
	 */
	public List<QName> getAlias() {
		return alias;
	}

	/**
	 * @param alias The alias to set.
	 */
	public void setAlias(List<QName> alias) {
		this.alias = alias;
	}

	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return Returns the iD.
	 */
	public String getID() {
		return iD;
	}

	/**
	 * @param id The iD to set.
	 */
	public void setID(String id) {
		iD = id;
	}

	/**
	 * @return Returns the javaType.
	 */
	public String getJavaClass() {
		return javaClass.trim();
	}

	/**
	 * @param javaType The javaType to set.
	 */
	public void setJavaClass(String javaType) {
		this.javaClass = javaType;
	}

	/**
	 * @return Returns the name.
	 */
	public QName getName() {
		return (qname==null) ? new QName(name) : qname; 
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(QName qname) {
		this.qname = qname;
	}

	/**
	 * @return Returns the xmlType.
	 */
	public String getXmlType() {
		return xmlType.trim();
	}

	/**
	 * @param xmlType The xmlType to set.
	 */
	public void setXmlType(String xmlType) {
		this.xmlType = xmlType;
	}
}
