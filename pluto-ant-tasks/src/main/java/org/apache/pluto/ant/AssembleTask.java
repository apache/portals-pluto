/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
package org.apache.pluto.ant;

import org.apache.tools.ant.Task;
import org.apache.tools.ant.BuildException;
import org.apache.pluto.util.UtilityException;
import org.apache.pluto.util.assemble.Assembler;
import org.apache.pluto.util.assemble.AssemblerFactory;
import org.apache.pluto.util.assemble.AssemblerConfig;

import java.io.File;

/**
 * TODO JavaDoc
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Nov 23, 2005
 */
public class AssembleTask extends Task {

    private File portletxml;

    private File webxml;

    private File destfile;

    private File webapp;

    public File getPortletxml() {
        if(webapp != null)
            return new File(webapp, "WEB-INF/portlet.xml");
        return portletxml;
    }

    public void setPortletxml(File portletxml) {
        this.portletxml = portletxml;
    }

    public File getWebxml() {
        if(webapp != null)
            return new File(webapp, "WEB-INF/web.xml");
        return webxml;
    }

    public void setWebxml(File webxml) {
        this.webxml = webxml;
    }

    public File getDestfile() {
        if(destfile != null)
            return destfile;
        return getWebxml();
    }

    public void setDestfile(File destfile) {
        this.destfile = destfile;
    }

    public File getWebapp() {
        return webapp;
    }

    public void setWebapp(File webapp) {
        this.webapp = webapp;
    }

    public void execute() throws BuildException {

        validateArgs();

        try {
            AssemblerConfig config = new AssemblerConfig();
            config.setPortletDescriptor(getPortletxml());
            config.setWebappDescriptor(getWebxml());
            config.setDestination(getDestfile());

            Assembler assembler =
                AssemblerFactory.getFactory().createAssembler(config);

           assembler.assemble(config);
        }

        catch(UtilityException ue) {
            throw new BuildException(ue);
        }
    }

    private void validateArgs() throws BuildException {
        if(webapp != null) {
            if(!webapp.exists()) {
               throw new BuildException("webapp "+webapp.getAbsolutePath()+ " does not exist");
            }
            return;
        }

        if(portletxml == null || !portletxml.exists()) {
            throw new BuildException("portletxml "+portletxml+" does not exist");
        }

        if(webxml == null || !webxml.exists()) {
            throw new BuildException("webxml "+webxml + " does not exist");
        }
    }
}
