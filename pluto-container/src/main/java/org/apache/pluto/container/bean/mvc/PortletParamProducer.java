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
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.portlet.ClientDataRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.Cookie;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author  Neil Griffin
 */
@Dependent
public class PortletParamProducer {

	private static final Logger LOG = LoggerFactory.getLogger(PortletParamProducer.class);

	@Inject
	private MutableBindingResult mutableBindingResult;

	@Inject
	@ParamConverterProviders
	private List<ParamConverterProvider> paramConverterProviders;

	@Dependent
	@PortletParam
	@Produces
	public Boolean getBooleanParam(ClientDataRequest clientDataRequest, PortletResponse portletResponse,
		InjectionPoint injectionPoint) {

		String value = getStringParam(clientDataRequest, portletResponse, injectionPoint);

		if (value == null) {
			return null;
		}

		Annotated field = injectionPoint.getAnnotated();

		Annotation[] fieldAnnotations = _getFieldAnnotations(field);

		ParamConverter<Boolean> paramConverter = _getParamConverter(Boolean.class, field.getBaseType(),
				fieldAnnotations);

		if (paramConverter != null) {

			try {
				return paramConverter.fromString(value);
			}
			catch (IllegalArgumentException iae) {
				_addBindingError(fieldAnnotations, iae.getMessage(), value);

				return null;
			}
		}

		if (LOG.isWarnEnabled()) {
			LOG.warn("Unable to find a ParamConverterProvider for type Boolean");
		}

		return null;
	}

	@Dependent
	@PortletParam
	@Produces
	public Date getDateParam(ClientDataRequest clientDataRequest, PortletResponse portletResponse,
		InjectionPoint injectionPoint) {

		String value = getStringParam(clientDataRequest, portletResponse, injectionPoint);

		if (value == null) {
			return null;
		}

		Annotated field = injectionPoint.getAnnotated();

		Annotation[] fieldAnnotations = _getFieldAnnotations(field);

		ParamConverter<Date> paramConverter = _getParamConverter(Date.class, field.getBaseType(), fieldAnnotations);

		if (paramConverter != null) {

			try {
				return paramConverter.fromString(value);
			}
			catch (IllegalArgumentException iae) {
				_addBindingError(fieldAnnotations, iae.getMessage(), value);

				return null;
			}
		}

		if (LOG.isWarnEnabled()) {
			LOG.warn("Unable to find a ParamConverterProvider for type Date");
		}

		return null;
	}

	@Dependent
	@PortletParam
	@Produces
	public Double getDoubleParam(ClientDataRequest clientDataRequest, PortletResponse portletResponse,
		InjectionPoint injectionPoint) {

		String value = getStringParam(clientDataRequest, portletResponse, injectionPoint);

		if (value == null) {
			return null;
		}

		Annotated field = injectionPoint.getAnnotated();

		Annotation[] fieldAnnotations = _getFieldAnnotations(field);

		ParamConverter<Double> paramConverter = _getParamConverter(Double.class, field.getBaseType(), fieldAnnotations);

		if (paramConverter != null) {

			try {
				return paramConverter.fromString(value);
			}
			catch (IllegalArgumentException iae) {
				_addBindingError(fieldAnnotations, iae.getMessage(), value);

				return null;
			}
		}

		if (LOG.isWarnEnabled()) {
			LOG.warn("Unable to find a ParamConverterProvider for type Double");
		}

		return null;
	}

	@Dependent
	@PortletParam
	@Produces
	public Float getFloatParam(ClientDataRequest clientDataRequest, PortletResponse portletResponse,
		InjectionPoint injectionPoint) {

		String value = getStringParam(clientDataRequest, portletResponse, injectionPoint);

		if (value == null) {
			return null;
		}

		Annotated field = injectionPoint.getAnnotated();

		Annotation[] fieldAnnotations = _getFieldAnnotations(field);

		ParamConverter<Float> paramConverter = _getParamConverter(Float.class, field.getBaseType(), fieldAnnotations);

		if (paramConverter != null) {

			try {
				return paramConverter.fromString(value);
			}
			catch (IllegalArgumentException iae) {
				_addBindingError(fieldAnnotations, iae.getMessage(), value);

				return null;
			}
		}

		if (LOG.isWarnEnabled()) {
			LOG.warn("Unable to find a ParamConverterProvider for type Float");
		}

		return null;
	}

