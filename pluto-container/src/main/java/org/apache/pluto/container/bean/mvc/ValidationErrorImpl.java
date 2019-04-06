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

import javax.mvc.binding.ValidationError;
import javax.validation.ConstraintViolation;


/**
 * @author  Neil Griffin
 */
public class ValidationErrorImpl extends ParamErrorImpl implements ValidationError {

	private ConstraintViolation constraintViolation;

	public ValidationErrorImpl(String paramName, String message, ConstraintViolation constraintViolation) {
		super(paramName, message);
		this.constraintViolation = constraintViolation;
	}

	@Override
	public ConstraintViolation<?> getViolation() {
		return constraintViolation;
	}
}
