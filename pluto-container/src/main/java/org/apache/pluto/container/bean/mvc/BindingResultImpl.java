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
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.mvc.RedirectScoped;
import javax.mvc.binding.BindingError;
import javax.mvc.binding.ParamError;
import javax.mvc.binding.ValidationError;


/**
 * @author  Neil Griffin
 */
@RedirectScoped
public class BindingResultImpl implements MutableBindingResult, Serializable {

	private static final long serialVersionUID = 2217732469752342741L;

	private Set<BindingError> bindingErrors = new LinkedHashSet<>();
	private boolean consulted = false;
	private Set<ValidationError> validationErrors = new LinkedHashSet<>();

	@Override
	public void addBindingError(BindingError bindingError) {
		bindingErrors.add(bindingError);
	}

	@Override
	public void addValidationError(ValidationError validationError) {
		validationErrors.add(validationError);
	}

	public void clear() {
		bindingErrors.clear();
		validationErrors.clear();
		consulted = false;
	}

	@Override
	public Set<ParamError> getAllErrors() {

		consulted = true;

		Set<ParamError> allErrors = new LinkedHashSet<>();
		allErrors.addAll(bindingErrors);
		allErrors.addAll(validationErrors);

		return allErrors;
	}

	@Override
	public List<String> getAllMessages() {

		consulted = true;

		List<String> allMessages = new ArrayList<>();

		for (BindingError bindingError : bindingErrors) {
			allMessages.add(bindingError.getMessage());
		}

		for (ValidationError validationError : validationErrors) {
			allMessages.add(validationError.getMessage());
		}

		return allMessages;
	}

	@Override
	public Set<ParamError> getErrors(String paramName) {
		consulted = true;

		Set<ParamError> errors = new LinkedHashSet<>();

		for (BindingError bindingError : bindingErrors) {

			if (Objects.equals(bindingError.getParamName(), paramName)) {
				errors.add(bindingError);
			}
		}

		for (ValidationError validationError : validationErrors) {

			if (Objects.equals(validationError.getParamName(), paramName)) {
				errors.add(validationError);
			}
		}

		return errors;
	}

	public boolean isConsulted() {
		return consulted;
	}

	@Override
	public boolean isFailed() {
		consulted = true;

		return !bindingErrors.isEmpty() || !validationErrors.isEmpty();
	}
}
