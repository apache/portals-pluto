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
package org.apache.pluto.deploy;

import java.io.IOException;
import java.io.InputStream;

/**
 * Interface defining the methods necessary to deploy a portlet
 * application to a servlet container.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 15, 2004
 */
public interface Deployer {

    /**
     * Deploy the specified web application
     * @param config
     * @param webapp
     * @throws IOException
     */
    public void deploy(DeploymentConfig config, InputStream webapp)
        throws IOException, DeploymentException;

}

