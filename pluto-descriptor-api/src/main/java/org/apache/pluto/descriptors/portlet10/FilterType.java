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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.om.ElementFactoryList;
import org.apache.pluto.om.common.Description;
import org.apache.pluto.om.common.DisplayName;
import org.apache.pluto.om.common.InitParam;
import org.apache.pluto.om.portlet.Filter;

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
    @XmlElement(name = "description", type=DescriptionType.class)
    protected List<Description> description;
    @XmlElement(name = "display-name", type=DisplayNameType.class)
    protected List<DisplayName> displayName;
    @XmlElement(name = "filter-name", required = true)
    protected String filterName;
    @XmlElement(name = "filter-class", required = true)
    protected String filterClass;
    @XmlElement(required = true)
    protected List<String> lifecycle;
    @XmlElement(name = "init-param", type=InitParamType.class)
    protected List<InitParam> initParam;

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

    public ElementFactoryList<InitParam> getInitParams()
    {
        if (initParam == null || !(initParam instanceof ElementFactoryList))
        {
            ElementFactoryList<InitParam> lf = 
                new ElementFactoryList<InitParam>( new ElementFactoryList.Factory<InitParam>()
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
        return (ElementFactoryList<InitParam>)initParam;
    }

    public void setLifecycles(List<String> lifecycles)
    {
        this.lifecycle = lifecycles;
    }
}
