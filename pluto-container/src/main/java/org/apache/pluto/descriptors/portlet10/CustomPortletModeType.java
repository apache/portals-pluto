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
import java.util.Locale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.pluto.om.ElementFactoryList;
import org.apache.pluto.om.portlet.CustomPortletMode;
import org.apache.pluto.om.portlet.Description;

/**
 * A custom portlet mode that one or more portlets in this portlet application supports. Used in: portlet-app <p>Java
 * class for custom-portlet-modeType complex type. <p>The following schema fragment specifies the expected content
 * contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;custom-portlet-modeType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;description&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}descriptionType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;portlet-mode&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}portlet-modeType&quot;/&gt;
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
@XmlType(name = "custom-portlet-modeType", propOrder = { "description", "portletMode" })
public class CustomPortletModeType implements CustomPortletMode
{
    @XmlElement(name = "description", type = DescriptionType.class)
    protected List<Description> description;
    @XmlElement(name = "portlet-mode", required = true)
    @XmlJavaTypeAdapter(value = CollapsedStringAdapter.class)
    protected String portletMode;

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

    public String getPortletMode()
    {
        return portletMode != null ? portletMode.toLowerCase() : null;
    }

    public void setPortletMode(String value)
    {
        portletMode = value != null ? value.toLowerCase() : null;
    }

    public boolean isPortalManaged()
    {
        throw new UnsupportedOperationException();
    }

    public void setPortalManaged(boolean value)
    {
        throw new UnsupportedOperationException();
    }
}
