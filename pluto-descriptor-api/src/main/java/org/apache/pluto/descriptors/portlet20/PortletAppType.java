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

import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.pluto.om.ElementFactoryList;
import org.apache.pluto.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.om.portlet.CustomPortletMode;
import org.apache.pluto.om.portlet.CustomWindowState;
import org.apache.pluto.om.portlet.EventDefinition;
import org.apache.pluto.om.portlet.Filter;
import org.apache.pluto.om.portlet.FilterMapping;
import org.apache.pluto.om.portlet.Listener;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.om.portlet.PublicRenderParameter;
import org.apache.pluto.om.portlet.SecurityConstraint;
import org.apache.pluto.om.portlet.UserAttribute;

/**
 * <p>Java class for portlet-appType complex type. <p>The following schema fragment specifies the expected content
 * contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;portlet-appType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;portlet&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}portletType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;custom-portlet-mode&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}custom-portlet-modeType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;custom-window-state&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}custom-window-stateType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;user-attribute&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}user-attributeType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;security-constraint&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}security-constraintType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;resource-bundle&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}resource-bundleType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;filter&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}filterType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;filter-mapping&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}filter-mappingType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;default-namespace&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyURI&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;event-definition&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}event-definitionType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;public-render-parameter&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}public-render-parameterType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;listener&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}listenerType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;container-runtime-option&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}container-runtime-optionType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name=&quot;version&quot; use=&quot;required&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}string&quot; /&gt;
 *       &lt;attribute name=&quot;id&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}string&quot; /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * @version $Id$
 */
@XmlRootElement(name = "portlet-app")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portlet-appType", propOrder = { "portlet", "customPortletMode", "customWindowState", "userAttribute",
                                                "securityConstraint", "resourceBundle", "filter", "filterMapping",
                                                "defaultNamespace", "eventDefinition", "publicRenderParameter",
                                                "listener", "containerRuntimeOption" })
public class PortletAppType implements PortletApplicationDefinition
{
    @XmlElement(name = "portlet", type=PortletType.class)
    protected List<PortletDefinition> portlet;
    @XmlElement(name = "custom-portlet-mode", type=CustomPortletModeType.class)
    protected List<CustomPortletMode> customPortletMode;
    @XmlElement(name = "custom-window-state", type=CustomWindowStateType.class)
    protected List<CustomWindowState> customWindowState;
    @XmlElement(name = "user-attribute", type=UserAttributeType.class)
    protected List<UserAttribute> userAttribute;
    @XmlElement(name = "security-constraint", type=SecurityConstraintType.class)
    protected List<SecurityConstraint> securityConstraint;
    @XmlElement(name = "resource-bundle")
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected String resourceBundle;
    @XmlElement(name = "filter", type=FilterType.class)
    protected List<Filter> filter;
    @XmlElement(name = "filter-mapping", type=FilterMappingType.class)
    protected List<FilterMapping> filterMapping;
    @XmlElement(name = "default-namespace")
    @XmlSchemaType(name = "anyURI")
    protected String defaultNamespace;
    @XmlElement(name = "event-definition", type=EventDefinitionType.class)
    protected List<EventDefinition> eventDefinition;
    @XmlElement(name = "public-render-parameter", type=PublicRenderParameterType.class)
    protected List<PublicRenderParameter> publicRenderParameter;
    @XmlElement(name = "listener", type=ListenerType.class)
    protected List<Listener> listener;
    @XmlElement(name = "container-runtime-option", type=ContainerRuntimeOptionType.class)
    protected List<ContainerRuntimeOption> containerRuntimeOption;
    @XmlAttribute(required = true)
    protected String version;
    @XmlAttribute
    protected String id;
    
