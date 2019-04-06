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
import java.lang.reflect.Type;
import java.util.Set;

import javax.enterprise.inject.spi.AnnotatedConstructor;
import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.AnnotatedType;


/**
 * @author  Neil Griffin
 */
public class ModifiedAnnotatedType<X> implements AnnotatedType<X> {

	private final AnnotatedType<X> annotatedType;
	private final Set<AnnotatedField<? super X>> fields;
	private final Set<AnnotatedMethod<? super X>> methods;

	public ModifiedAnnotatedType(AnnotatedType<X> annotatedType, Set<AnnotatedField<? super X>> fields,
		Set<AnnotatedMethod<? super X>> methods) {
		this.annotatedType = annotatedType;
		this.fields = fields;
		this.methods = methods;
	}

	@Override
	public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
		return annotatedType.getAnnotation(annotationType);
	}

	@Override
	public Set<Annotation> getAnnotations() {
		return annotatedType.getAnnotations();
	}

	@Override
	public Type getBaseType() {
		return annotatedType.getBaseType();
	}

	@Override
	public Set<AnnotatedConstructor<X>> getConstructors() {
		return annotatedType.getConstructors();
	}

	@Override
	public Set<AnnotatedField<? super X>> getFields() {
		return fields;
	}

	@Override
	public Class<X> getJavaClass() {
		return annotatedType.getJavaClass();
	}

	@Override
	public Set<AnnotatedMethod<? super X>> getMethods() {
		return methods;
	}

	@Override
	public Set<Type> getTypeClosure() {
		return annotatedType.getTypeClosure();
	}

	@Override
	public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
		return annotatedType.isAnnotationPresent(annotationType);
	}

}
