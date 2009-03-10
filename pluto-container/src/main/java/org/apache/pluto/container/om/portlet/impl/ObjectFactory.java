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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * org.apache.pluto.descriptors.portlet20 package. <p>An ObjectFactory allows you to programatically construct new
 * instances of the Java representation for XML content. The Java representation of XML content can consist of schema
 * derived interfaces and classes representing the binding of schema type definitions, element declarations and model
 * groups. Factory methods for each of these are provided in this class.
 * 
 * @version $Id$
 */
@XmlRegistry
public class ObjectFactory
{
    private final static QName _PortletApp_QNAME = new QName("http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd",
                                                             "portlet-app");

    public ObjectFactory()
    {
    }

    public PortletAppType createPortletApp()
    {
        return new PortletAppType();
    }

    @XmlElementDecl(namespace = "http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd", name = "portlet-app")
    public JAXBElement<PortletAppType> createPortletApp(PortletAppType value)
    {
        return new JAXBElement<PortletAppType>(_PortletApp_QNAME, PortletAppType.class, null, value);
    }
}
