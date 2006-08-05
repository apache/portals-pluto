/*
 * Copyright 2006 The Apache Software Foundation
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
package org.apache.pluto.descriptors.servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import junit.framework.TestCase;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;


/**
 * Unit tests for PLUTO-216
 *  
 * @author <a href="mailto:emetsger@jhu.edu">Elliot Metsger</a>
 * @version $Id$
 * @since Feb 27, 2006
 */
public class WebAppDDVersionTest extends TestCase {
    
    boolean debug = false;

    protected void setUp( ) throws Exception {
        super.setUp( );
        this.debug = false;
    }
    
    public void testUnMarshalServletVersion2dot4( ) throws Exception {
        WebAppDD config = unMarshalWebAppDD( "castor-web-xml-mapping.xml", "web.xml" );
        assertEquals( "2.4", config.getServletVersion(  ) );        
    }
    
    public void testUnMarshalServletVersion2dot3( ) throws Exception {
        WebAppDD config = unMarshalWebAppDD( "castor-web-xml-mapping.xml", "web-2.3.xml" );
        assertEquals( "2.3", config.getServletVersion( ) );
    }
    
    /**
     * This test attempts to unmarshal, marshal, and unmarshal a web application descriptor, testing
     * to see if the <code>version</code> attribute of the <code>web-app</code> element is
     * preserved.  This test uses a servlet descriptor purportedly conforming to Servlet
     * Specification 2.4.
     * 
     * This test expects to find a <code>version</code> attribute equal to the string "2.4".
     * 
     * @throws Exception
     */
    public void testMarshalServletVersion2dot4( ) throws Exception {        
        // first unmarshal the 2.4 web.xml
        WebAppDD config = unMarshalWebAppDD( "castor-web-xml-mapping.xml", "web.xml" );        
        assertEquals( "2.4", config.getServletVersion(  ) );
        
        // create a new OutputFormat for marshaling/serialization
        OutputFormat of = new OutputFormat( );
        of.setIndenting( true );
        of.setIndent( 4 ); // 2-space indention
        of.setLineWidth( 16384 ); // As large as needed to prevent linebreaks in text nodes
        // marshal the web.xml
        marshalWebAppDD( "castor-web-xml-mapping.xml", "testWeb24.xml", config, of );
        
        // unmarshal our test web.xml
        WebAppDD testWebXml = unMarshalWebAppDD( "castor-web-xml-mapping.xml", "testWeb24.xml" );
        
        // test to see if the version attribute is preserved
        assertEquals( "2.4", testWebXml.getServletVersion( ) );
        
        // null out references (is this required???)
        config = null;
        testWebXml = null;
        of = null;        
    }
    
    /**
     * This test attempts to unmarshal, marshal, and unmarshal a web application descriptor, testing
     * to see if the <code>version</code> attribute of the <code>web-app</code> element is
     * preserved.  This test uses a servlet descriptor purportedly conforming to Servlet
     * Specification 2.3.
     * 
     * This test expects to find a <code>version</code> attribute equal to "2.3".
     * 
     * @throws Exception
     */
    public void testMarshalServletVersion2dot3( ) throws Exception {
        // first unmarshal the 2.3 web.xml        
        WebAppDD config = unMarshalWebAppDD( "castor-web-xml-mapping.xml", "web-2.3.xml" );        
        assertEquals( "2.3", config.getServletVersion( ) );
        
        // create a new OuputFormat for marshaling/serialization
        OutputFormat of = new OutputFormat( );
        of.setIndenting( true );
        of.setIndent( 4 ); // 2-space indention
        of.setLineWidth( 16384 ); // As large as needed to prevent linebreaks in text nodes
        of.setDoctype(
             "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN",
             "http://java.sun.com/dtd/web-app_2_3.dtd");
        
        // marshal the web.xml
        marshalWebAppDD( "castor-web-xml-mapping.xml", "testWeb23.xml", config, of );
        
        // unmarshal our test web.xml
        WebAppDD testWebXml = unMarshalWebAppDD( "castor-web-xml-mapping.xml", "testWeb23.xml" );
        
        // test to see if the version attribute is preserved (in this case the version should be 
        // equal to 2.3)
        assertEquals( "2.3", testWebXml.getServletVersion( ) );
        
        // null out references (is this required???)
        config = null;
        testWebXml = null;
        of = null;
    }    
    
