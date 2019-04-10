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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.portlet.PortletSession;

/**
 * @author Scott Nicklous
 *
 */
public class MockPortletSession implements PortletSession {
   
   private Map<String, Object> attrs = new HashMap<String, Object>();

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getAttribute(java.lang.String)
    */
   @Override
   public Object getAttribute(String arg0) {
      return attrs.get(arg0);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getAttribute(java.lang.String, int)
    */
   @Override
   public Object getAttribute(String arg0, int arg1) {
      return attrs.get(arg0);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getAttributeMap()
    */
   @Override
   public Map<String, Object> getAttributeMap() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getAttributeMap(int)
    */
   @Override
   public Map<String, Object> getAttributeMap(int arg0) {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getAttributeNames()
    */
   @Override
   public Enumeration<String> getAttributeNames() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getAttributeNames(int)
    */
   @Override
   public Enumeration<String> getAttributeNames(int arg0) {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getCreationTime()
    */
   @Override
   public long getCreationTime() {
      return 0;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getId()
    */
   @Override
   public String getId() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getLastAccessedTime()
    */
   @Override
   public long getLastAccessedTime() {
      return 0;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getMaxInactiveInterval()
    */
   @Override
   public int getMaxInactiveInterval() {
      return 0;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getPortletContext()
    */
   @Override
   public PortletContext getPortletContext() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#invalidate()
    */
   @Override
   public void invalidate() {
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#isNew()
    */
   @Override
   public boolean isNew() {
      return false;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#removeAttribute(java.lang.String)
    */
   @Override
   public void removeAttribute(String arg0) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#removeAttribute(java.lang.String, int)
    */
   @Override
   public void removeAttribute(String arg0, int arg1) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#setAttribute(java.lang.String, java.lang.Object)
    */
   @Override
   public void setAttribute(String arg0, Object arg1) {
      attrs.put(arg0, arg1);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#setAttribute(java.lang.String, java.lang.Object, int)
    */
   @Override
   public void setAttribute(String arg0, Object arg1, int arg2) {
      attrs.put(arg0, arg1);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#setMaxInactiveInterval(int)
    */
   @Override
   public void setMaxInactiveInterval(int arg0) {
   }

}
