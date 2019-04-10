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
package org.apache.pluto.driver.services.container;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.portlet.CacheControl;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletMimeResponseContext;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.util.PrintWriterServletOutputStream;

/**
 * @version $Id$
 * 
 */
public abstract class PortletMimeResponseContextImpl extends PortletResponseContextImpl implements PortletMimeResponseContext {
   private static class CacheControlImpl implements CacheControl {
      private String  eTag;
      private int     expirationTime;
      private boolean publicScope;
      private boolean cachedContent;

      public CacheControlImpl() {
      }

      @Override
      public boolean useCachedContent() {
         return cachedContent;
      }

      @Override
      public String getETag() {
         return this.eTag;
      }

      @Override
      public int getExpirationTime() {
         return expirationTime;
      }

      @Override
      public boolean isPublicScope() {
         return publicScope;
      }

      @Override
      public void setETag(String eTag) {
         this.eTag = eTag;
      }

      @Override
      public void setExpirationTime(int expirationTime) {
         this.expirationTime = expirationTime;
      }

      @Override
      public void setPublicScope(boolean publicScope) {
         this.publicScope = publicScope;
      }

      @Override
      public void setUseCachedContent(boolean cachedContent) {
         this.cachedContent = cachedContent;
      }
   }

   private CacheControl cacheControl;
   private OutputStream outputStream;

   public PortletMimeResponseContextImpl(PortletContainer container, HttpServletRequest containerRequest, HttpServletResponse containerResponse,
         PortletWindow window, PortletRequestContext requestContext) {
      super(container, containerRequest, containerResponse, window, requestContext);
   }

   @Override
   public void close() {
      cacheControl = null;
      outputStream = null;
      super.close();
   }

   @Override
   public void flushBuffer() throws IOException {
      if (!isClosed() && !isHeaderBufferActive()) {
         getServletResponse().flushBuffer();
      }
   }

   @Override
   public int getBufferSize() {
      if (isHeaderBufferActive()) {
         // header request
         return headerData.getBufferSize();
      } else {
         // render or resource request
         return getServletResponse().getBufferSize();
      }
   }

   @Override
   public CacheControl getCacheControl() {
      if (isClosed()) {
         return null;
      }
      if (cacheControl == null) {
         cacheControl = new CacheControlImpl();
      }
      return cacheControl;
   }

   @Override
   public String getCharacterEncoding() {
      return isClosed() ? null : getServletResponse().getCharacterEncoding();
   }

   @Override
   public String getContentType() {
      String type = null;
      if (!isClosed()) {
         type = getServletResponse().getContentType();
         if (type == null) {
            if (!getLifecycle().equals(PortletRequest.RESOURCE_PHASE)) {
               // default MIME type for Pluto
               type = "text/html";
            }
         } else {
            // ignore charset parameter
            type = type.replaceAll("([^;]*).*", "$1");
         }
      }
      return type;
   }

   @Override
   public Locale getLocale() {
      return isClosed() ? null : getServletResponse().getLocale();
   }

   @Override
   public OutputStream getOutputStream() throws IOException, IllegalStateException {
      if (isClosed()) {
         return null;
      }
      if (isHeaderBufferActive()) {
         // header request
         return headerData.getBaoStream();
      } else {
         // render or resource request
         if (outputStream == null) {
            try {
               outputStream = getServletResponse().getOutputStream();
            } catch (IllegalStateException e) {
               // handle situation where underlying ServletResponse its getWriter()
               // has been called already anyway: return a wrapped PrintWriter in that case
               outputStream = new PrintWriterServletOutputStream(getServletResponse().getWriter(), getServletResponse().getCharacterEncoding());
            }
         }
         return outputStream;
      }
   }

   @Override
   public PrintWriter getWriter() throws IOException, IllegalStateException {
      if (isClosed()) {
         return null;
      }
      if (isHeaderBufferActive()) {
         // header request
         return headerData.getWriter();
      } else {
         // render or resource request
         return getServletResponse().getWriter();
      }
   }

   @Override
   public boolean isCommitted() {
      if (isHeaderBufferActive()) {
         // header request
         return false;
      } else {
         return getServletResponse().isCommitted();
      }
   }

   @Override
   public void reset() {
      if (!isClosed()) {
         if (isHeaderBufferActive()) {
            // header request
            headerData.reset();
         } else {
            getServletResponse().reset();
         }
      }
   }

   @Override
   public void resetBuffer() {
      if (!isClosed()) {
         if (isHeaderBufferActive()) {
            // header request
            headerData.resetBuffer();
         } else {
            getServletResponse().resetBuffer();
         }
      }
   }

   @Override
   public void setBufferSize(int size) {
      if (!isClosed()) {
         if (isHeaderBufferActive()) {
            // header request
            headerData.setBufferSize(size);
         } else {
            // render or resource request
            getServletResponse().setBufferSize(size);
         }
      }
   }

   @Override
   public void setContentType(String contentType) {
      // The content type is set by Pluto for the render & header phases
      if (!isClosed()) { 
         if (getLifecycle().equals(PortletRequest.RESOURCE_PHASE)) {
            getServletResponse().setContentType(contentType);
         } else {
            String type = getServletResponse().getContentType();
            if (type == null) {
               // default MIME type for Pluto
               type = "text/html";
            } else {
               // ignore charset parameter
               type = type.replaceAll("([^;]*).*", "$1");
            }
            if (!type.equals(contentType) && !contentType.matches("\\s*(?:\\*|\\*/\\s*\\*)\\s*")) {
               throw new IllegalArgumentException("Invalid content type: " + contentType);
            }
         }
      }
   }
}
