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

package org.apache.pluto.driver.taglib;

import org.apache.pluto.driver.Portal;
import org.apache.pluto.driver.impl.PortletWindowImpl;
import org.apache.pluto.driver.impl.PortletWindowImpl;
import org.apache.pluto.PlutoException;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.portlet.PortletException;
import java.io.IOException;

/**
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 8:17:59 AM
 */
public class RenderTag extends TagSupport {

    private static final Log LOG = LogFactory.getLog(RenderTag.class);

    public int doEndTag()
    throws JspException {
        PortletWindowImpl window =
            (PortletWindowImpl)pageContext.findAttribute("portlet");

        if(window==null) {
            throw new JspException("PortletDD not defined");
        }

        try {
            // When passing the response, we must either
            // wrap it and delay the output via the previous
            // out, OR, we must flush before passing this one.
            pageContext.getOut().flush();
            Portal.getPortal().doRender(
                window,
                (HttpServletRequest)pageContext.getRequest(),
                (HttpServletResponse)pageContext.getResponse()
            );
        }
        catch(IOException io) {
            throw new JspException(io);
        }
        catch(PortletException pe) {
            throw new JspException(pe);
        }
        catch(PlutoException pe) {
            throw new JspException(pe);
        }
        catch(RuntimeException re) {
            LOG.error("Error invoking portlet render", re);
            throw re;
        }
        return SKIP_BODY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name = "portlet";
}
