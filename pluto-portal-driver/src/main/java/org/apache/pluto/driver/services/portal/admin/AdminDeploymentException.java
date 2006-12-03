package org.apache.pluto.driver.services.portal.admin;

import org.apache.pluto.driver.portlets.AdminDeploymentPortlet;

/**
 * Indicates a problem with deployment using the admin
 * deployment portlet.
 *
 * @author <a href="cdoremus@apache.org">Craig Doremus</a>
 * @see AdminDeploymentPortlet
 *
 */
public class AdminDeploymentException extends Exception {

	public AdminDeploymentException(String msg) {
		super(msg);
	}

	public AdminDeploymentException(Throwable e) {
		super(e);
	}

	public AdminDeploymentException(String msg, Throwable e) {
		super(msg, e);
	}

}