    /**
     * Unmarshals a servlet web application deployment descriptor using the specified Castor
     * mapping filename and web.xml file name.  The file names should not be absolute; the
     * classpath will be searched for both files.
     * 
     * @param castorMappingFileName the Castor mapping to use; the classpath will be searched for the file name.
     * @param webXmlFileName the web.xml file to unmarshal; the classpath will be searched for the file name.
     * @return WebAppDD the unmarshaled web application deployment descriptor.
     */
    private WebAppDD unMarshalWebAppDD( String castorMappingFileName, String webXmlFileName ) throws Exception {        
        URL webXmlMapping = null;
        URL webXml = null;
        WebAppDD config = null;
        
        // portions of this code scavenged from WebAppDDTest!
        try {
            webXmlMapping = getClass().getResource( castorMappingFileName );
            Mapping mapping = new Mapping();
            mapping.loadMapping(webXmlMapping);
            webXml = getClass( ).getResource( webXmlFileName );            
            InputStream webXmlIs = webXml.openStream( );
            Unmarshaller unmarshaller = new Unmarshaller(mapping);
            unmarshaller.setIgnoreExtraElements(false);
            unmarshaller.setDebug(debug);
            config = (WebAppDD)unmarshaller.unmarshal(new InputStreamReader(webXmlIs));
            assertTrue(config!=null);
        } catch ( MappingException me ) {
            String msg = "Encountered mapping exception when unmarshaling " +
                    webXml.getPath( ) + " with Castor mapping file " + webXmlMapping.getPath( );
            System.out.println( msg );
            me.printStackTrace( System.out );
            throw me;
        } catch ( MarshalException me ) {
            String msg = "Encountered a marshaling exception when unmarshaling " +
                webXml.getPath( ) + " with Castor mapping file " + webXmlMapping.getPath( );
            System.out.println( msg );
            me.printStackTrace( System.out );
            throw me;
        } catch ( ValidationException ve ) {
            String msg = "Encountered a validation exception when unmarshaling " +
                webXml.getPath( ) + " with Castor mapping file " + webXmlMapping.getPath( );
            System.out.println( msg );
            ve.printStackTrace( );
            throw ve;
        } catch ( IOException ioe ) {
            String msg = "Encountered i/o exception when unmarshaling " +            
                webXml.getPath( ) + " with Castor mapping file " + webXmlMapping.getPath( ) +
                ".  Check to be sure the files exist!";
            System.out.println( msg );
            ioe.printStackTrace( System.out );
            throw ioe;            
        }
        
        return config;        
    }    
    
    /**
     * Marshals the supplied servlet web application deployment descriptor using the specified Castor
     * mapping filename and OutputFormat  The marshaled output will be output to the file specified 
     * by <code>outputWebXmlFileName</code>.
     * 
     * The classpath will be searched for the <code>castorMappingFileName</code>, but an absolute
     * or relative path may be specified for <code>outputWebXmlFileName</code>.
     * 
     * @param castorMappingFileName the Castor mapping to use; the classpath will be searched for the file name.
     * @param outputWebXmlFileName the unmarshaled web application deployment descriptor will be written here.
     * @param webApp represents the web application deployment descriptor to be marshaled.
     * @param of the <code>org.apache.xml.serialize.OutputFormat</code> used to serialize the web.xml file.
     */
    private void marshalWebAppDD( String castorMappingFileName, String outputWebXmlFileName, WebAppDD webApp, 
            OutputFormat of ) throws Exception {
        // portions of this code scavenged from WebAppDDTest!
        URL webXmlMapping = getClass( ).getResource( castorMappingFileName );
        Mapping mapping = new Mapping( );
        mapping.loadMapping( webXmlMapping );
        // the serialized webapp descriptor should go in the classpath so that 
        // we can unmarshal it later using unMarshalWebAppDD()
        FileWriter writer = new FileWriter( webApp.getClass().getResource(".").getPath().concat( "/" + outputWebXmlFileName ) );
        XMLSerializer serializer = new XMLSerializer(writer, of);        
        Marshaller marsh = new Marshaller(serializer.asDocumentHandler());
        marsh.setDebug(debug);
        marsh.setMapping(mapping);
        marsh.marshal(webApp);             
    }
    
}
