/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.pluto.descriptors.portlet;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.om.portlet.CustomPortletMode;
import org.apache.pluto.om.portlet.CustomWindowState;
import org.apache.pluto.om.portlet.EventDefinition;
import org.apache.pluto.om.portlet.Filter;
import org.apache.pluto.om.portlet.FilterMapping;
import org.apache.pluto.om.portlet.Listener;
import org.apache.pluto.om.portlet.Portlet;
import org.apache.pluto.om.portlet.PortletApp;
import org.apache.pluto.om.portlet.PublicRenderParam;
import org.apache.pluto.om.portlet.SecurityConstraint;
import org.apache.pluto.om.portlet.UserAttribute;

/**
 * Portlet Application Configuration.
 *
 * @version $Id: PortletAppDD.java 157475 2005-03-14 22:13:18Z ddewolf $
 * @since Mar 6, 2005
 *
 *
 * <p>Java class for portlet-appType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="portlet-appType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="portlet" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}portletType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="custom-portlet-mode" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}custom-portlet-modeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="custom-window-state" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}custom-window-stateType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="user-attribute" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}user-attributeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="security-constraint" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}security-constraintType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="resource-bundle" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}resource-bundleType" minOccurs="0"/>
 *         &lt;element name="filter" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}filterType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="filter-mapping" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}filter-mappingType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="event-definition" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}event-definitionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="public-render-parameter" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}public-render-parameterType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portlet-appType", propOrder = {
    "portlets",    "portlets1",
    "customPortletMode","customPortletMode1",
    "customWindowState","customWindowState1",
    "userAttribute","userAttribute1",
    "securityConstraint","securityConstraint1",
    "resourceBundle","resourceBundle1",
    "defaultNamespace",
    "filter",
    "filterMapping",
    "listener",
    "events",
    "render",
    "containerRuntimeOption"
})
public class PortletAppDD implements PortletApp {

    private String contextPath;
    
    /** The defined portlets within the system. */
	@XmlElement(name = "portlet", type=PortletDD.class, namespace = "http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd")
    private List<Portlet> portlets = null;
	
	/** The defined portlets (jsr 168) within the system. */
	@XmlElement(name = "portlet", type=PortletDD.class, namespace = "http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd")
    private List<Portlet> portlets1 = null;
	
	@XmlElement(name = "custom-portlet-mode", type=CustomPortletModeDD.class)
	private List<CustomPortletMode> customPortletMode = null;
	
	@XmlElement(name = "custom-portlet-mode", type=CustomPortletModeDD.class, namespace = "http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd")
	private List<CustomPortletMode> customPortletMode1 = null;
	
	@XmlElement(name = "custom-window-state", type=CustomWindowStateDD.class)
	private List<CustomWindowState> customWindowState = null;
	
	@XmlElement(name = "custom-window-state", type=CustomWindowStateDD.class, namespace = "http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd")
	private List<CustomWindowState> customWindowState1 = null;
	
	@XmlElement(name = "user-attribute", type=UserAttributeDD.class)
	private List<UserAttribute> userAttribute = null;

	@XmlElement(name = "user-attribute", type=UserAttributeDD.class, namespace = "http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd")
	private List<UserAttribute> userAttribute1 = null;
	
	@XmlElement(name = "security-constraint", type=SecurityConstraintDD.class)
	private List<SecurityConstraint> securityConstraint = null;
	
	@XmlElement(name = "security-constraint", type=SecurityConstraintDD.class, namespace = "http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd")
	private List<SecurityConstraint> securityConstraint1 = null;
	
	@XmlElement ( name = "resource-bundle")
	private String resourceBundle = null;
	
	@XmlElement ( name = "resource-bundle", namespace = "http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd")
	private String resourceBundle1 = null;
	
	/** The default Namespace */
	@XmlElement(name = "default-namespace")
	private String defaultNamespace = null; 
	
    /** The defined Portlet Events within the system. */
	@XmlElement(name = "event-definition", type=EventDefinitionDD.class)
    private List<EventDefinition> events = null;
    
    /** The defined public Render Parameter within the system. */
	@XmlElement(name = "public-render-parameter", type=PublicRenderParamDD.class)
    private List<PublicRenderParam> render =null;
	
	@XmlElement ( name = "filter", type=FilterDD.class)
	private List<Filter> filter = null;
	
	@XmlElement ( name = "filter-mapping", type=FilterMappingDD.class)
	private List<FilterMapping> filterMapping = null;
	
	@XmlElement ( name = "listener", type=ListenerDD.class)
	private List<Listener> listener = null;
	
	@XmlAttribute(name = "version")
	private String version;

	/** the container runtime options of this portlet application */
	@XmlElement(name = "container-runtime-option", type=ContainerRuntimeOptionDD.class)
	private List<ContainerRuntimeOption> containerRuntimeOption = null;
	
    /**
     * Default Constructor.
     */
    public PortletAppDD() {
    }
    
    /* (non-Javadoc)
     * @see org.apache.pluto.om.portlet.PortletApp#getContextPath()
     */
    public String getContextPath()
    {
        return contextPath;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.om.portlet.PortletApp#setContextPath(java.lang.String)
     */
    public void setContextPath(String contextPath)
    {
        this.contextPath = contextPath;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#getPortlets()
	 */
    public List getPortlets() {
    	if (portlets != null)
    		return portlets;
    	
    	return portlets1;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#setPortlets(java.util.List)
	 */
    public void setPortlets(List<Portlet> portlets) {
    	this.portlets = portlets;
    	this.portlets1 = portlets;
    }
    
    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#getEvents()
	 */
	public List<EventDefinition> getEvents() {
		return events;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#setEvents(java.util.List)
	 */
	public void setEvents(List<EventDefinition> events) {
		this.events = events;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#getRender()
	 */
	public List<PublicRenderParam> getRender() {
		return render;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#setRender(java.util.List)
	 */
	public void setRender(List<PublicRenderParam> render) {
		this.render = render;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#getVersion()
	 */
	public String getVersion() {
		return version;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#setVersion(java.lang.String)
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#getCustomPortletMode()
	 */
	public List<CustomPortletMode> getCustomPortletMode() {
		if (customPortletMode != null)
			return customPortletMode;
		return customPortletMode1;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#setCustomPortletMode(java.util.List)
	 */
	public void setCustomPortletMode(List<CustomPortletMode> customPortletMode) {
		this.customPortletMode = customPortletMode;
		this.customPortletMode1 = customPortletMode;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#getCustomWindowState()
	 */
	public List<CustomWindowState> getCustomWindowState() {
		if (customWindowState != null)
			return customWindowState;
		return customWindowState1;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#setCustomWindowState(java.util.List)
	 */
	public void setCustomWindowState(List<CustomWindowState> customWindowState) {
		this.customWindowState = customWindowState;
		this.customWindowState1 = customWindowState;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#getUserAttribute()
	 */
	public List<UserAttribute> getUserAttribute() {
		if (userAttribute != null)
			return userAttribute;
		return userAttribute1;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#setUserAttribute(java.util.List)
	 */
	public void setUserAttribute(List<UserAttribute> userAttribute) {
		this.userAttribute = userAttribute;
		this.userAttribute1 = userAttribute;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#getSecurityConstraint()
	 */
	public List<SecurityConstraint> getSecurityConstraint() {
		if (securityConstraint != null)
			return securityConstraint;
		return securityConstraint1;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#setSecurityConstraint(java.util.List)
	 */
	public void setSecurityConstraint(List<SecurityConstraint> securityConstraint) {
		this.securityConstraint = securityConstraint;
		this.securityConstraint1 = securityConstraint;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#getResourceBundle()
	 */
	public String getResourceBundle() {
		if (resourceBundle != null)
			return resourceBundle;
		return resourceBundle1;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#setResourceBundle(java.lang.String)
	 */
	public void setResourceBundle(String resourceBundle) {
		this.resourceBundle = resourceBundle;
		this.resourceBundle1 = resourceBundle;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#getFilter()
	 */
	public List<Filter> getFilter() {
		return filter;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#setFilter(java.util.List)
	 */
	public void setFilter(List<Filter> filter) {
		this.filter = filter;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#getFilterMapping()
	 */
	public List<FilterMapping> getFilterMapping() {
		return filterMapping;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#setFilterMapping(java.util.List)
	 */
	public void setFilterMapping(List<FilterMapping> filterMapping) {
		this.filterMapping = filterMapping;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#getListener()
	 */
	public List<Listener> getListener() {
		return listener;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#setListener(java.util.List)
	 */
	public void setListener(List<Listener> listener) {
		this.listener = listener;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#getDefaultNamespace()
	 */
	public String getDefaultNamespace() {
		return defaultNamespace;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#setDefaultNamespace(java.lang.String)
	 */
	public void setDefaultNamespace(String defaultNamespace) {
		this.defaultNamespace = defaultNamespace;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletApp#getContainerRuntimeOption()
	 */
	public List<ContainerRuntimeOption> getContainerRuntimeOption() {
		return containerRuntimeOption;
	}
}

