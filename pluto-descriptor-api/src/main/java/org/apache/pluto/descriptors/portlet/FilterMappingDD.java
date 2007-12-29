package org.apache.pluto.descriptors.portlet;

import java.util.ArrayList;
import java.util.List;

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
	private List<String> portletName = null;
	

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public List<String> getPortletName() {
		return portletName;
	}

	public void setPortletName(List<String> portletName) {
		this.portletName = portletName;
	}
}
