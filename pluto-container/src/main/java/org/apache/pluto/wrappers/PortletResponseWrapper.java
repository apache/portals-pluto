/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
package org.apache.pluto.wrappers;

import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.ResourceURL;
import javax.servlet.http.Cookie;

import org.w3c.dom.Element;

public class PortletResponseWrapper
    extends javax.servlet.http.HttpServletResponseWrapper
    implements PortletResponse {

    /**
     * Creates a ServletResponse adaptor wrapping the given response object.
     * @throws java.lang.IllegalArgumentException
     *          if the response is null.
     */
    public PortletResponseWrapper(PortletResponse portletResponse) {
        super((javax.servlet.http.HttpServletResponse) portletResponse);

        if (portletResponse == null) {
            throw new IllegalArgumentException("Response cannot be null");
        }
    }

    // javax.portlet.PortletResponse implementation ------------------------------------------------
    public void addProperty(String key, String value) {
        this.getPortletResponse().addProperty(key, value);
    }
    
    public void addProperty(Cookie cookie){
    	this.getPortletResponse().addProperty(cookie);
    }

    public void setProperty(String key, String value) {
        this.getPortletResponse().setProperty(key, value);
    }

    public String encodeURL(String path) {
        return this.getPortletResponse().encodeURL(path);
    }
    
    // FIXME: can we delete this function?
//    public void addProperty(String arg0, String arg1, int arg2) {
//		this.getPortletResponse().addProperty(arg0, arg1, arg2);
//	}

	public PortletURL createActionURL() {
		return this.getPortletResponse().createActionURL();
	}

	public PortletURL createRenderURL() {
		return this.getPortletResponse().createRenderURL();
	}

	public ResourceURL createResourceURL() {
		return this.getPortletResponse().createResourceURL(); 
	}

	public String getNamespace() {
		return this.getPortletResponse().getNamespace();
	}
	
    // --------------------------------------------------------------------------------------------

    // additional methods -------------------------------------------------------------------------
    /**
     * Return the wrapped ServletResponse object.
     */
    public PortletResponse getPortletResponse() {
        return (PortletResponse) super.getResponse();
    }

    /**
     * Sets the response being wrapped.
     * @throws java.lang.IllegalArgumentException
     *          if the response is null.
     */
    public void setResponse(PortletResponse response) {
        if (response == null) {
            throw new IllegalArgumentException("Response cannot be null");
        }
        setResponse((javax.servlet.http.HttpServletResponse) response);
    }

	public void addProperty(String key, Element element) {
		this.getPortletResponse().addProperty(key, element);
	}
}

