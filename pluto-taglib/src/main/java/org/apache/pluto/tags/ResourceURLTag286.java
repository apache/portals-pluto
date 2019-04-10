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


import static javax.portlet.ResourceURL.FULL;
import static javax.portlet.ResourceURL.PAGE;
import static javax.portlet.ResourceURL.PORTLET;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.BaseURL;
import javax.portlet.PortletConfig;
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
	
	private String cacheability = null;
	private static final Map<String, String> cacheabilityMap = new HashMap<String, String>();
	static {
	   cacheabilityMap.put("FULL", FULL);
	   cacheabilityMap.put("PORTLET", PORTLET);
	   cacheabilityMap.put("PAGE", PAGE);
	}
	
	private ResourceURL resourceURL = null;
	

	public ResourceURLTag286() {
		super();
		setEscapeXml(Boolean.TRUE.toString());
	}
	

	/* (non-Javadoc)
	 * @see org.apache.pluto.tags.BaseURLTag#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {                
        
       PortletConfig portletConfig = 
           (PortletConfig) pageContext.getRequest().getAttribute(Constants.PORTLET_CONFIG);
       Map<String,String[]> containerRuntimeOptions = portletConfig.getContainerRuntimeOptions();
       if (containerRuntimeOptions != null){
           String[] result = containerRuntimeOptions.get(Constants.ESCAPE_XML_RUNTIME_OPTION);
           if (result != null){
               if (result.length > 0){
                   setEscapeXml(result[0]);
               }
           }
       }
		       
        PortletResponse portletResponse = (PortletResponse) pageContext.getRequest()
            .getAttribute(Constants.PORTLET_RESPONSE);
        
        if (portletResponse != null) {
        	
        	ResourceURL resourceURL = createResourceURL(portletResponse);
                 
            if(id != null){
            	resourceURL.setResourceID(id);
            }

            if(cacheability != null){
               List<String> caAttribs = new ArrayList<String>(cacheabilityMap.keySet()); 
               if (!caAttribs.contains(cacheability.toUpperCase())) {
                  StringBuilder txt = new StringBuilder(128);
                  txt.append("Invalid cacheability option: ").append(cacheability);
                  txt.append(", valid options: ").append(caAttribs.toString());
                  throw new JspException(txt.toString());
               }
            	try{
            		resourceURL.setCacheability(cacheabilityMap.get(cacheability));
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
	 * @return the cacheability
	 */
	public String getCacheability() {
		return cacheability;
	}


	/**
	 * @param cacheability the cacheability to set
	 * @throws JspException 
	 */
	public void setCacheability(String cacheability) throws JspException {
		this.cacheability = cacheability;
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
