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
import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @goal uninstall
 * @requiresDependencyResolution runtime
 */
public class UninstallMojo extends AbstractInstallationMojo {

    protected void doExecute() throws Exception {
        getLog().info("Uninstalling Pluto from: "+installationDirectory.getAbsolutePath());

        File dir = new File(installationDirectory, "conf/"+engine+"/"+host);
        delete(new File(dir, "pluto.xml"));
        delete(new File(dir, "testsuite.xml"));

        dir = new File(installationDirectory, "webapps");
        delete(new File(dir, "pluto-portal.war"));
        delete(new File(dir, "pluto-testsuite.war"));

        List sharedDependencies = getSharedDependencies();
        dir = new File(installationDirectory, "shared/lib");
        deleteArtifacts(sharedDependencies, dir);

        List endorsedDependencies = getEndorsedDependencies();
        dir = new File(installationDirectory, "common/endorsed");
        deleteArtifacts(endorsedDependencies, dir);
    }

    private void delete(File file) throws MojoExecutionException {
        getLog().info("Deleting "+file.getAbsolutePath());
        if(!file.delete()) {
            throw new MojoExecutionException("Could not delete file: "+file.getAbsolutePath());
        }
    }

    private void deleteArtifacts(List names, File destination)
    throws MojoExecutionException {
        Set artifacts = project.getArtifacts();

        for(Iterator i = artifacts.iterator();i.hasNext();) {
            Artifact artifact = (Artifact)i.next();
            if(names.contains(artifact.getArtifactId())) {
                File art = artifact.getFile();
                File file = new File(destination, art.getName());
                delete(file);
            }
        }
    }
}
