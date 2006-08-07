/*
 * Copyright 2005 The Apache Software Foundation
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
package org.apache.pluto.descriptors.services.impl;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.apache.pluto.descriptors.services.WebAppDescriptorService;
import org.apache.pluto.descriptors.servlet.WebAppDD;

public class FileWebAppDescriptorServiceImplTest extends TestCase {
    
    private static final String SERVLET_23_WEB_XML = "web-2.3.xml";
    private static final String SERVLET_24_WEB_XML = "web.xml";

    /**
     * Tests method for 'org.apache.pluto.descriptors.services.impl.FileWebAppDescriptorServiceImpl.read()'
     * 
     * This test uses the FileWebAppDescriptorServiceImpl implementation of the WebAppDescriptorService to
     * read a web application deployment descriptor, and checks to see that the servlet version is correctly
     * set to "2.3".
     * 
     * @throws Exception
     */
    public void testServlet23Read() throws Exception {
        String webXmlPath = WebAppDD.class.getResource(SERVLET_23_WEB_XML).getPath();
        WebAppDescriptorService descSvc = createService("/testcontext", webXmlPath);
        WebAppDD webDD = null;
        try {
            // Use the FileWebAppDescriptorServiceImpl to read in our test servlet 2.3 web.xml file.
            webDD = descSvc.read();
        } catch (IOException ioe) {
            String msg = "Encountered an IOException while trying to read " + webXmlPath;
            System.out.println(msg);
            ioe.printStackTrace();
            throw ioe;
        }
        // make sure the test web.xml file was unmarshaled.
        assertNotNull(webDD);
        
        // ensure that the Servlet Version is 2.3
        assertEquals( "2.3", webDD.getServletVersion());       
    }

    /**
     * Tests method for 'org.apache.pluto.descriptors.services.impl.FileWebAppDescriptorServiceImpl.write()'
     * 
     * This test uses the FileWebAppDescriptorServiceImpl implementation of the WebAppDescriptorService to
     * write a web application deployment descriptor, and checks to see that the servlet version is correctly
     * set to "2.3".
     * 
     * @throws Exception
     */
    public void testServlet23Write() throws Exception {
        // Use an instance of the FileWebAppDescriptor service to read in our web.xml file.
        // We use the read() method to create our WebAppDD object that we'll use below.        
        String webXmlPath = WebAppDD.class.getResource(SERVLET_23_WEB_XML).getPath();
        WebAppDescriptorService descSvc = createService("/testcontext", webXmlPath);
        WebAppDD webDD = descSvc.read();
        assertNotNull(webDD);
        assertEquals("2.3", webDD.getServletVersion());        
        
        // Create a second instance of the FileWebAppDescriptorImpl service to write out a web.xml file.
        // We don't use the same instance as above because the FileWebAppDescriptorImpl service uses the
        // same InputStream for reading and writing and we'd overwrite our test web.xml.
        String testOutputDir = WebAppDD.class.getResource(".").getPath();        
        descSvc = createService("/testcontext", testOutputDir + "/testWeb23.xml");        
        
        // write out the file (it must exist before marshaling)
        new File( testOutputDir + "/testWeb23.xml").createNewFile();
        descSvc.write(webDD);
        
        // Ok, we've written out a test file; lets read it back in with yet another instance of a FileWebAppDescriptorImpl
        // and make sure that we can recover the version of the WebAppDD object.
        webDD = null;
        descSvc = createService("/testcontext", testOutputDir + "/testWeb23.xml");
        webDD = descSvc.read();
                
        // Servlet Version should be equal to "2.3"
        assertNotNull(webDD);
        assertEquals("2.3", webDD.getServletVersion());                              
    }

    /**
     * Tests method for 'org.apache.pluto.descriptors.services.impl.FileWebAppDescriptorServiceImpl.read()'
     * 
     * This test uses the FileWebAppDescriptorServiceImpl implementation of the WebAppDescriptorService to
     * read a web application deployment descriptor, and checks to see that the servlet version is correctly
     * set to "2.4".
     * 
     * @throws Exception
     */
    public void testServlet24Read() throws Exception {
        String webXmlPath = WebAppDD.class.getResource(SERVLET_24_WEB_XML).getPath();            
        WebAppDescriptorService descSvc = createService("/testcontext", webXmlPath);
        WebAppDD webDD = null;
        try {
            // Use the FileWebAppDescriptorServiceImpl to read in our test servlet 2.4 web.xml file.
            webDD = descSvc.read();
        } catch (IOException ioe) {
            String msg = "Encountered an IOException while trying to read " + webXmlPath;
            System.out.println(msg);
            ioe.printStackTrace();
            throw ioe;
        }
        
        // make sure the test web.xml file was unmarshaled.
        assertNotNull(webDD);        
        // ensure that the Servlet Version is 2.4
        assertEquals( "2.4", webDD.getServletVersion());
    }

    /**
     * Tests method for 'org.apache.pluto.descriptors.services.impl.FileWebAppDescriptorServiceImpl.write()'
     * 
     * This test uses the FileWebAppDescriptorServiceImpl implementation of the WebAppDescriptorService to
     * write a web application deployment descriptor, and checks to see that the servlet version is correctly
     * set to "2.4".
     * 
     * @throws Exception
     */
    public void testServlet24Write( ) throws Exception {
        // Use an instance of the FileWebAppDescriptor service to read in our web.xml file.
        // We use the read() method to create our WebAppDD object that we'll write out below.
        String webXmlPath = WebAppDD.class.getResource(SERVLET_24_WEB_XML).getPath();
        WebAppDescriptorService descSvc = createService("/testcontext", webXmlPath);
        WebAppDD webDD = descSvc.read();
        
        // Create a second instance of the FileWebAppDescriptorImpl service to write out a web.xml file.
        // We don't use the same instance as above because the FileWebAppDescriptorImpl service uses the
        // same InputStream for reading and writing and we'd overwrite our test web.xml.
        String testOutputWebXmlPath = WebAppDD.class.getResource(".").getPath().concat("/testWeb24.xml");        
        descSvc = createService("/testcontext", testOutputWebXmlPath);        
        
        // output file must exist first
        new File(testOutputWebXmlPath).createNewFile();
        // write out the file        
        descSvc.write(webDD);
        
        // Ok, we've written out a test file; lets read it back in with yet another instance of a FileWebAppDescriptorImpl
        // and make sure that we can recover the version of the WebAppDD object.
        webDD = null;
        descSvc = createService("/testcontext", testOutputWebXmlPath);
        webDD = descSvc.read();
                
        // Servlet Version should be equal to "2.4"
        assertEquals("2.4", webDD.getServletVersion()); 
    }
    
    private WebAppDescriptorService createService(String context, String webXmlFilePath) {
        FileWebAppDescriptorServiceImpl fileSvcImpl = new FileWebAppDescriptorServiceImpl(context, webXmlFilePath);
        return fileSvcImpl;
    }
    
}
