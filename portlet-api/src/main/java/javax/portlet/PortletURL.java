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
 * The <CODE>PortletURL</CODE> interface represents a URL
 * that reference the portlet itself.
 * <p>
 * A PortletURL is created through the <CODE>RenderResponse</CODE>
 * or <code>ResourceResponse</code>.
 * Parameters, a portlet mode, a window state and a security level
 * can be added to <CODE>PortletURL</CODE> objects. 
 * <P>
 * There are two types of PortletURLs:
 * <ul>
 * <li>Action URLs, they are created with <CODE>createActionURL</CODE>, and 
 *     trigger an action request followed by a render request.
 * <li>Render URLs, they are created with <CODE>createRenderURL</CODE>, and
 *     trigger a render request.
 * </ul>
 * <p>
 * The string representation of a PortletURL does not need to be a valid 
 * URL at the time the portlet is generating its content. It may contain  
 * special tokens that will be converted to a valid URL, by the portal, 
 * before the content is returned to the client.
 */
public interface PortletURL extends BaseURL
{



  /**
   * Indicates the window state the portlet should be in, if this 
   * portlet URL triggers a request.
   * <p>
   * A URL can not have more than one window state attached to it.
   * If more than one window state is set only the last one set
   * is attached to the URL.
   * 
   * @param windowState
   *               the portlet window state
   *
   * @exception WindowStateException
   *                   if the portlet cannot switch to this state,
   *                   because the portal does not support this state, the portlet has not 
   *                   declared in its deployment descriptor that it supports this state, or the current
   *                   user is not allowed to switch to this state.
   *                   The <code>PortletRequest.isWindowStateAllowed()</code> method can be used
   *                   to check if the portlet can set a given window state.
   * @see PortletRequest#isWindowStateAllowed
   */
  public void setWindowState (WindowState windowState)
    throws WindowStateException;


  /**
   * Indicates the portlet mode the portlet must be in, if this
   * portlet URL triggers a request.
   * <p>
   * A URL can not have more than one portlet mode attached to it.
   * If more than one portlet mode is set only the last one set
   * is attached to the URL.
   * 
   * @param portletMode
   *               the portlet mode
   * 
   * @exception PortletModeException
   *                   if the portlet cannot switch to this mode,
   *                   because the portal does not support this mode, the portlet has not
   *                   declared in its deployment descriptor that it supports this mode for the current markup,
   *                   or the current user is not allowed to switch to this mode.
   *                   The <code>PortletRequest.isPortletModeAllowed()</code> method can be used
   *                   to check if the portlet can set a given portlet mode.
   * @see PortletRequest#isPortletModeAllowed
   */
  public void setPortletMode (PortletMode portletMode)
    throws PortletModeException;


  /**
   * Returns the currently set portlet mode on this PortletURL.
   *             
   * @since 2.0
   *
   * @return   the portlet mode, or <code>null</code> if none is set
   */

  public PortletMode getPortletMode ();


  /**
   * Returns the currently set window state on this PortletURL.
   *             
   * @since 2.0
   *
   * @return   the window state, or <code>null</code> if none is set
   */

  public WindowState getWindowState ();

  /**
	* Removes the specified public render parameter.
	* The name must reference a public render parameter defined
	* in the portlet deployment descriptor under the
	* <code>public-render-parameter</code> element with the
	* <code>identifier</code> mapping to the parameter name.
	* <p>
	* Note that calling this method on a PortletURL of type
	* Action URL does not have any effect.
	* 
	* @param name			a <code>String</code> specifying 
	*					the name of the public render parameter to be removed
	*
	* @exception  java.lang.IllegalArgumentException 
	*                            if name is <code>null</code>.
	* @since 2.0
	*/
  public void removePublicRenderParameter(String name); 
}
