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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>Java class for portlet-infoType complex type. <p>The following schema fragment specifies the expected content
 * contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;portlet-infoType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;title&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}titleType&quot;/&gt;
 *         &lt;element name=&quot;short-title&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}short-titleType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;keywords&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}keywordsType&quot; minOccurs=&quot;0&quot;/&gt;
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
@XmlType(name = "portlet-infoType", propOrder = { "title", "shortTitle", "keywords" })
public class PortletInfoType
{
    @XmlElement(name = "title")
    @XmlJavaTypeAdapter(value = CollapsedStringAdapter.class)
    String title;
    @XmlElement(name = "short-title")
    @XmlJavaTypeAdapter(value = CollapsedStringAdapter.class)
    String shortTitle;
    @XmlElement(name = "keywords")
    @XmlJavaTypeAdapter(value = CollapsedStringAdapter.class)
    String keywords;
}
