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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.portlet.ClientDataRequest;

import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletResponseContext;

/**
 * Implementation of the <code>javax.portlet.ClientDataRequest</code> interface.
 */
public abstract class ClientDataRequestImpl extends PortletRequestImpl implements ClientDataRequest
{
    /** Flag indicating if the HTTP body reader has been accessed. */
    protected boolean readerAccessed = false;

    public ClientDataRequestImpl(PortletRequestContext requestContext, PortletResponseContext responseContext, String lifecyclePhase)
    {
        super(requestContext, responseContext, lifecyclePhase);
    }

    private void checkPostedFormData() 
    {
        if (getMethod().equals("POST"))
        {
            String contentType = getContentType();
            if (contentType == null || contentType.equals("application/x-www-form-urlencoded"))
            {
                throw new IllegalStateException("User request HTTP POST data is of type "
                                                + "application/x-www-form-urlencoded. "
                                                + "This data has been already processed "
                                                + "by the portlet-container and is available "
                                                + "as request parameters.");
            }
        }
    }
        
    public java.lang.String getCharacterEncoding()
    {
        return getServletRequest().getCharacterEncoding();
    }

    public int getContentLength()
    {
        return getServletRequest().getContentLength();
    }

    public java.lang.String getContentType()
    {
        return getServletRequest().getContentType();
    }
    
    public String getMethod()
    {
        return getServletRequest().getMethod();
    }

    public InputStream getPortletInputStream() throws IOException
    {
        checkPostedFormData();
        // the HttpServletRequest will ensure that a IllegalStateException is thrown
        //   if getReader() was called earlier        
        return getServletRequest().getInputStream();
    }

    public BufferedReader getReader()
    throws UnsupportedEncodingException, IOException 
    {
        checkPostedFormData();
        // the HttpServletRequest will ensure that a IllegalStateException is thrown
        //   if getInputStream() was called earlier
        BufferedReader reader = getServletRequest().getReader();
        readerAccessed = true;
        return reader;

    }
    
    public void setCharacterEncoding(String encoding)
    throws UnsupportedEncodingException 
    {
        if (readerAccessed) 
        {
            throw new IllegalStateException("Cannot set character encoding "
                    + "after HTTP body reader is accessed.");
        }
        getServletRequest().setCharacterEncoding(encoding);
    }
}
