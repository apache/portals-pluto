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

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 4, 2004
 */
public class PortletTitleTag extends TagSupport {


    public int doStartTag()
        throws JspException {
        PortletTag parent =
            (PortletTag) TagSupport
            .findAncestorWithClass(this, PortletTag.class);

        if (parent == null) {
            throw new JspException(
                "Portlet Window Controls may only reside within a pluto:portlet tag.");
        }

        try {
            pageContext.getOut().print(
                pageContext.getRequest().getAttribute(
                    "org.apache.pluto.dynamic_title"));
        } catch (IOException io) {
            throw new JspException(io);
        }
        return SKIP_BODY;
    }
}

