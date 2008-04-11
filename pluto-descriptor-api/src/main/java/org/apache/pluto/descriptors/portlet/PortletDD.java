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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

import org.apache.pluto.descriptors.common.InitParamDD;
import org.apache.pluto.descriptors.common.SecurityRoleRefDD;
import org.apache.pluto.om.common.InitParam;
import org.apache.pluto.om.common.SecurityRoleRef;
import org.apache.pluto.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.om.portlet.EventDefinitionReference;
import org.apache.pluto.om.portlet.ExpirationCache;
import org.apache.pluto.om.portlet.Portlet;
import org.apache.pluto.om.portlet.PortletInfo;
import org.apache.pluto.om.portlet.PortletPreferences;
import org.apache.pluto.om.portlet.Supports;

/**
 * Bare bones implementation of the Portlet descriptor.
 * 
 * FIXME: Hmmm... What do you mean, David?  --ZHENG Zhong
 * 
 * Eventually this should be flushed out :), but for the sake of timing I'll be lazy for now.
 *
 * @since Mar 6, 2005
 *
 * 
 * 			The portlet element contains the declarative data of a portlet. 
 * 			Used in: portlet-app
 * 			
 * 
 * <p>Java class for portletType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="portletType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}descriptionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="portlet-name" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}portlet-nameType"/>
 *         &lt;element name="display-name" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}display-nameType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="portlet-class" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}portlet-classType"/>
 *         &lt;element name="init-param" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}init-paramType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="expiration-cache" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}expiration-cacheType" minOccurs="0"/>
 *         &lt;element name="supports" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}supportsType" maxOccurs="unbounded"/>
 *         &lt;element name="supported-locale" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}supported-localeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="resource-bundle" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}resource-bundleType"/>
 *             &lt;element name="portlet-info" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}portlet-infoType" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element name="portlet-info" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}portlet-infoType"/>
 *         &lt;/choice>
 *         &lt;element name="portlet-preferences" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}portlet-preferencesType" minOccurs="0"/>
 *         &lt;element name="security-role-ref" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}security-role-refType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="supported-processing-event" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}nameType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="supported-publishing-event" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}nameType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="supported-public-render-parameter" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portletType", propOrder = {
    //"content",
    "supports", "supports1",
    "securityRoleRefs","securityRoleRefs1",
    "processingEvents",
    "portletName",    "portletName1",
    "initParams", "initParams1",
    "expirationCacheDD",    "expirationCache",
    "publishingEvents",
    "supportedLocale","supportedLocale1",
    "portletInfo", "portletInfo1",
    "resourceBundle","resourceBundle1",
    "portletClass", "portletClass1", 
    "portletPreferences", "portletPreferences1",
    "description",    "description1",
    "displayName",    "displayName1",
    "publicRenderParameter",
    "containerRuntimeOption"
})
public class PortletDD implements Portlet {
	
	private static final String QNAME_JSR286 = "http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd";

	@XmlElement(name = "supports",type=SupportsDD.class)
	private List<Supports> supports = null;
	
	@XmlElement(name = "supports",namespace = QNAME_JSR168,type=SupportsDD.class)
	private List<Supports> supports1 = null;
	
	/** All security role references. */
	@XmlElement(name = "security-role-ref",type=SecurityRoleRefDD.class)
    private List<SecurityRoleRef> securityRoleRefs = null;
	
	/** All security role references. */
	@XmlElement(name = "security-role-ref",namespace = QNAME_JSR168,type=SecurityRoleRefDD.class)
    private List<SecurityRoleRef> securityRoleRefs1 = null;
	
	/** the supported processing Events */
	@XmlElement(name = "supported-processing-event",type=EventDefinitionReferenceDD.class)
    private List<EventDefinitionReference> processingEvents = null;
	
    /** The unique name of the portlet. */
	@XmlElement(name = "portlet-name")
    private String portletName = null;
	
	@XmlElement (name = "portlet-name", namespace = QNAME_JSR168)
	private String portletName1 = null;
	
	@XmlElement(name = "init-param",type=InitParamDD.class)
    private List<InitParam> initParams = null;
	
	@XmlElement(name = "init-param",namespace = QNAME_JSR168,type=InitParamDD.class)
    private List<InitParam> initParams1 = null;
	
	@XmlElement(name = "expiration-cache", namespace = QNAME_JSR286,type=ExpirationCacheDD.class)
	private ExpirationCache expirationCacheDD = null;
	
	@XmlElement(name = "expiration-cache", namespace = QNAME_JSR168)
