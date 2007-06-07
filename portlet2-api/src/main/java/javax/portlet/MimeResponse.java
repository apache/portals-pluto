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
/*
 * Copyright 2006 IBM Corporation.
 *
 */
package javax.portlet;

/**
 * The <CODE>MimeResponse</CODE> defines the base interface to assist a
 * portlet in returing MIME content. 
 *
 * @since 2.0
 */
public interface MimeResponse extends PortletResponse {

    /**
     * Property to set the expiration time in seconds for this response using
     * the <code>setProperty</code> method.
     * <P>
     * If the expiration value is set to 0, caching is disabled for this
     * portlet; if the value is set to -1, the cache does not expire.
     * <p>
     * The value is <code>"portlet.expiration-cache"</code>.
     */
    public static final String EXPIRATION_CACHE = "portlet.expiration-cache";

    /**
     * Property to set the cache scope for this response using the
     * <code>setProperty</code> method.
     * <P>
     * Predefined cache scopes are: PUBLIC_SCOPE and PRIVATE_SCOPE.
     * <p>
     * Default is PRIVATE_SCOPE.
     * <p>
     * The value is <code>"portlet.cache-scope"</code>.
     * 
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
     * This property is set by the container if the container
     * has a cached response for the given validation tag. The property can be
     * retrieved using the <code>getProperty</code> method. 
     * <P>
     * The value is <code>"portlet.ETag "</code>.
     * 
     * @since 2.0
     */
    public static final String ETAG = "portlet.ETag";

    /**
     * Property to tell the portlet container to use the cached markup
     * for the validation token provided in the render request. This property 
     * needs to be set using the <code>setProperty</code> method with a non-null
     * value. The value itself is not evaluated. 
     * <P>
     * The value is <code>"portlet.use-cached-content "</code>.
     */
    public static final String USE_CACHED_CONTENT = "portlet.use-cached-content";

    /**
     * Returns the MIME type that can be used to contribute markup to the render
     * response.
     * <p>
     * If no content type was set previously using the {@link #setContentType}
     * method this method retuns <code>null</code>.
     * 
     * @see #setContentType
     * 
     * @return the MIME type of the response, or <code>null</code> if no
     *         content type is set
     */
    public String getContentType();

    /**
     * Sets the MIME type for the render response. The portlet must set the
     * content type before calling {@link #getWriter} or
     * {@link #getPortletOutputStream}.
     * <p>
     * Calling <code>setContentType</code> after <code>getWriter</code> or
     * <code>getOutputStream</code> does not change the content type.
     * <p>
     * The portlet container will ignore any character encoding
     * specified as part of the content type.
     * 
     * @param type
     *            the content MIME type
     * 
     * @throws java.lang.IllegalArgumentException
     *             if the given type is not in the list returned by
     *             <code>PortletRequest.getResponseContentTypes</code>
     * 
     * @see RenderRequest#getResponseContentTypes
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
     * Before calling this method the content type of the render response must
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
     *                been called on this response, or if no content type was
     *                set using the <code>setContentType</code> method.
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
     *                if an error occured when writing the output
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
     *                if this method is called after response is comitted
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
     *                this response, or if no content type was set using the
     *                <code>setContentType</code> method.
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
