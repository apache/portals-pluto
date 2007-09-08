package org.apache.pluto.descriptors.portlet;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.descriptors.common.InitParamDD;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filterType", propOrder = {
    "description",
    "displayName",
    "filterName",
    "filterClass",
    "lifecycle",
    "initParam"
})
public class FilterDD {
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
	
	@XmlElement (name = "init-param")
	private List<InitParamDD> initParam = null;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFilterClass() {
		return filterClass;
	}

	public void setFilterClass(String filterClass) {
		this.filterClass = filterClass;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public List<InitParamDD> getInitParam() {
		return initParam;
	}

	public void setInitParam(List<InitParamDD> initParam) {
		this.initParam = initParam;
	}

	public List getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(List<String> lifecycle) {
		this.lifecycle = lifecycle;
	}
}
