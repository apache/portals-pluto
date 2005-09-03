/*
 * Copyright 2004 The Apache Software Foundation.
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
package org.apache.pluto.driver.tags;

import java.io.IOException;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.pluto.driver.core.PortalURL;
import org.apache.pluto.driver.core.PortalUrlFactory;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 4, 2004
 */
public class PortletWindowControlTag extends BodyTagSupport {

    private String windowState;
    private String portletMode;

    public int doStartTag()
        throws JspException {
        PortletTag parent =
            (PortletTag) TagSupport
            .findAncestorWithClass(this, PortletTag.class);

        if (parent == null) {
            throw new JspException(
                "Portlet Window Controls may only reside within a pluto:portlet tag.");
        }

        String id = parent.getEvaluatedPortletId();
        HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
        PortalURL url = PortalUrlFactory.getFactory().createPortalUrl(req);

        if (windowState != null) {
            WindowState state = new WindowState(windowState);
            url.setWindowState(id, state);
        }

        if (portletMode != null) {
            PortletMode mode = new PortletMode(portletMode);
            url.setPortletMode(id, mode);
        }

        try {
            pageContext.getOut().print(url.toString());
        } catch (IOException io) {
            throw new JspException(io);
        }

        return EVAL_BODY_INCLUDE;
    }

    public String getWindowState() {
        return windowState;
    }

    public void setWindowState(String windowState) {
        this.windowState = windowState;
    }

    public String getPortletMode() {
        return portletMode;
    }

    public void setPortletMode(String portletMode) {
        this.portletMode = portletMode;
    }


}

