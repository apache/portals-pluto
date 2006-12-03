/*
 * Copyright 2006 The Apache Software Foundation.
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
package org.apache.pluto.util.fileupload.http;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.pluto.util.fileupload.FileUploaderConfig;
import org.apache.pluto.util.fileupload.FileUploader;
import org.apache.pluto.util.fileupload.FileUploaderException;

public class PortletFileUploader implements FileUploader {

	public static final Log LOG = LogFactory.getLog(PortletFileUploader.class); 
	
	public File upload(ActionRequest request, FileUploaderConfig config) throws FileUploaderException {
		// Check that we have a file upload request
		if (!PortletFileUpload.isMultipartContent(request)) {
			//TODO: Return an error message or and exception
			//	that results in an error message
			String msg = "No file upload content";
			throw new FileUploaderException(msg);
		}
		//Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();
	
		//Create a new file upload handler
		PortletFileUpload upload = new PortletFileUpload(factory);
	
		//Set overall request size constraint
		upload.setSizeMax(config.getMaxUploadSize());
	    String fileName = null;
	    File tmpUploadDir = config.getUploadPath();
	    //create the uploading directory if it does not exist
	    if (!tmpUploadDir.exists()){
	    	tmpUploadDir.mkdirs();
	    }
	    
	    InputStream uploadedStream = null;
		File uploadedFile = null;
	    
		try {
			//Parse the request
			List /* FileItem */ items = upload.parseRequest(request);
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				//Process the file upload, not a form field
				if (!item.isFormField()) {
				    fileName = item.getName();
				    LOG.debug("File name: " + fileName);	
				    String contentType = item.getContentType();
				    boolean isInMemory = item.isInMemory();
				    long sizeInBytes = item.getSize();
				    uploadedFile = new File(tmpUploadDir, fileName);
				    LOG.debug("Uploaded file: " + uploadedFile);
				    //The write() method should only be used for small files
				    item.write(uploadedFile);
				    //TODO: Use streams to handle large files
	//			    uploadedStream = item.getInputStream();
	//			    FileOutputStream os = new FileOutputStream(uploadedFile);
				    
				}	
				
			}
		} catch (org.apache.commons.fileupload.FileUploadException e) {
			String msg = "File upload problem: " + e.getMessage(); 
			LOG.error(msg, e);
			throw new FileUploaderException(msg, e);
		} catch (Exception e) {
			String msg = "File upload problem: " + e.getMessage(); 
			LOG.error(msg, e);
			throw new FileUploaderException(msg, e);
		} finally {
			if (uploadedStream != null) {
				try {
					uploadedStream.close();
				} catch (IOException e) {
					String msg = "File upload problem: " + e.getMessage();
					LOG.warn(msg, e);
					throw new FileUploaderException(msg, e);
				}
			}
		}
		
		if (LOG.isDebugEnabled()) {
			StringBuffer sb = new StringBuffer("File uploaded ");
			if (fileName != null) {
				sb.append(fileName);			
			}
			sb.append(" to directory " + config.getUploadPath());
			String msg = sb.toString();		
			LOG.debug("Message: " + msg);				
		}

		return uploadedFile;		
	}

	/**
	 * Gets the file name minus the extension from a file.
	 * @param pathName
	 * @return
	 */
	  private String getRootFilename(String pathName) {
		    int endFilenameIndex = pathName.lastIndexOf('.');
		    String filename =  pathName.substring(0, endFilenameIndex);
		    return filename;
	  }
	
}
