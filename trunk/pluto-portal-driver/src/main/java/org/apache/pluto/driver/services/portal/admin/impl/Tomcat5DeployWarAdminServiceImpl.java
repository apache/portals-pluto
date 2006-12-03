package org.apache.pluto.driver.services.portal.admin.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.driver.services.portal.admin.DeployWarAdminService;
import org.apache.pluto.util.deploy.Deployer;
import org.apache.pluto.util.deploy.DeploymentException;
import org.apache.pluto.util.deploy.Undeployer;
import org.apache.pluto.util.deploy.file.Tomcat5FileSystemDeployer;
import org.apache.pluto.util.deploy.file.TomcatDeploymentConfig;
import org.apache.pluto.util.deploy.http.HttpTomcatDeployer;
import org.apache.pluto.util.install.file.TomcatCrossContextGenerator;

public class Tomcat5DeployWarAdminServiceImpl implements DeployWarAdminService {

	private static final Log LOG = LogFactory.getLog(TomcatDeploymentConfig.class);
	
	private Deployer deployer = null;//configure with Spring
	private Undeployer undeployer = null;//configure with Spring
	private String tomcatService = "Catalina";//configure with Spring
	private String host = "localhost";//configure with Spring
	private String port = "8080";//configure with Spring
	private String protocol = "http";//configure with Spring
	private String tomcatHome = System.getProperty("catalina.home");//configure with Spring

	
	public Tomcat5DeployWarAdminServiceImpl() {
		super();
	}
	/* (non-Javadoc)
	 * @see org.apache.pluto.driver.services.portal.admin.DeployWarAdminService#deployWar(java.io.File)
	 */
	public void deployWar(File war, boolean configure)  throws DeploymentException{
		String strWar = war.getAbsolutePath();
		if (LOG.isDebugEnabled()) {
			LOG.debug("New War to deploy:" + strWar);
		}
		String warName = strWar.substring(strWar.lastIndexOf(File.separator) +1);
		String deploymentName = warName.substring(0, warName.lastIndexOf('.'));
		// 
		TomcatDeploymentConfig config = new TomcatDeploymentConfig(deploymentName);
		//is the war configured already or is it a redeployment?
		config.setConfigured(configure);
		config.setDeploymentName(deploymentName);
		//Add other info for deployment
		config.addDeploymentProperty("tomcat.home", tomcatHome);
		config.addDeploymentProperty("tomcat.service", tomcatService);
		config.addDeploymentProperty("tomcat.host", host);
		config.addDeploymentProperty("tomcat.port", port);		
		config.addDeploymentProperty("tomcat.protocol", protocol);
				
		undeployer = new HttpTomcatDeployer();
		deployer = new Tomcat5FileSystemDeployer();
		
		
		try { 
			undeployer.undeploy(config, war);
			deployer.deploy(config, war);
		} catch (FileNotFoundException e) {
			DeploymentException de = new DeploymentException("War file cannot be found");
			de.initCause(e);
			throw de;
		} catch (IOException e) {
			DeploymentException de = new DeploymentException("Generic I/O issue with war file");
			de.initCause(e);
			throw de;
		} 
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getTomcatHome() {
		return tomcatHome;
	}
	public void setTomcatHome(String tomcatHome) {
		this.tomcatHome = tomcatHome;
	}
	public String getTomcatService() {
		return tomcatService;
	}
	public void setTomcatService(String tomcatService) {
		this.tomcatService = tomcatService;
	}
	public Deployer getDeployer() {
		return deployer;
	}
	public void setDeployer(Deployer deployer) {
		this.deployer = deployer;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public Undeployer getUndeployer() {
		return undeployer;
	}
	public void setUndeployer(Undeployer undeployer) {
		this.undeployer = undeployer;
	}
	

}
