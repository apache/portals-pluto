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
package org.apache.pluto.thymeleaf.portlet;

/**
 * Defines a contract for validating {@link org.thymeleaf.context.WebContext} variable names during a portlet request.
 *
 * @author  Neil Griffin
 */
public interface VariableValidator {

	/**
	 * Context initialization parameter that defines whether or not standard portlet beans should be added as variables
	 * to the current {@link org.thymeleaf.context.WebContext}.
	 */
	public static final String INCLUDE_STANDARD_BEANS = "org.apache.pluto.thymeleaf.portlet.INCLUDE_STANDARD_BEANS";

	/**
	 * Determines whether or not the specified variable name is valid for the current portlet request considering the
	 * specified flags. If valid, then the variable name and value should be added to the associated {@link
	 * org.thymeleaf.context.WebContext}.
	 */
	public boolean isValidName(String name, boolean headerPhase, boolean renderPhase, boolean resourcePhase);
}
