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
package org.apache.pluto.container.om.portlet10.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
public class PortletType
{
    @XmlElement(name = "description")
    List<DescriptionType> description;
    @XmlElement(name = "portlet-name", required = true)
    @XmlJavaTypeAdapter(value = CollapsedStringAdapter.class)
    String portletName;
    @XmlElement(name = "display-name")
    List<DisplayNameType> displayName;
    @XmlElement(name = "portlet-class", required = true)
    @XmlJavaTypeAdapter(value = CollapsedStringAdapter.class)
    String portletClass;
    @XmlElement(name = "init-param")
    List<InitParamType> initParam;
    @XmlElement(name = "expiration-cache")
    Integer expirationCache;
    @XmlElement(required = true)
    List<SupportsType> supports;
    @XmlElement(name = "supported-locale")
    @XmlJavaTypeAdapter(value = CollapsedStringAdapter.class)
    List<String> supportedLocale;
    @XmlElement(name = "resource-bundle")
    @XmlJavaTypeAdapter(value = CollapsedStringAdapter.class)
    String resourceBundle;
    @XmlElement(name = "portlet-info")
    PortletInfoType portletInfo;
    @XmlElement(name = "portlet-preferences")
    PortletPreferencesType portletPreferences;
    @XmlElement(name = "security-role-ref")
    List<SecurityRoleRefType> securityRoleRef;
}
