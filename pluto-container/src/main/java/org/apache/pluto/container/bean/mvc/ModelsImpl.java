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

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.inject.Named;
import javax.mvc.Models;
import javax.mvc.RedirectScoped;


/**
 * @author  Neil Griffin
 */
@Named("models")
@RedirectScoped
public class ModelsImpl implements Models, Serializable {

	private static final long serialVersionUID = 2433287856890024741L;

	private final Map<String, Object> modelsMap = new LinkedHashMap<>();

	@Override
	public Map<String, Object> asMap() {
		return Collections.unmodifiableMap(modelsMap);
	}

	public void clear() {
		modelsMap.clear();
	}

	@Override
	public Object get(String name) {
		return get(name, Object.class);
	}

	@Override
	public <T> T get(String name, Class<T> type) {
		return type.cast(modelsMap.get(name));
	}

	@Override
	public Iterator<String> iterator() {
		Set<String> keySet = modelsMap.keySet();

		return keySet.iterator();
	}

	@Override
	public Models put(String name, Object model) {
		modelsMap.put(name, model);

		return this;
	}
}
