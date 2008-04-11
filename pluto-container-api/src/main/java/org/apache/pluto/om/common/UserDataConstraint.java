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

public interface UserDataConstraint {

	public static final String NONE = "NONE";
	public static final String INTEGRAL = "INTEGRAL";
	public static final String CONFIDENTIAL = "CONFIDENTIAL";

	public abstract List<String> getDescriptions();

	public abstract void setDescriptions(List<String> descriptions);

	public abstract String getTransportGuarantee();

	public abstract void setTransportGuarantee(String transportGuarantee);

}