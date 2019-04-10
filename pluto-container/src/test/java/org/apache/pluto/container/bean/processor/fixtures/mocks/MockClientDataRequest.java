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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.portlet.ClientDataRequest;
import javax.portlet.PortletException;
import javax.servlet.http.Part;

/**
 * @author Scott
 *
 */
public class MockClientDataRequest extends MockPortletRequest implements ClientDataRequest {

   /* (non-Javadoc)
    * @see javax.portlet.ClientDataRequest#getCharacterEncoding()
    */
   @Override
   public String getCharacterEncoding() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ClientDataRequest#getContentLength()
    */
   @Override
   public int getContentLength() {
      return 0;
   }

   @Override
   public long getContentLengthLong() {
      return 0;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ClientDataRequest#getContentType()
    */
   @Override
   public String getContentType() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ClientDataRequest#getMethod()
    */
   @Override
   public String getMethod() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ClientDataRequest#getPortletInputStream()
    */
   @Override
   public InputStream getPortletInputStream() throws IOException {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ClientDataRequest#getReader()
    */
   @Override
   public BufferedReader getReader() throws UnsupportedEncodingException, IOException {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ClientDataRequest#setCharacterEncoding(java.lang.String)
    */
   @Override
   public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
   }

   @Override
   public Part getPart(String name) throws IOException, PortletException {
      return null;
   }

   @Override
   public Collection<Part> getParts() throws IOException, PortletException {
      return null;
   }

}
