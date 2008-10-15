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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.om.ElementFactoryList;
import org.apache.pluto.om.common.DisplayName;
import org.apache.pluto.om.common.UserDataConstraint;
import org.apache.pluto.om.portlet.PortletCollection;
import org.apache.pluto.om.portlet.SecurityConstraint;

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
    @XmlElement(name = "display-name", type=DisplayNameType.class)
    protected List<DisplayName> displayName;
    @XmlElement(name = "portlet-collection", required = true)
    protected PortletCollectionType portletCollection;
    @XmlElement(name = "user-data-constraint", required = true)
    protected UserDataConstraintType userDataConstraint;
    @XmlAttribute
    protected String id;

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

    public PortletCollection getPortletCollection()
    {
        if (portletCollection == null)
        {
            portletCollection = new PortletCollectionType();
        }
        return portletCollection;
    }

    public UserDataConstraint getUserDataConstraint()
    {
        if (userDataConstraint == null)
        {
            userDataConstraint = new UserDataConstraintType();
        }
        return userDataConstraint;
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
