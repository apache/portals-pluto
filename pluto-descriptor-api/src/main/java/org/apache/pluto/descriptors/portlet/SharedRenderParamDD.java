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
