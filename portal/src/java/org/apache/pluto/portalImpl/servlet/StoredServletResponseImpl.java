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

package org.apache.pluto.portalImpl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

public class StoredServletResponseImpl extends javax.servlet.http.HttpServletResponseWrapper 
{
    private PrintWriter writer;

    public StoredServletResponseImpl(HttpServletResponse response, PrintWriter _writer)
    {
        super(response);
        writer = _writer;
    }

    private javax.servlet.http.HttpServletResponse _getHttpServletResponse()
    {
        return(javax.servlet.http.HttpServletResponse) super.getResponse();
    }

    public void setResponse(HttpServletResponse response) 
    {
        super.setResponse(response);
    }
/*    
    public ServletOutputStream getOutputStream()
        throws IOException
    {
        return response.getOutputStream();
    }
*/
    public PrintWriter getWriter()
        throws IOException
    {
        return writer;
    }
/*
    public void setBufferSize(int size)
    {
        response.setBufferSize(size);
    }

    public int getBufferSize()
    {
        return response.getBufferSize();
    }
*/
    public void flushBuffer()
        throws IOException
    {
        writer.flush();
    }
/*
    public boolean isCommitted()
    {
        return response.isCommitted();
    }

    public void reset()
    {
        response.reset();
    }

    public void resetBuffer()
    {
        response.resetBuffer();
    }
*/
}
