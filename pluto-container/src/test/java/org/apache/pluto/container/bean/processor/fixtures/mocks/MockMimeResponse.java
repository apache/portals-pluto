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


package org.apache.pluto.container.bean.processor.fixtures.mocks;

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
 * @author Scott Nicklous
 *
 */
public class MockMimeResponse extends MockPortletResponse implements MimeResponse {

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#createActionURL()
    */
   @Override
   public <T extends PortletURL & ActionURL> T createActionURL() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#createActionURL(javax.portlet.MimeResponse.Copy)
    */
   @Override
   public ActionURL createActionURL(Copy arg0) {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#createRenderURL()
    */
   @Override
   public <T extends PortletURL & RenderURL> T createRenderURL() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#createRenderURL(javax.portlet.MimeResponse.Copy)
    */
   @Override
   public RenderURL createRenderURL(Copy arg0) {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#createResourceURL()
    */
   @Override
   public ResourceURL createResourceURL() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#flushBuffer()
    */
   @Override
   public void flushBuffer() throws IOException {

   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#getBufferSize()
    */
   @Override
   public int getBufferSize() {
      return 0;
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#getCacheControl()
    */
   @Override
   public CacheControl getCacheControl() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#getCharacterEncoding()
    */
   @Override
   public String getCharacterEncoding() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#getContentType()
    */
   @Override
   public String getContentType() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#getLocale()
    */
   @Override
   public Locale getLocale() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#getPortletOutputStream()
    */
   @Override
   public OutputStream getPortletOutputStream() throws IOException {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#getWriter()
    */
   @Override
   public PrintWriter getWriter() throws IOException {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#isCommitted()
    */
   @Override
   public boolean isCommitted() {
      return false;
   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#reset()
    */
   @Override
   public void reset() {

   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#resetBuffer()
    */
   @Override
   public void resetBuffer() {

   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#setBufferSize(int)
    */
   @Override
   public void setBufferSize(int arg0) {

   }

   /* (non-Javadoc)
    * @see javax.portlet.MimeResponse#setContentType(java.lang.String)
    */
   @Override
   public void setContentType(String arg0) {

   }

}
