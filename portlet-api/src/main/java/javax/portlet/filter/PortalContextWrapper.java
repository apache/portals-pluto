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

import javax.portlet.PortalContext;
import javax.portlet.PortletMode;
import javax.portlet.WindowState;

/**
 * <div class="changed_added_3_0">
 * The <code>PortalContextWrapper</code> provides a convenient 
 * implementation of the <code>PortalContext</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped object.
 * </div>
 *
 * @since 3.0
 */
public class PortalContextWrapper implements PortalContext {
   
   protected PortalContext wrapped;
   
   /**
    */
   public PortalContextWrapper(PortalContext wrapped) {
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
   public PortalContext getWrapped() {
      return wrapped;
   }


   /**
    * <div class="changed_added_3_0">
    * Sets the wrapped object.
    * </div>
    * 
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the request is null.
    */
   public void setWrapped(PortalContext wrapped) {
      if (wrapped == null) {
         throw new java.lang.IllegalArgumentException("Object to wrap is null");
      }
     this.wrapped = wrapped;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortalContext#getProperty(java.lang.String)
    */
   @Override
   public String getProperty(String name) {
      return wrapped.getProperty(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortalContext#getPropertyNames()
    */
   @Override
   public Enumeration<String> getPropertyNames() {
      return wrapped.getPropertyNames();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortalContext#getSupportedPortletModes()
    */
   @Override
   public Enumeration<PortletMode> getSupportedPortletModes() {
      return wrapped.getSupportedPortletModes();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortalContext#getSupportedWindowStates()
    */
   @Override
   public Enumeration<WindowState> getSupportedWindowStates() {
      return wrapped.getSupportedWindowStates();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortalContext#getPortalInfo()
    */
   @Override
   public String getPortalInfo() {
      return wrapped.getPortalInfo();
   }

}
