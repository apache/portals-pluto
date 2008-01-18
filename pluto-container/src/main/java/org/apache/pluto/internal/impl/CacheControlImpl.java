/*
 * Copyright 2003,2004 The Apache Software Foundation.
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

package org.apache.pluto.internal.impl;

import javax.portlet.CacheControl;
import javax.portlet.MimeResponse;

/**
 * Implementation of JSR-286 <code>CacheControl</code>.
 *
 * @since 2.0
 * TODO: Move CachControlImpl from inner Class to this implementation
 */
public class CacheControlImpl implements CacheControl {

	MimeResponseImpl mimeResponseImpl;
	private String eTag;

	private int expirationTime;

	private boolean publicScope;

	private boolean cachedContent;

	public CacheControlImpl(MimeResponseImpl mimeResponseImpl) {
		this.mimeResponseImpl = mimeResponseImpl;
	}

	public boolean useCachedContent() {
		return this.cachedContent;
	}

	public String getETag() {
		return this.eTag;
	}

	public int getExpirationTime() {
		return this.expirationTime;
	}

	public boolean isPublicScope() {
		return this.publicScope;
	}

	public void setETag(String eTag) {
		this.eTag = eTag;
	}

	public void setExpirationTime(int expirationTime) {
		this.expirationTime = expirationTime;
		mimeResponseImpl.setProperty(MimeResponse.EXPIRATION_CACHE, String
				.valueOf(expirationTime));
	}

	public void setPublicScope(boolean publicScope) {
		this.publicScope = publicScope;
		mimeResponseImpl.setProperty(MimeResponse.PUBLIC_SCOPE,
				publicScope ? MimeResponse.PUBLIC_SCOPE : MimeResponse.PRIVATE_SCOPE);
	}

	public void setUseCachedContent(boolean cachedContent) {
		this.cachedContent = cachedContent;
		mimeResponseImpl.setProperty(MimeResponse.USE_CACHED_CONTENT,
				cachedContent ? Boolean.TRUE.toString() : null);
	}

}
