package org.apache.pluto.descriptors.portlet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "custom-portlet-modeType", propOrder = {
    "description","description1",
    "portletMode","portletMode1",
    "portalManaged",
    "decorationName"
})
public class CustomPortletModeDD {
	
	@XmlElement(name = "description")
	private String description = null;
	
	@XmlElement(name = "description", namespace = PortletDD.QNAME_JSR168)
	private String description1 = null;
	
	@XmlElement(name = "portlet-mode")
	private String portletMode = null;
	
	@XmlElement(name = "portlet-mode", namespace = PortletDD.QNAME_JSR168)
	private String portletMode1 = null;
	
	@XmlElement(name = "portal-managed")
	private String portalManaged = null;
	
	@XmlElement(name = "decoration-name")
	private String decorationName = null;
	
	public boolean isPortalManaged(){
		return portalManaged.equals("true")?true:false;
	}

	public String getDecorationName() {
		return decorationName;
	}

	public void setDecorationName(String decorationName) {
		this.decorationName = decorationName;
	}

	public String getDescription() {
		if (description != null)
			return description;
		return description1;
	}

	public void setDescription(String description) {
		this.description = description;
		this.description1 = description;
	}

	public String getPortletMode() {
		if (portletMode != null)
			return portletMode;
		return portletMode1;
	}

	public void setPortletMode(String portletMode) {
		this.portletMode = portletMode;
		this.portletMode1 = portletMode;
	}
}
