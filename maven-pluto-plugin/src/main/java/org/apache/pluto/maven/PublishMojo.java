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
package org.apache.pluto.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.pluto.util.publish.PortletPublishConfig;
import org.apache.pluto.util.publish.PortletPublishServiceFactory;
import org.apache.pluto.util.publish.PortletPublishService;
import org.apache.pluto.util.UtilityException;

/**
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Dec 5, 2005
 *
 * @goal publish
 * @requiresDependencyResolution runtime
 */
public class PublishMojo extends AbstractMojo {

    /**
     * @parameter expression="${host}"
     */
    protected String host = "localhost";

    /**
     * @parameter expression="${port}"
     */
    protected int port = 8080;

    /**
     * @parameter  expression="${protocol}"
     */
    protected String protocol = "http";

    /**
     * @parameter expression="${portalContext}"
     */
    protected String portalContextPath = "pluto";

    /**
     * @parameter expression="${username}"
     */
    protected String username = "pluto";

    /**
     * @parameter expression="${password}"
     */
    protected String password = "pluto";

    /**
     * @parameter expression="${maven.final.name}"
     */
    protected String portletApplicationContext;

    /**
     * @parameter expression="${project}"
     */
    protected MavenProject project;

    public void execute() throws MojoExecutionException, MojoFailureException {

        PortletPublishConfig config = new PortletPublishConfig();
        config.setHost(host);
        config.setPort(port);
        config.setProtocol(protocol);
        config.setUsername(username);
        config.setPassword(password);
        config.setContext(portalContextPath);
        config.setPortletApplicationContext(portletApplicationContext);

        PortletPublishService publisher =
            PortletPublishServiceFactory.getFactory().createPortletPublishService(config);

        try {
            publisher.publish(config);
        }
        catch(UtilityException ue) {
            throw new MojoExecutionException(ue.getMessage());
        }
    }
}
