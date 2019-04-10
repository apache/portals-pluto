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
 * <span class="changed_modified_3_0">The</span>
 * <CODE>MimeResponse</CODE> defines the base interface to assist a
 * portlet in returning MIME content.
 *
 * @since 2.0
 */
public interface MimeResponse extends PortletResponse {

   
   /**
    * <div class="changed_added_3_0">
    * Specifies processing when a URL is created.
    * </div>
    * 
    * @see #createActionURL(Copy)
    * @see #createRenderURL(Copy)
    * 
    * @since 3.0
    */
   public enum Copy {

      /**
       * <div class="changed_added_3_0">
       * Specifies that no parameters are to be copied when a URL is created.
       * </div>
       *  
       * @since 3.0
       */
      NONE,

      /**
       * <div class="changed_added_3_0">
       * Specifies that the public and private render parameters set for 
       * the current request are
       * be copied to the URL when it is created.
       * </div>
       *  
       * @since 3.0
       */
      ALL,

      /**
       * <div class="changed_added_3_0">
       * Specifies that only the public render parameters set for the 
       * current request are be copied to the URL when it is created.
       * </div>
       *  
       * @since 3.0
       */
      PUBLIC;
   }
   
   
    /**
     * Property to set the expiration time in seconds for this response using
     * the <code>setProperty</code> method intended to be used in 
     * forwarded or included servlets/JSPs.
     * <P>
     * If the expiration value is set to <code>0</code>, caching is disabled for this
     * portlet; if the value is set to <code>-1</code>, the cache does not expire.
     * <p>
     * A default can be defined in the portlet deployment descriptor
     * with the <code>expiration-cache</code> tag, otherwise it is <code>0</code>.
     * <p>
     * Non-integer values are treated as <code>0</code>.
     * <p>
     * The value is <code>"portlet.expiration-cache"</code>.
     * 
     * @see CacheControl
     */
    public static final String EXPIRATION_CACHE = "portlet.expiration-cache";

    
    /**
     * Property to set the cache scope for this response using the
     * <code>setProperty</code> method intended to be used in 
     * forwarded or included servlets/JSPs.
     * <P>
     * Predefined cache scopes are: <code>PUBLIC_SCOPE</code> and <code>PRIVATE_SCOPE</code>.
     * <p>
     * A default can be defined in the portlet deployment descriptor
     * with the <code>cache-scope</code> tag, otherwise it is <code>PRIVATE_SCOPE</code>.
     * <p>
     * Values that are not either <code>PUBLIC_SCOPE</code> or <code>PRIVATE_SCOPE</code>
     * are treated as <code>PRIVATE_SCOPE</code>.
     * <p>
     * The value is <code>"portlet.cache-scope"</code>.
     * 
     * @see CacheControl
     * @since 2.0
     */
    public static final String CACHE_SCOPE = "portlet.cache-scope";

    /**
     * Public cache scope, indicating that the cache entry can be shared across
     * users. The value is <code>"portlet.public-scope"</code>.
     * 
     * @since 2.0
     */
    public static final String PUBLIC_SCOPE = "portlet.public-scope";

    /**
     * Private cache scope, indicating that the cache entry must not be shared
     * across users. The value is <code>"portlet.private-scope"</code>.
     * 
     * @since 2.0
     */
    public static final String PRIVATE_SCOPE = "portlet.private-scope";
    
    /**
     * Property to tell the portlet container the new ETag for this response
     * intended to be used in forwarded or included servlets/JSPs.
     * <p>
     * This property needs to be set using the <code>setProperty</code> method. 
     * <P>
     * The value is <code>"portlet.ETag "</code>.
     * 
     * @see CacheControl
     * @since 2.0
     */
    public static final String ETAG = "portlet.ETag";

