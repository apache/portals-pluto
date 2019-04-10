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

import javax.portlet.MutableResourceParameters;
import javax.portlet.ResourceURL;

/**
 * <div class="changed_added_3_0">
 * The <code>ResourceURLWrapper</code> provides a convenient 
 * implementation of the <code>ResourceURL</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped request object.
 * </div>
 *
 * @since 3.0
 */
public class ResourceURLWrapper extends BaseURLWrapper implements ResourceURL {
   
   /**
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the ResourceURL is null.
    */
   public ResourceURLWrapper(ResourceURL wrapped) {
      super(wrapped);
   }
   

   /**
    * Gets the wrapped object.
    * 
    * @return the wrapped object.
    */
   public ResourceURL getWrapped() {
      return (ResourceURL) wrapped;
   }


   /**
    * Sets the wrapped object.
    * 
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the ResourceURL is null.
    */
   public void setWrapped(ResourceURL wrapped) {
      super.setWrapped(wrapped);
   }

   /* (non-Javadoc)
    * @see javax.portlet.ResourceURL#getResourceParameters()
    */
   @Override
   public MutableResourceParameters getResourceParameters() {
      return ((ResourceURL)wrapped).getResourceParameters();
   }

   /* (non-Javadoc)
    * @see javax.portlet.ResourceURL#setResourceID(java.lang.String)
    */
   @Override
   public void setResourceID(String resourceID) {
      ((ResourceURL)wrapped).setResourceID(resourceID);
   }

   /* (non-Javadoc)
    * @see javax.portlet.ResourceURL#getResourceID()
    */
   @Override
   public String getResourceID() {
      return ((ResourceURL)wrapped).getResourceID();
   }

   /* (non-Javadoc)
    * @see javax.portlet.ResourceURL#getCacheability()
    */
   @Override
   public String getCacheability() {
      return ((ResourceURL)wrapped).getCacheability();
   }

   /* (non-Javadoc)
    * @see javax.portlet.ResourceURL#setCacheability(java.lang.String)
    */
   @Override
   public void setCacheability(String cacheLevel) {
      ((ResourceURL)wrapped).setCacheability(cacheLevel);
   }

}
