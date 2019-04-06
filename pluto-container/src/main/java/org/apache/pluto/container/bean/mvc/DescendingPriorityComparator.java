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

import java.util.Comparator;

import javax.annotation.Priority;
import javax.enterprise.inject.Vetoed;


/**
 * @author  Neil Griffin
 */
@Vetoed
public class DescendingPriorityComparator<T> implements Comparator<Object> {

	private int _defaultPriority;

	public DescendingPriorityComparator() {
		this(0);
	}

	public DescendingPriorityComparator(int defaultPriority) {
		_defaultPriority = defaultPriority;
	}

	@Override
	public int compare(Object object1, Object object2) {
		Class<?> class1 = object1.getClass();
		Priority priority1 = class1.getAnnotation(Priority.class);
		Class<?> class2 = object2.getClass();
		Priority priority2 = class2.getAnnotation(Priority.class);

		if ((priority1 == null) && (priority2 == null)) {
			return 0;
		}
		else if (priority1 == null) {
			return Integer.compare(priority2.value(), _defaultPriority);
		}
		else if (priority2 == null) {
			return Integer.compare(_defaultPriority, priority1.value());
		}
		else {
			return Integer.compare(priority1.value(), priority2.value());
		}
	}
}
