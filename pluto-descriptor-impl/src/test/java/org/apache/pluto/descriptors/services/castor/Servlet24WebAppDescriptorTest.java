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

import junit.framework.TestCase;

import org.apache.pluto.descriptors.services.WebAppDescriptorService;
import org.apache.pluto.descriptors.servlet.WebAppDD;

/**
 * This test ensures that the version attribute of a Servlet 2.4 
 * descriptor is being read from and written to propery by Castor.
 * 
 * @author Elliot Metsger (emetsger@jhu.edu)
 * @since Mar 3, 2007
 * @version $Id$
 */
public class Servlet24WebAppDescriptorTest extends TestCase
{
    
    private static final String DESCRIPTOR = "/servlet-2.4-webapp-descriptor.xml";
    InputStream in = null;
    private WebAppDescriptorService underTest = null;

    protected void setUp() throws Exception
    {
        underTest = new WebAppDescriptorServiceImpl();
        in = this.getClass().getResourceAsStream(DESCRIPTOR);
        assertNotNull(in);
    }

    protected void tearDown() throws Exception
    {
        in = null;
        underTest = null;
    }

    public void testRead() throws Exception
    {
        WebAppDD webapp = underTest.read(in);
        assertNotNull(webapp);
        assertEquals("2.4", webapp.getServletVersion());
    }

    public void testWrite() throws Exception
    {
        WebAppDD webapp = underTest.read(in);
        File outputFile = File.createTempFile("webapp-2.4-descriptor-test", ".xml");
        FileOutputStream out = new FileOutputStream(outputFile);
        underTest.write(webapp, out);
        // roundtrip it.
        WebAppDD webapp2 = underTest.read(new FileInputStream(outputFile));
        assertNotNull(webapp2);
        assertEquals("2.4", webapp2.getServletVersion());
    }

}
