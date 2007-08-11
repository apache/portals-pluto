/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.descriptors.portlet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Implementation of the Portlet Info descriptor element.
 * @since 1.1.0-SNAPSHOT
 *
 * <p>Java class for portlet-infoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="portlet-infoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="title" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}titleType" minOccurs="0"/>
 *         &lt;element name="short-title" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}short-titleType" minOccurs="0"/>
 *         &lt;element name="keywords" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}keywordsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portlet-infoType", propOrder = {
    "title","title1",
    "shortTitle","shortTitle1",
    "keywords","keywords1"
})
public class PortletInfoDD {
	@XmlElement (name = "title")
    private String title;
	
	@XmlElement (name = "title", namespace =PortletDD.QNAME_JSR168)
    private String title1;
    
    @XmlElement (name = "short-title")
    private String shortTitle;
    
    @XmlElement (name = "short-title", namespace =PortletDD.QNAME_JSR168)
    private String shortTitle1;
    
    @XmlElement (name="keywords")
    private String keywords;
    
    @XmlElement (name="keywords", namespace =PortletDD.QNAME_JSR168)
    private String keywords1;

    public String getTitle() {
    	if (title != null)
    		return title;
    	return title1;
    }

    public void setTitle(String title) {
    	this.title = title;
    	this.title1 = title;
    }

    public String getKeywords() {
    	if (keywords != null)
    		return keywords;
    	return keywords1;
    }

    public void setKeywords(String keywords) {
    	this.keywords = keywords;
    	this.keywords1 = keywords;
    }

    public String getShortTitle() {
    	if (shortTitle != null)
    		return shortTitle;
    	return shortTitle1;
    }

    public void setShortTitle(String shortTitle) {
    	this.shortTitle = shortTitle;
    	this.shortTitle1 = shortTitle;
    }

}
