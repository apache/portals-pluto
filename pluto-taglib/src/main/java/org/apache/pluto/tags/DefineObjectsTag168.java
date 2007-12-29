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

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.VariableInfo;

/**
 * A tag handler for the <CODE>defineObjects</CODE> tag as defined in the JSR 168.
 * Creates the following variables to be used in the JSP: 
 * <UL> 
 * <LI><CODE>{@link RenderRequest} renderRequest</CODE>
 * <LI><CODE>{@link RenderResponse} renderResponse</CODE> 
 * <LI><CODE>{@link PortletConfig} portletConfig</CODE>
 * </UL>
 * 
 * @version 2.0
 */
public class DefineObjectsTag168 extends TagSupport {
	
	private static final long serialVersionUID = 286L;

	/**
	 * Helper method.
	 * <p>
     * Sets an pageContext attribute with <CODE>PAGE_SCOPE</CODE>.
     * 
     * @param attribute - the attribute object to set
     * @param attributeName - the name of the attribute object
     * 
     * @return void
     */
	private void setAttribute(Object attribute, String attributeName){
		if (pageContext.getAttribute(attributeName) == null){   //Set attributes only once
 
            pageContext.setAttribute(attributeName,
            						 attribute,
                                     PageContext.PAGE_SCOPE);
        }
	}
	  
     
	/**
     * Processes the <CODE>defineObjects</CODE> tag.
     * @return <CODE>SKIP_BODY</CODE>
     */
    public int doStartTag() throws JspException {
    	
    	ServletRequest servletRequest = pageContext.getRequest();
    	
    	PortletRequest portletRequest = 
    		(PortletRequest) servletRequest.getAttribute(Constants.PORTLET_REQUEST);
    	
    	PortletResponse portletResponse = 
    		(PortletResponse) servletRequest.getAttribute(Constants.PORTLET_RESPONSE);
    	
    	PortletConfig portletConfig = 
    		(PortletConfig) servletRequest.getAttribute(Constants.PORTLET_CONFIG);
    	
    	// set attribute renderRequest
    	setAttribute(portletRequest, "renderRequest");
    	
    	// set attribute renderResponse
    	setAttribute(portletResponse, "renderResponse");
    	
    	// set attribute portletConfig
    	setAttribute(portletConfig, "portletConfig");   	
    	
        return SKIP_BODY;
    }

    
    
    /**
     * TagExtraInfo class for DefineObjectsTag.
     *
     */
    public static class TEI extends TagExtraInfo {

        public VariableInfo[] getVariableInfo(TagData tagData) {
            VariableInfo[] info = new VariableInfo[]{
            	new VariableInfo("renderRequest",
            					 "javax.portlet.RenderRequest",
            					 true,
            					 VariableInfo.AT_BEGIN),
                new VariableInfo("renderResponse",
                   				 "javax.portlet.RenderResponse",
                   				 true,
                  				 VariableInfo.AT_BEGIN),                            
                new VariableInfo("portletConfig",
                                 "javax.portlet.PortletConfig",
                                 true,
                                 VariableInfo.AT_BEGIN)                                              
            };
            return info;
        }
    }
}