    /**
     * Property to tell the portlet container to use the cached markup
     * for the validation token provided in the request. This property 
     * needs to be set using the <code>setProperty</code> method with a non-null
     * value and is intended to be used in forwarded or included servlets/JSPs.
     * The value itself is not evaluated. 
     * <P>
     * The value is <code>"portlet.use-cached-content "</code>.
     * 
     * @see CacheControl
     * @since 2.0
     */
    public static final String USE_CACHED_CONTENT = "portlet.use-cached-content";

    
    /**
     * Property intended to be a hint to the portal application that the returned 
     * content is completely namespaced. 
     * This includes all markup id elements, form fields, etc.
     * One example where this is might be used is for portal applications that
     * are form-based and thus need to re-write any forms included in the portlet
     * markup. 
     * <p>
     * This property  needs to be set using the <code>setProperty</code> method with a non-null
     * value. The value itself is not evaluated. 
     * <p>
     * The value is <code>"X-JAVAX-PORTLET-NAMESPACED-RESPONSE"</code>.
     * 
     * @since 2.0
     */
    public static final String NAMESPACED_RESPONSE = "X-JAVAX-PORTLET-NAMESPACED-RESPONSE";
    
    /**
     * Property intended to be a hint to the portal application that the provided
     * DOM element should be added to the markup head section of the response to the
     * client.
     * <p>
     * Support for this property is optional and the portlet can verify if the
     * calling portal supports this property via the <code>MARKUP_HEAD_ELEMENT_SUPPORT</code>
     * property on the <code>PortalContext</code>.
     * <p>
     * Even if the calling portal support this property delivery of the DOM
     * element to the client cannot be guaranteed, e.g. due to possible security
     * rules of the portal application or elements that conflict with the
     * response of other portlets.
     * <p>
     * This property  needs to be set using the 
     * <code>setProperty(String key,org.w3c.dom.Element element)</code>
     * method.
     * <p>
     * The value is <code>"javax.portlet.markup.head.element"</code>.
     *
     * @since 2.0
     */
    public static final String MARKUP_HEAD_ELEMENT = "javax.portlet.markup.head.element";
    
    
    /**
     * Returns the MIME type that can be used to contribute markup to the render
     * response.
     * <p>
     * If no content type was set previously using the {@link #setContentType}
     * method this method returns <code>null</code>.
     * 
     * @see #setContentType
     * 
     * @return the MIME type of the response, or <code>null</code> if no
     *         content type is set
     */
    public String getContentType();

    /**
     * <span class="changed_modified_3_0">Sets</span> 
     * the MIME type for the response. The portlet should set the
     * content type before calling {@link #getWriter} or
     * {@link #getPortletOutputStream}. 
     * <span class="changed_modified_3_0"> 
     * If the content type is not set using this method, the preferred 
     * content type as returned by {@link PortletRequest#getResponseContentType} is used.
     * </span> 
     * <p>
     * Calling <code>setContentType</code> after <code>getWriter</code> or
     * <code>getOutputStream</code> does not change the content type.
     * <p>
     * 
     * @param type
     *            the content MIME type
     *            
     * @exception java.lang.IllegalArgumentException 
     * <span class="changed_added_3_0"> 
     *             if the content type is invalid.
     * </span>
     * 
     * @see PortletRequest#getResponseContentTypes
     * @see #getContentType
     */
    public void setContentType(String type);

    /**
     * Returns the name of the charset used for the MIME body sent in this
     * response.
     * 
     * <p>
     * See <a href="http://ds.internic.net/rfc/rfc2045.txt">RFC 2047</a> for
     * more information about character encoding and MIME.
     * 
     * @return a <code>String</code> specifying the name of the charset, for
     *         example, <code>ISO-8859-1</code>
     * 
     */
    public String getCharacterEncoding();

