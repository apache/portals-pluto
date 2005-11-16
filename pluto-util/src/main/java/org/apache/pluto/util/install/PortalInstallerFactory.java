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
package org.apache.pluto.util.install;

import org.apache.pluto.util.install.impl.Tomcat5FileSystemInstaller;
import org.apache.pluto.util.install.impl.Jetty5FileSystemInstaller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 *
 */
public abstract class PortalInstallerFactory {

    private static final ArrayList HANDLERS = new ArrayList();

    static {
        HANDLERS.add(new Tomcat5FileSystemInstaller());
        HANDLERS.add(new Jetty5FileSystemInstaller());
    }

    public static PortalInstaller getAppServerHandler(File installDir) {
        String className = System.getProperty(PortalInstallerFactory.class.getName());
        PortalInstaller ash;
        if(className != null)
            return getHandler(className, installDir);
        else
            return findHandler(installDir);
    }

    private static PortalInstaller getHandler(String className, File installDir) {
        PortalInstaller ash;
        try {
            Class cl = Class.forName(className);
            ash = (PortalInstaller)cl.newInstance();
            if(ash.isValidInstallationDirectory(installDir)) {
                return ash;
            }
            else {
                throw new Exception("Invalid installation directory for handler: "+className);
            }
       }
        catch(Exception e) {
            throw new RuntimeException("Unable to instantiate class: "+className, e);
        }
    }

    private static PortalInstaller findHandler(File installDir) {
        Iterator it = HANDLERS.iterator();
        while(it.hasNext()) {
            PortalInstaller ash = (PortalInstaller)it.next();
            if(ash.isValidInstallationDirectory(installDir)) {
                return ash;
            }
        }
        throw new RuntimeException("Unable to locate appropriate app server handler for: "+installDir.getAbsolutePath());
    }

}
