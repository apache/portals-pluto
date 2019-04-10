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
import javax.portlet.MutableRenderState;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

/**
 * <div class="changed_added_3_0">
 * The <code>MutableRenderStateWrapper</code> provides a convenient 
 * implementation of the <code>MutableRenderState</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped request object.
 * </div>
 *
 * @since 3.0
 */
public class MutableRenderStateWrapper extends RenderStateWrapper implements MutableRenderState, Mutable {
   
   /**
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the MutableRenderState is null.
    */
   public MutableRenderStateWrapper(MutableRenderState wrapped) {
      super(wrapped);
   }
   

   /**
    * Gets the wrapped object.
    * 
    * @return the wrapped object.
    */
   public MutableRenderState getWrapped() {
      return (MutableRenderState) wrapped;
   }


   /**
    * Sets the wrapped object.
    * 
    * @param wrapped   the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the MutableRenderState is null.
    */
   public void setWrapped(MutableRenderState wrapped) {
      super.setWrapped(wrapped);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutableRenderState#getRenderParameters()
    */
   @Override
   public MutableRenderParameters getRenderParameters() {
      return ((MutableRenderState)wrapped).getRenderParameters();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutableRenderState#setWindowState(javax.portlet.WindowState)
    */
   @Override
   public void setWindowState(WindowState windowState) throws WindowStateException {
      ((MutableRenderState)wrapped).setWindowState(windowState);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutableRenderState#setPortletMode(javax.portlet.PortletMode)
    */
   @Override
   public void setPortletMode(PortletMode portletMode) throws PortletModeException {
      ((MutableRenderState)wrapped).setPortletMode(portletMode);
   }

}
