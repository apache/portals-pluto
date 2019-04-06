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

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.enterprise.inject.Vetoed;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;


/**
 * @author  Neil Griffin
 */
@Vetoed
public class BeanUtil {

	public static <T> List<T> getBeanInstances(BeanManager beanManager, Class<T> type, Annotation... qualifiers) {

		List<T> beanInstances = new ArrayList<>();

		if (qualifiers == null) {
			qualifiers = new Annotation[] {};
		}

		Set<Bean<?>> beans = beanManager.getBeans(type, qualifiers);

		for (Bean<?> bean : beans) {
			beanInstances.add((T) beanManager.getReference(bean, type, beanManager.createCreationalContext(bean)));
		}

		return beanInstances;
	}
}
