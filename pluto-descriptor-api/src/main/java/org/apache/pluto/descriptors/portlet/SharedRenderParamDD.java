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
 * Initialization Event Definitions
 * 
 * @author <a href="mailto:dettborn@dettborn.minet.uni-jena.de">Torsten Dettborn</a>
 *
 */

public class SharedRenderParamDD {
	/**
	 * Name of the shared render Parameter
	 */
	private String name;
	
	/**
	 * Descripton of the shared render Parameter
	 */
	private String description;
	
	/**
	 * Alias names of the shared render Parameter
	 */
	private List alias;
	
	/**
	 * (optional) Event ID
	 */
	private String iD;

	/**
	 * @return the alias
	 */
	public List getAlias() {
		return alias;
	}

	/**
	 * @param alias The alias to set
	 */
	public void setAlias(List alias) {
		this.alias = alias;
	}

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
	public String getID() {
		return iD;
	}

	/**
	 * @param id The ID to set
	 */
	public void setID(String id) {
		iD = id;
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
