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
import java.io.InputStream;
import java.io.OutputStream;

import junit.framework.TestCase;

import org.apache.pluto.descriptors.services.WebAppDescriptorService;
import org.apache.pluto.descriptors.servlet.WebAppDD;

/**
 * This test ensures that the version attribute of a servlet 2.3 descriptor
 * is being read from and written to properly by Castor.
 *
 * @since Mar 3, 2007
 * @version $Id$
 * @todo JavaDoc
 */
public class Servlet23WebAppDescriptorTest extends TestCase
{

    private static final String DESCRIPTOR = "/servlet-2.3-webapp-descriptor.xml";
    private InputStream in;
    private WebAppDescriptorService underTest;

    protected void setUp() throws Exception
    {
        underTest = new WebAppDescriptorServiceImpl();
        in = this.getClass().getResourceAsStream(DESCRIPTOR);
        assertNotNull(in);
    }

    protected void tearDown() throws Exception
    {
        underTest = null;
        in = null;
    }

    public void testRead() throws Exception
    {
        WebAppDD webappdd = underTest.read(in);
        assertNotNull(webappdd);
        assertEquals("2.3", webappdd.getServletVersion());
    }

    public void testWrite() throws Exception
    {
        File outputFile = File.createTempFile( "webapp-2.3-descriptor-test", ".xml" );
        OutputStream out = new FileOutputStream( outputFile );
        WebAppDD webappdd = underTest.read(in);
        underTest.write(webappdd, out);
        // now round-trip it
        WebAppDD webappdd2 = underTest.read(new FileInputStream(outputFile));
        assertNotNull(webappdd2);
        assertEquals("2.3", webappdd2.getServletVersion());
    }
}
