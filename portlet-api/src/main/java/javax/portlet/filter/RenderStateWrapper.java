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

import javax.portlet.PortletMode;
import javax.portlet.RenderState;
import javax.portlet.RenderParameters;
import javax.portlet.WindowState;

/**
 * <div class="changed_added_3_0">
 * The <code>RenderStateWrapper</code> provides a convenient 
 * implementation of the <code>RenderState</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped request object.
 * </div>
 *
 * @since 3.0
 */
public class RenderStateWrapper implements RenderState {
   
   protected RenderState wrapped;
   
   /**
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the RenderState is null.
    */
   public RenderStateWrapper(RenderState wrapped) {
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
   public RenderState getWrapped() {
      return wrapped;
   }


   /**
    * <div class="changed_added_3_0">
    * Sets the wrapped object.
    * </div>
    * 
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the RenderState is null.
    */
   public void setWrapped(RenderState wrapped) {
      if (wrapped == null) {
         throw new java.lang.IllegalArgumentException("Object to wrap is null");
      }
     this.wrapped = wrapped;
   }

   /* (non-Javadoc)
    * @see javax.portlet.RenderState#getRenderParameters()
    */
   @Override
   public RenderParameters getRenderParameters() {
      return wrapped.getRenderParameters();
   }

   /* (non-Javadoc)
    * @see javax.portlet.RenderState#getPortletMode()
    */
   @Override
   public PortletMode getPortletMode() {
      return wrapped.getPortletMode();
   }

   /* (non-Javadoc)
    * @see javax.portlet.RenderState#getWindowState()
    */
   @Override
   public WindowState getWindowState() {
      return wrapped.getWindowState();
   }

}
