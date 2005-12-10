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
package org.apache.pluto.util.assemble;

import org.apache.pluto.util.install.ServerConfig;

import java.util.List;
import java.util.Map;
import java.io.File;

/**
 *
 */
public class AssemblerConfig {

    private File portletDescriptor;

    private File webappDescriptor;

    private File destination;

    public File getPortletDescriptor() {
        return portletDescriptor;
    }

    public void setPortletDescriptor(File portletDescriptor) {
        this.portletDescriptor = portletDescriptor;
    }

    public File getWebappDescriptor() {
        return webappDescriptor;
    }

    public void setWebappDescriptor(File webappDescriptor) {
        this.webappDescriptor = webappDescriptor;
    }

    public File getDestination() {
        return destination;
    }

    public void setDestination(File destination) {
        this.destination = destination;
        this.destination.getParentFile().mkdirs();
    }
}
