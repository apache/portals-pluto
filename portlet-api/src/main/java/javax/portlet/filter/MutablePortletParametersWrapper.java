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

import javax.portlet.Mutable;
import javax.portlet.MutablePortletParameters;
import javax.portlet.PortletParameters;

/**
 * <div class="changed_added_3_0">
 * The <code>MutablePortletParametersWrapper</code> provides a convenient 
 * implementation of the <code>MutablePortletParameters</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped request object.
 * </div>
 *
 * @since 3.0
 */
public class MutablePortletParametersWrapper extends PortletParametersWrapper implements MutablePortletParameters,
      Mutable {
   
   /**
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the MutablePortletParameters is null.
    */
   public MutablePortletParametersWrapper(MutablePortletParameters wrapped) {
      super(wrapped);
   }
   

   /**
    * Gets the wrapped object.
    * 
    * @return the wrapped object.
    */
   public MutablePortletParameters getWrapped() {
      return (MutablePortletParameters) wrapped;
   }


   /**
    * Sets the wrapped object.
    * 
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the MutablePortletParameters is null.
    */
   public void setWrapped(MutablePortletParameters wrapped) {
      super.setWrapped(wrapped);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutablePortletParameters#setValue(java.lang.String, java.lang.String)
    */
   @Override
   public String setValue(String name, String value) {
      return ((MutablePortletParameters)wrapped).setValue(name, value);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutablePortletParameters#setValues(java.lang.String, java.lang.String[])
    */
   @Override
   public String[] setValues(String name, String... values) {
      return ((MutablePortletParameters)wrapped).setValues(name, values);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutablePortletParameters#removeParameter(java.lang.String)
    */
   @Override
   public boolean removeParameter(String name) {
      return ((MutablePortletParameters)wrapped).removeParameter(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutablePortletParameters#set(javax.portlet.PortletParameters)
    */
   @Override
   public MutablePortletParameters set(PortletParameters params) {
      return ((MutablePortletParameters)wrapped).set(params);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutablePortletParameters#add(javax.portlet.PortletParameters)
    */
   @Override
   public MutablePortletParameters add(PortletParameters params) {
      return ((MutablePortletParameters)wrapped).add(params);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutablePortletParameters#clear()
    */
   @Override
   public void clear() {
      ((MutablePortletParameters)wrapped).clear();
   }

}
