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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 28, 2004
 */
public class Tomcat4FileSystemDeployer extends FileSystemDeployer {

    private File tomcatHome = null;

    public Tomcat4FileSystemDeployer() {

    }

    protected File getWebApplicationDirectory(DeploymentConfig config)
    throws DeploymentException {
        File dir = new File(getTomcatHome(config), "webapps");
        dir.mkdirs();
        return dir;
    }

    protected void configure(DeploymentConfig config)
    throws DeploymentException, IOException {
        File conf = new File(getConfigDir(config), config.getDeploymentName()+".xml");
        PrintWriter out  = new PrintWriter(new FileWriter(conf));
        out.print("<Context path=\"/");
        out.print(config.getDeploymentName());
        out.print("\" docBase=\"");
        out.print(config.getDeploymentName()+".war");
        out.println("\" crossContext=\"true\">");
        out.println("</Context>");

        out.flush();
        out.close();
    }

    protected File getTomcatHome(DeploymentConfig config) throws DeploymentException {
        if(tomcatHome == null) {
            String file = config.getDeploymentProperty("tomcat.home");
            if(file == null) {
                throw new DeploymentException("tomcat.home not defined");
            }
            tomcatHome =  new File(file);
            tomcatHome.mkdirs();
        }
        return tomcatHome;
    }

    protected File getConfigDir(DeploymentConfig config)
    throws DeploymentException {
        File dir = new File(getTomcatHome(config), "conf");
        return dir;
    }

}

