package org.apache.pluto.container.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Locale;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.pluto.container.PortletAppDescriptorService;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.impl.PortletAppType;
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

    public static Locale convertStringToLocale(String lang)
    {
        if (lang == null)
        {
            return null;
        }
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
        return new Locale(lang, country, variant);
    }    
    
    private static final String NAMESPACE_PREFIX = "xp";
    
    private DocumentBuilderFactory domFactory;

    
    public PortletApplicationDefinition createPortletApplicationDefinition()
    {
        return new PortletAppType();
    }
    
    /**
     * Read the Web Application Deployment Descriptor.
     *
     * @return WebAppDD instance representing the descriptor.
     * @throws java.io.IOException
     */
    
    @SuppressWarnings("unchecked")
    public PortletApplicationDefinition read(String name, String contextPath, InputStream in) throws IOException {
        JAXBElement app = null;
        try {
            JAXBContext jc = JAXBContext.newInstance( 
                    "org.apache.pluto.container.om.portlet10.impl" + ":" +
                    "org.apache.pluto.container.om.portlet.impl", PortletAppDescriptorServiceImpl.class.getClassLoader());

            Unmarshaller u = jc.createUnmarshaller();
            u.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

            app = (JAXBElement) u.unmarshal(in);                
        }catch (JAXBException jaxbEx){
            jaxbEx.printStackTrace();
            throw new IOException(jaxbEx.getMessage());
        }
        catch(Exception me) {
            throw new IOException(me.getLocalizedMessage());
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
        if (domFactory == null)
        {
            domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(true);
        }
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
        
        Document document = builder.parse(webDescriptor);
        Element root = document.getDocumentElement();
        String namespace = root.getNamespaceURI();

        XPath xpath = XPathFactory.newInstance().newXPath();
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

        // retrieve servlet-mapping url patterns
        nodes = (NodeList)xpath.evaluate("/"+prefix+"web-app/"+prefix+"servlet-mapping", document, XPathConstants.NODESET);
        if (nodes != null)
        {
            String urlPattern;
            
            for (int i = 0, nsize = nodes.getLength(); i < nsize; i++)
            {
                element = (Element)nodes.item(i);
                children = element.getElementsByTagName("url-pattern");
                if (children != null && children.getLength() != 0)
                {
                    urlPattern = children.item(0).getTextContent().trim();
                    if (urlPattern.length() > 0)
                    {
                        pa.getServletMappingURLPatterns().add(urlPattern);
                    }
                }
            }
        }
        
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
            JAXBContext jc = null;
            Object src = null;
            if (PortletApplicationDefinition.JSR_168_VERSION.equals(app.getVersion()))
            {                
                jc = JAXBContext.newInstance("org.apache.pluto.container.om.portlet10.impl");                
                src = new org.apache.pluto.container.om.portlet10.impl.PortletAppType(app);
            }
            else
            {
                jc = JAXBContext.newInstance("org.apache.pluto.container.om.portlet.impl");
                src = app;
            }
            Marshaller m = jc.createMarshaller();
            m.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            m.marshal(src,out);
        }catch (JAXBException jaxbEx){
            jaxbEx.printStackTrace();
            throw new IOException(jaxbEx.getMessage());
        }
        catch(Exception me) {
            throw new IOException(me.getLocalizedMessage());
        }
    }
}
