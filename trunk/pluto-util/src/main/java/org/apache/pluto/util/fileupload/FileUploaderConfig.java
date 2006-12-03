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
package org.apache.pluto.util.fileupload;

import java.io.File;

/**
 * 
 *
 * @author <a href="cdoremus@apache.org">Craig Doremus</a>
 *
 */
public class FileUploaderConfig {

	private File uploadPath = null;
	private int maxUploadSize = 10;
	
	public FileUploaderConfig() {
		super();
	}
	
	/**
	 * @return the uploadDirectory
	 */
	public File getUploadPath() {
		return uploadPath;
	}

	/**
	 * @param uploadDirectory the uploadDirectory to set
	 */
	public void setUploadPath(File uploadPath) {
		this.uploadPath = uploadPath;
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
}
