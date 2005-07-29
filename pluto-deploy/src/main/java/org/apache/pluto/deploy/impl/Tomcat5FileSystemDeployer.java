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
package org.apache.pluto.deploy.impl;

import org.apache.pluto.deploy.DeploymentConfig;
import org.apache.pluto.deploy.DeploymentException;

import java.io.File;

/**
 * Deployer used to deploy portlet applications to a Tomcat 5
 * installation via the file system.  This deployer performs
 * a simple copy of the assembled application into the webapps
 * directory and creates a context configuration file under
 * the ${tomcat.home}/conf/${tomcat.service}/${tomcat.host}
 * directory.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 28, 2004
 */
public class Tomcat5FileSystemDeployer extends Tomcat4FileSystemDeployer {

    /**
     * Retrieve the configuration directory for the deployment.
     *
     * @param config
     * @return
     * @throws DeploymentException
     */
    protected File getConfigDir(DeploymentConfig config) throws DeploymentException {
        File dir = super.getConfigDir(config);
        String serv = config.getDeploymentProperty("tomcat.service");
        if(serv == null) {
            throw new DeploymentException("tomcat.service is not defined");
        }
        dir = new File(dir, serv);
        String host = config.getDeploymentProperty("tomcat.host");
        if(host == null) {
            throw new DeploymentException("tomcat.host is not defined");
        }
        dir = new File(dir, host);
        dir.mkdirs();
        return dir;
    }
}

