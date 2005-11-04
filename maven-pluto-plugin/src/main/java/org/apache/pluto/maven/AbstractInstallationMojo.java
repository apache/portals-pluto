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

import org.apache.maven.project.MavenProject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Mojo for installation tasks.
 *
 * @since 07/29/2005
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 */
public abstract class AbstractInstallationMojo extends org.apache.pluto.maven.AbstractPlutoMojo {

    protected AbstractInstallationMojo() {

    }

    protected AbstractInstallationMojo(MavenProject project,
                                       File installationDirectory,
                                       File basedir,
                                       String host, String engine) {
        this.installationDirectory = installationDirectory;
        this.host = host;
        this.engine = engine;
        this.project = project;
        this.basedir = basedir;
    }

    /**
     * @parameter expression="${pluto.installation.tomcat.host}"
     */
    protected String host = "localhost";

    /**
     * @parameter expression="${pluto.installation.tomcat.engine}"
     */
    protected String engine = "Catalina";

    /**
     * @parameter expression="${project.basedir}/.."
     */
    protected File basedir;

    protected List getSharedDependencies() {
        List list = new ArrayList();
        list.add("portlet-api");
        list.add("pluto-descriptor-api");
        list.add("pluto-descriptor-impl");
        list.add("pluto-container");
        list.add("pluto-taglib");
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
