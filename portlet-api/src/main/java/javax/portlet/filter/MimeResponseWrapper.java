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
 * <div class="changed_added_3_0">
 * The <code>MimeResponseWrapper</code> provides a convenient 
 * implementation of the <code>MimeResponse</code> interface 
 * that can be subclassed by developers wishing to adapt the response.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped response object.
 * </div>
 */
public class MimeResponseWrapper extends PortletResponseWrapper implements
MimeResponse {

   MimeResponse response;

   /**
    * @param response
    */
   public MimeResponseWrapper(MimeResponse response) {
      super(response);
      this.response = response;
   }

   /**
    * Return the wrapped response object.
    * 
    * @return the wrapped response
    */
   public MimeResponse getResponse() {
      return response;
   }

   /**
    * Sets the response object being wrapped.
    * 
    * @param response the response to set
    * @throws java.lang.IllegalArgumentException   if the response is null.
    */
   public void setResponse(MimeResponse response) {
      if ( response == null) {
         throw new java.lang.IllegalArgumentException("Response is null");
      }
      super.setResponse(response);
      this.response = response;
   }

   /**
    * The default behavior of this method is to call 
    * <code>flushBuffer()</code> on the wrapped response object.
    */ 
   public void flushBuffer() throws IOException {
      response.flushBuffer();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getBufferSize()</code> on the wrapped response object.
    */
   public int getBufferSize() {
      return response.getBufferSize();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getCharacterEncoding()</code> on the wrapped response object.
    */
   public String getCharacterEncoding() {
      return response.getCharacterEncoding();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getContentType()</code> on the wrapped response object.
    */
   public String getContentType() {
      return response.getContentType();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getLocale()</code> on the wrapped response object.
    */
   public Locale getLocale() {
      return response.getLocale();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getPortletOutputStream()</code> on the wrapped response object.
    */
   public OutputStream getPortletOutputStream() throws IOException {
      return response.getPortletOutputStream();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getWriter()</code> on the wrapped response object.
    */
   public PrintWriter getWriter() throws IOException {
      return response.getWriter();
   }

   /**
    * The default behavior of this method is to call 
    * <code>isCommitted()</code> on the wrapped response object.
    */
   public boolean isCommitted() {
      return response.isCommitted();
   }

   /**
    * The default behavior of this method is to call 
    * <code>reset()</code> on the wrapped response object.
    */
   public void reset() {
      response.reset();
   }

   /**
    * The default behavior of this method is to call 
    * <code>resetBuffer()</code> on the wrapped response object.
    */
   public void resetBuffer() {
      response.resetBuffer();
   }

   /**
    * The default behavior of this method is to call 
    * <code>setBufferSize(size)</code> on the wrapped response object.
    */
   public void setBufferSize(int size) {
      response.setBufferSize(size);
   }

   /**
    * The default behavior of this method is to call 
    * <code>getCacheControl()</code> on the wrapped response object.
    */
   public CacheControl getCacheControl() {
      return response.getCacheControl();
   }

   /**
    *  The default behavior of this method is to call 
    * <code>createActionURL()</code> on the wrapped response object.
    */
   public <T extends PortletURL & ActionURL> T createActionURL() throws IllegalStateException {
      return response.createActionURL();
   }

   /**
    *  <span class="changed_added_3_0">The default behavior of this method is to call 
    * <code>createActionURL(ParameterCopyOption)</code> on the wrapped response object.</span>
    */
   public ActionURL createActionURL(Copy option) throws IllegalStateException {
      return response.createActionURL(option);
   }

   /**
    *  The default behavior of this method is to call 
    * <code>createRenderURL()</code> on the wrapped response object.
    */
   public <T extends PortletURL & RenderURL> T createRenderURL() throws IllegalStateException {
      return response.createRenderURL();
   }

   /**
    *  <span class="changed_added_3_0">The default behavior of this method is to call 
    * <code>createRenderURL(ParameterCopyOption)</code> on the wrapped response object.</span>
    */
   public RenderURL createRenderURL(Copy option) throws IllegalStateException {
      return response.createRenderURL(option);
   }

   /**
    *  The default behavior of this method is to call 
    * <code>createResourceURL()</code> on the wrapped response object.
    */
   public ResourceURL createResourceURL() throws IllegalStateException {
      return response.createResourceURL();
   }

   /**
    * The default behavior of this method is to call 
    * <code>setContentType(type)</code> on the wrapped response object.
    */
   public void setContentType(String type) {
      response.setContentType(type);
   }

}