//	private int expirationCache = EXPIRATION_CACHE_DEFAULT;
    private int expirationCache = EXPIRATION_CACHE_UNSET;
	
	/** the supported publishing Events */
	@XmlElement(name = "supported-publishing-event",type=EventDefinitionReferenceDD.class)
    private List<EventDefinitionReference> publishingEvents = null;
	
	@XmlElement (name = "supported-locale")
	private List<String> supportedLocale = null;
	
	@XmlElement (name = "supported-locale", namespace = QNAME_JSR168)
	private List<String> supportedLocale1 = null;
	
	@XmlElement(name = "portlet-info",type=PortletInfoDD.class)
    private PortletInfo portletInfo = null;
	
	@XmlElement(name = "portlet-info", namespace = QNAME_JSR168,type=PortletInfoDD.class)
    private PortletInfo portletInfo1 = null;
	
	@XmlElement(name = "resource-bundle")
    private String resourceBundle = null;
	
	@XmlElement(name = "resource-bundle", namespace = QNAME_JSR168)
    private String resourceBundle1 = null;

	/** The class which implements the portlet interface. */
	@XmlElement(name = "portlet-class")
    private String portletClass = null;
	
	/** The class which implements the portlet interface. */
	@XmlElement(name = "portlet-class", namespace = QNAME_JSR168)
    private String portletClass1 = null;
	
	@XmlElement(name = "portlet-preferences",type=PortletPreferencesDD.class)
    private PortletPreferences portletPreferences = null;
	
	@XmlElement(name = "portlet-preferences", namespace = QNAME_JSR168,type=PortletPreferencesDD.class)
    private PortletPreferences portletPreferences1 = null;
	
	@XmlElement(name = "description")
	private String description = null;
	
	@XmlElement(name = "description" ,namespace = QNAME_JSR168)
	private String description1 = null;
    
	@XmlElement(name = "display-name")
	private String displayName = null;
	
	@XmlElement(name = "display-name", namespace = QNAME_JSR168)
	private String displayName1 = null;
	
    /** the supported public render parameter */
	@XmlElement(name = "supported-public-render-parameter")
    private List<String> publicRenderParameter = null;
	
		
	/** the container runtime options of this portlet */
	@XmlElement(name = "container-runtime-option",type=ContainerRuntimeOptionDD.class)
	private List<ContainerRuntimeOption> containerRuntimeOption = null;
    
    
    // Constructor -------------------------------------------------------------
    
    /**
     * Default no-arg constructor.
     */
    public PortletDD() {
    	// Do nothing.
    }
    
    
    // Public Methods ----------------------------------------------------------
    


    
    
    // Object Methods ----------------------------------------------------------
    
    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#toString()
	 */
    public String toString() {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append(getClass().getName());
    	buffer.append("[portletName=").append(portletName);
    	buffer.append(",portletClass=").append(portletClass);
    	// TODO:
    	return buffer.toString();
    }
    
    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#hashCode()
	 */
    public int hashCode() {
    	return toString().hashCode();
    }


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getInitParams()
	 */
	public List<InitParam> getInitParams() {
		if (initParams != null)
			return initParams;
		return initParams1;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#setInitParams(java.util.List)
	 */
	public void setInitParams(List<InitParam> initParams) {
		if (initParams != null)
			this.initParams = initParams;
		else
			this.initParams1 = initParams;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getPortletClass()
	 */
	public String getPortletClass() {
		if (portletClass != null)
			return portletClass.trim();
		return portletClass1.trim();
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#setPortletClass(java.lang.String)
	 */
	public void setPortletClass(String portletClass) {
		if (portletClass != null)
			this.portletClass = portletClass;
		else
			this.portletClass1 = portletClass;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getPortletInfo()
	 */
	public PortletInfo getPortletInfo() {
		if (portletInfo != null)
			return portletInfo;
		return portletInfo1;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#setPortletInfo(org.apache.pluto.descriptors.portlet.PortletInfoDD)
	 */
	public void setPortletInfo(PortletInfo portletInfo) {
		if (portletInfo != null)
			this.portletInfo = portletInfo;
		else
			this.portletInfo1 = portletInfo;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getPortletName()
	 */
	public String getPortletName() {
		if (portletName != null)
			return portletName.trim();
		return portletName1.trim();
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#setPortletName(java.lang.String)
	 */
	public void setPortletName(String portletName) {
		this.portletName = portletName;
		this.portletName1 = portletName;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getPortletPreferences()
	 */
	public PortletPreferences getPortletPreferences() {
		if (portletPreferences!= null)
			return portletPreferences;
		return portletPreferences1;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#setPortletPreferences(org.apache.pluto.descriptors.portlet.PortletPreferences)
	 */
	public void setPortletPreferences(PortletPreferences portletPreferences) {
		this.portletPreferences = portletPreferences;
		this.portletPreferences1 = portletPreferences;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getProcessingEvents()
	 */
	public List<QName> getProcessingEvents() {
		List<QName> list = new ArrayList<QName>();
		if (processingEvents != null) {
			for (EventDefinitionReference ref : processingEvents) {
				list.add(ref.getName());
			}
			return list;
		}
		return null;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#setProcessingEvents(java.util.List)
	 */
	public void setProcessingEvents(List<EventDefinitionReference> processingEvents) {
		this.processingEvents = processingEvents;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getPublishingEvents()
	 */
	public List<QName> getPublishingEvents() {
		List<QName> list = new ArrayList<QName>();
		if (publishingEvents != null) {
			for (EventDefinitionReference ref : publishingEvents) {
				list.add(ref.getName());
			}
			return list;
		}
		return null;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#setPublishingEvents(java.util.List)
	 */
	public void setPublishingEvents(List<EventDefinitionReference> publishingEvents) {
		this.publishingEvents = publishingEvents;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getPublicRenderParameter()
	 */
	public List<String> getPublicRenderParameter() {
		return publicRenderParameter;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#setPublicRenderParameter(java.util.List)
	 */
	public void setPublicRenderParameter(List<String> publicRenderParameter) {
		this.publicRenderParameter = publicRenderParameter;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getResourceBundle()
	 */
	public String getResourceBundle() {
		if (resourceBundle!= null)
			return resourceBundle;
		return resourceBundle1;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#setResourceBundle(java.lang.String)
	 */
	public void setResourceBundle(String resourceBundle) {
		this.resourceBundle = resourceBundle;
		this.resourceBundle1 = resourceBundle;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getSecurityRoleRefs()
	 */
	public List<SecurityRoleRef> getSecurityRoleRefs() {
		if (securityRoleRefs!= null)
			return securityRoleRefs;
		return securityRoleRefs1;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#setSecurityRoleRefs(java.util.List)
	 */
	public void setSecurityRoleRefs(List<SecurityRoleRef> securityRoleRefs) {
		this.securityRoleRefs = securityRoleRefs;
		this.securityRoleRefs1 = securityRoleRefs;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getSupports()
	 */
	public List<Supports> getSupports() {
		if (supports!= null)
			return supports;
		return supports1;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#setSupports(java.util.List)
	 */
	public void setSupports(List<Supports> supports) {
		this.supports = supports;
		this.supports1 = supports;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getDescription()
	 */
	public String getDescription() {
		if (description != null)
			return description;
		return description1;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#setDescription(java.lang.String)
	 */
	public void setDescription(String description) {
		this.description = description;
		this.description1 = description;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getDisplayName()
	 */
	public String getDisplayName() {
		if (displayName != null)
			return displayName;
		return displayName1;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#setDisplayName(java.lang.String)
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
		this.displayName1 = displayName;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getSupportedLocale()
	 */
	public List<String> getSupportedLocale() {
		if (supportedLocale != null)
			return supportedLocale;
		return supportedLocale1;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#setSupportedLocale(java.util.List)
	 */
	public void setSupportedLocale(List<String> supportedLocale) {
		this.supportedLocale = supportedLocale;
		this.supportedLocale1 = supportedLocale;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getExpirationCache()
	 */
	public ExpirationCache getExpirationCache() {
		// use old style expiration cache (JSR 168)
		if (expirationCache != EXPIRATION_CACHE_UNSET){
			ExpirationCache result = new ExpirationCacheDD();
			result.setExpirationTime(expirationCache);
			result.setScope("");
			return result;
		}
		
		return expirationCacheDD;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#setExpirationCache(org.apache.pluto.descriptors.portlet.ExpirationCache)
	 */
	public void setExpirationCache(ExpirationCache expirationCache) {
		this.expirationCache = expirationCacheDD.getExpirationTime();
		this.expirationCacheDD = expirationCacheDD;
	}


	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.Portlet#getContainerRuntimeOption()
	 */
	public List<ContainerRuntimeOption> getContainerRuntimeOption() {
		return containerRuntimeOption;
	}
}

