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

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Set;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequestDispatcher;

/**
 * <div class="changed_added_3_0">
 * The <code>PortletContextWrapper</code> provides a convenient 
 * implementation of the <code>PortletContext</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped request object.
 * </div>
 *
 * @since 3.0
 */
public class PortletContextWrapper implements PortletContext {
   
   protected PortletContext wrapped;
   
   /**
    */
   public PortletContextWrapper(PortletContext wrapped) {
      if (wrapped == null) {
         throw new java.lang.IllegalArgumentException("PortletContext to wrap is null");
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
   public PortletContext getPortletContext() {
      return wrapped;
   }


   /**
    * <div class="changed_added_3_0">
    * Sets the wrapped object.
    * </div>
    * 
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the PortletContext is null.
    */
   public void setPortletContext(PortletContext wrapped) {
      if (wrapped == null) {
         throw new java.lang.IllegalArgumentException("PortletContext to wrap is null");
      }
     this.wrapped = wrapped;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getServerInfo()
    */
   @Override
   public String getServerInfo() {
      return wrapped.getServerInfo();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getRequestDispatcher(java.lang.String)
    */
   @Override
   public PortletRequestDispatcher getRequestDispatcher(String path) {
      return wrapped.getRequestDispatcher(path);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getNamedDispatcher(java.lang.String)
    */
   @Override
   public PortletRequestDispatcher getNamedDispatcher(String name) {
      return wrapped.getNamedDispatcher(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getResourceAsStream(java.lang.String)
    */
   @Override
   public InputStream getResourceAsStream(String path) {
      return wrapped.getResourceAsStream(path);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getMajorVersion()
    */
   @Override
   public int getMajorVersion() {
      return wrapped.getMajorVersion();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getMinorVersion()
    */
   @Override
   public int getMinorVersion() {
      return wrapped.getMinorVersion();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getMimeType(java.lang.String)
    */
   @Override
   public String getMimeType(String file) {
      return wrapped.getMimeType(file);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getRealPath(java.lang.String)
    */
   @Override
   public String getRealPath(String path) {
      return wrapped.getRealPath(path);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getResourcePaths(java.lang.String)
    */
   @Override
   public Set<String> getResourcePaths(String path) {
      return wrapped.getResourcePaths(path);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getResource(java.lang.String)
    */
   @Override
   public URL getResource(String path) throws MalformedURLException {
      return wrapped.getResource(path);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getAttribute(java.lang.String)
    */
   @Override
   public Object getAttribute(String name) {
      return wrapped.getAttribute(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getAttributeNames()
    */
   @Override
   public Enumeration<String> getAttributeNames() {
      return wrapped.getAttributeNames();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getInitParameter(java.lang.String)
    */
   @Override
   public String getInitParameter(String name) {
      return wrapped.getInitParameter(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getInitParameterNames()
    */
   @Override
   public Enumeration<String> getInitParameterNames() {
      return wrapped.getInitParameterNames();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#log(java.lang.String)
    */
   @Override
   public void log(String msg) {
      wrapped.log(msg);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#log(java.lang.String, java.lang.Throwable)
    */
   @Override
   public void log(String message, Throwable throwable) {
      wrapped.log(message, throwable);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#removeAttribute(java.lang.String)
    */
   @Override
   public void removeAttribute(String name) {
      wrapped.removeAttribute(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#setAttribute(java.lang.String, java.lang.Object)
    */
   @Override
   public void setAttribute(String name, Object object) {
      wrapped.setAttribute(name, object);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getPortletContextName()
    */
   @Override
   public String getPortletContextName() {
      return wrapped.getPortletContextName();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getContainerRuntimeOptions()
    */
   @Override
   public Enumeration<String> getContainerRuntimeOptions() {
      return wrapped.getContainerRuntimeOptions();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getEffectiveMajorVersion()
    */
   @Override
   public int getEffectiveMajorVersion() {
      return wrapped.getEffectiveMajorVersion();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getEffectiveMinorVersion()
    */
   @Override
   public int getEffectiveMinorVersion() {
      return wrapped.getEffectiveMinorVersion();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getContextPath()
    */
   @Override
   public String getContextPath() {
      return wrapped.getContextPath();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletContext#getClassLoader()
    */
   @Override
   public ClassLoader getClassLoader() {
      return wrapped.getClassLoader();
   }

}
