/*
 * Copyright 2006 The Apache Software Foundation.
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

import java.util.Properties;

import org.apache.pluto.util.deploy.DeploymentConfig;

/**
 *
 * @author <a href="cdoremus@apache.org">Craig Doremus</a>
 *
 */
public class TomcatDeploymentConfig extends DeploymentConfig {

	Properties props = new Properties();
	/**
	 * Constructor from base class
	 * @param deploymentName
	 */
	public TomcatDeploymentConfig(String deploymentName) {
		super(deploymentName);
	}

	/**
	 * Retrieves properties from internal store added using addDeploymentProperty().
	 * 
	 * @see org.apache.pluto.util.deploy.DeploymentConfig#getDeploymentProperty(java.lang.String)
	 */
	public String getDeploymentProperty(String key) {
		return props.getProperty(key);
	}
	
	public void addDeploymentProperty(String key, String value) {
		props.put(key, value);
	}
}
