/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.container.bean.mvc;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;


/**
 * @author  Neil Griffin
 */
public class UriInfoImpl implements UriInfo {

	@Override
	public URI getAbsolutePath() {
		throw new UnsupportedOperationException();
	}

	@Override
	public UriBuilder getAbsolutePathBuilder() {
		throw new UnsupportedOperationException();
	}

	@Override
	public URI getBaseUri() {
		throw new UnsupportedOperationException();
	}

	@Override
	public UriBuilder getBaseUriBuilder() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Object> getMatchedResources() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<String> getMatchedURIs() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<String> getMatchedURIs(boolean decode) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getPath() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getPath(boolean decode) {
		throw new UnsupportedOperationException();
	}

	@Override
	public MultivaluedMap<String, String> getPathParameters() {
		throw new UnsupportedOperationException();
	}

	@Override
	public MultivaluedMap<String, String> getPathParameters(boolean decode) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<PathSegment> getPathSegments() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<PathSegment> getPathSegments(boolean decode) {
		throw new UnsupportedOperationException();
	}

	@Override
	public MultivaluedMap<String, String> getQueryParameters() {
		throw new UnsupportedOperationException();
	}

	@Override
	public MultivaluedMap<String, String> getQueryParameters(boolean decode) {
		throw new UnsupportedOperationException();
	}

	@Override
	public URI getRequestUri() {
		throw new UnsupportedOperationException();
	}

	@Override
	public UriBuilder getRequestUriBuilder() {
		throw new UnsupportedOperationException();
	}

	@Override
	public URI relativize(URI uri) {
		throw new UnsupportedOperationException();
	}

	@Override
	public URI resolve(URI uri) {
		throw new UnsupportedOperationException();
	}
}
