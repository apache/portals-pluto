/*
 * Copyright 2008 The Apache Software Foundation
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
package org.apache.pluto.om.portlet;

import java.util.List;

import javax.xml.namespace.QName;

public interface EventDefinition {

	/**
	 * @return Returns the alias.
	 */
	public abstract List<QName> getAlias();

	/**
	 * @param alias The alias to set.
	 */
	public abstract void setAlias(List<QName> alias);

	/**
	 * @return Returns the description.
	 */
	public abstract String getDescription();

	/**
	 * @param description The description to set.
	 */
	public abstract void setDescription(String description);

	/**
	 * @return Returns the iD.
	 */
	public abstract String getID();

	/**
	 * @param id The iD to set.
	 */
	public abstract void setID(String id);

	/**
	 * @return Returns the javaType.
	 */
	public abstract String getJavaClass();

	/**
	 * @param javaType The javaType to set.
	 */
	public abstract void setJavaClass(String javaType);

	/**
	 * @return Returns the qName.
	 */
	public abstract QName getQName();

	/**
	 * @param name The qName to set.
	 */
	public abstract void setQName(QName qname);

	/**
	 * @return Returns the name.
	 */
	public abstract String getName();

	/**
	 * @param name The qName to set.
	 */
	public abstract void setName(String name);

	/**
	 * @return Returns the xmlType.
	 */
	public abstract String getXmlType();

	/**
	 * @param xmlType The xmlType to set.
	 */
	public abstract void setXmlType(String xmlType);

}