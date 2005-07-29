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

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import org.apache.commons.jelly.TagSupport;
import org.apache.commons.jelly.XMLOutput;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.JellyTagException;
import org.apache.pluto.deploy.Deployer;
import org.apache.pluto.deploy.DeploymentConfig;
import org.apache.pluto.deploy.DeploymentException;

/**
 * Tag which is used to assemble portlet applications.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 27, 2004
 */
public class PlutoDeployTag extends TagSupport {

    public PlutoDeployTag() {
    }

    public void doTag(XMLOutput xmlOutput) throws MissingAttributeException,
                                                  JellyTagException {
        try {
            String deployerName =
                (String)context.getVariable("org.apache.pluto.deploy.Deployer");

            String dir  = (String)context.getVariable("maven.build.dir");
            String name = (String)context.getVariable("maven.pluto.final.name");

            File file = new File(dir, name+".war");
            FileInputStream in = new FileInputStream(file);
            DeploymentConfig config = new MavenDeploymentConfig(name, context);

            Class cl = Class.forName(deployerName);
            Deployer deployer = (Deployer)cl.newInstance();
            deployer.deploy(config, in);
        }
        catch(IOException io) {
            throw new JellyTagException(io);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new JellyTagException("Error retrieving Deployer", e);
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new JellyTagException("Error Instantiating Deployer", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new JellyTagException("Error Finding Deployer", e);
        } catch (DeploymentException e) {
            e.printStackTrace();
            throw new JellyTagException("Error deploying application", e);
        } catch(RuntimeException t) {
            t.printStackTrace();
            throw t;
        }
    }


}

