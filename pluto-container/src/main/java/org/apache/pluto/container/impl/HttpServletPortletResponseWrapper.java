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
package org.apache.pluto.container.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.pluto.container.util.DummyPrintWriter;
import org.apache.pluto.container.util.DummyServletOutputStream;

/**
 * @author <a href="mailto:ate@douma.nu">Ate Douma</a>
 * @version $Id$
 */
public class HttpServletPortletResponseWrapper extends HttpServletResponseWrapper
{
    private final boolean forwarded;
    private final PortletResponse portletResponse;
    private final MimeResponse mimeResponse;
    private final String lifecyclePhase;
    private boolean included;
    private OutputStream outputStream;
    private ServletOutputStream servletOutputStream;
    
    public HttpServletPortletResponseWrapper(HttpServletResponse response, PortletRequest portletRequest, PortletResponse portletResponse, boolean included)
    {
        super(response);
        this.portletResponse = portletResponse;
        this.lifecyclePhase = (String)portletRequest.getAttribute(PortletRequest.LIFECYCLE_PHASE);
        this.mimeResponse = PortletRequest.RENDER_PHASE.equals(lifecyclePhase) || PortletRequest.RESOURCE_PHASE.equals(lifecyclePhase) ? (MimeResponse)portletResponse : null;
        this.forwarded = !included;
        this.included = included;
    }
    
    public void setIncluded(boolean included)
    {
        this.included = included;
    }
    
    @Override
    public void addCookie(Cookie cookie)
    {
        if (forwarded && !included)
        {
            portletResponse.addProperty(cookie);
        }
    }

    @Override
    public void addDateHeader(String name, long date)
    {
        if (forwarded && !included && mimeResponse != null)
        {
            mimeResponse.addProperty(name, Long.toString(date));
        }
    }

    @Override
    public void addHeader(String name, String value)
    {
        if (forwarded && !included && mimeResponse != null)
        {
            mimeResponse.addProperty(name, value);
        }
    }

    @Override
    public void addIntHeader(String name, int value)
    {
        if (forwarded && !included && mimeResponse != null)
        {
            mimeResponse.addProperty(name, Integer.toString(value));
        }
    }

    @Override
    public boolean containsHeader(String name)
    {
        return false;
    }

    @Override
    public String encodeRedirectUrl(String url)
    {
        return null;
    }

    @Override
    public String encodeRedirectURL(String url)
    {
        return null;
    }

    @Override
    public String encodeUrl(String url)
    {
        return encodeURL(url);
    }

    @Override
    public String encodeURL(String url)
    {
        if (url != null && url.indexOf("://") == -1 && !url.startsWith("/"))
        {
            // The Portlet Spec only allows URL encoding for absolute or full path URIs
            // Letting this pass through thus would lead to an IllegalArgumentException been thrown.

            // TODO: figure out how (if not impossible) this can be (pre)fixed properly
            return url;
        }
        return portletResponse.encodeURL(url);
    }

    @Override
    public void sendError(int sc, String msg) throws IOException
    {
    }

    @Override
    public void sendError(int sc) throws IOException
    {
    }

    @Override
    public void sendRedirect(String location) throws IOException
    {
        if (forwarded && !included && PortletRequest.ACTION_PHASE.equals(lifecyclePhase))
        {
            ((ActionResponse)portletResponse).sendRedirect(location);
        }
    }

    @Override
    public void setDateHeader(String name, long date)
    {
        if (forwarded && !included && mimeResponse != null)
        {
            mimeResponse.setProperty(name, Long.toString(date));
        }
    }

    @Override
    public void setHeader(String name, String value)
    {
        if (forwarded && !included && mimeResponse != null)
        {
            mimeResponse.setProperty(name, value);
        }
    }

    @Override
    public void setIntHeader(String name, int value)
    {
        if (forwarded && !included && mimeResponse != null)
        {
            mimeResponse.setProperty(name, Integer.toString(value));
        }
    }

    @Override
    public void setStatus(int sc, String sm)
    {
        setStatus(sc);
    }

    @Override
    public void setStatus(int sc)
    {
        if (forwarded && !included && PortletRequest.RESOURCE_PHASE.equals(lifecyclePhase))
        {
            mimeResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, Integer.toString(sc));
        }
    }

    @Override
    public void flushBuffer() throws IOException
    {
        if (mimeResponse != null)
        {
            mimeResponse.flushBuffer();
        }            
    }

    @Override
    public int getBufferSize()
    {
        return mimeResponse != null ? mimeResponse.getBufferSize() : 0;
    }

    @Override
    public String getCharacterEncoding()
    {
        return mimeResponse != null ? mimeResponse.getCharacterEncoding() : null;
    }

    @Override
    public String getContentType()
    {
        return mimeResponse != null ? mimeResponse.getContentType() : null;
    }

    @Override
    public Locale getLocale()
    {
        return mimeResponse != null ? mimeResponse.getLocale() : null;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException
    {
    	if (servletOutputStream == null)
    	{
        	outputStream = mimeResponse != null ? mimeResponse.getPortletOutputStream() : DummyServletOutputStream.getInstance();
        	if (outputStream instanceof ServletOutputStream)
        	{
        		servletOutputStream = (ServletOutputStream)outputStream;
        	}
        	else
        	{
        		servletOutputStream = new ServletOutputStream()
        		{
					@Override
					public void write(int b) throws IOException 
					{
						outputStream.write(b);
					}
        		};
        	}
    	}
    	return servletOutputStream;
    }

    @Override
    public PrintWriter getWriter() throws IOException
    {
        return mimeResponse != null ? mimeResponse.getWriter() : DummyPrintWriter.getInstance();
    }

    @Override
    public boolean isCommitted()
    {
        return mimeResponse != null ? mimeResponse.isCommitted() : forwarded ? false : true;
    }

    @Override
    public void reset()
    {
        if (mimeResponse != null)
        {
            mimeResponse.reset();
        }
    }

    @Override
    public void resetBuffer()
    {
        if (mimeResponse != null)
        {
            mimeResponse.resetBuffer();
        }
    }

    @Override
    public void setBufferSize(int size)
    {
        if (mimeResponse != null)
        {
            mimeResponse.setBufferSize(size);
        }
    }

    @Override
    public void setCharacterEncoding(String charset)
    {
        if (forwarded && !included && PortletRequest.RESOURCE_PHASE.equals(lifecyclePhase))
        {
            ((ResourceResponse)portletResponse).setCharacterEncoding(charset);
        }
    }

    @Override
    public void setContentLength(int len)
    {
        if (forwarded && !included && PortletRequest.RESOURCE_PHASE.equals(lifecyclePhase))
        {
            ((ResourceResponse)portletResponse).setContentLength(len);
        }
    }

    @Override
    public void setContentType(String type)
    {
        if (forwarded && !included && mimeResponse != null)
        {
            mimeResponse.setContentType(type);
        }
    }

    @Override
    public void setLocale(Locale loc)
    {
        if (forwarded && !included && PortletRequest.RESOURCE_PHASE.equals(lifecyclePhase))
        {
            ((ResourceResponse)portletResponse).setLocale(loc);
        }
    }    
}
