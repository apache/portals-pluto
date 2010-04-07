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
package org.apache.pluto.driver.tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import javax.portlet.PortletConfig;
import javax.portlet.PortletMode;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.core.PortletWindowImpl;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

/**
 * The tag is used to render a portlet mode anchor specified by the portlet ID and mode.
 * This is designed to live inside of a <pluto:portlet/> tag.
 * 
 * <pluto:modeDropDown />
 *
 */
public class PortletModeDropDownTag extends BodyTagSupport {
    
	private static final long serialVersionUID = 1L;


	/** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PortletModeDropDownTag.class);
        
    
    // Private Member Variables ------------------------------------------------
    private String portletMode = null;
    
    /** The portlet ID attribute obtained from parent tag. */
    private String portletId = null;
    
    /** The evaluated value of the portlet ID attribute. */
    private String evaluatedPortletId = null;       
    
    // BodyTagSupport Impl -----------------------------------------------------
    
    /**
     * Method invoked when the start tag is encountered.
     * @throws JspException  if an error occurs.
     */
    public int doStartTag() throws JspException {
        
        // Ensure that the modeAnchor tag resides within a portlet tag.
        PortletTag parentTag = (PortletTag) TagSupport.findAncestorWithClass(
                this, PortletTag.class);
        if (parentTag == null) {
            throw new JspException("Portlet window controls may only reside "
                    + "within a pluto:portlet tag.");
        }
        
        portletId = parentTag.getPortletId();        
        // Evaluate portlet ID attribute.
        evaluatePortletId();
        
        // Retrieve the portlet window config for the evaluated portlet ID.
        ServletContext servletContext = pageContext.getServletContext();
        DriverConfiguration driverConfig = (DriverConfiguration)
                servletContext.getAttribute(AttributeKeys.DRIVER_CONFIG);
        
        // Retrieve the portal environment.
        PortalRequestContext portalEnv = PortalRequestContext.getContext(
                (HttpServletRequest) pageContext.getRequest());        
        
        //find the current mode for use in 'selected' attrib of select option
		PortalURL requestedPortalUrl = portalEnv.getRequestedPortalURL();
        PortletWindowConfig windowConfig =
            PortletWindowConfig.fromId(evaluatedPortletId);
        // Retrieve the portlet container from servlet context.
        PortletContainer container = (PortletContainer)
                servletContext.getAttribute(AttributeKeys.PORTLET_CONTAINER);
        
        // Create the portlet window to render.
        PortletWindow window = null;
        
        
        try
        {
        	// If this fails it means that the portlet will be not available.
        	// Render Tag will take care of it.
        	window = new PortletWindowImpl(container, windowConfig, requestedPortalUrl);
        }
        catch(RuntimeException ex) 
        {
        	  if (LOG.isDebugEnabled()) {
                  LOG.debug("The portlet " + windowConfig.getPortletName() + " is not available. Is already deployed?");
              }
        }
		
        //start the markup
        StringBuffer tag = new StringBuffer();
     
        // Do not render if we don't have a window.
        if(window!=null)
        {
        	PortletMode currentMode = requestedPortalUrl.getPortletMode(window.getId().getStringId());


        	//        String strCurrentMode = currentMode.toString();        
        	//        tag.append("Current mode: " + currentMode.toString());
        	tag.append("<form action=\"\" name=\"modeSelectionForm\" style=\"display:inline\"><select onchange=\"self.location=this.options[this.selectedIndex].value\">");
        	Set<PortletMode> modeSet = null;
        	try {
        		modeSet = driverConfig.getSupportedPortletModes(evaluatedPortletId);
        	} catch (PortletContainerException e) {
        		throw new JspException(e);
        	}

        	if (modeSet != null) {
        		Iterator<PortletMode> i = modeSet.iterator();
        		while (i.hasNext()) {
        			PortletMode mode = i.next();

        			PortalURL portalUrl =  portalEnv.createPortalURL();
        			portalUrl.setPortletMode(evaluatedPortletId, mode);

        			// Build a string buffer containing the anchor tag
        			tag.append("<option value=\"" + portalUrl.toString() + "\"");
        			//Add 'selected' attribute for current mode.
        			if (mode.equals(currentMode)) {
        				tag.append(" selected=\"true\"");
        			}
        			tag.append(">");
        			if (driverConfig.isPortletManagedMode(evaluatedPortletId, mode.toString())) {
        				tag.append(getCustomModeDecorationName(driverConfig, mode));	            	
        			} else {
        				tag.append(mode.toString().toUpperCase());
        			}
        			//	            tag.append(mode.toString().toUpperCase());
        			tag.append("</option>");
        		}
        	}
        	tag.append("</select></form>");

        }
        
        // Print the mode anchor tag.
        try {
            JspWriter out = pageContext.getOut();
            out.print(tag.toString());
        } catch (IOException ex) {
            throw new JspException(ex);
        }
        
        // Continue to evaluate the tag body.
        return EVAL_BODY_INCLUDE;
    }
    
