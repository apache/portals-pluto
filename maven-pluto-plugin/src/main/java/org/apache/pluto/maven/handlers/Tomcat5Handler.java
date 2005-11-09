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
package org.apache.pluto.maven.handlers;

import org.apache.pluto.maven.AppServerHandler;
import org.apache.pluto.maven.InstallationConfig;
import org.codehaus.plexus.util.FileUtils;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Iterator;
import java.util.Map;

public class Tomcat5Handler implements AppServerHandler {

    private File endorsedDir;
    private File sharedDir;
    private File domainDir;
    private File contextConfigurationDirectory;

    private void init(InstallationConfig config) {
        File installationDirectory = config.getInstallationDirectory();

        endorsedDir = new File(installationDirectory, "common/endorsed");
        sharedDir = new File(installationDirectory, "shared/lib");
        domainDir = new File(
            installationDirectory, config.getServerConfig().getDomain()
        );

        domainDir.mkdirs();

        String engine = "Catalina";
        String host   = config.getServerConfig().getHost();
        contextConfigurationDirectory = new File(installationDirectory, "conf/"+engine+"/"+host);
    }


    public void install(InstallationConfig config) throws Exception {
        init(config);
        // NOTE: Order is important.  If the server is running, we want to
        //       make sure that the correct order is preserved

        // 1) Install endorsed dependencies
        copyFilesToDirectory(config.getEndorsedDependencies(), endorsedDir);

        // 2) Install shared dependencies
        copyFilesToDirectory(config.getSharedDependencies(), sharedDir);

        // 4) Prep Time
        //    -- Create a domain directory for the portal
        //    -- Init the configs holder

        // 5) Install the Portlet Applications
        Iterator it = config.getPortletApplications().values().iterator();
        while(it.hasNext()) {
            File portletApp = (File)it.next();
            FileUtils.copyFileToDirectory(portletApp, domainDir);
        }

        // 6) Install the Portal Application
       FileUtils.copyFileToDirectory(config.getPortalApplication(), domainDir);

        // 7) Finally, install the configs

        it = config.getPortletApplications().entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String context = entry.getKey().toString();
            File portletApp = (File)entry.getValue();

            File deployed = new File(domainDir, portletApp.getName());
            String contents = getPortletApplicationConfig(context, deployed);
            FileWriter out = new FileWriter(
                new File(contextConfigurationDirectory, context+".xml"));
            out.write(contents);
            out.flush();
            out.close();
        }

        File xmlFile =  new File(contextConfigurationDirectory, config.getPortalContextPath()+".xml");
        FileWriter out = new FileWriter(xmlFile);
        out.write(getPortalApplicationConfig(config));
        out.flush();
        out.close();
    }

    public void uninstall(InstallationConfig config) {
        init(config);
    }

    public void deploy() {

    }

    private void copyFilesToDirectory(List dependencies, File destination)
            throws IOException {
        Iterator it = dependencies.iterator();
        while(it.hasNext()) {
            File from = (File)it.next();
            FileUtils.copyFileToDirectory(from, destination);
        }
    }

    //====
    private String getPortalApplicationConfig(InstallationConfig config) {
        String war = domainDir.getAbsolutePath() + File.separatorChar +
                config.getPortalApplication().getName();

        String contextPath = config.getPortalContextPath();

        return getConfigContents(war, contextPath);
    }

    private String getPortletApplicationConfig(String contextPath, File file) {
        String war = file.getAbsolutePath();
        return getConfigContents(war, contextPath);
    }

    private String getConfigContents(String war, String contextPath) {
        StringBuffer contents = new StringBuffer();
        contents.append("<Context ")
                .append("path=\"").append(contextPath).append("\" ")
                .append("docBase=\"").append(war).append("\" ")
                .append("crossContext=\"true\">").append("</Context>");
        /*
        <Context path="/pluto" docBase="pluto-portal.war" crossContext="true">
        </Context>
        */
        return contents.toString();
    }
}
