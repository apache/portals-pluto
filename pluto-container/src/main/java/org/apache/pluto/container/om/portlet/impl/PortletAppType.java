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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import javax.xml.namespace.QName;

import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.container.om.portlet.CustomPortletMode;
import org.apache.pluto.container.om.portlet.CustomWindowState;
import org.apache.pluto.container.om.portlet.EventDefinition;
import org.apache.pluto.container.om.portlet.Filter;
import org.apache.pluto.container.om.portlet.FilterMapping;
import org.apache.pluto.container.om.portlet.Listener;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.PublicRenderParameter;
import org.apache.pluto.container.om.portlet.SecurityConstraint;
import org.apache.pluto.container.om.portlet.UserAttribute;

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
    @XmlElement(name = "portlet")
    protected List<PortletType> portlet;
    @XmlElement(name = "custom-portlet-mode")
    protected List<CustomPortletModeType> customPortletMode;
    @XmlElement(name = "custom-window-state")
    protected List<CustomWindowStateType> customWindowState;
    @XmlElement(name = "user-attribute")
    protected List<UserAttributeType> userAttribute;
    @XmlElement(name = "security-constraint")
    protected List<SecurityConstraintType> securityConstraint;
    @XmlElement(name = "resource-bundle")
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected String resourceBundle;
    @XmlElement(name = "filter")
    protected List<FilterType> filter;
    @XmlElement(name = "filter-mapping")
    protected List<FilterMappingType> filterMapping;
    @XmlElement(name = "default-namespace")
    @XmlSchemaType(name = "anyURI")
    protected String defaultNamespace;
    @XmlElement(name = "event-definition")
    protected List<EventDefinitionType> eventDefinition;
    @XmlElement(name = "public-render-parameter")
    protected List<PublicRenderParameterType> publicRenderParameter;
    @XmlElement(name = "listener")
    protected List<ListenerType> listener;
    @XmlElement(name = "container-runtime-option")
    protected List<ContainerRuntimeOptionType> containerRuntimeOption;
    @XmlAttribute(required = true)
    protected String version = JSR_286_VERSION;
    
    @XmlTransient
    protected String name;
    @XmlTransient
    protected String contextPath;
    @XmlTransient
    protected Map<Locale, String> localeEncodingMappings;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getContextPath()
    {
        return contextPath;
    }
    
    public void setContextPath(String contextPath)
    {
        this.contextPath = contextPath;
    }
    
    public PortletDefinition getPortlet(String portletName)
    {
        for (PortletDefinition pd : getPortlets())
        {
            if (pd.getPortletName().equals(portletName))
            {
                return pd;
            }
        }
        return null;
    }
    
    public List<? extends PortletDefinition> getPortlets()
    {
        if (portlet == null)
        {
            portlet = new ArrayList<PortletType>();
        }
        return portlet;
    }
    
    public PortletDefinition addPortlet(String portletName)
    {
        if (getPortlet(portletName) != null)
        {
            throw new IllegalArgumentException("Portlet with name: "+portletName+" already defined");
        }
        PortletType p = new PortletType();
        p.setPortletName(portletName);
        p.setApplication(this);
        portlet.add(p);
        return p;
    }

    public CustomPortletMode getCustomPortletMode(String name)
    {
        for (CustomPortletMode cpm : getCustomPortletModes())
        {
            if (cpm.getPortletMode().equalsIgnoreCase(name))
            {
                return cpm;
            }
        }
        return null;
    }
    
    public List<? extends CustomPortletMode> getCustomPortletModes()
    {
        if (customPortletMode == null)
        {
            customPortletMode = new ArrayList<CustomPortletModeType>();
        }
        return customPortletMode;
    }
    
    public CustomPortletMode addCustomPortletMode(String name)
    {
        if (getCustomPortletMode(name) != null)
        {
            throw new IllegalArgumentException("Custom PortletMode with mode name: "+name+" already defined");
        }
        CustomPortletModeType cpm = new CustomPortletModeType();
        cpm.setPortletMode(name);
        customPortletMode.add(cpm);
        return cpm;        
    }
    
    public CustomWindowState getCustomWindowState(String name)
    {
        for (CustomWindowState cws : getCustomWindowStates())
        {
            if (cws.getWindowState().equalsIgnoreCase(name))
            {
                return cws;
            }
        }
        return null;
    }
    
    public List<? extends CustomWindowState> getCustomWindowStates()
    {
        if (customWindowState == null)
        {
            customWindowState = new ArrayList<CustomWindowStateType>();
        }
        return customWindowState;
    }
    
    public CustomWindowState addCustomWindowState(String name)
    {
        if (getCustomWindowState(name) != null)
        {
            throw new IllegalArgumentException("Custom WindowState with state name: "+name+" already defined");
        }
        CustomWindowStateType cws = new CustomWindowStateType();
        cws.setWindowState(name);
        customWindowState.add(cws);
        return cws;        
    }
    
    public UserAttribute getUserAttribute(String name)
    {
        for (UserAttribute ua : getUserAttributes())
        {
            if (ua.getName().equals(name))
            {
                return ua;
            }
        }
        return null;
    }
    
    public List<? extends UserAttribute> getUserAttributes()
    {
        if (userAttribute == null)
        {
            userAttribute = new ArrayList<UserAttributeType>();
        }
        return userAttribute;
    }
    
    public UserAttribute addUserAttribute(String name)
    {
        if (getUserAttribute(name) != null)
        {
            throw new IllegalArgumentException("User attribute with name: "+name+" already defined");
        }
        UserAttributeType ua = new UserAttributeType();
        ua.setName(name);
        userAttribute.add(ua);
        return ua;        
    }
    
    public List<? extends SecurityConstraint> getSecurityConstraints()
    {
        if (securityConstraint == null)
        {
            securityConstraint = new ArrayList<SecurityConstraintType>();
        }
        return securityConstraint;
    }
    
    public SecurityConstraint addSecurityConstraint(String transportGuarantee)
    {
        SecurityConstraintType sc = new SecurityConstraintType();
        ((UserDataConstraintType)sc.getUserDataConstraint()).setTransportGuarantee(transportGuarantee);
        getSecurityConstraints();
        securityConstraint.add(sc);
        return sc;        
    }
    
    public String getResourceBundle()
    {
        return resourceBundle;
    }

    public void setResourceBundle(String value)
    {
        resourceBundle = value;
    }
    
    public Filter getFilter(String name)
    {
        for (Filter f : getFilters())
        {
            if (f.getFilterName().equals(name))
            {
                return f;
            }
        }
        return null;
    }

    public List<? extends Filter> getFilters()
    {
        if (filter == null)
        {
            filter = new ArrayList<FilterType>();
        }
        return filter;
    }
    
    public Filter addFilter(String name)
    {
        if (getFilter(name) != null)
        {
            throw new IllegalArgumentException("Filter with name: "+name+" already defined");
        }
        FilterType f = new FilterType();
        f.setFilterName(name);
        filter.add(f);
        return f;        
    }
    
    public FilterMapping getFilterMapping(String name)
    {
        for (FilterMapping f : getFilterMappings())
        {
            if (f.getFilterName().equals(name))
            {
                return f;
            }
        }
        return null;
    }

    public List<? extends FilterMapping> getFilterMappings()
    {
        if (filterMapping == null)
        {
            filterMapping = new ArrayList<FilterMappingType>();
        }
        return filterMapping;
    }
    
    public FilterMapping addFilterMapping(String name)
    {
        if (getFilterMapping(name) != null)
        {
            throw new IllegalArgumentException("Filtermapping for filter: "+name+" already defined");
        }
        FilterMappingType fm = new FilterMappingType();
        fm.setFilterName(name);
        filterMapping.add(fm);
        return fm;        
    }
    
    public String getDefaultNamespace()
    {
        return defaultNamespace != null ? defaultNamespace : XMLConstants.NULL_NS_URI;
    }

    public void setDefaultNamespace(String value)
    {
        defaultNamespace = value;
    }

    public List<? extends EventDefinition> getEventDefinitions()
    {
        if (eventDefinition == null)
        {
            eventDefinition = new ArrayList<EventDefinitionType>();
        }
        return eventDefinition;
    }
    
    public EventDefinition addEventDefinition(String name)
    {
        // TODO: check duplicates (complication: set of qname and name)
        EventDefinitionType ed = new EventDefinitionType();
        ed.setName(name);
        eventDefinition.add(ed);
        return ed;        
    }
    
    public EventDefinition addEventDefinition(QName qname)
    {
        // TODO: check duplicates (complication: set of qname and name)
        EventDefinitionType ed = new EventDefinitionType();
        ed.setQName(qname);
        eventDefinition.add(ed);
        return ed;        
    }
    
    public PublicRenderParameter getPublicRenderParameter(String identifier)
    {
        for (PublicRenderParameter prp : getPublicRenderParameters())
        {
            if (prp.getIdentifier().equals(identifier))
            {
                return prp;
            }
        }
        return null;
    }
    
    public List<? extends PublicRenderParameter> getPublicRenderParameters()
    {
        if (publicRenderParameter == null)
        {
            publicRenderParameter = new ArrayList<PublicRenderParameterType>();
        }
        return publicRenderParameter;
    }
    
    public PublicRenderParameter addPublicRenderParameter(String name, String identifier)
    {
        if (getPublicRenderParameter(identifier) != null)
        {
            throw new IllegalArgumentException("PublicRenderParameter with identifier: "+identifier+" already defined");
        }
        // TODO: check duplicates on name|qname?
        PublicRenderParameterType p = new PublicRenderParameterType();
        p.setName(name);
        p.setIdentifier(identifier);
        publicRenderParameter.add(p);
        return p;        
    }
    
    public PublicRenderParameter addPublicRenderParameter(QName qname, String identifier)
    {
        if (getPublicRenderParameter(identifier) != null)
        {
            throw new IllegalArgumentException("PublicRenderParameter with identifier: "+identifier+" already defined");
        }
        // TODO: check duplicates on name|qname?
        PublicRenderParameterType p = new PublicRenderParameterType();
        p.setQName(qname);
        p.setIdentifier(identifier);
        publicRenderParameter.add(p);
        return p;        
    }
    
    public List<? extends Listener> getListeners()
    {
        if (listener == null)
        {
            listener = new ArrayList<ListenerType>();
        }
        return listener;
    }
    
    public Listener addListener(String listenerClass)
    {
        for (Listener l : getListeners())
        {
            if (l.getListenerClass().equals(listenerClass))
            {
                throw new IllegalArgumentException("Listener of class: "+listenerClass+" already defined");
            }
        }
        ListenerType l = new ListenerType();
        l.setListenerClass(listenerClass);
        listener.add(l);
        return l;        
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
    
    public String getVersion()
    {
        return version;
    }

    public void setVersion(String value)
    {
        if (JSR_168_VERSION.equals(value) || JSR_286_VERSION.equals(value))
        {
            version = value;
        }
        else
        {
            throw new IllegalArgumentException("Application descriptor version: "+value+" unsupported.");
        }
    }
    
    public Map<Locale, String> getLocaleEncodingMappings()
    {
        if (localeEncodingMappings == null)
        {
            localeEncodingMappings = new HashMap<Locale,String>();
        }
        return localeEncodingMappings;
    }
    
    public void addLocaleEncodingMapping(Locale locale, String encoding)
    {
        getLocaleEncodingMappings().put(locale, encoding);
    }
}
