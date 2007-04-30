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
package org.apache.pluto.tags;

import javax.portlet.*;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.VariableInfo;

/**
 * A tag handler for the <CODE>defineObjects</CODE> tag. Creates the
 * following variables to be used in the JSP: 
 * <UL> 
 * <LI><CODE>{@link RenderRequest} renderRequest</CODE>, when included from within the <CODE>render</CODE> method
 * <LI><CODE>{@link ResourceRequest} resourceRequest</CODE>, when included from within the <CODE>serveResource</CODE> method
 * <LI><CODE>{@link ActionRequest} actionRequest</CODE>, when included from within the <CODE>processAction</CODE> method
 * <LI><CODE>{@link EventRequest} eventRequest</CODE>, when included from within the <CODE>processEvent</CODE> method
 * <LI><CODE>{@link RenderResponse} renderResponse</CODE>, when included from within the <CODE>render</CODE> method 
 * <LI><CODE>{@link ResourceResponse} resourceResponse</CODE>, when included from within the <CODE>serveResource</CODE> method 
 * <LI><CODE>{@link ActionResponse} actionResponse</CODE>, when included from within the <CODE>processAction</CODE> method
 * <LI><CODE>{@link EventResponse} eventResponse</CODE>, when included from within the <CODE>processEvent</CODE> method
 * <LI><CODE>{@link PortletConfig} portletConfig</CODE>
 * <LI><CODE>{@link PortletSession} portletSession</CODE>
 * <LI><CODE>{@link PortletPreferences} portletPreferences</CODE> 
 * </UL>
 * 
 * @author <a href="mailto:olisp_jena@yahoo.de">Oliver Spindler</a> (since Nov 01, 2006)
 * @version 2.0
 */
public class DefineObjectsTag extends TagSupport {

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
	private void setAttribute(Object attribute, String attributeName)
	{
		if (pageContext.getAttribute(attributeName) == null)   //Set attributes only once
        {
            pageContext.setAttribute(attributeName,
            						 attribute,
                                     PageContext.PAGE_SCOPE);
        }
	}
	
	/**
     * Helper method.
     * <p>
     * Sets render and request attribute with the names described in the 
     * JSR 286 - PLT 25.1 (defineObjects Tag).
     * @param request PortletRequest
     * @param response PortletResponse
     * @return void
     */
    private void setReqRes(PortletRequest request,PortletResponse response )
    {
    	//check where request and response where included from
    	if(request instanceof RenderRequest)
    	{
    		setAttribute(request,"renderRequest");
    		setAttribute(response,"renderResponse");
    	}
    	
    	else if(request instanceof ResourceRequest)
    	{
    		setAttribute(request,"resourceRequest");
    		setAttribute(response,"resourceResponse");
    	}
    	
    	else if(request instanceof ActionRequest)
    	{
    		setAttribute(request,"actionRequest");
    		setAttribute(response,"actionResponse");
    	}
    	
    	else if(request instanceof EventRequest)
    	{
    		setAttribute(request,"eventRequest");
    		setAttribute(response,"eventResponse");
    	}
    }
    
     
	/**
     * Processes the <CODE>defineObjects</CODE> tag.
     * @return <CODE>SKIP_BODY</CODE>
     */
    public int doStartTag() throws JspException {
    	PortletRequest request = (PortletRequest) pageContext.getRequest()
        .getAttribute(Constants.PORTLET_REQUEST);
    	PortletResponse response = (PortletResponse) pageContext.getRequest()
        .getAttribute(Constants.PORTLET_RESPONSE);
    	PortletConfig portletConfig = (PortletConfig) pageContext.getRequest()
        .getAttribute(Constants.PORTLET_CONFIG);
    	
    	PortletSession portletSession=request.getPortletSession();
    	
    	PortletPreferences portletPreferences = request.getPreferences();
    	
    	// set attributes render and request
    	setReqRes(request,response);
    	
    	// set attribute portletConfig
    	setAttribute(portletConfig,"portletConfig");
    	
    	// set attribute portletSession
    	setAttribute(portletSession,"portletSession");
    	
    	// set attribute portletPreferences
    	setAttribute(portletPreferences,"portletPreferences");  	
    	
        return SKIP_BODY;
    }

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
                new VariableInfo("resourceRequest",
                                 "javax.portlet.ResourceRequest",
                                 true,
                                 VariableInfo.AT_BEGIN),
                new VariableInfo("resourceResponse",
                                 "javax.portlet.ResourceResponse",
                                 true,
                                 VariableInfo.AT_BEGIN),                            
                new VariableInfo("actionRequest",
                                 "javax.portlet.ActionRequest",
                                 true,
                                 VariableInfo.AT_BEGIN),
                new VariableInfo("actionResponse",
                                 "javax.portlet.ActionResponse",
                                 true,
                                 VariableInfo.AT_BEGIN),
                new VariableInfo("eventRequest",
                                 "javax.portlet.EventRequest",
                                 true,
                                 VariableInfo.AT_BEGIN),
                new VariableInfo("eventResponse",
                                 "javax.portlet.EventResponse",
                                 true,
                                 VariableInfo.AT_BEGIN),                                 
                new VariableInfo("portletConfig",
                                 "javax.portlet.PortletConfig",
                                 true,
                                 VariableInfo.AT_BEGIN),
               new VariableInfo("portletPreferences",
                                "javax.portlet.PortletPreferences",
                                true,
                                VariableInfo.AT_BEGIN),                                 
                new VariableInfo("portletSession",
                        		 "javax.portlet.PortletSession",
                        		 true,
                        		 VariableInfo.AT_BEGIN)
            };

            return info;
        }
    }
}

