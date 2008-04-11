/*
 * Copyright 2008 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.om.common;

import java.util.List;

public interface InitParam {

	/**
	 * Retrieve the name of the parameter.
	 * @return
	 */
	public abstract String getParamName();

	/**
	 * Set the name of the parameter.
	 * @param paramName
	 */
	public abstract void setParamName(String paramName);

	/**
	 * Get the name of the parameter.
	 * @return
	 */
	public abstract String getParamValue();

	/**
	 * Set the value of the parameter.
	 * @param paramValue
	 */
	public abstract void setParamValue(String paramValue);

	/**
	 * Retrieve the description.
	 * @return
	 */
	public abstract String getDescription();

	/**
	 * Set the description of the parameter.
	 * @param description
	 */
	public abstract void setDescription(String description);

	/**
	 * Retrieve the description list.
	 * @return
	 */
	public abstract List getDescriptions();

	/**
	 * Set the description list.
	 * @param description
	 */
	public abstract void setDescriptions(List<String> descriptions);

}