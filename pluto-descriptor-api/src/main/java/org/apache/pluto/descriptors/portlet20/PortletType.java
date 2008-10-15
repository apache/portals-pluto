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
package org.apache.pluto.descriptors.portlet20;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.pluto.om.ElementFactoryList;
import org.apache.pluto.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.om.portlet.Description;
import org.apache.pluto.om.portlet.DisplayName;
import org.apache.pluto.om.portlet.EventDefinitionReference;
import org.apache.pluto.om.portlet.InitParam;
import org.apache.pluto.om.portlet.Portlet;
import org.apache.pluto.om.portlet.PortletApp;
import org.apache.pluto.om.portlet.PortletInfo;
import org.apache.pluto.om.portlet.PortletPreferences;
import org.apache.pluto.om.portlet.SecurityRoleRef;
import org.apache.pluto.om.portlet.Supports;

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
public class PortletType implements Portlet
{
    @XmlElement(name = "description", type=DescriptionType.class)
    protected List<Description> description;
    @XmlElement(name = "portlet-name", required = true)
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected String portletName;
    @XmlElement(name = "display-name", type=DisplayNameType.class)
    protected List<DisplayName> displayName;
    @XmlElement(name = "portlet-class", required = true)
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected String portletClass;
    @XmlElement(name = "init-param", type=InitParamType.class)
    protected List<InitParam> initParam;
    @XmlElement(name = "expiration-cache")
    protected Integer expirationCache;
    @XmlElement(name = "cache-scope")
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected String cacheScope;
    @XmlElement(required = true, type=SupportsType.class)
    protected List<Supports> supports;
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
    @XmlElement(name = "security-role-ref", type=SecurityRoleRefType.class)
    protected List<SecurityRoleRef> securityRoleRef;
    @XmlElement(name = "supported-processing-event", type=EventDefinitionReferenceType.class)
    protected List<EventDefinitionReference> supportedProcessingEvent;
    @XmlElement(name = "supported-publishing-event", type=EventDefinitionReferenceType.class)
    protected List<EventDefinitionReference> supportedPublishingEvent;
    @XmlElement(name = "supported-public-render-parameter")
    protected List<String> supportedPublicRenderParameter;
    @XmlElement(name = "container-runtime-option", type=ContainerRuntimeOptionType.class)
    protected List<ContainerRuntimeOption> containerRuntimeOption;
    @XmlAttribute
    protected String id;
    
    @XmlTransient
    private PortletApp application;
    
    public PortletType()
    {
    }
    
    public PortletType(PortletApp application)
    {
        this.application = application;
    }
    
    public PortletApp getApplication()
    {
        return application;
    }

    public ElementFactoryList<Description> getDescriptions()
    {
        if (description == null || !(description instanceof ElementFactoryList))
        {
            ElementFactoryList<Description> lf = 
                new ElementFactoryList<Description>( new ElementFactoryList.Factory<Description>()
                {
                    public Class<? extends Description> getElementClass()
                    {
                        return DescriptionType.class;
                    }

                    public Description newElement()
                    {
                        return new DescriptionType();
                    }
                }); 
            if (description != null)
            {
                lf.addAll(description);
            }
            description = lf;
        }
        return (ElementFactoryList<Description>)description;
    }

    public String getPortletName()
    {
        return portletName;
    }

    public void setPortletName(String value)
    {
        portletName = value;
    }

    public ElementFactoryList<DisplayName> getDisplayNames()
    {
        if (displayName == null || !(displayName instanceof ElementFactoryList))
        {
            ElementFactoryList<DisplayName> lf = 
                new ElementFactoryList<DisplayName>( new ElementFactoryList.Factory<DisplayName>()
                {
                    public Class<? extends DisplayName> getElementClass()
                    {
                        return DisplayNameType.class;
                    }

                    public DisplayName newElement()
                    {
                        return new DisplayNameType();
                    }
                }); 
            if (displayName != null)
            {
                lf.addAll(displayName);
            }
            displayName = lf;
        }
        return (ElementFactoryList<DisplayName>)displayName;
    }

    public String getPortletClass()
    {
        return portletClass;
    }

    public void setPortletClass(String value)
    {
        portletClass = value;
    }

