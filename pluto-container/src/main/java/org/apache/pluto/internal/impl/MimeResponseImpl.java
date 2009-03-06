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

package org.apache.pluto.internal.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.CacheControl;
import javax.portlet.MimeResponse;
import javax.portlet.PortletURL;
import javax.portlet.ResourceURL;

import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.portlet.Supports;
import org.apache.pluto.spi.optional.PortletMimeResponseContext;

public class MimeResponseImpl extends PortletResponseImpl implements MimeResponse
{
    /** Response content types. */
    private ArrayList<String> responseContentTypes;
    
    private boolean usingWriter;
    private boolean usingStream;

    private PortletMimeResponseContext responseContext;
    
	public MimeResponseImpl(PortletMimeResponseContext responseContext)
	{
		super(responseContext);
		this.responseContext = responseContext;
		PortletDefinition portletDefinition = getPortletWindow().getPortletEntity().getPortletDefinition();
		getCacheControl().setExpirationTime(portletDefinition.getExpirationCache());
		getCacheControl().setPublicScope(PUBLIC_SCOPE.equals(portletDefinition.getCacheScope()));
	}
	
    protected List<String> getResponseContentTypes() 
    {
        if (responseContentTypes == null) 
        {
            responseContentTypes = new ArrayList<String>();
            PortletDefinition dd = getPortletWindow().getPortletEntity().getPortletDefinition();
            for (Supports sup : dd.getSupports())
            {
                responseContentTypes.add(sup.getMimeType());
            }
            if (responseContentTypes.isEmpty()) 
            {
                responseContentTypes.add("text/html");
            }
        }
        return responseContentTypes;
    }
    
    public PortletURL createActionURL()
    {
        return new PortletURLImpl(responseContext, true, false);
    }
    
    public PortletURL createRenderURL()
    {
        return new PortletURLImpl(responseContext, false, false);
    }


    public ResourceURL createResourceURL()
    {
        return new PortletURLImpl(responseContext, false, true);
    }
    
    public void flushBuffer() throws IOException
    {
        responseContext.flushBuffer();
    }

    public int getBufferSize()
    {
        return responseContext.getBufferSize();
    }
    
	public CacheControl getCacheControl() {
		return responseContext.getCacheControl();
	}
	
    public String getCharacterEncoding()
    {
        return responseContext.getCharacterEncoding();
    }

    public String getContentType()
    {
        return responseContext.getContentType();
    }
    
    public Locale getLocale()
    {
        return responseContext.getLocale();
    }

    public OutputStream getPortletOutputStream()
    throws IllegalStateException, IOException
    {
        if (usingWriter)
        {
            throw new IllegalStateException("getPortletOutputStream can't be used after getWriter was invoked.");
        }
        if (getContentType() == null)
        {
            setContentType(getResponseContentTypes().get(0));
        }
        usingStream = true;
        return responseContext.getOutputStream();
    }
    
    public PrintWriter getWriter()
    throws IllegalStateException, IOException
    {
        if (usingStream)
        {
            throw new IllegalStateException("getWriter can't be used after getOutputStream was invoked.");
        }
        if (getContentType() == null)
        {
            setContentType(getResponseContentTypes().get(0));
        }
        usingWriter = true;
        return responseContext.getWriter();
    }

    public boolean isCommitted()
    {
        return responseContext.isCommitted();
    }

    public void reset()
    {
        responseContext.reset();
    }

    public void resetBuffer()
    {
        responseContext.resetBuffer();
    }

    public void setBufferSize(int size)
    {
        responseContext.setBufferSize(size);
    }
    
    public void setContentType(String contentType)
    {
        responseContext.setContentType(contentType);
    }
    
    @Override
    public void setProperty(String name, String value)
    {
        if (USE_CACHED_CONTENT.equals(name))
        {
            getCacheControl().setUseCachedContent(value != null);
        } 
        else if (EXPIRATION_CACHE.equals(name))
        {
            int expirationTime;
            try 
            {
                expirationTime = Integer.parseInt(value);
            } 
            catch (NumberFormatException e)
            {
                expirationTime = 0;
            }
            getCacheControl().setExpirationTime(expirationTime);
        } 
        else if (ETAG.equals(name)) 
        {
            getCacheControl().setETag(value);
        } 
        else if (CACHE_SCOPE.equals(name))
        {
            getCacheControl().setPublicScope(PUBLIC_SCOPE.equals(value));
        } 
        else 
        {
            super.setProperty(name, value);
        }
    }
}
