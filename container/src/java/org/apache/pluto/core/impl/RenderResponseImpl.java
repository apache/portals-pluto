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

package org.apache.pluto.core.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.factory.PortletObjectAccess;
import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.services.information.InformationProviderAccess;
import org.apache.pluto.services.title.DynamicTitle;
import org.apache.pluto.util.NamespaceMapperAccess;

public class RenderResponseImpl extends PortletResponseImpl implements RenderResponse {
    private static final String illegalStateExceptionText = "No content type set.";

    private boolean isContentTypeSet;
    
    public RenderResponseImpl(PortletWindow portletWindow,
                              javax.servlet.http.HttpServletRequest servletRequest,
                              javax.servlet.http.HttpServletResponse servletResponse)
    {
        super(portletWindow, servletRequest, servletResponse);
    }

    // javax.portlet.RenderResponse ---------------------------------------------------------------
    public String getContentType()
    {
        if (!isContentTypeSet) {
            return null;
        }
        return InformationProviderAccess.getDynamicProvider(getHttpServletRequest()).getResponseContentType();
    }
    
    public PortletURL createRenderURL()
    {
        PortletURL url = createURL(false);
        return url;
    }
    
    public PortletURL createActionURL()
    {
        PortletURL url = createURL(true);
        return url;
    }
    
    public String getNamespace()
    {
        return NamespaceMapperAccess.getNamespaceMapper().encode(getInternalPortletWindow().getId(), "");
    }
    
    public void setTitle(String title)
    {
        DynamicTitle.setDynamicTitle(getInternalPortletWindow(),
                                     getHttpServletRequest(),
                                     title);
    }
    
    public void setContentType(String type)
    {
        String mimeType = stripCharacterEncoding(type);
        if (!isValidContentType(mimeType)) {
            throw new IllegalArgumentException(mimeType);
        }
        this._getHttpServletResponse().setContentType(mimeType);
        isContentTypeSet = true;
    }

    public String getCharacterEncoding()
    {
        return this._getHttpServletResponse().getCharacterEncoding();
    }
    
    public PrintWriter getWriter() throws IOException, IllegalStateException {
        if (!isContentTypeSet) {
            throw new java.lang.IllegalStateException(illegalStateExceptionText);
        }

        return super.getWriter();
    }

    public java.util.Locale getLocale()
    {
        return this.getHttpServletRequest().getLocale();
    }

    public void setBufferSize(int size)
    {
        throw new IllegalStateException("portlet container does not support buffering");
    }
    
    public int getBufferSize()
    {
        //return this._getHttpServletResponse().getBufferSize();
        return 0;
    }
    
    public void flushBuffer() throws java.io.IOException
    {
        this._getHttpServletResponse().flushBuffer();
    }

    public void resetBuffer()
    {
        this._getHttpServletResponse().resetBuffer();
    }

    public boolean isCommitted()
    {
        return this._getHttpServletResponse().isCommitted();
    }

    public void reset()
    {
        this._getHttpServletResponse().reset();
    }
    
    public OutputStream getPortletOutputStream() throws java.io.IOException,java.lang.IllegalStateException
    {
        if (!isContentTypeSet) {
            throw new java.lang.IllegalStateException(illegalStateExceptionText);
        }
        return getOutputStream(); 
    }
    // --------------------------------------------------------------------------------------------

    // internal methods ---------------------------------------------------------------------------
    private PortletURL createURL(boolean isAction)
    {
        return PortletObjectAccess.getPortletURL(getInternalPortletWindow(),
                                                 getHttpServletRequest(),
                                                 _getHttpServletResponse(),
                                                 isAction);
    }

    private boolean isValidContentType(String type)
    {
        return type.equals("text/html");
    }

    private String stripCharacterEncoding(String type)
    {
        int xs = type.indexOf(';');
        String strippedType;
        if (xs == -1) {
            strippedType = type;
        } else {
            strippedType = type.substring(0,xs);
        }
        return strippedType.trim();
    }
    // --------------------------------------------------------------------------------------------
}
