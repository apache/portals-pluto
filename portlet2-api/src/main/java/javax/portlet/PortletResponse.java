/*
 * Copyright 2006 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */
/*
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
     * This constant defines a per response scope for the response properties.
     * The properties should considerate valid only until the current portlet response is
     * returned to the portlet container / portal.
     * <p>
     * Value: <code>0x01</code>
     */
    public static final int RESPONSE_SCOPE = 0x01;

    /**
     * This constant defines a per end user session scope for the response attribute.
     * The attributes should considerate valid only within the current end user session.
     * <p>
     * Properties stored in this scope can be shared by the portlet container / portal
     * with other portlets or artifacts within the current end user scope. The portlet
     * should be aware that other portlets or artifacts may change this value too.
     * <p>
     * Session scoped properties must be declared in the portlet deployment descriptor
     * using the <code><shared-property></code> tag.
     * <p>
     * Value: <code>0x02</code>
     */
    public static final int SESSION_SCOPE = 0x02;

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
   * Adds a String property to an existing key to be returned to the portal.
   * <p>
   * This method allows response properties to have multiple values.
   * <p>
   * Properties can be used by portlets to provide vendor specific 
   * information to the portal or for sharing data at the portal level.
   *
   * @param  key    the key of the property to be returned to the portal
   * @param  value  the value of the property to be returned to the portal
   * @param  scope  the scope in which this key should be set
   * 
   * @exception  java.lang.IllegalArgumentException 
   *                            if key is <code>null</code>,
   *                            scope is unkown, or
   *                            value is not allowed in the given scope.
   */

  public void addProperty(String key, String value, int scope);


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
   * The current portlet mode and window state are preserved. 
   * <p>
   * If a request is triggered by the
   * PortletURL, it results in a render resource request of the
   * <code>ResouceServingListener</code> interface.
   * <p>
   * The returned URL can be further extended by adding
   * portlet-specific parameters . 
   * <p>
   * The created URL will per default contain 
   * the current render request.
   *
   * @since 2.0
   * @return a portlet resource URL
   */
  public ResourceURL createResourceURL ();

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
   * Sets a String property to be returned to the portal.
   * <p>
   * Properties can be used by portlets to provide vendor specific 
   * information to the portal or for sharing data at the portal level.
   * <p>
   * This method resets all properties previously added with the same key.
   *
   * @param  key    the key of the property to be returned to the portal
   * @param  value  the value of the property to be returned to the portal
   * @param  scope  the scope in which this key should be set
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if key is <code>null</code>,
   *                            scope is unkown, or
   *                            value is not allowed in the given scope.
   */

  public void setProperty(String key, String value, int scope);

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


