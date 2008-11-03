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
package org.apache.pluto.util.descriptors.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @version $Id$
 */
public class PlutoWebXmlRewriter
{
    private static final String NAMESPACE_PREFIX = "xp";
    
    private static final String[] ELEMENTS_BEFORE_SERVLET_23 = new String[] { "icon", "display-name", "description",
                                                                             "distributable", "context-param",
                                                                             "filter", "filter-mapping", "listener",
                                                                             "servlet" };
    private static final String[] ELEMENTS_BEFORE_SERVLET_MAPPING_23 = new String[] { "icon", "display-name",
                                                                                     "description", "distributable",
                                                                                     "context-param", "filter",
                                                                                     "filter-mapping", "listener",
                                                                                     "servlet", "servlet-mapping" };
    private static final String[] ELEMENTS_BEFORE_SERVLET = new String[] { "description", "display-name", "icon",
                                                                          "distributable", "context-param", "filter",
                                                                          "filter-mapping", "listener", "servlet" };
    private static final String[] ELEMENTS_BEFORE_SERVLET_MAPPING = new String[] { "description", "display-name",
                                                                                  "icon", "distributable",
                                                                                  "context-param", "filter",
                                                                                  "filter-mapping", "listener",
                                                                                  "servlet", "servlet-mapping" };
    
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

