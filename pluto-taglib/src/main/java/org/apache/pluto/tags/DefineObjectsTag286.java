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

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.VariableInfo;

/**
 * A tag handler for the <CODE>defineObjects</CODE> tag as defined in the JSR 286. 
 * Creates the following variables to be used in the JSP: 
 * <UL> 
 * <LI><CODE>{@link RenderRequest} renderRequest</CODE>, 
 * 	when included from within the <CODE>render</CODE> method, <code>null</code> otherwise
 * <LI><CODE>{@link ResourceRequest} resourceRequest</CODE>, 
 *  when included from within the <CODE>serveResource</CODE> method, <code>null</code> otherwise
 * <LI><CODE>{@link ActionRequest} actionRequest</CODE>, 
 *  when included from within the <CODE>processAction</CODE> method, <code>null</code> otherwise
 * <LI><CODE>{@link EventRequest} eventRequest</CODE>, 
 *  when included from within the <CODE>processEvent</CODE> method, <code>null</code> otherwise
 * <LI><CODE>{@link RenderResponse} renderResponse</CODE>, 
 *  when included from within the <CODE>render</CODE> method, <code>null</code> otherwise
 * <LI><CODE>{@link ResourceResponse} resourceResponse</CODE>, 
 *  when included from within the <CODE>serveResource</CODE> method, <code>null</code> otherwise 
 * <LI><CODE>{@link ActionResponse} actionResponse</CODE>, 
 *  when included from within the <CODE>processAction</CODE> method, <code>null</code> otherwise
 * <LI><CODE>{@link EventResponse} eventResponse</CODE>, 
 *  when included from within the <CODE>processEvent</CODE> method, <code>null</code> otherwise
 * <LI><CODE>{@link PortletConfig} portletConfig</CODE>
 * <LI><CODE>{@link PortletSession} portletSession</CODE>, providing access to the portletSession,
 *  does not create a new session, only returns an existing session
 * <LI><CODE>{@link Map<String, Object>} portletSessionScope</CODE>, providing access to the 
 *  portletSession attributes as a Map.
 * <LI><CODE>{@link PortletPreferences} portletPreferences</CODE>, providing access to 
 *  the portlet preferences
 * <LI> <CODE>{@link Map<String, String[]>} portletPreferencesValues</CODE>, providing access to the
 *  portlet preferences as a Map
 * </UL>
 * 
 * @version 2.0
 */
public class DefineObjectsTag286 extends TagSupport {
	
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
     * Helper method.
     * <p>
     * Sets the portlet render and request attribute with 
     * the names described in the JSR 286 - PLT 26.1 (defineObjects Tag).
     * 
     * @param request PortletRequest
     * @param response PortletResponse
     */
    private void setPortletRequestResponseAttribute(PortletRequest request, 
    		PortletResponse response ){
    	
    	String phase = (
    			String)request.getAttribute(PortletRequest.LIFECYCLE_PHASE);
    	
    	//check where request and response where included from
    	if(PortletRequest.ACTION_PHASE.equals(phase)){
    		setAttribute(request, "actionRequest");
    		setAttribute(response, "actionResponse");
    	}    	
    	else if(PortletRequest.EVENT_PHASE.equals(phase)){
    		setAttribute(request, "eventRequest");
    		setAttribute(response, "eventResponse");
    	}
    	else if(PortletRequest.RENDER_PHASE.equals(phase)){
    		setAttribute(request, "renderRequest");
    		setAttribute(response, "renderResponse");
    	}    	
    	else if(PortletRequest.RESOURCE_PHASE.equals(phase)){
    		setAttribute(request, "resourceRequest");
    		setAttribute(response, "resourceResponse");
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
    	
    	PortletSession portletSession = portletRequest.getPortletSession(false);
    	
    	Map<String, Object> portletSessionScope = null;
    	if(portletSession != null){
    		portletSessionScope = (Map<String, Object>)portletSession.getAttributeMap();// getMap();
    	}
    	else{
    		portletSessionScope = new HashMap<String, Object>();
    	}
    	
    	PortletPreferences portletPreferences = portletRequest.getPreferences();
    	
    	Map<String, String[]> portletPreferencesValues = null;
    	if(portletPreferences != null){
    		portletPreferencesValues = portletPreferences.getMap();
    	}
    	else{
    		portletPreferencesValues = new HashMap<String, String[]>();
    	}
    	
    	// set attributes render and request
    	setPortletRequestResponseAttribute(portletRequest, portletResponse);
    	
    	// set attribute portletConfig
    	setAttribute(portletConfig, "portletConfig");
    	
    	// set attribute portletSession
    	setAttribute(portletSession, "portletSession");
    	
    	//set attribute portletSession
    	setAttribute(portletSessionScope, "portletSessionScope");
    	
    	// set attribute portletPreferences
    	setAttribute(portletPreferences, "portletPreferences");
    	
    	// set attribute portletPreferences
    	setAttribute(portletPreferencesValues, "portletPreferencesValues");    	
    	
        return SKIP_BODY;
    }

    
    
    /**
     * TagExtraInfo class for DefineObjectsTag.
     *
     */
    public static class TEI extends TagExtraInfo {

        public VariableInfo[] getVariableInfo(TagData tagData) {
            VariableInfo[] info = new VariableInfo[]{
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
                new VariableInfo("portletConfig",
                                 "javax.portlet.PortletConfig",
                                 true,
                                 VariableInfo.AT_BEGIN),
                new VariableInfo("portletSession",
                                 "javax.portlet.PortletSession",
                                 true,
                                 VariableInfo.AT_BEGIN),
                new VariableInfo("portletSessionScope",
                          		 "java.util.Map",
                          		 true,
                           		 VariableInfo.AT_BEGIN),                                		 
                new VariableInfo("portletPreferences",
                                "javax.portlet.PortletPreferences",
                                true,
                                VariableInfo.AT_BEGIN),   
                new VariableInfo("portletPreferencesValues",
                                 "java.util.Map",
                                 true,
                                 VariableInfo.AT_BEGIN),                                
                
            };
            return info;
        }
    }
}

