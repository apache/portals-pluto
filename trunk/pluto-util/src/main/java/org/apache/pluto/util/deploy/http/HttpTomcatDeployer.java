package org.apache.pluto.util.deploy.http;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.util.deploy.Deployer;
import org.apache.pluto.util.deploy.DeploymentConfig;
import org.apache.pluto.util.deploy.DeploymentException;
import org.apache.pluto.util.deploy.HttpDeploymentConfig;
import org.apache.pluto.util.deploy.Undeployer;

/**
 * Handles deployment of war files using the Tomcat manger
 * application URL interface via commons-httpclient.
 *
 * @author <a href="cdoremus@apache.org">Craig Doremus</a>
 *
 */
public class HttpTomcatDeployer implements Deployer, Undeployer {
	private static final Log LOG = LogFactory.getLog(HttpDeploymentConfig.class);
	
	public void deploy(DeploymentConfig config, File webappFile)
			throws IOException, DeploymentException {

		GetMethod get = doDeployment(config, webappFile, "deploy");
        if(LOG.isDebugEnabled()) {
            LOG.debug("Deployment Response Status: "+get.getStatusLine().toString());
        }
        String response = get.getResponseBodyAsString();

        if(LOG.isDebugEnabled()) {
            LOG.debug("Deployment Details: \n"+response);
        }
	}

	
	public void undeploy(DeploymentConfig config, File webappFile) throws IOException, DeploymentException {
		GetMethod get = doDeployment(config, webappFile, "undeploy");
        if(LOG.isDebugEnabled()) {
            LOG.debug("Undeployment Response Status: "+get.getStatusLine().toString());
        }
        String response = get.getResponseBodyAsString();

        if(LOG.isDebugEnabled()) {
            LOG.debug("Undeployment Details: \n"+response);
        }
	}

	public GetMethod doDeployment(DeploymentConfig config, File webappFile, String deploymentType) throws DeploymentException {
        HttpClient hclient = new HttpClient();
        hclient.setHostConfiguration(getHostConfiguration(config));
        hclient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);

        StringBuffer sb = new StringBuffer();
        sb.append("/manager/")
          .append(deploymentType)
          .append("?path=")
          .append(URLEncoder.encode(webappFile.getAbsolutePath()));
        

        if(LOG.isDebugEnabled()) {
            LOG.debug("Request url: "+sb.toString());
        }

        GetMethod get = new GetMethod(sb.toString());

        try {
            hclient.executeMethod(get);

        }
        catch(HttpException e) {
            DeploymentException de = new DeploymentException("Unable to undeploy");
            de.initCause(e);
            throw de;
        }
        catch(IOException e) {
            DeploymentException de = new DeploymentException("Unable to undeploy");
            de.initCause(e);
            throw de;
        }
		
        return get;
	}
	
    private HostConfiguration getHostConfiguration(DeploymentConfig config) {
        HostConfiguration host = new HostConfiguration();
        if(LOG.isDebugEnabled()) {
        		LOG.debug("Host configuration: ");
        		LOG.debug("Host: " + config.getDeploymentProperty("tomcat.host"));
        		LOG.debug("Port: " + config.getDeploymentProperty("tomcat.port"));
        		LOG.debug("Protocol: " + config.getDeploymentProperty("tomcat.protocol"));
        }        
        host.setHost(config.getDeploymentProperty("tomcat.host"), 
        		Integer.parseInt(config.getDeploymentProperty("tomcat.port")), 
        		config.getDeploymentProperty("tomcat.protocol"));
        return host;
    }
}