        @SuppressWarnings("unchecked")
        public Iterator getPrefixes(String namespaceURI)
        {
            throw new UnsupportedOperationException();
        }
    }
    
    private Document descriptor;
    private String namespace;
    private String prefix;
    private Element  root;
    private XPath xpath;
    private boolean descriptor23;
    
    public PlutoWebXmlRewriter(Document descriptor)
    {
        this.descriptor = descriptor;
        this.root = descriptor.getDocumentElement();
        this.namespace = root.getNamespaceURI();
        String version = root.getAttribute("version");
        if (version.equals(""))
        {
            version = "2.3";
        }
        try
        {
            // Check version is a valid number
            Double.parseDouble(version);
        }
        catch(NumberFormatException e)
        {
            throw new RuntimeException("Unable to create Determine wew.xml version: " + version, e);
        }
        descriptor23 = version.equals("2.3");
        if (!descriptor23 && version.compareTo("2.3") < 0)
        {
            throw new RuntimeException("Unsupported (too old?) web.xml version: "+version);
        }        
        xpath = XPathFactory.newInstance().newXPath();
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
    }
    
    public PlutoWebXmlRewriter(InputStream source) throws Exception
    {
        this(parseXml(source));
    }

    protected static Document parseXml(InputStream source) throws Exception
    {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        builder.setEntityResolver(new EntityResolver()
        {
            public InputSource resolveEntity(java.lang.String publicId, java.lang.String systemId) throws SAXException,
                            java.io.IOException
            {
                if (systemId.equals("http://java.sun.com/dtd/web-app_2_3.dtd"))
                {
                    return new InputSource(getClass().getResourceAsStream("web-app_2_3.dtd"));
                }
                return null;
            }
        });
        Document document = builder.parse(source);
        return document;
    }
    
    /**
     * 
     * <p>
     * insertElementCorrectly
     * </p>
     * 
     * @param root
     *            element representing the &lt; web-app &gt;
     * @param toInsert
     *            element to insert into the web.xml hierarchy.
     * @param elementsBefore
     *            an array of web.xml elements that should be defined before the
     *            element we want to insert. This order should be the order
     *            defined by the web.xml's DTD or XSD type definition.
     */
    protected static void insertElementCorrectly( Element root, Element toInsert, String[] elementsBefore )
    {
        NodeList allChildren = root.getChildNodes();
        List<String> elementsBeforeList = Arrays.asList(elementsBefore);
        Node insertBefore = null;
        for (int i = 0; i < allChildren.getLength(); i++)
        {
            Node node = allChildren.item(i);
            if (insertBefore == null)
            {
                insertBefore = node;
            }
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                if (elementsBeforeList.contains(node.getNodeName()))
                {
                    insertBefore = null;
                }
                else
                {
                    break;
                }
            }
        }
        if (insertBefore == null)
        {
            root.appendChild(toInsert);
        }
        else
        {
            root.insertBefore(toInsert, insertBefore);
        }
    }
    
    public boolean is23Descriptor()
    {
        return descriptor23;
    }
    
    public boolean hasServlets()
    {
        Object result = null;
        try
        {
            result = xpath.evaluate("/"+prefix+"web-app/"+prefix+"servlet", descriptor, XPathConstants.NODESET);
        }
        catch (XPathExpressionException e)
        {
            throw new RuntimeException(e);
        }
        return result != null ? ((NodeList)result).getLength() > 0 : false;
    }
    
    public boolean hasServletMappings()
    {
        Object result = null;
        try
        {
            result = xpath.evaluate("/"+prefix+"web-app/"+prefix+"servlet-mapping", descriptor, XPathConstants.NODESET);
        }
        catch (XPathExpressionException e)
        {
            throw new RuntimeException(e);
        }
        return result != null ? ((NodeList)result).getLength() > 0 : false;
    }
    
    public String getServletClass(String servletName)
    {
        Object result = null;
        try
        {
            result = xpath.evaluate("/"+prefix+"web-app/"+prefix+"servlet["+prefix+"servlet-name='"+servletName+"']/"+prefix+"servlet-class/text()", descriptor, XPathConstants.STRING);
        }
        catch (XPathExpressionException e)
        {
            throw new RuntimeException(e);
        }
        return result != null ? (String)result : null;
    }
    
    public void injectPortletServlet(String className, String name)
    {
        Element servlet = descriptor.createElementNS(namespace, "servlet");
        Element servletName = descriptor.createElementNS(namespace, "servlet-name");
        servletName.setTextContent(name);
        Element servletClass = descriptor.createElementNS(namespace, "servlet-class");
        servletClass.setTextContent(className);
        servlet.appendChild(servletName);
        servlet.appendChild(servletClass);

        Element init2Param = descriptor.createElementNS(namespace, "init-param");        
        Element param2Name = descriptor.createElementNS(namespace, "param-name");
        param2Name.setTextContent("portlet-name");
        Element param2Value = descriptor.createElementNS(namespace, "param-value");
        param2Value.setTextContent(name);
        init2Param.appendChild(param2Name);
        init2Param.appendChild(param2Value);        
        servlet.appendChild(init2Param);                    

        
        Element loadOnStartup = descriptor.createElementNS(namespace, "load-on-startup");
        loadOnStartup.setTextContent("1");
        servlet.appendChild(loadOnStartup);        
        
        insertElementCorrectly(root, servlet, descriptor23 ? ELEMENTS_BEFORE_SERVLET_23 : ELEMENTS_BEFORE_SERVLET);
        
        Element servletMappingElement = descriptor.createElementNS(namespace, "servlet-mapping");
        
        Element servletMapName = descriptor.createElementNS(namespace, "servlet-name");
        servletMapName.setTextContent(name);
        Element servletUrlPattern = descriptor.createElementNS(namespace, "url-pattern");
        servletUrlPattern.setTextContent("/PlutoInvoker/"+name);

        servletMappingElement.appendChild(servletMapName);
        servletMappingElement.appendChild(servletUrlPattern);

        insertElementCorrectly(root, servletMappingElement, descriptor23 ? ELEMENTS_BEFORE_SERVLET_MAPPING_23 : ELEMENTS_BEFORE_SERVLET_MAPPING);        
    }
    
    public void write(OutputStream dest) throws IOException
    {
        try
        {
            DOMSource domSource = new DOMSource(descriptor);
            StreamResult streamResult = new StreamResult(dest);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            if (descriptor.getDoctype() != null)
            {
                transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, descriptor.getDoctype().getPublicId());
                transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, descriptor.getDoctype().getSystemId());
            }
            transformer.setOutputProperty(OutputKeys.MEDIA_TYPE, "text/xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(domSource, streamResult);
        }
        catch (TransformerConfigurationException e)
        {
            throw new IOException(e.getMessage());
        }
        catch (TransformerException e)
        {
            throw new IOException(e.getMessage());
        }
    }
}
