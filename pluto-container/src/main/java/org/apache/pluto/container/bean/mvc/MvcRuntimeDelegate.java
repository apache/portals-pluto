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

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Variant;
import javax.ws.rs.ext.RuntimeDelegate;


/**
 * @author  Neil Griffin
 */
public class MvcRuntimeDelegate extends RuntimeDelegate {

	@Override
	public <T> T createEndpoint(Application application, Class<T> aClass) throws IllegalArgumentException,
		UnsupportedOperationException {
		return null;
	}

	@Override
	public <T> HeaderDelegate<T> createHeaderDelegate(Class<T> aClass) throws IllegalArgumentException {
		return new HeaderDelegate<T>() {
				@Override
				public T fromString(String s) {
					return (T) s;
				}

				@Override
				public String toString(T t) {
					return t.toString();
				}
			};
	}

	@Override
	public Link.Builder createLinkBuilder() {
		return null;
	}

	@Override
	public Response.ResponseBuilder createResponseBuilder() {
		return null;
	}

	@Override
	public UriBuilder createUriBuilder() {
		return null;
	}

	@Override
	public Variant.VariantListBuilder createVariantListBuilder() {
		return null;
	}
}
