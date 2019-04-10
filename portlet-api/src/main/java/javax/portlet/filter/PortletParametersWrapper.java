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

import java.util.Set;

import javax.portlet.MutablePortletParameters;
import javax.portlet.PortletParameters;

/**
 * <div class="changed_added_3_0">
 * The <code>PortletParametersWrapper</code> provides a convenient 
 * implementation of the <code>PortletParameters</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped request object.
 * </div>
 *
 * @since 3.0
 */
public class PortletParametersWrapper implements PortletParameters {
   
   protected PortletParameters wrapped;
   
   /**
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the PortletParameters is null.
    */
   public PortletParametersWrapper(PortletParameters wrapped) {
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
   public PortletParameters getWrapped() {
      return wrapped;
   }


   /**
    * <div class="changed_added_3_0">
    * Sets the wrapped object.
    * </div>
    * 
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the PortletParameters is null.
    */
   public void setWrapped(PortletParameters wrapped) {
      if (wrapped == null) {
         throw new java.lang.IllegalArgumentException("Object to wrap is null");
      }
     this.wrapped = wrapped;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletParameters#getValue(java.lang.String)
    */
   @Override
   public String getValue(String name) {
      return wrapped.getValue(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletParameters#getNames()
    */
   @Override
   public Set<String> getNames() {
      return wrapped.getNames();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletParameters#getValues(java.lang.String)
    */
   @Override
   public String[] getValues(String name) {
      return wrapped.getValues(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletParameters#isEmpty()
    */
   @Override
   public boolean isEmpty() {
      return wrapped.isEmpty();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletParameters#size()
    */
   @Override
   public int size() {
      return wrapped.size();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletParameters#clone()
    */
   @Override
   public MutablePortletParameters clone() {
      return wrapped.clone();
   }

}