	@Dependent
	@PortletParam
	@Produces
	public Integer getIntegerParam(ClientDataRequest clientDataRequest, PortletResponse portletResponse,
		InjectionPoint injectionPoint) {

		String value = getStringParam(clientDataRequest, portletResponse, injectionPoint);

		if (value == null) {
			return null;
		}

		Annotated field = injectionPoint.getAnnotated();

		Annotation[] fieldAnnotations = _getFieldAnnotations(field);

		ParamConverter<Integer> paramConverter = _getParamConverter(Integer.class, field.getBaseType(),
				fieldAnnotations);

		if (paramConverter != null) {

			try {
				return paramConverter.fromString(value);
			}
			catch (IllegalArgumentException iae) {
				_addBindingError(fieldAnnotations, iae.getMessage(), value);

				return null;
			}
		}

		if (LOG.isWarnEnabled()) {
			LOG.warn("Unable to find a ParamConverterProvider for type Integer");
		}

		return null;
	}

	@Dependent
	@PortletParam
	@Produces
	public Long getLongParam(ClientDataRequest clientDataRequest, PortletResponse portletResponse,
		InjectionPoint injectionPoint) {

		String value = getStringParam(clientDataRequest, portletResponse, injectionPoint);

		if (value == null) {
			return null;
		}

		Annotated field = injectionPoint.getAnnotated();

		Annotation[] fieldAnnotations = _getFieldAnnotations(field);

		ParamConverter<Long> paramConverter = _getParamConverter(Long.class, field.getBaseType(), fieldAnnotations);

		if (paramConverter != null) {

			try {
				return paramConverter.fromString(value);
			}
			catch (IllegalArgumentException iae) {
				_addBindingError(fieldAnnotations, iae.getMessage(), value);

				return null;
			}
		}

		if (LOG.isWarnEnabled()) {
			LOG.warn("Unable to find a ParamConverterProvider for type Long");
		}

		return Long.valueOf(value);
	}

