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
package org.apache.pluto.container.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.helpers.DefaultValidationEventHandler;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.StreamReaderDelegate;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.pluto.container.PortletAppDescriptorService;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/** 
 *  JAXB implementation of the xml2java binding
 *  @author <a href="mailto:chrisra@cs.uni-jena.de">Christian Raschka</a>
 */

public class PortletAppDescriptorServiceImpl implements PortletAppDescriptorService{
    
    private static class WebAppDtdEntityResolver implements EntityResolver {
        public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException
        {
            if (systemId.equals("http://java.sun.com/dtd/web-app_2_3.dtd"))
            {
                return new InputSource(getClass().getResourceAsStream("web-app_2_3.dtd"));
            }
            return null;
        }
    }

    private static class NamespaceOverridingStreamReaderDelegate extends StreamReaderDelegate {
        private String adjustedNamespaceURI = null;

        private NamespaceOverridingStreamReaderDelegate(XMLStreamReader reader) {
            super(reader);
        }

        @Override
        public int next() throws XMLStreamException
        {
            int eventCode = super.next();
            if (eventCode == XMLEvent.START_ELEMENT && "portlet-app".equals(getLocalName()))
            {
                String version = getAttributeValue(null, "version");
                if ("1.0".equals(version))
                {
                    adjustedNamespaceURI = "http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd";
                }
                else if ("2.0".equals(version))
                {
                    adjustedNamespaceURI = "http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd";
                }
            }
            return eventCode;
        }

        @Override
        public String getNamespaceURI()
        {
            String namespaceURI = super.getNamespaceURI();
            return (namespaceURI != null ? namespaceURI : adjustedNamespaceURI);
        }
    }

    private static class XPathNamespaceContext implements NamespaceContext
    {
        private String namespaceURI;
        private String prefix;
        
        public XPathNamespaceContext(String prefix)
        {
            this(prefix,XMLConstants.XML_NS_URI);
        }

        public XPathNamespaceContext(String prefix, String namespaceURI)
        {
            this.prefix = prefix;
            this.namespaceURI = namespaceURI;
        }

        public String getNamespaceURI(String prefix)
        {
            if (prefix == null)
            {
                throw new NullPointerException("Null prefix");
            }
            else if (this.prefix.equals(prefix))
            {
                return namespaceURI;
            }
            else if ("xml".equals(prefix))
            {
                return XMLConstants.XML_NS_URI;
            }
            return XMLConstants.NULL_NS_URI;
        }

        public String getPrefix(String namespaceURI)
        {
            throw new UnsupportedOperationException();
        }

        public Iterator<?> getPrefixes(String namespaceURI)
        {
            throw new UnsupportedOperationException();
        }
    }

    public static Locale convertStringToLocale(String lang)
    {
        if (lang == null)
        {
            return null;
        }
        String country = "";
        String variant = "";
        String[] localeArray = LOCALE_SPLIT.split(lang);
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
        return new Locale(lang, country, variant);
    }    
    
    private static final Pattern LOCALE_SPLIT = Pattern.compile("[-|_]");
    private static final String NAMESPACE_PREFIX = "xp";
    
    private final JAXBContext jaxbContext;

    public PortletAppDescriptorServiceImpl() {
        ClassLoader containerClassLoader = PortletAppDescriptorServiceImpl.class.getClassLoader();
        try {
            jaxbContext = JAXBContext.newInstance(org.apache.pluto.container.om.portlet10.impl.ObjectFactory.class.getPackage().getName() + ":" +
                                                  org.apache.pluto.container.om.portlet.impl.ObjectFactory.class.getPackage().getName(), 
                                                  containerClassLoader);
        }
        catch (JAXBException e) {
            throw new IllegalStateException("Failed to initialize JAXBContext for reading and writing portlet descriptors", e);
        }
    }
    