    @XmlTransient
    protected String name;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public ElementFactoryList<PortletDefinition> getPortlets()
    {
        if (portlet == null || !(portlet instanceof ElementFactoryList))
        {
            ElementFactoryList<PortletDefinition> lf = 
                new ElementFactoryList<PortletDefinition>( new ElementFactoryList.Factory<PortletDefinition>()
                {
                    public Class<? extends PortletDefinition> getElementClass()
                    {
                        return PortletType.class;
                    }

                    public PortletDefinition newElement()
                    {
                        return new PortletType();
                    }
                }); 
            if (portlet != null)
            {
                lf.addAll(portlet);
            }
            portlet = lf;
        }
        return (ElementFactoryList<PortletDefinition>)portlet;
    }

    public ElementFactoryList<CustomPortletMode> getCustomPortletModes()
    {
        if (customPortletMode == null || !(customPortletMode instanceof ElementFactoryList))
        {
            ElementFactoryList<CustomPortletMode> lf = 
                new ElementFactoryList<CustomPortletMode>( new ElementFactoryList.Factory<CustomPortletMode>()
                {
                    public Class<? extends CustomPortletMode> getElementClass()
                    {
                        return CustomPortletModeType.class;
                    }

                    public CustomPortletMode newElement()
                    {
                        return new CustomPortletModeType();
                    }
                }); 
            if (customPortletMode != null)
            {
                lf.addAll(customPortletMode);
            }
            customPortletMode = lf;
        }
        return (ElementFactoryList<CustomPortletMode>)customPortletMode;
    }

    public ElementFactoryList<CustomWindowState> getCustomWindowStates()
    {
        if (customWindowState == null || !(customWindowState instanceof ElementFactoryList))
        {
            ElementFactoryList<CustomWindowState> lf = 
                new ElementFactoryList<CustomWindowState>( new ElementFactoryList.Factory<CustomWindowState>()
                {
                    public Class<? extends CustomWindowState> getElementClass()
                    {
                        return CustomWindowStateType.class;
                    }

                    public CustomWindowState newElement()
                    {
                        return new CustomWindowStateType();
                    }
                }); 
            if (customWindowState != null)
            {
                lf.addAll(customWindowState);
            }
            customWindowState = lf;
        }
        return (ElementFactoryList<CustomWindowState>)customWindowState;
    }

    public ElementFactoryList<UserAttribute> getUserAttributes()
    {
        if (userAttribute == null || !(userAttribute instanceof ElementFactoryList))
        {
            ElementFactoryList<UserAttribute> lf = 
                new ElementFactoryList<UserAttribute>( new ElementFactoryList.Factory<UserAttribute>()
                {
                    public Class<? extends UserAttribute> getElementClass()
                    {
                        return UserAttributeType.class;
                    }

                    public UserAttribute newElement()
                    {
                        return new UserAttributeType();
                    }
                }); 
            if (userAttribute != null)
            {
                lf.addAll(userAttribute);
            }
            userAttribute = lf;
        }
        return (ElementFactoryList<UserAttribute>)userAttribute;
    }

    public ElementFactoryList<SecurityConstraint> getSecurityConstraints()
    {
        if (securityConstraint == null || !(securityConstraint instanceof ElementFactoryList))
        {
            ElementFactoryList<SecurityConstraint> lf = 
                new ElementFactoryList<SecurityConstraint>( new ElementFactoryList.Factory<SecurityConstraint>()
                {
                    public Class<? extends SecurityConstraint> getElementClass()
                    {
                        return SecurityConstraintType.class;
                    }

                    public SecurityConstraint newElement()
                    {
                        return new SecurityConstraintType();
                    }
                }); 
            if (securityConstraint != null)
            {
                lf.addAll(securityConstraint);
            }
            securityConstraint = lf;
        }
        return (ElementFactoryList<SecurityConstraint>)securityConstraint;
    }

    public String getResourceBundle()
    {
        return resourceBundle;
    }

    public void setResourceBundle(String value)
    {
        resourceBundle = value;
    }

