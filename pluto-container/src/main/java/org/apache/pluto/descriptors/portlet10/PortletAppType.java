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
package org.apache.pluto.descriptors.portlet10;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

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
 * <p>Java class for portlet-appType complex type.</p> <p>The following schema fragment specifies the expected
 * content contained within this class.</p>
 * 
 * <pre>
 * &lt;complexType name=&quot;portlet-appType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;portlet&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}portletType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;custom-portlet-mode&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}custom-portlet-modeType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;custom-window-state&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}custom-window-stateType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;user-attribute&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}user-attributeType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;security-constraint&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}security-constraintType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name=&quot;version&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;id&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
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
                                                "securityConstraint" })
public class PortletAppType implements PortletApplicationDefinition
{
    @XmlElement(name = "portlet", type = PortletType.class)
    protected List<PortletDefinition> portlet;
    @XmlElement(name = "custom-portlet-mode", type = CustomPortletModeType.class)
    protected List<CustomPortletMode> customPortletMode;
    @XmlElement(name = "custom-window-state", type = CustomWindowStateType.class)
    protected List<CustomWindowState> customWindowState;
    @XmlElement(name = "user-attribute", type = UserAttributeType.class)
    protected List<UserAttribute> userAttribute;
    @XmlElement(name = "security-constraint", type = SecurityConstraintType.class)
    protected List<SecurityConstraint> securityConstraint;
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
            ElementFactoryList<PortletDefinition> lf = new ElementFactoryList<PortletDefinition>(new ElementFactoryList.Factory<PortletDefinition>()
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
        return (ElementFactoryList<PortletDefinition>) portlet;
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
        return null;
    }

    public void setResourceBundle(String value)
    {
        throw new UnsupportedOperationException();
    }

    public ElementFactoryList<Filter> getFilters()
    {
        return null;
    }

    public ElementFactoryList<FilterMapping> getFilterMappings()
    {
        return null;
    }

    public String getDefaultNamespace()
    {
        return null;
    }

    public void setDefaultNamespace(String value)
    {
        throw new UnsupportedOperationException();
    }

    public ElementFactoryList<EventDefinition> getEventDefinitions()
    {
        return null;
    }

    public ElementFactoryList<PublicRenderParameter> getPublicRenderParameters()
    {
        return null;
    }

    public ElementFactoryList<Listener> getListeners()
    {
        return null;
    }

    public ElementFactoryList<ContainerRuntimeOption> getContainerRuntimeOptions()
    {
        return null;
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
