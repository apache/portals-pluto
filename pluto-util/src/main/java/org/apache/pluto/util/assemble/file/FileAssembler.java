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
package org.apache.pluto.util.assemble.file;

import org.apache.pluto.util.assemble.Assembler;
import org.apache.pluto.util.assemble.AssemblerConfig;
import org.apache.pluto.util.UtilityException;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.services.PortletAppDescriptorService;
import org.apache.pluto.descriptors.services.castor.EntityResolverImpl;
import org.apache.pluto.descriptors.services.castor.PortletAppDescriptorServiceImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

/**
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Nov 8, 2004
 */
public class FileAssembler implements Assembler {

    private static final Properties PROPERTIES =
        new Properties();

    static {
        PROPERTIES.setProperty(OutputKeys.INDENT, "yes");
    }

    public FileAssembler() {
   }

    public void assemble(AssemblerConfig config)
    throws UtilityException {

        try {
            InputStream servletIn =
                new FileInputStream(config.getWebappDescriptor());

            InputStream portletIn =
                new FileInputStream(config.getPortletDescriptor());

            Document xml = updateWebXML(servletIn, portletIn);
            servletIn.close();

            FileOutputStream servletOut =
                new FileOutputStream(config.getDestination());

            save(xml, servletOut);
        }
        catch(IOException io) {
            throw new UtilityException(io.getMessage(), io, null);
        }

    }


    protected void save(Document doc, OutputStream out)
    throws IOException {
        try {
            TransformerFactory fact = TransformerFactory.newInstance();
            Transformer trans = fact.newTransformer();
            trans.setOutputProperties(PROPERTIES);
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


    /**
     * @todo currently we rely specifically on the castor implementation.
     * @param servletIn
     * @param portletIn
     * @return
     * @throws IOException
     */
    protected Document updateWebXML(InputStream servletIn, InputStream portletIn)
    throws IOException {
        PortletAppDescriptorService portletService =
                new PortletAppDescriptorServiceImpl();

        Document doc = parse(servletIn);

        Collection servlets = new ArrayList();
        Collection mappings = new ArrayList();

        PortletAppDD portletAppDD = portletService.read(portletIn);
        List portlets = portletAppDD.getPortlets();
        Iterator it = portlets.iterator();

        while(it.hasNext()) {
            PortletDD portlet = (PortletDD)it.next();
            String name = portlet.getPortletName();

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



        Element webAppNode = doc.getDocumentElement();
        NodeList nodes = webAppNode.getChildNodes();

//         Find the first node that shouldn't be before the servlet
//         and start appending.  This is kind of ugly, but the hack
//         works for now!
        for(int i=0;i<nodes.getLength();i++) {
            Node node = nodes.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                if(!BEFORE_SERVLET_DEF.contains(node.getNodeName())) {
                    it = servlets.iterator();
                    while(it.hasNext()) {
                        Node servlet = (Node)it.next();
                        webAppNode.insertBefore(servlet, node);
                        it.remove();
                    }
                }

                if(!BEFORE_SERVLET_MAPPING_DEF.contains(node.getNodeName())) {
                    it = mappings.iterator();
                    while(it.hasNext()) {
                        Node mapping = (Node)it.next();
                        webAppNode.insertBefore(mapping, node);
                        it.remove();
                    }
                }
            }
        }

        // Now, in case there are not any nodes after the servlet def!
        it = servlets.iterator();
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

