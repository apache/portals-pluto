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
package org.apache.pluto.internal.impl;

import java.util.Locale;

import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.internal.InternalResourceResponse;
import org.apache.pluto.util.ArgumentUtility;
import org.apache.pluto.util.StringUtils;

public class ResourceResponseImpl extends MimeResponseImpl
implements ResourceResponse, InternalResourceResponse {
	

    public ResourceResponseImpl(PortletContainer container,
                              InternalPortletWindow internalPortletWindow,
                              HttpServletRequest servletRequest,
                              HttpServletResponse servletResponse) {
        super(container, internalPortletWindow, servletRequest,
              servletResponse);
    }
	
	@Override
	public void setCharacterEncoding(String arg0) {
		if (super.isIncluded()){
			//no operation
		}
		else
			super.setCharacterEncoding(arg0);
	}

	@Override
	public void setContentLength(int arg0) {
		if (super.isIncluded()){
			//no operation
		}
		else
			super.setContentLength(arg0);
	}

	@Override
	public void setLocale(Locale arg0) {
		if (super.isIncluded()){
			//no operation
		}
		else
			super.setLocale(arg0);
	}
	
	@Override
	public int getBufferSize() {
		if (super.isForwarded() || super.isIncluded()){
			return 0;
		}
		else
			return getHttpServletResponse().getBufferSize();
	}
	
	@Override
    public void setContentType(String contentType)
    		throws IllegalArgumentException {
    	
    	if (super.isIncluded()){
    		//no operation
    	}
    	else{
    		ArgumentUtility.validateNotNull("contentType", contentType);
            String mimeType = StringUtils.getMimeTypeWithoutEncoding(contentType);
            if (!isValidContentType(mimeType)) {
                throw new IllegalArgumentException("Specified content type '"
                		+ mimeType + "' is not supported.");
            }
            getHttpServletResponse().setContentType(mimeType);
    	}
    }
	
	@Override
	public String getContentType() {
        return getHttpServletResponse().getContentType();
    }

	public String getCacheability() {
		// TODO Auto-generated method stub
		return null;
	}	
}
