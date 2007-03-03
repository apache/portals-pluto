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
package org.apache.pluto.util.assemble.war;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;
import org.apache.pluto.util.assemble.AssemblerConfig;

/**
 * @author Eric Dalquist <a href="mailto:eric.dalquist@doit.wisc.edu">eric.dalquist@doit.wisc.edu</a>
 * @version $Revision$
 */
public class WarAssemblerTest extends TestCase {
    private File portletFile = null;
    
    protected void setUp() throws Exception {
        final URL portletUrl = this.getClass().getResource("/org/apache/pluto/util/assemble/war/WarDeployerTestPortlet.war");
        this.portletFile = new File(portletUrl.getFile());
    }

    protected void tearDown() throws Exception {
        this.portletFile = null;
    }

    public void testAssembleToNewDirectory() throws Exception {
        AssemblerConfig config = new AssemblerConfig();
        
        config.setWarSource(this.portletFile);
        
        final File tempDir = getTempDir();
        config.setDestination(tempDir);
        
        WarAssembler assembler = new WarAssembler();
        assembler.assemble(config);
        
        //How to validate it worked?
    }
    
    public void testAssembleOverSelf() throws Exception {
        AssemblerConfig config = new AssemblerConfig();
        
        final File portletCopy = File.createTempFile(this.portletFile.getName() + ".", ".war");
        portletCopy.deleteOnExit();
        FileUtils.copyFile(this.portletFile, portletCopy);
        
        config.setWarSource(portletCopy);
        config.setDestination(portletCopy.getParentFile());
        
        WarAssembler assembler = new WarAssembler();
        assembler.assemble(config);
        
        //How to validate it worked?
    }

    private File getTempDir() throws IOException {
        final File tempFile = File.createTempFile("DoesNotMatter", ".tmp");
        tempFile.delete();
        final File tempDir = tempFile.getParentFile();
        return tempDir;
    }
}
