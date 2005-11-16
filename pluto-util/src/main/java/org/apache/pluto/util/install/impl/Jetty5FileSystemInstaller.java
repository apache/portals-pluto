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
package org.apache.pluto.util.install.impl;

import org.apache.pluto.util.install.InstallationConfig;
import org.apache.pluto.util.install.impl.FileSystemInstaller;
import org.apache.pluto.util.ManagementException;
import org.codehaus.plexus.util.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map;

public class Jetty5FileSystemInstaller extends FileSystemInstaller {

    protected File getEndorsedDir(InstallationConfig config ) {
        File installationDirectory = config.getInstallationDirectory();
        return new File(installationDirectory, "ext");
    }

    protected File getSharedDir(InstallationConfig config) {
        File installationDirectory = config.getInstallationDirectory();
        return new File(installationDirectory, "ext");
    }

    protected File getWebAppDir(InstallationConfig config) {
        File installationDirectory = config.getInstallationDirectory();
        return new File(
            installationDirectory, config.getServerConfig().getDomain()
        );
    }

    protected File getConfigurationDir(InstallationConfig config) {
        File installationDirectory = config.getInstallationDirectory();
        String engine = "Catalina";
        String host   = config.getServerConfig().getHost();
        return new File(installationDirectory, "conf/"+engine+"/"+host);
    }

    public void uninstall(InstallationConfig config) {
    }

    public void deploy() {

    }

    public boolean isValidInstallationDirectory(File installDir) {
        File serverConfig = new File(installDir, "etc/jetty.xml");
        return serverConfig.exists();
    }

    /**
     * NOTE: Order is important.  If the server is running, we want to
     *       make sure that the correct order is preserved
     *
     * 1) Install endorsed dependencies
     * 2) Install shared dependencies
     * 4) Prep Time
     *    -- Create a domain directory for the portal
     *    -- Init the configs holder
     * 5) Install the Portlet Applications
     * 6) Install the Portal Application
     * 7) Finally, install the configs
     * @param config
     * @throws org.apache.pluto.util.ManagementException
     */
    public void install(InstallationConfig config) throws ManagementException {
        File endorsedDir = getEndorsedDir(config);
        File sharedDir = getSharedDir(config);
        File domainDir = getWebAppDir(config);
        domainDir.mkdirs();
        File contextConfigurationDirectory = getConfigurationDir(config);
        /*
        (config.getEndorsedDependencies(), endorsedDir);

        copyFilesToDirectory(config.getSharedDependencies(), sharedDir);

       Iterator it = config.getPortletApplications().values().iterator();
        while(it.hasNext()) {
            File portletApp = (File)it.next();
            FileUtils.copyFileToDirectory(portletApp, domainDir);
        }

       FileUtils.copyFileToDirectory(config.getPortalApplication(), domainDir);


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
        */
    }

    private String getPortalApplicationConfig(InstallationConfig config) {
        File domainDir = this.getWebAppDir(config);
        String war = domainDir.getAbsolutePath() + File.separatorChar +
                config.getPortalApplication().getName();
        String contextPath = config.getPortalContextPath();
        return getConfigContents(war, contextPath);
    }

    private String getPortletApplicationConfig(String contextPath, File file) {
        String war = file.getAbsolutePath();
        return getConfigContents(war, contextPath);
    }

    public void writeConfiguration(InstallationConfig config) {

    }

    private String getConfigContents(String war, String contextPath) {
        StringBuffer contents = new StringBuffer();
        contents.append("<Context ")
                .append("path=\"").append(contextPath).append("\" ")
                .append("docBase=\"").append(war).append("\" ")
                .append("crossContext=\"true\">").append("</Context>");
       return contents.toString();
    }
}
