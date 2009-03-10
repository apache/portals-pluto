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

import org.apache.pluto.container.om.portlet.FilterMapping;

/**
 * Declaration of the filter mappings in this portlet application is done by using filter-mappingType. The container
 * uses the filter-mapping declarations to decide which filters to apply to a request, and in what order. To determine
 * which filters to apply it matches filter-mapping declarations on the portlet-name and the lifecyle phase defined in
 * the filter element. The order in which filters are invoked is the order in which filter-mapping declarations that
 * match appear in the list of filter-mapping elements. Used in: portlet-app <p>Java class for filter-mappingType
 * complex type. <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;filter-mappingType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;filter-name&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}filter-nameType&quot;/&gt;
 *         &lt;element name=&quot;portlet-name&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}portlet-nameType&quot; maxOccurs=&quot;unbounded&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * @version $Id$
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filter-mappingType", propOrder = { "filterName", "portletName" })
public class FilterMappingType implements FilterMapping
{
    @XmlElement(name = "filter-name", required = true)
    protected String filterName;
    @XmlElement(name = "portlet-name", required = true)
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected List<String> portletName;

    public String getFilterName()
    {
        return filterName;
    }

    public void setFilterName(String value)
    {
        filterName = value;
    }

    public List<String> getPortletNames()
    {
        if (portletName == null)
        {
            portletName = new ArrayList<String>();
        }
        return portletName;
    }
    
    public void addPortletName(String name)
    {
        // TODO: check for duplicates
        getPortletNames().add(name);
    }
}
