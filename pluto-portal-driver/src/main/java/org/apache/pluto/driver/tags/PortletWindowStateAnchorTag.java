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

import javax.portlet.WindowState;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

/**
 * The tag is used to render a portlet mode anchor specified by the portlet ID and mode.
 * This is designed to live inside of a <pluto:portlet/> tag.
 *
 * <pluto:windowStateAnchor portletId="" windowState="maximized"/>
 *
 */
public class PortletWindowStateAnchorTag extends BodyTagSupport {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PortletWindowStateAnchorTag.class);


    // Private Member Variables ------------------------------------------------
    /** Window state name */
    private String state;

    /** Context-relative URL to icon representing window state */
	private String icon;
    
    /** The portlet ID attribute obtained from parent tag. */
    private String portletId;

    /** The evaluated value of the portlet ID attribute. */
    private String evaluatedPortletId;

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

        if (isWindowStateAllowed(driverConfig, state)) {
            // Retrieve the portal environment.
            PortalRequestContext portalEnv = PortalRequestContext.getContext(
                    (HttpServletRequest) pageContext.getRequest());

            PortalURL portalUrl =  portalEnv.createPortalURL();
            portalUrl.setWindowState(evaluatedPortletId, new WindowState(state));

            // Build a string buffer containing the anchor tag
            StringBuffer tag = new StringBuffer();
//            tag.append("<a class=\"" + ToolTips.CSS_CLASS_NAME + "\" href=\"" + portalUrl.toString() + "\">");
//            tag.append("<span class=\"" + state + "\"></span>");
//            tag.append("<span class=\"" + ToolTips.CSS_CLASS_NAME + "\">");
//            tag.append(ToolTips.forWindowState(new WindowState(state)));
//            tag.append("</span></a>");
            tag.append("<a title=\"");
            tag.append(ToolTips.forWindowState(new WindowState(state)));
            tag.append("\" ");
            tag.append("href=\"" + portalUrl.toString() + "\">");
            tag.append("<img border=\"0\" src=\"" + icon + "\" />");
            tag.append("</a>");

            // Print the mode anchor tag.
            try {
                JspWriter out = pageContext.getOut();
                out.print(tag.toString());
            } catch (IOException ex) {
                throw new JspException(ex);
            }
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
        if (LOG.isTraceEnabled()) {
            LOG.debug("Evaluated portletId to: " + obj);
        }
        evaluatedPortletId = (String) obj;
    }

    /**
     * @return the portletMode
     */
    public String getWindowState() {
        return state;
    }

    /**
     * @param portletMode the portletMode to set
     */
    public void setWindowState(String state) {
        this.state = state;
    }

    public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}
    
    private boolean isWindowStateAllowed(DriverConfiguration config, String state) {
        LOG.trace("Testing if PortletWindowConfig [" + getEvaluatedPortletId() + "] supports window state [" + state + "]");
        return config.isWindowStateSupported(getEvaluatedPortletId(), state);
    }


}
