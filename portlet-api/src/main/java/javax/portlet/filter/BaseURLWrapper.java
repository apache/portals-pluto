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
import java.io.Writer;
import java.util.Map;

import javax.portlet.BaseURL;
import javax.portlet.PortletSecurityException;

/**
 * <div class="changed_added_3_0">
 * The <code>BaseURLWrapper</code> provides a convenient 
 * implementation of the <code>BaseURL</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped object.
 * </div>
 *
 * @since 3.0
 */
public class BaseURLWrapper extends RenderStateWrapper implements BaseURL {
   
   /**
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the BaseURL is null.
    */
   public BaseURLWrapper(BaseURL wrapped) {
      super(wrapped);
   }
   

   /**
    * Gets the wrapped object.
    * 
    * @return the wrapped object.
    */
   @Override
   public BaseURL getWrapped() {
      return ((BaseURL)wrapped);
   }


   /**
    * Sets the wrapped object.
    * 
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the BaseURL is null.
    */
   public void setWrapped(BaseURL wrapped) {
      if (wrapped == null) {
         throw new java.lang.IllegalArgumentException("BaseURL to wrap is null");
      }
     this.wrapped = wrapped;
   }

   /* (non-Javadoc)
    * @see javax.portlet.BaseURL#setParameter(java.lang.String, java.lang.String)
    */
   @Deprecated
   @Override
   public void setParameter(String name, String value) {
      ((BaseURL)wrapped).setParameter(name, value);
   }

   /* (non-Javadoc)
    * @see javax.portlet.BaseURL#setParameter(java.lang.String, java.lang.String[])
    */
   @Deprecated
   @Override
   public void setParameter(String name, String... values) {
      ((BaseURL)wrapped).setParameter(name, values);
   }

   /* (non-Javadoc)
    * @see javax.portlet.BaseURL#setParameters(java.util.Map)
    */
   @Deprecated
   @Override
   public void setParameters(Map<String, String[]> parameters) {
      ((BaseURL)wrapped).setParameters(parameters);
   }

   /* (non-Javadoc)
    * @see javax.portlet.BaseURL#setSecure(boolean)
    */
   @Override
   public void setSecure(boolean secure) throws PortletSecurityException {
      ((BaseURL)wrapped).setSecure(secure);
   }

   /* (non-Javadoc)
    * @see javax.portlet.BaseURL#getParameterMap()
    */
   @Deprecated
   @Override
   public Map<String, String[]> getParameterMap() {
      return ((BaseURL)wrapped).getParameterMap();
   }

   /* (non-Javadoc)
    * @see javax.portlet.BaseURL#write(java.io.Writer)
    */
   @Override
   public void write(Writer out) throws IOException {
      ((BaseURL)wrapped).write(out);
   }

   /* (non-Javadoc)
    * @see javax.portlet.BaseURL#write(java.io.Writer, boolean)
    */
   @Override
   public void write(Writer out, boolean escapeXML) throws IOException {
      ((BaseURL)wrapped).write(out, escapeXML);
   }

   /* (non-Javadoc)
    * @see javax.portlet.BaseURL#append(java.lang.Appendable)
    */
   @Override
   public Appendable append(Appendable out) throws IOException {
      return ((BaseURL)wrapped).append(out);
   }

   /* (non-Javadoc)
    * @see javax.portlet.BaseURL#append(java.lang.Appendable, boolean)
    */
   @Override
   public Appendable append(Appendable out, boolean escapeXML) throws IOException {
      return ((BaseURL)wrapped).append(out, escapeXML);
   }

   /* (non-Javadoc)
    * @see javax.portlet.BaseURL#addProperty(java.lang.String, java.lang.String)
    */
   @Override
   public void addProperty(String key, String value) {
      ((BaseURL)wrapped).addProperty(key, value);
   }

   /* (non-Javadoc)
    * @see javax.portlet.BaseURL#setProperty(java.lang.String, java.lang.String)
    */
   @Override
   public void setProperty(String key, String value) {
      ((BaseURL)wrapped).setProperty(key, value);
   }

   /* (non-Javadoc)
    * @see javax.portlet.BaseURL#toString()
    */
   @Override
   public String toString() {
      return wrapped.toString();
   }
}
