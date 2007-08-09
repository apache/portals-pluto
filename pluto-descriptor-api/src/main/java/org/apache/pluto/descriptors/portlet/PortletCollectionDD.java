package org.apache.pluto.descriptors.portlet;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portlet-collectionType", propOrder = {
    "portletName","portletName1"
})
public class PortletCollectionDD {
	@XmlElement (name = "portlet-name")
	private List<String> portletName = null;
	
	@XmlElement (name = "portlet-name", namespace = PortletDD.QNAME_JSR168)
	private List<String> portletName1 = null;

	public List<String> getPortletName() {
		if (portletName != null)
			return portletName;
		return portletName1;
	}

	public void setPortletName(List<String> portletName) {
		this.portletName = portletName;
		this.portletName1 = portletName;
	}

}
