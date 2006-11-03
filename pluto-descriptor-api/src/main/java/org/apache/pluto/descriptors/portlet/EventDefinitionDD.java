package org.apache.pluto.descriptors.portlet;

import java.util.List;

/**
 * Initialization Event Definitions
 * 
 * @author <a href="mailto:chrisra@cs.uni-jena.de">Christian Raschka</a>
 *
 */

public class EventDefinitionDD {
	
	/**
	 * Name of the Event
	 */
	private String name;
	
	/**
	 * Descripton of the Event
	 */
	private String description;
	
	/**
	 * Java-Type of the Event
	 */
	private String javaType;
	
	/**
	 * XML-Type of the Event
	 */
	private String xmlType;
	
	/**
	 * Alias names of the Event
	 */
	private List alias;
	
	/**
	 * (optional) Event ID
	 */
	private String iD;

	/**
	 * @return Returns the alias.
	 */
	public List getAlias() {
		return alias;
	}

	/**
	 * @param alias The alias to set.
	 */
	public void setAlias(List alias) {
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
	public String getJavaType() {
		return javaType;
	}

	/**
	 * @param javaType The javaType to set.
	 */
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the xmlType.
	 */
	public String getXmlType() {
		return xmlType;
	}

	/**
	 * @param xmlType The xmlType to set.
	 */
	public void setXmlType(String xmlType) {
		this.xmlType = xmlType;
	}
}
