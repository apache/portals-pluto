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
package org.apache.pluto.deploy;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Enumeration;

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

import org.apache.pluto.binding.PortletDD;
import org.apache.pluto.binding.PortletAppDD;
import org.apache.pluto.binding.XMLBindingFactory;
import org.apache.crimson.tree.TextNode;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import sun.tools.jar.resources.jar;

/**
 * Used to assemble a web application into a portlet application.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 15, 2004
 */
public class Assembler {

    private static final String PORTLET_XML = "WEB-INF/portlet.xml";

    private static final String SERVLET_XML = "WEB-INF/web.xml";
    
    private static final String DISPATCH_SERVLET_CLASS =
        "org.apache.pluto.core.PortletServlet";


    public Assembler() {

    }

    public void assemble(File webapp, File destination)
    throws IOException {

        InputStream portletIn = null;
        InputStream servletIn = null;
        OutputStream out = null;
        if(webapp.isDirectory()) {
            File portletXML = new File(webapp, PORTLET_XML);
            File servletXML = new File(webapp, SERVLET_XML);
            portletIn = new FileInputStream(portletXML);
            servletIn = new FileInputStream(servletXML);

        }
        else {
            JarFile jar = new JarFile(webapp);
            JarEntry portletXML = jar.getJarEntry(PORTLET_XML);
            JarEntry servletXML = jar.getJarEntry(SERVLET_XML);

            portletIn = jar.getInputStream(portletXML);
            servletIn = jar.getInputStream(servletXML);
        }

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
            servletName.appendChild(new TextNode(name));

            Element servletClass = doc.createElement("servlet-class");
            servletClass.appendChild(new TextNode(DISPATCH_SERVLET_CLASS));

            Element initParam = doc.createElement("init-param");
            Element paramName = doc.createElement("param-name");
            paramName.appendChild(new TextNode("portlet-name"));

            Element paramValue = doc.createElement("param-value");
            paramValue.appendChild(new TextNode(name));

            initParam.appendChild(paramName);
            initParam.appendChild(paramValue);

            Element load = doc.createElement("load-on-startup");
            load.appendChild(new TextNode("1"));

            servlet.appendChild(servletName);
            servlet.appendChild(servletClass);
            servlet.appendChild(initParam);
            servlet.appendChild(load);

            Element mapping = doc.createElement("servlet-mapping");
            servletName = doc.createElement("servlet-name");
            servletName.appendChild(new TextNode(name));
            Element uri = doc.createElement("url-pattern");
            uri.appendChild(new TextNode("/PlutoInvoker/"+name));
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

        if(webapp.isDirectory()) {
            out = new FileOutputStream(new File(destination, SERVLET_XML));
        }
        else {
            JarFile jar = new JarFile(webapp);
            out = new AssemblerJarOutputStream(jar, webapp);
        }
        save(doc, out);
    }

    private Document parse(InputStream in)
    throws IOException {
        Document doc = null;
        try {
            DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = fact.newDocumentBuilder();
            doc = builder.parse(in);
        } catch (ParserConfigurationException e) {
            throw new IOException(e.getMessage());
        } catch (SAXException e) {
            throw new IOException(e.getMessage());
        }
        return doc;
    }

    private void save(Document doc, OutputStream out)
    throws IOException {
        try {
            TransformerFactory fact = TransformerFactory.newInstance();
            Transformer trans = fact.newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.transform(new DOMSource(doc), new StreamResult(out));
        } catch (TransformerConfigurationException e) {
            throw new IOException(e.getMessage());
        } catch (TransformerException e) {
            throw new IOException(e.getMessage());
        } finally {
            out.flush();
            out.close();
        }
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

    /**
     * OutputStream which captures the webapplication
     * deployment descriptor and rewrites the jar file
     * with it.
     */
    private static class AssemblerJarOutputStream
        extends ByteArrayOutputStream {
        JarFile jar;
        File webapp;

        AssemblerJarOutputStream(JarFile jar, File webapp) {
            this.jar = jar;
            this.webapp = webapp;
        }

        public void close() throws IOException {
            super.flush();
            super.close();
            byte[] bits = toByteArray();

            // we write it to a temp file and then copy it in case
            // the destination is the same as the source: in which
            // case we'll be unable to write it while we still have
            // the jar open.
            File file = new File(
                webapp.getParent(), webapp.getName()+".tmp"
            );

            FileOutputStream fout = new FileOutputStream(file);
            JarOutputStream out = new JarOutputStream(fout);

            Enumeration enum = jar.entries();
            while(enum.hasMoreElements()) {
                JarEntry entry = (JarEntry)enum.nextElement();
                entry = new JarEntry(entry.getName());
                InputStream is = null;
                if(SERVLET_XML.equals(entry.getName())) {
                    is = new ByteArrayInputStream(bits);
                }
                else {
                    is = jar.getInputStream(entry);
                }
                int bytesRead = -1;
                byte[] buffer = new byte[256];
                out.putNextEntry(new JarEntry(entry));
                while ((bytesRead = is.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }

            out.flush();
            out.close();

            webapp.delete();
            file.renameTo(webapp);
            file.delete();
        }
    }
}


