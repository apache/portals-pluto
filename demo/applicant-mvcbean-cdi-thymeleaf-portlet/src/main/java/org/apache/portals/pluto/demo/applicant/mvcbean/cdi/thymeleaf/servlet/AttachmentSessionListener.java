/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.portals.pluto.demo.applicant.mvcbean.cdi.thymeleaf.servlet;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author  Neil Griffin
 */
@WebListener
public class AttachmentSessionListener implements HttpSessionListener {

	private static final Logger logger = LoggerFactory.getLogger(AttachmentSessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

		HttpSession httpSession = httpSessionEvent.getSession();
		ServletContext servletContext = httpSession.getServletContext();
		File tempDir = (File) servletContext.getAttribute(ServletContext.TEMPDIR);

		File attachmentDir = new File(tempDir, httpSession.getId());

		if (attachmentDir.exists()) {

			File[] files = attachmentDir.listFiles();

			for (File file : files) {

				file.delete();

				logger.debug("Deleted file: " + file.getAbsolutePath());
			}
		}
	}
}
