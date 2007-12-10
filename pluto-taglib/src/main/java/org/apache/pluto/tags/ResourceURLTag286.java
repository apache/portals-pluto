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
package org.apache.pluto.tags;


import java.io.IOException;

import javax.portlet.PortletResponse;
import javax.portlet.PortletSecurityException;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;


/**
 * A tag handler for the <CODE>resourceURL</CODE> tag as defined in the JSR 286.
 * Creates a url that points to the current Portlet and triggers a 
 * resource request with the supplied parameters.
 * 
 * @version 2.0
 */

public class ResourceURLTag286 extends BaseURLTag {
	
	private static final long serialVersionUID = 286L;

	private ResourceURL url = null;
	
	private String id = null;
	private String cachability = null;
	

	public ResourceURLTag286() {
		super();
		this.escapeXml = true;
	}
	

	/* (non-Javadoc)
	 * @see org.apache.pluto.tags.BaseURLTag#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		
        if (var != null) {
            pageContext.removeAttribute(var, PageContext.PAGE_SCOPE);
        }
        
        PortletResponse portletResponse = (PortletResponse) pageContext.getRequest()
            .getAttribute(Constants.PORTLET_RESPONSE);

        if (portletResponse != null) {
        	if(portletResponse instanceof RenderResponse){
        		url = ((RenderResponse)portletResponse).createResourceURL();	
        	}
        	else if(portletResponse instanceof ResourceResponse){
        		url = ((ResourceResponse)portletResponse).createResourceURL();
        	}
        	else{
        		throw new JspException();
        	}
            
            if (secure != null) {
                try {                	
                    url.setSecure(getSecureBoolean());                    
                } catch (PortletSecurityException e) {                	
                    throw new JspException(e);                    
                }
            }
        }
        
    	if(id != null){
			url.setResourceID(id);
		}
		
		if(cachability != null){
			try{
				url.setCacheability(cachability);
			}
			catch(IllegalArgumentException e){
				throw new JspException(e);
			}
			catch(IllegalStateException e){
				throw new JspException(e);
			}
		}
        
        return EVAL_BODY_INCLUDE;
    }
	

	/* (non-Javadoc)
	 * @see org.apache.pluto.tags.BaseURLTag#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException{
		
		setUrlParameters(url);
		setUrlProperties(url);
		
		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
		
		String urlString = response.encodeURL(url.toString());
        //properly encoding urls to allow non-cookie enabled sessions - PLUTO-252 
		
		if(escapeXml){			
			urlString = doEscapeXml(urlString);
		}
		
	    if (var == null) {
            try {
                JspWriter writer = pageContext.getOut();
                writer.print(urlString);                
            } catch (IOException ioe) {            	
                throw new JspException(
                   "resourceURL Tag Exception: cannot write to the output writer.");
            }
            
        } 
	    else {        	
            pageContext.setAttribute(var, urlString,
                                     PageContext.PAGE_SCOPE);
        }
	    
	    /*cleanup*/
	    propertiesMap.clear();
	    parametersMap.clear();
	    
        return EVAL_PAGE;
	}
	
    /**
     * Gets the url property.
     * @return BaseURL
     */
    public ResourceURL getUrl() {
        return url;
    }
	
    /**
     * Sets the url porperty.
     * @param url BaseUrl - The url to set.
     * @return void
     */
    public void setUrl(ResourceURL url) {
        this.url = url;
    }
    
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the cachability
	 */
	public String getCachability() {
		return cachability;
	}


	/**
	 * @param cachability the cachability to set
	 */
	public void setCachability(String cachability) {
		this.cachability = cachability;
	}
}
