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
 * <B>TODO</B>: Document
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 28, 2004
 */
public class DeployerFactory {

    private static DeployerFactory factory;

    public static DeployerFactory getFactory() {
        if(factory == null) {
            factory = new DeployerFactory();
        }
        return factory;
    }

    public Deployer createFactory() {
        String className = System.getProperty(
            "org.apache.pluto.deploy.Deployer",
            "org.apache.pluto.util.deploy.impl.FileSystemDeployer"
        );

        try {
            Class cl = Class.forName(className);
            return (Deployer)cl.newInstance();
        }
        catch(Throwable t) {
            t.printStackTrace();
            return null;
        }
    }

}

