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
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.xml.namespace.QName;

/**
 * <div class="changed_added_3_0">
 * The <code>PortletConfigWrapper</code> provides a convenient 
 * implementation of the <code>PortletConfig</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped request object.
 * </div>
 *
 * @since 3.0
 */
public class PortletConfigWrapper implements PortletConfig {
   
   protected PortletConfig wrapped;
   
   /**
    */
   public PortletConfigWrapper(PortletConfig wrapped) {
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
   public PortletConfig getWrapped() {
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
   public void setWrapped(PortletConfig wrapped) {
      if (wrapped == null) {
         throw new java.lang.IllegalArgumentException("Object to wrap is null");
      }
     this.wrapped = wrapped;
   }


   /* (non-Javadoc)
    * @see javax.portlet.PortletConfig#getPortletName()
    */
   @Override
   public String getPortletName() {
      return wrapped.getPortletName();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletConfig#getPortletContext()
    */
   @Override
   public PortletContext getPortletContext() {
      return wrapped.getPortletContext();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletConfig#getResourceBundle(java.util.Locale)
    */
   @Override
   public ResourceBundle getResourceBundle(Locale locale) {
      return wrapped.getResourceBundle(locale);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletConfig#getInitParameter(java.lang.String)
    */
   @Override
   public String getInitParameter(String name) {
      return wrapped.getInitParameter(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletConfig#getInitParameterNames()
    */
   @Override
   public Enumeration<String> getInitParameterNames() {
      return wrapped.getInitParameterNames();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletConfig#getPublicRenderParameterNames()
    */
   @Override
   public Enumeration<String> getPublicRenderParameterNames() {
      return wrapped.getPublicRenderParameterNames();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletConfig#getDefaultNamespace()
    */
   @Override
   public String getDefaultNamespace() {
      return wrapped.getDefaultNamespace();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletConfig#getPublishingEventQNames()
    */
   @Override
   public Enumeration<QName> getPublishingEventQNames() {
      return wrapped.getPublishingEventQNames();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletConfig#getProcessingEventQNames()
    */
   @Override
   public Enumeration<QName> getProcessingEventQNames() {
      return wrapped.getProcessingEventQNames();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletConfig#getSupportedLocales()
    */
   @Override
   public Enumeration<Locale> getSupportedLocales() {
      return wrapped.getSupportedLocales();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletConfig#getContainerRuntimeOptions()
    */
   @Override
   public Map<String, String[]> getContainerRuntimeOptions() {
      return wrapped.getContainerRuntimeOptions();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletConfig#getPortletModes(java.lang.String)
    */
   @Override
   public Enumeration<PortletMode> getPortletModes(String mimeType) {
      return wrapped.getPortletModes(mimeType);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletConfig#getWindowStates(java.lang.String)
    */
   @Override
   public Enumeration<WindowState> getWindowStates(String mimeType) {
      return wrapped.getWindowStates(mimeType);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletConfig#getPublicRenderParameterDefinitions()
    */
   @Override
   public Map<String, QName> getPublicRenderParameterDefinitions() {
      return wrapped.getPublicRenderParameterDefinitions();
   }

}
