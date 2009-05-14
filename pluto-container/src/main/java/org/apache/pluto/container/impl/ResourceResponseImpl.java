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
import java.io.PrintWriter;
import java.util.Locale;

import javax.portlet.PortletURL;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

import org.apache.pluto.container.PortletResourceResponseContext;
import org.apache.pluto.container.PortletURLProvider;

public class ResourceResponseImpl extends MimeResponseImpl implements ResourceResponse
{
    private static final String DEFAULT_CONTAINER_CHARSET = "UTF-8";
    
    private boolean canSetLocaleEncoding = true;
    private String charset;
    private String requestCacheLevel;
    private PortletResourceResponseContext responseContext;
    
    public ResourceResponseImpl(PortletResourceResponseContext responseContext, String requestCacheLevel)
    {
        super(responseContext);
        this.responseContext = responseContext;
        this.requestCacheLevel = requestCacheLevel == null ? ResourceURL.PAGE : requestCacheLevel;
    }
	
    @Override
    public PortletURL createActionURL()
    {
        if (ResourceURL.PAGE.equals(requestCacheLevel))
        {
            return new PortletURLImpl(responseContext, PortletURLProvider.TYPE.ACTION);
        }
        throw new IllegalStateException("Not allowed to create an ActionURL with current request cacheability level "+requestCacheLevel);
    }
    
    @Override
    public PortletURL createRenderURL()
    {
        if (ResourceURL.PAGE.equals(requestCacheLevel))
        {
            return new PortletURLImpl(responseContext, PortletURLProvider.TYPE.RENDER);
        }
        throw new IllegalStateException("Not allowed to create a RenderURL with current request cacheability level "+requestCacheLevel);
    }

    @Override
    public ResourceURL createResourceURL()
    {
        return new PortletURLImpl(responseContext, requestCacheLevel);
    }
    
    @Override
    public PrintWriter getWriter()
    throws IllegalStateException, IOException
    {
        if (charset == null)
        {
            // enforce the default Container encoding == UTF-8 if encoding hasn't been set yet.
            setCharacterEncoding(DEFAULT_CONTAINER_CHARSET);
        }
        return super.getWriter();
    }
    
    @Override
    public String getCharacterEncoding()
    {
        return charset != null ? charset : DEFAULT_CONTAINER_CHARSET;
    }
    
	public void setCharacterEncoding(String encoding)
	{
        // ensure client hasn't passed us the full name/value pair; i.e
        // charset=utf-8
        int index = encoding.indexOf('=');
        if (index != -1 && index < encoding.length()-1)
        {
          encoding = encoding.substring(index+1).trim();
        }
            
	    if (encoding != null && encoding.length() > 0)
	    {
	        this.charset = encoding;
	        responseContext.setCharacterEncoding(charset);
	        canSetLocaleEncoding = false;
	    }
	}
	
	@Override
	public void setContentType(String contentType)
	{
	    if (contentType != null)
	    {
	        int index = contentType.indexOf(';');
	        if (index != -1 && index < contentType.length()-1) 
	        {
	            String encoding = contentType.substring(index+1).trim();
	            if (encoding.length() > 0)
	            {
	                setCharacterEncoding(encoding);
	            }
	        }
	        super.setContentType(contentType);
	    }
	}

	public void setContentLength(int len)
	{
	    responseContext.setContentLength(len);
	}

	public void setLocale(Locale locale)
	{
	    if (locale != null)
	    {
            responseContext.setLocale(locale);
	        if (canSetLocaleEncoding)
	        {
	            String encoding = getPortletWindow().getPortletDefinition().getApplication().getLocaleEncodingMappings().get(locale);
	            if (encoding != null)
	            {
	                setCharacterEncoding(encoding);
	                // allow repeated setLocale usage for characterEncoding
	                canSetLocaleEncoding = true;
	            }
	        }
	    }
	}
}
