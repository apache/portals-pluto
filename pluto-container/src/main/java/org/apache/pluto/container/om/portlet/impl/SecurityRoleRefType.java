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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.SecurityRoleRef;

/**
 * The security-role-ref element contains the declaration of a security role reference in the code of the web
 * application. The declaration consists of an optional description, the security role name used in the code, and an
 * optional link to a security role. If the security role is not specified, the Deployer must choose an appropriate
 * security role. The value of the role name element must be the String used as the parameter to the
 * EJBContext.isCallerInRole(String roleName) method or the HttpServletRequest.isUserInRole(String role) method. Used
 * in: portlet <p>Java class for security-role-refType complex type. <p>The following schema fragment specifies the
 * expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;security-role-refType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;description&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}descriptionType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;role-name&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}role-nameType&quot;/&gt;
 *         &lt;element name=&quot;role-link&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}role-linkType&quot; minOccurs=&quot;0&quot;/&gt;
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
@XmlType(name = "security-role-refType", propOrder = { "description", "roleName", "roleLink" })
public class SecurityRoleRefType implements SecurityRoleRef
{
    @XmlElement(name = "description")
    protected List<DescriptionType> description;
    @XmlElement(name = "role-name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String roleName;
    @XmlElement(name = "role-link")
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected String roleLink;

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

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String value)
    {
        roleName = value;
    }

    public String getRoleLink()
    {
        return roleLink;
    }

    public void setRoleLink(String value)
    {
        roleLink = value;
    }
}
