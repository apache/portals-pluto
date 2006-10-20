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
 * The <code>CacheControl</code> interface represents cache settings
 * for a piece of markup. The settings are only valid for the current
 * request.
 *
 * @since 2.0
 */
public interface CacheControl {

    /**
     * Get the currently set expiration time,
     * or <code>null</code> if no expiration time
     * is set.
     * <p>
     * This call returns the same value as the
     * <code>getProperty(EXPIRATION_CACHE)</code>
     * call.
     * 
     * @return  the currently set expiration time in seconds,
     *          or <code>null</code> if no expiration time
     *          is set.
     */
    public long getExpirationTime();
    
    /**
     * Sets a new expiration time for the current response
     * in seconds.
     * <p>
     * If the expiration value is set to 0, caching is disabled for this
     * portlet; if the value is set to -1, the cache does not expire.
     * <p>
     * This call is equivalent to calling
     * <code>setProperty(EXPIRATION_CACHE)</code>.
     * 
     * @param time  expiration time in seconds
     */
    public void setExpirationTime(long time);
    
    
    /**
     * Returns a boolean indicating whether the
     * caching scope is set to public for the current response.
     * If no caching scope is set, the default scope
     * is not public and thus returns false.
     * <p>
     * Public cache scope indicates that the cache entry can be shared across
     * users. Non-public, or private cache scope indicates that the cache entry
     * must not be shared across users.
     * <p>
     * This call is equivalent to calling
     * <code>getProperty(CACHE_SCOPE).equals(PUBLIC_SCOPE)</code>.
     * 
     * @return true if the cache scope is public for the
     *         current response.
     */
    public boolean isPublicScope();
    
    /**
     * Sets the caching scope for the current response
     * to public with <code>true</code> as 
     * <code>publicScope</code> and to private with
     * <code>false</code> as <code>publicScope</code>.
     * <p>
     * Public cache scope indicates that the cache entry can be shared across
     * users. Non-public, or private cache scope indicates that the cache entry 
     * must not be shared across users.
     * <p>
     * This call is equivalent to calling
     * <code>(publicScope ? setProperty(CACHE_SCOPE, PUBLIC_SCOPE | 
     *        setProperty(CACHE_SCOPE, PRIVATE_SCOPE)</code>.
     * 
     * @param publicScope
     */
    public void setPublicScope(boolean publicScope);
    
    /**
     * Returns the ETag for the current response that is
     * used as validation tag, or <code>null</null>
     * if no ETag is set.
     * <p>
     * This call is equivalent to calling
     * <code>getProperty(ETAG)</code>.
     * 
     * @return  the ETag for the current response that is
     *          used as validation tag, or <code>null</null>
     *          if no ETag is set.
     */
    public String getETag();
    
    /**
     * Sets an ETag for the current response that is
     * used as validation tag. If an ETag was already
     * set it is replaced with the new value.
     * <p>
     * This call is equivalent to calling
     * <code>setProperty(ETAG, token)</code>.
     *  
     * @param token
     */
    public void setETag(String token);
    
    
    /**
     * Returns a boolean indicating whether the
     * caching scope is set to public for the current response.
     * If no caching scope is set, the default scope
     * is not public and thus returns false.
     * <p>
     * Public cache scope indicates that the cache entry can be shared across
     * users. Non-public, or private cache scope indicates that the cache entry
     * must not be shared across users.
     * <p>
     * This call is equivalent to calling
     * <code>getProperty(CACHE_SCOPE).equals(PUBLIC_SCOPE)</code>.
     * 
     * @return  boolean indicating whether the
     *          caching scope is set to public for the current response
     */
    public boolean useCachedContent();
    
    /**
     * 
     * @param useCachedContent
     */
    public void setUseCachedContent(boolean useCachedContent);

}
