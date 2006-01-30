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
package org.apache.pluto.util.deploy;

/**
 * Encapsulation of deployment configuration info. Implementations must provide
 * a way to retrieved context specific deployment properties.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 15, 2004
 */
public abstract class DeploymentConfig {

    /** The deployment name. */
    private String deploymentName = null;

    /**
     * Default Constructor.
     * @param deploymentName the name of the deployment.
     */
    public DeploymentConfig(String deploymentName) {
        this.deploymentName = deploymentName;
    }

    /**
     * Standard Getter.
     * @return the name of the deployment.
     */
    public String getDeploymentName() {
        return deploymentName;
    }

    /**
     * Standard Setter
     * @param deploymentName the name of the deployment.
     */
    public void setDeploymentName(String deploymentName) {
        this.deploymentName = deploymentName;
    }

    /**
     * Retrieve the named deployment property.
     * @param key
     * @return
     */
    public abstract String getDeploymentProperty(String key);

}
