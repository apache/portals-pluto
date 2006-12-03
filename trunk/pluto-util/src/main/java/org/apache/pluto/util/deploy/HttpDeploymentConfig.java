package org.apache.pluto.util.deploy;

import java.util.Properties;

/**
 * Holds configuration data for http deployments. 
 *
 * @author <a href="cdoremus@apache.org">Craig Doremus</a>
 *
 */
public class HttpDeploymentConfig {

    private String protocol = "http";

    private String host = "localhost";

    private int port = 8080;

	public HttpDeploymentConfig() {
		super();
	}
	
	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getProtocol() {
		return protocol;
	}

}
