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

import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.DisplayName;
import org.apache.pluto.container.om.portlet.Filter;
import org.apache.pluto.container.om.portlet.InitParam;

/**
 * The filter element specifies a filter that can transform the content of portlet requests and portlet responses.
 * Filters can access the initialization parameters declared in the deployment descriptor at runtime via the
 * FilterConfig interface. A filter can be restricted to one or more lifecycle phases of the portlet. Valid entries for
 * lifecycle are: ACTION_PHASE, EVENT_PHASE, RENDER_PHASE, RESOURCE_PHASE Used in: portlet-app <p>Java class for
 * filterType complex type. <p>The following schema fragment specifies the expected content contained within this
 * class.
 * 
 * <pre>
 * &lt;complexType name=&quot;filterType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;description&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}descriptionType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;display-name&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}display-nameType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;filter-name&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}filter-nameType&quot;/&gt;
 *         &lt;element name=&quot;filter-class&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}fully-qualified-classType&quot;/&gt;
 *         &lt;element name=&quot;lifecycle&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}string&quot; maxOccurs=&quot;unbounded&quot;/&gt;
 *         &lt;element name=&quot;init-param&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}init-paramType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * @version $Id$
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filterType", propOrder = { "description", "displayName", "filterName", "filterClass", "lifecycle",
                                           "initParam" })
public class FilterType implements Filter
{
    @XmlElement(name = "description")
    protected List<DescriptionType> description;
    @XmlElement(name = "display-name")
    protected List<DisplayNameType> displayName;
    @XmlElement(name = "filter-name", required = true)
    protected String filterName;
    @XmlElement(name = "filter-class", required = true)
    protected String filterClass;
    @XmlElement(required = true)
    protected List<String> lifecycle;
    @XmlElement(name = "init-param")
    protected List<InitParamType> initParam;

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

    public String getFilterName()
    {
        return filterName;
    }

    public void setFilterName(String value)
    {
        filterName = value;
    }

    public String getFilterClass()
    {
        return filterClass;
    }

    public void setFilterClass(String value)
    {
        filterClass = value;
    }

    public List<String> getLifecycles()
    {
        if (lifecycle == null)
        {
            lifecycle = new ArrayList<String>();
        }
        return lifecycle;
    }
    
    public void addLifecycle(String name)
    {
        // TODO: check valid name and duplicates
        getLifecycles().add(name);
    }
    
    public InitParam getInitParam(String name)
    {
        for (InitParam param : getInitParams())
        {
            if (param.getParamName().equals(name))
            {
                return param;
            }
        }
        return null;
    }

    public List<? extends InitParam> getInitParams()
    {
        if (initParam == null)
        {
            initParam = new ArrayList<InitParamType>();
        }
        return initParam;
    }
    
    public InitParam addInitParam(String paramName)
    {
        if (getInitParam(paramName) != null)
        {
            throw new IllegalArgumentException("Init parameter: "+paramName+" already defined");
        }
        InitParamType param = new InitParamType();
        param.setParamName(paramName);
        getInitParams();
        initParam.add(param);
        return param;
    }
}
