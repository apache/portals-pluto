package org.apache.pluto.descriptors.portlet;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user-data-constraintType", propOrder = {
		"description","description1",
		"transportGuarantee", "transportGuarantee1"
})
public class UserDataConstraintDD {
	@XmlElement(name = "description")
	private List<String> description = null;
	
	@XmlElement(name = "description", namespace = PortletDD.QNAME_JSR168)
	private List<String> description1 = null;
	
	@XmlElement(name = "transport-guarantee")
	private String transportGuarantee = null;
	
	@XmlElement(name = "transport-guarantee", namespace = PortletDD.QNAME_JSR168)
	private String transportGuarantee1 = null;
	
	public List<String> getDescription() {
		if (description != null)
			return description;
		return description1;
	}

	public void setDescription(List<String> description) {
		this.description = description;
		this.description1 = description;
	}

	public String getTransportGuarantee() {
		if (transportGuarantee != null)
			return transportGuarantee;
		return transportGuarantee1;
	}

	public void setTransportGuarantee(String transportGuarantee) {
		this.transportGuarantee = transportGuarantee;
		this.transportGuarantee1 = transportGuarantee;
	}
}
