/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
/* 

 */

/*
 * Created on Feb 21, 2003
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code Template
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
 ** Supporting class for the <CODE>renderURL</CODE> tag.
 ** Creates a url that points to the current Portlet and triggers an render request
 ** with the supplied parameters. 
 **
 **/
public class RenderURLTag extends BasicURLTag
{


    /* (non-Javadoc)
         * @see javax.servlet.jsp.tagext.Tag#doStartTag()
         */
    public int doStartTag() throws JspException {
        if (var != null)
        {
            pageContext.removeAttribute(var, PageContext.PAGE_SCOPE);
        }
        RenderResponse renderResponse = (RenderResponse)pageContext.getRequest().getAttribute("javax.portlet.response");

        if (renderResponse != null)
        {
            setUrl(renderResponse.createRenderURL());
            if (portletMode != null)
            {
                try
                {
                    url.setPortletMode((PortletMode)TEI.portletModes.get(portletMode.toUpperCase()));
                }
                catch (PortletModeException e)
                {
                    throw new JspException(e);
                }
            }
            if (windowState != null)
            {
                try
                {
                    url.setWindowState((WindowState)TEI.definedWindowStates.get(windowState.toUpperCase()));
                }
                catch (WindowStateException e)
                {
                    throw new JspException(e);
                }
            }
            if (secure != null)
            {
                try
                {
                    url.setSecure(getSecureBoolean());
                }
                catch (PortletSecurityException e)
                {
                    throw new JspException(e);
                }
            }
        }
        return EVAL_PAGE;
    }
}

