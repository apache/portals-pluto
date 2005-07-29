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
package org.apache.pluto.deploy.maven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.jelly.TagSupport;
import org.apache.commons.jelly.XMLOutput;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.JellyTagException;
import org.apache.pluto.deploy.Assembler;
import org.apache.pluto.deploy.AssemblerFactory;

/**
 * Tag which is used to assemble portlet applications.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 27, 2004
 */
public class PlutoAssemblerTag extends TagSupport {

    private Assembler assembler;

    public PlutoAssemblerTag() {
    }

    public void doTag(XMLOutput xmlOutput) throws MissingAttributeException,
                                                  JellyTagException {

        String src = (String)context.getVariable("maven.pluto.src.webapp");
        File source = new File(src);

        try {
            // BIG HACK! Why doesn't Maven like Transformers?
            // I think it probably does a System.setProperties(Props)
            // and overrides the dflt prop.
            // xalan comes with jdk1.4.0x so we're kinda safe to do this
            if(System.getProperty("javax.xml.transform.TransformerFactory")==null) {
                System.setProperty(
                    "javax.xml.transform.TransformerFactory",
                    "org.apache.xalan.processor.TransformerFactoryImpl"
                );
            }
            assembler =  AssemblerFactory.getFactory().
                createAssembler(source, source);
            assembler.assemble();
        }
        catch(IOException io) {
            io.printStackTrace();
            throw new JellyTagException(io);
        }
        catch(RuntimeException re) {
            re.printStackTrace();
            throw re;
        }
        catch(Error error) {
            error.printStackTrace();
            throw error;
        }
    }

}

