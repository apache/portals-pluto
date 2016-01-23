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
import javax.portlet.MutablePortletState;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

/**
 * <div class="changed_added_3_0">
 * The <code>MutablePortletStateWrapper</code> provides a convenient 
 * implementation of the <code>MutablePortletState</code> interface 
 * that can be subclassed by developers wishing to adapt the request.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped request object.
 * </div>
 * 
 * @author Scott Nicklous
 *
 */
public class MutablePortletStateWrapper extends PortletStateWrapper implements MutablePortletState, Mutable {
   
   /**
    * @param the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the MutablePortletState is null.
    */
   public MutablePortletStateWrapper(MutablePortletState wrapped) {
      super(wrapped);
   }
   

   /**
    * Gets the wrapped object.
    * 
    * @return the wrapped object.
    */
   public MutablePortletState getWrapped() {
      return (MutablePortletState) wrapped;
   }


   /**
    * Sets the wrapped object.
    * 
    * @param the wrapped object to set.
    * @throws java.lang.IllegalArgumentException   if the MutablePortletState is null.
    */
   public void setWrapped(MutablePortletState wrapped) {
      super.setWrapped(wrapped);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutablePortletState#getRenderParameters()
    */
   @Override
   public MutableRenderParameters getRenderParameters() {
      return ((MutablePortletState)wrapped).getRenderParameters();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutablePortletState#setWindowState(javax.portlet.WindowState)
    */
   @Override
   public void setWindowState(WindowState windowState) throws WindowStateException {
      ((MutablePortletState)wrapped).setWindowState(windowState);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutablePortletState#setPortletMode(javax.portlet.PortletMode)
    */
   @Override
   public void setPortletMode(PortletMode portletMode) throws PortletModeException {
      ((MutablePortletState)wrapped).setPortletMode(portletMode);
   }

}
