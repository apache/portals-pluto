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
package org.apache.pluto.descriptors.servlet;

import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.mapping.Mapping;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;

/**
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Mar 4, 2005
 */
public class CastorMappingTest extends TestCase {

    private boolean debug = false;


//
    public void setUp() throws Exception {
        this.debug = false;
    }

    public void testUnmarshalWebXml() throws Exception {
        URL webXmlMapping = getClass().getResource("castor-web-xml-mapping.xml");
        Mapping mapping = new Mapping();
        mapping.loadMapping(webXmlMapping);
        InputStream webXml = getClass().getResourceAsStream("web.xml");
        Unmarshaller unmarshaller = new Unmarshaller(mapping);
        unmarshaller.setIgnoreExtraElements(false);
        unmarshaller.setDebug(debug);
        WebAppDD config = (WebAppDD)unmarshaller.unmarshal(new InputStreamReader(webXml));
        assertTrue(config!=null);
    }

    public void testMarshalWebXml() throws Exception {
        URL webXmlMapping = getClass().getResource("castor-web-xml-mapping.xml");
        Mapping mapping = new Mapping();
        mapping.loadMapping(webXmlMapping);
        InputStream webXml = getClass().getResourceAsStream("web.xml");
        Unmarshaller unmarshaller = new Unmarshaller(mapping);
        WebAppDD config = (WebAppDD)unmarshaller.unmarshal(new InputStreamReader(webXml));

           OutputFormat of = new OutputFormat();
            of.setIndenting(true);
            of.setIndent(4); // 2-space indention
            of.setLineWidth(16384);
            // As large as needed to prevent linebreaks in text nodes
            of.setDoctype(
                 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN",
                 "http://java.sun.com/dtd/web-app_2_3.dtd");

            FileWriter writer = new FileWriter("newWeb.xml");
            XMLSerializer serializer = new XMLSerializer(writer, of);
        Marshaller marsh = new Marshaller(serializer.asDocumentHandler());
        marsh.setDebug(debug);
        marsh.setMapping(mapping);
        marsh.marshal(config);

    }


    /**
     * Start the tests.
     *
     * @param theArgs the arguments. Not used
     */
    public static void main(String[] theArgs) {
        junit.awtui.TestRunner.main(
            new String[] { CastorMappingTest.class.getName()});
    }

    /**
     * @return a test suite (<code>TestSuite</code>) that includes all methods
     *         starting with "test"
     */
    public static Test suite() {
        // All methods starting with "test" will be executed in the test suite.
        return new TestSuite(CastorMappingTest.class);
    }

}