	@Dependent
	@PortletParam
	@Produces
	public String getStringParam(ClientDataRequest clientDataRequest, PortletResponse portletResponse,
		InjectionPoint injectionPoint) {

		Annotated field = injectionPoint.getAnnotated();

		String defaultValue = null;

		DefaultValue defaultValueAnnotation = field.getAnnotation(DefaultValue.class);

		if (defaultValueAnnotation != null) {
			defaultValue = defaultValueAnnotation.value();
		}

		CookieParam cookieParam = field.getAnnotation(CookieParam.class);

		if (cookieParam != null) {
			Cookie[] cookies = clientDataRequest.getCookies();

			for (Cookie cookie : cookies) {

				if (Objects.equals(cookieParam.value(), cookie.getName())) {
					String cookieValue = cookie.getValue();

					if (cookieValue == null) {

						if (LOG.isDebugEnabled()) {
							LOG.debug("Injecting the default value=" + defaultValue + " into a field annotated " +
								"with @CookieParam(\"" + cookieParam.value() +
								"\") because the cookie does not have a " + "value.");
						}

						return defaultValue;
					}

					return cookieValue;
				}
			}

			if (LOG.isDebugEnabled()) {
				LOG.debug("Injecting the default value=" + defaultValue +
					" into a field annotated with @CookieParam(\"" + cookieParam.value() +
					"\") because there is no cookie " + "with that name.");
			}

			return defaultValue;
		}

		FormParam formParam = field.getAnnotation(FormParam.class);

		if (formParam != null) {
			String lifecyclePhase = (String) clientDataRequest.getAttribute(PortletRequest.LIFECYCLE_PHASE);

			String httpMethod = clientDataRequest.getMethod();

			if ("post".equalsIgnoreCase(httpMethod) &&
					(lifecyclePhase.equals(PortletRequest.ACTION_PHASE) ||
						lifecyclePhase.equals(PortletRequest.RESOURCE_PHASE))) {

				String parameterValue = clientDataRequest.getParameter(formParam.value());

				if (parameterValue == null) {
					parameterValue = clientDataRequest.getParameter(portletResponse.getNamespace() + formParam.value());
				}

				if (parameterValue == null) {

					if (LOG.isDebugEnabled()) {
						LOG.debug("Injecting the default value=" + defaultValue +
							" into a field annotated with @FormParam(\"" + formParam.value() +
							"\") because the request " + "parameter does not have a value.");
					}

					return defaultValue;
				}

				return parameterValue;
			}

			if (LOG.isDebugEnabled()) {

				if (lifecyclePhase.equals(PortletRequest.RENDER_PHASE)) {
					LOG.debug("Injection into a field annotated with " + "@FormParam(\"" + formParam.value() +
						"\") is " + "invalid during the RENDER_PHASE.");
				}
				else {
					LOG.debug("Injection into a field annotated with " + "@FormParam(\"" + formParam.value() +
						"\") is " + "invalid during the " + lifecyclePhase + " (HTTP " + httpMethod + ") request.");
				}
			}

			return null;
		}

		HeaderParam headerParam = field.getAnnotation(HeaderParam.class);

		if (headerParam != null) {
			Enumeration<String> propertyNames = clientDataRequest.getPropertyNames();

			while (propertyNames.hasMoreElements()) {
				String propertyName = propertyNames.nextElement();

				if (Objects.equals(headerParam.value(), propertyName)) {
					String headerValue = clientDataRequest.getProperty(propertyName);

					if (headerValue == null) {

						if (LOG.isDebugEnabled()) {
							LOG.debug("Injecting the default value=" + defaultValue + " into a field annotated " +
								"with @HeaderParam(\"" + headerParam.value() +
								"\") because the header does not have a " + "value.");
						}

						return defaultValue;
					}

					return headerValue;
				}
			}

			if (LOG.isDebugEnabled()) {
				LOG.debug("Injecting the default value=" + defaultValue +
					" into a field annotated with @HeaderParam(\"" + headerParam.value() +
					"\") because there is no header with that name.");
			}

			return defaultValue;
		}

		QueryParam queryParam = field.getAnnotation(QueryParam.class);

		if (queryParam != null) {
			String parameterValue = clientDataRequest.getParameter(queryParam.value());

			if (parameterValue == null) {
				parameterValue = clientDataRequest.getParameter(portletResponse.getNamespace() + queryParam.value());
			}

			if (parameterValue == null) {

				if (LOG.isDebugEnabled()) {
					LOG.debug("Injecting the default value=" + defaultValue +
						" into a field annotated with @QueryParam(\"" + queryParam.value() +
						"\") because the request parameter does not have " + "a value.");
				}

				return defaultValue;
			}

			return parameterValue;
		}

		return defaultValue;
	}

	private void _addBindingError(Annotation[] fieldAnnotations, String message, String value) {

		if (mutableBindingResult == null) {
			LOG.error("Unable to add binding error");
		}
		else {
			mutableBindingResult.addBindingError(new BindingErrorImpl(_getParamName(fieldAnnotations), message, value));
		}
	}

	private Annotation[] _getFieldAnnotations(Annotated field) {
		Set<Annotation> annotations = field.getAnnotations();

		return annotations.toArray(new Annotation[annotations.size()]);
	}

	private <T> ParamConverter _getParamConverter(Class<?> rawType, Type baseType, Annotation[] annotations) {

		for (ParamConverterProvider paramConverterProvider : paramConverterProviders) {

			ParamConverter<T> paramConverter = paramConverterProvider.getConverter((Class<T>) rawType, baseType,
					annotations);

			if (paramConverter != null) {
				return paramConverter;
			}
		}

		return null;
	}

	private String _getParamName(Annotation[] annotations) {

		for (Annotation annotation : annotations) {
			Class<? extends Annotation> annotationClass = annotation.getClass();

			if (CookieParam.class.isAssignableFrom(annotationClass)) {
				CookieParam cookieParam = (CookieParam) annotation;

				return cookieParam.value();
			}

			if (FormParam.class.isAssignableFrom(annotationClass)) {
				FormParam formParam = (FormParam) annotation;

				return formParam.value();
			}

			if (HeaderParam.class.isAssignableFrom(annotationClass)) {
				HeaderParam headerParam = (HeaderParam) annotation;

				return headerParam.value();
			}

			if (QueryParam.class.isAssignableFrom(annotationClass)) {
				QueryParam queryParam = (QueryParam) annotation;

				return queryParam.value();
			}
		}

		return null;
	}
}
