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
package org.apache.pluto.util.assemble.file;

import java.io.File;
import java.io.FileReader;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.pluto.util.assemble.AssemblerConfig;
import org.apache.pluto.util.assemble.ResourceEntityResolver;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;

/**
 * @version $Revision$
 */
public class FileAssemblerTest extends XMLTestCase {

    private File webXmlFile;
    private File web23XmlFile;
    private File portletXmlFile;
    private File portlet23XmlFile;
    private File assembledWebXmlFile;
    private File assembledWeb23XmlFile;

    protected void setUp() throws Exception {
        XMLUnit.setIgnoreWhitespace(true);
        XMLUnit.setControlEntityResolver( new ResourceEntityResolver() );
        XMLUnit.setTestEntityResolver( new ResourceEntityResolver() );

        final URL webXmlUrl = this.getClass().getResource("/org/apache/pluto/util/assemble/file/web.xml");
        this.webXmlFile = new File(webXmlUrl.getFile());

        final URL web23XmlUrl = this.getClass().getResource("/org/apache/pluto/util/assemble/file/webServlet23.xml");
        this.web23XmlFile = new File(web23XmlUrl.getFile());

        final URL portletXmlUrl = this.getClass().getResource("/org/apache/pluto/util/assemble/file/portlet.xml");
        this.portletXmlFile = new File(portletXmlUrl.getFile());

        final URL portlet23XmlUrl = this.getClass().getResource("/org/apache/pluto/util/assemble/file/portletWebServlet23.xml");
        this.portlet23XmlFile = new File(portlet23XmlUrl.getFile());

        final URL assembledWebXmlUrl = this.getClass().getResource("/org/apache/pluto/util/assemble/file/assembled.web.xml");
        this.assembledWebXmlFile = new File(assembledWebXmlUrl.getFile());

        final URL assembledWeb23XmlUrl = this.getClass().getResource("/org/apache/pluto/util/assemble/file/assembled.webServlet23.xml");
        this.assembledWeb23XmlFile = new File(assembledWeb23XmlUrl.getFile());
    }

    protected void tearDown() throws Exception {
        this.webXmlFile = null;
        this.portletXmlFile = null;
    }

    public void testAssembleToNewDirectory() throws Exception {
        AssemblerConfig config = new AssemblerConfig();

        final File webXmlFileDest = File.createTempFile(this.webXmlFile.getName() + ".", ".xml");
        webXmlFileDest.deleteOnExit();

        config.setWebappDescriptor(this.webXmlFile);
        config.setPortletDescriptor(this.portletXmlFile);
        config.setDestination(webXmlFileDest);

        FileAssembler assembler = new FileAssembler();
        assembler.assemble(config);

        assertXMLEqual(new FileReader(this.assembledWebXmlFile), new FileReader(webXmlFileDest));
    }

    public void testAssembleWeb23ToNewDirectory() throws Exception {
        AssemblerConfig config = new AssemblerConfig();

        final File webXmlFileDest = File.createTempFile(this.web23XmlFile.getName() + ".", ".xml");
        webXmlFileDest.deleteOnExit();

        config.setWebappDescriptor(this.web23XmlFile);
        config.setPortletDescriptor(this.portlet23XmlFile);
        config.setDestination(webXmlFileDest);

        FileAssembler assembler = new FileAssembler();
        assembler.assemble(config);

        assertXMLEqual(new FileReader(this.assembledWeb23XmlFile), new FileReader(webXmlFileDest));
    }

    public void testAssembleOverSelf() throws Exception {
        AssemblerConfig config = new AssemblerConfig();

        final File webXmlFileCopy = File.createTempFile(this.webXmlFile.getName() + ".", ".source.xml");
        webXmlFileCopy.deleteOnExit();

        FileUtils.copyFile(this.webXmlFile, webXmlFileCopy);

        config.setWebappDescriptor(webXmlFileCopy);
        config.setPortletDescriptor(this.portletXmlFile);
        config.setDestination(webXmlFileCopy);

        FileAssembler assembler = new FileAssembler();
        assembler.assemble(config);

        assertXMLEqual(new FileReader(this.assembledWebXmlFile), new FileReader(webXmlFileCopy));
    }
}
