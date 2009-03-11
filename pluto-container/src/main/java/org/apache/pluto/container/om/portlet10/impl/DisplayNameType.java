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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * The display-name type contains a short name that is intended to be displayed by tools. It is used by display-name
 * elements. The display name need not be unique. Example: ...
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;display-name xmlns="http://www.w3.org/2001/XMLSchema" xmlns:portlet="http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd" xmlns:xs="http://www.w3.org/2001/XMLSchema" xml:lang="en"&gt;Employee Self Service&lt;/display-name&gt;
 * </pre>
 * 
 * It has an optional attribute xml:lang to indicate which language is used in the description according to RFC 1766
 * (http://www.ietf.org/rfc/rfc1766.txt). The default value of this attribute is English(“en”). <p>Java class for
 * display-nameType complex type. <p>The following schema fragment specifies the expected content contained within this
 * class.
 * 
 * <pre>
 * &lt;complexType name="display-nameType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd>string">
 *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @version $Id$
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "display-nameType", propOrder = { "value" })
public class DisplayNameType
{
    @XmlValue
    @XmlJavaTypeAdapter(value = CollapsedStringAdapter.class)
    String value;
    @XmlAttribute(namespace = "http://www.w3.org/XML/1998/namespace")
    String lang = null;
}
