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
import org.apache.pluto.om.common.Description;
import org.apache.pluto.om.common.DisplayName;
import org.apache.pluto.om.common.InitParam;
import org.apache.pluto.om.common.SecurityRoleRef;
import org.apache.pluto.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.om.portlet.EventDefinitionReference;
import org.apache.pluto.om.portlet.Portlet;
import org.apache.pluto.om.portlet.PortletApp;
import org.apache.pluto.om.portlet.PortletInfo;
import org.apache.pluto.om.portlet.PortletPreferences;
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
 *         &lt;element name=&quot;description&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}descriptionType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;portlet-name&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}portlet-nameType&quot;/&gt;
 *         &lt;element name=&quot;display-name&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}display-nameType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;portlet-class&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}portlet-classType&quot;/&gt;
 *         &lt;element name=&quot;init-param&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}init-paramType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;expiration-cache&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}expiration-cacheType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;supports&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}supportsType&quot; maxOccurs=&quot;unbounded&quot;/&gt;
 *         &lt;element name=&quot;supported-locale&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}supported-localeType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name=&quot;resource-bundle&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}resource-bundleType&quot;/&gt;
 *             &lt;element name=&quot;portlet-info&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}portlet-infoType&quot; minOccurs=&quot;0&quot;/&gt;
 *           &lt;/sequence&gt;
 *           &lt;element name=&quot;portlet-info&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}portlet-infoType&quot;/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name=&quot;portlet-preferences&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}portlet-preferencesType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;security-role-ref&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}security-role-refType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name=&quot;id&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * @version $Id$
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portletType", propOrder = { "description", "portletName", "displayName", "portletClass", "initParam",
                                            "expirationCache", "supports", "supportedLocale", "resourceBundle",
                                            "portletInfo", "portletPreferences", "securityRoleRef" })
public class PortletType implements Portlet
{
    @XmlElement(name = "description", type = DescriptionType.class)
    protected List<Description> description;
    @XmlElement(name = "portlet-name", required = true)
    @XmlJavaTypeAdapter(value = CollapsedStringAdapter.class)
    protected String portletName;
    @XmlElement(name = "display-name", type = DisplayNameType.class)
    protected List<DisplayName> displayName;
    @XmlElement(name = "portlet-class", required = true)
    @XmlJavaTypeAdapter(value = CollapsedStringAdapter.class)
    protected String portletClass;
    @XmlElement(name = "init-param", type = InitParamType.class)
    protected List<InitParam> initParam;
    @XmlElement(name = "expiration-cache")
    protected Integer expirationCache;
    @XmlElement(required = true, type = SupportsType.class)
    protected List<Supports> supports;
    @XmlElement(name = "supported-locale")
    @XmlJavaTypeAdapter(value = CollapsedStringAdapter.class)
    protected List<String> supportedLocale;
    @XmlElement(name = "resource-bundle")
    @XmlJavaTypeAdapter(value = CollapsedStringAdapter.class)
    protected String resourceBundle;
    @XmlElement(name = "portlet-info")
    protected PortletInfoType portletInfo;
    @XmlElement(name = "portlet-preferences")
    protected PortletPreferencesType portletPreferences;
    @XmlElement(name = "security-role-ref", type = SecurityRoleRefType.class)
    protected List<SecurityRoleRef> securityRoleRef;
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
            ElementFactoryList<Description> lf = new ElementFactoryList<Description>(new ElementFactoryList.Factory<Description>()
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
        return (ElementFactoryList<Description>) description;
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
            ElementFactoryList<DisplayName> lf = new ElementFactoryList<DisplayName>(new ElementFactoryList.Factory<DisplayName>()
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
        return (ElementFactoryList<DisplayName>) displayName;
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
            ElementFactoryList<InitParam> lf = new ElementFactoryList<InitParam>(new ElementFactoryList.Factory<InitParam>()
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
        return (ElementFactoryList<InitParam>) initParam;
    }

    public int getExpirationCache()
    {
        return expirationCache != null ? expirationCache.intValue() : 0;
    }

    public void setExpirationCache(int value)
    {
        expirationCache = new Integer(value);
    }

    public String getCacheScope()
    {
        return null;
    }

    public void setCacheScope(String cacheScope)
    {
        throw new UnsupportedOperationException();
    }

    public ElementFactoryList<Supports> getSupports()
    {
        if (supports == null || !(supports instanceof ElementFactoryList))
        {
            ElementFactoryList<Supports> lf = new ElementFactoryList<Supports>(new ElementFactoryList.Factory<Supports>()
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
        return (ElementFactoryList<Supports>) supports;
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
            ElementFactoryList<SecurityRoleRef> lf = new ElementFactoryList<SecurityRoleRef>(
                                                                                   new ElementFactoryList.Factory<SecurityRoleRef>()
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
        return (ElementFactoryList<SecurityRoleRef>) securityRoleRef;
    }

    public ElementFactoryList<EventDefinitionReference> getSupportedProcessingEvents()
    {
        return null;
    }

    public ElementFactoryList<EventDefinitionReference> getSupportedPublishingEvents()
    {
        return null;
    }

    public List<String> getSupportedPublicRenderParameters()
    {
        return null;
    }

    public ElementFactoryList<ContainerRuntimeOption> getContainerRuntimeOptions()
    {
        return null;
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
        throw new UnsupportedOperationException();
    }

    public void afterUnmarshal(Unmarshaller u, Object parent)
    {
        application = (PortletApp) parent;
    }
}
