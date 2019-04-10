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

import java.util.Collection;

import javax.portlet.PortletResponse;
import javax.servlet.http.Cookie;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

/**
 * @author Scott
 *
 */
public class MockPortletResponse implements PortletResponse {

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#addProperty(javax.servlet.http.Cookie)
    */
   @Override
   public void addProperty(Cookie arg0) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#addProperty(java.lang.String, java.lang.String)
    */
   @Override
   public void addProperty(String arg0, String arg1) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#addProperty(java.lang.String, org.w3c.dom.Element)
    */
   @Override
   public void addProperty(String arg0, Element arg1) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#createElement(java.lang.String)
    */
   @Override
   public Element createElement(String arg0) throws DOMException {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#encodeURL(java.lang.String)
    */
   @Override
   public String encodeURL(String arg0) {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#getNamespace()
    */
   @Override
   public String getNamespace() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletResponse#setProperty(java.lang.String, java.lang.String)
    */
   @Override
   public void setProperty(String arg0, String arg1) {
   }

   @Override
   public String getProperty(String key) {
      return null;
   }

   @Override
   public Collection<String> getPropertyValues(String name) {
      return null;
   }

   @Override
   public Collection<String> getPropertyNames() {
      return null;
   }

}
