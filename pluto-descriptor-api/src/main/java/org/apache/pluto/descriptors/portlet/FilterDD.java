package org.apache.pluto.descriptors.portlet;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.descriptors.common.InitParamDD;
import org.apache.pluto.om.common.InitParam;
import org.apache.pluto.om.portlet.Filter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filterType", propOrder = {
    "description",
    "displayName",
    "filterName",
    "filterClass",
    "lifecycle",
    "initParam"
})
public class FilterDD implements Filter {
	@XmlElement (name="description")
	private String description = null;
	
	@XmlElement (name = "display-name")
	private String displayName = null;
	
	@XmlElement (name = "filter-name")
	private String filterName = null;
	
	@XmlElement (name = "filter-class")
	private String filterClass = null;
	
	@XmlElement (name = "lifecycle")
	private List<String> lifecycle = null;
	
	@XmlElement (name = "init-param", type=InitParamDD.class)
	private List<InitParam> initParam = null;

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Filter#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Filter#setDescription(java.lang.String)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Filter#getDisplayName()
	 */
	public String getDisplayName() {
		return displayName;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Filter#setDisplayName(java.lang.String)
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Filter#getFilterClass()
	 */
	public String getFilterClass() {
		return filterClass;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Filter#setFilterClass(java.lang.String)
	 */
	public void setFilterClass(String filterClass) {
		this.filterClass = filterClass;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Filter#getFilterName()
	 */
	public String getFilterName() {
		return filterName;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Filter#setFilterName(java.lang.String)
	 */
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Filter#getInitParam()
	 */
	public List<InitParam> getInitParam() {
		return initParam;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Filter#setInitParam(java.util.List)
	 */
	public void setInitParam(List<InitParam> initParam) {
		this.initParam = initParam;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Filter#getLifecycle()
	 */
	public List<String> getLifecycle() {
		return lifecycle;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Filter#setLifecycle(java.util.List)
	 */
	public void setLifecycle(List<String> lifecycle) {
		this.lifecycle = lifecycle;
	}
}
