/*
 * Copyright 2004 The Apache Software Foundation.
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
package org.apache.pluto.spi.optional;

import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.internal.InternalPortletRequest;
import org.apache.pluto.internal.InternalPortletResponse;
import org.apache.pluto.internal.InternalActionResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Factory Service for creating Portlet request and responses.
 * <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public interface PortletEnvironmentService {
	
	public InternalPortletRequest createActionRequest(
			HttpServletRequest servletRequest,
			HttpServletResponse servletResponse,
			InternalPortletWindow internalPortletWindow);
	
	public InternalActionResponse createActionRespose(
			HttpServletRequest servletRequest,
			HttpServletResponse servletResponse,
			InternalPortletWindow internalPortletWindow);
	
	public InternalPortletRequest createRenderRequest(
			HttpServletRequest servletRequest,
			HttpServletResponse servletResponse,
			InternalPortletWindow internalPortletWindow);
	
	public InternalPortletResponse createRenderRespose(
			HttpServletRequest servletRequest,
			HttpServletResponse servletResponse,
			InternalPortletWindow internalPortletWindow);
	
}
