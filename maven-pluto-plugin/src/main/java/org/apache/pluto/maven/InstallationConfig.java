package org.apache.pluto.maven;

import java.util.List;
import java.util.Map;
import java.io.File;

/**
 *
 */
public class InstallationConfig {

    /**
     * A list of depdencies that are shared amoungst web applications.
     */
    private List sharedDependencies;

    /**
     * A list of dependencies are are shared amoungst web applications.
     */
    private List endorsedDependencies;

    /**
     * A list of war files which are to be considered portal dependencies.
     */
    private Map portletApplications;

    /**
     * The location of the portal application being installed.
     */
    private File portalApplication;

    /**
     * The installation directory.
     */
    private File installationDirectory;

    private String portalContextPath;

    private ServerConfig serverConfig;


    public List getSharedDependencies() {
        return sharedDependencies;
    }

    public void setSharedDependencies(List sharedDependencies) {
        this.sharedDependencies = sharedDependencies;
    }

    public List getEndorsedDependencies() {
        return endorsedDependencies;
    }

    public void setEndorsedDependencies(List endorsedDependencies) {
        this.endorsedDependencies = endorsedDependencies;
    }

    public Map getPortletApplications() {
        return portletApplications;
    }

    public void setPortletApplications(Map portletApplications) {
        this.portletApplications = portletApplications;
    }

    public File getPortalApplication() {
        return portalApplication;
    }

    public void setPortalApplication(File portalApplication) {
        this.portalApplication = portalApplication;
    }

    public File getInstallationDirectory() {
        return installationDirectory;
    }

    public void setInstallationDirectory(File installationDirectory) {
        this.installationDirectory = installationDirectory;
    }

    public String getPortalContextPath() {
        return portalContextPath;
    }

    public void setPortalContextPath(String portalContextPath) {
        this.portalContextPath = portalContextPath;
    }

    public ServerConfig getServerConfig() {
        return serverConfig;
    }

    public void setServerConfig(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }

}
