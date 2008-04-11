package org.apache.pluto.descriptors.portlet;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

import org.apache.pluto.om.portlet.Listener;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listener", propOrder = {
    "description",
    "displayName",
    "listenerClass"
})
public class ListenerDD implements Listener {

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

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Listener#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Listener#setDescription(java.lang.String)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Listener#getDisplayName()
	 */
	public List<String> getDisplayName() {
		return displayName;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Listener#setDisplayName(java.util.List)
	 */
	public void setDisplayName(List<String> displayName) {
		this.displayName = displayName;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Listener#getID()
	 */
	public String getID() {
		return iD;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Listener#setID(java.lang.String)
	 */
	public void setID(String id) {
		iD = id;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Listener#getListenerClass()
	 */
	public String getListenerClass() {
		return listenerClass;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Listener#setListenerClass(java.lang.String)
	 */
	public void setListenerClass(String listenerClass) {
		this.listenerClass = listenerClass;
	}

	
	
}
