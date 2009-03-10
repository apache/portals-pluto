/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.container.om.portlet.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.DisplayName;
import org.apache.pluto.container.om.portlet.EventDefinitionReference;
import org.apache.pluto.container.om.portlet.InitParam;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.PortletInfo;
import org.apache.pluto.container.om.portlet.Preferences;
import org.apache.pluto.container.om.portlet.SecurityRoleRef;
import org.apache.pluto.container.om.portlet.Supports;

/**
 * The portlet element contains the declarative data of a portlet. Used in: portlet-app <p>Java class for portletType
 * complex type. <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;portletType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;description&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}descriptionType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;portlet-name&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}portlet-nameType&quot;/&gt;
 *         &lt;element name=&quot;display-name&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}display-nameType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;portlet-class&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}portlet-classType&quot;/&gt;
 *         &lt;element name=&quot;init-param&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}init-paramType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;expiration-cache&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}expiration-cacheType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;cache-scope&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}cache-scopeType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;supports&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}supportsType&quot; maxOccurs=&quot;unbounded&quot;/&gt;
 *         &lt;element name=&quot;supported-locale&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}supported-localeType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;resource-bundle&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}resource-bundleType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;portlet-info&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}portlet-infoType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;portlet-preferences&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}portlet-preferencesType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;security-role-ref&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}security-role-refType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;supported-processing-event&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}event-definition-referenceType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;supported-publishing-event&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}event-definition-referenceType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;supported-public-render-parameter&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}string&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;container-runtime-option&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}container-runtime-optionType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name=&quot;id&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}string&quot; /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * @version $Id$
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portletType", propOrder = { "description", "portletName", "displayName", "portletClass", "initParam",
                                            "expirationCache", "cacheScope", "supports", "supportedLocale",
                                            "resourceBundle", "portletInfo", "portletPreferences", "securityRoleRef",
                                            "supportedProcessingEvent", "supportedPublishingEvent",
                                            "supportedPublicRenderParameter", "containerRuntimeOption" })
public class PortletType implements PortletDefinition
{
    @XmlElement(name = "description")
    protected List<DescriptionType> description;
    @XmlElement(name = "portlet-name", required = true)
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected String portletName;
    @XmlElement(name = "display-name")
    protected List<DisplayNameType> displayName;
    @XmlElement(name = "portlet-class", required = true)
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected String portletClass;
    @XmlElement(name = "init-param")
    protected List<InitParamType> initParam;
    @XmlElement(name = "expiration-cache")
    protected Integer expirationCache;
    @XmlElement(name = "cache-scope")
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected String cacheScope;
    @XmlElement(required = true)
    protected List<SupportsType> supports;
    @XmlElement(name = "supported-locale")
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected List<String> supportedLocale;
    @XmlElement(name = "resource-bundle")
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected String resourceBundle;
    @XmlElement(name = "portlet-info")
    protected PortletInfoType portletInfo;
    @XmlElement(name = "portlet-preferences")
    protected PortletPreferencesType portletPreferences;
    @XmlElement(name = "security-role-ref")
    protected List<SecurityRoleRefType> securityRoleRef;
    @XmlElement(name = "supported-processing-event")
    protected List<EventDefinitionReferenceType> supportedProcessingEvent;
    @XmlElement(name = "supported-publishing-event")
    protected List<EventDefinitionReferenceType> supportedPublishingEvent;
    @XmlElement(name = "supported-public-render-parameter")
    protected List<String> supportedPublicRenderParameter;
    @XmlElement(name = "container-runtime-option")
    protected List<ContainerRuntimeOptionType> containerRuntimeOption;
    
    @XmlTransient
    private PortletApplicationDefinition application;
    
    public PortletType()
    {
    }
    
    public PortletApplicationDefinition getApplication()
    {
        return application;
    }
    
    public void setApplication(PortletApplicationDefinition app)
    {
        this.application = app;
    }

    public Description getDescription(Locale locale)
    {
        for (Description d : getDescriptions())
        {
            if (d.getLocale().equals(locale))
            {
                return d;
            }
        }
        return null;
    }
    
    public List<? extends Description> getDescriptions()
    {
        if (description == null)
        {
            description = new ArrayList<DescriptionType>();
        }
        return description;
    }
    
    public Description addDescription(String lang)
    {
        DescriptionType d = new DescriptionType();
        d.setLang(lang);
        if (getDescription(d.getLocale()) != null)
        {
            throw new IllegalArgumentException("Description for language: "+d.getLocale()+" already defined");
        }
        getDescriptions();
        description.add(d);
        return d;
    }

    public DisplayName getDisplayName(Locale locale)
    {
        for (DisplayName d : getDisplayNames())
        {
            if (d.getLocale().equals(locale))
            {
                return d;
            }
        }
        return null;
    }
    
    public List<? extends DisplayName> getDisplayNames()
    {
        if (displayName == null)
        {
            displayName = new ArrayList<DisplayNameType>();
        }
        return displayName;
    }
    
    public DisplayName addDisplayName(String lang)
    {
        DisplayNameType d = new DisplayNameType();
        d.setLang(lang);
        if (getDisplayName(d.getLocale()) != null)
        {
            throw new IllegalArgumentException("DisplayName for language: "+d.getLocale()+" already defined");
        }
        getDisplayNames();
        displayName.add(d);
        return d;
    }

    public String getPortletName()
    {
        return portletName;
    }

    public void setPortletName(String value)
    {
        portletName = value;
    }

    public String getPortletClass()
    {
        return portletClass;
    }

    public void setPortletClass(String value)
    {
        portletClass = value;
    }

    public InitParam getInitParam(String name)
    {
        for (InitParam param : getInitParams())
        {
            if (param.getParamName().equals(name))
            {
                return param;
            }
        }
        return null;
    }

    public List<? extends InitParam> getInitParams()
    {
        if (initParam == null)
        {
            initParam = new ArrayList<InitParamType>();
        }
        return initParam;
    }
    
    public InitParam addInitParam(String paramName)
    {
        if (getInitParam(paramName) != null)
        {
            throw new IllegalArgumentException("Init parameter: "+paramName+" already defined");
        }
        InitParamType param = new InitParamType();
        param.setParamName(paramName);
        getInitParams();
        initParam.add(param);
        return param;
    }
    
    public int getExpirationCache()
    {
        return expirationCache != null ? expirationCache.intValue() : 0;
    }

    public void setExpirationCache(int value)
    {
        expirationCache = new Integer(value);
    }

    /**
     * Caching scope, allowed values are "private" indicating that the content should not be shared across users and
     * "public" indicating that the content may be shared across users. The default value if not present is "private".
     */
    public String getCacheScope()
    {
        return cacheScope != null ? cacheScope : "private";
    }

    public void setCacheScope(String cacheScope)
    {
        this.cacheScope = cacheScope;
    }

    public Supports getSupports(String mimeType)
    {
        for (Supports s : getSupports())
        {
            if (s.getMimeType().equals(mimeType))
            {
                return s;
            }
        }
        return null;
    }
    
    public List<? extends Supports> getSupports()
    {
        if (supports == null)
        {
            supports = new ArrayList<SupportsType>();
        }
        return supports;
    }
    
    public Supports addSupports(String mimeType)
    {
        if (getSupports(mimeType) != null)
        {
            throw new IllegalArgumentException("Supports for mime type: "+mimeType+" already defined");
        }
        SupportsType s = new SupportsType();
        s.setMimeType(mimeType);
        supports.add(s);
        return s;        
    }
    
    public List<String> getSupportedLocales()
    {
        if (supportedLocale == null)
        {
            supportedLocale = new ArrayList<String>();
        }
        return supportedLocale;
    }
    
    public void addSupportedLocale(String lang)
    {
        for (String l : getSupportedLocales())
        {
            if (l.equals(lang))
            {
                throw new IllegalArgumentException("Supported locale: "+lang+" already defined");
            }
        }
        supportedLocale.add(lang);    
    }

    public String getResourceBundle()
    {
        return resourceBundle;
    }

    public void setResourceBundle(String value)
    {
        resourceBundle = value;
    }

    public PortletInfo getPortletInfo()
    {
        if (portletInfo == null)
        {
            portletInfo = new PortletInfoType();
        }
        return portletInfo;
    }

    public Preferences getPortletPreferences()
    {
        if (portletPreferences == null)
        {
            portletPreferences = new PortletPreferencesType();
        }
        return portletPreferences;
    }
    
    public SecurityRoleRef getSecurityRoleRef(String roleName)
    {
        for (SecurityRoleRef ref : getSecurityRoleRefs())
        {
            if (ref.getRoleName().equals(roleName))
            {
                return ref;
            }
        }
        return null;
    }

    public List<? extends SecurityRoleRef> getSecurityRoleRefs()
    {
        if (securityRoleRef == null)
        {
            securityRoleRef = new ArrayList<SecurityRoleRefType>();
        }
        return securityRoleRef;
    }
    
    public SecurityRoleRef addSecurityRoleRef(String roleName)
    {
        if (getSecurityRoleRef(roleName) != null)
        {
            throw new IllegalArgumentException("Security role reference for role: "+roleName+" already defined");
        }
        SecurityRoleRefType srr = new SecurityRoleRefType();
        srr.setRoleName(roleName);
        securityRoleRef.add(srr);
        return srr;        
    }
    
    public List<? extends EventDefinitionReference> getSupportedProcessingEvents()
    {
        if (supportedProcessingEvent == null)
        {
            supportedProcessingEvent = new ArrayList<EventDefinitionReferenceType>();            
        }
        return supportedProcessingEvent;
    }

    public EventDefinitionReference addSupportedProcessingEvent(QName qname)
    {
        // TODO: check duplicates
        getSupportedProcessingEvents();
        EventDefinitionReferenceType edr = new EventDefinitionReferenceType();
        edr.setQName(qname);
        supportedProcessingEvent.add(edr);
        return edr;
    }
    
    public EventDefinitionReference addSupportedProcessingEvent(String name)
    {
        // TODO check duplicates
        getSupportedProcessingEvents();
        EventDefinitionReferenceType edr = new EventDefinitionReferenceType();
        edr.setName(name);
        supportedProcessingEvent.add(edr);
        return edr;
    }
        
    public List<? extends EventDefinitionReference> getSupportedPublishingEvents()
    {
        if (supportedPublishingEvent == null)
        {
            supportedPublishingEvent = new ArrayList<EventDefinitionReferenceType>();            
        }
        return supportedPublishingEvent;
    }

    public EventDefinitionReference addSupportedPublishingEvent(QName qname)
    {
        // TODO: check duplicates
        getSupportedPublishingEvents();
        EventDefinitionReferenceType edr = new EventDefinitionReferenceType();
        edr.setQName(qname);
        supportedPublishingEvent.add(edr);
        return edr;
    }
    
    public EventDefinitionReference addSupportedPublishingEvent(String name)
    {
        // TODO check duplicates
        getSupportedPublishingEvents();
        EventDefinitionReferenceType edr = new EventDefinitionReferenceType();
        edr.setName(name);
        supportedPublishingEvent.add(edr);
        return edr;
    }
        
    public List<String> getSupportedPublicRenderParameters()
    {
        if (supportedPublicRenderParameter == null)
        {
            supportedPublicRenderParameter = new ArrayList<String>();
        }
        return supportedPublicRenderParameter;
    }
    
    public void addSupportedPublicRenderParameter(String identifier)
    {
        for (String ident : getSupportedPublicRenderParameters())
        {
            if (ident.equals(identifier))
            {
                throw new IllegalArgumentException("Support for public render parameter with identifier: "+identifier+" already defined");
            }
        }
        supportedPublicRenderParameter.add(identifier);
    }

    public ContainerRuntimeOption getContainerRuntimeOption(String name)
    {
        for (ContainerRuntimeOption cro : getContainerRuntimeOptions())
        {
            if (cro.getName().equals(name))
            {
                return cro;
            }
        }
        return null;
    }
    
    public List<? extends ContainerRuntimeOption> getContainerRuntimeOptions()
    {
        if (containerRuntimeOption == null)
        {
            containerRuntimeOption = new ArrayList<ContainerRuntimeOptionType>();
        }
        return containerRuntimeOption;
    }
    
    public ContainerRuntimeOption addContainerRuntimeOption(String name)
    {
        if (getContainerRuntimeOption(name) != null)
        {
            throw new IllegalArgumentException("Container runtime option with name: "+name+" already defined");
        }
        ContainerRuntimeOptionType cro = new ContainerRuntimeOptionType();
        cro.setName(name);
        containerRuntimeOption.add(cro);
        return cro;        
    }
    
    public void afterUnmarshal(Unmarshaller u, Object parent) {
        application = (PortletApplicationDefinition)parent;
    }
}
