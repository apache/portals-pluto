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

package org.apache.pluto.core.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

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
