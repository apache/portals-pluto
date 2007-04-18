package org.apache.pluto.descriptors.portlet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user-attributeType", propOrder = {
    "description","description1",
    "name","name1"
})
public class UserAttributeDD {
	
	@XmlElement(name = "description")
	private String description = null;
	
	@XmlElement(name = "description", namespace = PortletDD.QNAME_JSR168)
	private String description1 = null;
	
	@XmlElement ( name = "name")
	private String name = null;
	
	@XmlElement ( name = "name", namespace = PortletDD.QNAME_JSR168)
	private String name1 = null;

	public String getDescription() {
		if (description != null)
			return description;
		return description1;
	}

	public void setDescription(String description) {
		this.description = description;
		this.description1 = description;
	}

	public String getName() {
		if (name != null)
			return name;
		return name1;
	}

	public void setName(String name) {
		this.name = name;
		this.name1 = name;
	}
}
