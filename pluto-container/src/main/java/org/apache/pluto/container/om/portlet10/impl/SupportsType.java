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

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Supports indicates the portlet modes a portlet supports for a specific content type. All portlets must support the
 * view mode. Used in: portlet <p>Java class for supportsType complex type. <p>The following schema fragment specifies
 * the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="supportsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mime-type" type="{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}mime-typeType"/>
 *         &lt;element name="portlet-mode" type="{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}portlet-modeType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "supportsType", propOrder = { "mimeType", "portletMode" })
public class SupportsType
{
    @XmlElement(name = "mime-type", required = true)
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    String mimeType;
    @XmlElement(name = "portlet-mode")
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    List<String> portletMode;
}
