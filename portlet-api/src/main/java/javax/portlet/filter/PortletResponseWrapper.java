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

/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

package javax.portlet.filter;

import java.util.Collection;

import javax.portlet.PortletResponse;
import javax.servlet.http.Cookie;

/**
 * <span class="changed_modified_3_0">The</span> <code>PortletResponseWrapper</code> provides a convenient
 * implementation of the <code>PortletResponse</code> interface and is extended by other response wrappers. This class
 * implements the Wrapper or Decorator pattern. Methods default to calling through to the wrapped response object.
 * 
 * @since 2.0
 * @see PortletResponse
 */
public class PortletResponseWrapper implements PortletResponse {

   PortletResponse response;

   /**
    * Creates an <code>ActionResponse</code> adaptor wrapping the given response object.
    * 
    * @param response
    *           the action response to wrap
    * @throws java.lang.IllegalArgumentException
    *            if the response is <code>null</code>
    */
   public PortletResponseWrapper(PortletResponse response) {
      if (response == null)
         throw new java.lang.IllegalArgumentException("Response is null");

      this.response = response;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#addProperty(java.lang.String, java.lang.String)
    */
   @Override
   public void addProperty(String key, String value) {
      response.addProperty(key, value);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#encodeURL(java.lang.String)
    */
   @Override
   public String encodeURL(String path) {
      return response.encodeURL(path);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#getNamespace()
    */
   @Override
   public String getNamespace() {
      return response.getNamespace();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#setProperty(java.lang.String, java.lang.String)
    */
   @Override
   public void setProperty(String key, String value) {
      response.setProperty(key, value);
   }

   /**
    * Return the wrapped response object.
    * 
    * @return the wrapped response
    */
   public PortletResponse getResponse() {
      return response;
   }

   /**
    * Sets the response object being wrapped.
    * 
    * @param response
    *           the response to set
    * @throws java.lang.IllegalArgumentException
    *            if the response is null.
    */
   public void setResponse(PortletResponse response) {
      if (response == null)
         throw new java.lang.IllegalArgumentException("Response is null");

      this.response = response;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#addProperty(java.lang.String, org.w3c.dom.Element)
    */
   @Override
   public void addProperty(String key, org.w3c.dom.Element element) {
      response.addProperty(key, element);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#createElement(java.lang.String)
    */
   @Override
   public org.w3c.dom.Element createElement(String tagName) {
      return response.createElement(tagName);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#addProperty(javax.servlet.http.Cookie)
    */
   @Override
   public void addProperty(Cookie cookie) {
      response.addProperty(cookie);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#getProperty(java.lang.String)
    */
   @Override
   public String getProperty(String key) {
      return response.getProperty(key);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#getPropertyValues(java.lang.String)
    */
   @Override
   public Collection<String> getPropertyValues(String name) {
      return response.getPropertyValues(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#getPropertyNames()
    */
   @Override
   public Collection<String> getPropertyNames() {
      return response.getPropertyNames();
   }

}
