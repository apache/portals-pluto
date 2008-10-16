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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.pluto.om.ElementFactoryList;
import org.apache.pluto.om.portlet.CustomWindowState;
import org.apache.pluto.om.portlet.Description;

/**
 * A custom window state that one or more portlets in this portlet application supports. Used in: portlet-app <p>Java
 * class for custom-window-stateType complex type. <p>The following schema fragment specifies the expected content
 * contained within this class.
 * 
 * <pre>
 * &lt;complexType name="custom-window-stateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}descriptionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="window-state" type="{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}window-stateType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @version $Id$
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "custom-window-stateType", propOrder = { "description", "windowState" })
public class CustomWindowStateType implements CustomWindowState
{
    @XmlElement(name = "description", type=DescriptionType.class)
    protected List<Description> description;
    @XmlElement(name = "window-state", required = true)
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected String windowState;

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

    public String getWindowState()
    {
        return windowState != null ? windowState.toLowerCase() : null;
    }

    public void setWindowState(String value)
    {
        windowState = value != null ? value.toLowerCase() : null;
    }
}
