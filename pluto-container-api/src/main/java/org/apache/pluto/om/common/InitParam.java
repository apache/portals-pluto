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

import org.apache.pluto.om.ElementFactoryList;

public interface InitParam {

	/**
	 * Retrieve the name of the parameter.
	 * @return
	 */
	String getParamName();

	/**
	 * Set the name of the parameter.
	 * @param paramName
	 */
	void setParamName(String paramName);

	/**
	 * Get the name of the parameter.
	 * @return
	 */
	String getParamValue();

	/**
	 * Set the value of the parameter.
	 * @param paramValue
	 */
	void setParamValue(String paramValue);

	/**
	 * Retrieve the description list.
	 * @return
	 */
	public ElementFactoryList<Description> getDescriptions();
	
	String getId();
	
	void setId(String id);
}