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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Interface defining the methods necessary to deploy a portlet application to
 * a servlet container.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 15, 2004
 */
public interface Undeployer {

    /**
     * Undeploy the specified portlet application to pluto.
     * @param config  the deployment configuration of the portlet app.
     * @param webappInputStream  the input stream to the WAR file.
     * @throws IOException  if an IO error occurs.
     * @throws DeploymentException  if a deployment error occurs.
     */
    public void undeploy(DeploymentConfig config, File webappFile)
    throws IOException, DeploymentException;

}