    public ElementFactoryList<Filter> getFilters()
    {
        if (filter == null || !(filter instanceof ElementFactoryList))
        {
            ElementFactoryList<Filter> lf = 
                new ElementFactoryList<Filter>( new ElementFactoryList.Factory<Filter>()
                {
                    public Class<? extends Filter> getElementClass()
                    {
                        return FilterType.class;
                    }

                    public Filter newElement()
                    {
                        return new FilterType();
                    }
                }); 
            if (filter != null)
            {
                lf.addAll(filter);
            }
            filter = lf;
        }
        return (ElementFactoryList<Filter>)filter;
    }

    public ElementFactoryList<FilterMapping> getFilterMappings()
    {
        if (filterMapping == null || !(filterMapping instanceof ElementFactoryList))
        {
            ElementFactoryList<FilterMapping> lf = 
                new ElementFactoryList<FilterMapping>( new ElementFactoryList.Factory<FilterMapping>()
                {
                    public Class<? extends FilterMapping> getElementClass()
                    {
                        return FilterMappingType.class;
                    }

                    public FilterMapping newElement()
                    {
                        return new FilterMappingType();
                    }
                }); 
            if (filterMapping != null)
            {
                lf.addAll(filterMapping);
            }
            filterMapping = lf;
        }
        return (ElementFactoryList<FilterMapping>)filterMapping;
    }

    public String getDefaultNamespace()
    {
        return defaultNamespace != null ? defaultNamespace : XMLConstants.NULL_NS_URI;
    }

    public void setDefaultNamespace(String value)
    {
        defaultNamespace = value;
    }

    public ElementFactoryList<EventDefinition> getEventDefinitions()
    {
        if (eventDefinition == null || !(eventDefinition instanceof ElementFactoryList))
        {
            ElementFactoryList<EventDefinition> lf = 
                new ElementFactoryList<EventDefinition>( new ElementFactoryList.Factory<EventDefinition>()
                {
                    public Class<? extends EventDefinition> getElementClass()
                    {
                        return EventDefinitionType.class;
                    }

                    public EventDefinition newElement()
                    {
                        return new EventDefinitionType();
                    }
                }); 
            if (eventDefinition != null)
            {
                lf.addAll(eventDefinition);
            }
            eventDefinition = lf;
        }
        return (ElementFactoryList<EventDefinition>)eventDefinition;
    }

    public ElementFactoryList<PublicRenderParameter> getPublicRenderParameters()
    {
        if (publicRenderParameter == null || !(publicRenderParameter instanceof ElementFactoryList))
        {
            ElementFactoryList<PublicRenderParameter> lf = 
                new ElementFactoryList<PublicRenderParameter>( new ElementFactoryList.Factory<PublicRenderParameter>()
                {
                    public Class<? extends PublicRenderParameter> getElementClass()
                    {
                        return PublicRenderParameterType.class;
                    }

                    public PublicRenderParameter newElement()
                    {
                        return new PublicRenderParameterType();
                    }
                }); 
            if (publicRenderParameter != null)
            {
                lf.addAll(publicRenderParameter);
            }
            publicRenderParameter = lf;
        }
        return (ElementFactoryList<PublicRenderParameter>)publicRenderParameter;
    }

    public ElementFactoryList<Listener> getListeners()
    {
        if (listener == null || !(listener instanceof ElementFactoryList))
        {
            ElementFactoryList<Listener> lf = 
                new ElementFactoryList<Listener>( new ElementFactoryList.Factory<Listener>()
                {
                    public Class<? extends Listener> getElementClass()
                    {
                        return ListenerType.class;
                    }

                    public Listener newElement()
                    {
                        return new ListenerType();
                    }
                }); 
            if (listener != null)
            {
                lf.addAll(listener);
            }
            listener = lf;
        }
        return (ElementFactoryList<Listener>)listener;
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

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String value)
    {
        version = value;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String value)
    {
        id = value;
    }
}
