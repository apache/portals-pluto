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

import java.lang.reflect.Method;

import javax.enterprise.inject.Vetoed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author  Neil Griffin
 */
@Vetoed
public class SpringCsrfToken {

	private static final Logger LOG = LoggerFactory.getLogger(SpringCsrfToken.class);

	private String name;
	private String value;

	public SpringCsrfToken(Object springCsrfToken) {

		if (springCsrfToken != null) {

			Class<?> springCsrfTokenClass = springCsrfToken.getClass();

			try {
				Method getParameterNameMethod = springCsrfTokenClass.getMethod("getParameterName", new Class[] {});
				getParameterNameMethod.setAccessible(true);
				name = (String) getParameterNameMethod.invoke(springCsrfToken, new Object[] {});

				Method getTokenMethod = springCsrfTokenClass.getMethod("getToken", null);
				getTokenMethod.setAccessible(true);
				value = (String) getTokenMethod.invoke(springCsrfToken, null);
			}
			catch (Exception e) {
				LOG.error(e.getMessage(), e);
			}
		}
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
}
