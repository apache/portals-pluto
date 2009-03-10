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

import java.util.Locale;

import javax.portlet.PortletURL;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

import org.apache.pluto.container.spi.optional.PortletResourceResponseContext;

public class ResourceResponseImpl extends MimeResponseImpl implements ResourceResponse
{
    private String requestCacheLevel;
    private PortletResourceResponseContext responseContext;
    
    public ResourceResponseImpl(PortletResourceResponseContext responseContext, String requestCachelevel)
    {
        super(responseContext);
        this.responseContext = responseContext;
        this.requestCacheLevel = requestCachelevel;
    }
	
    public PortletURL createActionURL()
    {
        return new PortletURLImpl(responseContext, true, false, requestCacheLevel);
    }
    
    public PortletURL createRenderURL()
    {
        return new PortletURLImpl(responseContext, false, false, requestCacheLevel);
    }


    public ResourceURL createResourceURL()
    {
        return new PortletURLImpl(responseContext, false, true, requestCacheLevel);
    }
    
	public void setCharacterEncoding(String charset)
	{
	    responseContext.setCharacterEncoding(charset);
	}

	public void setContentLength(int len)
	{
	    responseContext.setContentLength(len);
	}

	public void setLocale(Locale locale)
	{
	    responseContext.setLocale(locale);
	}
}
