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

package org.apache.pluto.maven;

import org.apache.pluto.deploy.Assembler;
import org.apache.pluto.deploy.impl.ArchivedFileAssembler;

import java.io.IOException;
import java.io.File;
import java.util.jar.JarFile;

/**
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @todo Document
 * @todo Refactor this and the assembler to model deployer and allow no arg constructor
 * @since Jul 30, 2005
 * 
 * @goal assemble
 */
public class AssembleMojo extends AbstractPortletMojo {

    protected void doExecute() throws Exception {

        Assembler assembler = createAssembler();
        assembler.assemble();

    }

    private Assembler createAssembler() throws IOException {
        JarFile jar = new JarFile(deployment);
        File destination = deployment;
        Assembler assembler = new ArchivedFileAssembler(jar, destination);
        return assembler;
    }
}
