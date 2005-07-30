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

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @goal install
 * @requiresDependencyResolution runtime
 */
public class InstallMojo extends AbstractMojo {

    /**
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    private MavenProject project;

    /**
     * @parameter expression="${pluto.installation.dir}"
     * @required
     */
    private File installationDirectory;


    /**
     * @parameter expression="${pluto.installation.tomcat.host}"
     */
    private String host = "localhost";


    /**
     * @parameter expression="${pluto.installation.tomcat.engine}"
     */
    private String engine = "Catalina";

    /**
     * @parameter expression="${project.basedir}/.."
     */
    private File basedir;


    public void execute() throws MojoExecutionException {
        if(!installationDirectory.exists() || !installationDirectory.isDirectory()) {
            throw new MojoExecutionException("Installation Directory "+installationDirectory.getAbsolutePath()+" does not exist.");
        }

        try {
            doExecute();
        }
        catch(Exception e) {
            throw new MojoExecutionException("Error Installing Pluto", e);
        }
    }

    private void doExecute() throws Exception {
        getLog().info("Installing Pluto to: "+installationDirectory.getAbsolutePath());
        configure();
        sharedLibraries();
        endorsedLibraries();
        webapps();
    }

    private void configure() throws IOException {
        File conf = new File(installationDirectory, "conf/"+engine+"/"+host);
        conf.mkdirs();

        File from = new File(basedir, "pluto-portal/src/main/resources/pluto.xml");
        getLog().info("Copying "+from.getAbsolutePath()+" to "+conf.getAbsolutePath());
        FileUtils.copyFileToDirectory(from, conf);

        from = new File(basedir, "pluto-testsuite/src/main/resources/testsuite.xml");
        getLog().info("Copying "+from.getAbsolutePath()+" to "+conf.getAbsolutePath());
        FileUtils.copyFileToDirectory(from, conf);
    }

    private List getSharedDependencies() {
        List list = new ArrayList();
        list.add("pluto-container");
        list.add("pluto-descriptor-api");
        list.add("pluto-descriptor-impl");
        list.add("portlet-api");
        list.add("castor");
        return list;
    }

    private void sharedLibraries() throws IOException {
        File shared = new File(installationDirectory, "shared/lib");
        shared.mkdirs();

        List sharedDependencies = getSharedDependencies();
        copyArtifacts(sharedDependencies, shared);
    }

    private List getEndorsedDependencies() {
        List list = new ArrayList();
        list.add("xercesImpl");
        list.add("xmlParserAPIs");
        return list;
    }

    private void endorsedLibraries() throws IOException {
        File endorsed = new File(installationDirectory, "common/endorsed");
        endorsed.mkdirs();

        List endorsedDependencies = getEndorsedDependencies();
        copyArtifacts(endorsedDependencies, endorsed);
    }

    private void webapps() throws IOException {
        File webapps = new File(installationDirectory, "webapps");
        webapps.mkdirs();

        File from = new File(basedir, "/pluto-portal/target/pluto-portal.war");
        File to = new File(installationDirectory, "webapps");
        getLog().info("Copying "+from.getAbsolutePath()+" to "+to.getAbsolutePath());
        FileUtils.copyFileToDirectory(from, to);

        from = new File(basedir, "/pluto-testsuite/target/pluto-testsuite.war");
        getLog().info("Copying "+from.getAbsolutePath()+" to "+to.getAbsolutePath());
        FileUtils.copyFileToDirectory(from, to);
    }

    private void copyArtifacts(List names, File destination)
            throws IOException {
        Set artifacts = project.getArtifacts();

        for(Iterator i = artifacts.iterator();i.hasNext();) {
            Artifact artifact = (Artifact)i.next();
            if(names.contains(artifact.getArtifactId())) {
                File from = artifact.getFile();
                getLog().info("Copying "+from.getAbsolutePath()+" to "+destination.getAbsolutePath());
                FileUtils.copyFileToDirectory(from, destination);
            }
        }
    }

}
