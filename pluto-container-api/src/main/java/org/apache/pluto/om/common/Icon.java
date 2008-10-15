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

public interface Icon {

	/**
	 * Retrieve the large icon uri.
	 * @return the uri to the large icon (relative to the context path).
	 */
	String getLargeIcon();

	/**
	 * Set the large icon uri.
	 * @param largeIcon the relative path to the icon resource.
	 */
	void setLargeIcon(String largeIcon);

	/**
	 * Retrieve the small icon uri.
	 * @return the uri to the small icon (relative to the context path).
	 */
	String getSmallIcon();

	/**
	 * Set the small Icon uri.
	 * @param smallIcon the relative path to the icon resource.
	 */
	void setSmallIcon(String smallIcon);
}