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
package org.apache.pluto.driver.services.container;

import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import javax.portlet.Event;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.EventProvider;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.driver.PortletRegistryService;
import org.apache.pluto.container.om.portlet.EventDefinition;
import org.apache.pluto.container.om.portlet.EventDefinitionReference;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;

/**
 * @version $Id$
 */
public class EventProviderImpl implements EventProvider
{
    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(EventProviderImpl.class);
    private PortletWindow portletWindow;
    private PortletRegistryService portletRegistry;
    
    public EventProviderImpl(PortletWindow portletWindow, PortletRegistryService portletRegistry)
    {
        this.portletWindow = portletWindow;
        this.portletRegistry = portletRegistry;
    }

    @SuppressWarnings("unchecked")
    public Event createEvent(QName qname, Serializable value) throws IllegalArgumentException
    {
        if (isDeclaredAsPublishingEvent(qname))
        {
            if (value != null && !isValueInstanceOfDefinedClass(qname, value))
            {
                throw new IllegalArgumentException("Payload class (" +
                                                   value.getClass().getCanonicalName() +
                                                   ") does not have the right class, check your defined event types in portlet.xml.");
            }
            try
            {
                if (value == null)
                {
                    return new EventImpl(qname, value);
                }
                else
                {
                    ClassLoader cl = Thread.currentThread().getContextClassLoader();
                    Writer out = new StringWriter();
                    Class clazz = value.getClass();
                    try
                    {
                        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
                        JAXBContext jc = JAXBContext.newInstance(clazz);
                        Marshaller marshaller = jc.createMarshaller();
                        JAXBElement<Serializable> element = new JAXBElement<Serializable>(qname, clazz, value);
                        marshaller.marshal(element, out);
                    }
                    finally
                    {
                        Thread.currentThread().setContextClassLoader(cl);
                    }
                    return new EventImpl(qname, out.toString());
                }
            }
            catch (JAXBException e)
            {
                // maybe there is no valid jaxb binding
                // TODO wsrp:eventHandlingFailed
                LOG.error("Event handling failed", e);
            }
            catch (FactoryConfigurationError e)
            {
                LOG.warn(e.getMessage(),e);
            }
        }
        return null;
    }

    private boolean isDeclaredAsPublishingEvent(QName qname)
    {
        String applicationId = PortletWindowConfig.parseContextPath(portletWindow.getId().getStringId());
        String applicationName = applicationId;
        String portletName = PortletWindowConfig.parsePortletName(portletWindow.getId().getStringId());
        List<? extends EventDefinitionReference> events = null;
        try
        {
            events = portletRegistry.getPortlet(applicationName, portletName).getSupportedPublishingEvents();
        }
        catch (PortletContainerException e1)
        {
            e1.printStackTrace();
        }
        if (events != null)
        {
            String defaultNamespace = portletWindow.getPortletDefinition().getApplication()
                                                   .getDefaultNamespace();
            for (EventDefinitionReference ref : events)
            {
                QName name = ref.getQualifiedName(defaultNamespace);
                if (name == null)
                {
                    continue;
                }
                if (qname.equals(name))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValueInstanceOfDefinedClass(QName qname, Serializable value)
    {
        PortletApplicationDefinition app = portletWindow.getPortletDefinition().getApplication();
        List<? extends EventDefinition> events = app.getEventDefinitions();
        if (events != null)
        {
            for (EventDefinition def : events)
            {
                if (def.getQName() != null)
                {
                    if (def.getQName().equals(qname))
                    {
                        return value.getClass().getName().equals(def.getValueType());
                    }
                }
                else
                {
                    QName tmp = new QName(app.getDefaultNamespace(), def.getName());
                    if (tmp.equals(qname))
                    {
                        return value.getClass().getName().equals(def.getValueType());
                    }
                }
            }
        }
        // event not declared
        return true;
    }
}
