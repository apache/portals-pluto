/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
package org.apache.pluto.ant;

import org.apache.tools.ant.Task;
import org.apache.tools.ant.BuildException;
import org.apache.pluto.util.UtilityException;
import org.apache.pluto.util.publish.PortletPublishConfig;
import org.apache.pluto.util.publish.PortletPublishServiceFactory;
import org.apache.pluto.util.publish.PortletPublishService;

/**
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Nov 23, 2005
 */
public class PublishTask extends Task {

    private String host;

    private int port;

    private String portalContext;

    private String username;

    private String password;

    private String portletApplicationContext;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPortalContext() {
        return portalContext;
    }

    public void setPortalContext(String portalContext) {
        this.portalContext = portalContext;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPortletApplicationContext() {
        return portletApplicationContext;
    }

    public void setPortletApplicationContext(String portletApplicationContext) {
        this.portletApplicationContext = portletApplicationContext;
    }

    public void execute() throws BuildException {

        validateArgs();

        try {
            PortletPublishConfig config = new PortletPublishConfig();
            config.setHost(getHost());
            config.setPort(getPort());
            config.setContext(getPortalContext());
            config.setUsername(getUsername());
            config.setPassword(getPassword());
            config.setPortletApplicationContext(getPortletApplicationContext());

            PortletPublishService publisher = PortletPublishServiceFactory.getFactory()
                .createPortletPublishService(config);
            publisher.publish(config);
        }
        catch(UtilityException ue) {
            throw new BuildException(ue);
        }
    }

    private void validateArgs() throws BuildException {

    }
}
