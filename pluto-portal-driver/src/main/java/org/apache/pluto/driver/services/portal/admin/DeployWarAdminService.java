package org.apache.pluto.driver.services.portal.admin;

import java.io.File;

import org.apache.pluto.util.deploy.DeploymentException;

public interface DeployWarAdminService {

	public void deployWar(File war, boolean configure) throws DeploymentException;

}