    public ElementFactoryList<InitParam> getInitParams()
    {
        if (initParam == null || !(initParam instanceof ElementFactoryList))
        {
            ElementFactoryList<InitParam> lf = 
                new ElementFactoryList<InitParam>( new ElementFactoryList.Factory<InitParam>()
                {
                    public Class<? extends InitParam> getElementClass()
                    {
                        return InitParamType.class;
                    }

                    public InitParam newElement()
                    {
                        return new InitParamType();
                    }
                }); 
            if (initParam != null)
            {
                lf.addAll(initParam);
            }
            initParam = lf;
        }
        return (ElementFactoryList<InitParam>)initParam;
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

    public ElementFactoryList<Supports> getSupports()
    {
        if (supports == null || !(supports instanceof ElementFactoryList))
        {
            ElementFactoryList<Supports> lf = 
                new ElementFactoryList<Supports>( new ElementFactoryList.Factory<Supports>()
                {
                    public Class<? extends Supports> getElementClass()
                    {
                        return SupportsType.class;
                    }

                    public Supports newElement()
                    {
                        return new SupportsType();
                    }
                }); 
            if (supports != null)
            {
                lf.addAll(supports);
            }
            supports = lf;
        }
        return (ElementFactoryList<Supports>)supports;
    }

    public List<String> getSupportedLocales()
    {
        if (supportedLocale == null)
        {
            supportedLocale = new ArrayList<String>();
        }
        return supportedLocale;
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
        return getPortletInfo(false);
    }

    public PortletInfo getPortletInfo(boolean create)
    {
        if (create && portletInfo == null)
        {
            portletInfo = new PortletInfoType();
        }
        return portletInfo;
    }

    public PortletPreferences getPortletPreferences()
    {
        return getPortletPreferences(false);
    }

    public PortletPreferences getPortletPreferences(boolean create)
    {
        if (create && portletPreferences == null)
        {
            portletPreferences = new PortletPreferencesType();
        }
        return portletPreferences;
    }

    public ElementFactoryList<SecurityRoleRef> getSecurityRoleRefs()
    {
        if (securityRoleRef == null || !(securityRoleRef instanceof ElementFactoryList))
        {
            ElementFactoryList<SecurityRoleRef> lf = 
                new ElementFactoryList<SecurityRoleRef>( new ElementFactoryList.Factory<SecurityRoleRef>()
                {
                    public Class<? extends SecurityRoleRef> getElementClass()
                    {
                        return SecurityRoleRefType.class;
                    }

                    public SecurityRoleRef newElement()
                    {
                        return new SecurityRoleRefType();
                    }
                }); 
            if (securityRoleRef != null)
            {
                lf.addAll(securityRoleRef);
            }
            securityRoleRef = lf;
        }
        return (ElementFactoryList<SecurityRoleRef>)securityRoleRef;
    }

    public ElementFactoryList<EventDefinitionReference> getSupportedProcessingEvents()
    {
        if (supportedProcessingEvent == null || !(supportedProcessingEvent instanceof ElementFactoryList))
        {
            ElementFactoryList<EventDefinitionReference> lf = 
                new ElementFactoryList<EventDefinitionReference>( new ElementFactoryList.Factory<EventDefinitionReference>()
                {
                    public Class<? extends EventDefinitionReference> getElementClass()
                    {
                        return EventDefinitionReferenceType.class;
                    }

                    public EventDefinitionReference newElement()
                    {
                        return new EventDefinitionReferenceType();
                    }
                }); 
            if (supportedProcessingEvent != null)
            {
                lf.addAll(supportedProcessingEvent);
            }
            supportedProcessingEvent = lf;
        }
        return (ElementFactoryList<EventDefinitionReference>)supportedProcessingEvent;
    }

    public ElementFactoryList<EventDefinitionReference> getSupportedPublishingEvents()
    {
        if (supportedPublishingEvent == null || !(supportedPublishingEvent instanceof ElementFactoryList))
        {
            ElementFactoryList<EventDefinitionReference> lf = 
                new ElementFactoryList<EventDefinitionReference>( new ElementFactoryList.Factory<EventDefinitionReference>()
                {
                    public Class<? extends EventDefinitionReference> getElementClass()
                    {
                        return EventDefinitionReferenceType.class;
                    }

                    public EventDefinitionReference newElement()
                    {
                        return new EventDefinitionReferenceType();
                    }
                }); 
            if (supportedPublishingEvent != null)
            {
                lf.addAll(supportedPublishingEvent);
            }
            supportedPublishingEvent = lf;
        }
        return (ElementFactoryList<EventDefinitionReference>)supportedPublishingEvent;
    }

    public List<String> getSupportedPublicRenderParameters()
    {
        if (supportedPublicRenderParameter == null)
        {
            supportedPublicRenderParameter = new ArrayList<String>();
        }
        return supportedPublicRenderParameter;
    }

    public ElementFactoryList<ContainerRuntimeOption> getContainerRuntimeOptions()
    {
        if (containerRuntimeOption == null || !(containerRuntimeOption instanceof ElementFactoryList))
        {
            ElementFactoryList<ContainerRuntimeOption> lf = 
                new ElementFactoryList<ContainerRuntimeOption>( new ElementFactoryList.Factory<ContainerRuntimeOption>()
                {
                    public Class<? extends ContainerRuntimeOption> getElementClass()
                    {
                        return ContainerRuntimeOptionType.class;
                    }

                    public ContainerRuntimeOption newElement()
                    {
                        return new ContainerRuntimeOptionType();
                    }
                }); 
            if (containerRuntimeOption != null)
            {
                lf.addAll(containerRuntimeOption);
            }
            containerRuntimeOption = lf;
        }
        return (ElementFactoryList<ContainerRuntimeOption>)containerRuntimeOption;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String value)
    {
        id = value;
    }

    public void setSupportedLocales(List<String> supportedLocales)
    {
        this.supportedLocale = supportedLocales;
    }
    
    public void setSupportedPublicRenderParameters(List<String> supportedPublicRenderParameters)
    {
        this.supportedPublicRenderParameter = supportedPublicRenderParameters;
    }

    public void afterUnmarshal(Unmarshaller u, Object parent) {
        application = (PortletApp)parent;
    }
}
