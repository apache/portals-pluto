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
package org.apache.pluto.driver.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;

public class PortalServletResponse
    extends javax.servlet.http.HttpServletResponseWrapper {

    private StringWriter buffer = null;
    private PrintWriter writer = null;

    public PortalServletResponse(HttpServletResponse response) {
        super(response);
        buffer = new StringWriter();
        writer = new PrintWriter(buffer);
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public StringWriter getInternalBuffer() {
        return buffer;
    }

    public PrintWriter getInternalResponseWriter()
        throws IOException {
        return super.getWriter();
    }

    @Override
    public void flushBuffer() throws IOException
    {
    }

    @Override
    public int getBufferSize()
    {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isCommitted()
    {
        return false;
    }

    @Override
    public void reset()
    {
        resetBuffer();
    }

    @Override
    public void resetBuffer()
    {
        buffer.getBuffer().setLength(0);
    }

    @Override
    public void setBufferSize(int size)
    {
    }
}
