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

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

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
public class PortletAppDD {

    /** The defined portlets within the system. */
	@XmlElement(name = "portlet", namespace = "http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd")
    private List<PortletDD> portlets = null;
	
	/** The defined portlets (jsr 168) within the system. */
	@XmlElement(name = "portlet", namespace = "http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd")
    private List<PortletDD> portlets1 = null;
	
	@XmlElement(name = "custom-portlet-mode")
	private List<CustomPortletModeDD> customPortletMode = null;
	
	@XmlElement(name = "custom-portlet-mode", namespace = "http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd")
	private List<CustomPortletModeDD> customPortletMode1 = null;
	
	@XmlElement(name = "custom-window-state")
	private List<CustomWindowStateDD> customWindowState = null;
	
	@XmlElement(name = "custom-window-state", namespace = "http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd")
	private List<CustomWindowStateDD> customWindowState1 = null;
	
	@XmlElement(name = "user-attribute")
	private List<UserAttributeDD> userAttribute = null;

	@XmlElement(name = "user-attribute", namespace = "http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd")
	private List<UserAttributeDD> userAttribute1 = null;
	
	@XmlElement(name = "security-constraint")
	private List<SecurityConstraintDD> securityConstraint = null;
	
	@XmlElement(name = "security-constraint", namespace = "http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd")
	private List<SecurityConstraintDD> securityConstraint1 = null;
	
	@XmlElement ( name = "resource-bundle")
	private String resourceBundle = null;
	
	@XmlElement ( name = "resource-bundle", namespace = "http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd")
	private String resourceBundle1 = null;
	
	/** The default Namespace */
	@XmlElement(name = "default-namespace")
	private String defaultNamespace = null; 
	
    /** The defined Portlet Events within the system. */
	@XmlElement(name = "event-definition")
    private List<EventDefinitionDD> events = null;
    
    /** The defined public Render Parameter within the system. */
	@XmlElement(name = "public-render-parameter")
    private List<PublicRenderParamDD> render =null;
	
	@XmlElement ( name = "filter")
	private List<FilterDD> filter = null;
	
	@XmlElement ( name = "filter-mapping")
	private List<FilterMappingDD> filterMapping = null;
	
	@XmlElement ( name = "listener")
	private List<ListenerDD> listener = null;
	
	@XmlAttribute(name = "version")
	private String version;

	/** the container runtime options of this portlet application */
	@XmlElement(name = "container-runtime-option")
	private List<ContainerRuntimeOptionDD> containerRuntimeOption = null;
	
    /**
     * Default Constructor.
     */
    public PortletAppDD() {
    }

    /**
     * Retrieve the portlets which exist within this application.
     * @return
     */
    public List getPortlets() {
    	if (portlets != null)
    		return portlets;
    	
    	return portlets1;
    }

    /**
     * Set the portlets that exist within this application.
     * @param portlets
     */
    public void setPortlets(List<PortletDD> portlets) {
    	this.portlets = portlets;
    	this.portlets1 = portlets;
    }
    
    /**
	 * @return Returns the events.
	 */
	public List<EventDefinitionDD> getEvents() {
		return events;
	}

	/**
	 * @param events The events to set.
	 */
	public void setEvents(List<EventDefinitionDD> events) {
		this.events = events;
	}

	/**
	 * @return Returns the public render parameter.
	 */
	public List<PublicRenderParamDD> getRender() {
		return render;
	}

	/**
	 * @param render The public render parameter to set.
	 */
	public void setRender(List<PublicRenderParamDD> render) {
		this.render = render;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<CustomPortletModeDD> getCustomPortletMode() {
		if (customPortletMode != null)
			return customPortletMode;
		return customPortletMode1;
	}

	public void setCustomPortletMode(List<CustomPortletModeDD> customPortletMode) {
		this.customPortletMode = customPortletMode;
		this.customPortletMode1 = customPortletMode;
	}

	public List<CustomWindowStateDD> getCustomWindowState() {
		if (customWindowState != null)
			return customWindowState;
		return customWindowState1;
	}

	public void setCustomWindowState(List<CustomWindowStateDD> customWindowState) {
		this.customWindowState = customWindowState;
		this.customWindowState1 = customWindowState;
	}

	public List<UserAttributeDD> getUserAttribute() {
		if (userAttribute != null)
			return userAttribute;
		return userAttribute1;
	}

	public void setUserAttribute(List<UserAttributeDD> userAttribute) {
		this.userAttribute = userAttribute;
		this.userAttribute1 = userAttribute;
	}

	public List<SecurityConstraintDD> getSecurityConstraint() {
		if (securityConstraint != null)
			return securityConstraint;
		return securityConstraint1;
	}

	public void setSecurityConstraint(List<SecurityConstraintDD> securityConstraint) {
		this.securityConstraint = securityConstraint;
		this.securityConstraint1 = securityConstraint;
	}

	public String getResourceBundle() {
		if (resourceBundle != null)
			return resourceBundle;
		return resourceBundle1;
	}

	public void setResourceBundle(String resourceBundle) {
		this.resourceBundle = resourceBundle;
		this.resourceBundle1 = resourceBundle;
	}

	public List<FilterDD> getFilter() {
		return filter;
	}

	public void setFilter(List<FilterDD> filter) {
		this.filter = filter;
	}

	public List<FilterMappingDD> getFilterMapping() {
		return filterMapping;
	}

	public void setFilterMapping(List<FilterMappingDD> filterMapping) {
		this.filterMapping = filterMapping;
	}

	public List<ListenerDD> getListener() {
		return listener;
	}

	public void setListener(List<ListenerDD> listener) {
		this.listener = listener;
	}

	public String getDefaultNamespace() {
		return defaultNamespace;
	}

	public void setDefaultNamespace(String defaultNamespace) {
		this.defaultNamespace = defaultNamespace;
	}

	public List<ContainerRuntimeOptionDD> getContainerRuntimeOption() {
		return containerRuntimeOption;
	}
}

