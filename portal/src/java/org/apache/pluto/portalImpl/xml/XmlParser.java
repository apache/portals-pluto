/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
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
            
        domParser.setFeature("http://xml.org/sax/features/validation", true);
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
