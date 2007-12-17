package org.apache.pluto.descriptors.portlet;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listener", propOrder = {
    "description",
    "displayName",
    "listenerClass"
})
public class ListenerDD {

	/**
	 * Descripton of the listener
	 */
	private String description;
	
	/**
	 * display name
	 */
	@XmlElement ( name = "display-name")
	private List<String> displayName;	
	
	/**
	 * Java-Type of the Event
	 */
	@XmlElement(name = "listener-class")
	private String listenerClass;
	
	/**
	 * (optional) listener ID
	 */
	@XmlAttribute ( name = "id")
	private String iD;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getDisplayName() {
		return displayName;
	}

	public void setDisplayName(List<String> displayName) {
		this.displayName = displayName;
	}

	public String getID() {
		return iD;
	}

	public void setID(String id) {
		iD = id;
	}

	public String getListenerClass() {
		return listenerClass;
	}

	public void setListenerClass(String listenerClass) {
		this.listenerClass = listenerClass;
	}

	
	
}
