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
import java.util.LinkedHashSet;
import java.util.Set;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Vetoed;
import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author  Neil Griffin
 */
@Vetoed
public class MvcExtension implements Extension {

	private static final Logger LOG = LoggerFactory.getLogger(MvcExtension.class);

	private static final Annotation BEAN_VALIDATION_INTERCEPTOR_BINDING = new BeanValidationInterceptorBinding() {

			@Override
			public Class<? extends Annotation> annotationType() {
				return BeanValidationInterceptorBinding.class;
			}
		};

	private static final Annotation CONTROLLER_INTERCEPTOR_BINDING = new ControllerInterceptorBinding() {

			@Override
			public Class<? extends Annotation> annotationType() {
				return ControllerInterceptorBinding.class;
			}
		};

	private static final Annotation CSRF_VALIDATION_INTERCEPTOR_BINDING = new CsrfValidationInterceptorBinding() {

			@Override
			public Class<? extends Annotation> annotationType() {
				return CsrfValidationInterceptorBinding.class;
			}
		};

	private static final Annotation INJECT = new Inject() {

			@Override
			public Class<? extends Annotation> annotationType() {
				return Inject.class;
			}

		};

	private static final Annotation PORTLET_PARAM = new PortletParam() {

			@Override
			public Class<? extends Annotation> annotationType() {
				return PortletParam.class;
			}

		};

	private static final Class<? extends Annotation>[] UNSUPPORTED_ANNOTATION_CLASSES = new Class[] {
			MatrixParam.class, PathParam.class
		};

	public static <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> processAnnotatedType) {

		AnnotatedType<T> annotatedType = processAnnotatedType.getAnnotatedType();

		boolean modifiedMethods = false;

		Set<AnnotatedMethod<? super T>> annotatedMethods = new LinkedHashSet<>();

		boolean typeLevelController = annotatedType.isAnnotationPresent(Controller.class);

		for (AnnotatedMethod<? super T> annotatedMethod : annotatedType.getMethods()) {

			ActionMethod actionMethod = annotatedMethod.getAnnotation(ActionMethod.class);

			RenderMethod renderMethod = annotatedMethod.getAnnotation(RenderMethod.class);

			ServeResourceMethod serveResourceMethod = annotatedMethod.getAnnotation(ServeResourceMethod.class);

			if (((actionMethod != null) || (renderMethod != null) || (serveResourceMethod != null)) &&
					(typeLevelController || annotatedMethod.isAnnotationPresent(Controller.class))) {

				Set<Annotation> methodAnnotations = new LinkedHashSet<>(annotatedMethod.getAnnotations());

				methodAnnotations.add(CONTROLLER_INTERCEPTOR_BINDING);

				modifiedMethods = true;

				if ((actionMethod != null) || (serveResourceMethod != null)) {
					methodAnnotations.add(CSRF_VALIDATION_INTERCEPTOR_BINDING);
				}

				ValidateOnExecution validateOnExecution = annotatedMethod.getAnnotation(ValidateOnExecution.class);

				boolean addBeanValidationInterceptor = true;

				if (validateOnExecution != null) {
					ExecutableType[] executableTypes = validateOnExecution.type();

					for (ExecutableType executableType : executableTypes) {

						if (executableType == ExecutableType.NONE) {
							addBeanValidationInterceptor = false;

							break;
						}
					}
				}

				if (addBeanValidationInterceptor) {
					methodAnnotations.add(BEAN_VALIDATION_INTERCEPTOR_BINDING);
				}

				annotatedMethod = new ModifiedMethod<>(annotatedMethod, methodAnnotations);
			}

			annotatedMethods.add(annotatedMethod);
		}

		boolean modifiedFieldAnnotations = false;

		Set<AnnotatedField<? super T>> annotatedFields = new LinkedHashSet<>();

		for (AnnotatedField<? super T> annotatedField : annotatedType.getFields()) {

			Set<Annotation> fieldAnnotations = new LinkedHashSet<>(annotatedField.getAnnotations());

			for (Class<? extends Annotation> unsupportedAnnotationClass : UNSUPPORTED_ANNOTATION_CLASSES) {

				Annotation unsupportedAnnotation = annotatedField.getAnnotation(unsupportedAnnotationClass);

				if (unsupportedAnnotation != null) {

					fieldAnnotations.remove(unsupportedAnnotation);

					modifiedFieldAnnotations = true;

					if (LOG.isWarnEnabled()) {
						LOG.warn("Removed unsupported @" + unsupportedAnnotationClass.getSimpleName() +
							" annotation from " + annotatedField);
					}
				}

			}

			BeanParam beanParam = annotatedField.getAnnotation(BeanParam.class);
			CookieParam cookieParam = annotatedField.getAnnotation(CookieParam.class);
			FormParam formParam = annotatedField.getAnnotation(FormParam.class);
			HeaderParam headerParam = annotatedField.getAnnotation(HeaderParam.class);
			QueryParam queryParam = annotatedField.getAnnotation(QueryParam.class);

			if ((beanParam != null) || (cookieParam != null) || (formParam != null) || (headerParam != null) ||
					(queryParam != null)) {

				if (!annotatedField.isAnnotationPresent(Inject.class)) {
					fieldAnnotations.add(INJECT);
					modifiedFieldAnnotations = true;
				}

				if (beanParam == null) {
					fieldAnnotations.add(PORTLET_PARAM);
					modifiedFieldAnnotations = true;
				}

			}

			if (modifiedFieldAnnotations) {
				annotatedField = new ModifiedField(annotatedField, fieldAnnotations);
			}

			annotatedFields.add(annotatedField);
		}

		if (modifiedMethods || modifiedFieldAnnotations) {
			processAnnotatedType.setAnnotatedType(new ModifiedAnnotatedType<>(annotatedType, annotatedFields,
					annotatedMethods));
		}
	}
}
