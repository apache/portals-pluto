/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
/* 

 */

package org.apache.pluto.portalImpl.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XmlParser
{


    public static org.w3c.dom.Document parsePortletXml(InputStream portletXml) throws IOException, SAXException
    {
        
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        documentBuilderFactory.setAttribute("http://xml.org/sax/features/validation", Boolean.TRUE);
        documentBuilderFactory.setAttribute("http://apache.org/xml/features/validation/schema", Boolean.TRUE);

        documentBuilderFactory.setAttribute("http://xml.org/sax/features/namespaces", Boolean.TRUE);
        documentBuilderFactory.setAttribute("http://apache.org/xml/features/dom/include-ignorable-whitespace", Boolean.FALSE);


        try{

            // throws ParserConfigurationException if documentBuilder cannot be created
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder(); 
            documentBuilder.setErrorHandler(new ErrorHandler());
            documentBuilder.setEntityResolver(new EntityResolver(Constants.RES_PORTLET_DTDS, Constants.RES_PORTLET_DTD_NAMES)); 

            Document returnDoc = documentBuilder.parse( portletXml );
            returnDoc.normalize();

            return returnDoc;

        } catch (ParserConfigurationException e)
        {
            throw new SAXException("Failed creating DocumentBuilder",e);
        }
    }

    public static org.w3c.dom.Document parseWebXml(InputStream webXml) throws IOException, SAXException
    {
        DOMParser domParser = new DOMParser();

        domParser.setErrorHandler(new ErrorHandler());
        domParser.setEntityResolver(new EntityResolver(Constants.RES_WEB_PUBLIC_ID,
                                                       Constants.RES_WEB_DTD,
                                                       Constants.RES_WEB_DTD_NAME));
            
	// modified by YCLI: START :: do not do validation for web.xml
        domParser.setFeature("http://xml.org/sax/features/validation", false);
	// modified by YCLI: END 
        domParser.setFeature("http://apache.org/xml/features/dom/include-ignorable-whitespace", false);

        InputSource source = new InputSource( webXml );
        
        domParser.parse( source );
        
        return domParser.getDocument();
    }

    // private helper classes for parsing
    public static class ErrorHandler implements org.xml.sax.ErrorHandler
    {

        // org.xml.sax.ErrorHandler implementation.

        public void warning (SAXParseException exception) throws SAXException {
            throw exception;
        }
        public void error   (SAXParseException exception) throws SAXException {
            throw exception;
        }
        public void fatalError (SAXParseException exception) throws SAXException {
            throw exception;
        }
    }
    
    
    public static class EntityResolver implements org.xml.sax.EntityResolver
    {

        
        public String publicDTD         = null;
        public String[] resourceDTDs    = new String[1];
        public String[] resourceDTDNames= new String[1];

        public EntityResolver(String publicDTD,
                              String resourceDTD,
                              String resourceDTDName)
        {
            this.publicDTD       = publicDTD;
            this.resourceDTDs[0]     = resourceDTD;
            this.resourceDTDNames[0] = resourceDTDName;
        }

        public EntityResolver(String[] resourceDTDs,
                              String[] resourceDTDNames)
        {
            this.resourceDTDs     = resourceDTDs;
            this.resourceDTDNames = resourceDTDNames;
        }

        public InputSource resolveEntity(String publicId, String systemId) throws SAXException 
        {

            for (int i=0; i<resourceDTDNames.length; i++)
            {
                if ((publicId != null && publicId.equals(publicDTD))
                    || (systemId != null && systemId.endsWith(resourceDTDNames[i])))
                {
                    java.io.InputStream is = getClass().getResourceAsStream(resourceDTDs[i]);

                    if (is != null)
                        return new InputSource(is);
                    throw new SAXException("XML configuration DTD not found: "+resourceDTDs[i]);
                }
            }
            
            // no other external entity permitted
            throw new SAXException("External entites are not permitted in XML configuration files");
            
        }

    }

}
