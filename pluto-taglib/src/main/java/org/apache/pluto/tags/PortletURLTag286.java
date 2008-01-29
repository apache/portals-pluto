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

import java.util.Map;
import java.util.Set;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.servlet.jsp.JspException;

/**
 * Abstract supporting class for the JSR 286 actionURL 
 * and renderURL tag handlers.
 * 
 * @version 2.0
 */

public abstract class PortletURLTag286 extends PortletURLTag168 {
	
	
	protected Boolean copyCurrentRenderParameters = false;
	
	
	public PortletURLTag286() {
		super();
		this.escapeXml = true;
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
        			if (result[0].equals(true))
        				escapeXml = true;
        			else if (result[0].equals(false))
        				escapeXml = false;
        		}
        	}
        }
        
        return super.doStartTag();
    }
	
    
	/* (non-Javadoc)
	 * @see org.apache.pluto.tags.BaseURLTag#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException{
				
		if(copyCurrentRenderParameters){
			/*prepend current render parameters*/
			doCopyCurrentRenderParameters();
		}
	    
        return super.doEndTag();
	}
	
        
    /**
     * Returns the copyCurrentRenderParameters property.
     * @return Boolean
     */
    public Boolean getCopyCurrentRenderParameters() {
        return copyCurrentRenderParameters;
    }
         
        
    /**
     * Sets copyCurrentRenderParameters property.
     * @param copyCurrentRenderParameters
     * @return void
     */
    public void setCopyCurrentRenderParameters(Boolean copyCurrentRenderParameters) {
        this.copyCurrentRenderParameters = copyCurrentRenderParameters;
    }
        
    	
	/**
     * Copies the current render parameters to the parameter map.
     * @return void
     */
    protected void doCopyCurrentRenderParameters(){
    	PortletRequest request = 
    		(PortletRequest) pageContext.getRequest().
    		getAttribute(Constants.PORTLET_REQUEST);
		
    	if(request != null){    		
			Map<String,String[]> renderParamsMap =
				request.getPrivateParameterMap();
			
			Set<String> keySet = renderParamsMap.keySet();
			
			for(String key : keySet){
									
				if(!removedParametersList.contains(key)){

					String[] values = renderParamsMap.get(key);

					for(int index = 0; index < values.length; ++index){
						addParameter(key, values[index]);				
					}
				}
			}
		}
    }
    
}