    // Package Methods ---------------------------------------------------------
    
    /**
     * Returns the evaluated portlet ID.
     * @return the evaluated portlet ID.
     */
    String getEvaluatedPortletId() {
        return evaluatedPortletId;
    }

    
    
    // Private Methods ---------------------------------------------------------
    
    /**
     * Evaluates the portlet ID attribute passed into this tag. This method
     * evaluates the member variable <code>portletId</code> and saves the
     * evaluated result to <code>evaluatedPortletId</code>
     * @throws JspException  if an error occurs.
     */
    private void evaluatePortletId() throws JspException {
        Object obj = ExpressionEvaluatorManager.evaluate(
                "portletId", portletId, String.class, this, pageContext);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Evaluated portletId to: " + obj);
        }
        evaluatedPortletId = (String) obj;
    }

    /**
     * @return the portletMode
     */
    public String getPortletMode() {
        return portletMode;
    }

    /**
     * @param portletMode the portletMode to set
     */
    public void setPortletMode(String portletMode) {
        this.portletMode = portletMode;
    }
    
    private boolean isPortletModeAllowed(DriverConfiguration config, String mode) {
        LOG.debug("Testing if PortletWindowConfig [" + getEvaluatedPortletId() + "] supports mode [" + mode + "]");
        return config.isPortletModeSupported(getEvaluatedPortletId(), mode);
    }

    /**
     * Obtains decoration name for a portlet managed mode from the portlet's resource bundle
     * as defined in PLT.8.4 of the JSR-286 spec using the key 
     * javax.portlet.app.custom-portlet-mode.<custom mode>.decoration-name where
     * custom mode is the name of the custom mode as defined in portlet.xml
     * (//portlet-app/custom-portlet-mode/portlet-mode element). If the decoration
     * name is not found in the resource bundle, this method returns the uppercased
     * mode name.
     * 
     * @param driverConfig the driver config object found in the session.
     * @param mode the portlet managed custom mode that will be searched for decoration name
     * in the resource bundle.
     * @return the decoration name for a portlet managed mode in the resource bundle
     * using the key javax.portlet.app.custom-portlet-mode.<custom mode>.decoration-name 
     * where custom mode is the name of the custom mode as defined in portlet.xml
     * (//portlet-app/custom-portlet-mode/portlet-mode element). If the decoration
     * name is not found in the resource bundle, the uppercased
     * mode name is returned.
     */
    private String getCustomModeDecorationName(DriverConfiguration driverConfig, 
    		PortletMode mode) {
    	//decoration name is mode name by default
		String decorationName = mode.toString().toUpperCase();
		ResourceBundle bundle;
		StringBuffer res;
		try {
			PortletConfig config = driverConfig.getPortletConfig(evaluatedPortletId);
			ServletRequest request = pageContext.getRequest();
			Locale defaultLocale = request.getLocale();
			bundle = config.getResourceBundle(defaultLocale);
			res = new StringBuffer();
			res.append("javax.portlet.app.custom-portlet-mode.");
			res.append(mode.toString());
			res.append(".decoration-name");
			decorationName = bundle.getString(res.toString());
		} catch (Exception e) {
			LOG.debug("Problem finding decoration-name for custom mode: " + mode.toString());
		}
		return decorationName;
    }
    
}