    /**
     * Returns a PrintWriter object that can send character text to the portal.
     * <p>
     * Before calling this method the content type of the render response should
     * be set using the {@link #setContentType} method.
     * <p>
     * Either this method or {@link #getPortletOutputStream} may be called to
     * write the body, not both.
     * 
     * @return a <code>PrintWriter</code> object that can return character
     *         data to the portal
     * 
     * @exception java.io.IOException
     *                if an input or output exception occurred
     * @exception java.lang.IllegalStateException
     *                if the <code>getPortletOutputStream</code> method has
     *                been called on this response.
     * 
     * @see #setContentType
     * @see #getPortletOutputStream
     */
    public java.io.PrintWriter getWriter() throws java.io.IOException;

    /**
     * Returns the locale assigned to the response.
     * 
     * @return Locale of this response
     */
    public java.util.Locale getLocale();

    /**
     * Sets the preferred buffer size for the body of the response. The portlet
     * container will use a buffer at least as large as the size requested.
     * <p>
     * This method must be called before any response body content is written;
     * if content has been written, or the portlet container does not support
     * buffering, this method may throw an <code>IllegalStateException</code>.
     * 
     * @param size
     *            the preferred buffer size
     * 
     * @exception java.lang.IllegalStateException
     *                if this method is called after content has been written,
     *                or the portlet container does not support buffering
     * 
     * @see #getBufferSize
     * @see #flushBuffer
     * @see #isCommitted
     * @see #reset
     */
    public void setBufferSize(int size);

    /**
     * Returns the actual buffer size used for the response. If no buffering is
     * used, this method returns 0.
     * 
     * @return the actual buffer size used
     * 
     * @see #setBufferSize
     * @see #flushBuffer
     * @see #isCommitted
     * @see #reset
     */
    public int getBufferSize();

    /**
     * Forces any content in the buffer to be written to the underlying output stream. A call to
     * this method automatically commits the response.
     * 
     * @exception java.io.IOException
     *                if an error occurred when writing the output
     * 
     * @see #setBufferSize
     * @see #getBufferSize
     * @see #isCommitted
     * @see #reset
     */
    public void flushBuffer() throws java.io.IOException;

    /**
     * Clears the content of the underlying buffer in the response without
     * clearing properties set. If the response has been committed, this method
     * throws an <code>IllegalStateException</code>.
     * 
     * @exception IllegalStateException
     *                if this method is called after response is committed
     * 
     * @see #setBufferSize
     * @see #getBufferSize
     * @see #isCommitted
     * @see #reset
     */
    public void resetBuffer();

    /**
     * Returns a boolean indicating if the response has been committed.
     * 
     * @return a boolean indicating if the response has been committed
     * 
     * @see #setBufferSize
     * @see #getBufferSize
     * @see #flushBuffer
     * @see #reset
     */
    public boolean isCommitted();

    /**
     * Clears any data that exists in the buffer as well as the properties set.
     * If the response has been committed, this method throws an
     * <code>IllegalStateException</code>.
     * 
     * @exception java.lang.IllegalStateException
     *                if the response has already been committed
     * 
     * @see #setBufferSize
     * @see #getBufferSize
     * @see #flushBuffer
     * @see #isCommitted
     */
    public void reset();

    /**
     * Returns a <code>OutputStream</code> suitable for writing binary data in
     * the response. The portlet container does not encode the binary data.
     * <p>
     * Before calling this method the content type of the render response must
     * be set using the {@link #setContentType} method.
     * <p>
     * Calling <code>flush()</code> on the OutputStream commits the response.
     * <p>
     * Either this method or {@link #getWriter} may be called to write the body,
     * not both.
     * 
     * @return a <code>OutputStream</code> for writing binary data
     * 
     * @exception java.lang.IllegalStateException
     *                if the <code>getWriter</code> method has been called on
     *                this response.
     * 
     * @exception java.io.IOException
     *                if an input or output exception occurred
     * 
     * @see #setContentType
     * @see #getWriter
     */
    public java.io.OutputStream getPortletOutputStream()
            throws java.io.IOException;

