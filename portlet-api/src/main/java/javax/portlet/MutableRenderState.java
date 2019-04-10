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
 * Provides read-write access to the render state.
 * The render state is represented by the render parameters,
 * portlet mode and window state.
 * <p>
 * The mutable render state is available through certain portlet response and 
 * portlet URL interfaces.
 * <p>
 * When changed on one of these interfaces, the modified render state becomes
 * active according to the rules of the originating object.
 * If the render state is modified on a response, it becomes active for
 * subsequent portlet render phases.
 * If the render state is modified on a URL, it becomes active when the URL
 * containing the modified state is activated.
 * <p>
 * For example, the methods defined here can be used to set a new portlet mode and 
 * render parameters on a {@link PortletURL} object. 
 * When the portlet URL containing this modified render state is activated,
 * the portlet will have the portlet mode and render parameter values set as they
 * were applied to the portlet URL.
 * </div>
 *
 * @since 3.0
 * @see      RenderState 
 * @see      MutablePortletParameters 
 */
public interface MutableRenderState extends RenderState, Mutable {


   /**
    * <div class="changed_added_3_0">
    * Gets the mutable render parameters.
    * </div>
    * 
    * @return   a <code>MutableRenderParameters</code> object representing
    *           the private and public render parameters
    * @see      PortletParameters 
    * @see      RenderParameters 
    * @see      MutablePortletParameters 
    * @see      MutableRenderParameters 
    */

   public MutableRenderParameters getRenderParameters();


   /**
    * <div class="changed_added_3_0">
    * Sets the portlet mode of a portlet to the given portlet mode.
    * <p>
    * Possible values are the standard portlet modes and any custom portlet
    * modes supported by the portal and the portlet. Portlets must declare in
    * the deployment descriptor the portlet modes they support for each markup
    * type. Standard portlet modes are:
    * <ul>
    * <li>EDIT
    * <li>HELP
    * <li>VIEW
    * </ul>
    * <p>
    * Not more than one portlet mode can be set.
    * If more than one portlet mode is set, only the last one set
    * is valid.
    * <p>
    * Note: The portlet may still be called in a different portlet mode in the
    * next render call, depending on the portlet container / portal.
    * </div>
    * 
    * @param portletMode
    *            the new portlet mode
    * 
    * @exception PortletModeException
    *                   if the portlet cannot switch to this mode,
    *                   because the portal does not support this mode, the portlet has not
    *                   declared in its deployment descriptor that it supports this mode for the current markup,
    *                   or the current user is not allowed to switch to this mode.
    *                   The <code>PortletRequest.isPortletModeAllowed()</code> method can be used
    *                   to check if the portlet can set a given portlet mode.
    * @exception java.lang.IllegalStateException
    *                if the method is invoked after <code>sendRedirect</code>
    *                has been called.
    * @exception java.lang.IllegalArgumentException
    *                if the input parameter is <code>null</code>.
    */

   public void setPortletMode(PortletMode portletMode)
         throws PortletModeException;

   /**
    * <div class="changed_added_3_0">
    * Sets the window state of a portlet to the given window state.
    * <p>
    * Possible values are the standard window states and any custom window
    * states supported by the portal and the portlet. Standard window states
    * are:
    * <ul>
    * <li>MINIMIZED
    * <li>NORMAL
    * <li>MAXIMIZED
    * </ul>
    * <p>
    * Not more than one window state can be set.
    * If more than one window state is set, only the last one set
    * is valid.
    * </div>
    * 
    * @param windowState
    *            the new portlet window state
    * 
    * @exception WindowStateException
    *                   if the portlet cannot switch to this state,
    *                   because the portal does not support this state, the portlet has not 
    *                   declared in its deployment descriptor that it supports this state, or the current
    *                   user is not allowed to switch to this state.
    *                   The <code>PortletRequest.isWindowStateAllowed()</code> method can be used
    *                   to check if the portlet can set a given window state.
    * @exception java.lang.IllegalStateException
    *                if the method is invoked after <code>sendRedirect</code>
    *                has been called.
    * @exception java.lang.IllegalArgumentException
    *                if the input parameter is <code>null</code>.
    * 
    */

   public void setWindowState(WindowState windowState)
         throws WindowStateException;

}