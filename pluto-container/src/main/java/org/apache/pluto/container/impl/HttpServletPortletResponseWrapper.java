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
import java.util.Collection;
import java.util.Locale;

import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.pluto.container.util.DummyPrintWriter;
import org.apache.pluto.container.util.DummyServletOutputStream;

/**
 * @author <a href="mailto:ate@douma.nu">Ate Douma</a>
 * @version $Id$
 */
public class HttpServletPortletResponseWrapper extends HttpServletResponseWrapper {
   private final PortletResponse portletResponse;
   private boolean               included;
   private OutputStream          outputStream;
   private ServletOutputStream   servletOutputStream;

   public HttpServletPortletResponseWrapper(HttpServletResponse response, PortletRequest portletRequest,
         PortletResponse portletResponse, boolean included) {
      super(response);
      this.portletResponse = portletResponse;
      this.included = included;
   }

   @Override
   public void addCookie(Cookie cookie) {
      if (!included) {
         portletResponse.addProperty(cookie);
      }
   }

   @Override
   public void addDateHeader(String name, long date) {
      if (!included && (portletResponse instanceof MimeResponse)) {
         ((MimeResponse) portletResponse).addProperty(name, Long.toString(date));
      }
   }

   @Override
   public void addHeader(String name, String value) {
      if (!included && (portletResponse instanceof MimeResponse)) {
         ((MimeResponse) portletResponse).addProperty(name, value);
      }
   }

   @Override
   public void addIntHeader(String name, int value) {
      if (!included && (portletResponse instanceof MimeResponse)) {
         ((MimeResponse) portletResponse).addProperty(name, Integer.toString(value));
      }
   }

   @Override
   public boolean containsHeader(String name) {
      return false;
   }

   @Override
   public String encodeRedirectUrl(String url) {
      return null;
   }

   @Override
   public String encodeRedirectURL(String url) {
      return null;
   }

   @Override
   public String encodeUrl(String url) {
      return encodeURL(url);
   }

   @Override
   public String encodeURL(String url) {
      return portletResponse.encodeURL(url);
   }

   @Override
   public void sendError(int sc, String msg) throws IOException {
   }

   @Override
   public void sendError(int sc) throws IOException {
   }

   @Override
   public void sendRedirect(String location) throws IOException {
      if (!included && (portletResponse instanceof ActionResponse)) {
         ((ActionResponse) portletResponse).sendRedirect(location);
      }
   }

   @Override
   public void setDateHeader(String name, long date) {
      if (!included && (portletResponse instanceof MimeResponse)) {
         ((MimeResponse) portletResponse).setProperty(name, Long.toString(date));
      }
   }

   @Override
   public void setHeader(String name, String value) {
      if (!included && (portletResponse instanceof MimeResponse)) {
         ((MimeResponse) portletResponse).setProperty(name, value);
      }
   }

   @Override
   public void setIntHeader(String name, int value) {
      if (!included && (portletResponse instanceof MimeResponse)) {
         ((MimeResponse) portletResponse).setProperty(name, Integer.toString(value));
      }
   }

   @Override
   public void setStatus(int sc, String sm) {
      setStatus(sc);
   }

   @Override
   public void setStatus(int sc) {
      if (!included && (portletResponse instanceof ResourceResponse)) {
         ((ResourceResponse) portletResponse).setProperty(ResourceResponse.HTTP_STATUS_CODE, Integer.toString(sc));
      }
   }

   @Override
   public void flushBuffer() throws IOException {
      if ((portletResponse instanceof MimeResponse)) {
         ((MimeResponse) portletResponse).flushBuffer();
      }
   }

   @Override
   public int getBufferSize() {
      if (portletResponse instanceof MimeResponse) {
         return ((MimeResponse) portletResponse).getBufferSize();
      }
      return 0;
   }

