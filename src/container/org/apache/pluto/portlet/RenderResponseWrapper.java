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

package org.apache.pluto.portlet;

import java.io.IOException;
import java.io.OutputStream;
import javax.portlet.*;

public class RenderResponseWrapper extends PortletResponseWrapper 
implements RenderResponse 
{
   /**
    * Creates a ServletResponse adaptor wrapping the given response object.
    * @throws java.lang.IllegalArgumentException if the response is null.
    */
    public RenderResponseWrapper(RenderResponse renderResponse)
    {
        super(renderResponse);

        if (renderResponse == null) 
        {
            throw new IllegalArgumentException("Response cannot be null");
        }
    }

    // javax.portlet.RenderResponse implementation ------------------------------------------------
    public String getContentType()
    {
        return this.getRenderResponse().getContentType();
    }
    
    public PortletURL createRenderURL()
    {
        return this.getRenderResponse().createRenderURL();
    }

    public PortletURL createActionURL()
    {
        return this.getRenderResponse().createActionURL();
    }
    
    public String getNamespace()
    {
        return this.getRenderResponse().getNamespace();
    }

    public void setTitle(String title)
    {
        this.getRenderResponse().setTitle(title);
    }

    public void setContentType(String type)
    {
        this.getRenderResponse().setContentType(type);
    }

    public String getCharacterEncoding()
    {
        return this.getRenderResponse().getCharacterEncoding();
    }
    
    public java.io.PrintWriter getWriter() throws java.io.IOException
    {
        return this.getRenderResponse().getWriter();
    }

    public java.util.Locale getLocale()
    {
        return this.getRenderResponse().getLocale();
    }
    
    public void setBufferSize(int size)
    {
        this.getRenderResponse().setBufferSize(size);
    }
    
    public int getBufferSize()
    {
        return this.getRenderResponse().getBufferSize();
    }
    
    public void flushBuffer() throws java.io.IOException
    {
        this.getRenderResponse().flushBuffer();
    }
    
    public void resetBuffer()
    {
        this.getRenderResponse().resetBuffer();
    }
    
    public boolean isCommitted()
    {
        return this.getRenderResponse().isCommitted();
    }
    
    public void reset()
    {
        this.getRenderResponse().reset();
    }
    
    public OutputStream getPortletOutputStream() throws IOException 
    {
        return this.getRenderResponse().getPortletOutputStream();
    }
    // --------------------------------------------------------------------------------------------

    // additional methods -------------------------------------------------------------------------
    /**
     * Return the wrapped ServletResponse object.
     */
    public RenderResponse getRenderResponse()
    {
        return (RenderResponse) getPortletResponse();
    }
    // --------------------------------------------------------------------------------------------

}

