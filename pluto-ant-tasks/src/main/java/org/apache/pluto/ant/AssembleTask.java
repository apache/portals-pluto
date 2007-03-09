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
package org.apache.pluto.ant;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.pluto.util.UtilityException;
import org.apache.pluto.util.assemble.Assembler;
import org.apache.pluto.util.assemble.AssemblerConfig;
import org.apache.pluto.util.assemble.AssemblerFactory;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;

/**
 * TODO JavaDoc
 *
 * @version 1.0
 * @since Nov 23, 2005
 */
public class AssembleTask extends Task {

    private File portletxml;

    private File webxml;

    private File destfile;

    private File webapp;

    private File war;

    private File destdir;

    private Collection warFileSets = new LinkedList();

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

    public File getWar() {
        return this.war;
    }

    public void setWar(File war) {
        this.war = war;
    }

    public File getDestdir() {
        if (destdir == null) {
            return (war != null ? war.getParentFile() : null);
        }
        return this.destdir;
    }

    public void setDestdir(File destDir) {
        this.destdir = destDir;
    }

    public void addWars(FileSet fileSet) {
        this.warFileSets.add(fileSet);
    }

    public void execute() throws BuildException {

        validateArgs();

        try {
            if (this.warFileSets.size() > 0) {
                for (final Iterator fileSetItr = this.warFileSets.iterator(); fileSetItr.hasNext();) {
                    final FileSet fileSet = (FileSet)fileSetItr.next();
                    final DirectoryScanner directoryScanner = fileSet.getDirectoryScanner(this.getProject());

                    final File basedir = directoryScanner.getBasedir();
                    final String[] includedFiles = directoryScanner.getIncludedFiles();

                    for (int index = 0; index < includedFiles.length; index++) {
                        AssemblerConfig config = new AssemblerConfig();

                        final File warSource = new File(basedir, includedFiles[index]);
                        config.setWarSource(warSource);
                        config.setDestination(getDestdir());

                        this.log("Assembling '" + warSource + "' to '" + getDestdir() + "'");
                        Assembler assembler = AssemblerFactory.getFactory().createAssembler(config);
                        assembler.assemble(config);
                    }
                }
            }
            else {
                AssemblerConfig config = new AssemblerConfig();

                final File warSource = getWar();
                if (warSource != null) {
                    config.setWarSource(warSource);
                    config.setDestination(getDestdir());
                    this.log("Assembling '" + warSource + "' to '" + getDestdir() + "'");
                }
                else {
                    config.setPortletDescriptor(getPortletxml());
                    config.setWebappDescriptor(getWebxml());
                    config.setDestination(getDestfile());
                    this.log("Assembling '" + getWebxml() + "' to '" + getDestfile() + "'");
                }


                Assembler assembler = AssemblerFactory.getFactory().createAssembler(config);
                assembler.assemble(config);
            }
        }

        catch(UtilityException ue) {
            throw new BuildException(ue);
        }
    }

    private void validateArgs() throws BuildException {
        //Check if running with webapp arg
        if(webapp != null) {
            if(!webapp.exists()) {
               throw new BuildException("webapp "+webapp.getAbsolutePath()+ " does not exist");
            }

            if (war != null) {
                throw new BuildException("war should not be specified if webapp is specified");
            }
            if (this.warFileSets.size() > 0) {
                throw new BuildException("wars should not be specified if webapp is specified");
            }
            if (destdir != null) {
                throw new BuildException("destfile should not be specified if webapp is specified");
            }

            return;
        }

        //Check if running with war arg
        if (war != null) {
            if(!war.exists()) {
                throw new BuildException("WAR "+war.getAbsolutePath()+ " does not exist");
            }

            if (this.warFileSets.size() > 0) {
                throw new BuildException("wars should not be specified if war is specified");
            }
            if (webapp != null) {
                throw new BuildException("webapp should not be specified if war is specified");
            }
            if (destfile != null) {
                throw new BuildException("destfile should not be specified if war is specified");
            }
            if (portletxml != null) {
                throw new BuildException("portletxml should not be specified if war is specified");
            }
            if (webxml != null) {
                throw new BuildException("webxml should not be specified if war is specified");
            }

            return;
        }

        //Check if running with war arg
        if (this.warFileSets.size() > 0) {
            if (war != null) {
                throw new BuildException("wars should not be specified if war is specified");
            }
            if (webapp != null) {
                throw new BuildException("webapp should not be specified if war is specified");
            }
            if (destfile != null) {
                throw new BuildException("destfile should not be specified if war is specified");
            }
            if (portletxml != null) {
                throw new BuildException("portletxml should not be specified if war is specified");
            }
            if (webxml != null) {
                throw new BuildException("webxml should not be specified if war is specified");
            }

            return;
        }

        //Check if running with portletxml && webxml args
        if(portletxml == null || !portletxml.exists()) {
            throw new BuildException("portletxml "+portletxml+" does not exist");
        }
        if(webxml == null || !webxml.exists()) {
            throw new BuildException("webxml "+webxml + " does not exist");
        }
        if (war != null) {
            throw new BuildException("war should not be specified if portletxml and webxml are aspecified");
        }
        if (this.warFileSets.size() > 0) {
            throw new BuildException("wars should not be specified if portletxml and webxml are aspecified");
        }
        if (destdir != null) {
            throw new BuildException("destfile should not be specified if portletxml and webxml are aspecified");
        }
    }
}