    /**
     * Read the Web Application Deployment Descriptor.
     *
     * @return WebAppDD instance representing the descriptor.
     * @throws java.io.IOException
     */
    public PortletApplicationDefinition read(String name, String contextPath, InputStream in) throws IOException 
    {
        if (in == null) {
            throw new IOException("Cannot read from a null InputStream");
        }
        
        final XMLInputFactory xmlInputFactory = getXmlInputFactory();
        
        //Generate an xml stream reader for the input stream 
        final XMLStreamReader streamReader;
        try {
            streamReader = xmlInputFactory.createXMLStreamReader(in);
        }
        catch (XMLStreamException e) {
            final IOException ioe = new IOException(e.getLocalizedMessage());
            ioe.initCause(e);
            throw ioe;
        }
        
        //Wrap the stream reader to make sure the namespace gets setup correctly
        final XMLStreamReader delegatingStreamReader = new NamespaceOverridingStreamReaderDelegate(streamReader);

        //Unmarshall the stream
        final JAXBElement<?> app;
        try {
            final Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
            unmarshaller.setEventHandler(new DefaultValidationEventHandler());
            app = (JAXBElement<?>) unmarshaller.unmarshal(delegatingStreamReader);
        }
        catch (JAXBException e) {
            final IOException ioe = new IOException(e.getMessage());
            ioe.initCause(e);
            throw ioe;
        }

        PortletApplicationDefinition pad = null;
        if (app.getValue() instanceof org.apache.pluto.container.om.portlet10.impl.PortletAppType)
        {
             pad = ((org.apache.pluto.container.om.portlet10.impl.PortletAppType)app.getValue()).upgrade();
        }      
        else
        {
            pad = (PortletApplicationDefinition)app.getValue();
        }
        
        pad.setName(name);
        pad.setContextPath(contextPath);
        
        return pad;
    }

    public void mergeWebDescriptor(PortletApplicationDefinition pa, InputStream webDescriptor) throws Exception
    {
        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        final DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        builder.setEntityResolver(new WebAppDtdEntityResolver());
        
        final Document document = builder.parse(webDescriptor);
        final Element root = document.getDocumentElement();
        final String namespace = root.getNamespaceURI();

        final XPathFactory xpathFactory = XPathFactory.newInstance();
        final XPath xpath = xpathFactory.newXPath();
        
        String prefix;
        if(namespace!= null && namespace.length() > 0)
        {
            prefix = NAMESPACE_PREFIX+":";
            xpath.setNamespaceContext(new XPathNamespaceContext(NAMESPACE_PREFIX, namespace));
        }
        else
        {
            prefix = XMLConstants.DEFAULT_NS_PREFIX;
            xpath.setNamespaceContext(new XPathNamespaceContext(XMLConstants.DEFAULT_NS_PREFIX));
        }
        
        NodeList nodes;
        NodeList children;
        Element element;

        // retrieve locale-encoding-mapping
        nodes = (NodeList)xpath.evaluate("/"+prefix+"web-app/"+prefix+"locale-encoding-mapping-list/"+prefix+"locale-encoding-mapping", document, XPathConstants.NODESET);
        if (nodes != null)
        {
            String locale;
            String encoding;
            
            for (int i = 0, nsize = nodes.getLength(); i < nsize; i++)
            {
                element = (Element)nodes.item(i);
                children = element.getElementsByTagName("locale");
                if (children != null && children.getLength() != 0)
                {
                    locale = children.item(0).getTextContent().trim();
                    if (locale.length() > 0)
                    {
                        
                        children = element.getElementsByTagName("encoding");
                        if (children != null && children.getLength() != 0)
                        {
                            encoding = children.item(0).getTextContent().trim();
                            if (encoding.length() > 0)
                            {
                                pa.getLocaleEncodingMappings().put(convertStringToLocale(locale), encoding);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Write the deployment descriptor.
     * @param app
     * @throws java.io.IOException
     */
    public void write(PortletApplicationDefinition app, OutputStream out) throws IOException {
        try {
            final Object src;
            if (PortletApplicationDefinition.JSR_168_VERSION.equals(app.getVersion()))
            {                
                src = new org.apache.pluto.container.om.portlet10.impl.PortletAppType(app);
            }
            else
            {
                src = app;
            }
            final Marshaller marshaller = this.jaxbContext.createMarshaller();
            marshaller.setEventHandler(new DefaultValidationEventHandler());
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(src,out);
        }
        catch (JAXBException jaxbEx){
            final IOException ioe = new IOException(jaxbEx.getMessage());
            ioe.initCause(jaxbEx);
            throw ioe;
        }
        catch(Exception me) {
            final IOException ioe = new IOException(me.getLocalizedMessage());
            ioe.initCause(me);
            throw ioe;
        }
    }
    
    protected XMLInputFactory getXmlInputFactory() {
        final ClassLoader portalClassLoader = this.getClass().getClassLoader();
        final Thread currentThread = Thread.currentThread();
        final ClassLoader contextClassLoader = currentThread.getContextClassLoader();
        
        if (portalClassLoader == contextClassLoader) {
            return XMLInputFactory.newInstance();
        }
        
        try {
            currentThread.setContextClassLoader(portalClassLoader);
            return XMLInputFactory.newInstance();
        }
        finally {
            currentThread.setContextClassLoader(contextClassLoader);
        }
    }
}
