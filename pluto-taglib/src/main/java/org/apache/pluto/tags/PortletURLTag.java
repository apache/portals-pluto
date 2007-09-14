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
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Map;

import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSecurityException;
import javax.portlet.PortletURL;
import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.http.HttpServletResponse;

/**
 * Abstract supporting class for actionURL tag and renderURL tag.
 * 
 * @version 2.0
 */

public abstract class PortletURLTag extends BaseURLTag {
	
	/**
	 * TagExtraInfo class for PortletURLTag.
	 */
	public static class TEI extends BaseURLTag.TEI {
        public final static Hashtable<String,Object> definedWindowStates = getDefinedWindowStates();
        public final static Hashtable<String,Object> portletModes = getDefinedPortletModes();

        /**
         * Provides a list of all static PortletMode available in the
         * specifications by using introspection
         * @return Hashtable
         */
        private static Hashtable<String,Object> getDefinedPortletModes() {
            Hashtable<String,Object> portletModes = new Hashtable<String,Object>();
            Field[] f = PortletMode.class.getDeclaredFields();

            for (int i = 0; i < f.length; i++) {
                if (f[i].getType().isAssignableFrom(
                    javax.portlet.PortletMode.class)) {
                    try {
                        portletModes.put(
                            f[i].get(f[i]).toString().toUpperCase(),
                            f[i].get(f[i]));
                    } catch (IllegalAccessException e) {
                    }
                }
            }

            return portletModes;
        }

        /**
         * Provides a list of all static WindowsStates available in the
         * specifications by using introspection
         * @return Hashtable
         */
        private static Hashtable<String,Object> getDefinedWindowStates() {
            Hashtable<String,Object> definedWindowStates = new Hashtable<String,Object>();
            Field[] f = WindowState.class.getDeclaredFields();

            for (int i = 0; i < f.length; i++) {
                if (f[i].getType().isAssignableFrom(
                    javax.portlet.WindowState.class)) {
                    try {
                        definedWindowStates.put(
                            f[i].get(f[i]).toString().toUpperCase(),
                            f[i].get(f[i]));
                    } catch (IllegalAccessException e) {

                    }
                }
            }
            return definedWindowStates;
        }

    }
	
	//------------------------------------------------------------------------------------------------------------------
	
	protected String portletMode = null;
	protected String windowState = null;
	protected Boolean copyCurrentRenderParameters = false;
	protected PortletURL url = null;
	
	
	/* (non-Javadoc)
	 * @see org.apache.pluto.tags.BaseURLTag#doStartTag()
	 */
	@Override
    public int doStartTag() throws JspException {
    	
    	//parameters= new HashMap<String,List<String>> ();
    	
    	if(copyCurrentRenderParameters){
			doCopyCurrentRenderParameters();
		}
    	
        if (var != null) {
            pageContext.removeAttribute(var, PageContext.PAGE_SCOPE);
        }
        
        PortletResponse portletResponse = 
        	(PortletResponse) pageContext.getRequest().getAttribute(Constants.PORTLET_RESPONSE);

        if (portletResponse != null) {
        	
            setUrl(createPortletUrl(portletResponse));
            
            if (portletMode != null) {//set portlet mode
                try {
                    PortletMode mode = (PortletMode)
                        TEI.portletModes.get(portletMode.toUpperCase());
                    
                    if (mode == null) {
                        mode = new PortletMode(portletMode);// support for custom portlet modes PLUTO-258
                    }
                    
                    url.setPortletMode(mode);
                    
                } catch (PortletModeException e) {                	
                    throw new JspException(e);                    
                }
            }
            
            if (windowState != null) {//set window state
                try {                	
                    WindowState state = (WindowState)
                        TEI.definedWindowStates.get(windowState.toUpperCase());                  
                    
                    if (state == null) {
                        state = new WindowState(windowState);//support for custom window states PLUTO-258
                    }
                    
                    url.setWindowState(state);
                    
                } catch (WindowStateException e) {                	
                    throw new JspException(e);
                }
            }
            
            if (secure != null) {//set secure boolean
                try {                	
                    url.setSecure(getSecureBoolean());
                } catch (PortletSecurityException e) {                	
                    throw new JspException(e);
                }
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
		//	properly encoding urls to allow non-cookie enabled sessions - PLUTO-252 
		String urlString = response.encodeURL(url.toString());
		
		if(escapeXml){
			urlString = doEscapeXml(urlString);
		}
		
	    if (var == null) {
            try {            	
                JspWriter writer = pageContext.getOut();
                writer.print(urlString);
            } catch (IOException ioe) {
                throw new JspException(
                    "actionURL/renderURL Tag Exception: cannot write to the output writer.");
            }
        } 
	    else {
            pageContext.setAttribute(var, urlString,
                                     PageContext.PAGE_SCOPE);
        }
	    
	    propertiesMap.clear();
	    parametersMap.clear();//cleanup
	    
        return EVAL_PAGE;
	}
	
	
	/**
	 * Returns the url property.
     * @return PortletURL
     */
    public PortletURL getUrl() {
        return url;
    }
	
    
	/**
     * Returns the portletMode property.
     * @return String
     */
    public String getPortletMode() {
        return portletMode;
    }
    
    
    /**
     * Returns the windowState property.
     * @return String
     */
    public String getWindowState() {
        return windowState;
    }
    
    
    /**
     * Returns the copyCurrentRenderParameters property.
     * @return Boolean
     */
    public Boolean getCopyCurrentRenderParameters() {
        return copyCurrentRenderParameters;
    }
    
    
    /**
     * Sets the url property.
     * @param url The url to set
     * @return void
     */
    public void setUrl(PortletURL url) {
        this.url = url;
    }
    
    
    /**
     * Sets the portletMode property.
     * @param portletMode - the portlet mode to set
     * @return void
     */
    public void setPortletMode(String portletMode) {
        this.portletMode = portletMode;
    }
    
    
    /**
     * Sets the windowState property.
     * @param windowState - the portlet window state to set
     * @return void
     */
    public void setWindowState(String windowState) {
        this.windowState = windowState;
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
    		(PortletRequest) pageContext.getRequest().getAttribute(Constants.PORTLET_REQUEST);
		
    	if(request != null){    		
			Map<String,String[]> renderParamsMap = request.getPrivateParameterMap();
			
			Set<String> keySet = renderParamsMap.keySet();
			
			for(String key : keySet){
												
				String[] values = renderParamsMap.get(key);
				
				List<String> valueList = new ArrayList<String>();
				
				for(int index = 0; index < values.length; ++index){
					valueList.add(values[index]);
				}
			    
				parametersMap.put(key,valueList);
			}
		}
    }
    
    
    /**
     * Creates an actionURL or a renderURL
     * @param portletResponse PortletResponse
     * @return PortletURL
     */
    protected abstract PortletURL createPortletUrl(PortletResponse portletResponse);   

}
