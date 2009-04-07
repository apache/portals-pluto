/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.pluto.driver.container;

import org.apache.pluto.container.ContainerInfo;

/**
 * @version $Id$
 *
 */
public final class PlutoContainerInfo implements ContainerInfo
{
    private static final ContainerInfo instance = new PlutoContainerInfo();
    
    private PlutoContainerInfo()
    {
    }
    
    public static ContainerInfo getInfo()
    {
        return instance;
    }
    /**
     * Retrieve the name of the container.
     * @return the container name.
     */
    public String getPortletContainerName() {
        return Configuration.getPortletContainerName();
    }

    /**
     * Retrieve the portlet container version.
     *
     * @return container version
     */
    public String getPortletContainerVersion() {
        return Configuration.getPortletContainerVersion();
    }

    /**
     * Retrieve the major version number of the specification which this version
     * of pluto supports.
     * @return te major specification version.
     */
    public int getMajorSpecificationVersion() {
        return Configuration.getMajorSpecificationVersion();
    }

    /**
     * Retrieve the minor version number of the specification which this version
     * of pluto supports.
     * @return the minor specification version.
     */
    public int getMinorSpecificationVersion() {
        return Configuration.getMinorSpecificationVersion();
    }

    /**
     * Retrieve the formatted server info String required to be returned by the
     * PortletContext.
     * @return the server info.
     */
    public String getServerInfo() {
        return Configuration.getServerInfo();
    }
}
