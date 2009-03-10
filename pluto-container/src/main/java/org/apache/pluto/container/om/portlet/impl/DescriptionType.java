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

import java.util.Locale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.pluto.container.om.portlet.Description;

/**
 * The description element is used to provide text describing the parent element. The description element should include
 * any information that the portlet application war file producer wants to provide to the consumer of the portlet
 * application war file (i.e., to the Deployer). Typically, the tools used by the portlet application war file consumer
 * will display the description when processing the parent element that contains the description. It has an optional
 * attribute xml:lang to indicate which language is used in the description according to RFC 1766
 * (http://www.ietf.org/rfc/rfc1766.txt). The default value of this attribute is English(“en”). Used in: init-param,
 * portlet, portlet-app, security-role <p>Java class for descriptionType complex type. <p>The following schema
 * fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;descriptionType&quot;&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base=&quot;&lt;http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd&gt;string&quot;&gt;
 *       &lt;attribute ref=&quot;{http://www.w3.org/XML/1998/namespace}lang&quot;/&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * @version $Id$
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "descriptionType", propOrder = { "value" })
public class DescriptionType implements Description
{
    @XmlValue
    @XmlJavaTypeAdapter(value=CollapsedStringAdapter.class)
    protected String value;
    @XmlAttribute(namespace = "http://www.w3.org/XML/1998/namespace")
    protected String lang = null;
    @XmlTransient
    protected Locale locale;

    public String getDescription()
    {
        return value;
    }

    public void setDescription(String value)
    {
        this.value = value;
    }

    public String getLang()
    {
        return lang == null ? Locale.ENGLISH.toString() : lang;
    }

    public void setLang(String value)
    {
        lang = value;
        deriveLocale();
    }
    
    public Locale getLocale()
    {
        return locale == null ? deriveLocale() : locale;
    }
    
    protected Locale deriveLocale()
    {
        Locale locale = null;
        String lang = this.getLang();
        if (lang != null)
        {
            String country = "";
            String variant = "";
            String[] localeArray = lang.split("[-|_]");
            for (int i = 0; i < localeArray.length; i++)
            {
                if (i == 0)
                {
                    lang = localeArray[i];
                }
                else if (i == 1)
                {
                    country = localeArray[i];
                }
                else if (i == 2)
                {
                    variant = localeArray[i];
                }
            }
            locale = new Locale(lang, country, variant);
        }
        return this.locale = locale;
    }
}
