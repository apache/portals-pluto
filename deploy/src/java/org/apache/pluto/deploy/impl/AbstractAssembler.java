/*
 * Copyright 2004 The Apache Software Foundation
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
package org.apache.pluto.deploy.impl;

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.apache.pluto.binding.XMLBindingFactory;
import org.apache.pluto.binding.PortletAppDD;
import org.apache.pluto.binding.PortletDD;
import org.apache.pluto.binding.util.EntityResolverImpl;
import org.apache.pluto.deploy.Assembler;
import org.xml.sax.SAXException;

/**
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Nov 8, 2004
 */
public abstract class AbstractAssembler implements Assembler {

    private static final String PORTLET_XML = "WEB-INF/portlet.xml";

    private static final String SERVLET_XML = "WEB-INF/web.xml";

    private static final String[] CLASSES = new String[] { };

    private Properties properties;

    public AbstractAssembler() {
        properties = new Properties();
        properties.setProperty(OutputKeys.INDENT, "yes");
        //properties.setProperty("{http://xml.apache.org/xslt}indent-amount", "4");
    }

    public void assemble() throws IOException {
        InputStream servletIn = getWebResource(SERVLET_XML);
        InputStream portletIn = getWebResource(PORTLET_XML);

        Document xml = updateWebXML(servletIn, portletIn);
        setWebResource(SERVLET_XML, xml);

        InputStream in = null;
        for(int i = 0;i<CLASSES.length;i++) {
            in = getClass().getClassLoader().getResourceAsStream(CLASSES[i]);
            setWebResource("WEB-INF/classes/"+CLASSES[i], in);
        }

        close();
    }

    protected abstract InputStream getWebResource(String resource)
        throws IOException;

    protected abstract void setWebResource(String name, InputStream in)
        throws IOException;

    protected abstract void setWebResource(String name, Document dom)
    throws IOException;

    protected abstract void close()
        throws IOException;

    protected void save(Document doc, OutputStream out)
    throws IOException {
        try {
            TransformerFactory fact = TransformerFactory.newInstance();
            Transformer trans = fact.newTransformer();
            trans.setOutputProperties(properties);
            trans.transform(new DOMSource(doc), new StreamResult(out));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            throw new IOException(e.getMessage());
        } catch (TransformerException e) {
            e.printStackTrace();
            throw new IOException(e.getMessage());
        } finally {
            out.flush();
            out.close();
        }
    }

    protected void save(InputStream in, OutputStream out)
    throws IOException {
        try {
            int bytesRead = -1;
            byte[] buffer = new byte[256];
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
        finally {
            out.flush();
            out.close();
        }
    }

    protected Document updateWebXML(InputStream servletIn, InputStream portletIn)
    throws IOException {
        XMLBindingFactory factory =
            XMLBindingFactory.createXMLBinding(XMLBindingFactory.READ_WRITE);

        Document doc = parse(servletIn);

        Collection servlets = new ArrayList();
        Collection mappings = new ArrayList();

        PortletAppDD portletAppDD = factory.getPortletAppDD(portletIn);
        PortletDD[] portlets = portletAppDD.getPortlets();
        for(int i=0;i<portlets.length;i++) {
            String name = portlets[i].getPortletName();
            Element servlet = doc.createElement("servlet");

            Element servletName = doc.createElement("servlet-name");
            servletName.appendChild(doc.createTextNode(name));
            servlet.appendChild(servletName);

            Element servletClass = doc.createElement("servlet-class");
            servletClass.appendChild(doc.createTextNode(DISPATCH_SERVLET_CLASS));
            servlet.appendChild(servletClass);

            Element initParam = doc.createElement("init-param");
            Element paramName = doc.createElement("param-name");
            paramName.appendChild(doc.createTextNode("portlet-name"));

            Element paramValue = doc.createElement("param-value");
            paramValue.appendChild(doc.createTextNode(name));

            initParam.appendChild(paramName);
            initParam.appendChild(paramValue);
            servlet.appendChild(initParam);

            Element load = doc.createElement("load-on-startup");
            load.appendChild(doc.createTextNode("1"));
            servlet.appendChild(load);

            Element mapping = doc.createElement("servlet-mapping");
            servletName = doc.createElement("servlet-name");
            servletName.appendChild(doc.createTextNode(name));
            Element uri = doc.createElement("url-pattern");
            uri.appendChild(doc.createTextNode("/PlutoInvoker/"+name));
            mapping.appendChild(servletName);
            mapping.appendChild(uri);

            servlets.add(servlet);
            mappings.add(mapping);
        }


        Element webAppNode = (Element)doc.getDocumentElement();
        NodeList nodes = webAppNode.getChildNodes();

        // Find the first node that shouldn't be before the servlet
        // and start appending.  This is kind of ugly, but the hack
        // works for now!
        for(int i=0;i<nodes.getLength();i++) {
            Node node = nodes.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                if(!BEFORE_SERVLET_DEF.contains(node.getNodeName())) {
                    Iterator it = servlets.iterator();
                    while(it.hasNext()) {
                        Node servlet = (Node)it.next();
                        webAppNode.insertBefore(servlet, node);
                        it.remove();
                    }
                }

                if(!BEFORE_SERVLET_MAPPING_DEF.contains(node.getNodeName())) {
                    Iterator it = mappings.iterator();
                    while(it.hasNext()) {
                        Node mapping = (Node)it.next();
                        webAppNode.insertBefore(mapping, node);
                        it.remove();
                    }
                }
            }
        }

        // Now, in case there are not any nodes after the servlet def!
        Iterator it = servlets.iterator();
        while(it.hasNext()) {
            webAppNode.appendChild((Node)it.next());
        }

        it = mappings.iterator();
        while(it.hasNext()) {
            webAppNode.appendChild((Node)it.next());
        }

        return doc;
    }

    private static final Collection BEFORE_SERVLET_DEF = new ArrayList();

    private static final Collection BEFORE_SERVLET_MAPPING_DEF = new ArrayList();

    static {
        BEFORE_SERVLET_DEF.add("icon");
        BEFORE_SERVLET_DEF.add("display-name");
        BEFORE_SERVLET_DEF.add("description");
        BEFORE_SERVLET_DEF.add("distributable");
        BEFORE_SERVLET_DEF.add("context-param");
        BEFORE_SERVLET_DEF.add("filter");
        BEFORE_SERVLET_DEF.add("filter-mapping");
        BEFORE_SERVLET_DEF.add("listener");

        BEFORE_SERVLET_MAPPING_DEF.addAll(BEFORE_SERVLET_DEF);
        BEFORE_SERVLET_MAPPING_DEF.add("servlet");
    }

    private Document parse(InputStream in)
    throws IOException {
        Document doc = null;
        try {
            DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = fact.newDocumentBuilder();
            builder.setEntityResolver(new EntityResolverImpl());
            doc = builder.parse(in);
        } catch (ParserConfigurationException e) {
            throw new IOException(e.getMessage());
        } catch (SAXException e) {
            throw new IOException(e.getMessage());
        }
        return doc;
    }
}

