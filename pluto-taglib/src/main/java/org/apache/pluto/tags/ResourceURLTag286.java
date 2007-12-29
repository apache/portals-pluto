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


import javax.portlet.BaseURL;
import javax.portlet.PortletResponse;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.servlet.jsp.JspException;


/**
 * A tag handler for the <CODE>resourceURL</CODE> tag as defined in the JSR 286.
 * Creates a url that points to the current Portlet and triggers a 
 * resource request with the supplied parameters.
 * 
 * @version 2.0
 */

public class ResourceURLTag286 extends BaseURLTag {
	
	private static final long serialVersionUID = 286L;	
	
	private String id = null;
	
	private String cachability = null;
	
	private ResourceURL resourceURL = null;
	

	public ResourceURLTag286() {
		super();
		this.escapeXml = true;
	}
	

	/* (non-Javadoc)
	 * @see org.apache.pluto.tags.BaseURLTag#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		       
        PortletResponse portletResponse = (PortletResponse) pageContext.getRequest()
            .getAttribute(Constants.PORTLET_RESPONSE);
        
        if (portletResponse != null) {
        	
        	ResourceURL resourceURL = createResourceURL(portletResponse);
                 
            if(id != null){
            	resourceURL.setResourceID(id);
            }

            if(cachability != null){
            	try{
            		resourceURL.setCacheability(cachability);
            	}
            	catch(IllegalArgumentException e){
            		throw new JspException(e);
            	}
            	catch(IllegalStateException e){
            		throw new JspException(e);
            	}
            }
            
            setUrl(resourceURL);
        }
        
        return super.doStartTag();
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
	

    /* (non-Javadoc)
     * @see org.apache.pluto.tags.BaseURLTag#getUrl()
     */
    @Override
    protected ResourceURL getUrl() {
        return resourceURL;
    }
	
   
    /* (non-Javadoc)
     * @see org.apache.pluto.tags.BaseURLTag#setUrl(javax.portlet.BaseURL)
     */
    @Override
    protected void setUrl(BaseURL url) {
        this.resourceURL = (ResourceURL)url;
    }
	
    
	/**
	 * Creates a resourceURL.
	 * 
	 * @param portletResponse
	 * @return a resourceURL
	 * @throws JspException
	 */
	protected ResourceURL createResourceURL(PortletResponse portletResponse) throws JspException{
		ResourceURL result = null;
		if(portletResponse instanceof RenderResponse){
    		result = ((RenderResponse)portletResponse).createResourceURL();	
    	}
    	else if(portletResponse instanceof ResourceResponse){
    		result = ((ResourceResponse)portletResponse).createResourceURL();
    	}	
    	else{
    		throw new JspException();
    	}
		return result;
	}
}
