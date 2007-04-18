package org.apache.pluto.descriptors.portlet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "custom-window-stateType", propOrder = {
    "description","description1",
    "windowState","windowState1"
})
public class CustomWindowStateDD {
	
	@XmlElement(name = "description")
	private String description = null;
	
	@XmlElement(name = "description", namespace = PortletDD.QNAME_JSR168)
	private String description1 = null;
	
	@XmlElement(name = "window-state")
	private String windowState = null;

	@XmlElement(name = "window-state", namespace = PortletDD.QNAME_JSR168)
	private String windowState1 = null;
	
	public String getDescription() {
		if (description != null)
			return description;
		return description1;
	}

	public void setDescription(String description) {
		this.description = description;
		this.description1 = description;
	}

	public String getWindowState() {
		if (windowState != null)
			return windowState;
		return windowState1;
	}

	public void setWindowState(String windowState) {
		this.windowState = windowState;
		this.windowState1 = windowState;
	}

}
