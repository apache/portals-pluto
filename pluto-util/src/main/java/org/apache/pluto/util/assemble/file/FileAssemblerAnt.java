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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.pluto.util.UtilityException;
import org.apache.pluto.util.assemble.Assembler;
import org.apache.pluto.util.assemble.AssemblerConfig;
import org.apache.pluto.util.assemble.io.WebXmlStreamingAssembly;

/**
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Nov 8, 2004
 */
public class FileAssemblerAnt implements Assembler {
    
    // Constructor -------------------------------------------------------------
    
    /**
     * Default no-arg constructor.
     */
    public FileAssemblerAnt() {
    	// Do nothing.
    }
    
    
    // Assembler Impl ----------------------------------------------------------
    
    public void assemble(AssemblerConfig config) throws UtilityException {
        try {
            InputStream webXmlIn = new FileInputStream(
            		config.getWebappDescriptor());
            InputStream portletXmlIn = new FileInputStream(
            		config.getPortletDescriptor());
            FileOutputStream webXmlOut = new FileOutputStream(
            		config.getDestination());
            WebXmlStreamingAssembly.assembleStream(webXmlIn, portletXmlIn, webXmlOut, DISPATCH_SERVLET_CLASS);
        } catch (IOException ex) {
            throw new UtilityException(ex.getMessage(), ex, null);
        }
    }
}

