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
package org.apache.pluto.deploy.maven;

import org.apache.commons.jelly.JellyContext;
import org.apache.pluto.deploy.DeploymentConfig;

/**
 * Deployment Configuration used for Maven goals.
 * Exposes the JellyContext underwhich Maven is executing
 * so that the Variables can be used as deployment properties.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 28, 2004
 *
 */
class MavenDeploymentConfig extends DeploymentConfig  {

    private JellyContext context;

    MavenDeploymentConfig(String name, JellyContext context) {
        super(name);
        this.context = context;
    }

    public String getDeploymentProperty(String key) {
        Object var = context.getVariable(key);
        // for backwards compatibility, if it's null
        // we will append maven. and retry.
        if(var == null) {
            var = context.getVariable("maven."+key);
        }
        return var==null?null:var.toString();
    }
}

