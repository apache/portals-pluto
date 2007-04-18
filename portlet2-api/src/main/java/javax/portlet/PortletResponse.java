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
 * NOTE: this source code is based on an early draft version of JSR 286 and not intended for product
 * implementations. This file may change or vanish in the final version of the JSR 286 specification.
 */
/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */
/**
  * Copyright 2006 IBM Corporation.
  */

package javax.portlet;



/**
 * The <CODE>PortletResponse</CODE> defines the base interface to assist a
 * portlet in creating and sending a response to the client.
 * The portlet container uses two specialized versions of this interface
 * when invoking a portlet, <CODE>ActionResponse</CODE> and
 * <CODE>RenderResponse</CODE>. The  portlet container creates these
 * objects and passes them as arguments to the portlet's <CODE>processAction</CODE>
 * and <CODE>render</CODE> methods.
 * 
 * @see ActionResponse
 * @see RenderResponse
 */
public interface PortletResponse
{


  /**
   * Adds a String property to an existing key to be returned to the portal.
   * <p>
   * This method allows response properties to have multiple values.
   * <p>
   * Properties can be used by portlets to provide vendor specific 
   * information to the portal.
   *
   * @param  key    the key of the property to be returned to the portal
   * @param  value  the value of the property to be returned to the portal
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if key is <code>null</code>.
   */

  public void addProperty(String key, String value);


  /**
   * Creates a portlet URL targeting the portlet. If no portlet mode, 
   * window state or security modifier is set in the PortletURL the
   * current values are preserved. If a request is triggered by the
   * PortletURL, it results in a render request.
   * <p>
   * The returned URL can be further extended by adding
   * portlet-specific parameters and portlet modes and window states. 
   * <p>
   * The created URL will per default not contain any parameters
   * of the current render request.
   *
   * @return a portlet render URL
   */
  public PortletURL createRenderURL ();


  /**
   * Creates a portlet URL targeting the portlet. If no portlet mode, 
   * window state or security modifier is set in the PortletURL the
   * current values are preserved. If a request is triggered by the
   * PortletURL, it results in an action request.
   * <p>
   * The returned URL can be further extended by adding
   * portlet-specific parameters and portlet modes and window states. 
   * <p>
   * The created URL will per default not contain any parameters
   * of the current render request.
   *
   * @return a portlet action URL
   */
  public PortletURL createActionURL ();


  /**
   * Creates a portlet URL targeting the portlet. If no security modifier is 
   * set in the PortletURL the current values are preserved. 
   * The current render parameters, portlet mode and window state are preserved. 
   * <p>
   * If a request is triggered by the
   * PortletURL, it results in a serve resource request of the
   * <code>ResouceServingPortlet</code> interface.
   * <p>
   * The returned URL can be further extended by adding
   * portlet-specific parameters . 
   * <p>
   * The created URL will per default contain 
   * the current render request.
   * <p>
   * The markup returned when activating this
   * resource URL must only contain resource URLs or no portlet URLs at all.
   * This method is equivalent to calling
   * <code>createResourceURL(false)</code>.<BR>
   * You should use this <code>createResourceURL</code> method
   * if your resource markup does not contain any portlet URLs or only
   * resource URLs as the final URL that may be create as an result
   * will allow for better cachability of the resource markup on
   * the client.
   *
   * @since 2.0
   * @return a portlet resource URL
   */
  public ResourceURL createResourceURL ();

  /**
   * Creates a portlet URL targeting the portlet. If no security modifier is 
   * set in the PortletURL the current values are preserved. 
   * The current render parameters, portlet mode and window state are preserved. 
   * <p>
   * If a request is triggered by the
   * PortletURL, it results in a serve resource request of the
   * <code>ResouceServingPortlet</code> interface.
   * <p>
   * The returned URL can be further extended by adding
   * portlet-specific parameters . 
   * <p>
   * The created URL will per default contain 
   * the current render request.
   * <p>
   * If <code>markupContainsPortletURLs</code> is set to 
   * <code>true</code>, the markup returned when activating this
   * resource URL may contain arbitrary portlet URLs (action URLs,
   * render URLs, fragment URLs and resource URLs). If set to
   * <code>false</code>, the markup returned when activating this
   * resource URL must only contain resource URLs or no portlet URLs at all.
   *
   * @since 2.0
   * @param  markupContainsPortletURLs
   * 			if set to <code>true</code>, the markup returned when activating this
   * 			resource URL may contain arbitrary portlet URLs.
   * @return a portlet resource URL
   */
  public ResourceURL createResourceURL (boolean markupContainsPortletURLs);

  /**
   * Creates a portlet URL targeting the portlet. If no security modifier is 
   * set in the PortletURL the current values are preserved. 
   * The current render parameters, portlet mode and window state are preserved. 
   * <p>
   * If a request is triggered via some client side script function provided
   * by the portal application, it results in a serve fragment request of the
   * <code>FragmentServingPortlet</code> interface.
   * <p>
   * The returned URL can be further extended by adding
   * fragment-specific parameters and portlet modes and window states. 
   * <p>
   * The created URL will per default contain 
   * the current render request.
   *
   * @since 2.0
   * @return a portlet fragment URL
   */
  public FragmentURL createFragmentURL ();

  /**
   * Sets a String property to be returned to the portal.
   * <p>
   * Properties can be used by portlets to provide vendor specific 
   * information to the portal.
   * <p>
   * This method resets all properties previously added with the same key.
   *
   * @param  key    the key of the property to be returned to the portal
   * @param  value  the value of the property to be returned to the portal
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if key is <code>null</code>.
   */

  public void setProperty(String key, String value);

  /**
   * Returns the encoded URL of the resource, like servlets,
   * JSPs, images and other static files, at the given path.
   * <p>
   * Some portal/portlet-container implementation may require 
   * those URLs to contain implementation specific data encoded
   * in it. Because of that, portlets should use this method to 
   * create such URLs.
   * <p>
   * The <code>encodeURL</code> method may include the session ID 
   * and other portal/portlet-container specific information into the URL. 
   * If encoding is not needed, it returns the URL unchanged. 
   *
   * @param   path
   *          the URI path to the resource. This must be either
   *          an absolute URL (e.g. 
   *          <code>http://my.co/myportal/mywebap/myfolder/myresource.gif</code>)
   *          or a full path URI (e.g. <code>/myportal/mywebap/myfolder/myresource.gif</code>).
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if path doesn't have a leading slash or is not an absolute URL
   * 
   * @return   the encoded resource URL as string
   */

  public String encodeURL (String path);

  
  /**
   * The value returned by this method should be prefixed or appended to 
   * elements, such as JavaScript variables or function names, to ensure 
   * they are unique in the context of the portal page.
   * <p>
   * The namespace value must be constant for the lifetime of the portlet window.
   *
   * @return   the namespace
   */
  
  public String getNamespace ();
}


