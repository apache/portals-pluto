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
package org.apache.pluto.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

import java.util.List;
import java.util.ArrayList;
import java.io.File;

/**
 * Abstract Mojo for installation tasks.
 *
 * @since 07/29/2005
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 */
public abstract class AbstractInstallationMojo extends AbstractMojo {

    /**
     * @parameter expression="${pluto.installation.dir}"
     * @required
     */
    protected File installationDirectory;
    /**
     * @parameter expression="${pluto.installation.tomcat.host}"
     */
    protected String host = "localhost";

    /**
     * @parameter expression="${pluto.installation.tomcat.engine}"
     */
    protected String engine = "Catalina";

    /**
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    protected MavenProject project;

    /**
     * @parameter expression="${project.basedir}/.."
     */
    protected File basedir;

    public void execute() throws MojoExecutionException {
        if(!installationDirectory.exists() || !installationDirectory.isDirectory()) {
            throw new MojoExecutionException("Installation Directory "+installationDirectory.getAbsolutePath()+" does not exist.");
        }

        try {
            doExecute();
        }
        catch(MojoExecutionException mee) {
            throw mee;
        }
        catch(Exception e) {
            throw new MojoExecutionException("Error Installing Pluto", e);
        }
    }

    /**
     * Process the actual execution.
     * @throws Exception
     */
    protected abstract void doExecute() throws Exception;

    protected List getSharedDependencies() {
        List list = new ArrayList();
        list.add("pluto-container");
        list.add("pluto-descriptor-api");
        list.add("pluto-descriptor-impl");
        list.add("portlet-api");
        list.add("castor");
        return list;
    }

    protected List getEndorsedDependencies() {
        List list = new ArrayList();
        list.add("xercesImpl");
        list.add("xmlParserAPIs");
        return list;
    }
}
