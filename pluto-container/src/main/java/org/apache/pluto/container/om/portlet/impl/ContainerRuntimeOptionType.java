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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;

/**
 * The container-runtime-option element contains settings for the portlet container that the portlet expects to be
 * honored at runtime. These settings may re-define default portlet container behavior, like the javax.portlet.escapeXml
 * setting that disables XML encoding of URLs produced by the portlet tag library as default. Names with the
 * javax.portlet prefix are reserved for the Java Portlet Specification. Used in: portlet-app, portlet <p>Java class
 * for container-runtime-optionType complex type. <p>The following schema fragment specifies the expected content
 * contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;container-runtime-optionType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;name&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}nameType&quot;/&gt;
 *         &lt;element name=&quot;value&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}valueType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * @version $Id$
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "container-runtime-optionType", propOrder = { "name", "value" })
public class ContainerRuntimeOptionType implements ContainerRuntimeOption
{
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected String name;
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected List<String> value;

    public String getName()
    {
        return name;
    }

    public void setName(String value)
    {
        name = value;
    }

    public List<String> getValues()
    {
        if (value == null)
        {
            value = new ArrayList<String>();
        }
        return value;
    }

    public void addValue(String value)
    {
        getValues().add(value);
    }
}
