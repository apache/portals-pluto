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
package org.apache.pluto.descriptors.services.castor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.pluto.descriptors.services.WebAppDescriptorService;
import org.apache.pluto.descriptors.servlet.WebAppDD;
import org.custommonkey.xmlunit.XMLTestCase;

/**
 * Base test for doing a read and read/write/read test on specific versions
 * of the descriptor xml.
 *
 * @since Mar 3, 2007
 * @version $Id$
 * @todo JavaDoc
 */
public abstract class AbstractVersionedWebAppDescriptorTest extends XMLTestCase
{
    private WebAppDescriptorService underTest = null;

    protected void setUp() throws Exception
    {
        underTest = new WebAppDescriptorServiceImpl();
    }

    protected final InputStream getDescriptorStream() {
        final String descriptorPath = this.getDescriptorPath();
        return this.getRequiredResource(descriptorPath);
    }
    
    protected final InputStream getExpectedDescriptorStream() {
        final String expectedDescriptorPath = this.getExpectedDescriptorPath();
        return this.getRequiredResource(expectedDescriptorPath);
    }
    
    protected final InputStream getRequiredResource(String path) {
        final InputStream resource = this.getClass().getResourceAsStream(path);
        assertNotNull(resource);
        return resource;
    }

    protected void tearDown() throws Exception
    {
        underTest = null;
    }
    
    protected abstract String getDescriptorPath();
    
    protected abstract String getExpectedDescriptorPath();
    
    protected abstract String getDescriptorVersion();

    public final void testRead() throws Exception
    {
        final InputStream descriptorStream = this.getDescriptorStream();
        WebAppDD webappdd = underTest.read(descriptorStream);
        assertNotNull(webappdd);
        assertEquals(this.getDescriptorVersion(), webappdd.getServletVersion());
    }

    public final void testWrite() throws Exception
    {
        File outputFile = File.createTempFile("web-app-descriptor-test", ".xml");
        OutputStream out = new FileOutputStream(outputFile);
        final InputStream descriptorStream = this.getDescriptorStream();
        WebAppDD webappdd = underTest.read(descriptorStream);
        underTest.write(webappdd, out);
        
        final InputStream expectedDescriptorStream = getExpectedDescriptorStream();
        assertXMLEqual(new InputStreamReader(expectedDescriptorStream), new FileReader(outputFile));
        
        // now round-trip it
        WebAppDD webappdd2 = underTest.read(new FileInputStream(outputFile));
        assertNotNull(webappdd2);
        assertEquals(this.getDescriptorVersion(), webappdd2.getServletVersion());
        outputFile.delete();
    }
}
