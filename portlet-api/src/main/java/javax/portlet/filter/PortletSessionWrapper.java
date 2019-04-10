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

import java.util.Enumeration;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.portlet.PortletSession;

/**
 * <div class="changed_added_3_0">
 * The <code>PortletSessionWrapper</code> provides a convenient 
 * implementation of the <code>PortletSession</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped request object.
 * </div>
 *
 * @since 3.0
 */
public class PortletSessionWrapper implements PortletSession {
   
   protected PortletSession wrapped;
   
   /**
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the PortletSession is null.
    */
   public PortletSessionWrapper(PortletSession wrapped) {
      if (wrapped == null) {
         throw new java.lang.IllegalArgumentException("Object to wrap is null");
      }
      this.wrapped = wrapped;
   }
   

   /**
    * <div class="changed_added_3_0">
    * Gets the wrapped object.
    * </div>
    * 
    * @return the wrapped object.
    */
   public PortletSession getWrapped() {
      return wrapped;
   }


   /**
    * <div class="changed_added_3_0">
    * Sets the wrapped object.
    * </div>
    * 
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the PortletSession is null.
    */
   public void setWrapped(PortletSession wrapped) {
      if (wrapped == null) {
         throw new java.lang.IllegalArgumentException("Object to wrap is null");
      }
     this.wrapped = wrapped;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getAttribute(java.lang.String)
    */
   @Override
   public Object getAttribute(String name) {
      return wrapped.getAttribute(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getAttribute(java.lang.String, int)
    */
   @Override
   public Object getAttribute(String name, int scope) {
      return wrapped.getAttribute(name, scope);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getAttributeNames()
    */
   @Override
   public Enumeration<String> getAttributeNames() {
      return wrapped.getAttributeNames();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getAttributeNames(int)
    */
   @Override
   public Enumeration<String> getAttributeNames(int scope) {
      return wrapped.getAttributeNames(scope);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getCreationTime()
    */
   @Override
   public long getCreationTime() {
      return wrapped.getCreationTime();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getId()
    */
   @Override
   public String getId() {
      return wrapped.getId();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getLastAccessedTime()
    */
   @Override
   public long getLastAccessedTime() {
      return wrapped.getLastAccessedTime();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getMaxInactiveInterval()
    */
   @Override
   public int getMaxInactiveInterval() {
      return wrapped.getMaxInactiveInterval();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#invalidate()
    */
   @Override
   public void invalidate() {
      wrapped.invalidate();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#isNew()
    */
   @Override
   public boolean isNew() {
      return wrapped.isNew();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#removeAttribute(java.lang.String)
    */
   @Override
   public void removeAttribute(String name) {
      wrapped.removeAttribute(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#removeAttribute(java.lang.String, int)
    */
   @Override
   public void removeAttribute(String name, int scope) {
      wrapped.removeAttribute(name, scope);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#setAttribute(java.lang.String, java.lang.Object)
    */
   @Override
   public void setAttribute(String name, Object value) {
      wrapped.setAttribute(name, value);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#setAttribute(java.lang.String, java.lang.Object, int)
    */
   @Override
   public void setAttribute(String name, Object value, int scope) {
      wrapped.setAttribute(name, value, scope);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#setMaxInactiveInterval(int)
    */
   @Override
   public void setMaxInactiveInterval(int interval) {
      wrapped.setMaxInactiveInterval(interval);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getPortletContext()
    */
   @Override
   public PortletContext getPortletContext() {
      return wrapped.getPortletContext();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getAttributeMap()
    */
   @Override
   public Map<String, Object> getAttributeMap() {
      return wrapped.getAttributeMap();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletSession#getAttributeMap(int)
    */
   @Override
   public Map<String, Object> getAttributeMap(int scope) {
      return wrapped.getAttributeMap(scope);
   }

}
