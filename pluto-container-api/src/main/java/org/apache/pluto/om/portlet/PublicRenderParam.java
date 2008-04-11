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

public interface PublicRenderParam {

	/**
	 * @return the description
	 */
	public abstract String getDescription();

	/**
	 * @param description The description to set
	 */
	public abstract void setDescription(String description);

	/**
	 * @return the ID
	 */
	public abstract String getIdentifier();

	/**
	 * @param id The ID to set
	 */
	public abstract void setIdentifier(String id);

	/**
	 * @return the name
	 */
	public abstract QName getName();

	/**
	 * @param name The name to set
	 */
	public abstract void setName(QName qname);

	/**
	 * @return Returns the alias.
	 */
	public abstract List<QName> getAlias();

	/**
	 * @param alias The alias to set.
	 */
	public abstract void setAlias(List<QName> alias);

}