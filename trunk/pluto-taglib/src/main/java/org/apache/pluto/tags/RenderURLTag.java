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

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletSecurityException;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

/**
 * Supporting class for the <CODE>renderURL</CODE> tag. Creates a url that
 * points to the current Portlet and triggers an render request * with the
 * supplied parameters. *
 */
public class RenderURLTag extends BasicURLTag {


    /* (non-Javadoc)
         * @see javax.servlet.jsp.tagext.Tag#doStartTag()
         */
    public int doStartTag() throws JspException {
        if (var != null) {
            pageContext.removeAttribute(var, PageContext.PAGE_SCOPE);
        }
        RenderResponse renderResponse = (RenderResponse) pageContext.getRequest()
            .getAttribute("javax.portlet.response");

        if (renderResponse != null) {
            setUrl(renderResponse.createRenderURL());
            if (portletMode != null) {
                try {
                    url.setPortletMode(
                        (PortletMode) TEI.portletModes.get(
                            portletMode.toUpperCase()));
                } catch (PortletModeException e) {
                    throw new JspException(e);
                }
            }
            if (windowState != null) {
                try {
                    url.setWindowState(
                        (WindowState) TEI.definedWindowStates.get(
                            windowState.toUpperCase()));
                } catch (WindowStateException e) {
                    throw new JspException(e);
                }
            }
            if (secure != null) {
                try {
                    url.setSecure(getSecureBoolean());
                } catch (PortletSecurityException e) {
                    throw new JspException(e);
                }
            }
        }
        return EVAL_PAGE;
    }
}

