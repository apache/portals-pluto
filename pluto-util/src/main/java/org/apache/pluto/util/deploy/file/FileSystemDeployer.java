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
package org.apache.pluto.util.deploy.file;

import org.apache.pluto.util.deploy.Deployer;
import org.apache.pluto.util.deploy.DeploymentConfig;
import org.apache.pluto.util.deploy.DeploymentException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 15, 2004
 */
public abstract class FileSystemDeployer implements Deployer {
	
	// Constructor -------------------------------------------------------------
	
	/**
	 * Protected no-arg constructor.
	 */
    protected FileSystemDeployer() {
    	// Do nothing.
    }
    
    
    // Deployer Impl -----------------------------------------------------------
    
    public void deploy(DeploymentConfig config, InputStream webappInputStream)
    throws IOException, DeploymentException {

        File dir = getWebApplicationDirectory(config);
        File file = new File(dir, config.getDeploymentName() + ".war");
        FileOutputStream out = new FileOutputStream(file);

        int read = -1;
        byte[] bits = new byte[256];
        while ((read = webappInputStream.read(bits)) != -1) {
            out.write(bits, 0, read);
        }
        out.flush();
        out.close();
        configure(config);
    }
    
    
    // Protected Abstract Methods ----------------------------------------------
    
    /**
     * Retrieves the directory to which the portlet app should be deployed.
     * @return
     */
    protected abstract File getWebApplicationDirectory(DeploymentConfig config)
    throws DeploymentException;
    
    /**
     * Configures the deployment.
     * @param config
     */
    protected abstract void configure(DeploymentConfig config)
    throws DeploymentException, IOException;

}

