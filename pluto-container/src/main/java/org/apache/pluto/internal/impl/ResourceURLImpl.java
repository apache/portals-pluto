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
package org.apache.pluto.internal.impl;

import javax.portlet.ResourceURL;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.internal.InternalPortletWindow;

/**
 * Implementation of JSR-286 <code>ResourceURL</code>.
 *
 * @since 2.0
 */
public class ResourceURLImpl extends BaseURLImpl implements ResourceURL {
	public ResourceURLImpl(PortletContainer container,
	        InternalPortletWindow internalPortletWindow,
	        javax.servlet.http.HttpServletRequest servletRequest,
	        javax.servlet.http.HttpServletResponse servletResponse) {
			super(container,internalPortletWindow,servletRequest,
				servletResponse,false,true);
	}

	public void setResourceID(String resourceID) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}
}