   @Override
   public String getCharacterEncoding() {
      if (portletResponse instanceof MimeResponse) {
         return ((MimeResponse) portletResponse).getCharacterEncoding(); 
      }
      return null;
   }

   @Override
   public String getContentType() {
      if (portletResponse instanceof MimeResponse) {
         return ((MimeResponse) portletResponse).getContentType(); 
      }
      return null;
   }

   @Override
   public Locale getLocale() {
      if (portletResponse instanceof MimeResponse) {
         return ((MimeResponse) portletResponse).getLocale(); 
      }
      return null;
   }

   @Override
   public ServletOutputStream getOutputStream() throws IOException {
      if (servletOutputStream == null) {
         outputStream = (portletResponse instanceof MimeResponse) ? ((MimeResponse) portletResponse)
               .getPortletOutputStream() : DummyServletOutputStream.getInstance();
         if (outputStream instanceof ServletOutputStream) {
            servletOutputStream = (ServletOutputStream) outputStream;
         } else {
            servletOutputStream = new ServletOutputStream() {
               @Override
               public void write(int b) throws IOException {
                  outputStream.write(b);
               }

               @Override
               public boolean isReady() {
                  // Servlet 3.1 API. Not implemented.
                  return true;
               }

               @Override
               public void setWriteListener(WriteListener arg0) {
                  // Servlet 3.1 API. Not implemented.
               }
            };
         }
      }
      return servletOutputStream;
   }

   @Override
   public PrintWriter getWriter() throws IOException {
      PrintWriter writer = null;
      if (portletResponse instanceof MimeResponse) {
         writer =  ((MimeResponse) portletResponse).getWriter();
      } else {
         writer = DummyPrintWriter.getInstance();
      }
      return writer;
   }

   @Override
   public boolean isCommitted() {
      if (portletResponse instanceof MimeResponse) {
         return ((MimeResponse) portletResponse).isCommitted();
      }
      return included;
   }

   @Override
   public void reset() {
      if ((portletResponse instanceof MimeResponse)) {
         ((MimeResponse) portletResponse).reset();
      }
   }

   @Override
   public void resetBuffer() {
      if ((portletResponse instanceof MimeResponse)) {
         ((MimeResponse) portletResponse).resetBuffer();
      }
   }

   @Override
   public void setBufferSize(int size) {
      if ((portletResponse instanceof MimeResponse)) {
         ((MimeResponse) portletResponse).setBufferSize(size);
      }
   }

   @Override
   public void setCharacterEncoding(String charset) {
      if (!included && (portletResponse instanceof ResourceResponse)) {
         ((ResourceResponse) portletResponse).setCharacterEncoding(charset);
      }
   }

   @Override
   public void setContentLength(int len) {
      if (!included && (portletResponse instanceof ResourceResponse)) {
         ((ResourceResponse) portletResponse).setContentLength(len);
      }
   }

   @Override
   public void setContentType(String type) {
      if (!included && (portletResponse instanceof MimeResponse)) {
         ((MimeResponse) portletResponse).setContentType(type);
      }
   }

   @Override
   public void setLocale(Locale loc) {
      if (!included && (portletResponse instanceof ResourceResponse)) {
         ((ResourceResponse) portletResponse).setLocale(loc);
      }
   }
   
   @Override
   public void setContentLengthLong(long length) {
      if (portletResponse instanceof ResourceResponse) {
         ((ResourceResponse) portletResponse).setContentLengthLong(length);
      }
   }
   
   @Override
   public int getStatus() {
      if (portletResponse instanceof ResourceResponse) {
         return ((ResourceResponse) portletResponse).getStatus();
      }
      return SC_OK;
   }
   
   @Override
   public String getHeader(String name) {
      return portletResponse.getProperty(name);
   }
   
   @Override
   public Collection<String> getHeaderNames() {
      return portletResponse.getPropertyNames();
   }
   
   @Override
   public Collection<String> getHeaders(String name) {
      return portletResponse.getPropertyValues(name);
   }
}