    /**
     * <div class="changed_modified_3_0">
     * Creates a render URL targeting the portlet. 
     * Render URLs cause idempotent requests that move the portlet to a 
     * new view state, for example, to view a different page of data. 
     * <p> 
     * If a request is triggered by the URL, it results in
     * a render request.
     * </div>
     * <div class="changed_added_3_0">
     * <p>
     * The returned render URL will not contain any private render parameters from the
     * current request.  
     * </div>
     * <div class="changed_deleted_3_0">
     * <p>
     * The created URL will per default not contain any parameters of the
     * current render request.
     * </div>
     * <p>
     * The returned URL can be further extended by adding portlet-specific render
     * parameters, portlet mode, and window state.
     * If no portlet mode, window
     * state or security modifier is set on the URL, the values from the
     * current render or resource request are preserved.
     * <p>
     * <div class="changed_added_3_0">
     * Public render parameters do not need to be explicitly added to the returned 
     * render URL, unless the public render parameter value is to be changed. 
     * Any public render parameters associated with 
     * the portlet will automatically be available during render request processing resulting
     * from activation of the URL.
     * <p>
     * If a public render parameter value is set or removed on a render URL, then the public 
     * render parameter will be set to the new value or removed when the URL is activated.
     * <p>
     * The effect of this method is the same as calling {@link #createRenderURL(Copy)}
     * with the parameter set to PUBLIC.
     * </div>
     *
     * @return a portlet render URL
     */
    public <T extends PortletURL & RenderURL> T createRenderURL();
	

    /**
     * <div class="changed_added_3_0">
     * Creates a render URL targeting the portlet. 
     * Render URLs cause idempotent requests that move the portlet to a 
     * new view state, for example, to view a different page of data. 
     * <p> 
     * If a request is triggered by the URL, it results in
     * a render request.
     * <p>
     * The new render URL will contain render parameters from the
     * current request as specified by the <code>option</code> parameter.
     * <dl>
     * <dt>NONE</dt>
     * <dd>All public and private parameters are removed from the URL.</dd>
     * <dt>ALL</dt>
     * <dd>The public and private parameters governing the current 
     * request are added to the URL.</dd>
     * <dt>PUBLIC</dt>
     * <dd>Only public parameters governing the current
     * request are added to the URL.</dd>
     * </dl>
     * The URL can be further extended by adding render
     * parameters, portlet mode, and window state.
     * If no additional portlet mode, window
     * state or security modifier is set on the URL, the values from the
     * current render or resource request are preserved.
     * <p>
     * If a public render parameter value is set or removed on a render URL, then the public 
     * render parameter will be set to the new value or removed when the URL is activated.
     * </div>
     * 
     * @param option
     *            Specifies how current parameters are to be copied to the URL
     *
     * @see Copy
     * 
     * @return a portlet render URL
     *     
     * @since 3.0
     */
    public RenderURL createRenderURL(Copy option);


    /**
     * <div class="changed_modified_3_0">
     * Creates an action URL targeting the portlet.
     * Action URLs are used to create forms or links that, when triggered,
     * update the render state in a non-idempotent manner.
     * <p> 
     * If a request is triggered by the URL, it results in
     * an action request.
     * </div>
     * <p>
     * The returned action URL will 
     * <span class="changed_added_3_0">not contain any private render parameters</span>
     * <span class="changed_deleted_3_0">per default not contain any parameters</span> 
     * from the current request. 
     * <p>
     * The returned URL can be further extended by adding portlet-specific action
     * parameters, portlet mode, and window state.
     * If no additional portlet mode, window
     * state or security modifier is set on the URL, the values from the
     * current render or resource request are preserved.
     * <div class="changed_added_3_0">
     * <p>
     * Public render parameters do not need to be explicitly added to the returned 
     * action URL, unless the public render parameter value is to be changed. 
     * Any public render parameters associated with 
     * the portlet will automatically be available during action request 
     * processing resulting from activation of the URL. 
     * <p>
     * If a public render parameter value is set or removed on an action URL, 
     * then the public render parameter will be set to the new value or 
     * removed when the URL is activated.
     * <p>
     * The effect of this method is the same as calling {@link #createRenderURL(Copy)}
     * with the parameter set to PUBLIC.
     * </div>
     * 
     * @return a portlet action URL
     */
    public <T extends PortletURL & ActionURL> T createActionURL();


