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

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * <div class="changed_added_3_0">
 * The <code>PortletRequestDispatcherWrapper</code> provides a convenient 
 * implementation of the <code>PortletRequestDispatcher</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped request object.
 * </div>
 * 
 * @since 3.0
 */
public class PortletRequestDispatcherWrapper implements PortletRequestDispatcher {
   
   protected PortletRequestDispatcher wrapped;
   
   /**
    */
   public PortletRequestDispatcherWrapper(PortletRequestDispatcher wrapped) {
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
   public PortletRequestDispatcher getWrapped() {
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
   public void setWrapped(PortletRequestDispatcher wrapped) {
      if (wrapped == null) {
         throw new java.lang.IllegalArgumentException("Object to wrap is null");
      }
     this.wrapped = wrapped;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequestDispatcher#include(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
    */
   @Override
   public void include(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      wrapped.include(request, response);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequestDispatcher#include(javax.portlet.PortletRequest, javax.portlet.PortletResponse)
    */
   @Override
   public void include(PortletRequest request, PortletResponse response) throws PortletException, IOException {
      wrapped.include(request, response);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequestDispatcher#forward(javax.portlet.PortletRequest, javax.portlet.PortletResponse)
    */
   @Override
   public void forward(PortletRequest request, PortletResponse response) throws PortletException, IOException {
      wrapped.forward(request, response);
   }

}
