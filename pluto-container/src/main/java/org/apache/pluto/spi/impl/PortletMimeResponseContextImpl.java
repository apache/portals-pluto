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

package org.apache.pluto.spi.impl;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.portlet.CacheControl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletMimeResponseContext;
import org.apache.pluto.container.PortletWindow;

/**
 * @version $Id$
 *
 */
public abstract class PortletMimeResponseContextImpl extends PortletResponseContextImpl implements PortletMimeResponseContext
{
    public PortletMimeResponseContextImpl(PortletContainer container, HttpServletRequest request,
                                          HttpServletResponse response, PortletWindow window)
    {
        super(container, request, response, window);
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletMimeResponseContext#flushBuffer()
     */
    public void flushBuffer()
    {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletMimeResponseContext#getBufferSize()
     */
    public int getBufferSize()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletMimeResponseContext#getCacheControl()
     */
    public CacheControl getCacheControl()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletMimeResponseContext#getCharacterEncoding()
     */
    public String getCharacterEncoding()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletMimeResponseContext#getContentType()
     */
    public String getContentType()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletMimeResponseContext#getLocale()
     */
    public Locale getLocale()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletMimeResponseContext#getOutputStream()
     */
    public OutputStream getOutputStream()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletMimeResponseContext#getWriter()
     */
    public PrintWriter getWriter()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletMimeResponseContext#isCommitted()
     */
    public boolean isCommitted()
    {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletMimeResponseContext#reset()
     */
    public void reset()
    {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletMimeResponseContext#resetBuffer()
     */
    public void resetBuffer()
    {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletMimeResponseContext#setBufferSize(int)
     */
    public void setBufferSize(int size)
    {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletMimeResponseContext#setContentType(java.lang.String)
     */
    public void setContentType(String contentType)
    {
        // TODO Auto-generated method stub
    }
}
