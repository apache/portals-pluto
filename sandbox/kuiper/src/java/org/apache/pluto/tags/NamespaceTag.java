
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
/* 

 */

package org.apache.pluto.tags;

import java.io.IOException;

import javax.portlet.RenderResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * This tag produces a unique value for the current portlet.
 *
 *
 * Supporting class for the <CODE>namespace</CODE> tag.
 * writes a unique value for the current portlet
 * <BR>This tag has no attributes
 */
public class NamespaceTag extends TagSupport
{

    /* (non-Javadoc)
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     */
    public int doStartTag() throws JspException {
        RenderResponse renderResponse = (RenderResponse)pageContext.getRequest().getAttribute("javax.portlet.response");
        String namespace = renderResponse.getNamespace();
        JspWriter writer = pageContext.getOut();
        try
        {
            writer.print(namespace);
            writer.flush();
        }
        catch (IOException ioe)
        {
            throw new JspException("namespace Tag Exception: cannot write to the output writer.");
        }
        return SKIP_BODY;
    }
}
