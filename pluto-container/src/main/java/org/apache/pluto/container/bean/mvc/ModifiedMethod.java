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
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.AnnotatedParameter;
import javax.enterprise.inject.spi.AnnotatedType;


/**
 * @author  Neil Griffin
 */
public class ModifiedMethod<X> implements AnnotatedMethod<X> {

	private AnnotatedMethod annotatedMethod;
	private Set<Annotation> annotations;

	public ModifiedMethod(AnnotatedMethod<X> annotatedMethod, Set<Annotation> annotations) {
		this.annotatedMethod = annotatedMethod;
		this.annotations = annotations;
	}

	@Override
	public <T extends Annotation> T getAnnotation(Class<T> annotationType) {

		for (Annotation annotation : annotations) {
			Class<? extends Annotation> curAnnotationType = annotation.annotationType();

			if (curAnnotationType.equals(annotationType)) {
				return annotationType.cast(annotation);
			}
		}

		return null;
	}

	@Override
	public Set<Annotation> getAnnotations() {
		return annotations;
	}

	@Override
	public Type getBaseType() {
		return annotatedMethod.getBaseType();
	}

	@Override
	public AnnotatedType<X> getDeclaringType() {
		return annotatedMethod.getDeclaringType();
	}

	@Override
	public Method getJavaMember() {
		return annotatedMethod.getJavaMember();
	}

	@Override
	public List<AnnotatedParameter<X>> getParameters() {
		return annotatedMethod.getParameters();
	}

	@Override
	public Set<Type> getTypeClosure() {
		return annotatedMethod.getTypeClosure();
	}

	@Override
	public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {

		Annotation annotation = getAnnotation(annotationType);

		if (annotation == null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isStatic() {
		return annotatedMethod.isStatic();
	}
}
