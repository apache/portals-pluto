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

import java.util.List;
import java.util.Locale;
import java.util.Objects;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.mvc.locale.LocaleResolver;
import javax.mvc.locale.LocaleResolverContext;


/**
 * @author  Neil Griffin
 */
@ApplicationScoped
@Priority(0)
public class LocaleResolverImpl implements LocaleResolver {

	@Override
	public Locale resolveLocale(LocaleResolverContext localeResolverContext) {

		List<Locale> acceptableLanguages = localeResolverContext.getAcceptableLanguages();

		for (Locale acceptableLanguage : acceptableLanguages) {

			if (!Objects.equals(acceptableLanguage.getLanguage(), "*")) {
				return acceptableLanguage;
			}
		}

		return Locale.getDefault();
	}
}
