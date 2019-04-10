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

/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

package javax.portlet;

/**
 * <div class="changed_added_3_0">
 * Provides read-only access to the render state.
 * The render state is represented by the render parameters,
 * portlet mode and window state.
 * <p>
 * During render or resource request processing, the render state is constant and 
 * can be accessed through methods provided by this interface.
 * <p>
 * During portlet action or event request ptocessing, the render state can be modified for 
 * subsequent render phase processing.
 * During the portlet render or resource phases, URLs containing modified render state 
 * can be created.
 * When a portlet URL containing modified render state is triggered, the corresponding portlet
 * phase is executed with the modified render state.
 * <p>
 * The render state is modified through {@link MutableRenderState}.
 * </div> 
 * @since      3.0
 * @see        MutableRenderState
 * @see        PortletParameters
 */
public interface RenderState {
   
   
   /**
    * <div class="changed_added_3_0">
    * Gets the render parameters.
    * </div>
    * 
    * @return   an immutable <code>RenderParameters</code> object representing
    *           the private and public render parameters
    * @see      PortletParameters 
    * @see      RenderParameters 
    */
   
   public RenderParameters getRenderParameters();

   
   /**
    * <div class="changed_added_3_0">
    * Returns the current portlet mode of the portlet.
    * </div>
    *
    * @return     the portlet mode. If the portlet mode is not available, 
    *             {@link PortletMode#UNDEFINED} is returned.
    * @see        PortletMode
    */

   public PortletMode getPortletMode();

   
   /**
    * <div class="changed_added_3_0">
    * Returns the current window state of the portlet.
    * </div>
    *
    * @return     the window state. If the window state is not available, 
    *             {@link WindowState#UNDEFINED} is returned.
    * @see        WindowState
    */

   public WindowState getWindowState();

}