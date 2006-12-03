package org.apache.pluto.driver.services.portal.admin.impl;

import java.io.File;

import javax.portlet.ActionRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.driver.services.portal.admin.WarUploadAdminService;
import org.apache.pluto.util.fileupload.FileUploaderConfig;
import org.apache.pluto.util.fileupload.FileUploader;
import org.apache.pluto.util.fileupload.FileUploaderException;

/**
 * Uploads the war using a <code>FileUploader</code> utility.
 *
 * @author <a href="cdoremus@apache.org">Craig Doremus</a>
 * @see FileUploader
 */
public class WarUploadAdminServiceImpl implements WarUploadAdminService {

	public static final Log LOG = LogFactory.getLog(WarUploadAdminServiceImpl.class);
	/**
	 * Implementation of FileUploader utility used to upload
	 * file, which can be configured using Spring. 
	 */
	FileUploader fileUploader = null;//configure with Spring
	/**
	 * Directory to upload the war to, which should be configured
	 * by Spring. By default, it is a .pluto directory underneath
	 * the user's home directory.
	 */
	String uploadDir = System.getProperty("user.home") + "/pluto";
	/**
	 * Maximum size of file upload in megabytes, which should be configured
	 * by String. By default it is 10 megabytes.
	 */
	int maxUploadSize = 10;//configure with Spring
	
	public WarUploadAdminServiceImpl() {
		super();
	}
	
	/**
	 * Uploads the war using a FileUploader implementation.
	 * 
	 * @param request The portlet request
	 * @return Pointer to the uploaded file
	 */
	public File uploadWar(ActionRequest request) throws FileUploaderException {
		File uploadedFile = null;
		if (fileUploader == null) {
			throw new FileUploaderException("FileUploader is null. Please check Spring configuration.");
		}
		FileUploaderConfig config = new FileUploaderConfig();
		config.setMaxUploadSize(maxUploadSize * 1000000);
		File fUploadDir = new File(uploadDir);
		if (!fUploadDir.exists()) {
			fUploadDir.mkdir();
		}
		config.setUploadPath(fUploadDir);
		uploadedFile = fileUploader.upload(request,config);
		if (LOG.isDebugEnabled()) {
			LOG.debug("Uploaded file: " + uploadedFile.getAbsolutePath());
		}
		return uploadedFile;
	}
	
	/**
	 * @return the maxUploadSize
	 */
	public int getMaxUploadSize() {
		return maxUploadSize;
	}
	
	/**
	 * @param maxUploadSize the maxUploadSize to set
	 */
	public void setMaxUploadSize(int maxUploadSize) {
		this.maxUploadSize = maxUploadSize;
	}
	
	/**
	 * @return the uploadDir
	 */
	public String getUploadDir() {
		return uploadDir;
	}
	
	/**
	 * @param uploadDir the uploadDir to set
	 */
	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
	
	/**
	 * @return the fileUploader
	 */
	public FileUploader getFileUploader() {
		return fileUploader;
	}
	
	/**
	 * @param fileUploader the fileUploader to set
	 */
	public void setFileUploader(FileUploader fileUploader) {
		this.fileUploader = fileUploader;
	}
}
