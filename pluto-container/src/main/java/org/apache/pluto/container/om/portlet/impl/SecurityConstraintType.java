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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.container.om.portlet.DisplayName;
import org.apache.pluto.container.om.portlet.SecurityConstraint;
import org.apache.pluto.container.om.portlet.UserDataConstraint;

/**
 * The security-constraintType is used to associate intended security constraints with one or more portlets. Used in:
 * portlet-app <p>Java class for security-constraintType complex type. <p>The following schema fragment specifies the
 * expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;security-constraintType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;display-name&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}display-nameType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;portlet-collection&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}portlet-collectionType&quot;/&gt;
 *         &lt;element name=&quot;user-data-constraint&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}user-data-constraintType&quot;/&gt;
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
@XmlType(name = "security-constraintType", propOrder = { "displayName", "portletCollection", "userDataConstraint" })
public class SecurityConstraintType implements SecurityConstraint
{
    @XmlElement(name = "display-name")
    protected List<DisplayNameType> displayName;
    @XmlElement(name = "portlet-collection", required = true)
    protected PortletCollectionType portletCollection;
    @XmlElement(name = "user-data-constraint", required = true)
    protected UserDataConstraintType userDataConstraint;

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

    public List<String> getPortletNames()
    {
        if (portletCollection == null)
        {
            portletCollection = new PortletCollectionType();
        }
        return portletCollection.getPortletNames();
    }
    
    public void addPortletName(String portletName)
    {
        for (String name : getPortletNames())
        {
            if (name.equals(portletName))
            {
                throw new IllegalArgumentException("Portlet name: "+name+" already defined");
            }
        }
        portletCollection.getPortletNames().add(portletName);        
    }

    public UserDataConstraint getUserDataConstraint()
    {
        if (userDataConstraint == null)
        {
            userDataConstraint = new UserDataConstraintType();
        }
        return userDataConstraint;
    }
}
