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

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

import java.io.File;

/**
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @todo Document
 * @since Jul 30, 2005
 */
public abstract class AbstractPlutoMojo extends AbstractMojo {

    /**
     * @parameter expression="${installDir}"
     */
    protected File installationDirectory = null;

    /**
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    protected MavenProject project = null;

    public void execute() throws MojoExecutionException {
        // Validation of the installDir property is done by maven.
        try {
            doValidate();
            doExecute();
        } catch (MojoExecutionException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new MojoExecutionException("Error Installing Pluto", ex);
        }
    }

    /**
     * Process the actual execution.
     * @throws Exception
     */
    protected abstract void doExecute() throws Exception;

    protected abstract void doValidate() throws Exception;
}
