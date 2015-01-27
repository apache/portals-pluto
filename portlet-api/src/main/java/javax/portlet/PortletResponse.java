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
 * The <CODE>PortletResponse</CODE> defines the base interface to assist a
 * portlet in creating and sending a response to the client. The portlet
 * container uses specialized versions of this interface when invoking a
 * portlet.
 * The portlet container creates these objects and passes them as arguments to
 * the portlet's <CODE>processAction, processEvent, serveResource</CODE> and <CODE>render</CODE> methods.
 * 
 * @see ActionResponse
 * @see RenderResponse
 * @see EventResponse
 * @see ResourceResponse
 */
public interface PortletResponse {


	/**
     * Adds a String property to an existing key to be returned to the portal.
     * If there are no property values already associated with the key, 
     * a new key is created.
     * <p>
     * This method allows response properties to have multiple values.
     * <p>
     * Response properties can be viewed as header values set for the portal application. 
     * If these header values are intended to be transmitted to the client they should be 
     * set before the response is committed.
     * 
     * @param key
     *            the key of the property to be returned to the portal
     * @param value
     *            the value of the property to be returned to the portal
     * 
     * @exception java.lang.IllegalArgumentException
     *                if key is <code>null</code>.
     */

	public void addProperty(String key, String value);


	/**
     * Sets a String property to be returned to the portal.
     * <p>
     * Response properties can be viewed as header values set for the portal application. 
     * If these header values are intended to be transmitted to the client they should be 
     * set before the response is committed.
     * <p>
     * This method resets all properties previously added with the same key.
     * 
     * @param key
     *            the key of the property to be returned to the portal
     * @param value
     *            the value of the property to be returned to the portal
     * 
     * @exception java.lang.IllegalArgumentException
     *                if key is <code>null</code>.
     */

	public void setProperty(String key, String value);

	/**
     * Returns the encoded URL of the resource, like servlets, JSPs, images and
     * other static files, at the given path.
     * <p>
     * Portlets should encode all resource URLs pointing to resources in the
     * portlet application via this method in order to ensure that they get
     * served via the portal application.
     * <p>
     * Some portal/portlet-container implementation may require those URLs to
     * contain implementation specific data encoded in it. Because of that,
     * portlets should use this method to create such URLs.
     * <p>
     * The <code>encodeURL</code> method may include the session ID and other
     * portal/portlet-container specific information into the URL. If encoding
     * is not needed, it returns the URL unchanged.
     * <p>
     * Portlet developer should be aware that the returned URL might not be a well formed
     * URL but a special token at the time the portlet is generating its content. 
     * Thus portlets should not add additional parameters on the resulting URL or 
     * expect to be able to parse the URL. As a result, the outcome of the encodeURL 
     * call may be different than calling encodeURL in the servlet world.
     * 
     * @param path
     *            the URI path to the resource. This must be either an absolute
     *            URL (e.g.
     *            <code>http://my.co/myportal/mywebap/myfolder/myresource.gif</code>)
     *            or a full path URI (e.g.
     *            <code>/myportal/mywebap/myfolder/myresource.gif</code>).
     * 
     * @exception java.lang.IllegalArgumentException
     *                if path doesn't have a leading slash or is not an absolute
     *                URL
     * 
     * @return the encoded resource URL as string, may not be a valid URL
     */

	public String encodeURL(String path);

	/**
     * The value returned by this method should be prefixed or appended to
     * elements, such as JavaScript variables or function names, to ensure they
     * are unique in the context of the portal page.
     * <p>
     * The namespace value must be constant for the lifetime of the portlet
     * window.
     * 
     * @return the namespace
     */

	public String getNamespace();

    /**
     * Adds a HTTP Cookie property to the response.<br>
     * The portlet should note that the cookie may not make
     * it to the client, but may be stored at the portal.
     * <p>
     * This method allows response properties to have multiple cookies.
     * <p>
     *
     * @param  cookie the cookie to be added to the response
     * 
     * @exception  java.lang.IllegalArgumentException 
     *                            if cookie is <code>null</code>.
     * @since 2.0
     */

    public void addProperty(javax.servlet.http.Cookie cookie);


    /**
     * Adds an XML DOM element property to the response.
     * <p>
     * If a DOM element with the provided key already exists
     * the provided element will be stored in addition to the
     * existing element under the same key.
     * <p>
     * If the element is <code>null</code> the key is removed from
     * the response.
     * <p>
     * Response XML DOM element properties can be viewed as 
     * additional response document sections
     * set for the portal application. 
     * If these header values are intended to be transmitted to the client they should be 
     * set before the response is committed.
     *
     * @param key
     *            the key of the property to be returned to the portal
     * @param  element
     *            the XML DOM element to be added to the response
     *
     * @exception  java.lang.IllegalArgumentException
     *                            if key is <code>null</code>.
     * @since 2.0
     */
   void addProperty(String key, org.w3c.dom.Element element);
   
   /**
    * Creates an element of the type specified to be used in the 
    * {@link #addProperty(String,Element)} method. 
    * 
    * @param tagName	name of the element type to instantiate
    * @return  A new Element object with the nodeName attribute set to tagName, 
    *          and localName, prefix, and namespaceURI set to null.
    * @throws org.w3c.dom.DOMException
    *     INVALID_CHARACTER_ERR: Raised if the specified name 
    *     contains an illegal character.
    */
   org.w3c.dom.Element createElement(String tagName) throws org.w3c.dom.DOMException;


}
