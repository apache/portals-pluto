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
package org.apache.pluto.deploy;

import org.apache.pluto.deploy.impl.ArchivedFileAssembler;
import org.apache.pluto.deploy.impl.ExplodedFileAssembler;

import java.io.File;
import java.io.IOException;
import java.util.jar.JarFile;

/**
 * <B>TODO</B>: Document
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Nov 8, 2004
 */
public class AssemblerFactory {

    private static AssemblerFactory factory;

    private AssemblerFactory() {

    }

    public static AssemblerFactory getFactory() {
        if(factory == null) {
            factory = new AssemblerFactory();
        }
        return factory;
    }

    public Assembler createAssembler(File webapp, File destination) {
        if(webapp.isDirectory()) {
            return new ExplodedFileAssembler(webapp, destination);
        }
        else {
            try {
                JarFile war = new JarFile(webapp);
                return new ArchivedFileAssembler(war, destination);
            }
            catch(IOException io) {
                return null;
            }
        }

    }
}

