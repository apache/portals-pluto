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

public interface SecurityRoleRef {

	/**
	 * Retrieve the name of the role reference.
	 * @return
	 */
	public abstract String getRoleName();

	/**
	 * Set the name of the role reference.
	 * @param roleName
	 */
	public abstract void setRoleName(String roleName);

	/**
	 * Retrieve then role to which the reference is linked.
	 * @return
	 */
	public abstract String getRoleLink();

	/**
	 * Set the role to which the reference is linked.
	 * @param roleLink
	 */
	public abstract void setRoleLink(String roleLink);

	/**
	 * Retrieve the description of the role reference.
	 * @return
	 */
	public abstract String getDescription();

	/**
	 * Set the description of the role reference.
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