package org.apache.pluto.descriptors.portlet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filter-mappingType", propOrder = {
    "filterName",
    "portletName"
})
public class FilterMappingDD {
	@XmlElement (name = "filter-name")
	private String filterName = null;
	
	@XmlElement (name = "portlet-name")
	private String portletName = null;

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public String getPortletName() {
		return portletName;
	}

	public void setPortletName(String portletName) {
		this.portletName = portletName;
	}

}
