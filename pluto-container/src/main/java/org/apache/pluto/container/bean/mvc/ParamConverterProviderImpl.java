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
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.function.Function;

import javax.inject.Inject;
import javax.mvc.MvcContext;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;


/**
 * @author  Neil Griffin
 */
public class ParamConverterProviderImpl implements ParamConverterProvider {

	@Inject
	private MvcContext mvcContext;

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {

		if (rawType == null) {
			return null;
		}

		if (rawType.equals(Integer.class) || rawType.equals(Integer.TYPE) || rawType.equals(Long.class) ||
				rawType.equals(Long.TYPE) || rawType.equals(Double.class) || rawType.equals(Double.TYPE) ||
				rawType.equals(Float.class) || rawType.equals(Float.TYPE) || rawType.equals(Boolean.class) ||
				rawType.equals(Boolean.TYPE)) {

			return new ParamConverter<T>() {
					@Override
					public T fromString(String value) {

						if (value == null) {
							throw new IllegalArgumentException("Unable to convert a null parameter value");
						}

						if (rawType.equals(Integer.class) || rawType.equals(Integer.TYPE)) {
							Function<Number, Integer> numberIntegerFunction = new Function<Number, Integer>() {
									@Override
									public Integer apply(Number number) {
										return number.intValue();
									}
								};

							return _getNumber(value, numberIntegerFunction);
						}
						else if (rawType.equals(Long.class) || rawType.equals(Long.TYPE)) {
							Function<Number, Long> numberLongFunction = new Function<Number, Long>() {
									@Override
									public Long apply(Number number) {
										return number.longValue();
									}
								};

							return _getNumber(value, numberLongFunction);
						}
						else if (rawType.equals(Double.class) || rawType.equals(Double.TYPE)) {
							Function<Number, Double> numberDoubleFunction = new Function<Number, Double>() {
									@Override
									public Double apply(Number number) {
										return number.doubleValue();
									}
								};

							return _getNumber(value, numberDoubleFunction);
						}
						else if (rawType.equals(Float.class) || rawType.equals(Float.TYPE)) {
							Function<Number, Float> numberFloatFunction = new Function<Number, Float>() {
									@Override
									public Float apply(Number number) {
										return number.floatValue();
									}
								};

							return _getNumber(value, numberFloatFunction);
						}
						else if (rawType.equals(Boolean.class) || rawType.equals(Boolean.TYPE)) {

							if (value == null) {
								return (T) Boolean.FALSE;
							}

							value = value.trim();
							value = value.toLowerCase();

							if (Boolean.valueOf(value)) {
								return (T) Boolean.TRUE;
							}

							return (T) Boolean.valueOf(value.equals("on"));
						}

						return null;
					}

					private T _getNumber(String value, Function getNumberFunction) {
						NumberFormat numberFormat = NumberFormat.getInstance(mvcContext.getLocale());

						try {
							Number number = numberFormat.parse(value);

							return (T) getNumberFunction.apply(number);
						}
						catch (ParseException pe) {
							throw new IllegalArgumentException(pe);
						}
					}

					@Override
					public String toString(T value) {

						if (value == null) {
							return "";
						}

						return value.toString();
					}
				};
		}
		else {
			return null;
		}
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
