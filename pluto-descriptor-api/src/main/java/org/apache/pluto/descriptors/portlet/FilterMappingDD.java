package org.apache.pluto.descriptors.portlet;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.om.portlet.FilterMapping;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filter-mappingType", propOrder = {
    "filterName",
    "portletName"
})
public class FilterMappingDD implements FilterMapping {
	@XmlElement (name = "filter-name")
	private String filterName = null;
	
	@XmlElement (name = "portlet-name")
	private List<String> portletName = null;
	

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.FilterMapping#getFilterName()
	 */
	public String getFilterName() {
		return filterName;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.FilterMapping#setFilterName(java.lang.String)
	 */
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.FilterMapping#getPortletName()
	 */
	public List<String> getPortletName() {
		return portletName;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.FilterMapping#setPortletName(java.util.List)
	 */
	public void setPortletName(List<String> portletName) {
		this.portletName = portletName;
	}
}
