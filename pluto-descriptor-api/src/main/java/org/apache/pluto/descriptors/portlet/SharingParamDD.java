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

/**
 * Initialization Session Sharing Attributes
 * 
 * @author <a href="mailto:chrisra@cs.uni-jena.de">Christian Raschka</a>
 *
 */

public class SharingParamDD {
	
	/**
	 * Name of the Session Sharing Attribute
	 */
	private String name;
	
	/**
	 * Descripton of the sharing attribute
	 */
	private String description;
	
	/**
	 * Type of the sharing attribute
	 */
	private String javaType;
	
	/**
	 * XML-Type of the sharing attribute
	 */
	private String xmlType;
	
	/**
	 * Alias names of the attributes
	 */
	private List alias;
	
	/**
	 * (optional) Param ID
	 */
	private String iD;
	
	

	public String getID() {
		return iD;
	}


	public void setID(String id) {
		iD = id;
	}


	/**
	 * Default Constructor
	 */
	public SharingParamDD() {
		
	}


	public String getJavaType() {
		return javaType;
	}


	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}


	public String getName() {
		return name;
	}


	public void setName(String sharingSharingAttribute) {
		this.name = sharingSharingAttribute;
	}
		
	public List getAlias() {
		return alias;
	}


	public void setAlias(List alias) {
		this.alias = alias;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getXmlType() {
		return xmlType;
	}


	public void setXmlType(String xmlType) {
		this.xmlType = xmlType;
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	//@Override
	public String toString() {
		String string;
		string = getName() + " (" + getDescription() + ") "
		  + getJavaType();
		return string;
	}
}
