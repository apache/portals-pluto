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

import javax.validation.ConstraintViolation;
import javax.validation.MessageInterpolator;
import javax.validation.metadata.ConstraintDescriptor;


/**
 * @author  Neil Griffin
 */
public class MessageInterpolatorContextImpl implements MessageInterpolator.Context {

	private ConstraintViolation<?> constraintViolation;

	public MessageInterpolatorContextImpl(ConstraintViolation<?> constraintViolation) {
		this.constraintViolation = constraintViolation;
	}

	@Override
	public ConstraintDescriptor<?> getConstraintDescriptor() {
		return constraintViolation.getConstraintDescriptor();
	}

	@Override
	public Object getValidatedValue() {
		return constraintViolation.getInvalidValue();
	}

	@Override
	public <T> T unwrap(Class<T> aClass) {
		throw new UnsupportedOperationException();
	}
}
