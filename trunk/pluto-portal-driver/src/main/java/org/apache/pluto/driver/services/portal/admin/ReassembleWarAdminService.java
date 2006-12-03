package org.apache.pluto.driver.services.portal.admin;

import java.io.File;

import org.apache.pluto.util.UtilityException;


public interface ReassembleWarAdminService {
	/**
	 * 
	 * @param warFilePath War file to reassemble
	 * @return Reference to new war file
	 * @throws UtilityException
	 */
	public File reassembleWar(File warFilePath) throws UtilityException ;
}
