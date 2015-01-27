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
 * The <CODE>ResourceURL</CODE> defines a resource URL that when clicked will
 * result in a <code>serveResource</code> call of the
 * <code>ResourceServingPortlet</code> interface.
 * <p>
 * Each resource URL has a specific cache level assigned with it. This level
 * can be either <code>FULL, PORTLET</code> or <code>PAGE</code> and denotes
 * the cacheability of the resource in the browser.
 * <p>
 * The default cache level of a resource URL is either the cache level of the
 * parent resource URL, or <code>PAGE</code> if no parent resource URL is
 * available.
 *   
 * @since 2.0
 */
public interface ResourceURL extends BaseURL {

	/**
     * The URL of type <code>FULL</code> does not need to contain the current
     * state of the page or the current render parameters, portlet mode, or
     * window state of the portlet. Thus the portlet may not be able to
     * access the portlet mode, window state, or render parameters in the
     * <code>serveResource</code> call. 
     * <p>
     * Only URLs of the type <code>FULL</code> are allowed in the response.
     * The same restriction is true for all downstream URLs that result from
     * this response call. Attempts to create URLs that are not of type
     * <code>FULL</code> will result in an <code>IllegalStateException</code>.
     * <p>
     * URLs of the type <code>FULL</code> have the highest cacheability in the
     * browser as they do not depend on any state of the portlet or page.
     */
	public static final String FULL = "cacheLevelFull";

	/**
     * The URL of type <code>PORTLRET</code> does not need to contain the
     * current state of the page, but the current render parameters, portlet
     * mode, or window state of the portlet must be accessible to the portlet.
     * <p>
     * Only URLs of the type <code>PORTLET</code> or <code>FULL</code> are
     * allowed in the response. The same restriction
     * is true for all downstream URLs that result from this response.
     * Attempts to create URLs that are not of type
     * <code>PORTLET</code> or <code>FULL</code> will result in an 
     * <code>IllegalStateException</code>.
     * <p>
     * URLs of the type <code>PORTLET</code> are cacheable on the portlet
     * level in the browser and can be served from the browser cache for as long
     * as the state of this portlet does not change.
     */
	public static final String PORTLET = "cacheLevelPortlet";

	/**
     * The URL of type <code>PAGE</code> may contain artifacts that require
     * knowledge of the state of the complete page, like
     * <code>PortletURLs</code>.
     * <p>
     * URLs of the type <code>PAGE</code> are only cacheable on the page level
     * and can only be served from the browser cache as long as no state on the
     * page changes.
     */
	public static final String PAGE = "cacheLevelPage";

	/**
	 * Property that the portlet can set for resources with caching
	 * type <code>FULL</code> via the <code>setProperty</code> method
	 * on the <code>ResourceURL</code>.
	 * <p>
	 * When set, this property indicates to the portal application
	 * that it can share this resource across different portlet applications.
	 * <p>
	 * The value of this property should be a QName in the 
	 * format of <code>javax.xml.namespace.QName.toString()</code>.
	 */
	public static final String SHARED = "javax.portlet.shared";

	
	/**
     * Allows setting a resource ID that can be retrieved when serving the
     * resource through the {@link ResourceRequest#getResourceID} method.
     * 
     * @param resourceID
     *            ID for this resource URL
     */
	public void setResourceID(String resourceID);

	/**
	 * Returns the cache level of this resource URL.
	 * <p>
	 * Possible return values are: <code>FULL, PORTLET</code> 
	 * or <code>PAGE</code>.
	 * 
     * @return  the cache level of this resource URL.
     */
	public String getCacheability();

	/**
	 * Sets the cache level of this resource URL.
	 * <p>
	 * Possible values are: <code>FULL, PORTLET</code> 
	 * or <code>PAGE</code>.
	 * <p>
	 * Note that if this URL is created inside a 
	 * <code>serveResource</code> call it must have
	 * at minimum the same cacheablity, or a more
	 * restrictive one, as the parent resource URL,
	 * otherwise an IllegalStateException is thrown.
	 * <p>
	 * The default cache level of a resource URL is either the cache level of the
	 * parent resource URL, or <code>PAGE</code> if no parent resource URL is
	 * available.
	 * 
     * @param cacheLevel  the cache level of this resource URL.
     * @throws java.lang.IllegalStateException  
     * 			if this resource URL has a weaker cache level
     * 			than the parent resource URL.
     * @throws java.lang.IllegalArgumentException
     * 			if the cacheLevel is unknown to the portlet container
     */
	public void setCacheability(String cacheLevel);

}
