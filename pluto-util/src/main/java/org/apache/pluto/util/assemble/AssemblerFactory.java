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
package org.apache.pluto.util.assemble;

import org.apache.pluto.util.assemble.file.FileAssembler;

import java.io.File;

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
            return new FileAssembler();
    }
}
