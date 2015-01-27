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
 * The <CODE>PortalContext</CODE> interface gives the portlet
 * the ability to retrieve information about the portal calling this portlet.
 * <p>
 * The portlet can only read the <CODE>PortalContext</CODE> data.
 */
public interface PortalContext
{
	/**
     * Property indicating if the portal application supports the
     * <code>MimeResponse</code> property <code>MARKUP_HEAD_ELEMENT</code>.
     * <p>
     * A non-null value indicates that the portal application supports
     * the <code>MARKUP_HEAD_ELEMENT</code> property.
     * <p>
     * The value is <code>"javax.portlet.markup.head.element.support"</code>.
     *
     * @since 2.0
     */
	public static final String MARKUP_HEAD_ELEMENT_SUPPORT = "javax.portlet.markup.head.element.support";
  
	
  /**
   * Returns the portal property with the given name, 
   * or a <code>null</code> if there is 
   * no property by that name.
   *
   * @param  name    property name
   *
   * @return  portal property with key <code>name</code>
   *
   * @exception	java.lang.IllegalArgumentException	
   *                      if name is <code>null</code>.
   */

  public java.lang.String getProperty(java.lang.String name);


  /**
   * Returns all portal property names, or an empty 
   * <code>Enumeration</code> if there are no property names.
   *
   * @return  All portal property names as an 
   *          <code>Enumeration</code> of <code>String</code> objects
   */
  public java.util.Enumeration<String> getPropertyNames();


  /**
   * Returns all supported portlet modes by the portal
   * as an enumeration of <code>PortletMode</code> objects.
   * <p>
   * The portlet modes must at least include the
   * standard portlet modes <code>EDIT, HELP, VIEW</code>.
   *
   * @return  All supported portal modes by the portal
   *          as an enumeration of <code>PortletMode</code> objects.
   */

  public java.util.Enumeration<PortletMode> getSupportedPortletModes();


  /**
   * Returns all supported window states by the portal
   * as an enumeration of <code>WindowState</code> objects.
   * <p>
   * The window states must at least include the
   * standard window states <code> MINIMIZED, NORMAL, MAXIMIZED</code>.
   *
   * @return  All supported window states by the portal
   *          as an enumeration of <code>WindowState</code> objects.
   */

  public java.util.Enumeration<WindowState> getSupportedWindowStates();


  /**
   * Returns information about the portal like vendor, version, etc.
   * <p>
   * The form of the returned string is <I>servername/versionnumber</I>. For 
   * example, the reference implementation Pluto may return the string 
   * <CODE>Pluto/1.0</CODE>.
   * <p>
   * The portlet container may return other optional information  after the 
   * primary string in parentheses, for example, <CODE>Pluto/1.0 
   * (JDK 1.3.1; Windows NT 4.0 x86)</CODE>.
   * 
   * @return a <CODE>String</CODE> containing at least the portal name and version number
   */

  public java.lang.String getPortalInfo();
}
