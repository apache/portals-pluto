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

import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.validation.MessageInterpolator;
import javax.validation.NoProviderFoundException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author  Neil Griffin
 */
@ApplicationScoped
public class BeanValidationProducer {

	private static final Logger LOG = LoggerFactory.getLogger(BeanValidationProducer.class);

	private MessageInterpolator messageInterpolator;
	private Validator validator;

	@Inject
	private Instance<ValidatorFactory> validatorFactoryInstance;

	@BeanValidationMessageInterpolator
	@Dependent
	@Produces
	public MessageInterpolator getMessageInterpolator() {
		return messageInterpolator;
	}

	@BeanValidationValidator
	@Dependent
	@Produces
	public Validator getValidator() {
		return validator;
	}

	@PostConstruct
	public void postConstruct() {
		ValidatorFactory validatorFactory = null;

		Iterator<ValidatorFactory> iterator = validatorFactoryInstance.iterator();

		if (iterator.hasNext()) {
			validatorFactory = iterator.next();
		}

		if (validatorFactory == null) {

			if (LOG.isWarnEnabled()) {
				LOG.warn("ValidatorFactory was not injected -- if using Hibernate " + "Validator, please include the " +
					"hibernate-validator-cdi dependency.");
			}

			try {
				validatorFactory = Validation.buildDefaultValidatorFactory();
			}
			catch (NoProviderFoundException npfe) {
				LOG.error(npfe.getMessage(), npfe);
			}
		}

		if (validatorFactory != null) {
			messageInterpolator = validatorFactory.getMessageInterpolator();

			if ((messageInterpolator == null) && LOG.isWarnEnabled()) {
				LOG.warn("Bean validation MessageInterpolator not available");
			}

			validator = validatorFactory.getValidator();

			if ((validator == null) && LOG.isWarnEnabled()) {
				LOG.warn("Bean validation validator not available");
			}
		}
	}

}
