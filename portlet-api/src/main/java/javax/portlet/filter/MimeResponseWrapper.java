/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package javax.portlet.filter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.portlet.ActionURL;
import javax.portlet.CacheControl;
import javax.portlet.MimeResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderURL;
import javax.portlet.ResourceURL;

/**
 * <div class="changed_added_3_0"> The <code>MimeResponseWrapper</code> provides
 * a convenient implementation of the <code>MimeResponse</code> interface that
 * can be subclassed by developers. This class
 * implements the Wrapper or Decorator pattern. Methods default to calling
 * through to the wrapped response object. </div>
 * 
 * @since 3.0
 */
public class MimeResponseWrapper extends PortletResponseWrapper implements MimeResponse {

   /**
    * @param response
    */
   public MimeResponseWrapper(MimeResponse response) {
      super(response);
   }

   /**
    * Return the wrapped response object.
    * 
    * @return the wrapped response
    */
   public MimeResponse getResponse() {
      return (MimeResponse) super.getResponse();
   }

   /**
    * Sets the response object being wrapped.
    * 
    * @param response
    *           the response to set
    * @throws java.lang.IllegalArgumentException
    *            if the response is null.
    */
   public void setResponse(MimeResponse response) {
      super.setResponse(response);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#flushBuffer()
    */
   @Override
   public void flushBuffer() throws IOException {
      ((MimeResponse)response).flushBuffer();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#getBufferSize()
    */
   @Override
   public int getBufferSize() {
      return ((MimeResponse)response).getBufferSize();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#getCharacterEncoding()
    */
   @Override
   public String getCharacterEncoding() {
      return ((MimeResponse)response).getCharacterEncoding();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#getContentType()
    */
   @Override
   public String getContentType() {
      return ((MimeResponse)response).getContentType();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#getLocale()
    */
   @Override
   public Locale getLocale() {
      return ((MimeResponse)response).getLocale();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#getPortletOutputStream()
    */
   @Override
   public OutputStream getPortletOutputStream() throws IOException {
      return ((MimeResponse)response).getPortletOutputStream();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#getWriter()
    */
   @Override
   public PrintWriter getWriter() throws IOException {
      return ((MimeResponse)response).getWriter();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#isCommitted()
    */
   @Override
   public boolean isCommitted() {
      return ((MimeResponse)response).isCommitted();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#reset()
    */
   @Override
   public void reset() {
      ((MimeResponse)response).reset();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#resetBuffer()
    */
   @Override
   public void resetBuffer() {
      ((MimeResponse)response).resetBuffer();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#setBufferSize(int)
    */
   @Override
   public void setBufferSize(int size) {
      ((MimeResponse)response).setBufferSize(size);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#getCacheControl()
    */
   @Override
   public CacheControl getCacheControl() {
      return ((MimeResponse)response).getCacheControl();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#createActionURL()
    */
   @Override
   public <T extends PortletURL & ActionURL> T createActionURL() throws IllegalStateException {
      return ((MimeResponse)response).createActionURL();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#createActionURL(javax.portlet.MimeResponse.Copy)
    */
   @Override
   public ActionURL createActionURL(Copy option) throws IllegalStateException {
      return ((MimeResponse)response).createActionURL(option);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#createRenderURL()
    */
   @Override
   public <T extends PortletURL & RenderURL> T createRenderURL() throws IllegalStateException {
      return ((MimeResponse)response).createRenderURL();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#createRenderURL(javax.portlet.MimeResponse.Copy)
    */
   @Override
   public RenderURL createRenderURL(Copy option) throws IllegalStateException {
      return ((MimeResponse)response).createRenderURL(option);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#createResourceURL()
    */
   @Override
   public ResourceURL createResourceURL() throws IllegalStateException {
      return ((MimeResponse)response).createResourceURL();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#setContentType(java.lang.String)
    */
   @Override
   public void setContentType(String type) {
      ((MimeResponse)response).setContentType(type);
   }

}
