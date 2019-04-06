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

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.mvc.MvcContext;
import javax.validation.ConstraintViolation;
import javax.validation.ElementKind;
import javax.validation.MessageInterpolator;
import javax.validation.Path;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;


/**
 * @author  Neil Griffin
 */
@Interceptor
@BeanValidationInterceptorBinding
@Priority(Interceptor.Priority.LIBRARY_BEFORE)
public class BeanValidationInterceptor implements Serializable {

	private static final long serialVersionUID = 2378576156374329311L;

	@BeanValidationMessageInterpolator
	@Inject
	private MessageInterpolator messageInterpolator;

	@Inject
	private MutableBindingResult mutableBindingResult;

	@Inject
	private MvcContext mvcContext;

	@Inject
	private ValidatorFactory validatorFactory;

	@AroundInvoke
	public Object validateMethodInvocation(InvocationContext invocationContext) throws Exception {

		Validator validator = validatorFactory.getValidator();

		if (validator == null) {
			return invocationContext.proceed();
		}

		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(invocationContext.getTarget());

		for (ConstraintViolation<Object> constraintViolation : constraintViolations) {

			Path propertyPath = constraintViolation.getPropertyPath();

			Path.Node lastPathNode = null;

			for (Path.Node pathNode : propertyPath) {
				lastPathNode = pathNode;
			}

			if ((lastPathNode != null) && (lastPathNode.getKind() == ElementKind.PROPERTY)) {

				Object leafBean = constraintViolation.getLeafBean();
				Class<?> leafBeanClass = leafBean.getClass();

				BeanInfo beanInfo = Introspector.getBeanInfo(leafBean.getClass());

				PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

				for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
					String propertyDescriptorName = propertyDescriptor.getName();

					if (propertyDescriptorName.equals("targetClass")) {
						Method readMethod = propertyDescriptor.getReadMethod();
						leafBeanClass = (Class<?>) readMethod.invoke(leafBean);
					}
				}

				Field leafBeanField = leafBeanClass.getDeclaredField(lastPathNode.getName());

				String paramName = null;

				Annotation[] annotations = leafBeanField.getAnnotations();

				for (Annotation annotation : annotations) {

					if (annotation instanceof CookieParam) {
						CookieParam cookieParam = (CookieParam) annotation;
						paramName = cookieParam.value();

						break;
					}
					else if (annotation instanceof FormParam) {
						FormParam formParam = (FormParam) annotation;
						paramName = formParam.value();

						break;
					}
					else if (annotation instanceof HeaderParam) {
						HeaderParam headerParam = (HeaderParam) annotation;
						paramName = headerParam.value();

						break;
					}
					else if (annotation instanceof QueryParam) {
						QueryParam queryParam = (QueryParam) annotation;
						paramName = queryParam.value();
					}
				}

				String interpolatedMessage = constraintViolation.getMessage();

				if (messageInterpolator != null) {
					interpolatedMessage = messageInterpolator.interpolate(constraintViolation.getMessageTemplate(),
							new MessageInterpolatorContextImpl(constraintViolation), mvcContext.getLocale());
				}

				mutableBindingResult.addValidationError(new ValidationErrorImpl(paramName, interpolatedMessage,
						constraintViolation));
			}

		}

		return invocationContext.proceed();
	}
}
