package org.apache.pluto.driver.services.portal.admin;

import java.io.File;

import javax.portlet.ActionRequest;

import org.apache.pluto.util.fileupload.FileUploaderException;

public interface WarUploadAdminService {

	/**
	 * Processes an uploaded file and puts it on the file system in a temporary
	 * directory (<code>AdminPortletConfig.getInstance().getTempUploadDir()</code>.
	 * 
	 * @param req ActionRequest
	 * @return The uploaded file name.
	 * @throws AdminPortletException If there is no upload file. This is a RuntimeException that 
	 * wraps a FileUploaderException, IOException and any other Exception thrown during the processing 
	 * of the uploaded file.
	 */
	public File uploadWar(ActionRequest req) throws FileUploaderException;	
	
	/**
	 * Change the max upload size via a session variable set in the edit mode or configured using Spring.
	 * 
	 * @param maxUploadSize
	 */
	public void setMaxUploadSize(int maxUploadSize);

}
