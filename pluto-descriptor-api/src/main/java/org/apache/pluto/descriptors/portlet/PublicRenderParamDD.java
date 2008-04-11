/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.pluto.descriptors.portlet;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

import org.apache.pluto.om.portlet.PublicRenderParam;

/**
 * Initialization Event Definitions
 * 
 * @author <a href="mailto:dettborn@dettborn.minet.uni-jena.de">Torsten Dettborn</a>
 *
 *
 * 
 * 			The public-render-parameters defines a render parameter that is allowed to be public
 * 			with other portlets.
 * 			The identifier must be used for referencing this public render parameter in the portlet code.
 * 			Used in: portlet-app
 * 			
 * 
 * <p>Java class for public-render-parameterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * <complexType name="public-render-parameterType">
 *		&lt;annotation&gt;
 *			<documentation>
 *			The public-render-parameters defines a render parameter that is allowed to be public
 * 			and thus be shared with other portlets.
 *			The identifier must be used for referencing this public render parameter in the portlet code.
 *			Used in: portlet-app
 *			</documentation>
 *		&lt;/annotation&gt;
 * 		<sequence>
 *			<element name="description" type="portlet:descriptionType" minOccurs="0" maxOccurs="unbounded"/>
 *			<element name="identifier" type="string"/>
 *			<choice>
 *				<element name="qname" type="xs:QName"/>
 *				<element name="name" type="string"/>
 *			</choice>
 *		</sequence>
 *		<attribute name="id" type="string" use="optional"/>
 *	</complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "public-render-parameterType", propOrder = {
    "description",
    "identifier",
    "name","qname",
    "alias"
})

public class PublicRenderParamDD implements PublicRenderParam {
	
	/**
	 * Descripton of the public render Parameter
	 */
	private String description;
	
	/**
	 * Identifier
	 */
	private String identifier;
	
	/**
	 * Name of the public render parameter
	 */
	private QName qname;		
	private String name;
	
	/**
	 * Alias names of the public render parameter
	 */
	@XmlElement ( name = "alias")
	private List<QName> alias;

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PublicRenderParam#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PublicRenderParam#setDescription(java.lang.String)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PublicRenderParam#getIdentifier()
	 */
	public String getIdentifier() {
		return identifier;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PublicRenderParam#setIdentifier(java.lang.String)
	 */
	public void setIdentifier(String id) {
		identifier = id;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PublicRenderParam#getName()
	 */
	public QName getName() {
		return (qname==null) ? new QName(name) : qname; 
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PublicRenderParam#setName(javax.xml.namespace.QName)
	 */
	public void setName(QName qname) {
		this.qname = qname;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PublicRenderParam#getAlias()
	 */
	public List<QName> getAlias() {
		return alias;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PublicRenderParam#setAlias(java.util.List)
	 */
	public void setAlias(List<QName> alias) {
		this.alias = alias;
	}

}