    /**
     * <div class="changed_added_3_0">
     * Creates an action URL targeting the portlet. 
     * Action URLs are used to create forms or links that, when triggered,
     * update the render state in a non-idempotent manner.
     * <p> 
     * If a request is triggered by the URL, it results in
     * an action request.
     * <p>
     * The new action URL will contain render parameters from the
     * current request as specified by the <code>option</code> parameter.
     * <dl>
     * <dt>NONE</dt>
     * <dd>All public and private parameters are removed from the URL.</dd>
     * <dt>ALL</dt>
     * <dd>The public and private parameters governing the current 
     * request are added to the URL.</dd>
     * <dt>PUBLIC</dt>
     * <dd>Only public parameters governing the current
     * request are added to the URL.</dd>
     * </dl>
     * <p>
     * The returned URL can be further extended by adding action
     * parameters, portlet mode, and window state.
     * If no additional portlet mode, window
     * state or security modifier is set on the URL, the values from the
     * current render or resource request are preserved.
     * <p>
     * If a public render parameter value is set or removed on an action URL, 
     * then the public render parameter will be set to the new value or 
     * removed when the URL is activated.
     * </div>
     * 
     * @param option
     *            Specifies how current parameters are to be copied to the URL
     *
     * @see Copy
     * 
     * @return a portlet action URL
     *     
     * @since 3.0
     */
    public ActionURL createActionURL(Copy option);

	
	/**
     * <div class="changed_modified_3_0">
     * Creates a resource URL targeting the portlet. 
     * Resource URLs are used to trigger requests for content that applies
     * to the current portlet view state.
     * <p>
     * If a request is triggered by the <code>ResourceURL</code>, it results in a serve
     * resource request of the <code>ResourceServingPortlet</code> interface.
     * <p>
     * The security settings can be changed for the URL. If the security settings are
     * not explicitly set, the values governing the current request 
     * are preserved. 
     * The current
     * render parameters, portlet mode, and window state are preserved 
     * depending on the cacheability setting for the returned resource URL.
     * </div>
     * <div class="changed_added_3_0">
     * <p>
     * If cacheability is set to <code>PORTLET</code> or <code>PAGE</code>, the values of the render
     * parameters, portlet mode, and window state are preserved. 
     * Otherwise, they will not be preserved.
     * <p>
     * If allowed by the cacheability setting, public and private render 
     * parameters are added to the URL with their current values.
     * The render parameter values cannot be changed on the URL. 
     * <p>
     * The URL can be further extended by adding portlet-specific resource
     * parameters. 
     * <p>
     * The URL will contain the current 
     * cacheability setting of the parent resource by default. 
     * If no parent resource is available, <code>PAGE</code> is the default.
     * </div>
     * <div class="changed_deleted_3_0">
     * If a request is triggered by the PortletURL, it results in a serve
     * resource request of the <code>ResourceServingPortlet</code> interface.
     * <p>
     * The returned URL can be further extended by adding portlet-specific
     * parameters .
     * <p>
     * The created URL will by default contain the current 
     * cacheability setting of the parent resource. 
     * If no parent resource is available, <code>PAGE</code> is the default.
     * </div>
     * 
     * @since 2.0
     * @return a portlet resource URL
     */
	public ResourceURL createResourceURL();


    
    /**
     * Returns the cache control object allowing to set
     * specific cache settings valid for the markup
     * returned in this response.
     * 
     * @return  Cache control for the current response.
     * 
     * @since 2.0
     */
    public CacheControl getCacheControl();

    


}
